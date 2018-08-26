package kr.pe.ecmaxp.thumbsj;

public interface MemoryHook
{
    int Invoke(long address, boolean read, int size, int value);
}
