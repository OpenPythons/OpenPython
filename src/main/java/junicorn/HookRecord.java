package junicorn;

public class HookRecord
{
    final long id;
    final long handle;
    final Hook hook;
    final Object user_data;
    final HookHandler handler;

    HookRecord(long id, long handle, Hook hook, Object user_data)
    {
        this.id = id;
        this.handle = handle;
        this.hook = hook;
        this.user_data = user_data;
        this.handler = HookHandlers.findHandler(hook);
    }
}

