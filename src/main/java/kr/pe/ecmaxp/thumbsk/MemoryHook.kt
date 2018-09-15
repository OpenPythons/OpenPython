package kr.pe.ecmaxp.thumbsk

typealias MemoryHook = (address: Long, read: Boolean, size: Int, value: Int) -> Int

