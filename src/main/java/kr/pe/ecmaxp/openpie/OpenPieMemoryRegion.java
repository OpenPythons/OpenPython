package kr.pe.ecmaxp.openpie;

import static junicorn.UnicornConst.*;

public enum OpenPieMemoryRegion
{
    FLASH (0x08000000, 0x100000, UC_PROT_READ | UC_PROT_EXEC),
    SRAM(0x20000000, 0x80000, UC_PROT_READ | UC_PROT_WRITE),
    STACK(0x3FFF0000, 0x10000, UC_PROT_READ | UC_PROT_WRITE),
    PERIPHERAL(0x40000000, 0x10000, UC_PROT_READ | UC_PROT_WRITE),
    SYSCALL_BUFFER(0xE0100000, 0x10000, UC_PROT_READ | UC_PROT_WRITE);

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
