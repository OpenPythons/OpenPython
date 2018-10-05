package kr.pe.ecmaxp.thumbsf

import kr.pe.ecmaxp.thumbsf.consts.ERROR
import kr.pe.ecmaxp.thumbsf.consts.NULL
import kr.pe.ecmaxp.thumbsf.exc.InvalidMemoryException
import kr.pe.ecmaxp.thumbsf.exc.UnexceptedLogicError
import kr.pe.ecmaxp.thumbsf.exc.UnknownInstructionException
import kr.pe.ecmaxp.thumbsf.exc.UnsupportedInstructionException
import java.nio.charset.StandardCharsets
import java.util.*

class Memory(private val _list: ArrayList<MemoryRegion> = ArrayList()) {
    fun fork(): Memory {
        return Memory(_list)
    }

    private var _execPage: MemoryRegion? = null
    private var _readPage: MemoryRegion? = null
    private var _writePage: MemoryRegion? = null
    private var _execCache: IntArray? = null

    fun copy(): Memory {
        val memory = Memory()
        for (region in _list) {
            if (region.flag == MemoryFlag.HOOK) {
                memory.map(region)
            } else {
                val newRegion = MemoryRegion(region.begin, region.size, region.flag)
                val size = region.buffer.size
                System.arraycopy(region.buffer, 0, newRegion.buffer, 0, size)

                memory.map(newRegion)
            }
        }

        return memory;
    }

    private fun map(region: MemoryRegion) {
        _list.add(region)

        if (region.flag == MemoryFlag.RX) {
            if (_execPage != null) {
                throw InvalidMemoryException(region.begin)
            }

            _execPage = region
        }
    }

    @Throws(InvalidMemoryException::class)
    fun flash(address: Int, size: Int, firmware: ByteArray) {
        map(address, size, MemoryFlag.RX)
        writeBuffer(address, firmware)
        loadExecCache(address)
    }

    @Throws(InvalidMemoryException::class)
    fun map(address: Int, size: Int, hook: (address: Long, read: Boolean, size: Int, value: Int) -> Int) {
        // TODO: MemoryHookRegion
        map(MemoryRegion(address, size, hook))
    }

    @Throws(InvalidMemoryException::class)
    fun map(address: Int, size: Int, flag: MemoryFlag) {
        // TODO: MemoryBufferRegion
        map(MemoryRegion(address, size, flag))
    }

    @Throws(InvalidMemoryException::class)
    fun readBuffer(address: Int, size: Int): ByteArray {
        val page = updateCache(_readPage, address, size)
        _readPage = page

        return page.readBuffer(address, size)
    }

    @Throws(InvalidMemoryException::class)
    fun writeBuffer(address: Int, buffer: ByteArray) {
        val size = buffer.size
        val page = updateCache(_writePage, address, size)
        _writePage = page

        return page.writeBuffer(address, buffer)
    }

    @Throws(InvalidMemoryException::class)
    fun readString(address: Int, maxSize: Int): String {
        val region = findRegion(address, 0)
        if (region.flag == MemoryFlag.HOOK)
            throw InvalidMemoryException(address)

        var size = Math.min(region.end - address, maxSize)
        val buffer = ByteArray(size)

        for (pos in 0 until size) {
            val ch = readByte(address + pos)
            buffer[pos] = ch
            if (ch == 0.toByte()) {
                size = pos
                break
            }
        }

        return String(buffer, 0, size, StandardCharsets.UTF_8)
    }

    @Throws(InvalidMemoryException::class)
    fun fetchCode(address: Int): Int {
        val page = updateCache(_execPage, address, 2)
        _execPage = page

        return page.readShort(address).toInt() and 0xFFFF
    }

    @Throws(InvalidMemoryException::class)
    fun readInt(address: Int): Int {
        val page = updateCache(_readPage, address, 4)
        _readPage = page

        return page.readInt(address)
    }

    @Throws(InvalidMemoryException::class)
    fun readShort(address: Int): Short {
        val page = updateCache(_readPage, address, 2)
        _readPage = page

        return page.readShort(address)
    }

    @Throws(InvalidMemoryException::class)
    fun readByte(address: Int): Byte {
        val page = updateCache(_readPage, address, 1)
        _readPage = page

        return page.readByte(address)
    }

    @Throws(InvalidMemoryException::class)
    fun writeInt(address: Int, value: Int) {
        val page = updateCache(_writePage, address, 4)
        _writePage = page

        return page.writeInt(address, value)
    }

    @Throws(InvalidMemoryException::class)
    fun writeShort(address: Int, shortValue: Short) {
        val page = updateCache(_writePage, address, 2)
        _writePage = page

        return page.writeShort(address, shortValue)
    }

    @Throws(InvalidMemoryException::class)
    fun writeByte(address: Int, byteValue: Byte) {
        val page = updateCache(_writePage, address, 1)
        _writePage = page

        return page.writeByte(address, byteValue)
    }

    @Throws(InvalidMemoryException::class)
    private fun updateCache(region: MemoryRegion?, address: Int, size: Int): MemoryRegion {
        return if (region != null && region.begin <= address && address + size <= region.end) {
            region
        } else {
            findRegion(address, size)
        }

    }

    @Throws(InvalidMemoryException::class)
    fun findRegion(address: Int, size: Int): MemoryRegion {
        for (page in _list) {
            if (!(page.begin <= address && address + size <= page.end)) continue
            return page
        }

        throw InvalidMemoryException(address)
    }

    fun loadExecCache(pc: Int): Pair<IntArray, Int> {
        val region = findRegion(pc, 2)
        val base = region.begin
        if (region.flag != MemoryFlag.RX)
            throw InvalidMemoryException(pc)

        if (_execCache == null) {
            _execCache = IntArray(region.size)

            val buffer = _execCache!!
            for (addr in region.begin until region.end step 2) {
                var result: Pair<Int, Int>

                try {
                    result = decode(this, addr)
                } catch (e: UnknownInstructionException) {
                    result = insni(ERROR, buffer[addr - region.begin])
                } catch (e: UnsupportedInstructionException) {
                    result = insni(ERROR, buffer[addr - region.begin])
                }

                val (code, imm32) = result

                when (code and 0xFF) {
                    NULL -> throw UnexceptedLogicError()
                }

                buffer[addr - base] = code
                buffer[addr - base + 1] = imm32
            }
        }

        return Pair(_execCache!!, base)
    }
}
