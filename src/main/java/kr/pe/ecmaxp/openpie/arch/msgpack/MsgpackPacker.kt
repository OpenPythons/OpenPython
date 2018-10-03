package kr.pe.ecmaxp.openpie.arch.msgpack

import li.cil.oc.api.machine.Signal
import org.msgpack.core.MessagePack


class MsgpackPacker {
    val packer = MessagePack.newDefaultBufferPacker()

    fun pack(o: Any?) {
        if (o == null) {
            packer.packNil()
        } else if (o is Boolean) {
            packer.packBoolean(o)
        } else if (o is Int) {
            packer.packInt(o)
        } else if (o is Float) {
            packer.packFloat(o)
        } else if (o is Double) {
            packer.packDouble(o)
        } else if (o is String) {
            packer.packString(o)
        } else if (o is ByteArray) {
            packer.packBinaryHeader(o.size)
            packer.writePayload(o)
        } else if (o is Array<*>) {
            packer.packArrayHeader(o.size)
            for (item in o)
                pack(item)
        } else if (o is Collection<*>) {
            packer.packArrayHeader(o.size)
            for (item in o)
                pack(item)
        } else if (o is Map<*, *>) {
            packer.packMapHeader(o.size)
            for (pair in o) {
                pack(pair.key)
                pack(pair.value)
            }
        } else if (o is Signal) {
            packer.packArrayHeader(2)
            packer.packString(o.name())
            packer.packArrayHeader(o.args().size)
            for (item in o.args()) {
                pack(item)
            }
        } else if (o is Exception || o is Error) {
            packer.packArrayHeader(2)
            packer.packString(o.javaClass.canonicalName)
            packer.packString(o.toString())
        } else {
            throw Exception("mismatch type ${o.javaClass} => $o")
        }
    }

    fun toByteArray(): ByteArray = packer.toByteArray()
}