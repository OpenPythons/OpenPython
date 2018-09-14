package kr.pe.ecmaxp.thumbsj

interface MemoryHook {
    fun Invoke(address: Long, read: Boolean, size: Int, value: Int): Int
}
