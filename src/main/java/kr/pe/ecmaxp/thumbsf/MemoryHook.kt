package kr.pe.ecmaxp.thumbsf

typealias MemoryHook = (address: Long, read: Boolean, size: Int, value: Int) -> Int

