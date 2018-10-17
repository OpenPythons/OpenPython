package kr.pe.ecmaxp.openpython.arch

import kr.pe.ecmaxp.openpython.arch.consts.KB
import li.cil.oc.api.Driver
import li.cil.oc.api.driver.item.Memory
import li.cil.oc.api.machine.Architecture
import li.cil.oc.api.machine.ExecutionResult
import li.cil.oc.api.machine.Machine
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound


open class OpenPythonArchitecture(val machine: Machine) : Architecture {
    var totalMemory = 0
    var vm: OpenPythonVirtualMachine? = null
    var lastSynchronizedResult: ExecutionResult? = null

    override fun isInitialized(): Boolean {
        return vm != null
    }

    override fun initialize(): Boolean {
        close()

        try {
            val firmware = OpenPythonFirmware("debug") // TODO: OpenPythonFirmware mapping
            recomputeMemory(machine.host().internalComponents())
            vm = OpenPythonVirtualMachine(machine, totalMemory, firmware)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return isInitialized
    }

    override fun close() {
        vm?.close()
        vm = null
        lastSynchronizedResult = null
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
    }

    private fun step(isSynchronized: Boolean): ExecutionResult {
        val vm = this.vm ?: return ExecutionResult.Error("invalid machine")
        if (vm.memorySize > totalMemory)
            return ExecutionResult.Error("not enough memory")

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
            val result = lastSynchronizedResult ?: ExecutionResult.SynchronizedCall()
            lastSynchronizedResult = null
            result
        }
    }

    override fun runSynchronized() {
        lastSynchronizedResult = step(true)
    }

    override fun onSignal() {}

    override fun onConnect() {}

    override fun load(nbt: NBTTagCompound) {
        if (!machine.isRunning) return
        vm!!.load(nbt)
    }

    override fun save(nbt: NBTTagCompound) {
        vm!!.save(nbt)
    }
}
