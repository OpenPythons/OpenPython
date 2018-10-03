package kr.pe.ecmaxp.openpie.arch

import com.mojang.realmsclient.util.Pair
import kr.pe.ecmaxp.openpie.arch.OpenPieMemoryRegion.*
import kr.pe.ecmaxp.openpie.arch.consts.*
import kr.pe.ecmaxp.openpie.arch.types.Call
import kr.pe.ecmaxp.openpie.arch.types.Interrupt
import kr.pe.ecmaxp.thumbsf.CPU
import kr.pe.ecmaxp.thumbsf.Registers
import kr.pe.ecmaxp.thumbsf.consts.LR
import kr.pe.ecmaxp.thumbsf.consts.PC
import kr.pe.ecmaxp.thumbsf.signal.ControlPauseSignal
import kr.pe.ecmaxp.thumbsf.signal.ControlSignal
import kr.pe.ecmaxp.thumbsf.signal.ControlStopSignal
import li.cil.oc.api.machine.ExecutionResult
import li.cil.oc.api.machine.Machine
import li.cil.oc.api.machine.Signal
import java.util.*


class OpenPieVirtualMachine internal constructor(private val machine: Machine, val firmware: ByteArray = loadFirmware()) {
    private val cpu: CPU = CPU()
    var state: VMState = VMState()
    var interruptHandler: OpenPieInterruptHandler = OpenPieInterruptHandler(cpu, machine, state)

    init {
        val memory = cpu.memory.apply {
            map(FLASH.address, FLASH.size, FLASH.flag)
            map(SRAM.address, SRAM.size, SRAM.flag)
            map(PERIPHERAL.address, PERIPHERAL.size) { addr: Long, is_read: Boolean, size: Int, value: Int
                ->
                PeripheralHook(addr, is_read, size, value)
            }
            map(RAM.address, RAM.size, RAM.flag)
            map(SYSCALL.address, SYSCALL.size, SYSCALL.flag)
            map(EXTERNAL_STACK.address, EXTERNAL_STACK.size, EXTERNAL_STACK.flag)

            writeBuffer(FLASH.address.toInt(), firmware)
        }

        cpu.regs[PC] = memory.readInt(FLASH.address.toInt() + 4)
    }

    fun close() {
        // TODO: free memory
    }

    private fun PeripheralHook(addr: Long, is_read: Boolean, size: Int, value: Int): Int {
        var rvalue = value
        if (is_read) {
            when (addr.toInt()) {
                OP_IO_RXR -> {
                    return if (!state.inputBuffer.isEmpty()) state.inputBuffer.pop().toInt() else 0

                }
                OP_IO_TXR -> return 0
                OP_CON_PENDING, OP_CON_EXCEPTION, OP_CON_INTR_CHAR -> {
                }
                OP_CON_RAM_SIZE -> rvalue = 0x80000
                OP_CON_IDLE, OP_CON_INSNS -> {
                }
                OP_RTC_TICKS_MS -> return System.currentTimeMillis().toInt()
                else -> System.out.printf("failure: %x, %d, %d\n", addr, size, rvalue)
            }
        } else {
            when (addr.toInt()) {
                OP_IO_RXR -> state.inputBuffer.add(rvalue.toChar())
                OP_IO_TXR -> if (rvalue == 0) {
                    val length = state.outputBuffer.length
                    if (length > 0)
                        machine.signal("print")
                } else {
                    state.outputBuffer.append(rvalue.toChar())
                }
                OP_CON_PENDING, OP_CON_EXCEPTION, OP_CON_INTR_CHAR, OP_CON_RAM_SIZE, OP_CON_IDLE, OP_CON_INSNS, OP_RTC_TICKS_MS -> {
                }
                OP_IO_RXR + 1 -> state.redirectKeyEvent = rvalue != 0
                else -> System.out.printf("failure: %x, %d, %d\n", addr, size, rvalue)
            }
        }


        return rvalue
    }

    internal fun step(isSynchronized: Boolean): ExecutionResult {
        if (!isSynchronized) { // async
            var foundSignals = false

            synchronized(this) {
                foundSignals = !state.signals.isEmpty()
                while (!state.signals.isEmpty())
                    state.pendingSignals.add(state.signals.pop())
            }

            if (foundSignals) {
                return ExecutionResult.Sleep(0)
            }

            try {
                cpuStep()
            } catch (controlSignal: ControlSignal) {
                val value = controlSignal.value
                if (value is ExecutionResult)
                    return value
                else if (value is SystemControlReturn)
                    throw Exception("Invalid Return")

                throw Exception(controlSignal)
            }

            return ExecutionResult.Sleep(0)
        } else { // sync
            var intr: Interrupt? = null
            synchronized(this) {
                if (state.lastInterrupt != null) {
                    intr = state.lastInterrupt!!
                    state.lastInterrupt = null
                } else {
                    return ExecutionResult.Sleep(0)
                }
            }

            try {
                interruptHandler(intr!!)
            } catch (controlSignal: ControlSignal) {
                val value = controlSignal.value
                if (value is ExecutionResult)
                    return value
                else if (value is SystemControlReturn)
                    throw Exception("Invalid Return")
            }

            return ExecutionResult.Sleep(0)
        }
    }

    private fun cpuStep() {
        try {
            cpu.run(10000000) {
                val intr = Interrupt(cpu, it)

                try {
                    interruptHandler(intr)
                } catch (controlSignal: ControlSignal){
                    state.lastInterrupt = intr
                    throw controlSignal
                } catch (e: Exception) {
                    e.printStackTrace()
                    machine.crash(e.toString())
                    throw e
                }
            }
        } catch (controlSignal: ControlSignal) {
            throw controlSignal
        } catch (e: Exception) {
            e.printStackTrace()
            state.pendingException = e
        }

        if (state.pendingException != null) {
            val pc = Integer.toUnsignedLong(cpu.regs.get(PC))
            val mapping = loadMapping()
            var selected: Pair<Long, String>? = null
            var found = false
            for (pair in mapping) {
                val addr = pair.first()
                if (addr > pc) {
                    found = true
                    break
                }

                selected = pair
            }

            if (found && selected != null) {
                println("last function :" + selected.second() + " (+" + java.lang.Long.toString(pc - selected.first()) + ")")
            } else {
                println("last function : (null)")
            }

            val lr = Integer.toUnsignedLong(cpu.regs.get(LR))
            selected = null
            found = false
            for (pair in mapping) {
                val addr = pair.first()
                if (addr > lr) {
                    found = true
                    break
                }

                selected = pair
            }

            if (found && selected != null) {
                println("last function :" + selected.second() + " (+" + java.lang.Long.toString(lr - selected.first()) + ")")
            } else {
                println("last function : (null)")
            }

            throw state.pendingException!!
        }
    }

    internal fun onSignal(signal: Signal) {
        if (state.redirectKeyEvent) {
            if (signal.name() == "key_down") {
                val args = signal.args()
                if (args.size >= 4)
                    state.inputBuffer.add((args[1] as Double).toInt().toChar())

                return
            } else if (signal.name() == "key_up") {
                return
            }
        }

        val caller = cpu.fork(Registers(
                sp = (EXTERNAL_STACK.address + (EXTERNAL_STACK.size - 4)).toInt(),
                pc = cpu.memory.readInt(FLASH.address.toInt() + 8)
        ))

        state.pendingSignals.add(signal)

        try {
            caller.run(Int.MAX_VALUE) {
                val intr = Interrupt(caller, it)

                try {
                    interruptHandler(intr)
                } catch (e: Exception) {
                    e.printStackTrace()
                    machine.crash(e.toString())
                }
            }
        } catch (controlSignal: ControlSignal) {
            if (controlSignal.value is SystemControlReturn)
                return

            controlSignal.printStackTrace()
            machine.crash(controlSignal.toString())
        }
    }
}

class FileHandle(val address: String, val handle: Int) {
    var is_closed: Boolean = false
    var pos = 0

    init {
        this.is_closed = false
    }

    override fun toString(): String {
        return "FileHandle{" +
                "address='" + address + '\''.toString() +
                ", handle=" + handle +
                '}'.toString()
    }

    fun call(func: String, vararg args: Any): Call {
        val callArgs = arrayOfNulls<Any>(args.size + 1)
        callArgs[0] = this.handle
        System.arraycopy(args, 0, callArgs, 1, args.size)
        return Call(this.address, func, *callArgs)
    }
}

class VMState {
    var lastControlSignal: ControlSignal? = null
    var redirectKeyEvent = true
    var fdMap: HashMap<Int, FileHandle> = HashMap()
    var lastInterrupt: Interrupt? = null
    var fdCount = 3
    val signals: LinkedList<Signal> = LinkedList()
    val pendingSignals: LinkedList<Signal> = LinkedList()
    val inputBuffer: LinkedList<Char> = LinkedList()
    var outputBuffer: StringBuilder = StringBuilder()
    var pendingException: Exception? = null
}
