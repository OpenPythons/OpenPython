package kr.pe.ecmaxp.thumbsj;

import kr.pe.ecmaxp.thumbsj.exc.InvalidMemoryException;

import java.util.ArrayList;

public class Memory
{
    private ArrayList<MemoryRegion> _list = new ArrayList<>();
    public HookMemory GlobalHook = null;
    public HookMemory Hook = null;

    // cached
    private long _beginCode;
    private long _endCode;
    private byte[] _bufferCode;
    private long _begin;
    private long _end;
    private byte[] _buffer;

    public Memory(HookMemory hook)
    {
        Hook = hook;
    }

    public Memory()
    {
    }

    // ReSharper disable once UnusedMember.Global
    public void map(long address, int size, boolean isSpecial)
    {
        if (isSpecial) return;
        byte[] chunk = new byte[size];

        MemoryRegion region = new MemoryRegion(address, address + size, chunk);
        _list.add(region);

        if (_bufferCode == null) {
            _beginCode = region.getBegin();
            _endCode = region.getEnd();
            _bufferCode = region.getBuffer();
        }
    }

    // ReSharper disable once UnusedMember.Global
    public void writeBuffer(int address, byte[] buffer) throws InvalidMemoryException
    {
        for (int i = 0; i < buffer.length; i++)
            writeByte(address + i, buffer[i]);
    }

    public int readInt(int address) throws InvalidMemoryException
    {
        int size = 4;
        long addr = (address & 0XFFFFFFFFL);

        if (isValidCache(addr, size))
        {
            if (!UpdateAndCheck(addr))
            {
                if (Hook != null)
                {
                    return Hook.Invoke(addr, true, size, 0);
                }
                else
                {
                    throw new InvalidMemoryException(addr);
                }
            }
        }

        int pos = (int) (addr - _begin);

        int value = (_buffer[pos++] & 0xFF) |
                ((_buffer[pos++] & 0xFF) << 8) |
                ((_buffer[pos++] & 0xFF) << 16) |
                ((_buffer[pos] & 0xFF) << 24);

        if (GlobalHook != null)
            GlobalHook.Invoke(addr, true, size, value);

        return value;
    }

    public void writeInt(int address, int value) throws InvalidMemoryException
    {
        final int size = 4;
        long addr = (address & 0XFFFFFFFFL);

        if (isValidCache(addr, size))
        {
            if (!UpdateAndCheck(addr))
            {
                if (Hook != null)
                {
                    Hook.Invoke(addr, false, size, value);
                    return;
                }
                else
                {
                    throw new InvalidMemoryException(addr);
                }
            }
        }

        if (GlobalHook != null)
            GlobalHook.Invoke(addr, false, size, value);

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

        if (UpdateCacheOrWriteHook(value, size, addr)) return;

        if (GlobalHook != null)
            GlobalHook.Invoke(addr, false, size, value);

        int pos = (int) (addr - _begin);
        _buffer[pos++] = (byte) value;
        _buffer[pos] = (byte) (value >> 8);
    }

    public int fetchCode(int address) throws InvalidMemoryException
    {
        final int size = 2;
        long addr = (address & 0XFFFFFFFFL);

        if (!(_beginCode <= addr && addr < _endCode))
            throw new InvalidMemoryException(addr);

        int pos = (int) (addr - _beginCode);
        int value = (_bufferCode[pos++] & 0xFF) |
                ((_bufferCode[pos] & 0xFF) << 8);

        return value;
    }

    public short readShort(int address) throws InvalidMemoryException
    {
        final int size = 2;
        long addr = (address & 0XFFFFFFFFL);

        if (isValidCache(addr, size))
        {
            if (!UpdateAndCheck(addr))
            {
                if (Hook != null)
                {
                    return (short) Hook.Invoke(addr, true, size, 0);
                }
                else
                {
                    throw new InvalidMemoryException(addr);
                }
            }
        }

        int pos = (int) (addr - _begin);
        int value = (_buffer[pos++] & 0xFF) |
                ((_buffer[pos] & 0xFF) << 8);
        short shortValue = (short) value;

        if (GlobalHook != null)
            GlobalHook.Invoke(addr, true, size, value);

        return shortValue;
    }

    public void writeByte(int address, byte byteValue) throws InvalidMemoryException
    {
        final int size = 1;
        long addr = (address & 0XFFFFFFFFL);
        int value = byteValue & 0xFF;

        if (UpdateCacheOrWriteHook(value, size, addr)) return;

        if (GlobalHook != null)
            GlobalHook.Invoke(addr, false, size, value);

        int pos = (int) (address - _begin);
        _buffer[pos] = byteValue;
    }

    public byte readByte(int address) throws InvalidMemoryException
    {
        final int size = 1;
        long addr = (address & 0XFFFFFFFFL);

        if (isValidCache(addr, size))
        {
            if (!UpdateAndCheck(addr))
            {
                if (Hook != null)
                {
                    return (byte) (Hook.Invoke(addr, true, size, 0) & 0XFF);
                }
                else
                {
                    throw new InvalidMemoryException(addr);
                }
            }
        }

        int pos = (int) (addr - _begin);
        byte byteValue = _buffer[pos];
        int value = byteValue & 0xFF;

        if (GlobalHook != null)
            GlobalHook.Invoke(addr, true, size, value);

        return byteValue;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private boolean isValidCache(long address, long size)
    {
        return _begin > address || address + size >= _end;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private boolean UpdateAndCheck(long address)
    {
        for (MemoryRegion page : _list)
        {
            if (!(page.getBegin() <= address && address < page.getEnd())) continue;
            _begin = page.getBegin();
            _end = page.getEnd();
            _buffer = page.getBuffer();
            return true;
        }

        _begin = 0;
        _end = 0;
        _buffer = null;
        return false;
    }

    private boolean UpdateCacheOrWriteHook(int value, int size, long addr) throws InvalidMemoryException
    {
        if (isValidCache(addr, size))
        {
            if (!UpdateAndCheck(addr))
            {
                if (Hook != null)
                {
                    Hook.Invoke(addr, false, size, value);
                    return true;
                }
                else
                {
                    throw new InvalidMemoryException(addr);
                }
            }
        }
        return false;
    }
}
