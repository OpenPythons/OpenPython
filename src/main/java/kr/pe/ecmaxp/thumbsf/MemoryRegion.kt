package kr.pe.ecmaxp.thumbsf

import kr.pe.ecmaxp.thumbsf.exc.InvalidMemoryException

class MemoryRegion(val begin: Int, val size: Int, val flag: MemoryFlag) {
    val end: Int = begin + size
    internal val buffer: ByteArray = ByteArray(size)
    private var hook: MemoryHook? = null
    val isHook = flag == MemoryFlag.HOOK

    constructor(begin: Int, size: Int, hook: MemoryHook) : this(begin, size, MemoryFlag.HOOK) {
        this.hook = hook
    }

    override fun toString(): String {
        return "MemoryRegion(begin=$begin, size=$size, flag=$flag)"
    }

    fun valid(address: Int, size: Int): Boolean {
        return begin <= address && address + size <= end
    }

    @Throws(InvalidMemoryException::class)
    private fun hook(address: Int, read: Boolean, size: Int, value: Int): Int {
        if (hook == null)
            throw InvalidMemoryException(address)

        return hook!!(Integer.toUnsignedLong(address), read, size, value)
    }

    @Throws(InvalidMemoryException::class)
    fun hook(address: Int, size: Int): Int {
        return hook(address, true, size, 0)
    }

    @Throws(InvalidMemoryException::class)
    fun hook(address: Int, size: Int, value: Int) {
        hook(address, false, size, value)
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
        val rvalue = if (isHook) {
            hook(address, 4)
        } else {
            var pos = loadKey(address, 4)
            val buf = buffer
            (buf[pos++].toInt() and 0xFF) or
                    (buf[pos++].toInt() and 0xFF shl 8) or
                    (buf[pos++].toInt() and 0xFF shl 16) or
                    (buf[pos].toInt() and 0xFF shl 24)
        }

        return rvalue
    }

    @Throws(InvalidMemoryException::class)
    fun readShort(address: Int): Short {
        val rvalue = if (isHook) {
            hook(address, 2).toShort()
        } else {
            var pos = loadKey(address, 2)
            val buf = buffer
            ((buf[pos++].toInt() and 0xFF) or
                    (buf[pos].toInt() shl 8)).toShort()
        }

        return rvalue
    }

    @Throws(InvalidMemoryException::class)
    fun readByte(address: Int): Byte {
        val rvalue = if (isHook) {
            hook(address, 1).toByte()
        } else {
            val pos = loadKey(address, 1)
            val buf = buffer
            buf[pos]
        }

        return rvalue
    }

    @Throws(InvalidMemoryException::class)
    fun writeInt(address: Int, value: Int) {
        if (isHook) {
            hook(address, 4, value)
        } else {
            var pos = loadKey(address, 4)
            val buf = buffer
            buf[pos++] = value.toByte()
            buf[pos++] = (value shr 8).toByte()
            buf[pos++] = (value shr 16).toByte()
            buf[pos] = (value shr 24).toByte()
        }
    }

    @Throws(InvalidMemoryException::class)
    fun writeShort(address: Int, shortValue: Short) {
        if (isHook) {
            val value = shortValue.toInt() and 0xFFFF
            hook(address, 2, value)
        } else {
            var pos = loadKey(address, 2)
            val buf = buffer
            buf[pos++] = shortValue.toByte()
            buf[pos] = (shortValue.toInt() shr 8).toByte()
        }
    }

    @Throws(InvalidMemoryException::class)
    fun writeByte(address: Int, byteValue: Byte) {
        if (isHook) {
            val value = byteValue.toInt() and 0xFF
            hook(address, 1, value)
        } else {
            val pos = loadKey(address, 1)
            val buf = buffer
            buf[pos] = byteValue
        }
    }
}
