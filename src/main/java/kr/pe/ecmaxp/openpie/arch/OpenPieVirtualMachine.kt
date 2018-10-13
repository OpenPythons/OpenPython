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
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.nbt.NBTTagList
import java.io.ByteArrayOutputStream
import java.util.zip.GZIPInputStream
import java.util.zip.GZIPOutputStream


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

    fun load(rootTag: NBTTagCompound) {
        cpu.regs.store(rootTag.getIntArray("regs"))
        firmware = OpenPieFirmware(rootTag.getString("firmware"))

        val memoryTag = rootTag.getTagList("memory", 10)
        for (regionBaseTag in memoryTag) {
            val regionTag = regionBaseTag as NBTTagCompound
            val address = regionTag.getLong("address").toInt()
            // val size = regionTag.getInteger("size")
            // val flag = regionTag.getInteger("flag")

            val compressed = regionTag.getByteArray("buffer")
            val content = GZIPInputStream(compressed.inputStream()).use { it.readBytes() }
            try {
                cpu.memory.writeBuffer(address, content)
            } catch (e: InvalidMemoryException) {
                machine.crash("InvalidMemoryException while load() from world")
                return
            }
        }
    }

    fun save(rootTag: NBTTagCompound) {
        val memoryTag = NBTTagList()
        for (region in cpu.memory.fork()) {
            val regionTag = NBTTagCompound()
            regionTag.setLong("address", Integer.toUnsignedLong(region.begin))
            regionTag.setInteger("size", region.size)
            regionTag.setInteger("flag", region.flag.ordinal)

            val content = region.buffer
            val stream = ByteArrayOutputStream()
            GZIPOutputStream(stream).use { it.write(content) }
            val compressed = stream.toByteArray()
            regionTag.setByteArray("buffer", compressed)

            memoryTag.appendTag(regionTag)
        }

        // TODO: store OpenPieVirtualMachineState (file mapping)
        rootTag.setString("firmware", firmware.name)
        rootTag.setInteger("protocol", firmware.protocol)
        rootTag.setIntArray("regs", cpu.regs.load())
        rootTag.setTag("memory", memoryTag)
    }
}
