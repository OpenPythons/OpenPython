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
import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.attribute.FileTime
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
                totalRam += driver.amount(stack) * 1024
            }
        }

        totalMemory = totalRam.toInt()
        return (vm?.memorySize ?: 0) <= totalRam
    }

    // TODO: report exception handler?

    override fun initialize(): Boolean {
        close()

        try {
            vm = OpenPieVirtualMachine(machine, totalMemory)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return isInitialized
    }

    override fun close() {
        vm?.close()
        vm = null
    }

    val prev = DebugFirmwareGetLastModifiedTime()
    private fun step(isSynchronized: Boolean): ExecutionResult {
        val vm = this.vm ?: return ExecutionResult.Error("invalid machine")
        if (vm.memorySize > totalMemory)
            return ExecutionResult.Error("not enough memory")

        val next = DebugFirmwareGetLastModifiedTime()
        if (prev != next)
            return ExecutionResult.Shutdown(true)

        return try {
            vm.step(isSynchronized)
        } catch (e: InvalidMemoryException) {
            ExecutionResult.Error("memory access violation: 0x${String.format("%08X", e.address)}")
        } catch (e: Exception) {
            e.printStackTrace()
            ExecutionResult.Error(e.toString())
        } catch (e: Throwable) {
            e.printStackTrace()
            throw e;
        }
    }

    override fun runThreaded(isSynchronizedReturn: Boolean): ExecutionResult {
        return if (!isSynchronizedReturn) {
            step(false)
        } else {
            val result = lastSynchronizedResult ?: ExecutionResult.Error("invalid synchronized call")
            lastSynchronizedResult = null
            result
        }
    }

    override fun runSynchronized() {
        lastSynchronizedResult = try {
            step(true)
        } catch (e: Exception) {
            e.printStackTrace()
            ExecutionResult.Error(e.toString())
        }
    }

    private fun DebugFirmwareGetLastModifiedTime(): FileTime? {
        val file = File("C:\\Users\\EcmaXp\\Dropbox\\Projects\\openpie\\oprom\\build\\firmware.bin")
        try {
            return Files.getLastModifiedTime(file.toPath())
        } catch (ignored: IOException) {
        }

        return null
    }

    override fun onSignal() {
        vm!!.onSignal()
    }

    override fun onConnect() {
        println(toString() + ": onConnect()")
    }

    override fun load(rootTag: NBTTagCompound) {
        if (!machine.isRunning) return

        val vm = this.vm!!
        val cpu = vm.cpu

        val memoryTag = rootTag.getTagList("memory", 10)
        for (regionBaseTag in memoryTag) {
            val regionTag = regionBaseTag as NBTTagCompound
            val address = regionTag.getLong("address").toInt()
            // val size = regionTag.getInteger("size") // TODO: load memory size please
            val isHook = regionTag.getBoolean("isHook")
            // val flag = regionTag.getInteger("size")

            if (!isHook) {
                val compressed = regionTag.getByteArray("buffer")
                val content = GZIPInputStream(compressed.inputStream()).use { it.readBytes() }
                cpu.memory.writeBuffer(address, content)
            } else {
                // TODO: ?
            }
        }

        cpu.regs.store(rootTag.getIntArray("regs"))
    }

    override fun save(rootTag: NBTTagCompound) {
        val vm = this.vm!!
        val cpu = vm.cpu

        val memoryTag = NBTTagList()
        for (region in cpu.memory.fork()) {
            val regionTag = NBTTagCompound()
            regionTag.setLong("address", Integer.toUnsignedLong(region.begin))
            regionTag.setInteger("size", region.size)
            regionTag.setBoolean("isHook", region.isHook)
            regionTag.setInteger("flag", region.flag.ordinal)

            if (!region.isHook) {
                val content = region.buffer
                val stream = ByteArrayOutputStream()
                GZIPOutputStream(stream).use { it.write(content) }
                val compressed = stream.toByteArray()
                regionTag.setByteArray("buffer", compressed)
            }

            memoryTag.appendTag(regionTag)
        }

        // TODO: store firmware (and protocol) version
        // TODO: store VMState (file mapping, input/output buffer and signals)
        rootTag.setTag("memory", memoryTag)
        rootTag.setIntArray("regs", cpu.regs.load())
    }

    override fun toString(): String {
        return "OpenPieArchitecture(machine=$machine, initialized=$initialized, vm=$vm, lastSynchronizedResult=$lastSynchronizedResult)"
    }
}
