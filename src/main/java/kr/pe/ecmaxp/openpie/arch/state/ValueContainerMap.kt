package kr.pe.ecmaxp.openpie.arch.state

import li.cil.oc.api.Persistable
import li.cil.oc.api.machine.Value
import net.minecraft.nbt.NBTTagCompound
import java.util.*

class ValueContainerMap : Persistable {
    var containerSet: HashSet<ValueContainer> = HashSet()
    var pointerMap: HashMap<Int, ValueContainer> = HashMap()
    var valueMap: HashMap<Value, ValueContainer> = HashMap()

    operator fun get(id: Int): Value {
        return pointerMap[id]!!.value!!
    }

    fun register(value: Value): ValueContainer = valueMap.get(value) ?: register(findEmptyId(), value)

    fun register(id: Int, value: Value): ValueContainer {
        val container = ValueContainer(value, id)

        valueMap[value] = container
        pointerMap[id] = container
        containerSet.add(container)
        return container
    }

    fun unregister(value: Value) = unregister(valueMap[value]!!)

    fun unregister(container: ValueContainer) {
        valueMap.remove(container.value)
        pointerMap.remove(container.id)
        containerSet.remove(container)
    }


    private val rand = Random()
    private fun findEmptyId(): Int {
        for (num in rand.ints()) {
            if (!pointerMap.containsKey(num)) {
                return num
            }
        }

        return 0
    }

    override fun save(nbt: NBTTagCompound) {
        TODO("not implemented")
    }

    override fun load(nbt: NBTTagCompound) {
        TODO("not implemented")
    }
}