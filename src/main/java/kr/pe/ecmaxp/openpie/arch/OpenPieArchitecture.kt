package kr.pe.ecmaxp.openpie.arch

import kr.pe.ecmaxp.thumbsf.exc.InvalidMemoryException
import li.cil.oc.api.Driver
import li.cil.oc.api.driver.item.Memory
import li.cil.oc.api.machine.Architecture
import li.cil.oc.api.machine.ExecutionResult
import li.cil.oc.api.machine.Machine
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.nbt.NBTTagList
import java.io.ByteArrayOutputStream
import java.util.zip.GZIPInputStream
import java.util.zip.GZIPOutputStream


@Suppress("unused")
@Architecture.Name("micropython (OpenPie)")
class OpenPieArchitecture(private val machine: Machine) : Architecture {
    private var initialized: Boolean = false
    private var totalMemory = 0
    private var vmMemory = 0
    private var vm: OpenPieVirtualMachine? = null
    private var lastSynchronizedResult: ExecutionResult? = null

    override fun isInitialized(): Boolean {
        return vm != null
    }

    override fun recomputeMemory(iterable: Iterable<ItemStack>): Boolean {
        var totalRam = 0.0
        for (stack in iterable) {
            val driver = Driver.driverFor(stack)
            if (driver is Memory) {
                totalRam += driver.amount(stack) * KB
            }
        }

        totalMemory = totalRam.toInt()
        return (vm?.memorySize ?: 1) <= totalRam
    }a

    override fun initialize(): Boolean {
        close()

        try {
            val firmware = Firmware("debug") // TODO: Firmware mapping
            recomputeMemory(machine.host().internalComponents())
            vm = OpenPieVirtualMachine(machine, totalMemory, firmware)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return isInitialized
    }

    override fun close() {
        vm?.close()
        vm = null
    }

    var prev = Firmware.DEBUG.getDebugLastModifiedTime()
    private fun step(isSynchronized: Boolean): ExecutionResult {
        val vm = this.vm ?: return ExecutionResult.Error("invalid machine")
        if (vm.memorySize > totalMemory)
            return ExecutionResult.Error("not enough memory")

        val next = Firmware.DEBUG.getDebugLastModifiedTime()
        if (prev != next) {
            prev = next;
            return ExecutionResult.Shutdown(true)
        }

        return try {
            vm.step(isSynchronized)
        } catch (e: Exception) {
            e.printStackTrace()
            ExecutionResult.Error("kernel panic:\n${e}")
        } catch (e: Error) {
            e.printStackTrace()
            ExecutionResult.Error("kernel panic:\n${e}")
        } catch (e: Throwable) {
            throw e
        }
    }

    override fun runThreaded(synchronizedReturn: Boolean): ExecutionResult {
        return if (!synchronizedReturn) {
            step(false)
        } else {
            val result = lastSynchronizedResult!!
            lastSynchronizedResult = null
            result
        }
    }

    override fun runSynchronized() {
        lastSynchronizedResult = step(true)
    }

    override fun onSignal() {}

    override fun onConnect() {}

    override fun load(rootTag: NBTTagCompound) {
        if (!machine.isRunning) return

        val vm = this.vm!!
        val cpu = vm.cpu

        cpu.regs.store(rootTag.getIntArray("regs"))
        vm.firmware = Firmware(rootTag.getString("firmware"))

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

    override fun save(rootTag: NBTTagCompound) {
        val vm = this.vm!!
        val cpu = vm.cpu

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

        // TODO: store VMState (file mapping)
        rootTag.setString("firmware", vm.firmware.name)
        rootTag.setInteger("protocol", vm.firmware.protocol)
        rootTag.setIntArray("regs", cpu.regs.load())
        rootTag.setTag("memory", memoryTag)
    }

    override fun toString(): String {
        return "OpenPieArchitecture(machine=$machine, initialized=$initialized, vm=$vm, lastSynchronizedResult=$lastSynchronizedResult)"
    }
}
