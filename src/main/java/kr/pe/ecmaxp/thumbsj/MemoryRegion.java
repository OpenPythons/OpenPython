package kr.pe.ecmaxp.thumbsj;

import kr.pe.ecmaxp.thumbsj.exc.InvalidMemoryException;

import java.util.Arrays;

public class MemoryRegion
{
    private long Begin;
    private long End;
    private byte[] Buffer;
    private MemoryFlag Flag;
    private MemoryHook Hook;

    public MemoryRegion(long begin, int size, MemoryFlag flag)
    {
        Begin = begin;
        End = begin + size;
        Buffer = new byte[size];
        Flag = flag;
    }

    public MemoryRegion(long begin, int size, MemoryHook hook)
    {
        this(begin, size, MemoryFlag.HOOK);
        Hook = hook;
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

    public MemoryFlag getFlag()
    {
        return Flag;
    }

    @Override
    public String toString()
    {
        return "MemoryRegion{" +
                "Begin=" + Begin +
                ", End=" + End +
                ", Buffer=" + Arrays.toString(Buffer) +
                ", Flag=" + Flag +
                '}';
    }

    private int hook(long address, boolean read, int size, int value) throws InvalidMemoryException
    {
        if (Hook == null)
            throw new InvalidMemoryException(address);

        return Hook.Invoke(address, read, size, value);
    }

    public int hook(long address, int size) throws InvalidMemoryException
    {
        return hook(address, true, size, 0);
    }

    public void hook(long address, int size, int value) throws InvalidMemoryException
    {
        hook(address, false, size, value);
    }
}

