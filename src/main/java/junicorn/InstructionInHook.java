package junicorn;

public interface InstructionInHook extends Hook
{
    int hook(Unicorn uc, int port, int size, Object user_data) throws UnicornException;
}
