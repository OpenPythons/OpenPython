package kr.pe.ecmaxp.thumbsj

typealias MemoryHook = (address: Long, read: Boolean, size: Int, value: Int) -> Int

