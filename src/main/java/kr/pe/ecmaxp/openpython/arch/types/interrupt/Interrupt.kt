package kr.pe.ecmaxp.openpython.arch.types.interrupt

import kr.pe.ecmaxp.openpython.arch.types.call.InvokeResult

interface Interrupt {
    fun readBuffer(): ByteArray
    fun readBuffer(address: Int, size: Int): ByteArray

    fun readString(): String?
    fun readString(address: Int, maxSize: Int): String

    fun readObject(): Any?

    fun responseNone(): Int
    fun responseResult(ret: InvokeResult): Int
    fun responseValue(value: Any?): Int
    fun responseError(value: Throwable): Int
    fun responseBuffer(buffer: ByteArray): Int
}
