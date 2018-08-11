package junicorn;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;

import static junicorn.UnicornNative.*;

@SuppressWarnings("unused")
public class Unicorn implements JavaUnicornConst, UnicornConst, ArmConst, Arm64Const, M68kConst, SparcConst, MipsConst, X86Const
{
    private long engine;
    private HashMap<Long, HookRecord> HookRecordMap = new HashMap<>();
    private HashMap<Hook, Long> HookIdMap = new HashMap<>();
    private int hook_id_counter = 1;

    private Exception pendingException;
    private int arch;
    private int mode;

    public Unicorn(int arch, int mode) throws UnicornException
    {
        this.arch = arch;
        this.mode = mode;
        this.engine = uc_open(arch, mode);
        juc_engine_register(this.engine, this);
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
        if (this.engine != 0)
        {
            uc_close(this.engine);
            juc_engine_unregister(this.engine);
            HookRecordMap.clear();
            HookIdMap.clear();
            this.engine = 0;
        }
    }

    HookRecord get_hook(long id)
    {
        return HookRecordMap.get(id);
    }

    private void hook_add(int cb_type, int type, Hook hook, int begin, int end, int arg1, Object user_data) throws UnicornException
    {
        long id = hook_id_counter++;
        long handle = uc_hook_add(engine, cb_type, type, id, begin, end, arg1);
        HookRecord record = new HookRecord(id, handle, hook, user_data);
        HookRecordMap.put(id, record);
        HookIdMap.put(hook, id);
    }

    public int errno()
    {
        return uc_errno(engine);
    }

    public void emu_start(long begin, long until, long timeout, long count) throws Exception
    {
        uc_emu_start(engine, begin, until, timeout, count);

        Exception exc = getPendingException();
        clearPendingException();
        if (exc != null) {
            throw exc;
        }
    }

    public Exception getPendingException()
    {
        return pendingException;
    }

    public void clearPendingException()
    {
        pendingException = null;
    }

    public void emu_stop() throws UnicornException
    {
        uc_emu_stop(engine);
    }

    private boolean is_big_reg(int reg_id)
    {
        switch (arch)
        {
            case UC_ARCH_X86:
                switch (reg_id)
                {
                    case UC_X86_REG_IDTR:
                    case UC_X86_REG_GDTR:
                    case UC_X86_REG_LDTR:
                    case UC_X86_REG_TR:
                    case UC_X86_REG_MSR:
                        return true;
                    default:
                        if (UC_X86_REG_FP0 <= reg_id && reg_id <= UC_X86_REG_FP7)
                            return true;
                        if (UC_X86_REG_XMM0 <= reg_id && reg_id <= UC_X86_REG_XMM7)
                            return true;
                }
                break;
            case UC_ARCH_ARM64:
                if (UC_ARM64_REG_Q0 <= reg_id && reg_id <= UC_ARM64_REG_Q31)
                    return true;
                if (UC_ARM64_REG_V0 <= reg_id && reg_id <= UC_ARM64_REG_V31)
                    return true;
                break;
        }

        return false;
    }

    public long reg_read(int reg_id) throws UnicornException
    {
        boolean is_big = is_big_reg(reg_id);
        if (is_big)
            throw new NotImplementedException();

        return uc_reg_read(engine, reg_id);
    }

    public long reg_read(int reg_id, int opt) throws UnicornException
    {
        boolean is_big = is_big_reg(reg_id);
        if (is_big)
            throw new NotImplementedException();

        //noinspection ConstantConditions
        if (false)
            return uc_reg_read(engine, reg_id, opt);

        throw new NotImplementedException();
    }

    public void reg_write(int reg_id, long value) throws UnicornException
    {
        boolean is_big = is_big_reg(reg_id);
        if (is_big)
            throw new NotImplementedException();

        uc_reg_write(engine, reg_id, value);
    }

    public byte[] mem_read(long address, long size) throws UnicornException
    {
        return uc_mem_read(engine, address, size);
    }

    public void mem_write(long address, byte[] data) throws UnicornException
    {
        uc_mem_write(engine, address, data, data.length);
    }

    public void mem_write(long address, byte[] data, long size) throws UnicornException
    {
        uc_mem_write(engine, address, data, size);
    }

    public void mem_map(long address, long size) throws UnicornException
    {
        uc_mem_map(engine, address, size, UC_PROT_ALL);
    }

    public void mem_map(long address, long size, int perms) throws UnicornException
    {
        uc_mem_map(engine, address, size, perms);
    }

    public void mem_map_ptr(long address, long size, int perms, long ptr) throws UnicornException
    {
        uc_mem_map_ptr(engine, address, size, perms, ptr);
    }

    public void mem_unmap(long address, long size) throws UnicornException
    {
        uc_mem_unmap(engine, address, size);
    }

    public void mem_protect(long address, long size) throws UnicornException
    {
        uc_mem_protect(engine, address, size, UC_PROT_ALL);
    }

    public void mem_protect(long address, long size, int perms) throws UnicornException
    {
        uc_mem_protect(engine, address, size, perms);
    }

    public long query(int mode) throws UnicornException
    {
        return uc_query(engine, mode);
    }

    public void hook_add(int type, int subtype, InstructionInHook hook, int begin, int end, Object user_data) throws UnicornException
    {
        if (type != UC_HOOK_INSN)
            throw new IllegalArgumentException();

        hook_add(JUC_HOOK_CB_INSN_IN, type, hook, begin, end, subtype, user_data);
    }

    public void hook_add(int type, int subtype, InstructionOutHook hook, int begin, int end, Object user_data) throws UnicornException
    {
        if (type != UC_HOOK_INSN)
            throw new IllegalArgumentException();

        hook_add(JUC_HOOK_CB_INSN_OUT, type, hook, begin, end, subtype, user_data);
    }

    public void hook_add(int type, int subtype, InstructionSysCallHook hook, int begin, int end, Object user_data) throws UnicornException
    {
        if (type != UC_HOOK_INSN)
            throw new IllegalArgumentException();

        hook_add(JUC_HOOK_CB_INSN_SYSCALL, type, hook, begin, end, subtype, user_data);
    }

    public void hook_add(int type, InterruptHook hook, int begin, int end, Object user_data) throws UnicornException
    {
        if (type != UC_HOOK_INTR)
            throw new IllegalArgumentException();

        hook_add(JUC_HOOK_CB_INTR_CB, type, hook, begin, end, 0, user_data);
    }

    public void hook_add(int type, MemoryInvaildHook hook, int begin, int end, Object user_data) throws UnicornException
    {
        if ((type & UC_HOOK_MEM_INVALID) == 0)
            throw new IllegalArgumentException();

        hook_add(JUC_HOOK_CB_MEM_INVAILD, type, hook, begin, end, 0, user_data);
    }

    public void hook_add(int type, MemoryAccessHook hook, int begin, int end, Object user_data) throws UnicornException
    {
        if ((type & UC_HOOK_MEM_VALID) == 0)
            throw new IllegalArgumentException();

        hook_add(JUC_HOOK_CB_MEM_ACCESS, type, hook, begin, end, 0, user_data);
    }

    public void hook_add(int type, CodeHook hook, int begin, int end, Object user_data) throws UnicornException
    {
        if (type != UC_HOOK_BLOCK && type != UC_HOOK_CODE)
            throw new IllegalArgumentException();

        hook_add(JUC_HOOK_CB_CODE, type, hook, begin, end, 0, user_data);
    }

    public void hook_del(Hook hook) throws UnicornException
    {
        long id = HookIdMap.get(hook);
        HookRecord record = HookRecordMap.get(id);
        uc_hook_del(engine, record.handle);
        HookRecordMap.remove(id);
        HookIdMap.remove(hook);
    }

    public UnicornContext save_context() throws UnicornException
    {
        UnicornContext context = new UnicornContext(engine);
        context.save(engine);
        return context;
    }

    public void update_context(UnicornContext context) throws UnicornException
    {
        context.save(engine);
    }

    public void restore_context(UnicornContext context) throws UnicornException
    {
        context.restore(engine);
    }

    public MemoryRegion[] mem_regions() throws UnicornException
    {
        return uc_mem_regions(engine);
    }

    public boolean HandleException(Exception e)
    {
        pendingException = e;

        try
        {
            emu_stop();
        }
        catch (UnicornException ignored)
        {
        }

        return false;
    }
}
