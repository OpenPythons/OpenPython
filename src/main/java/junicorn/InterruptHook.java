package junicorn;

public interface InterruptHook extends Hook
{
    void hook(Unicorn uc, int intno, Object user_data) throws UnicornException;
}
