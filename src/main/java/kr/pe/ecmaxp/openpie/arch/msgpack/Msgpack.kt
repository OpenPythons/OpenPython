package kr.pe.ecmaxp.openpie.arch.msgpack

import kr.pe.ecmaxp.openpie.arch.OpenPieVirtualMachine

class Msgpack(val vm: OpenPieVirtualMachine? = null) {
    fun loads(buffer: ByteArray): Any? {
        val unpacker = MsgpackUnpacker(buffer, vm)
        return unpacker.unpackObj()
    }

    fun dumps(o: Any?): ByteArray {
        val packer = MsgpackPacker(vm)
        packer.pack(o)
        return packer.toByteArray()
    }
}