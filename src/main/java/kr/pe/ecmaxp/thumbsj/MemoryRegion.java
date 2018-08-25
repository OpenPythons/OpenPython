package kr.pe.ecmaxp.thumbsj;

import java.util.Arrays;

public class MemoryRegion
{
    private long Begin;
    private long End;
    private byte[] Buffer;

    public MemoryRegion(long begin, long end, byte[] buffer)
    {
        Begin = begin;
        End = end;
        Buffer = buffer;
    }

    public long getBegin()
    {
        return Begin;
    }

    public long getEnd()
    {
        return End;
    }

    public byte[] getBuffer()
    {
        return Buffer;
    }

    @Override
    public String toString()
    {
        return "MemoryRegion{" +
                "Begin=" + Begin +
                ", End=" + End +
                ", Buffer=" + Arrays.toString(Buffer) +
                '}';
    }
}
