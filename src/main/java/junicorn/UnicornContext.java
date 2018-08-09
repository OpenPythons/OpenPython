package junicorn;

import static junicorn.UnicornNative.*;

public class UnicornContext
{
    private long context;

    UnicornContext(long engine) throws UnicornException
    {
        this.context = uc_context_alloc(engine);
    }

    @Override
    protected void finalize() throws Throwable
    {
        close();
        super.finalize();
    }

    @SuppressWarnings("WeakerAccess")
    public void close() throws UnicornException
    {
        if (context != 0)
        {
            uc_free(context);
            context = 0;
        }
    }

    void save(long engine) throws UnicornException
    {
        uc_context_save(engine, context);
    }

    void restore(long engine) throws UnicornException
    {
        uc_context_restore(engine, context);
    }
}
