package kr.pe.ecmaxp.micropython.example;

import kr.pe.ecmaxp.thumbsk.CPU;
import kr.pe.ecmaxp.thumbjk.KotlinCPU;
import org.jetbrains.annotations.NotNull;

import static kr.pe.ecmaxp.thumbsk.helper.RegisterIndex.*;
import static kr.pe.ecmaxp.micropython.example.MicroPython_vals.*;

abstract public class MicroPython_lib extends MicroPython_system
{
    public MicroPython_lib(@NotNull CPU cpu)
    {
        super(cpu);
    }

    // function: Function(address=134323156, size=34, name='strn_print_strn', path='build/lib/utils/printf.o', has_indirect=True)
    protected void strn_print_strn(int offset) throws Exception
    {
        pc = strn_print_strn + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r5 = ldr(r0 + 4);
                r4 = movs(r4, r0);
                cmp(r5, r2);
                if (bls(null, 12)) return;
            case 10:
                r5 = movs(r5, r2);
            case 12:
                r2 = movs(r2, r5);
                r0 = ldr(r4);
                lr = strn_print_strn + 20 | 1;
                bl(this::memcpy, 20);
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

    // function: Function(address=134323192, size=28, name='printf', path='build/lib/utils/printf.o', has_indirect=False)
    protected void printf(int offset) throws Exception
    {
        pc = printf + offset;
        switch (offset)
        {
            case 0:
                push(false, r0, r1, r2, r3);
                push(true, r0, r1, r2);
                r2 = add(sp, 16);
                r2 = ldm(r2, R1);
                r0 = mp_plat_print;
                str(sp + 4, r2);
                lr = printf + 16 | 1;
                bl(this::mp_vprintf, 16);
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

    // function: Function(address=134323220, size=20, name='putchar', path='build/lib/utils/printf.o', has_indirect=False)
    protected void putchar(int offset) throws Exception
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
                lr = putchar + 16 | 1;
                bl(this::mp_hal_stdout_tx_strn_cooked, 16);
                return;
            case 16:
                r0 = ldrb(r4);
                pop(true, R1, R2, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134323240, size=34, name='puts', path='build/lib/utils/printf.o', has_indirect=False)
    protected void puts(int offset) throws Exception
    {
        pc = puts + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r4);
                r4 = movs(r4, r0);
                lr = puts + 8 | 1;
                bl(this::strlen, 8);
                return;
            case 8:
                r1 = movs(r1, r0);
                r0 = movs(r0, r4);
                lr = puts + 16 | 1;
                bl(this::mp_hal_stdout_tx_strn_cooked, 16);
                return;
            case 16:
                r3 = mov(sp);
                r0 = adds(r3, 7);
                r3 = movs(r3, 10);
                r1 = movs(r1, 1);
                strb(r0, r3);
                lr = puts + 30 | 1;
                bl(this::mp_hal_stdout_tx_strn_cooked, 30);
                return;
            case 30:
                r0 = movs(r0, 1);
                pop(true, R1, R2, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134323276, size=56, name='vsnprintf', path='build/lib/utils/printf.o', has_indirect=False)
    protected void vsnprintf(int offset) throws Exception
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
                r2 = strn_print_strn | 1;
                hint(strn_print_strn | 1, this::strn_print_strn);
                str(sp, r0);
                str(sp + 12, r2);
                r0 = add(sp, 8);
                r2 = movs(r2, r3);
                str(sp + 4, r4);
                lr = vsnprintf + 26 | 1;
                bl(this::mp_vprintf, 26);
                return;
            case 26:
                cmp(r4, 0);
                if (beq(null, 42)) return;
            case 30:
                r2 = ldr(sp + 4);
                r3 = ldr(sp);
                cmp(r2, 0);
                if (bne(null, 46)) return;
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
                b(null, 40);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134323332, size=22, name='snprintf', path='build/lib/utils/printf.o', has_indirect=False)
    protected void snprintf(int offset) throws Exception
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
                lr = snprintf + 14 | 1;
                bl(this::vsnprintf, 14);
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

    // function: Function(address=134324724, size=8, name='stdio_obj___exit__', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected void stdio_obj___exit__(int offset) throws Exception
    {
        assert offset == 0;
        pc = stdio_obj___exit__ + offset;
        r0 = mp_const_none_obj;
        bx(lr);
    }

    // function: Function(address=134324732, size=16, name='stdio_obj_print', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected void stdio_obj_print(int offset) throws Exception
    {
        pc = stdio_obj_print + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r2 = ldr(r1 + 4);
                r1 = stdio_obj_print_str1_1;
                lr = stdio_obj_print + 10 | 1;
                bl(this::mp_printf, 10);
                return;
            case 10:
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324748, size=16, name='stdio_buffer_write', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected void stdio_buffer_write(int offset) throws Exception
    {
        pc = stdio_buffer_write + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r4 = movs(r4, r2);
                r0 = movs(r0, r1);
                r1 = movs(r1, r2);
                lr = stdio_buffer_write + 12 | 1;
                bl(this::mp_hal_stdout_tx_strn, 12);
                return;
            case 12:
                r0 = movs(r0, r4);
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324764, size=26, name='stdio_buffer_read', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected void stdio_buffer_read(int offset) throws Exception
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
                if (bne(null, 16)) return;
            case 12:
                r0 = movs(r0, r5);
                pop(true, R4, R5, R6);
                return;
            case 16:
                lr = stdio_buffer_read + 20 | 1;
                bl(this::mp_hal_stdin_rx_chr, 20);
                return;
            case 20:
                strb(r4, r0);
                r4 = adds(r4, 1);
                b(null, 8);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324790, size=36, name='stdio_write', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected void stdio_write(int offset) throws Exception
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
                if (bhi(null, 26)) return;
            case 16:
                r1 = movs(r1, r4);
                lr = stdio_write + 22 | 1;
                bl(this::mp_hal_stdout_tx_strn_cooked, 22);
                return;
            case 22:
                r0 = movs(r0, r4);
                pop(true, R4, R5, R6);
                return;
            case 26:
                r2 = movs(r2, 1);
                r4 = movs(r4, 1);
                str(r3, r2);
                r4 = rsbs(r4, 0);
                b(null, 22);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324826, size=50, name='stdio_read', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected void stdio_read(int offset) throws Exception
    {
        pc = stdio_read + offset;
        switch (offset)
        {
            case 0:
                push(true, r3, r4, r5, r6, r7);
                r5 = movs(r5, r2);
                r2 = ldr(r0 + 4);
                cmp(r2, 0);
                if (bne(null, 40)) return;
            case 10:
                r4 = movs(r4, r1);
                r7 = movs(r7, 10);
                r6 = adds(r1, r5);
            case 16:
                cmp(r4, r6);
                if (bne(null, 24)) return;
            case 20:
                r0 = movs(r0, r5);
                pop(true, R3, R4, R5, R6, R7);
                return;
            case 24:
                lr = stdio_read + 28 | 1;
                bl(this::mp_hal_stdin_rx_chr, 28);
                return;
            case 28:
                cmp(r0, 13);
                if (bne(null, 34)) return;
            case 32:
                r0 = movs(r0, r7);
            case 34:
                strb(r4, r0);
                r4 = adds(r4, 1);
                b(null, 16);
                return;
            case 40:
                r2 = movs(r2, 1);
                r5 = movs(r5, 1);
                str(r3, r2);
                r5 = rsbs(r5, 0);
                b(null, 20);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324876, size=44, name='mp_hal_stdout_tx_strn_cooked', path='build/lib/utils/stdout_helpers.o', has_indirect=False)
    protected void mp_hal_stdout_tx_strn_cooked(int offset) throws Exception
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
                if (bne(null, 12)) return;
            case 10:
                pop(true, R4, R5, R6);
                return;
            case 12:
                r3 = ldrb(r4);
                cmp(r3, 10);
                if (bne(null, 26)) return;
            case 18:
                r1 = movs(r1, 1);
                r0 = 0x0802abe4;
                lr = mp_hal_stdout_tx_strn_cooked + 26 | 1;
                bl(this::mp_hal_stdout_tx_strn, 26);
                return;
            case 26:
                r0 = movs(r0, r4);
                r6 = adds(r4, 1);
                r1 = movs(r1, 1);
                lr = mp_hal_stdout_tx_strn_cooked + 36 | 1;
                bl(this::mp_hal_stdout_tx_strn, 36);
                return;
            case 36:
                r4 = movs(r4, r6);
                b(null, 6);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324920, size=18, name='mp_hal_stdout_tx_str', path='build/lib/utils/stdout_helpers.o', has_indirect=False)
    protected void mp_hal_stdout_tx_str(int offset) throws Exception
    {
        pc = mp_hal_stdout_tx_str + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r4 = movs(r4, r0);
                lr = mp_hal_stdout_tx_str + 8 | 1;
                bl(this::strlen, 8);
                return;
            case 8:
                r1 = movs(r1, r0);
                r0 = movs(r0, r4);
                lr = mp_hal_stdout_tx_str + 16 | 1;
                bl(this::mp_hal_stdout_tx_strn, 16);
                return;
            case 16:
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324940, size=28, name='mp_hal_set_interrupt_char', path='build/lib/utils/interrupt_char.o', has_indirect=False)
    protected void mp_hal_set_interrupt_char(int offset) throws Exception
    {
        pc = mp_hal_set_interrupt_char + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r4 = movs(r4, r0);
                r3 = adds(r0, 1);
                if (beq(null, 14)) return;
            case 8:
                r0 = 0x20009db8;
                lr = mp_hal_set_interrupt_char + 14 | 1;
                bl(this::mp_obj_exception_clear_traceback, 14);
                return;
            case 14:
                r3 = mp_interrupt_char;
                str(r3, r4);
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324968, size=308, name='parse_compile_execute', path='build/lib/utils/pyexec.o', has_indirect=False)
    protected void parse_compile_execute(int offset) throws Exception
    {
        pc = parse_compile_execute + offset;
        switch (offset)
        {
            case 0:
                r3 = movs(r3, 0);
                push(true, r4, r5, r6, r7);
                r6 = pyexec_system_exit;
                sp = sub(sp, 92);
                r4 = movs(r4, r0);
                r0 = add(sp, 36);
                str(sp + 12, r1);
                r5 = movs(r5, r2);
                str(r6, r3);
                r7 = movs(r7, 1);
                lr = parse_compile_execute + 24 | 1;
                bl(this::nlr_push, 24);
                return;
            case 24:
                r7 = ands(r7, r5);
                r1 = subs(r0, 0);
                if (bne(null, 226)) return;
            case 30:
                r3 = movs(r3, 8);
                r3 = ands(r3, r5);
                if (beq(null, 170)) return;
            case 36:
                r2 = movs(r2, r0);
                r0 = movs(r0, r4);
                lr = parse_compile_execute + 44 | 1;
                bl(this::mp_make_function_from_raw_code, 44);
                return;
            case 44:
                r6 = movs(r6, r0);
                r0 = movs(r0, 3);
                lr = parse_compile_execute + 52 | 1;
                bl(this::mp_hal_set_interrupt_char, 52);
                return;
            case 52:
                lr = parse_compile_execute + 56 | 1;
                bl(this::mp_hal_ticks_ms, 56);
                return;
            case 56:
                r4 = movs(r4, r0);
                r0 = movs(r0, r6);
                lr = parse_compile_execute + 64 | 1;
                bl(this::mp_call_function_0, 64);
                return;
            case 64:
                r0 = movs(r0, 1);
                r0 = rsbs(r0, 0);
                lr = parse_compile_execute + 72 | 1;
                bl(this::mp_hal_set_interrupt_char, 72);
                return;
            case 72:
                r6 = movs(r6, 1);
                lr = parse_compile_execute + 78 | 1;
                bl(this::nlr_pop, 78);
                return;
            case 78:
                cmp(r7, 0);
                if (beq(null, 92)) return;
            case 82:
                r1 = movs(r1, r6);
                r0 = parse_compile_execute_str1_1;
                lr = parse_compile_execute + 90 | 1;
                bl(this::mp_hal_stdout_tx_strn, 90);
                return;
            case 90:
                r6 = movs(r6, r7);
            case 92:
                r3 = lsls(r5, 30);
                if (bpl(null, 152)) return;
            case 96:
                r3 = repl_display_debugging_info;
                r3 = ldrb(r3);
                cmp(r3, 0);
                if (beq(null, 152)) return;
            case 104:
                lr = parse_compile_execute + 108 | 1;
                bl(this::mp_hal_ticks_ms, 108);
                return;
            case 108:
                r1 = subs(r0, r4);
                r0 = 0x0802b306;
                lr = parse_compile_execute + 116 | 1;
                bl(this::printf, 116);
                return;
            case 116:
                r3 = add(sp, 28);
                r2 = add(sp, 24);
                r1 = add(sp, 20);
                r0 = add(sp, 16);
                lr = parse_compile_execute + 128 | 1;
                bl(this::qstr_pool_info, 128);
                return;
            case 128:
                r3 = ldr(sp + 28);
                r2 = ldr(sp + 20);
                r1 = ldr(sp + 16);
                str(sp, r3);
                r0 = 0x0802b312;
                r3 = ldr(sp + 24);
                lr = parse_compile_execute + 144 | 1;
                bl(this::printf, 144);
                return;
            case 144:
                lr = parse_compile_execute + 148 | 1;
                bl(this::gc_collect, 148);
                return;
            case 148:
                lr = parse_compile_execute + 152 | 1;
                bl(this::gc_dump_info, 152);
                return;
            case 152:
                cmp(r7, 0);
                if (beq(null, 164)) return;
            case 156:
                r1 = movs(r1, 1);
                r0 = parse_compile_execute_str1_1;
                lr = parse_compile_execute + 164 | 1;
                bl(this::mp_hal_stdout_tx_strn, 164);
                return;
            case 164:
                r0 = movs(r0, r6);
                sp = add(sp, 92);
                pop(true, R4, R5, R6, R7);
                return;
            case 170:
                r2 = lsls(r5, 27);
                if (bpl(null, 214)) return;
            case 174:
                r2 = ldr(r4 + 4);
                r1 = ldr(r4 + 8);
                r0 = movs(r0, 107);
                lr = parse_compile_execute + 184 | 1;
                bl(this::mp_lexer_new_from_str_len, 184);
                return;
            case 184:
                r4 = movs(r4, r0);
            case 186:
                r6 = ldr(r4);
                r2 = ldr(sp + 12);
                r1 = movs(r1, r4);
                r0 = add(sp, 28);
                lr = parse_compile_execute + 198 | 1;
                bl(this::mp_parse, 198);
                return;
            case 198:
                r3 = lsls(r5, 29);
                r3 = lsrs(r3, 31);
                r2 = movs(r2, 0);
                r1 = movs(r1, r6);
                r0 = add(sp, 28);
                lr = parse_compile_execute + 212 | 1;
                bl(this::mp_compile, 212);
                return;
            case 212:
                b(null, 44);
                return;
            case 214:
                r3 = lsls(r5, 26);
                if (bpl(null, 186)) return;
            case 218:
                r0 = movs(r0, r4);
                lr = parse_compile_execute + 224 | 1;
                bl(this::mp_lexer_new_from_file, 224);
                return;
            case 224:
                b(null, 184);
                return;
            case 226:
                r0 = movs(r0, 1);
                r0 = rsbs(r0, 0);
                lr = parse_compile_execute + 234 | 1;
                bl(this::mp_hal_set_interrupt_char, 234);
                return;
            case 234:
                cmp(r7, 0);
                if (beq(null, 246)) return;
            case 238:
                r1 = movs(r1, 1);
                r0 = parse_compile_execute_str1_1;
                lr = parse_compile_execute + 246 | 1;
                bl(this::mp_hal_stdout_tx_strn, 246);
                return;
            case 246:
                r3 = ldr(sp + 40);
                r1 = mp_type_SystemExit;
                r0 = ldr(r3);
                lr = parse_compile_execute + 256 | 1;
                bl(this::mp_obj_is_subclass_fast, 256);
                return;
            case 256:
                r4 = subs(r0, 0);
                if (beq(null, 266)) return;
            case 260:
                r6 = ldr(r6);
                r4 = movs(r4, 0);
                b(null, 92);
                return;
            case 266:
                r1 = ldr(sp + 40);
                r0 = mp_plat_print;
                lr = parse_compile_execute + 274 | 1;
                bl(this::mp_obj_print_exception, 274);
                return;
            case 274:
                r6 = movs(r6, r4);
                b(null, 92);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134325276, size=160, name='pyexec_raw_repl', path='build/lib/utils/pyexec.o', has_indirect=False)
    protected void pyexec_raw_repl(int offset) throws Exception
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
                lr = pyexec_raw_repl + 14 | 1;
                bl(this::vstr_init, 14);
                return;
            case 14:
                r4 = lsls(r4, 1);
            case 16:
                r0 = pyexec_raw_repl_str1_1;
                lr = pyexec_raw_repl + 22 | 1;
                bl(this::mp_hal_stdout_tx_str, 22);
                return;
            case 22:
                r3 = movs(r3, 0);
                r0 = 0x08025585;
                str(sp + 12, r3);
                lr = pyexec_raw_repl + 32 | 1;
                bl(this::mp_hal_stdout_tx_str, 32);
                return;
            case 32:
                lr = pyexec_raw_repl + 36 | 1;
                bl(this::mp_hal_stdin_rx_chr, 36);
                return;
            case 36:
                cmp(r0, 1);
                if (beq(null, 16)) return;
            case 40:
                cmp(r0, 2);
                if (bne(null, 68)) return;
            case 44:
                r0 = 0x0802b3cb;
                lr = pyexec_raw_repl + 50 | 1;
                bl(this::mp_hal_stdout_tx_str, 50);
                return;
            case 50:
                r0 = add(sp, 8);
                lr = pyexec_raw_repl + 56 | 1;
                bl(this::vstr_clear, 56);
                return;
            case 56:
                r2 = movs(r2, 1);
                r0 = movs(r0, 0);
                r3 = pyexec_mode_kind;
                strb(r3, r2);
            case 64:
                sp = add(sp, 24);
                pop(true, R4);
                return;
            case 68:
                cmp(r0, 3);
                if (bne(null, 78)) return;
            case 72:
                r3 = movs(r3, 0);
                str(sp + 12, r3);
                b(null, 32);
                return;
            case 78:
                cmp(r0, 4);
                if (beq(null, 92)) return;
            case 82:
                r1 = uxtb(r0);
                r0 = add(sp, 8);
                lr = pyexec_raw_repl + 90 | 1;
                bl(this::vstr_add_byte, 90);
                return;
            case 90:
                b(null, 32);
                return;
            case 92:
                r0 = 0x0802b446;
                lr = pyexec_raw_repl + 98 | 1;
                bl(this::mp_hal_stdout_tx_str, 98);
                return;
            case 98:
                r3 = ldr(sp + 12);
                str(sp + 4, r3);
                cmp(r3, 0);
                if (bne(null, 124)) return;
            case 106:
                r0 = 0x0802b3cb;
                lr = pyexec_raw_repl + 112 | 1;
                bl(this::mp_hal_stdout_tx_str, 112);
                return;
            case 112:
                r0 = add(sp, 8);
                lr = pyexec_raw_repl + 118 | 1;
                bl(this::vstr_clear, 118);
                return;
            case 118:
                r0 = movs(r0, 128);
                r0 = lsls(r0, 1);
                b(null, 64);
                return;
            case 124:
                r2 = movs(r2, 17);
                r1 = movs(r1, 1);
                r0 = add(sp, 8);
                lr = pyexec_raw_repl + 134 | 1;
                bl(this::parse_compile_execute, 134);
                return;
            case 134:
                tst(r0, r4);
                if (beq(null, 22)) return;
            case 138:
                b(null, 64);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134325436, size=272, name='pyexec_friendly_repl', path='build/lib/utils/pyexec.o', has_indirect=False)
    protected void pyexec_friendly_repl(int offset) throws Exception
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
                lr = pyexec_friendly_repl + 14 | 1;
                bl(this::vstr_init, 14);
                return;
            case 14:
                r5 = lsls(r5, 1);
            case 16:
                r0 = pyexec_friendly_repl_str1_1;
                lr = pyexec_friendly_repl + 22 | 1;
                bl(this::mp_hal_stdout_tx_str, 22);
                return;
            case 22:
                r0 = 0x0802b3a8;
            case 24:
                lr = pyexec_friendly_repl + 28 | 1;
                bl(this::mp_hal_stdout_tx_str, 28);
                return;
            case 28:
                r4 = movs(r4, 0);
                r1 = 0x0802b3ce;
                r0 = add(sp, 8);
                str(sp + 12, r4);
                lr = pyexec_friendly_repl + 40 | 1;
                bl(this::readline, 40);
                return;
            case 40:
                cmp(r0, 1);
                if (bne(null, 66)) return;
            case 44:
                r0 = 0x0802b3cb;
                lr = pyexec_friendly_repl + 50 | 1;
                bl(this::mp_hal_stdout_tx_str, 50);
                return;
            case 50:
                r0 = add(sp, 8);
                lr = pyexec_friendly_repl + 56 | 1;
                bl(this::vstr_clear, 56);
                return;
            case 56:
                r0 = movs(r0, r4);
                r3 = pyexec_mode_kind;
                strb(r3, r4);
            case 62:
                sp = add(sp, 28);
                pop(true, R4, R5);
                return;
            case 66:
                cmp(r0, 2);
                if (bne(null, 78)) return;
            case 70:
                r0 = 0x0802b3cb;
                lr = pyexec_friendly_repl + 76 | 1;
                bl(this::mp_hal_stdout_tx_str, 76);
                return;
            case 76:
                b(null, 16);
                return;
            case 78:
                cmp(r0, 3);
                if (bne(null, 86)) return;
            case 82:
                r0 = 0x0802b3cb;
                b(null, 24);
                return;
            case 86:
                cmp(r0, 4);
                if (bne(null, 108)) return;
            case 90:
                r0 = 0x0802b3cb;
                lr = pyexec_friendly_repl + 96 | 1;
                bl(this::mp_hal_stdout_tx_str, 96);
                return;
            case 96:
                r0 = add(sp, 8);
                lr = pyexec_friendly_repl + 102 | 1;
                bl(this::vstr_clear, 102);
                return;
            case 102:
                r0 = movs(r0, 128);
                r0 = lsls(r0, 1);
                b(null, 62);
                return;
            case 108:
                cmp(r0, 5);
                if (bne(null, 192)) return;
            case 112:
                r0 = 0x0802b3d3;
                lr = pyexec_friendly_repl + 118 | 1;
                bl(this::mp_hal_stdout_tx_str, 118);
                return;
            case 118:
                str(sp + 12, r4);
            case 120:
                lr = pyexec_friendly_repl + 124 | 1;
                bl(this::mp_hal_stdin_rx_chr, 124);
                return;
            case 124:
                r3 = mov(sp);
                r1 = uxtb(r0);
                r4 = adds(r3, 7);
                strb(r4, r1);
                cmp(r1, 3);
                if (beq(null, 82)) return;
            case 136:
                cmp(r1, 4);
                if (bne(null, 162)) return;
            case 140:
                r0 = 0x0802b3cb;
                lr = pyexec_friendly_repl + 146 | 1;
                bl(this::mp_hal_stdout_tx_str, 146);
                return;
            case 146:
                r1 = movs(r1, 1);
            case 148:
                r2 = movs(r2, 22);
                r0 = add(sp, 8);
                lr = pyexec_friendly_repl + 156 | 1;
                bl(this::parse_compile_execute, 156);
                return;
            case 156:
                tst(r0, r5);
                if (beq(null, 28)) return;
            case 160:
                b(null, 62);
                return;
            case 162:
                r0 = add(sp, 8);
                lr = pyexec_friendly_repl + 168 | 1;
                bl(this::vstr_add_byte, 168);
                return;
            case 168:
                r3 = ldrb(r4);
                cmp(r3, 13);
                if (bne(null, 182)) return;
            case 174:
                r0 = 0x0802b403;
                lr = pyexec_friendly_repl + 180 | 1;
                bl(this::mp_hal_stdout_tx_str, 180);
                return;
            case 180:
                b(null, 120);
                return;
            case 182:
                r1 = movs(r1, 1);
                r0 = movs(r0, r4);
                lr = pyexec_friendly_repl + 190 | 1;
                bl(this::mp_hal_stdout_tx_strn, 190);
                return;
            case 190:
                b(null, 120);
                return;
            case 192:
                r3 = ldr(sp + 12);
                cmp(r3, 0);
                if (beq(null, 28)) return;
            case 198:
                r0 = add(sp, 8);
                lr = pyexec_friendly_repl + 204 | 1;
                bl(this::vstr_null_terminated_str, 204);
                return;
            case 204:
                lr = pyexec_friendly_repl + 208 | 1;
                bl(this::mp_repl_continue_with_input, 208);
                return;
            case 208:
                cmp(r0, 0);
                if (beq(null, 236)) return;
            case 212:
                r1 = movs(r1, 10);
                r0 = add(sp, 8);
                lr = pyexec_friendly_repl + 220 | 1;
                bl(this::vstr_add_byte, 220);
                return;
            case 220:
                r1 = 0x0802b40a;
                r0 = add(sp, 8);
                lr = pyexec_friendly_repl + 228 | 1;
                bl(this::readline, 228);
                return;
            case 228:
                cmp(r0, 3);
                if (beq(null, 82)) return;
            case 232:
                cmp(r0, 4);
                if (bne(null, 198)) return;
            case 236:
                r1 = movs(r1, 0);
                b(null, 148);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134325708, size=60, name='pyexec_frozen_module', path='build/lib/utils/pyexec.o', has_indirect=False)
    protected void pyexec_frozen_module(int offset) throws Exception
    {
        pc = pyexec_frozen_module + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r4);
                r4 = movs(r4, r0);
                lr = pyexec_frozen_module + 8 | 1;
                bl(this::strlen, 8);
                return;
            case 8:
                r2 = add(sp, 4);
                r1 = movs(r1, r0);
                r0 = movs(r0, r4);
                lr = pyexec_frozen_module + 18 | 1;
                bl(this::mp_find_frozen_module, 18);
                return;
            case 18:
                r1 = movs(r1, r0);
                cmp(r0, 1);
                if (beq(null, 40)) return;
            case 24:
                cmp(r0, 2);
                if (beq(null, 50)) return;
            case 28:
                r1 = movs(r1, r4);
                r0 = pyexec_frozen_module_str1_1;
                lr = pyexec_frozen_module + 36 | 1;
                bl(this::printf, 36);
                return;
            case 36:
                r0 = movs(r0, 0);
                b(null, 48);
                return;
            case 40:
                r2 = movs(r2, 0);
            case 42:
                r0 = ldr(sp + 4);
                lr = pyexec_frozen_module + 48 | 1;
                bl(this::parse_compile_execute, 48);
                return;
            case 48:
                pop(true, R1, R2, R4);
                return;
            case 50:
                r2 = movs(r2, 8);
                r1 = movs(r1, 1);
                b(null, 42);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134325768, size=70, name='memcpy', path='build/lib/libc/string0.o', has_indirect=False)
    protected void memcpy(int offset) throws Exception
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
                if (beq(null, 28)) return;
            case 12:
                r3 = movs(r3, 0);
            case 14:
                cmp(r3, r2);
                if (bne(null, 20)) return;
            case 18:
                pop(true, R4, R5);
                return;
            case 20:
                r4 = ldrb(r1 + r3);
                strb(r0 + r3, r4);
                r3 = adds(r3, 1);
                b(null, 14);
                return;
            case 28:
                r4 = lsrs(r2, 2);
                r4 = lsls(r4, 2);
            case 32:
                cmp(r3, r4);
                if (bne(null, 62)) return;
            case 36:
                r4 = adds(r0, r3);
                r1 = adds(r1, r3);
                r3 = lsls(r2, 30);
                if (bpl(null, 52)) return;
            case 44:
                r3 = ldrh(r1);
                r1 = adds(r1, 2);
                strh(r4, r3);
                r4 = adds(r4, 2);
            case 52:
                r3 = lsls(r2, 31);
                if (bpl(null, 18)) return;
            case 56:
                r3 = ldrb(r1);
                strb(r4, r3);
                b(null, 18);
                return;
            case 62:
                r5 = ldr(r1 + r3);
                str(r0 + r3, r5);
                r3 = adds(r3, 4);
                b(null, 32);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134325838, size=36, name='memmove', path='build/lib/libc/string0.o', has_indirect=False)
    protected void memmove(int offset) throws Exception
    {
        pc = memmove + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                cmp(r1, r0);
                if (bhs(null, 30)) return;
            case 6:
                r3 = adds(r1, r2);
                cmp(r0, r3);
                if (bhs(null, 30)) return;
            case 12:
                r1 = subs(r1, 1);
                r3 = subs(r0, 1);
            case 16:
                cmp(r2, 0);
                if (bne(null, 22)) return;
            case 20:
                pop(true, R4);
                return;
            case 22:
                r4 = ldrb(r1 + r2);
                strb(r3 + r2, r4);
                r2 = subs(r2, 1);
                b(null, 16);
                return;
            case 30:
                lr = memmove + 34 | 1;
                bl(this::memcpy, 34);
                return;
            case 34:
                b(null, 20);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134325874, size=64, name='memset', path='build/lib/libc/string0.o', has_indirect=False)
    protected void memset(int offset) throws Exception
    {
        pc = memset + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5);
                cmp(r1, 0);
                if (beq(null, 20)) return;
            case 6:
                r3 = movs(r3, r0);
                r2 = adds(r2, r0);
            case 10:
                cmp(r2, r3);
                if (beq(null, 56)) return;
            case 14:
                strb(r3, r1);
                r3 = adds(r3, 1);
                b(null, 10);
                return;
            case 20:
                r4 = movs(r4, 3);
                r5 = movs(r5, r0);
                r4 = ands(r4, r0);
                if (bne(null, 6)) return;
            case 28:
                r3 = lsrs(r2, 2);
                r1 = movs(r1, r3);
            case 32:
                cmp(r1, 0);
                if (bne(null, 58)) return;
            case 36:
                r3 = lsls(r3, 2);
                r3 = adds(r0, r3);
                r4 = lsls(r2, 30);
                if (bpl(null, 48)) return;
            case 44:
                strh(r3, r1);
                r3 = adds(r3, 2);
            case 48:
                r2 = lsls(r2, 31);
                if (bpl(null, 56)) return;
            case 52:
                r2 = movs(r2, 0);
                strb(r3, r2);
            case 56:
                pop(true, R4, R5);
                return;
            case 58:
                r5 = stm(r5, R4);
                r1 = subs(r1, 1);
                b(null, 32);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134325938, size=36, name='memcmp', path='build/lib/libc/string0.o', has_indirect=False)
    protected void memcmp(int offset) throws Exception
    {
        pc = memcmp + offset;
        switch (offset)
        {
            case 0:
                r3 = movs(r3, 0);
                push(true, r4, r5);
            case 4:
                cmp(r2, r3);
                if (bne(null, 12)) return;
            case 8:
                r0 = movs(r0, 0);
            case 10:
                pop(true, R4, R5);
                return;
            case 12:
                r5 = ldrb(r0 + r3);
                r4 = ldrb(r1 + r3);
                cmp(r5, r4);
                if (blo(null, 30)) return;
            case 20:
                r3 = adds(r3, 1);
                cmp(r5, r4);
                if (bls(null, 4)) return;
            case 26:
                r0 = movs(r0, 1);
                b(null, 10);
                return;
            case 30:
                r0 = movs(r0, 1);
                r0 = rsbs(r0, 0);
                b(null, 10);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134325974, size=18, name='strlen', path='build/lib/libc/string0.o', has_indirect=False)
    protected void strlen(int offset) throws Exception
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
                if (bne(null, 14)) return;
            case 12:
                bx(lr);
                return;
            case 14:
                r3 = adds(r3, 1);
                b(null, 4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134325992, size=46, name='strcmp', path='build/lib/libc/string0.o', has_indirect=False)
    protected void strcmp(int offset) throws Exception
    {
        pc = strcmp + offset;
        switch (offset)
        {
            case 0:
                r2 = ldrb(r0);
                r3 = ldrb(r1);
                cmp(r2, 0);
                if (bne(null, 32)) return;
            case 8:
                cmp(r3, 0);
                if (beq(null, 38)) return;
            case 12:
                r0 = movs(r0, 1);
                r0 = rsbs(r0, 0);
                b(null, 44);
                return;
            case 18:
                r0 = adds(r0, 1);
                r1 = adds(r1, 1);
                cmp(r2, r3);
                if (blo(null, 12)) return;
            case 26:
                if (bls(null, 0)) return;
            case 28:
                r0 = movs(r0, 1);
                b(null, 44);
                return;
            case 32:
                cmp(r3, 0);
                if (bne(null, 18)) return;
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

    // function: Function(address=134326038, size=68, name='strncmp', path='build/lib/libc/string0.o', has_indirect=False)
    protected void strncmp(int offset) throws Exception
    {
        pc = strncmp + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
            case 2:
                r3 = ldrb(r0);
                cmp(r3, 0);
                if (beq(null, 38)) return;
            case 8:
                r4 = ldrb(r1);
                cmp(r4, 0);
                if (beq(null, 62)) return;
            case 14:
                cmp(r2, 0);
                if (bne(null, 22)) return;
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
                if (blo(null, 56)) return;
            case 32:
                if (bls(null, 2)) return;
            case 34:
                r0 = movs(r0, 1);
                b(null, 20);
                return;
            case 38:
                r0 = subs(r2, 0);
                if (beq(null, 20)) return;
            case 42:
                r3 = ldrb(r1);
                cmp(r3, 0);
                if (bne(null, 56)) return;
            case 48:
                r0 = movs(r0, r3);
                r3 = subs(r0, 1);
                r0 = sbcs(r0, r3);
                b(null, 20);
                return;
            case 56:
                r0 = movs(r0, 1);
                r0 = rsbs(r0, 0);
                b(null, 20);
                return;
            case 62:
                r0 = subs(r2, 0);
                if (bne(null, 48)) return;
            case 66:
                b(null, 20);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134326106, size=24, name='strchr', path='build/lib/libc/string0.o', has_indirect=False)
    protected void strchr(int offset) throws Exception
    {
        pc = strchr + offset;
        switch (offset)
        {
            case 0:
                r2 = uxtb(r1);
            case 2:
                r3 = ldrb(r0);
                cmp(r3, 0);
                if (beq(null, 12)) return;
            case 8:
                cmp(r3, r2);
                if (bne(null, 20)) return;
            case 12:
                cmp(r3, r1);
                if (beq(null, 18)) return;
            case 16:
                r0 = movs(r0, 0);
            case 18:
                bx(lr);
                return;
            case 20:
                r0 = adds(r0, 1);
                b(null, 2);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134326132, size=48, name='mp_hal_move_cursor_back', path='build/lib/mp-readline/readline.o', has_indirect=False)
    protected void mp_hal_move_cursor_back(int offset) throws Exception
    {
        pc = mp_hal_move_cursor_back + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2);
                r3 = movs(r3, r0);
                cmp(r0, 4);
                if (bhi(null, 18)) return;
            case 8:
                r1 = movs(r1, r0);
                r0 = mp_hal_move_cursor_back_str1_1;
            case 12:
                lr = mp_hal_move_cursor_back + 16 | 1;
                bl(this::mp_hal_stdout_tx_strn, 16);
                return;
            case 16:
                pop(true, R0, R1, R2);
                return;
            case 18:
                r2 = 0x0802b44e;
                r1 = movs(r1, 6);
                r0 = mov(sp);
                lr = mp_hal_move_cursor_back + 28 | 1;
                bl(this::snprintf, 28);
                return;
            case 28:
                r3 = movs(r3, 68);
                r2 = mov(sp);
                r1 = adds(r0, 1);
                strb(r2 + r0, r3);
                r0 = mov(sp);
                b(null, 12);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134326180, size=36, name='readline_init', path='build/lib/mp-readline/readline.o', has_indirect=False)
    protected void readline_init(int offset) throws Exception
    {
        pc = readline_init + offset;
        switch (offset)
        {
            case 0:
                r3 = bss_rl;
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
                lr = readline_init + 30 | 1;
                bl(this::mp_hal_stdout_tx_str, 30);
                return;
            case 30:
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134326216, size=96, name='readline_push_history', path='build/lib/mp-readline/readline.o', has_indirect=False)
    protected void readline_push_history(int offset) throws Exception
    {
        pc = readline_push_history + offset;
        switch (offset)
        {
            case 0:
                push(true, r3, r4, r5, r6, r7);
                r3 = ldrb(r0);
                r6 = movs(r6, r0);
                cmp(r3, 0);
                if (beq(null, 90)) return;
            case 10:
                r3 = movs(r3, 216);
                r4 = mp_state_ctx;
                r3 = lsls(r3, 1);
                r0 = ldr(r4 + r3);
                cmp(r0, 0);
                if (beq(null, 32)) return;
            case 22:
                r1 = movs(r1, r6);
                lr = readline_push_history + 28 | 1;
                bl(this::strcmp, 28);
                return;
            case 28:
                cmp(r0, 0);
                if (beq(null, 90)) return;
            case 32:
                r0 = movs(r0, r6);
                lr = readline_push_history + 38 | 1;
                bl(this::strlen, 38);
                return;
            case 38:
                r7 = adds(r0, 1);
                r0 = movs(r0, r7);
                lr = readline_push_history + 46 | 1;
                bl(this::m_malloc_maybe, 46);
                return;
            case 46:
                r5 = subs(r0, 0);
                if (beq(null, 90)) return;
            case 50:
                r2 = movs(r2, r7);
                r1 = movs(r1, r6);
                lr = readline_push_history + 58 | 1;
                bl(this::memcpy, 58);
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
                if (bne(null, 60)) return;
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

    // function: Function(address=134326312, size=628, name='readline_process_char', path='build/lib/mp-readline/readline.o', has_indirect=False)
    protected void readline_process_char(int offset) throws Exception
    {
        pc = readline_process_char + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r4 = bss_rl;
                r2 = movs(r2, r0);
                r0 = ldr(r4);
                r5 = ldr(r4 + 8);
                r3 = ldr(r0 + 4);
                sp = sub(sp, 20);
                str(sp + 4, r3);
                cmp(r5, 0);
                if (beq(null, 22)) return;
            case 20:
                b(null, 276);
                return;
            case 22:
                r3 = subs(r2, 1);
                cmp(r3, 4);
                if (bhi(null, 46)) return;
            case 28:
                r3 = ldr(r4 + 4);
                r1 = ldr(sp + 4);
                cmp(r3, r1);
                if (beq(null, 78)) return;
            case 36:
                cmp(r2, 1);
                if (bne(null, 42)) return;
            case 40:
                b(null, 524);
                return;
            case 42:
                cmp(r2, 3);
                if (beq(null, 78)) return;
            case 46:
                cmp(r2, 5);
                if (bne(null, 52)) return;
            case 50:
                b(null, 492);
                return;
            case 52:
                cmp(r2, 13);
                if (bne(null, 84)) return;
            case 56:
                r0 = 0x0802b3cb;
                lr = readline_process_char + 62 | 1;
                bl(this::mp_hal_stdout_tx_str, 62);
                return;
            case 62:
                r0 = ldr(r4);
                lr = readline_process_char + 68 | 1;
                bl(this::vstr_null_terminated_str, 68);
                return;
            case 68:
                r3 = ldr(r4 + 4);
                r0 = adds(r0, r3);
                lr = readline_process_char + 76 | 1;
                bl(this::readline_push_history, 76);
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
                if (beq(null, 294)) return;
            case 90:
                cmp(r2, 8);
                if (beq(null, 98)) return;
            case 94:
                cmp(r2, 127);
                if (bne(null, 120)) return;
            case 98:
                r1 = ldr(r4 + 16);
                r3 = ldr(r4 + 4);
                cmp(r1, r3);
                if (bls(null, 296)) return;
            case 106:
                r1 = subs(r1, 1);
                r2 = movs(r2, 1);
                lr = readline_process_char + 114 | 1;
                bl(this::vstr_cut_out_bytes, 114);
                return;
            case 114:
                r7 = movs(r7, 1);
            case 116:
                r6 = movs(r6, 1);
                b(null, 378);
                return;
            case 120:
                cmp(r2, 9);
                if (bne(null, 258)) return;
            case 124:
                r3 = ldr(r4 + 4);
                r2 = ldr(r4 + 16);
                r0 = ldr(r0 + 8);
                r1 = subs(r2, r3);
                r0 = adds(r0, r3);
                r2 = mp_plat_print;
                r3 = add(sp, 12);
                lr = readline_process_char + 142 | 1;
                bl(this::mp_repl_autocomplete, 142);
                return;
            case 142:
                r6 = subs(r0, 0);
                if (beq(null, 296)) return;
            case 146:
                r7 = movs(r7, 0);
                r3 = adds(r0, 1);
                if (bne(null, 230)) return;
            case 152:
                r0 = ldr(r4 + 24);
                lr = readline_process_char + 158 | 1;
                bl(this::mp_hal_stdout_tx_str, 158);
                return;
            case 158:
                r3 = ldr(r4 + 4);
                r2 = ldr(r4 + 16);
                r1 = subs(r2, r3);
                r2 = ldr(r4);
                r0 = ldr(r2 + 8);
                r0 = adds(r0, r3);
                lr = readline_process_char + 174 | 1;
                bl(this::mp_hal_stdout_tx_strn, 174);
                return;
            case 174:
                r3 = ldr(r4);
                r2 = ldr(sp + 4);
                r3 = ldr(r3 + 4);
                cmp(r3, r2);
                if (bhs(null, 192)) return;
            case 184:
                r1 = movs(r1, 3);
                r0 = readline_process_char_str1_1;
                lr = readline_process_char + 192 | 1;
                bl(this::mp_hal_stdout_tx_strn, 192);
                return;
            case 192:
                r2 = ldr(r4);
                r3 = ldr(r4 + 16);
                r1 = ldr(r2 + 4);
                r0 = ldr(r2 + 8);
                r1 = subs(r1, r3);
                r0 = adds(r0, r3);
                lr = readline_process_char + 208 | 1;
                bl(this::mp_hal_stdout_tx_strn, 208);
                return;
            case 208:
                r3 = ldr(r4);
                r0 = ldr(r3 + 4);
                r3 = ldr(r4 + 16);
                r0 = subs(r0, r3);
                r0 = subs(r0, r5);
                lr = readline_process_char + 222 | 1;
                bl(this::mp_hal_move_cursor_back, 222);
                return;
            case 222:
                r3 = ldr(r4 + 16);
                r5 = adds(r3, r5);
                str(r4 + 16, r5);
                b(null, 296);
                return;
            case 230:
                r3 = ldr(r4 + 16);
                r0 = ldr(r4);
                r1 = adds(r7, r3);
                r3 = ldr(sp + 12);
                r7 = adds(r7, 1);
                r2 = adds(r3, 1);
                str(sp + 12, r2);
                r2 = ldrb(r3);
                lr = readline_process_char + 250 | 1;
                bl(this::vstr_ins_byte, 250);
                return;
            case 250:
                cmp(r6, r7);
                if (bne(null, 230)) return;
            case 254:
                r5 = movs(r5, r6);
                b(null, 174);
                return;
            case 258:
                r3 = movs(r3, r2);
                r3 = subs(r3, 32);
                cmp(r3, 94);
                if (bhi(null, 296)) return;
            case 266:
                r1 = ldr(r4 + 16);
                lr = readline_process_char + 272 | 1;
                bl(this::vstr_ins_char, 272);
                return;
            case 272:
                r5 = movs(r5, 1);
                b(null, 174);
                return;
            case 276:
                cmp(r5, 1);
                if (bne(null, 302)) return;
            case 280:
                r3 = movs(r3, 4);
                cmp(r2, 79);
                if (beq(null, 294)) return;
            case 286:
                r3 = movs(r3, 2);
                cmp(r2, 91);
                if (beq(null, 294)) return;
            case 292:
                r3 = movs(r3, 0);
            case 294:
                str(r4 + 8, r3);
            case 296:
                r2 = movs(r2, 1);
                r2 = rsbs(r2, 0);
                b(null, 78);
                return;
            case 302:
                cmp(r5, 2);
                if (bne(null, 504)) return;
            case 306:
                r3 = movs(r3, r2);
                r3 = subs(r3, 48);
                cmp(r3, 9);
                if (bhi(null, 322)) return;
            case 314:
                r3 = movs(r3, 3);
                strb(r4 + 20, r2);
                str(r4 + 8, r3);
                b(null, 296);
                return;
            case 322:
                r5 = movs(r5, 0);
                str(r4 + 8, r5);
                cmp(r2, 65);
                if (bne(null, 392)) return;
            case 330:
                r3 = ldr(r4 + 12);
                cmp(r3, 6);
                if (bgt(null, 296)) return;
            case 336:
                r2 = adds(r3, 1);
                r1 = mp_state_ctx;
                r3 = adds(r3, 109);
                r3 = lsls(r3, 2);
                r1 = ldr(r3 + r1);
                cmp(r1, r5);
                if (beq(null, 296)) return;
            case 350:
                r3 = ldr(r4 + 4);
                str(r4 + 12, r2);
                str(r0 + 4, r3);
            case 356:
                lr = readline_process_char + 360 | 1;
                bl(this::vstr_add_str, 360);
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
                if (ble(null, 174)) return;
            case 378:
                r0 = movs(r0, r6);
                lr = readline_process_char + 384 | 1;
                bl(this::mp_hal_move_cursor_back, 384);
                return;
            case 384:
                r3 = ldr(r4 + 16);
                r6 = subs(r3, r6);
                str(r4 + 16, r6);
                b(null, 542);
                return;
            case 392:
                cmp(r2, 66);
                if (bne(null, 434)) return;
            case 396:
                r3 = ldr(r4 + 12);
                cmp(r3, 0);
                if (blt(null, 296)) return;
            case 402:
                r3 = subs(r3, 1);
                str(r4 + 12, r3);
                r2 = ldr(r4 + 4);
                r3 = ldr(sp + 4);
                r1 = subs(r3, r2);
                lr = readline_process_char + 416 | 1;
                bl(this::vstr_cut_tail_bytes, 416);
                return;
            case 416:
                r3 = ldr(r4 + 12);
                cmp(r3, 0);
                if (blt(null, 360)) return;
            case 422:
                r3 = adds(r3, 108);
                r2 = mp_state_ctx;
                r3 = lsls(r3, 2);
                r1 = ldr(r3 + r2);
                r0 = ldr(r4);
                b(null, 356);
                return;
            case 434:
                cmp(r2, 67);
                if (bne(null, 468)) return;
            case 438:
                r3 = ldr(r4 + 16);
                r2 = ldr(sp + 4);
                cmp(r3, r2);
                r5 = sbcs(r5, r5);
                r5 = rsbs(r5, 0);
            case 448:
                cmp(r5, 0);
                if (ble(null, 296)) return;
            case 452:
                r3 = ldr(r4);
                r1 = movs(r1, r5);
                r0 = ldr(r3 + 8);
                r3 = ldr(r4 + 16);
                r0 = adds(r0, r3);
                lr = readline_process_char + 466 | 1;
                bl(this::mp_hal_stdout_tx_strn, 466);
                return;
            case 466:
                b(null, 222);
                return;
            case 468:
                cmp(r2, 68);
                if (bne(null, 484)) return;
            case 472:
                r3 = ldr(r4 + 16);
                r2 = ldr(r4 + 4);
                cmp(r3, r2);
                if (bls(null, 296)) return;
            case 480:
                r7 = movs(r7, r5);
                b(null, 116);
                return;
            case 484:
                cmp(r2, 72);
                if (beq(null, 524)) return;
            case 488:
                cmp(r2, 70);
                if (bne(null, 296)) return;
            case 492:
                r7 = movs(r7, 0);
                r3 = ldr(sp + 4);
                r2 = ldr(r4 + 16);
                r6 = movs(r6, r7);
                r5 = subs(r3, r2);
                b(null, 534);
                return;
            case 504:
                r1 = movs(r1, 0);
                cmp(r5, 3);
                if (bne(null, 590)) return;
            case 510:
                cmp(r2, 126);
                if (bne(null, 584)) return;
            case 514:
                r3 = ldrb(r4 + 20);
                cmp(r3, 49);
                if (beq(null, 524)) return;
            case 520:
                cmp(r3, 55);
                if (bne(null, 548)) return;
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
                if (bgt(null, 378)) return;
            case 542:
                cmp(r7, 0);
                if (beq(null, 448)) return;
            case 546:
                b(null, 174);
                return;
            case 548:
                r2 = movs(r2, r3);
                r5 = movs(r5, 251);
                r2 = subs(r2, 52);
                tst(r2, r5);
                if (beq(null, 492)) return;
            case 558:
                cmp(r3, 51);
                if (bne(null, 584)) return;
            case 562:
                r1 = ldr(r4 + 16);
                r3 = ldr(sp + 4);
                cmp(r1, r3);
                if (bhs(null, 584)) return;
            case 570:
                r2 = movs(r2, 1);
                lr = readline_process_char + 576 | 1;
                bl(this::vstr_cut_out_bytes, 576);
                return;
            case 576:
                r5 = movs(r5, 0);
                r7 = movs(r7, 1);
            case 580:
                r6 = movs(r6, r5);
                b(null, 534);
                return;
            case 584:
                r5 = movs(r5, 0);
                r7 = movs(r7, r5);
                b(null, 580);
                return;
            case 590:
                cmp(r5, 4);
                if (bne(null, 604)) return;
            case 594:
                cmp(r2, 70);
                if (beq(null, 492)) return;
            case 598:
                cmp(r2, 72);
                if (beq(null, 524)) return;
            case 602:
                b(null, 292);
                return;
            case 604:
                str(r4 + 8, r1);
                b(null, 296);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134326940, size=20, name='readline', path='build/lib/mp-readline/readline.o', has_indirect=False)
    protected void readline(int offset) throws Exception
    {
        pc = readline + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                lr = readline + 6 | 1;
                bl(this::readline_init, 6);
                return;
            case 6:
                lr = readline + 10 | 1;
                bl(this::mp_hal_stdin_rx_chr, 10);
                return;
            case 10:
                lr = readline + 14 | 1;
                bl(this::readline_process_char, 14);
                return;
            case 14:
                cmp(r0, 0);
                if (blt(null, 6)) return;
            case 18:
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134326960, size=98, name='scalbnf', path='build/lib/libm/math.o', has_indirect=False)
    protected void scalbnf(int offset) throws Exception
    {
        pc = scalbnf + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r5 = movs(r5, r1);
                cmp(r1, 127);
                if (ble(null, 52)) return;
            case 8:
                r1 = movs(r1, 254);
                r4 = movs(r4, r5);
                r1 = lsls(r1, 23);
                r4 = subs(r4, 127);
                lr = scalbnf + 20 | 1;
                bl(this::__aeabi_fmul, 20);
                return;
            case 20:
                cmp(r4, 127);
                if (ble(null, 40)) return;
            case 24:
                r1 = movs(r1, 254);
                r4 = subs(r4, 127);
                r1 = lsls(r1, 23);
                lr = scalbnf + 34 | 1;
                bl(this::__aeabi_fmul, 34);
                return;
            case 34:
                cmp(r4, 127);
                if (ble(null, 40)) return;
            case 38:
                r4 = movs(r4, 127);
            case 40:
                r1 = movs(r1, r4);
                r1 = adds(r1, 127);
                r1 = lsls(r1, 23);
                lr = scalbnf + 50 | 1;
                bl(this::__aeabi_fmul, 50);
                return;
            case 50:
                pop(true, R4, R5, R6);
                return;
            case 52:
                r3 = movs(r3, r1);
                r4 = movs(r4, r1);
                r3 = adds(r3, 126);
                if (bge(null, 40)) return;
            case 60:
                r1 = movs(r1, 128);
                r4 = adds(r4, 126);
                r1 = lsls(r1, 16);
                lr = scalbnf + 70 | 1;
                bl(this::__aeabi_fmul, 70);
                return;
            case 70:
                r3 = movs(r3, r4);
                r3 = adds(r3, 126);
                if (bge(null, 40)) return;
            case 76:
                r1 = movs(r1, 128);
                r4 = adds(r4, 126);
                r1 = lsls(r1, 16);
                lr = scalbnf + 86 | 1;
                bl(this::__aeabi_fmul, 86);
                return;
            case 86:
                r3 = movs(r3, r4);
                r3 = adds(r3, 126);
                if (bge(null, 40)) return;
            case 92:
                r4 = movs(r4, 126);
                r4 = rsbs(r4, 0);
                b(null, 40);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134327060, size=1696, name='powf', path='build/lib/libm/math.o', has_indirect=True)
    protected void powf(int offset) throws Exception
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
                if (bne(null, 18)) return;
            case 16:
                b(null, 1610);
                return;
            case 18:
                r3 = movs(r3, 254);
                r6 = movs(r6, r0);
                r3 = lsls(r3, 22);
                cmp(r0, r3);
                if (bne(null, 30)) return;
            case 28:
                b(null, 1610);
                return;
            case 30:
                r3 = lsls(r0, 1);
                r0 = movs(r0, 255);
                str(sp, r3);
                r4 = lsrs(r3, 1);
                r0 = lsls(r0, 23);
                cmp(r4, r0);
                if (bgt(null, 48)) return;
            case 44:
                cmp(r2, r0);
                if (ble(null, 60)) return;
            case 48:
                r1 = ldr(sp + 4);
                r0 = adds(r7, 0);
                lr = powf + 56 | 1;
                bl(this::__aeabi_fadd, 56);
                return;
            case 56:
                sp = add(sp, 36);
                pop(true, R4, R5, R6, R7);
                return;
            case 60:
                r5 = movs(r5, 0);
                cmp(r7, r5);
                if (bge(null, 134)) return;
            case 66:
                r3 = 0x4b7fffff;
                cmp(r2, r3);
                if (bgt(null, 132)) return;
            case 72:
                r0 = 0x3f7fffff;
                cmp(r2, r0);
                if (ble(null, 106)) return;
            case 78:
                r3 = movs(r3, 150);
                r0 = asrs(r2, 23);
                r0 = subs(r3, r0);
                r3 = movs(r3, r2);
                r3 = asrs(r3, r0);
                r12 = mov(r3);
                r3 = lsls(r3, r0);
                cmp(r3, r2);
                if (bne(null, 106)) return;
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
                if (bne(null, 182)) return;
            case 114:
                r0 = adds(r7, 0);
                cmp(r1, 0);
                if (bge(null, 56)) return;
            case 120:
                r0 = movs(r0, 254);
                r1 = adds(r7, 0);
                r0 = lsls(r0, 22);
            case 126:
                lr = powf + 130 | 1;
                bl(this::__aeabi_fdiv, 130);
                return;
            case 130:
                b(null, 56);
                return;
            case 132:
                r5 = movs(r5, 2);
            case 134:
                cmp(r2, r0);
                if (bne(null, 106)) return;
            case 138:
                r0 = movs(r0, 254);
                r0 = lsls(r0, 22);
                cmp(r4, r0);
                if (bne(null, 148)) return;
            case 146:
                b(null, 1610);
                return;
            case 148:
                if (ble(null, 160)) return;
            case 150:
                r0 = ldr(sp + 4);
                cmp(r1, 0);
                if (bge(null, 56)) return;
            case 156:
                r0 = movs(r0, 0);
                b(null, 56);
                return;
            case 160:
                cmp(r4, 0);
                if (beq(null, 200)) return;
            case 164:
                cmp(r1, 0);
                if (bge(null, 156)) return;
            case 168:
                r2 = movs(r2, 128);
                r2 = lsls(r2, 24);
                r12 = mov(r2);
                r3 = ldr(sp + 4);
                r3 = add(r3, r12);
                r0 = movs(r0, r3);
                b(null, 56);
                return;
            case 182:
                r0 = movs(r0, 128);
                r0 = lsls(r0, 23);
                cmp(r1, r0);
                if (bne(null, 200)) return;
            case 190:
                r1 = adds(r7, 0);
                r0 = adds(r7, 0);
            case 194:
                lr = powf + 198 | 1;
                bl(this::__aeabi_fmul, 198);
                return;
            case 198:
                b(null, 56);
                return;
            case 200:
                r0 = movs(r0, 252);
                r0 = lsls(r0, 22);
                cmp(r1, r0);
                if (bne(null, 220)) return;
            case 208:
                cmp(r6, 0);
                if (blt(null, 220)) return;
            case 212:
                r0 = adds(r7, 0);
                lr = powf + 218 | 1;
                bl(this::sqrtf, 218);
                return;
            case 218:
                b(null, 56);
                return;
            case 220:
                r3 = lsls(r7, 1);
                r0 = lsrs(r3, 1);
                cmp(r4, 0);
                if (beq(null, 246)) return;
            case 228:
                r3 = lsls(r7, 2);
                r3 = lsrs(r3, 2);
                str(sp, r3);
                r3 = movs(r3, 254);
                r3 = lsls(r3, 22);
                r12 = mov(r3);
                r3 = ldr(sp);
                cmp(r3, r12);
                if (bne(null, 296)) return;
            case 246:
                cmp(r1, 0);
                if (bge(null, 260)) return;
            case 250:
                r1 = adds(r0, 0);
                r0 = movs(r0, 254);
                r0 = lsls(r0, 22);
                lr = powf + 260 | 1;
                bl(this::__aeabi_fdiv, 260);
                return;
            case 260:
                cmp(r6, 0);
                if (bge(null, 56)) return;
            case 264:
                r3 = 0xc0800000;
                r4 = adds(r4, r3);
                r4 = orrs(r4, r5);
                if (bne(null, 282)) return;
            case 272:
                r1 = adds(r0, 0);
            case 274:
                lr = powf + 278 | 1;
                bl(this::__aeabi_fsub, 278);
                return;
            case 278:
                r1 = adds(r0, 0);
                b(null, 126);
                return;
            case 282:
                cmp(r5, 1);
                if (beq(null, 288)) return;
            case 286:
                b(null, 56);
                return;
            case 288:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 24);
                r0 = adds(r0, r3);
                b(null, 56);
                return;
            case 296:
                cmp(r6, 0);
                if (bge(null, 350)) return;
            case 300:
                cmp(r5, 0);
                if (bne(null, 310)) return;
            case 304:
                r1 = adds(r7, 0);
                r0 = adds(r7, 0);
                b(null, 274);
                return;
            case 310:
                cmp(r5, 1);
                if (bne(null, 350)) return;
            case 314:
                r3 = 0xbf800000;
            case 316:
                str(sp, r3);
                r3 = movs(r3, 154);
                r3 = lsls(r3, 23);
                cmp(r2, r3);
                if (bgt(null, 328)) return;
            case 326:
                b(null, 1028);
                return;
            case 328:
                r3 = 0x3f7ffff7;
                cmp(r4, r3);
                if (bgt(null, 356)) return;
            case 334:
                cmp(r1, 0);
                if (bge(null, 366)) return;
            case 338:
                r1 = 0x7149f2ca;
                r0 = ldr(sp);
                lr = powf + 346 | 1;
                bl(this::__aeabi_fmul, 346);
                return;
            case 346:
                r1 = 0x7149f2ca;
                b(null, 194);
                return;
            case 350:
                r3 = movs(r3, 254);
                r3 = lsls(r3, 22);
                b(null, 316);
                return;
            case 356:
                r3 = 0x3f800007;
                cmp(r4, r3);
                if (ble(null, 412)) return;
            case 362:
                cmp(r1, 0);
                if (bgt(null, 338)) return;
            case 366:
                r1 = 0x0da24260;
                r0 = ldr(sp);
                lr = powf + 374 | 1;
                bl(this::__aeabi_fmul, 374);
                return;
            case 374:
                r1 = 0x0da24260;
                b(null, 194);
                return;
            case 412:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = powf + 420 | 1;
                bl(this::__aeabi_fsub, 420);
                return;
            case 420:
                r1 = 0x3fb8aa00;
                r4 = adds(r0, 0);
                lr = powf + 428 | 1;
                bl(this::__aeabi_fmul, 428);
                return;
            case 428:
                r1 = 0x36eca570;
                r5 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = powf + 438 | 1;
                bl(this::__aeabi_fmul, 438);
                return;
            case 438:
                r1 = movs(r1, 250);
                r6 = adds(r0, 0);
                r1 = lsls(r1, 22);
                r0 = adds(r4, 0);
                lr = powf + 450 | 1;
                bl(this::__aeabi_fmul, 450);
                return;
            case 450:
                r1 = adds(r0, 0);
                r0 = 0x3eaaaaab;
                lr = powf + 458 | 1;
                bl(this::__aeabi_fsub, 458);
                return;
            case 458:
                r1 = adds(r4, 0);
                lr = powf + 464 | 1;
                bl(this::__aeabi_fmul, 464);
                return;
            case 464:
                r1 = adds(r0, 0);
                r0 = movs(r0, 252);
                r0 = lsls(r0, 22);
                lr = powf + 474 | 1;
                bl(this::__aeabi_fsub, 474);
                return;
            case 474:
                r1 = adds(r4, 0);
                r7 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = powf + 484 | 1;
                bl(this::__aeabi_fmul, 484);
                return;
            case 484:
                r1 = adds(r0, 0);
                r0 = adds(r7, 0);
                lr = powf + 492 | 1;
                bl(this::__aeabi_fmul, 492);
                return;
            case 492:
                r1 = 0x3fb8aa3b;
                lr = powf + 498 | 1;
                bl(this::__aeabi_fmul, 498);
                return;
            case 498:
                r1 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = powf + 506 | 1;
                bl(this::__aeabi_fsub, 506);
                return;
            case 506:
                r1 = adds(r0, 0);
                r6 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = powf + 516 | 1;
                bl(this::__aeabi_fadd, 516);
                return;
            case 516:
                r4 = lsrs(r0, 12);
                r4 = lsls(r4, 12);
                r1 = adds(r5, 0);
                r0 = adds(r4, 0);
                lr = powf + 528 | 1;
                bl(this::__aeabi_fsub, 528);
                return;
            case 528:
                r1 = adds(r0, 0);
                r0 = adds(r6, 0);
            case 532:
                lr = powf + 536 | 1;
                bl(this::__aeabi_fsub, 536);
                return;
            case 536:
                r3 = ldr(sp + 4);
                r6 = adds(r0, 0);
                r5 = lsrs(r3, 12);
                r5 = lsls(r5, 12);
                r1 = adds(r5, 0);
                r0 = ldr(sp + 4);
                lr = powf + 552 | 1;
                bl(this::__aeabi_fsub, 552);
                return;
            case 552:
                r1 = adds(r4, 0);
                lr = powf + 558 | 1;
                bl(this::__aeabi_fmul, 558);
                return;
            case 558:
                r1 = ldr(sp + 4);
                r7 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = powf + 568 | 1;
                bl(this::__aeabi_fmul, 568);
                return;
            case 568:
                r1 = adds(r0, 0);
                r0 = adds(r7, 0);
                lr = powf + 576 | 1;
                bl(this::__aeabi_fadd, 576);
                return;
            case 576:
                r1 = adds(r5, 0);
                r7 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = powf + 586 | 1;
                bl(this::__aeabi_fmul, 586);
                return;
            case 586:
                str(sp + 4, r0);
                r1 = adds(r0, 0);
                r6 = adds(r0, 0);
                r0 = adds(r7, 0);
                lr = powf + 598 | 1;
                bl(this::__aeabi_fadd, 598);
                return;
            case 598:
                r3 = movs(r3, 134);
                r5 = adds(r0, 0);
                str(sp + 8, r0);
                r3 = lsls(r3, 23);
                cmp(r0, r3);
                if (ble(null, 612)) return;
            case 610:
                b(null, 338);
                return;
            case 612:
                if (beq(null, 616)) return;
            case 614:
                b(null, 1566);
                return;
            case 616:
                r1 = 0x3338aa3c;
                r0 = adds(r7, 0);
                lr = powf + 624 | 1;
                bl(this::__aeabi_fadd, 624);
                return;
            case 624:
                r1 = adds(r6, 0);
                r4 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = powf + 634 | 1;
                bl(this::__aeabi_fsub, 634);
                return;
            case 634:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = powf + 642 | 1;
                bl(this::__aeabi_fcmpgt, 642);
                return;
            case 642:
                cmp(r0, 0);
                if (beq(null, 648)) return;
            case 646:
                b(null, 338);
                return;
            case 648:
                r2 = movs(r2, 252);
                r3 = lsls(r5, 1);
                r3 = lsrs(r3, 1);
                r2 = lsls(r2, 22);
                r4 = movs(r4, 0);
                cmp(r3, r2);
                if (ble(null, 718)) return;
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
                r2 = 0x007fffff;
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
                if (bge(null, 710)) return;
            case 708:
                r4 = rsbs(r4, 0);
            case 710:
                r0 = adds(r6, 0);
                lr = powf + 716 | 1;
                bl(this::__aeabi_fsub, 716);
                return;
            case 716:
                str(sp + 4, r0);
            case 718:
                r1 = adds(r7, 0);
                r0 = ldr(sp + 4);
                lr = powf + 726 | 1;
                bl(this::__aeabi_fadd, 726);
                return;
            case 726:
                r5 = lsrs(r0, 15);
                r5 = lsls(r5, 15);
                r1 = 0x3f317200;
                r0 = adds(r5, 0);
                lr = powf + 738 | 1;
                bl(this::__aeabi_fmul, 738);
                return;
            case 738:
                r1 = ldr(sp + 4);
                r6 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = powf + 748 | 1;
                bl(this::__aeabi_fsub, 748);
                return;
            case 748:
                r1 = adds(r0, 0);
                r0 = adds(r7, 0);
                lr = powf + 756 | 1;
                bl(this::__aeabi_fsub, 756);
                return;
            case 756:
                r1 = 0x3f317218;
                lr = powf + 762 | 1;
                bl(this::__aeabi_fmul, 762);
                return;
            case 762:
                r1 = 0x35bfbe8c;
                r7 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = powf + 772 | 1;
                bl(this::__aeabi_fmul, 772);
                return;
            case 772:
                r1 = adds(r0, 0);
                r0 = adds(r7, 0);
                lr = powf + 780 | 1;
                bl(this::__aeabi_fadd, 780);
                return;
            case 780:
                r7 = adds(r0, 0);
                r1 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = powf + 790 | 1;
                bl(this::__aeabi_fadd, 790);
                return;
            case 790:
                r1 = adds(r6, 0);
                r5 = adds(r0, 0);
                lr = powf + 798 | 1;
                bl(this::__aeabi_fsub, 798);
                return;
            case 798:
                r1 = adds(r0, 0);
                r0 = adds(r7, 0);
                lr = powf + 806 | 1;
                bl(this::__aeabi_fsub, 806);
                return;
            case 806:
                r1 = adds(r5, 0);
                r6 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = powf + 816 | 1;
                bl(this::__aeabi_fmul, 816);
                return;
            case 816:
                r1 = 0x3331bb4c;
                r7 = adds(r0, 0);
                lr = powf + 824 | 1;
                bl(this::__aeabi_fmul, 824);
                return;
            case 824:
                r1 = 0x35ddea0e;
                lr = powf + 830 | 1;
                bl(this::__aeabi_fsub, 830);
                return;
            case 830:
                r1 = adds(r7, 0);
                lr = powf + 836 | 1;
                bl(this::__aeabi_fmul, 836);
                return;
            case 836:
                r1 = 0x388ab355;
                lr = powf + 842 | 1;
                bl(this::__aeabi_fadd, 842);
                return;
            case 842:
                r1 = adds(r7, 0);
                lr = powf + 848 | 1;
                bl(this::__aeabi_fmul, 848);
                return;
            case 848:
                r1 = 0x3b360b61;
                lr = powf + 854 | 1;
                bl(this::__aeabi_fsub, 854);
                return;
            case 854:
                r1 = adds(r7, 0);
                lr = powf + 860 | 1;
                bl(this::__aeabi_fmul, 860);
                return;
            case 860:
                r1 = 0x3e2aaaab;
                lr = powf + 866 | 1;
                bl(this::__aeabi_fadd, 866);
                return;
            case 866:
                r1 = adds(r7, 0);
                lr = powf + 872 | 1;
                bl(this::__aeabi_fmul, 872);
                return;
            case 872:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = powf + 880 | 1;
                bl(this::__aeabi_fsub, 880);
                return;
            case 880:
                r7 = adds(r0, 0);
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = powf + 890 | 1;
                bl(this::__aeabi_fmul, 890);
                return;
            case 890:
                r1 = movs(r1, 128);
                str(sp + 4, r0);
                r1 = lsls(r1, 23);
                r0 = adds(r7, 0);
                lr = powf + 902 | 1;
                bl(this::__aeabi_fsub, 902);
                return;
            case 902:
                r1 = adds(r0, 0);
                r0 = ldr(sp + 4);
                lr = powf + 910 | 1;
                bl(this::__aeabi_fdiv, 910);
                return;
            case 910:
                r1 = adds(r6, 0);
                r7 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = powf + 920 | 1;
                bl(this::__aeabi_fmul, 920);
                return;
            case 920:
                r1 = adds(r6, 0);
                lr = powf + 926 | 1;
                bl(this::__aeabi_fadd, 926);
                return;
            case 926:
                r1 = adds(r0, 0);
                r0 = adds(r7, 0);
                lr = powf + 934 | 1;
                bl(this::__aeabi_fsub, 934);
                return;
            case 934:
                r1 = adds(r5, 0);
                lr = powf + 940 | 1;
                bl(this::__aeabi_fsub, 940);
                return;
            case 940:
                r1 = adds(r0, 0);
                r0 = movs(r0, 254);
                r0 = lsls(r0, 22);
                lr = powf + 950 | 1;
                bl(this::__aeabi_fsub, 950);
                return;
            case 950:
                r3 = lsls(r4, 23);
                r3 = adds(r3, r0);
                r2 = asrs(r3, 23);
                cmp(r2, 0);
                if (ble(null, 962)) return;
            case 960:
                b(null, 1606);
                return;
            case 962:
                r1 = movs(r1, r4);
                lr = powf + 968 | 1;
                bl(this::scalbnf, 968);
                return;
            case 968:
                r1 = ldr(sp);
                b(null, 194);
                return;
            case 1028:
                r3 = 0x007fffff;
                r2 = movs(r2, 0);
                cmp(r4, r3);
                if (bgt(null, 1050)) return;
            case 1036:
                r1 = movs(r1, 151);
                r1 = lsls(r1, 23);
                lr = powf + 1044 | 1;
                bl(this::__aeabi_fmul, 1044);
                return;
            case 1044:
                r2 = movs(r2, 24);
                r4 = movs(r4, r0);
                r2 = rsbs(r2, 0);
            case 1050:
                r3 = asrs(r4, 23);
                r0 = lsls(r4, 9);
                r4 = movs(r4, 254);
                r3 = subs(r3, 127);
                r3 = adds(r3, r2);
                str(sp + 12, r3);
                r3 = 0x001cc471;
                r0 = lsrs(r0, 9);
                r4 = lsls(r4, 22);
                r4 = orrs(r4, r0);
                r5 = movs(r5, 0);
                cmp(r0, r3);
                if (ble(null, 1096)) return;
            case 1076:
                r3 = 0x005db3d6;
                r5 = adds(r5, 1);
                cmp(r0, r3);
                if (ble(null, 1096)) return;
            case 1084:
                r3 = ldr(sp + 12);
                r3 = adds(r3, r5);
                r5 = movs(r5, 0);
                str(sp + 12, r3);
                r3 = 0xff800000;
                r4 = adds(r4, r3);
            case 1096:
                r3 = lsls(r5, 2);
                str(sp + 16, r3);
                r3 = rodata_bp;
                r2 = lsls(r5, 2);
                r7 = ldr(r2 + r3);
                r0 = adds(r4, 0);
                r1 = adds(r7, 0);
                str(sp + 28, r4);
                lr = powf + 1116 | 1;
                bl(this::__aeabi_fsub, 1116);
                return;
            case 1116:
                r1 = adds(r4, 0);
                str(sp + 20, r0);
                r0 = adds(r7, 0);
                lr = powf + 1126 | 1;
                bl(this::__aeabi_fadd, 1126);
                return;
            case 1126:
                r1 = adds(r0, 0);
                r0 = movs(r0, 254);
                r0 = lsls(r0, 22);
                lr = powf + 1136 | 1;
                bl(this::__aeabi_fdiv, 1136);
                return;
            case 1136:
                r1 = adds(r0, 0);
                str(sp + 24, r0);
                r0 = ldr(sp + 20);
                lr = powf + 1146 | 1;
                bl(this::__aeabi_fmul, 1146);
                return;
            case 1146:
                str(sp + 8, r0);
                r3 = ldr(sp + 8);
                r4 = asrs(r4, 1);
                r6 = lsrs(r3, 12);
                r3 = 0xdffff000;
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
                lr = powf + 1184 | 1;
                bl(this::__aeabi_fmul, 1184);
                return;
            case 1184:
                r1 = adds(r0, 0);
                r0 = ldr(sp + 20);
                lr = powf + 1192 | 1;
                bl(this::__aeabi_fsub, 1192);
                return;
            case 1192:
                r1 = adds(r7, 0);
                r4 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = powf + 1202 | 1;
                bl(this::__aeabi_fsub, 1202);
                return;
            case 1202:
                r1 = adds(r0, 0);
                r0 = ldr(sp + 28);
                lr = powf + 1210 | 1;
                bl(this::__aeabi_fsub, 1210);
                return;
            case 1210:
                r1 = adds(r6, 0);
                lr = powf + 1216 | 1;
                bl(this::__aeabi_fmul, 1216);
                return;
            case 1216:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = powf + 1224 | 1;
                bl(this::__aeabi_fsub, 1224);
                return;
            case 1224:
                r1 = ldr(sp + 24);
                lr = powf + 1230 | 1;
                bl(this::__aeabi_fmul, 1230);
                return;
            case 1230:
                r1 = ldr(sp + 8);
                str(sp + 20, r0);
                r0 = adds(r1, 0);
                lr = powf + 1240 | 1;
                bl(this::__aeabi_fmul, 1240);
                return;
            case 1240:
                r1 = 0x3e53f142;
                r4 = adds(r0, 0);
                lr = powf + 1248 | 1;
                bl(this::__aeabi_fmul, 1248);
                return;
            case 1248:
                r1 = 0x3e6c3255;
                lr = powf + 1254 | 1;
                bl(this::__aeabi_fadd, 1254);
                return;
            case 1254:
                r1 = adds(r4, 0);
                lr = powf + 1260 | 1;
                bl(this::__aeabi_fmul, 1260);
                return;
            case 1260:
                r1 = 0x3e8ba305;
                lr = powf + 1266 | 1;
                bl(this::__aeabi_fadd, 1266);
                return;
            case 1266:
                r1 = adds(r4, 0);
                lr = powf + 1272 | 1;
                bl(this::__aeabi_fmul, 1272);
                return;
            case 1272:
                r1 = 0x3eaaaaab;
                lr = powf + 1278 | 1;
                bl(this::__aeabi_fadd, 1278);
                return;
            case 1278:
                r1 = adds(r4, 0);
                lr = powf + 1284 | 1;
                bl(this::__aeabi_fmul, 1284);
                return;
            case 1284:
                r1 = 0x3edb6db7;
                lr = powf + 1290 | 1;
                bl(this::__aeabi_fadd, 1290);
                return;
            case 1290:
                r1 = adds(r4, 0);
                lr = powf + 1296 | 1;
                bl(this::__aeabi_fmul, 1296);
                return;
            case 1296:
                r1 = 0x3f19999a;
                lr = powf + 1302 | 1;
                bl(this::__aeabi_fadd, 1302);
                return;
            case 1302:
                r1 = adds(r4, 0);
                r5 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = powf + 1312 | 1;
                bl(this::__aeabi_fmul, 1312);
                return;
            case 1312:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = powf + 1320 | 1;
                bl(this::__aeabi_fmul, 1320);
                return;
            case 1320:
                r1 = ldr(sp + 8);
                r4 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = powf + 1330 | 1;
                bl(this::__aeabi_fadd, 1330);
                return;
            case 1330:
                r1 = ldr(sp + 20);
                lr = powf + 1336 | 1;
                bl(this::__aeabi_fmul, 1336);
                return;
            case 1336:
                r1 = adds(r4, 0);
                lr = powf + 1342 | 1;
                bl(this::__aeabi_fadd, 1342);
                return;
            case 1342:
                r1 = adds(r6, 0);
                str(sp + 24, r0);
                r0 = adds(r6, 0);
                lr = powf + 1352 | 1;
                bl(this::__aeabi_fmul, 1352);
                return;
            case 1352:
                r1 = 0x40400000;
                r7 = adds(r0, 0);
                lr = powf + 1360 | 1;
                bl(this::__aeabi_fadd, 1360);
                return;
            case 1360:
                r1 = ldr(sp + 24);
                lr = powf + 1366 | 1;
                bl(this::__aeabi_fadd, 1366);
                return;
            case 1366:
                r4 = lsrs(r0, 12);
                r4 = lsls(r4, 12);
                r1 = adds(r4, 0);
                r0 = adds(r6, 0);
                lr = powf + 1378 | 1;
                bl(this::__aeabi_fmul, 1378);
                return;
            case 1378:
                r1 = 0x40400000;
                r5 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = powf + 1388 | 1;
                bl(this::__aeabi_fsub, 1388);
                return;
            case 1388:
                r1 = adds(r7, 0);
                lr = powf + 1394 | 1;
                bl(this::__aeabi_fsub, 1394);
                return;
            case 1394:
                r1 = adds(r0, 0);
                r0 = ldr(sp + 24);
                lr = powf + 1402 | 1;
                bl(this::__aeabi_fsub, 1402);
                return;
            case 1402:
                r1 = ldr(sp + 8);
                lr = powf + 1408 | 1;
                bl(this::__aeabi_fmul, 1408);
                return;
            case 1408:
                r1 = ldr(sp + 20);
                r6 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = powf + 1418 | 1;
                bl(this::__aeabi_fmul, 1418);
                return;
            case 1418:
                r1 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = powf + 1426 | 1;
                bl(this::__aeabi_fadd, 1426);
                return;
            case 1426:
                r6 = adds(r0, 0);
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = powf + 1436 | 1;
                bl(this::__aeabi_fadd, 1436);
                return;
            case 1436:
                r4 = lsrs(r0, 12);
                r4 = lsls(r4, 12);
                r1 = 0x3f764000;
                r0 = adds(r4, 0);
                lr = powf + 1448 | 1;
                bl(this::__aeabi_fmul, 1448);
                return;
            case 1448:
                r1 = adds(r5, 0);
                str(sp + 8, r0);
                r0 = adds(r4, 0);
                lr = powf + 1458 | 1;
                bl(this::__aeabi_fsub, 1458);
                return;
            case 1458:
                r1 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = powf + 1466 | 1;
                bl(this::__aeabi_fsub, 1466);
                return;
            case 1466:
                r1 = 0x3f76384f;
                lr = powf + 1472 | 1;
                bl(this::__aeabi_fmul, 1472);
                return;
            case 1472:
                r1 = 0xb8f623c6;
                r5 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = powf + 1482 | 1;
                bl(this::__aeabi_fmul, 1482);
                return;
            case 1482:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = powf + 1490 | 1;
                bl(this::__aeabi_fadd, 1490);
                return;
            case 1490:
                r2 = ldr(sp + 16);
                r3 = rodata_dp_l;
                r1 = ldr(r2 + r3);
                lr = powf + 1500 | 1;
                bl(this::__aeabi_fadd, 1500);
                return;
            case 1500:
                r5 = adds(r0, 0);
                r0 = ldr(sp + 12);
                lr = powf + 1508 | 1;
                bl(this::__aeabi_i2f, 1508);
                return;
            case 1508:
                r3 = rodata_dp_h;
                r2 = ldr(sp + 16);
                r7 = adds(r0, 0);
                r6 = ldr(r2 + r3);
                r1 = adds(r5, 0);
                r0 = ldr(sp + 8);
                lr = powf + 1524 | 1;
                bl(this::__aeabi_fadd, 1524);
                return;
            case 1524:
                r1 = adds(r6, 0);
                lr = powf + 1530 | 1;
                bl(this::__aeabi_fadd, 1530);
                return;
            case 1530:
                r1 = adds(r7, 0);
                lr = powf + 1536 | 1;
                bl(this::__aeabi_fadd, 1536);
                return;
            case 1536:
                r4 = lsrs(r0, 12);
                r4 = lsls(r4, 12);
                r1 = adds(r7, 0);
                r0 = adds(r4, 0);
                lr = powf + 1548 | 1;
                bl(this::__aeabi_fsub, 1548);
                return;
            case 1548:
                r1 = adds(r6, 0);
                lr = powf + 1554 | 1;
                bl(this::__aeabi_fsub, 1554);
                return;
            case 1554:
                r1 = ldr(sp + 8);
                lr = powf + 1560 | 1;
                bl(this::__aeabi_fsub, 1560);
                return;
            case 1560:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                b(null, 532);
                return;
            case 1566:
                r2 = 0x43160000;
                r3 = lsls(r0, 1);
                r3 = lsrs(r3, 1);
                cmp(r3, r2);
                if (ble(null, 1578)) return;
            case 1576:
                b(null, 366);
                return;
            case 1578:
                r3 = 0xc3160000;
                cmp(r0, r3);
                if (beq(null, 1586)) return;
            case 1584:
                b(null, 648);
                return;
            case 1586:
                r1 = adds(r6, 0);
                lr = powf + 1592 | 1;
                bl(this::__aeabi_fsub, 1592);
                return;
            case 1592:
                r1 = adds(r7, 0);
                lr = powf + 1598 | 1;
                bl(this::__aeabi_fcmpge, 1598);
                return;
            case 1598:
                cmp(r0, 0);
                if (bne(null, 1604)) return;
            case 1602:
                b(null, 648);
                return;
            case 1604:
                b(null, 366);
                return;
            case 1606:
                r0 = adds(r3, 0);
                b(null, 968);
                return;
            case 1610:
                r0 = movs(r0, 254);
                r0 = lsls(r0, 22);
                b(null, 56);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134328756, size=344, name='expf', path='build/lib/libm/math.o', has_indirect=True)
    protected void expf(int offset) throws Exception
    {
        pc = expf + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r3 = 0x42aeac4f;
                r6 = lsls(r0, 1);
                sp = sub(sp, 20);
                r4 = adds(r0, 0);
                r7 = lsrs(r0, 31);
                r6 = lsrs(r6, 1);
                cmp(r6, r3);
                if (bls(null, 80)) return;
            case 18:
                r3 = 0x42b17217;
                cmp(r6, r3);
                if (bls(null, 40)) return;
            case 24:
                cmp(r7, 0);
                if (bne(null, 58)) return;
            case 28:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 23);
                lr = expf + 36 | 1;
                bl(this::__aeabi_fmul, 36);
                return;
            case 36:
                sp = add(sp, 20);
                pop(true, R4, R5, R6, R7);
                return;
            case 40:
                cmp(r7, 0);
                if (bne(null, 58)) return;
            case 44:
                r3 = 0x3f851592;
                cmp(r6, r3);
                if (bhi(null, 118)) return;
            case 50:
                r5 = movs(r5, 1);
                r5 = subs(r5, r7);
                r5 = subs(r5, r7);
                b(null, 142);
                return;
            case 58:
                r1 = adds(r4, 0);
                r0 = 0x80000001;
                lr = expf + 66 | 1;
                bl(this::__aeabi_fdiv, 66);
                return;
            case 66:
                str(sp + 8, r0);
                r3 = ldr(sp + 8);
                r3 = 0x42cff1b4;
                cmp(r6, r3);
                if (bls(null, 44)) return;
            case 76:
                r0 = movs(r0, 0);
                b(null, 36);
                return;
            case 80:
                r3 = 0x3eb17218;
                cmp(r6, r3);
                if (bhi(null, 44)) return;
            case 86:
                r3 = movs(r3, 228);
                r3 = lsls(r3, 22);
                cmp(r6, r3);
                if (bhi(null, 286)) return;
            case 94:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 23);
                lr = expf + 102 | 1;
                bl(this::__aeabi_fadd, 102);
                return;
            case 102:
                r1 = movs(r1, 254);
                str(sp + 12, r0);
                r1 = lsls(r1, 22);
                r0 = adds(r4, 0);
                r3 = ldr(sp + 12);
                lr = expf + 116 | 1;
                bl(this::__aeabi_fadd, 116);
                return;
            case 116:
                b(null, 36);
                return;
            case 118:
                r1 = 0x3fb8aa3b;
                r0 = adds(r4, 0);
                lr = expf + 126 | 1;
                bl(this::__aeabi_fmul, 126);
                return;
            case 126:
                r3 = rodata_half;
                r7 = lsls(r7, 2);
                r1 = ldr(r7 + r3);
                lr = expf + 136 | 1;
                bl(this::__aeabi_fadd, 136);
                return;
            case 136:
                lr = expf + 140 | 1;
                bl(this::__aeabi_f2iz, 140);
                return;
            case 140:
                r5 = movs(r5, r0);
            case 142:
                r0 = movs(r0, r5);
                lr = expf + 148 | 1;
                bl(this::__aeabi_i2f, 148);
                return;
            case 148:
                r1 = 0x3f317200;
                r7 = adds(r0, 0);
                lr = expf + 156 | 1;
                bl(this::__aeabi_fmul, 156);
                return;
            case 156:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = expf + 164 | 1;
                bl(this::__aeabi_fsub, 164);
                return;
            case 164:
                r1 = 0x35bfbe8e;
                r6 = adds(r0, 0);
                r0 = adds(r7, 0);
                lr = expf + 174 | 1;
                bl(this::__aeabi_fmul, 174);
                return;
            case 174:
                r1 = adds(r0, 0);
                r7 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = expf + 184 | 1;
                bl(this::__aeabi_fsub, 184);
                return;
            case 184:
                r4 = adds(r0, 0);
            case 186:
                r1 = adds(r4, 0);
                r0 = adds(r4, 0);
                lr = expf + 194 | 1;
                bl(this::__aeabi_fmul, 194);
                return;
            case 194:
                r1 = 0xbb355215;
                str(sp + 4, r0);
                lr = expf + 202 | 1;
                bl(this::__aeabi_fmul, 202);
                return;
            case 202:
                r1 = 0x3e2aaa8f;
                lr = expf + 208 | 1;
                bl(this::__aeabi_fadd, 208);
                return;
            case 208:
                r1 = ldr(sp + 4);
                lr = expf + 214 | 1;
                bl(this::__aeabi_fmul, 214);
                return;
            case 214:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = expf + 222 | 1;
                bl(this::__aeabi_fsub, 222);
                return;
            case 222:
                r1 = adds(r0, 0);
                str(sp + 4, r0);
                r0 = adds(r4, 0);
                lr = expf + 232 | 1;
                bl(this::__aeabi_fmul, 232);
                return;
            case 232:
                r4 = adds(r0, 0);
                r0 = movs(r0, 128);
                r1 = ldr(sp + 4);
                r0 = lsls(r0, 23);
                lr = expf + 244 | 1;
                bl(this::__aeabi_fsub, 244);
                return;
            case 244:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = expf + 252 | 1;
                bl(this::__aeabi_fdiv, 252);
                return;
            case 252:
                r1 = adds(r7, 0);
                lr = expf + 258 | 1;
                bl(this::__aeabi_fsub, 258);
                return;
            case 258:
                r1 = adds(r6, 0);
                lr = expf + 264 | 1;
                bl(this::__aeabi_fadd, 264);
                return;
            case 264:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = expf + 272 | 1;
                bl(this::__aeabi_fadd, 272);
                return;
            case 272:
                cmp(r5, 0);
                if (bne(null, 278)) return;
            case 276:
                b(null, 36);
                return;
            case 278:
                r1 = movs(r1, r5);
                lr = expf + 284 | 1;
                bl(this::scalbnf, 284);
                return;
            case 284:
                b(null, 36);
                return;
            case 286:
                r6 = adds(r0, 0);
                r5 = movs(r5, 0);
                r7 = movs(r7, 0);
                b(null, 186);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134329100, size=664, name='expm1f', path='build/lib/libm/math.o', has_indirect=True)
    protected void expm1f(int offset) throws Exception
    {
        pc = expm1f + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r2 = 0x4195b843;
                r3 = lsls(r0, 1);
                sp = sub(sp, 20);
                r4 = adds(r0, 0);
                r3 = lsrs(r3, 1);
                r5 = lsrs(r0, 31);
                cmp(r3, r2);
                if (bls(null, 56)) return;
            case 18:
                r2 = movs(r2, 255);
                r2 = lsls(r2, 23);
                cmp(r3, r2);
                if (bls(null, 28)) return;
            case 26:
                b(null, 350);
                return;
            case 28:
                cmp(r5, 0);
                if (beq(null, 34)) return;
            case 32:
                b(null, 594);
                return;
            case 34:
                r1 = 0x42b17180;
                lr = expm1f + 40 | 1;
                bl(this::__aeabi_fcmpgt, 40);
                return;
            case 40:
                cmp(r0, 0);
                if (beq(null, 262)) return;
            case 44:
                r1 = movs(r1, 254);
                r0 = adds(r4, 0);
                r1 = lsls(r1, 23);
            case 50:
                lr = expm1f + 54 | 1;
                bl(this::__aeabi_fmul, 54);
                return;
            case 54:
                b(null, 474);
                return;
            case 56:
                r2 = 0x3eb17218;
                cmp(r3, r2);
                if (bhi(null, 64)) return;
            case 62:
                b(null, 328);
                return;
            case 64:
                r2 = 0x3f851591;
                cmp(r3, r2);
                if (bhi(null, 262)) return;
            case 70:
                r1 = 0x3f317180;
                cmp(r5, 0);
                if (bne(null, 248)) return;
            case 76:
                lr = expm1f + 80 | 1;
                bl(this::__aeabi_fsub, 80);
                return;
            case 80:
                r6 = 0x3717f7d1;
                r7 = adds(r0, 0);
                r5 = adds(r5, 1);
            case 86:
                r1 = adds(r6, 0);
                r0 = adds(r7, 0);
                lr = expm1f + 94 | 1;
                bl(this::__aeabi_fsub, 94);
                return;
            case 94:
                r1 = adds(r0, 0);
                r4 = adds(r0, 0);
                r0 = adds(r7, 0);
                lr = expm1f + 104 | 1;
                bl(this::__aeabi_fsub, 104);
                return;
            case 104:
                r1 = adds(r6, 0);
                lr = expm1f + 110 | 1;
                bl(this::__aeabi_fsub, 110);
                return;
            case 110:
                str(sp, r0);
            case 112:
                r1 = movs(r1, 252);
                r0 = adds(r4, 0);
                r1 = lsls(r1, 22);
                lr = expm1f + 122 | 1;
                bl(this::__aeabi_fmul, 122);
                return;
            case 122:
                r7 = adds(r0, 0);
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = expm1f + 132 | 1;
                bl(this::__aeabi_fmul, 132);
                return;
            case 132:
                r1 = 0x3acf3010;
                r6 = adds(r0, 0);
                lr = expm1f + 140 | 1;
                bl(this::__aeabi_fmul, 140);
                return;
            case 140:
                r1 = 0x3d088868;
                lr = expm1f + 146 | 1;
                bl(this::__aeabi_fsub, 146);
                return;
            case 146:
                r1 = adds(r6, 0);
                lr = expm1f + 152 | 1;
                bl(this::__aeabi_fmul, 152);
                return;
            case 152:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = expm1f + 160 | 1;
                bl(this::__aeabi_fadd, 160);
                return;
            case 160:
                r1 = adds(r0, 0);
                str(sp + 4, r0);
                r0 = adds(r7, 0);
                lr = expm1f + 170 | 1;
                bl(this::__aeabi_fmul, 170);
                return;
            case 170:
                r1 = adds(r0, 0);
                r0 = 0x40400000;
                lr = expm1f + 178 | 1;
                bl(this::__aeabi_fsub, 178);
                return;
            case 178:
                r1 = adds(r0, 0);
                r7 = adds(r0, 0);
                r0 = ldr(sp + 4);
                lr = expm1f + 188 | 1;
                bl(this::__aeabi_fsub, 188);
                return;
            case 188:
                r1 = adds(r7, 0);
                str(sp + 4, r0);
                r0 = adds(r4, 0);
                lr = expm1f + 198 | 1;
                bl(this::__aeabi_fmul, 198);
                return;
            case 198:
                r1 = adds(r0, 0);
                r0 = 0x40c00000;
                lr = expm1f + 206 | 1;
                bl(this::__aeabi_fsub, 206);
                return;
            case 206:
                r1 = adds(r0, 0);
                r0 = ldr(sp + 4);
                lr = expm1f + 214 | 1;
                bl(this::__aeabi_fdiv, 214);
                return;
            case 214:
                r1 = adds(r6, 0);
                lr = expm1f + 220 | 1;
                bl(this::__aeabi_fmul, 220);
                return;
            case 220:
                cmp(r5, 0);
                if (bne(null, 360)) return;
            case 224:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = expm1f + 232 | 1;
                bl(this::__aeabi_fmul, 232);
                return;
            case 232:
                r1 = adds(r6, 0);
                lr = expm1f + 238 | 1;
                bl(this::__aeabi_fsub, 238);
                return;
            case 238:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
            case 242:
                lr = expm1f + 246 | 1;
                bl(this::__aeabi_fsub, 246);
                return;
            case 246:
                b(null, 474);
                return;
            case 248:
                lr = expm1f + 252 | 1;
                bl(this::__aeabi_fadd, 252);
                return;
            case 252:
                r5 = movs(r5, 1);
                r7 = adds(r0, 0);
                r5 = rsbs(r5, 0);
                r6 = 0xb717f7d1;
                b(null, 86);
                return;
            case 262:
                r1 = 0x3fb8aa3b;
                r0 = adds(r4, 0);
                lr = expm1f + 270 | 1;
                bl(this::__aeabi_fmul, 270);
                return;
            case 270:
                cmp(r5, 0);
                if (bne(null, 322)) return;
            case 274:
                r1 = movs(r1, 252);
                r1 = lsls(r1, 22);
            case 278:
                lr = expm1f + 282 | 1;
                bl(this::__aeabi_fadd, 282);
                return;
            case 282:
                lr = expm1f + 286 | 1;
                bl(this::__aeabi_f2iz, 286);
                return;
            case 286:
                r5 = movs(r5, r0);
                lr = expm1f + 292 | 1;
                bl(this::__aeabi_i2f, 292);
                return;
            case 292:
                r1 = 0x3f317180;
                r6 = adds(r0, 0);
                lr = expm1f + 300 | 1;
                bl(this::__aeabi_fmul, 300);
                return;
            case 300:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = expm1f + 308 | 1;
                bl(this::__aeabi_fsub, 308);
                return;
            case 308:
                r1 = 0x3717f7d1;
                r7 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = expm1f + 318 | 1;
                bl(this::__aeabi_fmul, 318);
                return;
            case 318:
                r6 = adds(r0, 0);
                b(null, 86);
                return;
            case 322:
                r1 = movs(r1, 191);
                r1 = lsls(r1, 24);
                b(null, 278);
                return;
            case 328:
                r2 = 0x32ffffff;
                cmp(r3, r2);
                if (bhi(null, 356)) return;
            case 334:
                r2 = 0x007fffff;
                cmp(r3, r2);
                if (bhi(null, 350)) return;
            case 340:
                r1 = adds(r0, 0);
                lr = expm1f + 346 | 1;
                bl(this::__aeabi_fmul, 346);
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
                b(null, 112);
                return;
            case 360:
                r1 = ldr(sp);
                lr = expm1f + 366 | 1;
                bl(this::__aeabi_fsub, 366);
                return;
            case 366:
                r1 = adds(r4, 0);
                lr = expm1f + 372 | 1;
                bl(this::__aeabi_fmul, 372);
                return;
            case 372:
                r1 = ldr(sp);
                lr = expm1f + 378 | 1;
                bl(this::__aeabi_fsub, 378);
                return;
            case 378:
                r1 = adds(r6, 0);
                lr = expm1f + 384 | 1;
                bl(this::__aeabi_fsub, 384);
                return;
            case 384:
                r6 = adds(r0, 0);
                r3 = adds(r5, 1);
                if (bne(null, 412)) return;
            case 390:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = expm1f + 398 | 1;
                bl(this::__aeabi_fsub, 398);
                return;
            case 398:
                r1 = movs(r1, 252);
                r1 = lsls(r1, 22);
                lr = expm1f + 406 | 1;
                bl(this::__aeabi_fmul, 406);
                return;
            case 406:
                r1 = movs(r1, 252);
            case 408:
                r1 = lsls(r1, 22);
                b(null, 242);
                return;
            case 412:
                cmp(r5, 1);
                if (bne(null, 478)) return;
            case 416:
                r1 = 0xbe800000;
                r0 = adds(r4, 0);
                lr = expm1f + 424 | 1;
                bl(this::__aeabi_fcmplt, 424);
                return;
            case 424:
                cmp(r0, 0);
                if (beq(null, 452)) return;
            case 428:
                r1 = movs(r1, 252);
                r0 = adds(r4, 0);
                r1 = lsls(r1, 22);
                lr = expm1f + 438 | 1;
                bl(this::__aeabi_fadd, 438);
                return;
            case 438:
                r1 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = expm1f + 446 | 1;
                bl(this::__aeabi_fsub, 446);
                return;
            case 446:
                r1 = movs(r1, 192);
                r1 = lsls(r1, 24);
                b(null, 50);
                return;
            case 452:
                r1 = adds(r6, 0);
                r0 = adds(r4, 0);
                lr = expm1f + 460 | 1;
                bl(this::__aeabi_fsub, 460);
                return;
            case 460:
                r1 = adds(r0, 0);
                lr = expm1f + 466 | 1;
                bl(this::__aeabi_fadd, 466);
                return;
            case 466:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = expm1f + 474 | 1;
                bl(this::__aeabi_fadd, 474);
                return;
            case 474:
                r4 = adds(r0, 0);
                b(null, 350);
                return;
            case 478:
                r7 = movs(r7, r5);
                r7 = adds(r7, 127);
                r7 = lsls(r7, 23);
                cmp(r5, 56);
                if (bls(null, 530)) return;
            case 488:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = expm1f + 496 | 1;
                bl(this::__aeabi_fsub, 496);
                return;
            case 496:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = expm1f + 504 | 1;
                bl(this::__aeabi_fadd, 504);
                return;
            case 504:
                r1 = adds(r0, 0);
                cmp(r5, 128);
                if (bne(null, 526)) return;
            case 510:
                lr = expm1f + 514 | 1;
                bl(this::__aeabi_fadd, 514);
                return;
            case 514:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 23);
            case 518:
                lr = expm1f + 522 | 1;
                bl(this::__aeabi_fmul, 522);
                return;
            case 522:
                r1 = movs(r1, 254);
                b(null, 408);
                return;
            case 526:
                r0 = adds(r7, 0);
                b(null, 518);
                return;
            case 530:
                r3 = movs(r3, 127);
                r3 = subs(r3, r5);
                r3 = lsls(r3, 23);
                str(sp, r3);
                r1 = adds(r0, 0);
                cmp(r5, 22);
                if (bgt(null, 574)) return;
            case 544:
                r0 = adds(r4, 0);
                lr = expm1f + 550 | 1;
                bl(this::__aeabi_fsub, 550);
                return;
            case 550:
                r4 = adds(r0, 0);
                r0 = movs(r0, 254);
                r1 = ldr(sp);
                r0 = lsls(r0, 22);
                lr = expm1f + 562 | 1;
                bl(this::__aeabi_fsub, 562);
                return;
            case 562:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
            case 566:
                lr = expm1f + 570 | 1;
                bl(this::__aeabi_fadd, 570);
                return;
            case 570:
                r1 = adds(r7, 0);
                b(null, 50);
                return;
            case 574:
                r0 = ldr(sp);
                lr = expm1f + 580 | 1;
                bl(this::__aeabi_fadd, 580);
                return;
            case 580:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = expm1f + 588 | 1;
                bl(this::__aeabi_fsub, 588);
                return;
            case 588:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                b(null, 566);
                return;
            case 594:
                r4 = 0xbf800000;
                b(null, 350);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134329764, size=36, name='__expo2f', path='build/lib/libm/math.o', has_indirect=False)
    protected void __expo2f(int offset) throws Exception
    {
        pc = __expo2f + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r1 = 0x4322e3bc;
                lr = __expo2f + 8 | 1;
                bl(this::__aeabi_fsub, 8);
                return;
            case 8:
                lr = __expo2f + 12 | 1;
                bl(this::expf, 12);
                return;
            case 12:
                r1 = movs(r1, 244);
                r1 = lsls(r1, 23);
                lr = __expo2f + 20 | 1;
                bl(this::__aeabi_fmul, 20);
                return;
            case 20:
                r1 = movs(r1, 244);
                r1 = lsls(r1, 23);
                lr = __expo2f + 28 | 1;
                bl(this::__aeabi_fmul, 28);
                return;
            case 28:
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134329800, size=340, name='logf', path='build/lib/libm/math.o', has_indirect=False)
    protected void logf(int offset) throws Exception
    {
        pc = logf + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r2 = 0xff800000;
                sp = sub(sp, 20);
                r1 = adds(r0, r2);
                r2 = 0x7f7fffff;
                r3 = movs(r3, r0);
                cmp(r1, r2);
                if (bhi(null, 18)) return;
            case 16:
                b(null, 274);
                return;
            case 18:
                r2 = lsls(r0, 1);
                if (bne(null, 40)) return;
            case 22:
                r1 = adds(r0, 0);
                lr = logf + 28 | 1;
                bl(this::__aeabi_fmul, 28);
                return;
            case 28:
                r1 = adds(r0, 0);
                r0 = 0xbf800000;
            case 32:
                lr = logf + 36 | 1;
                bl(this::__aeabi_fdiv, 36);
                return;
            case 36:
                sp = add(sp, 20);
                pop(true, R4, R5, R6, R7);
                return;
            case 40:
                cmp(r0, 0);
                if (bge(null, 54)) return;
            case 44:
                r1 = adds(r0, 0);
                lr = logf + 50 | 1;
                bl(this::__aeabi_fsub, 50);
                return;
            case 50:
                r1 = movs(r1, 0);
                b(null, 32);
                return;
            case 54:
                r1 = movs(r1, 152);
                r1 = lsls(r1, 23);
                lr = logf + 62 | 1;
                bl(this::__aeabi_fmul, 62);
                return;
            case 62:
                r2 = movs(r2, 25);
                r3 = movs(r3, r0);
                r2 = rsbs(r2, 0);
            case 68:
                r1 = movs(r1, 254);
                str(sp + 4, r2);
                r2 = 0x004afb0d;
                r1 = lsls(r1, 22);
                r3 = adds(r3, r2);
                str(sp + 8, r3);
                r0 = lsls(r3, 9);
                r3 = 0x3f3504f3;
                r0 = lsrs(r0, 9);
                r0 = adds(r0, r3);
                lr = logf + 92 | 1;
                bl(this::__aeabi_fsub, 92);
                return;
            case 92:
                r1 = movs(r1, 128);
                r1 = lsls(r1, 23);
                r4 = adds(r0, 0);
                lr = logf + 102 | 1;
                bl(this::__aeabi_fadd, 102);
                return;
            case 102:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = logf + 110 | 1;
                bl(this::__aeabi_fdiv, 110);
                return;
            case 110:
                r1 = adds(r0, 0);
                r5 = adds(r0, 0);
                lr = logf + 118 | 1;
                bl(this::__aeabi_fmul, 118);
                return;
            case 118:
                r1 = adds(r0, 0);
                r6 = adds(r0, 0);
                lr = logf + 126 | 1;
                bl(this::__aeabi_fmul, 126);
                return;
            case 126:
                r1 = movs(r1, 252);
                r7 = adds(r0, 0);
                r1 = lsls(r1, 22);
                r0 = adds(r4, 0);
                lr = logf + 138 | 1;
                bl(this::__aeabi_fmul, 138);
                return;
            case 138:
                r1 = adds(r4, 0);
                lr = logf + 144 | 1;
                bl(this::__aeabi_fmul, 144);
                return;
            case 144:
                r3 = ldr(sp + 8);
                str(sp + 12, r0);
                r0 = lsrs(r3, 23);
                r3 = ldr(sp + 4);
                r0 = subs(r0, 127);
                r0 = adds(r0, r3);
                lr = logf + 160 | 1;
                bl(this::__aeabi_i2f, 160);
                return;
            case 160:
                r1 = 0x3e789e26;
                str(sp + 4, r0);
                r0 = adds(r7, 0);
                lr = logf + 170 | 1;
                bl(this::__aeabi_fmul, 170);
                return;
            case 170:
                r1 = 0x3eccce13;
                lr = logf + 176 | 1;
                bl(this::__aeabi_fadd, 176);
                return;
            case 176:
                r1 = adds(r7, 0);
                lr = logf + 182 | 1;
                bl(this::__aeabi_fmul, 182);
                return;
            case 182:
                r1 = 0x3e91e9ee;
                str(sp + 8, r0);
                r0 = adds(r7, 0);
                lr = logf + 192 | 1;
                bl(this::__aeabi_fmul, 192);
                return;
            case 192:
                r1 = 0x3f2aaaaa;
                lr = logf + 198 | 1;
                bl(this::__aeabi_fadd, 198);
                return;
            case 198:
                r1 = adds(r6, 0);
                lr = logf + 204 | 1;
                bl(this::__aeabi_fmul, 204);
                return;
            case 204:
                r1 = adds(r0, 0);
                r0 = ldr(sp + 8);
                lr = logf + 212 | 1;
                bl(this::__aeabi_fadd, 212);
                return;
            case 212:
                r1 = ldr(sp + 12);
                lr = logf + 218 | 1;
                bl(this::__aeabi_fadd, 218);
                return;
            case 218:
                r1 = adds(r5, 0);
                lr = logf + 224 | 1;
                bl(this::__aeabi_fmul, 224);
                return;
            case 224:
                r1 = 0x3717f7d1;
                r5 = adds(r0, 0);
                r0 = ldr(sp + 4);
                lr = logf + 234 | 1;
                bl(this::__aeabi_fmul, 234);
                return;
            case 234:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = logf + 242 | 1;
                bl(this::__aeabi_fadd, 242);
                return;
            case 242:
                r1 = ldr(sp + 12);
                lr = logf + 248 | 1;
                bl(this::__aeabi_fsub, 248);
                return;
            case 248:
                r1 = adds(r4, 0);
                lr = logf + 254 | 1;
                bl(this::__aeabi_fadd, 254);
                return;
            case 254:
                r1 = 0x3f317180;
                r4 = adds(r0, 0);
                r0 = ldr(sp + 4);
                lr = logf + 264 | 1;
                bl(this::__aeabi_fmul, 264);
                return;
            case 264:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = logf + 272 | 1;
                bl(this::__aeabi_fadd, 272);
                return;
            case 272:
                b(null, 36);
                return;
            case 274:
                cmp(r0, r2);
                if (bls(null, 280)) return;
            case 278:
                b(null, 36);
                return;
            case 280:
                r2 = movs(r2, 254);
                r0 = movs(r0, 0);
                r2 = lsls(r2, 22);
                cmp(r3, r2);
                if (bne(null, 292)) return;
            case 290:
                b(null, 36);
                return;
            case 292:
                r2 = movs(r2, 0);
                b(null, 68);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134330140, size=20, name='log10f', path='build/lib/libm/math.o', has_indirect=True)
    protected void log10f(int offset) throws Exception
    {
        pc = log10f + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                lr = log10f + 6 | 1;
                bl(this::logf, 6);
                return;
            case 6:
                r1 = 0x40135d8e;
                lr = log10f + 12 | 1;
                bl(this::__aeabi_fdiv, 12);
                return;
            case 12:
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134330160, size=144, name='coshf', path='build/lib/libm/math.o', has_indirect=True)
    protected void coshf(int offset) throws Exception
    {
        pc = coshf + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r4, r5);
                r3 = lsls(r0, 1);
                r2 = 0x3f317216;
                r3 = lsrs(r3, 1);
                r0 = adds(r3, 0);
                cmp(r3, r2);
                if (bhi(null, 86)) return;
            case 14:
                r2 = 0x397fffff;
                cmp(r3, r2);
                if (bhi(null, 38)) return;
            case 20:
                r1 = movs(r1, 247);
                r1 = lsls(r1, 23);
                lr = coshf + 28 | 1;
                bl(this::__aeabi_fadd, 28);
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
                lr = coshf + 42 | 1;
                bl(this::expm1f, 42);
                return;
            case 42:
                r1 = adds(r0, 0);
                r4 = adds(r0, 0);
                lr = coshf + 50 | 1;
                bl(this::__aeabi_fmul, 50);
                return;
            case 50:
                r1 = movs(r1, 254);
                r5 = adds(r0, 0);
                r1 = lsls(r1, 22);
                r0 = adds(r4, 0);
                lr = coshf + 62 | 1;
                bl(this::__aeabi_fadd, 62);
                return;
            case 62:
                r1 = adds(r0, 0);
                lr = coshf + 68 | 1;
                bl(this::__aeabi_fadd, 68);
                return;
            case 68:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = coshf + 76 | 1;
                bl(this::__aeabi_fdiv, 76);
                return;
            case 76:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = coshf + 84 | 1;
                bl(this::__aeabi_fadd, 84);
                return;
            case 84:
                b(null, 36);
                return;
            case 86:
                r2 = 0x42b17216;
                cmp(r3, r2);
                if (bhi(null, 124)) return;
            case 92:
                lr = coshf + 96 | 1;
                bl(this::expf, 96);
                return;
            case 96:
                r4 = adds(r0, 0);
                r1 = adds(r0, 0);
                r0 = movs(r0, 254);
                r0 = lsls(r0, 22);
                lr = coshf + 108 | 1;
                bl(this::__aeabi_fdiv, 108);
                return;
            case 108:
                r1 = adds(r4, 0);
                lr = coshf + 114 | 1;
                bl(this::__aeabi_fadd, 114);
                return;
            case 114:
                r1 = movs(r1, 252);
                r1 = lsls(r1, 22);
                lr = coshf + 122 | 1;
                bl(this::__aeabi_fmul, 122);
                return;
            case 122:
                b(null, 36);
                return;
            case 124:
                lr = coshf + 128 | 1;
                bl(this::__expo2f, 128);
                return;
            case 128:
                b(null, 36);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134330304, size=160, name='sinhf', path='build/lib/libm/math.o', has_indirect=True)
    protected void sinhf(int offset) throws Exception
    {
        pc = sinhf + offset;
        switch (offset)
        {
            case 0:
                push(true, r3, r4, r5, r6, r7);
                r6 = adds(r0, 0);
                r4 = subs(r0, 0);
                if (bge(null, 98)) return;
            case 8:
                r7 = movs(r7, 191);
                r7 = lsls(r7, 24);
            case 12:
                r4 = lsls(r4, 1);
                r3 = 0x42b17216;
                r4 = lsrs(r4, 1);
                r0 = adds(r4, 0);
                cmp(r4, r3);
                if (bhi(null, 128)) return;
            case 24:
                lr = sinhf + 28 | 1;
                bl(this::expm1f, 28);
                return;
            case 28:
                r3 = 0x3f7fffff;
                r5 = adds(r0, 0);
                cmp(r4, r3);
                if (bhi(null, 104)) return;
            case 36:
                r3 = 0x397fffff;
                cmp(r4, r3);
                if (bls(null, 94)) return;
            case 42:
                r1 = adds(r0, 0);
                lr = sinhf + 48 | 1;
                bl(this::__aeabi_fadd, 48);
                return;
            case 48:
                r1 = adds(r5, 0);
                r4 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = sinhf + 58 | 1;
                bl(this::__aeabi_fmul, 58);
                return;
            case 58:
                r1 = movs(r1, 254);
                r6 = adds(r0, 0);
                r1 = lsls(r1, 22);
                r0 = adds(r5, 0);
                lr = sinhf + 70 | 1;
                bl(this::__aeabi_fadd, 70);
                return;
            case 70:
                r1 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = sinhf + 78 | 1;
                bl(this::__aeabi_fdiv, 78);
                return;
            case 78:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = sinhf + 86 | 1;
                bl(this::__aeabi_fsub, 86);
                return;
            case 86:
                r1 = adds(r7, 0);
            case 88:
                lr = sinhf + 92 | 1;
                bl(this::__aeabi_fmul, 92);
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
                b(null, 12);
                return;
            case 104:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = sinhf + 112 | 1;
                bl(this::__aeabi_fadd, 112);
                return;
            case 112:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = sinhf + 120 | 1;
                bl(this::__aeabi_fdiv, 120);
                return;
            case 120:
                r1 = adds(r5, 0);
                lr = sinhf + 126 | 1;
                bl(this::__aeabi_fadd, 126);
                return;
            case 126:
                b(null, 86);
                return;
            case 128:
                lr = sinhf + 132 | 1;
                bl(this::__expo2f, 132);
                return;
            case 132:
                r1 = adds(r7, 0);
                r4 = adds(r0, 0);
                r0 = adds(r7, 0);
                lr = sinhf + 142 | 1;
                bl(this::__aeabi_fadd, 142);
                return;
            case 142:
                r1 = adds(r4, 0);
                b(null, 88);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134330464, size=76, name='tanhf', path='build/lib/libm/math.o', has_indirect=True)
    protected void tanhf(int offset) throws Exception
    {
        pc = tanhf + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r5 = lsls(r0, 1);
                r5 = lsrs(r5, 1);
                r4 = adds(r0, 0);
                r1 = 0x7f7fffff;
                r0 = adds(r5, 0);
                lr = tanhf + 16 | 1;
                bl(this::__aeabi_fcmpun, 16);
                return;
            case 16:
                cmp(r0, 0);
                if (bne(null, 44)) return;
            case 20:
                r1 = 0x7f7fffff;
                r0 = adds(r5, 0);
                lr = tanhf + 28 | 1;
                bl(this::__aeabi_fcmple, 28);
                return;
            case 28:
                cmp(r0, 0);
                if (bne(null, 44)) return;
            case 32:
                r0 = movs(r0, 254);
                r0 = lsls(r0, 22);
                cmp(r4, 0);
                if (bge(null, 42)) return;
            case 40:
                r0 = 0xbf800000;
            case 42:
                pop(true, R4, R5, R6);
                return;
            case 44:
                r0 = adds(r4, 0);
                lr = tanhf + 50 | 1;
                bl(this::sinhf, 50);
                return;
            case 50:
                r5 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = tanhf + 58 | 1;
                bl(this::coshf, 58);
                return;
            case 58:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = tanhf + 66 | 1;
                bl(this::__aeabi_fdiv, 66);
                return;
            case 66:
                b(null, 42);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134330540, size=88, name='ceilf', path='build/lib/libm/math.o', has_indirect=False)
    protected void ceilf(int offset) throws Exception
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
                if (bgt(null, 46)) return;
            case 14:
                cmp(r3, 0);
                if (blt(null, 50)) return;
            case 18:
                r6 = 0x007fffff;
                r6 = asrs(r6, r3);
                tst(r6, r0);
                if (beq(null, 46)) return;
            case 26:
                r1 = movs(r1, 247);
                r1 = lsls(r1, 23);
                lr = ceilf + 34 | 1;
                bl(this::__aeabi_fadd, 34);
                return;
            case 34:
                str(sp, r0);
                r3 = ldr(sp);
                cmp(r4, 0);
                if (blt(null, 44)) return;
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
                lr = ceilf + 58 | 1;
                bl(this::__aeabi_fadd, 58);
                return;
            case 58:
                str(sp + 4, r0);
                r3 = ldr(sp + 4);
                cmp(r4, 0);
                if (blt(null, 76)) return;
            case 66:
                r5 = lsls(r4, 1);
                if (beq(null, 46)) return;
            case 70:
                r4 = movs(r4, 254);
                r4 = lsls(r4, 22);
                b(null, 46);
                return;
            case 76:
                r4 = movs(r4, 128);
                r4 = lsls(r4, 24);
                b(null, 46);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134330628, size=88, name='floorf', path='build/lib/libm/math.o', has_indirect=False)
    protected void floorf(int offset) throws Exception
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
                if (bgt(null, 46)) return;
            case 14:
                cmp(r3, 0);
                if (blt(null, 50)) return;
            case 18:
                r6 = 0x007fffff;
                r6 = asrs(r6, r3);
                tst(r6, r0);
                if (beq(null, 46)) return;
            case 26:
                r1 = movs(r1, 247);
                r1 = lsls(r1, 23);
                lr = floorf + 34 | 1;
                bl(this::__aeabi_fadd, 34);
                return;
            case 34:
                str(sp, r0);
                r3 = ldr(sp);
                cmp(r4, 0);
                if (bge(null, 44)) return;
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
                lr = floorf + 58 | 1;
                bl(this::__aeabi_fadd, 58);
                return;
            case 58:
                str(sp + 4, r0);
                r3 = ldr(sp + 4);
                cmp(r4, 0);
                if (bge(null, 74)) return;
            case 66:
                r5 = lsls(r4, 1);
                if (beq(null, 46)) return;
            case 70:
                r4 = 0xbf800000;
                b(null, 46);
                return;
            case 74:
                r4 = movs(r4, 0);
                b(null, 46);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134330716, size=48, name='truncf', path='build/lib/libm/math.o', has_indirect=False)
    protected void truncf(int offset) throws Exception
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
                if (bgt(null, 46)) return;
            case 14:
                cmp(r3, 8);
                if (bgt(null, 20)) return;
            case 18:
                r3 = movs(r3, 1);
            case 20:
                r5 = movs(r5, 1);
                r5 = rsbs(r5, 0);
                r5 = lsrs(r5, r3);
                tst(r5, r4);
                if (beq(null, 46)) return;
            case 30:
                r1 = movs(r1, 247);
                r1 = lsls(r1, 23);
                lr = truncf + 38 | 1;
                bl(this::__aeabi_fadd, 38);
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

    // function: Function(address=134330764, size=160, name='acoshf', path='build/lib/libm/acoshf.o', has_indirect=True)
    protected void acoshf(int offset) throws Exception
    {
        pc = acoshf + offset;
        switch (offset)
        {
            case 0:
                r2 = 0x3fffffff;
                r3 = lsls(r0, 1);
                push(true, r4, r5, r6);
                r3 = lsrs(r3, 1);
                r4 = adds(r0, 0);
                cmp(r3, r2);
                if (bhi(null, 66)) return;
            case 14:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = acoshf + 22 | 1;
                bl(this::__aeabi_fsub, 22);
                return;
            case 22:
                r1 = adds(r0, 0);
                r4 = adds(r0, 0);
                lr = acoshf + 30 | 1;
                bl(this::__aeabi_fmul, 30);
                return;
            case 30:
                r1 = adds(r4, 0);
                r5 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = acoshf + 40 | 1;
                bl(this::__aeabi_fadd, 40);
                return;
            case 40:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = acoshf + 48 | 1;
                bl(this::__aeabi_fadd, 48);
                return;
            case 48:
                lr = acoshf + 52 | 1;
                bl(this::sqrtf, 52);
                return;
            case 52:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = acoshf + 60 | 1;
                bl(this::__aeabi_fadd, 60);
                return;
            case 60:
                lr = acoshf + 64 | 1;
                bl(this::log1pf, 64);
                return;
            case 64:
                pop(true, R4, R5, R6);
                return;
            case 66:
                r2 = 0x457fffff;
                cmp(r3, r2);
                if (bhi(null, 134)) return;
            case 72:
                r1 = adds(r0, 0);
                lr = acoshf + 78 | 1;
                bl(this::__aeabi_fmul, 78);
                return;
            case 78:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = acoshf + 86 | 1;
                bl(this::__aeabi_fsub, 86);
                return;
            case 86:
                lr = acoshf + 90 | 1;
                bl(this::sqrtf, 90);
                return;
            case 90:
                r1 = adds(r4, 0);
                r6 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = acoshf + 100 | 1;
                bl(this::__aeabi_fadd, 100);
                return;
            case 100:
                r1 = adds(r4, 0);
                r5 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = acoshf + 110 | 1;
                bl(this::__aeabi_fadd, 110);
                return;
            case 110:
                r1 = adds(r0, 0);
                r0 = movs(r0, 254);
                r0 = lsls(r0, 22);
                lr = acoshf + 120 | 1;
                bl(this::__aeabi_fdiv, 120);
                return;
            case 120:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = acoshf + 128 | 1;
                bl(this::__aeabi_fsub, 128);
                return;
            case 128:
                lr = acoshf + 132 | 1;
                bl(this::logf, 132);
                return;
            case 132:
                b(null, 64);
                return;
            case 134:
                lr = acoshf + 138 | 1;
                bl(this::logf, 138);
                return;
            case 138:
                r1 = 0x3f317218;
                lr = acoshf + 144 | 1;
                bl(this::__aeabi_fadd, 144);
                return;
            case 144:
                b(null, 64);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134330924, size=80, name='text_R', path='build/lib/libm/asinfacosf.o', has_indirect=False)
    protected void text_R(int offset) throws Exception
    {
        pc = text_R + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r1 = 0xbc0dd36b;
                r4 = adds(r0, 0);
                lr = text_R + 10 | 1;
                bl(this::__aeabi_fmul, 10);
                return;
            case 10:
                r1 = 0x3d2f13ba;
                lr = text_R + 16 | 1;
                bl(this::__aeabi_fsub, 16);
                return;
            case 16:
                r1 = adds(r4, 0);
                lr = text_R + 22 | 1;
                bl(this::__aeabi_fmul, 22);
                return;
            case 22:
                r1 = 0x3e2aaa75;
                lr = text_R + 28 | 1;
                bl(this::__aeabi_fadd, 28);
                return;
            case 28:
                r1 = adds(r4, 0);
                lr = text_R + 34 | 1;
                bl(this::__aeabi_fmul, 34);
                return;
            case 34:
                r1 = 0xbf34e5ae;
                r5 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = text_R + 44 | 1;
                bl(this::__aeabi_fmul, 44);
                return;
            case 44:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = text_R + 52 | 1;
                bl(this::__aeabi_fadd, 52);
                return;
            case 52:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = text_R + 60 | 1;
                bl(this::__aeabi_fdiv, 60);
                return;
            case 60:
                pop(true, R4, R5, R6);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134331004, size=196, name='asinf', path='build/lib/libm/asinfacosf.o', has_indirect=True)
    protected void asinf(int offset) throws Exception
    {
        pc = asinf + offset;
        switch (offset)
        {
            case 0:
                r3 = 0x3f7fffff;
                r1 = lsls(r0, 1);
                push(true, r4, r5, r6);
                r1 = lsrs(r1, 1);
                r4 = adds(r0, 0);
                r5 = movs(r5, r0);
                cmp(r1, r3);
                if (bls(null, 58)) return;
            case 16:
                r3 = adds(r3, 1);
                cmp(r1, r3);
                if (bne(null, 38)) return;
            case 22:
                r1 = 0x3fc90fda;
                lr = asinf + 28 | 1;
                bl(this::__aeabi_fmul, 28);
                return;
            case 28:
                r1 = movs(r1, 224);
                r1 = lsls(r1, 18);
            case 32:
                lr = asinf + 36 | 1;
                bl(this::__aeabi_fadd, 36);
                return;
            case 36:
                b(null, 52);
                return;
            case 38:
                r1 = adds(r0, 0);
                lr = asinf + 44 | 1;
                bl(this::__aeabi_fsub, 44);
                return;
            case 44:
                r1 = adds(r0, 0);
                r0 = movs(r0, 0);
                lr = asinf + 52 | 1;
                bl(this::__aeabi_fdiv, 52);
                return;
            case 52:
                r4 = adds(r0, 0);
            case 54:
                r0 = adds(r4, 0);
                pop(true, R4, R5, R6);
                return;
            case 58:
                r3 = 0x3effffff;
                cmp(r1, r3);
                if (bhi(null, 96)) return;
            case 64:
                r3 = 0xff800000;
                r1 = adds(r1, r3);
                r3 = 0x38ffffff;
                cmp(r1, r3);
                if (bls(null, 54)) return;
            case 74:
                r1 = adds(r0, 0);
                lr = asinf + 80 | 1;
                bl(this::__aeabi_fmul, 80);
                return;
            case 80:
                lr = asinf + 84 | 1;
                bl(this::text_R, 84);
                return;
            case 84:
                r1 = adds(r4, 0);
                lr = asinf + 90 | 1;
                bl(this::__aeabi_fmul, 90);
                return;
            case 90:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                b(null, 32);
                return;
            case 96:
                r0 = movs(r0, 254);
                r0 = lsls(r0, 22);
                lr = asinf + 104 | 1;
                bl(this::__aeabi_fsub, 104);
                return;
            case 104:
                r1 = movs(r1, 252);
                r1 = lsls(r1, 22);
                lr = asinf + 112 | 1;
                bl(this::__aeabi_fmul, 112);
                return;
            case 112:
                r6 = adds(r0, 0);
                lr = asinf + 118 | 1;
                bl(this::sqrtf, 118);
                return;
            case 118:
                r4 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = asinf + 126 | 1;
                bl(this::text_R, 126);
                return;
            case 126:
                r1 = adds(r4, 0);
                lr = asinf + 132 | 1;
                bl(this::__aeabi_fmul, 132);
                return;
            case 132:
                r1 = adds(r4, 0);
                lr = asinf + 138 | 1;
                bl(this::__aeabi_fadd, 138);
                return;
            case 138:
                r1 = adds(r0, 0);
                lr = asinf + 144 | 1;
                bl(this::__aeabi_fadd, 144);
                return;
            case 144:
                r1 = 0x33a22168;
                lr = asinf + 150 | 1;
                bl(this::__aeabi_fsub, 150);
                return;
            case 150:
                r1 = adds(r0, 0);
                r0 = 0x3fc90fda;
                lr = asinf + 158 | 1;
                bl(this::__aeabi_fsub, 158);
                return;
            case 158:
                r4 = adds(r0, 0);
                cmp(r5, 0);
                if (bge(null, 54)) return;
            case 164:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 24);
                r4 = adds(r0, r3);
                b(null, 54);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134331200, size=288, name='acosf', path='build/lib/libm/asinfacosf.o', has_indirect=True)
    protected void acosf(int offset) throws Exception
    {
        pc = acosf + offset;
        switch (offset)
        {
            case 0:
                r1 = 0x3f7fffff;
                push(true, r3, r4, r5, r6, r7);
                r3 = lsls(r0, 1);
                r4 = adds(r0, 0);
                r3 = lsrs(r3, 1);
                cmp(r3, r1);
                if (bls(null, 46)) return;
            case 14:
                r1 = adds(r1, 1);
                cmp(r3, r1);
                if (bne(null, 30)) return;
            case 20:
                r0 = movs(r0, 0);
                cmp(r4, 0);
                if (bge(null, 44)) return;
            case 26:
                r0 = 0x40490fda;
                b(null, 44);
                return;
            case 30:
                r1 = adds(r0, 0);
                lr = acosf + 36 | 1;
                bl(this::__aeabi_fsub, 36);
                return;
            case 36:
                r1 = adds(r0, 0);
                r0 = movs(r0, 0);
                lr = acosf + 44 | 1;
                bl(this::__aeabi_fdiv, 44);
                return;
            case 44:
                pop(true, R3, R4, R5, R6, R7);
                return;
            case 46:
                r1 = 0x3effffff;
                cmp(r3, r1);
                if (bhi(null, 102)) return;
            case 52:
                r2 = movs(r2, 202);
                r2 = lsls(r2, 22);
                cmp(r3, r2);
                if (bls(null, 262)) return;
            case 60:
                r1 = adds(r0, 0);
                lr = acosf + 66 | 1;
                bl(this::__aeabi_fmul, 66);
                return;
            case 66:
                lr = acosf + 70 | 1;
                bl(this::text_R, 70);
                return;
            case 70:
                r1 = adds(r4, 0);
                lr = acosf + 76 | 1;
                bl(this::__aeabi_fmul, 76);
                return;
            case 76:
                r1 = adds(r0, 0);
                r0 = 0x33a22168;
                lr = acosf + 84 | 1;
                bl(this::__aeabi_fsub, 84);
                return;
            case 84:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = acosf + 92 | 1;
                bl(this::__aeabi_fsub, 92);
                return;
            case 92:
                r1 = adds(r0, 0);
                r0 = 0x3fc90fda;
                lr = acosf + 100 | 1;
                bl(this::__aeabi_fsub, 100);
                return;
            case 100:
                b(null, 44);
                return;
            case 102:
                cmp(r0, 0);
                if (bge(null, 170)) return;
            case 106:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = acosf + 114 | 1;
                bl(this::__aeabi_fadd, 114);
                return;
            case 114:
                r1 = movs(r1, 252);
                r1 = lsls(r1, 22);
                lr = acosf + 122 | 1;
                bl(this::__aeabi_fmul, 122);
                return;
            case 122:
                r5 = adds(r0, 0);
                lr = acosf + 128 | 1;
                bl(this::sqrtf, 128);
                return;
            case 128:
                r4 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = acosf + 136 | 1;
                bl(this::text_R, 136);
                return;
            case 136:
                r1 = adds(r4, 0);
                lr = acosf + 142 | 1;
                bl(this::__aeabi_fmul, 142);
                return;
            case 142:
                r1 = 0x33a22168;
                lr = acosf + 148 | 1;
                bl(this::__aeabi_fsub, 148);
                return;
            case 148:
                r1 = adds(r4, 0);
                lr = acosf + 154 | 1;
                bl(this::__aeabi_fadd, 154);
                return;
            case 154:
                r1 = adds(r0, 0);
                r0 = 0x3fc90fda;
                lr = acosf + 162 | 1;
                bl(this::__aeabi_fsub, 162);
                return;
            case 162:
                r1 = adds(r0, 0);
                lr = acosf + 168 | 1;
                bl(this::__aeabi_fadd, 168);
                return;
            case 168:
                b(null, 44);
                return;
            case 170:
                r1 = adds(r0, 0);
                r0 = movs(r0, 254);
                r0 = lsls(r0, 22);
                lr = acosf + 180 | 1;
                bl(this::__aeabi_fsub, 180);
                return;
            case 180:
                r1 = movs(r1, 252);
                r1 = lsls(r1, 22);
                lr = acosf + 188 | 1;
                bl(this::__aeabi_fmul, 188);
                return;
            case 188:
                r6 = adds(r0, 0);
                lr = acosf + 194 | 1;
                bl(this::sqrtf, 194);
                return;
            case 194:
                r4 = lsrs(r0, 12);
                r4 = lsls(r4, 12);
                r5 = adds(r0, 0);
                r1 = adds(r4, 0);
                r0 = adds(r4, 0);
                lr = acosf + 208 | 1;
                bl(this::__aeabi_fmul, 208);
                return;
            case 208:
                r1 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = acosf + 216 | 1;
                bl(this::__aeabi_fsub, 216);
                return;
            case 216:
                r1 = adds(r4, 0);
                r7 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = acosf + 226 | 1;
                bl(this::__aeabi_fadd, 226);
                return;
            case 226:
                r1 = adds(r0, 0);
                r0 = adds(r7, 0);
                lr = acosf + 234 | 1;
                bl(this::__aeabi_fdiv, 234);
                return;
            case 234:
                r7 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = acosf + 242 | 1;
                bl(this::text_R, 242);
                return;
            case 242:
                r1 = adds(r5, 0);
                lr = acosf + 248 | 1;
                bl(this::__aeabi_fmul, 248);
                return;
            case 248:
                r1 = adds(r7, 0);
                lr = acosf + 254 | 1;
                bl(this::__aeabi_fadd, 254);
                return;
            case 254:
                r1 = adds(r4, 0);
                lr = acosf + 260 | 1;
                bl(this::__aeabi_fadd, 260);
                return;
            case 260:
                b(null, 162);
                return;
            case 262:
                r0 = 0x3fc90fda;
                b(null, 44);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134331488, size=200, name='asinhf', path='build/lib/libm/asinhf.o', has_indirect=True)
    protected void asinhf(int offset) throws Exception
    {
        pc = asinhf + offset;
        switch (offset)
        {
            case 0:
                r3 = lsls(r0, 1);
                r2 = 0x457fffff;
                r3 = lsrs(r3, 1);
                push(true, r0, r1, r4, r5, r6);
                r6 = lsrs(r0, 31);
                r4 = adds(r3, 0);
                cmp(r3, r2);
                if (bls(null, 44)) return;
            case 16:
                r0 = adds(r3, 0);
                lr = asinhf + 22 | 1;
                bl(this::logf, 22);
                return;
            case 22:
                r1 = 0x3f317218;
                lr = asinhf + 28 | 1;
                bl(this::__aeabi_fadd, 28);
                return;
            case 28:
                r4 = adds(r0, 0);
            case 30:
                cmp(r6, 0);
                if (beq(null, 40)) return;
            case 34:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 24);
                r4 = adds(r4, r3);
            case 40:
                r0 = adds(r4, 0);
                pop(true, R1, R2, R4, R5, R6);
                return;
            case 44:
                r2 = 0x3fffffff;
                cmp(r3, r2);
                if (bls(null, 110)) return;
            case 50:
                r1 = adds(r3, 0);
                r0 = adds(r3, 0);
                lr = asinhf + 58 | 1;
                bl(this::__aeabi_fmul, 58);
                return;
            case 58:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = asinhf + 66 | 1;
                bl(this::__aeabi_fadd, 66);
                return;
            case 66:
                lr = asinhf + 70 | 1;
                bl(this::sqrtf, 70);
                return;
            case 70:
                r1 = adds(r4, 0);
                lr = asinhf + 76 | 1;
                bl(this::__aeabi_fadd, 76);
                return;
            case 76:
                r1 = adds(r0, 0);
                r0 = movs(r0, 254);
                r0 = lsls(r0, 22);
                lr = asinhf + 86 | 1;
                bl(this::__aeabi_fdiv, 86);
                return;
            case 86:
                r1 = adds(r4, 0);
                r5 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = asinhf + 96 | 1;
                bl(this::__aeabi_fadd, 96);
                return;
            case 96:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = asinhf + 104 | 1;
                bl(this::__aeabi_fadd, 104);
                return;
            case 104:
                lr = asinhf + 108 | 1;
                bl(this::logf, 108);
                return;
            case 108:
                b(null, 28);
                return;
            case 110:
                r2 = 0x397fffff;
                cmp(r3, r2);
                if (bls(null, 166)) return;
            case 116:
                r1 = adds(r3, 0);
                r0 = adds(r3, 0);
                lr = asinhf + 124 | 1;
                bl(this::__aeabi_fmul, 124);
                return;
            case 124:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                r5 = adds(r0, 0);
                lr = asinhf + 134 | 1;
                bl(this::__aeabi_fadd, 134);
                return;
            case 134:
                lr = asinhf + 138 | 1;
                bl(this::sqrtf, 138);
                return;
            case 138:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = asinhf + 146 | 1;
                bl(this::__aeabi_fadd, 146);
                return;
            case 146:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = asinhf + 154 | 1;
                bl(this::__aeabi_fdiv, 154);
                return;
            case 154:
                r1 = adds(r4, 0);
                lr = asinhf + 160 | 1;
                bl(this::__aeabi_fadd, 160);
                return;
            case 160:
                lr = asinhf + 164 | 1;
                bl(this::log1pf, 164);
                return;
            case 164:
                b(null, 28);
                return;
            case 166:
                r1 = movs(r1, 247);
                r0 = adds(r3, 0);
                r1 = lsls(r1, 23);
                lr = asinhf + 176 | 1;
                bl(this::__aeabi_fadd, 176);
                return;
            case 176:
                str(sp + 4, r0);
                r3 = ldr(sp + 4);
                b(null, 30);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134331688, size=304, name='atan2f', path='build/lib/libm/atan2f.o', has_indirect=True)
    protected void atan2f(int offset) throws Exception
    {
        pc = atan2f + offset;
        switch (offset)
        {
            case 0:
                push(true, r3, r4, r5, r6, r7);
                r4 = adds(r0, 0);
                r0 = adds(r1, 0);
                r6 = adds(r1, 0);
                lr = atan2f + 12 | 1;
                bl(this::__aeabi_fcmpun, 12);
                return;
            case 12:
                cmp(r0, 0);
                if (bne(null, 28)) return;
            case 16:
                r1 = adds(r4, 0);
                r0 = adds(r4, 0);
                lr = atan2f + 24 | 1;
                bl(this::__aeabi_fcmpun, 24);
                return;
            case 24:
                cmp(r0, 0);
                if (beq(null, 40)) return;
            case 28:
                r1 = adds(r6, 0);
                r0 = adds(r4, 0);
                lr = atan2f + 36 | 1;
                bl(this::__aeabi_fadd, 36);
                return;
            case 36:
                r4 = adds(r0, 0);
                b(null, 124);
                return;
            case 40:
                r2 = movs(r2, 254);
                r2 = lsls(r2, 22);
                cmp(r6, r2);
                if (bne(null, 56)) return;
            case 48:
                r0 = adds(r4, 0);
                lr = atan2f + 54 | 1;
                bl(this::atanf, 54);
                return;
            case 54:
                b(null, 36);
                return;
            case 56:
                r1 = movs(r1, 2);
                r5 = lsrs(r6, 30);
                r3 = lsrs(r4, 31);
                r5 = ands(r5, r1);
                r5 = orrs(r5, r3);
                r3 = lsls(r4, 1);
                r3 = lsrs(r3, 1);
                if (bne(null, 84)) return;
            case 72:
                cmp(r5, r1);
                if (beq(null, 260)) return;
            case 76:
                cmp(r5, 3);
                if (bne(null, 124)) return;
            case 80:
                r4 = 0xc0490fdb;
                b(null, 124);
                return;
            case 84:
                r2 = lsls(r6, 1);
                r2 = lsrs(r2, 1);
                if (bne(null, 98)) return;
            case 90:
                r3 = lsls(r5, 31);
                if (bpl(null, 264)) return;
            case 94:
                r4 = 0xbfc90fdb;
                b(null, 124);
                return;
            case 98:
                r0 = movs(r0, 255);
                r0 = lsls(r0, 23);
                cmp(r2, r0);
                if (bne(null, 156)) return;
            case 106:
                cmp(r3, r2);
                if (bne(null, 136)) return;
            case 110:
                cmp(r5, 2);
                if (beq(null, 128)) return;
            case 114:
                cmp(r5, 3);
                if (beq(null, 132)) return;
            case 118:
                cmp(r5, 1);
                if (bne(null, 256)) return;
            case 122:
                r4 = 0xbf490fdb;
            case 124:
                r0 = adds(r4, 0);
                pop(true, R3, R4, R5, R6, R7);
                return;
            case 128:
                r4 = 0x4016cbe4;
                b(null, 124);
                return;
            case 132:
                r4 = 0xc016cbe4;
                b(null, 124);
                return;
            case 136:
                cmp(r5, 2);
                if (beq(null, 260)) return;
            case 140:
                cmp(r5, 3);
                if (beq(null, 80)) return;
            case 144:
                r4 = movs(r4, 0);
                cmp(r5, 1);
                if (bne(null, 124)) return;
            case 150:
                r4 = movs(r4, 128);
                r4 = lsls(r4, 24);
                b(null, 124);
                return;
            case 156:
                r7 = movs(r7, 208);
                r7 = lsls(r7, 20);
                r7 = adds(r2, r7);
                cmp(r7, r3);
                if (blo(null, 90)) return;
            case 166:
                cmp(r3, r0);
                if (beq(null, 90)) return;
            case 170:
                tst(r5, r1);
                if (beq(null, 184)) return;
            case 174:
                r1 = movs(r1, 208);
                r1 = lsls(r1, 20);
                r3 = adds(r3, r1);
                cmp(r3, r2);
                if (blo(null, 226)) return;
            case 184:
                r1 = adds(r6, 0);
                r0 = adds(r4, 0);
                lr = atan2f + 192 | 1;
                bl(this::__aeabi_fdiv, 192);
                return;
            case 192:
                r0 = lsls(r0, 1);
                r0 = lsrs(r0, 1);
                lr = atan2f + 200 | 1;
                bl(this::atanf, 200);
                return;
            case 200:
                r4 = adds(r0, 0);
            case 202:
                cmp(r5, 1);
                if (beq(null, 230)) return;
            case 206:
                cmp(r5, 0);
                if (beq(null, 124)) return;
            case 210:
                cmp(r5, 2);
                if (beq(null, 238)) return;
            case 214:
                r1 = 0x33bbbd2e;
                r0 = adds(r4, 0);
                lr = atan2f + 222 | 1;
                bl(this::__aeabi_fadd, 222);
                return;
            case 222:
                r1 = 0x40490fdb;
                b(null, 250);
                return;
            case 226:
                r4 = movs(r4, 0);
                b(null, 202);
                return;
            case 230:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 24);
                r4 = adds(r4, r3);
                b(null, 124);
                return;
            case 238:
                r1 = 0x33bbbd2e;
                r0 = adds(r4, 0);
                lr = atan2f + 246 | 1;
                bl(this::__aeabi_fadd, 246);
                return;
            case 246:
                r1 = adds(r0, 0);
                r0 = 0x40490fdb;
            case 250:
                lr = atan2f + 254 | 1;
                bl(this::__aeabi_fsub, 254);
                return;
            case 254:
                b(null, 36);
                return;
            case 256:
                r4 = 0x3f490fdb;
                b(null, 124);
                return;
            case 260:
                r4 = 0x40490fdb;
                b(null, 124);
                return;
            case 264:
                r4 = 0x3fc90fdb;
                b(null, 124);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134331992, size=456, name='atanf', path='build/lib/libm/atanf.o', has_indirect=True)
    protected void atanf(int offset) throws Exception
    {
        pc = atanf + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r3 = lsrs(r0, 31);
                sp = sub(sp, 20);
                r2 = 0x4c7fffff;
                str(sp + 4, r3);
                r3 = lsls(r0, 1);
                r4 = adds(r0, 0);
                r3 = lsrs(r3, 1);
                cmp(r3, r2);
                if (bls(null, 46)) return;
            case 20:
                r1 = adds(r0, 0);
                lr = atanf + 26 | 1;
                bl(this::__aeabi_fcmpun, 26);
                return;
            case 26:
                cmp(r0, 0);
                if (bne(null, 40)) return;
            case 30:
                r3 = ldr(sp + 4);
                cmp(r3, 0);
                if (bne(null, 38)) return;
            case 36:
                b(null, 382);
                return;
            case 38:
                r4 = 0xbfc90fda;
            case 40:
                r0 = adds(r4, 0);
                sp = add(sp, 20);
                pop(true, R4, R5, R6, R7);
                return;
            case 46:
                r2 = 0x3edfffff;
                cmp(r3, r2);
                if (bhi(null, 78)) return;
            case 52:
                r2 = 0x397fffff;
                cmp(r3, r2);
                if (bls(null, 60)) return;
            case 58:
                b(null, 332);
                return;
            case 60:
                r2 = 0x007fffff;
                cmp(r3, r2);
                if (bhi(null, 40)) return;
            case 66:
                r1 = adds(r0, 0);
                lr = atanf + 72 | 1;
                bl(this::__aeabi_fmul, 72);
                return;
            case 72:
                str(sp + 12, r0);
                r3 = ldr(sp + 12);
                b(null, 40);
                return;
            case 78:
                r2 = 0x3f97ffff;
                r4 = movs(r4, r3);
                cmp(r3, r2);
                if (bhi(null, 268)) return;
            case 86:
                r2 = 0x3f2fffff;
                cmp(r3, r2);
                if (bhi(null, 232)) return;
            case 92:
                r1 = adds(r3, 0);
                r0 = adds(r3, 0);
                lr = atanf + 100 | 1;
                bl(this::__aeabi_fadd, 100);
                return;
            case 100:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = atanf + 108 | 1;
                bl(this::__aeabi_fsub, 108);
                return;
            case 108:
                r1 = movs(r1, 128);
                r5 = adds(r0, 0);
                r1 = lsls(r1, 23);
                r0 = adds(r4, 0);
                lr = atanf + 120 | 1;
                bl(this::__aeabi_fadd, 120);
                return;
            case 120:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = atanf + 128 | 1;
                bl(this::__aeabi_fdiv, 128);
                return;
            case 128:
                r5 = movs(r5, 0);
                r4 = adds(r0, 0);
            case 132:
                r1 = adds(r4, 0);
                r0 = adds(r4, 0);
                lr = atanf + 140 | 1;
                bl(this::__aeabi_fmul, 140);
                return;
            case 140:
                r1 = adds(r0, 0);
                r7 = adds(r0, 0);
                lr = atanf + 148 | 1;
                bl(this::__aeabi_fmul, 148);
                return;
            case 148:
                r1 = 0x3d7cac25;
                r6 = adds(r0, 0);
                lr = atanf + 156 | 1;
                bl(this::__aeabi_fmul, 156);
                return;
            case 156:
                r1 = 0x3e11f50d;
                lr = atanf + 162 | 1;
                bl(this::__aeabi_fadd, 162);
                return;
            case 162:
                r1 = adds(r6, 0);
                lr = atanf + 168 | 1;
                bl(this::__aeabi_fmul, 168);
                return;
            case 168:
                r1 = 0x3eaaaaa9;
                lr = atanf + 174 | 1;
                bl(this::__aeabi_fadd, 174);
                return;
            case 174:
                r1 = adds(r7, 0);
                lr = atanf + 180 | 1;
                bl(this::__aeabi_fmul, 180);
                return;
            case 180:
                r1 = 0xbdda1247;
                r7 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = atanf + 190 | 1;
                bl(this::__aeabi_fmul, 190);
                return;
            case 190:
                r1 = 0x3e4cca98;
                lr = atanf + 196 | 1;
                bl(this::__aeabi_fsub, 196);
                return;
            case 196:
                r1 = adds(r6, 0);
                lr = atanf + 202 | 1;
                bl(this::__aeabi_fmul, 202);
                return;
            case 202:
                r1 = adds(r0, 0);
                r0 = adds(r7, 0);
                lr = atanf + 210 | 1;
                bl(this::__aeabi_fadd, 210);
                return;
            case 210:
                r1 = adds(r4, 0);
                lr = atanf + 216 | 1;
                bl(this::__aeabi_fmul, 216);
                return;
            case 216:
                r3 = adds(r5, 1);
                if (bne(null, 338)) return;
            case 220:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = atanf + 228 | 1;
                bl(this::__aeabi_fsub, 228);
                return;
            case 228:
                r4 = adds(r0, 0);
                b(null, 40);
                return;
            case 232:
                r1 = movs(r1, 254);
                r0 = adds(r3, 0);
                r1 = lsls(r1, 22);
                lr = atanf + 242 | 1;
                bl(this::__aeabi_fsub, 242);
                return;
            case 242:
                r1 = movs(r1, 254);
                r5 = adds(r0, 0);
                r1 = lsls(r1, 22);
                r0 = adds(r4, 0);
                lr = atanf + 254 | 1;
                bl(this::__aeabi_fadd, 254);
                return;
            case 254:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = atanf + 262 | 1;
                bl(this::__aeabi_fdiv, 262);
                return;
            case 262:
                r5 = movs(r5, 1);
                r4 = adds(r0, 0);
                b(null, 132);
                return;
            case 268:
                r2 = 0x401bffff;
                cmp(r3, r2);
                if (bhi(null, 318)) return;
            case 274:
                r1 = movs(r1, 255);
                r0 = adds(r3, 0);
                r1 = lsls(r1, 22);
                lr = atanf + 284 | 1;
                bl(this::__aeabi_fsub, 284);
                return;
            case 284:
                r1 = movs(r1, 255);
                r5 = adds(r0, 0);
                r1 = lsls(r1, 22);
                r0 = adds(r4, 0);
                lr = atanf + 296 | 1;
                bl(this::__aeabi_fmul, 296);
                return;
            case 296:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = atanf + 304 | 1;
                bl(this::__aeabi_fadd, 304);
                return;
            case 304:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = atanf + 312 | 1;
                bl(this::__aeabi_fdiv, 312);
                return;
            case 312:
                r5 = movs(r5, 2);
                r4 = adds(r0, 0);
                b(null, 132);
                return;
            case 318:
                r1 = adds(r3, 0);
                r0 = 0xbf800000;
                lr = atanf + 326 | 1;
                bl(this::__aeabi_fdiv, 326);
                return;
            case 326:
                r5 = movs(r5, 3);
                r4 = adds(r0, 0);
                b(null, 132);
                return;
            case 332:
                r5 = movs(r5, 1);
                r5 = rsbs(r5, 0);
                b(null, 132);
                return;
            case 338:
                r3 = atanlo;
                r5 = lsls(r5, 2);
                r1 = ldr(r5 + r3);
                lr = atanf + 348 | 1;
                bl(this::__aeabi_fsub, 348);
                return;
            case 348:
                r1 = adds(r4, 0);
                lr = atanf + 354 | 1;
                bl(this::__aeabi_fsub, 354);
                return;
            case 354:
                r3 = atanhi;
                r1 = adds(r0, 0);
                r0 = ldr(r5 + r3);
                lr = atanf + 364 | 1;
                bl(this::__aeabi_fsub, 364);
                return;
            case 364:
                r3 = ldr(sp + 4);
                r4 = adds(r0, 0);
                cmp(r3, 0);
                if (bne(null, 374)) return;
            case 372:
                b(null, 40);
                return;
            case 374:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 24);
                r4 = adds(r0, r3);
                b(null, 40);
                return;
            case 382:
                r4 = 0x3fc90fda;
                b(null, 40);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134332448, size=144, name='atanhf', path='build/lib/libm/atanhf.o', has_indirect=True)
    protected void atanhf(int offset) throws Exception
    {
        pc = atanhf + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r4, r5, r6, r7);
                r3 = 0x3effffff;
                r5 = lsrs(r0, 31);
                r0 = lsls(r0, 1);
                r0 = lsrs(r0, 1);
                r4 = adds(r0, 0);
                cmp(r0, r3);
                if (bhi(null, 108)) return;
            case 16:
                r3 = 0x2f7fffff;
                cmp(r0, r3);
                if (bhi(null, 52)) return;
            case 22:
                r3 = 0x007fffff;
                cmp(r0, r3);
                if (bhi(null, 38)) return;
            case 28:
                r1 = adds(r0, 0);
                lr = atanhf + 34 | 1;
                bl(this::__aeabi_fmul, 34);
                return;
            case 34:
                str(sp + 4, r0);
                r3 = ldr(sp + 4);
            case 38:
                cmp(r5, 0);
                if (beq(null, 48)) return;
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
                lr = atanhf + 58 | 1;
                bl(this::__aeabi_fadd, 58);
                return;
            case 58:
                r1 = adds(r4, 0);
                r6 = adds(r0, 0);
                lr = atanhf + 66 | 1;
                bl(this::__aeabi_fmul, 66);
                return;
            case 66:
                r7 = adds(r0, 0);
                r0 = movs(r0, 254);
                r1 = adds(r4, 0);
                r0 = lsls(r0, 22);
                lr = atanhf + 78 | 1;
                bl(this::__aeabi_fsub, 78);
                return;
            case 78:
                r1 = adds(r0, 0);
                r0 = adds(r7, 0);
                lr = atanhf + 86 | 1;
                bl(this::__aeabi_fdiv, 86);
                return;
            case 86:
                r1 = adds(r6, 0);
            case 88:
                lr = atanhf + 92 | 1;
                bl(this::__aeabi_fadd, 92);
                return;
            case 92:
                lr = atanhf + 96 | 1;
                bl(this::log1pf, 96);
                return;
            case 96:
                r1 = movs(r1, 252);
                r1 = lsls(r1, 22);
                lr = atanhf + 104 | 1;
                bl(this::__aeabi_fmul, 104);
                return;
            case 104:
                r4 = adds(r0, 0);
                b(null, 38);
                return;
            case 108:
                r1 = adds(r0, 0);
                r0 = movs(r0, 254);
                r0 = lsls(r0, 22);
                lr = atanhf + 118 | 1;
                bl(this::__aeabi_fsub, 118);
                return;
            case 118:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = atanhf + 126 | 1;
                bl(this::__aeabi_fdiv, 126);
                return;
            case 126:
                r1 = adds(r0, 0);
                b(null, 88);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134332592, size=692, name='__ieee754_rem_pio2f', path='build/lib/libm/ef_rem_pio2.o', has_indirect=False)
    protected void __ieee754_rem_pio2f(int offset) throws Exception
    {
        pc = __ieee754_rem_pio2f + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r3 = 0x3f490fd8;
                sp = sub(sp, 44);
                r6 = lsls(r0, 1);
                r4 = movs(r4, r1);
                str(sp + 20, r0);
                r6 = lsrs(r6, 1);
                cmp(r6, r3);
                if (bgt(null, 28)) return;
            case 18:
                r3 = movs(r3, 0);
                str(r1, r0);
                str(r1 + 4, r3);
            case 24:
                r7 = movs(r7, 0);
                b(null, 82);
                return;
            case 28:
                r3 = 0x4016cbe3;
                cmp(r6, r3);
                if (bgt(null, 184)) return;
            case 34:
                r3 = movs(r3, 15);
                r5 = 0x3fc90fd0;
                r6 = bics(r6, r3);
                r1 = 0x3fc90f80;
                cmp(r0, 0);
                if (ble(null, 116)) return;
            case 46:
                lr = __ieee754_rem_pio2f + 50 | 1;
                bl(this::__aeabi_fsub, 50);
                return;
            case 50:
                r7 = adds(r0, 0);
                cmp(r6, r5);
                if (beq(null, 88)) return;
            case 56:
                r1 = 0x37354443;
                lr = __ieee754_rem_pio2f + 62 | 1;
                bl(this::__aeabi_fsub, 62);
                return;
            case 62:
                r1 = adds(r0, 0);
                str(r4, r0);
                r0 = adds(r7, 0);
                lr = __ieee754_rem_pio2f + 72 | 1;
                bl(this::__aeabi_fsub, 72);
                return;
            case 72:
                r1 = 0x37354443;
            case 74:
                lr = __ieee754_rem_pio2f + 78 | 1;
                bl(this::__aeabi_fsub, 78);
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
                r1 = 0x37354400;
                lr = __ieee754_rem_pio2f + 94 | 1;
                bl(this::__aeabi_fsub, 94);
                return;
            case 94:
                r1 = 0x2e85a308;
                r5 = adds(r0, 0);
                lr = __ieee754_rem_pio2f + 102 | 1;
                bl(this::__aeabi_fsub, 102);
                return;
            case 102:
                r1 = adds(r0, 0);
                str(r4, r0);
                r0 = adds(r5, 0);
                lr = __ieee754_rem_pio2f + 112 | 1;
                bl(this::__aeabi_fsub, 112);
                return;
            case 112:
                r1 = 0x2e85a308;
                b(null, 74);
                return;
            case 116:
                lr = __ieee754_rem_pio2f + 120 | 1;
                bl(this::__aeabi_fadd, 120);
                return;
            case 120:
                r7 = adds(r0, 0);
                cmp(r6, r5);
                if (beq(null, 156)) return;
            case 126:
                r1 = 0x37354443;
                lr = __ieee754_rem_pio2f + 132 | 1;
                bl(this::__aeabi_fadd, 132);
                return;
            case 132:
                r1 = adds(r0, 0);
                str(r4, r0);
                r0 = adds(r7, 0);
                lr = __ieee754_rem_pio2f + 142 | 1;
                bl(this::__aeabi_fsub, 142);
                return;
            case 142:
                r1 = 0x37354443;
            case 144:
                lr = __ieee754_rem_pio2f + 148 | 1;
                bl(this::__aeabi_fadd, 148);
                return;
            case 148:
                r7 = movs(r7, 1);
                str(r4 + 4, r0);
            case 152:
                r7 = rsbs(r7, 0);
                b(null, 82);
                return;
            case 156:
                r1 = 0x37354400;
                lr = __ieee754_rem_pio2f + 162 | 1;
                bl(this::__aeabi_fadd, 162);
                return;
            case 162:
                r1 = 0x2e85a308;
                r5 = adds(r0, 0);
                lr = __ieee754_rem_pio2f + 170 | 1;
                bl(this::__aeabi_fadd, 170);
                return;
            case 170:
                r1 = adds(r0, 0);
                str(r4, r0);
                r0 = adds(r5, 0);
                lr = __ieee754_rem_pio2f + 180 | 1;
                bl(this::__aeabi_fsub, 180);
                return;
            case 180:
                r1 = 0x2e85a308;
                b(null, 144);
                return;
            case 184:
                r3 = 0x43490f80;
                cmp(r6, r3);
                if (ble(null, 192)) return;
            case 190:
                b(null, 478);
                return;
            case 192:
                r1 = 0x3f22f984;
                r0 = adds(r6, 0);
                lr = __ieee754_rem_pio2f + 200 | 1;
                bl(this::__aeabi_fmul, 200);
                return;
            case 200:
                r1 = movs(r1, 252);
                r1 = lsls(r1, 22);
                lr = __ieee754_rem_pio2f + 208 | 1;
                bl(this::__aeabi_fadd, 208);
                return;
            case 208:
                lr = __ieee754_rem_pio2f + 212 | 1;
                bl(this::__aeabi_f2iz, 212);
                return;
            case 212:
                r7 = movs(r7, r0);
                lr = __ieee754_rem_pio2f + 218 | 1;
                bl(this::__aeabi_i2f, 218);
                return;
            case 218:
                r1 = 0x3fc90f80;
                str(sp + 12, r0);
                lr = __ieee754_rem_pio2f + 226 | 1;
                bl(this::__aeabi_fmul, 226);
                return;
            case 226:
                r1 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = __ieee754_rem_pio2f + 234 | 1;
                bl(this::__aeabi_fsub, 234);
                return;
            case 234:
                r1 = 0x37354443;
                r5 = adds(r0, 0);
                r0 = ldr(sp + 12);
                lr = __ieee754_rem_pio2f + 244 | 1;
                bl(this::__aeabi_fmul, 244);
                return;
            case 244:
                str(sp + 8, r0);
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = __ieee754_rem_pio2f + 254 | 1;
                bl(this::__aeabi_fsub, 254);
                return;
            case 254:
                cmp(r7, 31);
                if (bgt(null, 280)) return;
            case 258:
                r3 = movs(r3, 255);
                r2 = movs(r2, r6);
                r1 = npio2_hw;
                r2 = bics(r2, r3);
                r3 = subs(r7, 1);
                r3 = lsls(r3, 2);
                r3 = ldr(r3 + r1);
                cmp(r2, r3);
                if (beq(null, 280)) return;
            case 276:
                str(r4, r0);
                b(null, 376);
                return;
            case 280:
                r2 = movs(r2, 255);
                r3 = asrs(r6, 23);
                str(sp + 16, r3);
                r3 = lsrs(r0, 23);
                r3 = ands(r3, r2);
                r2 = ldr(sp + 16);
                r3 = subs(r2, r3);
                cmp(r3, 8);
                if (ble(null, 276)) return;
            case 298:
                r1 = 0x37354400;
                r0 = ldr(sp + 12);
                lr = __ieee754_rem_pio2f + 306 | 1;
                bl(this::__aeabi_fmul, 306);
                return;
            case 306:
                r1 = adds(r0, 0);
                str(sp + 8, r0);
                r0 = adds(r5, 0);
                lr = __ieee754_rem_pio2f + 316 | 1;
                bl(this::__aeabi_fsub, 316);
                return;
            case 316:
                r1 = adds(r0, 0);
                r6 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = __ieee754_rem_pio2f + 326 | 1;
                bl(this::__aeabi_fsub, 326);
                return;
            case 326:
                r1 = ldr(sp + 8);
                lr = __ieee754_rem_pio2f + 332 | 1;
                bl(this::__aeabi_fsub, 332);
                return;
            case 332:
                r1 = 0x2e85a308;
                r5 = adds(r0, 0);
                r0 = ldr(sp + 12);
                lr = __ieee754_rem_pio2f + 342 | 1;
                bl(this::__aeabi_fmul, 342);
                return;
            case 342:
                r1 = adds(r5, 0);
                lr = __ieee754_rem_pio2f + 348 | 1;
                bl(this::__aeabi_fsub, 348);
                return;
            case 348:
                str(sp + 8, r0);
                r1 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = __ieee754_rem_pio2f + 358 | 1;
                bl(this::__aeabi_fsub, 358);
                return;
            case 358:
                r2 = movs(r2, 255);
                r3 = lsrs(r0, 23);
                r3 = ands(r3, r2);
                r2 = ldr(sp + 16);
                r3 = subs(r2, r3);
                cmp(r3, 25);
                if (bgt(null, 416)) return;
            case 372:
                str(r4, r0);
                r5 = adds(r6, 0);
            case 376:
                r6 = ldr(r4);
                r0 = adds(r5, 0);
                r1 = adds(r6, 0);
                lr = __ieee754_rem_pio2f + 386 | 1;
                bl(this::__aeabi_fsub, 386);
                return;
            case 386:
                r1 = ldr(sp + 8);
                lr = __ieee754_rem_pio2f + 392 | 1;
                bl(this::__aeabi_fsub, 392);
                return;
            case 392:
                r3 = ldr(sp + 20);
                str(r4 + 4, r0);
                cmp(r3, 0);
                if (blt(null, 402)) return;
            case 400:
                b(null, 82);
                return;
            case 402:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 24);
                r6 = adds(r6, r3);
                r0 = adds(r0, r3);
                str(r4, r6);
                str(r4 + 4, r0);
                b(null, 152);
                return;
            case 416:
                r1 = 0x2e85a300;
                r0 = ldr(sp + 12);
                lr = __ieee754_rem_pio2f + 424 | 1;
                bl(this::__aeabi_fmul, 424);
                return;
            case 424:
                str(sp + 8, r0);
                r1 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = __ieee754_rem_pio2f + 434 | 1;
                bl(this::__aeabi_fsub, 434);
                return;
            case 434:
                r5 = adds(r0, 0);
                r1 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = __ieee754_rem_pio2f + 444 | 1;
                bl(this::__aeabi_fsub, 444);
                return;
            case 444:
                r1 = ldr(sp + 8);
                lr = __ieee754_rem_pio2f + 450 | 1;
                bl(this::__aeabi_fsub, 450);
                return;
            case 450:
                r1 = 0x248d3132;
                r6 = adds(r0, 0);
                r0 = ldr(sp + 12);
                lr = __ieee754_rem_pio2f + 460 | 1;
                bl(this::__aeabi_fmul, 460);
                return;
            case 460:
                r1 = adds(r6, 0);
                lr = __ieee754_rem_pio2f + 466 | 1;
                bl(this::__aeabi_fsub, 466);
                return;
            case 466:
                str(sp + 8, r0);
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = __ieee754_rem_pio2f + 476 | 1;
                bl(this::__aeabi_fsub, 476);
                return;
            case 476:
                b(null, 276);
                return;
            case 478:
                r3 = 0x7f7fffff;
                cmp(r6, r3);
                if (ble(null, 496)) return;
            case 484:
                r1 = adds(r0, 0);
                lr = __ieee754_rem_pio2f + 490 | 1;
                bl(this::__aeabi_fsub, 490);
                return;
            case 490:
                str(r4 + 4, r0);
                str(r4, r0);
                b(null, 24);
                return;
            case 496:
                r5 = asrs(r6, 23);
                r5 = subs(r5, 134);
                r3 = lsls(r5, 23);
                r6 = subs(r6, r3);
                r0 = adds(r6, 0);
                lr = __ieee754_rem_pio2f + 510 | 1;
                bl(this::__aeabi_f2iz, 510);
                return;
            case 510:
                lr = __ieee754_rem_pio2f + 514 | 1;
                bl(this::__aeabi_i2f, 514);
                return;
            case 514:
                r1 = adds(r0, 0);
                str(sp + 28, r0);
                r0 = adds(r6, 0);
                lr = __ieee754_rem_pio2f + 524 | 1;
                bl(this::__aeabi_fsub, 524);
                return;
            case 524:
                r1 = movs(r1, 135);
                r1 = lsls(r1, 23);
                lr = __ieee754_rem_pio2f + 532 | 1;
                bl(this::__aeabi_fmul, 532);
                return;
            case 532:
                r7 = adds(r0, 0);
                lr = __ieee754_rem_pio2f + 538 | 1;
                bl(this::__aeabi_f2iz, 538);
                return;
            case 538:
                lr = __ieee754_rem_pio2f + 542 | 1;
                bl(this::__aeabi_i2f, 542);
                return;
            case 542:
                r1 = adds(r0, 0);
                str(sp + 32, r0);
                r6 = adds(r0, 0);
                r0 = adds(r7, 0);
                lr = __ieee754_rem_pio2f + 554 | 1;
                bl(this::__aeabi_fsub, 554);
                return;
            case 554:
                r1 = movs(r1, 135);
                r1 = lsls(r1, 23);
                lr = __ieee754_rem_pio2f + 562 | 1;
                bl(this::__aeabi_fmul, 562);
                return;
            case 562:
                r1 = movs(r1, 0);
                str(sp + 36, r0);
                lr = __ieee754_rem_pio2f + 570 | 1;
                bl(this::__aeabi_fcmpeq, 570);
                return;
            case 570:
                r3 = movs(r3, 3);
                cmp(r0, 0);
                if (beq(null, 590)) return;
            case 576:
                r1 = movs(r1, 0);
                r0 = adds(r6, 0);
                lr = __ieee754_rem_pio2f + 584 | 1;
                bl(this::__aeabi_fcmpeq, 584);
                return;
            case 584:
                r3 = rsbs(r0, 0);
                r3 = adcs(r3, r0);
                r3 = adds(r3, 1);
            case 590:
                r2 = two_over_pi;
                r1 = movs(r1, r4);
                str(sp + 4, r2);
                r2 = movs(r2, 2);
                r0 = add(sp, 28);
                str(sp, r2);
                r2 = movs(r2, r5);
                lr = __ieee754_rem_pio2f + 608 | 1;
                bl(this::__kernel_rem_pio2f, 608);
                return;
            case 608:
                r3 = ldr(sp + 20);
                r7 = movs(r7, r0);
                cmp(r3, 0);
                if (blt(null, 618)) return;
            case 616:
                b(null, 82);
                return;
            case 618:
                r2 = movs(r2, 128);
                r3 = ldr(r4);
                r2 = lsls(r2, 24);
                r3 = adds(r3, r2);
                str(r4, r3);
                r3 = ldr(r4 + 4);
                r3 = adds(r3, r2);
                str(r4 + 4, r3);
                b(null, 152);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134333284, size=176, name='sqrtf', path='build/lib/libm/ef_sqrt.o', has_indirect=True)
    protected void sqrtf(int offset) throws Exception
    {
        pc = sqrtf + offset;
        switch (offset)
        {
            case 0:
                r1 = 0x7f7fffff;
                r3 = lsls(r0, 1);
                push(true, r4, r5, r6);
                r2 = movs(r2, r0);
                r4 = adds(r0, 0);
                r3 = lsrs(r3, 1);
                cmp(r3, r1);
                if (bls(null, 36)) return;
            case 16:
                r1 = adds(r0, 0);
                lr = sqrtf + 22 | 1;
                bl(this::__aeabi_fmul, 22);
                return;
            case 22:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = sqrtf + 30 | 1;
                bl(this::__aeabi_fadd, 30);
                return;
            case 30:
                r4 = adds(r0, 0);
            case 32:
                r0 = adds(r4, 0);
                pop(true, R4, R5, R6);
                return;
            case 36:
                cmp(r3, 0);
                if (beq(null, 32)) return;
            case 40:
                cmp(r0, 0);
                if (bge(null, 58)) return;
            case 44:
                r1 = adds(r0, 0);
                lr = sqrtf + 50 | 1;
                bl(this::__aeabi_fsub, 50);
                return;
            case 50:
                r1 = adds(r0, 0);
                lr = sqrtf + 56 | 1;
                bl(this::__aeabi_fdiv, 56);
                return;
            case 56:
                b(null, 30);
                return;
            case 58:
                r1 = 0x007fffff;
                r4 = asrs(r0, 23);
                cmp(r3, r1);
                if (bls(null, 158)) return;
            case 66:
                r2 = lsls(r2, 9);
                r3 = lsrs(r2, 9);
                r2 = movs(r2, 128);
                r4 = subs(r4, 127);
                r2 = lsls(r2, 16);
                r2 = orrs(r2, r3);
                r3 = lsls(r4, 31);
                if (bpl(null, 84)) return;
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
                if (bgt(null, 110)) return;
            case 104:
                r6 = adds(r5, r1);
                r2 = subs(r2, r5);
                r3 = adds(r3, r1);
            case 110:
                r0 = subs(r0, 1);
                r2 = lsls(r2, 1);
                r1 = lsrs(r1, 1);
                cmp(r0, 0);
                if (bne(null, 98)) return;
            case 120:
                cmp(r2, 0);
                if (beq(null, 130)) return;
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
                b(null, 32);
                return;
            case 144:
                r2 = lsls(r2, 1);
                r3 = adds(r3, 1);
            case 148:
                tst(r2, r1);
                if (beq(null, 144)) return;
            case 152:
                r3 = subs(r3, 1);
                r4 = subs(r4, r3);
                b(null, 66);
                return;
            case 158:
                r1 = movs(r1, 128);
                r3 = movs(r3, 0);
                r1 = lsls(r1, 16);
                b(null, 148);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134333460, size=1976, name='__ieee754_lgammaf_r', path='build/lib/libm/erf_lgamma.o', has_indirect=False)
    protected void __ieee754_lgammaf_r(int offset) throws Exception
    {
        pc = __ieee754_lgammaf_r + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r4, r5, r6, r7);
                r7 = movs(r7, 1);
                r3 = 0x7f7fffff;
                r5 = lsls(r0, 1);
                r4 = adds(r0, 0);
                str(sp, r1);
                str(sp + 4, r0);
                str(r1, r7);
                r5 = lsrs(r5, r7);
                cmp(r5, r3);
                if (ble(null, 32)) return;
            case 22:
                r1 = adds(r0, 0);
                lr = __ieee754_lgammaf_r + 28 | 1;
                bl(this::__aeabi_fmul, 28);
                return;
            case 28:
                r4 = adds(r0, 0);
                b(null, 78);
                return;
            case 32:
                cmp(r5, 0);
                if (bne(null, 48)) return;
            case 36:
                r0 = movs(r0, 254);
                r1 = movs(r1, 0);
                r0 = lsls(r0, 22);
                lr = __ieee754_lgammaf_r + 46 | 1;
                bl(this::__aeabi_fdiv, 46);
                return;
            case 46:
                b(null, 28);
                return;
            case 48:
                r3 = 0x1c7fffff;
                cmp(r5, r3);
                if (bgt(null, 94)) return;
            case 54:
                cmp(r0, 0);
                if (bge(null, 82)) return;
            case 58:
                r3 = movs(r3, 1);
                r5 = movs(r5, 128);
                r2 = ldr(sp);
                r3 = rsbs(r3, 0);
                r5 = lsls(r5, 24);
                str(r2, r3);
                r0 = adds(r0, r5);
                lr = __ieee754_lgammaf_r + 76 | 1;
                bl(this::logf, 76);
                return;
            case 76:
                r4 = adds(r0, r5);
            case 78:
                r0 = adds(r4, 0);
                pop(true, R1, R2, R3, R4, R5, R6, R7);
                return;
            case 82:
                lr = __ieee754_lgammaf_r + 86 | 1;
                bl(this::logf, 86);
                return;
            case 86:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 24);
                r4 = adds(r0, r3);
                b(null, 78);
                return;
            case 94:
                cmp(r0, 0);
                if (blt(null, 100)) return;
            case 98:
                b(null, 1560);
                return;
            case 100:
                r3 = 0x4affffff;
                cmp(r5, r3);
                if (bgt(null, 36)) return;
            case 106:
                r3 = 0x3e7fffff;
                cmp(r5, r3);
                if (bgt(null, 204)) return;
            case 112:
                r1 = 0x40490fdb;
                lr = __ieee754_lgammaf_r + 118 | 1;
                bl(this::__aeabi_fmul, 118);
                return;
            case 118:
                r2 = movs(r2, 0);
                r1 = movs(r1, 0);
                lr = __ieee754_lgammaf_r + 126 | 1;
                bl(this::__kernel_sinf, 126);
                return;
            case 126:
                r6 = adds(r0, 0);
            case 128:
                r1 = movs(r1, 0);
                r0 = adds(r6, 0);
                lr = __ieee754_lgammaf_r + 136 | 1;
                bl(this::__aeabi_fcmpeq, 136);
                return;
            case 136:
                cmp(r0, 0);
                if (bne(null, 36)) return;
            case 140:
                r1 = adds(r6, 0);
                r0 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 148 | 1;
                bl(this::__aeabi_fmul, 148);
                return;
            case 148:
                r1 = lsls(r0, 1);
                r1 = lsrs(r1, 1);
                r0 = 0x40490fdb;
                lr = __ieee754_lgammaf_r + 158 | 1;
                bl(this::__aeabi_fdiv, 158);
                return;
            case 158:
                lr = __ieee754_lgammaf_r + 162 | 1;
                bl(this::logf, 162);
                return;
            case 162:
                r1 = movs(r1, 0);
                r7 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = __ieee754_lgammaf_r + 172 | 1;
                bl(this::__aeabi_fcmplt, 172);
                return;
            case 172:
                cmp(r0, 0);
                if (beq(null, 184)) return;
            case 176:
                r3 = movs(r3, 1);
                r2 = ldr(sp);
                r3 = rsbs(r3, 0);
                str(r2, r3);
            case 184:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 24);
                r4 = adds(r4, r3);
                r3 = movs(r3, 254);
                r3 = lsls(r3, 22);
                cmp(r5, r3);
                if (beq(null, 200)) return;
            case 198:
                b(null, 1572);
                return;
            case 200:
                r4 = movs(r4, 0);
                b(null, 1262);
                return;
            case 204:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 24);
                r6 = adds(r0, r3);
                r0 = adds(r6, 0);
                lr = __ieee754_lgammaf_r + 216 | 1;
                bl(this::floorf, 216);
                return;
            case 216:
                r1 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = __ieee754_lgammaf_r + 224 | 1;
                bl(this::__aeabi_fcmpeq, 224);
                return;
            case 224:
                cmp(r0, 0);
                if (bne(null, 296)) return;
            case 228:
                r1 = movs(r1, 252);
                r0 = adds(r6, 0);
                r1 = lsls(r1, 22);
                lr = __ieee754_lgammaf_r + 238 | 1;
                bl(this::__aeabi_fmul, 238);
                return;
            case 238:
                r6 = adds(r0, 0);
                lr = __ieee754_lgammaf_r + 244 | 1;
                bl(this::floorf, 244);
                return;
            case 244:
                r1 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = __ieee754_lgammaf_r + 252 | 1;
                bl(this::__aeabi_fsub, 252);
                return;
            case 252:
                r1 = adds(r0, 0);
                lr = __ieee754_lgammaf_r + 258 | 1;
                bl(this::__aeabi_fadd, 258);
                return;
            case 258:
                r1 = movs(r1, 129);
                r1 = lsls(r1, 23);
                r7 = adds(r0, 0);
                lr = __ieee754_lgammaf_r + 268 | 1;
                bl(this::__aeabi_fmul, 268);
                return;
            case 268:
                lr = __ieee754_lgammaf_r + 272 | 1;
                bl(this::__aeabi_f2iz, 272);
                return;
            case 272:
                r6 = movs(r6, r0);
            case 274:
                cmp(r6, 4);
                if (bgt(null, 322)) return;
            case 278:
                cmp(r6, 3);
                if (bge(null, 404)) return;
            case 282:
                cmp(r6, 0);
                if (beq(null, 356)) return;
            case 286:
                if (bge(null, 374)) return;
            case 288:
                r1 = movs(r1, 128);
                r0 = adds(r7, 0);
                r1 = lsls(r1, 23);
                b(null, 410);
                return;
            case 296:
                r0 = movs(r0, 150);
                r1 = adds(r4, 0);
                r0 = lsls(r0, 23);
                lr = __ieee754_lgammaf_r + 306 | 1;
                bl(this::__aeabi_fsub, 306);
                return;
            case 306:
                r6 = movs(r6, r7);
                r6 = ands(r6, r0);
                r0 = movs(r0, r6);
                lr = __ieee754_lgammaf_r + 316 | 1;
                bl(this::__aeabi_i2f, 316);
                return;
            case 316:
                r6 = lsls(r6, 2);
                r7 = adds(r0, 0);
                b(null, 274);
                return;
            case 322:
                cmp(r6, 6);
                if (bgt(null, 288)) return;
            case 326:
                r1 = movs(r1, 255);
                r0 = adds(r7, 0);
                r1 = lsls(r1, 22);
                lr = __ieee754_lgammaf_r + 336 | 1;
                bl(this::__aeabi_fsub, 336);
                return;
            case 336:
                r1 = 0x40490fdb;
                lr = __ieee754_lgammaf_r + 342 | 1;
                bl(this::__aeabi_fmul, 342);
                return;
            case 342:
                r1 = movs(r1, 0);
                lr = __ieee754_lgammaf_r + 348 | 1;
                bl(this::__kernel_cosf, 348);
                return;
            case 348:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 24);
                r0 = adds(r0, r3);
                b(null, 396);
                return;
            case 356:
                r1 = 0x40490fdb;
                r0 = adds(r7, 0);
            case 360:
                lr = __ieee754_lgammaf_r + 364 | 1;
                bl(this::__aeabi_fmul, 364);
                return;
            case 364:
                r2 = movs(r2, 0);
                r1 = movs(r1, 0);
                lr = __ieee754_lgammaf_r + 372 | 1;
                bl(this::__kernel_sinf, 372);
                return;
            case 372:
                b(null, 396);
                return;
            case 374:
                r0 = movs(r0, 252);
                r1 = adds(r7, 0);
                r0 = lsls(r0, 22);
                lr = __ieee754_lgammaf_r + 384 | 1;
                bl(this::__aeabi_fsub, 384);
                return;
            case 384:
                r1 = 0x40490fdb;
                lr = __ieee754_lgammaf_r + 390 | 1;
                bl(this::__aeabi_fmul, 390);
                return;
            case 390:
                r1 = movs(r1, 0);
                lr = __ieee754_lgammaf_r + 396 | 1;
                bl(this::__kernel_cosf, 396);
                return;
            case 396:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 24);
                r6 = adds(r0, r3);
                b(null, 128);
                return;
            case 404:
                r0 = movs(r0, 254);
                r1 = adds(r7, 0);
                r0 = lsls(r0, 22);
            case 410:
                lr = __ieee754_lgammaf_r + 414 | 1;
                bl(this::__aeabi_fsub, 414);
                return;
            case 414:
                r1 = 0x40490fdb;
                b(null, 360);
                return;
            case 418:
                r3 = 0x3e6d3307;
                cmp(r5, r3);
                if (bgt(null, 426)) return;
            case 424:
                b(null, 708);
                return;
            case 426:
                r1 = 0x3eec5b0c;
                r0 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 434 | 1;
                bl(this::__aeabi_fsub, 434);
                return;
            case 434:
                r5 = adds(r0, 0);
            case 436:
                r1 = adds(r5, 0);
                r0 = adds(r5, 0);
                lr = __ieee754_lgammaf_r + 444 | 1;
                bl(this::__aeabi_fmul, 444);
                return;
            case 444:
                r1 = adds(r5, 0);
                str(sp, r0);
                lr = __ieee754_lgammaf_r + 452 | 1;
                bl(this::__aeabi_fmul, 452);
                return;
            case 452:
                r1 = 0x39a57b6b;
                r4 = adds(r0, 0);
                lr = __ieee754_lgammaf_r + 460 | 1;
                bl(this::__aeabi_fmul, 460);
                return;
            case 460:
                r1 = 0x3ab7f476;
                lr = __ieee754_lgammaf_r + 466 | 1;
                bl(this::__aeabi_fsub, 466);
                return;
            case 466:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 472 | 1;
                bl(this::__aeabi_fmul, 472);
                return;
            case 472:
                r1 = 0x3bc7e707;
                lr = __ieee754_lgammaf_r + 478 | 1;
                bl(this::__aeabi_fadd, 478);
                return;
            case 478:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 484 | 1;
                bl(this::__aeabi_fmul, 484);
                return;
            case 484:
                r1 = 0x3d064d47;
                lr = __ieee754_lgammaf_r + 490 | 1;
                bl(this::__aeabi_fsub, 490);
                return;
            case 490:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 496 | 1;
                bl(this::__aeabi_fmul, 496);
                return;
            case 496:
                r1 = 0x3ef7b95e;
                lr = __ieee754_lgammaf_r + 502 | 1;
                bl(this::__aeabi_fadd, 502);
                return;
            case 502:
                r1 = ldr(sp);
                lr = __ieee754_lgammaf_r + 508 | 1;
                bl(this::__aeabi_fmul, 508);
                return;
            case 508:
                r1 = 0x39afe9f7;
                str(sp, r0);
                r0 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 518 | 1;
                bl(this::__aeabi_fmul, 518);
                return;
            case 518:
                r1 = 0x3a0d3085;
                lr = __ieee754_lgammaf_r + 524 | 1;
                bl(this::__aeabi_fsub, 524);
                return;
            case 524:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 530 | 1;
                bl(this::__aeabi_fmul, 530);
                return;
            case 530:
                r1 = 0x3b141699;
                lr = __ieee754_lgammaf_r + 536 | 1;
                bl(this::__aeabi_fadd, 536);
                return;
            case 536:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 542 | 1;
                bl(this::__aeabi_fmul, 542);
                return;
            case 542:
                r1 = 0x3c28fcfe;
                lr = __ieee754_lgammaf_r + 548 | 1;
                bl(this::__aeabi_fsub, 548);
                return;
            case 548:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 554 | 1;
                bl(this::__aeabi_fmul, 554);
                return;
            case 554:
                r1 = 0x3d845a15;
                lr = __ieee754_lgammaf_r + 560 | 1;
                bl(this::__aeabi_fadd, 560);
                return;
            case 560:
                r1 = adds(r5, 0);
                lr = __ieee754_lgammaf_r + 566 | 1;
                bl(this::__aeabi_fmul, 566);
                return;
            case 566:
                r1 = 0xb9a3f927;
                r5 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 576 | 1;
                bl(this::__aeabi_fmul, 576);
                return;
            case 576:
                r1 = 0x3a66f867;
                lr = __ieee754_lgammaf_r + 582 | 1;
                bl(this::__aeabi_fadd, 582);
                return;
            case 582:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 588 | 1;
                bl(this::__aeabi_fmul, 588);
                return;
            case 588:
                r1 = 0x3b7177fe;
                lr = __ieee754_lgammaf_r + 594 | 1;
                bl(this::__aeabi_fsub, 594);
                return;
            case 594:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 600 | 1;
                bl(this::__aeabi_fmul, 600);
                return;
            case 600:
                r1 = 0x3c93373d;
                lr = __ieee754_lgammaf_r + 606 | 1;
                bl(this::__aeabi_fadd, 606);
                return;
            case 606:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 612 | 1;
                bl(this::__aeabi_fmul, 612);
                return;
            case 612:
                r1 = 0x3e17213c;
                lr = __ieee754_lgammaf_r + 618 | 1;
                bl(this::__aeabi_fsub, 618);
                return;
            case 618:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = __ieee754_lgammaf_r + 626 | 1;
                bl(this::__aeabi_fadd, 626);
                return;
            case 626:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 632 | 1;
                bl(this::__aeabi_fmul, 632);
                return;
            case 632:
                r1 = adds(r0, 0);
                r0 = 0x31e61c52;
                lr = __ieee754_lgammaf_r + 640 | 1;
                bl(this::__aeabi_fsub, 640);
                return;
            case 640:
                r1 = adds(r0, 0);
                r0 = ldr(sp);
                lr = __ieee754_lgammaf_r + 648 | 1;
                bl(this::__aeabi_fsub, 648);
                return;
            case 648:
                r1 = 0x3df8cdcd;
                b(null, 1800);
                return;
            case 652:
                r3 = 0x3fdda617;
                cmp(r5, r3);
                if (ble(null, 674)) return;
            case 658:
                r0 = movs(r0, 128);
                r1 = adds(r4, 0);
                r0 = lsls(r0, 23);
                lr = __ieee754_lgammaf_r + 668 | 1;
                bl(this::__aeabi_fsub, 668);
                return;
            case 668:
                r6 = movs(r6, 0);
                r5 = adds(r0, 0);
                b(null, 1630);
                return;
            case 674:
                r3 = 0x3f9da61f;
                cmp(r5, r3);
                if (ble(null, 694)) return;
            case 680:
                r1 = 0x3fbb16c3;
                r0 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 688 | 1;
                bl(this::__aeabi_fsub, 688);
                return;
            case 688:
                r6 = movs(r6, 0);
                r5 = adds(r0, 0);
                b(null, 436);
                return;
            case 694:
                r1 = movs(r1, 254);
                r0 = adds(r4, 0);
                r1 = lsls(r1, 22);
                lr = __ieee754_lgammaf_r + 704 | 1;
                bl(this::__aeabi_fsub, 704);
                return;
            case 704:
                r6 = movs(r6, 0);
                r4 = adds(r0, 0);
            case 708:
                r1 = 0x3c5b3c5e;
                r0 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 716 | 1;
                bl(this::__aeabi_fmul, 716);
                return;
            case 716:
                r1 = 0x3e6a7578;
                lr = __ieee754_lgammaf_r + 722 | 1;
                bl(this::__aeabi_fadd, 722);
                return;
            case 722:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 728 | 1;
                bl(this::__aeabi_fmul, 728);
                return;
            case 728:
                r1 = 0x3f7a4bb2;
                lr = __ieee754_lgammaf_r + 734 | 1;
                bl(this::__aeabi_fadd, 734);
                return;
            case 734:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 740 | 1;
                bl(this::__aeabi_fmul, 740);
                return;
            case 740:
                r1 = 0x3fba3ae7;
                lr = __ieee754_lgammaf_r + 746 | 1;
                bl(this::__aeabi_fadd, 746);
                return;
            case 746:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 752 | 1;
                bl(this::__aeabi_fmul, 752);
                return;
            case 752:
                r1 = 0x3f2200f4;
                lr = __ieee754_lgammaf_r + 758 | 1;
                bl(this::__aeabi_fadd, 758);
                return;
            case 758:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 764 | 1;
                bl(this::__aeabi_fmul, 764);
                return;
            case 764:
                r1 = 0x3d9e233f;
                lr = __ieee754_lgammaf_r + 770 | 1;
                bl(this::__aeabi_fsub, 770);
                return;
            case 770:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 776 | 1;
                bl(this::__aeabi_fmul, 776);
                return;
            case 776:
                r1 = 0x3b52d5db;
                r5 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 786 | 1;
                bl(this::__aeabi_fmul, 786);
                return;
            case 786:
                r1 = 0x3dd572af;
                lr = __ieee754_lgammaf_r + 792 | 1;
                bl(this::__aeabi_fadd, 792);
                return;
            case 792:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 798 | 1;
                bl(this::__aeabi_fmul, 798);
                return;
            case 798:
                r1 = 0x3f44efdf;
                lr = __ieee754_lgammaf_r + 804 | 1;
                bl(this::__aeabi_fadd, 804);
                return;
            case 804:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 810 | 1;
                bl(this::__aeabi_fmul, 810);
                return;
            case 810:
                r1 = 0x4008392d;
                lr = __ieee754_lgammaf_r + 816 | 1;
                bl(this::__aeabi_fadd, 816);
                return;
            case 816:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 822 | 1;
                bl(this::__aeabi_fmul, 822);
                return;
            case 822:
                r1 = 0x401d2ebe;
                lr = __ieee754_lgammaf_r + 828 | 1;
                bl(this::__aeabi_fadd, 828);
                return;
            case 828:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 834 | 1;
                bl(this::__aeabi_fmul, 834);
                return;
            case 834:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = __ieee754_lgammaf_r + 842 | 1;
                bl(this::__aeabi_fadd, 842);
                return;
            case 842:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = __ieee754_lgammaf_r + 850 | 1;
                bl(this::__aeabi_fdiv, 850);
                return;
            case 850:
                r1 = movs(r1, 191);
                r5 = adds(r0, 0);
                r1 = lsls(r1, 24);
                r0 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 862 | 1;
                bl(this::__aeabi_fmul, 862);
                return;
            case 862:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = __ieee754_lgammaf_r + 870 | 1;
                bl(this::__aeabi_fadd, 870);
                return;
            case 870:
                b(null, 1804);
                return;
            case 1024:
                r3 = 0x40ffffff;
                cmp(r5, r3);
                if (ble(null, 1032)) return;
            case 1030:
                b(null, 1394);
                return;
            case 1032:
                r0 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 1038 | 1;
                bl(this::__aeabi_f2iz, 1038);
                return;
            case 1038:
                r5 = movs(r5, r0);
                lr = __ieee754_lgammaf_r + 1044 | 1;
                bl(this::__aeabi_i2f, 1044);
                return;
            case 1044:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 1052 | 1;
                bl(this::__aeabi_fsub, 1052);
                return;
            case 1052:
                r1 = 0x3805ff67;
                r6 = adds(r0, 0);
                lr = __ieee754_lgammaf_r + 1060 | 1;
                bl(this::__aeabi_fmul, 1060);
                return;
            case 1060:
                r1 = 0x3af135b4;
                lr = __ieee754_lgammaf_r + 1066 | 1;
                bl(this::__aeabi_fadd, 1066);
                return;
            case 1066:
                r1 = adds(r6, 0);
                lr = __ieee754_lgammaf_r + 1072 | 1;
                bl(this::__aeabi_fmul, 1072);
                return;
            case 1072:
                r1 = 0x3cda40e4;
                lr = __ieee754_lgammaf_r + 1078 | 1;
                bl(this::__aeabi_fadd, 1078);
                return;
            case 1078:
                r1 = adds(r6, 0);
                lr = __ieee754_lgammaf_r + 1084 | 1;
                bl(this::__aeabi_fmul, 1084);
                return;
            case 1084:
                r1 = 0x3e15dce6;
                lr = __ieee754_lgammaf_r + 1090 | 1;
                bl(this::__aeabi_fadd, 1090);
                return;
            case 1090:
                r1 = adds(r6, 0);
                lr = __ieee754_lgammaf_r + 1096 | 1;
                bl(this::__aeabi_fmul, 1096);
                return;
            case 1096:
                r1 = 0x3ea6cc7a;
                lr = __ieee754_lgammaf_r + 1102 | 1;
                bl(this::__aeabi_fadd, 1102);
                return;
            case 1102:
                r1 = adds(r6, 0);
                lr = __ieee754_lgammaf_r + 1108 | 1;
                bl(this::__aeabi_fmul, 1108);
                return;
            case 1108:
                r1 = 0x3e5c245a;
                lr = __ieee754_lgammaf_r + 1114 | 1;
                bl(this::__aeabi_fadd, 1114);
                return;
            case 1114:
                r1 = adds(r6, 0);
                lr = __ieee754_lgammaf_r + 1120 | 1;
                bl(this::__aeabi_fmul, 1120);
                return;
            case 1120:
                r1 = 0x3d9e233f;
                lr = __ieee754_lgammaf_r + 1126 | 1;
                bl(this::__aeabi_fsub, 1126);
                return;
            case 1126:
                r1 = adds(r6, 0);
                lr = __ieee754_lgammaf_r + 1132 | 1;
                bl(this::__aeabi_fmul, 1132);
                return;
            case 1132:
                r1 = 0x36f5d7bd;
                r4 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = __ieee754_lgammaf_r + 1142 | 1;
                bl(this::__aeabi_fmul, 1142);
                return;
            case 1142:
                r1 = 0x3a4beed6;
                lr = __ieee754_lgammaf_r + 1148 | 1;
                bl(this::__aeabi_fadd, 1148);
                return;
            case 1148:
                r1 = adds(r6, 0);
                lr = __ieee754_lgammaf_r + 1154 | 1;
                bl(this::__aeabi_fmul, 1154);
                return;
            case 1154:
                r1 = 0x3c98bf54;
                lr = __ieee754_lgammaf_r + 1160 | 1;
                bl(this::__aeabi_fadd, 1160);
                return;
            case 1160:
                r1 = adds(r6, 0);
                lr = __ieee754_lgammaf_r + 1166 | 1;
                bl(this::__aeabi_fmul, 1166);
                return;
            case 1166:
                r1 = 0x3e300f6e;
                lr = __ieee754_lgammaf_r + 1172 | 1;
                bl(this::__aeabi_fadd, 1172);
                return;
            case 1172:
                r1 = adds(r6, 0);
                lr = __ieee754_lgammaf_r + 1178 | 1;
                bl(this::__aeabi_fmul, 1178);
                return;
            case 1178:
                r1 = 0x3f38d0c5;
                lr = __ieee754_lgammaf_r + 1184 | 1;
                bl(this::__aeabi_fadd, 1184);
                return;
            case 1184:
                r1 = adds(r6, 0);
                lr = __ieee754_lgammaf_r + 1190 | 1;
                bl(this::__aeabi_fmul, 1190);
                return;
            case 1190:
                r1 = 0x3fb22d3b;
                lr = __ieee754_lgammaf_r + 1196 | 1;
                bl(this::__aeabi_fadd, 1196);
                return;
            case 1196:
                r1 = adds(r6, 0);
                lr = __ieee754_lgammaf_r + 1202 | 1;
                bl(this::__aeabi_fmul, 1202);
                return;
            case 1202:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = __ieee754_lgammaf_r + 1210 | 1;
                bl(this::__aeabi_fadd, 1210);
                return;
            case 1210:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 1218 | 1;
                bl(this::__aeabi_fdiv, 1218);
                return;
            case 1218:
                r1 = movs(r1, 252);
                r4 = adds(r0, 0);
                r1 = lsls(r1, 22);
                r0 = adds(r6, 0);
                lr = __ieee754_lgammaf_r + 1230 | 1;
                bl(this::__aeabi_fmul, 1230);
                return;
            case 1230:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 1238 | 1;
                bl(this::__aeabi_fadd, 1238);
                return;
            case 1238:
                r4 = adds(r0, 0);
                cmp(r5, 5);
                if (beq(null, 1376)) return;
            case 1244:
                if (bgt(null, 1272)) return;
            case 1246:
                cmp(r5, 3);
                if (beq(null, 1388)) return;
            case 1250:
                cmp(r5, 4);
                if (beq(null, 1382)) return;
            case 1254:
                r3 = ldr(sp + 4);
                cmp(r3, 0);
                if (blt(null, 1262)) return;
            case 1260:
                b(null, 78);
                return;
            case 1262:
                r1 = adds(r4, 0);
                r0 = adds(r7, 0);
                lr = __ieee754_lgammaf_r + 1270 | 1;
                bl(this::__aeabi_fsub, 1270);
                return;
            case 1270:
                b(null, 28);
                return;
            case 1272:
                cmp(r5, 6);
                if (beq(null, 1370)) return;
            case 1276:
                cmp(r5, 7);
                if (bne(null, 1254)) return;
            case 1280:
                r1 = 0x40c00000;
                r0 = adds(r6, 0);
                lr = __ieee754_lgammaf_r + 1288 | 1;
                bl(this::__aeabi_fadd, 1288);
                return;
            case 1288:
                r5 = adds(r0, 0);
            case 1290:
                r1 = 0x40a00000;
                r0 = adds(r6, 0);
                lr = __ieee754_lgammaf_r + 1298 | 1;
                bl(this::__aeabi_fadd, 1298);
                return;
            case 1298:
                r1 = adds(r5, 0);
                lr = __ieee754_lgammaf_r + 1304 | 1;
                bl(this::__aeabi_fmul, 1304);
                return;
            case 1304:
                r5 = adds(r0, 0);
            case 1306:
                r1 = movs(r1, 129);
                r0 = adds(r6, 0);
                r1 = lsls(r1, 23);
                lr = __ieee754_lgammaf_r + 1316 | 1;
                bl(this::__aeabi_fadd, 1316);
                return;
            case 1316:
                r1 = adds(r5, 0);
                lr = __ieee754_lgammaf_r + 1322 | 1;
                bl(this::__aeabi_fmul, 1322);
                return;
            case 1322:
                r5 = adds(r0, 0);
            case 1324:
                r1 = 0x40400000;
                r0 = adds(r6, 0);
                lr = __ieee754_lgammaf_r + 1332 | 1;
                bl(this::__aeabi_fadd, 1332);
                return;
            case 1332:
                r1 = adds(r5, 0);
                lr = __ieee754_lgammaf_r + 1338 | 1;
                bl(this::__aeabi_fmul, 1338);
                return;
            case 1338:
                r5 = adds(r0, 0);
            case 1340:
                r1 = movs(r1, 128);
                r0 = adds(r6, 0);
                r1 = lsls(r1, 23);
                lr = __ieee754_lgammaf_r + 1350 | 1;
                bl(this::__aeabi_fadd, 1350);
                return;
            case 1350:
                r1 = adds(r5, 0);
                lr = __ieee754_lgammaf_r + 1356 | 1;
                bl(this::__aeabi_fmul, 1356);
                return;
            case 1356:
                lr = __ieee754_lgammaf_r + 1360 | 1;
                bl(this::logf, 1360);
                return;
            case 1360:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
            case 1364:
                lr = __ieee754_lgammaf_r + 1368 | 1;
                bl(this::__aeabi_fadd, 1368);
                return;
            case 1368:
                b(null, 1556);
                return;
            case 1370:
                r5 = movs(r5, 254);
                r5 = lsls(r5, 22);
                b(null, 1290);
                return;
            case 1376:
                r5 = movs(r5, 254);
                r5 = lsls(r5, 22);
                b(null, 1306);
                return;
            case 1382:
                r5 = movs(r5, 254);
                r5 = lsls(r5, 22);
                b(null, 1324);
                return;
            case 1388:
                r5 = movs(r5, 254);
                r5 = lsls(r5, 22);
                b(null, 1340);
                return;
            case 1394:
                r3 = 0x5c7fffff;
                r0 = adds(r4, 0);
                cmp(r5, r3);
                if (bgt(null, 1538)) return;
            case 1402:
                lr = __ieee754_lgammaf_r + 1406 | 1;
                bl(this::logf, 1406);
                return;
            case 1406:
                str(sp, r0);
                r0 = movs(r0, 254);
                r1 = adds(r4, 0);
                r0 = lsls(r0, 22);
                lr = __ieee754_lgammaf_r + 1418 | 1;
                bl(this::__aeabi_fdiv, 1418);
                return;
            case 1418:
                r1 = adds(r0, 0);
                r6 = adds(r0, 0);
                lr = __ieee754_lgammaf_r + 1426 | 1;
                bl(this::__aeabi_fmul, 1426);
                return;
            case 1426:
                r1 = 0xbad5c4e8;
                r5 = adds(r0, 0);
                lr = __ieee754_lgammaf_r + 1434 | 1;
                bl(this::__aeabi_fmul, 1434);
                return;
            case 1434:
                r1 = 0x3a5b3dd2;
                lr = __ieee754_lgammaf_r + 1440 | 1;
                bl(this::__aeabi_fadd, 1440);
                return;
            case 1440:
                r1 = adds(r5, 0);
                lr = __ieee754_lgammaf_r + 1446 | 1;
                bl(this::__aeabi_fmul, 1446);
                return;
            case 1446:
                r1 = 0x3a1c065c;
                lr = __ieee754_lgammaf_r + 1452 | 1;
                bl(this::__aeabi_fsub, 1452);
                return;
            case 1452:
                r1 = adds(r5, 0);
                lr = __ieee754_lgammaf_r + 1458 | 1;
                bl(this::__aeabi_fmul, 1458);
                return;
            case 1458:
                r1 = 0x3a500cfd;
                lr = __ieee754_lgammaf_r + 1464 | 1;
                bl(this::__aeabi_fadd, 1464);
                return;
            case 1464:
                r1 = adds(r5, 0);
                lr = __ieee754_lgammaf_r + 1470 | 1;
                bl(this::__aeabi_fmul, 1470);
                return;
            case 1470:
                r1 = 0x3b360b61;
                lr = __ieee754_lgammaf_r + 1476 | 1;
                bl(this::__aeabi_fsub, 1476);
                return;
            case 1476:
                r1 = adds(r5, 0);
                lr = __ieee754_lgammaf_r + 1482 | 1;
                bl(this::__aeabi_fmul, 1482);
                return;
            case 1482:
                r1 = 0x3daaaaab;
                lr = __ieee754_lgammaf_r + 1488 | 1;
                bl(this::__aeabi_fadd, 1488);
                return;
            case 1488:
                r1 = adds(r6, 0);
                lr = __ieee754_lgammaf_r + 1494 | 1;
                bl(this::__aeabi_fmul, 1494);
                return;
            case 1494:
                r1 = 0x3ed67f1d;
                lr = __ieee754_lgammaf_r + 1500 | 1;
                bl(this::__aeabi_fadd, 1500);
                return;
            case 1500:
                r1 = movs(r1, 252);
                r5 = adds(r0, 0);
                r1 = lsls(r1, 22);
                r0 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 1512 | 1;
                bl(this::__aeabi_fsub, 1512);
                return;
            case 1512:
                r1 = movs(r1, 254);
                r4 = adds(r0, 0);
                r1 = lsls(r1, 22);
                r0 = ldr(sp);
                lr = __ieee754_lgammaf_r + 1524 | 1;
                bl(this::__aeabi_fsub, 1524);
                return;
            case 1524:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 1532 | 1;
                bl(this::__aeabi_fmul, 1532);
                return;
            case 1532:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                b(null, 1364);
                return;
            case 1538:
                lr = __ieee754_lgammaf_r + 1542 | 1;
                bl(this::logf, 1542);
                return;
            case 1542:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = __ieee754_lgammaf_r + 1550 | 1;
                bl(this::__aeabi_fsub, 1550);
                return;
            case 1550:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 1556 | 1;
                bl(this::__aeabi_fmul, 1556);
                return;
            case 1556:
                r4 = adds(r0, 0);
                b(null, 1254);
                return;
            case 1560:
                r3 = movs(r3, 254);
                r3 = lsls(r3, 22);
                cmp(r5, r3);
                if (bne(null, 1808)) return;
            case 1568:
                r4 = movs(r4, 0);
                b(null, 78);
                return;
            case 1572:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 23);
                cmp(r5, r3);
                if (bne(null, 1582)) return;
            case 1580:
                b(null, 200);
                return;
            case 1582:
                r3 = 0x3fffffff;
                cmp(r5, r3);
                if (ble(null, 1590)) return;
            case 1588:
                b(null, 1024);
                return;
            case 1590:
                r3 = 0x3f666666;
                cmp(r5, r3);
                if (ble(null, 1598)) return;
            case 1596:
                b(null, 652);
                return;
            case 1598:
                r0 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 1604 | 1;
                bl(this::logf, 1604);
                return;
            case 1604:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 24);
                r6 = adds(r0, r3);
                r3 = 0x3f3b4a1f;
                cmp(r5, r3);
                if (bgt(null, 1618)) return;
            case 1616:
                b(null, 418);
                return;
            case 1618:
                r0 = movs(r0, 254);
                r1 = adds(r4, 0);
                r0 = lsls(r0, 22);
                lr = __ieee754_lgammaf_r + 1628 | 1;
                bl(this::__aeabi_fsub, 1628);
                return;
            case 1628:
                r5 = adds(r0, 0);
            case 1630:
                r1 = adds(r5, 0);
                r0 = adds(r5, 0);
                lr = __ieee754_lgammaf_r + 1638 | 1;
                bl(this::__aeabi_fmul, 1638);
                return;
            case 1638:
                r1 = 0x37d383a2;
                r4 = adds(r0, 0);
                lr = __ieee754_lgammaf_r + 1646 | 1;
                bl(this::__aeabi_fmul, 1646);
                return;
            case 1646:
                r1 = 0x39679767;
                lr = __ieee754_lgammaf_r + 1652 | 1;
                bl(this::__aeabi_fadd, 1652);
                return;
            case 1652:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 1658 | 1;
                bl(this::__aeabi_fmul, 1658);
                return;
            case 1658:
                r1 = 0x3a9c54a1;
                lr = __ieee754_lgammaf_r + 1664 | 1;
                bl(this::__aeabi_fadd, 1664);
                return;
            case 1664:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 1670 | 1;
                bl(this::__aeabi_fmul, 1670);
                return;
            case 1670:
                r1 = 0x3bf2027e;
                lr = __ieee754_lgammaf_r + 1676 | 1;
                bl(this::__aeabi_fadd, 1676);
                return;
            case 1676:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 1682 | 1;
                bl(this::__aeabi_fmul, 1682);
                return;
            case 1682:
                r1 = 0x3d89f001;
                lr = __ieee754_lgammaf_r + 1688 | 1;
                bl(this::__aeabi_fadd, 1688);
                return;
            case 1688:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 1694 | 1;
                bl(this::__aeabi_fmul, 1694);
                return;
            case 1694:
                r1 = 0x3d9e233f;
                lr = __ieee754_lgammaf_r + 1700 | 1;
                bl(this::__aeabi_fadd, 1700);
                return;
            case 1700:
                r1 = adds(r5, 0);
                lr = __ieee754_lgammaf_r + 1706 | 1;
                bl(this::__aeabi_fmul, 1706);
                return;
            case 1706:
                r1 = 0x383c2c75;
                str(sp, r0);
                r0 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 1716 | 1;
                bl(this::__aeabi_fmul, 1716);
                return;
            case 1716:
                r1 = 0x38e28445;
                lr = __ieee754_lgammaf_r + 1722 | 1;
                bl(this::__aeabi_fadd, 1722);
                return;
            case 1722:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 1728 | 1;
                bl(this::__aeabi_fmul, 1728);
                return;
            case 1728:
                r1 = 0x3a05b634;
                lr = __ieee754_lgammaf_r + 1734 | 1;
                bl(this::__aeabi_fadd, 1734);
                return;
            case 1734:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 1740 | 1;
                bl(this::__aeabi_fmul, 1740);
                return;
            case 1740:
                r1 = 0x3b3d6ec6;
                lr = __ieee754_lgammaf_r + 1746 | 1;
                bl(this::__aeabi_fadd, 1746);
                return;
            case 1746:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 1752 | 1;
                bl(this::__aeabi_fmul, 1752);
                return;
            case 1752:
                r1 = 0x3ca89915;
                lr = __ieee754_lgammaf_r + 1758 | 1;
                bl(this::__aeabi_fadd, 1758);
                return;
            case 1758:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 1764 | 1;
                bl(this::__aeabi_fmul, 1764);
                return;
            case 1764:
                r1 = 0x3ea51a66;
                lr = __ieee754_lgammaf_r + 1770 | 1;
                bl(this::__aeabi_fadd, 1770);
                return;
            case 1770:
                r1 = adds(r4, 0);
                lr = __ieee754_lgammaf_r + 1776 | 1;
                bl(this::__aeabi_fmul, 1776);
                return;
            case 1776:
                r1 = adds(r0, 0);
                r0 = ldr(sp);
                lr = __ieee754_lgammaf_r + 1784 | 1;
                bl(this::__aeabi_fadd, 1784);
                return;
            case 1784:
                r1 = movs(r1, 252);
                r4 = adds(r0, 0);
                r1 = lsls(r1, 22);
                r0 = adds(r5, 0);
                lr = __ieee754_lgammaf_r + 1796 | 1;
                bl(this::__aeabi_fmul, 1796);
                return;
            case 1796:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
            case 1800:
                lr = __ieee754_lgammaf_r + 1804 | 1;
                bl(this::__aeabi_fsub, 1804);
                return;
            case 1804:
                r1 = adds(r6, 0);
                b(null, 1364);
                return;
            case 1808:
                r3 = movs(r3, 128);
                r7 = movs(r7, 0);
                r3 = lsls(r3, 23);
                cmp(r5, r3);
                if (bne(null, 1582)) return;
            case 1818:
                b(null, 1568);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134335436, size=208, name='fmodf', path='build/lib/libm/fmodf.o', has_indirect=True)
    protected void fmodf(int offset) throws Exception
    {
        pc = fmodf + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r5 = adds(r0, 0);
                r4 = adds(r1, 0);
                r6 = lsls(r1, 1);
                if (beq(null, 30)) return;
            case 10:
                r0 = adds(r1, 0);
                lr = fmodf + 16 | 1;
                bl(this::__aeabi_fcmpun, 16);
                return;
            case 16:
                cmp(r0, 0);
                if (bne(null, 30)) return;
            case 20:
                r3 = lsrs(r5, 23);
                r3 = uxtb(r3);
                r2 = movs(r2, r5);
                cmp(r3, 255);
                if (bne(null, 50)) return;
            case 30:
                r1 = adds(r4, 0);
                r0 = adds(r5, 0);
                lr = fmodf + 38 | 1;
                bl(this::__aeabi_fmul, 38);
                return;
            case 38:
                r1 = adds(r0, 0);
                lr = fmodf + 44 | 1;
                bl(this::__aeabi_fdiv, 44);
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
                if (blo(null, 68)) return;
            case 56:
                if (bne(null, 46)) return;
            case 58:
                r1 = movs(r1, 0);
                r0 = adds(r5, 0);
                lr = fmodf + 66 | 1;
                bl(this::__aeabi_fmul, 66);
                return;
            case 66:
                b(null, 44);
                return;
            case 68:
                r0 = lsls(r5, 9);
                cmp(r3, 0);
                if (bne(null, 150)) return;
            case 74:
                cmp(r0, 0);
                if (bge(null, 144)) return;
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
                if (bne(null, 166)) return;
            case 96:
                cmp(r1, 0);
                if (bge(null, 160)) return;
            case 100:
                r1 = movs(r1, 1);
                r1 = subs(r1, r6);
                r4 = lsls(r4, r1);
            case 106:
                r1 = subs(r0, r4);
                cmp(r3, r6);
                if (bgt(null, 176)) return;
            case 112:
                cmp(r1, 0);
                if (blt(null, 120)) return;
            case 116:
                r0 = subs(r1, 0);
                if (beq(null, 58)) return;
            case 120:
                r1 = lsrs(r0, 23);
                if (beq(null, 190)) return;
            case 124:
                cmp(r3, 0);
                if (ble(null, 196)) return;
            case 128:
                r1 = 0xff800000;
                r1 = adds(r0, r1);
                r0 = lsls(r3, 23);
                r0 = orrs(r0, r1);
            case 136:
                r5 = lsrs(r2, 31);
                r5 = lsls(r5, 31);
                r5 = orrs(r5, r0);
                b(null, 46);
                return;
            case 144:
                r3 = subs(r3, 1);
                r0 = lsls(r0, 1);
                b(null, 74);
                return;
            case 150:
                r1 = movs(r1, 128);
                r0 = lsrs(r0, 9);
                r1 = lsls(r1, 16);
                r0 = orrs(r0, r1);
                b(null, 86);
                return;
            case 160:
                r6 = subs(r6, 1);
                r1 = lsls(r1, 1);
                b(null, 96);
                return;
            case 166:
                r4 = movs(r4, 128);
                r1 = lsrs(r1, 9);
                r4 = lsls(r4, 16);
                r4 = orrs(r4, r1);
                b(null, 106);
                return;
            case 176:
                cmp(r1, 0);
                if (blt(null, 184)) return;
            case 180:
                if (beq(null, 58)) return;
            case 182:
                r0 = movs(r0, r1);
            case 184:
                r0 = lsls(r0, 1);
                r3 = subs(r3, 1);
                b(null, 106);
                return;
            case 190:
                r0 = lsls(r0, 1);
                r3 = subs(r3, 1);
                b(null, 120);
                return;
            case 196:
                r1 = movs(r1, 1);
                r3 = subs(r1, r3);
                r0 = lsrs(r0, r3);
                b(null, 136);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134335644, size=260, name='__kernel_cosf', path='build/lib/libm/kf_cos.o', has_indirect=False)
    protected void __kernel_cosf(int offset) throws Exception
    {
        pc = __kernel_cosf + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r4, r5, r6, r7);
                r3 = 0x31ffffff;
                r4 = lsls(r0, 1);
                r6 = adds(r0, 0);
                str(sp + 4, r1);
                r4 = lsrs(r4, 1);
                cmp(r4, r3);
                if (bgt(null, 24)) return;
            case 16:
                lr = __kernel_cosf + 20 | 1;
                bl(this::__aeabi_f2iz, 20);
                return;
            case 20:
                cmp(r0, 0);
                if (beq(null, 212)) return;
            case 24:
                r1 = adds(r6, 0);
                r0 = adds(r6, 0);
                lr = __kernel_cosf + 32 | 1;
                bl(this::__aeabi_fmul, 32);
                return;
            case 32:
                r1 = movs(r1, 252);
                r1 = lsls(r1, 22);
                r5 = adds(r0, 0);
                lr = __kernel_cosf + 42 | 1;
                bl(this::__aeabi_fmul, 42);
                return;
            case 42:
                r1 = 0xad47d74e;
                r7 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = __kernel_cosf + 52 | 1;
                bl(this::__aeabi_fmul, 52);
                return;
            case 52:
                r1 = 0x310f74f6;
                lr = __kernel_cosf + 58 | 1;
                bl(this::__aeabi_fadd, 58);
                return;
            case 58:
                r1 = adds(r5, 0);
                lr = __kernel_cosf + 64 | 1;
                bl(this::__aeabi_fmul, 64);
                return;
            case 64:
                r1 = 0x3493f27c;
                lr = __kernel_cosf + 70 | 1;
                bl(this::__aeabi_fsub, 70);
                return;
            case 70:
                r1 = adds(r5, 0);
                lr = __kernel_cosf + 76 | 1;
                bl(this::__aeabi_fmul, 76);
                return;
            case 76:
                r1 = 0x37d00d01;
                lr = __kernel_cosf + 82 | 1;
                bl(this::__aeabi_fadd, 82);
                return;
            case 82:
                r1 = adds(r5, 0);
                lr = __kernel_cosf + 88 | 1;
                bl(this::__aeabi_fmul, 88);
                return;
            case 88:
                r1 = 0x3ab60b61;
                lr = __kernel_cosf + 94 | 1;
                bl(this::__aeabi_fsub, 94);
                return;
            case 94:
                r1 = adds(r5, 0);
                lr = __kernel_cosf + 100 | 1;
                bl(this::__aeabi_fmul, 100);
                return;
            case 100:
                r1 = 0x3d2aaaab;
                lr = __kernel_cosf + 106 | 1;
                bl(this::__aeabi_fadd, 106);
                return;
            case 106:
                r1 = adds(r5, 0);
                lr = __kernel_cosf + 112 | 1;
                bl(this::__aeabi_fmul, 112);
                return;
            case 112:
                r1 = adds(r5, 0);
                lr = __kernel_cosf + 118 | 1;
                bl(this::__aeabi_fmul, 118);
                return;
            case 118:
                r1 = ldr(sp + 4);
                r5 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = __kernel_cosf + 128 | 1;
                bl(this::__aeabi_fmul, 128);
                return;
            case 128:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = __kernel_cosf + 136 | 1;
                bl(this::__aeabi_fsub, 136);
                return;
            case 136:
                r3 = 0x3e999999;
                r5 = adds(r0, 0);
                cmp(r4, r3);
                if (bgt(null, 164)) return;
            case 144:
                r1 = adds(r0, 0);
                r0 = adds(r7, 0);
                lr = __kernel_cosf + 152 | 1;
                bl(this::__aeabi_fsub, 152);
                return;
            case 152:
                r1 = adds(r0, 0);
                r0 = movs(r0, 254);
                r0 = lsls(r0, 22);
            case 158:
                lr = __kernel_cosf + 162 | 1;
                bl(this::__aeabi_fsub, 162);
                return;
            case 162:
                pop(true, R1, R2, R3, R4, R5, R6, R7);
                return;
            case 164:
                r3 = 0x3f480000;
                cmp(r4, r3);
                if (bgt(null, 208)) return;
            case 170:
                r3 = movs(r3, 255);
                r3 = lsls(r3, 24);
                r4 = adds(r4, r3);
            case 176:
                r0 = movs(r0, 254);
                r1 = adds(r4, 0);
                r0 = lsls(r0, 22);
                lr = __kernel_cosf + 186 | 1;
                bl(this::__aeabi_fsub, 186);
                return;
            case 186:
                r1 = adds(r4, 0);
                r6 = adds(r0, 0);
                r0 = adds(r7, 0);
                lr = __kernel_cosf + 196 | 1;
                bl(this::__aeabi_fsub, 196);
                return;
            case 196:
                r1 = adds(r5, 0);
                lr = __kernel_cosf + 202 | 1;
                bl(this::__aeabi_fsub, 202);
                return;
            case 202:
                r1 = adds(r0, 0);
                r0 = adds(r6, 0);
                b(null, 158);
                return;
            case 208:
                r4 = 0x3e900000;
                b(null, 176);
                return;
            case 212:
                r0 = movs(r0, 254);
                r0 = lsls(r0, 22);
                b(null, 162);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134335904, size=1428, name='__kernel_rem_pio2f', path='build/lib/libm/kf_rem_pio2.o', has_indirect=False)
    protected void __kernel_rem_pio2f(int offset) throws Exception
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
                r3 = init_jk;
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
                if (ble(null, 344)) return;
            case 88:
                r5 = movs(r5, 0);
                r3 = ldr(sp + 32);
                r4 = lsls(r3, 2);
                r3 = add(sp, 136);
                r4 = adds(r3, r4);
            case 98:
                r3 = ldr(sp + 24);
                cmp(r5, r3);
                if (bgt(null, 106)) return;
            case 104:
                b(null, 416);
                return;
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
                if (ble(null, 140)) return;
            case 138:
                b(null, 422);
                return;
            case 140:
                r1 = ldr(sp + 4);
                r0 = adds(r4, 0);
                lr = __kernel_rem_pio2f + 148 | 1;
                bl(this::scalbnf, 148);
                return;
            case 148:
                r1 = movs(r1, 248);
                r1 = lsls(r1, 22);
                r4 = adds(r0, 0);
                lr = __kernel_rem_pio2f + 158 | 1;
                bl(this::__aeabi_fmul, 158);
                return;
            case 158:
                lr = __kernel_rem_pio2f + 162 | 1;
                bl(this::floorf, 162);
                return;
            case 162:
                r1 = movs(r1, 130);
                r1 = lsls(r1, 23);
                lr = __kernel_rem_pio2f + 170 | 1;
                bl(this::__aeabi_fmul, 170);
                return;
            case 170:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = __kernel_rem_pio2f + 178 | 1;
                bl(this::__aeabi_fsub, 178);
                return;
            case 178:
                r4 = adds(r0, 0);
                lr = __kernel_rem_pio2f + 184 | 1;
                bl(this::__aeabi_f2iz, 184);
                return;
            case 184:
                str(sp + 20, r0);
                lr = __kernel_rem_pio2f + 190 | 1;
                bl(this::__aeabi_i2f, 190);
                return;
            case 190:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = __kernel_rem_pio2f + 198 | 1;
                bl(this::__aeabi_fsub, 198);
                return;
            case 198:
                r3 = ldr(sp + 4);
                r4 = adds(r0, 0);
                cmp(r3, 0);
                if (bgt(null, 208)) return;
            case 206:
                b(null, 492);
                return;
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
                if (bgt(null, 258)) return;
            case 256:
                b(null, 526);
                return;
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
                if (ble(null, 282)) return;
            case 280:
                b(null, 656);
                return;
            case 282:
                r3 = ldr(sp + 4);
                cmp(r3, 0);
                if (ble(null, 300)) return;
            case 288:
                cmp(r3, 1);
                if (bne(null, 294)) return;
            case 292:
                b(null, 696);
                return;
            case 294:
                cmp(r3, 2);
                if (bne(null, 300)) return;
            case 298:
                b(null, 718);
                return;
            case 300:
                r3 = ldr(sp + 8);
                cmp(r3, 2);
                if (bne(null, 526)) return;
            case 306:
                r0 = movs(r0, 254);
                r1 = adds(r4, 0);
                r0 = lsls(r0, 22);
                lr = __kernel_rem_pio2f + 316 | 1;
                bl(this::__aeabi_fsub, 316);
                return;
            case 316:
                r4 = adds(r0, 0);
                cmp(r5, 0);
                if (beq(null, 526)) return;
            case 322:
                r0 = movs(r0, 254);
                r1 = ldr(sp + 4);
                r0 = lsls(r0, 22);
                lr = __kernel_rem_pio2f + 332 | 1;
                bl(this::scalbnf, 332);
                return;
            case 332:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = __kernel_rem_pio2f + 340 | 1;
                bl(this::__aeabi_fsub, 340);
                return;
            case 340:
                r4 = adds(r0, 0);
                b(null, 526);
                return;
            case 344:
                r0 = movs(r0, 0);
                cmn(r6, r4);
                if (bmi(null, 358)) return;
            case 350:
                r3 = lsls(r4, 2);
                r0 = ldr(r5 + r3);
                lr = __kernel_rem_pio2f + 358 | 1;
                bl(this::__aeabi_i2f, 358);
                return;
            case 358:
                r3 = lsls(r4, 2);
                str(r3 + r7, r0);
                r4 = adds(r4, 1);
                b(null, 82);
                return;
            case 366:
                r2 = lsls(r6, 2);
                r3 = subs(r4, r2);
                r1 = ldr(sp + 36);
                r3 = subs(r3, 4);
                r1 = ldr(r1 + r2);
                r0 = ldr(r3);
                lr = __kernel_rem_pio2f + 382 | 1;
                bl(this::__aeabi_fmul, 382);
                return;
            case 382:
                r1 = adds(r0, 0);
                r0 = adds(r7, 0);
                lr = __kernel_rem_pio2f + 390 | 1;
                bl(this::__aeabi_fadd, 390);
                return;
            case 390:
                r6 = adds(r6, 1);
                r7 = adds(r0, 0);
            case 394:
                r3 = ldr(sp + 28);
                cmp(r6, r3);
                if (ble(null, 366)) return;
            case 400:
                r1 = movs(r1, 240);
                r2 = add(sp, 56);
                r3 = lsls(r5, 2);
                r2 = adds(r2, r1);
                str(r2 + r3, r7);
                r5 = adds(r5, 1);
                r4 = adds(r4, 4);
                b(null, 98);
                return;
            case 416:
                r7 = movs(r7, 0);
                r6 = movs(r6, 0);
                b(null, 394);
                return;
            case 422:
                r1 = movs(r1, 238);
                r0 = adds(r4, 0);
                r1 = lsls(r1, 22);
                lr = __kernel_rem_pio2f + 432 | 1;
                bl(this::__aeabi_fmul, 432);
                return;
            case 432:
                lr = __kernel_rem_pio2f + 436 | 1;
                bl(this::__aeabi_f2iz, 436);
                return;
            case 436:
                lr = __kernel_rem_pio2f + 440 | 1;
                bl(this::__aeabi_i2f, 440);
                return;
            case 440:
                r1 = movs(r1, 135);
                r3 = lsls(r6, 2);
                r3 = rsbs(r3, 0);
                r1 = lsls(r1, 23);
                str(sp + 20, r3);
                r5 = adds(r0, 0);
                lr = __kernel_rem_pio2f + 456 | 1;
                bl(this::__aeabi_fmul, 456);
                return;
            case 456:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = __kernel_rem_pio2f + 464 | 1;
                bl(this::__aeabi_fsub, 464);
                return;
            case 464:
                lr = __kernel_rem_pio2f + 468 | 1;
                bl(this::__aeabi_f2iz, 468);
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
                lr = __kernel_rem_pio2f + 488 | 1;
                bl(this::__aeabi_fadd, 488);
                return;
            case 488:
                r4 = adds(r0, 0);
                b(null, 134);
                return;
            case 492:
                r3 = ldr(sp + 4);
                cmp(r3, 0);
                if (bne(null, 512)) return;
            case 498:
                r3 = subs(r7, 1);
                r3 = lsls(r3, 2);
                r2 = add(sp, 56);
                r0 = ldr(r3 + r2);
                r3 = asrs(r0, 8);
                str(sp + 8, r3);
                b(null, 250);
                return;
            case 512:
                r1 = movs(r1, 252);
                r1 = lsls(r1, 22);
                lr = __kernel_rem_pio2f + 520 | 1;
                bl(this::__aeabi_fcmpge, 520);
                return;
            case 520:
                cmp(r0, 0);
                if (bne(null, 650)) return;
            case 524:
                str(sp + 8, r0);
            case 526:
                r1 = movs(r1, 0);
                r0 = adds(r4, 0);
                lr = __kernel_rem_pio2f + 534 | 1;
                bl(this::__aeabi_fcmpeq, 534);
                return;
            case 534:
                cmp(r0, 0);
                if (bne(null, 540)) return;
            case 538:
                b(null, 892);
                return;
            case 540:
                r3 = movs(r3, r7);
                r2 = movs(r2, 0);
                r1 = subs(r7, 1);
            case 546:
                r0 = ldr(sp + 24);
                r3 = subs(r3, 1);
                cmp(r0, r3);
                if (ble(null, 732)) return;
            case 554:
                cmp(r2, 0);
                if (bne(null, 560)) return;
            case 558:
                b(null, 844);
                return;
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
                if (bne(null, 580)) return;
            case 578:
                b(null, 882);
                return;
            case 580:
                r0 = movs(r0, 254);
                r1 = ldr(sp + 4);
                r0 = lsls(r0, 22);
                lr = __kernel_rem_pio2f + 590 | 1;
                bl(this::scalbnf, 590);
                return;
            case 590:
                r3 = lsls(r7, 2);
                r5 = movs(r5, r3);
                r6 = movs(r6, r7);
                r4 = adds(r0, 0);
                str(sp + 4, r3);
            case 600:
                cmp(r6, 0);
                if (blt(null, 606)) return;
            case 604:
                b(null, 998);
                return;
            case 606:
                r5 = movs(r5, 0);
                r2 = ldr(sp + 4);
                r3 = add(sp, 296);
                r4 = adds(r3, r2);
            case 614:
                r3 = subs(r7, r5);
                if (bmi(null, 620)) return;
            case 618:
                b(null, 1090);
                return;
            case 620:
                r3 = ldr(sp + 400);
                cmp(r3, 2);
                if (ble(null, 628)) return;
            case 626:
                b(null, 1098);
                return;
            case 628:
                cmp(r3, 0);
                if (ble(null, 634)) return;
            case 632:
                b(null, 1216);
                return;
            case 634:
                if (bne(null, 638)) return;
            case 636:
                b(null, 1144);
                return;
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
                b(null, 258);
                return;
            case 656:
                r1 = lsls(r2, 2);
                r3 = add(sp, 56);
                r3 = ldr(r1 + r3);
                cmp(r5, 0);
                if (bne(null, 684)) return;
            case 666:
                cmp(r3, 0);
                if (beq(null, 678)) return;
            case 670:
                r3 = subs(r6, r3);
                r5 = add(sp, 56);
                str(r1 + r5, r3);
                r3 = mov(r12);
            case 678:
                r2 = adds(r2, 1);
                r5 = movs(r5, r3);
                b(null, 276);
                return;
            case 684:
                r0 = movs(r0, 255);
                r3 = subs(r0, r3);
                r0 = add(sp, 56);
                str(r1 + r0, r3);
                r3 = movs(r3, r5);
                b(null, 678);
                return;
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
                b(null, 300);
                return;
            case 718:
                r3 = subs(r7, 1);
                r3 = lsls(r3, 2);
                r2 = add(sp, 56);
                r2 = ldr(r3 + r2);
                str(sp + 40, r2);
                r2 = movs(r2, 63);
                b(null, 708);
                return;
            case 732:
                r0 = lsls(r3, 2);
                r4 = add(sp, 56);
                r0 = ldr(r0 + r4);
                r2 = orrs(r2, r0);
                b(null, 546);
                return;
            case 742:
                r3 = adds(r3, 1);
            case 744:
                r2 = lsls(r3, 2);
                r1 = ldr(sp + 48);
                r2 = rsbs(r2, 0);
                r2 = ldr(r1 + r2);
                cmp(r2, 0);
                if (beq(null, 742)) return;
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
                if (bge(null, 792)) return;
            case 790:
                b(null, 116);
                return;
            case 792:
                r3 = ldr(sp + 40);
                r2 = ldr(sp + 404);
                r3 = adds(r4, r3);
                r3 = adds(r2, r3);
                r0 = ldr(r3 + 4);
                lr = __kernel_rem_pio2f + 806 | 1;
                bl(this::__aeabi_i2f, 806);
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
                if (ble(null, 852)) return;
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
                b(null, 784);
                return;
            case 844:
                r3 = movs(r3, 1);
                b(null, 744);
                return;
            case 852:
                r3 = lsls(r5, 2);
                r1 = ldr(sp + 44);
                r2 = rsbs(r3, 0);
                r1 = ldr(r1 + r2);
                r2 = ldr(sp + 36);
                r5 = adds(r5, 1);
                r0 = ldr(r2 + r3);
                lr = __kernel_rem_pio2f + 870 | 1;
                bl(this::__aeabi_fmul, 870);
                return;
            case 870:
                r1 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = __kernel_rem_pio2f + 878 | 1;
                bl(this::__aeabi_fadd, 878);
                return;
            case 878:
                r6 = adds(r0, 0);
                b(null, 818);
                return;
            case 882:
                r3 = ldr(sp + 4);
                r7 = subs(r7, 1);
                r3 = subs(r3, 8);
                str(sp + 4, r3);
                b(null, 568);
                return;
            case 892:
                r3 = ldr(sp + 4);
                r0 = adds(r4, 0);
                r1 = rsbs(r3, 0);
                lr = __kernel_rem_pio2f + 902 | 1;
                bl(this::scalbnf, 902);
                return;
            case 902:
                r1 = movs(r1, 135);
                r1 = lsls(r1, 23);
                r4 = adds(r0, 0);
                lr = __kernel_rem_pio2f + 912 | 1;
                bl(this::__aeabi_fcmpge, 912);
                return;
            case 912:
                cmp(r0, 0);
                if (beq(null, 984)) return;
            case 916:
                r1 = movs(r1, 238);
                r0 = adds(r4, 0);
                r1 = lsls(r1, 22);
                lr = __kernel_rem_pio2f + 926 | 1;
                bl(this::__aeabi_fmul, 926);
                return;
            case 926:
                lr = __kernel_rem_pio2f + 930 | 1;
                bl(this::__aeabi_f2iz, 930);
                return;
            case 930:
                lr = __kernel_rem_pio2f + 934 | 1;
                bl(this::__aeabi_i2f, 934);
                return;
            case 934:
                r1 = movs(r1, 135);
                r1 = lsls(r1, 23);
                r5 = adds(r0, 0);
                lr = __kernel_rem_pio2f + 944 | 1;
                bl(this::__aeabi_fmul, 944);
                return;
            case 944:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = __kernel_rem_pio2f + 952 | 1;
                bl(this::__aeabi_fsub, 952);
                return;
            case 952:
                lr = __kernel_rem_pio2f + 956 | 1;
                bl(this::__aeabi_f2iz, 956);
                return;
            case 956:
                r6 = lsls(r7, 2);
                r3 = add(sp, 56);
                str(r6 + r3, r0);
                r3 = ldr(sp + 4);
                r0 = adds(r5, 0);
                r3 = adds(r3, 8);
                str(sp + 4, r3);
                lr = __kernel_rem_pio2f + 974 | 1;
                bl(this::__aeabi_f2iz, 974);
                return;
            case 974:
                r7 = adds(r7, 1);
                r4 = lsls(r7, 2);
                r3 = add(sp, 56);
                str(r4 + r3, r0);
                b(null, 580);
                return;
            case 984:
                r0 = adds(r4, 0);
                lr = __kernel_rem_pio2f + 990 | 1;
                bl(this::__aeabi_f2iz, 990);
                return;
            case 990:
                r5 = lsls(r7, 2);
                r3 = add(sp, 56);
                str(r5 + r3, r0);
                b(null, 580);
                return;
            case 998:
                r3 = add(sp, 56);
                r0 = ldr(r5 + r3);
                lr = __kernel_rem_pio2f + 1006 | 1;
                bl(this::__aeabi_i2f, 1006);
                return;
            case 1006:
                r1 = adds(r4, 0);
                lr = __kernel_rem_pio2f + 1012 | 1;
                bl(this::__aeabi_fmul, 1012);
                return;
            case 1012:
                r2 = movs(r2, 240);
                r1 = movs(r1, 238);
                r3 = add(sp, 56);
                r3 = adds(r3, r2);
                str(r3 + r5, r0);
                r1 = lsls(r1, 22);
                r0 = adds(r4, 0);
                lr = __kernel_rem_pio2f + 1030 | 1;
                bl(this::__aeabi_fmul, 1030);
                return;
            case 1030:
                r6 = subs(r6, 1);
                r4 = adds(r0, 0);
                r5 = subs(r5, 4);
                b(null, 600);
                return;
            case 1038:
                r2 = rodata_PIo2;
                r3 = lsls(r6, 2);
                r1 = ldr(r4 + r3);
                r0 = ldr(r3 + r2);
                lr = __kernel_rem_pio2f + 1050 | 1;
                bl(this::__aeabi_fmul, 1050);
                return;
            case 1050:
                r1 = adds(r0, 0);
                r0 = ldr(sp + 16);
                lr = __kernel_rem_pio2f + 1058 | 1;
                bl(this::__aeabi_fadd, 1058);
                return;
            case 1058:
                r6 = adds(r6, 1);
                str(sp + 16, r0);
            case 1062:
                r3 = ldr(sp + 24);
                cmp(r6, r3);
                if (bgt(null, 1072)) return;
            case 1068:
                cmp(r5, r6);
                if (bge(null, 1038)) return;
            case 1072:
                r1 = movs(r1, 160);
                r2 = add(sp, 56);
                r2 = adds(r2, r1);
                r1 = ldr(sp + 16);
                r3 = lsls(r5, 2);
                str(r2 + r3, r1);
                r5 = adds(r5, 1);
                r4 = subs(r4, 4);
                b(null, 614);
                return;
            case 1090:
                r3 = movs(r3, 0);
                r6 = movs(r6, 0);
                str(sp + 16, r3);
                b(null, 1062);
                return;
            case 1098:
                r3 = ldr(sp + 400);
                cmp(r3, 3);
                if (beq(null, 1106)) return;
            case 1104:
                b(null, 638);
                return;
            case 1106:
                r6 = ldr(sp + 4);
                r5 = movs(r5, r7);
                b(null, 1292);
                return;
            case 1112:
                r3 = lsls(r7, 2);
                r1 = ldr(r3 + r4);
                lr = __kernel_rem_pio2f + 1120 | 1;
                bl(this::__aeabi_fadd, 1120);
                return;
            case 1120:
                r7 = subs(r7, 1);
            case 1122:
                cmp(r7, 0);
                if (bge(null, 1112)) return;
            case 1126:
                r3 = ldr(sp + 8);
                cmp(r3, 0);
                if (beq(null, 1138)) return;
            case 1132:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 24);
                r0 = adds(r0, r3);
            case 1138:
                r3 = ldr(sp + 12);
                str(r3, r0);
                b(null, 638);
                return;
            case 1144:
                r0 = movs(r0, 0);
                r4 = add(sp, 216);
                b(null, 1122);
                return;
            case 1150:
                r3 = lsls(r4, 2);
                r1 = ldr(r3 + r5);
                lr = __kernel_rem_pio2f + 1158 | 1;
                bl(this::__aeabi_fadd, 1158);
                return;
            case 1158:
                r4 = subs(r4, 1);
            case 1160:
                cmp(r4, 0);
                if (bge(null, 1150)) return;
            case 1164:
                r2 = ldr(sp + 8);
                r3 = adds(r0, 0);
                cmp(r2, 0);
                if (beq(null, 1178)) return;
            case 1172:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 24);
                r3 = adds(r0, r3);
            case 1178:
                r2 = ldr(sp + 12);
                r1 = adds(r0, 0);
                str(r2, r3);
                r0 = ldr(sp + 216);
                lr = __kernel_rem_pio2f + 1190 | 1;
                bl(this::__aeabi_fsub, 1190);
                return;
            case 1190:
                r4 = movs(r4, 1);
                r5 = add(sp, 216);
            case 1194:
                cmp(r7, r4);
                if (bge(null, 1224)) return;
            case 1198:
                r3 = ldr(sp + 8);
                cmp(r3, 0);
                if (beq(null, 1210)) return;
            case 1204:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 24);
                r0 = adds(r0, r3);
            case 1210:
                r3 = ldr(sp + 12);
                str(r3 + 4, r0);
                b(null, 638);
                return;
            case 1216:
                r4 = movs(r4, r7);
                r0 = movs(r0, 0);
                r5 = add(sp, 216);
                b(null, 1160);
                return;
            case 1224:
                r3 = lsls(r4, 2);
                r1 = ldr(r3 + r5);
                lr = __kernel_rem_pio2f + 1232 | 1;
                bl(this::__aeabi_fadd, 1232);
                return;
            case 1232:
                r4 = adds(r4, 1);
                b(null, 1194);
                return;
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
                lr = __kernel_rem_pio2f + 1264 | 1;
                bl(this::__aeabi_fadd, 1264);
                return;
            case 1264:
                r1 = adds(r0, 0);
                str(sp + 28, r0);
                r0 = ldr(sp + 16);
                lr = __kernel_rem_pio2f + 1274 | 1;
                bl(this::__aeabi_fsub, 1274);
                return;
            case 1274:
                r1 = ldr(sp + 24);
                lr = __kernel_rem_pio2f + 1280 | 1;
                bl(this::__aeabi_fadd, 1280);
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
                if (bgt(null, 1236)) return;
            case 1298:
                r5 = movs(r5, r7);
                r4 = add(sp, 216);
            case 1302:
                r3 = ldr(sp + 4);
                r3 = subs(r3, 4);
                str(sp + 4, r3);
                cmp(r5, 1);
                if (bgt(null, 1340)) return;
            case 1312:
                r0 = movs(r0, 0);
            case 1314:
                cmp(r7, 1);
                if (bgt(null, 1390)) return;
            case 1318:
                r1 = ldr(sp + 8);
                r2 = ldr(sp + 216);
                r3 = ldr(r4 + 4);
                cmp(r1, 0);
                if (bne(null, 1402)) return;
            case 1328:
                r1 = ldr(sp + 12);
                str(r1 + 4, r3);
                r3 = movs(r3, r1);
                str(r1, r2);
            case 1336:
                str(r3 + 8, r0);
                b(null, 638);
                return;
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
                lr = __kernel_rem_pio2f + 1364 | 1;
                bl(this::__aeabi_fadd, 1364);
                return;
            case 1364:
                r1 = adds(r0, 0);
                str(sp + 28, r0);
                r0 = ldr(sp + 16);
                lr = __kernel_rem_pio2f + 1374 | 1;
                bl(this::__aeabi_fsub, 1374);
                return;
            case 1374:
                r1 = ldr(sp + 24);
                lr = __kernel_rem_pio2f + 1380 | 1;
                bl(this::__aeabi_fadd, 1380);
                return;
            case 1380:
                r3 = ldr(sp + 4);
                r2 = ldr(sp + 28);
                str(r6 + 4, r0);
                str(r4 + r3, r2);
                b(null, 1302);
                return;
            case 1390:
                r3 = lsls(r7, 2);
                r1 = ldr(r4 + r3);
                lr = __kernel_rem_pio2f + 1398 | 1;
                bl(this::__aeabi_fadd, 1398);
                return;
            case 1398:
                r7 = subs(r7, 1);
                b(null, 1314);
                return;
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
                b(null, 1336);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134337332, size=236, name='__kernel_sinf', path='build/lib/libm/kf_sin.o', has_indirect=False)
    protected void __kernel_sinf(int offset) throws Exception
    {
        pc = __kernel_sinf + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r4, r5, r6, r7);
                str(sp + 4, r2);
                r2 = 0x31ffffff;
                r3 = lsls(r0, 1);
                r4 = adds(r0, 0);
                str(sp, r1);
                r3 = lsrs(r3, 1);
                cmp(r3, r2);
                if (bgt(null, 26)) return;
            case 18:
                lr = __kernel_sinf + 22 | 1;
                bl(this::__aeabi_f2iz, 22);
                return;
            case 22:
                cmp(r0, 0);
                if (beq(null, 134)) return;
            case 26:
                r1 = adds(r4, 0);
                r0 = adds(r4, 0);
                lr = __kernel_sinf + 34 | 1;
                bl(this::__aeabi_fmul, 34);
                return;
            case 34:
                r5 = adds(r0, 0);
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = __kernel_sinf + 44 | 1;
                bl(this::__aeabi_fmul, 44);
                return;
            case 44:
                r1 = 0x2f2ec9d3;
                r6 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = __kernel_sinf + 54 | 1;
                bl(this::__aeabi_fmul, 54);
                return;
            case 54:
                r1 = 0x32d72f34;
                lr = __kernel_sinf + 60 | 1;
                bl(this::__aeabi_fsub, 60);
                return;
            case 60:
                r1 = adds(r5, 0);
                lr = __kernel_sinf + 66 | 1;
                bl(this::__aeabi_fmul, 66);
                return;
            case 66:
                r1 = 0x3638ef1b;
                lr = __kernel_sinf + 72 | 1;
                bl(this::__aeabi_fadd, 72);
                return;
            case 72:
                r1 = adds(r5, 0);
                lr = __kernel_sinf + 78 | 1;
                bl(this::__aeabi_fmul, 78);
                return;
            case 78:
                r1 = 0x39500d01;
                lr = __kernel_sinf + 84 | 1;
                bl(this::__aeabi_fsub, 84);
                return;
            case 84:
                r1 = adds(r5, 0);
                lr = __kernel_sinf + 90 | 1;
                bl(this::__aeabi_fmul, 90);
                return;
            case 90:
                r1 = 0x3c088889;
                lr = __kernel_sinf + 96 | 1;
                bl(this::__aeabi_fadd, 96);
                return;
            case 96:
                r3 = ldr(sp + 4);
                r7 = adds(r0, 0);
                cmp(r3, 0);
                if (bne(null, 138)) return;
            case 104:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = __kernel_sinf + 112 | 1;
                bl(this::__aeabi_fmul, 112);
                return;
            case 112:
                r1 = 0x3e2aaaab;
                lr = __kernel_sinf + 118 | 1;
                bl(this::__aeabi_fsub, 118);
                return;
            case 118:
                r1 = adds(r6, 0);
                lr = __kernel_sinf + 124 | 1;
                bl(this::__aeabi_fmul, 124);
                return;
            case 124:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = __kernel_sinf + 132 | 1;
                bl(this::__aeabi_fadd, 132);
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
                lr = __kernel_sinf + 148 | 1;
                bl(this::__aeabi_fmul, 148);
                return;
            case 148:
                r1 = adds(r7, 0);
                str(sp + 4, r0);
                r0 = adds(r6, 0);
                lr = __kernel_sinf + 158 | 1;
                bl(this::__aeabi_fmul, 158);
                return;
            case 158:
                r1 = adds(r0, 0);
                r0 = ldr(sp + 4);
                lr = __kernel_sinf + 166 | 1;
                bl(this::__aeabi_fsub, 166);
                return;
            case 166:
                r1 = adds(r5, 0);
                lr = __kernel_sinf + 172 | 1;
                bl(this::__aeabi_fmul, 172);
                return;
            case 172:
                r1 = ldr(sp);
                lr = __kernel_sinf + 178 | 1;
                bl(this::__aeabi_fsub, 178);
                return;
            case 178:
                r1 = 0x3e2aaaab;
                r5 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = __kernel_sinf + 188 | 1;
                bl(this::__aeabi_fmul, 188);
                return;
            case 188:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = __kernel_sinf + 196 | 1;
                bl(this::__aeabi_fadd, 196);
                return;
            case 196:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = __kernel_sinf + 204 | 1;
                bl(this::__aeabi_fsub, 204);
                return;
            case 204:
                b(null, 132);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134337568, size=604, name='__kernel_tanf', path='build/lib/libm/kf_tan.o', has_indirect=False)
    protected void __kernel_tanf(int offset) throws Exception
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
                r3 = 0x317fffff;
                r2 = ldr(sp + 4);
                r7 = adds(r0, 0);
                str(sp + 16, r0);
                cmp(r2, r3);
                if (bgt(null, 74)) return;
            case 26:
                lr = __kernel_tanf + 30 | 1;
                bl(this::__aeabi_f2iz, 30);
                return;
            case 30:
                cmp(r0, 0);
                if (bne(null, 122)) return;
            case 34:
                r3 = ldr(sp + 8);
                r2 = ldr(sp + 4);
                r3 = adds(r3, 1);
                r3 = orrs(r3, r2);
                if (bne(null, 62)) return;
            case 44:
                r0 = movs(r0, 254);
                r1 = movs(r1, r2);
                r0 = lsls(r0, 22);
            case 50:
                lr = __kernel_tanf + 54 | 1;
                bl(this::__aeabi_fdiv, 54);
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
                if (beq(null, 56)) return;
            case 68:
                r1 = adds(r7, 0);
                r0 = 0xbf800000;
                b(null, 50);
                return;
            case 74:
                r3 = 0x3f2ca13f;
                r2 = ldr(sp + 4);
                cmp(r2, r3);
                if (ble(null, 122)) return;
            case 82:
                cmp(r0, 0);
                if (bge(null, 94)) return;
            case 86:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 24);
                r7 = adds(r0, r3);
                r5 = adds(r5, r3);
            case 94:
                r1 = adds(r7, 0);
                r0 = 0x3f490fda;
                lr = __kernel_tanf + 102 | 1;
                bl(this::__aeabi_fsub, 102);
                return;
            case 102:
                r1 = adds(r5, 0);
                r4 = adds(r0, 0);
                r0 = 0x33222168;
                lr = __kernel_tanf + 112 | 1;
                bl(this::__aeabi_fsub, 112);
                return;
            case 112:
                r1 = adds(r4, 0);
                lr = __kernel_tanf + 118 | 1;
                bl(this::__aeabi_fadd, 118);
                return;
            case 118:
                r5 = movs(r5, 0);
                r7 = adds(r0, 0);
            case 122:
                r1 = adds(r7, 0);
                r0 = adds(r7, 0);
                lr = __kernel_tanf + 130 | 1;
                bl(this::__aeabi_fmul, 130);
                return;
            case 130:
                r1 = adds(r0, 0);
                r6 = adds(r0, 0);
                lr = __kernel_tanf + 138 | 1;
                bl(this::__aeabi_fmul, 138);
                return;
            case 138:
                r1 = adds(r6, 0);
                r4 = adds(r0, 0);
                r0 = adds(r7, 0);
                lr = __kernel_tanf + 148 | 1;
                bl(this::__aeabi_fmul, 148);
                return;
            case 148:
                r1 = 0x37d95384;
                str(sp + 12, r0);
                r0 = adds(r4, 0);
                lr = __kernel_tanf + 158 | 1;
                bl(this::__aeabi_fmul, 158);
                return;
            case 158:
                r1 = 0x3895c07a;
                lr = __kernel_tanf + 164 | 1;
                bl(this::__aeabi_fadd, 164);
                return;
            case 164:
                r1 = adds(r4, 0);
                lr = __kernel_tanf + 170 | 1;
                bl(this::__aeabi_fmul, 170);
                return;
            case 170:
                r1 = 0x398137b9;
                lr = __kernel_tanf + 176 | 1;
                bl(this::__aeabi_fadd, 176);
                return;
            case 176:
                r1 = adds(r4, 0);
                lr = __kernel_tanf + 182 | 1;
                bl(this::__aeabi_fmul, 182);
                return;
            case 182:
                r1 = 0x3abede48;
                lr = __kernel_tanf + 188 | 1;
                bl(this::__aeabi_fadd, 188);
                return;
            case 188:
                r1 = adds(r4, 0);
                lr = __kernel_tanf + 194 | 1;
                bl(this::__aeabi_fmul, 194);
                return;
            case 194:
                r1 = 0x3c11371f;
                lr = __kernel_tanf + 200 | 1;
                bl(this::__aeabi_fadd, 200);
                return;
            case 200:
                r1 = adds(r4, 0);
                lr = __kernel_tanf + 206 | 1;
                bl(this::__aeabi_fmul, 206);
                return;
            case 206:
                r1 = 0x3d5d0dd1;
                lr = __kernel_tanf + 212 | 1;
                bl(this::__aeabi_fadd, 212);
                return;
            case 212:
                r1 = adds(r6, 0);
                lr = __kernel_tanf + 218 | 1;
                bl(this::__aeabi_fmul, 218);
                return;
            case 218:
                r1 = 0xb79bae5f;
                str(sp + 20, r0);
                r0 = adds(r4, 0);
                lr = __kernel_tanf + 228 | 1;
                bl(this::__aeabi_fmul, 228);
                return;
            case 228:
                r1 = 0x38a3f445;
                lr = __kernel_tanf + 234 | 1;
                bl(this::__aeabi_fadd, 234);
                return;
            case 234:
                r1 = adds(r4, 0);
                lr = __kernel_tanf + 240 | 1;
                bl(this::__aeabi_fmul, 240);
                return;
            case 240:
                r1 = 0x3a1a26c8;
                lr = __kernel_tanf + 246 | 1;
                bl(this::__aeabi_fadd, 246);
                return;
            case 246:
                r1 = adds(r4, 0);
                lr = __kernel_tanf + 252 | 1;
                bl(this::__aeabi_fmul, 252);
                return;
            case 252:
                r1 = 0x3b6b6916;
                lr = __kernel_tanf + 258 | 1;
                bl(this::__aeabi_fadd, 258);
                return;
            case 258:
                r1 = adds(r4, 0);
                lr = __kernel_tanf + 264 | 1;
                bl(this::__aeabi_fmul, 264);
                return;
            case 264:
                r1 = 0x3cb327a4;
                lr = __kernel_tanf + 270 | 1;
                bl(this::__aeabi_fadd, 270);
                return;
            case 270:
                r1 = adds(r4, 0);
                lr = __kernel_tanf + 276 | 1;
                bl(this::__aeabi_fmul, 276);
                return;
            case 276:
                r1 = 0x3e088889;
                lr = __kernel_tanf + 282 | 1;
                bl(this::__aeabi_fadd, 282);
                return;
            case 282:
                r1 = adds(r0, 0);
                r0 = ldr(sp + 20);
                lr = __kernel_tanf + 290 | 1;
                bl(this::__aeabi_fadd, 290);
                return;
            case 290:
                r1 = ldr(sp + 12);
                lr = __kernel_tanf + 296 | 1;
                bl(this::__aeabi_fmul, 296);
                return;
            case 296:
                r1 = adds(r5, 0);
                lr = __kernel_tanf + 302 | 1;
                bl(this::__aeabi_fadd, 302);
                return;
            case 302:
                r1 = adds(r6, 0);
                lr = __kernel_tanf + 308 | 1;
                bl(this::__aeabi_fmul, 308);
                return;
            case 308:
                r1 = adds(r5, 0);
                lr = __kernel_tanf + 314 | 1;
                bl(this::__aeabi_fadd, 314);
                return;
            case 314:
                r1 = 0x3eaaaaab;
                r4 = adds(r0, 0);
                r0 = ldr(sp + 12);
                lr = __kernel_tanf + 324 | 1;
                bl(this::__aeabi_fmul, 324);
                return;
            case 324:
                r1 = adds(r4, 0);
                lr = __kernel_tanf + 330 | 1;
                bl(this::__aeabi_fadd, 330);
                return;
            case 330:
                r1 = adds(r0, 0);
                r6 = adds(r0, 0);
                r0 = adds(r7, 0);
                lr = __kernel_tanf + 340 | 1;
                bl(this::__aeabi_fadd, 340);
                return;
            case 340:
                r3 = 0x3f2ca13f;
                r2 = ldr(sp + 4);
                r4 = adds(r0, 0);
                cmp(r2, r3);
                if (ble(null, 440)) return;
            case 350:
                r0 = ldr(sp + 8);
                lr = __kernel_tanf + 356 | 1;
                bl(this::__aeabi_i2f, 356);
                return;
            case 356:
                r1 = adds(r4, 0);
                r5 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = __kernel_tanf + 366 | 1;
                bl(this::__aeabi_fmul, 366);
                return;
            case 366:
                r1 = adds(r5, 0);
                str(sp + 4, r0);
                r0 = adds(r4, 0);
                lr = __kernel_tanf + 376 | 1;
                bl(this::__aeabi_fadd, 376);
                return;
            case 376:
                r1 = adds(r0, 0);
                r0 = ldr(sp + 4);
                lr = __kernel_tanf + 384 | 1;
                bl(this::__aeabi_fdiv, 384);
                return;
            case 384:
                r1 = adds(r6, 0);
                lr = __kernel_tanf + 390 | 1;
                bl(this::__aeabi_fsub, 390);
                return;
            case 390:
                r1 = adds(r0, 0);
                r0 = adds(r7, 0);
                lr = __kernel_tanf + 398 | 1;
                bl(this::__aeabi_fsub, 398);
                return;
            case 398:
                r1 = adds(r0, 0);
                lr = __kernel_tanf + 404 | 1;
                bl(this::__aeabi_fadd, 404);
                return;
            case 404:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = __kernel_tanf + 412 | 1;
                bl(this::__aeabi_fsub, 412);
                return;
            case 412:
                r3 = ldr(sp + 16);
                r4 = adds(r0, 0);
                r0 = asrs(r3, 30);
                r3 = movs(r3, 2);
                r0 = ands(r0, r3);
                r3 = subs(r3, 1);
                r0 = subs(r3, r0);
                lr = __kernel_tanf + 430 | 1;
                bl(this::__aeabi_i2f, 430);
                return;
            case 430:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = __kernel_tanf + 438 | 1;
                bl(this::__aeabi_fmul, 438);
                return;
            case 438:
                b(null, 54);
                return;
            case 440:
                r3 = ldr(sp + 8);
                cmp(r3, 1);
                if (beq(null, 528)) return;
            case 446:
                r1 = adds(r0, 0);
                r5 = lsrs(r0, 12);
                r0 = 0xbf800000;
                lr = __kernel_tanf + 456 | 1;
                bl(this::__aeabi_fdiv, 456);
                return;
            case 456:
                str(sp + 4, r0);
                r3 = ldr(sp + 4);
                r5 = lsls(r5, 12);
                r1 = adds(r7, 0);
                r0 = adds(r5, 0);
                r4 = lsrs(r3, 12);
                lr = __kernel_tanf + 472 | 1;
                bl(this::__aeabi_fsub, 472);
                return;
            case 472:
                r4 = lsls(r4, 12);
                r1 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = __kernel_tanf + 482 | 1;
                bl(this::__aeabi_fsub, 482);
                return;
            case 482:
                r1 = adds(r4, 0);
                lr = __kernel_tanf + 488 | 1;
                bl(this::__aeabi_fmul, 488);
                return;
            case 488:
                r1 = adds(r4, 0);
                r6 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = __kernel_tanf + 498 | 1;
                bl(this::__aeabi_fmul, 498);
                return;
            case 498:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = __kernel_tanf + 506 | 1;
                bl(this::__aeabi_fadd, 506);
                return;
            case 506:
                r1 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = __kernel_tanf + 514 | 1;
                bl(this::__aeabi_fadd, 514);
                return;
            case 514:
                r1 = ldr(sp + 4);
                lr = __kernel_tanf + 520 | 1;
                bl(this::__aeabi_fmul, 520);
                return;
            case 520:
                r1 = adds(r4, 0);
                lr = __kernel_tanf + 526 | 1;
                bl(this::__aeabi_fadd, 526);
                return;
            case 526:
                b(null, 54);
                return;
            case 528:
                r7 = adds(r0, 0);
                b(null, 56);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134338172, size=448, name='log1pf', path='build/lib/libm/log1pf.o', has_indirect=False)
    protected void log1pf(int offset) throws Exception
    {
        pc = log1pf + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r2 = 0xc12bec30;
                sp = sub(sp, 28);
                r1 = adds(r0, r2);
                r2 = 0x412bec2f;
                r4 = adds(r0, 0);
                cmp(r1, r2);
                if (bhi(null, 18)) return;
            case 16:
                b(null, 348);
                return;
            case 18:
                r2 = 0xbf7fffff;
                cmp(r0, r2);
                if (bls(null, 58)) return;
            case 24:
                r1 = 0xbf800000;
                lr = log1pf + 30 | 1;
                bl(this::__aeabi_fcmpeq, 30);
                return;
            case 30:
                cmp(r0, 0);
                if (beq(null, 46)) return;
            case 34:
                r1 = movs(r1, 0);
                r0 = 0xbf800000;
            case 38:
                lr = log1pf + 42 | 1;
                bl(this::__aeabi_fdiv, 42);
                return;
            case 42:
                r4 = adds(r0, 0);
                b(null, 84);
                return;
            case 46:
                r1 = adds(r4, 0);
                r0 = adds(r4, 0);
                lr = log1pf + 54 | 1;
                bl(this::__aeabi_fsub, 54);
                return;
            case 54:
                r1 = movs(r1, 0);
                b(null, 38);
                return;
            case 58:
                r1 = 0x66ffffff;
                r2 = lsls(r0, 1);
                cmp(r2, r1);
                if (bhi(null, 90)) return;
            case 66:
                r2 = movs(r2, 255);
                r2 = lsls(r2, 23);
                tst(r0, r2);
                if (bne(null, 84)) return;
            case 74:
                r1 = adds(r0, 0);
                lr = log1pf + 80 | 1;
                bl(this::__aeabi_fmul, 80);
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
                r2 = 0xbe95f619;
                cmp(r0, r2);
                if (bhi(null, 98)) return;
            case 96:
                b(null, 378);
                return;
            case 98:
                r1 = movs(r1, 254);
                r0 = adds(r4, 0);
                r1 = lsls(r1, 22);
                lr = log1pf + 108 | 1;
                bl(this::__aeabi_fadd, 108);
                return;
            case 108:
                r3 = 0x004afb0d;
                r7 = adds(r0, 0);
                r6 = adds(r0, r3);
                r5 = lsrs(r6, 23);
                r5 = subs(r5, 127);
                cmp(r5, 24);
                if (bgt(null, 372)) return;
            case 122:
                cmp(r5, 1);
                if (ble(null, 358)) return;
            case 126:
                r1 = adds(r4, 0);
                lr = log1pf + 132 | 1;
                bl(this::__aeabi_fsub, 132);
                return;
            case 132:
                r1 = adds(r0, 0);
                r0 = movs(r0, 254);
                r0 = lsls(r0, 22);
            case 138:
                lr = log1pf + 142 | 1;
                bl(this::__aeabi_fsub, 142);
                return;
            case 142:
                r1 = adds(r7, 0);
                lr = log1pf + 148 | 1;
                bl(this::__aeabi_fdiv, 148);
                return;
            case 148:
                str(sp, r0);
            case 150:
                r1 = movs(r1, 254);
                r3 = 0x3f3504f3;
                r0 = lsls(r6, 9);
                r0 = lsrs(r0, 9);
                r0 = adds(r0, r3);
                r1 = lsls(r1, 22);
                lr = log1pf + 166 | 1;
                bl(this::__aeabi_fsub, 166);
                return;
            case 166:
                r4 = adds(r0, 0);
            case 168:
                r1 = movs(r1, 128);
                r0 = adds(r4, 0);
                r1 = lsls(r1, 23);
                lr = log1pf + 178 | 1;
                bl(this::__aeabi_fadd, 178);
                return;
            case 178:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = log1pf + 186 | 1;
                bl(this::__aeabi_fdiv, 186);
                return;
            case 186:
                r1 = adds(r0, 0);
                str(sp + 4, r0);
                lr = log1pf + 194 | 1;
                bl(this::__aeabi_fmul, 194);
                return;
            case 194:
                r1 = adds(r0, 0);
                r6 = adds(r0, 0);
                lr = log1pf + 202 | 1;
                bl(this::__aeabi_fmul, 202);
                return;
            case 202:
                r1 = movs(r1, 252);
                r7 = adds(r0, 0);
                r1 = lsls(r1, 22);
                r0 = adds(r4, 0);
                lr = log1pf + 214 | 1;
                bl(this::__aeabi_fmul, 214);
                return;
            case 214:
                r1 = adds(r4, 0);
                lr = log1pf + 220 | 1;
                bl(this::__aeabi_fmul, 220);
                return;
            case 220:
                str(sp + 8, r0);
                r0 = movs(r0, r5);
                lr = log1pf + 228 | 1;
                bl(this::__aeabi_i2f, 228);
                return;
            case 228:
                r1 = 0x3e789e26;
                str(sp + 12, r0);
                r0 = adds(r7, 0);
                lr = log1pf + 238 | 1;
                bl(this::__aeabi_fmul, 238);
                return;
            case 238:
                r1 = 0x3eccce13;
                lr = log1pf + 244 | 1;
                bl(this::__aeabi_fadd, 244);
                return;
            case 244:
                r1 = adds(r7, 0);
                lr = log1pf + 250 | 1;
                bl(this::__aeabi_fmul, 250);
                return;
            case 250:
                r1 = 0x3e91e9ee;
                r5 = adds(r0, 0);
                r0 = adds(r7, 0);
                lr = log1pf + 260 | 1;
                bl(this::__aeabi_fmul, 260);
                return;
            case 260:
                r1 = 0x3f2aaaaa;
                lr = log1pf + 266 | 1;
                bl(this::__aeabi_fadd, 266);
                return;
            case 266:
                r1 = adds(r6, 0);
                lr = log1pf + 272 | 1;
                bl(this::__aeabi_fmul, 272);
                return;
            case 272:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = log1pf + 280 | 1;
                bl(this::__aeabi_fadd, 280);
                return;
            case 280:
                r1 = ldr(sp + 8);
                lr = log1pf + 286 | 1;
                bl(this::__aeabi_fadd, 286);
                return;
            case 286:
                r1 = ldr(sp + 4);
                lr = log1pf + 292 | 1;
                bl(this::__aeabi_fmul, 292);
                return;
            case 292:
                r1 = 0x3717f7d1;
                r5 = adds(r0, 0);
                r0 = ldr(sp + 12);
                lr = log1pf + 302 | 1;
                bl(this::__aeabi_fmul, 302);
                return;
            case 302:
                r1 = ldr(sp);
                lr = log1pf + 308 | 1;
                bl(this::__aeabi_fadd, 308);
                return;
            case 308:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = log1pf + 316 | 1;
                bl(this::__aeabi_fadd, 316);
                return;
            case 316:
                r1 = ldr(sp + 8);
                lr = log1pf + 322 | 1;
                bl(this::__aeabi_fsub, 322);
                return;
            case 322:
                r1 = adds(r4, 0);
                lr = log1pf + 328 | 1;
                bl(this::__aeabi_fadd, 328);
                return;
            case 328:
                r1 = 0x3f317180;
                r4 = adds(r0, 0);
                r0 = ldr(sp + 12);
                lr = log1pf + 338 | 1;
                bl(this::__aeabi_fmul, 338);
                return;
            case 338:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = log1pf + 346 | 1;
                bl(this::__aeabi_fadd, 346);
                return;
            case 346:
                b(null, 42);
                return;
            case 348:
                r2 = 0x7f7fffff;
                cmp(r0, r2);
                if (bhi(null, 356)) return;
            case 354:
                b(null, 98);
                return;
            case 356:
                b(null, 84);
                return;
            case 358:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = log1pf + 366 | 1;
                bl(this::__aeabi_fsub, 366);
                return;
            case 366:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                b(null, 138);
                return;
            case 372:
                r3 = movs(r3, 0);
                str(sp, r3);
                b(null, 150);
                return;
            case 378:
                r3 = movs(r3, 0);
                r5 = movs(r5, 0);
                str(sp, r3);
                b(null, 168);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134338620, size=74, name='nearbyintf', path='build/lib/libm/nearbyintf.o', has_indirect=False)
    protected void nearbyintf(int offset) throws Exception
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
                if (bgt(null, 56)) return;
            case 12:
                r1 = movs(r1, 150);
                r5 = lsrs(r0, 31);
                r1 = lsls(r1, 23);
                cmp(r5, 0);
                if (beq(null, 60)) return;
            case 22:
                lr = nearbyintf + 26 | 1;
                bl(this::__aeabi_fsub, 26);
                return;
            case 26:
                r1 = movs(r1, 150);
                r1 = lsls(r1, 23);
                lr = nearbyintf + 34 | 1;
                bl(this::__aeabi_fadd, 34);
                return;
            case 34:
                r1 = movs(r1, 0);
                r4 = adds(r0, 0);
                lr = nearbyintf + 42 | 1;
                bl(this::__aeabi_fcmpeq, 42);
                return;
            case 42:
                cmp(r0, 0);
                if (beq(null, 56)) return;
            case 46:
                r4 = movs(r4, 0);
                cmp(r5, 0);
                if (beq(null, 56)) return;
            case 52:
                r4 = movs(r4, 128);
                r4 = lsls(r4, 24);
            case 56:
                r0 = adds(r4, 0);
                pop(true, R4, R5, R6);
                return;
            case 60:
                lr = nearbyintf + 64 | 1;
                bl(this::__aeabi_fadd, 64);
                return;
            case 64:
                r1 = movs(r1, 150);
                r1 = lsls(r1, 23);
                lr = nearbyintf + 72 | 1;
                bl(this::__aeabi_fsub, 72);
                return;
            case 72:
                b(null, 34);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134338696, size=108, name='cosf', path='build/lib/libm/sf_cos.o', has_indirect=True)
    protected void cosf(int offset) throws Exception
    {
        pc = cosf + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2);
                r2 = 0x3f490fd8;
                r3 = lsls(r0, 1);
                r3 = lsrs(r3, 1);
                r1 = movs(r1, 0);
                cmp(r3, r2);
                if (ble(null, 54)) return;
            case 14:
                r2 = 0x7f7fffff;
                cmp(r3, r2);
                if (ble(null, 28)) return;
            case 20:
                r1 = adds(r0, 0);
                lr = cosf + 26 | 1;
                bl(this::__aeabi_fsub, 26);
                return;
            case 26:
                pop(true, R1, R2, R3);
                return;
            case 28:
                r1 = mov(sp);
                lr = cosf + 34 | 1;
                bl(this::__ieee754_rem_pio2f, 34);
                return;
            case 34:
                r2 = movs(r2, 3);
                r2 = ands(r2, r0);
                cmp(r2, 1);
                if (beq(null, 60)) return;
            case 42:
                cmp(r2, 2);
                if (beq(null, 76)) return;
            case 46:
                cmp(r2, 0);
                if (bne(null, 86)) return;
            case 50:
                r1 = ldr(sp + 4);
                r0 = ldr(sp);
            case 54:
                lr = cosf + 58 | 1;
                bl(this::__kernel_cosf, 58);
                return;
            case 58:
                b(null, 26);
                return;
            case 60:
                r1 = ldr(sp + 4);
                r0 = ldr(sp);
                lr = cosf + 68 | 1;
                bl(this::__kernel_sinf, 68);
                return;
            case 68:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 24);
                r0 = adds(r0, r3);
                b(null, 26);
                return;
            case 76:
                r1 = ldr(sp + 4);
                r0 = ldr(sp);
                lr = cosf + 84 | 1;
                bl(this::__kernel_cosf, 84);
                return;
            case 84:
                b(null, 68);
                return;
            case 86:
                r2 = movs(r2, 1);
                r1 = ldr(sp + 4);
                r0 = ldr(sp);
                lr = cosf + 96 | 1;
                bl(this::__kernel_sinf, 96);
                return;
            case 96:
                b(null, 26);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134338804, size=1208, name='erff', path='build/lib/libm/sf_erf.o', has_indirect=True)
    protected void erff(int offset) throws Exception
    {
        pc = erff + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r3 = 0x7f7fffff;
                r6 = lsls(r0, 1);
                sp = sub(sp, 20);
                r5 = adds(r0, 0);
                r7 = movs(r7, r0);
                r6 = lsrs(r6, 1);
                cmp(r6, r3);
                if (ble(null, 52)) return;
            case 18:
                r3 = lsrs(r0, 31);
                r0 = movs(r0, 1);
                r3 = lsls(r3, 1);
                r0 = subs(r0, r3);
                lr = erff + 30 | 1;
                bl(this::__aeabi_i2f, 30);
                return;
            case 30:
                r4 = adds(r0, 0);
                r0 = movs(r0, 254);
                r1 = adds(r5, 0);
                r0 = lsls(r0, 22);
                lr = erff + 42 | 1;
                bl(this::__aeabi_fdiv, 42);
                return;
            case 42:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
            case 46:
                lr = erff + 50 | 1;
                bl(this::__aeabi_fadd, 50);
                return;
            case 50:
                b(null, 104);
                return;
            case 52:
                r3 = 0x3f57ffff;
                cmp(r6, r3);
                if (bgt(null, 252)) return;
            case 58:
                r3 = 0x317fffff;
                cmp(r6, r3);
                if (bgt(null, 118)) return;
            case 64:
                r3 = 0x03ffffff;
                cmp(r6, r3);
                if (bgt(null, 108)) return;
            case 70:
                r1 = movs(r1, 130);
                r1 = lsls(r1, 23);
                lr = erff + 78 | 1;
                bl(this::__aeabi_fmul, 78);
                return;
            case 78:
                r1 = 0x3f8375d4;
                r4 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = erff + 88 | 1;
                bl(this::__aeabi_fmul, 88);
                return;
            case 88:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = erff + 96 | 1;
                bl(this::__aeabi_fadd, 96);
                return;
            case 96:
                r1 = movs(r1, 248);
                r1 = lsls(r1, 22);
                lr = erff + 104 | 1;
                bl(this::__aeabi_fmul, 104);
                return;
            case 104:
                sp = add(sp, 20);
                pop(true, R4, R5, R6, R7);
                return;
            case 108:
                r1 = 0x3e0375d4;
            case 110:
                lr = erff + 114 | 1;
                bl(this::__aeabi_fmul, 114);
                return;
            case 114:
                r1 = adds(r5, 0);
                b(null, 46);
                return;
            case 118:
                r1 = adds(r0, 0);
                lr = erff + 124 | 1;
                bl(this::__aeabi_fmul, 124);
                return;
            case 124:
                r1 = 0xb7c756b1;
                r4 = adds(r0, 0);
                lr = erff + 132 | 1;
                bl(this::__aeabi_fmul, 132);
                return;
            case 132:
                r1 = 0x3bbd1489;
                lr = erff + 138 | 1;
                bl(this::__aeabi_fsub, 138);
                return;
            case 138:
                r1 = adds(r4, 0);
                lr = erff + 144 | 1;
                bl(this::__aeabi_fmul, 144);
                return;
            case 144:
                r1 = 0x3ce9528f;
                lr = erff + 150 | 1;
                bl(this::__aeabi_fsub, 150);
                return;
            case 150:
                r1 = adds(r4, 0);
                lr = erff + 156 | 1;
                bl(this::__aeabi_fmul, 156);
                return;
            case 156:
                r1 = 0x3ea66beb;
                lr = erff + 162 | 1;
                bl(this::__aeabi_fsub, 162);
                return;
            case 162:
                r1 = adds(r4, 0);
                lr = erff + 168 | 1;
                bl(this::__aeabi_fmul, 168);
                return;
            case 168:
                r1 = 0x3e0375d4;
                lr = erff + 174 | 1;
                bl(this::__aeabi_fadd, 174);
                return;
            case 174:
                r1 = 0xb684e21a;
                r6 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = erff + 184 | 1;
                bl(this::__aeabi_fmul, 184);
                return;
            case 184:
                r1 = 0x390aee49;
                lr = erff + 190 | 1;
                bl(this::__aeabi_fadd, 190);
                return;
            case 190:
                r1 = adds(r4, 0);
                lr = erff + 196 | 1;
                bl(this::__aeabi_fmul, 196);
                return;
            case 196:
                r1 = 0x3ba68116;
                lr = erff + 202 | 1;
                bl(this::__aeabi_fadd, 202);
                return;
            case 202:
                r1 = adds(r4, 0);
                lr = erff + 208 | 1;
                bl(this::__aeabi_fmul, 208);
                return;
            case 208:
                r1 = 0x3d852a63;
                lr = erff + 214 | 1;
                bl(this::__aeabi_fadd, 214);
                return;
            case 214:
                r1 = adds(r4, 0);
                lr = erff + 220 | 1;
                bl(this::__aeabi_fmul, 220);
                return;
            case 220:
                r1 = 0x3ecbbbce;
                lr = erff + 226 | 1;
                bl(this::__aeabi_fadd, 226);
                return;
            case 226:
                r1 = adds(r4, 0);
                lr = erff + 232 | 1;
                bl(this::__aeabi_fmul, 232);
                return;
            case 232:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = erff + 240 | 1;
                bl(this::__aeabi_fadd, 240);
                return;
            case 240:
                r1 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = erff + 248 | 1;
                bl(this::__aeabi_fdiv, 248);
                return;
            case 248:
                r1 = adds(r5, 0);
                b(null, 110);
                return;
            case 252:
                r3 = 0x3f9fffff;
                cmp(r6, r3);
                if (bgt(null, 446)) return;
            case 258:
                r1 = movs(r1, 254);
                r0 = movs(r0, r6);
                r1 = lsls(r1, 22);
                lr = erff + 268 | 1;
                bl(this::__aeabi_fsub, 268);
                return;
            case 268:
                r1 = 0xbb0df9c0;
                r4 = adds(r0, 0);
                lr = erff + 276 | 1;
                bl(this::__aeabi_fmul, 276);
                return;
            case 276:
                r1 = 0x3d1151b3;
                lr = erff + 282 | 1;
                bl(this::__aeabi_fadd, 282);
                return;
            case 282:
                r1 = adds(r4, 0);
                lr = erff + 288 | 1;
                bl(this::__aeabi_fmul, 288);
                return;
            case 288:
                r1 = 0x3de31cc2;
                lr = erff + 294 | 1;
                bl(this::__aeabi_fsub, 294);
                return;
            case 294:
                r1 = adds(r4, 0);
                lr = erff + 300 | 1;
                bl(this::__aeabi_fmul, 300);
                return;
            case 300:
                r1 = 0x3ea2fe54;
                lr = erff + 306 | 1;
                bl(this::__aeabi_fadd, 306);
                return;
            case 306:
                r1 = adds(r4, 0);
                lr = erff + 312 | 1;
                bl(this::__aeabi_fmul, 312);
                return;
            case 312:
                r1 = 0x3ebe9208;
                lr = erff + 318 | 1;
                bl(this::__aeabi_fsub, 318);
                return;
            case 318:
                r1 = adds(r4, 0);
                lr = erff + 324 | 1;
                bl(this::__aeabi_fmul, 324);
                return;
            case 324:
                r1 = 0x3ed46805;
                lr = erff + 330 | 1;
                bl(this::__aeabi_fadd, 330);
                return;
            case 330:
                r1 = adds(r4, 0);
                lr = erff + 336 | 1;
                bl(this::__aeabi_fmul, 336);
                return;
            case 336:
                r1 = 0x3b1acdc6;
                lr = erff + 342 | 1;
                bl(this::__aeabi_fsub, 342);
                return;
            case 342:
                r1 = 0x3c445aa3;
                r5 = adds(r0, 0);
                r0 = adds(r4, 0);
                lr = erff + 352 | 1;
                bl(this::__aeabi_fmul, 352);
                return;
            case 352:
                r1 = 0x3c5f6e13;
                lr = erff + 358 | 1;
                bl(this::__aeabi_fadd, 358);
                return;
            case 358:
                r1 = adds(r4, 0);
                lr = erff + 364 | 1;
                bl(this::__aeabi_fmul, 364);
                return;
            case 364:
                r1 = 0x3e013307;
                lr = erff + 370 | 1;
                bl(this::__aeabi_fadd, 370);
                return;
            case 370:
                r1 = adds(r4, 0);
                lr = erff + 376 | 1;
                bl(this::__aeabi_fmul, 376);
                return;
            case 376:
                r1 = 0x3d931ae7;
                lr = erff + 382 | 1;
                bl(this::__aeabi_fadd, 382);
                return;
            case 382:
                r1 = adds(r4, 0);
                lr = erff + 388 | 1;
                bl(this::__aeabi_fmul, 388);
                return;
            case 388:
                r1 = 0x3f0a5785;
                lr = erff + 394 | 1;
                bl(this::__aeabi_fadd, 394);
                return;
            case 394:
                r1 = adds(r4, 0);
                lr = erff + 400 | 1;
                bl(this::__aeabi_fmul, 400);
                return;
            case 400:
                r1 = 0x3dd9f331;
                lr = erff + 406 | 1;
                bl(this::__aeabi_fadd, 406);
                return;
            case 406:
                r1 = adds(r4, 0);
                lr = erff + 412 | 1;
                bl(this::__aeabi_fmul, 412);
                return;
            case 412:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = erff + 420 | 1;
                bl(this::__aeabi_fadd, 420);
                return;
            case 420:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = erff + 428 | 1;
                bl(this::__aeabi_fdiv, 428);
                return;
            case 428:
                cmp(r7, 0);
                if (blt(null, 436)) return;
            case 432:
                r1 = 0x3f58560b;
                b(null, 46);
                return;
            case 436:
                r1 = adds(r0, 0);
                r0 = 0xbf58560b;
            case 440:
                lr = erff + 444 | 1;
                bl(this::__aeabi_fsub, 444);
                return;
            case 444:
                b(null, 104);
                return;
            case 446:
                r3 = 0x40bfffff;
                cmp(r6, r3);
                if (ble(null, 464)) return;
            case 452:
                cmp(r0, 0);
                if (bge(null, 458)) return;
            case 456:
                b(null, 1144);
                return;
            case 458:
                r0 = movs(r0, 254);
                r0 = lsls(r0, 22);
                b(null, 104);
                return;
            case 464:
                r1 = adds(r0, 0);
                lr = erff + 470 | 1;
                bl(this::__aeabi_fmul, 470);
                return;
            case 470:
                r1 = adds(r0, 0);
                r0 = movs(r0, 254);
                r0 = lsls(r0, 22);
                lr = erff + 480 | 1;
                bl(this::__aeabi_fdiv, 480);
                return;
            case 480:
                r3 = 0x4036db6d;
                r4 = movs(r4, r6);
                r5 = adds(r0, 0);
                cmp(r6, r3);
                if (ble(null, 492)) return;
            case 490:
                b(null, 988);
                return;
            case 492:
                r1 = 0xc11d077e;
                lr = erff + 498 | 1;
                bl(this::__aeabi_fmul, 498);
                return;
            case 498:
                r1 = 0x42a2932b;
                lr = erff + 504 | 1;
                bl(this::__aeabi_fsub, 504);
                return;
            case 504:
                r1 = adds(r5, 0);
                lr = erff + 510 | 1;
                bl(this::__aeabi_fmul, 510);
                return;
            case 510:
                r1 = 0x43389ae7;
                lr = erff + 516 | 1;
                bl(this::__aeabi_fsub, 516);
                return;
            case 516:
                r1 = adds(r5, 0);
                lr = erff + 522 | 1;
                bl(this::__aeabi_fmul, 522);
                return;
            case 522:
                r1 = 0x4322658c;
                lr = erff + 528 | 1;
                bl(this::__aeabi_fsub, 528);
                return;
            case 528:
                r1 = adds(r5, 0);
                lr = erff + 534 | 1;
                bl(this::__aeabi_fmul, 534);
                return;
            case 534:
                r1 = 0x42798057;
                lr = erff + 540 | 1;
                bl(this::__aeabi_fsub, 540);
                return;
            case 540:
                r1 = adds(r5, 0);
                lr = erff + 546 | 1;
                bl(this::__aeabi_fmul, 546);
                return;
            case 546:
                r1 = 0x4128f022;
                lr = erff + 552 | 1;
                bl(this::__aeabi_fsub, 552);
                return;
            case 552:
                r1 = adds(r5, 0);
                lr = erff + 558 | 1;
                bl(this::__aeabi_fmul, 558);
                return;
            case 558:
                r1 = 0x3f31a0b7;
                lr = erff + 564 | 1;
                bl(this::__aeabi_fsub, 564);
                return;
            case 564:
                r1 = adds(r5, 0);
                lr = erff + 570 | 1;
                bl(this::__aeabi_fmul, 570);
                return;
            case 570:
                r1 = 0x3c21a093;
                lr = erff + 576 | 1;
                bl(this::__aeabi_fsub, 576);
                return;
            case 576:
                r1 = 0xbd777f97;
                r6 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = erff + 586 | 1;
                bl(this::__aeabi_fmul, 586);
                return;
            case 586:
                r1 = 0x40d23f7c;
                lr = erff + 592 | 1;
                bl(this::__aeabi_fadd, 592);
                return;
            case 592:
                r1 = adds(r5, 0);
                lr = erff + 598 | 1;
                bl(this::__aeabi_fmul, 598);
                return;
            case 598:
                r1 = 0x42d9451f;
                lr = erff + 604 | 1;
                bl(this::__aeabi_fadd, 604);
                return;
            case 604:
                r1 = adds(r5, 0);
                lr = erff + 610 | 1;
                bl(this::__aeabi_fmul, 610);
                return;
            case 610:
                r1 = 0x43d6810b;
                lr = erff + 616 | 1;
                bl(this::__aeabi_fadd, 616);
                return;
            case 616:
                r1 = adds(r5, 0);
                lr = erff + 622 | 1;
                bl(this::__aeabi_fmul, 622);
                return;
            case 622:
                r1 = 0x442158c9;
                lr = erff + 628 | 1;
                bl(this::__aeabi_fadd, 628);
                return;
            case 628:
                r1 = adds(r5, 0);
                lr = erff + 634 | 1;
                bl(this::__aeabi_fmul, 634);
                return;
            case 634:
                r1 = 0x43d9486f;
                lr = erff + 640 | 1;
                bl(this::__aeabi_fadd, 640);
                return;
            case 640:
                r1 = adds(r5, 0);
                lr = erff + 646 | 1;
                bl(this::__aeabi_fmul, 646);
                return;
            case 646:
                r1 = 0x4309a863;
                lr = erff + 652 | 1;
                bl(this::__aeabi_fadd, 652);
                return;
            case 652:
                r1 = adds(r5, 0);
                lr = erff + 658 | 1;
                bl(this::__aeabi_fmul, 658);
                return;
            case 658:
                r1 = 0x419d35ce;
            case 660:
                lr = erff + 664 | 1;
                bl(this::__aeabi_fadd, 664);
                return;
            case 664:
                r1 = adds(r5, 0);
                lr = erff + 670 | 1;
                bl(this::__aeabi_fmul, 670);
                return;
            case 670:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = erff + 678 | 1;
                bl(this::__aeabi_fadd, 678);
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
                lr = erff + 698 | 1;
                bl(this::__aeabi_fmul, 698);
                return;
            case 698:
                r1 = 0x3f100000;
                lr = erff + 704 | 1;
                bl(this::__aeabi_fsub, 704);
                return;
            case 704:
                lr = erff + 708 | 1;
                bl(this::expf, 708);
                return;
            case 708:
                r1 = adds(r4, 0);
                str(sp + 8, r0);
                r0 = adds(r5, 0);
                lr = erff + 718 | 1;
                bl(this::__aeabi_fsub, 718);
                return;
            case 718:
                r1 = adds(r4, 0);
                str(sp + 12, r0);
                r0 = adds(r5, 0);
                lr = erff + 728 | 1;
                bl(this::__aeabi_fadd, 728);
                return;
            case 728:
                r1 = adds(r0, 0);
                r0 = ldr(sp + 12);
                lr = erff + 736 | 1;
                bl(this::__aeabi_fmul, 736);
                return;
            case 736:
                r1 = ldr(sp + 4);
                r5 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = erff + 746 | 1;
                bl(this::__aeabi_fdiv, 746);
                return;
            case 746:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = erff + 754 | 1;
                bl(this::__aeabi_fadd, 754);
                return;
            case 754:
                lr = erff + 758 | 1;
                bl(this::expf, 758);
                return;
            case 758:
                r1 = adds(r0, 0);
                r0 = ldr(sp + 8);
                lr = erff + 766 | 1;
                bl(this::__aeabi_fmul, 766);
                return;
            case 766:
                r1 = adds(r4, 0);
                cmp(r7, 0);
                if (bge(null, 774)) return;
            case 772:
                b(null, 1134);
                return;
            case 774:
                lr = erff + 778 | 1;
                bl(this::__aeabi_fdiv, 778);
                return;
            case 778:
                r1 = adds(r0, 0);
                r0 = movs(r0, 254);
                r0 = lsls(r0, 22);
                b(null, 440);
                return;
            case 988:
                r1 = 0xc3f1c275;
                lr = erff + 994 | 1;
                bl(this::__aeabi_fmul, 994);
                return;
            case 994:
                r1 = 0x4480230b;
                lr = erff + 1000 | 1;
                bl(this::__aeabi_fsub, 1000);
                return;
            case 1000:
                r1 = adds(r5, 0);
                lr = erff + 1006 | 1;
                bl(this::__aeabi_fmul, 1006);
                return;
            case 1006:
                r1 = 0x441f6441;
                lr = erff + 1012 | 1;
                bl(this::__aeabi_fsub, 1012);
                return;
            case 1012:
                r1 = adds(r5, 0);
                lr = erff + 1018 | 1;
                bl(this::__aeabi_fmul, 1018);
                return;
            case 1018:
                r1 = 0x4320a2ea;
                lr = erff + 1024 | 1;
                bl(this::__aeabi_fsub, 1024);
                return;
            case 1024:
                r1 = adds(r5, 0);
                lr = erff + 1030 | 1;
                bl(this::__aeabi_fmul, 1030);
                return;
            case 1030:
                r1 = 0x418e104b;
                lr = erff + 1036 | 1;
                bl(this::__aeabi_fsub, 1036);
                return;
            case 1036:
                r1 = adds(r5, 0);
                lr = erff + 1042 | 1;
                bl(this::__aeabi_fmul, 1042);
                return;
            case 1042:
                r1 = 0x3f4c9dd4;
                lr = erff + 1048 | 1;
                bl(this::__aeabi_fsub, 1048);
                return;
            case 1048:
                r1 = adds(r5, 0);
                lr = erff + 1054 | 1;
                bl(this::__aeabi_fmul, 1054);
                return;
            case 1054:
                r1 = 0x3c21a092;
                lr = erff + 1060 | 1;
                bl(this::__aeabi_fsub, 1060);
                return;
            case 1060:
                r1 = 0xc1b38712;
                r6 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = erff + 1070 | 1;
                bl(this::__aeabi_fmul, 1070);
                return;
            case 1070:
                r1 = 0x43ed43a7;
                lr = erff + 1076 | 1;
                bl(this::__aeabi_fadd, 1076);
                return;
            case 1076:
                r1 = adds(r5, 0);
                lr = erff + 1082 | 1;
                bl(this::__aeabi_fmul, 1082);
                return;
            case 1082:
                r1 = 0x451f90ce;
                lr = erff + 1088 | 1;
                bl(this::__aeabi_fadd, 1088);
                return;
            case 1088:
                r1 = adds(r5, 0);
                lr = erff + 1094 | 1;
                bl(this::__aeabi_fmul, 1094);
                return;
            case 1094:
                r1 = 0x4547fdbb;
                lr = erff + 1100 | 1;
                bl(this::__aeabi_fadd, 1100);
                return;
            case 1100:
                r1 = adds(r5, 0);
                lr = erff + 1106 | 1;
                bl(this::__aeabi_fmul, 1106);
                return;
            case 1106:
                r1 = 0x44c01759;
                lr = erff + 1112 | 1;
                bl(this::__aeabi_fadd, 1112);
                return;
            case 1112:
                r1 = adds(r5, 0);
                lr = erff + 1118 | 1;
                bl(this::__aeabi_fmul, 1118);
                return;
            case 1118:
                r1 = 0x43a2e571;
                lr = erff + 1124 | 1;
                bl(this::__aeabi_fadd, 1124);
                return;
            case 1124:
                r1 = adds(r5, 0);
                lr = erff + 1130 | 1;
                bl(this::__aeabi_fmul, 1130);
                return;
            case 1130:
                r1 = 0x41f2b459;
                b(null, 660);
                return;
            case 1134:
                lr = erff + 1138 | 1;
                bl(this::__aeabi_fdiv, 1138);
                return;
            case 1138:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                b(null, 440);
                return;
            case 1144:
                r0 = 0xbf800000;
                b(null, 104);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134340012, size=1212, name='erfcf', path='build/lib/libm/sf_erf.o', has_indirect=True)
    protected void erfcf(int offset) throws Exception
    {
        pc = erfcf + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r3 = 0x7f7fffff;
                r7 = lsls(r0, 1);
                sp = sub(sp, 20);
                r6 = adds(r0, 0);
                r4 = movs(r4, r0);
                r7 = lsrs(r7, 1);
                cmp(r7, r3);
                if (ble(null, 50)) return;
            case 18:
                r0 = lsrs(r0, 31);
                r0 = lsls(r0, 1);
                lr = erfcf + 26 | 1;
                bl(this::__aeabi_ui2f, 26);
                return;
            case 26:
                r4 = adds(r0, 0);
                r0 = movs(r0, 254);
                r1 = adds(r6, 0);
                r0 = lsls(r0, 22);
                lr = erfcf + 38 | 1;
                bl(this::__aeabi_fdiv, 38);
                return;
            case 38:
                r1 = adds(r0, 0);
                r0 = adds(r4, 0);
            case 42:
                lr = erfcf + 46 | 1;
                bl(this::__aeabi_fadd, 46);
                return;
            case 46:
                sp = add(sp, 20);
                pop(true, R4, R5, R6, R7);
                return;
            case 50:
                r3 = 0x3f57ffff;
                cmp(r7, r3);
                if (bgt(null, 250)) return;
            case 56:
                r3 = 0x237fffff;
                r1 = adds(r0, 0);
                cmp(r7, r3);
                if (bgt(null, 74)) return;
            case 64:
                r0 = movs(r0, 254);
            case 66:
                r0 = lsls(r0, 22);
            case 68:
                lr = erfcf + 72 | 1;
                bl(this::__aeabi_fsub, 72);
                return;
            case 72:
                b(null, 46);
                return;
            case 74:
                lr = erfcf + 78 | 1;
                bl(this::__aeabi_fmul, 78);
                return;
            case 78:
                r1 = 0xb7c756b1;
                r5 = adds(r0, 0);
                lr = erfcf + 86 | 1;
                bl(this::__aeabi_fmul, 86);
                return;
            case 86:
                r1 = 0x3bbd1489;
                lr = erfcf + 92 | 1;
                bl(this::__aeabi_fsub, 92);
                return;
            case 92:
                r1 = adds(r5, 0);
                lr = erfcf + 98 | 1;
                bl(this::__aeabi_fmul, 98);
                return;
            case 98:
                r1 = 0x3ce9528f;
                lr = erfcf + 104 | 1;
                bl(this::__aeabi_fsub, 104);
                return;
            case 104:
                r1 = adds(r5, 0);
                lr = erfcf + 110 | 1;
                bl(this::__aeabi_fmul, 110);
                return;
            case 110:
                r1 = 0x3ea66beb;
                lr = erfcf + 116 | 1;
                bl(this::__aeabi_fsub, 116);
                return;
            case 116:
                r1 = adds(r5, 0);
                lr = erfcf + 122 | 1;
                bl(this::__aeabi_fmul, 122);
                return;
            case 122:
                r1 = 0x3e0375d4;
                lr = erfcf + 128 | 1;
                bl(this::__aeabi_fadd, 128);
                return;
            case 128:
                r1 = 0xb684e21a;
                r7 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = erfcf + 138 | 1;
                bl(this::__aeabi_fmul, 138);
                return;
            case 138:
                r1 = 0x390aee49;
                lr = erfcf + 144 | 1;
                bl(this::__aeabi_fadd, 144);
                return;
            case 144:
                r1 = adds(r5, 0);
                lr = erfcf + 150 | 1;
                bl(this::__aeabi_fmul, 150);
                return;
            case 150:
                r1 = 0x3ba68116;
                lr = erfcf + 156 | 1;
                bl(this::__aeabi_fadd, 156);
                return;
            case 156:
                r1 = adds(r5, 0);
                lr = erfcf + 162 | 1;
                bl(this::__aeabi_fmul, 162);
                return;
            case 162:
                r1 = 0x3d852a63;
                lr = erfcf + 168 | 1;
                bl(this::__aeabi_fadd, 168);
                return;
            case 168:
                r1 = adds(r5, 0);
                lr = erfcf + 174 | 1;
                bl(this::__aeabi_fmul, 174);
                return;
            case 174:
                r1 = 0x3ecbbbce;
                lr = erfcf + 180 | 1;
                bl(this::__aeabi_fadd, 180);
                return;
            case 180:
                r1 = adds(r5, 0);
                lr = erfcf + 186 | 1;
                bl(this::__aeabi_fmul, 186);
                return;
            case 186:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = erfcf + 194 | 1;
                bl(this::__aeabi_fadd, 194);
                return;
            case 194:
                r1 = adds(r0, 0);
                r0 = adds(r7, 0);
                lr = erfcf + 202 | 1;
                bl(this::__aeabi_fdiv, 202);
                return;
            case 202:
                r1 = adds(r6, 0);
                lr = erfcf + 208 | 1;
                bl(this::__aeabi_fmul, 208);
                return;
            case 208:
                r3 = 0x3e7fffff;
                r5 = adds(r0, 0);
                cmp(r6, r3);
                if (bgt(null, 228)) return;
            case 216:
                r1 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = erfcf + 224 | 1;
                bl(this::__aeabi_fadd, 224);
                return;
            case 224:
                r1 = adds(r0, 0);
                b(null, 64);
                return;
            case 228:
                r1 = movs(r1, 252);
                r0 = adds(r6, 0);
                r1 = lsls(r1, 22);
                lr = erfcf + 238 | 1;
                bl(this::__aeabi_fsub, 238);
                return;
            case 238:
                r1 = adds(r5, 0);
                lr = erfcf + 244 | 1;
                bl(this::__aeabi_fadd, 244);
                return;
            case 244:
                r1 = adds(r0, 0);
                r0 = movs(r0, 252);
                b(null, 66);
                return;
            case 250:
                r3 = 0x3f9fffff;
                cmp(r7, r3);
                if (bgt(null, 448)) return;
            case 256:
                r1 = movs(r1, 254);
                r0 = movs(r0, r7);
                r1 = lsls(r1, 22);
                lr = erfcf + 266 | 1;
                bl(this::__aeabi_fsub, 266);
                return;
            case 266:
                r1 = 0xbb0df9c0;
                r5 = adds(r0, 0);
                lr = erfcf + 274 | 1;
                bl(this::__aeabi_fmul, 274);
                return;
            case 274:
                r1 = 0x3d1151b3;
                lr = erfcf + 280 | 1;
                bl(this::__aeabi_fadd, 280);
                return;
            case 280:
                r1 = adds(r5, 0);
                lr = erfcf + 286 | 1;
                bl(this::__aeabi_fmul, 286);
                return;
            case 286:
                r1 = 0x3de31cc2;
                lr = erfcf + 292 | 1;
                bl(this::__aeabi_fsub, 292);
                return;
            case 292:
                r1 = adds(r5, 0);
                lr = erfcf + 298 | 1;
                bl(this::__aeabi_fmul, 298);
                return;
            case 298:
                r1 = 0x3ea2fe54;
                lr = erfcf + 304 | 1;
                bl(this::__aeabi_fadd, 304);
                return;
            case 304:
                r1 = adds(r5, 0);
                lr = erfcf + 310 | 1;
                bl(this::__aeabi_fmul, 310);
                return;
            case 310:
                r1 = 0x3ebe9208;
                lr = erfcf + 316 | 1;
                bl(this::__aeabi_fsub, 316);
                return;
            case 316:
                r1 = adds(r5, 0);
                lr = erfcf + 322 | 1;
                bl(this::__aeabi_fmul, 322);
                return;
            case 322:
                r1 = 0x3ed46805;
                lr = erfcf + 328 | 1;
                bl(this::__aeabi_fadd, 328);
                return;
            case 328:
                r1 = adds(r5, 0);
                lr = erfcf + 334 | 1;
                bl(this::__aeabi_fmul, 334);
                return;
            case 334:
                r1 = 0x3b1acdc6;
                lr = erfcf + 340 | 1;
                bl(this::__aeabi_fsub, 340);
                return;
            case 340:
                r1 = 0x3c445aa3;
                r6 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = erfcf + 350 | 1;
                bl(this::__aeabi_fmul, 350);
                return;
            case 350:
                r1 = 0x3c5f6e13;
                lr = erfcf + 356 | 1;
                bl(this::__aeabi_fadd, 356);
                return;
            case 356:
                r1 = adds(r5, 0);
                lr = erfcf + 362 | 1;
                bl(this::__aeabi_fmul, 362);
                return;
            case 362:
                r1 = 0x3e013307;
                lr = erfcf + 368 | 1;
                bl(this::__aeabi_fadd, 368);
                return;
            case 368:
                r1 = adds(r5, 0);
                lr = erfcf + 374 | 1;
                bl(this::__aeabi_fmul, 374);
                return;
            case 374:
                r1 = 0x3d931ae7;
                lr = erfcf + 380 | 1;
                bl(this::__aeabi_fadd, 380);
                return;
            case 380:
                r1 = adds(r5, 0);
                lr = erfcf + 386 | 1;
                bl(this::__aeabi_fmul, 386);
                return;
            case 386:
                r1 = 0x3f0a5785;
                lr = erfcf + 392 | 1;
                bl(this::__aeabi_fadd, 392);
                return;
            case 392:
                r1 = adds(r5, 0);
                lr = erfcf + 398 | 1;
                bl(this::__aeabi_fmul, 398);
                return;
            case 398:
                r1 = 0x3dd9f331;
                lr = erfcf + 404 | 1;
                bl(this::__aeabi_fadd, 404);
                return;
            case 404:
                r1 = adds(r5, 0);
                lr = erfcf + 410 | 1;
                bl(this::__aeabi_fmul, 410);
                return;
            case 410:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = erfcf + 418 | 1;
                bl(this::__aeabi_fadd, 418);
                return;
            case 418:
                r1 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = erfcf + 426 | 1;
                bl(this::__aeabi_fdiv, 426);
                return;
            case 426:
                cmp(r4, 0);
                if (blt(null, 436)) return;
            case 430:
                r1 = adds(r0, 0);
                r0 = 0x3e1ea7d4;
                b(null, 68);
                return;
            case 436:
                r1 = 0x3f58560b;
                lr = erfcf + 442 | 1;
                bl(this::__aeabi_fadd, 442);
                return;
            case 442:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                b(null, 42);
                return;
            case 448:
                r3 = 0x41dfffff;
                cmp(r7, r3);
                if (ble(null, 456)) return;
            case 454:
                b(null, 1138);
                return;
            case 456:
                r1 = adds(r0, 0);
                lr = erfcf + 462 | 1;
                bl(this::__aeabi_fmul, 462);
                return;
            case 462:
                r1 = adds(r0, 0);
                r0 = movs(r0, 254);
                r0 = lsls(r0, 22);
                lr = erfcf + 472 | 1;
                bl(this::__aeabi_fdiv, 472);
                return;
            case 472:
                r3 = 0x4036db6c;
                r5 = movs(r5, r7);
                r6 = adds(r0, 0);
                cmp(r7, r3);
                if (ble(null, 484)) return;
            case 482:
                b(null, 968);
                return;
            case 484:
                r1 = 0xc11d077e;
                lr = erfcf + 490 | 1;
                bl(this::__aeabi_fmul, 490);
                return;
            case 490:
                r1 = 0x42a2932b;
                lr = erfcf + 496 | 1;
                bl(this::__aeabi_fsub, 496);
                return;
            case 496:
                r1 = adds(r6, 0);
                lr = erfcf + 502 | 1;
                bl(this::__aeabi_fmul, 502);
                return;
            case 502:
                r1 = 0x43389ae7;
                lr = erfcf + 508 | 1;
                bl(this::__aeabi_fsub, 508);
                return;
            case 508:
                r1 = adds(r6, 0);
                lr = erfcf + 514 | 1;
                bl(this::__aeabi_fmul, 514);
                return;
            case 514:
                r1 = 0x4322658c;
                lr = erfcf + 520 | 1;
                bl(this::__aeabi_fsub, 520);
                return;
            case 520:
                r1 = adds(r6, 0);
                lr = erfcf + 526 | 1;
                bl(this::__aeabi_fmul, 526);
                return;
            case 526:
                r1 = 0x42798057;
                lr = erfcf + 532 | 1;
                bl(this::__aeabi_fsub, 532);
                return;
            case 532:
                r1 = adds(r6, 0);
                lr = erfcf + 538 | 1;
                bl(this::__aeabi_fmul, 538);
                return;
            case 538:
                r1 = 0x4128f022;
                lr = erfcf + 544 | 1;
                bl(this::__aeabi_fsub, 544);
                return;
            case 544:
                r1 = adds(r6, 0);
                lr = erfcf + 550 | 1;
                bl(this::__aeabi_fmul, 550);
                return;
            case 550:
                r1 = 0x3f31a0b7;
                lr = erfcf + 556 | 1;
                bl(this::__aeabi_fsub, 556);
                return;
            case 556:
                r1 = adds(r6, 0);
                lr = erfcf + 562 | 1;
                bl(this::__aeabi_fmul, 562);
                return;
            case 562:
                r1 = 0x3c21a093;
                lr = erfcf + 568 | 1;
                bl(this::__aeabi_fsub, 568);
                return;
            case 568:
                r1 = 0xbd777f97;
                r7 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = erfcf + 578 | 1;
                bl(this::__aeabi_fmul, 578);
                return;
            case 578:
                r1 = 0x40d23f7c;
                lr = erfcf + 584 | 1;
                bl(this::__aeabi_fadd, 584);
                return;
            case 584:
                r1 = adds(r6, 0);
                lr = erfcf + 590 | 1;
                bl(this::__aeabi_fmul, 590);
                return;
            case 590:
                r1 = 0x42d9451f;
                lr = erfcf + 596 | 1;
                bl(this::__aeabi_fadd, 596);
                return;
            case 596:
                r1 = adds(r6, 0);
                lr = erfcf + 602 | 1;
                bl(this::__aeabi_fmul, 602);
                return;
            case 602:
                r1 = 0x43d6810b;
                lr = erfcf + 608 | 1;
                bl(this::__aeabi_fadd, 608);
                return;
            case 608:
                r1 = adds(r6, 0);
                lr = erfcf + 614 | 1;
                bl(this::__aeabi_fmul, 614);
                return;
            case 614:
                r1 = 0x442158c9;
                lr = erfcf + 620 | 1;
                bl(this::__aeabi_fadd, 620);
                return;
            case 620:
                r1 = adds(r6, 0);
                lr = erfcf + 626 | 1;
                bl(this::__aeabi_fmul, 626);
                return;
            case 626:
                r1 = 0x43d9486f;
                lr = erfcf + 632 | 1;
                bl(this::__aeabi_fadd, 632);
                return;
            case 632:
                r1 = adds(r6, 0);
                lr = erfcf + 638 | 1;
                bl(this::__aeabi_fmul, 638);
                return;
            case 638:
                r1 = 0x4309a863;
                lr = erfcf + 644 | 1;
                bl(this::__aeabi_fadd, 644);
                return;
            case 644:
                r1 = adds(r6, 0);
                lr = erfcf + 650 | 1;
                bl(this::__aeabi_fmul, 650);
                return;
            case 650:
                r1 = 0x419d35ce;
            case 652:
                lr = erfcf + 656 | 1;
                bl(this::__aeabi_fadd, 656);
                return;
            case 656:
                r1 = adds(r6, 0);
                lr = erfcf + 662 | 1;
                bl(this::__aeabi_fmul, 662);
                return;
            case 662:
                r1 = movs(r1, 254);
                r1 = lsls(r1, 22);
                lr = erfcf + 670 | 1;
                bl(this::__aeabi_fadd, 670);
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
                lr = erfcf + 690 | 1;
                bl(this::__aeabi_fmul, 690);
                return;
            case 690:
                r1 = 0x3f100000;
                lr = erfcf + 696 | 1;
                bl(this::__aeabi_fsub, 696);
                return;
            case 696:
                lr = erfcf + 700 | 1;
                bl(this::expf, 700);
                return;
            case 700:
                r1 = adds(r5, 0);
                str(sp + 8, r0);
                r0 = adds(r6, 0);
                lr = erfcf + 710 | 1;
                bl(this::__aeabi_fsub, 710);
                return;
            case 710:
                r1 = adds(r5, 0);
                str(sp + 12, r0);
                r0 = adds(r6, 0);
                lr = erfcf + 720 | 1;
                bl(this::__aeabi_fadd, 720);
                return;
            case 720:
                r1 = adds(r0, 0);
                r0 = ldr(sp + 12);
                lr = erfcf + 728 | 1;
                bl(this::__aeabi_fmul, 728);
                return;
            case 728:
                r1 = ldr(sp + 4);
                r6 = adds(r0, 0);
                r0 = adds(r7, 0);
                lr = erfcf + 738 | 1;
                bl(this::__aeabi_fdiv, 738);
                return;
            case 738:
                r1 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = erfcf + 746 | 1;
                bl(this::__aeabi_fadd, 746);
                return;
            case 746:
                lr = erfcf + 750 | 1;
                bl(this::expf, 750);
                return;
            case 750:
                r1 = adds(r0, 0);
                r0 = ldr(sp + 8);
                lr = erfcf + 758 | 1;
                bl(this::__aeabi_fmul, 758);
                return;
            case 758:
                r1 = adds(r5, 0);
                cmp(r4, 0);
                if (bgt(null, 766)) return;
            case 764:
                b(null, 1126);
                return;
            case 766:
                lr = erfcf + 770 | 1;
                bl(this::__aeabi_fdiv, 770);
                return;
            case 770:
                b(null, 46);
                return;
            case 968:
                cmp(r4, 0);
                if (bge(null, 978)) return;
            case 972:
                r3 = 0x40bfffff;
                cmp(r7, r3);
                if (bgt(null, 1146)) return;
            case 978:
                r1 = 0xc3f1c275;
                r0 = adds(r6, 0);
                lr = erfcf + 986 | 1;
                bl(this::__aeabi_fmul, 986);
                return;
            case 986:
                r1 = 0x4480230b;
                lr = erfcf + 992 | 1;
                bl(this::__aeabi_fsub, 992);
                return;
            case 992:
                r1 = adds(r6, 0);
                lr = erfcf + 998 | 1;
                bl(this::__aeabi_fmul, 998);
                return;
            case 998:
                r1 = 0x441f6441;
                lr = erfcf + 1004 | 1;
                bl(this::__aeabi_fsub, 1004);
                return;
            case 1004:
                r1 = adds(r6, 0);
                lr = erfcf + 1010 | 1;
                bl(this::__aeabi_fmul, 1010);
                return;
            case 1010:
                r1 = 0x4320a2ea;
                lr = erfcf + 1016 | 1;
                bl(this::__aeabi_fsub, 1016);
                return;
            case 1016:
                r1 = adds(r6, 0);
                lr = erfcf + 1022 | 1;
                bl(this::__aeabi_fmul, 1022);
                return;
            case 1022:
                r1 = 0x418e104b;
                lr = erfcf + 1028 | 1;
                bl(this::__aeabi_fsub, 1028);
                return;
            case 1028:
                r1 = adds(r6, 0);
                lr = erfcf + 1034 | 1;
                bl(this::__aeabi_fmul, 1034);
                return;
            case 1034:
                r1 = 0x3f4c9dd4;
                lr = erfcf + 1040 | 1;
                bl(this::__aeabi_fsub, 1040);
                return;
            case 1040:
                r1 = adds(r6, 0);
                lr = erfcf + 1046 | 1;
                bl(this::__aeabi_fmul, 1046);
                return;
            case 1046:
                r1 = 0x3c21a092;
                lr = erfcf + 1052 | 1;
                bl(this::__aeabi_fsub, 1052);
                return;
            case 1052:
                r1 = 0xc1b38712;
                r7 = adds(r0, 0);
                r0 = adds(r6, 0);
                lr = erfcf + 1062 | 1;
                bl(this::__aeabi_fmul, 1062);
                return;
            case 1062:
                r1 = 0x43ed43a7;
                lr = erfcf + 1068 | 1;
                bl(this::__aeabi_fadd, 1068);
                return;
            case 1068:
                r1 = adds(r6, 0);
                lr = erfcf + 1074 | 1;
                bl(this::__aeabi_fmul, 1074);
                return;
            case 1074:
                r1 = 0x451f90ce;
                lr = erfcf + 1080 | 1;
                bl(this::__aeabi_fadd, 1080);
                return;
            case 1080:
                r1 = adds(r6, 0);
                lr = erfcf + 1086 | 1;
                bl(this::__aeabi_fmul, 1086);
                return;
            case 1086:
                r1 = 0x4547fdbb;
                lr = erfcf + 1092 | 1;
                bl(this::__aeabi_fadd, 1092);
                return;
            case 1092:
                r1 = adds(r6, 0);
                lr = erfcf + 1098 | 1;
                bl(this::__aeabi_fmul, 1098);
                return;
            case 1098:
                r1 = 0x44c01759;
                lr = erfcf + 1104 | 1;
                bl(this::__aeabi_fadd, 1104);
                return;
            case 1104:
                r1 = adds(r6, 0);
                lr = erfcf + 1110 | 1;
                bl(this::__aeabi_fmul, 1110);
                return;
            case 1110:
                r1 = 0x43a2e571;
                lr = erfcf + 1116 | 1;
                bl(this::__aeabi_fadd, 1116);
                return;
            case 1116:
                r1 = adds(r6, 0);
                lr = erfcf + 1122 | 1;
                bl(this::__aeabi_fmul, 1122);
                return;
            case 1122:
                r1 = 0x41f2b459;
                b(null, 652);
                return;
            case 1126:
                lr = erfcf + 1130 | 1;
                bl(this::__aeabi_fdiv, 1130);
                return;
            case 1130:
                r1 = adds(r0, 0);
                r0 = movs(r0, 128);
                r0 = lsls(r0, 23);
                b(null, 68);
                return;
            case 1138:
                r0 = movs(r0, 0);
                cmp(r6, 0);
                if (ble(null, 1146)) return;
            case 1144:
                b(null, 46);
                return;
            case 1146:
                r0 = movs(r0, 128);
                r0 = lsls(r0, 23);
                b(null, 46);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134341224, size=84, name='frexpf', path='build/lib/libm/sf_frexp.o', has_indirect=False)
    protected void frexpf(int offset) throws Exception
    {
        pc = frexpf + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r4 = movs(r4, r1);
                r1 = movs(r1, 0);
                str(r4, r1);
                r1 = 0x7f7fffff;
                r3 = lsls(r0, 1);
                r2 = movs(r2, r0);
                r3 = lsrs(r3, 1);
                cmp(r3, r1);
                if (bgt(null, 70)) return;
            case 20:
                cmp(r3, 0);
                if (beq(null, 70)) return;
            case 24:
                r1 = 0x007fffff;
                cmp(r3, r1);
                if (bgt(null, 50)) return;
            case 30:
                r1 = movs(r1, 152);
                r1 = lsls(r1, 23);
                lr = frexpf + 38 | 1;
                bl(this::__aeabi_fmul, 38);
                return;
            case 38:
                r1 = movs(r1, 25);
                r2 = movs(r2, r0);
                r3 = lsls(r0, 1);
                r1 = rsbs(r1, 0);
                r3 = lsrs(r3, 1);
                str(r4, r1);
            case 50:
                r0 = 0x807fffff;
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

    // function: Function(address=134341308, size=64, name='ldexpf', path='build/lib/libm/sf_ldexp.o', has_indirect=False)
    protected void ldexpf(int offset) throws Exception
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
                r1 = 0x7f7fffff;
                lr = ldexpf + 18 | 1;
                bl(this::__aeabi_fcmpun, 18);
                return;
            case 18:
                cmp(r0, 0);
                if (bne(null, 56)) return;
            case 22:
                r1 = 0x7f7fffff;
                r0 = adds(r5, 0);
                lr = ldexpf + 30 | 1;
                bl(this::__aeabi_fcmpgt, 30);
                return;
            case 30:
                cmp(r0, 0);
                if (bne(null, 56)) return;
            case 34:
                r1 = movs(r1, 0);
                r0 = adds(r4, 0);
                lr = ldexpf + 42 | 1;
                bl(this::__aeabi_fcmpeq, 42);
                return;
            case 42:
                cmp(r0, 0);
                if (bne(null, 56)) return;
            case 46:
                r0 = adds(r4, 0);
                r1 = movs(r1, r6);
                lr = ldexpf + 54 | 1;
                bl(this::scalbnf, 54);
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

    // function: Function(address=134341372, size=68, name='modff', path='build/lib/libm/sf_modf.o', has_indirect=False)
    protected void modff(int offset) throws Exception
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
                if (bgt(null, 54)) return;
            case 14:
                cmp(r2, 0);
                if (bge(null, 26)) return;
            case 18:
                r2 = lsrs(r0, 31);
                r2 = lsls(r2, 31);
                str(r1, r2);
            case 24:
                pop(true, R4);
                return;
            case 26:
                r4 = 0x007fffff;
                r4 = asrs(r4, r2);
                tst(r4, r0);
                if (bne(null, 42)) return;
            case 34:
                r3 = lsrs(r0, 31);
                str(r1, r0);
                r0 = lsls(r3, 31);
                b(null, 24);
                return;
            case 42:
                r3 = bics(r3, r4);
                str(r1, r3);
                r1 = adds(r3, 0);
                lr = modff + 52 | 1;
                bl(this::__aeabi_fsub, 52);
                return;
            case 52:
                b(null, 24);
                return;
            case 54:
                str(r1, r0);
                r0 = lsrs(r0, 31);
                r0 = lsls(r0, 31);
                b(null, 24);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134341440, size=112, name='sinf', path='build/lib/libm/sf_sin.o', has_indirect=True)
    protected void sinf(int offset) throws Exception
    {
        pc = sinf + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2);
                r2 = 0x3f490fd8;
                r3 = lsls(r0, 1);
                r3 = lsrs(r3, 1);
                cmp(r3, r2);
                if (bgt(null, 22)) return;
            case 12:
                r2 = movs(r2, 0);
                r1 = movs(r1, 0);
            case 16:
                lr = sinf + 20 | 1;
                bl(this::__kernel_sinf, 20);
                return;
            case 20:
                b(null, 34);
                return;
            case 22:
                r2 = 0x7f7fffff;
                cmp(r3, r2);
                if (ble(null, 36)) return;
            case 28:
                r1 = adds(r0, 0);
                lr = sinf + 34 | 1;
                bl(this::__aeabi_fsub, 34);
                return;
            case 34:
                pop(true, R1, R2, R3);
                return;
            case 36:
                r1 = mov(sp);
                lr = sinf + 42 | 1;
                bl(this::__ieee754_rem_pio2f, 42);
                return;
            case 42:
                r3 = movs(r3, 3);
                r0 = ands(r0, r3);
                cmp(r0, 1);
                if (beq(null, 66)) return;
            case 50:
                cmp(r0, 2);
                if (beq(null, 76)) return;
            case 54:
                cmp(r0, 0);
                if (bne(null, 94)) return;
            case 58:
                r2 = movs(r2, 1);
                r1 = ldr(sp + 4);
                r0 = ldr(sp);
                b(null, 16);
                return;
            case 66:
                r1 = ldr(sp + 4);
                r0 = ldr(sp);
                lr = sinf + 74 | 1;
                bl(this::__kernel_cosf, 74);
                return;
            case 74:
                b(null, 34);
                return;
            case 76:
                r2 = movs(r2, 1);
                r1 = ldr(sp + 4);
                r0 = ldr(sp);
                lr = sinf + 86 | 1;
                bl(this::__kernel_sinf, 86);
                return;
            case 86:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 24);
                r0 = adds(r0, r3);
                b(null, 34);
                return;
            case 94:
                r1 = ldr(sp + 4);
                r0 = ldr(sp);
                lr = sinf + 102 | 1;
                bl(this::__kernel_cosf, 102);
                return;
            case 102:
                b(null, 86);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134341552, size=68, name='tanf', path='build/lib/libm/sf_tan.o', has_indirect=True)
    protected void tanf(int offset) throws Exception
    {
        pc = tanf + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2);
                r2 = 0x3f490fda;
                r3 = lsls(r0, 1);
                r3 = lsrs(r3, 1);
                cmp(r3, r2);
                if (bgt(null, 22)) return;
            case 12:
                r2 = movs(r2, 1);
                r1 = movs(r1, 0);
            case 16:
                lr = tanf + 20 | 1;
                bl(this::__kernel_tanf, 20);
                return;
            case 20:
                b(null, 34);
                return;
            case 22:
                r2 = 0x7f7fffff;
                cmp(r3, r2);
                if (ble(null, 36)) return;
            case 28:
                r1 = adds(r0, 0);
                lr = tanf + 34 | 1;
                bl(this::__aeabi_fsub, 34);
                return;
            case 34:
                pop(true, R1, R2, R3);
                return;
            case 36:
                r1 = mov(sp);
                lr = tanf + 42 | 1;
                bl(this::__ieee754_rem_pio2f, 42);
                return;
            case 42:
                r2 = movs(r2, 2);
                r0 = lsls(r0, 1);
                r0 = ands(r0, r2);
                r2 = subs(r2, 1);
                r2 = subs(r2, r0);
                r1 = ldr(sp + 4);
                r0 = ldr(sp);
                b(null, 16);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134341620, size=10, name='lgammaf', path='build/lib/libm/wf_lgamma.o', has_indirect=True)
    protected void lgammaf(int offset) throws Exception
    {
        pc = lgammaf + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2);
                r1 = add(sp, 4);
                lr = lgammaf + 8 | 1;
                bl(this::__ieee754_lgammaf_r, 8);
                return;
            case 8:
                pop(true, R1, R2, R3);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134341630, size=26, name='tgammaf', path='build/lib/libm/wf_tgamma.o', has_indirect=True)
    protected void tgammaf(int offset) throws Exception
    {
        pc = tgammaf + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2);
                r1 = add(sp, 4);
                lr = tgammaf + 8 | 1;
                bl(this::__ieee754_lgammaf_r, 8);
                return;
            case 8:
                lr = tgammaf + 12 | 1;
                bl(this::expf, 12);
                return;
            case 12:
                r3 = ldr(sp + 4);
                cmp(r3, 0);
                if (bge(null, 24)) return;
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

} // MicroPython_lib
