package kr.pe.ecmaxp.thumbsf

import kr.pe.ecmaxp.thumbsf.exc.InvalidMemoryException

class MemoryRegion(val begin: Int, val size: Int, val flag: MemoryFlag) {
    val end: Int = begin + size
    internal val buffer: ByteArray = ByteArray(size)

    override fun toString(): String {
        return "MemoryRegion(begin=$begin, size=$size, flag=$flag)"
    }

    fun valid(address: Int, size: Int): Boolean {
        return begin <= address && address + size <= end
    }

    @Throws(InvalidMemoryException::class)
    fun readBuffer(address: Int, size: Int): ByteArray {
        if (flag != MemoryFlag.RX && flag != MemoryFlag.RW)
            throw InvalidMemoryException(address)

        val pos = loadKey(address, size)
        return buffer.copyOfRange(pos, pos + size)
    }

    @Throws(InvalidMemoryException::class)
    fun writeBuffer(address: Int, buf: ByteArray) {
        if (flag != MemoryFlag.RX && flag != MemoryFlag.RW)
            throw InvalidMemoryException(address)

        val size = buf.size
        val pos = loadKey(address, size)
        System.arraycopy(buf, 0, buffer, pos, size)
    }

    private fun loadKey(address: Int, size: Int): Int {
        val key = address - begin
        if (key < 0 || end < address + size)
            throw InvalidMemoryException(address)

        return key
    }

    @Throws(InvalidMemoryException::class)
    fun readInt(address: Int): Int {
        var pos = loadKey(address, 4)
        val buf = buffer
        return (buf[pos++].toInt() and 0xFF) or
                (buf[pos++].toInt() and 0xFF shl 8) or
                (buf[pos++].toInt() and 0xFF shl 16) or
                (buf[pos].toInt() and 0xFF shl 24)
    }

    @Throws(InvalidMemoryException::class)
    fun readShort(address: Int): Short {
        var pos = loadKey(address, 2)
        val buf = buffer
        return ((buf[pos++].toInt() and 0xFF) or
                (buf[pos].toInt() shl 8)).toShort()
    }

    @Throws(InvalidMemoryException::class)
    fun readByte(address: Int): Byte {
        val pos = loadKey(address, 1)
        val buf = buffer
        return buf[pos]
    }

    @Throws(InvalidMemoryException::class)
    fun writeInt(address: Int, value: Int) {
        var pos = loadKey(address, 4)
        val buf = buffer
        buf[pos++] = value.toByte()
        buf[pos++] = (value shr 8).toByte()
        buf[pos++] = (value shr 16).toByte()
        buf[pos] = (value shr 24).toByte()
    }

    @Throws(InvalidMemoryException::class)
    fun writeShort(address: Int, shortValue: Short) {
        var pos = loadKey(address, 2)
        val buf = buffer
        buf[pos++] = shortValue.toByte()
        buf[pos] = (shortValue.toInt() shr 8).toByte()
    }

    @Throws(InvalidMemoryException::class)
    fun writeByte(address: Int, byteValue: Byte) {
        val pos = loadKey(address, 1)
        val buf = buffer
        buf[pos] = byteValue
    }
}
