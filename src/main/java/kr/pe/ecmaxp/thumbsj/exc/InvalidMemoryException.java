package kr.pe.ecmaxp.thumbsj.exc;

public class InvalidMemoryException extends Exception
{
    private long addr;

    public InvalidMemoryException(long addr)
    {
        super(String.format("memory access in %08X", addr));
        this.addr = addr;
    }
}
