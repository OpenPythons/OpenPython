package kr.pe.ecmaxp.thumbsk.exc

class InvalidMemoryException(private val addr: Long) : Exception(String.format("memory access in %08X", addr))
