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
import java.io.*
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
            firmware.printLastTracebackCPU(cpu)
            ExecutionResult.Error("memory access violation:\n0x${String.format("%08X", e.address)}")
        } catch (e: Throwable) {
            firmware.printLastTracebackCPU(cpu)
            throw e
        }
    }

    fun load(tag: NBTTagCompound) {
        val rootTag = OpenComputersLikeSaveHandler.loadNbt(machine.host(), tag, machine.node().address()) ?: run {
            if (machine.isRunning) machine.crash("Missing data")
            return
        }


        // firmware
        val firmwareTag = rootTag.getCompoundTag("firmware")
        val firmwareName = firmwareTag.getString("name")
        if (firmware.name != firmwareName)
            firmware = OpenPieFirmware(firmwareName)


        // cpu
        val cpuTag = rootTag.getCompoundTag("cpu")

        cpu.regs.store(cpuTag.getIntArray("regs"))

        val memoryTag = cpuTag.getTagList("memory", NBTTagCompound().id.toInt())
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


        // state
        val stateTag = rootTag.getCompoundTag("state")
        state.load(stateTag)
    }

    fun save(tag: NBTTagCompound) {

        // firmware
        val firmwareTag = NBTTagCompound()
        firmwareTag.setString("name", firmware.name)
        firmwareTag.setInteger("protocol", firmware.protocol)


        // cpu
        val cpuTag = NBTTagCompound()

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

        cpuTag.setIntArray("regs", cpu.regs.load())
        cpuTag.setTag("memory", memoryTag)


        // state
        val stateTag = NBTTagCompound()
        state.save(stateTag)


        val rootTag = NBTTagCompound()
        // rootTag.setInteger("memorySize", memorySize) // TODO: no idea
        rootTag.setTag("firmware", firmwareTag)
        rootTag.setTag("cpu", cpuTag)
        rootTag.setTag("state", stateTag)

        OpenComputersLikeSaveHandler.scheduleSave(machine.host(), tag, machine.node().address(), rootTag)
    }
}
