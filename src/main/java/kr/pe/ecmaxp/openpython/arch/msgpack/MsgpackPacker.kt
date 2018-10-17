package kr.pe.ecmaxp.openpython.arch.msgpack

import kr.pe.ecmaxp.openpython.arch.OpenPythonVirtualMachine
import li.cil.oc.api.machine.Signal
import li.cil.oc.api.machine.Value
import org.msgpack.core.MessagePack


class MsgpackPacker(val vm: OpenPythonVirtualMachine? = null) {
    val packer = MessagePack.newDefaultBufferPacker()!!

    fun toByteArray(): ByteArray = packer.toByteArray()

    fun pack(o: Any?) {
        packer.apply {
            when (o) {
                null -> packNil()
                is Boolean -> packBoolean(o)
                is Int -> packInt(o)
                is Long -> packLong(o)
                is Float -> packFloat(o)
                is Double -> packDouble(o)
                is String -> packString(o)
                is ByteArray -> {
                    packBinaryHeader(o.size)
                    writePayload(o)
                }
                is Array<*> -> {
                    packArrayHeader(o.size)
                    for (item in o)
                        pack(item)
                }
                is Collection<*> -> {
                    packArrayHeader(o.size)
                    for (item in o)
                        pack(item)
                }
                is Map<*, *> -> {
                    packMapHeader(o.size)
                    for (pair in o) {
                        pack(pair.key)
                        pack(pair.value)
                    }
                }
                is scala.collection.mutable.HashMap<*, *> -> {
                    packMapHeader(o.size())
                    for (pair in o) {
                        pack(pair._1)
                        pack(pair._2)
                    }
                }
                is scala.collection.immutable.HashMap<*, *> -> {
                    packMapHeader(o.size())
                    for (pair in o) {
                        pack(pair._1)
                        pack(pair._2)
                    }
                }
                is Signal -> {
                    packArrayHeader(2)
                    packString(o.name())
                    packArrayHeader(o.args().size)
                    for (item in o.args()) {
                        pack(item)
                    }
                }
                is Throwable -> {
                    packArrayHeader(2)
                    packString(o.javaClass.canonicalName)
                    packString(o.toString())
                }
                is Value -> {
                    val packer = MsgpackPacker(vm)
                    packer.pack(vm!!.state.valueMap.register(o).id)
                    val buffer = packer.toByteArray()
                    packExtensionTypeHeader(1, buffer.size)
                    writePayload(buffer)
                }
                else -> {
                    throw Exception("mismatch type ${o.javaClass} => $o")
                }
            }
        }
    }
}