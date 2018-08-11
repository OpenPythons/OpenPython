package junicorn;

public interface MemoryAccessHook extends Hook
{
    void hook(Unicorn uc, int type, long address, int size, long value, Object user_data) throws UnicornException;
}
