package kr.pe.ecmaxp.openpie;

public enum OpenPieMemoryRegion
{
    FLASH (0x08000000, 0x100000, 0),
    SRAM(0x20000000, 0x80000, 0),
    STACK(0x3FFF0000, 0x10000, 0),
    PERIPHERAL(0x40000000, 0x10000, 0),
    SYSCALL_BUFFER(0xE0000000, 0x10000, 0);

    public final long address;
    public final long size;
    public final int perms;

    OpenPieMemoryRegion(long address, long size, int perms)
    {
        this.address = address;
        this.size = size;
        this.perms = perms;
    }
}
