package kr.pe.ecmaxp.openpie.arch.types.value

class ValueResult(val result: Any? = null, val error: Throwable? = null) {
    override fun toString(): String {
        return "ValueResult(args=${result}, error=$error)"
    }
}
