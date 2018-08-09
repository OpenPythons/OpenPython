package junicorn;

public interface InstructionOutHook extends Hook
{
    void hook(Unicorn uc, int port, int size, int value, Object user_data);
}
