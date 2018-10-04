package kr.pe.ecmaxp.thumbsf

import kr.pe.ecmaxp.thumbsf.exc.InvalidMemoryException

class MemoryRegion(val begin: Long, val size: Int, val flag: MemoryFlag) {
    val start: Int = begin.toInt()
    val end: Long
    internal val buffer: ByteArray
    internal var Hook: MemoryHook? = null

    init {
        if (size % 4 != 0)
            throw Exception("invalid memory size")

        end = begin + size
        buffer = ByteArray(size)
    }

    constructor(begin: Long, size: Int, hook: MemoryHook) : this(begin, size, MemoryFlag.HOOK) {
        Hook = hook
    }

    override fun toString(): String {
        return "MemoryRegion{" +
                "Begin=" + begin +
                ", End=" + end +
                ", Flag=" + flag +
                '}'.toString()
    }

    @Throws(InvalidMemoryException::class)
    private fun hook(address: Long, read: Boolean, size: Int, value: Int): Int {
        if (Hook == null)
            throw InvalidMemoryException(address)

        return Hook!!(address, read, size, value)
    }

    @Throws(InvalidMemoryException::class)
    fun hook(address: Long, size: Int): Int {
        return hook(address, true, size, 0)
    }

    @Throws(InvalidMemoryException::class)
    fun hook(address: Long, size: Int, value: Int) {
        hook(address, false, size, value)
    }

    @Throws(InvalidMemoryException::class)
    fun readBuffer(address: Int, size: Int): ByteArray {
        val addr = Integer.toUnsignedLong(address)

        if (flag != MemoryFlag.RX && flag != MemoryFlag.RW)
            throw InvalidMemoryException(addr)

        val buffer = ByteArray(size)
        for (i in 0 until size)
            buffer[i] = readByte(address + i)

        return buffer
    }

    @Throws(InvalidMemoryException::class)
    fun writeBuffer(address: Int, buffer: ByteArray) {
        val addr = Integer.toUnsignedLong(address)
        val size = buffer.size

        if (flag != MemoryFlag.RX && flag != MemoryFlag.RW)
            throw InvalidMemoryException(addr)

        for (i in 0 until size)
            writeByte(address + i, buffer[i])
    }

    fun loadKey(address: Long): Int = (address - begin).toInt()

    @Throws(InvalidMemoryException::class)
    fun readInt(address: Int): Int {
        val addr = Integer.toUnsignedLong(address)
        val size = 4

        val rvalue = when (flag) {
            MemoryFlag.HOOK -> {
                hook(addr, size)
            }
            else -> {
                var pos = loadKey(addr)
                val buf = buffer
                (buf[pos++].toInt() and 0xFF) or
                        (buf[pos++].toInt() and 0xFF shl 8) or
                        (buf[pos++].toInt() and 0xFF shl 16) or
                        (buf[pos].toInt() and 0xFF shl 24)
            }
        }

        return rvalue
    }

    @Throws(InvalidMemoryException::class)
    fun readShort(address: Int): Short {
        val addr = Integer.toUnsignedLong(address)
        val size = 2

        val rvalue = when (flag) {
            MemoryFlag.HOOK -> {
                hook(addr, size).toShort()
            }
            else -> {
                var pos = loadKey(addr)
                val buf = buffer
                ((buf[pos++].toInt() and 0xFF) or
                        (buf[pos].toInt() shl 8)).toShort()
            }
        }

        return rvalue
    }

    @Throws(InvalidMemoryException::class)
    fun readByte(address: Int): Byte {
        val addr = Integer.toUnsignedLong(address)
        val size = 1

        val rvalue = when (flag) {
            MemoryFlag.HOOK -> {
                hook(addr, size).toByte()
            }
            else -> {
                val pos = loadKey(addr)
                val buf = buffer
                buf[pos]
            }
        }

        return rvalue
    }

    @Throws(InvalidMemoryException::class)
    fun writeInt(address: Int, value: Int) {
        val addr = Integer.toUnsignedLong(address)
        val size = 4

        when (flag) {
            MemoryFlag.HOOK -> {
                hook(addr, size, value)
            }
            else -> {
                var pos = loadKey(addr)
                val buf = buffer
                buf[pos++] = value.toByte()
                buf[pos++] = (value shr 8).toByte()
                buf[pos++] = (value shr 16).toByte()
                buf[pos] = (value shr 24).toByte()
            }
        }
    }

    @Throws(InvalidMemoryException::class)
    fun writeShort(address: Int, shortValue: Short) {
        val addr = Integer.toUnsignedLong(address)
        val size = 2

        when (flag) {
            MemoryFlag.HOOK -> {
                val value = shortValue.toInt() and 0xFFFF
                hook(addr, size, value)
            }
            else -> {
                var pos = loadKey(addr)
                val buf = buffer
                buf[pos++] = shortValue.toByte()
                buf[pos] = (shortValue.toInt() shr 8).toByte()
            }
        }
    }

    @Throws(InvalidMemoryException::class)
    fun writeByte(address: Int, byteValue: Byte) {
        val addr = Integer.toUnsignedLong(address)
        val size = 1

        when (flag) {
            MemoryFlag.HOOK -> {
                val value = byteValue.toInt() and 0xFF
                hook(addr, size, value)
            }
            else -> {
                val pos = loadKey(addr)
                val buf = buffer
                buf[pos] = byteValue
            }
        }
    }
}
