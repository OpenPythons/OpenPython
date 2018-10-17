package kr.pe.ecmaxp.openpython.arch.types.call

import li.cil.oc.api.machine.Arguments
import net.minecraft.item.ItemStack

class ArgumentsImpl(val args: MutableList<Any?>) : Arguments {
    constructor (args: Array<*>) : this(args.toMutableList())

    override fun iterator(): MutableIterator<Any?> = args.iterator()
    override fun count(): Int = args.size
    override fun toArray(): Array<Any?> = args.toTypedArray()


    private inline fun <reified T> checkValue(index: Int, name: String): T {
        if (index < 0)
            throw IndexOutOfBoundsException()
        else if (args.size <= index)
        //                                 li.cil.oc.server.machine.ArgumentsImpl
            throw IllegalArgumentException("bad arguments #${index + 1} ($name expected, got no value)")

        val value = args[index]
        return if (value is T) value
        else throw typeError(index, value, name)
    }

    override fun checkAny(index: Int): Any? = checkValue(index, "value")
    override fun checkBoolean(index: Int): Boolean = checkValue(index, "boolean")
    override fun checkInteger(index: Int): Int = checkValue(index, "number")
    override fun checkDouble(index: Int): Double = checkValue(index, "number")
    override fun checkString(index: Int): String = checkValue(index, "string")
    override fun checkByteArray(index: Int): ByteArray = checkValue(index, "string")
    override fun checkTable(index: Int): MutableMap<Any?, Any?> = checkValue(index, "table")
    override fun checkItemStack(index: Int): ItemStack = checkValue(index, "itemstack") // WHAT?


    private inline fun <reified T> optValue(index: Int, name: String, default: T): T {
        if (index < 0 || args.size <= index)
            return default

        val value = args[index]
        return if (value != null && value is T) value else default
    }

    override fun optAny(index: Int, default: Any?): Any? = optValue(index, "hello", default)
    override fun optBoolean(index: Int, default: Boolean): Boolean = optValue(index, "hello", default)
    override fun optInteger(index: Int, default: Int): Int = optValue(index, "hello", default)
    override fun optDouble(index: Int, default: Double): Double = optValue(index, "hello", default)
    override fun optString(index: Int, default: String): String = optValue(index, "hello", default)
    override fun optByteArray(index: Int, default: ByteArray): ByteArray = optValue(index, "hello", default)
    override fun optTable(index: Int, default: MutableMap<Any?, Any?>): MutableMap<Any?, Any?> = optValue(index, "hello", default)
    override fun optItemStack(index: Int, default: ItemStack): ItemStack = optValue(index, "hello", default)


    private fun safeValue(index: Int): Any? = if (0 < index && index < args.size) null else args[index]

    override fun isBoolean(index: Int): Boolean {
        val value = safeValue(index) ?: return false
        return when (value) {
            is Boolean -> true
            else -> false
        }
    }

    override fun isInteger(index: Int): Boolean {
        val value = safeValue(index) ?: return false
        return when (value) {
            is Byte -> true
            is Short -> true
            is Int -> true
            is Long -> true
            is Double -> true
            else -> false
        }
    }

    override fun isDouble(index: Int): Boolean {
        val value = safeValue(index)
        return when (value) {
            is Float -> true
            is Double -> true
            else -> false
        }
    }

    override fun isString(index: Int): Boolean {
        val value = safeValue(index)
        return when (value) {
            is String -> true
            is ByteArray -> true
            else -> false
        }
    }

    override fun isByteArray(index: Int): Boolean {
        val value = safeValue(index)
        return when (value) {
            is String -> true
            is ByteArray -> true
            else -> false
        }
    }

    override fun isTable(index: Int): Boolean {
        val value = safeValue(index)
        return when (value) {
            is Map<*, *> -> true
            is MutableMap<*, *> -> true
            else -> false
        }
    }

    override fun isItemStack(index: Int): Boolean {
        val value = safeValue(index)
        return false // TODO: ?
    }


    // li.cil.oc.server.machine.ArgumentsImpl
    private fun typeError(index: Int, have: Any?, want: String) =
            IllegalArgumentException("bad argument #${index + 1} ($want expected, got ${typeName(have)})")

    // li.cil.oc.server.machine.ArgumentsImpl
    private fun typeName(value: Any?): String {
        return when (value) {
            null -> "nil"
            is Boolean -> "boolean"
            is Number -> "double"
            is String -> "string"
            is ByteArray -> "string"
            is Map<*, *> -> "table"
            is MutableMap<*, *> -> "table"
            else -> value.javaClass.simpleName
        }
    }
}