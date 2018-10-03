package kr.pe.ecmaxp.openpie.arch

import kr.pe.ecmaxp.openpie.arch.consts.*
import kr.pe.ecmaxp.openpie.arch.micropython.*
import kr.pe.ecmaxp.openpie.arch.msgpack.Msgpack
import kr.pe.ecmaxp.openpie.arch.types.Call
import kr.pe.ecmaxp.openpie.arch.types.Interrupt
import kr.pe.ecmaxp.openpie.arch.types.Result
import kr.pe.ecmaxp.thumbsf.CPU
import kr.pe.ecmaxp.thumbsf.MemoryFlag
import kr.pe.ecmaxp.thumbsf.exc.InvalidMemoryException
import kr.pe.ecmaxp.thumbsf.exc.UnexceptedLogicError
import kr.pe.ecmaxp.thumbsf.signal.ControlStopSignal
import li.cil.oc.api.machine.ExecutionResult
import li.cil.oc.api.machine.LimitReachedException
import li.cil.oc.api.machine.Machine
import li.cil.oc.api.network.Component
import java.io.FileNotFoundException
import java.nio.charset.StandardCharsets

object SystemControlReturn

class OpenPieInterruptHandler(val cpu: CPU, val machine: Machine, val state: VMState) {
    private fun handleSystemControl(intr: Interrupt): Int {
        when (intr.r0) {
            SYS_CONTROL_SHUTDOWN -> throw ControlStopSignal(ExecutionResult.Shutdown(false))
            SYS_CONTROL_REBOOT -> throw ControlStopSignal(ExecutionResult.Shutdown(true))
            SYS_CONTROL_CRASH -> {
                val str = cpu.memory.readString(intr.r1, 256)
                Crash(str)
            }
            SYS_CONTROL_RETURN -> throw ControlStopSignal(SystemControlReturn)
        }

        Crash("Unknown Interrupt")
        throw UnexceptedLogicError()
    }

    private fun Crash(message: String) {
        machine.crash(message)
        throw ControlStopSignal(ExecutionResult.Error(message))
    }

    private fun handleSystemInvoke(intr: Interrupt): Int {
        // intr.r0 => unused
        val obj = intr.loadObject(cpu)
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

    private fun handleSystemRequest(intr: Interrupt): Int {
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
                val req = intr.loadObject(cpu) as Array<*>
                val node = machine.node().network().node(req[0] as String)

                if (node is Component) {
                    return intrResponse(node.methods())
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

    var test = 0;
    private fun handleSystemVirtualFileSystem(intr: Interrupt): Int {
        val command = intr.r0
        if (command == 1) {
            val address = cpu.memory.readString(intr.r1, 64)
            val path = cpu.memory.readString(intr.r2, 256)
            val mode = cpu.memory.readString(intr.r3, 16)

            val ret = invoke(Call(address, "open", path, mode))
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
                2 // VFS_VALID
                -> {
                    val ret = invoke(fh.call("seek", fh.pos))
                    return if (ret.error == null) MP_OK else MP_EIO
                }
                3 // VFS_REPR
                -> return MP_EPERM
                4 // VFS_CLOSE
                -> {
                    val ret = invoke(fh.call("close"))
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
                    val ret = invoke(fh.call("read", intr.r2))
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
                6 // VFS_WRITE
                -> {
                    val buf = cpu.memory.readBuffer(intr.r2, intr.r3)
                    val ret = invoke(fh.call("write", *arrayOf(buf)))
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

                    val ret = invoke(fh.call("seek", whenceStr, offset))
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


    private fun handleSystemDebug(intr: Interrupt): Int {
        val buf = cpu.memory.readBuffer(intr.r0, intr.r1)
        val str = String(buf, StandardCharsets.UTF_8)

        print(str)
        return 0
    }

    private fun handleSystemLegacy(intr: Interrupt): Int {
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

    operator fun invoke(intr: Interrupt) {
        try {
            val code: Int = when (intr.imm) {
                SYS_CONTROL -> handleSystemControl(intr)
                SYS_INVOKE -> handleSystemInvoke(intr)
                SYS_REQUEST -> handleSystemRequest(intr)
                SYS_VFS -> handleSystemVirtualFileSystem(intr)
                SYS_DEBUG -> handleSystemDebug(intr)
                SYS_LEGACY -> handleSystemLegacy(intr)
                else -> throw UnknownInterrupt()
            }

            cpu.regs[0] = code
        } catch (e: UnknownInterrupt) {
            Crash("Unknown interrupt number")
        } catch (e: LimitReachedException) {
            throw ControlStopSignal(ExecutionResult.SynchronizedCall())
        }
    }

    private fun intrResponse(value: Any): Int {
        val bufAddress = OpenPieMemoryRegion.SYSCALL.address.toInt()
        val buffer = Msgpack.dumps(value)
        cpu.memory.writeInt(bufAddress, bufAddress + 8) // + 0
        cpu.memory.writeInt(bufAddress + 4, buffer.size) // + 4
        cpu.memory.writeBuffer(bufAddress + 8, buffer) // + 8
        cpu.memory.writeByte(bufAddress + 8 + buffer.size, 0.toByte()) // + 8 + n
        return bufAddress
    }

    private fun intrResponseBuffer(buffer: ByteArray?): Int {
        if (buffer != null && buffer.size > 0)
            return interruptResponseBuffer(buffer)
        else
            return 0
    }

    private fun interruptResponseBuffer(buffer: ByteArray): Int {
        val bufAddress = OpenPieMemoryRegion.SYSCALL.address.toInt()
        cpu.memory.writeInt(bufAddress, bufAddress + 8) // + 0
        cpu.memory.writeInt(bufAddress + 4, buffer.size) // + 4
        cpu.memory.writeBuffer(bufAddress + 8, buffer) // + 8
        cpu.memory.writeByte(bufAddress + 8 + buffer.size, 0.toByte()) // + 8 + n
        return bufAddress
    }

    private fun invoke(call: Call): Result {
        return call.invoke(machine)
    }
}