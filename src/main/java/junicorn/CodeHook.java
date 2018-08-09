package junicorn;

public interface CodeHook extends Hook
{
    void hook(Unicorn uc, long address, int size, Object user_data);
}
