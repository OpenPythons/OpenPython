package kr.pe.ecmaxp.openpie.arch.msgpack

import org.msgpack.core.MessagePack
import org.msgpack.value.ValueType


class MsgpackUnpacker(buffer: ByteArray) {
    val unpacker = MessagePack.newDefaultUnpacker(buffer)

    fun unpack(): Any? {
        if (!unpacker.hasNext())
            throw Exception("invalid unpack")

        unpacker.apply {
            return when (nextFormat.valueType) {
                null -> throw Exception()
                ValueType.NIL -> null
                ValueType.BOOLEAN -> unpackBoolean()
                ValueType.INTEGER -> unpackInt()
                ValueType.FLOAT -> unpackFloat()
                ValueType.STRING -> unpackString()
                ValueType.BINARY -> {
                    val length = unpackBinaryHeader()
                    readPayload(length)
                }
                ValueType.ARRAY -> {
                    val length = unpackArrayHeader()
                    val list = arrayOfNulls<Any?>(length)
                    for (i in 0 until length)
                        list[i] = unpack()

                    list
                }
                ValueType.MAP -> {
                    val length = unpackMapHeader()
                    val map = HashMap<Any?, Any?>()
                    for (i in 0 until length)
                        map.put(unpack(), unpack())

                    map
                }
                ValueType.EXTENSION -> TODO()
                else -> throw Exception()
            }
        }

        throw Exception()
    }

    fun unpack_obj(): Any? {
        val value = unpack()
        finish()
        return value
    }

    fun finish() {
        if (unpacker.hasNext())
            throw Exception("too many argument")
    }
}

