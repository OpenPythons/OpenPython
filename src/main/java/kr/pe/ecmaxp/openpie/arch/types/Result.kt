package kr.pe.ecmaxp.openpie.arch.types

class Result {
    val call: Call?
    val args: Array<Any?>?
    val error: Throwable?

    constructor(call: Call?, args: Array<Any?>?) {
        this.call = call
        this.args = args
        this.error = null
    }

    constructor(call: Call?, throwable: Throwable) {
        this.call = call
        this.args = null
        this.error = throwable
    }
}
