package kr.pe.ecmaxp.thumbsf

import kr.pe.ecmaxp.thumbsf.exc.InvalidMemoryException

class MemoryRegion(val begin: Long, val size: Int, val flag: MemoryFlag) {
    val end: Long
    internal val buffer: IntArray
    internal var Hook: MemoryHook? = null

    init {
        if (size % 4 != 0)
            throw Exception("invalid memory size")

        end = begin + size
        buffer = IntArray(size / 4)
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

    fun loadKey(address: Long): Int {
        return ((address - begin) shr 2).toInt()
    }

    @Throws(InvalidMemoryException::class)
    fun readBuffer(address: Int, size: Int): ByteArray {
        val addr = Integer.toUnsignedLong(address)

        if (flag != MemoryFlag.RX && flag != MemoryFlag.RW)
            throw InvalidMemoryException(addr)

        val buffer = ByteArray(size)
        for (i in 0 until size) {
            buffer[i] = readByte(address + i)
        }

        return buffer
    }

    @Throws(InvalidMemoryException::class)
    fun writeBuffer(address: Int, buffer: ByteArray) {
        val size = buffer.size
        val addr = Integer.toUnsignedLong(address)

        if (flag != MemoryFlag.RX && flag != MemoryFlag.RW)
            throw InvalidMemoryException(addr)

        for (i in 0 until size) {
            writeByte(address + i, buffer[i])
        }

        // legacyMemory.writeBuffer(address, buffer)
        // val legacyBuf = legacyMemory.readBuffer(address, size)
        // if (!legacyBuf.contentEquals(buffer)) throw Exception()

        // System.arraycopy(buffer, 0, buffer, (addr - begin).toInt(), size)
    }

    @Throws(InvalidMemoryException::class)
    fun fetchCode(address: Int): Int {
        val size = 2
        val addr = Integer.toUnsignedLong(address)

        val pos = loadKey(addr)
        val bufferCode = buffer
        val mvalue = bufferCode[pos]
        val rvalue = when (addr % 4) {
            0L -> mvalue and 0xFFFF
            2L -> (mvalue shr 16) and 0xFFFF
            else -> throw Exception("not align")
        }

        // if (legacyMemory.fetchCode(address) != rvalue) throw Exception()
        return rvalue
    }

    @Throws(InvalidMemoryException::class)
    fun readInt(address: Int): Int {
        val size = 4
        val addr = Integer.toUnsignedLong(address)

        val rvalue = when (flag) {
            MemoryFlag.HOOK -> {
                hook(addr, size)
            }
            else -> {
                val pos = loadKey(addr)
                val buffer = buffer
                val mvalue = buffer[pos]
                when (addr % 4) {
                    0L ->
                        mvalue
                    else -> throw Exception("not align")
                }
            }
        }

        // if (legacyMemory.readInt(address) != rvalue) throw Exception()
        return rvalue
    }

    @Throws(InvalidMemoryException::class)
    fun readShort(address: Int): Short {
        val size = 2
        val addr = Integer.toUnsignedLong(address)

        val rvalue = when (flag) {
            MemoryFlag.HOOK -> {
                hook(addr, size).toShort()
            }
            else -> {
                val pos = loadKey(addr)
                val buffer = buffer
                val mvalue = buffer[pos]
                when (addr % 4) {
                    0L ->
                        mvalue.toShort()
                    2L ->
                        (mvalue shr 16).toShort()
                    else -> throw Exception("not align")
                }
            }
        }

        // if (legacyMemory.readShort(address) != rvalue) throw Exception()
        return rvalue
    }

    @Throws(InvalidMemoryException::class)
    fun readByte(address: Int): Byte {
        val size = 1
        val addr = Integer.toUnsignedLong(address)

        val rvalue = when (flag) {
            MemoryFlag.HOOK -> {
                hook(addr, size).toByte()
            }
            else -> {
                val pos = loadKey(addr)
                val buffer = buffer
                val mvalue = buffer[pos]
                when (addr % 4) {
                    0L ->
                        mvalue.toByte()
                    1L ->
                        (mvalue shr 8).toByte()
                    2L ->
                        (mvalue shr 16).toByte()
                    3L ->
                        (mvalue shr 24).toByte()
                    else -> throw Exception("not align")
                }
            }
        }

        return rvalue
    }

    @Throws(InvalidMemoryException::class)
    fun writeInt(address: Int, value: Int) {
        val size = 4
        val addr = Integer.toUnsignedLong(address)

        // legacyMemory.writeInt(address, value)
        when (flag) {
            MemoryFlag.HOOK -> {
                hook(addr, size, value)
            }
            else -> {
                val pos = loadKey(addr)
                val buffer = buffer
                buffer[pos] = when (addr % 4) {
                    0L ->
                        value
                    else -> throw Exception("not align")
                }
            }
        }
    }

    @Throws(InvalidMemoryException::class)
    fun writeShort(address: Int, shortValue: Short) {
        val size = 2
        val addr = Integer.toUnsignedLong(address)
        val value = shortValue.toInt() and 0xFFFF

        when (flag) {
            MemoryFlag.HOOK -> {
                hook(addr, size, value)
            }
            else -> {
                val pos = loadKey(addr)
                val buffer = buffer
                val mvalue = buffer[pos]
                buffer[pos] = when (addr % 4) {
                    0L ->
                        (mvalue and 0xFFFF.inv()) or value
                    2L ->
                        (mvalue and 0xFFFF) or (value shl 16)
                    else -> throw Exception("not align")
                }
            }
        }
    }

    @Throws(InvalidMemoryException::class)
    fun writeByte(address: Int, byteValue: Byte) {
        val size = 1
        val addr = Integer.toUnsignedLong(address)
        val value = byteValue.toInt() and 0xFF
        
        when (flag) {
            MemoryFlag.HOOK -> {
                hook(addr, size, value)
            }
            else -> {
                val pos = loadKey(addr)
                val buffer = buffer
                val mvalue = buffer[pos]
                buffer[pos] = when (addr % 4) {
                    0L ->
                        (mvalue and 0x000000FF.inv()) or value
                    1L ->
                        (mvalue and 0x0000FF00.inv()) or (value shl 8)
                    2L ->
                        (mvalue and 0x00FF0000.inv()) or (value shl 16)
                    3L ->
                        (mvalue and 0x00FFFFFF) or (value shl 24)
                    else -> throw Exception("not align")
                }
            }
        }
    }
}
