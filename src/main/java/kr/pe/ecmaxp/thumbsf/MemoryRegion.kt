package kr.pe.ecmaxp.thumbsf

import kr.pe.ecmaxp.thumbsf.exc.InvalidMemoryException

class MemoryRegion(val begin: Int, val size: Int, val flag: MemoryFlag) {
    val end: Int = begin + size
    internal val buffer: ByteArray = ByteArray(size)
    private var hook: MemoryHook? = null

    constructor(begin: Int, size: Int, hook: MemoryHook) : this(begin, size, MemoryFlag.HOOK) {
        this.hook = hook
    }

    override fun toString(): String {
        return "MemoryRegion(begin=$begin, size=$size, flag=$flag)"
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

        val pos = loadKey(address)
        return buffer.copyOfRange(pos, pos + size)
    }

    @Throws(InvalidMemoryException::class)
    fun writeBuffer(address: Int, buf: ByteArray) {
        if (flag != MemoryFlag.RX && flag != MemoryFlag.RW)
            throw InvalidMemoryException(address)

        val pos = loadKey(address)
        val size = buf.size
        System.arraycopy(buf, 0, buffer, pos, size)
    }

    private fun loadKey(address: Int): Int = address - begin

    @Throws(InvalidMemoryException::class)
    fun readInt(address: Int): Int {
        val size = 4

        val rvalue = when (flag) {
            MemoryFlag.HOOK -> {
                hook(address, size)
            }
            else -> {
                var pos = loadKey(address)
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
        val size = 2

        val rvalue = when (flag) {
            MemoryFlag.HOOK -> {
                hook(address, size).toShort()
            }
            else -> {
                var pos = loadKey(address)
                val buf = buffer
                ((buf[pos++].toInt() and 0xFF) or
                        (buf[pos].toInt() shl 8)).toShort()
            }
        }

        return rvalue
    }

    @Throws(InvalidMemoryException::class)
    fun readByte(address: Int): Byte {
        val size = 1

        val rvalue = when (flag) {
            MemoryFlag.HOOK -> {
                hook(address, size).toByte()
            }
            else -> {
                val pos = loadKey(address)
                val buf = buffer
                buf[pos]
            }
        }

        return rvalue
    }

    @Throws(InvalidMemoryException::class)
    fun writeInt(address: Int, value: Int) {
        val size = 4

        when (flag) {
            MemoryFlag.HOOK -> {
                hook(address, size, value)
            }
            else -> {
                var pos = loadKey(address)
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
        val size = 2

        when (flag) {
            MemoryFlag.HOOK -> {
                val value = shortValue.toInt() and 0xFFFF
                hook(address, size, value)
            }
            else -> {
                var pos = loadKey(address)
                val buf = buffer
                buf[pos++] = shortValue.toByte()
                buf[pos] = (shortValue.toInt() shr 8).toByte()
            }
        }
    }

    @Throws(InvalidMemoryException::class)
    fun writeByte(address: Int, byteValue: Byte) {
        val size = 1

        when (flag) {
            MemoryFlag.HOOK -> {
                val value = byteValue.toInt() and 0xFF
                hook(address, size, value)
            }
            else -> {
                val pos = loadKey(address)
                val buf = buffer
                buf[pos] = byteValue
            }
        }
    }
}
