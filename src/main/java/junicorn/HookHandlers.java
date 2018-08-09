package junicorn;

class HookHandlers
{
    static final HookHandler CODE_HANDLER = (record, uc, address, size, _3, _4) ->
    {
        ((CodeHook) record.hook).hook(uc, address, (int) size, record.user_data);
        return 0;
    };

    static final HookHandler INSTRUCTION_IN_HANDLER = (record, uc, port, size, _3, _4) ->
    {
        ((InstructionInHook) record.hook).hook(uc, (int) port, (int) size, record.user_data);
        return 0;
    };

    static final HookHandler INSTRUCTION_OUT_HANDLER = (record, uc, port, size, value, _4) ->
    {
        ((InstructionOutHook) record.hook).hook(uc, (int) port, (int) size, (int) value, record.user_data);
        return 0;
    };

    static final HookHandler INSTRUCTION_SYSCALL_HANDLER = (record, uc, _1, _2, _3, _4) ->
    {
        ((InstructionSysCallHook) record.hook).hook(uc, record.user_data);
        return 0;
    };

    static final HookHandler INTERRUPT_HANDLER = (record, uc, intno, _2, _3, _4) ->
    {
        ((InterruptHook) record.hook).hook(uc, (int) intno, record.user_data);
        return 0;
    };

    static final HookHandler MEMORY_ACCESS_HANDLER = (record, uc, type, address, size, value) ->
    {
        ((MemoryAccessHook) record.hook).hook(uc, (int) type, address, (int) size, value, record.user_data);
        return 0;
    };

    static final HookHandler MEMORY_INVAILD_HANDLER = (record, uc, type, address, size, value) ->
    {
        boolean result = ((MemoryInvaildHook) record.hook).hook(uc, (int) type, address, (int) size, value, record.user_data);
        return result ? 1 : 0;
    };

    static final HookHandler UNKNOWN_HANDLER = (record, uc, _1, _2, _3, _4) ->
    {
        // System.out.printf("hook[%d](%d, %d, %d, %d)\n", record.id, _1, _2, _3, _4);
        return 0;
    };

    static HookHandler findHandler(Hook hook)
    {
        if (hook instanceof CodeHook)
            return CODE_HANDLER;
        else if (hook instanceof InstructionInHook)
            return INSTRUCTION_IN_HANDLER;
        else if (hook instanceof InstructionOutHook)
            return INSTRUCTION_OUT_HANDLER;
        else if (hook instanceof InstructionSysCallHook)
            return INSTRUCTION_SYSCALL_HANDLER;
        else if (hook instanceof InterruptHook)
            return INTERRUPT_HANDLER;
        else if (hook instanceof MemoryAccessHook)
            return MEMORY_ACCESS_HANDLER;
        else if (hook instanceof MemoryInvaildHook)
            return MEMORY_INVAILD_HANDLER;
        else
            return UNKNOWN_HANDLER;
    }
}
