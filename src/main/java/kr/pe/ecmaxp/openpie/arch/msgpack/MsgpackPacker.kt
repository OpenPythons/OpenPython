package kr.pe.ecmaxp.openpie.arch.msgpack

import li.cil.oc.api.machine.Signal
import org.msgpack.core.MessagePack


class MsgpackPacker {
    val packer = MessagePack.newDefaultBufferPacker()

    fun pack(o: Any?) {
        packer.apply {
            if (o == null) {
                packNil()
            } else if (o is Boolean) {
                packBoolean(o)
            } else if (o is Int) {
                packInt(o)
            } else if (o is Long) {
                packLong(o)
            } else if (o is Float) {
                packFloat(o)
            } else if (o is Double) {
                packDouble(o)
            } else if (o is String) {
                packString(o)
            } else if (o is ByteArray) {
                packBinaryHeader(o.size)
                writePayload(o)
            } else if (o is Array<*>) {
                packArrayHeader(o.size)
                for (item in o)
                    pack(item)
            } else if (o is Collection<*>) {
                packArrayHeader(o.size)
                for (item in o)
                    pack(item)
            } else if (o is Map<*, *>) {
                packMapHeader(o.size)
                for (pair in o) {
                    pack(pair.key)
                    pack(pair.value)
                }
            } else if (o is Signal) {
                packArrayHeader(2)
                packString(o.name())
                packArrayHeader(o.args().size)
                for (item in o.args()) {
                    pack(item)
                }
            } else if (o is Exception || o is Error) {
                packArrayHeader(2)
                packString(o.javaClass.canonicalName)
                packString(o.toString())
            } else {
                val num = o.toString().toIntOrNull()
                if (num != null)
                    packInt(num) // li.cil.oc.server.component.HandleValue
                else
                    throw Exception("mismatch type ${o.javaClass} => $o")
            }
        }

    }

    fun toByteArray(): ByteArray = packer.toByteArray()
}