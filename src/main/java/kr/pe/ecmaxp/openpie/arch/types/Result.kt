package kr.pe.ecmaxp.openpie.arch.types

import java.util.*

class Result(val invoke: Invoke, val args: Array<Any?>? = null, val error: Throwable? = null) {
    override fun toString(): String {
        return "Result(invoke=$invoke, args=${Arrays.toString(args)}, error=$error)"
    }
}
