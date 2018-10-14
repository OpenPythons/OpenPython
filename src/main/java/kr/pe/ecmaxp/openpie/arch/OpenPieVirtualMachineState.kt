package kr.pe.ecmaxp.openpie.arch

import kr.pe.ecmaxp.openpie.arch.state.FileHandle
import kr.pe.ecmaxp.openpie.arch.state.ValueContainerMap
import li.cil.oc.api.Persistable
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.nbt.NBTTagList
import java.util.*

class OpenPieVirtualMachineState : Persistable {
    var fdCount = 3
    var fdMap: HashMap<Int, FileHandle> = HashMap()
    var valueMap: ValueContainerMap = ValueContainerMap()

    // TODO: component and method?

    override fun load(tag: NBTTagCompound) {
        fdCount = tag.getInteger("fdCount")
        for (fdBaseTag in tag.getTagList("fdMap", NBTTagCompound().id.toInt())) {
            val fdTag = fdBaseTag as NBTTagCompound
            val handle = FileHandle.load(fdTag)
            fdMap[handle.fd] = handle
        }

        valueMap.load(tag.getCompoundTag("valueMap"))
    }

    override fun save(tag: NBTTagCompound) {
        val valueTag = NBTTagCompound()
        valueMap.save(valueTag)

        val fdTagList = NBTTagList()
        for (item in fdMap) {
            val fdTag = NBTTagCompound()
            item.value.save(fdTag)
            fdTagList.appendTag(fdTag)
        }

        tag.setInteger("fdCount", 3)
        tag.setTag("fdMap", fdTagList)
        tag.setTag("valueMap", valueTag)
    }
}
