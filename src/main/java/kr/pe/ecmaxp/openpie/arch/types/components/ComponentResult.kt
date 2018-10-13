package kr.pe.ecmaxp.openpie.arch.types.components

import java.util.*

class ComponentResult(val args: Array<Any?>? = null, val error: Throwable? = null) {
    override fun toString(): String {
        return "ComponentResult(args=${Arrays.toString(args)}, error=$error)"
    }
}
