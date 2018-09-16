package kr.pe.ecmaxp.micropython.example;

import kr.pe.ecmaxp.thumbsk.CPU;
import kr.pe.ecmaxp.thumbjk.KotlinCPU;
import org.jetbrains.annotations.NotNull;

import static kr.pe.ecmaxp.thumbsk.helper.RegisterIndex.*;
import static kr.pe.ecmaxp.micropython.example.MicroPython_vals.*;

abstract public class MicroPython_main extends MicroPython_py
{
    public MicroPython_main(@NotNull CPU cpu)
    {
        super(cpu);
    }

    // function: Function(address=134323356, size=200, name='main', path='build/main.o', has_indirect=False)
    protected void main(int offset) throws Exception
    {
        pc = main + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5);
                sp = sub(sp, 60);
                r0 = add(sp, 4);
                lr = main + 10 | 1;
                bl(this::nlr_push, 10);
                return;
            case 10:
                r5 = subs(r0, 0);
                if (bne(null, 134)) return;
            case 14:
                r4 = 0x20010000;
                r0 = movs(r0, r4);
                lr = main + 22 | 1;
                bl(this::mp_stack_set_top, 22);
                return;
            case 22:
                r0 = 0x20009fac;
                r3 = 0xfffffe00;
                r0 = subs(r4, r0);
                r0 = asrs(r0, 2);
                r0 = adds(r0, r3);
                lr = main + 36 | 1;
                bl(this::mp_stack_set_limit, 36);
                return;
            case 36:
                r1 = print_hook;
                r0 = pystack_6802;
                lr = main + 44 | 1;
                bl(this::mp_pystack_init, 44);
                return;
            case 44:
                r1 = 0x60030000;
                r0 = 0x60000000;
                lr = main + 52 | 1;
                bl(this::gc_init, 52);
                return;
            case 52:
                lr = main + 56 | 1;
                bl(this::mp_init, 56);
                return;
            case 56:
                r4 = 0x20009e10;
                r1 = movs(r1, r5);
                r0 = movs(r0, r4);
                lr = main + 66 | 1;
                bl(this::mp_obj_list_init, 66);
                return;
            case 66:
                r1 = movs(r1, 6);
                r0 = movs(r0, r4);
                lr = main + 74 | 1;
                bl(this::mp_obj_list_append, 74);
                return;
            case 74:
                r0 = 0x20009e20;
                r1 = movs(r1, r5);
                lr = main + 82 | 1;
                bl(this::mp_obj_list_init, 82);
                return;
            case 82:
                r0 = 0x0802ae17;
                lr = main + 88 | 1;
                bl(this::pyexec_frozen_module, 88);
                return;
            case 88:
                cmp(r0, 1);
                if (beq(null, 98)) return;
            case 92:
                r0 = movs(r0, 1);
            case 94:
                sp = add(sp, 60);
                pop(true, R4, R5);
                return;
            case 98:
                r0 = 0x0802ad93;
                lr = main + 104 | 1;
                bl(this::pyexec_frozen_module, 104);
                return;
            case 104:
                cmp(r0, 1);
                if (bne(null, 92)) return;
            case 108:
                r3 = pyexec_mode_kind;
                r3 = ldrb(r3);
                cmp(r3, 0);
                if (bne(null, 128)) return;
            case 116:
                lr = main + 120 | 1;
                bl(this::pyexec_raw_repl, 120);
                return;
            case 120:
                cmp(r0, 0);
                if (beq(null, 108)) return;
            case 124:
                r0 = movs(r0, 0);
                b(null, 94);
                return;
            case 128:
                lr = main + 132 | 1;
                bl(this::pyexec_friendly_repl, 132);
                return;
            case 132:
                b(null, 120);
                return;
            case 134:
                r1 = ldr(sp + 8);
                r0 = mp_plat_print;
                lr = main + 142 | 1;
                bl(this::mp_obj_print_exception, 142);
                return;
            case 142:
                lr = main + 146 | 1;
                bl(this::mp_deinit, 146);
                return;
            case 146:
                b(null, 124);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134323556, size=44, name='Signal_Handler', path='build/machine.o', has_indirect=False)
    protected void Signal_Handler(int offset) throws Exception
    {
        pc = Signal_Handler + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r1 = 0x00000792;
                r0 = 0x20009e00;
                lr = Signal_Handler + 10 | 1;
                bl(this::mp_obj_dict_get, 10);
                return;
            case 10:
                r1 = mp_const_none_obj;
                lr = Signal_Handler + 16 | 1;
                bl(this::mp_sched_schedule, 16);
                return;
            case 16:
                r0 = movs(r0, 4);
                r3 = movs(r3, 1);
                r2 = adds(r7, 0);
                r7 = adds(r3, 0);
                svc(0);
                r7 = adds(r2, 0);
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134323600, size=14, name='_exit', path='build/machine.o', has_indirect=False)
    protected void _exit(int offset) throws Exception
    {
        assert offset == 0;
        pc = _exit + offset;
        r0 = movs(r0, 1);
        r3 = movs(r3, r0);
        r2 = adds(r7, 0);
        r7 = adds(r3, 0);
        svc(0);
        r7 = adds(r2, 0);
        bx(lr);
    }

    // function: Function(address=134323614, size=16, name='_start', path='build/machine.o', has_indirect=False)
    protected void _start(int offset) throws Exception
    {
        pc = _start + offset;
        switch (offset)
        {
            case 0:
                r1 = movs(r1, 0);
                push(true, r4);
                r0 = movs(r0, r1);
                lr = _start + 10 | 1;
                bl(this::main, 10);
                return;
            case 10:
                lr = _start + 14 | 1;
                bl(this::_exit, 14);
                return;
            case 14:
                b(null, 14);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134323632, size=100, name='Reset_Handler', path='build/machine.o', has_indirect=False)
    protected void Reset_Handler(int offset) throws Exception
    {
        pc = Reset_Handler + offset;
        switch (offset)
        {
            case 0:
                r0 = 0x08000000;
                r1 = ldr(r0);
                sp = mov(r1);
                r3 = movs(r3, 0);
                r0 = yasmarang_d;
                r1 = mp_dynamic_compiler;
                r4 = 0x0802b928;
            case 14:
                r2 = adds(r3, r0);
                cmp(r2, r1);
                if (blo(null, 48)) return;
            case 20:
                r1 = movs(r1, 0);
                r3 = mp_dynamic_compiler;
                r2 = 0x20009fac;
            case 26:
                cmp(r3, r2);
                if (blo(null, 56)) return;
            case 30:
                r3 = 0x40000100;
                r2 = 0x20009dd8;
                str(r3, r2);
                r2 = 0x20009db8;
                str(r3 + 4, r2);
                r2 = mp_interrupt_char;
                str(r3 + 8, r2);
                lr = Reset_Handler + 48 | 1;
                bl(this::_start, 48);
                return;
            case 48:
                r5 = ldr(r4 + r3);
                r3 = adds(r3, 4);
                str(r2, r5);
                b(null, 14);
                return;
            case 56:
                r3 = stm(r3, R1);
                b(null, 26);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134323732, size=16, name='__fatal_error', path='build/machine.o', has_indirect=False)
    protected void __fatal_error(int offset) throws Exception
    {
        pc = __fatal_error + offset;
        switch (offset)
        {
            case 0:
                r1 = movs(r1, r0);
                r3 = movs(r3, 1);
                r0 = movs(r0, 3);
                r2 = adds(r7, 0);
                r7 = adds(r3, 0);
                svc(0);
                r7 = adds(r2, 0);
            case 14:
                b(null, 14);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134323748, size=12, name='nlr_jump_fail', path='build/machine.o', has_indirect=False)
    protected void nlr_jump_fail(int offset) throws Exception
    {
        assert offset == 0;
        pc = nlr_jump_fail + offset;
        push(true, r4);
        r0 = nlr_jump_fail_str1_1;
        lr = nlr_jump_fail + 8 | 1;
        bl(this::__fatal_error, 8);
    }

    // function: Function(address=134323760, size=16, name='mp_hal_stdin_rx_chr', path='build/mphalport.o', has_indirect=False)
    protected void mp_hal_stdin_rx_chr(int offset) throws Exception
    {
        pc = mp_hal_stdin_rx_chr + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                lr = mp_hal_stdin_rx_chr + 6 | 1;
                bl(this::mp_handle_pending, 6);
                return;
            case 6:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 23);
                r0 = ldrb(r3 + 1);
                r0 = uxtb(r0);
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134323776, size=32, name='mp_hal_stdout_tx_strn', path='build/mphalport.o', has_indirect=False)
    protected void mp_hal_stdout_tx_strn(int offset) throws Exception
    {
        pc = mp_hal_stdout_tx_strn + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                lr = mp_hal_stdout_tx_strn + 6 | 1;
                bl(this::mp_obj_new_str, 6);
                return;
            case 6:
                r4 = movs(r4, r0);
                r1 = 0x000006d6;
                r0 = 0x20009e00;
                lr = mp_hal_stdout_tx_strn + 16 | 1;
                bl(this::mp_obj_dict_get, 16);
                return;
            case 16:
                r1 = movs(r1, r4);
                lr = mp_hal_stdout_tx_strn + 22 | 1;
                bl(this::mp_call_function_1_protected, 22);
                return;
            case 22:
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134323808, size=40, name='mp_hal_delay_ms', path='build/mphalport.o', has_indirect=False)
    protected void mp_hal_delay_ms(int offset) throws Exception
    {
        pc = mp_hal_delay_ms + offset;
        switch (offset)
        {
            case 0:
                push(true, r3, r4, r5, r6, r7);
                r5 = movs(r5, r0);
                r7 = movs(r7, 1);
                r4 = 0x40000200;
                r6 = ldr(r4);
            case 10:
                r3 = ldr(r4);
                r3 = subs(r3, r6);
                cmp(r3, r5);
                if (blo(null, 20)) return;
            case 18:
                pop(true, R3, R4, R5, R6, R7);
                return;
            case 20:
                lr = mp_hal_delay_ms + 24 | 1;
                bl(this::mp_handle_pending, 24);
                return;
            case 24:
                r3 = 0x40000100;
                str(r3 + 16, r7);
                b(null, 10);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134323848, size=12, name='mp_hal_ticks_ms', path='build/mphalport.o', has_indirect=False)
    protected void mp_hal_ticks_ms(int offset) throws Exception
    {
        assert offset == 0;
        pc = mp_hal_ticks_ms + offset;
        r3 = 0x40000200;
        r0 = ldr(r3);
        bx(lr);
    }

    // function: Function(address=134323860, size=12, name='mp_hal_ticks_cpu', path='build/mphalport.o', has_indirect=False)
    protected void mp_hal_ticks_cpu(int offset) throws Exception
    {
        assert offset == 0;
        pc = mp_hal_ticks_cpu + offset;
        r3 = 0x40000100;
        r0 = ldr(r3 + 20);
        bx(lr);
    }

    // function: Function(address=134323872, size=16, name='usystem_print_hook', path='build/modusystem.o', has_indirect=False)
    protected void usystem_print_hook(int offset) throws Exception
    {
        assert offset == 0;
        pc = usystem_print_hook + offset;
        r3 = print_hook;
        str(r3, r0);
        r0 = mp_const_none_obj;
        bx(lr);
    }

    // function: Function(address=134323888, size=32, name='usystem_debug', path='build/modusystem.o', has_indirect=False)
    protected void usystem_debug(int offset) throws Exception
    {
        pc = usystem_debug + offset;
        switch (offset)
        {
            case 0:
                r3 = movs(r3, 0);
                push(true, r0, r1, r2);
                r1 = add(sp, 4);
                str(sp + 4, r3);
                lr = usystem_debug + 12 | 1;
                bl(this::mp_obj_str_get_data, 12);
                return;
            case 12:
                r1 = ldr(sp + 4);
                r3 = movs(r3, 5);
                r2 = adds(r7, 0);
                r7 = adds(r3, 0);
                svc(0);
                r7 = adds(r2, 0);
                r0 = mp_const_none_obj;
                pop(true, R1, R2, R3);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134323920, size=52, name='usystem_set_stdin_char', path='build/modusystem.o', has_indirect=False)
    protected void usystem_set_stdin_char(int offset) throws Exception
    {
        pc = usystem_set_stdin_char + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r3 = lsls(r0, 31);
                if (bmi(null, 20)) return;
            case 6:
                r3 = mp_const_false_obj;
                r2 = lsls(r0, 30);
                if (bne(null, 34)) return;
            case 12:
                r2 = mp_type_int;
                r1 = ldr(r0);
                cmp(r1, r2);
                if (bne(null, 34)) return;
            case 20:
                lr = usystem_set_stdin_char + 24 | 1;
                bl(this::mp_obj_get_int, 24);
                return;
            case 24:
                r3 = movs(r3, 128);
                r0 = uxtb(r0);
                r3 = lsls(r3, 23);
                strb(r3 + 1, r0);
                r3 = mp_const_true_obj;
            case 34:
                r0 = movs(r0, r3);
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134323972, size=36, name='parse_2', path='build/modusystem.o', has_indirect=False)
    protected void parse_2(int offset) throws Exception
    {
        pc = parse_2 + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r4 = mp_const_none_obj;
                cmp(r0, 0);
                if (beq(null, 22)) return;
            case 8:
                r0 = ldm(r0, R1, R2);
                r0 = mp_type_str;
                lr = parse_2 + 16 | 1;
                bl(this::mp_obj_new_str_copy, 16);
                return;
            case 16:
                r4 = movs(r4, r0);
                lr = parse_2 + 22 | 1;
                bl(this::usystem_debug, 22);
                return;
            case 22:
                r0 = movs(r0, r4);
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324008, size=30, name='usystem_syscall', path='build/modusystem.o', has_indirect=False)
    protected void usystem_syscall(int offset) throws Exception
    {
        pc = usystem_syscall + offset;
        switch (offset)
        {
            case 0:
                r3 = movs(r3, 0);
                push(true, r0, r1, r2);
                r1 = add(sp, 4);
                str(sp + 4, r3);
                lr = usystem_syscall + 12 | 1;
                bl(this::mp_obj_str_get_data, 12);
                return;
            case 12:
                r1 = ldr(sp + 4);
                r3 = movs(r3, 2);
                r2 = adds(r7, 0);
                r7 = adds(r3, 0);
                svc(0);
                r7 = adds(r2, 0);
                lr = usystem_syscall + 28 | 1;
                bl(this::parse_2, 28);
                return;
            case 28:
                pop(true, R1, R2, R3);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324038, size=20, name='usystem_signal', path='build/modusystem.o', has_indirect=False)
    protected void usystem_signal(int offset) throws Exception
    {
        pc = usystem_signal + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r0 = movs(r0, 0);
                r3 = movs(r3, 3);
                r2 = adds(r7, 0);
                r7 = adds(r3, 0);
                svc(0);
                r7 = adds(r2, 0);
                lr = usystem_signal + 18 | 1;
                bl(this::parse_2, 18);
                return;
            case 18:
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324058, size=20, name='usystem_components', path='build/modusystem.o', has_indirect=False)
    protected void usystem_components(int offset) throws Exception
    {
        pc = usystem_components + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r0 = movs(r0, 1);
                r3 = movs(r3, 3);
                r2 = adds(r7, 0);
                r7 = adds(r3, 0);
                svc(0);
                r7 = adds(r2, 0);
                lr = usystem_components + 18 | 1;
                bl(this::parse_2, 18);
                return;
            case 18:
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324078, size=34, name='usystem_methods', path='build/modusystem.o', has_indirect=False)
    protected void usystem_methods(int offset) throws Exception
    {
        pc = usystem_methods + offset;
        switch (offset)
        {
            case 0:
                r3 = movs(r3, 0);
                push(true, r0, r1, r2);
                r1 = add(sp, 4);
                str(sp + 4, r3);
                lr = usystem_methods + 12 | 1;
                bl(this::mp_obj_str_get_data, 12);
                return;
            case 12:
                r2 = ldr(sp + 4);
                r1 = movs(r1, r0);
                r3 = movs(r3, 3);
                r0 = movs(r0, 2);
                r12 = mov(r7);
                r7 = adds(r3, 0);
                svc(0);
                r7 = mov(r12);
                lr = usystem_methods + 32 | 1;
                bl(this::parse_2, 32);
                return;
            case 32:
                pop(true, R1, R2, R3);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324112, size=32, name='usystem_annotations', path='build/modusystem.o', has_indirect=False)
    protected void usystem_annotations(int offset) throws Exception
    {
        pc = usystem_annotations + offset;
        switch (offset)
        {
            case 0:
                r3 = movs(r3, 0);
                push(true, r0, r1, r2);
                r1 = add(sp, 4);
                str(sp + 4, r3);
                lr = usystem_annotations + 12 | 1;
                bl(this::mp_obj_str_get_data, 12);
                return;
            case 12:
                r2 = ldr(sp + 4);
                r1 = movs(r1, r0);
                r0 = movs(r0, 3);
                r12 = mov(r7);
                r7 = adds(r0, 0);
                svc(0);
                r7 = mov(r12);
                lr = usystem_annotations + 30 | 1;
                bl(this::parse_2, 30);
                return;
            case 30:
                pop(true, R1, R2, R3);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324144, size=20, name='usystem_get_stdout_str', path='build/modusystem.o', has_indirect=False)
    protected void usystem_get_stdout_str(int offset) throws Exception
    {
        pc = usystem_get_stdout_str + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r0 = movs(r0, 1);
                r3 = movs(r3, 6);
                r2 = adds(r7, 0);
                r7 = adds(r3, 0);
                svc(0);
                r7 = adds(r2, 0);
                lr = usystem_get_stdout_str + 18 | 1;
                bl(this::parse_2, 18);
                return;
            case 18:
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324164, size=36, name='gc_collect', path='build/gccollect.o', has_indirect=False)
    protected void gc_collect(int offset) throws Exception
    {
        pc = gc_collect + offset;
        switch (offset)
        {
            case 0:
                push(true);
                sp = sub(sp, 44);
                lr = gc_collect + 8 | 1;
                bl(this::gc_collect_start, 8);
                return;
            case 8:
                r0 = mov(sp);
                lr = gc_collect + 14 | 1;
                bl(this::gc_helper_get_regs_and_sp, 14);
                return;
            case 14:
                r1 = 0x20010000;
                r1 = subs(r1, r0);
                r1 = lsrs(r1, 2);
                lr = gc_collect + 24 | 1;
                bl(this::gc_collect_root, 24);
                return;
            case 24:
                lr = gc_collect + 28 | 1;
                bl(this::gc_collect_end, 28);
                return;
            case 28:
                sp = add(sp, 44);
                pop(true);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324200, size=10, name='vfs_openpie_file___exit__', path='build/openpie_vfs.o', has_indirect=False)
    protected void vfs_openpie_file___exit__(int offset) throws Exception
    {
        pc = vfs_openpie_file___exit__ + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r0 = ldr(r1);
                lr = vfs_openpie_file___exit__ + 8 | 1;
                bl(this::mp_stream_close, 8);
                return;
            case 8:
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324212, size=32, name='vfs_openpie_file_print', path='build/openpie_vfs.o', has_indirect=False)
    protected void vfs_openpie_file_print(int offset) throws Exception
    {
        pc = vfs_openpie_file_print + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r5 = movs(r5, r0);
                r0 = movs(r0, r1);
                r4 = movs(r4, r1);
                lr = vfs_openpie_file_print + 12 | 1;
                bl(this::mp_obj_get_type_str, 12);
                return;
            case 12:
                r3 = ldr(r4 + 4);
                r2 = movs(r2, r0);
                r1 = vfs_openpie_file_print_str1_1;
                r0 = movs(r0, r5);
                lr = vfs_openpie_file_print + 24 | 1;
                bl(this::mp_printf, 24);
                return;
            case 24:
                pop(true, R4, R5, R6);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324244, size=24, name='unlikely_check_fd_is_open_isra_0_part_1', path='build/openpie_vfs.o', has_indirect=False)
    protected void unlikely_check_fd_is_open_isra_0_part_1(int offset) throws Exception
    {
        pc = unlikely_check_fd_is_open_isra_0_part_1 + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r1 = stringio_write_str1_1;
                r0 = mp_type_ValueError;
                lr = unlikely_check_fd_is_open_isra_0_part_1 + 10 | 1;
                bl(this::mp_obj_new_exception_msg, 10);
                return;
            case 10:
                lr = unlikely_check_fd_is_open_isra_0_part_1 + 14 | 1;
                bl(this::nlr_jump, 14);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324268, size=18, name='vfs_openpie_file_fileno', path='build/openpie_vfs.o', has_indirect=False)
    protected void vfs_openpie_file_fileno(int offset) throws Exception
    {
        pc = vfs_openpie_file_fileno + offset;
        switch (offset)
        {
            case 0:
                r0 = ldr(r0 + 4);
                push(true, r4);
                r3 = adds(r0, 1);
                if (bne(null, 12)) return;
            case 8:
                lr = vfs_openpie_file_fileno + 12 | 1;
                bl(this::unlikely_check_fd_is_open_isra_0_part_1, 12);
                return;
            case 12:
                lr = vfs_openpie_file_fileno + 16 | 1;
                bl(this::mp_obj_new_int, 16);
                return;
            case 16:
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324286, size=14, name='SVC_CALL_VFS', path='build/openpie_vfs.o', has_indirect=False)
    protected void SVC_CALL_VFS(int offset) throws Exception
    {
        assert offset == 0;
        pc = SVC_CALL_VFS + offset;
        push(true, r4);
        r4 = movs(r4, 4);
        r12 = mov(r7);
        r7 = adds(r4, 0);
        svc(0);
        r7 = mov(r12);
        pop(true, R4);
    }

    // function: Function(address=134324300, size=16, name='SVC_CALL_VFS_OUT', path='build/openpie_vfs.o', has_indirect=False)
    protected void SVC_CALL_VFS_OUT(int offset) throws Exception
    {
        assert offset == 0;
        pc = SVC_CALL_VFS_OUT + offset;
        push(true, r4, r5);
        r4 = ldr(sp + 12);
        r5 = movs(r5, 4);
        r12 = mov(r7);
        r7 = adds(r5, 0);
        svc(0);
        r7 = mov(r12);
        pop(true, R4, R5);
    }

    // function: Function(address=134324316, size=126, name='vfs_openpie_file_ioctl', path='build/openpie_vfs.o', has_indirect=False)
    protected void vfs_openpie_file_ioctl(int offset) throws Exception
    {
        pc = vfs_openpie_file_ioctl + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r3, r4, r5, r6);
                r6 = movs(r6, r0);
                r0 = movs(r0, r1);
                r1 = ldr(r6 + 4);
                r5 = movs(r5, r2);
                r4 = movs(r4, r3);
                r3 = adds(r1, 1);
                if (bne(null, 20)) return;
            case 16:
                lr = vfs_openpie_file_ioctl + 20 | 1;
                bl(this::unlikely_check_fd_is_open_isra_0_part_1, 20);
                return;
            case 20:
                cmp(r0, 2);
                if (beq(null, 58)) return;
            case 24:
                cmp(r0, 4);
                if (beq(null, 94)) return;
            case 28:
                cmp(r0, 1);
                if (bne(null, 120)) return;
            case 32:
                r3 = movs(r3, 0);
                r0 = adds(r0, 7);
                r2 = movs(r2, r3);
                lr = vfs_openpie_file_ioctl + 42 | 1;
                bl(this::SVC_CALL_VFS, 42);
                return;
            case 42:
                r3 = movs(r3, r0);
                r0 = movs(r0, 0);
                cmp(r3, r0);
                if (beq(null, 54)) return;
            case 50:
                str(r4, r3);
                r0 = subs(r0, 1);
            case 54:
                sp = add(sp, 16);
                pop(true, R4, R5, R6);
                return;
            case 58:
                r3 = movs(r3, 0);
                str(sp + 12, r3);
                r3 = add(sp, 12);
                str(sp, r3);
                r3 = ldr(r2 + 4);
                r0 = movs(r0, 7);
                r2 = ldr(r2);
                lr = vfs_openpie_file_ioctl + 76 | 1;
                bl(this::SVC_CALL_VFS_OUT, 76);
                return;
            case 76:
                cmp(r0, 0);
                if (beq(null, 88)) return;
            case 80:
                str(r4, r0);
            case 82:
                r0 = movs(r0, 1);
                r0 = rsbs(r0, 0);
                b(null, 54);
                return;
            case 88:
                r3 = ldr(sp + 12);
                str(r5, r3);
                b(null, 54);
                return;
            case 94:
                r3 = movs(r3, 0);
                r2 = movs(r2, r3);
                lr = vfs_openpie_file_ioctl + 102 | 1;
                bl(this::SVC_CALL_VFS, 102);
                return;
            case 102:
                r3 = movs(r3, 1);
                r3 = rsbs(r3, 0);
                cmp(r0, 0);
                if (beq(null, 116)) return;
            case 110:
                str(r4, r0);
                r0 = movs(r0, r3);
                b(null, 54);
                return;
            case 116:
                str(r6 + 4, r3);
                b(null, 54);
                return;
            case 120:
                r3 = movs(r3, 22);
                str(r4, r3);
                b(null, 82);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324442, size=54, name='vfs_openpie_file_write', path='build/openpie_vfs.o', has_indirect=False)
    protected void vfs_openpie_file_write(int offset) throws Exception
    {
        pc = vfs_openpie_file_write + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5);
                r5 = movs(r5, r1);
                r1 = ldr(r0 + 4);
                sp = sub(sp, 20);
                r4 = movs(r4, r3);
                r3 = adds(r1, 1);
                if (bne(null, 18)) return;
            case 14:
                lr = vfs_openpie_file_write + 18 | 1;
                bl(this::unlikely_check_fd_is_open_isra_0_part_1, 18);
                return;
            case 18:
                r3 = movs(r3, 0);
                str(sp + 12, r3);
                r3 = add(sp, 12);
                str(sp, r3);
                r0 = movs(r0, 6);
                r3 = movs(r3, r2);
                r2 = movs(r2, r5);
                lr = vfs_openpie_file_write + 36 | 1;
                bl(this::SVC_CALL_VFS_OUT, 36);
                return;
            case 36:
                r3 = ldr(sp + 12);
                cmp(r0, 0);
                if (beq(null, 48)) return;
            case 42:
                r3 = movs(r3, 1);
                str(r4, r0);
                r3 = rsbs(r3, 0);
            case 48:
                r0 = movs(r0, r3);
                sp = add(sp, 20);
                pop(true, R4, R5);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324496, size=52, name='vfs_openpie_file_read', path='build/openpie_vfs.o', has_indirect=False)
    protected void vfs_openpie_file_read(int offset) throws Exception
    {
        pc = vfs_openpie_file_read + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5);
                r5 = movs(r5, r1);
                r1 = ldr(r0 + 4);
                sp = sub(sp, 20);
                r4 = movs(r4, r3);
                r3 = adds(r1, 1);
                if (bne(null, 18)) return;
            case 14:
                lr = vfs_openpie_file_read + 18 | 1;
                bl(this::unlikely_check_fd_is_open_isra_0_part_1, 18);
                return;
            case 18:
                r3 = movs(r3, 0);
                str(sp + 12, r3);
                r3 = add(sp, 12);
                str(sp, r3);
                r0 = movs(r0, 5);
                r3 = movs(r3, r5);
                lr = vfs_openpie_file_read + 34 | 1;
                bl(this::SVC_CALL_VFS_OUT, 34);
                return;
            case 34:
                r3 = ldr(sp + 12);
                cmp(r0, 0);
                if (beq(null, 46)) return;
            case 40:
                r3 = movs(r3, 1);
                str(r4, r0);
                r3 = rsbs(r3, 0);
            case 46:
                r0 = movs(r0, r3);
                sp = add(sp, 20);
                pop(true, R4, R5);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324548, size=92, name='mp_vfs_openpie_file_open', path='build/openpie_vfs.o', has_indirect=False)
    protected void mp_vfs_openpie_file_open(int offset) throws Exception
    {
        pc = mp_vfs_openpie_file_open + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                sp = sub(sp, 20);
                str(sp + 12, r0);
                r0 = movs(r0, 8);
                r7 = movs(r7, r1);
                r6 = movs(r6, r2);
                r5 = movs(r5, r3);
                lr = mp_vfs_openpie_file_open + 18 | 1;
                bl(this::m_malloc, 18);
                return;
            case 18:
                r4 = movs(r4, r0);
                r0 = movs(r0, r7);
                lr = mp_vfs_openpie_file_open + 26 | 1;
                bl(this::mp_obj_str_get_str, 26);
                return;
            case 26:
                r7 = movs(r7, r0);
                r0 = movs(r0, r6);
                lr = mp_vfs_openpie_file_open + 34 | 1;
                bl(this::mp_obj_str_get_str, 34);
                return;
            case 34:
                r6 = movs(r6, r0);
                r0 = movs(r0, r5);
                lr = mp_vfs_openpie_file_open + 42 | 1;
                bl(this::mp_obj_str_get_str, 42);
                return;
            case 42:
                r2 = ldr(sp + 12);
                r3 = movs(r3, r0);
                str(r4, r2);
                r2 = movs(r2, 1);
                r2 = rsbs(r2, 0);
                str(r4 + 4, r2);
                r2 = adds(r4, 4);
                str(sp, r2);
                r1 = movs(r1, r7);
                r2 = movs(r2, r6);
                r0 = movs(r0, 1);
                lr = mp_vfs_openpie_file_open + 68 | 1;
                bl(this::SVC_CALL_VFS_OUT, 68);
                return;
            case 68:
                cmp(r0, 0);
                if (beq(null, 76)) return;
            case 72:
                lr = mp_vfs_openpie_file_open + 76 | 1;
                bl(this::mp_raise_OSError, 76);
                return;
            case 76:
                r3 = ldr(r4 + 4);
                r3 = adds(r3, 1);
                if (bne(null, 86)) return;
            case 82:
                lr = mp_vfs_openpie_file_open + 86 | 1;
                bl(this::unlikely_check_fd_is_open_isra_0_part_1, 86);
                return;
            case 86:
                r0 = movs(r0, r4);
                sp = add(sp, 20);
                pop(true, R4, R5, R6, R7);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324640, size=48, name='vfs_openpie_file_make_new', path='build/openpie_vfs.o', has_indirect=False)
    protected void vfs_openpie_file_make_new(int offset) throws Exception
    {
        pc = vfs_openpie_file_make_new + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5);
                r5 = movs(r5, r0);
                sp = sub(sp, 28);
                r0 = movs(r0, r1);
                r1 = movs(r1, r2);
                r2 = movs(r2, r3);
                r3 = allowed_args_7517;
                r4 = add(sp, 12);
                str(sp, r3);
                str(sp + 4, r4);
                r3 = movs(r3, 3);
                lr = vfs_openpie_file_make_new + 26 | 1;
                bl(this::mp_arg_parse_all_kw_array, 26);
                return;
            case 26:
                r3 = ldr(r4 + 8);
                r2 = ldr(r4 + 4);
                r1 = ldr(sp + 12);
                r0 = movs(r0, r5);
                lr = vfs_openpie_file_make_new + 38 | 1;
                bl(this::mp_vfs_openpie_file_open, 38);
                return;
            case 38:
                sp = add(sp, 28);
                pop(true, R4, R5);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134324688, size=36, name='gc_helper_get_regs_and_sp', path='build/gchelper_m0.o', has_indirect=False)
    protected void gc_helper_get_regs_and_sp(int offset) throws Exception
    {
        assert offset == 0;
        pc = gc_helper_get_regs_and_sp + offset;
        str(r0, r4);
        str(r0 + 4, r5);
        str(r0 + 8, r6);
        str(r0 + 12, r7);
        r1 = mov(r8);
        str(r0 + 16, r1);
        r1 = mov(r9);
        str(r0 + 20, r1);
        r1 = mov(r10);
        str(r0 + 24, r1);
        r1 = mov(r11);
        str(r0 + 28, r1);
        r1 = mov(r12);
        str(r0 + 32, r1);
        r1 = mov(sp);
        str(r0 + 36, r1);
        r0 = mov(sp);
        bx(lr);
    }

} // MicroPython_main
