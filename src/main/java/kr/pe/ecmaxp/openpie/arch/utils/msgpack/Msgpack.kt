package kr.pe.ecmaxp.openpie.arch.utils.msgpack

object Msgpack {
    fun loads(buffer: ByteArray): Any? {
        val unpacker = MsgpackUnpacker(buffer)
        return unpacker.unpack_obj()
    }

    fun dumps(o: Any?): ByteArray {
        val packer = MsgpackPacker()
        packer.pack(o)
        return packer.toByteArray()
    }
}