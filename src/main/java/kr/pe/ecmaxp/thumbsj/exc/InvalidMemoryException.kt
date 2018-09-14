package kr.pe.ecmaxp.thumbsj.exc

class InvalidMemoryException(private val addr: Long) : Exception(String.format("memory access in %08X", addr))
