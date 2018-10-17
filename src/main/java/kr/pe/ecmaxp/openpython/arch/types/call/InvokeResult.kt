package kr.pe.ecmaxp.openpython.arch.types.call

import java.util.*

class InvokeResult(val args: Array<Any?>? = null, val error: Throwable? = null) {
    override fun toString(): String = "InvokeResult(args=${Arrays.toString(args)}, error=$error)"
}
