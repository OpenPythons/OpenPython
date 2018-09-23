package kr.pe.ecmaxp.thumbsf

import kr.pe.ecmaxp.thumbsf.consts.ERROR
import kr.pe.ecmaxp.thumbsf.consts.NULL
import kr.pe.ecmaxp.thumbsf.exc.InvalidMemoryException
import kr.pe.ecmaxp.thumbsf.exc.UnexceptedLogicError
import kr.pe.ecmaxp.thumbsf.exc.UnknownInstructionException
import kr.pe.ecmaxp.thumbsf.exc.UnsupportedInstructionException
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
                for (i in 0 until region.buffer.size)
                    newRegion.buffer[i] = region.buffer[i]

                memory.map(newRegion)
            }
        }

        return memory;
    }

    internal fun map(region: MemoryRegion) {
        if (region.size % 4 != 0)
            throw Exception("invalid memory size")

        _list.add(region)

        if (region.flag == MemoryFlag.RX) {
            if (_execPage != null) {
                throw InvalidMemoryException(region.begin)
            }

            _execPage = region
        }
    }

    @Throws(InvalidMemoryException::class)
    fun flash(address: Long, size: Int, firmware: ByteArray) {
        map(address, size, MemoryFlag.RX)
        writeBuffer(address.toInt(), firmware)
        loadExecCache(address.toInt())
    }

    @Throws(InvalidMemoryException::class)
    fun map(address: Long, size: Int, hook: (address: Long, read: Boolean, size: Int, value: Int) -> Int) {
        map(MemoryRegion(address, size, hook))
    }

    @Throws(InvalidMemoryException::class)
    fun map(address: Long, size: Int, flag: MemoryFlag) {
        map(MemoryRegion(address, size, flag))
    }

    @Throws(InvalidMemoryException::class)
    fun readBuffer(address: Int, size: Int): ByteArray {
        val addr = Integer.toUnsignedLong(address)
        val page = updateCache(_readPage, addr, size)
        _readPage = page

        return page.readBuffer(address, size)
    }

    @Throws(InvalidMemoryException::class)
    fun writeBuffer(address: Int, buffer: ByteArray) {
        val size = buffer.size
        val addr = Integer.toUnsignedLong(address)
        val page = updateCache(_writePage, addr, size)
        _writePage = page

        return page.writeBuffer(address, buffer)
    }

    @Throws(InvalidMemoryException::class)
    fun fetchCode(address: Int): Int {
        val size = 2
        val addr = Integer.toUnsignedLong(address)
        val page= updateCache(_execPage, addr, size)
        _execPage = page

        return page.fetchCode(address)
    }

    @Throws(InvalidMemoryException::class)
    fun readInt(address: Int): Int {
        val size = 4
        val addr = Integer.toUnsignedLong(address)
        val page = updateCache(_readPage, addr, size)
        _readPage = page

        return page.readInt(address)
    }

    @Throws(InvalidMemoryException::class)
    fun readShort(address: Int): Short {
        val size = 2
        val addr = Integer.toUnsignedLong(address)
        val page = updateCache(_readPage, addr, size)
        _readPage = page

        return page.readShort(address)
    }

    @Throws(InvalidMemoryException::class)
    fun readByte(address: Int): Byte {
        val size = 1
        val addr = Integer.toUnsignedLong(address)
        val page = updateCache(_readPage, addr, size)
        _readPage = page

        return page.readByte(address)
    }

    @Throws(InvalidMemoryException::class)
    fun writeInt(address: Int, value: Int) {
        val size = 4
        val addr = Integer.toUnsignedLong(address)
        val page = updateCache(_writePage, addr, size)
        _writePage = page

        return page.writeInt(address, value)
    }

    @Throws(InvalidMemoryException::class)
    fun writeShort(address: Int, shortValue: Short) {
        val size = 2
        val addr = Integer.toUnsignedLong(address)
        val page = updateCache(_writePage, addr, size)
        _writePage = page

        return page.writeShort(address, shortValue)
    }

    @Throws(InvalidMemoryException::class)
    fun writeByte(address: Int, byteValue: Byte) {
        val size = 1
        val addr = Integer.toUnsignedLong(address)
        val page = updateCache(_writePage, addr, size)
        _writePage = page

        return page.writeByte(address, byteValue)
    }

    @Throws(InvalidMemoryException::class)
    private fun updateCache(region: MemoryRegion?, address: Long, size: Int): MemoryRegion {
        return if (region != null && region.begin <= address && address + size <= region.end) {
            region
        } else {
            findRegion(address, size)
        }

    }

    @Throws(InvalidMemoryException::class)
    fun findRegion(address: Long, size: Int): MemoryRegion {
        for (page in _list) {
            if (!(page.begin <= address && address + size <= page.end)) continue
            return page
        }

        throw InvalidMemoryException(address)
    }

    fun loadExecCache(pc: Int): Pair<IntArray, Int> {
        val region = findRegion(Integer.toUnsignedLong(pc), 2)
        val base = region.begin.toInt()
        if (_execCache == null) {
            _execCache = IntArray(region.size)

            val buffer = _execCache!!
            for (addr in region.begin.toInt() until region.end.toInt() step 2) {
                var code: Int
                var imm32 = 0

                try {
                    val (first, second) = decode(this, addr)
                    code = first
                    imm32 = second
                } catch (e: UnknownInstructionException) {
                    code = ERROR
                } catch (e: UnsupportedInstructionException) {
                    code = ERROR
                }

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
