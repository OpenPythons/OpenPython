package kr.pe.ecmaxp.thumbsj

import kr.pe.ecmaxp.thumbsj.exc.InvalidMemoryException
import kr.pe.ecmaxp.thumbsj.signal.ControlPauseSignal
import kr.pe.ecmaxp.thumbsj.signal.ControlStopSignal

interface InterruptHandler {
    @Throws(InvalidMemoryException::class, ControlStopSignal::class, ControlPauseSignal::class)
    operator fun invoke(imm: Int)
}
