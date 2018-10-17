package kr.pe.ecmaxp.openpython.arch.state

import kr.pe.ecmaxp.openpython.arch.types.call.ComponentInvoke
import li.cil.oc.api.Persistable
import net.minecraft.nbt.NBTTagCompound

class FileHandle(var fd: Int, var address: String, var handle: Int, var pos: Int = 0) : Persistable {
    operator fun invoke(func: String, vararg args: Any): ComponentInvoke = ComponentInvoke(this.address, func, this.handle, *args)

    override fun toString(): String {
        return "FileHandle(fd='$fd', address='$address', handle=$handle, pos=$pos)"
    }

    override fun load(tag: NBTTagCompound) {
        fd = tag.getInteger("fd")
        address = tag.getString("address")
        handle = tag.getInteger("handle")
        pos = tag.getInteger("pos")
    }

    override fun save(tag: NBTTagCompound) {
        tag.setInteger("fd", fd)
        tag.setString("address", address)
        tag.setInteger("handle", handle)
        tag.setInteger("pos", pos)
    }

    companion object {
        fun load(tag: NBTTagCompound): FileHandle {
            val handle = FileHandle(0, "", 0, 0)
            handle.load(tag)
            return handle
        }
    }
}
