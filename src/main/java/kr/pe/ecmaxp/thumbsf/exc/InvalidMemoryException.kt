package kr.pe.ecmaxp.thumbsf.exc

class InvalidMemoryException(val address: Int) : Exception(String.format("memory access in %08X", address))
