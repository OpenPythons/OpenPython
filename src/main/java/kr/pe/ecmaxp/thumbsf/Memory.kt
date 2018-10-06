package kr.pe.ecmaxp.thumbsf

import kr.pe.ecmaxp.thumbsf.consts.ERROR
import kr.pe.ecmaxp.thumbsf.consts.NULL
import kr.pe.ecmaxp.thumbsf.exc.InvalidMemoryException
import kr.pe.ecmaxp.thumbsf.exc.UnexceptedLogicError
import kr.pe.ecmaxp.thumbsf.exc.UnknownInstructionException
import kr.pe.ecmaxp.thumbsf.exc.UnsupportedInstructionException
import java.nio.charset.StandardCharsets

val EmptyPage = MemoryRegion(0, 0, MemoryFlag.RW)

class Memory(private val _list: Array<MemoryRegion> = Array(256) { EmptyPage }): Iterable<MemoryRegion> {
    private var _execCache: IntArray? = null

    override fun iterator(): Iterator<MemoryRegion> {
        val list = ArrayList<MemoryRegion>()
        for (region in _list.iterator()) {
            if (region != EmptyPage)
                list.add(region)
        }

        return list.iterator()
    }

    fun fork(): Memory {
        return Memory(_list)
    }

    fun copy(): Memory {
        val memory = Memory()
        for (region in _list) {
            if (region == EmptyPage)
                continue;

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

    @Throws(InvalidMemoryException::class)
    private fun map(region: MemoryRegion) {
        val key = region.begin ushr 24
        if (_list[key] != EmptyPage)
            throw InvalidMemoryException(region.begin)

        if (region.begin shl 8 ushr 24 != 0)
            throw InvalidMemoryException(region.begin)

        _list[key] = region
    }

    @Throws(InvalidMemoryException::class)
    fun map(address: Int, size: Int, hook: (address: Long, read: Boolean, size: Int, value: Int) -> Int) = map(MemoryRegion(address, size, hook))

    @Throws(InvalidMemoryException::class)
    fun map(address: Int, size: Int, flag: MemoryFlag) = map(MemoryRegion(address, size, flag))

    @Throws(InvalidMemoryException::class)
    fun flash(address: Int, size: Int, firmware: ByteArray) {
        map(address, size, MemoryFlag.RX)
        writeBuffer(address, firmware)
        loadExecCache(address)
    }

    private fun findRegion(address: Int): MemoryRegion = _list[address ushr 24]

    @Throws(InvalidMemoryException::class)
    fun readBuffer(address: Int, size: Int): ByteArray = findRegion(address).readBuffer(address, size)

    @Throws(InvalidMemoryException::class)
    fun writeBuffer(address: Int, buffer: ByteArray) = findRegion(address).writeBuffer(address, buffer)

    @Throws(InvalidMemoryException::class)
    fun readString(address: Int, maxSize: Int): String {
        val region = findRegion(address)
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
    fun fetchCode(address: Int): Int = findRegion(address).readShort(address).toInt() and 0xFFFF

    @Throws(InvalidMemoryException::class)
    fun readInt(address: Int): Int = findRegion(address).readInt(address)

    @Throws(InvalidMemoryException::class)
    fun readShort(address: Int): Short = findRegion(address).readShort(address)

    @Throws(InvalidMemoryException::class)
    fun readByte(address: Int): Byte = findRegion(address).readByte(address)

    @Throws(InvalidMemoryException::class)
    fun writeInt(address: Int, value: Int) = findRegion(address).writeInt(address, value)

    @Throws(InvalidMemoryException::class)
    fun writeShort(address: Int, shortValue: Short) = findRegion(address).writeShort(address, shortValue)

    @Throws(InvalidMemoryException::class)
    fun writeByte(address: Int, byteValue: Byte) = findRegion(address).writeByte(address, byteValue)

    @Throws(InvalidMemoryException::class)
    fun loadExecCache(pc: Int): Pair<IntArray, Int> {
        val region = findRegion(pc)
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
                    result = insnx(ERROR, this.fetchCode(addr))
                } catch (e: UnsupportedInstructionException) {
                    result = insnx(ERROR, this.fetchCode(addr))
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
