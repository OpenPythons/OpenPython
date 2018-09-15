package kr.pe.ecmaxp.openpie.console

import kr.pe.ecmaxp.thumbsk.CPU
import kr.pe.ecmaxp.thumbsk.MemoryFlag
import kr.pe.ecmaxp.thumbsk.helper.RegisterIndex.PC
import kr.pe.ecmaxp.thumbsk.signal.ControlPauseSignal
import kr.pe.ecmaxp.thumbsk.signal.ControlStopSignal
import java.io.File
import java.nio.file.Files


object OpenPieMain {
    internal var pos = 0

    @Throws(Exception::class, ControlPauseSignal::class, ControlStopSignal::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val cpu = CPU()

        val file = File("C:\\Users\\EcmaXp\\Dropbox\\Projects\\openpie\\oprom\\build\\firmware.bin")
        val firmware = Files.readAllBytes(file.toPath())
        val KB = 1024
        val memory = cpu.memory
        memory.map(0x08000000, 256 * KB, MemoryFlag.RX) // flash
        memory.map(0x20000000, 64 * KB, MemoryFlag.RW) // sram
        /*
        memory.map(0x40000000, 4 * KB, { addr, read, size, value ->
            if (!read) {
                if (addr == 0x40000000L) {
                    System.out.append(value.toChar())
                }
            }

            0
        }) // peripheral
        */
        memory.map(0x60000000, 192 * KB, MemoryFlag.RW) // ram
        memory.map(-0x20000000, 16 * KB, MemoryFlag.RW) // syscall

        val flash = 0x08000000
        cpu.memory.writeBuffer(flash, firmware)
        cpu.regs[PC] = cpu.memory.readInt(0x08000000 + 4)

        val line = "print(1, 2, 3)\r\n".toByteArray()


        do {
            cpu.run(10000)
        } while (true)

        // uc.close();
    }
}
