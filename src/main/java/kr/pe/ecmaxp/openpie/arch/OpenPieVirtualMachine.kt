package kr.pe.ecmaxp.openpie.arch

import kr.pe.ecmaxp.openpie.arch.OpenPieMemoryRegion.*
import kr.pe.ecmaxp.openpie.arch.consts.*
import kr.pe.ecmaxp.openpie.arch.state.VMState
import kr.pe.ecmaxp.openpie.arch.types.Interrupt
import kr.pe.ecmaxp.thumbsf.CPU
import kr.pe.ecmaxp.thumbsf.Registers
import kr.pe.ecmaxp.thumbsf.consts.I0
import kr.pe.ecmaxp.thumbsf.consts.PC
import kr.pe.ecmaxp.thumbsf.exc.*
import kr.pe.ecmaxp.thumbsf.signal.ControlPauseSignal
import kr.pe.ecmaxp.thumbsf.signal.ControlSignal
import li.cil.oc.api.machine.ExecutionResult
import li.cil.oc.api.machine.Machine


class OpenPieVirtualMachine internal constructor(private val machine: Machine, val memorySize: Int, var firmware: Firmware) {
    val cpu: CPU = CPU()
    var state: VMState = VMState()
    var interruptHandler: OpenPieInterruptHandler = OpenPieInterruptHandler(this, cpu, machine, state)

    init {
        val memory = cpu.memory.apply {
            flash(FLASH.address, FLASH.size, firmware.loadFirmware())
            map(SRAM.address, SRAM.size, SRAM.flag)
            map(RAM.address, memorySize, RAM.flag)
            map(SYSCALL.address, SYSCALL.size, SYSCALL.flag)
            map(EXTERNAL_STACK.address, EXTERNAL_STACK.size, EXTERNAL_STACK.flag)
        }

        cpu.regs[PC] = memory.readInt(FLASH.address + 4) and I0.inv()
    }

    fun close() {
        // TODO: free memory
    }

    fun step(synchronized: Boolean): ExecutionResult {
        return try {
            if (!synchronized) {
                // async
                cpu.run(10000000) {
                    val interrupt = Interrupt(cpu, it)
                    interruptHandler(interrupt, synchronized)
                }
            } else {
                // sync
                cpu.run(1) {
                    val interrupt = Interrupt(cpu, it)
                    interruptHandler(interrupt, synchronized)
                }
            }

            ExecutionResult.Sleep(0)
        } catch (controlSignal: ControlSignal) {
            if (controlSignal.value !is ExecutionResult)
                throw controlSignal

            controlSignal.value
        } catch (e: InvalidMemoryException) {
            ExecutionResult.Error("memory access violation:\n0x${String.format("%08X", e.address)}")
        } catch (e: Throwable) {
            firmware.printLastTracebackCPU(cpu)
            throw e
        }
    }

    fun onSignal() {
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
                interruptHandler(intr, true)
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

