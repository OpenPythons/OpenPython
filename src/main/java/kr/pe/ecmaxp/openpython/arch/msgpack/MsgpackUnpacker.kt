package kr.pe.ecmaxp.openpython.arch.msgpack

import kr.pe.ecmaxp.openpython.arch.OpenPythonVirtualMachine
import org.msgpack.core.MessagePack
import org.msgpack.value.ValueType


class MsgpackUnpacker(buffer: ByteArray, val vm: OpenPythonVirtualMachine? = null) {
    val unpacker = MessagePack.newDefaultUnpacker(buffer)

    fun unpack(): Any? {
        if (!unpacker.hasNext())
            throw Exception("invalid unpack")

        unpacker.apply {
            return when (nextFormat.valueType) {
                null -> throw Exception()
                ValueType.NIL -> unpackNil()
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
                ValueType.EXTENSION -> {
                    val ext = unpackExtensionTypeHeader()
                    val payload = readPayload(ext.length)
                    when (ext.type.toInt() and 0xFF) {
                        1 -> {
                            val unpacker = MsgpackUnpacker(payload, vm)
                            val pointer = unpacker.unpack() as Int
                            vm!!.state.valueMap[pointer]
                        }
                        else -> TODO()
                    }
                }
                else -> throw Exception()
            }
        }

        throw Exception()
    }

    fun unpackObj(): Any? {
        val value = unpack()
        finish()
        return value
    }

    private fun finish() {
        if (unpacker.hasNext())
            throw Exception("too many argument")
    }
}

