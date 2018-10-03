package kr.pe.ecmaxp.openpie.arch.msgpack

import org.msgpack.core.MessagePack
import org.msgpack.value.ValueType


class MsgpackUnpacker(buffer: ByteArray) {
    val unpacker = MessagePack.newDefaultUnpacker(buffer)

    fun unpack(): Any? {
        if (!unpacker.hasNext())
            throw Exception("invalid unpack")

        val format = unpacker.nextFormat
        return when (format.valueType) {
            null -> throw Exception()
            ValueType.NIL -> null
            ValueType.BOOLEAN -> unpacker.unpackBoolean()
            ValueType.INTEGER -> unpacker.unpackInt()
            ValueType.FLOAT -> unpacker.unpackFloat()
            ValueType.STRING -> unpacker.unpackString()
            ValueType.BINARY -> {
                val length = unpacker.unpackBinaryHeader()
                unpacker.readPayload(length)
            }
            ValueType.ARRAY -> {
                val length = unpacker.unpackArrayHeader()
                val list = arrayOfNulls<Any?>(length)
                for (i in 0 until length)
                    list[i] = unpack()

                list
            }
            ValueType.MAP -> {
                val length = unpacker.unpackMapHeader()
                val map = HashMap<Any?, Any?>()
                for (i in 0 until length)
                    map.put(unpack(), unpack())

                map
            }
            ValueType.EXTENSION -> TODO()
        }
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

