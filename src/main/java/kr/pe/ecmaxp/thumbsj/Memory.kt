package kr.pe.ecmaxp.thumbsj

import kr.pe.ecmaxp.thumbsj.exc.InvalidMemoryException
import java.util.*

class Memory {
    private val _list = ArrayList<MemoryRegion>()

    // cached
    private var _execPage: MemoryRegion? = null
    private var _readPage: MemoryRegion? = null
    private var _writePage: MemoryRegion? = null

    @Throws(InvalidMemoryException::class)
    fun map(address: Long, size: Int, hook: (address: Long, read: Boolean, size: Int, value: Int) -> Int) {
        val region = MemoryRegion(address, size, hook)
        _list.add(region)
    }

    @Throws(InvalidMemoryException::class)
    fun map(address: Long, size: Int, flag: MemoryFlag) {
        val region = MemoryRegion(address, size, flag)
        _list.add(region)

        if (region.flag == MemoryFlag.RX) {
            if (_execPage != null) {
                throw InvalidMemoryException(region.begin)
            }

            _execPage = region
        }
    }

    @Throws(InvalidMemoryException::class)
    fun readBuffer(address: Int, size: Int): ByteArray {
        val addr = Integer.toUnsignedLong(address)
        _readPage = updateCache(_readPage, addr, size.toLong())
        val page = _readPage!!

        if (page.flag != MemoryFlag.RX && page.flag != MemoryFlag.RW)
            throw InvalidMemoryException(addr)

        val buffer = ByteArray(size)
        System.arraycopy(page.buffer, (addr - page.begin).toInt(), buffer, 0, size)
        return buffer
    }

    @Throws(InvalidMemoryException::class)
    fun writeBuffer(address: Int, buffer: ByteArray) {
        val size = buffer.size
        val addr = Integer.toUnsignedLong(address)
        _writePage = updateCache(_writePage, addr, size.toLong())
        val page = _writePage!!

        if (page.flag != MemoryFlag.RX && page.flag != MemoryFlag.RW)
            throw InvalidMemoryException(addr)

        System.arraycopy(buffer, 0, page.buffer, (addr - page.begin).toInt(), size)
    }

    @Throws(InvalidMemoryException::class)
    fun fetchCode(address: Int): Int {
        val size = 2
        val addr = Integer.toUnsignedLong(address)
        _execPage = updateCache(_execPage, addr, size.toLong())
        val page = _execPage!!

        var pos = (addr - page.begin).toInt()

        val bufferCode = page.buffer
        return bufferCode[pos++].toInt() and 0xFF or (bufferCode[pos].toInt() and 0xFF shl 8)
    }

    @Throws(InvalidMemoryException::class)
    fun readInt(address: Int): Int {
        val size = 4
        val addr = Integer.toUnsignedLong(address)
        _readPage = updateCache(_readPage, addr, size.toLong())
        val page = _readPage!!

        if (page.flag == MemoryFlag.HOOK)
            return page.hook(addr, size)

        var pos = (addr - page.begin).toInt()
        val buffer = page.buffer
        return (buffer[pos++].toInt() and 0xFF) or
                (buffer[pos++].toInt() and 0xFF shl 8) or
                (buffer[pos++].toInt() and 0xFF shl 16) or
                (buffer[pos].toInt() and 0xFF shl 24)
    }

    @Throws(InvalidMemoryException::class)
    fun readShort(address: Int): Short {
        val size = 2
        val addr = Integer.toUnsignedLong(address)
        _readPage = updateCache(_readPage, addr, size.toLong())
        val page = _readPage!!

        if (page.flag == MemoryFlag.HOOK)
            return page.hook(addr, size).toShort()

        var pos = (addr - page.begin).toInt()

        val buffer = page.buffer
        return (buffer[pos++].toInt() and 0xFF or (buffer[pos].toInt() and 0xFF shl 8)).toShort()
    }

    @Throws(InvalidMemoryException::class)
    fun readByte(address: Int): Byte {
        val size = 1
        val addr = Integer.toUnsignedLong(address)
        _readPage = updateCache(_readPage, addr, size.toLong())
        val page = _readPage!!

        if (page.flag == MemoryFlag.HOOK)
            return page.hook(addr, size).toByte()

        val pos = (addr - page.begin).toInt()
        val buffer = page.buffer
        return buffer[pos]
    }

    @Throws(InvalidMemoryException::class)
    fun writeInt(address: Int, value: Int) {
        val size = 4
        val addr = Integer.toUnsignedLong(address)
        _writePage = updateCache(_writePage, addr, size.toLong())
        val page = _writePage!!

        if (page.flag == MemoryFlag.HOOK) {
            page.hook(addr, size, value)
            return
        }

        var pos = (addr - page.begin).toInt()
        val buffer = page.buffer
        buffer[pos++] = value.toByte()
        buffer[pos++] = (value shr 8).toByte()
        buffer[pos++] = (value shr 16).toByte()
        buffer[pos] = (value shr 24).toByte()
    }

    @Throws(InvalidMemoryException::class)
    fun writeShort(address: Int, shortValue: Short) {
        val size = 2
        val addr = Integer.toUnsignedLong(address)
        val value = shortValue.toInt() and 0xFFFF
        _writePage = updateCache(_writePage, addr, size.toLong())
        val page = _writePage!!

        if (page.flag == MemoryFlag.HOOK) {
            page.hook(addr, size, value)
            return
        }

        var pos = (addr - page.begin).toInt()
        val buffer = page.buffer
        buffer[pos++] = value.toByte()
        buffer[pos] = (value shr 8).toByte()
    }

    @Throws(InvalidMemoryException::class)
    fun writeByte(address: Int, byteValue: Byte) {
        val size = 1
        val addr = Integer.toUnsignedLong(address)
        _writePage = updateCache(_writePage, addr, size.toLong())
        val page = _writePage!!

        if (page.flag == MemoryFlag.HOOK) {
            page.hook(addr, size, byteValue.toInt() and 0xFF)
            return
        }

        val pos = (address - page.begin).toInt()
        val buffer = page.buffer
        buffer[pos] = byteValue
    }

    @Throws(InvalidMemoryException::class)
    private fun updateCache(region: MemoryRegion?, address: Long, size: Long): MemoryRegion {
        return if (region != null && region.begin <= address && address + size <= region.end) {
            region
        } else {
            findRegion(address, size)
        }

    }

    @Throws(InvalidMemoryException::class)
    fun findRegion(address: Long, size: Long): MemoryRegion {
        for (page in _list) {
            if (!(page.begin <= address && address + size <= page.end)) continue
            return page
        }

        throw InvalidMemoryException(address)
    }
}
