package kr.pe.ecmaxp.micropython.example;

import kotlin.Pair;
import kr.pe.ecmaxp.thumbjk.Callback;
import kr.pe.ecmaxp.thumbjk.KotlinCPU;
import kr.pe.ecmaxp.thumbjk.InterruptHandler;
import kr.pe.ecmaxp.thumbsk.Memory;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

import static kr.pe.ecmaxp.thumbsk.helper.RegisterIndex.*;

abstract public class MicroPython_lib extends MicroPython_system
{
    public MicroPython_lib(@NotNull Memory memory)
    {
        super(memory);
    }

    // function: Function(address=134322752, size=34, name='strn_print_strn', path='build/lib/utils/printf.o', has_indirect=True)
    protected void strn_print_strn(int offset) throws Exception
    {
        while (true)
        {
            pc = strn_print_strn + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6);
                    r5 = ldr(r0 + 4);
                    r4 = movs(r4, r0);
                    cmp(r5, r2);
                    if (bls()) {
                        offset = 12;
                        continue;
                    }
                case 10:
                    r5 = movs(r5, r2);
                case 12:
                    r2 = movs(r2, r5);
                    r0 = ldr(r4);
                    bl(this::memcpy, strn_print_strn + 20 | 1, 20);
                    return;
                case 20:
                    r3 = ldr(r4);
                    r3 = adds(r3, r5);
                    str(r4, r3);
                    r3 = ldr(r4 + 4);
                    r5 = subs(r3, r5);
                    str(r4 + 4, r5);
                    pop(true, R4, R5, R6);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134322788, size=28, name='printf', path='build/lib/utils/printf.o', has_indirect=False)
    protected void printf(int offset) throws Exception
    {
        while (true)
        {
            pc = printf + offset;
            switch (offset)
            {
                case 0:
                    push(false, r0, r1, r2, r3);
                    push(true, r0, r1, r2);
                    r2 = add(sp, 16);
                    r2 = ldm(r2, R1);
                    r0 = ldr(printf + 24); // mp_plat_print;
                    str(sp + 4, r2);
                    bl(this::mp_vprintf, printf + 16 | 1, 16);
                    return;
                case 16:
                    sp = add(sp, 12);
                    pop(false, R3);
                    sp = add(sp, 16);
                    bx(r3);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134322816, size=20, name='putchar', path='build/lib/utils/printf.o', has_indirect=False)
    protected void putchar(int offset) throws Exception
    {
        while (true)
        {
            pc = putchar + offset;
            switch (offset)
            {
                case 0:
                    push(true, r0, r1, r4);
                    r3 = mov(sp);
                    r4 = adds(r3, 7);
                    strb(r3 + 7, r0);
                    r1 = movs(r1, 1);
                    r0 = movs(r0, r4);
                    bl(this::mp_hal_stdout_tx_strn_cooked, putchar + 16 | 1, 16);
                    return;
                case 16:
                    r0 = ldrb(r4);
                    pop(true, R1, R2, R4);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134322836, size=34, name='puts', path='build/lib/utils/printf.o', has_indirect=False)
    protected void puts(int offset) throws Exception
    {
        while (true)
        {
            pc = puts + offset;
            switch (offset)
            {
                case 0:
                    push(true, r0, r1, r4);
                    r4 = movs(r4, r0);
                    bl(this::strlen, puts + 8 | 1, 8);
                    return;
                case 8:
                    r1 = movs(r1, r0);
                    r0 = movs(r0, r4);
                    bl(this::mp_hal_stdout_tx_strn_cooked, puts + 16 | 1, 16);
                    return;
                case 16:
                    r3 = mov(sp);
                    r0 = adds(r3, 7);
                    r3 = movs(r3, 10);
                    r1 = movs(r1, 1);
                    strb(r0, r3);
                    bl(this::mp_hal_stdout_tx_strn_cooked, puts + 30 | 1, 30);
                    return;
                case 30:
                    r0 = movs(r0, 1);
                    pop(true, R1, R2, R4);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134322872, size=56, name='vsnprintf', path='build/lib/utils/printf.o', has_indirect=False)
    protected void vsnprintf(int offset) throws Exception
    {
        while (true)
        {
            pc = vsnprintf + offset;
            switch (offset)
            {
                case 0:
                    push(true, r0, r1, r2, r3, r4);
                    r4 = movs(r4, r1);
                    r1 = movs(r1, r2);
                    r2 = mov(sp);
                    str(sp + 8, r2);
                    r2 = mov(strn_print_strn | 1);
                    str(sp, r0);
                    str(sp + 12, r2);
                    r0 = add(sp, 8);
                    r2 = movs(r2, r3);
                    str(sp + 4, r4);
                    bl(this::mp_vprintf, vsnprintf + 26 | 1, 26);
                    return;
                case 26:
                    cmp(r4, 0);
                    if (beq()) {
                        offset = 42;
                        continue;
                    }
                case 30:
                    r2 = ldr(sp + 4);
                    r3 = ldr(sp);
                    cmp(r2, 0);
                    if (bne()) {
                        offset = 46;
                        continue;
                    }
                case 38:
                    r3 = subs(r3, 1);
                case 40:
                    strb(r3, r2);
                case 42:
                    sp = add(sp, 16);
                    pop(true, R4);
                    return;
                case 46:
                    r2 = movs(r2, 0);
                    step();
                    offset = 40;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134322928, size=22, name='snprintf', path='build/lib/utils/printf.o', has_indirect=False)
    protected void snprintf(int offset) throws Exception
    {
        while (true)
        {
            pc = snprintf + offset;
            switch (offset)
            {
                case 0:
                    push(false, r2, r3);
                    push(true, r0, r1, r2);
                    r3 = add(sp, 16);
                    r3 = ldm(r3, R2);
                    str(sp + 4, r3);
                    bl(this::vsnprintf, snprintf + 14 | 1, 14);
                    return;
                case 14:
                    sp = add(sp, 12);
                    pop(false, R3);
                    sp = add(sp, 8);
                    bx(r3);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134324320, size=8, name='stdio_obj___exit__', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected void stdio_obj___exit__(int offset) throws Exception
    {
        assert offset == 0;
        pc = stdio_obj___exit__ + offset;
        r0 = ldr(stdio_obj___exit__ + 4); // mp_const_none_obj;
        bx(lr);
    }

    // function: Function(address=134324328, size=16, name='stdio_obj_print', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected void stdio_obj_print(int offset) throws Exception
    {
        while (true)
        {
            pc = stdio_obj_print + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4);
                    r2 = ldr(r1 + 4);
                    r1 = ldr(stdio_obj_print + 12); // stdio_obj_print.str1.1;
                    bl(this::mp_printf, stdio_obj_print + 10 | 1, 10);
                    return;
                case 10:
                    pop(true, R4);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134324344, size=16, name='stdio_buffer_write', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected void stdio_buffer_write(int offset) throws Exception
    {
        while (true)
        {
            pc = stdio_buffer_write + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4);
                    r4 = movs(r4, r2);
                    r0 = movs(r0, r1);
                    r1 = movs(r1, r2);
                    bl(this::mp_hal_stdout_tx_strn, stdio_buffer_write + 12 | 1, 12);
                    return;
                case 12:
                    r0 = movs(r0, r4);
                    pop(true, R4);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134324360, size=26, name='stdio_buffer_read', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected void stdio_buffer_read(int offset) throws Exception
    {
        while (true)
        {
            pc = stdio_buffer_read + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6);
                    r5 = movs(r5, r2);
                    r4 = movs(r4, r1);
                    r6 = adds(r1, r2);
                case 8:
                    cmp(r4, r6);
                    if (bne()) {
                        offset = 16;
                        continue;
                    }
                case 12:
                    r0 = movs(r0, r5);
                    pop(true, R4, R5, R6);
                    return;
                case 16:
                    bl(this::mp_hal_stdin_rx_chr, stdio_buffer_read + 20 | 1, 20);
                    return;
                case 20:
                    strb(r4, r0);
                    r4 = adds(r4, 1);
                    step();
                    offset = 8;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134324386, size=36, name='stdio_write', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected void stdio_write(int offset) throws Exception
    {
        while (true)
        {
            pc = stdio_write + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6);
                    r5 = movs(r5, r0);
                    r4 = movs(r4, r2);
                    r2 = ldr(r5 + 4);
                    r0 = movs(r0, r1);
                    r2 = subs(r2, 1);
                    cmp(r2, 1);
                    if (bhi()) {
                        offset = 26;
                        continue;
                    }
                case 16:
                    r1 = movs(r1, r4);
                    bl(this::mp_hal_stdout_tx_strn_cooked, stdio_write + 22 | 1, 22);
                    return;
                case 22:
                    r0 = movs(r0, r4);
                    pop(true, R4, R5, R6);
                    return;
                case 26:
                    r2 = movs(r2, 1);
                    r4 = movs(r4, 1);
                    str(r3, r2);
                    r4 = rsbs(r4);
                    step();
                    offset = 22;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134324422, size=50, name='stdio_read', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected void stdio_read(int offset) throws Exception
    {
        while (true)
        {
            pc = stdio_read + offset;
            switch (offset)
            {
                case 0:
                    push(true, r3, r4, r5, r6, r7);
                    r5 = movs(r5, r2);
                    r2 = ldr(r0 + 4);
                    cmp(r2, 0);
                    if (bne()) {
                        offset = 40;
                        continue;
                    }
                case 10:
                    r4 = movs(r4, r1);
                    r7 = movs(r7, 10);
                    r6 = adds(r1, r5);
                case 16:
                    cmp(r4, r6);
                    if (bne()) {
                        offset = 24;
                        continue;
                    }
                case 20:
                    r0 = movs(r0, r5);
                    pop(true, R3, R4, R5, R6, R7);
                    return;
                case 24:
                    bl(this::mp_hal_stdin_rx_chr, stdio_read + 28 | 1, 28);
                    return;
                case 28:
                    cmp(r0, 13);
                    if (bne()) {
                        offset = 34;
                        continue;
                    }
                case 32:
                    r0 = movs(r0, r7);
                case 34:
                    strb(r4, r0);
                    r4 = adds(r4, 1);
                    step();
                    offset = 16;
                    continue;
                case 40:
                    r2 = movs(r2, 1);
                    r5 = movs(r5, 1);
                    str(r3, r2);
                    r5 = rsbs(r5);
                    step();
                    offset = 20;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134324472, size=44, name='mp_hal_stdout_tx_strn_cooked', path='build/lib/utils/stdout_helpers.o', has_indirect=False)
    protected void mp_hal_stdout_tx_strn_cooked(int offset) throws Exception
    {
        while (true)
        {
            pc = mp_hal_stdout_tx_strn_cooked + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6);
                    r4 = movs(r4, r0);
                    r5 = adds(r0, r1);
                case 6:
                    cmp(r4, r5);
                    if (bne()) {
                        offset = 12;
                        continue;
                    }
                case 10:
                    pop(true, R4, R5, R6);
                    return;
                case 12:
                    r3 = ldrb(r4);
                    cmp(r3, 10);
                    if (bne()) {
                        offset = 26;
                        continue;
                    }
                case 18:
                    r1 = movs(r1, 1);
                    r0 = ldr(mp_hal_stdout_tx_strn_cooked + 40);
                    bl(this::mp_hal_stdout_tx_strn, mp_hal_stdout_tx_strn_cooked + 26 | 1, 26);
                    return;
                case 26:
                    r0 = movs(r0, r4);
                    r6 = adds(r4, 1);
                    r1 = movs(r1, 1);
                    bl(this::mp_hal_stdout_tx_strn, mp_hal_stdout_tx_strn_cooked + 36 | 1, 36);
                    return;
                case 36:
                    r4 = movs(r4, r6);
                    step();
                    offset = 6;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134324516, size=18, name='mp_hal_stdout_tx_str', path='build/lib/utils/stdout_helpers.o', has_indirect=False)
    protected void mp_hal_stdout_tx_str(int offset) throws Exception
    {
        while (true)
        {
            pc = mp_hal_stdout_tx_str + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4);
                    r4 = movs(r4, r0);
                    bl(this::strlen, mp_hal_stdout_tx_str + 8 | 1, 8);
                    return;
                case 8:
                    r1 = movs(r1, r0);
                    r0 = movs(r0, r4);
                    bl(this::mp_hal_stdout_tx_strn, mp_hal_stdout_tx_str + 16 | 1, 16);
                    return;
                case 16:
                    pop(true, R4);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134324536, size=28, name='mp_hal_set_interrupt_char', path='build/lib/utils/interrupt_char.o', has_indirect=False)
    protected void mp_hal_set_interrupt_char(int offset) throws Exception
    {
        while (true)
        {
            pc = mp_hal_set_interrupt_char + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4);
                    r4 = movs(r4, r0);
                    r3 = adds(r0, 1);
                    if (beq()) {
                        offset = 14;
                        continue;
                    }
                case 8:
                    r0 = ldr(mp_hal_set_interrupt_char + 20);
                    bl(this::mp_obj_exception_clear_traceback, mp_hal_set_interrupt_char + 14 | 1, 14);
                    return;
                case 14:
                    r3 = ldr(mp_hal_set_interrupt_char + 24); // mp_interrupt_char;
                    str(r3, r4);
                    pop(true, R4);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134324564, size=308, name='parse_compile_execute', path='build/lib/utils/pyexec.o', has_indirect=False)
    protected void parse_compile_execute(int offset) throws Exception
    {
        while (true)
        {
            pc = parse_compile_execute + offset;
            switch (offset)
            {
                case 0:
                    r3 = movs(r3, 0);
                    push(true, r4, r5, r6, r7);
                    r6 = ldr(parse_compile_execute + 280); // pyexec_system_exit;
                    sp = sub(sp, 92);
                    r4 = movs(r4, r0);
                    r0 = add(sp, 36);
                    str(sp + 12, r1);
                    r5 = movs(r5, r2);
                    str(r6, r3);
                    r7 = movs(r7, 1);
                    bl(this::nlr_push, parse_compile_execute + 24 | 1, 24);
                    return;
                case 24:
                    r7 = ands(r7, r5);
                    r1 = subs(r0, 0);
                    if (bne()) {
                        offset = 226;
                        continue;
                    }
                case 30:
                    r3 = movs(r3, 8);
                    r3 = ands(r3, r5);
                    if (beq()) {
                        offset = 170;
                        continue;
                    }
                case 36:
                    r2 = movs(r2, r0);
                    r0 = movs(r0, r4);
                    bl(this::mp_make_function_from_raw_code, parse_compile_execute + 44 | 1, 44);
                    return;
                case 44:
                    r6 = movs(r6, r0);
                    r0 = movs(r0, 3);
                    bl(this::mp_hal_set_interrupt_char, parse_compile_execute + 52 | 1, 52);
                    return;
                case 52:
                    bl(this::mp_hal_ticks_ms, parse_compile_execute + 56 | 1, 56);
                    return;
                case 56:
                    r4 = movs(r4, r0);
                    r0 = movs(r0, r6);
                    bl(this::mp_call_function_0, parse_compile_execute + 64 | 1, 64);
                    return;
                case 64:
                    r0 = movs(r0, 1);
                    r0 = rsbs(r0);
                    bl(this::mp_hal_set_interrupt_char, parse_compile_execute + 72 | 1, 72);
                    return;
                case 72:
                    r6 = movs(r6, 1);
                    bl(this::nlr_pop, parse_compile_execute + 78 | 1, 78);
                    return;
                case 78:
                    cmp(r7, 0);
                    if (beq()) {
                        offset = 92;
                        continue;
                    }
                case 82:
                    r1 = movs(r1, r6);
                    r0 = ldr(parse_compile_execute + 284); // parse_compile_execute.str1.1;
                    bl(this::mp_hal_stdout_tx_strn, parse_compile_execute + 90 | 1, 90);
                    return;
                case 90:
                    r6 = movs(r6, r7);
                case 92:
                    r3 = lsls(r5, 30);
                    if (bpl()) {
                        offset = 152;
                        continue;
                    }
                case 96:
                    r3 = ldr(parse_compile_execute + 288); // repl_display_debugging_info;
                    r3 = ldrb(r3);
                    cmp(r3, 0);
                    if (beq()) {
                        offset = 152;
                        continue;
                    }
                case 104:
                    bl(this::mp_hal_ticks_ms, parse_compile_execute + 108 | 1, 108);
                    return;
                case 108:
                    r1 = subs(r0, r4);
                    r0 = ldr(parse_compile_execute + 292);
                    bl(this::printf, parse_compile_execute + 116 | 1, 116);
                    return;
                case 116:
                    r3 = add(sp, 28);
                    r2 = add(sp, 24);
                    r1 = add(sp, 20);
                    r0 = add(sp, 16);
                    bl(this::qstr_pool_info, parse_compile_execute + 128 | 1, 128);
                    return;
                case 128:
                    r3 = ldr(sp + 28);
                    r2 = ldr(sp + 20);
                    r1 = ldr(sp + 16);
                    str(sp, r3);
                    r0 = ldr(parse_compile_execute + 296);
                    r3 = ldr(sp + 24);
                    bl(this::printf, parse_compile_execute + 144 | 1, 144);
                    return;
                case 144:
                    bl(this::gc_collect, parse_compile_execute + 148 | 1, 148);
                    return;
                case 148:
                    bl(this::gc_dump_info, parse_compile_execute + 152 | 1, 152);
                    return;
                case 152:
                    cmp(r7, 0);
                    if (beq()) {
                        offset = 164;
                        continue;
                    }
                case 156:
                    r1 = movs(r1, 1);
                    r0 = ldr(parse_compile_execute + 284); // parse_compile_execute.str1.1;
                    bl(this::mp_hal_stdout_tx_strn, parse_compile_execute + 164 | 1, 164);
                    return;
                case 164:
                    r0 = movs(r0, r6);
                    sp = add(sp, 92);
                    pop(true, R4, R5, R6, R7);
                    return;
                case 170:
                    r2 = lsls(r5, 27);
                    if (bpl()) {
                        offset = 214;
                        continue;
                    }
                case 174:
                    r2 = ldr(r4 + 4);
                    r1 = ldr(r4 + 8);
                    r0 = movs(r0, 107);
                    bl(this::mp_lexer_new_from_str_len, parse_compile_execute + 184 | 1, 184);
                    return;
                case 184:
                    r4 = movs(r4, r0);
                case 186:
                    r6 = ldr(r4);
                    r2 = ldr(sp + 12);
                    r1 = movs(r1, r4);
                    r0 = add(sp, 28);
                    bl(this::mp_parse, parse_compile_execute + 198 | 1, 198);
                    return;
                case 198:
                    r3 = lsls(r5, 29);
                    r3 = lsrs(r3, 31);
                    r2 = movs(r2, 0);
                    r1 = movs(r1, r6);
                    r0 = add(sp, 28);
                    bl(this::mp_compile, parse_compile_execute + 212 | 1, 212);
                    return;
                case 212:
                    step();
                    offset = 44;
                    continue;
                case 214:
                    r3 = lsls(r5, 26);
                    if (bpl()) {
                        offset = 186;
                        continue;
                    }
                case 218:
                    r0 = movs(r0, r4);
                    bl(this::mp_lexer_new_from_file, parse_compile_execute + 224 | 1, 224);
                    return;
                case 224:
                    step();
                    offset = 184;
                    continue;
                case 226:
                    r0 = movs(r0, 1);
                    r0 = rsbs(r0);
                    bl(this::mp_hal_set_interrupt_char, parse_compile_execute + 234 | 1, 234);
                    return;
                case 234:
                    cmp(r7, 0);
                    if (beq()) {
                        offset = 246;
                        continue;
                    }
                case 238:
                    r1 = movs(r1, 1);
                    r0 = ldr(parse_compile_execute + 284); // parse_compile_execute.str1.1;
                    bl(this::mp_hal_stdout_tx_strn, parse_compile_execute + 246 | 1, 246);
                    return;
                case 246:
                    r3 = ldr(sp + 40);
                    r1 = ldr(parse_compile_execute + 300); // mp_type_SystemExit;
                    r0 = ldr(r3);
                    bl(this::mp_obj_is_subclass_fast, parse_compile_execute + 256 | 1, 256);
                    return;
                case 256:
                    r4 = subs(r0, 0);
                    if (beq()) {
                        offset = 266;
                        continue;
                    }
                case 260:
                    r6 = ldr(r6);
                    r4 = movs(r4, 0);
                    step();
                    offset = 92;
                    continue;
                case 266:
                    r1 = ldr(sp + 40);
                    r0 = ldr(parse_compile_execute + 304); // mp_plat_print;
                    bl(this::mp_obj_print_exception, parse_compile_execute + 274 | 1, 274);
                    return;
                case 274:
                    r6 = movs(r6, r4);
                    step();
                    offset = 92;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134324872, size=160, name='pyexec_raw_repl', path='build/lib/utils/pyexec.o', has_indirect=False)
    protected void pyexec_raw_repl(int offset) throws Exception
    {
        while (true)
        {
            pc = pyexec_raw_repl + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4);
                    sp = sub(sp, 24);
                    r1 = movs(r1, 32);
                    r0 = add(sp, 8);
                    r4 = movs(r4, 128);
                    bl(this::vstr_init, pyexec_raw_repl + 14 | 1, 14);
                    return;
                case 14:
                    r4 = lsls(r4, 1);
                case 16:
                    r0 = ldr(pyexec_raw_repl + 140); // pyexec_raw_repl.str1.1;
                    bl(this::mp_hal_stdout_tx_str, pyexec_raw_repl + 22 | 1, 22);
                    return;
                case 22:
                    r3 = movs(r3, 0);
                    r0 = ldr(pyexec_raw_repl + 144);
                    str(sp + 12, r3);
                    bl(this::mp_hal_stdout_tx_str, pyexec_raw_repl + 32 | 1, 32);
                    return;
                case 32:
                    bl(this::mp_hal_stdin_rx_chr, pyexec_raw_repl + 36 | 1, 36);
                    return;
                case 36:
                    cmp(r0, 1);
                    if (beq()) {
                        offset = 16;
                        continue;
                    }
                case 40:
                    cmp(r0, 2);
                    if (bne()) {
                        offset = 68;
                        continue;
                    }
                case 44:
                    r0 = ldr(pyexec_raw_repl + 148);
                    bl(this::mp_hal_stdout_tx_str, pyexec_raw_repl + 50 | 1, 50);
                    return;
                case 50:
                    r0 = add(sp, 8);
                    bl(this::vstr_clear, pyexec_raw_repl + 56 | 1, 56);
                    return;
                case 56:
                    r2 = movs(r2, 1);
                    r0 = movs(r0, 0);
                    r3 = ldr(pyexec_raw_repl + 152); // pyexec_mode_kind;
                    strb(r3, r2);
                case 64:
                    sp = add(sp, 24);
                    pop(true, R4);
                    return;
                case 68:
                    cmp(r0, 3);
                    if (bne()) {
                        offset = 78;
                        continue;
                    }
                case 72:
                    r3 = movs(r3, 0);
                    str(sp + 12, r3);
                    step();
                    offset = 32;
                    continue;
                case 78:
                    cmp(r0, 4);
                    if (beq()) {
                        offset = 92;
                        continue;
                    }
                case 82:
                    r1 = uxtb(r0);
                    r0 = add(sp, 8);
                    bl(this::vstr_add_byte, pyexec_raw_repl + 90 | 1, 90);
                    return;
                case 90:
                    step();
                    offset = 32;
                    continue;
                case 92:
                    r0 = ldr(pyexec_raw_repl + 156);
                    bl(this::mp_hal_stdout_tx_str, pyexec_raw_repl + 98 | 1, 98);
                    return;
                case 98:
                    r3 = ldr(sp + 12);
                    str(sp + 4, r3);
                    cmp(r3, 0);
                    if (bne()) {
                        offset = 124;
                        continue;
                    }
                case 106:
                    r0 = ldr(pyexec_raw_repl + 148);
                    bl(this::mp_hal_stdout_tx_str, pyexec_raw_repl + 112 | 1, 112);
                    return;
                case 112:
                    r0 = add(sp, 8);
                    bl(this::vstr_clear, pyexec_raw_repl + 118 | 1, 118);
                    return;
                case 118:
                    r0 = movs(r0, 128);
                    r0 = lsls(r0, 1);
                    step();
                    offset = 64;
                    continue;
                case 124:
                    r2 = movs(r2, 17);
                    r1 = movs(r1, 1);
                    r0 = add(sp, 8);
                    bl(this::parse_compile_execute, pyexec_raw_repl + 134 | 1, 134);
                    return;
                case 134:
                    tst(r0, r4);
                    if (beq()) {
                        offset = 22;
                        continue;
                    }
                case 138:
                    step();
                    offset = 64;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134325032, size=272, name='pyexec_friendly_repl', path='build/lib/utils/pyexec.o', has_indirect=False)
    protected void pyexec_friendly_repl(int offset) throws Exception
    {
        while (true)
        {
            pc = pyexec_friendly_repl + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5);
                    sp = sub(sp, 28);
                    r1 = movs(r1, 32);
                    r0 = add(sp, 8);
                    r5 = movs(r5, 128);
                    bl(this::vstr_init, pyexec_friendly_repl + 14 | 1, 14);
                    return;
                case 14:
                    r5 = lsls(r5, 1);
                case 16:
                    r0 = ldr(pyexec_friendly_repl + 240); // pyexec_friendly_repl.str1.1;
                    bl(this::mp_hal_stdout_tx_str, pyexec_friendly_repl + 22 | 1, 22);
                    return;
                case 22:
                    r0 = ldr(pyexec_friendly_repl + 244);
                case 24:
                    bl(this::mp_hal_stdout_tx_str, pyexec_friendly_repl + 28 | 1, 28);
                    return;
                case 28:
                    r4 = movs(r4, 0);
                    r1 = ldr(pyexec_friendly_repl + 248);
                    r0 = add(sp, 8);
                    str(sp + 12, r4);
                    bl(this::readline, pyexec_friendly_repl + 40 | 1, 40);
                    return;
                case 40:
                    cmp(r0, 1);
                    if (bne()) {
                        offset = 66;
                        continue;
                    }
                case 44:
                    r0 = ldr(pyexec_friendly_repl + 252);
                    bl(this::mp_hal_stdout_tx_str, pyexec_friendly_repl + 50 | 1, 50);
                    return;
                case 50:
                    r0 = add(sp, 8);
                    bl(this::vstr_clear, pyexec_friendly_repl + 56 | 1, 56);
                    return;
                case 56:
                    r0 = movs(r0, r4);
                    r3 = ldr(pyexec_friendly_repl + 256); // pyexec_mode_kind;
                    strb(r3, r4);
                case 62:
                    sp = add(sp, 28);
                    pop(true, R4, R5);
                    return;
                case 66:
                    cmp(r0, 2);
                    if (bne()) {
                        offset = 78;
                        continue;
                    }
                case 70:
                    r0 = ldr(pyexec_friendly_repl + 252);
                    bl(this::mp_hal_stdout_tx_str, pyexec_friendly_repl + 76 | 1, 76);
                    return;
                case 76:
                    step();
                    offset = 16;
                    continue;
                case 78:
                    cmp(r0, 3);
                    if (bne()) {
                        offset = 86;
                        continue;
                    }
                case 82:
                    r0 = ldr(pyexec_friendly_repl + 252);
                    step();
                    offset = 24;
                    continue;
                case 86:
                    cmp(r0, 4);
                    if (bne()) {
                        offset = 108;
                        continue;
                    }
                case 90:
                    r0 = ldr(pyexec_friendly_repl + 252);
                    bl(this::mp_hal_stdout_tx_str, pyexec_friendly_repl + 96 | 1, 96);
                    return;
                case 96:
                    r0 = add(sp, 8);
                    bl(this::vstr_clear, pyexec_friendly_repl + 102 | 1, 102);
                    return;
                case 102:
                    r0 = movs(r0, 128);
                    r0 = lsls(r0, 1);
                    step();
                    offset = 62;
                    continue;
                case 108:
                    cmp(r0, 5);
                    if (bne()) {
                        offset = 192;
                        continue;
                    }
                case 112:
                    r0 = ldr(pyexec_friendly_repl + 260);
                    bl(this::mp_hal_stdout_tx_str, pyexec_friendly_repl + 118 | 1, 118);
                    return;
                case 118:
                    str(sp + 12, r4);
                case 120:
                    bl(this::mp_hal_stdin_rx_chr, pyexec_friendly_repl + 124 | 1, 124);
                    return;
                case 124:
                    r3 = mov(sp);
                    r1 = uxtb(r0);
                    r4 = adds(r3, 7);
                    strb(r4, r1);
                    cmp(r1, 3);
                    if (beq()) {
                        offset = 82;
                        continue;
                    }
                case 136:
                    cmp(r1, 4);
                    if (bne()) {
                        offset = 162;
                        continue;
                    }
                case 140:
                    r0 = ldr(pyexec_friendly_repl + 252);
                    bl(this::mp_hal_stdout_tx_str, pyexec_friendly_repl + 146 | 1, 146);
                    return;
                case 146:
                    r1 = movs(r1, 1);
                case 148:
                    r2 = movs(r2, 22);
                    r0 = add(sp, 8);
                    bl(this::parse_compile_execute, pyexec_friendly_repl + 156 | 1, 156);
                    return;
                case 156:
                    tst(r0, r5);
                    if (beq()) {
                        offset = 28;
                        continue;
                    }
                case 160:
                    step();
                    offset = 62;
                    continue;
                case 162:
                    r0 = add(sp, 8);
                    bl(this::vstr_add_byte, pyexec_friendly_repl + 168 | 1, 168);
                    return;
                case 168:
                    r3 = ldrb(r4);
                    cmp(r3, 13);
                    if (bne()) {
                        offset = 182;
                        continue;
                    }
                case 174:
                    r0 = ldr(pyexec_friendly_repl + 264);
                    bl(this::mp_hal_stdout_tx_str, pyexec_friendly_repl + 180 | 1, 180);
                    return;
                case 180:
                    step();
                    offset = 120;
                    continue;
                case 182:
                    r1 = movs(r1, 1);
                    r0 = movs(r0, r4);
                    bl(this::mp_hal_stdout_tx_strn, pyexec_friendly_repl + 190 | 1, 190);
                    return;
                case 190:
                    step();
                    offset = 120;
                    continue;
                case 192:
                    r3 = ldr(sp + 12);
                    cmp(r3, 0);
                    if (beq()) {
                        offset = 28;
                        continue;
                    }
                case 198:
                    r0 = add(sp, 8);
                    bl(this::vstr_null_terminated_str, pyexec_friendly_repl + 204 | 1, 204);
                    return;
                case 204:
                    bl(this::mp_repl_continue_with_input, pyexec_friendly_repl + 208 | 1, 208);
                    return;
                case 208:
                    cmp(r0, 0);
                    if (beq()) {
                        offset = 236;
                        continue;
                    }
                case 212:
                    r1 = movs(r1, 10);
                    r0 = add(sp, 8);
                    bl(this::vstr_add_byte, pyexec_friendly_repl + 220 | 1, 220);
                    return;
                case 220:
                    r1 = ldr(pyexec_friendly_repl + 268);
                    r0 = add(sp, 8);
                    bl(this::readline, pyexec_friendly_repl + 228 | 1, 228);
                    return;
                case 228:
                    cmp(r0, 3);
                    if (beq()) {
                        offset = 82;
                        continue;
                    }
                case 232:
                    cmp(r0, 4);
                    if (bne()) {
                        offset = 198;
                        continue;
                    }
                case 236:
                    r1 = movs(r1, 0);
                    step();
                    offset = 148;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134325304, size=60, name='pyexec_frozen_module', path='build/lib/utils/pyexec.o', has_indirect=False)
    protected void pyexec_frozen_module(int offset) throws Exception
    {
        while (true)
        {
            pc = pyexec_frozen_module + offset;
            switch (offset)
            {
                case 0:
                    push(true, r0, r1, r4);
                    r4 = movs(r4, r0);
                    bl(this::strlen, pyexec_frozen_module + 8 | 1, 8);
                    return;
                case 8:
                    r2 = add(sp, 4);
                    r1 = movs(r1, r0);
                    r0 = movs(r0, r4);
                    bl(this::mp_find_frozen_module, pyexec_frozen_module + 18 | 1, 18);
                    return;
                case 18:
                    r1 = movs(r1, r0);
                    cmp(r0, 1);
                    if (beq()) {
                        offset = 40;
                        continue;
                    }
                case 24:
                    cmp(r0, 2);
                    if (beq()) {
                        offset = 50;
                        continue;
                    }
                case 28:
                    r1 = movs(r1, r4);
                    r0 = ldr(pyexec_frozen_module + 56); // pyexec_frozen_module.str1.1;
                    bl(this::printf, pyexec_frozen_module + 36 | 1, 36);
                    return;
                case 36:
                    r0 = movs(r0, 0);
                    step();
                    offset = 48;
                    continue;
                case 40:
                    r2 = movs(r2, 0);
                case 42:
                    r0 = ldr(sp + 4);
                    bl(this::parse_compile_execute, pyexec_frozen_module + 48 | 1, 48);
                    return;
                case 48:
                    pop(true, R1, R2, R4);
                    return;
                case 50:
                    r2 = movs(r2, 8);
                    r1 = movs(r1, 1);
                    step();
                    offset = 42;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134325364, size=70, name='memcpy', path='build/lib/libc/string0.o', has_indirect=False)
    protected void memcpy(int offset) throws Exception
    {
        while (true)
        {
            pc = memcpy + offset;
            switch (offset)
            {
                case 0:
                    r3 = movs(r3, r0);
                    push(true, r4, r5);
                    r4 = movs(r4, 3);
                    r3 = orrs(r3, r1);
                    r3 = ands(r3, r4);
                    if (beq()) {
                        offset = 28;
                        continue;
                    }
                case 12:
                    r3 = movs(r3, 0);
                case 14:
                    cmp(r3, r2);
                    if (bne()) {
                        offset = 20;
                        continue;
                    }
                case 18:
                    pop(true, R4, R5);
                    return;
                case 20:
                    r4 = ldrb(r1 + r3);
                    strb(r0 + r3, r4);
                    r3 = adds(r3, 1);
                    step();
                    offset = 14;
                    continue;
                case 28:
                    r4 = lsrs(r2, 2);
                    r4 = lsls(r4, 2);
                case 32:
                    cmp(r3, r4);
                    if (bne()) {
                        offset = 62;
                        continue;
                    }
                case 36:
                    r4 = adds(r0, r3);
                    r1 = adds(r1, r3);
                    r3 = lsls(r2, 30);
                    if (bpl()) {
                        offset = 52;
                        continue;
                    }
                case 44:
                    r3 = ldrh(r1);
                    r1 = adds(r1, 2);
                    strh(r4, r3);
                    r4 = adds(r4, 2);
                case 52:
                    r3 = lsls(r2, 31);
                    if (bpl()) {
                        offset = 18;
                        continue;
                    }
                case 56:
                    r3 = ldrb(r1);
                    strb(r4, r3);
                    step();
                    offset = 18;
                    continue;
                case 62:
                    r5 = ldr(r1 + r3);
                    str(r0 + r3, r5);
                    r3 = adds(r3, 4);
                    step();
                    offset = 32;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134325434, size=36, name='memmove', path='build/lib/libc/string0.o', has_indirect=False)
    protected void memmove(int offset) throws Exception
    {
        while (true)
        {
            pc = memmove + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4);
                    cmp(r1, r0);
                    if (bhs()) {
                        offset = 30;
                        continue;
                    }
                case 6:
                    r3 = adds(r1, r2);
                    cmp(r0, r3);
                    if (bhs()) {
                        offset = 30;
                        continue;
                    }
                case 12:
                    r1 = subs(r1, 1);
                    r3 = subs(r0, 1);
                case 16:
                    cmp(r2, 0);
                    if (bne()) {
                        offset = 22;
                        continue;
                    }
                case 20:
                    pop(true, R4);
                    return;
                case 22:
                    r4 = ldrb(r1 + r2);
                    strb(r3 + r2, r4);
                    r2 = subs(r2, 1);
                    step();
                    offset = 16;
                    continue;
                case 30:
                    bl(this::memcpy, memmove + 34 | 1, 34);
                    return;
                case 34:
                    step();
                    offset = 20;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134325470, size=64, name='memset', path='build/lib/libc/string0.o', has_indirect=False)
    protected void memset(int offset) throws Exception
    {
        while (true)
        {
            pc = memset + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5);
                    cmp(r1, 0);
                    if (beq()) {
                        offset = 20;
                        continue;
                    }
                case 6:
                    r3 = movs(r3, r0);
                    r2 = adds(r2, r0);
                case 10:
                    cmp(r2, r3);
                    if (beq()) {
                        offset = 56;
                        continue;
                    }
                case 14:
                    strb(r3, r1);
                    r3 = adds(r3, 1);
                    step();
                    offset = 10;
                    continue;
                case 20:
                    r4 = movs(r4, 3);
                    r5 = movs(r5, r0);
                    r4 = ands(r4, r0);
                    if (bne()) {
                        offset = 6;
                        continue;
                    }
                case 28:
                    r3 = lsrs(r2, 2);
                    r1 = movs(r1, r3);
                case 32:
                    cmp(r1, 0);
                    if (bne()) {
                        offset = 58;
                        continue;
                    }
                case 36:
                    r3 = lsls(r3, 2);
                    r3 = adds(r0, r3);
                    r4 = lsls(r2, 30);
                    if (bpl()) {
                        offset = 48;
                        continue;
                    }
                case 44:
                    strh(r3, r1);
                    r3 = adds(r3, 2);
                case 48:
                    r2 = lsls(r2, 31);
                    if (bpl()) {
                        offset = 56;
                        continue;
                    }
                case 52:
                    r2 = movs(r2, 0);
                    strb(r3, r2);
                case 56:
                    pop(true, R4, R5);
                    return;
                case 58:
                    r5 = stm(r5, r4);
                    r1 = subs(r1, 1);
                    step();
                    offset = 32;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134325534, size=36, name='memcmp', path='build/lib/libc/string0.o', has_indirect=False)
    protected void memcmp(int offset) throws Exception
    {
        while (true)
        {
            pc = memcmp + offset;
            switch (offset)
            {
                case 0:
                    r3 = movs(r3, 0);
                    push(true, r4, r5);
                case 4:
                    cmp(r2, r3);
                    if (bne()) {
                        offset = 12;
                        continue;
                    }
                case 8:
                    r0 = movs(r0, 0);
                case 10:
                    pop(true, R4, R5);
                    return;
                case 12:
                    r5 = ldrb(r0 + r3);
                    r4 = ldrb(r1 + r3);
                    cmp(r5, r4);
                    if (blo()) {
                        offset = 30;
                        continue;
                    }
                case 20:
                    r3 = adds(r3, 1);
                    cmp(r5, r4);
                    if (bls()) {
                        offset = 4;
                        continue;
                    }
                case 26:
                    r0 = movs(r0, 1);
                    step();
                    offset = 10;
                    continue;
                case 30:
                    r0 = movs(r0, 1);
                    r0 = rsbs(r0);
                    step();
                    offset = 10;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134325570, size=18, name='strlen', path='build/lib/libc/string0.o', has_indirect=False)
    protected void strlen(int offset) throws Exception
    {
        while (true)
        {
            pc = strlen + offset;
            switch (offset)
            {
                case 0:
                    r2 = movs(r2, r0);
                    r3 = movs(r3, r0);
                case 4:
                    r1 = ldrb(r3);
                    r0 = subs(r3, r2);
                    cmp(r1, 0);
                    if (bne()) {
                        offset = 14;
                        continue;
                    }
                case 12:
                    bx(lr);
                    return;
                case 14:
                    r3 = adds(r3, 1);
                    step();
                    offset = 4;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134325588, size=46, name='strcmp', path='build/lib/libc/string0.o', has_indirect=False)
    protected void strcmp(int offset) throws Exception
    {
        while (true)
        {
            pc = strcmp + offset;
            switch (offset)
            {
                case 0:
                    r2 = ldrb(r0);
                    r3 = ldrb(r1);
                    cmp(r2, 0);
                    if (bne()) {
                        offset = 32;
                        continue;
                    }
                case 8:
                    cmp(r3, 0);
                    if (beq()) {
                        offset = 38;
                        continue;
                    }
                case 12:
                    r0 = movs(r0, 1);
                    r0 = rsbs(r0);
                    step();
                    offset = 44;
                    continue;
                case 18:
                    r0 = adds(r0, 1);
                    r1 = adds(r1, 1);
                    cmp(r2, r3);
                    if (blo()) {
                        offset = 12;
                        continue;
                    }
                case 26:
                    if (bls()) {
                        offset = 0;
                        continue;
                    }
                case 28:
                    r0 = movs(r0, 1);
                    step();
                    offset = 44;
                    continue;
                case 32:
                    cmp(r3, 0);
                    if (bne()) {
                        offset = 18;
                        continue;
                    }
                case 36:
                    r3 = movs(r3, r2);
                case 38:
                    r0 = movs(r0, r3);
                    r3 = subs(r0, 1);
                    r0 = sbcs(r0, r3);
                case 44:
                    bx(lr);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134325634, size=68, name='strncmp', path='build/lib/libc/string0.o', has_indirect=False)
    protected void strncmp(int offset) throws Exception
    {
        while (true)
        {
            pc = strncmp + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4);
                case 2:
                    r3 = ldrb(r0);
                    cmp(r3, 0);
                    if (beq()) {
                        offset = 38;
                        continue;
                    }
                case 8:
                    r4 = ldrb(r1);
                    cmp(r4, 0);
                    if (beq()) {
                        offset = 62;
                        continue;
                    }
                case 14:
                    cmp(r2, 0);
                    if (bne()) {
                        offset = 22;
                        continue;
                    }
                case 18:
                    r0 = movs(r0, r2);
                case 20:
                    pop(true, R4);
                    return;
                case 22:
                    r0 = adds(r0, 1);
                    r1 = adds(r1, 1);
                    r2 = subs(r2, 1);
                    cmp(r3, r4);
                    if (blo()) {
                        offset = 56;
                        continue;
                    }
                case 32:
                    if (bls()) {
                        offset = 2;
                        continue;
                    }
                case 34:
                    r0 = movs(r0, 1);
                    step();
                    offset = 20;
                    continue;
                case 38:
                    r0 = subs(r2, 0);
                    if (beq()) {
                        offset = 20;
                        continue;
                    }
                case 42:
                    r3 = ldrb(r1);
                    cmp(r3, 0);
                    if (bne()) {
                        offset = 56;
                        continue;
                    }
                case 48:
                    r0 = movs(r0, r3);
                    r3 = subs(r0, 1);
                    r0 = sbcs(r0, r3);
                    step();
                    offset = 20;
                    continue;
                case 56:
                    r0 = movs(r0, 1);
                    r0 = rsbs(r0);
                    step();
                    offset = 20;
                    continue;
                case 62:
                    r0 = subs(r2, 0);
                    if (bne()) {
                        offset = 48;
                        continue;
                    }
                case 66:
                    step();
                    offset = 20;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134325702, size=24, name='strchr', path='build/lib/libc/string0.o', has_indirect=False)
    protected void strchr(int offset) throws Exception
    {
        while (true)
        {
            pc = strchr + offset;
            switch (offset)
            {
                case 0:
                    r2 = uxtb(r1);
                case 2:
                    r3 = ldrb(r0);
                    cmp(r3, 0);
                    if (beq()) {
                        offset = 12;
                        continue;
                    }
                case 8:
                    cmp(r3, r2);
                    if (bne()) {
                        offset = 20;
                        continue;
                    }
                case 12:
                    cmp(r3, r1);
                    if (beq()) {
                        offset = 18;
                        continue;
                    }
                case 16:
                    r0 = movs(r0, 0);
                case 18:
                    bx(lr);
                    return;
                case 20:
                    r0 = adds(r0, 1);
                    step();
                    offset = 2;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134325728, size=48, name='mp_hal_move_cursor_back', path='build/lib/mp-readline/readline.o', has_indirect=False)
    protected void mp_hal_move_cursor_back(int offset) throws Exception
    {
        while (true)
        {
            pc = mp_hal_move_cursor_back + offset;
            switch (offset)
            {
                case 0:
                    push(true, r0, r1, r2);
                    r3 = movs(r3, r0);
                    cmp(r0, 4);
                    if (bhi()) {
                        offset = 18;
                        continue;
                    }
                case 8:
                    r1 = movs(r1, r0);
                    r0 = ldr(mp_hal_move_cursor_back + 40); // mp_hal_move_cursor_back.str1.1;
                case 12:
                    bl(this::mp_hal_stdout_tx_strn, mp_hal_move_cursor_back + 16 | 1, 16);
                    return;
                case 16:
                    pop(true, R0, R1, R2);
                    return;
                case 18:
                    r2 = ldr(mp_hal_move_cursor_back + 44);
                    r1 = movs(r1, 6);
                    r0 = mov(sp);
                    bl(this::snprintf, mp_hal_move_cursor_back + 28 | 1, 28);
                    return;
                case 28:
                    r3 = movs(r3, 68);
                    r2 = mov(sp);
                    r1 = adds(r0, 1);
                    strb(r2 + r0, r3);
                    r0 = mov(sp);
                    step();
                    offset = 12;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134325776, size=36, name='readline_init', path='build/lib/mp-readline/readline.o', has_indirect=False)
    protected void readline_init(int offset) throws Exception
    {
        while (true)
        {
            pc = readline_init + offset;
            switch (offset)
            {
                case 0:
                    r3 = ldr(readline_init + 32); // bss.rl;
                    push(true, r4);
                    r2 = ldr(r0 + 4);
                    str(r3, r0);
                    r0 = movs(r0, 0);
                    str(r3 + 8, r0);
                    strb(r3 + 20, r0);
                    r0 = subs(r0, 1);
                    str(r3 + 12, r0);
                    r0 = movs(r0, r1);
                    str(r3 + 4, r2);
                    str(r3 + 16, r2);
                    str(r3 + 24, r1);
                    bl(this::mp_hal_stdout_tx_str, readline_init + 30 | 1, 30);
                    return;
                case 30:
                    pop(true, R4);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134325812, size=96, name='readline_push_history', path='build/lib/mp-readline/readline.o', has_indirect=False)
    protected void readline_push_history(int offset) throws Exception
    {
        while (true)
        {
            pc = readline_push_history + offset;
            switch (offset)
            {
                case 0:
                    push(true, r3, r4, r5, r6, r7);
                    r3 = ldrb(r0);
                    r6 = movs(r6, r0);
                    cmp(r3, 0);
                    if (beq()) {
                        offset = 90;
                        continue;
                    }
                case 10:
                    r3 = movs(r3, 216);
                    r4 = ldr(readline_push_history + 92); // mp_state_ctx;
                    r3 = lsls(r3, 1);
                    r0 = ldr(r4 + r3);
                    cmp(r0, 0);
                    if (beq()) {
                        offset = 32;
                        continue;
                    }
                case 22:
                    r1 = movs(r1, r6);
                    bl(this::strcmp, readline_push_history + 28 | 1, 28);
                    return;
                case 28:
                    cmp(r0, 0);
                    if (beq()) {
                        offset = 90;
                        continue;
                    }
                case 32:
                    r0 = movs(r0, r6);
                    bl(this::strlen, readline_push_history + 38 | 1, 38);
                    return;
                case 38:
                    r7 = adds(r0, 1);
                    r0 = movs(r0, r7);
                    bl(this::m_malloc_maybe, readline_push_history + 46 | 1, 46);
                    return;
                case 46:
                    r5 = subs(r0, 0);
                    if (beq()) {
                        offset = 90;
                        continue;
                    }
                case 50:
                    r2 = movs(r2, r7);
                    r1 = movs(r1, r6);
                    bl(this::memcpy, readline_push_history + 58 | 1, 58);
                    return;
                case 58:
                    r3 = movs(r3, 0);
                case 60:
                    r2 = adds(r4, r3);
                    r1 = movs(r1, r2);
                    r1 = adds(r1, 201);
                    r1 = adds(r1, 255);
                    r1 = ldr(r1);
                    r2 = adds(r2, 205);
                    r2 = adds(r2, 255);
                    r3 = subs(r3, 4);
                    str(r2, r1);
                    r2 = movs(r2, r3);
                    r2 = adds(r2, 28);
                    if (bne()) {
                        offset = 60;
                        continue;
                    }
                case 84:
                    r3 = movs(r3, 216);
                    r3 = lsls(r3, 1);
                    str(r4 + r3, r5);
                case 90:
                    pop(true, R3, R4, R5, R6, R7);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134325908, size=628, name='readline_process_char', path='build/lib/mp-readline/readline.o', has_indirect=False)
    protected void readline_process_char(int offset) throws Exception
    {
        while (true)
        {
            pc = readline_process_char + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6, r7);
                    r4 = ldr(readline_process_char + 608); // bss.rl;
                    r2 = movs(r2, r0);
                    r0 = ldr(r4);
                    r5 = ldr(r4 + 8);
                    r3 = ldr(r0 + 4);
                    sp = sub(sp, 20);
                    str(sp + 4, r3);
                    cmp(r5, 0);
                    if (beq()) {
                        offset = 22;
                        continue;
                    }
                case 20:
                    step();
                    offset = 276;
                    continue;
                case 22:
                    r3 = subs(r2, 1);
                    cmp(r3, 4);
                    if (bhi()) {
                        offset = 46;
                        continue;
                    }
                case 28:
                    r3 = ldr(r4 + 4);
                    r1 = ldr(sp + 4);
                    cmp(r3, r1);
                    if (beq()) {
                        offset = 78;
                        continue;
                    }
                case 36:
                    cmp(r2, 1);
                    if (bne()) {
                        offset = 42;
                        continue;
                    }
                case 40:
                    step();
                    offset = 524;
                    continue;
                case 42:
                    cmp(r2, 3);
                    if (beq()) {
                        offset = 78;
                        continue;
                    }
                case 46:
                    cmp(r2, 5);
                    if (bne()) {
                        offset = 52;
                        continue;
                    }
                case 50:
                    step();
                    offset = 492;
                    continue;
                case 52:
                    cmp(r2, 13);
                    if (bne()) {
                        offset = 84;
                        continue;
                    }
                case 56:
                    r0 = ldr(readline_process_char + 612);
                    bl(this::mp_hal_stdout_tx_str, readline_process_char + 62 | 1, 62);
                    return;
                case 62:
                    r0 = ldr(r4);
                    bl(this::vstr_null_terminated_str, readline_process_char + 68 | 1, 68);
                    return;
                case 68:
                    r3 = ldr(r4 + 4);
                    r0 = adds(r0, r3);
                    bl(this::readline_push_history, readline_process_char + 76 | 1, 76);
                    return;
                case 76:
                    r2 = movs(r2, 0);
                case 78:
                    r0 = movs(r0, r2);
                    sp = add(sp, 20);
                    pop(true, R4, R5, R6, R7);
                    return;
                case 84:
                    r3 = movs(r3, 1);
                    cmp(r2, 27);
                    if (beq()) {
                        offset = 294;
                        continue;
                    }
                case 90:
                    cmp(r2, 8);
                    if (beq()) {
                        offset = 98;
                        continue;
                    }
                case 94:
                    cmp(r2, 127);
                    if (bne()) {
                        offset = 120;
                        continue;
                    }
                case 98:
                    r1 = ldr(r4 + 16);
                    r3 = ldr(r4 + 4);
                    cmp(r1, r3);
                    if (bls()) {
                        offset = 296;
                        continue;
                    }
                case 106:
                    r1 = subs(r1, 1);
                    r2 = movs(r2, 1);
                    bl(this::vstr_cut_out_bytes, readline_process_char + 114 | 1, 114);
                    return;
                case 114:
                    r7 = movs(r7, 1);
                case 116:
                    r6 = movs(r6, 1);
                    step();
                    offset = 378;
                    continue;
                case 120:
                    cmp(r2, 9);
                    if (bne()) {
                        offset = 258;
                        continue;
                    }
                case 124:
                    r3 = ldr(r4 + 4);
                    r2 = ldr(r4 + 16);
                    r0 = ldr(r0 + 8);
                    r1 = subs(r2, r3);
                    r0 = adds(r0, r3);
                    r2 = ldr(readline_process_char + 616); // mp_plat_print;
                    r3 = add(sp, 12);
                    bl(this::mp_repl_autocomplete, readline_process_char + 142 | 1, 142);
                    return;
                case 142:
                    r6 = subs(r0, 0);
                    if (beq()) {
                        offset = 296;
                        continue;
                    }
                case 146:
                    r7 = movs(r7, 0);
                    r3 = adds(r0, 1);
                    if (bne()) {
                        offset = 230;
                        continue;
                    }
                case 152:
                    r0 = ldr(r4 + 24);
                    bl(this::mp_hal_stdout_tx_str, readline_process_char + 158 | 1, 158);
                    return;
                case 158:
                    r3 = ldr(r4 + 4);
                    r2 = ldr(r4 + 16);
                    r1 = subs(r2, r3);
                    r2 = ldr(r4);
                    r0 = ldr(r2 + 8);
                    r0 = adds(r0, r3);
                    bl(this::mp_hal_stdout_tx_strn, readline_process_char + 174 | 1, 174);
                    return;
                case 174:
                    r3 = ldr(r4);
                    r2 = ldr(sp + 4);
                    r3 = ldr(r3 + 4);
                    cmp(r3, r2);
                    if (bhs()) {
                        offset = 192;
                        continue;
                    }
                case 184:
                    r1 = movs(r1, 3);
                    r0 = ldr(readline_process_char + 620); // readline_process_char.str1.1;
                    bl(this::mp_hal_stdout_tx_strn, readline_process_char + 192 | 1, 192);
                    return;
                case 192:
                    r2 = ldr(r4);
                    r3 = ldr(r4 + 16);
                    r1 = ldr(r2 + 4);
                    r0 = ldr(r2 + 8);
                    r1 = subs(r1, r3);
                    r0 = adds(r0, r3);
                    bl(this::mp_hal_stdout_tx_strn, readline_process_char + 208 | 1, 208);
                    return;
                case 208:
                    r3 = ldr(r4);
                    r0 = ldr(r3 + 4);
                    r3 = ldr(r4 + 16);
                    r0 = subs(r0, r3);
                    r0 = subs(r0, r5);
                    bl(this::mp_hal_move_cursor_back, readline_process_char + 222 | 1, 222);
                    return;
                case 222:
                    r3 = ldr(r4 + 16);
                    r5 = adds(r3, r5);
                    str(r4 + 16, r5);
                    step();
                    offset = 296;
                    continue;
                case 230:
                    r3 = ldr(r4 + 16);
                    r0 = ldr(r4);
                    r1 = adds(r7, r3);
                    r3 = ldr(sp + 12);
                    r7 = adds(r7, 1);
                    r2 = adds(r3, 1);
                    str(sp + 12, r2);
                    r2 = ldrb(r3);
                    bl(this::vstr_ins_byte, readline_process_char + 250 | 1, 250);
                    return;
                case 250:
                    cmp(r6, r7);
                    if (bne()) {
                        offset = 230;
                        continue;
                    }
                case 254:
                    r5 = movs(r5, r6);
                    step();
                    offset = 174;
                    continue;
                case 258:
                    r3 = movs(r3, r2);
                    r3 = subs(r3, 32);
                    cmp(r3, 94);
                    if (bhi()) {
                        offset = 296;
                        continue;
                    }
                case 266:
                    r1 = ldr(r4 + 16);
                    bl(this::vstr_ins_char, readline_process_char + 272 | 1, 272);
                    return;
                case 272:
                    r5 = movs(r5, 1);
                    step();
                    offset = 174;
                    continue;
                case 276:
                    cmp(r5, 1);
                    if (bne()) {
                        offset = 302;
                        continue;
                    }
                case 280:
                    r3 = movs(r3, 4);
                    cmp(r2, 79);
                    if (beq()) {
                        offset = 294;
                        continue;
                    }
                case 286:
                    r3 = movs(r3, 2);
                    cmp(r2, 91);
                    if (beq()) {
                        offset = 294;
                        continue;
                    }
                case 292:
                    r3 = movs(r3, 0);
                case 294:
                    str(r4 + 8, r3);
                case 296:
                    r2 = movs(r2, 1);
                    r2 = rsbs(r2);
                    step();
                    offset = 78;
                    continue;
                case 302:
                    cmp(r5, 2);
                    if (bne()) {
                        offset = 504;
                        continue;
                    }
                case 306:
                    r3 = movs(r3, r2);
                    r3 = subs(r3, 48);
                    cmp(r3, 9);
                    if (bhi()) {
                        offset = 322;
                        continue;
                    }
                case 314:
                    r3 = movs(r3, 3);
                    strb(r4 + 20, r2);
                    str(r4 + 8, r3);
                    step();
                    offset = 296;
                    continue;
                case 322:
                    r5 = movs(r5, 0);
                    str(r4 + 8, r5);
                    cmp(r2, 65);
                    if (bne()) {
                        offset = 392;
                        continue;
                    }
                case 330:
                    r3 = ldr(r4 + 12);
                    cmp(r3, 6);
                    if (bgt()) {
                        offset = 296;
                        continue;
                    }
                case 336:
                    r2 = adds(r3, 1);
                    r1 = ldr(readline_process_char + 624); // mp_state_ctx;
                    r3 = adds(r3, 109);
                    r3 = lsls(r3, 2);
                    r1 = ldr(r3 + r1);
                    cmp(r1, r5);
                    if (beq()) {
                        offset = 296;
                        continue;
                    }
                case 350:
                    r3 = ldr(r4 + 4);
                    str(r4 + 12, r2);
                    str(r0 + 4, r3);
                case 356:
                    bl(this::vstr_add_str, readline_process_char + 360 | 1, 360);
                    return;
                case 360:
                    r3 = ldr(r4 + 4);
                    r2 = ldr(r4 + 16);
                    r7 = movs(r7, 1);
                    r6 = subs(r2, r3);
                    r2 = ldr(r4);
                    r5 = ldr(r2 + 4);
                    r5 = subs(r5, r3);
                    cmp(r6, 0);
                    if (ble()) {
                        offset = 174;
                        continue;
                    }
                case 378:
                    r0 = movs(r0, r6);
                    bl(this::mp_hal_move_cursor_back, readline_process_char + 384 | 1, 384);
                    return;
                case 384:
                    r3 = ldr(r4 + 16);
                    r6 = subs(r3, r6);
                    str(r4 + 16, r6);
                    step();
                    offset = 542;
                    continue;
                case 392:
                    cmp(r2, 66);
                    if (bne()) {
                        offset = 434;
                        continue;
                    }
                case 396:
                    r3 = ldr(r4 + 12);
                    cmp(r3, 0);
                    if (blt()) {
                        offset = 296;
                        continue;
                    }
                case 402:
                    r3 = subs(r3, 1);
                    str(r4 + 12, r3);
                    r2 = ldr(r4 + 4);
                    r3 = ldr(sp + 4);
                    r1 = subs(r3, r2);
                    bl(this::vstr_cut_tail_bytes, readline_process_char + 416 | 1, 416);
                    return;
                case 416:
                    r3 = ldr(r4 + 12);
                    cmp(r3, 0);
                    if (blt()) {
                        offset = 360;
                        continue;
                    }
                case 422:
                    r3 = adds(r3, 108);
                    r2 = ldr(readline_process_char + 624); // mp_state_ctx;
                    r3 = lsls(r3, 2);
                    r1 = ldr(r3 + r2);
                    r0 = ldr(r4);
                    step();
                    offset = 356;
                    continue;
                case 434:
                    cmp(r2, 67);
                    if (bne()) {
                        offset = 468;
                        continue;
                    }
                case 438:
                    r3 = ldr(r4 + 16);
                    r2 = ldr(sp + 4);
                    cmp(r3, r2);
                    r5 = sbcs(r5, r5);
                    r5 = rsbs(r5);
                case 448:
                    cmp(r5, 0);
                    if (ble()) {
                        offset = 296;
                        continue;
                    }
                case 452:
                    r3 = ldr(r4);
                    r1 = movs(r1, r5);
                    r0 = ldr(r3 + 8);
                    r3 = ldr(r4 + 16);
                    r0 = adds(r0, r3);
                    bl(this::mp_hal_stdout_tx_strn, readline_process_char + 466 | 1, 466);
                    return;
                case 466:
                    step();
                    offset = 222;
                    continue;
                case 468:
                    cmp(r2, 68);
                    if (bne()) {
                        offset = 484;
                        continue;
                    }
                case 472:
                    r3 = ldr(r4 + 16);
                    r2 = ldr(r4 + 4);
                    cmp(r3, r2);
                    if (bls()) {
                        offset = 296;
                        continue;
                    }
                case 480:
                    r7 = movs(r7, r5);
                    step();
                    offset = 116;
                    continue;
                case 484:
                    cmp(r2, 72);
                    if (beq()) {
                        offset = 524;
                        continue;
                    }
                case 488:
                    cmp(r2, 70);
                    if (bne()) {
                        offset = 296;
                        continue;
                    }
                case 492:
                    r7 = movs(r7, 0);
                    r3 = ldr(sp + 4);
                    r2 = ldr(r4 + 16);
                    r6 = movs(r6, r7);
                    r5 = subs(r3, r2);
                    step();
                    offset = 534;
                    continue;
                case 504:
                    r1 = movs(r1, 0);
                    cmp(r5, 3);
                    if (bne()) {
                        offset = 590;
                        continue;
                    }
                case 510:
                    cmp(r2, 126);
                    if (bne()) {
                        offset = 584;
                        continue;
                    }
                case 514:
                    r3 = ldrb(r4 + 20);
                    cmp(r3, 49);
                    if (beq()) {
                        offset = 524;
                        continue;
                    }
                case 520:
                    cmp(r3, 55);
                    if (bne()) {
                        offset = 548;
                        continue;
                    }
                case 524:
                    r5 = movs(r5, 0);
                    r7 = movs(r7, r5);
                    r3 = ldr(r4 + 16);
                    r2 = ldr(r4 + 4);
                    r6 = subs(r3, r2);
                case 534:
                    r3 = movs(r3, 0);
                    str(r4 + 8, r3);
                    cmp(r6, r3);
                    if (bgt()) {
                        offset = 378;
                        continue;
                    }
                case 542:
                    cmp(r7, 0);
                    if (beq()) {
                        offset = 448;
                        continue;
                    }
                case 546:
                    step();
                    offset = 174;
                    continue;
                case 548:
                    r2 = movs(r2, r3);
                    r5 = movs(r5, 251);
                    r2 = subs(r2, 52);
                    tst(r2, r5);
                    if (beq()) {
                        offset = 492;
                        continue;
                    }
                case 558:
                    cmp(r3, 51);
                    if (bne()) {
                        offset = 584;
                        continue;
                    }
                case 562:
                    r1 = ldr(r4 + 16);
                    r3 = ldr(sp + 4);
                    cmp(r1, r3);
                    if (bhs()) {
                        offset = 584;
                        continue;
                    }
                case 570:
                    r2 = movs(r2, 1);
                    bl(this::vstr_cut_out_bytes, readline_process_char + 576 | 1, 576);
                    return;
                case 576:
                    r5 = movs(r5, 0);
                    r7 = movs(r7, 1);
                case 580:
                    r6 = movs(r6, r5);
                    step();
                    offset = 534;
                    continue;
                case 584:
                    r5 = movs(r5, 0);
                    r7 = movs(r7, r5);
                    step();
                    offset = 580;
                    continue;
                case 590:
                    cmp(r5, 4);
                    if (bne()) {
                        offset = 604;
                        continue;
                    }
                case 594:
                    cmp(r2, 70);
                    if (beq()) {
                        offset = 492;
                        continue;
                    }
                case 598:
                    cmp(r2, 72);
                    if (beq()) {
                        offset = 524;
                        continue;
                    }
                case 602:
                    step();
                    offset = 292;
                    continue;
                case 604:
                    str(r4 + 8, r1);
                    step();
                    offset = 296;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134326536, size=20, name='readline', path='build/lib/mp-readline/readline.o', has_indirect=False)
    protected void readline(int offset) throws Exception
    {
        while (true)
        {
            pc = readline + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4);
                    bl(this::readline_init, readline + 6 | 1, 6);
                    return;
                case 6:
                    bl(this::mp_hal_stdin_rx_chr, readline + 10 | 1, 10);
                    return;
                case 10:
                    bl(this::readline_process_char, readline + 14 | 1, 14);
                    return;
                case 14:
                    cmp(r0, 0);
                    if (blt()) {
                        offset = 6;
                        continue;
                    }
                case 18:
                    pop(true, R4);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134326556, size=98, name='scalbnf', path='build/lib/libm/math.o', has_indirect=False)
    protected void scalbnf(int offset) throws Exception
    {
        while (true)
        {
            pc = scalbnf + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6);
                    r5 = movs(r5, r1);
                    cmp(r1, 127);
                    if (ble()) {
                        offset = 52;
                        continue;
                    }
                case 8:
                    r1 = movs(r1, 254);
                    r4 = movs(r4, r5);
                    r1 = lsls(r1, 23);
                    r4 = subs(r4, 127);
                    bl(this::__aeabi_fmul, scalbnf + 20 | 1, 20);
                    return;
                case 20:
                    cmp(r4, 127);
                    if (ble()) {
                        offset = 40;
                        continue;
                    }
                case 24:
                    r1 = movs(r1, 254);
                    r4 = subs(r4, 127);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fmul, scalbnf + 34 | 1, 34);
                    return;
                case 34:
                    cmp(r4, 127);
                    if (ble()) {
                        offset = 40;
                        continue;
                    }
                case 38:
                    r4 = movs(r4, 127);
                case 40:
                    r1 = movs(r1, r4);
                    r1 = adds(r1, 127);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fmul, scalbnf + 50 | 1, 50);
                    return;
                case 50:
                    pop(true, R4, R5, R6);
                    return;
                case 52:
                    r3 = movs(r3, r1);
                    r4 = movs(r4, r1);
                    r3 = adds(r3, 126);
                    if (bge()) {
                        offset = 40;
                        continue;
                    }
                case 60:
                    r1 = movs(r1, 128);
                    r4 = adds(r4, 126);
                    r1 = lsls(r1, 16);
                    bl(this::__aeabi_fmul, scalbnf + 70 | 1, 70);
                    return;
                case 70:
                    r3 = movs(r3, r4);
                    r3 = adds(r3, 126);
                    if (bge()) {
                        offset = 40;
                        continue;
                    }
                case 76:
                    r1 = movs(r1, 128);
                    r4 = adds(r4, 126);
                    r1 = lsls(r1, 16);
                    bl(this::__aeabi_fmul, scalbnf + 86 | 1, 86);
                    return;
                case 86:
                    r3 = movs(r3, r4);
                    r3 = adds(r3, 126);
                    if (bge()) {
                        offset = 40;
                        continue;
                    }
                case 92:
                    r4 = movs(r4, 126);
                    r4 = rsbs(r4);
                    step();
                    offset = 40;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134326656, size=1696, name='powf', path='build/lib/libm/math.o', has_indirect=True)
    protected void powf(int offset) throws Exception
    {
        while (true)
        {
            pc = powf + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6, r7);
                    sp = sub(sp, 36);
                    str(sp + 4, r1);
                    r1 = ldr(sp + 4);
                    r7 = adds(r0, 0);
                    r2 = lsls(r1, 1);
                    r2 = lsrs(r2, 1);
                    if (bne()) {
                        offset = 18;
                        continue;
                    }
                case 16:
                    step();
                    offset = 1610;
                    continue;
                case 18:
                    r3 = movs(r3, 254);
                    r6 = movs(r6, r0);
                    r3 = lsls(r3, 22);
                    cmp(r0, r3);
                    if (bne()) {
                        offset = 30;
                        continue;
                    }
                case 28:
                    step();
                    offset = 1610;
                    continue;
                case 30:
                    r3 = lsls(r0, 1);
                    r0 = movs(r0, 255);
                    str(sp, r3);
                    r4 = lsrs(r3, 1);
                    r0 = lsls(r0, 23);
                    cmp(r4, r0);
                    if (bgt()) {
                        offset = 48;
                        continue;
                    }
                case 44:
                    cmp(r2, r0);
                    if (ble()) {
                        offset = 60;
                        continue;
                    }
                case 48:
                    r1 = ldr(sp + 4);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fadd, powf + 56 | 1, 56);
                    return;
                case 56:
                    sp = add(sp, 36);
                    pop(true, R4, R5, R6, R7);
                    return;
                case 60:
                    r5 = movs(r5, 0);
                    cmp(r7, r5);
                    if (bge()) {
                        offset = 134;
                        continue;
                    }
                case 66:
                    r3 = ldr(powf + 380);
                    cmp(r2, r3);
                    if (bgt()) {
                        offset = 132;
                        continue;
                    }
                case 72:
                    r0 = ldr(powf + 384);
                    cmp(r2, r0);
                    if (ble()) {
                        offset = 106;
                        continue;
                    }
                case 78:
                    r3 = movs(r3, 150);
                    r0 = asrs(r2, 23);
                    r0 = subs(r3, r0);
                    r3 = movs(r3, r2);
                    r3 = asrs(r3, r0);
                    r12 = mov(r3);
                    r3 = lsls(r3, r0);
                    cmp(r3, r2);
                    if (bne()) {
                        offset = 106;
                        continue;
                    }
                case 96:
                    r3 = mov(r12);
                    r0 = movs(r0, 2);
                    r5 = adds(r5, 1);
                    r3 = ands(r3, r5);
                    r5 = subs(r0, r3);
                case 106:
                    r0 = movs(r0, 254);
                    r0 = lsls(r0, 22);
                    cmp(r2, r0);
                    if (bne()) {
                        offset = 182;
                        continue;
                    }
                case 114:
                    r0 = adds(r7, 0);
                    cmp(r1, 0);
                    if (bge()) {
                        offset = 56;
                        continue;
                    }
                case 120:
                    r0 = movs(r0, 254);
                    r1 = adds(r7, 0);
                    r0 = lsls(r0, 22);
                case 126:
                    bl(this::__aeabi_fdiv, powf + 130 | 1, 130);
                    return;
                case 130:
                    step();
                    offset = 56;
                    continue;
                case 132:
                    r5 = movs(r5, 2);
                case 134:
                    cmp(r2, r0);
                    if (bne()) {
                        offset = 106;
                        continue;
                    }
                case 138:
                    r0 = movs(r0, 254);
                    r0 = lsls(r0, 22);
                    cmp(r4, r0);
                    if (bne()) {
                        offset = 148;
                        continue;
                    }
                case 146:
                    step();
                    offset = 1610;
                    continue;
                case 148:
                    if (ble()) {
                        offset = 160;
                        continue;
                    }
                case 150:
                    r0 = ldr(sp + 4);
                    cmp(r1, 0);
                    if (bge()) {
                        offset = 56;
                        continue;
                    }
                case 156:
                    r0 = movs(r0, 0);
                    step();
                    offset = 56;
                    continue;
                case 160:
                    cmp(r4, 0);
                    if (beq()) {
                        offset = 200;
                        continue;
                    }
                case 164:
                    cmp(r1, 0);
                    if (bge()) {
                        offset = 156;
                        continue;
                    }
                case 168:
                    r2 = movs(r2, 128);
                    r2 = lsls(r2, 24);
                    r12 = mov(r2);
                    r3 = ldr(sp + 4);
                    r3 = add(r3, r12);
                    r0 = movs(r0, r3);
                    step();
                    offset = 56;
                    continue;
                case 182:
                    r0 = movs(r0, 128);
                    r0 = lsls(r0, 23);
                    cmp(r1, r0);
                    if (bne()) {
                        offset = 200;
                        continue;
                    }
                case 190:
                    r1 = adds(r7, 0);
                    r0 = adds(r7, 0);
                case 194:
                    bl(this::__aeabi_fmul, powf + 198 | 1, 198);
                    return;
                case 198:
                    step();
                    offset = 56;
                    continue;
                case 200:
                    r0 = movs(r0, 252);
                    r0 = lsls(r0, 22);
                    cmp(r1, r0);
                    if (bne()) {
                        offset = 220;
                        continue;
                    }
                case 208:
                    cmp(r6, 0);
                    if (blt()) {
                        offset = 220;
                        continue;
                    }
                case 212:
                    r0 = adds(r7, 0);
                    bl(this::sqrtf, powf + 218 | 1, 218);
                    return;
                case 218:
                    step();
                    offset = 56;
                    continue;
                case 220:
                    r3 = lsls(r7, 1);
                    r0 = lsrs(r3, 1);
                    cmp(r4, 0);
                    if (beq()) {
                        offset = 246;
                        continue;
                    }
                case 228:
                    r3 = lsls(r7, 2);
                    r3 = lsrs(r3, 2);
                    str(sp, r3);
                    r3 = movs(r3, 254);
                    r3 = lsls(r3, 22);
                    r12 = mov(r3);
                    r3 = ldr(sp);
                    cmp(r3, r12);
                    if (bne()) {
                        offset = 296;
                        continue;
                    }
                case 246:
                    cmp(r1, 0);
                    if (bge()) {
                        offset = 260;
                        continue;
                    }
                case 250:
                    r1 = adds(r0, 0);
                    r0 = movs(r0, 254);
                    r0 = lsls(r0, 22);
                    bl(this::__aeabi_fdiv, powf + 260 | 1, 260);
                    return;
                case 260:
                    cmp(r6, 0);
                    if (bge()) {
                        offset = 56;
                        continue;
                    }
                case 264:
                    r3 = ldr(powf + 388);
                    r4 = adds(r4, r3);
                    r4 = orrs(r4, r5);
                    if (bne()) {
                        offset = 282;
                        continue;
                    }
                case 272:
                    r1 = adds(r0, 0);
                case 274:
                    bl(this::__aeabi_fsub, powf + 278 | 1, 278);
                    return;
                case 278:
                    r1 = adds(r0, 0);
                    step();
                    offset = 126;
                    continue;
                case 282:
                    cmp(r5, 1);
                    if (beq()) {
                        offset = 288;
                        continue;
                    }
                case 286:
                    step();
                    offset = 56;
                    continue;
                case 288:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 24);
                    r0 = adds(r0, r3);
                    step();
                    offset = 56;
                    continue;
                case 296:
                    cmp(r6, 0);
                    if (bge()) {
                        offset = 350;
                        continue;
                    }
                case 300:
                    cmp(r5, 0);
                    if (bne()) {
                        offset = 310;
                        continue;
                    }
                case 304:
                    r1 = adds(r7, 0);
                    r0 = adds(r7, 0);
                    step();
                    offset = 274;
                    continue;
                case 310:
                    cmp(r5, 1);
                    if (bne()) {
                        offset = 350;
                        continue;
                    }
                case 314:
                    r3 = ldr(powf + 392);
                case 316:
                    str(sp, r3);
                    r3 = movs(r3, 154);
                    r3 = lsls(r3, 23);
                    cmp(r2, r3);
                    if (bgt()) {
                        offset = 328;
                        continue;
                    }
                case 326:
                    step();
                    offset = 1028;
                    continue;
                case 328:
                    r3 = ldr(powf + 396);
                    cmp(r4, r3);
                    if (bgt()) {
                        offset = 356;
                        continue;
                    }
                case 334:
                    cmp(r1, 0);
                    if (bge()) {
                        offset = 366;
                        continue;
                    }
                case 338:
                    r1 = ldr(powf + 400);
                    r0 = ldr(sp);
                    bl(this::__aeabi_fmul, powf + 346 | 1, 346);
                    return;
                case 346:
                    r1 = ldr(powf + 400);
                    step();
                    offset = 194;
                    continue;
                case 350:
                    r3 = movs(r3, 254);
                    r3 = lsls(r3, 22);
                    step();
                    offset = 316;
                    continue;
                case 356:
                    r3 = ldr(powf + 404);
                    cmp(r4, r3);
                    if (ble()) {
                        offset = 412;
                        continue;
                    }
                case 362:
                    cmp(r1, 0);
                    if (bgt()) {
                        offset = 338;
                        continue;
                    }
                case 366:
                    r1 = ldr(powf + 408);
                    r0 = ldr(sp);
                    bl(this::__aeabi_fmul, powf + 374 | 1, 374);
                    return;
                case 374:
                    r1 = ldr(powf + 408);
                    step();
                    offset = 194;
                    continue;
                case 412:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fsub, powf + 420 | 1, 420);
                    return;
                case 420:
                    r1 = ldr(powf + 972);
                    r4 = adds(r0, 0);
                    bl(this::__aeabi_fmul, powf + 428 | 1, 428);
                    return;
                case 428:
                    r1 = ldr(powf + 976);
                    r5 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, powf + 438 | 1, 438);
                    return;
                case 438:
                    r1 = movs(r1, 250);
                    r6 = adds(r0, 0);
                    r1 = lsls(r1, 22);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, powf + 450 | 1, 450);
                    return;
                case 450:
                    r1 = adds(r0, 0);
                    r0 = ldr(powf + 980);
                    bl(this::__aeabi_fsub, powf + 458 | 1, 458);
                    return;
                case 458:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, powf + 464 | 1, 464);
                    return;
                case 464:
                    r1 = adds(r0, 0);
                    r0 = movs(r0, 252);
                    r0 = lsls(r0, 22);
                    bl(this::__aeabi_fsub, powf + 474 | 1, 474);
                    return;
                case 474:
                    r1 = adds(r4, 0);
                    r7 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, powf + 484 | 1, 484);
                    return;
                case 484:
                    r1 = adds(r0, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fmul, powf + 492 | 1, 492);
                    return;
                case 492:
                    r1 = ldr(powf + 984);
                    bl(this::__aeabi_fmul, powf + 498 | 1, 498);
                    return;
                case 498:
                    r1 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fsub, powf + 506 | 1, 506);
                    return;
                case 506:
                    r1 = adds(r0, 0);
                    r6 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fadd, powf + 516 | 1, 516);
                    return;
                case 516:
                    r4 = lsrs(r0, 12);
                    r4 = lsls(r4, 12);
                    r1 = adds(r5, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, powf + 528 | 1, 528);
                    return;
                case 528:
                    r1 = adds(r0, 0);
                    r0 = adds(r6, 0);
                case 532:
                    bl(this::__aeabi_fsub, powf + 536 | 1, 536);
                    return;
                case 536:
                    r3 = ldr(sp + 4);
                    r6 = adds(r0, 0);
                    r5 = lsrs(r3, 12);
                    r5 = lsls(r5, 12);
                    r1 = adds(r5, 0);
                    r0 = ldr(sp + 4);
                    bl(this::__aeabi_fsub, powf + 552 | 1, 552);
                    return;
                case 552:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, powf + 558 | 1, 558);
                    return;
                case 558:
                    r1 = ldr(sp + 4);
                    r7 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fmul, powf + 568 | 1, 568);
                    return;
                case 568:
                    r1 = adds(r0, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fadd, powf + 576 | 1, 576);
                    return;
                case 576:
                    r1 = adds(r5, 0);
                    r7 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, powf + 586 | 1, 586);
                    return;
                case 586:
                    str(sp + 4, r0);
                    r1 = adds(r0, 0);
                    r6 = adds(r0, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fadd, powf + 598 | 1, 598);
                    return;
                case 598:
                    r3 = movs(r3, 134);
                    r5 = adds(r0, 0);
                    str(sp + 8, r0);
                    r3 = lsls(r3, 23);
                    cmp(r0, r3);
                    if (ble()) {
                        offset = 612;
                        continue;
                    }
                case 610:
                    step();
                    offset = 338;
                    continue;
                case 612:
                    if (beq()) {
                        offset = 616;
                        continue;
                    }
                case 614:
                    step();
                    offset = 1566;
                    continue;
                case 616:
                    r1 = ldr(powf + 988);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fadd, powf + 624 | 1, 624);
                    return;
                case 624:
                    r1 = adds(r6, 0);
                    r4 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fsub, powf + 634 | 1, 634);
                    return;
                case 634:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fcmpgt, powf + 642 | 1, 642);
                    return;
                case 642:
                    cmp(r0, 0);
                    if (beq()) {
                        offset = 648;
                        continue;
                    }
                case 646:
                    step();
                    offset = 338;
                    continue;
                case 648:
                    r2 = movs(r2, 252);
                    r3 = lsls(r5, 1);
                    r3 = lsrs(r3, 1);
                    r2 = lsls(r2, 22);
                    r4 = movs(r4, 0);
                    cmp(r3, r2);
                    if (ble()) {
                        offset = 718;
                        continue;
                    }
                case 662:
                    r4 = movs(r4, 128);
                    r4 = lsls(r4, 16);
                    r2 = movs(r2, r4);
                    r3 = asrs(r3, 23);
                    r3 = subs(r3, 126);
                    r2 = asrs(r2, r3);
                    r5 = adds(r2, r5);
                    r3 = asrs(r5, 23);
                    r3 = uxtb(r3);
                    r2 = ldr(powf + 992);
                    r3 = subs(r3, 127);
                    r2 = asrs(r2, r3);
                    r1 = movs(r1, r5);
                    r1 = bics(r1, r2);
                    r2 = movs(r2, 23);
                    r5 = lsls(r5, 9);
                    r5 = lsrs(r5, 9);
                    r3 = subs(r2, r3);
                    r4 = orrs(r4, r5);
                    r4 = asrs(r4, r3);
                    r3 = ldr(sp + 8);
                    cmp(r3, 0);
                    if (bge()) {
                        offset = 710;
                        continue;
                    }
                case 708:
                    r4 = rsbs(r4);
                case 710:
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fsub, powf + 716 | 1, 716);
                    return;
                case 716:
                    str(sp + 4, r0);
                case 718:
                    r1 = adds(r7, 0);
                    r0 = ldr(sp + 4);
                    bl(this::__aeabi_fadd, powf + 726 | 1, 726);
                    return;
                case 726:
                    r5 = lsrs(r0, 15);
                    r5 = lsls(r5, 15);
                    r1 = ldr(powf + 996);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fmul, powf + 738 | 1, 738);
                    return;
                case 738:
                    r1 = ldr(sp + 4);
                    r6 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fsub, powf + 748 | 1, 748);
                    return;
                case 748:
                    r1 = adds(r0, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fsub, powf + 756 | 1, 756);
                    return;
                case 756:
                    r1 = ldr(powf + 1000);
                    bl(this::__aeabi_fmul, powf + 762 | 1, 762);
                    return;
                case 762:
                    r1 = ldr(powf + 1004);
                    r7 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fmul, powf + 772 | 1, 772);
                    return;
                case 772:
                    r1 = adds(r0, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fadd, powf + 780 | 1, 780);
                    return;
                case 780:
                    r7 = adds(r0, 0);
                    r1 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fadd, powf + 790 | 1, 790);
                    return;
                case 790:
                    r1 = adds(r6, 0);
                    r5 = adds(r0, 0);
                    bl(this::__aeabi_fsub, powf + 798 | 1, 798);
                    return;
                case 798:
                    r1 = adds(r0, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fsub, powf + 806 | 1, 806);
                    return;
                case 806:
                    r1 = adds(r5, 0);
                    r6 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fmul, powf + 816 | 1, 816);
                    return;
                case 816:
                    r1 = ldr(powf + 1008);
                    r7 = adds(r0, 0);
                    bl(this::__aeabi_fmul, powf + 824 | 1, 824);
                    return;
                case 824:
                    r1 = ldr(powf + 1012);
                    bl(this::__aeabi_fsub, powf + 830 | 1, 830);
                    return;
                case 830:
                    r1 = adds(r7, 0);
                    bl(this::__aeabi_fmul, powf + 836 | 1, 836);
                    return;
                case 836:
                    r1 = ldr(powf + 1016);
                    bl(this::__aeabi_fadd, powf + 842 | 1, 842);
                    return;
                case 842:
                    r1 = adds(r7, 0);
                    bl(this::__aeabi_fmul, powf + 848 | 1, 848);
                    return;
                case 848:
                    r1 = ldr(powf + 1020);
                    bl(this::__aeabi_fsub, powf + 854 | 1, 854);
                    return;
                case 854:
                    r1 = adds(r7, 0);
                    bl(this::__aeabi_fmul, powf + 860 | 1, 860);
                    return;
                case 860:
                    r1 = ldr(powf + 1024);
                    bl(this::__aeabi_fadd, powf + 866 | 1, 866);
                    return;
                case 866:
                    r1 = adds(r7, 0);
                    bl(this::__aeabi_fmul, powf + 872 | 1, 872);
                    return;
                case 872:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fsub, powf + 880 | 1, 880);
                    return;
                case 880:
                    r7 = adds(r0, 0);
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fmul, powf + 890 | 1, 890);
                    return;
                case 890:
                    r1 = movs(r1, 128);
                    str(sp + 4, r0);
                    r1 = lsls(r1, 23);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fsub, powf + 902 | 1, 902);
                    return;
                case 902:
                    r1 = adds(r0, 0);
                    r0 = ldr(sp + 4);
                    bl(this::__aeabi_fdiv, powf + 910 | 1, 910);
                    return;
                case 910:
                    r1 = adds(r6, 0);
                    r7 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fmul, powf + 920 | 1, 920);
                    return;
                case 920:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fadd, powf + 926 | 1, 926);
                    return;
                case 926:
                    r1 = adds(r0, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fsub, powf + 934 | 1, 934);
                    return;
                case 934:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fsub, powf + 940 | 1, 940);
                    return;
                case 940:
                    r1 = adds(r0, 0);
                    r0 = movs(r0, 254);
                    r0 = lsls(r0, 22);
                    bl(this::__aeabi_fsub, powf + 950 | 1, 950);
                    return;
                case 950:
                    r3 = lsls(r4, 23);
                    r3 = adds(r3, r0);
                    r2 = asrs(r3, 23);
                    cmp(r2, 0);
                    if (ble()) {
                        offset = 962;
                        continue;
                    }
                case 960:
                    step();
                    offset = 1606;
                    continue;
                case 962:
                    r1 = movs(r1, r4);
                    bl(this::scalbnf, powf + 968 | 1, 968);
                    return;
                case 968:
                    r1 = ldr(sp);
                    step();
                    offset = 194;
                    continue;
                case 1028:
                    r3 = ldr(powf + 1616);
                    r2 = movs(r2, 0);
                    cmp(r4, r3);
                    if (bgt()) {
                        offset = 1050;
                        continue;
                    }
                case 1036:
                    r1 = movs(r1, 151);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fmul, powf + 1044 | 1, 1044);
                    return;
                case 1044:
                    r2 = movs(r2, 24);
                    r4 = movs(r4, r0);
                    r2 = rsbs(r2);
                case 1050:
                    r3 = asrs(r4, 23);
                    r0 = lsls(r4, 9);
                    r4 = movs(r4, 254);
                    r3 = subs(r3, 127);
                    r3 = adds(r3, r2);
                    str(sp + 12, r3);
                    r3 = ldr(powf + 1620);
                    r0 = lsrs(r0, 9);
                    r4 = lsls(r4, 22);
                    r4 = orrs(r4, r0);
                    r5 = movs(r5, 0);
                    cmp(r0, r3);
                    if (ble()) {
                        offset = 1096;
                        continue;
                    }
                case 1076:
                    r3 = ldr(powf + 1624);
                    r5 = adds(r5, 1);
                    cmp(r0, r3);
                    if (ble()) {
                        offset = 1096;
                        continue;
                    }
                case 1084:
                    r3 = ldr(sp + 12);
                    r3 = adds(r3, r5);
                    r5 = movs(r5, 0);
                    str(sp + 12, r3);
                    r3 = ldr(powf + 1628);
                    r4 = adds(r4, r3);
                case 1096:
                    r3 = lsls(r5, 2);
                    str(sp + 16, r3);
                    r3 = ldr(powf + 1632); // rodata.bp;
                    r2 = lsls(r5, 2);
                    r7 = ldr(r2 + r3);
                    r0 = adds(r4, 0);
                    r1 = adds(r7, 0);
                    str(sp + 28, r4);
                    bl(this::__aeabi_fsub, powf + 1116 | 1, 1116);
                    return;
                case 1116:
                    r1 = adds(r4, 0);
                    str(sp + 20, r0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fadd, powf + 1126 | 1, 1126);
                    return;
                case 1126:
                    r1 = adds(r0, 0);
                    r0 = movs(r0, 254);
                    r0 = lsls(r0, 22);
                    bl(this::__aeabi_fdiv, powf + 1136 | 1, 1136);
                    return;
                case 1136:
                    r1 = adds(r0, 0);
                    str(sp + 24, r0);
                    r0 = ldr(sp + 20);
                    bl(this::__aeabi_fmul, powf + 1146 | 1, 1146);
                    return;
                case 1146:
                    str(sp + 8, r0);
                    r3 = ldr(sp + 8);
                    r4 = asrs(r4, 1);
                    r6 = lsrs(r3, 12);
                    r3 = ldr(powf + 1636);
                    r5 = lsls(r5, 21);
                    r4 = ands(r4, r3);
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 22);
                    r4 = orrs(r4, r3);
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 15);
                    r4 = adds(r4, r3);
                    r6 = lsls(r6, 12);
                    r5 = adds(r4, r5);
                    r1 = adds(r5, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fmul, powf + 1184 | 1, 1184);
                    return;
                case 1184:
                    r1 = adds(r0, 0);
                    r0 = ldr(sp + 20);
                    bl(this::__aeabi_fsub, powf + 1192 | 1, 1192);
                    return;
                case 1192:
                    r1 = adds(r7, 0);
                    r4 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fsub, powf + 1202 | 1, 1202);
                    return;
                case 1202:
                    r1 = adds(r0, 0);
                    r0 = ldr(sp + 28);
                    bl(this::__aeabi_fsub, powf + 1210 | 1, 1210);
                    return;
                case 1210:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, powf + 1216 | 1, 1216);
                    return;
                case 1216:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, powf + 1224 | 1, 1224);
                    return;
                case 1224:
                    r1 = ldr(sp + 24);
                    bl(this::__aeabi_fmul, powf + 1230 | 1, 1230);
                    return;
                case 1230:
                    r1 = ldr(sp + 8);
                    str(sp + 20, r0);
                    r0 = adds(r1, 0);
                    bl(this::__aeabi_fmul, powf + 1240 | 1, 1240);
                    return;
                case 1240:
                    r1 = ldr(powf + 1640);
                    r4 = adds(r0, 0);
                    bl(this::__aeabi_fmul, powf + 1248 | 1, 1248);
                    return;
                case 1248:
                    r1 = ldr(powf + 1644);
                    bl(this::__aeabi_fadd, powf + 1254 | 1, 1254);
                    return;
                case 1254:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, powf + 1260 | 1, 1260);
                    return;
                case 1260:
                    r1 = ldr(powf + 1648);
                    bl(this::__aeabi_fadd, powf + 1266 | 1, 1266);
                    return;
                case 1266:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, powf + 1272 | 1, 1272);
                    return;
                case 1272:
                    r1 = ldr(powf + 1652);
                    bl(this::__aeabi_fadd, powf + 1278 | 1, 1278);
                    return;
                case 1278:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, powf + 1284 | 1, 1284);
                    return;
                case 1284:
                    r1 = ldr(powf + 1656);
                    bl(this::__aeabi_fadd, powf + 1290 | 1, 1290);
                    return;
                case 1290:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, powf + 1296 | 1, 1296);
                    return;
                case 1296:
                    r1 = ldr(powf + 1660);
                    bl(this::__aeabi_fadd, powf + 1302 | 1, 1302);
                    return;
                case 1302:
                    r1 = adds(r4, 0);
                    r5 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, powf + 1312 | 1, 1312);
                    return;
                case 1312:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fmul, powf + 1320 | 1, 1320);
                    return;
                case 1320:
                    r1 = ldr(sp + 8);
                    r4 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fadd, powf + 1330 | 1, 1330);
                    return;
                case 1330:
                    r1 = ldr(sp + 20);
                    bl(this::__aeabi_fmul, powf + 1336 | 1, 1336);
                    return;
                case 1336:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fadd, powf + 1342 | 1, 1342);
                    return;
                case 1342:
                    r1 = adds(r6, 0);
                    str(sp + 24, r0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fmul, powf + 1352 | 1, 1352);
                    return;
                case 1352:
                    r1 = ldr(powf + 1664);
                    r7 = adds(r0, 0);
                    bl(this::__aeabi_fadd, powf + 1360 | 1, 1360);
                    return;
                case 1360:
                    r1 = ldr(sp + 24);
                    bl(this::__aeabi_fadd, powf + 1366 | 1, 1366);
                    return;
                case 1366:
                    r4 = lsrs(r0, 12);
                    r4 = lsls(r4, 12);
                    r1 = adds(r4, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fmul, powf + 1378 | 1, 1378);
                    return;
                case 1378:
                    r1 = ldr(powf + 1664);
                    r5 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, powf + 1388 | 1, 1388);
                    return;
                case 1388:
                    r1 = adds(r7, 0);
                    bl(this::__aeabi_fsub, powf + 1394 | 1, 1394);
                    return;
                case 1394:
                    r1 = adds(r0, 0);
                    r0 = ldr(sp + 24);
                    bl(this::__aeabi_fsub, powf + 1402 | 1, 1402);
                    return;
                case 1402:
                    r1 = ldr(sp + 8);
                    bl(this::__aeabi_fmul, powf + 1408 | 1, 1408);
                    return;
                case 1408:
                    r1 = ldr(sp + 20);
                    r6 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, powf + 1418 | 1, 1418);
                    return;
                case 1418:
                    r1 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fadd, powf + 1426 | 1, 1426);
                    return;
                case 1426:
                    r6 = adds(r0, 0);
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fadd, powf + 1436 | 1, 1436);
                    return;
                case 1436:
                    r4 = lsrs(r0, 12);
                    r4 = lsls(r4, 12);
                    r1 = ldr(powf + 1668);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, powf + 1448 | 1, 1448);
                    return;
                case 1448:
                    r1 = adds(r5, 0);
                    str(sp + 8, r0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, powf + 1458 | 1, 1458);
                    return;
                case 1458:
                    r1 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fsub, powf + 1466 | 1, 1466);
                    return;
                case 1466:
                    r1 = ldr(powf + 1672);
                    bl(this::__aeabi_fmul, powf + 1472 | 1, 1472);
                    return;
                case 1472:
                    r1 = ldr(powf + 1676);
                    r5 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, powf + 1482 | 1, 1482);
                    return;
                case 1482:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fadd, powf + 1490 | 1, 1490);
                    return;
                case 1490:
                    r2 = ldr(sp + 16);
                    r3 = ldr(powf + 1680); // rodata.dp_l;
                    r1 = ldr(r2 + r3);
                    bl(this::__aeabi_fadd, powf + 1500 | 1, 1500);
                    return;
                case 1500:
                    r5 = adds(r0, 0);
                    r0 = ldr(sp + 12);
                    bl(this::__aeabi_i2f, powf + 1508 | 1, 1508);
                    return;
                case 1508:
                    r3 = ldr(powf + 1684); // rodata.dp_h;
                    r2 = ldr(sp + 16);
                    r7 = adds(r0, 0);
                    r6 = ldr(r2 + r3);
                    r1 = adds(r5, 0);
                    r0 = ldr(sp + 8);
                    bl(this::__aeabi_fadd, powf + 1524 | 1, 1524);
                    return;
                case 1524:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fadd, powf + 1530 | 1, 1530);
                    return;
                case 1530:
                    r1 = adds(r7, 0);
                    bl(this::__aeabi_fadd, powf + 1536 | 1, 1536);
                    return;
                case 1536:
                    r4 = lsrs(r0, 12);
                    r4 = lsls(r4, 12);
                    r1 = adds(r7, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, powf + 1548 | 1, 1548);
                    return;
                case 1548:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fsub, powf + 1554 | 1, 1554);
                    return;
                case 1554:
                    r1 = ldr(sp + 8);
                    bl(this::__aeabi_fsub, powf + 1560 | 1, 1560);
                    return;
                case 1560:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    step();
                    offset = 532;
                    continue;
                case 1566:
                    r2 = ldr(powf + 1688);
                    r3 = lsls(r0, 1);
                    r3 = lsrs(r3, 1);
                    cmp(r3, r2);
                    if (ble()) {
                        offset = 1578;
                        continue;
                    }
                case 1576:
                    step();
                    offset = 366;
                    continue;
                case 1578:
                    r3 = ldr(powf + 1692);
                    cmp(r0, r3);
                    if (beq()) {
                        offset = 1586;
                        continue;
                    }
                case 1584:
                    step();
                    offset = 648;
                    continue;
                case 1586:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fsub, powf + 1592 | 1, 1592);
                    return;
                case 1592:
                    r1 = adds(r7, 0);
                    bl(this::__aeabi_fcmpge, powf + 1598 | 1, 1598);
                    return;
                case 1598:
                    cmp(r0, 0);
                    if (bne()) {
                        offset = 1604;
                        continue;
                    }
                case 1602:
                    step();
                    offset = 648;
                    continue;
                case 1604:
                    step();
                    offset = 366;
                    continue;
                case 1606:
                    r0 = adds(r3, 0);
                    step();
                    offset = 968;
                    continue;
                case 1610:
                    r0 = movs(r0, 254);
                    r0 = lsls(r0, 22);
                    step();
                    offset = 56;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134328352, size=344, name='expf', path='build/lib/libm/math.o', has_indirect=True)
    protected void expf(int offset) throws Exception
    {
        while (true)
        {
            pc = expf + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6, r7);
                    r3 = ldr(expf + 296);
                    r6 = lsls(r0, 1);
                    sp = sub(sp, 20);
                    r4 = adds(r0, 0);
                    r7 = lsrs(r0, 31);
                    r6 = lsrs(r6, 1);
                    cmp(r6, r3);
                    if (bls()) {
                        offset = 80;
                        continue;
                    }
                case 18:
                    r3 = ldr(expf + 300);
                    cmp(r6, r3);
                    if (bls()) {
                        offset = 40;
                        continue;
                    }
                case 24:
                    cmp(r7, 0);
                    if (bne()) {
                        offset = 58;
                        continue;
                    }
                case 28:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fmul, expf + 36 | 1, 36);
                    return;
                case 36:
                    sp = add(sp, 20);
                    pop(true, R4, R5, R6, R7);
                    return;
                case 40:
                    cmp(r7, 0);
                    if (bne()) {
                        offset = 58;
                        continue;
                    }
                case 44:
                    r3 = ldr(expf + 304);
                    cmp(r6, r3);
                    if (bhi()) {
                        offset = 118;
                        continue;
                    }
                case 50:
                    r5 = movs(r5, 1);
                    r5 = subs(r5, r7);
                    r5 = subs(r5, r7);
                    step();
                    offset = 142;
                    continue;
                case 58:
                    r1 = adds(r4, 0);
                    r0 = ldr(expf + 308);
                    bl(this::__aeabi_fdiv, expf + 66 | 1, 66);
                    return;
                case 66:
                    str(sp + 8, r0);
                    r3 = ldr(sp + 8);
                    r3 = ldr(expf + 312);
                    cmp(r6, r3);
                    if (bls()) {
                        offset = 44;
                        continue;
                    }
                case 76:
                    r0 = movs(r0, 0);
                    step();
                    offset = 36;
                    continue;
                case 80:
                    r3 = ldr(expf + 316);
                    cmp(r6, r3);
                    if (bhi()) {
                        offset = 44;
                        continue;
                    }
                case 86:
                    r3 = movs(r3, 228);
                    r3 = lsls(r3, 22);
                    cmp(r6, r3);
                    if (bhi()) {
                        offset = 286;
                        continue;
                    }
                case 94:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fadd, expf + 102 | 1, 102);
                    return;
                case 102:
                    r1 = movs(r1, 254);
                    str(sp + 12, r0);
                    r1 = lsls(r1, 22);
                    r0 = adds(r4, 0);
                    r3 = ldr(sp + 12);
                    bl(this::__aeabi_fadd, expf + 116 | 1, 116);
                    return;
                case 116:
                    step();
                    offset = 36;
                    continue;
                case 118:
                    r1 = ldr(expf + 320);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, expf + 126 | 1, 126);
                    return;
                case 126:
                    r3 = ldr(expf + 324); // rodata.half;
                    r7 = lsls(r7, 2);
                    r1 = ldr(r7 + r3);
                    bl(this::__aeabi_fadd, expf + 136 | 1, 136);
                    return;
                case 136:
                    bl(this::__aeabi_f2iz, expf + 140 | 1, 140);
                    return;
                case 140:
                    r5 = movs(r5, r0);
                case 142:
                    r0 = movs(r0, r5);
                    bl(this::__aeabi_i2f, expf + 148 | 1, 148);
                    return;
                case 148:
                    r1 = ldr(expf + 328);
                    r7 = adds(r0, 0);
                    bl(this::__aeabi_fmul, expf + 156 | 1, 156);
                    return;
                case 156:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, expf + 164 | 1, 164);
                    return;
                case 164:
                    r1 = ldr(expf + 332);
                    r6 = adds(r0, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fmul, expf + 174 | 1, 174);
                    return;
                case 174:
                    r1 = adds(r0, 0);
                    r7 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fsub, expf + 184 | 1, 184);
                    return;
                case 184:
                    r4 = adds(r0, 0);
                case 186:
                    r1 = adds(r4, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, expf + 194 | 1, 194);
                    return;
                case 194:
                    r1 = ldr(expf + 336);
                    str(sp + 4, r0);
                    bl(this::__aeabi_fmul, expf + 202 | 1, 202);
                    return;
                case 202:
                    r1 = ldr(expf + 340);
                    bl(this::__aeabi_fadd, expf + 208 | 1, 208);
                    return;
                case 208:
                    r1 = ldr(sp + 4);
                    bl(this::__aeabi_fmul, expf + 214 | 1, 214);
                    return;
                case 214:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, expf + 222 | 1, 222);
                    return;
                case 222:
                    r1 = adds(r0, 0);
                    str(sp + 4, r0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, expf + 232 | 1, 232);
                    return;
                case 232:
                    r4 = adds(r0, 0);
                    r0 = movs(r0, 128);
                    r1 = ldr(sp + 4);
                    r0 = lsls(r0, 23);
                    bl(this::__aeabi_fsub, expf + 244 | 1, 244);
                    return;
                case 244:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fdiv, expf + 252 | 1, 252);
                    return;
                case 252:
                    r1 = adds(r7, 0);
                    bl(this::__aeabi_fsub, expf + 258 | 1, 258);
                    return;
                case 258:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fadd, expf + 264 | 1, 264);
                    return;
                case 264:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fadd, expf + 272 | 1, 272);
                    return;
                case 272:
                    cmp(r5, 0);
                    if (bne()) {
                        offset = 278;
                        continue;
                    }
                case 276:
                    step();
                    offset = 36;
                    continue;
                case 278:
                    r1 = movs(r1, r5);
                    bl(this::scalbnf, expf + 284 | 1, 284);
                    return;
                case 284:
                    step();
                    offset = 36;
                    continue;
                case 286:
                    r6 = adds(r0, 0);
                    r5 = movs(r5, 0);
                    r7 = movs(r7, 0);
                    step();
                    offset = 186;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134328696, size=664, name='expm1f', path='build/lib/libm/math.o', has_indirect=True)
    protected void expm1f(int offset) throws Exception
    {
        while (true)
        {
            pc = expm1f + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6, r7);
                    r2 = ldr(expm1f + 600);
                    r3 = lsls(r0, 1);
                    sp = sub(sp, 20);
                    r4 = adds(r0, 0);
                    r3 = lsrs(r3, 1);
                    r5 = lsrs(r0, 31);
                    cmp(r3, r2);
                    if (bls()) {
                        offset = 56;
                        continue;
                    }
                case 18:
                    r2 = movs(r2, 255);
                    r2 = lsls(r2, 23);
                    cmp(r3, r2);
                    if (bls()) {
                        offset = 28;
                        continue;
                    }
                case 26:
                    step();
                    offset = 350;
                    continue;
                case 28:
                    cmp(r5, 0);
                    if (beq()) {
                        offset = 34;
                        continue;
                    }
                case 32:
                    step();
                    offset = 594;
                    continue;
                case 34:
                    r1 = ldr(expm1f + 604);
                    bl(this::__aeabi_fcmpgt, expm1f + 40 | 1, 40);
                    return;
                case 40:
                    cmp(r0, 0);
                    if (beq()) {
                        offset = 262;
                        continue;
                    }
                case 44:
                    r1 = movs(r1, 254);
                    r0 = adds(r4, 0);
                    r1 = lsls(r1, 23);
                case 50:
                    bl(this::__aeabi_fmul, expm1f + 54 | 1, 54);
                    return;
                case 54:
                    step();
                    offset = 474;
                    continue;
                case 56:
                    r2 = ldr(expm1f + 608);
                    cmp(r3, r2);
                    if (bhi()) {
                        offset = 64;
                        continue;
                    }
                case 62:
                    step();
                    offset = 328;
                    continue;
                case 64:
                    r2 = ldr(expm1f + 612);
                    cmp(r3, r2);
                    if (bhi()) {
                        offset = 262;
                        continue;
                    }
                case 70:
                    r1 = ldr(expm1f + 616);
                    cmp(r5, 0);
                    if (bne()) {
                        offset = 248;
                        continue;
                    }
                case 76:
                    bl(this::__aeabi_fsub, expm1f + 80 | 1, 80);
                    return;
                case 80:
                    r6 = ldr(expm1f + 620);
                    r7 = adds(r0, 0);
                    r5 = adds(r5, 1);
                case 86:
                    r1 = adds(r6, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fsub, expm1f + 94 | 1, 94);
                    return;
                case 94:
                    r1 = adds(r0, 0);
                    r4 = adds(r0, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fsub, expm1f + 104 | 1, 104);
                    return;
                case 104:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fsub, expm1f + 110 | 1, 110);
                    return;
                case 110:
                    str(sp, r0);
                case 112:
                    r1 = movs(r1, 252);
                    r0 = adds(r4, 0);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fmul, expm1f + 122 | 1, 122);
                    return;
                case 122:
                    r7 = adds(r0, 0);
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, expm1f + 132 | 1, 132);
                    return;
                case 132:
                    r1 = ldr(expm1f + 624);
                    r6 = adds(r0, 0);
                    bl(this::__aeabi_fmul, expm1f + 140 | 1, 140);
                    return;
                case 140:
                    r1 = ldr(expm1f + 628);
                    bl(this::__aeabi_fsub, expm1f + 146 | 1, 146);
                    return;
                case 146:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, expm1f + 152 | 1, 152);
                    return;
                case 152:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fadd, expm1f + 160 | 1, 160);
                    return;
                case 160:
                    r1 = adds(r0, 0);
                    str(sp + 4, r0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fmul, expm1f + 170 | 1, 170);
                    return;
                case 170:
                    r1 = adds(r0, 0);
                    r0 = ldr(expm1f + 632);
                    bl(this::__aeabi_fsub, expm1f + 178 | 1, 178);
                    return;
                case 178:
                    r1 = adds(r0, 0);
                    r7 = adds(r0, 0);
                    r0 = ldr(sp + 4);
                    bl(this::__aeabi_fsub, expm1f + 188 | 1, 188);
                    return;
                case 188:
                    r1 = adds(r7, 0);
                    str(sp + 4, r0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, expm1f + 198 | 1, 198);
                    return;
                case 198:
                    r1 = adds(r0, 0);
                    r0 = ldr(expm1f + 636);
                    bl(this::__aeabi_fsub, expm1f + 206 | 1, 206);
                    return;
                case 206:
                    r1 = adds(r0, 0);
                    r0 = ldr(sp + 4);
                    bl(this::__aeabi_fdiv, expm1f + 214 | 1, 214);
                    return;
                case 214:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, expm1f + 220 | 1, 220);
                    return;
                case 220:
                    cmp(r5, 0);
                    if (bne()) {
                        offset = 360;
                        continue;
                    }
                case 224:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, expm1f + 232 | 1, 232);
                    return;
                case 232:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fsub, expm1f + 238 | 1, 238);
                    return;
                case 238:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                case 242:
                    bl(this::__aeabi_fsub, expm1f + 246 | 1, 246);
                    return;
                case 246:
                    step();
                    offset = 474;
                    continue;
                case 248:
                    bl(this::__aeabi_fadd, expm1f + 252 | 1, 252);
                    return;
                case 252:
                    r5 = movs(r5, 1);
                    r7 = adds(r0, 0);
                    r5 = rsbs(r5);
                    r6 = ldr(expm1f + 640);
                    step();
                    offset = 86;
                    continue;
                case 262:
                    r1 = ldr(expm1f + 644);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, expm1f + 270 | 1, 270);
                    return;
                case 270:
                    cmp(r5, 0);
                    if (bne()) {
                        offset = 322;
                        continue;
                    }
                case 274:
                    r1 = movs(r1, 252);
                    r1 = lsls(r1, 22);
                case 278:
                    bl(this::__aeabi_fadd, expm1f + 282 | 1, 282);
                    return;
                case 282:
                    bl(this::__aeabi_f2iz, expm1f + 286 | 1, 286);
                    return;
                case 286:
                    r5 = movs(r5, r0);
                    bl(this::__aeabi_i2f, expm1f + 292 | 1, 292);
                    return;
                case 292:
                    r1 = ldr(expm1f + 616);
                    r6 = adds(r0, 0);
                    bl(this::__aeabi_fmul, expm1f + 300 | 1, 300);
                    return;
                case 300:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, expm1f + 308 | 1, 308);
                    return;
                case 308:
                    r1 = ldr(expm1f + 620);
                    r7 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fmul, expm1f + 318 | 1, 318);
                    return;
                case 318:
                    r6 = adds(r0, 0);
                    step();
                    offset = 86;
                    continue;
                case 322:
                    r1 = movs(r1, 191);
                    r1 = lsls(r1, 24);
                    step();
                    offset = 278;
                    continue;
                case 328:
                    r2 = ldr(expm1f + 648);
                    cmp(r3, r2);
                    if (bhi()) {
                        offset = 356;
                        continue;
                    }
                case 334:
                    r2 = ldr(expm1f + 652);
                    cmp(r3, r2);
                    if (bhi()) {
                        offset = 350;
                        continue;
                    }
                case 340:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fmul, expm1f + 346 | 1, 346);
                    return;
                case 346:
                    str(sp + 12, r0);
                    r3 = ldr(sp + 12);
                case 350:
                    r0 = adds(r4, 0);
                    sp = add(sp, 20);
                    pop(true, R4, R5, R6, R7);
                    return;
                case 356:
                    r5 = movs(r5, 0);
                    step();
                    offset = 112;
                    continue;
                case 360:
                    r1 = ldr(sp);
                    bl(this::__aeabi_fsub, expm1f + 366 | 1, 366);
                    return;
                case 366:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, expm1f + 372 | 1, 372);
                    return;
                case 372:
                    r1 = ldr(sp);
                    bl(this::__aeabi_fsub, expm1f + 378 | 1, 378);
                    return;
                case 378:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fsub, expm1f + 384 | 1, 384);
                    return;
                case 384:
                    r6 = adds(r0, 0);
                    r3 = adds(r5, 1);
                    if (bne()) {
                        offset = 412;
                        continue;
                    }
                case 390:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, expm1f + 398 | 1, 398);
                    return;
                case 398:
                    r1 = movs(r1, 252);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fmul, expm1f + 406 | 1, 406);
                    return;
                case 406:
                    r1 = movs(r1, 252);
                case 408:
                    r1 = lsls(r1, 22);
                    step();
                    offset = 242;
                    continue;
                case 412:
                    cmp(r5, 1);
                    if (bne()) {
                        offset = 478;
                        continue;
                    }
                case 416:
                    r1 = ldr(expm1f + 656);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fcmplt, expm1f + 424 | 1, 424);
                    return;
                case 424:
                    cmp(r0, 0);
                    if (beq()) {
                        offset = 452;
                        continue;
                    }
                case 428:
                    r1 = movs(r1, 252);
                    r0 = adds(r4, 0);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fadd, expm1f + 438 | 1, 438);
                    return;
                case 438:
                    r1 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fsub, expm1f + 446 | 1, 446);
                    return;
                case 446:
                    r1 = movs(r1, 192);
                    r1 = lsls(r1, 24);
                    step();
                    offset = 50;
                    continue;
                case 452:
                    r1 = adds(r6, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, expm1f + 460 | 1, 460);
                    return;
                case 460:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fadd, expm1f + 466 | 1, 466);
                    return;
                case 466:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fadd, expm1f + 474 | 1, 474);
                    return;
                case 474:
                    r4 = adds(r0, 0);
                    step();
                    offset = 350;
                    continue;
                case 478:
                    r7 = movs(r7, r5);
                    r7 = adds(r7, 127);
                    r7 = lsls(r7, 23);
                    cmp(r5, 56);
                    if (bls()) {
                        offset = 530;
                        continue;
                    }
                case 488:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, expm1f + 496 | 1, 496);
                    return;
                case 496:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fadd, expm1f + 504 | 1, 504);
                    return;
                case 504:
                    r1 = adds(r0, 0);
                    cmp(r5, 128);
                    if (bne()) {
                        offset = 526;
                        continue;
                    }
                case 510:
                    bl(this::__aeabi_fadd, expm1f + 514 | 1, 514);
                    return;
                case 514:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 23);
                case 518:
                    bl(this::__aeabi_fmul, expm1f + 522 | 1, 522);
                    return;
                case 522:
                    r1 = movs(r1, 254);
                    step();
                    offset = 408;
                    continue;
                case 526:
                    r0 = adds(r7, 0);
                    step();
                    offset = 518;
                    continue;
                case 530:
                    r3 = movs(r3, 127);
                    r3 = subs(r3, r5);
                    r3 = lsls(r3, 23);
                    str(sp, r3);
                    r1 = adds(r0, 0);
                    cmp(r5, 22);
                    if (bgt()) {
                        offset = 574;
                        continue;
                    }
                case 544:
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, expm1f + 550 | 1, 550);
                    return;
                case 550:
                    r4 = adds(r0, 0);
                    r0 = movs(r0, 254);
                    r1 = ldr(sp);
                    r0 = lsls(r0, 22);
                    bl(this::__aeabi_fsub, expm1f + 562 | 1, 562);
                    return;
                case 562:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                case 566:
                    bl(this::__aeabi_fadd, expm1f + 570 | 1, 570);
                    return;
                case 570:
                    r1 = adds(r7, 0);
                    step();
                    offset = 50;
                    continue;
                case 574:
                    r0 = ldr(sp);
                    bl(this::__aeabi_fadd, expm1f + 580 | 1, 580);
                    return;
                case 580:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, expm1f + 588 | 1, 588);
                    return;
                case 588:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    step();
                    offset = 566;
                    continue;
                case 594:
                    r4 = ldr(expm1f + 660);
                    step();
                    offset = 350;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134329360, size=36, name='__expo2f', path='build/lib/libm/math.o', has_indirect=False)
    protected void __expo2f(int offset) throws Exception
    {
        while (true)
        {
            pc = __expo2f + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4);
                    r1 = ldr(__expo2f + 32);
                    bl(this::__aeabi_fsub, __expo2f + 8 | 1, 8);
                    return;
                case 8:
                    bl(this::expf, __expo2f + 12 | 1, 12);
                    return;
                case 12:
                    r1 = movs(r1, 244);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fmul, __expo2f + 20 | 1, 20);
                    return;
                case 20:
                    r1 = movs(r1, 244);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fmul, __expo2f + 28 | 1, 28);
                    return;
                case 28:
                    pop(true, R4);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134329396, size=340, name='logf', path='build/lib/libm/math.o', has_indirect=False)
    protected void logf(int offset) throws Exception
    {
        while (true)
        {
            pc = logf + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6, r7);
                    r2 = ldr(logf + 296);
                    sp = sub(sp, 20);
                    r1 = adds(r0, r2);
                    r2 = ldr(logf + 300);
                    r3 = movs(r3, r0);
                    cmp(r1, r2);
                    if (bhi()) {
                        offset = 18;
                        continue;
                    }
                case 16:
                    step();
                    offset = 274;
                    continue;
                case 18:
                    r2 = lsls(r0, 1);
                    if (bne()) {
                        offset = 40;
                        continue;
                    }
                case 22:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fmul, logf + 28 | 1, 28);
                    return;
                case 28:
                    r1 = adds(r0, 0);
                    r0 = ldr(logf + 304);
                case 32:
                    bl(this::__aeabi_fdiv, logf + 36 | 1, 36);
                    return;
                case 36:
                    sp = add(sp, 20);
                    pop(true, R4, R5, R6, R7);
                    return;
                case 40:
                    cmp(r0, 0);
                    if (bge()) {
                        offset = 54;
                        continue;
                    }
                case 44:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fsub, logf + 50 | 1, 50);
                    return;
                case 50:
                    r1 = movs(r1, 0);
                    step();
                    offset = 32;
                    continue;
                case 54:
                    r1 = movs(r1, 152);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fmul, logf + 62 | 1, 62);
                    return;
                case 62:
                    r2 = movs(r2, 25);
                    r3 = movs(r3, r0);
                    r2 = rsbs(r2);
                case 68:
                    r1 = movs(r1, 254);
                    str(sp + 4, r2);
                    r2 = ldr(logf + 308);
                    r1 = lsls(r1, 22);
                    r3 = adds(r3, r2);
                    str(sp + 8, r3);
                    r0 = lsls(r3, 9);
                    r3 = ldr(logf + 312);
                    r0 = lsrs(r0, 9);
                    r0 = adds(r0, r3);
                    bl(this::__aeabi_fsub, logf + 92 | 1, 92);
                    return;
                case 92:
                    r1 = movs(r1, 128);
                    r1 = lsls(r1, 23);
                    r4 = adds(r0, 0);
                    bl(this::__aeabi_fadd, logf + 102 | 1, 102);
                    return;
                case 102:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fdiv, logf + 110 | 1, 110);
                    return;
                case 110:
                    r1 = adds(r0, 0);
                    r5 = adds(r0, 0);
                    bl(this::__aeabi_fmul, logf + 118 | 1, 118);
                    return;
                case 118:
                    r1 = adds(r0, 0);
                    r6 = adds(r0, 0);
                    bl(this::__aeabi_fmul, logf + 126 | 1, 126);
                    return;
                case 126:
                    r1 = movs(r1, 252);
                    r7 = adds(r0, 0);
                    r1 = lsls(r1, 22);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, logf + 138 | 1, 138);
                    return;
                case 138:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, logf + 144 | 1, 144);
                    return;
                case 144:
                    r3 = ldr(sp + 8);
                    str(sp + 12, r0);
                    r0 = lsrs(r3, 23);
                    r3 = ldr(sp + 4);
                    r0 = subs(r0, 127);
                    r0 = adds(r0, r3);
                    bl(this::__aeabi_i2f, logf + 160 | 1, 160);
                    return;
                case 160:
                    r1 = ldr(logf + 316);
                    str(sp + 4, r0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fmul, logf + 170 | 1, 170);
                    return;
                case 170:
                    r1 = ldr(logf + 320);
                    bl(this::__aeabi_fadd, logf + 176 | 1, 176);
                    return;
                case 176:
                    r1 = adds(r7, 0);
                    bl(this::__aeabi_fmul, logf + 182 | 1, 182);
                    return;
                case 182:
                    r1 = ldr(logf + 324);
                    str(sp + 8, r0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fmul, logf + 192 | 1, 192);
                    return;
                case 192:
                    r1 = ldr(logf + 328);
                    bl(this::__aeabi_fadd, logf + 198 | 1, 198);
                    return;
                case 198:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, logf + 204 | 1, 204);
                    return;
                case 204:
                    r1 = adds(r0, 0);
                    r0 = ldr(sp + 8);
                    bl(this::__aeabi_fadd, logf + 212 | 1, 212);
                    return;
                case 212:
                    r1 = ldr(sp + 12);
                    bl(this::__aeabi_fadd, logf + 218 | 1, 218);
                    return;
                case 218:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, logf + 224 | 1, 224);
                    return;
                case 224:
                    r1 = ldr(logf + 332);
                    r5 = adds(r0, 0);
                    r0 = ldr(sp + 4);
                    bl(this::__aeabi_fmul, logf + 234 | 1, 234);
                    return;
                case 234:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fadd, logf + 242 | 1, 242);
                    return;
                case 242:
                    r1 = ldr(sp + 12);
                    bl(this::__aeabi_fsub, logf + 248 | 1, 248);
                    return;
                case 248:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fadd, logf + 254 | 1, 254);
                    return;
                case 254:
                    r1 = ldr(logf + 336);
                    r4 = adds(r0, 0);
                    r0 = ldr(sp + 4);
                    bl(this::__aeabi_fmul, logf + 264 | 1, 264);
                    return;
                case 264:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fadd, logf + 272 | 1, 272);
                    return;
                case 272:
                    step();
                    offset = 36;
                    continue;
                case 274:
                    cmp(r0, r2);
                    if (bls()) {
                        offset = 280;
                        continue;
                    }
                case 278:
                    step();
                    offset = 36;
                    continue;
                case 280:
                    r2 = movs(r2, 254);
                    r0 = movs(r0, 0);
                    r2 = lsls(r2, 22);
                    cmp(r3, r2);
                    if (bne()) {
                        offset = 292;
                        continue;
                    }
                case 290:
                    step();
                    offset = 36;
                    continue;
                case 292:
                    r2 = movs(r2, 0);
                    step();
                    offset = 68;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134329736, size=20, name='log10f', path='build/lib/libm/math.o', has_indirect=True)
    protected void log10f(int offset) throws Exception
    {
        while (true)
        {
            pc = log10f + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4);
                    bl(this::logf, log10f + 6 | 1, 6);
                    return;
                case 6:
                    r1 = ldr(log10f + 16);
                    bl(this::__aeabi_fdiv, log10f + 12 | 1, 12);
                    return;
                case 12:
                    pop(true, R4);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134329756, size=144, name='coshf', path='build/lib/libm/math.o', has_indirect=True)
    protected void coshf(int offset) throws Exception
    {
        while (true)
        {
            pc = coshf + offset;
            switch (offset)
            {
                case 0:
                    push(true, r0, r1, r2, r4, r5);
                    r3 = lsls(r0, 1);
                    r2 = ldr(coshf + 132);
                    r3 = lsrs(r3, 1);
                    r0 = adds(r3, 0);
                    cmp(r3, r2);
                    if (bhi()) {
                        offset = 86;
                        continue;
                    }
                case 14:
                    r2 = ldr(coshf + 136);
                    cmp(r3, r2);
                    if (bhi()) {
                        offset = 38;
                        continue;
                    }
                case 20:
                    r1 = movs(r1, 247);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fadd, coshf + 28 | 1, 28);
                    return;
                case 28:
                    str(sp + 4, r0);
                    r0 = movs(r0, 254);
                    r3 = ldr(sp + 4);
                    r0 = lsls(r0, 22);
                case 36:
                    pop(true, R1, R2, R3, R4, R5);
                    return;
                case 38:
                    bl(this::expm1f, coshf + 42 | 1, 42);
                    return;
                case 42:
                    r1 = adds(r0, 0);
                    r4 = adds(r0, 0);
                    bl(this::__aeabi_fmul, coshf + 50 | 1, 50);
                    return;
                case 50:
                    r1 = movs(r1, 254);
                    r5 = adds(r0, 0);
                    r1 = lsls(r1, 22);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fadd, coshf + 62 | 1, 62);
                    return;
                case 62:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fadd, coshf + 68 | 1, 68);
                    return;
                case 68:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fdiv, coshf + 76 | 1, 76);
                    return;
                case 76:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fadd, coshf + 84 | 1, 84);
                    return;
                case 84:
                    step();
                    offset = 36;
                    continue;
                case 86:
                    r2 = ldr(coshf + 140);
                    cmp(r3, r2);
                    if (bhi()) {
                        offset = 124;
                        continue;
                    }
                case 92:
                    bl(this::expf, coshf + 96 | 1, 96);
                    return;
                case 96:
                    r4 = adds(r0, 0);
                    r1 = adds(r0, 0);
                    r0 = movs(r0, 254);
                    r0 = lsls(r0, 22);
                    bl(this::__aeabi_fdiv, coshf + 108 | 1, 108);
                    return;
                case 108:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fadd, coshf + 114 | 1, 114);
                    return;
                case 114:
                    r1 = movs(r1, 252);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fmul, coshf + 122 | 1, 122);
                    return;
                case 122:
                    step();
                    offset = 36;
                    continue;
                case 124:
                    bl(this::__expo2f, coshf + 128 | 1, 128);
                    return;
                case 128:
                    step();
                    offset = 36;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134329900, size=160, name='sinhf', path='build/lib/libm/math.o', has_indirect=True)
    protected void sinhf(int offset) throws Exception
    {
        while (true)
        {
            pc = sinhf + offset;
            switch (offset)
            {
                case 0:
                    push(true, r3, r4, r5, r6, r7);
                    r6 = adds(r0, 0);
                    r4 = subs(r0, 0);
                    if (bge()) {
                        offset = 98;
                        continue;
                    }
                case 8:
                    r7 = movs(r7, 191);
                    r7 = lsls(r7, 24);
                case 12:
                    r4 = lsls(r4, 1);
                    r3 = ldr(sinhf + 148);
                    r4 = lsrs(r4, 1);
                    r0 = adds(r4, 0);
                    cmp(r4, r3);
                    if (bhi()) {
                        offset = 128;
                        continue;
                    }
                case 24:
                    bl(this::expm1f, sinhf + 28 | 1, 28);
                    return;
                case 28:
                    r3 = ldr(sinhf + 152);
                    r5 = adds(r0, 0);
                    cmp(r4, r3);
                    if (bhi()) {
                        offset = 104;
                        continue;
                    }
                case 36:
                    r3 = ldr(sinhf + 156);
                    cmp(r4, r3);
                    if (bls()) {
                        offset = 94;
                        continue;
                    }
                case 42:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fadd, sinhf + 48 | 1, 48);
                    return;
                case 48:
                    r1 = adds(r5, 0);
                    r4 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fmul, sinhf + 58 | 1, 58);
                    return;
                case 58:
                    r1 = movs(r1, 254);
                    r6 = adds(r0, 0);
                    r1 = lsls(r1, 22);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fadd, sinhf + 70 | 1, 70);
                    return;
                case 70:
                    r1 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fdiv, sinhf + 78 | 1, 78);
                    return;
                case 78:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, sinhf + 86 | 1, 86);
                    return;
                case 86:
                    r1 = adds(r7, 0);
                case 88:
                    bl(this::__aeabi_fmul, sinhf + 92 | 1, 92);
                    return;
                case 92:
                    r6 = adds(r0, 0);
                case 94:
                    r0 = adds(r6, 0);
                    pop(true, R3, R4, R5, R6, R7);
                    return;
                case 98:
                    r7 = movs(r7, 252);
                    r7 = lsls(r7, 22);
                    step();
                    offset = 12;
                    continue;
                case 104:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fadd, sinhf + 112 | 1, 112);
                    return;
                case 112:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fdiv, sinhf + 120 | 1, 120);
                    return;
                case 120:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fadd, sinhf + 126 | 1, 126);
                    return;
                case 126:
                    step();
                    offset = 86;
                    continue;
                case 128:
                    bl(this::__expo2f, sinhf + 132 | 1, 132);
                    return;
                case 132:
                    r1 = adds(r7, 0);
                    r4 = adds(r0, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fadd, sinhf + 142 | 1, 142);
                    return;
                case 142:
                    r1 = adds(r4, 0);
                    step();
                    offset = 88;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134330060, size=76, name='tanhf', path='build/lib/libm/math.o', has_indirect=True)
    protected void tanhf(int offset) throws Exception
    {
        while (true)
        {
            pc = tanhf + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6);
                    r5 = lsls(r0, 1);
                    r5 = lsrs(r5, 1);
                    r4 = adds(r0, 0);
                    r1 = ldr(tanhf + 68);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fcmpun, tanhf + 16 | 1, 16);
                    return;
                case 16:
                    cmp(r0, 0);
                    if (bne()) {
                        offset = 44;
                        continue;
                    }
                case 20:
                    r1 = ldr(tanhf + 68);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fcmple, tanhf + 28 | 1, 28);
                    return;
                case 28:
                    cmp(r0, 0);
                    if (bne()) {
                        offset = 44;
                        continue;
                    }
                case 32:
                    r0 = movs(r0, 254);
                    r0 = lsls(r0, 22);
                    cmp(r4, 0);
                    if (bge()) {
                        offset = 42;
                        continue;
                    }
                case 40:
                    r0 = ldr(tanhf + 72);
                case 42:
                    pop(true, R4, R5, R6);
                    return;
                case 44:
                    r0 = adds(r4, 0);
                    bl(this::sinhf, tanhf + 50 | 1, 50);
                    return;
                case 50:
                    r5 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::coshf, tanhf + 58 | 1, 58);
                    return;
                case 58:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fdiv, tanhf + 66 | 1, 66);
                    return;
                case 66:
                    step();
                    offset = 42;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134330136, size=88, name='ceilf', path='build/lib/libm/math.o', has_indirect=False)
    protected void ceilf(int offset) throws Exception
    {
        while (true)
        {
            pc = ceilf + offset;
            switch (offset)
            {
                case 0:
                    r3 = lsrs(r0, 23);
                    r3 = uxtb(r3);
                    r3 = subs(r3, 127);
                    push(true, r0, r1, r4, r5, r6);
                    r4 = adds(r0, 0);
                    cmp(r3, 22);
                    if (bgt()) {
                        offset = 46;
                        continue;
                    }
                case 14:
                    cmp(r3, 0);
                    if (blt()) {
                        offset = 50;
                        continue;
                    }
                case 18:
                    r6 = ldr(ceilf + 84);
                    r6 = asrs(r6, r3);
                    tst(r6, r0);
                    if (beq()) {
                        offset = 46;
                        continue;
                    }
                case 26:
                    r1 = movs(r1, 247);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fadd, ceilf + 34 | 1, 34);
                    return;
                case 34:
                    str(sp, r0);
                    r3 = ldr(sp);
                    cmp(r4, 0);
                    if (blt()) {
                        offset = 44;
                        continue;
                    }
                case 42:
                    r4 = adds(r4, r6);
                case 44:
                    r4 = bics(r4, r6);
                case 46:
                    r0 = adds(r4, 0);
                    pop(true, R1, R2, R4, R5, R6);
                    return;
                case 50:
                    r1 = movs(r1, 247);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fadd, ceilf + 58 | 1, 58);
                    return;
                case 58:
                    str(sp + 4, r0);
                    r3 = ldr(sp + 4);
                    cmp(r4, 0);
                    if (blt()) {
                        offset = 76;
                        continue;
                    }
                case 66:
                    r5 = lsls(r4, 1);
                    if (beq()) {
                        offset = 46;
                        continue;
                    }
                case 70:
                    r4 = movs(r4, 254);
                    r4 = lsls(r4, 22);
                    step();
                    offset = 46;
                    continue;
                case 76:
                    r4 = movs(r4, 128);
                    r4 = lsls(r4, 24);
                    step();
                    offset = 46;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134330224, size=88, name='floorf', path='build/lib/libm/math.o', has_indirect=False)
    protected void floorf(int offset) throws Exception
    {
        while (true)
        {
            pc = floorf + offset;
            switch (offset)
            {
                case 0:
                    r3 = lsrs(r0, 23);
                    r3 = uxtb(r3);
                    r3 = subs(r3, 127);
                    push(true, r0, r1, r4, r5, r6);
                    r4 = adds(r0, 0);
                    cmp(r3, 22);
                    if (bgt()) {
                        offset = 46;
                        continue;
                    }
                case 14:
                    cmp(r3, 0);
                    if (blt()) {
                        offset = 50;
                        continue;
                    }
                case 18:
                    r6 = ldr(floorf + 80);
                    r6 = asrs(r6, r3);
                    tst(r6, r0);
                    if (beq()) {
                        offset = 46;
                        continue;
                    }
                case 26:
                    r1 = movs(r1, 247);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fadd, floorf + 34 | 1, 34);
                    return;
                case 34:
                    str(sp, r0);
                    r3 = ldr(sp);
                    cmp(r4, 0);
                    if (bge()) {
                        offset = 44;
                        continue;
                    }
                case 42:
                    r4 = adds(r4, r6);
                case 44:
                    r4 = bics(r4, r6);
                case 46:
                    r0 = adds(r4, 0);
                    pop(true, R1, R2, R4, R5, R6);
                    return;
                case 50:
                    r1 = movs(r1, 247);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fadd, floorf + 58 | 1, 58);
                    return;
                case 58:
                    str(sp + 4, r0);
                    r3 = ldr(sp + 4);
                    cmp(r4, 0);
                    if (bge()) {
                        offset = 74;
                        continue;
                    }
                case 66:
                    r5 = lsls(r4, 1);
                    if (beq()) {
                        offset = 46;
                        continue;
                    }
                case 70:
                    r4 = ldr(floorf + 84);
                    step();
                    offset = 46;
                    continue;
                case 74:
                    r4 = movs(r4, 0);
                    step();
                    offset = 46;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134330312, size=48, name='truncf', path='build/lib/libm/math.o', has_indirect=False)
    protected void truncf(int offset) throws Exception
    {
        while (true)
        {
            pc = truncf + offset;
            switch (offset)
            {
                case 0:
                    r3 = lsrs(r0, 23);
                    r3 = uxtb(r3);
                    r3 = subs(r3, 118);
                    push(true, r0, r1, r2, r4, r5);
                    r4 = movs(r4, r0);
                    cmp(r3, 31);
                    if (bgt()) {
                        offset = 46;
                        continue;
                    }
                case 14:
                    cmp(r3, 8);
                    if (bgt()) {
                        offset = 20;
                        continue;
                    }
                case 18:
                    r3 = movs(r3, 1);
                case 20:
                    r5 = movs(r5, 1);
                    r5 = rsbs(r5);
                    r5 = lsrs(r5, r3);
                    tst(r5, r4);
                    if (beq()) {
                        offset = 46;
                        continue;
                    }
                case 30:
                    r1 = movs(r1, 247);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fadd, truncf + 38 | 1, 38);
                    return;
                case 38:
                    r4 = bics(r4, r5);
                    str(sp + 4, r0);
                    r0 = movs(r0, r4);
                    r3 = ldr(sp + 4);
                case 46:
                    pop(true, R1, R2, R3, R4, R5);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134330360, size=160, name='acoshf', path='build/lib/libm/acoshf.o', has_indirect=True)
    protected void acoshf(int offset) throws Exception
    {
        while (true)
        {
            pc = acoshf + offset;
            switch (offset)
            {
                case 0:
                    r2 = ldr(acoshf + 148);
                    r3 = lsls(r0, 1);
                    push(true, r4, r5, r6);
                    r3 = lsrs(r3, 1);
                    r4 = adds(r0, 0);
                    cmp(r3, r2);
                    if (bhi()) {
                        offset = 66;
                        continue;
                    }
                case 14:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fsub, acoshf + 22 | 1, 22);
                    return;
                case 22:
                    r1 = adds(r0, 0);
                    r4 = adds(r0, 0);
                    bl(this::__aeabi_fmul, acoshf + 30 | 1, 30);
                    return;
                case 30:
                    r1 = adds(r4, 0);
                    r5 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fadd, acoshf + 40 | 1, 40);
                    return;
                case 40:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fadd, acoshf + 48 | 1, 48);
                    return;
                case 48:
                    bl(this::sqrtf, acoshf + 52 | 1, 52);
                    return;
                case 52:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fadd, acoshf + 60 | 1, 60);
                    return;
                case 60:
                    bl(this::log1pf, acoshf + 64 | 1, 64);
                    return;
                case 64:
                    pop(true, R4, R5, R6);
                    return;
                case 66:
                    r2 = ldr(acoshf + 152);
                    cmp(r3, r2);
                    if (bhi()) {
                        offset = 134;
                        continue;
                    }
                case 72:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fmul, acoshf + 78 | 1, 78);
                    return;
                case 78:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fsub, acoshf + 86 | 1, 86);
                    return;
                case 86:
                    bl(this::sqrtf, acoshf + 90 | 1, 90);
                    return;
                case 90:
                    r1 = adds(r4, 0);
                    r6 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fadd, acoshf + 100 | 1, 100);
                    return;
                case 100:
                    r1 = adds(r4, 0);
                    r5 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fadd, acoshf + 110 | 1, 110);
                    return;
                case 110:
                    r1 = adds(r0, 0);
                    r0 = movs(r0, 254);
                    r0 = lsls(r0, 22);
                    bl(this::__aeabi_fdiv, acoshf + 120 | 1, 120);
                    return;
                case 120:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fsub, acoshf + 128 | 1, 128);
                    return;
                case 128:
                    bl(this::logf, acoshf + 132 | 1, 132);
                    return;
                case 132:
                    step();
                    offset = 64;
                    continue;
                case 134:
                    bl(this::logf, acoshf + 138 | 1, 138);
                    return;
                case 138:
                    r1 = ldr(acoshf + 156);
                    bl(this::__aeabi_fadd, acoshf + 144 | 1, 144);
                    return;
                case 144:
                    step();
                    offset = 64;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134330520, size=80, name='text_R', path='build/lib/libm/asinfacosf.o', has_indirect=False)
    protected void text_R(int offset) throws Exception
    {
        while (true)
        {
            pc = text_R + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6);
                    r1 = ldr(text_R + 64);
                    r4 = adds(r0, 0);
                    bl(this::__aeabi_fmul, text_R + 10 | 1, 10);
                    return;
                case 10:
                    r1 = ldr(text_R + 68);
                    bl(this::__aeabi_fsub, text_R + 16 | 1, 16);
                    return;
                case 16:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, text_R + 22 | 1, 22);
                    return;
                case 22:
                    r1 = ldr(text_R + 72);
                    bl(this::__aeabi_fadd, text_R + 28 | 1, 28);
                    return;
                case 28:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, text_R + 34 | 1, 34);
                    return;
                case 34:
                    r1 = ldr(text_R + 76);
                    r5 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, text_R + 44 | 1, 44);
                    return;
                case 44:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fadd, text_R + 52 | 1, 52);
                    return;
                case 52:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fdiv, text_R + 60 | 1, 60);
                    return;
                case 60:
                    pop(true, R4, R5, R6);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134330600, size=196, name='asinf', path='build/lib/libm/asinfacosf.o', has_indirect=True)
    protected void asinf(int offset) throws Exception
    {
        while (true)
        {
            pc = asinf + offset;
            switch (offset)
            {
                case 0:
                    r3 = ldr(asinf + 172);
                    r1 = lsls(r0, 1);
                    push(true, r4, r5, r6);
                    r1 = lsrs(r1, 1);
                    r4 = adds(r0, 0);
                    r5 = movs(r5, r0);
                    cmp(r1, r3);
                    if (bls()) {
                        offset = 58;
                        continue;
                    }
                case 16:
                    r3 = adds(r3, 1);
                    cmp(r1, r3);
                    if (bne()) {
                        offset = 38;
                        continue;
                    }
                case 22:
                    r1 = ldr(asinf + 176);
                    bl(this::__aeabi_fmul, asinf + 28 | 1, 28);
                    return;
                case 28:
                    r1 = movs(r1, 224);
                    r1 = lsls(r1, 18);
                case 32:
                    bl(this::__aeabi_fadd, asinf + 36 | 1, 36);
                    return;
                case 36:
                    step();
                    offset = 52;
                    continue;
                case 38:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fsub, asinf + 44 | 1, 44);
                    return;
                case 44:
                    r1 = adds(r0, 0);
                    r0 = movs(r0, 0);
                    bl(this::__aeabi_fdiv, asinf + 52 | 1, 52);
                    return;
                case 52:
                    r4 = adds(r0, 0);
                case 54:
                    r0 = adds(r4, 0);
                    pop(true, R4, R5, R6);
                    return;
                case 58:
                    r3 = ldr(asinf + 180);
                    cmp(r1, r3);
                    if (bhi()) {
                        offset = 96;
                        continue;
                    }
                case 64:
                    r3 = ldr(asinf + 184);
                    r1 = adds(r1, r3);
                    r3 = ldr(asinf + 188);
                    cmp(r1, r3);
                    if (bls()) {
                        offset = 54;
                        continue;
                    }
                case 74:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fmul, asinf + 80 | 1, 80);
                    return;
                case 80:
                    bl(this::text_R, asinf + 84 | 1, 84);
                    return;
                case 84:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, asinf + 90 | 1, 90);
                    return;
                case 90:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    step();
                    offset = 32;
                    continue;
                case 96:
                    r0 = movs(r0, 254);
                    r0 = lsls(r0, 22);
                    bl(this::__aeabi_fsub, asinf + 104 | 1, 104);
                    return;
                case 104:
                    r1 = movs(r1, 252);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fmul, asinf + 112 | 1, 112);
                    return;
                case 112:
                    r6 = adds(r0, 0);
                    bl(this::sqrtf, asinf + 118 | 1, 118);
                    return;
                case 118:
                    r4 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::text_R, asinf + 126 | 1, 126);
                    return;
                case 126:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, asinf + 132 | 1, 132);
                    return;
                case 132:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fadd, asinf + 138 | 1, 138);
                    return;
                case 138:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fadd, asinf + 144 | 1, 144);
                    return;
                case 144:
                    r1 = ldr(asinf + 192);
                    bl(this::__aeabi_fsub, asinf + 150 | 1, 150);
                    return;
                case 150:
                    r1 = adds(r0, 0);
                    r0 = ldr(asinf + 176);
                    bl(this::__aeabi_fsub, asinf + 158 | 1, 158);
                    return;
                case 158:
                    r4 = adds(r0, 0);
                    cmp(r5, 0);
                    if (bge()) {
                        offset = 54;
                        continue;
                    }
                case 164:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 24);
                    r4 = adds(r0, r3);
                    step();
                    offset = 54;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134330796, size=288, name='acosf', path='build/lib/libm/asinfacosf.o', has_indirect=True)
    protected void acosf(int offset) throws Exception
    {
        while (true)
        {
            pc = acosf + offset;
            switch (offset)
            {
                case 0:
                    r1 = ldr(acosf + 268);
                    push(true, r3, r4, r5, r6, r7);
                    r3 = lsls(r0, 1);
                    r4 = adds(r0, 0);
                    r3 = lsrs(r3, 1);
                    cmp(r3, r1);
                    if (bls()) {
                        offset = 46;
                        continue;
                    }
                case 14:
                    r1 = adds(r1, 1);
                    cmp(r3, r1);
                    if (bne()) {
                        offset = 30;
                        continue;
                    }
                case 20:
                    r0 = movs(r0, 0);
                    cmp(r4, 0);
                    if (bge()) {
                        offset = 44;
                        continue;
                    }
                case 26:
                    r0 = ldr(acosf + 272);
                    step();
                    offset = 44;
                    continue;
                case 30:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fsub, acosf + 36 | 1, 36);
                    return;
                case 36:
                    r1 = adds(r0, 0);
                    r0 = movs(r0, 0);
                    bl(this::__aeabi_fdiv, acosf + 44 | 1, 44);
                    return;
                case 44:
                    pop(true, R3, R4, R5, R6, R7);
                    return;
                case 46:
                    r1 = ldr(acosf + 276);
                    cmp(r3, r1);
                    if (bhi()) {
                        offset = 102;
                        continue;
                    }
                case 52:
                    r2 = movs(r2, 202);
                    r2 = lsls(r2, 22);
                    cmp(r3, r2);
                    if (bls()) {
                        offset = 262;
                        continue;
                    }
                case 60:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fmul, acosf + 66 | 1, 66);
                    return;
                case 66:
                    bl(this::text_R, acosf + 70 | 1, 70);
                    return;
                case 70:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, acosf + 76 | 1, 76);
                    return;
                case 76:
                    r1 = adds(r0, 0);
                    r0 = ldr(acosf + 280);
                    bl(this::__aeabi_fsub, acosf + 84 | 1, 84);
                    return;
                case 84:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, acosf + 92 | 1, 92);
                    return;
                case 92:
                    r1 = adds(r0, 0);
                    r0 = ldr(acosf + 284);
                    bl(this::__aeabi_fsub, acosf + 100 | 1, 100);
                    return;
                case 100:
                    step();
                    offset = 44;
                    continue;
                case 102:
                    cmp(r0, 0);
                    if (bge()) {
                        offset = 170;
                        continue;
                    }
                case 106:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fadd, acosf + 114 | 1, 114);
                    return;
                case 114:
                    r1 = movs(r1, 252);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fmul, acosf + 122 | 1, 122);
                    return;
                case 122:
                    r5 = adds(r0, 0);
                    bl(this::sqrtf, acosf + 128 | 1, 128);
                    return;
                case 128:
                    r4 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::text_R, acosf + 136 | 1, 136);
                    return;
                case 136:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, acosf + 142 | 1, 142);
                    return;
                case 142:
                    r1 = ldr(acosf + 280);
                    bl(this::__aeabi_fsub, acosf + 148 | 1, 148);
                    return;
                case 148:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fadd, acosf + 154 | 1, 154);
                    return;
                case 154:
                    r1 = adds(r0, 0);
                    r0 = ldr(acosf + 284);
                    bl(this::__aeabi_fsub, acosf + 162 | 1, 162);
                    return;
                case 162:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fadd, acosf + 168 | 1, 168);
                    return;
                case 168:
                    step();
                    offset = 44;
                    continue;
                case 170:
                    r1 = adds(r0, 0);
                    r0 = movs(r0, 254);
                    r0 = lsls(r0, 22);
                    bl(this::__aeabi_fsub, acosf + 180 | 1, 180);
                    return;
                case 180:
                    r1 = movs(r1, 252);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fmul, acosf + 188 | 1, 188);
                    return;
                case 188:
                    r6 = adds(r0, 0);
                    bl(this::sqrtf, acosf + 194 | 1, 194);
                    return;
                case 194:
                    r4 = lsrs(r0, 12);
                    r4 = lsls(r4, 12);
                    r5 = adds(r0, 0);
                    r1 = adds(r4, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, acosf + 208 | 1, 208);
                    return;
                case 208:
                    r1 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fsub, acosf + 216 | 1, 216);
                    return;
                case 216:
                    r1 = adds(r4, 0);
                    r7 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fadd, acosf + 226 | 1, 226);
                    return;
                case 226:
                    r1 = adds(r0, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fdiv, acosf + 234 | 1, 234);
                    return;
                case 234:
                    r7 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::text_R, acosf + 242 | 1, 242);
                    return;
                case 242:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, acosf + 248 | 1, 248);
                    return;
                case 248:
                    r1 = adds(r7, 0);
                    bl(this::__aeabi_fadd, acosf + 254 | 1, 254);
                    return;
                case 254:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fadd, acosf + 260 | 1, 260);
                    return;
                case 260:
                    step();
                    offset = 162;
                    continue;
                case 262:
                    r0 = ldr(acosf + 284);
                    step();
                    offset = 44;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134331084, size=200, name='asinhf', path='build/lib/libm/asinhf.o', has_indirect=True)
    protected void asinhf(int offset) throws Exception
    {
        while (true)
        {
            pc = asinhf + offset;
            switch (offset)
            {
                case 0:
                    r3 = lsls(r0, 1);
                    r2 = ldr(asinhf + 184);
                    r3 = lsrs(r3, 1);
                    push(true, r0, r1, r4, r5, r6);
                    r6 = lsrs(r0, 31);
                    r4 = adds(r3, 0);
                    cmp(r3, r2);
                    if (bls()) {
                        offset = 44;
                        continue;
                    }
                case 16:
                    r0 = adds(r3, 0);
                    bl(this::logf, asinhf + 22 | 1, 22);
                    return;
                case 22:
                    r1 = ldr(asinhf + 188);
                    bl(this::__aeabi_fadd, asinhf + 28 | 1, 28);
                    return;
                case 28:
                    r4 = adds(r0, 0);
                case 30:
                    cmp(r6, 0);
                    if (beq()) {
                        offset = 40;
                        continue;
                    }
                case 34:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 24);
                    r4 = adds(r4, r3);
                case 40:
                    r0 = adds(r4, 0);
                    pop(true, R1, R2, R4, R5, R6);
                    return;
                case 44:
                    r2 = ldr(asinhf + 192);
                    cmp(r3, r2);
                    if (bls()) {
                        offset = 110;
                        continue;
                    }
                case 50:
                    r1 = adds(r3, 0);
                    r0 = adds(r3, 0);
                    bl(this::__aeabi_fmul, asinhf + 58 | 1, 58);
                    return;
                case 58:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fadd, asinhf + 66 | 1, 66);
                    return;
                case 66:
                    bl(this::sqrtf, asinhf + 70 | 1, 70);
                    return;
                case 70:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fadd, asinhf + 76 | 1, 76);
                    return;
                case 76:
                    r1 = adds(r0, 0);
                    r0 = movs(r0, 254);
                    r0 = lsls(r0, 22);
                    bl(this::__aeabi_fdiv, asinhf + 86 | 1, 86);
                    return;
                case 86:
                    r1 = adds(r4, 0);
                    r5 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fadd, asinhf + 96 | 1, 96);
                    return;
                case 96:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fadd, asinhf + 104 | 1, 104);
                    return;
                case 104:
                    bl(this::logf, asinhf + 108 | 1, 108);
                    return;
                case 108:
                    step();
                    offset = 28;
                    continue;
                case 110:
                    r2 = ldr(asinhf + 196);
                    cmp(r3, r2);
                    if (bls()) {
                        offset = 166;
                        continue;
                    }
                case 116:
                    r1 = adds(r3, 0);
                    r0 = adds(r3, 0);
                    bl(this::__aeabi_fmul, asinhf + 124 | 1, 124);
                    return;
                case 124:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    r5 = adds(r0, 0);
                    bl(this::__aeabi_fadd, asinhf + 134 | 1, 134);
                    return;
                case 134:
                    bl(this::sqrtf, asinhf + 138 | 1, 138);
                    return;
                case 138:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fadd, asinhf + 146 | 1, 146);
                    return;
                case 146:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fdiv, asinhf + 154 | 1, 154);
                    return;
                case 154:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fadd, asinhf + 160 | 1, 160);
                    return;
                case 160:
                    bl(this::log1pf, asinhf + 164 | 1, 164);
                    return;
                case 164:
                    step();
                    offset = 28;
                    continue;
                case 166:
                    r1 = movs(r1, 247);
                    r0 = adds(r3, 0);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fadd, asinhf + 176 | 1, 176);
                    return;
                case 176:
                    str(sp + 4, r0);
                    r3 = ldr(sp + 4);
                    step();
                    offset = 30;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134331284, size=304, name='atan2f', path='build/lib/libm/atan2f.o', has_indirect=True)
    protected void atan2f(int offset) throws Exception
    {
        while (true)
        {
            pc = atan2f + offset;
            switch (offset)
            {
                case 0:
                    push(true, r3, r4, r5, r6, r7);
                    r4 = adds(r0, 0);
                    r0 = adds(r1, 0);
                    r6 = adds(r1, 0);
                    bl(this::__aeabi_fcmpun, atan2f + 12 | 1, 12);
                    return;
                case 12:
                    cmp(r0, 0);
                    if (bne()) {
                        offset = 28;
                        continue;
                    }
                case 16:
                    r1 = adds(r4, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fcmpun, atan2f + 24 | 1, 24);
                    return;
                case 24:
                    cmp(r0, 0);
                    if (beq()) {
                        offset = 40;
                        continue;
                    }
                case 28:
                    r1 = adds(r6, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fadd, atan2f + 36 | 1, 36);
                    return;
                case 36:
                    r4 = adds(r0, 0);
                    step();
                    offset = 124;
                    continue;
                case 40:
                    r2 = movs(r2, 254);
                    r2 = lsls(r2, 22);
                    cmp(r6, r2);
                    if (bne()) {
                        offset = 56;
                        continue;
                    }
                case 48:
                    r0 = adds(r4, 0);
                    bl(this::atanf, atan2f + 54 | 1, 54);
                    return;
                case 54:
                    step();
                    offset = 36;
                    continue;
                case 56:
                    r1 = movs(r1, 2);
                    r5 = lsrs(r6, 30);
                    r3 = lsrs(r4, 31);
                    r5 = ands(r5, r1);
                    r5 = orrs(r5, r3);
                    r3 = lsls(r4, 1);
                    r3 = lsrs(r3, 1);
                    if (bne()) {
                        offset = 84;
                        continue;
                    }
                case 72:
                    cmp(r5, r1);
                    if (beq()) {
                        offset = 260;
                        continue;
                    }
                case 76:
                    cmp(r5, 3);
                    if (bne()) {
                        offset = 124;
                        continue;
                    }
                case 80:
                    r4 = ldr(atan2f + 268);
                    step();
                    offset = 124;
                    continue;
                case 84:
                    r2 = lsls(r6, 1);
                    r2 = lsrs(r2, 1);
                    if (bne()) {
                        offset = 98;
                        continue;
                    }
                case 90:
                    r3 = lsls(r5, 31);
                    if (bpl()) {
                        offset = 264;
                        continue;
                    }
                case 94:
                    r4 = ldr(atan2f + 272);
                    step();
                    offset = 124;
                    continue;
                case 98:
                    r0 = movs(r0, 255);
                    r0 = lsls(r0, 23);
                    cmp(r2, r0);
                    if (bne()) {
                        offset = 156;
                        continue;
                    }
                case 106:
                    cmp(r3, r2);
                    if (bne()) {
                        offset = 136;
                        continue;
                    }
                case 110:
                    cmp(r5, 2);
                    if (beq()) {
                        offset = 128;
                        continue;
                    }
                case 114:
                    cmp(r5, 3);
                    if (beq()) {
                        offset = 132;
                        continue;
                    }
                case 118:
                    cmp(r5, 1);
                    if (bne()) {
                        offset = 256;
                        continue;
                    }
                case 122:
                    r4 = ldr(atan2f + 276);
                case 124:
                    r0 = adds(r4, 0);
                    pop(true, R3, R4, R5, R6, R7);
                    return;
                case 128:
                    r4 = ldr(atan2f + 280);
                    step();
                    offset = 124;
                    continue;
                case 132:
                    r4 = ldr(atan2f + 284);
                    step();
                    offset = 124;
                    continue;
                case 136:
                    cmp(r5, 2);
                    if (beq()) {
                        offset = 260;
                        continue;
                    }
                case 140:
                    cmp(r5, 3);
                    if (beq()) {
                        offset = 80;
                        continue;
                    }
                case 144:
                    r4 = movs(r4, 0);
                    cmp(r5, 1);
                    if (bne()) {
                        offset = 124;
                        continue;
                    }
                case 150:
                    r4 = movs(r4, 128);
                    r4 = lsls(r4, 24);
                    step();
                    offset = 124;
                    continue;
                case 156:
                    r7 = movs(r7, 208);
                    r7 = lsls(r7, 20);
                    r7 = adds(r2, r7);
                    cmp(r7, r3);
                    if (blo()) {
                        offset = 90;
                        continue;
                    }
                case 166:
                    cmp(r3, r0);
                    if (beq()) {
                        offset = 90;
                        continue;
                    }
                case 170:
                    tst(r5, r1);
                    if (beq()) {
                        offset = 184;
                        continue;
                    }
                case 174:
                    r1 = movs(r1, 208);
                    r1 = lsls(r1, 20);
                    r3 = adds(r3, r1);
                    cmp(r3, r2);
                    if (blo()) {
                        offset = 226;
                        continue;
                    }
                case 184:
                    r1 = adds(r6, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fdiv, atan2f + 192 | 1, 192);
                    return;
                case 192:
                    r0 = lsls(r0, 1);
                    r0 = lsrs(r0, 1);
                    bl(this::atanf, atan2f + 200 | 1, 200);
                    return;
                case 200:
                    r4 = adds(r0, 0);
                case 202:
                    cmp(r5, 1);
                    if (beq()) {
                        offset = 230;
                        continue;
                    }
                case 206:
                    cmp(r5, 0);
                    if (beq()) {
                        offset = 124;
                        continue;
                    }
                case 210:
                    cmp(r5, 2);
                    if (beq()) {
                        offset = 238;
                        continue;
                    }
                case 214:
                    r1 = ldr(atan2f + 288);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fadd, atan2f + 222 | 1, 222);
                    return;
                case 222:
                    r1 = ldr(atan2f + 292);
                    step();
                    offset = 250;
                    continue;
                case 226:
                    r4 = movs(r4, 0);
                    step();
                    offset = 202;
                    continue;
                case 230:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 24);
                    r4 = adds(r4, r3);
                    step();
                    offset = 124;
                    continue;
                case 238:
                    r1 = ldr(atan2f + 288);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fadd, atan2f + 246 | 1, 246);
                    return;
                case 246:
                    r1 = adds(r0, 0);
                    r0 = ldr(atan2f + 292);
                case 250:
                    bl(this::__aeabi_fsub, atan2f + 254 | 1, 254);
                    return;
                case 254:
                    step();
                    offset = 36;
                    continue;
                case 256:
                    r4 = ldr(atan2f + 296);
                    step();
                    offset = 124;
                    continue;
                case 260:
                    r4 = ldr(atan2f + 292);
                    step();
                    offset = 124;
                    continue;
                case 264:
                    r4 = ldr(atan2f + 300);
                    step();
                    offset = 124;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134331588, size=456, name='atanf', path='build/lib/libm/atanf.o', has_indirect=True)
    protected void atanf(int offset) throws Exception
    {
        while (true)
        {
            pc = atanf + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6, r7);
                    r3 = lsrs(r0, 31);
                    sp = sub(sp, 20);
                    r2 = ldr(atanf + 388);
                    str(sp + 4, r3);
                    r3 = lsls(r0, 1);
                    r4 = adds(r0, 0);
                    r3 = lsrs(r3, 1);
                    cmp(r3, r2);
                    if (bls()) {
                        offset = 46;
                        continue;
                    }
                case 20:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fcmpun, atanf + 26 | 1, 26);
                    return;
                case 26:
                    cmp(r0, 0);
                    if (bne()) {
                        offset = 40;
                        continue;
                    }
                case 30:
                    r3 = ldr(sp + 4);
                    cmp(r3, 0);
                    if (bne()) {
                        offset = 38;
                        continue;
                    }
                case 36:
                    step();
                    offset = 382;
                    continue;
                case 38:
                    r4 = ldr(atanf + 392);
                case 40:
                    r0 = adds(r4, 0);
                    sp = add(sp, 20);
                    pop(true, R4, R5, R6, R7);
                    return;
                case 46:
                    r2 = ldr(atanf + 396);
                    cmp(r3, r2);
                    if (bhi()) {
                        offset = 78;
                        continue;
                    }
                case 52:
                    r2 = ldr(atanf + 400);
                    cmp(r3, r2);
                    if (bls()) {
                        offset = 60;
                        continue;
                    }
                case 58:
                    step();
                    offset = 332;
                    continue;
                case 60:
                    r2 = ldr(atanf + 404);
                    cmp(r3, r2);
                    if (bhi()) {
                        offset = 40;
                        continue;
                    }
                case 66:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fmul, atanf + 72 | 1, 72);
                    return;
                case 72:
                    str(sp + 12, r0);
                    r3 = ldr(sp + 12);
                    step();
                    offset = 40;
                    continue;
                case 78:
                    r2 = ldr(atanf + 408);
                    r4 = movs(r4, r3);
                    cmp(r3, r2);
                    if (bhi()) {
                        offset = 268;
                        continue;
                    }
                case 86:
                    r2 = ldr(atanf + 412);
                    cmp(r3, r2);
                    if (bhi()) {
                        offset = 232;
                        continue;
                    }
                case 92:
                    r1 = adds(r3, 0);
                    r0 = adds(r3, 0);
                    bl(this::__aeabi_fadd, atanf + 100 | 1, 100);
                    return;
                case 100:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fsub, atanf + 108 | 1, 108);
                    return;
                case 108:
                    r1 = movs(r1, 128);
                    r5 = adds(r0, 0);
                    r1 = lsls(r1, 23);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fadd, atanf + 120 | 1, 120);
                    return;
                case 120:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fdiv, atanf + 128 | 1, 128);
                    return;
                case 128:
                    r5 = movs(r5, 0);
                    r4 = adds(r0, 0);
                case 132:
                    r1 = adds(r4, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, atanf + 140 | 1, 140);
                    return;
                case 140:
                    r1 = adds(r0, 0);
                    r7 = adds(r0, 0);
                    bl(this::__aeabi_fmul, atanf + 148 | 1, 148);
                    return;
                case 148:
                    r1 = ldr(atanf + 416);
                    r6 = adds(r0, 0);
                    bl(this::__aeabi_fmul, atanf + 156 | 1, 156);
                    return;
                case 156:
                    r1 = ldr(atanf + 420);
                    bl(this::__aeabi_fadd, atanf + 162 | 1, 162);
                    return;
                case 162:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, atanf + 168 | 1, 168);
                    return;
                case 168:
                    r1 = ldr(atanf + 424);
                    bl(this::__aeabi_fadd, atanf + 174 | 1, 174);
                    return;
                case 174:
                    r1 = adds(r7, 0);
                    bl(this::__aeabi_fmul, atanf + 180 | 1, 180);
                    return;
                case 180:
                    r1 = ldr(atanf + 428);
                    r7 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fmul, atanf + 190 | 1, 190);
                    return;
                case 190:
                    r1 = ldr(atanf + 432);
                    bl(this::__aeabi_fsub, atanf + 196 | 1, 196);
                    return;
                case 196:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, atanf + 202 | 1, 202);
                    return;
                case 202:
                    r1 = adds(r0, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fadd, atanf + 210 | 1, 210);
                    return;
                case 210:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, atanf + 216 | 1, 216);
                    return;
                case 216:
                    r3 = adds(r5, 1);
                    if (bne()) {
                        offset = 338;
                        continue;
                    }
                case 220:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, atanf + 228 | 1, 228);
                    return;
                case 228:
                    r4 = adds(r0, 0);
                    step();
                    offset = 40;
                    continue;
                case 232:
                    r1 = movs(r1, 254);
                    r0 = adds(r3, 0);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fsub, atanf + 242 | 1, 242);
                    return;
                case 242:
                    r1 = movs(r1, 254);
                    r5 = adds(r0, 0);
                    r1 = lsls(r1, 22);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fadd, atanf + 254 | 1, 254);
                    return;
                case 254:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fdiv, atanf + 262 | 1, 262);
                    return;
                case 262:
                    r5 = movs(r5, 1);
                    r4 = adds(r0, 0);
                    step();
                    offset = 132;
                    continue;
                case 268:
                    r2 = ldr(atanf + 436);
                    cmp(r3, r2);
                    if (bhi()) {
                        offset = 318;
                        continue;
                    }
                case 274:
                    r1 = movs(r1, 255);
                    r0 = adds(r3, 0);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fsub, atanf + 284 | 1, 284);
                    return;
                case 284:
                    r1 = movs(r1, 255);
                    r5 = adds(r0, 0);
                    r1 = lsls(r1, 22);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, atanf + 296 | 1, 296);
                    return;
                case 296:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fadd, atanf + 304 | 1, 304);
                    return;
                case 304:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fdiv, atanf + 312 | 1, 312);
                    return;
                case 312:
                    r5 = movs(r5, 2);
                    r4 = adds(r0, 0);
                    step();
                    offset = 132;
                    continue;
                case 318:
                    r1 = adds(r3, 0);
                    r0 = ldr(atanf + 440);
                    bl(this::__aeabi_fdiv, atanf + 326 | 1, 326);
                    return;
                case 326:
                    r5 = movs(r5, 3);
                    r4 = adds(r0, 0);
                    step();
                    offset = 132;
                    continue;
                case 332:
                    r5 = movs(r5, 1);
                    r5 = rsbs(r5);
                    step();
                    offset = 132;
                    continue;
                case 338:
                    r3 = ldr(atanf + 444); // atanlo;
                    r5 = lsls(r5, 2);
                    r1 = ldr(r5 + r3);
                    bl(this::__aeabi_fsub, atanf + 348 | 1, 348);
                    return;
                case 348:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fsub, atanf + 354 | 1, 354);
                    return;
                case 354:
                    r3 = ldr(atanf + 448); // atanhi;
                    r1 = adds(r0, 0);
                    r0 = ldr(r5 + r3);
                    bl(this::__aeabi_fsub, atanf + 364 | 1, 364);
                    return;
                case 364:
                    r3 = ldr(sp + 4);
                    r4 = adds(r0, 0);
                    cmp(r3, 0);
                    if (bne()) {
                        offset = 374;
                        continue;
                    }
                case 372:
                    step();
                    offset = 40;
                    continue;
                case 374:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 24);
                    r4 = adds(r0, r3);
                    step();
                    offset = 40;
                    continue;
                case 382:
                    r4 = ldr(atanf + 452);
                    step();
                    offset = 40;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134332044, size=144, name='atanhf', path='build/lib/libm/atanhf.o', has_indirect=True)
    protected void atanhf(int offset) throws Exception
    {
        while (true)
        {
            pc = atanhf + offset;
            switch (offset)
            {
                case 0:
                    push(true, r0, r1, r2, r4, r5, r6, r7);
                    r3 = ldr(atanhf + 132);
                    r5 = lsrs(r0, 31);
                    r0 = lsls(r0, 1);
                    r0 = lsrs(r0, 1);
                    r4 = adds(r0, 0);
                    cmp(r0, r3);
                    if (bhi()) {
                        offset = 108;
                        continue;
                    }
                case 16:
                    r3 = ldr(atanhf + 136);
                    cmp(r0, r3);
                    if (bhi()) {
                        offset = 52;
                        continue;
                    }
                case 22:
                    r3 = ldr(atanhf + 140);
                    cmp(r0, r3);
                    if (bhi()) {
                        offset = 38;
                        continue;
                    }
                case 28:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fmul, atanhf + 34 | 1, 34);
                    return;
                case 34:
                    str(sp + 4, r0);
                    r3 = ldr(sp + 4);
                case 38:
                    cmp(r5, 0);
                    if (beq()) {
                        offset = 48;
                        continue;
                    }
                case 42:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 24);
                    r4 = adds(r4, r3);
                case 48:
                    r0 = adds(r4, 0);
                    pop(true, R1, R2, R3, R4, R5, R6, R7);
                    return;
                case 52:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fadd, atanhf + 58 | 1, 58);
                    return;
                case 58:
                    r1 = adds(r4, 0);
                    r6 = adds(r0, 0);
                    bl(this::__aeabi_fmul, atanhf + 66 | 1, 66);
                    return;
                case 66:
                    r7 = adds(r0, 0);
                    r0 = movs(r0, 254);
                    r1 = adds(r4, 0);
                    r0 = lsls(r0, 22);
                    bl(this::__aeabi_fsub, atanhf + 78 | 1, 78);
                    return;
                case 78:
                    r1 = adds(r0, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fdiv, atanhf + 86 | 1, 86);
                    return;
                case 86:
                    r1 = adds(r6, 0);
                case 88:
                    bl(this::__aeabi_fadd, atanhf + 92 | 1, 92);
                    return;
                case 92:
                    bl(this::log1pf, atanhf + 96 | 1, 96);
                    return;
                case 96:
                    r1 = movs(r1, 252);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fmul, atanhf + 104 | 1, 104);
                    return;
                case 104:
                    r4 = adds(r0, 0);
                    step();
                    offset = 38;
                    continue;
                case 108:
                    r1 = adds(r0, 0);
                    r0 = movs(r0, 254);
                    r0 = lsls(r0, 22);
                    bl(this::__aeabi_fsub, atanhf + 118 | 1, 118);
                    return;
                case 118:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fdiv, atanhf + 126 | 1, 126);
                    return;
                case 126:
                    r1 = adds(r0, 0);
                    step();
                    offset = 88;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134332188, size=692, name='__ieee754_rem_pio2f', path='build/lib/libm/ef_rem_pio2.o', has_indirect=False)
    protected void __ieee754_rem_pio2f(int offset) throws Exception
    {
        while (true)
        {
            pc = __ieee754_rem_pio2f + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6, r7);
                    r3 = ldr(__ieee754_rem_pio2f + 636);
                    sp = sub(sp, 44);
                    r6 = lsls(r0, 1);
                    r4 = movs(r4, r1);
                    str(sp + 20, r0);
                    r6 = lsrs(r6, 1);
                    cmp(r6, r3);
                    if (bgt()) {
                        offset = 28;
                        continue;
                    }
                case 18:
                    r3 = movs(r3, 0);
                    str(r1, r0);
                    str(r1 + 4, r3);
                case 24:
                    r7 = movs(r7, 0);
                    step();
                    offset = 82;
                    continue;
                case 28:
                    r3 = ldr(__ieee754_rem_pio2f + 640);
                    cmp(r6, r3);
                    if (bgt()) {
                        offset = 184;
                        continue;
                    }
                case 34:
                    r3 = movs(r3, 15);
                    r5 = ldr(__ieee754_rem_pio2f + 644);
                    r6 = bics(r6, r3);
                    r1 = ldr(__ieee754_rem_pio2f + 648);
                    cmp(r0, 0);
                    if (ble()) {
                        offset = 116;
                        continue;
                    }
                case 46:
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 50 | 1, 50);
                    return;
                case 50:
                    r7 = adds(r0, 0);
                    cmp(r6, r5);
                    if (beq()) {
                        offset = 88;
                        continue;
                    }
                case 56:
                    r1 = ldr(__ieee754_rem_pio2f + 652);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 62 | 1, 62);
                    return;
                case 62:
                    r1 = adds(r0, 0);
                    str(r4, r0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 72 | 1, 72);
                    return;
                case 72:
                    r1 = ldr(__ieee754_rem_pio2f + 652);
                case 74:
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 78 | 1, 78);
                    return;
                case 78:
                    r7 = movs(r7, 1);
                    str(r4 + 4, r0);
                case 82:
                    r0 = movs(r0, r7);
                    sp = add(sp, 44);
                    pop(true, R4, R5, R6, R7);
                    return;
                case 88:
                    r1 = ldr(__ieee754_rem_pio2f + 656);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 94 | 1, 94);
                    return;
                case 94:
                    r1 = ldr(__ieee754_rem_pio2f + 660);
                    r5 = adds(r0, 0);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 102 | 1, 102);
                    return;
                case 102:
                    r1 = adds(r0, 0);
                    str(r4, r0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 112 | 1, 112);
                    return;
                case 112:
                    r1 = ldr(__ieee754_rem_pio2f + 660);
                    step();
                    offset = 74;
                    continue;
                case 116:
                    bl(this::__aeabi_fadd, __ieee754_rem_pio2f + 120 | 1, 120);
                    return;
                case 120:
                    r7 = adds(r0, 0);
                    cmp(r6, r5);
                    if (beq()) {
                        offset = 156;
                        continue;
                    }
                case 126:
                    r1 = ldr(__ieee754_rem_pio2f + 652);
                    bl(this::__aeabi_fadd, __ieee754_rem_pio2f + 132 | 1, 132);
                    return;
                case 132:
                    r1 = adds(r0, 0);
                    str(r4, r0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 142 | 1, 142);
                    return;
                case 142:
                    r1 = ldr(__ieee754_rem_pio2f + 652);
                case 144:
                    bl(this::__aeabi_fadd, __ieee754_rem_pio2f + 148 | 1, 148);
                    return;
                case 148:
                    r7 = movs(r7, 1);
                    str(r4 + 4, r0);
                case 152:
                    r7 = rsbs(r7);
                    step();
                    offset = 82;
                    continue;
                case 156:
                    r1 = ldr(__ieee754_rem_pio2f + 656);
                    bl(this::__aeabi_fadd, __ieee754_rem_pio2f + 162 | 1, 162);
                    return;
                case 162:
                    r1 = ldr(__ieee754_rem_pio2f + 660);
                    r5 = adds(r0, 0);
                    bl(this::__aeabi_fadd, __ieee754_rem_pio2f + 170 | 1, 170);
                    return;
                case 170:
                    r1 = adds(r0, 0);
                    str(r4, r0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 180 | 1, 180);
                    return;
                case 180:
                    r1 = ldr(__ieee754_rem_pio2f + 660);
                    step();
                    offset = 144;
                    continue;
                case 184:
                    r3 = ldr(__ieee754_rem_pio2f + 664);
                    cmp(r6, r3);
                    if (ble()) {
                        offset = 192;
                        continue;
                    }
                case 190:
                    step();
                    offset = 478;
                    continue;
                case 192:
                    r1 = ldr(__ieee754_rem_pio2f + 668);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fmul, __ieee754_rem_pio2f + 200 | 1, 200);
                    return;
                case 200:
                    r1 = movs(r1, 252);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fadd, __ieee754_rem_pio2f + 208 | 1, 208);
                    return;
                case 208:
                    bl(this::__aeabi_f2iz, __ieee754_rem_pio2f + 212 | 1, 212);
                    return;
                case 212:
                    r7 = movs(r7, r0);
                    bl(this::__aeabi_i2f, __ieee754_rem_pio2f + 218 | 1, 218);
                    return;
                case 218:
                    r1 = ldr(__ieee754_rem_pio2f + 648);
                    str(sp + 12, r0);
                    bl(this::__aeabi_fmul, __ieee754_rem_pio2f + 226 | 1, 226);
                    return;
                case 226:
                    r1 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 234 | 1, 234);
                    return;
                case 234:
                    r1 = ldr(__ieee754_rem_pio2f + 652);
                    r5 = adds(r0, 0);
                    r0 = ldr(sp + 12);
                    bl(this::__aeabi_fmul, __ieee754_rem_pio2f + 244 | 1, 244);
                    return;
                case 244:
                    str(sp + 8, r0);
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 254 | 1, 254);
                    return;
                case 254:
                    cmp(r7, 31);
                    if (bgt()) {
                        offset = 280;
                        continue;
                    }
                case 258:
                    r3 = movs(r3, 255);
                    r2 = movs(r2, r6);
                    r1 = ldr(__ieee754_rem_pio2f + 672); // npio2_hw;
                    r2 = bics(r2, r3);
                    r3 = subs(r7, 1);
                    r3 = lsls(r3, 2);
                    r3 = ldr(r3 + r1);
                    cmp(r2, r3);
                    if (beq()) {
                        offset = 280;
                        continue;
                    }
                case 276:
                    str(r4, r0);
                    step();
                    offset = 376;
                    continue;
                case 280:
                    r2 = movs(r2, 255);
                    r3 = asrs(r6, 23);
                    str(sp + 16, r3);
                    r3 = lsrs(r0, 23);
                    r3 = ands(r3, r2);
                    r2 = ldr(sp + 16);
                    r3 = subs(r2, r3);
                    cmp(r3, 8);
                    if (ble()) {
                        offset = 276;
                        continue;
                    }
                case 298:
                    r1 = ldr(__ieee754_rem_pio2f + 656);
                    r0 = ldr(sp + 12);
                    bl(this::__aeabi_fmul, __ieee754_rem_pio2f + 306 | 1, 306);
                    return;
                case 306:
                    r1 = adds(r0, 0);
                    str(sp + 8, r0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 316 | 1, 316);
                    return;
                case 316:
                    r1 = adds(r0, 0);
                    r6 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 326 | 1, 326);
                    return;
                case 326:
                    r1 = ldr(sp + 8);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 332 | 1, 332);
                    return;
                case 332:
                    r1 = ldr(__ieee754_rem_pio2f + 660);
                    r5 = adds(r0, 0);
                    r0 = ldr(sp + 12);
                    bl(this::__aeabi_fmul, __ieee754_rem_pio2f + 342 | 1, 342);
                    return;
                case 342:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 348 | 1, 348);
                    return;
                case 348:
                    str(sp + 8, r0);
                    r1 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 358 | 1, 358);
                    return;
                case 358:
                    r2 = movs(r2, 255);
                    r3 = lsrs(r0, 23);
                    r3 = ands(r3, r2);
                    r2 = ldr(sp + 16);
                    r3 = subs(r2, r3);
                    cmp(r3, 25);
                    if (bgt()) {
                        offset = 416;
                        continue;
                    }
                case 372:
                    str(r4, r0);
                    r5 = adds(r6, 0);
                case 376:
                    r6 = ldr(r4);
                    r0 = adds(r5, 0);
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 386 | 1, 386);
                    return;
                case 386:
                    r1 = ldr(sp + 8);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 392 | 1, 392);
                    return;
                case 392:
                    r3 = ldr(sp + 20);
                    str(r4 + 4, r0);
                    cmp(r3, 0);
                    if (blt()) {
                        offset = 402;
                        continue;
                    }
                case 400:
                    step();
                    offset = 82;
                    continue;
                case 402:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 24);
                    r6 = adds(r6, r3);
                    r0 = adds(r0, r3);
                    str(r4, r6);
                    str(r4 + 4, r0);
                    step();
                    offset = 152;
                    continue;
                case 416:
                    r1 = ldr(__ieee754_rem_pio2f + 676);
                    r0 = ldr(sp + 12);
                    bl(this::__aeabi_fmul, __ieee754_rem_pio2f + 424 | 1, 424);
                    return;
                case 424:
                    str(sp + 8, r0);
                    r1 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 434 | 1, 434);
                    return;
                case 434:
                    r5 = adds(r0, 0);
                    r1 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 444 | 1, 444);
                    return;
                case 444:
                    r1 = ldr(sp + 8);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 450 | 1, 450);
                    return;
                case 450:
                    r1 = ldr(__ieee754_rem_pio2f + 680);
                    r6 = adds(r0, 0);
                    r0 = ldr(sp + 12);
                    bl(this::__aeabi_fmul, __ieee754_rem_pio2f + 460 | 1, 460);
                    return;
                case 460:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 466 | 1, 466);
                    return;
                case 466:
                    str(sp + 8, r0);
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 476 | 1, 476);
                    return;
                case 476:
                    step();
                    offset = 276;
                    continue;
                case 478:
                    r3 = ldr(__ieee754_rem_pio2f + 684);
                    cmp(r6, r3);
                    if (ble()) {
                        offset = 496;
                        continue;
                    }
                case 484:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 490 | 1, 490);
                    return;
                case 490:
                    str(r4 + 4, r0);
                    str(r4, r0);
                    step();
                    offset = 24;
                    continue;
                case 496:
                    r5 = asrs(r6, 23);
                    r5 = subs(r5, 134);
                    r3 = lsls(r5, 23);
                    r6 = subs(r6, r3);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_f2iz, __ieee754_rem_pio2f + 510 | 1, 510);
                    return;
                case 510:
                    bl(this::__aeabi_i2f, __ieee754_rem_pio2f + 514 | 1, 514);
                    return;
                case 514:
                    r1 = adds(r0, 0);
                    str(sp + 28, r0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 524 | 1, 524);
                    return;
                case 524:
                    r1 = movs(r1, 135);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fmul, __ieee754_rem_pio2f + 532 | 1, 532);
                    return;
                case 532:
                    r7 = adds(r0, 0);
                    bl(this::__aeabi_f2iz, __ieee754_rem_pio2f + 538 | 1, 538);
                    return;
                case 538:
                    bl(this::__aeabi_i2f, __ieee754_rem_pio2f + 542 | 1, 542);
                    return;
                case 542:
                    r1 = adds(r0, 0);
                    str(sp + 32, r0);
                    r6 = adds(r0, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fsub, __ieee754_rem_pio2f + 554 | 1, 554);
                    return;
                case 554:
                    r1 = movs(r1, 135);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fmul, __ieee754_rem_pio2f + 562 | 1, 562);
                    return;
                case 562:
                    r1 = movs(r1, 0);
                    str(sp + 36, r0);
                    bl(this::__aeabi_fcmpeq, __ieee754_rem_pio2f + 570 | 1, 570);
                    return;
                case 570:
                    r3 = movs(r3, 3);
                    cmp(r0, 0);
                    if (beq()) {
                        offset = 590;
                        continue;
                    }
                case 576:
                    r1 = movs(r1, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fcmpeq, __ieee754_rem_pio2f + 584 | 1, 584);
                    return;
                case 584:
                    r3 = rsbs(r0);
                    r3 = adcs(r3, r0);
                    r3 = adds(r3, 1);
                case 590:
                    r2 = ldr(__ieee754_rem_pio2f + 688); // two_over_pi;
                    r1 = movs(r1, r4);
                    str(sp + 4, r2);
                    r2 = movs(r2, 2);
                    r0 = add(sp, 28);
                    str(sp, r2);
                    r2 = movs(r2, r5);
                    bl(this::__kernel_rem_pio2f, __ieee754_rem_pio2f + 608 | 1, 608);
                    return;
                case 608:
                    r3 = ldr(sp + 20);
                    r7 = movs(r7, r0);
                    cmp(r3, 0);
                    if (blt()) {
                        offset = 618;
                        continue;
                    }
                case 616:
                    step();
                    offset = 82;
                    continue;
                case 618:
                    r2 = movs(r2, 128);
                    r3 = ldr(r4);
                    r2 = lsls(r2, 24);
                    r3 = adds(r3, r2);
                    str(r4, r3);
                    r3 = ldr(r4 + 4);
                    r3 = adds(r3, r2);
                    str(r4 + 4, r3);
                    step();
                    offset = 152;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134332880, size=176, name='sqrtf', path='build/lib/libm/ef_sqrt.o', has_indirect=True)
    protected void sqrtf(int offset) throws Exception
    {
        while (true)
        {
            pc = sqrtf + offset;
            switch (offset)
            {
                case 0:
                    r1 = ldr(sqrtf + 168);
                    r3 = lsls(r0, 1);
                    push(true, r4, r5, r6);
                    r2 = movs(r2, r0);
                    r4 = adds(r0, 0);
                    r3 = lsrs(r3, 1);
                    cmp(r3, r1);
                    if (bls()) {
                        offset = 36;
                        continue;
                    }
                case 16:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fmul, sqrtf + 22 | 1, 22);
                    return;
                case 22:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fadd, sqrtf + 30 | 1, 30);
                    return;
                case 30:
                    r4 = adds(r0, 0);
                case 32:
                    r0 = adds(r4, 0);
                    pop(true, R4, R5, R6);
                    return;
                case 36:
                    cmp(r3, 0);
                    if (beq()) {
                        offset = 32;
                        continue;
                    }
                case 40:
                    cmp(r0, 0);
                    if (bge()) {
                        offset = 58;
                        continue;
                    }
                case 44:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fsub, sqrtf + 50 | 1, 50);
                    return;
                case 50:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fdiv, sqrtf + 56 | 1, 56);
                    return;
                case 56:
                    step();
                    offset = 30;
                    continue;
                case 58:
                    r1 = ldr(sqrtf + 172);
                    r4 = asrs(r0, 23);
                    cmp(r3, r1);
                    if (bls()) {
                        offset = 158;
                        continue;
                    }
                case 66:
                    r2 = lsls(r2, 9);
                    r3 = lsrs(r2, 9);
                    r2 = movs(r2, 128);
                    r4 = subs(r4, 127);
                    r2 = lsls(r2, 16);
                    r2 = orrs(r2, r3);
                    r3 = lsls(r4, 31);
                    if (bpl()) {
                        offset = 84;
                        continue;
                    }
                case 82:
                    r2 = lsls(r2, 1);
                case 84:
                    r3 = movs(r3, 0);
                    r1 = movs(r1, 128);
                    r0 = movs(r0, 25);
                    r6 = movs(r6, r3);
                    r4 = asrs(r4, 1);
                    r2 = lsls(r2, 1);
                    r1 = lsls(r1, 17);
                case 98:
                    r5 = adds(r6, r1);
                    cmp(r5, r2);
                    if (bgt()) {
                        offset = 110;
                        continue;
                    }
                case 104:
                    r6 = adds(r5, r1);
                    r2 = subs(r2, r5);
                    r3 = adds(r3, r1);
                case 110:
                    r0 = subs(r0, 1);
                    r2 = lsls(r2, 1);
                    r1 = lsrs(r1, 1);
                    cmp(r0, 0);
                    if (bne()) {
                        offset = 98;
                        continue;
                    }
                case 120:
                    cmp(r2, 0);
                    if (beq()) {
                        offset = 130;
                        continue;
                    }
                case 124:
                    r2 = movs(r2, 1);
                    r3 = adds(r3, 1);
                    r3 = bics(r3, r2);
                case 130:
                    r2 = movs(r2, 252);
                    r3 = asrs(r3, 1);
                    r2 = lsls(r2, 22);
                    r3 = adds(r3, r2);
                    r4 = lsls(r4, 23);
                    r4 = adds(r4, r3);
                    step();
                    offset = 32;
                    continue;
                case 144:
                    r2 = lsls(r2, 1);
                    r3 = adds(r3, 1);
                case 148:
                    tst(r2, r1);
                    if (beq()) {
                        offset = 144;
                        continue;
                    }
                case 152:
                    r3 = subs(r3, 1);
                    r4 = subs(r4, r3);
                    step();
                    offset = 66;
                    continue;
                case 158:
                    r1 = movs(r1, 128);
                    r3 = movs(r3, 0);
                    r1 = lsls(r1, 16);
                    step();
                    offset = 148;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134333056, size=1976, name='__ieee754_lgammaf_r', path='build/lib/libm/erf_lgamma.o', has_indirect=False)
    protected void __ieee754_lgammaf_r(int offset) throws Exception
    {
        while (true)
        {
            pc = __ieee754_lgammaf_r + offset;
            switch (offset)
            {
                case 0:
                    push(true, r0, r1, r2, r4, r5, r6, r7);
                    r7 = movs(r7, 1);
                    r3 = ldr(__ieee754_lgammaf_r + 872);
                    r5 = lsls(r0, 1);
                    r4 = adds(r0, 0);
                    str(sp, r1);
                    str(sp + 4, r0);
                    str(r1, r7);
                    r5 = lsrs(r5, r7);
                    cmp(r5, r3);
                    if (ble()) {
                        offset = 32;
                        continue;
                    }
                case 22:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 28 | 1, 28);
                    return;
                case 28:
                    r4 = adds(r0, 0);
                    step();
                    offset = 78;
                    continue;
                case 32:
                    cmp(r5, 0);
                    if (bne()) {
                        offset = 48;
                        continue;
                    }
                case 36:
                    r0 = movs(r0, 254);
                    r1 = movs(r1, 0);
                    r0 = lsls(r0, 22);
                    bl(this::__aeabi_fdiv, __ieee754_lgammaf_r + 46 | 1, 46);
                    return;
                case 46:
                    step();
                    offset = 28;
                    continue;
                case 48:
                    r3 = ldr(__ieee754_lgammaf_r + 876);
                    cmp(r5, r3);
                    if (bgt()) {
                        offset = 94;
                        continue;
                    }
                case 54:
                    cmp(r0, 0);
                    if (bge()) {
                        offset = 82;
                        continue;
                    }
                case 58:
                    r3 = movs(r3, 1);
                    r5 = movs(r5, 128);
                    r2 = ldr(sp);
                    r3 = rsbs(r3);
                    r5 = lsls(r5, 24);
                    str(r2, r3);
                    r0 = adds(r0, r5);
                    bl(this::logf, __ieee754_lgammaf_r + 76 | 1, 76);
                    return;
                case 76:
                    r4 = adds(r0, r5);
                case 78:
                    r0 = adds(r4, 0);
                    pop(true, R1, R2, R3, R4, R5, R6, R7);
                    return;
                case 82:
                    bl(this::logf, __ieee754_lgammaf_r + 86 | 1, 86);
                    return;
                case 86:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 24);
                    r4 = adds(r0, r3);
                    step();
                    offset = 78;
                    continue;
                case 94:
                    cmp(r0, 0);
                    if (blt()) {
                        offset = 100;
                        continue;
                    }
                case 98:
                    step();
                    offset = 1560;
                    continue;
                case 100:
                    r3 = ldr(__ieee754_lgammaf_r + 880);
                    cmp(r5, r3);
                    if (bgt()) {
                        offset = 36;
                        continue;
                    }
                case 106:
                    r3 = ldr(__ieee754_lgammaf_r + 884);
                    cmp(r5, r3);
                    if (bgt()) {
                        offset = 204;
                        continue;
                    }
                case 112:
                    r1 = ldr(__ieee754_lgammaf_r + 888);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 118 | 1, 118);
                    return;
                case 118:
                    r2 = movs(r2, 0);
                    r1 = movs(r1, 0);
                    bl(this::__kernel_sinf, __ieee754_lgammaf_r + 126 | 1, 126);
                    return;
                case 126:
                    r6 = adds(r0, 0);
                case 128:
                    r1 = movs(r1, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fcmpeq, __ieee754_lgammaf_r + 136 | 1, 136);
                    return;
                case 136:
                    cmp(r0, 0);
                    if (bne()) {
                        offset = 36;
                        continue;
                    }
                case 140:
                    r1 = adds(r6, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 148 | 1, 148);
                    return;
                case 148:
                    r1 = lsls(r0, 1);
                    r1 = lsrs(r1, 1);
                    r0 = ldr(__ieee754_lgammaf_r + 888);
                    bl(this::__aeabi_fdiv, __ieee754_lgammaf_r + 158 | 1, 158);
                    return;
                case 158:
                    bl(this::logf, __ieee754_lgammaf_r + 162 | 1, 162);
                    return;
                case 162:
                    r1 = movs(r1, 0);
                    r7 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fcmplt, __ieee754_lgammaf_r + 172 | 1, 172);
                    return;
                case 172:
                    cmp(r0, 0);
                    if (beq()) {
                        offset = 184;
                        continue;
                    }
                case 176:
                    r3 = movs(r3, 1);
                    r2 = ldr(sp);
                    r3 = rsbs(r3);
                    str(r2, r3);
                case 184:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 24);
                    r4 = adds(r4, r3);
                    r3 = movs(r3, 254);
                    r3 = lsls(r3, 22);
                    cmp(r5, r3);
                    if (beq()) {
                        offset = 200;
                        continue;
                    }
                case 198:
                    step();
                    offset = 1572;
                    continue;
                case 200:
                    r4 = movs(r4, 0);
                    step();
                    offset = 1262;
                    continue;
                case 204:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 24);
                    r6 = adds(r0, r3);
                    r0 = adds(r6, 0);
                    bl(this::floorf, __ieee754_lgammaf_r + 216 | 1, 216);
                    return;
                case 216:
                    r1 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fcmpeq, __ieee754_lgammaf_r + 224 | 1, 224);
                    return;
                case 224:
                    cmp(r0, 0);
                    if (bne()) {
                        offset = 296;
                        continue;
                    }
                case 228:
                    r1 = movs(r1, 252);
                    r0 = adds(r6, 0);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 238 | 1, 238);
                    return;
                case 238:
                    r6 = adds(r0, 0);
                    bl(this::floorf, __ieee754_lgammaf_r + 244 | 1, 244);
                    return;
                case 244:
                    r1 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 252 | 1, 252);
                    return;
                case 252:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 258 | 1, 258);
                    return;
                case 258:
                    r1 = movs(r1, 129);
                    r1 = lsls(r1, 23);
                    r7 = adds(r0, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 268 | 1, 268);
                    return;
                case 268:
                    bl(this::__aeabi_f2iz, __ieee754_lgammaf_r + 272 | 1, 272);
                    return;
                case 272:
                    r6 = movs(r6, r0);
                case 274:
                    cmp(r6, 4);
                    if (bgt()) {
                        offset = 322;
                        continue;
                    }
                case 278:
                    cmp(r6, 3);
                    if (bge()) {
                        offset = 404;
                        continue;
                    }
                case 282:
                    cmp(r6, 0);
                    if (beq()) {
                        offset = 356;
                        continue;
                    }
                case 286:
                    if (bge()) {
                        offset = 374;
                        continue;
                    }
                case 288:
                    r1 = movs(r1, 128);
                    r0 = adds(r7, 0);
                    r1 = lsls(r1, 23);
                    step();
                    offset = 410;
                    continue;
                case 296:
                    r0 = movs(r0, 150);
                    r1 = adds(r4, 0);
                    r0 = lsls(r0, 23);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 306 | 1, 306);
                    return;
                case 306:
                    r6 = movs(r6, r7);
                    r6 = ands(r6, r0);
                    r0 = movs(r0, r6);
                    bl(this::__aeabi_i2f, __ieee754_lgammaf_r + 316 | 1, 316);
                    return;
                case 316:
                    r6 = lsls(r6, 2);
                    r7 = adds(r0, 0);
                    step();
                    offset = 274;
                    continue;
                case 322:
                    cmp(r6, 6);
                    if (bgt()) {
                        offset = 288;
                        continue;
                    }
                case 326:
                    r1 = movs(r1, 255);
                    r0 = adds(r7, 0);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 336 | 1, 336);
                    return;
                case 336:
                    r1 = ldr(__ieee754_lgammaf_r + 888);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 342 | 1, 342);
                    return;
                case 342:
                    r1 = movs(r1, 0);
                    bl(this::__kernel_cosf, __ieee754_lgammaf_r + 348 | 1, 348);
                    return;
                case 348:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 24);
                    r0 = adds(r0, r3);
                    step();
                    offset = 396;
                    continue;
                case 356:
                    r1 = ldr(__ieee754_lgammaf_r + 888);
                    r0 = adds(r7, 0);
                case 360:
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 364 | 1, 364);
                    return;
                case 364:
                    r2 = movs(r2, 0);
                    r1 = movs(r1, 0);
                    bl(this::__kernel_sinf, __ieee754_lgammaf_r + 372 | 1, 372);
                    return;
                case 372:
                    step();
                    offset = 396;
                    continue;
                case 374:
                    r0 = movs(r0, 252);
                    r1 = adds(r7, 0);
                    r0 = lsls(r0, 22);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 384 | 1, 384);
                    return;
                case 384:
                    r1 = ldr(__ieee754_lgammaf_r + 888);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 390 | 1, 390);
                    return;
                case 390:
                    r1 = movs(r1, 0);
                    bl(this::__kernel_cosf, __ieee754_lgammaf_r + 396 | 1, 396);
                    return;
                case 396:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 24);
                    r6 = adds(r0, r3);
                    step();
                    offset = 128;
                    continue;
                case 404:
                    r0 = movs(r0, 254);
                    r1 = adds(r7, 0);
                    r0 = lsls(r0, 22);
                case 410:
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 414 | 1, 414);
                    return;
                case 414:
                    r1 = ldr(__ieee754_lgammaf_r + 888);
                    step();
                    offset = 360;
                    continue;
                case 418:
                    r3 = ldr(__ieee754_lgammaf_r + 892);
                    cmp(r5, r3);
                    if (bgt()) {
                        offset = 426;
                        continue;
                    }
                case 424:
                    step();
                    offset = 708;
                    continue;
                case 426:
                    r1 = ldr(__ieee754_lgammaf_r + 896);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 434 | 1, 434);
                    return;
                case 434:
                    r5 = adds(r0, 0);
                case 436:
                    r1 = adds(r5, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 444 | 1, 444);
                    return;
                case 444:
                    r1 = adds(r5, 0);
                    str(sp, r0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 452 | 1, 452);
                    return;
                case 452:
                    r1 = ldr(__ieee754_lgammaf_r + 900);
                    r4 = adds(r0, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 460 | 1, 460);
                    return;
                case 460:
                    r1 = ldr(__ieee754_lgammaf_r + 904);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 466 | 1, 466);
                    return;
                case 466:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 472 | 1, 472);
                    return;
                case 472:
                    r1 = ldr(__ieee754_lgammaf_r + 908);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 478 | 1, 478);
                    return;
                case 478:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 484 | 1, 484);
                    return;
                case 484:
                    r1 = ldr(__ieee754_lgammaf_r + 912);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 490 | 1, 490);
                    return;
                case 490:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 496 | 1, 496);
                    return;
                case 496:
                    r1 = ldr(__ieee754_lgammaf_r + 916);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 502 | 1, 502);
                    return;
                case 502:
                    r1 = ldr(sp);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 508 | 1, 508);
                    return;
                case 508:
                    r1 = ldr(__ieee754_lgammaf_r + 920);
                    str(sp, r0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 518 | 1, 518);
                    return;
                case 518:
                    r1 = ldr(__ieee754_lgammaf_r + 924);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 524 | 1, 524);
                    return;
                case 524:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 530 | 1, 530);
                    return;
                case 530:
                    r1 = ldr(__ieee754_lgammaf_r + 928);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 536 | 1, 536);
                    return;
                case 536:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 542 | 1, 542);
                    return;
                case 542:
                    r1 = ldr(__ieee754_lgammaf_r + 932);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 548 | 1, 548);
                    return;
                case 548:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 554 | 1, 554);
                    return;
                case 554:
                    r1 = ldr(__ieee754_lgammaf_r + 936);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 560 | 1, 560);
                    return;
                case 560:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 566 | 1, 566);
                    return;
                case 566:
                    r1 = ldr(__ieee754_lgammaf_r + 940);
                    r5 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 576 | 1, 576);
                    return;
                case 576:
                    r1 = ldr(__ieee754_lgammaf_r + 944);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 582 | 1, 582);
                    return;
                case 582:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 588 | 1, 588);
                    return;
                case 588:
                    r1 = ldr(__ieee754_lgammaf_r + 948);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 594 | 1, 594);
                    return;
                case 594:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 600 | 1, 600);
                    return;
                case 600:
                    r1 = ldr(__ieee754_lgammaf_r + 952);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 606 | 1, 606);
                    return;
                case 606:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 612 | 1, 612);
                    return;
                case 612:
                    r1 = ldr(__ieee754_lgammaf_r + 956);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 618 | 1, 618);
                    return;
                case 618:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 626 | 1, 626);
                    return;
                case 626:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 632 | 1, 632);
                    return;
                case 632:
                    r1 = adds(r0, 0);
                    r0 = ldr(__ieee754_lgammaf_r + 960);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 640 | 1, 640);
                    return;
                case 640:
                    r1 = adds(r0, 0);
                    r0 = ldr(sp);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 648 | 1, 648);
                    return;
                case 648:
                    r1 = ldr(__ieee754_lgammaf_r + 964);
                    step();
                    offset = 1800;
                    continue;
                case 652:
                    r3 = ldr(__ieee754_lgammaf_r + 968);
                    cmp(r5, r3);
                    if (ble()) {
                        offset = 674;
                        continue;
                    }
                case 658:
                    r0 = movs(r0, 128);
                    r1 = adds(r4, 0);
                    r0 = lsls(r0, 23);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 668 | 1, 668);
                    return;
                case 668:
                    r6 = movs(r6, 0);
                    r5 = adds(r0, 0);
                    step();
                    offset = 1630;
                    continue;
                case 674:
                    r3 = ldr(__ieee754_lgammaf_r + 972);
                    cmp(r5, r3);
                    if (ble()) {
                        offset = 694;
                        continue;
                    }
                case 680:
                    r1 = ldr(__ieee754_lgammaf_r + 976);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 688 | 1, 688);
                    return;
                case 688:
                    r6 = movs(r6, 0);
                    r5 = adds(r0, 0);
                    step();
                    offset = 436;
                    continue;
                case 694:
                    r1 = movs(r1, 254);
                    r0 = adds(r4, 0);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 704 | 1, 704);
                    return;
                case 704:
                    r6 = movs(r6, 0);
                    r4 = adds(r0, 0);
                case 708:
                    r1 = ldr(__ieee754_lgammaf_r + 980);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 716 | 1, 716);
                    return;
                case 716:
                    r1 = ldr(__ieee754_lgammaf_r + 984);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 722 | 1, 722);
                    return;
                case 722:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 728 | 1, 728);
                    return;
                case 728:
                    r1 = ldr(__ieee754_lgammaf_r + 988);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 734 | 1, 734);
                    return;
                case 734:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 740 | 1, 740);
                    return;
                case 740:
                    r1 = ldr(__ieee754_lgammaf_r + 992);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 746 | 1, 746);
                    return;
                case 746:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 752 | 1, 752);
                    return;
                case 752:
                    r1 = ldr(__ieee754_lgammaf_r + 996);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 758 | 1, 758);
                    return;
                case 758:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 764 | 1, 764);
                    return;
                case 764:
                    r1 = ldr(__ieee754_lgammaf_r + 1000);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 770 | 1, 770);
                    return;
                case 770:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 776 | 1, 776);
                    return;
                case 776:
                    r1 = ldr(__ieee754_lgammaf_r + 1004);
                    r5 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 786 | 1, 786);
                    return;
                case 786:
                    r1 = ldr(__ieee754_lgammaf_r + 1008);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 792 | 1, 792);
                    return;
                case 792:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 798 | 1, 798);
                    return;
                case 798:
                    r1 = ldr(__ieee754_lgammaf_r + 1012);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 804 | 1, 804);
                    return;
                case 804:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 810 | 1, 810);
                    return;
                case 810:
                    r1 = ldr(__ieee754_lgammaf_r + 1016);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 816 | 1, 816);
                    return;
                case 816:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 822 | 1, 822);
                    return;
                case 822:
                    r1 = ldr(__ieee754_lgammaf_r + 1020);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 828 | 1, 828);
                    return;
                case 828:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 834 | 1, 834);
                    return;
                case 834:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 842 | 1, 842);
                    return;
                case 842:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fdiv, __ieee754_lgammaf_r + 850 | 1, 850);
                    return;
                case 850:
                    r1 = movs(r1, 191);
                    r5 = adds(r0, 0);
                    r1 = lsls(r1, 24);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 862 | 1, 862);
                    return;
                case 862:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 870 | 1, 870);
                    return;
                case 870:
                    step();
                    offset = 1804;
                    continue;
                case 1024:
                    r3 = ldr(__ieee754_lgammaf_r + 1820);
                    cmp(r5, r3);
                    if (ble()) {
                        offset = 1032;
                        continue;
                    }
                case 1030:
                    step();
                    offset = 1394;
                    continue;
                case 1032:
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_f2iz, __ieee754_lgammaf_r + 1038 | 1, 1038);
                    return;
                case 1038:
                    r5 = movs(r5, r0);
                    bl(this::__aeabi_i2f, __ieee754_lgammaf_r + 1044 | 1, 1044);
                    return;
                case 1044:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 1052 | 1, 1052);
                    return;
                case 1052:
                    r1 = ldr(__ieee754_lgammaf_r + 1824);
                    r6 = adds(r0, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1060 | 1, 1060);
                    return;
                case 1060:
                    r1 = ldr(__ieee754_lgammaf_r + 1828);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1066 | 1, 1066);
                    return;
                case 1066:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1072 | 1, 1072);
                    return;
                case 1072:
                    r1 = ldr(__ieee754_lgammaf_r + 1832);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1078 | 1, 1078);
                    return;
                case 1078:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1084 | 1, 1084);
                    return;
                case 1084:
                    r1 = ldr(__ieee754_lgammaf_r + 1836);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1090 | 1, 1090);
                    return;
                case 1090:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1096 | 1, 1096);
                    return;
                case 1096:
                    r1 = ldr(__ieee754_lgammaf_r + 1840);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1102 | 1, 1102);
                    return;
                case 1102:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1108 | 1, 1108);
                    return;
                case 1108:
                    r1 = ldr(__ieee754_lgammaf_r + 1844);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1114 | 1, 1114);
                    return;
                case 1114:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1120 | 1, 1120);
                    return;
                case 1120:
                    r1 = ldr(__ieee754_lgammaf_r + 1848);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 1126 | 1, 1126);
                    return;
                case 1126:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1132 | 1, 1132);
                    return;
                case 1132:
                    r1 = ldr(__ieee754_lgammaf_r + 1852);
                    r4 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1142 | 1, 1142);
                    return;
                case 1142:
                    r1 = ldr(__ieee754_lgammaf_r + 1856);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1148 | 1, 1148);
                    return;
                case 1148:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1154 | 1, 1154);
                    return;
                case 1154:
                    r1 = ldr(__ieee754_lgammaf_r + 1860);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1160 | 1, 1160);
                    return;
                case 1160:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1166 | 1, 1166);
                    return;
                case 1166:
                    r1 = ldr(__ieee754_lgammaf_r + 1864);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1172 | 1, 1172);
                    return;
                case 1172:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1178 | 1, 1178);
                    return;
                case 1178:
                    r1 = ldr(__ieee754_lgammaf_r + 1868);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1184 | 1, 1184);
                    return;
                case 1184:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1190 | 1, 1190);
                    return;
                case 1190:
                    r1 = ldr(__ieee754_lgammaf_r + 1872);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1196 | 1, 1196);
                    return;
                case 1196:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1202 | 1, 1202);
                    return;
                case 1202:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1210 | 1, 1210);
                    return;
                case 1210:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fdiv, __ieee754_lgammaf_r + 1218 | 1, 1218);
                    return;
                case 1218:
                    r1 = movs(r1, 252);
                    r4 = adds(r0, 0);
                    r1 = lsls(r1, 22);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1230 | 1, 1230);
                    return;
                case 1230:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1238 | 1, 1238);
                    return;
                case 1238:
                    r4 = adds(r0, 0);
                    cmp(r5, 5);
                    if (beq()) {
                        offset = 1376;
                        continue;
                    }
                case 1244:
                    if (bgt()) {
                        offset = 1272;
                        continue;
                    }
                case 1246:
                    cmp(r5, 3);
                    if (beq()) {
                        offset = 1388;
                        continue;
                    }
                case 1250:
                    cmp(r5, 4);
                    if (beq()) {
                        offset = 1382;
                        continue;
                    }
                case 1254:
                    r3 = ldr(sp + 4);
                    cmp(r3, 0);
                    if (blt()) {
                        offset = 1262;
                        continue;
                    }
                case 1260:
                    step();
                    offset = 78;
                    continue;
                case 1262:
                    r1 = adds(r4, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 1270 | 1, 1270);
                    return;
                case 1270:
                    step();
                    offset = 28;
                    continue;
                case 1272:
                    cmp(r5, 6);
                    if (beq()) {
                        offset = 1370;
                        continue;
                    }
                case 1276:
                    cmp(r5, 7);
                    if (bne()) {
                        offset = 1254;
                        continue;
                    }
                case 1280:
                    r1 = ldr(__ieee754_lgammaf_r + 1876);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1288 | 1, 1288);
                    return;
                case 1288:
                    r5 = adds(r0, 0);
                case 1290:
                    r1 = ldr(__ieee754_lgammaf_r + 1880);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1298 | 1, 1298);
                    return;
                case 1298:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1304 | 1, 1304);
                    return;
                case 1304:
                    r5 = adds(r0, 0);
                case 1306:
                    r1 = movs(r1, 129);
                    r0 = adds(r6, 0);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1316 | 1, 1316);
                    return;
                case 1316:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1322 | 1, 1322);
                    return;
                case 1322:
                    r5 = adds(r0, 0);
                case 1324:
                    r1 = ldr(__ieee754_lgammaf_r + 1884);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1332 | 1, 1332);
                    return;
                case 1332:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1338 | 1, 1338);
                    return;
                case 1338:
                    r5 = adds(r0, 0);
                case 1340:
                    r1 = movs(r1, 128);
                    r0 = adds(r6, 0);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1350 | 1, 1350);
                    return;
                case 1350:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1356 | 1, 1356);
                    return;
                case 1356:
                    bl(this::logf, __ieee754_lgammaf_r + 1360 | 1, 1360);
                    return;
                case 1360:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                case 1364:
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1368 | 1, 1368);
                    return;
                case 1368:
                    step();
                    offset = 1556;
                    continue;
                case 1370:
                    r5 = movs(r5, 254);
                    r5 = lsls(r5, 22);
                    step();
                    offset = 1290;
                    continue;
                case 1376:
                    r5 = movs(r5, 254);
                    r5 = lsls(r5, 22);
                    step();
                    offset = 1306;
                    continue;
                case 1382:
                    r5 = movs(r5, 254);
                    r5 = lsls(r5, 22);
                    step();
                    offset = 1324;
                    continue;
                case 1388:
                    r5 = movs(r5, 254);
                    r5 = lsls(r5, 22);
                    step();
                    offset = 1340;
                    continue;
                case 1394:
                    r3 = ldr(__ieee754_lgammaf_r + 1888);
                    r0 = adds(r4, 0);
                    cmp(r5, r3);
                    if (bgt()) {
                        offset = 1538;
                        continue;
                    }
                case 1402:
                    bl(this::logf, __ieee754_lgammaf_r + 1406 | 1, 1406);
                    return;
                case 1406:
                    str(sp, r0);
                    r0 = movs(r0, 254);
                    r1 = adds(r4, 0);
                    r0 = lsls(r0, 22);
                    bl(this::__aeabi_fdiv, __ieee754_lgammaf_r + 1418 | 1, 1418);
                    return;
                case 1418:
                    r1 = adds(r0, 0);
                    r6 = adds(r0, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1426 | 1, 1426);
                    return;
                case 1426:
                    r1 = ldr(__ieee754_lgammaf_r + 1892);
                    r5 = adds(r0, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1434 | 1, 1434);
                    return;
                case 1434:
                    r1 = ldr(__ieee754_lgammaf_r + 1896);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1440 | 1, 1440);
                    return;
                case 1440:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1446 | 1, 1446);
                    return;
                case 1446:
                    r1 = ldr(__ieee754_lgammaf_r + 1900);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 1452 | 1, 1452);
                    return;
                case 1452:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1458 | 1, 1458);
                    return;
                case 1458:
                    r1 = ldr(__ieee754_lgammaf_r + 1904);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1464 | 1, 1464);
                    return;
                case 1464:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1470 | 1, 1470);
                    return;
                case 1470:
                    r1 = ldr(__ieee754_lgammaf_r + 1908);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 1476 | 1, 1476);
                    return;
                case 1476:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1482 | 1, 1482);
                    return;
                case 1482:
                    r1 = ldr(__ieee754_lgammaf_r + 1912);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1488 | 1, 1488);
                    return;
                case 1488:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1494 | 1, 1494);
                    return;
                case 1494:
                    r1 = ldr(__ieee754_lgammaf_r + 1916);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1500 | 1, 1500);
                    return;
                case 1500:
                    r1 = movs(r1, 252);
                    r5 = adds(r0, 0);
                    r1 = lsls(r1, 22);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 1512 | 1, 1512);
                    return;
                case 1512:
                    r1 = movs(r1, 254);
                    r4 = adds(r0, 0);
                    r1 = lsls(r1, 22);
                    r0 = ldr(sp);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 1524 | 1, 1524);
                    return;
                case 1524:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1532 | 1, 1532);
                    return;
                case 1532:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    step();
                    offset = 1364;
                    continue;
                case 1538:
                    bl(this::logf, __ieee754_lgammaf_r + 1542 | 1, 1542);
                    return;
                case 1542:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 1550 | 1, 1550);
                    return;
                case 1550:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1556 | 1, 1556);
                    return;
                case 1556:
                    r4 = adds(r0, 0);
                    step();
                    offset = 1254;
                    continue;
                case 1560:
                    r3 = movs(r3, 254);
                    r3 = lsls(r3, 22);
                    cmp(r5, r3);
                    if (bne()) {
                        offset = 1808;
                        continue;
                    }
                case 1568:
                    r4 = movs(r4, 0);
                    step();
                    offset = 78;
                    continue;
                case 1572:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 23);
                    cmp(r5, r3);
                    if (bne()) {
                        offset = 1582;
                        continue;
                    }
                case 1580:
                    step();
                    offset = 200;
                    continue;
                case 1582:
                    r3 = ldr(__ieee754_lgammaf_r + 1920);
                    cmp(r5, r3);
                    if (ble()) {
                        offset = 1590;
                        continue;
                    }
                case 1588:
                    step();
                    offset = 1024;
                    continue;
                case 1590:
                    r3 = ldr(__ieee754_lgammaf_r + 1924);
                    cmp(r5, r3);
                    if (ble()) {
                        offset = 1598;
                        continue;
                    }
                case 1596:
                    step();
                    offset = 652;
                    continue;
                case 1598:
                    r0 = adds(r4, 0);
                    bl(this::logf, __ieee754_lgammaf_r + 1604 | 1, 1604);
                    return;
                case 1604:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 24);
                    r6 = adds(r0, r3);
                    r3 = ldr(__ieee754_lgammaf_r + 1928);
                    cmp(r5, r3);
                    if (bgt()) {
                        offset = 1618;
                        continue;
                    }
                case 1616:
                    step();
                    offset = 418;
                    continue;
                case 1618:
                    r0 = movs(r0, 254);
                    r1 = adds(r4, 0);
                    r0 = lsls(r0, 22);
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 1628 | 1, 1628);
                    return;
                case 1628:
                    r5 = adds(r0, 0);
                case 1630:
                    r1 = adds(r5, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1638 | 1, 1638);
                    return;
                case 1638:
                    r1 = ldr(__ieee754_lgammaf_r + 1932);
                    r4 = adds(r0, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1646 | 1, 1646);
                    return;
                case 1646:
                    r1 = ldr(__ieee754_lgammaf_r + 1936);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1652 | 1, 1652);
                    return;
                case 1652:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1658 | 1, 1658);
                    return;
                case 1658:
                    r1 = ldr(__ieee754_lgammaf_r + 1940);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1664 | 1, 1664);
                    return;
                case 1664:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1670 | 1, 1670);
                    return;
                case 1670:
                    r1 = ldr(__ieee754_lgammaf_r + 1944);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1676 | 1, 1676);
                    return;
                case 1676:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1682 | 1, 1682);
                    return;
                case 1682:
                    r1 = ldr(__ieee754_lgammaf_r + 1948);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1688 | 1, 1688);
                    return;
                case 1688:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1694 | 1, 1694);
                    return;
                case 1694:
                    r1 = ldr(__ieee754_lgammaf_r + 1848);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1700 | 1, 1700);
                    return;
                case 1700:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1706 | 1, 1706);
                    return;
                case 1706:
                    r1 = ldr(__ieee754_lgammaf_r + 1952);
                    str(sp, r0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1716 | 1, 1716);
                    return;
                case 1716:
                    r1 = ldr(__ieee754_lgammaf_r + 1956);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1722 | 1, 1722);
                    return;
                case 1722:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1728 | 1, 1728);
                    return;
                case 1728:
                    r1 = ldr(__ieee754_lgammaf_r + 1960);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1734 | 1, 1734);
                    return;
                case 1734:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1740 | 1, 1740);
                    return;
                case 1740:
                    r1 = ldr(__ieee754_lgammaf_r + 1964);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1746 | 1, 1746);
                    return;
                case 1746:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1752 | 1, 1752);
                    return;
                case 1752:
                    r1 = ldr(__ieee754_lgammaf_r + 1968);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1758 | 1, 1758);
                    return;
                case 1758:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1764 | 1, 1764);
                    return;
                case 1764:
                    r1 = ldr(__ieee754_lgammaf_r + 1972);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1770 | 1, 1770);
                    return;
                case 1770:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1776 | 1, 1776);
                    return;
                case 1776:
                    r1 = adds(r0, 0);
                    r0 = ldr(sp);
                    bl(this::__aeabi_fadd, __ieee754_lgammaf_r + 1784 | 1, 1784);
                    return;
                case 1784:
                    r1 = movs(r1, 252);
                    r4 = adds(r0, 0);
                    r1 = lsls(r1, 22);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __ieee754_lgammaf_r + 1796 | 1, 1796);
                    return;
                case 1796:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                case 1800:
                    bl(this::__aeabi_fsub, __ieee754_lgammaf_r + 1804 | 1, 1804);
                    return;
                case 1804:
                    r1 = adds(r6, 0);
                    step();
                    offset = 1364;
                    continue;
                case 1808:
                    r3 = movs(r3, 128);
                    r7 = movs(r7, 0);
                    r3 = lsls(r3, 23);
                    cmp(r5, r3);
                    if (bne()) {
                        offset = 1582;
                        continue;
                    }
                case 1818:
                    step();
                    offset = 1568;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134335032, size=208, name='fmodf', path='build/lib/libm/fmodf.o', has_indirect=True)
    protected void fmodf(int offset) throws Exception
    {
        while (true)
        {
            pc = fmodf + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6);
                    r5 = adds(r0, 0);
                    r4 = adds(r1, 0);
                    r6 = lsls(r1, 1);
                    if (beq()) {
                        offset = 30;
                        continue;
                    }
                case 10:
                    r0 = adds(r1, 0);
                    bl(this::__aeabi_fcmpun, fmodf + 16 | 1, 16);
                    return;
                case 16:
                    cmp(r0, 0);
                    if (bne()) {
                        offset = 30;
                        continue;
                    }
                case 20:
                    r3 = lsrs(r5, 23);
                    r3 = uxtb(r3);
                    r2 = movs(r2, r5);
                    cmp(r3, 255);
                    if (bne()) {
                        offset = 50;
                        continue;
                    }
                case 30:
                    r1 = adds(r4, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fmul, fmodf + 38 | 1, 38);
                    return;
                case 38:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fdiv, fmodf + 44 | 1, 44);
                    return;
                case 44:
                    r5 = adds(r0, 0);
                case 46:
                    r0 = adds(r5, 0);
                    pop(true, R4, R5, R6);
                    return;
                case 50:
                    r1 = lsls(r5, 1);
                    cmp(r6, r1);
                    if (blo()) {
                        offset = 68;
                        continue;
                    }
                case 56:
                    if (bne()) {
                        offset = 46;
                        continue;
                    }
                case 58:
                    r1 = movs(r1, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fmul, fmodf + 66 | 1, 66);
                    return;
                case 66:
                    step();
                    offset = 44;
                    continue;
                case 68:
                    r0 = lsls(r5, 9);
                    cmp(r3, 0);
                    if (bne()) {
                        offset = 150;
                        continue;
                    }
                case 74:
                    cmp(r0, 0);
                    if (bge()) {
                        offset = 144;
                        continue;
                    }
                case 78:
                    r1 = movs(r1, 1);
                    r0 = movs(r0, r2);
                    r1 = subs(r1, r3);
                    r0 = lsls(r0, r1);
                case 86:
                    r6 = lsrs(r4, 23);
                    r6 = uxtb(r6);
                    r1 = lsls(r4, 9);
                    cmp(r6, 0);
                    if (bne()) {
                        offset = 166;
                        continue;
                    }
                case 96:
                    cmp(r1, 0);
                    if (bge()) {
                        offset = 160;
                        continue;
                    }
                case 100:
                    r1 = movs(r1, 1);
                    r1 = subs(r1, r6);
                    r4 = lsls(r4, r1);
                case 106:
                    r1 = subs(r0, r4);
                    cmp(r3, r6);
                    if (bgt()) {
                        offset = 176;
                        continue;
                    }
                case 112:
                    cmp(r1, 0);
                    if (blt()) {
                        offset = 120;
                        continue;
                    }
                case 116:
                    r0 = subs(r1, 0);
                    if (beq()) {
                        offset = 58;
                        continue;
                    }
                case 120:
                    r1 = lsrs(r0, 23);
                    if (beq()) {
                        offset = 190;
                        continue;
                    }
                case 124:
                    cmp(r3, 0);
                    if (ble()) {
                        offset = 196;
                        continue;
                    }
                case 128:
                    r1 = ldr(fmodf + 204);
                    r1 = adds(r0, r1);
                    r0 = lsls(r3, 23);
                    r0 = orrs(r0, r1);
                case 136:
                    r5 = lsrs(r2, 31);
                    r5 = lsls(r5, 31);
                    r5 = orrs(r5, r0);
                    step();
                    offset = 46;
                    continue;
                case 144:
                    r3 = subs(r3, 1);
                    r0 = lsls(r0, 1);
                    step();
                    offset = 74;
                    continue;
                case 150:
                    r1 = movs(r1, 128);
                    r0 = lsrs(r0, 9);
                    r1 = lsls(r1, 16);
                    r0 = orrs(r0, r1);
                    step();
                    offset = 86;
                    continue;
                case 160:
                    r6 = subs(r6, 1);
                    r1 = lsls(r1, 1);
                    step();
                    offset = 96;
                    continue;
                case 166:
                    r4 = movs(r4, 128);
                    r1 = lsrs(r1, 9);
                    r4 = lsls(r4, 16);
                    r4 = orrs(r4, r1);
                    step();
                    offset = 106;
                    continue;
                case 176:
                    cmp(r1, 0);
                    if (blt()) {
                        offset = 184;
                        continue;
                    }
                case 180:
                    if (beq()) {
                        offset = 58;
                        continue;
                    }
                case 182:
                    r0 = movs(r0, r1);
                case 184:
                    r0 = lsls(r0, 1);
                    r3 = subs(r3, 1);
                    step();
                    offset = 106;
                    continue;
                case 190:
                    r0 = lsls(r0, 1);
                    r3 = subs(r3, 1);
                    step();
                    offset = 120;
                    continue;
                case 196:
                    r1 = movs(r1, 1);
                    r3 = subs(r1, r3);
                    r0 = lsrs(r0, r3);
                    step();
                    offset = 136;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134335240, size=260, name='__kernel_cosf', path='build/lib/libm/kf_cos.o', has_indirect=False)
    protected void __kernel_cosf(int offset) throws Exception
    {
        while (true)
        {
            pc = __kernel_cosf + offset;
            switch (offset)
            {
                case 0:
                    push(true, r0, r1, r2, r4, r5, r6, r7);
                    r3 = ldr(__kernel_cosf + 220);
                    r4 = lsls(r0, 1);
                    r6 = adds(r0, 0);
                    str(sp + 4, r1);
                    r4 = lsrs(r4, 1);
                    cmp(r4, r3);
                    if (bgt()) {
                        offset = 24;
                        continue;
                    }
                case 16:
                    bl(this::__aeabi_f2iz, __kernel_cosf + 20 | 1, 20);
                    return;
                case 20:
                    cmp(r0, 0);
                    if (beq()) {
                        offset = 212;
                        continue;
                    }
                case 24:
                    r1 = adds(r6, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fmul, __kernel_cosf + 32 | 1, 32);
                    return;
                case 32:
                    r1 = movs(r1, 252);
                    r1 = lsls(r1, 22);
                    r5 = adds(r0, 0);
                    bl(this::__aeabi_fmul, __kernel_cosf + 42 | 1, 42);
                    return;
                case 42:
                    r1 = ldr(__kernel_cosf + 224);
                    r7 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __kernel_cosf + 52 | 1, 52);
                    return;
                case 52:
                    r1 = ldr(__kernel_cosf + 228);
                    bl(this::__aeabi_fadd, __kernel_cosf + 58 | 1, 58);
                    return;
                case 58:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __kernel_cosf + 64 | 1, 64);
                    return;
                case 64:
                    r1 = ldr(__kernel_cosf + 232);
                    bl(this::__aeabi_fsub, __kernel_cosf + 70 | 1, 70);
                    return;
                case 70:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __kernel_cosf + 76 | 1, 76);
                    return;
                case 76:
                    r1 = ldr(__kernel_cosf + 236);
                    bl(this::__aeabi_fadd, __kernel_cosf + 82 | 1, 82);
                    return;
                case 82:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __kernel_cosf + 88 | 1, 88);
                    return;
                case 88:
                    r1 = ldr(__kernel_cosf + 240);
                    bl(this::__aeabi_fsub, __kernel_cosf + 94 | 1, 94);
                    return;
                case 94:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __kernel_cosf + 100 | 1, 100);
                    return;
                case 100:
                    r1 = ldr(__kernel_cosf + 244);
                    bl(this::__aeabi_fadd, __kernel_cosf + 106 | 1, 106);
                    return;
                case 106:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __kernel_cosf + 112 | 1, 112);
                    return;
                case 112:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __kernel_cosf + 118 | 1, 118);
                    return;
                case 118:
                    r1 = ldr(sp + 4);
                    r5 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fmul, __kernel_cosf + 128 | 1, 128);
                    return;
                case 128:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fsub, __kernel_cosf + 136 | 1, 136);
                    return;
                case 136:
                    r3 = ldr(__kernel_cosf + 248);
                    r5 = adds(r0, 0);
                    cmp(r4, r3);
                    if (bgt()) {
                        offset = 164;
                        continue;
                    }
                case 144:
                    r1 = adds(r0, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fsub, __kernel_cosf + 152 | 1, 152);
                    return;
                case 152:
                    r1 = adds(r0, 0);
                    r0 = movs(r0, 254);
                    r0 = lsls(r0, 22);
                case 158:
                    bl(this::__aeabi_fsub, __kernel_cosf + 162 | 1, 162);
                    return;
                case 162:
                    pop(true, R1, R2, R3, R4, R5, R6, R7);
                    return;
                case 164:
                    r3 = ldr(__kernel_cosf + 252);
                    cmp(r4, r3);
                    if (bgt()) {
                        offset = 208;
                        continue;
                    }
                case 170:
                    r3 = movs(r3, 255);
                    r3 = lsls(r3, 24);
                    r4 = adds(r4, r3);
                case 176:
                    r0 = movs(r0, 254);
                    r1 = adds(r4, 0);
                    r0 = lsls(r0, 22);
                    bl(this::__aeabi_fsub, __kernel_cosf + 186 | 1, 186);
                    return;
                case 186:
                    r1 = adds(r4, 0);
                    r6 = adds(r0, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fsub, __kernel_cosf + 196 | 1, 196);
                    return;
                case 196:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fsub, __kernel_cosf + 202 | 1, 202);
                    return;
                case 202:
                    r1 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    step();
                    offset = 158;
                    continue;
                case 208:
                    r4 = ldr(__kernel_cosf + 256);
                    step();
                    offset = 176;
                    continue;
                case 212:
                    r0 = movs(r0, 254);
                    r0 = lsls(r0, 22);
                    step();
                    offset = 162;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134335500, size=1428, name='__kernel_rem_pio2f', path='build/lib/libm/kf_rem_pio2.o', has_indirect=False)
    protected void __kernel_rem_pio2f(int offset) throws Exception
    {
        while (true)
        {
            pc = __kernel_rem_pio2f + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6, r7);
                    sp = sub(sp, 380);
                    str(sp + 36, r0);
                    r0 = movs(r0, 7);
                    str(sp + 32, r3);
                    r3 = ldr(sp + 400);
                    str(sp + 12, r1);
                    r1 = lsls(r3, 2);
                    r3 = ldr(__kernel_rem_pio2f + 848); // init_jk;
                    r4 = movs(r4, 0);
                    r3 = ldr(r1 + r3);
                    r1 = subs(r2, 3);
                    str(sp + 24, r3);
                    r3 = ldr(sp + 32);
                    r7 = add(sp, 136);
                    r3 = subs(r3, 1);
                    str(sp + 28, r3);
                    r3 = asrs(r1, 31);
                    r3 = ands(r3, r0);
                    r3 = adds(r3, r1);
                    r3 = asrs(r3, 3);
                    str(sp + 16, r3);
                    r3 = mvns(r3, r3);
                    r1 = ldr(sp + 16);
                    r3 = asrs(r3, 31);
                    r1 = ands(r1, r3);
                    r3 = movs(r3, r1);
                    r3 = adds(r3, 1);
                    r3 = lsls(r3, 3);
                    r3 = subs(r2, r3);
                    r2 = ldr(sp + 28);
                    str(sp + 4, r3);
                    r12 = mov(r2);
                    r3 = ldr(sp + 24);
                    r6 = subs(r1, r2);
                    r3 = add(r3, r12);
                    str(sp + 8, r3);
                    r3 = ldr(sp + 404);
                    r5 = lsls(r6, 2);
                    str(sp + 16, r1);
                    r5 = adds(r3, r5);
                case 82:
                    r3 = ldr(sp + 8);
                    cmp(r4, r3);
                    if (ble()) {
                        offset = 344;
                        continue;
                    }
                case 88:
                    r5 = movs(r5, 0);
                    r3 = ldr(sp + 32);
                    r4 = lsls(r3, 2);
                    r3 = add(sp, 136);
                    r4 = adds(r3, r4);
                case 98:
                    r3 = ldr(sp + 24);
                    cmp(r5, r3);
                    if (bgt()) {
                        offset = 106;
                        continue;
                    }
                case 104:
                    step();
                    offset = 416;
                    continue;
                case 106:
                    r3 = lsls(r3, 2);
                    r2 = add(sp, 56);
                    r3 = adds(r3, r2);
                    r7 = ldr(sp + 24);
                    str(sp + 48, r3);
                case 116:
                    r6 = movs(r6, r7);
                    r3 = lsls(r7, 2);
                    r5 = add(sp, 296);
                    r2 = add(sp, 56);
                    str(sp + 52, r3);
                    r4 = ldr(r3 + r5);
                    r3 = adds(r3, r2);
                    str(sp + 8, r3);
                    str(sp + 40, r5);
                case 134:
                    cmp(r6, 0);
                    if (ble()) {
                        offset = 140;
                        continue;
                    }
                case 138:
                    step();
                    offset = 422;
                    continue;
                case 140:
                    r1 = ldr(sp + 4);
                    r0 = adds(r4, 0);
                    bl(this::scalbnf, __kernel_rem_pio2f + 148 | 1, 148);
                    return;
                case 148:
                    r1 = movs(r1, 248);
                    r1 = lsls(r1, 22);
                    r4 = adds(r0, 0);
                    bl(this::__aeabi_fmul, __kernel_rem_pio2f + 158 | 1, 158);
                    return;
                case 158:
                    bl(this::floorf, __kernel_rem_pio2f + 162 | 1, 162);
                    return;
                case 162:
                    r1 = movs(r1, 130);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fmul, __kernel_rem_pio2f + 170 | 1, 170);
                    return;
                case 170:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, __kernel_rem_pio2f + 178 | 1, 178);
                    return;
                case 178:
                    r4 = adds(r0, 0);
                    bl(this::__aeabi_f2iz, __kernel_rem_pio2f + 184 | 1, 184);
                    return;
                case 184:
                    str(sp + 20, r0);
                    bl(this::__aeabi_i2f, __kernel_rem_pio2f + 190 | 1, 190);
                    return;
                case 190:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, __kernel_rem_pio2f + 198 | 1, 198);
                    return;
                case 198:
                    r3 = ldr(sp + 4);
                    r4 = adds(r0, 0);
                    cmp(r3, 0);
                    if (bgt()) {
                        offset = 208;
                        continue;
                    }
                case 206:
                    step();
                    offset = 492;
                    continue;
                case 208:
                    r1 = movs(r1, 8);
                    r3 = subs(r7, 1);
                    r3 = lsls(r3, 2);
                    r2 = add(sp, 56);
                    r2 = ldr(r3 + r2);
                    r0 = ldr(sp + 4);
                    r5 = ldr(sp + 20);
                    r1 = subs(r1, r0);
                    r0 = movs(r0, r2);
                    r0 = asrs(r0, r1);
                    r5 = adds(r5, r0);
                    r0 = lsls(r0, r1);
                    r0 = subs(r2, r0);
                    r2 = add(sp, 56);
                    str(r3 + r2, r0);
                    r3 = movs(r3, 7);
                    r2 = ldr(sp + 4);
                    str(sp + 20, r5);
                    r3 = subs(r3, r2);
                    r0 = asrs(r0, r3);
                    str(sp + 8, r0);
                case 250:
                    r3 = ldr(sp + 8);
                    cmp(r3, 0);
                    if (bgt()) {
                        offset = 258;
                        continue;
                    }
                case 256:
                    step();
                    offset = 526;
                    continue;
                case 258:
                    r3 = ldr(sp + 20);
                    r2 = movs(r2, 0);
                    r3 = adds(r3, 1);
                    str(sp + 20, r3);
                    r3 = movs(r3, 1);
                    r6 = movs(r6, 128);
                    r5 = movs(r5, r2);
                    r12 = mov(r3);
                    r6 = lsls(r6, 1);
                case 276:
                    cmp(r7, r2);
                    if (ble()) {
                        offset = 282;
                        continue;
                    }
                case 280:
                    step();
                    offset = 656;
                    continue;
                case 282:
                    r3 = ldr(sp + 4);
                    cmp(r3, 0);
                    if (ble()) {
                        offset = 300;
                        continue;
                    }
                case 288:
                    cmp(r3, 1);
                    if (bne()) {
                        offset = 294;
                        continue;
                    }
                case 292:
                    step();
                    offset = 696;
                    continue;
                case 294:
                    cmp(r3, 2);
                    if (bne()) {
                        offset = 300;
                        continue;
                    }
                case 298:
                    step();
                    offset = 718;
                    continue;
                case 300:
                    r3 = ldr(sp + 8);
                    cmp(r3, 2);
                    if (bne()) {
                        offset = 526;
                        continue;
                    }
                case 306:
                    r0 = movs(r0, 254);
                    r1 = adds(r4, 0);
                    r0 = lsls(r0, 22);
                    bl(this::__aeabi_fsub, __kernel_rem_pio2f + 316 | 1, 316);
                    return;
                case 316:
                    r4 = adds(r0, 0);
                    cmp(r5, 0);
                    if (beq()) {
                        offset = 526;
                        continue;
                    }
                case 322:
                    r0 = movs(r0, 254);
                    r1 = ldr(sp + 4);
                    r0 = lsls(r0, 22);
                    bl(this::scalbnf, __kernel_rem_pio2f + 332 | 1, 332);
                    return;
                case 332:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, __kernel_rem_pio2f + 340 | 1, 340);
                    return;
                case 340:
                    r4 = adds(r0, 0);
                    step();
                    offset = 526;
                    continue;
                case 344:
                    r0 = movs(r0, 0);
                    cmn(r6, r4);
                    if (bmi()) {
                        offset = 358;
                        continue;
                    }
                case 350:
                    r3 = lsls(r4, 2);
                    r0 = ldr(r5 + r3);
                    bl(this::__aeabi_i2f, __kernel_rem_pio2f + 358 | 1, 358);
                    return;
                case 358:
                    r3 = lsls(r4, 2);
                    str(r3 + r7, r0);
                    r4 = adds(r4, 1);
                    step();
                    offset = 82;
                    continue;
                case 366:
                    r2 = lsls(r6, 2);
                    r3 = subs(r4, r2);
                    r1 = ldr(sp + 36);
                    r3 = subs(r3, 4);
                    r1 = ldr(r1 + r2);
                    r0 = ldr(r3);
                    bl(this::__aeabi_fmul, __kernel_rem_pio2f + 382 | 1, 382);
                    return;
                case 382:
                    r1 = adds(r0, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fadd, __kernel_rem_pio2f + 390 | 1, 390);
                    return;
                case 390:
                    r6 = adds(r6, 1);
                    r7 = adds(r0, 0);
                case 394:
                    r3 = ldr(sp + 28);
                    cmp(r6, r3);
                    if (ble()) {
                        offset = 366;
                        continue;
                    }
                case 400:
                    r1 = movs(r1, 240);
                    r2 = add(sp, 56);
                    r3 = lsls(r5, 2);
                    r2 = adds(r2, r1);
                    str(r2 + r3, r7);
                    r5 = adds(r5, 1);
                    r4 = adds(r4, 4);
                    step();
                    offset = 98;
                    continue;
                case 416:
                    r7 = movs(r7, 0);
                    r6 = movs(r6, 0);
                    step();
                    offset = 394;
                    continue;
                case 422:
                    r1 = movs(r1, 238);
                    r0 = adds(r4, 0);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fmul, __kernel_rem_pio2f + 432 | 1, 432);
                    return;
                case 432:
                    bl(this::__aeabi_f2iz, __kernel_rem_pio2f + 436 | 1, 436);
                    return;
                case 436:
                    bl(this::__aeabi_i2f, __kernel_rem_pio2f + 440 | 1, 440);
                    return;
                case 440:
                    r1 = movs(r1, 135);
                    r3 = lsls(r6, 2);
                    r3 = rsbs(r3);
                    r1 = lsls(r1, 23);
                    str(sp + 20, r3);
                    r5 = adds(r0, 0);
                    bl(this::__aeabi_fmul, __kernel_rem_pio2f + 456 | 1, 456);
                    return;
                case 456:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, __kernel_rem_pio2f + 464 | 1, 464);
                    return;
                case 464:
                    bl(this::__aeabi_f2iz, __kernel_rem_pio2f + 468 | 1, 468);
                    return;
                case 468:
                    r3 = ldr(sp + 8);
                    r2 = ldr(sp + 20);
                    r6 = subs(r6, 1);
                    str(r3 + r2, r0);
                    r2 = ldr(sp + 40);
                    r3 = lsls(r6, 2);
                    r1 = ldr(r3 + r2);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fadd, __kernel_rem_pio2f + 488 | 1, 488);
                    return;
                case 488:
                    r4 = adds(r0, 0);
                    step();
                    offset = 134;
                    continue;
                case 492:
                    r3 = ldr(sp + 4);
                    cmp(r3, 0);
                    if (bne()) {
                        offset = 512;
                        continue;
                    }
                case 498:
                    r3 = subs(r7, 1);
                    r3 = lsls(r3, 2);
                    r2 = add(sp, 56);
                    r0 = ldr(r3 + r2);
                    r3 = asrs(r0, 8);
                    str(sp + 8, r3);
                    step();
                    offset = 250;
                    continue;
                case 512:
                    r1 = movs(r1, 252);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fcmpge, __kernel_rem_pio2f + 520 | 1, 520);
                    return;
                case 520:
                    cmp(r0, 0);
                    if (bne()) {
                        offset = 650;
                        continue;
                    }
                case 524:
                    str(sp + 8, r0);
                case 526:
                    r1 = movs(r1, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fcmpeq, __kernel_rem_pio2f + 534 | 1, 534);
                    return;
                case 534:
                    cmp(r0, 0);
                    if (bne()) {
                        offset = 540;
                        continue;
                    }
                case 538:
                    step();
                    offset = 892;
                    continue;
                case 540:
                    r3 = movs(r3, r7);
                    r2 = movs(r2, 0);
                    r1 = subs(r7, 1);
                case 546:
                    r0 = ldr(sp + 24);
                    r3 = subs(r3, 1);
                    cmp(r0, r3);
                    if (ble()) {
                        offset = 732;
                        continue;
                    }
                case 554:
                    cmp(r2, 0);
                    if (bne()) {
                        offset = 560;
                        continue;
                    }
                case 558:
                    step();
                    offset = 844;
                    continue;
                case 560:
                    r7 = movs(r7, r1);
                    r3 = ldr(sp + 4);
                    r3 = subs(r3, 8);
                    str(sp + 4, r3);
                case 568:
                    r3 = lsls(r7, 2);
                    r2 = add(sp, 56);
                    r3 = ldr(r3 + r2);
                    cmp(r3, 0);
                    if (bne()) {
                        offset = 580;
                        continue;
                    }
                case 578:
                    step();
                    offset = 882;
                    continue;
                case 580:
                    r0 = movs(r0, 254);
                    r1 = ldr(sp + 4);
                    r0 = lsls(r0, 22);
                    bl(this::scalbnf, __kernel_rem_pio2f + 590 | 1, 590);
                    return;
                case 590:
                    r3 = lsls(r7, 2);
                    r5 = movs(r5, r3);
                    r6 = movs(r6, r7);
                    r4 = adds(r0, 0);
                    str(sp + 4, r3);
                case 600:
                    cmp(r6, 0);
                    if (blt()) {
                        offset = 606;
                        continue;
                    }
                case 604:
                    step();
                    offset = 998;
                    continue;
                case 606:
                    r5 = movs(r5, 0);
                    r2 = ldr(sp + 4);
                    r3 = add(sp, 296);
                    r4 = adds(r3, r2);
                case 614:
                    r3 = subs(r7, r5);
                    if (bmi()) {
                        offset = 620;
                        continue;
                    }
                case 618:
                    step();
                    offset = 1090;
                    continue;
                case 620:
                    r3 = ldr(sp + 400);
                    cmp(r3, 2);
                    if (ble()) {
                        offset = 628;
                        continue;
                    }
                case 626:
                    step();
                    offset = 1098;
                    continue;
                case 628:
                    cmp(r3, 0);
                    if (ble()) {
                        offset = 634;
                        continue;
                    }
                case 632:
                    step();
                    offset = 1216;
                    continue;
                case 634:
                    if (bne()) {
                        offset = 638;
                        continue;
                    }
                case 636:
                    step();
                    offset = 1144;
                    continue;
                case 638:
                    r0 = movs(r0, 7);
                    r3 = ldr(sp + 20);
                    r3 = ands(r3, r0);
                    r0 = movs(r0, r3);
                    sp = add(sp, 380);
                    pop(true, R4, R5, R6, R7);
                    return;
                case 650:
                    r3 = movs(r3, 2);
                    str(sp + 8, r3);
                    step();
                    offset = 258;
                    continue;
                case 656:
                    r1 = lsls(r2, 2);
                    r3 = add(sp, 56);
                    r3 = ldr(r1 + r3);
                    cmp(r5, 0);
                    if (bne()) {
                        offset = 684;
                        continue;
                    }
                case 666:
                    cmp(r3, 0);
                    if (beq()) {
                        offset = 678;
                        continue;
                    }
                case 670:
                    r3 = subs(r6, r3);
                    r5 = add(sp, 56);
                    str(r1 + r5, r3);
                    r3 = mov(r12);
                case 678:
                    r2 = adds(r2, 1);
                    r5 = movs(r5, r3);
                    step();
                    offset = 276;
                    continue;
                case 684:
                    r0 = movs(r0, 255);
                    r3 = subs(r0, r3);
                    r0 = add(sp, 56);
                    str(r1 + r0, r3);
                    r3 = movs(r3, r5);
                    step();
                    offset = 678;
                    continue;
                case 696:
                    r3 = subs(r7, 1);
                    r3 = lsls(r3, 2);
                    r2 = add(sp, 56);
                    r2 = ldr(r3 + r2);
                    str(sp + 40, r2);
                    r2 = movs(r2, 127);
                case 708:
                    r1 = ldr(sp + 40);
                    r2 = ands(r2, r1);
                    r1 = add(sp, 56);
                    str(r3 + r1, r2);
                    step();
                    offset = 300;
                    continue;
                case 718:
                    r3 = subs(r7, 1);
                    r3 = lsls(r3, 2);
                    r2 = add(sp, 56);
                    r2 = ldr(r3 + r2);
                    str(sp + 40, r2);
                    r2 = movs(r2, 63);
                    step();
                    offset = 708;
                    continue;
                case 732:
                    r0 = lsls(r3, 2);
                    r4 = add(sp, 56);
                    r0 = ldr(r0 + r4);
                    r2 = orrs(r2, r0);
                    step();
                    offset = 546;
                    continue;
                case 742:
                    r3 = adds(r3, 1);
                case 744:
                    r2 = lsls(r3, 2);
                    r1 = ldr(sp + 48);
                    r2 = rsbs(r2);
                    r2 = ldr(r1 + r2);
                    cmp(r2, 0);
                    if (beq()) {
                        offset = 742;
                        continue;
                    }
                case 756:
                    r4 = movs(r4, 0);
                    r2 = adds(r7, 1);
                    str(sp + 8, r2);
                    r2 = ldr(sp + 16);
                    r1 = add(sp, 136);
                    r2 = adds(r2, r7);
                    r2 = lsls(r2, 2);
                    str(sp + 40, r2);
                    r2 = ldr(sp + 32);
                    r2 = adds(r7, r2);
                    r2 = lsls(r2, 2);
                    r2 = adds(r1, r2);
                    str(sp + 20, r2);
                    r7 = adds(r7, r3);
                case 784:
                    r3 = ldr(sp + 8);
                    cmp(r7, r3);
                    if (bge()) {
                        offset = 792;
                        continue;
                    }
                case 790:
                    step();
                    offset = 116;
                    continue;
                case 792:
                    r3 = ldr(sp + 40);
                    r2 = ldr(sp + 404);
                    r3 = adds(r4, r3);
                    r3 = adds(r2, r3);
                    r0 = ldr(r3 + 4);
                    bl(this::__aeabi_i2f, __kernel_rem_pio2f + 806 | 1, 806);
                    return;
                case 806:
                    r5 = movs(r5, 0);
                    r6 = movs(r6, 0);
                    r3 = ldr(sp + 20);
                    str(r3 + r4, r0);
                    r3 = adds(r3, r4);
                    str(sp + 44, r3);
                case 818:
                    r3 = ldr(sp + 28);
                    cmp(r5, r3);
                    if (ble()) {
                        offset = 852;
                        continue;
                    }
                case 824:
                    r3 = ldr(sp + 52);
                    r2 = add(sp, 296);
                    r3 = adds(r4, r3);
                    r3 = adds(r2, r3);
                    str(r3 + 4, r6);
                    r3 = ldr(sp + 8);
                    r4 = adds(r4, 4);
                    r3 = adds(r3, 1);
                    str(sp + 8, r3);
                    step();
                    offset = 784;
                    continue;
                case 844:
                    r3 = movs(r3, 1);
                    step();
                    offset = 744;
                    continue;
                case 852:
                    r3 = lsls(r5, 2);
                    r1 = ldr(sp + 44);
                    r2 = rsbs(r3);
                    r1 = ldr(r1 + r2);
                    r2 = ldr(sp + 36);
                    r5 = adds(r5, 1);
                    r0 = ldr(r2 + r3);
                    bl(this::__aeabi_fmul, __kernel_rem_pio2f + 870 | 1, 870);
                    return;
                case 870:
                    r1 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fadd, __kernel_rem_pio2f + 878 | 1, 878);
                    return;
                case 878:
                    r6 = adds(r0, 0);
                    step();
                    offset = 818;
                    continue;
                case 882:
                    r3 = ldr(sp + 4);
                    r7 = subs(r7, 1);
                    r3 = subs(r3, 8);
                    str(sp + 4, r3);
                    step();
                    offset = 568;
                    continue;
                case 892:
                    r3 = ldr(sp + 4);
                    r0 = adds(r4, 0);
                    r1 = rsbs(r3);
                    bl(this::scalbnf, __kernel_rem_pio2f + 902 | 1, 902);
                    return;
                case 902:
                    r1 = movs(r1, 135);
                    r1 = lsls(r1, 23);
                    r4 = adds(r0, 0);
                    bl(this::__aeabi_fcmpge, __kernel_rem_pio2f + 912 | 1, 912);
                    return;
                case 912:
                    cmp(r0, 0);
                    if (beq()) {
                        offset = 984;
                        continue;
                    }
                case 916:
                    r1 = movs(r1, 238);
                    r0 = adds(r4, 0);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fmul, __kernel_rem_pio2f + 926 | 1, 926);
                    return;
                case 926:
                    bl(this::__aeabi_f2iz, __kernel_rem_pio2f + 930 | 1, 930);
                    return;
                case 930:
                    bl(this::__aeabi_i2f, __kernel_rem_pio2f + 934 | 1, 934);
                    return;
                case 934:
                    r1 = movs(r1, 135);
                    r1 = lsls(r1, 23);
                    r5 = adds(r0, 0);
                    bl(this::__aeabi_fmul, __kernel_rem_pio2f + 944 | 1, 944);
                    return;
                case 944:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, __kernel_rem_pio2f + 952 | 1, 952);
                    return;
                case 952:
                    bl(this::__aeabi_f2iz, __kernel_rem_pio2f + 956 | 1, 956);
                    return;
                case 956:
                    r6 = lsls(r7, 2);
                    r3 = add(sp, 56);
                    str(r6 + r3, r0);
                    r3 = ldr(sp + 4);
                    r0 = adds(r5, 0);
                    r3 = adds(r3, 8);
                    str(sp + 4, r3);
                    bl(this::__aeabi_f2iz, __kernel_rem_pio2f + 974 | 1, 974);
                    return;
                case 974:
                    r7 = adds(r7, 1);
                    r4 = lsls(r7, 2);
                    r3 = add(sp, 56);
                    str(r4 + r3, r0);
                    step();
                    offset = 580;
                    continue;
                case 984:
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_f2iz, __kernel_rem_pio2f + 990 | 1, 990);
                    return;
                case 990:
                    r5 = lsls(r7, 2);
                    r3 = add(sp, 56);
                    str(r5 + r3, r0);
                    step();
                    offset = 580;
                    continue;
                case 998:
                    r3 = add(sp, 56);
                    r0 = ldr(r5 + r3);
                    bl(this::__aeabi_i2f, __kernel_rem_pio2f + 1006 | 1, 1006);
                    return;
                case 1006:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __kernel_rem_pio2f + 1012 | 1, 1012);
                    return;
                case 1012:
                    r2 = movs(r2, 240);
                    r1 = movs(r1, 238);
                    r3 = add(sp, 56);
                    r3 = adds(r3, r2);
                    str(r3 + r5, r0);
                    r1 = lsls(r1, 22);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __kernel_rem_pio2f + 1030 | 1, 1030);
                    return;
                case 1030:
                    r6 = subs(r6, 1);
                    r4 = adds(r0, 0);
                    r5 = subs(r5, 4);
                    step();
                    offset = 600;
                    continue;
                case 1038:
                    r2 = ldr(__kernel_rem_pio2f + 1424); // rodata.PIo2;
                    r3 = lsls(r6, 2);
                    r1 = ldr(r4 + r3);
                    r0 = ldr(r3 + r2);
                    bl(this::__aeabi_fmul, __kernel_rem_pio2f + 1050 | 1, 1050);
                    return;
                case 1050:
                    r1 = adds(r0, 0);
                    r0 = ldr(sp + 16);
                    bl(this::__aeabi_fadd, __kernel_rem_pio2f + 1058 | 1, 1058);
                    return;
                case 1058:
                    r6 = adds(r6, 1);
                    str(sp + 16, r0);
                case 1062:
                    r3 = ldr(sp + 24);
                    cmp(r6, r3);
                    if (bgt()) {
                        offset = 1072;
                        continue;
                    }
                case 1068:
                    cmp(r5, r6);
                    if (bge()) {
                        offset = 1038;
                        continue;
                    }
                case 1072:
                    r1 = movs(r1, 160);
                    r2 = add(sp, 56);
                    r2 = adds(r2, r1);
                    r1 = ldr(sp + 16);
                    r3 = lsls(r5, 2);
                    str(r2 + r3, r1);
                    r5 = adds(r5, 1);
                    r4 = subs(r4, 4);
                    step();
                    offset = 614;
                    continue;
                case 1090:
                    r3 = movs(r3, 0);
                    r6 = movs(r6, 0);
                    str(sp + 16, r3);
                    step();
                    offset = 1062;
                    continue;
                case 1098:
                    r3 = ldr(sp + 400);
                    cmp(r3, 3);
                    if (beq()) {
                        offset = 1106;
                        continue;
                    }
                case 1104:
                    step();
                    offset = 638;
                    continue;
                case 1106:
                    r6 = ldr(sp + 4);
                    r5 = movs(r5, r7);
                    step();
                    offset = 1292;
                    continue;
                case 1112:
                    r3 = lsls(r7, 2);
                    r1 = ldr(r3 + r4);
                    bl(this::__aeabi_fadd, __kernel_rem_pio2f + 1120 | 1, 1120);
                    return;
                case 1120:
                    r7 = subs(r7, 1);
                case 1122:
                    cmp(r7, 0);
                    if (bge()) {
                        offset = 1112;
                        continue;
                    }
                case 1126:
                    r3 = ldr(sp + 8);
                    cmp(r3, 0);
                    if (beq()) {
                        offset = 1138;
                        continue;
                    }
                case 1132:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 24);
                    r0 = adds(r0, r3);
                case 1138:
                    r3 = ldr(sp + 12);
                    str(r3, r0);
                    step();
                    offset = 638;
                    continue;
                case 1144:
                    r0 = movs(r0, 0);
                    r4 = add(sp, 216);
                    step();
                    offset = 1122;
                    continue;
                case 1150:
                    r3 = lsls(r4, 2);
                    r1 = ldr(r3 + r5);
                    bl(this::__aeabi_fadd, __kernel_rem_pio2f + 1158 | 1, 1158);
                    return;
                case 1158:
                    r4 = subs(r4, 1);
                case 1160:
                    cmp(r4, 0);
                    if (bge()) {
                        offset = 1150;
                        continue;
                    }
                case 1164:
                    r2 = ldr(sp + 8);
                    r3 = adds(r0, 0);
                    cmp(r2, 0);
                    if (beq()) {
                        offset = 1178;
                        continue;
                    }
                case 1172:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 24);
                    r3 = adds(r0, r3);
                case 1178:
                    r2 = ldr(sp + 12);
                    r1 = adds(r0, 0);
                    str(r2, r3);
                    r0 = ldr(sp + 216);
                    bl(this::__aeabi_fsub, __kernel_rem_pio2f + 1190 | 1, 1190);
                    return;
                case 1190:
                    r4 = movs(r4, 1);
                    r5 = add(sp, 216);
                case 1194:
                    cmp(r7, r4);
                    if (bge()) {
                        offset = 1224;
                        continue;
                    }
                case 1198:
                    r3 = ldr(sp + 8);
                    cmp(r3, 0);
                    if (beq()) {
                        offset = 1210;
                        continue;
                    }
                case 1204:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 24);
                    r0 = adds(r0, r3);
                case 1210:
                    r3 = ldr(sp + 12);
                    str(r3 + 4, r0);
                    step();
                    offset = 638;
                    continue;
                case 1216:
                    r4 = movs(r4, r7);
                    r0 = movs(r0, 0);
                    r5 = add(sp, 216);
                    step();
                    offset = 1160;
                    continue;
                case 1224:
                    r3 = lsls(r4, 2);
                    r1 = ldr(r3 + r5);
                    bl(this::__aeabi_fadd, __kernel_rem_pio2f + 1232 | 1, 1232);
                    return;
                case 1232:
                    r4 = adds(r4, 1);
                    step();
                    offset = 1194;
                    continue;
                case 1236:
                    r3 = movs(r3, 160);
                    r2 = add(sp, 56);
                    r2 = adds(r2, r3);
                    r2 = ldr(r2 + r6);
                    r5 = subs(r5, 1);
                    str(sp + 16, r2);
                    r2 = add(sp, 216);
                    r4 = adds(r2, r6);
                    r2 = ldr(r4 + 4);
                    r0 = ldr(sp + 16);
                    r1 = adds(r2, 0);
                    str(sp + 24, r2);
                    bl(this::__aeabi_fadd, __kernel_rem_pio2f + 1264 | 1, 1264);
                    return;
                case 1264:
                    r1 = adds(r0, 0);
                    str(sp + 28, r0);
                    r0 = ldr(sp + 16);
                    bl(this::__aeabi_fsub, __kernel_rem_pio2f + 1274 | 1, 1274);
                    return;
                case 1274:
                    r1 = ldr(sp + 24);
                    bl(this::__aeabi_fadd, __kernel_rem_pio2f + 1280 | 1, 1280);
                    return;
                case 1280:
                    r3 = movs(r3, 160);
                    r2 = add(sp, 56);
                    r3 = adds(r2, r3);
                    r2 = ldr(sp + 28);
                    str(r4 + 4, r0);
                    str(r3 + r6, r2);
                case 1292:
                    r6 = subs(r6, 4);
                    cmp(r5, 0);
                    if (bgt()) {
                        offset = 1236;
                        continue;
                    }
                case 1298:
                    r5 = movs(r5, r7);
                    r4 = add(sp, 216);
                case 1302:
                    r3 = ldr(sp + 4);
                    r3 = subs(r3, 4);
                    str(sp + 4, r3);
                    cmp(r5, 1);
                    if (bgt()) {
                        offset = 1340;
                        continue;
                    }
                case 1312:
                    r0 = movs(r0, 0);
                case 1314:
                    cmp(r7, 1);
                    if (bgt()) {
                        offset = 1390;
                        continue;
                    }
                case 1318:
                    r1 = ldr(sp + 8);
                    r2 = ldr(sp + 216);
                    r3 = ldr(r4 + 4);
                    cmp(r1, 0);
                    if (bne()) {
                        offset = 1402;
                        continue;
                    }
                case 1328:
                    r1 = ldr(sp + 12);
                    str(r1 + 4, r3);
                    r3 = movs(r3, r1);
                    str(r1, r2);
                case 1336:
                    str(r3 + 8, r0);
                    step();
                    offset = 638;
                    continue;
                case 1340:
                    r3 = ldr(sp + 4);
                    r5 = subs(r5, 1);
                    r3 = ldr(r4 + r3);
                    str(sp + 16, r3);
                    r3 = ldr(sp + 4);
                    r0 = ldr(sp + 16);
                    r6 = adds(r4, r3);
                    r3 = ldr(r6 + 4);
                    r1 = adds(r3, 0);
                    str(sp + 24, r3);
                    bl(this::__aeabi_fadd, __kernel_rem_pio2f + 1364 | 1, 1364);
                    return;
                case 1364:
                    r1 = adds(r0, 0);
                    str(sp + 28, r0);
                    r0 = ldr(sp + 16);
                    bl(this::__aeabi_fsub, __kernel_rem_pio2f + 1374 | 1, 1374);
                    return;
                case 1374:
                    r1 = ldr(sp + 24);
                    bl(this::__aeabi_fadd, __kernel_rem_pio2f + 1380 | 1, 1380);
                    return;
                case 1380:
                    r3 = ldr(sp + 4);
                    r2 = ldr(sp + 28);
                    str(r6 + 4, r0);
                    str(r4 + r3, r2);
                    step();
                    offset = 1302;
                    continue;
                case 1390:
                    r3 = lsls(r7, 2);
                    r1 = ldr(r4 + r3);
                    bl(this::__aeabi_fadd, __kernel_rem_pio2f + 1398 | 1, 1398);
                    return;
                case 1398:
                    r7 = subs(r7, 1);
                    step();
                    offset = 1314;
                    continue;
                case 1402:
                    r1 = movs(r1, 128);
                    r4 = ldr(sp + 12);
                    r1 = lsls(r1, 24);
                    r2 = adds(r2, r1);
                    str(r4, r2);
                    r2 = movs(r2, r1);
                    r3 = adds(r3, r1);
                    str(r4 + 4, r3);
                    r0 = adds(r0, r2);
                    r3 = movs(r3, r4);
                    step();
                    offset = 1336;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134336928, size=236, name='__kernel_sinf', path='build/lib/libm/kf_sin.o', has_indirect=False)
    protected void __kernel_sinf(int offset) throws Exception
    {
        while (true)
        {
            pc = __kernel_sinf + offset;
            switch (offset)
            {
                case 0:
                    push(true, r0, r1, r2, r4, r5, r6, r7);
                    str(sp + 4, r2);
                    r2 = ldr(__kernel_sinf + 208);
                    r3 = lsls(r0, 1);
                    r4 = adds(r0, 0);
                    str(sp, r1);
                    r3 = lsrs(r3, 1);
                    cmp(r3, r2);
                    if (bgt()) {
                        offset = 26;
                        continue;
                    }
                case 18:
                    bl(this::__aeabi_f2iz, __kernel_sinf + 22 | 1, 22);
                    return;
                case 22:
                    cmp(r0, 0);
                    if (beq()) {
                        offset = 134;
                        continue;
                    }
                case 26:
                    r1 = adds(r4, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __kernel_sinf + 34 | 1, 34);
                    return;
                case 34:
                    r5 = adds(r0, 0);
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __kernel_sinf + 44 | 1, 44);
                    return;
                case 44:
                    r1 = ldr(__kernel_sinf + 212);
                    r6 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __kernel_sinf + 54 | 1, 54);
                    return;
                case 54:
                    r1 = ldr(__kernel_sinf + 216);
                    bl(this::__aeabi_fsub, __kernel_sinf + 60 | 1, 60);
                    return;
                case 60:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __kernel_sinf + 66 | 1, 66);
                    return;
                case 66:
                    r1 = ldr(__kernel_sinf + 220);
                    bl(this::__aeabi_fadd, __kernel_sinf + 72 | 1, 72);
                    return;
                case 72:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __kernel_sinf + 78 | 1, 78);
                    return;
                case 78:
                    r1 = ldr(__kernel_sinf + 224);
                    bl(this::__aeabi_fsub, __kernel_sinf + 84 | 1, 84);
                    return;
                case 84:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __kernel_sinf + 90 | 1, 90);
                    return;
                case 90:
                    r1 = ldr(__kernel_sinf + 228);
                    bl(this::__aeabi_fadd, __kernel_sinf + 96 | 1, 96);
                    return;
                case 96:
                    r3 = ldr(sp + 4);
                    r7 = adds(r0, 0);
                    cmp(r3, 0);
                    if (bne()) {
                        offset = 138;
                        continue;
                    }
                case 104:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __kernel_sinf + 112 | 1, 112);
                    return;
                case 112:
                    r1 = ldr(__kernel_sinf + 232);
                    bl(this::__aeabi_fsub, __kernel_sinf + 118 | 1, 118);
                    return;
                case 118:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, __kernel_sinf + 124 | 1, 124);
                    return;
                case 124:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fadd, __kernel_sinf + 132 | 1, 132);
                    return;
                case 132:
                    r4 = adds(r0, 0);
                case 134:
                    r0 = adds(r4, 0);
                    pop(true, R1, R2, R3, R4, R5, R6, R7);
                    return;
                case 138:
                    r1 = movs(r1, 252);
                    r0 = ldr(sp);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fmul, __kernel_sinf + 148 | 1, 148);
                    return;
                case 148:
                    r1 = adds(r7, 0);
                    str(sp + 4, r0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fmul, __kernel_sinf + 158 | 1, 158);
                    return;
                case 158:
                    r1 = adds(r0, 0);
                    r0 = ldr(sp + 4);
                    bl(this::__aeabi_fsub, __kernel_sinf + 166 | 1, 166);
                    return;
                case 166:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __kernel_sinf + 172 | 1, 172);
                    return;
                case 172:
                    r1 = ldr(sp);
                    bl(this::__aeabi_fsub, __kernel_sinf + 178 | 1, 178);
                    return;
                case 178:
                    r1 = ldr(__kernel_sinf + 232);
                    r5 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fmul, __kernel_sinf + 188 | 1, 188);
                    return;
                case 188:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fadd, __kernel_sinf + 196 | 1, 196);
                    return;
                case 196:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, __kernel_sinf + 204 | 1, 204);
                    return;
                case 204:
                    step();
                    offset = 132;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134337164, size=604, name='__kernel_tanf', path='build/lib/libm/kf_tan.o', has_indirect=False)
    protected void __kernel_tanf(int offset) throws Exception
    {
        while (true)
        {
            pc = __kernel_tanf + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6, r7);
                    r5 = adds(r1, 0);
                    r1 = lsls(r0, 1);
                    sp = sub(sp, 28);
                    r3 = lsrs(r1, 1);
                    str(sp + 4, r3);
                    str(sp + 8, r2);
                    r3 = ldr(__kernel_tanf + 532);
                    r2 = ldr(sp + 4);
                    r7 = adds(r0, 0);
                    str(sp + 16, r0);
                    cmp(r2, r3);
                    if (bgt()) {
                        offset = 74;
                        continue;
                    }
                case 26:
                    bl(this::__aeabi_f2iz, __kernel_tanf + 30 | 1, 30);
                    return;
                case 30:
                    cmp(r0, 0);
                    if (bne()) {
                        offset = 122;
                        continue;
                    }
                case 34:
                    r3 = ldr(sp + 8);
                    r2 = ldr(sp + 4);
                    r3 = adds(r3, 1);
                    r3 = orrs(r3, r2);
                    if (bne()) {
                        offset = 62;
                        continue;
                    }
                case 44:
                    r0 = movs(r0, 254);
                    r1 = movs(r1, r2);
                    r0 = lsls(r0, 22);
                case 50:
                    bl(this::__aeabi_fdiv, __kernel_tanf + 54 | 1, 54);
                    return;
                case 54:
                    r7 = adds(r0, 0);
                case 56:
                    r0 = adds(r7, 0);
                    sp = add(sp, 28);
                    pop(true, R4, R5, R6, R7);
                    return;
                case 62:
                    r3 = ldr(sp + 8);
                    cmp(r3, 1);
                    if (beq()) {
                        offset = 56;
                        continue;
                    }
                case 68:
                    r1 = adds(r7, 0);
                    r0 = ldr(__kernel_tanf + 536);
                    step();
                    offset = 50;
                    continue;
                case 74:
                    r3 = ldr(__kernel_tanf + 540);
                    r2 = ldr(sp + 4);
                    cmp(r2, r3);
                    if (ble()) {
                        offset = 122;
                        continue;
                    }
                case 82:
                    cmp(r0, 0);
                    if (bge()) {
                        offset = 94;
                        continue;
                    }
                case 86:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 24);
                    r7 = adds(r0, r3);
                    r5 = adds(r5, r3);
                case 94:
                    r1 = adds(r7, 0);
                    r0 = ldr(__kernel_tanf + 544);
                    bl(this::__aeabi_fsub, __kernel_tanf + 102 | 1, 102);
                    return;
                case 102:
                    r1 = adds(r5, 0);
                    r4 = adds(r0, 0);
                    r0 = ldr(__kernel_tanf + 548);
                    bl(this::__aeabi_fsub, __kernel_tanf + 112 | 1, 112);
                    return;
                case 112:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fadd, __kernel_tanf + 118 | 1, 118);
                    return;
                case 118:
                    r5 = movs(r5, 0);
                    r7 = adds(r0, 0);
                case 122:
                    r1 = adds(r7, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fmul, __kernel_tanf + 130 | 1, 130);
                    return;
                case 130:
                    r1 = adds(r0, 0);
                    r6 = adds(r0, 0);
                    bl(this::__aeabi_fmul, __kernel_tanf + 138 | 1, 138);
                    return;
                case 138:
                    r1 = adds(r6, 0);
                    r4 = adds(r0, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fmul, __kernel_tanf + 148 | 1, 148);
                    return;
                case 148:
                    r1 = ldr(__kernel_tanf + 552);
                    str(sp + 12, r0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __kernel_tanf + 158 | 1, 158);
                    return;
                case 158:
                    r1 = ldr(__kernel_tanf + 556);
                    bl(this::__aeabi_fadd, __kernel_tanf + 164 | 1, 164);
                    return;
                case 164:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __kernel_tanf + 170 | 1, 170);
                    return;
                case 170:
                    r1 = ldr(__kernel_tanf + 560);
                    bl(this::__aeabi_fadd, __kernel_tanf + 176 | 1, 176);
                    return;
                case 176:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __kernel_tanf + 182 | 1, 182);
                    return;
                case 182:
                    r1 = ldr(__kernel_tanf + 564);
                    bl(this::__aeabi_fadd, __kernel_tanf + 188 | 1, 188);
                    return;
                case 188:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __kernel_tanf + 194 | 1, 194);
                    return;
                case 194:
                    r1 = ldr(__kernel_tanf + 568);
                    bl(this::__aeabi_fadd, __kernel_tanf + 200 | 1, 200);
                    return;
                case 200:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __kernel_tanf + 206 | 1, 206);
                    return;
                case 206:
                    r1 = ldr(__kernel_tanf + 572);
                    bl(this::__aeabi_fadd, __kernel_tanf + 212 | 1, 212);
                    return;
                case 212:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, __kernel_tanf + 218 | 1, 218);
                    return;
                case 218:
                    r1 = ldr(__kernel_tanf + 576);
                    str(sp + 20, r0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __kernel_tanf + 228 | 1, 228);
                    return;
                case 228:
                    r1 = ldr(__kernel_tanf + 580);
                    bl(this::__aeabi_fadd, __kernel_tanf + 234 | 1, 234);
                    return;
                case 234:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __kernel_tanf + 240 | 1, 240);
                    return;
                case 240:
                    r1 = ldr(__kernel_tanf + 584);
                    bl(this::__aeabi_fadd, __kernel_tanf + 246 | 1, 246);
                    return;
                case 246:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __kernel_tanf + 252 | 1, 252);
                    return;
                case 252:
                    r1 = ldr(__kernel_tanf + 588);
                    bl(this::__aeabi_fadd, __kernel_tanf + 258 | 1, 258);
                    return;
                case 258:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __kernel_tanf + 264 | 1, 264);
                    return;
                case 264:
                    r1 = ldr(__kernel_tanf + 592);
                    bl(this::__aeabi_fadd, __kernel_tanf + 270 | 1, 270);
                    return;
                case 270:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __kernel_tanf + 276 | 1, 276);
                    return;
                case 276:
                    r1 = ldr(__kernel_tanf + 596);
                    bl(this::__aeabi_fadd, __kernel_tanf + 282 | 1, 282);
                    return;
                case 282:
                    r1 = adds(r0, 0);
                    r0 = ldr(sp + 20);
                    bl(this::__aeabi_fadd, __kernel_tanf + 290 | 1, 290);
                    return;
                case 290:
                    r1 = ldr(sp + 12);
                    bl(this::__aeabi_fmul, __kernel_tanf + 296 | 1, 296);
                    return;
                case 296:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fadd, __kernel_tanf + 302 | 1, 302);
                    return;
                case 302:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, __kernel_tanf + 308 | 1, 308);
                    return;
                case 308:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fadd, __kernel_tanf + 314 | 1, 314);
                    return;
                case 314:
                    r1 = ldr(__kernel_tanf + 600);
                    r4 = adds(r0, 0);
                    r0 = ldr(sp + 12);
                    bl(this::__aeabi_fmul, __kernel_tanf + 324 | 1, 324);
                    return;
                case 324:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fadd, __kernel_tanf + 330 | 1, 330);
                    return;
                case 330:
                    r1 = adds(r0, 0);
                    r6 = adds(r0, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fadd, __kernel_tanf + 340 | 1, 340);
                    return;
                case 340:
                    r3 = ldr(__kernel_tanf + 540);
                    r2 = ldr(sp + 4);
                    r4 = adds(r0, 0);
                    cmp(r2, r3);
                    if (ble()) {
                        offset = 440;
                        continue;
                    }
                case 350:
                    r0 = ldr(sp + 8);
                    bl(this::__aeabi_i2f, __kernel_tanf + 356 | 1, 356);
                    return;
                case 356:
                    r1 = adds(r4, 0);
                    r5 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __kernel_tanf + 366 | 1, 366);
                    return;
                case 366:
                    r1 = adds(r5, 0);
                    str(sp + 4, r0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fadd, __kernel_tanf + 376 | 1, 376);
                    return;
                case 376:
                    r1 = adds(r0, 0);
                    r0 = ldr(sp + 4);
                    bl(this::__aeabi_fdiv, __kernel_tanf + 384 | 1, 384);
                    return;
                case 384:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fsub, __kernel_tanf + 390 | 1, 390);
                    return;
                case 390:
                    r1 = adds(r0, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fsub, __kernel_tanf + 398 | 1, 398);
                    return;
                case 398:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fadd, __kernel_tanf + 404 | 1, 404);
                    return;
                case 404:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fsub, __kernel_tanf + 412 | 1, 412);
                    return;
                case 412:
                    r3 = ldr(sp + 16);
                    r4 = adds(r0, 0);
                    r0 = asrs(r3, 30);
                    r3 = movs(r3, 2);
                    r0 = ands(r0, r3);
                    r3 = subs(r3, 1);
                    r0 = subs(r3, r0);
                    bl(this::__aeabi_i2f, __kernel_tanf + 430 | 1, 430);
                    return;
                case 430:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __kernel_tanf + 438 | 1, 438);
                    return;
                case 438:
                    step();
                    offset = 54;
                    continue;
                case 440:
                    r3 = ldr(sp + 8);
                    cmp(r3, 1);
                    if (beq()) {
                        offset = 528;
                        continue;
                    }
                case 446:
                    r1 = adds(r0, 0);
                    r5 = lsrs(r0, 12);
                    r0 = ldr(__kernel_tanf + 536);
                    bl(this::__aeabi_fdiv, __kernel_tanf + 456 | 1, 456);
                    return;
                case 456:
                    str(sp + 4, r0);
                    r3 = ldr(sp + 4);
                    r5 = lsls(r5, 12);
                    r1 = adds(r7, 0);
                    r0 = adds(r5, 0);
                    r4 = lsrs(r3, 12);
                    bl(this::__aeabi_fsub, __kernel_tanf + 472 | 1, 472);
                    return;
                case 472:
                    r4 = lsls(r4, 12);
                    r1 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fsub, __kernel_tanf + 482 | 1, 482);
                    return;
                case 482:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, __kernel_tanf + 488 | 1, 488);
                    return;
                case 488:
                    r1 = adds(r4, 0);
                    r6 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fmul, __kernel_tanf + 498 | 1, 498);
                    return;
                case 498:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fadd, __kernel_tanf + 506 | 1, 506);
                    return;
                case 506:
                    r1 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fadd, __kernel_tanf + 514 | 1, 514);
                    return;
                case 514:
                    r1 = ldr(sp + 4);
                    bl(this::__aeabi_fmul, __kernel_tanf + 520 | 1, 520);
                    return;
                case 520:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fadd, __kernel_tanf + 526 | 1, 526);
                    return;
                case 526:
                    step();
                    offset = 54;
                    continue;
                case 528:
                    r7 = adds(r0, 0);
                    step();
                    offset = 56;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134337768, size=448, name='log1pf', path='build/lib/libm/log1pf.o', has_indirect=False)
    protected void log1pf(int offset) throws Exception
    {
        while (true)
        {
            pc = log1pf + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6, r7);
                    r2 = ldr(log1pf + 388);
                    sp = sub(sp, 28);
                    r1 = adds(r0, r2);
                    r2 = ldr(log1pf + 392);
                    r4 = adds(r0, 0);
                    cmp(r1, r2);
                    if (bhi()) {
                        offset = 18;
                        continue;
                    }
                case 16:
                    step();
                    offset = 348;
                    continue;
                case 18:
                    r2 = ldr(log1pf + 396);
                    cmp(r0, r2);
                    if (bls()) {
                        offset = 58;
                        continue;
                    }
                case 24:
                    r1 = ldr(log1pf + 400);
                    bl(this::__aeabi_fcmpeq, log1pf + 30 | 1, 30);
                    return;
                case 30:
                    cmp(r0, 0);
                    if (beq()) {
                        offset = 46;
                        continue;
                    }
                case 34:
                    r1 = movs(r1, 0);
                    r0 = ldr(log1pf + 400);
                case 38:
                    bl(this::__aeabi_fdiv, log1pf + 42 | 1, 42);
                    return;
                case 42:
                    r4 = adds(r0, 0);
                    step();
                    offset = 84;
                    continue;
                case 46:
                    r1 = adds(r4, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fsub, log1pf + 54 | 1, 54);
                    return;
                case 54:
                    r1 = movs(r1, 0);
                    step();
                    offset = 38;
                    continue;
                case 58:
                    r1 = ldr(log1pf + 404);
                    r2 = lsls(r0, 1);
                    cmp(r2, r1);
                    if (bhi()) {
                        offset = 90;
                        continue;
                    }
                case 66:
                    r2 = movs(r2, 255);
                    r2 = lsls(r2, 23);
                    tst(r0, r2);
                    if (bne()) {
                        offset = 84;
                        continue;
                    }
                case 74:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fmul, log1pf + 80 | 1, 80);
                    return;
                case 80:
                    str(sp + 20, r0);
                    r3 = ldr(sp + 20);
                case 84:
                    r0 = adds(r4, 0);
                    sp = add(sp, 28);
                    pop(true, R4, R5, R6, R7);
                    return;
                case 90:
                    r2 = ldr(log1pf + 408);
                    cmp(r0, r2);
                    if (bhi()) {
                        offset = 98;
                        continue;
                    }
                case 96:
                    step();
                    offset = 378;
                    continue;
                case 98:
                    r1 = movs(r1, 254);
                    r0 = adds(r4, 0);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fadd, log1pf + 108 | 1, 108);
                    return;
                case 108:
                    r3 = ldr(log1pf + 412);
                    r7 = adds(r0, 0);
                    r6 = adds(r0, r3);
                    r5 = lsrs(r6, 23);
                    r5 = subs(r5, 127);
                    cmp(r5, 24);
                    if (bgt()) {
                        offset = 372;
                        continue;
                    }
                case 122:
                    cmp(r5, 1);
                    if (ble()) {
                        offset = 358;
                        continue;
                    }
                case 126:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fsub, log1pf + 132 | 1, 132);
                    return;
                case 132:
                    r1 = adds(r0, 0);
                    r0 = movs(r0, 254);
                    r0 = lsls(r0, 22);
                case 138:
                    bl(this::__aeabi_fsub, log1pf + 142 | 1, 142);
                    return;
                case 142:
                    r1 = adds(r7, 0);
                    bl(this::__aeabi_fdiv, log1pf + 148 | 1, 148);
                    return;
                case 148:
                    str(sp, r0);
                case 150:
                    r1 = movs(r1, 254);
                    r3 = ldr(log1pf + 416);
                    r0 = lsls(r6, 9);
                    r0 = lsrs(r0, 9);
                    r0 = adds(r0, r3);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fsub, log1pf + 166 | 1, 166);
                    return;
                case 166:
                    r4 = adds(r0, 0);
                case 168:
                    r1 = movs(r1, 128);
                    r0 = adds(r4, 0);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fadd, log1pf + 178 | 1, 178);
                    return;
                case 178:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fdiv, log1pf + 186 | 1, 186);
                    return;
                case 186:
                    r1 = adds(r0, 0);
                    str(sp + 4, r0);
                    bl(this::__aeabi_fmul, log1pf + 194 | 1, 194);
                    return;
                case 194:
                    r1 = adds(r0, 0);
                    r6 = adds(r0, 0);
                    bl(this::__aeabi_fmul, log1pf + 202 | 1, 202);
                    return;
                case 202:
                    r1 = movs(r1, 252);
                    r7 = adds(r0, 0);
                    r1 = lsls(r1, 22);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, log1pf + 214 | 1, 214);
                    return;
                case 214:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, log1pf + 220 | 1, 220);
                    return;
                case 220:
                    str(sp + 8, r0);
                    r0 = movs(r0, r5);
                    bl(this::__aeabi_i2f, log1pf + 228 | 1, 228);
                    return;
                case 228:
                    r1 = ldr(log1pf + 420);
                    str(sp + 12, r0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fmul, log1pf + 238 | 1, 238);
                    return;
                case 238:
                    r1 = ldr(log1pf + 424);
                    bl(this::__aeabi_fadd, log1pf + 244 | 1, 244);
                    return;
                case 244:
                    r1 = adds(r7, 0);
                    bl(this::__aeabi_fmul, log1pf + 250 | 1, 250);
                    return;
                case 250:
                    r1 = ldr(log1pf + 428);
                    r5 = adds(r0, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fmul, log1pf + 260 | 1, 260);
                    return;
                case 260:
                    r1 = ldr(log1pf + 432);
                    bl(this::__aeabi_fadd, log1pf + 266 | 1, 266);
                    return;
                case 266:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, log1pf + 272 | 1, 272);
                    return;
                case 272:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fadd, log1pf + 280 | 1, 280);
                    return;
                case 280:
                    r1 = ldr(sp + 8);
                    bl(this::__aeabi_fadd, log1pf + 286 | 1, 286);
                    return;
                case 286:
                    r1 = ldr(sp + 4);
                    bl(this::__aeabi_fmul, log1pf + 292 | 1, 292);
                    return;
                case 292:
                    r1 = ldr(log1pf + 436);
                    r5 = adds(r0, 0);
                    r0 = ldr(sp + 12);
                    bl(this::__aeabi_fmul, log1pf + 302 | 1, 302);
                    return;
                case 302:
                    r1 = ldr(sp);
                    bl(this::__aeabi_fadd, log1pf + 308 | 1, 308);
                    return;
                case 308:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fadd, log1pf + 316 | 1, 316);
                    return;
                case 316:
                    r1 = ldr(sp + 8);
                    bl(this::__aeabi_fsub, log1pf + 322 | 1, 322);
                    return;
                case 322:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fadd, log1pf + 328 | 1, 328);
                    return;
                case 328:
                    r1 = ldr(log1pf + 440);
                    r4 = adds(r0, 0);
                    r0 = ldr(sp + 12);
                    bl(this::__aeabi_fmul, log1pf + 338 | 1, 338);
                    return;
                case 338:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fadd, log1pf + 346 | 1, 346);
                    return;
                case 346:
                    step();
                    offset = 42;
                    continue;
                case 348:
                    r2 = ldr(log1pf + 444);
                    cmp(r0, r2);
                    if (bhi()) {
                        offset = 356;
                        continue;
                    }
                case 354:
                    step();
                    offset = 98;
                    continue;
                case 356:
                    step();
                    offset = 84;
                    continue;
                case 358:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fsub, log1pf + 366 | 1, 366);
                    return;
                case 366:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    step();
                    offset = 138;
                    continue;
                case 372:
                    r3 = movs(r3, 0);
                    str(sp, r3);
                    step();
                    offset = 150;
                    continue;
                case 378:
                    r3 = movs(r3, 0);
                    r5 = movs(r5, 0);
                    str(sp, r3);
                    step();
                    offset = 168;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134338216, size=74, name='nearbyintf', path='build/lib/libm/nearbyintf.o', has_indirect=False)
    protected void nearbyintf(int offset) throws Exception
    {
        while (true)
        {
            pc = nearbyintf + offset;
            switch (offset)
            {
                case 0:
                    r3 = lsrs(r0, 23);
                    r3 = uxtb(r3);
                    push(true, r4, r5, r6);
                    r4 = adds(r0, 0);
                    cmp(r3, 149);
                    if (bgt()) {
                        offset = 56;
                        continue;
                    }
                case 12:
                    r1 = movs(r1, 150);
                    r5 = lsrs(r0, 31);
                    r1 = lsls(r1, 23);
                    cmp(r5, 0);
                    if (beq()) {
                        offset = 60;
                        continue;
                    }
                case 22:
                    bl(this::__aeabi_fsub, nearbyintf + 26 | 1, 26);
                    return;
                case 26:
                    r1 = movs(r1, 150);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fadd, nearbyintf + 34 | 1, 34);
                    return;
                case 34:
                    r1 = movs(r1, 0);
                    r4 = adds(r0, 0);
                    bl(this::__aeabi_fcmpeq, nearbyintf + 42 | 1, 42);
                    return;
                case 42:
                    cmp(r0, 0);
                    if (beq()) {
                        offset = 56;
                        continue;
                    }
                case 46:
                    r4 = movs(r4, 0);
                    cmp(r5, 0);
                    if (beq()) {
                        offset = 56;
                        continue;
                    }
                case 52:
                    r4 = movs(r4, 128);
                    r4 = lsls(r4, 24);
                case 56:
                    r0 = adds(r4, 0);
                    pop(true, R4, R5, R6);
                    return;
                case 60:
                    bl(this::__aeabi_fadd, nearbyintf + 64 | 1, 64);
                    return;
                case 64:
                    r1 = movs(r1, 150);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fsub, nearbyintf + 72 | 1, 72);
                    return;
                case 72:
                    step();
                    offset = 34;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134338292, size=108, name='cosf', path='build/lib/libm/sf_cos.o', has_indirect=True)
    protected void cosf(int offset) throws Exception
    {
        while (true)
        {
            pc = cosf + offset;
            switch (offset)
            {
                case 0:
                    push(true, r0, r1, r2);
                    r2 = ldr(cosf + 100);
                    r3 = lsls(r0, 1);
                    r3 = lsrs(r3, 1);
                    r1 = movs(r1, 0);
                    cmp(r3, r2);
                    if (ble()) {
                        offset = 54;
                        continue;
                    }
                case 14:
                    r2 = ldr(cosf + 104);
                    cmp(r3, r2);
                    if (ble()) {
                        offset = 28;
                        continue;
                    }
                case 20:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fsub, cosf + 26 | 1, 26);
                    return;
                case 26:
                    pop(true, R1, R2, R3);
                    return;
                case 28:
                    r1 = mov(sp);
                    bl(this::__ieee754_rem_pio2f, cosf + 34 | 1, 34);
                    return;
                case 34:
                    r2 = movs(r2, 3);
                    r2 = ands(r2, r0);
                    cmp(r2, 1);
                    if (beq()) {
                        offset = 60;
                        continue;
                    }
                case 42:
                    cmp(r2, 2);
                    if (beq()) {
                        offset = 76;
                        continue;
                    }
                case 46:
                    cmp(r2, 0);
                    if (bne()) {
                        offset = 86;
                        continue;
                    }
                case 50:
                    r1 = ldr(sp + 4);
                    r0 = ldr(sp);
                case 54:
                    bl(this::__kernel_cosf, cosf + 58 | 1, 58);
                    return;
                case 58:
                    step();
                    offset = 26;
                    continue;
                case 60:
                    r1 = ldr(sp + 4);
                    r0 = ldr(sp);
                    bl(this::__kernel_sinf, cosf + 68 | 1, 68);
                    return;
                case 68:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 24);
                    r0 = adds(r0, r3);
                    step();
                    offset = 26;
                    continue;
                case 76:
                    r1 = ldr(sp + 4);
                    r0 = ldr(sp);
                    bl(this::__kernel_cosf, cosf + 84 | 1, 84);
                    return;
                case 84:
                    step();
                    offset = 68;
                    continue;
                case 86:
                    r2 = movs(r2, 1);
                    r1 = ldr(sp + 4);
                    r0 = ldr(sp);
                    bl(this::__kernel_sinf, cosf + 96 | 1, 96);
                    return;
                case 96:
                    step();
                    offset = 26;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134338400, size=1208, name='erff', path='build/lib/libm/sf_erf.o', has_indirect=True)
    protected void erff(int offset) throws Exception
    {
        while (true)
        {
            pc = erff + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6, r7);
                    r3 = ldr(erff + 788);
                    r6 = lsls(r0, 1);
                    sp = sub(sp, 20);
                    r5 = adds(r0, 0);
                    r7 = movs(r7, r0);
                    r6 = lsrs(r6, 1);
                    cmp(r6, r3);
                    if (ble()) {
                        offset = 52;
                        continue;
                    }
                case 18:
                    r3 = lsrs(r0, 31);
                    r0 = movs(r0, 1);
                    r3 = lsls(r3, 1);
                    r0 = subs(r0, r3);
                    bl(this::__aeabi_i2f, erff + 30 | 1, 30);
                    return;
                case 30:
                    r4 = adds(r0, 0);
                    r0 = movs(r0, 254);
                    r1 = adds(r5, 0);
                    r0 = lsls(r0, 22);
                    bl(this::__aeabi_fdiv, erff + 42 | 1, 42);
                    return;
                case 42:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                case 46:
                    bl(this::__aeabi_fadd, erff + 50 | 1, 50);
                    return;
                case 50:
                    step();
                    offset = 104;
                    continue;
                case 52:
                    r3 = ldr(erff + 792);
                    cmp(r6, r3);
                    if (bgt()) {
                        offset = 252;
                        continue;
                    }
                case 58:
                    r3 = ldr(erff + 796);
                    cmp(r6, r3);
                    if (bgt()) {
                        offset = 118;
                        continue;
                    }
                case 64:
                    r3 = ldr(erff + 800);
                    cmp(r6, r3);
                    if (bgt()) {
                        offset = 108;
                        continue;
                    }
                case 70:
                    r1 = movs(r1, 130);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fmul, erff + 78 | 1, 78);
                    return;
                case 78:
                    r1 = ldr(erff + 804);
                    r4 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 88 | 1, 88);
                    return;
                case 88:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fadd, erff + 96 | 1, 96);
                    return;
                case 96:
                    r1 = movs(r1, 248);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fmul, erff + 104 | 1, 104);
                    return;
                case 104:
                    sp = add(sp, 20);
                    pop(true, R4, R5, R6, R7);
                    return;
                case 108:
                    r1 = ldr(erff + 808);
                case 110:
                    bl(this::__aeabi_fmul, erff + 114 | 1, 114);
                    return;
                case 114:
                    r1 = adds(r5, 0);
                    step();
                    offset = 46;
                    continue;
                case 118:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fmul, erff + 124 | 1, 124);
                    return;
                case 124:
                    r1 = ldr(erff + 812);
                    r4 = adds(r0, 0);
                    bl(this::__aeabi_fmul, erff + 132 | 1, 132);
                    return;
                case 132:
                    r1 = ldr(erff + 816);
                    bl(this::__aeabi_fsub, erff + 138 | 1, 138);
                    return;
                case 138:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, erff + 144 | 1, 144);
                    return;
                case 144:
                    r1 = ldr(erff + 820);
                    bl(this::__aeabi_fsub, erff + 150 | 1, 150);
                    return;
                case 150:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, erff + 156 | 1, 156);
                    return;
                case 156:
                    r1 = ldr(erff + 824);
                    bl(this::__aeabi_fsub, erff + 162 | 1, 162);
                    return;
                case 162:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, erff + 168 | 1, 168);
                    return;
                case 168:
                    r1 = ldr(erff + 808);
                    bl(this::__aeabi_fadd, erff + 174 | 1, 174);
                    return;
                case 174:
                    r1 = ldr(erff + 828);
                    r6 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, erff + 184 | 1, 184);
                    return;
                case 184:
                    r1 = ldr(erff + 832);
                    bl(this::__aeabi_fadd, erff + 190 | 1, 190);
                    return;
                case 190:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, erff + 196 | 1, 196);
                    return;
                case 196:
                    r1 = ldr(erff + 836);
                    bl(this::__aeabi_fadd, erff + 202 | 1, 202);
                    return;
                case 202:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, erff + 208 | 1, 208);
                    return;
                case 208:
                    r1 = ldr(erff + 840);
                    bl(this::__aeabi_fadd, erff + 214 | 1, 214);
                    return;
                case 214:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, erff + 220 | 1, 220);
                    return;
                case 220:
                    r1 = ldr(erff + 844);
                    bl(this::__aeabi_fadd, erff + 226 | 1, 226);
                    return;
                case 226:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, erff + 232 | 1, 232);
                    return;
                case 232:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fadd, erff + 240 | 1, 240);
                    return;
                case 240:
                    r1 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fdiv, erff + 248 | 1, 248);
                    return;
                case 248:
                    r1 = adds(r5, 0);
                    step();
                    offset = 110;
                    continue;
                case 252:
                    r3 = ldr(erff + 848);
                    cmp(r6, r3);
                    if (bgt()) {
                        offset = 446;
                        continue;
                    }
                case 258:
                    r1 = movs(r1, 254);
                    r0 = movs(r0, r6);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fsub, erff + 268 | 1, 268);
                    return;
                case 268:
                    r1 = ldr(erff + 852);
                    r4 = adds(r0, 0);
                    bl(this::__aeabi_fmul, erff + 276 | 1, 276);
                    return;
                case 276:
                    r1 = ldr(erff + 856);
                    bl(this::__aeabi_fadd, erff + 282 | 1, 282);
                    return;
                case 282:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, erff + 288 | 1, 288);
                    return;
                case 288:
                    r1 = ldr(erff + 860);
                    bl(this::__aeabi_fsub, erff + 294 | 1, 294);
                    return;
                case 294:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, erff + 300 | 1, 300);
                    return;
                case 300:
                    r1 = ldr(erff + 864);
                    bl(this::__aeabi_fadd, erff + 306 | 1, 306);
                    return;
                case 306:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, erff + 312 | 1, 312);
                    return;
                case 312:
                    r1 = ldr(erff + 868);
                    bl(this::__aeabi_fsub, erff + 318 | 1, 318);
                    return;
                case 318:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, erff + 324 | 1, 324);
                    return;
                case 324:
                    r1 = ldr(erff + 872);
                    bl(this::__aeabi_fadd, erff + 330 | 1, 330);
                    return;
                case 330:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, erff + 336 | 1, 336);
                    return;
                case 336:
                    r1 = ldr(erff + 876);
                    bl(this::__aeabi_fsub, erff + 342 | 1, 342);
                    return;
                case 342:
                    r1 = ldr(erff + 880);
                    r5 = adds(r0, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fmul, erff + 352 | 1, 352);
                    return;
                case 352:
                    r1 = ldr(erff + 884);
                    bl(this::__aeabi_fadd, erff + 358 | 1, 358);
                    return;
                case 358:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, erff + 364 | 1, 364);
                    return;
                case 364:
                    r1 = ldr(erff + 888);
                    bl(this::__aeabi_fadd, erff + 370 | 1, 370);
                    return;
                case 370:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, erff + 376 | 1, 376);
                    return;
                case 376:
                    r1 = ldr(erff + 892);
                    bl(this::__aeabi_fadd, erff + 382 | 1, 382);
                    return;
                case 382:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, erff + 388 | 1, 388);
                    return;
                case 388:
                    r1 = ldr(erff + 896);
                    bl(this::__aeabi_fadd, erff + 394 | 1, 394);
                    return;
                case 394:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, erff + 400 | 1, 400);
                    return;
                case 400:
                    r1 = ldr(erff + 900);
                    bl(this::__aeabi_fadd, erff + 406 | 1, 406);
                    return;
                case 406:
                    r1 = adds(r4, 0);
                    bl(this::__aeabi_fmul, erff + 412 | 1, 412);
                    return;
                case 412:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fadd, erff + 420 | 1, 420);
                    return;
                case 420:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fdiv, erff + 428 | 1, 428);
                    return;
                case 428:
                    cmp(r7, 0);
                    if (blt()) {
                        offset = 436;
                        continue;
                    }
                case 432:
                    r1 = ldr(erff + 904);
                    step();
                    offset = 46;
                    continue;
                case 436:
                    r1 = adds(r0, 0);
                    r0 = ldr(erff + 908);
                case 440:
                    bl(this::__aeabi_fsub, erff + 444 | 1, 444);
                    return;
                case 444:
                    step();
                    offset = 104;
                    continue;
                case 446:
                    r3 = ldr(erff + 912);
                    cmp(r6, r3);
                    if (ble()) {
                        offset = 464;
                        continue;
                    }
                case 452:
                    cmp(r0, 0);
                    if (bge()) {
                        offset = 458;
                        continue;
                    }
                case 456:
                    step();
                    offset = 1144;
                    continue;
                case 458:
                    r0 = movs(r0, 254);
                    r0 = lsls(r0, 22);
                    step();
                    offset = 104;
                    continue;
                case 464:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fmul, erff + 470 | 1, 470);
                    return;
                case 470:
                    r1 = adds(r0, 0);
                    r0 = movs(r0, 254);
                    r0 = lsls(r0, 22);
                    bl(this::__aeabi_fdiv, erff + 480 | 1, 480);
                    return;
                case 480:
                    r3 = ldr(erff + 916);
                    r4 = movs(r4, r6);
                    r5 = adds(r0, 0);
                    cmp(r6, r3);
                    if (ble()) {
                        offset = 492;
                        continue;
                    }
                case 490:
                    step();
                    offset = 988;
                    continue;
                case 492:
                    r1 = ldr(erff + 920);
                    bl(this::__aeabi_fmul, erff + 498 | 1, 498);
                    return;
                case 498:
                    r1 = ldr(erff + 924);
                    bl(this::__aeabi_fsub, erff + 504 | 1, 504);
                    return;
                case 504:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 510 | 1, 510);
                    return;
                case 510:
                    r1 = ldr(erff + 928);
                    bl(this::__aeabi_fsub, erff + 516 | 1, 516);
                    return;
                case 516:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 522 | 1, 522);
                    return;
                case 522:
                    r1 = ldr(erff + 932);
                    bl(this::__aeabi_fsub, erff + 528 | 1, 528);
                    return;
                case 528:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 534 | 1, 534);
                    return;
                case 534:
                    r1 = ldr(erff + 936);
                    bl(this::__aeabi_fsub, erff + 540 | 1, 540);
                    return;
                case 540:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 546 | 1, 546);
                    return;
                case 546:
                    r1 = ldr(erff + 940);
                    bl(this::__aeabi_fsub, erff + 552 | 1, 552);
                    return;
                case 552:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 558 | 1, 558);
                    return;
                case 558:
                    r1 = ldr(erff + 944);
                    bl(this::__aeabi_fsub, erff + 564 | 1, 564);
                    return;
                case 564:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 570 | 1, 570);
                    return;
                case 570:
                    r1 = ldr(erff + 948);
                    bl(this::__aeabi_fsub, erff + 576 | 1, 576);
                    return;
                case 576:
                    r1 = ldr(erff + 952);
                    r6 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 586 | 1, 586);
                    return;
                case 586:
                    r1 = ldr(erff + 956);
                    bl(this::__aeabi_fadd, erff + 592 | 1, 592);
                    return;
                case 592:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 598 | 1, 598);
                    return;
                case 598:
                    r1 = ldr(erff + 960);
                    bl(this::__aeabi_fadd, erff + 604 | 1, 604);
                    return;
                case 604:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 610 | 1, 610);
                    return;
                case 610:
                    r1 = ldr(erff + 964);
                    bl(this::__aeabi_fadd, erff + 616 | 1, 616);
                    return;
                case 616:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 622 | 1, 622);
                    return;
                case 622:
                    r1 = ldr(erff + 968);
                    bl(this::__aeabi_fadd, erff + 628 | 1, 628);
                    return;
                case 628:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 634 | 1, 634);
                    return;
                case 634:
                    r1 = ldr(erff + 972);
                    bl(this::__aeabi_fadd, erff + 640 | 1, 640);
                    return;
                case 640:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 646 | 1, 646);
                    return;
                case 646:
                    r1 = ldr(erff + 976);
                    bl(this::__aeabi_fadd, erff + 652 | 1, 652);
                    return;
                case 652:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 658 | 1, 658);
                    return;
                case 658:
                    r1 = ldr(erff + 980);
                case 660:
                    bl(this::__aeabi_fadd, erff + 664 | 1, 664);
                    return;
                case 664:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 670 | 1, 670);
                    return;
                case 670:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fadd, erff + 678 | 1, 678);
                    return;
                case 678:
                    r3 = movs(r3, 128);
                    str(sp + 4, r0);
                    r0 = lsrs(r4, 12);
                    r0 = lsls(r0, 12);
                    r3 = lsls(r3, 24);
                    r5 = adds(r0, 0);
                    r1 = adds(r5, 0);
                    r0 = adds(r0, r3);
                    bl(this::__aeabi_fmul, erff + 698 | 1, 698);
                    return;
                case 698:
                    r1 = ldr(erff + 984);
                    bl(this::__aeabi_fsub, erff + 704 | 1, 704);
                    return;
                case 704:
                    bl(this::expf, erff + 708 | 1, 708);
                    return;
                case 708:
                    r1 = adds(r4, 0);
                    str(sp + 8, r0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fsub, erff + 718 | 1, 718);
                    return;
                case 718:
                    r1 = adds(r4, 0);
                    str(sp + 12, r0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fadd, erff + 728 | 1, 728);
                    return;
                case 728:
                    r1 = adds(r0, 0);
                    r0 = ldr(sp + 12);
                    bl(this::__aeabi_fmul, erff + 736 | 1, 736);
                    return;
                case 736:
                    r1 = ldr(sp + 4);
                    r5 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fdiv, erff + 746 | 1, 746);
                    return;
                case 746:
                    r1 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fadd, erff + 754 | 1, 754);
                    return;
                case 754:
                    bl(this::expf, erff + 758 | 1, 758);
                    return;
                case 758:
                    r1 = adds(r0, 0);
                    r0 = ldr(sp + 8);
                    bl(this::__aeabi_fmul, erff + 766 | 1, 766);
                    return;
                case 766:
                    r1 = adds(r4, 0);
                    cmp(r7, 0);
                    if (bge()) {
                        offset = 774;
                        continue;
                    }
                case 772:
                    step();
                    offset = 1134;
                    continue;
                case 774:
                    bl(this::__aeabi_fdiv, erff + 778 | 1, 778);
                    return;
                case 778:
                    r1 = adds(r0, 0);
                    r0 = movs(r0, 254);
                    r0 = lsls(r0, 22);
                    step();
                    offset = 440;
                    continue;
                case 988:
                    r1 = ldr(erff + 1148);
                    bl(this::__aeabi_fmul, erff + 994 | 1, 994);
                    return;
                case 994:
                    r1 = ldr(erff + 1152);
                    bl(this::__aeabi_fsub, erff + 1000 | 1, 1000);
                    return;
                case 1000:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 1006 | 1, 1006);
                    return;
                case 1006:
                    r1 = ldr(erff + 1156);
                    bl(this::__aeabi_fsub, erff + 1012 | 1, 1012);
                    return;
                case 1012:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 1018 | 1, 1018);
                    return;
                case 1018:
                    r1 = ldr(erff + 1160);
                    bl(this::__aeabi_fsub, erff + 1024 | 1, 1024);
                    return;
                case 1024:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 1030 | 1, 1030);
                    return;
                case 1030:
                    r1 = ldr(erff + 1164);
                    bl(this::__aeabi_fsub, erff + 1036 | 1, 1036);
                    return;
                case 1036:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 1042 | 1, 1042);
                    return;
                case 1042:
                    r1 = ldr(erff + 1168);
                    bl(this::__aeabi_fsub, erff + 1048 | 1, 1048);
                    return;
                case 1048:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 1054 | 1, 1054);
                    return;
                case 1054:
                    r1 = ldr(erff + 1172);
                    bl(this::__aeabi_fsub, erff + 1060 | 1, 1060);
                    return;
                case 1060:
                    r1 = ldr(erff + 1176);
                    r6 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 1070 | 1, 1070);
                    return;
                case 1070:
                    r1 = ldr(erff + 1180);
                    bl(this::__aeabi_fadd, erff + 1076 | 1, 1076);
                    return;
                case 1076:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 1082 | 1, 1082);
                    return;
                case 1082:
                    r1 = ldr(erff + 1184);
                    bl(this::__aeabi_fadd, erff + 1088 | 1, 1088);
                    return;
                case 1088:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 1094 | 1, 1094);
                    return;
                case 1094:
                    r1 = ldr(erff + 1188);
                    bl(this::__aeabi_fadd, erff + 1100 | 1, 1100);
                    return;
                case 1100:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 1106 | 1, 1106);
                    return;
                case 1106:
                    r1 = ldr(erff + 1192);
                    bl(this::__aeabi_fadd, erff + 1112 | 1, 1112);
                    return;
                case 1112:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 1118 | 1, 1118);
                    return;
                case 1118:
                    r1 = ldr(erff + 1196);
                    bl(this::__aeabi_fadd, erff + 1124 | 1, 1124);
                    return;
                case 1124:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erff + 1130 | 1, 1130);
                    return;
                case 1130:
                    r1 = ldr(erff + 1200);
                    step();
                    offset = 660;
                    continue;
                case 1134:
                    bl(this::__aeabi_fdiv, erff + 1138 | 1, 1138);
                    return;
                case 1138:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    step();
                    offset = 440;
                    continue;
                case 1144:
                    r0 = ldr(erff + 1204);
                    step();
                    offset = 104;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134339608, size=1212, name='erfcf', path='build/lib/libm/sf_erf.o', has_indirect=True)
    protected void erfcf(int offset) throws Exception
    {
        while (true)
        {
            pc = erfcf + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6, r7);
                    r3 = ldr(erfcf + 772);
                    r7 = lsls(r0, 1);
                    sp = sub(sp, 20);
                    r6 = adds(r0, 0);
                    r4 = movs(r4, r0);
                    r7 = lsrs(r7, 1);
                    cmp(r7, r3);
                    if (ble()) {
                        offset = 50;
                        continue;
                    }
                case 18:
                    r0 = lsrs(r0, 31);
                    r0 = lsls(r0, 1);
                    bl(this::__aeabi_ui2f, erfcf + 26 | 1, 26);
                    return;
                case 26:
                    r4 = adds(r0, 0);
                    r0 = movs(r0, 254);
                    r1 = adds(r6, 0);
                    r0 = lsls(r0, 22);
                    bl(this::__aeabi_fdiv, erfcf + 38 | 1, 38);
                    return;
                case 38:
                    r1 = adds(r0, 0);
                    r0 = adds(r4, 0);
                case 42:
                    bl(this::__aeabi_fadd, erfcf + 46 | 1, 46);
                    return;
                case 46:
                    sp = add(sp, 20);
                    pop(true, R4, R5, R6, R7);
                    return;
                case 50:
                    r3 = ldr(erfcf + 776);
                    cmp(r7, r3);
                    if (bgt()) {
                        offset = 250;
                        continue;
                    }
                case 56:
                    r3 = ldr(erfcf + 780);
                    r1 = adds(r0, 0);
                    cmp(r7, r3);
                    if (bgt()) {
                        offset = 74;
                        continue;
                    }
                case 64:
                    r0 = movs(r0, 254);
                case 66:
                    r0 = lsls(r0, 22);
                case 68:
                    bl(this::__aeabi_fsub, erfcf + 72 | 1, 72);
                    return;
                case 72:
                    step();
                    offset = 46;
                    continue;
                case 74:
                    bl(this::__aeabi_fmul, erfcf + 78 | 1, 78);
                    return;
                case 78:
                    r1 = ldr(erfcf + 784);
                    r5 = adds(r0, 0);
                    bl(this::__aeabi_fmul, erfcf + 86 | 1, 86);
                    return;
                case 86:
                    r1 = ldr(erfcf + 788);
                    bl(this::__aeabi_fsub, erfcf + 92 | 1, 92);
                    return;
                case 92:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erfcf + 98 | 1, 98);
                    return;
                case 98:
                    r1 = ldr(erfcf + 792);
                    bl(this::__aeabi_fsub, erfcf + 104 | 1, 104);
                    return;
                case 104:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erfcf + 110 | 1, 110);
                    return;
                case 110:
                    r1 = ldr(erfcf + 796);
                    bl(this::__aeabi_fsub, erfcf + 116 | 1, 116);
                    return;
                case 116:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erfcf + 122 | 1, 122);
                    return;
                case 122:
                    r1 = ldr(erfcf + 800);
                    bl(this::__aeabi_fadd, erfcf + 128 | 1, 128);
                    return;
                case 128:
                    r1 = ldr(erfcf + 804);
                    r7 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erfcf + 138 | 1, 138);
                    return;
                case 138:
                    r1 = ldr(erfcf + 808);
                    bl(this::__aeabi_fadd, erfcf + 144 | 1, 144);
                    return;
                case 144:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erfcf + 150 | 1, 150);
                    return;
                case 150:
                    r1 = ldr(erfcf + 812);
                    bl(this::__aeabi_fadd, erfcf + 156 | 1, 156);
                    return;
                case 156:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erfcf + 162 | 1, 162);
                    return;
                case 162:
                    r1 = ldr(erfcf + 816);
                    bl(this::__aeabi_fadd, erfcf + 168 | 1, 168);
                    return;
                case 168:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erfcf + 174 | 1, 174);
                    return;
                case 174:
                    r1 = ldr(erfcf + 820);
                    bl(this::__aeabi_fadd, erfcf + 180 | 1, 180);
                    return;
                case 180:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erfcf + 186 | 1, 186);
                    return;
                case 186:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fadd, erfcf + 194 | 1, 194);
                    return;
                case 194:
                    r1 = adds(r0, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fdiv, erfcf + 202 | 1, 202);
                    return;
                case 202:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 208 | 1, 208);
                    return;
                case 208:
                    r3 = ldr(erfcf + 824);
                    r5 = adds(r0, 0);
                    cmp(r6, r3);
                    if (bgt()) {
                        offset = 228;
                        continue;
                    }
                case 216:
                    r1 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fadd, erfcf + 224 | 1, 224);
                    return;
                case 224:
                    r1 = adds(r0, 0);
                    step();
                    offset = 64;
                    continue;
                case 228:
                    r1 = movs(r1, 252);
                    r0 = adds(r6, 0);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fsub, erfcf + 238 | 1, 238);
                    return;
                case 238:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fadd, erfcf + 244 | 1, 244);
                    return;
                case 244:
                    r1 = adds(r0, 0);
                    r0 = movs(r0, 252);
                    step();
                    offset = 66;
                    continue;
                case 250:
                    r3 = ldr(erfcf + 828);
                    cmp(r7, r3);
                    if (bgt()) {
                        offset = 448;
                        continue;
                    }
                case 256:
                    r1 = movs(r1, 254);
                    r0 = movs(r0, r7);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fsub, erfcf + 266 | 1, 266);
                    return;
                case 266:
                    r1 = ldr(erfcf + 832);
                    r5 = adds(r0, 0);
                    bl(this::__aeabi_fmul, erfcf + 274 | 1, 274);
                    return;
                case 274:
                    r1 = ldr(erfcf + 836);
                    bl(this::__aeabi_fadd, erfcf + 280 | 1, 280);
                    return;
                case 280:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erfcf + 286 | 1, 286);
                    return;
                case 286:
                    r1 = ldr(erfcf + 840);
                    bl(this::__aeabi_fsub, erfcf + 292 | 1, 292);
                    return;
                case 292:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erfcf + 298 | 1, 298);
                    return;
                case 298:
                    r1 = ldr(erfcf + 844);
                    bl(this::__aeabi_fadd, erfcf + 304 | 1, 304);
                    return;
                case 304:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erfcf + 310 | 1, 310);
                    return;
                case 310:
                    r1 = ldr(erfcf + 848);
                    bl(this::__aeabi_fsub, erfcf + 316 | 1, 316);
                    return;
                case 316:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erfcf + 322 | 1, 322);
                    return;
                case 322:
                    r1 = ldr(erfcf + 852);
                    bl(this::__aeabi_fadd, erfcf + 328 | 1, 328);
                    return;
                case 328:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erfcf + 334 | 1, 334);
                    return;
                case 334:
                    r1 = ldr(erfcf + 856);
                    bl(this::__aeabi_fsub, erfcf + 340 | 1, 340);
                    return;
                case 340:
                    r1 = ldr(erfcf + 860);
                    r6 = adds(r0, 0);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erfcf + 350 | 1, 350);
                    return;
                case 350:
                    r1 = ldr(erfcf + 864);
                    bl(this::__aeabi_fadd, erfcf + 356 | 1, 356);
                    return;
                case 356:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erfcf + 362 | 1, 362);
                    return;
                case 362:
                    r1 = ldr(erfcf + 868);
                    bl(this::__aeabi_fadd, erfcf + 368 | 1, 368);
                    return;
                case 368:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erfcf + 374 | 1, 374);
                    return;
                case 374:
                    r1 = ldr(erfcf + 872);
                    bl(this::__aeabi_fadd, erfcf + 380 | 1, 380);
                    return;
                case 380:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erfcf + 386 | 1, 386);
                    return;
                case 386:
                    r1 = ldr(erfcf + 876);
                    bl(this::__aeabi_fadd, erfcf + 392 | 1, 392);
                    return;
                case 392:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erfcf + 398 | 1, 398);
                    return;
                case 398:
                    r1 = ldr(erfcf + 880);
                    bl(this::__aeabi_fadd, erfcf + 404 | 1, 404);
                    return;
                case 404:
                    r1 = adds(r5, 0);
                    bl(this::__aeabi_fmul, erfcf + 410 | 1, 410);
                    return;
                case 410:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fadd, erfcf + 418 | 1, 418);
                    return;
                case 418:
                    r1 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fdiv, erfcf + 426 | 1, 426);
                    return;
                case 426:
                    cmp(r4, 0);
                    if (blt()) {
                        offset = 436;
                        continue;
                    }
                case 430:
                    r1 = adds(r0, 0);
                    r0 = ldr(erfcf + 884);
                    step();
                    offset = 68;
                    continue;
                case 436:
                    r1 = ldr(erfcf + 888);
                    bl(this::__aeabi_fadd, erfcf + 442 | 1, 442);
                    return;
                case 442:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    step();
                    offset = 42;
                    continue;
                case 448:
                    r3 = ldr(erfcf + 892);
                    cmp(r7, r3);
                    if (ble()) {
                        offset = 456;
                        continue;
                    }
                case 454:
                    step();
                    offset = 1138;
                    continue;
                case 456:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fmul, erfcf + 462 | 1, 462);
                    return;
                case 462:
                    r1 = adds(r0, 0);
                    r0 = movs(r0, 254);
                    r0 = lsls(r0, 22);
                    bl(this::__aeabi_fdiv, erfcf + 472 | 1, 472);
                    return;
                case 472:
                    r3 = ldr(erfcf + 896);
                    r5 = movs(r5, r7);
                    r6 = adds(r0, 0);
                    cmp(r7, r3);
                    if (ble()) {
                        offset = 484;
                        continue;
                    }
                case 482:
                    step();
                    offset = 968;
                    continue;
                case 484:
                    r1 = ldr(erfcf + 900);
                    bl(this::__aeabi_fmul, erfcf + 490 | 1, 490);
                    return;
                case 490:
                    r1 = ldr(erfcf + 904);
                    bl(this::__aeabi_fsub, erfcf + 496 | 1, 496);
                    return;
                case 496:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 502 | 1, 502);
                    return;
                case 502:
                    r1 = ldr(erfcf + 908);
                    bl(this::__aeabi_fsub, erfcf + 508 | 1, 508);
                    return;
                case 508:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 514 | 1, 514);
                    return;
                case 514:
                    r1 = ldr(erfcf + 912);
                    bl(this::__aeabi_fsub, erfcf + 520 | 1, 520);
                    return;
                case 520:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 526 | 1, 526);
                    return;
                case 526:
                    r1 = ldr(erfcf + 916);
                    bl(this::__aeabi_fsub, erfcf + 532 | 1, 532);
                    return;
                case 532:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 538 | 1, 538);
                    return;
                case 538:
                    r1 = ldr(erfcf + 920);
                    bl(this::__aeabi_fsub, erfcf + 544 | 1, 544);
                    return;
                case 544:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 550 | 1, 550);
                    return;
                case 550:
                    r1 = ldr(erfcf + 924);
                    bl(this::__aeabi_fsub, erfcf + 556 | 1, 556);
                    return;
                case 556:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 562 | 1, 562);
                    return;
                case 562:
                    r1 = ldr(erfcf + 928);
                    bl(this::__aeabi_fsub, erfcf + 568 | 1, 568);
                    return;
                case 568:
                    r1 = ldr(erfcf + 932);
                    r7 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 578 | 1, 578);
                    return;
                case 578:
                    r1 = ldr(erfcf + 936);
                    bl(this::__aeabi_fadd, erfcf + 584 | 1, 584);
                    return;
                case 584:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 590 | 1, 590);
                    return;
                case 590:
                    r1 = ldr(erfcf + 940);
                    bl(this::__aeabi_fadd, erfcf + 596 | 1, 596);
                    return;
                case 596:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 602 | 1, 602);
                    return;
                case 602:
                    r1 = ldr(erfcf + 944);
                    bl(this::__aeabi_fadd, erfcf + 608 | 1, 608);
                    return;
                case 608:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 614 | 1, 614);
                    return;
                case 614:
                    r1 = ldr(erfcf + 948);
                    bl(this::__aeabi_fadd, erfcf + 620 | 1, 620);
                    return;
                case 620:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 626 | 1, 626);
                    return;
                case 626:
                    r1 = ldr(erfcf + 952);
                    bl(this::__aeabi_fadd, erfcf + 632 | 1, 632);
                    return;
                case 632:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 638 | 1, 638);
                    return;
                case 638:
                    r1 = ldr(erfcf + 956);
                    bl(this::__aeabi_fadd, erfcf + 644 | 1, 644);
                    return;
                case 644:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 650 | 1, 650);
                    return;
                case 650:
                    r1 = ldr(erfcf + 960);
                case 652:
                    bl(this::__aeabi_fadd, erfcf + 656 | 1, 656);
                    return;
                case 656:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 662 | 1, 662);
                    return;
                case 662:
                    r1 = movs(r1, 254);
                    r1 = lsls(r1, 22);
                    bl(this::__aeabi_fadd, erfcf + 670 | 1, 670);
                    return;
                case 670:
                    r3 = movs(r3, 128);
                    str(sp + 4, r0);
                    r0 = lsrs(r5, 12);
                    r0 = lsls(r0, 12);
                    r3 = lsls(r3, 24);
                    r6 = adds(r0, 0);
                    r1 = adds(r6, 0);
                    r0 = adds(r0, r3);
                    bl(this::__aeabi_fmul, erfcf + 690 | 1, 690);
                    return;
                case 690:
                    r1 = ldr(erfcf + 964);
                    bl(this::__aeabi_fsub, erfcf + 696 | 1, 696);
                    return;
                case 696:
                    bl(this::expf, erfcf + 700 | 1, 700);
                    return;
                case 700:
                    r1 = adds(r5, 0);
                    str(sp + 8, r0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fsub, erfcf + 710 | 1, 710);
                    return;
                case 710:
                    r1 = adds(r5, 0);
                    str(sp + 12, r0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fadd, erfcf + 720 | 1, 720);
                    return;
                case 720:
                    r1 = adds(r0, 0);
                    r0 = ldr(sp + 12);
                    bl(this::__aeabi_fmul, erfcf + 728 | 1, 728);
                    return;
                case 728:
                    r1 = ldr(sp + 4);
                    r6 = adds(r0, 0);
                    r0 = adds(r7, 0);
                    bl(this::__aeabi_fdiv, erfcf + 738 | 1, 738);
                    return;
                case 738:
                    r1 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fadd, erfcf + 746 | 1, 746);
                    return;
                case 746:
                    bl(this::expf, erfcf + 750 | 1, 750);
                    return;
                case 750:
                    r1 = adds(r0, 0);
                    r0 = ldr(sp + 8);
                    bl(this::__aeabi_fmul, erfcf + 758 | 1, 758);
                    return;
                case 758:
                    r1 = adds(r5, 0);
                    cmp(r4, 0);
                    if (bgt()) {
                        offset = 766;
                        continue;
                    }
                case 764:
                    step();
                    offset = 1126;
                    continue;
                case 766:
                    bl(this::__aeabi_fdiv, erfcf + 770 | 1, 770);
                    return;
                case 770:
                    step();
                    offset = 46;
                    continue;
                case 968:
                    cmp(r4, 0);
                    if (bge()) {
                        offset = 978;
                        continue;
                    }
                case 972:
                    r3 = ldr(erfcf + 1152);
                    cmp(r7, r3);
                    if (bgt()) {
                        offset = 1146;
                        continue;
                    }
                case 978:
                    r1 = ldr(erfcf + 1156);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 986 | 1, 986);
                    return;
                case 986:
                    r1 = ldr(erfcf + 1160);
                    bl(this::__aeabi_fsub, erfcf + 992 | 1, 992);
                    return;
                case 992:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 998 | 1, 998);
                    return;
                case 998:
                    r1 = ldr(erfcf + 1164);
                    bl(this::__aeabi_fsub, erfcf + 1004 | 1, 1004);
                    return;
                case 1004:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 1010 | 1, 1010);
                    return;
                case 1010:
                    r1 = ldr(erfcf + 1168);
                    bl(this::__aeabi_fsub, erfcf + 1016 | 1, 1016);
                    return;
                case 1016:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 1022 | 1, 1022);
                    return;
                case 1022:
                    r1 = ldr(erfcf + 1172);
                    bl(this::__aeabi_fsub, erfcf + 1028 | 1, 1028);
                    return;
                case 1028:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 1034 | 1, 1034);
                    return;
                case 1034:
                    r1 = ldr(erfcf + 1176);
                    bl(this::__aeabi_fsub, erfcf + 1040 | 1, 1040);
                    return;
                case 1040:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 1046 | 1, 1046);
                    return;
                case 1046:
                    r1 = ldr(erfcf + 1180);
                    bl(this::__aeabi_fsub, erfcf + 1052 | 1, 1052);
                    return;
                case 1052:
                    r1 = ldr(erfcf + 1184);
                    r7 = adds(r0, 0);
                    r0 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 1062 | 1, 1062);
                    return;
                case 1062:
                    r1 = ldr(erfcf + 1188);
                    bl(this::__aeabi_fadd, erfcf + 1068 | 1, 1068);
                    return;
                case 1068:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 1074 | 1, 1074);
                    return;
                case 1074:
                    r1 = ldr(erfcf + 1192);
                    bl(this::__aeabi_fadd, erfcf + 1080 | 1, 1080);
                    return;
                case 1080:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 1086 | 1, 1086);
                    return;
                case 1086:
                    r1 = ldr(erfcf + 1196);
                    bl(this::__aeabi_fadd, erfcf + 1092 | 1, 1092);
                    return;
                case 1092:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 1098 | 1, 1098);
                    return;
                case 1098:
                    r1 = ldr(erfcf + 1200);
                    bl(this::__aeabi_fadd, erfcf + 1104 | 1, 1104);
                    return;
                case 1104:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 1110 | 1, 1110);
                    return;
                case 1110:
                    r1 = ldr(erfcf + 1204);
                    bl(this::__aeabi_fadd, erfcf + 1116 | 1, 1116);
                    return;
                case 1116:
                    r1 = adds(r6, 0);
                    bl(this::__aeabi_fmul, erfcf + 1122 | 1, 1122);
                    return;
                case 1122:
                    r1 = ldr(erfcf + 1208);
                    step();
                    offset = 652;
                    continue;
                case 1126:
                    bl(this::__aeabi_fdiv, erfcf + 1130 | 1, 1130);
                    return;
                case 1130:
                    r1 = adds(r0, 0);
                    r0 = movs(r0, 128);
                    r0 = lsls(r0, 23);
                    step();
                    offset = 68;
                    continue;
                case 1138:
                    r0 = movs(r0, 0);
                    cmp(r6, 0);
                    if (ble()) {
                        offset = 1146;
                        continue;
                    }
                case 1144:
                    step();
                    offset = 46;
                    continue;
                case 1146:
                    r0 = movs(r0, 128);
                    r0 = lsls(r0, 23);
                    step();
                    offset = 46;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134340820, size=84, name='frexpf', path='build/lib/libm/sf_frexp.o', has_indirect=False)
    protected void frexpf(int offset) throws Exception
    {
        while (true)
        {
            pc = frexpf + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4);
                    r4 = movs(r4, r1);
                    r1 = movs(r1, 0);
                    str(r4, r1);
                    r1 = ldr(frexpf + 72);
                    r3 = lsls(r0, 1);
                    r2 = movs(r2, r0);
                    r3 = lsrs(r3, 1);
                    cmp(r3, r1);
                    if (bgt()) {
                        offset = 70;
                        continue;
                    }
                case 20:
                    cmp(r3, 0);
                    if (beq()) {
                        offset = 70;
                        continue;
                    }
                case 24:
                    r1 = ldr(frexpf + 76);
                    cmp(r3, r1);
                    if (bgt()) {
                        offset = 50;
                        continue;
                    }
                case 30:
                    r1 = movs(r1, 152);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fmul, frexpf + 38 | 1, 38);
                    return;
                case 38:
                    r1 = movs(r1, 25);
                    r2 = movs(r2, r0);
                    r3 = lsls(r0, 1);
                    r1 = rsbs(r1);
                    r3 = lsrs(r3, 1);
                    str(r4, r1);
                case 50:
                    r0 = ldr(frexpf + 80);
                    r1 = ldr(r4);
                    r2 = ands(r2, r0);
                    r0 = movs(r0, 252);
                    r3 = asrs(r3, 23);
                    r3 = subs(r3, 126);
                    r3 = adds(r1, r3);
                    r0 = lsls(r0, 22);
                    str(r4, r3);
                    r0 = orrs(r0, r2);
                case 70:
                    pop(true, R4);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134340904, size=64, name='ldexpf', path='build/lib/libm/sf_ldexp.o', has_indirect=False)
    protected void ldexpf(int offset) throws Exception
    {
        while (true)
        {
            pc = ldexpf + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6);
                    r5 = lsls(r0, 1);
                    r5 = lsrs(r5, 1);
                    r4 = adds(r0, 0);
                    r6 = movs(r6, r1);
                    r0 = adds(r5, 0);
                    r1 = ldr(ldexpf + 60);
                    bl(this::__aeabi_fcmpun, ldexpf + 18 | 1, 18);
                    return;
                case 18:
                    cmp(r0, 0);
                    if (bne()) {
                        offset = 56;
                        continue;
                    }
                case 22:
                    r1 = ldr(ldexpf + 60);
                    r0 = adds(r5, 0);
                    bl(this::__aeabi_fcmpgt, ldexpf + 30 | 1, 30);
                    return;
                case 30:
                    cmp(r0, 0);
                    if (bne()) {
                        offset = 56;
                        continue;
                    }
                case 34:
                    r1 = movs(r1, 0);
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_fcmpeq, ldexpf + 42 | 1, 42);
                    return;
                case 42:
                    cmp(r0, 0);
                    if (bne()) {
                        offset = 56;
                        continue;
                    }
                case 46:
                    r0 = adds(r4, 0);
                    r1 = movs(r1, r6);
                    bl(this::scalbnf, ldexpf + 54 | 1, 54);
                    return;
                case 54:
                    r4 = adds(r0, 0);
                case 56:
                    r0 = adds(r4, 0);
                    pop(true, R4, R5, R6);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134340968, size=68, name='modff', path='build/lib/libm/sf_modf.o', has_indirect=False)
    protected void modff(int offset) throws Exception
    {
        while (true)
        {
            pc = modff + offset;
            switch (offset)
            {
                case 0:
                    r2 = asrs(r0, 23);
                    r2 = uxtb(r2);
                    r2 = subs(r2, 127);
                    push(true, r4);
                    r3 = movs(r3, r0);
                    cmp(r2, 22);
                    if (bgt()) {
                        offset = 54;
                        continue;
                    }
                case 14:
                    cmp(r2, 0);
                    if (bge()) {
                        offset = 26;
                        continue;
                    }
                case 18:
                    r2 = lsrs(r0, 31);
                    r2 = lsls(r2, 31);
                    str(r1, r2);
                case 24:
                    pop(true, R4);
                    return;
                case 26:
                    r4 = ldr(modff + 64);
                    r4 = asrs(r4, r2);
                    tst(r4, r0);
                    if (bne()) {
                        offset = 42;
                        continue;
                    }
                case 34:
                    r3 = lsrs(r0, 31);
                    str(r1, r0);
                    r0 = lsls(r3, 31);
                    step();
                    offset = 24;
                    continue;
                case 42:
                    r3 = bics(r3, r4);
                    str(r1, r3);
                    r1 = adds(r3, 0);
                    bl(this::__aeabi_fsub, modff + 52 | 1, 52);
                    return;
                case 52:
                    step();
                    offset = 24;
                    continue;
                case 54:
                    str(r1, r0);
                    r0 = lsrs(r0, 31);
                    r0 = lsls(r0, 31);
                    step();
                    offset = 24;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134341036, size=112, name='sinf', path='build/lib/libm/sf_sin.o', has_indirect=True)
    protected void sinf(int offset) throws Exception
    {
        while (true)
        {
            pc = sinf + offset;
            switch (offset)
            {
                case 0:
                    push(true, r0, r1, r2);
                    r2 = ldr(sinf + 104);
                    r3 = lsls(r0, 1);
                    r3 = lsrs(r3, 1);
                    cmp(r3, r2);
                    if (bgt()) {
                        offset = 22;
                        continue;
                    }
                case 12:
                    r2 = movs(r2, 0);
                    r1 = movs(r1, 0);
                case 16:
                    bl(this::__kernel_sinf, sinf + 20 | 1, 20);
                    return;
                case 20:
                    step();
                    offset = 34;
                    continue;
                case 22:
                    r2 = ldr(sinf + 108);
                    cmp(r3, r2);
                    if (ble()) {
                        offset = 36;
                        continue;
                    }
                case 28:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fsub, sinf + 34 | 1, 34);
                    return;
                case 34:
                    pop(true, R1, R2, R3);
                    return;
                case 36:
                    r1 = mov(sp);
                    bl(this::__ieee754_rem_pio2f, sinf + 42 | 1, 42);
                    return;
                case 42:
                    r3 = movs(r3, 3);
                    r0 = ands(r0, r3);
                    cmp(r0, 1);
                    if (beq()) {
                        offset = 66;
                        continue;
                    }
                case 50:
                    cmp(r0, 2);
                    if (beq()) {
                        offset = 76;
                        continue;
                    }
                case 54:
                    cmp(r0, 0);
                    if (bne()) {
                        offset = 94;
                        continue;
                    }
                case 58:
                    r2 = movs(r2, 1);
                    r1 = ldr(sp + 4);
                    r0 = ldr(sp);
                    step();
                    offset = 16;
                    continue;
                case 66:
                    r1 = ldr(sp + 4);
                    r0 = ldr(sp);
                    bl(this::__kernel_cosf, sinf + 74 | 1, 74);
                    return;
                case 74:
                    step();
                    offset = 34;
                    continue;
                case 76:
                    r2 = movs(r2, 1);
                    r1 = ldr(sp + 4);
                    r0 = ldr(sp);
                    bl(this::__kernel_sinf, sinf + 86 | 1, 86);
                    return;
                case 86:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 24);
                    r0 = adds(r0, r3);
                    step();
                    offset = 34;
                    continue;
                case 94:
                    r1 = ldr(sp + 4);
                    r0 = ldr(sp);
                    bl(this::__kernel_cosf, sinf + 102 | 1, 102);
                    return;
                case 102:
                    step();
                    offset = 86;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134341148, size=68, name='tanf', path='build/lib/libm/sf_tan.o', has_indirect=True)
    protected void tanf(int offset) throws Exception
    {
        while (true)
        {
            pc = tanf + offset;
            switch (offset)
            {
                case 0:
                    push(true, r0, r1, r2);
                    r2 = ldr(tanf + 60);
                    r3 = lsls(r0, 1);
                    r3 = lsrs(r3, 1);
                    cmp(r3, r2);
                    if (bgt()) {
                        offset = 22;
                        continue;
                    }
                case 12:
                    r2 = movs(r2, 1);
                    r1 = movs(r1, 0);
                case 16:
                    bl(this::__kernel_tanf, tanf + 20 | 1, 20);
                    return;
                case 20:
                    step();
                    offset = 34;
                    continue;
                case 22:
                    r2 = ldr(tanf + 64);
                    cmp(r3, r2);
                    if (ble()) {
                        offset = 36;
                        continue;
                    }
                case 28:
                    r1 = adds(r0, 0);
                    bl(this::__aeabi_fsub, tanf + 34 | 1, 34);
                    return;
                case 34:
                    pop(true, R1, R2, R3);
                    return;
                case 36:
                    r1 = mov(sp);
                    bl(this::__ieee754_rem_pio2f, tanf + 42 | 1, 42);
                    return;
                case 42:
                    r2 = movs(r2, 2);
                    r0 = lsls(r0, 1);
                    r0 = ands(r0, r2);
                    r2 = subs(r2, 1);
                    r2 = subs(r2, r0);
                    r1 = ldr(sp + 4);
                    r0 = ldr(sp);
                    step();
                    offset = 16;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134341216, size=10, name='lgammaf', path='build/lib/libm/wf_lgamma.o', has_indirect=True)
    protected void lgammaf(int offset) throws Exception
    {
        while (true)
        {
            pc = lgammaf + offset;
            switch (offset)
            {
                case 0:
                    push(true, r0, r1, r2);
                    r1 = add(sp, 4);
                    bl(this::__ieee754_lgammaf_r, lgammaf + 8 | 1, 8);
                    return;
                case 8:
                    pop(true, R1, R2, R3);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134341226, size=26, name='tgammaf', path='build/lib/libm/wf_tgamma.o', has_indirect=True)
    protected void tgammaf(int offset) throws Exception
    {
        while (true)
        {
            pc = tgammaf + offset;
            switch (offset)
            {
                case 0:
                    push(true, r0, r1, r2);
                    r1 = add(sp, 4);
                    bl(this::__ieee754_lgammaf_r, tgammaf + 8 | 1, 8);
                    return;
                case 8:
                    bl(this::expf, tgammaf + 12 | 1, 12);
                    return;
                case 12:
                    r3 = ldr(sp + 4);
                    cmp(r3, 0);
                    if (bge()) {
                        offset = 24;
                        continue;
                    }
                case 18:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 24);
                    r0 = adds(r0, r3);
                case 24:
                    pop(true, R1, R2, R3);
                    return;
                default:
                    crash();
            }
        }
    }

} // MicroPython_lib
