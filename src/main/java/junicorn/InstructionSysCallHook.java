package junicorn;

public interface InstructionSysCallHook extends Hook
{
    void hook(Unicorn uc, Object user_data);
}
