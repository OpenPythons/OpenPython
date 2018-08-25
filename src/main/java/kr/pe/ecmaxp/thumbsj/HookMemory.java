package kr.pe.ecmaxp.thumbsj;

public interface HookMemory
{
    int Invoke(long addr, boolean b, int size, int value);
}
