package kr.pe.ecmaxp.openpython.arch.types.interrupt

interface InterruptHandler {
    operator fun invoke(interrupt: Interrupt, synchronized: Boolean)
}
