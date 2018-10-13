package kr.pe.ecmaxp.openpie.arch.state

import kr.pe.ecmaxp.openpie.arch.types.call.ComponentInvoke
import li.cil.oc.api.Persistable
import net.minecraft.nbt.NBTTagCompound

class FileHandle(val fd: Int, val address: String, val handle: Int, var pos: Int = 0): Persistable {
    operator fun invoke(func: String, vararg args: Any): ComponentInvoke = ComponentInvoke(this.address, func, this.handle, *args)

    override fun toString(): String {
        return "FileHandle(fd='$fd', address='$address', handle=$handle, pos=$pos)"
    }

    override fun load(p0: NBTTagCompound?) {
        TODO("not implemented")
    }

    override fun save(p0: NBTTagCompound?) {
        TODO("not implemented")
    }

    companion object {
        fun load(p0: NBTTagCompound): FileHandle {
            val handle = FileHandle(0, "", 0, 0)
            handle.load(p0)
            return handle
        }
    }
}
