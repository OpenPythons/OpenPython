package junicorn;

public interface MemoryInvaildHook extends Hook
{
    boolean hook(Unicorn uc, int type, long address, int size, long value, Object user_data) throws UnicornException;
}
