package kr.pe.ecmaxp.openpie.arch

import com.mojang.realmsclient.util.Pair
import kr.pe.ecmaxp.openpie.OpenPieFilePaths
import kr.pe.ecmaxp.openpie.arch.consts.*
import kr.pe.ecmaxp.openpie.arch.micropython.*
import kr.pe.ecmaxp.openpie.arch.msgpack.Msgpack
import kr.pe.ecmaxp.openpie.arch.types.Call
import kr.pe.ecmaxp.openpie.arch.types.Interrupt
import kr.pe.ecmaxp.openpie.arch.types.Result
import kr.pe.ecmaxp.thumbsf.CPU
import kr.pe.ecmaxp.thumbsf.MemoryFlag
import kr.pe.ecmaxp.thumbsf.Registers
import kr.pe.ecmaxp.thumbsf.consts.LR
import kr.pe.ecmaxp.thumbsf.consts.PC
import kr.pe.ecmaxp.thumbsf.exc.InvalidMemoryException
import kr.pe.ecmaxp.thumbsf.exc.UnexceptedLogicError
import kr.pe.ecmaxp.thumbsf.signal.ControlPauseSignal
import kr.pe.ecmaxp.thumbsf.signal.ControlSignal
import kr.pe.ecmaxp.thumbsf.signal.ControlStopSignal
import li.cil.oc.api.machine.ExecutionResult
import li.cil.oc.api.machine.LimitReachedException
import li.cil.oc.api.machine.Machine
import li.cil.oc.api.machine.Signal
import li.cil.oc.api.network.Component
import java.io.File
import java.io.FileNotFoundException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.util.*


class OpenPieVirtualMachine internal constructor(private val machine: Machine) {
    companion object {
        private val KB = 1024
        private val bufAddress = -0x20000000
        private val bufMaxSize = 16 * KB
    }

    private var cpu: CPU = CPU()
    var state: VMState = VMState()

    inner class VMState {
        var lastControlSignal: ControlSignal? = null
        var redirectKeyEvent = true
        var fdMap: HashMap<Int, FileHandle> = HashMap()
        var lastException: Exception? = null
        var lastInterrupt: Interrupt? = null
        var fdCount = 3
        val signals: LinkedList<Signal> = LinkedList()
        val pendingSignals: LinkedList<Signal> = LinkedList()
        val inputBuffer: LinkedList<Char> = LinkedList()
        var outputBuffer: StringBuilder = StringBuilder()
        var pendingException: Exception? = null
    }


    fun init(): Boolean {
        val KB = 1024
        val firmware = loadFirmware()

        cpu = CPU()
        val memory = cpu.memory
        memory.map(0x08000000L, 256 * KB, MemoryFlag.RX) // flash
        memory.map(0x20000000L, 64 * KB, MemoryFlag.RW) // sram
        memory.map(0x40000000L, 4 * KB) { addr: Long, is_read: Boolean, size: Int, value: Int
            ->
            this.PeripheralHook(addr, is_read, size, value)
        } // peripheral
        memory.map(0x60000000L, 192 * KB, MemoryFlag.RW) // ram
        memory.map(0xE0000000L, 16 * KB, MemoryFlag.RW) // syscall
        memory.map(0xE1000000L, 2 * KB, MemoryFlag.RW) // external stack

        memory.writeBuffer(0x08000000, firmware)
        cpu.regs.set(PC, memory.readInt(0x08000000 + 4))
        state = VMState()

        return true
    }

    fun close() {
    }


    inner class FileHandle(val address: String, val handle: Int) {
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

    private fun SysCallHandler_Control(intr: Interrupt): Int {
        when (intr.r0) {
            SYS_CONTROL_SHUTDOWN -> throw ControlStopSignal(ExecutionResult.Shutdown(false))
            SYS_CONTROL_REBOOT -> throw ControlStopSignal(ExecutionResult.Shutdown(true))
            SYS_CONTROL_CRASH -> {
                val str = readString(intr.r1, 256)
                Crash(str)
            }
            SYS_CONTROL_RETURN -> throw ControlStopSignal(null)
        }

        Crash("Unknown Interrupt")
        throw UnexceptedLogicError()
    }

    private fun Crash(message: String) {
        machine.crash(message)
        throw ControlStopSignal(ExecutionResult.Shutdown(false))
    }

    private fun SysCallHandler_Invoke(intr: Interrupt): Int {
        val obj = intr.loadObject0(cpu)
        val call = Call.FromObjectArray(obj as Array<*>)
        val ret = when (call) {
            null -> Result(null, Exception("Invaild call"))
            else -> {
                val ret = invoke(call)
                if (ret.error != null)
                    ret.error.printStackTrace()

                ret
            }
        }

        return intrResponse(arrayOf<Any?>(ret.args, ret.error))
    }

    private fun SysCallHandler_Request(intr: Interrupt): Int {
        when (intr.r0) {
            0 -> {
                if (!state.pendingSignals.isEmpty()) {
                    val signal = state.pendingSignals.pop()
                    return intrResponse(signal)
                }

                return 0
            }
            SYS_REQUEST_COMPONENTS -> return intrResponse(machine.components())
            SYS_REQUEST_METHODS -> {
                val req = intr.loadObject1(cpu) as Array<*>
                val node = machine.node().network().node(req[0] as String)

                if (node is Component) {
                    return intrResponse(node.methods())
                }

                return 0
            }
            SYS_REQUEST_ANNOTATIONS -> {
                val req = intr.loadObject1(cpu) as Array<*>
                if (req.size == 2) {
                    val node = machine.node().network().node(req[0] as String)
                    if (node is Component) {
                        try {
                            val callback = node.annotation(req[1] as String)
                            return intrResponse(callback.doc)
                        } catch (exc: Exception) {
                            // how to handle?
                            exc.printStackTrace()
                        }
                    }
                }

                return 0
            }
            else -> throw UnknownInterrupt()
        }
    }

    private fun SysCallHandler_VirtualFileSystem(intr: Interrupt): Int {
        val ret: Result
        val command = intr.r0
        if (command == 1) {
            val address = readString(intr.r1, 64)
            val path = readString(intr.r2, 256)
            val mode = readString(intr.r3, 16)

            ret = invoke(Call(address, "open", path, mode))
            if (ret.error is FileNotFoundException) {
                return MP_ENOENT
            } else if (ret.args != null) {
                if (ret.args.size != 1) {
                    return MP_EPERM
                }

                val fdPtr = intr.r4
                val fd = state.fdCount++
                val handle = Integer.parseInt(ret.args[0].toString()) // handle

                state.fdMap[fd] = FileHandle(address, handle)

                cpu.memory.writeInt(fdPtr, fd)
                return MP_OK
            } else {
                return MP_EPERM
            }
        } else {
            val fd = intr.r1
            val fh = (state.fdMap as Map<Int, FileHandle>).getOrDefault(fd, null)
            if (fh == null) {
                return MP_EBADF
            }

            when (command) {
                2 // VFS_VALID
                -> {
                    ret = invoke(fh.call("seek", fh.pos))
                    return if (ret.error == null) MP_OK else MP_EIO
                }
                3 // VFS_REPR
                -> return MP_EPERM
                4 // VFS_CLOSE
                -> {
                    ret = invoke(fh.call("close"))
                    if (ret.error != null) {
                        ret.error.printStackTrace()
                        return 1
                    } else {
                        state.fdMap.remove(fd)
                        return MP_OK
                    }
                }
                5 // VFS_READ
                -> {
                    ret = invoke(fh.call("read", intr.r2))
                    val buf: ByteArray
                    if (ret.error != null) {
                        ret.error.printStackTrace()
                        return 1
                    } else if (ret.args != null) {
                        if (ret.args.size != 1) {
                            return MP_EPERM
                        }

                        val arg = ret.args[0]
                        if (arg is ByteArray) {
                            buf = arg
                            cpu.memory.writeBuffer(intr.r3, buf)
                            cpu.memory.writeInt(intr.r4, buf.size)
                            return 0
                        } else if (arg == null) {
                            // EOF
                            return 0
                        } else {
                            return MP_EPERM
                        }
                    } else {
                        return MP_EPERM
                    }
                }
                6 // VFS_WRITE
                -> {
                    val buf = cpu.memory.readBuffer(intr.r2, intr.r3)
                    ret = invoke(fh.call("write", *arrayOf(buf)))
                    if (ret.error != null) {
                        ret.error.printStackTrace()
                        return 1
                    } else if (ret.args != null) {
                        if (ret.args.size != 1) {
                            return MP_EPERM
                        }

                        val arg = ret.args[0]
                        if (arg is Boolean) {
                            if (arg) {
                                fh.pos += buf.size
                                cpu.memory.writeInt(intr.r4, buf.size)
                            }
                            return 0
                        } else if (arg == null) {
                            // EOF
                            return MP_OK
                        } else {
                            return MP_EPERM
                        }
                    } else {
                        return MP_EPERM
                    }
                }
                7 // VFS_SEEK
                -> {
                    val offset = intr.r2
                    val whence = intr.r3
                    val offsetPtr = intr.r4
                    var whenceStr: String? = null

                    when (whence) {
                        0 // MP_SEEK_SET
                        -> whenceStr = "set"
                        1 // MP_SEEK_CUR
                        -> whenceStr = "cur"
                        2 // MP_SEEK_END
                        -> whenceStr = "end"
                        else -> {
                        }
                    }

                    if (whenceStr == null) {
                        return MP_EPERM
                    }

                    ret = invoke(fh.call("seek", whenceStr, offset))
                    if (ret.error != null) {
                        ret.error.printStackTrace()
                        return 1
                    } else if (ret.args != null) {
                        if (ret.args.size != 1) {
                            return MP_EPERM
                        }

                        val arg = ret.args[0]
                        if (arg is Int) {
                            fh.pos = arg
                            return MP_OK
                        } else
                            return MP_EPERM
                    } else {
                        return MP_EPERM
                    }
                }
                8 // VFS_FLUSH
                -> return 0 // always flushed?
                else -> return MP_EPERM
            }
        }
    }


    private fun SysCallHandler_Debug(intr: Interrupt): Int {
        val buf = cpu.memory.readBuffer(intr.r0, intr.r1)
        val str = String(buf, StandardCharsets.UTF_8)
        if (str.length > 2 && str.endsWith("}")) {
            println(str)
            return 0;
        }

        print(str)
        return 0;
    }

    private fun SysCallHandler_Legacy(intr: Interrupt): Int {
        when (intr.r0) {
            0 -> {
                val buf = state.outputBuffer.toString().toByteArray(StandardCharsets.UTF_8)
                state.outputBuffer = StringBuilder()
                return intrResponseBuffer(buf)
            }
            else -> throw UnknownInterrupt()
        }
    }

    inner class UnknownInterrupt : Exception()

    private fun InterruptHandler(intr: Interrupt) {
        try {
            val code: Int = when (intr.imm) {
                SYS_CONTROL -> SysCallHandler_Control(intr)
                SYS_INVOKE -> SysCallHandler_Invoke(intr)
                SYS_REQUEST -> SysCallHandler_Request(intr)
                SYS_VFS -> SysCallHandler_VirtualFileSystem(intr)
                SYS_DEBUG -> SysCallHandler_Debug(intr)
                SYS_LEGACY -> SysCallHandler_Legacy(intr)
                else -> throw UnknownInterrupt()
            }

            cpu.regs[0] = code
        } catch (e: UnknownInterrupt) {
            Crash("Unknown interrupt number")
        } catch (e: LimitReachedException) {
            throw ControlStopSignal(ExecutionResult.SynchronizedCall())
        } catch (e: InvalidMemoryException) {
            throw e
        }
    }


    private fun readString(address: Int, maxSize: Int): String {
        val addr = Integer.toUnsignedLong(address)
        val region = this.cpu.memory.findRegion(addr, 0)
        if (region.flag == MemoryFlag.HOOK)
            throw InvalidMemoryException(address.toLong())

        var size = Math.min(region.end - addr, maxSize.toLong()).toInt()
        val buffer = ByteArray(size)

        val memory = this.cpu.memory
        for (pos in 0 until size) {
            val ch = memory.readByte(address + pos)
            buffer[pos] = ch
            if (ch == 0.toByte()) {
                size = pos
                break
            }
        }

        return String(buffer, 0, size, StandardCharsets.UTF_8)
    }

    private fun invoke(call: Call): Result {
        return call.invoke(machine)
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

                    println("console:" + state.outputBuffer.toString())
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

    internal fun step(isSynchronized: Boolean): ExecutionResult? {
        if (isSynchronized) {
            var intr: Interrupt? = null
            synchronized(this) {
                if (state.lastInterrupt != null) {
                    intr = state.lastInterrupt!!
                    state.lastInterrupt = null
                } else {
                    return null
                }
            }

            try {
                InterruptHandler(intr!!)
            } catch (controlSignal: ControlPauseSignal) {
                state.lastControlSignal = controlSignal
            } catch (controlSignal: ControlStopSignal) {
                state.lastControlSignal = controlSignal
            }

            return null
        } else {
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

                throw Exception(controlSignal)
            }

            return ExecutionResult.Sleep(0)
        }
    }

    private fun cpuStep() {
        try {
            cpu.run(10000000) {
                val intr = Interrupt(cpu, it)

                try {
                    InterruptHandler(intr)
                } catch (e: Exception) {
                    e.printStackTrace()
                    state.lastException = e
                    Crash(e.toString())
                }
            }
        } catch (controlSignal: ControlPauseSignal) {
            throw controlSignal
        } catch (controlSignal: ControlStopSignal) {
            throw controlSignal
        } catch (e: Exception) {
            e.printStackTrace()
            state.pendingException = e
        }

        if (state.pendingException != null) {
            val pc = cpu.regs.get(PC).toLong() and 0xFFFFFFFFL
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


            val lr = cpu.regs.get(LR).toLong() and 0xFFFFFFFFL
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

    private fun loadFirmware(): ByteArray {
        val file = File(OpenPieFilePaths.FirmwareFile)
        return Files.readAllBytes(file.toPath())
    }

    private fun loadMapping(): List<Pair<Long, String>> {
        val file = File(OpenPieFilePaths.MapFile)
        val lines = Files.readAllLines(file.toPath())
        val result = ArrayList<Pair<Long, String>>()

        var last_name: String? = null
        for (line in lines) {
            val tokens = line.trim { it <= ' ' }.split("\\s+".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()
            var last_pair: Pair<Long, String>?
            if (tokens.size >= 1) {
                if (tokens[0].startsWith(".text")) {
                    last_name = tokens[0]
                } else if (tokens[0].startsWith("0x")) {
                    val addr = java.lang.Long.parseLong(tokens[0].substring(2), 16)
                    if (tokens.size == 2) {
                        last_pair = Pair.of(addr, tokens[1])
                        result.add(last_pair)
                    } else if (last_name != null) {
                        last_pair = Pair.of(addr, last_name)
                        result.add(last_pair)
                    }
                } else {
                    last_name = null
                }
            }
        }

        return result
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
                sp = 0xE10003F0L.toInt(),
                pc = cpu.memory.readInt(0x08000000 + 8)
        ))

        state.pendingSignals.add(signal)

        try {
            caller.run(Int.MAX_VALUE) {
                val intr = Interrupt(caller, it)

                try {
                    InterruptHandler(intr)
                } catch (e: Exception) {
                    e.printStackTrace()
                    state.lastException = e
                    Crash(e.toString())
                }
            }
        } catch (controlSignal: ControlSignal) {
            return;
            // TODO: this is bug (unexcepted behavior)
            val value = controlSignal.value
            if (value is ExecutionResult)
                throw Exception(value.toString())

            if (value != null)
                throw Exception(controlSignal)
        }

        // state.signals.add(signal)
    }

    private fun intrResponse(value: Any): Int {
        return intrResponseBuffer(Msgpack.dumps(value))
    }

    private fun intrResponseBuffer(buffer: ByteArray?): Int {
        if (buffer != null && buffer.size > 0)
            return interruptResponseBuffer(buffer)
        else
            return 0
    }

    private fun interruptResponseBuffer(buffer: ByteArray): Int {
        cpu.memory.writeInt(bufAddress, bufAddress + 8) // + 0
        cpu.memory.writeInt(bufAddress + 4, buffer.size) // + 4
        cpu.memory.writeBuffer(bufAddress + 8, buffer) // + 8
        cpu.memory.writeByte(bufAddress + 8 + buffer.size, 0.toByte()) // + 8 + n
        return bufAddress
    }
}
