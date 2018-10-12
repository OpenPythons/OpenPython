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
    private fun handleControl(intr: Interrupt, @Suppress("UNUSED_PARAMETER") synchronized: Boolean): Int {
        when (intr.imm) {
            SYS_CONTROL_SHUTDOWN -> throw ControlStopSignal(ExecutionResult.Shutdown(false))
            SYS_CONTROL_REBOOT -> throw ControlStopSignal(ExecutionResult.Shutdown(true))
            SYS_CONTROL_CRASH -> {
                val str = cpu.memory.readString(intr.r0, intr.r1)
                throw ControlStopSignal(ExecutionResult.Error(str))
            }
            SYS_CONTROL_RETURN -> throw ControlStopSignal(SystemControlReturn)
            SYS_CONTROL_INIT_COPY -> {
                val src = intr.r0
                val dest = intr.r1
                val dest_finish = intr.r2
                val size = dest_finish - dest
                val buffer = cpu.memory.readBuffer(src, size)
                cpu.memory.writeBuffer(dest, buffer)
                return 1
            }
            SYS_CONTROL_INIT_ZERO -> {
                val start = intr.r0
                val end = intr.r1
                val size = end - start
                cpu.memory.writeBuffer(start, ByteArray(size) { i -> 0 })
                return 1
            }
        }

        throw UnknownInterrupt()
    }

    private fun handleDebug(intr: Interrupt, @Suppress("UNUSED_PARAMETER") synchronized: Boolean): Int {
        val buf = cpu.memory.readBuffer(intr.r0, intr.r1)
        val str = String(buf, StandardCharsets.UTF_8)

        print(str)
        return 0
    }

    private fun handleSignal(intr: Interrupt, @Suppress("UNUSED_PARAMETER") synchronized: Boolean): Int {
        when (intr.imm) {
            SYS_SIGNAL_REQUEST -> {
                val signal: Signal? = machine.popSignal()
                if (signal == null) {
                    cpu.regs[R0] = SYS_SIGNAL_PENDING
                    throw ControlPauseSignal(ExecutionResult.Sleep(intr.r0))
                }

                return responseValue(signal)
            }
            SYS_SIGNAL_PENDING -> {
                val signal: Signal = machine.popSignal() ?: return 0
                return responseValue(signal)
            }
            SYS_SIGNAL_PUSH -> {
                TODO()
            }
        }

        throw UnknownInterrupt()
    }

    private fun handleInvoke(intr: Interrupt, synchronized: Boolean): Int {
        // intr.r0 => unused
        val obj = intr.loadObject(cpu)
        val call = Call.fromArray(obj as Array<*>)
                ?: return responseError(Exception("Invaild call"))

        if (!synchronized) {
            val node = machine.node().network().node(call.component) as? Component
                    ?: return responseError(Exception("Invalid Component"))

            val callback: Callback?

            try {
                callback = node.annotation(call.function)
                        ?: return responseError(Exception("Invalid Function"))
            } catch (e: NoSuchMethodException) {
                e.printStackTrace()
                return responseError(e)
            }

            if (!callback.direct) {
                // TODO: automatic detect sync call?
                throw ControlPauseSignal(ExecutionResult.SynchronizedCall())
            }
        }

        val ret = call(call)
        return if (ret.error == null) {
            responseValue(ret.args)
        } else {
            ret.error.printStackTrace()
            responseError(ret.error)
        }
    }

    // SYS_INFO_COMPUTER_ADDRESS -> responseValue(machine.node().address())

    private fun handleComputer(intr: Interrupt, @Suppress("UNUSED_PARAMETER") synchronized: Boolean): Int {
        when (intr.imm) {
            SYS_COMPUTER_COMPONENTS -> {
                return when (intr.r0) {
                    0 -> responseValue(machine.components())
                    else -> {
                        val target = cpu.memory.readString(intr.r0, intr.r1)
                        val components = ArrayList<String>()
                        for ((address, type) in machine.components()) {
                            if (type == target)
                                components.add(address)
                        }

                        responseValue(components)
                    }
                }
            }
            SYS_COMPUTER_COMPONENT_COUNT -> return responseValue(machine.componentCount())
            SYS_COMPUTER_MAX_COMPONENT -> return responseValue(machine.maxComponents())
            SYS_COMPUTER_METHODS -> {
                val req = intr.loadObject(cpu) as Array<*>
                val node = machine.node().network().node(req[0] as String)

                if (node is Component) {
                    return responseValue(node.methods())
                }

                return 0
            }
            SYS_COMPUTER_ANNOTATIONS -> {
                val req = intr.loadObject(cpu) as Array<*>
                if (req.size == 2) {
                    val node = machine.node().network().node(req[0] as String)
                    if (node is Component) {
                        try {
                            val callback = node.annotation(req[1] as String)
                            return responseValue(callback.doc)
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
            SYS_COMPUTER_GET_COST_PER_TICK -> return responseValue(machine.costPerTick)
            SYS_COMPUTER_LAST_ERROR -> return responseValue(machine.lastError())
            SYS_COMPUTER_BEEP_1 -> {
                val pattern = cpu.memory.readString(intr.r0, intr.r1)
                machine.beep(pattern)
                return responseNone()
            }
            SYS_COMPUTER_BEEP_2 -> {
                machine.beep(intr.r0.toShort(), intr.r1.toShort())
                return responseNone()
            }
            SYS_COMPUTER_USERS -> return responseValue(machine.users())
            SYS_COMPUTER_ADD_USER -> {
                val user = cpu.memory.readString(intr.r0, intr.r1)

                return try {
                    machine.addUser(user)
                    responseNone()
                } catch (e: Exception) {
                    responseError(e)
                }
            }
            SYS_COMPUTER_REMOVE_USER -> {
                val user = cpu.memory.readString(intr.r0, intr.r1)
                return responseValue(machine.removeUser(user))
            }
            SYS_COMPUTER_COMPUTER_ADDRESS -> return responseValue(machine.node().address())
            SYS_COMPUTER_TMP_ADDRESS -> return responseValue(machine.tmpAddress())
            else -> throw UnknownInterrupt()
        }
    }

    private fun handleInfo(intr: Interrupt, @Suppress("UNUSED_PARAMETER") synchronized: Boolean): Int {
        return when (intr.imm) {
            SYS_INFO_VERSION -> 0x0000
            SYS_INFO_RAM_SIZE -> vm.memorySize
            else -> throw UnknownInterrupt()
        }
    }

    private fun handleTimer(intr: Interrupt, @Suppress("UNUSED_PARAMETER") synchronized: Boolean): Int {
        return when (intr.imm) {
            SYS_TIMER_TICKS_MS -> System.currentTimeMillis().toInt()
            SYS_TIMER_TICKS_US -> System.nanoTime().toInt()
            SYS_TIMER_WORLD_TIME -> responseValue(machine.worldTime())
            SYS_TIMER_UP_TIME -> responseValue(machine.upTime())
            SYS_TIMER_CPU_TIME -> responseValue(machine.cpuTime())
            else -> throw UnknownInterrupt()
        }
    }

    private fun handleVirtualFileSystem(intr: Interrupt, synchronized: Boolean): Int {
        if (!synchronized)
            throw ControlPauseSignal(ExecutionResult.SynchronizedCall())

        val command = intr.imm
        if (command == SYS_VFS_OPEN) {
            val address = cpu.memory.readString(intr.r0, 64)
            val path = cpu.memory.readString(intr.r1, 256)
            val mode = cpu.memory.readString(intr.r2, 16)

            val ret = call(Call(address, "open", path, mode))
            when {
                ret.error is FileNotFoundException -> return MP_ENOENT
                ret.args != null -> {
                    if (ret.args.size != 1)
                        return MP_EPERM

                    val fdPtr = intr.r3
                    val fd = state.fdCount++
                    val handle = Integer.parseInt(ret.args[0].toString()) // handle

                    state.fdMap[fd] = FileHandle(address, handle)

                    cpu.memory.writeInt(fdPtr, fd)
                    return MP_OK
                }
                else -> return MP_EPERM
            }
        } else {
            val fd = intr.r0
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
                    val ret = call(fh.call("read", intr.r1))
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
                                cpu.memory.writeBuffer(intr.r2, buf)
                                cpu.memory.writeInt(intr.r3, buf.size)
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
                    val buf = cpu.memory.readBuffer(intr.r1, intr.r2)
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
                                cpu.memory.writeInt(intr.r3, buf.size)
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
                    val offset = intr.r1
                    val whence = intr.r2
                    val offsetPtr = intr.r3
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
            val code: Int = when (intr.imm and (0xFFFF shl 16)) {
                SYS_CONTROL -> handleControl(intr, synchronized)
                SYS_DEBUG -> handleDebug(intr, synchronized)
                SYS_SIGNAL -> handleSignal(intr, synchronized)
                SYS_INVOKE -> handleInvoke(intr, synchronized)
                SYS_COMPUTER -> handleComputer(intr, synchronized)
                SYS_INFO -> handleInfo(intr, synchronized)
                SYS_TIMER -> handleTimer(intr, synchronized)
                SYS_VFS -> handleVirtualFileSystem(intr, synchronized)
                else -> throw UnknownInterrupt()
            }

            cpu.regs[0] = code
        } catch (e: UnknownInterrupt) {
            e.printStackTrace()
            throw ControlStopSignal(ExecutionResult.Error("Unknown Interrupt?"))
        } catch (e: LimitReachedException) {
            throw ControlPauseSignal(ExecutionResult.SynchronizedCall())
        }
    }

    private fun responseNone(): Int {
        return 0
    }

    private fun responseError(value: Throwable): Int {
        val bufAddress = OpenPieMemoryRegion.SYSCALL.address
        val buffer = Msgpack.dumps(value)
        cpu.memory.writeInt(bufAddress, 0) // + 0 | 1 = OK (msgpack)
        cpu.memory.writeInt(bufAddress + 4, bufAddress + 12) // + 4
        cpu.memory.writeInt(bufAddress + 8, buffer.size) // + 8
        cpu.memory.writeBuffer(bufAddress + 12, buffer) // + 12
        return bufAddress
    }

    private fun responseValue(value: Any?): Int {
        if (value == null)
            return responseNone()

        val bufAddress = OpenPieMemoryRegion.SYSCALL.address
        val buffer = Msgpack.dumps(value)
        cpu.memory.writeInt(bufAddress, 1) // + 0 = OK (msgpack)
        cpu.memory.writeInt(bufAddress + 4, bufAddress + 12) // + 4
        cpu.memory.writeInt(bufAddress + 8, buffer.size) // + 8
        cpu.memory.writeBuffer(bufAddress + 12, buffer) // + 12
        return bufAddress
    }

    private fun responseBuffer(buffer: ByteArray): Int {
        val bufAddress = OpenPieMemoryRegion.SYSCALL.address
        cpu.memory.writeInt(bufAddress, bufAddress + 8) // + 0 | 0 = ERROR
        cpu.memory.writeInt(bufAddress + 4, buffer.size) // + 4
        cpu.memory.writeBuffer(bufAddress + 8, buffer) // + 8
        cpu.memory.writeByte(bufAddress + 8 + buffer.size, 0.toByte()) // + 8 + n
        return bufAddress
    }

    private fun call(call: Call): Result = call.invoke(machine)
}