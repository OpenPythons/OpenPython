package kr.pe.ecmaxp.thumbsj;

import kr.pe.ecmaxp.thumbsj.exc.InvalidMemoryException;
import kr.pe.ecmaxp.thumbsj.signal.ControlPauseSignal;
import kr.pe.ecmaxp.thumbsj.signal.ControlStopSignal;

public interface InterruptHandler
{
    void invoke(int imm) throws InvalidMemoryException, ControlStopSignal, ControlPauseSignal;
}
