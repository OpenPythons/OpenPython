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
        return ((address - begin) / 4).toInt()
    }
}
