package kr.pe.ecmaxp.openpie.arch.state

import li.cil.oc.api.Persistable
import li.cil.oc.api.machine.Value
import net.minecraft.nbt.NBTTagCompound

class ValueContainer(var value: Value? = null, var id: Int = 0) : Persistable {
    override fun load(nbt: NBTTagCompound) {
        val clsName = nbt.getString("class")
        val cls = Class.forName(clsName)
        val instance = cls.newInstance() as? Value ?: throw TypeCastException()
        val data = nbt.getCompoundTag("data")
        val id = nbt.getInteger("id")

        instance.load(data)

        this.id = id
        this.value = instance
    }

    override fun save(nbt: NBTTagCompound) {
        val data = NBTTagCompound()
        value!!.save(data)

        nbt.setString("class", value!!.javaClass.name)
        nbt.setTag("data", data)
        nbt.setInteger("id", id)
    }
}
