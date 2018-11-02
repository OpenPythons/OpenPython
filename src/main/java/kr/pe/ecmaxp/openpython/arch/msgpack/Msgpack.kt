package kr.pe.ecmaxp.openpython.arch.msgpack

import kr.pe.ecmaxp.openpython.OpenPythonVirtualMachine

class Msgpack(val vm: OpenPythonVirtualMachine? = null) {
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