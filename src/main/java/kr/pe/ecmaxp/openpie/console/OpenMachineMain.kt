package kr.pe.ecmaxp.openpie.console

import kr.pe.ecmaxp.micropython.example.MicroPython_mp
import kr.pe.ecmaxp.openpie.OpenPieVirtualMachine
import kr.pe.ecmaxp.thumbsk.CPU
import kr.pe.ecmaxp.thumbsk.MemoryFlag
import kr.pe.ecmaxp.thumbsk.helper.RegisterIndex.PC
import kr.pe.ecmaxp.thumbsk.signal.ControlPauseSignal
import kr.pe.ecmaxp.thumbsk.signal.ControlStopSignal
import java.io.File
import java.nio.file.Files


object OpenMachineMain {
    internal var pos = 0

    @Throws(Exception::class, ControlPauseSignal::class, ControlStopSignal::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val mp = MicroPython_mp(CPU())
        val cpu = mp.cpu
        val memory = cpu.memory

        val file = File("C:\\Users\\EcmaXp\\Dropbox\\Projects\\openpie\\oprom\\build\\firmware.bin")
        val firmware = Files.readAllBytes(file.toPath())
        val KB = 1024
        memory.map(0x08000000L, 256 * KB, MemoryFlag.RX) // flash
        memory.map(0x20000000L, 64 * KB, MemoryFlag.RW) // sram
        memory.map(0x40000000L, 4 * KB) { addr: Long, is_read: Boolean, size: Int, value: Int
            -> TODO("not yet")
        }
        // peripheral
        memory.map(0x60000000L, 192 * KB, MemoryFlag.RW) // ram
        memory.map(0xE0000000L, 16 * KB, MemoryFlag.RW) // syscall
        memory.writeBuffer(0x08000000, firmware)
        cpu.regs[PC] = cpu!!.memory.readInt(0x08000000 + 4)

        mp.Reset_Handler()
        // uc.close();
    }
}
