package junicorn;

import java.util.HashMap;

public class UnicornNative
{
    private static HashMap<Long, Unicorn> EngineMap = new HashMap<>();

    @SuppressWarnings("unused")
    public native static long uc_version();

    @SuppressWarnings("unused")
    public native static boolean uc_arch_supported(int arch);

    native static long uc_open(int arch, int mode) throws UnicornException;

    native static void uc_close(long engine) throws UnicornException;

    native static String uc_strerror(int errno);

    native static int uc_errno(long engine);

    native static long uc_reg_read(long engine, int regid) throws UnicornException;

    native static long uc_reg_read(long engine, int regid, int opt) throws UnicornException;

    native static void uc_reg_write(long engine, int regid, long value) throws UnicornException;

    native static byte[] uc_mem_read(long engine, long address, long size) throws UnicornException;

    native static void uc_mem_write(long engine, long address, byte[] data, long size) throws UnicornException;

    native static void uc_emu_start(long engine, long begin, long until, long timeout, long count) throws UnicornException;

    native static void uc_emu_stop(long engine) throws UnicornException;

    native static long uc_hook_add(long engine, int cb_type, int type, long id, long begin, long end, long arg1) throws UnicornException;

    native static void uc_hook_del(long engine, long id) throws UnicornException;

    native static void uc_mem_map(long engine, long address, long size, int perms) throws UnicornException;

    native static void uc_mem_map_ptr(long engine, long address, long size, int perms, long ptr) throws UnicornException;

    native static void uc_mem_unmap(long engine, long address, long size) throws UnicornException;

    native static void uc_mem_protect(long engine, long address, long size, int perms) throws UnicornException;

    native static long uc_query(long engine, int type) throws UnicornException;

    native static long uc_context_alloc(long engine) throws UnicornException;

    native static void uc_free(long context) throws UnicornException;

    native static void uc_context_save(long engine, long context) throws UnicornException;

    native static void uc_context_restore(long engine, long context) throws UnicornException;

    native static MemoryRegion[] uc_mem_regions(long engine) throws UnicornException;

    static synchronized void juc_engine_register(long engine, Unicorn uc)
    {
        EngineMap.put(engine, uc);
    }

    static synchronized void juc_engine_unregister(long engine)
    {
        EngineMap.remove(engine);
    }

    static synchronized Unicorn juc_engine_lookup(long engine)
    {
        return EngineMap.get(engine);
    }

    @SuppressWarnings("unused")
    private static int juc_hook_cb(long engine, long id, long arg1, long arg2, long arg3, long arg4) throws UnicornException
    {
        Unicorn uc = juc_engine_lookup(engine);
        if (uc == null)
            return 0;

        HookRecord record = uc.get_hook(id);
        if (record == null)
            return 0;

        return record.handler.handle(record, uc, arg1, arg2, arg3, arg4);
    }
}

