package kr.pe.ecmaxp.micropython.example;

import kotlin.Pair;
import kr.pe.ecmaxp.thumbjk.Callback;
import kr.pe.ecmaxp.thumbsk.Memory;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class MicroPython extends MicroPython_main
{
    public MicroPython(@NotNull Memory memory)
    {
        super(memory);
    }

    public MicroPython spawn()
    {
        // same memory, new register
        return new MicroPython(memory);
    }
}