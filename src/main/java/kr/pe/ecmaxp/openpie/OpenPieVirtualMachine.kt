package kr.pe.ecmaxp.openpie

import com.google.gson.Gson
import com.mojang.realmsclient.util.Pair
import kr.pe.ecmaxp.openpie.micropython.*
import kr.pe.ecmaxp.thumbsf.CPU
import kr.pe.ecmaxp.thumbsf.InterruptHandler
import kr.pe.ecmaxp.thumbsf.MemoryFlag
import kr.pe.ecmaxp.thumbsf.exc.InvalidMemoryException
import kr.pe.ecmaxp.thumbsf.helper.*
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
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.util.*


class OpenPieVirtualMachine internal constructor(private val machine: Machine) {
    private var cpu: CPU? = null
    var state: VMState? = null

    @Throws(Exception::class)
    internal fun init(): Boolean {
        val KB = 1024
        val firmware = loadFirmware()

        close()

        cpu = CPU()
        val memory = cpu!!.memory
        memory.map(0x08000000L, 256 * KB, MemoryFlag.RX) // flash
        memory.map(0x20000000L, 64 * KB, MemoryFlag.RW) // sram
        memory.map(0x40000000L, 4 * KB) { addr: Long, is_read: Boolean, size: Int, value: Int
            ->
            this.PeripheralHook(addr, is_read, size, value)
        } // peripheral
        memory.map(0x60000000L, 192 * KB, MemoryFlag.RW) // ram
        memory.map(0xE0000000L, 16 * KB, MemoryFlag.RW) // syscall
        memory.writeBuffer(0x08000000, firmware)
        cpu!!.regs.set(PC, memory.readInt(0x08000000 + 4))

        state = VMState()

        return true
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

    inner class VMState () {
        var lastControlSignal: ControlSignal? = null
        var redirectKeyEvent = true
        internal val signals: LinkedList<Signal>
        internal val pendingSignals: LinkedList<Signal>
        internal val inputBuffer: LinkedList<Char>
        internal var outputBuffer: StringBuilder
        internal var pendingException: Exception? = null
        var fdMap: HashMap<Int, FileHandle>
        var lastException: Exception? = null
        var lastInterrupt: Interrupt? = null
        var fdCount = 3

        init {
            redirectKeyEvent = true
            signals = LinkedList()
            fdMap = HashMap()
            pendingSignals = LinkedList()
            inputBuffer = LinkedList()
            outputBuffer = StringBuilder()
        }
    }

    private inner class ResultJson {
        private var args: Array<Any?>? = null
        private var error: String? = null

        internal constructor(error: Throwable) {
            this.error = error.toString()
        }

        internal constructor(args: Array<Any?>) {
            this.args = args
        }

        internal constructor(result: Result) {
            this.args = result.args
            this.error = if (result.error != null) result.error.toString() else null
        }
    }

    @Throws(InvalidMemoryException::class, ControlStopSignal::class)
    private fun SysCallHandler_Control(intr: Interrupt) {
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
    }

    @Throws(ControlStopSignal::class)
    private fun Crash(message: String) {
        machine.crash(message)
        throw ControlStopSignal(ExecutionResult.Shutdown(false))
    }

    @Throws(InvalidMemoryException::class, LimitReachedException::class)
    private fun SysCallHandler_Invoke(intr: Interrupt) {
        val buf = cpu!!.memory.readBuffer(intr.r0, intr.r1)
        val str = String(buf, StandardCharsets.UTF_8)

        val req = Gson().fromJson<Array<Any>>(str, Array<Any>::class.java)
        val call = Call.FromObjectArray(req)

        val ret: Result
        if (call == null) {
            ret = Result(null, Exception("Invaild call"))
        } else {
            ret = invoke(call) // LimitReachedException
            if (ret.error != null)
                ret.error.printStackTrace()
        }

        interruptResponseJson(arrayOf<Any?>(ret.args, ret.error))
    }

    @Throws(InvalidMemoryException::class, ControlStopSignal::class)
    private fun SysCallHandler_Request(intr: Interrupt) {
        when (intr.r0) {
            0 -> {
                run {
                    if (!state!!.pendingSignals.isEmpty()) {
                        val signal = state!!.pendingSignals.pop()
                        interruptResponseJson(signal)
                    } else {
                        interruptResponseEmpty()
                    }
                }
            }
            SYS_REQUEST_COMPONENTS -> {
                run { interruptResponseJson(machine.components()) }
            }
            SYS_REQUEST_METHODS -> {
                run {
                    val buf = cpu!!.memory.readBuffer(intr.r1, intr.r2)
                    val str = String(buf, StandardCharsets.UTF_8)

                    val node = machine.node().network().node(str)
                    if (node is Component) {
                        interruptResponseJson(node.methods())
                    } else {
                        interruptResponseEmpty()
                    }
                }
            }
            SYS_REQUEST_ANNOTATIONS -> {
                run {
                    val buf = cpu!!.memory.readBuffer(intr.r1, intr.r2)
                    val str = String(buf, StandardCharsets.UTF_8)

                    val req = Gson().fromJson<Array<String>>(str, Array<String>::class.java)
                    if (req.size != 2) {
                        interruptResponseEmpty()
                        return
                    }

                    val node = machine.node().network().node(req[0])
                    if (node is Component) {
                        try {
                            val callback = node.annotation(req[1])
                            interruptResponseJson(callback.doc)
                        } catch (exc: Exception) {
                            // how to handle?
                            exc.printStackTrace()
                            interruptResponseEmpty()
                        }

                    } else {
                        interruptResponseEmpty()
                    }
                }
            }
            else -> {
            }
        }
    }

    @Throws(InvalidMemoryException::class, LimitReachedException::class)
    private fun SysCallHandler_VirtualFileSystem(intr: Interrupt) {
        val ret: Result
        val command = intr.r0
        if (command == 1) {
            val address = readString(intr.r1, 64)
            val path = readString(intr.r2, 256)
            val mode = readString(intr.r3, 16)

            ret = invoke(Call(address, "open", path, mode))
            if (ret.error is FileNotFoundException) {
                interruptResponseCode(MP_ENOENT)
            } else if (ret.args != null) {
                if (ret.args.size != 1) {
                    interruptResponseCode(MP_EPERM)
                    return
                }

                val fdPtr = intr.r4
                val fd = state!!.fdCount++
                val handle = Integer.parseInt(ret.args[0].toString()) // handle

                state!!.fdMap[fd] = FileHandle(address, handle)

                cpu!!.memory.writeInt(fdPtr, fd)
                interruptResponseCode(0)
            } else {
                interruptResponseCode(MP_EPERM)
            }
        } else {
            val fd = intr.r1
            val fh = (state!!.fdMap as Map<Int, FileHandle>).getOrDefault(fd, null)
            if (fh == null) {
                interruptResponseCode(MP_EBADF)
                return
            }

            when (command) {
                2 // VFS_VALID
                -> {
                    ret = invoke(fh.call("seek", fh.pos))
                    interruptResponseCode(if (ret.error == null) 0 else MP_EIO)
                }
                3 // VFS_REPR
                -> interruptResponseCode(MP_EPERM)
                4 // VFS_CLOSE
                -> {
                    ret = invoke(fh.call("close"))
                    if (ret.error != null) {
                        ret.error.printStackTrace()
                        interruptResponseCode(1)
                    } else {
                        state!!.fdMap.remove(fd)
                        interruptResponseCode(0)
                    }
                }
                5 // VFS_READ
                -> {
                    ret = invoke(fh.call("read", intr.r2))
                    val buf: ByteArray
                    if (ret.error != null) {
                        ret.error.printStackTrace()
                        interruptResponseCode(1)
                    } else if (ret.args != null) {
                        if (ret.args.size != 1) {
                            interruptResponseCode(MP_EPERM)
                            return
                        }

                        val arg = ret.args[0]
                        if (arg is ByteArray) {
                            buf = arg
                            cpu!!.memory.writeBuffer(intr.r3, buf)
                            cpu!!.memory.writeInt(intr.r4, buf.size)
                        } else if (arg == null) {
                            // EOF
                            interruptResponseCode(0)
                        } else {
                            interruptResponseCode(MP_EPERM)
                        }
                    } else {
                        interruptResponseCode(MP_EPERM)
                    }
                    interruptResponseCode(0)
                }
                6 // VFS_WRITE
                -> {
                    val buf = cpu!!.memory.readBuffer(intr.r2, intr.r3)
                    ret = invoke(fh.call("write", *arrayOf(buf)))
                    if (ret.error != null) {
                        ret.error.printStackTrace()
                        interruptResponseCode(1)
                    } else if (ret.args != null) {
                        if (ret.args.size != 1) {
                            interruptResponseCode(MP_EPERM)
                            return
                        }

                        val arg = ret.args[0]
                        if (arg is Boolean) {
                            if (arg) {
                                fh.pos += buf.size
                                cpu!!.memory.writeInt(intr.r4, buf.size)
                            }
                        } else if (arg == null) {
                            // EOF
                            interruptResponseCode(0)
                        } else {
                            interruptResponseCode(MP_EPERM)
                        }
                    } else {
                        interruptResponseCode(MP_EPERM)
                    }
                    interruptResponseCode(0)
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
                        interruptResponseCode(MP_EPERM)
                        return
                    }

                    ret = invoke(fh.call("seek", whenceStr, offset))
                    if (ret.error != null) {
                        ret.error.printStackTrace()
                        interruptResponseCode(1)
                    } else if (ret.args != null) {
                        if (ret.args.size != 1) {
                            interruptResponseCode(MP_EPERM)
                            return
                        }

                        val arg = ret.args[0]
                        if (arg is Int)
                            fh.pos = arg
                        else
                            interruptResponseCode(MP_EPERM)
                    } else {
                        interruptResponseCode(MP_EPERM)
                    }
                    interruptResponseCode(0)
                }
                8 // VFS_FLUSH
                -> interruptResponseCode(0) // always flushed?
                else -> interruptResponseCode(MP_EPERM)
            }
        }
    }

    @Throws(InvalidMemoryException::class)
    private fun SysCallHandler_Debug(intr: Interrupt) {
        if (true) return
        val buf = cpu!!.memory.readBuffer(intr.r0, intr.r1)
        val str = String(buf, StandardCharsets.UTF_8)
        println(str)
    }

    @Throws(InvalidMemoryException::class)
    private fun SysCallHandler_Legacy(intr: Interrupt) {
        when (intr.r0) {
            0 -> {
                val buf = state!!.outputBuffer.toString().toByteArray(StandardCharsets.UTF_8)
                state!!.outputBuffer = StringBuilder()
                interruptResponseBufferOrEmpty(buf)
            }
        }
    }

    @Throws(InvalidMemoryException::class, ControlStopSignal::class, ControlPauseSignal::class)
    private fun InterruptHandler(intr: Interrupt?) {
        try {
            when (intr!!.imm) {
                SYS_CONTROL -> SysCallHandler_Control(intr)
                SYS_INVOKE -> SysCallHandler_Invoke(intr)
                SYS_REQUEST -> SysCallHandler_Request(intr)
                SYS_VFS -> SysCallHandler_VirtualFileSystem(intr)
                SYS_DEBUG -> SysCallHandler_Debug(intr)
                SYS_LEGACY -> SysCallHandler_Legacy(intr)
                else -> Crash("Unknown interrupt number")
            }
        } catch (e: LimitReachedException) {
            throw ControlStopSignal(ExecutionResult.SynchronizedCall())
        } catch (e: InvalidMemoryException) {
            throw e
        } catch (e: Exception) {
            // error!
            throw ControlStopSignal(e)
        }
    }

    @Throws(InvalidMemoryException::class)
    private fun readString(address: Int, maxSize: Int): String {
        val addr = Integer.toUnsignedLong(address)
        val region = this.cpu!!.memory.findRegion(addr, 0)
        if (region.flag == MemoryFlag.HOOK)
            throw InvalidMemoryException(address.toLong())

        val start = (address - region.begin).toInt()
        var size = Math.min(region.end - addr, maxSize.toLong()).toInt()
        val end = start + size
        val buffer = ByteArray(size)

        val memory = this.cpu!!.memory
        for (pos in 0 until size) {
            val ch = memory.readByte(start + pos)
            buffer[pos] = ch
            if (ch == 0.toByte()) {
                size = pos
                break
            }
        }

        return String(buffer, 0, size, StandardCharsets.UTF_8)
    }

    @Throws(LimitReachedException::class)
    private operator fun invoke(call: Call): Result {
        return call.invoke(machine)
    }

    private fun PeripheralHook(addr: Long, is_read: Boolean, size: Int, value: Int): Int {
        var rvalue = value
        if (is_read) {
            when (addr.toInt()) {
                OP_IO_RXR -> {
                    return if (!state!!.inputBuffer.isEmpty()) state!!.inputBuffer.pop().toInt() else 0

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
                OP_IO_RXR -> state!!.inputBuffer.add(rvalue.toChar())
                OP_IO_TXR -> if (rvalue == 0) {
                    val length = state!!.outputBuffer.length
                    if (length > 0)
                        machine.signal("print")

                    println("console:" + state!!.outputBuffer.toString())
                } else {
                    state!!.outputBuffer.append(rvalue.toChar())
                }
                OP_CON_PENDING, OP_CON_EXCEPTION, OP_CON_INTR_CHAR, OP_CON_RAM_SIZE, OP_CON_IDLE, OP_CON_INSNS, OP_RTC_TICKS_MS -> {
                }
                OP_IO_RXR + 1 -> state!!.redirectKeyEvent = rvalue != 0
                else -> System.out.printf("failure: %x, %d, %d\n", addr, size, rvalue)
            }
        }


        return rvalue
    }

    @Synchronized
    @Throws(Exception::class)
    internal fun step(isSynchronized: Boolean): ExecutionResult? {
        if (isSynchronized) {
            var intr: Interrupt? = null
            synchronized(this) {
                if (state!!.lastInterrupt != null) {
                    intr = state!!.lastInterrupt
                    state!!.lastInterrupt = null
                }
            }

            try {
                InterruptHandler(intr)
            } catch (controlSignal: ControlPauseSignal) {
                state!!.lastControlSignal = controlSignal
            } catch (controlSignal: ControlStopSignal) {
                state!!.lastControlSignal = controlSignal
            }

            return null
        } else {
            var foundSignals = false

            synchronized(this) {
                foundSignals = !state!!.signals.isEmpty()
                while (!state!!.signals.isEmpty())
                    state!!.pendingSignals.add(state!!.signals.pop())
            }

            if (foundSignals) {
                val regs = cpu!!.regs.copy()
                cpu!!.regs.set(PC, cpu!!.memory.readInt(0x08000000 + 8))
                cpu!!.regs.set(SP, cpu!!.regs.get(SP) - 32)
                // end if


                try {
                    cpuStep()
                } catch (controlSignal: ControlSignal) {
                    val value = controlSignal.value
                    if (value is ExecutionResult)
                        return value

                    if (value != null)
                        throw Exception(controlSignal)
                }

                // if runing
                cpu!!.regs = regs
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

    @Throws(Exception::class, ControlPauseSignal::class, ControlStopSignal::class)
    private fun cpuStep() {

        try {
            cpu!!.run(1000000) {
                val intr = Interrupt(cpu!!, it)

                try {
                    InterruptHandler(intr)
                } catch (e: Exception) {
                    state!!.lastException = e
                    Crash(e.toString())
                }
            }
        } catch (controlSignal: ControlPauseSignal) {
            throw controlSignal
        } catch (controlSignal: ControlStopSignal) {
            throw controlSignal
        } catch (e: Exception) {
            state!!.pendingException = e
        }

        if (state!!.pendingException != null) {
            val pc = cpu!!.regs.get(PC).toLong() and 0xFFFFFFFFL
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


            val lr = cpu!!.regs.get(LR).toLong() and 0xFFFFFFFFL
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

            throw state!!.pendingException!!
        }
    }

    internal fun close() {
        cpu = null
        state = null
    }

    @Throws(IOException::class)
    private fun loadFirmware(): ByteArray {
        val file = File(OpenPieFilePaths.FirmwareFile)
        return Files.readAllBytes(file.toPath())
    }

    @Throws(IOException::class)
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

    @Synchronized
    internal fun onSignal(signal: Signal) {
        if (state!!.redirectKeyEvent) {
            if (signal.name() == "key_down") {
                val args = signal.args()
                if (args.size >= 4)
                    state!!.inputBuffer.add((args[1] as Double).toInt().toChar())

                return
            } else if (signal.name() == "key_up") {
                return
            }
        }

        state!!.signals.add(signal)
    }

    @Throws(InvalidMemoryException::class)
    private fun interruptResponseJson(value: Any) {
        // TODO: msgpack
        interruptResponseBufferOrEmpty(Gson().toJson(value).toByteArray(StandardCharsets.UTF_8))
    }

    @Throws(InvalidMemoryException::class)
    private fun interruptResponseBufferOrEmpty(buffer: ByteArray?) {
        if (buffer != null && buffer.size > 0)
            interruptResponseBuffer(buffer)
        else
            interruptResponseEmpty()
    }

    @Throws(InvalidMemoryException::class)
    private fun interruptResponseBuffer(buffer: ByteArray) {
        cpu!!.memory.writeInt(bufAddress, bufAddress + 8) // + 0
        cpu!!.memory.writeInt(bufAddress + 4, buffer.size) // + 4
        cpu!!.memory.writeBuffer(bufAddress + 8, buffer) // + 8
        cpu!!.memory.writeByte(bufAddress + 8 + buffer.size, 0.toByte()) // + 8 + n
        cpu!!.regs.set(R0, bufAddress)
    }

    private fun interruptResponseEmpty() {
        interruptResponseCode(0)
    }

    private fun interruptResponseCode(code: Int) {
        cpu!!.regs.set(R0, code)
    }

    companion object {

        private val KB = 1024
        private val bufAddress = -0x20000000
        private val bufMaxSize = 16 * KB
    }
}
