package kr.pe.ecmaxp.thumbsj;

import kr.pe.ecmaxp.thumbsj.exc.InvalidMemoryException;

import java.util.ArrayList;

public class Memory
{
    private ArrayList<MemoryRegion> _list = new ArrayList<>();

    // cached
    private long _beginCode;
    private long _endCode;
    private byte[] _bufferCode;
    private long _begin;
    private long _end;
    private byte[] _buffer;
    private MemoryFlag _flag;
    private MemoryRegion _page;

    public Memory()
    {
    }

    public void map(long address, int size, MemoryHook hook) throws InvalidMemoryException
    {
        long addr = (address & 0XFFFFFFFFL);
        MemoryRegion region = new MemoryRegion(addr, size, hook);
        _list.add(region);
    }

    public void map(long address, int size, MemoryFlag flag) throws InvalidMemoryException
    {
        long addr = (address & 0XFFFFFFFFL);
        MemoryRegion region = new MemoryRegion(addr, size, flag);
        _list.add(region);

        if (region.getFlag() == MemoryFlag.RX)
        {
            if (_bufferCode != null)
            {
                throw new InvalidMemoryException(region.getBegin());
            }

            _beginCode = region.getBegin();
            _endCode = region.getEnd();
            _bufferCode = region.getBuffer();
        }
    }

    public byte[] readBuffer(int address, int size) throws InvalidMemoryException
    {
        if (!isValidCache(address, size))
            UpdateCache(address, size);

        if (_flag != MemoryFlag.RX && _flag != MemoryFlag.RW)
            throw new InvalidMemoryException(address);

        byte[] buffer = new byte[size];
        System.arraycopy(_buffer, (int) (address - _begin), buffer, 0, size);
        return buffer;
    }

    public void writeBuffer(int address, byte[] buffer) throws InvalidMemoryException
    {
        long addr = (address & 0XFFFFFFFFL);
        if (!isValidCache(addr, buffer.length))
            UpdateCache(addr, buffer.length);

        if (_flag != MemoryFlag.RX && _flag != MemoryFlag.RW)
            throw new InvalidMemoryException(addr);

        System.arraycopy(buffer, 0, _buffer, (int) (addr - _begin), buffer.length);
    }

    public int fetchCode(int address) throws InvalidMemoryException
    {
        final int size = 2;
        long addr = (address & 0XFFFFFFFFL);

        if (!(_beginCode <= addr && addr + 2 < _endCode))
            throw new InvalidMemoryException(addr);

        int pos = (int) (addr - _beginCode);

        return (_bufferCode[pos++] & 0xFF) |
                ((_bufferCode[pos] & 0xFF) << 8);
    }

    public int readInt(int address) throws InvalidMemoryException
    {
        int size = 4;
        long addr = (address & 0XFFFFFFFFL);

        if (!isValidCache(addr, size))
            UpdateCache(addr, size);

        if (_flag == MemoryFlag.HOOK)
            return _page.hook(address, size);

        int pos = (int) (addr - _begin);

        return (_buffer[pos++] & 0xFF) |
                ((_buffer[pos++] & 0xFF) << 8) |
                ((_buffer[pos++] & 0xFF) << 16) |
                ((_buffer[pos] & 0xFF) << 24);
    }

    public short readShort(int address) throws InvalidMemoryException
    {
        final int size = 2;
        long addr = (address & 0XFFFFFFFFL);

        if (!isValidCache(addr, size))
            UpdateCache(addr, size);

        if (_flag == MemoryFlag.HOOK)
            return (short) _page.hook(address, size);

        int pos = (int) (addr - _begin);

        return (short) ((_buffer[pos++] & 0xFF) |
                ((_buffer[pos] & 0xFF) << 8));
    }

    public byte readByte(int address) throws InvalidMemoryException
    {
        final int size = 1;
        long addr = (address & 0XFFFFFFFFL);

        if (!isValidCache(addr, size))
            UpdateCache(addr, size);

        if (_flag == MemoryFlag.HOOK)
            return (byte) _page.hook(address, size);

        int pos = (int) (addr - _begin);
        return _buffer[pos];
    }

    public void writeInt(int address, int value) throws InvalidMemoryException
    {
        final int size = 4;
        long addr = (address & 0XFFFFFFFFL);

        if (!isValidCache(addr, size))
            UpdateCache(addr, size);

        if (_flag == MemoryFlag.HOOK)
        {
            _page.hook(addr, size, value);
            return;
        }

        int pos = (int) (addr - _begin);
        _buffer[pos++] = (byte) value;
        _buffer[pos++] = (byte) (value >> 8);
        _buffer[pos++] = (byte) (value >> 16);
        _buffer[pos] = (byte) (value >> 24);
    }

    public void writeShort(int address, short shortValue) throws InvalidMemoryException
    {
        final int size = 2;
        long addr = (address & 0XFFFFFFFFL);
        int value = shortValue & 0xFFFF;

        if (!isValidCache(addr, size))
            UpdateCache(addr, size);

        if (_flag == MemoryFlag.HOOK)
        {
            _page.hook(addr, size, value);
            return;
        }

        int pos = (int) (addr - _begin);
        _buffer[pos++] = (byte) value;
        _buffer[pos] = (byte) (value >> 8);
    }

    public void writeByte(int address, byte byteValue) throws InvalidMemoryException
    {
        final int size = 1;
        long addr = (address & 0XFFFFFFFFL);

        if (!isValidCache(addr, size))
            UpdateCache(addr, size);

        if (_flag == MemoryFlag.HOOK)
        {
            _page.hook(addr, size, byteValue & 0xFF);
            return;
        }

        int pos = (int) (address - _begin);
        _buffer[pos] = byteValue;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private boolean isValidCache(long address, long size)
    {
        return (_begin <= address && address + size <= _end);
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private void UpdateCache(long address, long size) throws InvalidMemoryException
    {
        for (MemoryRegion page : _list)
        {
            if (!(page.getBegin() <= address && address + size <= page.getEnd())) continue;
            _page = page;
            _begin = page.getBegin();
            _end = page.getEnd();
            _buffer = page.getBuffer();
            _flag = page.getFlag();
            return;
        }

        throw new InvalidMemoryException(address);
    }
}
