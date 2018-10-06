package kr.pe.ecmaxp.openpie.arch

import kr.pe.ecmaxp.openpie.arch.OpenPieMemoryRegion.*
import kr.pe.ecmaxp.openpie.arch.consts.*
import kr.pe.ecmaxp.openpie.arch.state.VMState
import kr.pe.ecmaxp.openpie.arch.types.Interrupt
import kr.pe.ecmaxp.thumbsf.CPU
import kr.pe.ecmaxp.thumbsf.Registers
import kr.pe.ecmaxp.thumbsf.consts.I0
import kr.pe.ecmaxp.thumbsf.consts.PC
import kr.pe.ecmaxp.thumbsf.signal.ControlPauseSignal
import kr.pe.ecmaxp.thumbsf.signal.ControlSignal
import li.cil.oc.api.machine.ExecutionResult
import li.cil.oc.api.machine.Machine


class OpenPieVirtualMachine internal constructor(private val machine: Machine, val memorySize: Int, val firmware: ByteArray = loadFirmware()) {
    val cpu: CPU = CPU()
    var state: VMState = VMState()
    var interruptHandler: OpenPieInterruptHandler = OpenPieInterruptHandler(cpu, machine, state)

    init {
        val memory = cpu.memory.apply {
            flash(FLASH.address, FLASH.size, firmware)
            map(SRAM.address, SRAM.size, SRAM.flag)
            map(PERIPHERAL.address, PERIPHERAL.size) { addr: Long, is_read: Boolean, size: Int, value: Int
                ->
                PeripheralHook(addr, is_read, size, value)
            }
            map(RAM.address, memorySize, RAM.flag)
            map(SYSCALL.address, SYSCALL.size, SYSCALL.flag)
            map(EXTERNAL_STACK.address, EXTERNAL_STACK.size, EXTERNAL_STACK.flag)
        }

        cpu.regs[PC] = memory.readInt(FLASH.address + 4) and I0.inv()
    }

    fun close() {
        // TODO: free memory
    }

    private fun PeripheralHook(addr: Long, is_read: Boolean, size: Int, value: Int): Int {
        if (is_read) {
            return when (addr.toInt()) {
                OP_IO_RXR -> {
                    if (!state.inputBuffer.isEmpty())
                        return state.inputBuffer.pop().toInt()
                    else
                        throw ControlPauseSignal(ExecutionResult.Sleep(0))
                }
                OP_IO_TXR -> 0
                OP_CON_RAM_SIZE -> memorySize
                OP_CON_PENDING, OP_CON_EXCEPTION, OP_CON_INTR_CHAR -> 0 // TODO
                OP_CON_IDLE, OP_CON_INSNS -> 0 // TODO
                OP_RTC_TICKS_MS -> System.currentTimeMillis().toInt()
                else -> {
                    println("failure: addr=${addr}, size=$size")
                    0
                }
            }
        } else {
            when (addr.toInt()) {
                OP_IO_RXR -> state.inputBuffer.add(value.toChar())
                OP_IO_TXR -> {
                    if (value == 0) {
                        val length = state.outputBuffer.length
                        if (length > 0)
                            machine.signal("print")
                    } else {
                        state.outputBuffer.append(value.toChar())
                    }
                }
                OP_CON_PENDING, OP_CON_EXCEPTION, OP_CON_INTR_CHAR, OP_CON_RAM_SIZE, OP_CON_IDLE, OP_CON_INSNS, OP_RTC_TICKS_MS -> {
                }
                OP_IO_RXR + 1 -> state.redirectKeyEvent = value != 0
                else -> println("failure: addr=${addr}, size=$size, value=$value")
            }

            return 0
        }
    }

    internal fun step(isSynchronized: Boolean): ExecutionResult {
        try {
            if (!isSynchronized) {
                // async
                cpu.run(100000000) {
                    val intr = Interrupt(cpu, it)

                    try {
                        interruptHandler(intr)
                    } catch (controlSignal: ControlSignal) {
                        state.lastInterrupt = intr
                        throw controlSignal
                    }
                }
            } else {
                // sync
                val intr = state.lastInterrupt ?: return ExecutionResult.Sleep(0)
                state.lastInterrupt = null
                interruptHandler(intr)
            }
        } catch (controlSignal: ControlSignal) {
            val value = controlSignal.value
            if (value is ExecutionResult)
                return value

            throw Exception(controlSignal)
        } catch (e: Exception) {
            printLastTracebackCPU(cpu)
            throw e
        }

        return ExecutionResult.Sleep(0)
    }

    internal fun onSignal() {
        if (state.redirectKeyEvent) {
            val signal = machine.popSignal()
            when (signal.name()) {
                "key_down" -> {
                    val args = signal.args()
                    if (args.size >= 4) {
                        state.inputBuffer.add((args[1] as Double).toInt().toChar())
                        return
                    }
                }
                "key_up" -> return
                else -> state.signals.add(signal)
            }
        }

        val caller = cpu.fork(Registers(
                sp = (EXTERNAL_STACK.address + (EXTERNAL_STACK.size - 4)).toInt(),
                pc = cpu.memory.readInt(FLASH.address.toInt() + 8)
        ))

        try {
            caller.run(Int.MAX_VALUE) {
                val intr = Interrupt(caller, it)
                interruptHandler(intr)
            }
        } catch (controlSignal: ControlSignal) {
            if (controlSignal.value is SystemControlReturn)
                return

            controlSignal.printStackTrace()
            machine.crash(controlSignal.toString())
        } catch (e: Exception) {
            e.printStackTrace()
            machine.crash(e.toString())
        }
    }
}

