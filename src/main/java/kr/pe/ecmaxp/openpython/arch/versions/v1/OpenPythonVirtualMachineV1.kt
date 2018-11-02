package kr.pe.ecmaxp.openpython.arch.versions.v1

import kr.pe.ecmaxp.openpython.OpenPythonVirtualMachine
import kr.pe.ecmaxp.openpython.arch.OpenComputersLikeSaveHandler
import kr.pe.ecmaxp.openpython.arch.msgpack.MsgpackPacker
import kr.pe.ecmaxp.openpython.arch.msgpack.MsgpackUnpacker
import kr.pe.ecmaxp.openpython.arch.types.interrupt.Interrupt
import kr.pe.ecmaxp.openpython.arch.types.interrupt.InterruptHandler
import kr.pe.ecmaxp.openpython.arch.versions.v1.OpenPythonMemoryRegionV1.*
import kr.pe.ecmaxp.openpython.repack.org.msgpack.core.MessagePacker
import kr.pe.ecmaxp.openpython.repack.org.msgpack.core.MessageUnpacker
import kr.pe.ecmaxp.thumbsf.CPU
import kr.pe.ecmaxp.thumbsf.consts.I0
import kr.pe.ecmaxp.thumbsf.consts.PC
import kr.pe.ecmaxp.thumbsf.exc.InvalidMemoryException
import kr.pe.ecmaxp.thumbsf.signal.ControlSignal
import li.cil.oc.api.machine.ExecutionResult
import li.cil.oc.api.machine.Machine
import li.cil.oc.api.machine.Value
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.nbt.NBTTagList
import java.io.ByteArrayOutputStream
import java.util.zip.GZIPInputStream
import java.util.zip.GZIPOutputStream


class OpenPythonVirtualMachineV1 internal constructor(val machine: Machine, override val memorySize: Int) : OpenPythonVirtualMachine {
    override fun packValue(packer: MessagePacker, value: Value) {
        val newPacker = MsgpackPacker(this)
        newPacker.pack(state.valueMap.register(value).id)
        val buffer = newPacker.toByteArray()
        packer.packExtensionTypeHeader(1, buffer.size)
        packer.writePayload(buffer)
    }

    override fun unpackExtension(unpacker: MessageUnpacker): Any? {
        val ext = unpacker.unpackExtensionTypeHeader()
        val payload = unpacker.readPayload(ext.length)

        return when (ext.type.toInt() and 0xFF) {
            1 -> {
                val newUnpacker = MsgpackUnpacker(payload, this)
                val pointer = newUnpacker.unpack() as Int
                state.valueMap[pointer]
            }
            else -> TODO()
        }
    }

    var firmware = OpenPythonArchitectureV1.LATEST_FIRMWARE
    val cpu: CPU = CPU()
    var state: OpenPythonVirtualMachineStateV1 = OpenPythonVirtualMachineStateV1()
    var interruptHandler: InterruptHandler = OpenPythonInterruptHandlerV1(this)

    init {
        val memory = cpu.memory.apply {
            flash(FLASH.address, FLASH.size, firmware.loadFirmware())
            map(SRAM.address, SRAM.size, SRAM.flag)
            map(RAM.address, memorySize, RAM.flag)
            map(SYSCALL.address, SYSCALL.size, SYSCALL.flag)
        }

        cpu.regs[PC] = memory.readInt(FLASH.address + 4) and I0.inv()
    }

    override fun close() {
        // TODO: free memory
    }

    override fun step(synchronized: Boolean): ExecutionResult {
        return try {
            cpu.run(if (synchronized) 1 else 10000000) {
                val interrupt = OpenPythonInterruptV1(cpu, it, this)
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

    override fun load(tag: NBTTagCompound) {
        val rootTag = OpenComputersLikeSaveHandler.loadNbt(machine.host(), tag, machine.node().address())
                ?: run {
                    if (machine.isRunning) machine.crash("Missing data")
                    return
                }


        // LATEST_FIRMWARE
        val firmwareTag = rootTag.getCompoundTag("LATEST_FIRMWARE")
        val firmwareName = firmwareTag.getString("name")
        if (firmware.name != firmwareName) {
            firmware = OpenPythonArchitectureV1.LATEST_FIRMWARE
        }


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

    override fun save(tag: NBTTagCompound) {
        // LATEST_FIRMWARE
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
        rootTag.setTag("LATEST_FIRMWARE", firmwareTag)
        rootTag.setTag("cpu", cpuTag)
        rootTag.setTag("state", stateTag)

        OpenComputersLikeSaveHandler.scheduleSave(machine.host(), tag, machine.node().address(), rootTag)
    }
}
