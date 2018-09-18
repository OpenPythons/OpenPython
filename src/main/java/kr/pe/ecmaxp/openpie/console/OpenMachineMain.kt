package kr.pe.ecmaxp.openpie.console

import kr.pe.ecmaxp.thumbjk.Interrupt
import kr.pe.ecmaxp.thumbsk.CPU
import kr.pe.ecmaxp.thumbsk.Memory
import kr.pe.ecmaxp.thumbsk.MemoryFlag
import kr.pe.ecmaxp.thumbsk.helper.RegisterIndex
import kr.pe.ecmaxp.thumbsk.signal.ControlPauseSignal
import kr.pe.ecmaxp.thumbsk.signal.ControlStopSignal
import java.io.File
import java.nio.file.Files
import java.time.DateTimeException
import java.time.Instant
import java.util.*
import kotlin.system.exitProcess


object OpenMachineMain {
    internal var pos = 0


    @Throws(Exception::class, ControlPauseSignal::class, ControlStopSignal::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val memory = Memory()

        val file = File("C:\\Users\\EcmaXp\\Dropbox\\Projects\\openpie\\oprom\\build\\firmware.bin")
        val firmware = Files.readAllBytes(file.toPath())
        val KB = 1024
        memory.map(0x08000000L, 256 * KB, MemoryFlag.RX) // flash
        memory.map(0x20000000L, 64 * KB, MemoryFlag.RW) // sram

        val mem = HashMap<Long, Int>()
        fun handle (addr: Long, is_read: Boolean, size: Int, value: Int): Int {
            if (!is_read) {
                print("${addr} ${size} ${value}\n")
                mem[addr] = value
            }

            else {
                return when (addr) {
                    0x40000200L -> { // mp_hal_ticks_ms
                        0
                    }
                    else -> {
                        mem[addr]!!
                        // TODO("missing")
                    }
                }
            }

            return 0;
        }

        memory.map(0x40000000L, 4 * KB) { addr: Long, is_read: Boolean, size: Int, value: Int
            -> handle(addr, is_read, size, value)
        }

        // peripheral
        memory.map(0x60000000L, 192 * KB, MemoryFlag.RW) // ram
        memory.map(0xE0000000L, 16 * KB, MemoryFlag.RW) // syscall
        memory.writeBuffer(0x08000000, firmware)

        val refMemory = memory.copy()
        var refCPU = CPU()
        refCPU.memory = refMemory
        refCPU.regs[RegisterIndex.PC] = memory.readInt(0x08000000 + 4)
        refCPU.interruptHandler = {
            throw Exception(it.toString())
        }

        val start2 = Instant.now()
        try{
            while (true)
                refCPU.run(10000)
        } catch (e: Exception) {
            // throw e;
            println("done $e")
            println(Instant.now().toEpochMilli() - start2.toEpochMilli())
        }

        refCPU = CPU()
        refCPU.memory = refMemory
        refCPU.regs[RegisterIndex.PC] = memory.readInt(0x08000000 + 4)
        refCPU.interruptHandler = {
            throw Exception(it.toString())
        }

        val start3 = Instant.now()
        try{
            while (true)
                refCPU.run(10000)
        } catch (e: Exception) {
            // throw e;
            println("done $e")
            println(Instant.now().toEpochMilli() - start3.toEpochMilli())
        }
    }
}
