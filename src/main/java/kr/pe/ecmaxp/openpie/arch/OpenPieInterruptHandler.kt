package kr.pe.ecmaxp.openpie.arch

import kr.pe.ecmaxp.openpie.arch.consts.*
import kr.pe.ecmaxp.openpie.arch.micropython.*
import kr.pe.ecmaxp.openpie.arch.msgpack.Msgpack
import kr.pe.ecmaxp.openpie.arch.state.FileHandle
import kr.pe.ecmaxp.openpie.arch.state.VMState
import kr.pe.ecmaxp.openpie.arch.types.Call
import kr.pe.ecmaxp.openpie.arch.types.Interrupt
import kr.pe.ecmaxp.openpie.arch.types.Result
import kr.pe.ecmaxp.thumbsf.CPU
import kr.pe.ecmaxp.thumbsf.consts.R0
import kr.pe.ecmaxp.thumbsf.signal.ControlPauseSignal
import kr.pe.ecmaxp.thumbsf.signal.ControlStopSignal
import li.cil.oc.api.machine.*
import li.cil.oc.api.network.Component
import java.io.FileNotFoundException
import java.nio.charset.StandardCharsets

object SystemControlReturn

class OpenPieInterruptHandler(val vm: OpenPieVirtualMachine, val cpu: CPU, val machine: Machine, val state: VMState) {
    private fun handleSystemControl(intr: Interrupt, @Suppress("UNUSED_PARAMETER") synchronized: Boolean): Int {
        when (intr.r0) {
            SYS_CONTROL_SHUTDOWN -> throw ControlStopSignal(ExecutionResult.Shutdown(false))
            SYS_CONTROL_REBOOT -> throw ControlStopSignal(ExecutionResult.Shutdown(true))
            SYS_CONTROL_CRASH -> {
                val str = cpu.memory.readString(intr.r1, intr.r2)
                throw ControlStopSignal(ExecutionResult.Error(str))
            }
            SYS_CONTROL_RETURN -> throw ControlStopSignal(SystemControlReturn)
        }

        throw UnknownInterrupt()
    }

    private fun handleSystemDebug(intr: Interrupt, @Suppress("UNUSED_PARAMETER") synchronized: Boolean): Int {
        val buf = cpu.memory.readBuffer(intr.r0, intr.r1)
        val str = String(buf, StandardCharsets.UTF_8)

        print(str)
        return 0
    }

    private fun handleSystemSignal(intr: Interrupt, @Suppress("UNUSED_PARAMETER") synchronized: Boolean): Int {
        when (intr.r0) {
            SYS_SIGNAL_REQUEST -> {
                val signal: Signal? = machine.popSignal()
                if (signal == null) {
                    cpu.regs[R0] = SYS_SIGNAL_PENDING
                    throw ControlPauseSignal(ExecutionResult.Sleep(intr.r1))
                }

                return response(signal)
            }
            SYS_SIGNAL_PENDING -> {
                val signal: Signal = machine.popSignal() ?: return 0
                return response(signal)
            }
        }

        throw UnknownInterrupt()
    }

    private fun handleSystemInvoke(intr: Interrupt, synchronized: Boolean): Int {
        // intr.r0 => unused
        val obj = intr.loadObject(cpu)
        val call = Call.fromArray(obj as Array<*>)
                ?: return responseInvoke(Exception("Invaild call"))

        if (!synchronized) {
            val node = machine.node().network().node(call.component) as? Component
                    ?: return responseInvoke(Exception("Invalid Component"))

            var callback: Callback? = null

            try {
                callback = node.annotation(call.function)
                        ?: return responseInvoke(Exception("Invalid Function"))
            } catch (e: NoSuchMethodException) {
                e.printStackTrace()
                return responseInvoke(e)
            }

            if (!callback.direct) {
                // TODO: automatic detect sync call?
                throw ControlPauseSignal(ExecutionResult.SynchronizedCall())
            }
        }

        val ret = call(call)
        return if (ret.error == null) {
            responseInvoke(ret.args)
        } else {
            ret.error.printStackTrace()
            responseInvoke(ret.error)
        }
    }

    private fun responseInvoke(error: Throwable?): Int = response(arrayOf<Any?>(null, error))
    private fun responseInvoke(args: Any?): Int = response(arrayOf(args, null))

    private fun handleSystemRequest(intr: Interrupt, @Suppress("UNUSED_PARAMETER") synchronized: Boolean): Int {
        when (intr.r0) {
            SYS_REQUEST_COMPONENTS -> {
                return when (intr.r1) {
                    0 -> response(machine.components())
                    else -> {
                        val target = cpu.memory.readString(intr.r1, intr.r2)
                        val components = ArrayList<String>()
                        for ((address, type) in machine.components()) {
                            if (type == target)
                                components.add(address)
                        }

                        response(components)
                    }
                }
            }
            SYS_REQUEST_METHODS -> {
                val req = intr.loadObject(cpu) as Array<*>
                val node = machine.node().network().node(req[0] as String)

                if (node is Component) {
                    return response(node.methods())
                }

                return 0
            }
            SYS_REQUEST_ANNOTATIONS -> {
                val req = intr.loadObject(cpu) as Array<*>
                if (req.size == 2) {
                    val node = machine.node().network().node(req[0] as String)
                    if (node is Component) {
                        try {
                            val callback = node.annotation(req[1] as String)
                            return response(callback.doc)
                        } catch (e: NoSuchMethodError) {
                            return 0
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

    private fun handleSystemInfo(intr: Interrupt, @Suppress("UNUSED_PARAMETER") synchronized: Boolean): Int {
        return when (intr.r0) {
            SYS_INFO_VERSION -> 0x0000
            SYS_INFO_RAM_SIZE -> vm.memorySize
            else -> throw UnknownInterrupt()
        }
    }

    private fun handleSystemTimer(intr: Interrupt, @Suppress("UNUSED_PARAMETER") synchronized: Boolean): Int {
        return when (intr.r0) {
            SYS_TIMER_TICKS_MS -> System.currentTimeMillis().toInt()
            SYS_TIMER_TICKS_US -> System.nanoTime().toInt()
            else -> throw UnknownInterrupt()
        }
    }

    private fun handleSystemVirtualFileSystem(intr: Interrupt, synchronized: Boolean): Int {
        if (!synchronized)
            throw ControlPauseSignal(ExecutionResult.SynchronizedCall())

        val command = intr.r0
        if (command == SYS_VFS_OPEN) {
            val address = cpu.memory.readString(intr.r1, 64)
            val path = cpu.memory.readString(intr.r2, 256)
            val mode = cpu.memory.readString(intr.r3, 16)

            val ret = call(Call(address, "open", path, mode))
            when {
                ret.error is FileNotFoundException -> return MP_ENOENT
                ret.args != null -> {
                    if (ret.args.size != 1)
                        return MP_EPERM

                    val fdPtr = intr.r4
                    val fd = state.fdCount++
                    val handle = Integer.parseInt(ret.args[0].toString()) // handle

                    state.fdMap[fd] = FileHandle(address, handle)

                    cpu.memory.writeInt(fdPtr, fd)
                    return MP_OK
                }
                else -> return MP_EPERM
            }
        } else {
            val fd = intr.r1
            val fh = state.fdMap.getOrDefault(fd, null) ?: return MP_EBADF

            when (command) {
                SYS_VFS_VALID -> {
                    val ret = call(fh.call("seek", fh.pos))
                    return if (ret.error == null) MP_OK else MP_EIO
                }
                SYS_VFS_REPR -> return MP_EPERM
                SYS_VFS_CLOSE -> {
                    val ret = call(fh.call("close"))
                    if (ret.error != null) {
                        ret.error.printStackTrace()
                        return 1
                    } else {
                        state.fdMap.remove(fd)
                        return MP_OK
                    }
                }
                SYS_VFS_READ -> {
                    val ret = call(fh.call("read", intr.r2))
                    val buf: ByteArray
                    when {
                        ret.error != null -> {
                            ret.error.printStackTrace()
                            return 1
                        }
                        ret.args != null -> {
                            if (ret.args.size != 1) {
                                return MP_EPERM
                            }

                            val arg = ret.args[0]
                            return if (arg is ByteArray) {
                                buf = arg
                                cpu.memory.writeBuffer(intr.r3, buf)
                                cpu.memory.writeInt(intr.r4, buf.size)
                                0
                            } else if (arg == null) {
                                // EOF
                                0
                            } else {
                                MP_EPERM
                            }
                        }
                        else -> return MP_EPERM
                    }
                }
                SYS_VFS_WRITE -> {
                    val buf = cpu.memory.readBuffer(intr.r2, intr.r3)
                    val ret = call(fh.call("write", *arrayOf(buf)))
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
                SYS_VFS_SEEK -> {
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

                    val ret = call(fh.call("seek", whenceStr, offset))
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
                SYS_VFS_FLUSH -> return 0 // always flushed?
                else -> return MP_EPERM
            }
        }
    }

    inner class UnknownInterrupt : Exception()

    operator fun invoke(intr: Interrupt, synchronized: Boolean) {
        try {
            val code: Int = when (intr.imm) {
                SYS_CONTROL -> handleSystemControl(intr, synchronized)
                SYS_DEBUG -> handleSystemDebug(intr, synchronized)
                SYS_SIGNAL -> handleSystemSignal(intr, synchronized)
                SYS_INVOKE -> handleSystemInvoke(intr, synchronized)
                SYS_REQUEST -> handleSystemRequest(intr, synchronized)
                SYS_INFO -> handleSystemInfo(intr, synchronized)
                SYS_TIMER -> handleSystemTimer(intr, synchronized)
                SYS_VFS -> handleSystemVirtualFileSystem(intr, synchronized)
                else -> throw UnknownInterrupt()
            }

            cpu.regs[0] = code
        } catch (e: UnknownInterrupt) {
            throw ControlStopSignal(ExecutionResult.Error("Unknown Interrupt"))
        } catch (e: LimitReachedException) {
            throw ControlPauseSignal(ExecutionResult.SynchronizedCall())
        }
    }

    private fun response(value: Any): Int {
        val buffer = Msgpack.dumps(value)
        return responseBuffer(buffer, false)
    }

    private fun responseBuffer(buffer: ByteArray, isCString: Boolean = true): Int {
        val bufAddress = OpenPieMemoryRegion.SYSCALL.address
        cpu.memory.writeInt(bufAddress, bufAddress + 8) // + 0
        cpu.memory.writeInt(bufAddress + 4, buffer.size) // + 4
        cpu.memory.writeBuffer(bufAddress + 8, buffer) // + 8
        if (isCString)
            cpu.memory.writeByte(bufAddress + 8 + buffer.size, 0.toByte()) // + 8 + n

        return bufAddress
    }

    private fun call(call: Call): Result = call.invoke(machine)
}