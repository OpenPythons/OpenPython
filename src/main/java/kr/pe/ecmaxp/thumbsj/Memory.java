package kr.pe.ecmaxp.thumbsj;

import kr.pe.ecmaxp.thumbsj.exc.InvalidMemoryException;

import java.util.ArrayList;

public class Memory
{
    private ArrayList<MemoryRegion> _list = new ArrayList<>();

    // cached
    private MemoryRegion _execPage;
    private MemoryRegion _readPage;
    private MemoryRegion _writePage;

    public Memory()
    {
    }

    public void map(long address, int size, MemoryHook hook) throws InvalidMemoryException
    {
        MemoryRegion region = new MemoryRegion(address, size, hook);
        _list.add(region);
    }

    public void map(long address, int size, MemoryFlag flag) throws InvalidMemoryException
    {
        MemoryRegion region = new MemoryRegion(address, size, flag);
        _list.add(region);

        if (region.getFlag() == MemoryFlag.RX)
        {
            if (_execPage != null)
            {
                throw new InvalidMemoryException(region.getBegin());
            }

            _execPage = region;
        }
    }

    public byte[] readBuffer(int address, int size) throws InvalidMemoryException
    {
        long addr = Integer.toUnsignedLong(address);
        MemoryRegion page = _readPage = UpdateCache(_readPage, addr, size);

        if (page.getFlag() != MemoryFlag.RX && page.getFlag() != MemoryFlag.RW)
            throw new InvalidMemoryException(addr);

        byte[] buffer = new byte[size];
        System.arraycopy(page.getBuffer(), (int) (addr - page.getBegin()), buffer, 0, size);
        return buffer;
    }

    public void writeBuffer(int address, byte[] buffer) throws InvalidMemoryException
    {
        int size = buffer.length;
        long addr = Integer.toUnsignedLong(address);
        MemoryRegion page = _writePage = UpdateCache(_writePage, addr, size);

        if (page.getFlag() != MemoryFlag.RX && page.getFlag() != MemoryFlag.RW)
            throw new InvalidMemoryException(addr);

        System.arraycopy(buffer, 0, page.getBuffer(), (int) (addr - page.getBegin()), size);
    }

    public int fetchCode(int address) throws InvalidMemoryException
    {
        final int size = 2;
        long addr = Integer.toUnsignedLong(address);
        MemoryRegion page = _execPage = UpdateCache(_execPage, addr, size);

        int pos = (int) (addr - page.getBegin());

        byte[] _bufferCode = page.getBuffer();
        return (_bufferCode[pos++] & 0xFF) |
                ((_bufferCode[pos] & 0xFF) << 8);
    }

    public int readInt(int address) throws InvalidMemoryException
    {
        int size = 4;
        long addr = Integer.toUnsignedLong(address);
        MemoryRegion page = _readPage = UpdateCache(_readPage, addr, size);

        if (page.getFlag() == MemoryFlag.HOOK)
            return page.hook(addr, size);

        int pos = (int) (addr - page.getBegin());
        byte[] _buffer = page.getBuffer();
        return (_buffer[pos++] & 0xFF) |
                ((_buffer[pos++] & 0xFF) << 8) |
                ((_buffer[pos++] & 0xFF) << 16) |
                ((_buffer[pos] & 0xFF) << 24);
    }

    public short readShort(int address) throws InvalidMemoryException
    {
        final int size = 2;
        long addr = Integer.toUnsignedLong(address);
        MemoryRegion page = _readPage = UpdateCache(_readPage, addr, size);

        if (page.getFlag() == MemoryFlag.HOOK)
            return (short) page.hook(addr, size);

        int pos = (int) (addr - page.getBegin());

        byte[] _buffer = page.getBuffer();
        return (short) ((_buffer[pos++] & 0xFF) |
                ((_buffer[pos] & 0xFF) << 8));
    }

    public byte readByte(int address) throws InvalidMemoryException
    {
        final int size = 1;
        long addr = Integer.toUnsignedLong(address);
        MemoryRegion page = _readPage = UpdateCache(_readPage, addr, size);

        if (page.getFlag() == MemoryFlag.HOOK)
            return (byte) page.hook(addr, size);

        int pos = (int) (addr - page.getBegin());
        byte[] _buffer = page.getBuffer();
        return _buffer[pos];
    }

    public void writeInt(int address, int value) throws InvalidMemoryException
    {
        final int size = 4;
        long addr = Integer.toUnsignedLong(address);
        MemoryRegion page = _writePage = UpdateCache(_writePage, addr, size);

        if (page.getFlag() == MemoryFlag.HOOK)
        {
            page.hook(addr, size, value);
            return;
        }

        int pos = (int) (addr - page.getBegin());
        byte[] _buffer = page.getBuffer();
        _buffer[pos++] = (byte) value;
        _buffer[pos++] = (byte) (value >> 8);
        _buffer[pos++] = (byte) (value >> 16);
        _buffer[pos] = (byte) (value >> 24);
    }

    public void writeShort(int address, short shortValue) throws InvalidMemoryException
    {
        final int size = 2;
        long addr = Integer.toUnsignedLong(address);
        int value = shortValue & 0xFFFF;
        MemoryRegion page = _writePage = UpdateCache(_writePage, addr, size);

        if (page.getFlag() == MemoryFlag.HOOK)
        {
            page.hook(addr, size, value);
            return;
        }

        int pos = (int) (addr - page.getBegin());
        byte[] _buffer = page.getBuffer();
        _buffer[pos++] = (byte) value;
        _buffer[pos] = (byte) (value >> 8);
    }

    public void writeByte(int address, byte byteValue) throws InvalidMemoryException
    {
        final int size = 1;
        long addr = Integer.toUnsignedLong(address);
        MemoryRegion page = _writePage = UpdateCache(_writePage, addr, size);

        if (page.getFlag() == MemoryFlag.HOOK)
        {
            page.hook(addr, size, byteValue & 0xFF);
            return;
        }

        int pos = (int) (address - page.getBegin());
        byte[] _buffer = page.getBuffer();
        _buffer[pos] = byteValue;
    }

    private MemoryRegion UpdateCache(MemoryRegion region, long address, long size) throws InvalidMemoryException {
        if (region != null && region.getBegin() <= address && address + size <= region.getEnd()) {
            return region;
        }

        return FindRegion(address, size);
    }

    public MemoryRegion FindRegion(long address, long size) throws InvalidMemoryException
    {
        for (MemoryRegion page: _list)
        {
            if (!(page.getBegin() <= address && address + size <= page.getEnd())) continue;
            return page;
        }

        throw new InvalidMemoryException(address);
    }
}
