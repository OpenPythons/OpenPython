package kr.pe.ecmaxp.openpie.arch

import kr.pe.ecmaxp.openpie.arch.OpenPieMemoryRegion.*
import kr.pe.ecmaxp.openpie.arch.types.Interrupt
import kr.pe.ecmaxp.thumbsf.CPU
import kr.pe.ecmaxp.thumbsf.consts.I0
import kr.pe.ecmaxp.thumbsf.consts.PC
import kr.pe.ecmaxp.thumbsf.exc.InvalidMemoryException
import kr.pe.ecmaxp.thumbsf.signal.ControlSignal
import li.cil.oc.api.machine.ExecutionResult
import li.cil.oc.api.machine.Machine


class OpenPieVirtualMachine internal constructor(val machine: Machine, val memorySize: Int, var firmware: OpenPieFirmware) {
    val cpu: CPU = CPU()
    var state: OpenPieVirtualMachineState = OpenPieVirtualMachineState()
    var interruptHandler: OpenPieInterruptHandler = OpenPieInterruptHandler(this)

    init {
        val memory = cpu.memory.apply {
            flash(FLASH.address, FLASH.size, firmware.loadFirmware())
            map(SRAM.address, SRAM.size, SRAM.flag)
            map(RAM.address, memorySize, RAM.flag)
            map(SYSCALL.address, SYSCALL.size, SYSCALL.flag)
        }

        cpu.regs[PC] = memory.readInt(FLASH.address + 4) and I0.inv()
    }

    fun close() {
        // TODO: free memory
    }

    fun step(synchronized: Boolean): ExecutionResult {
        return try {
            cpu.run(if (synchronized) 1 else 10000000) {
                val interrupt = Interrupt(cpu, it, this)
                interruptHandler(interrupt, synchronized)
            }

            ExecutionResult.Sleep(0)
        } catch (controlSignal: ControlSignal) {
            if (controlSignal.value is ExecutionResult)
                controlSignal.value
            else
                throw controlSignal
        } catch (e: InvalidMemoryException) {
            ExecutionResult.Error("memory access violation:\n0x${String.format("%08X", e.address)}")
        } catch (e: Throwable) {
            firmware.printLastTracebackCPU(cpu)
            throw e
        }
    }
}
