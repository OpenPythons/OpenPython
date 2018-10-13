package kr.pe.ecmaxp.openpie.arch

import kr.pe.ecmaxp.openpie.arch.state.FileHandle
import kr.pe.ecmaxp.openpie.arch.state.ValueContainerMap
import li.cil.oc.api.Persistable
import net.minecraft.nbt.NBTTagCompound
import java.util.*

class OpenPieVirtualMachineState : Persistable {
    var fdCount = 3
    var fdMap: HashMap<Int, FileHandle> = HashMap()
    var valueMap: ValueContainerMap = ValueContainerMap()

    // TODO: component and method?

    override fun load(p0: NBTTagCompound?) {
        TODO("not implemented")
    }

    override fun save(p0: NBTTagCompound?) {
        TODO("not implemented")
    }
}
