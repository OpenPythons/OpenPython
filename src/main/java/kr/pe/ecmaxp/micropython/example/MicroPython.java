package kr.pe.ecmaxp.micropython.example;

import kr.pe.ecmaxp.thumbsk.Memory;
import org.jetbrains.annotations.NotNull;

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