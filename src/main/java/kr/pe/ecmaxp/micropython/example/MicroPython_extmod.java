package kr.pe.ecmaxp.micropython.example;

import kr.pe.ecmaxp.thumbsk.CPU;
import kr.pe.ecmaxp.thumbjk.KotlinCPU;
import org.jetbrains.annotations.NotNull;

import static kr.pe.ecmaxp.thumbsk.helper.RegisterIndex.*;
import static kr.pe.ecmaxp.micropython.example.MicroPython_vals.*;

abstract public class MicroPython_extmod extends MicroPython_lib
{
    public MicroPython_extmod(@NotNull CPU cpu)
    {
        super(cpu);
    }

    // function: Function(address=134310612, size=20, name='uctypes_struct_addressof', path='build/extmod/moductypes.o', has_indirect=False)
    protected void uctypes_struct_addressof(int offset) throws Exception
    {
        pc = uctypes_struct_addressof + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r3, r4);
                r2 = movs(r2, 1);
                r1 = add(sp, 4);
                lr = uctypes_struct_addressof + 10 | 1;
                bl(this::mp_get_buffer_raise, 10);
                return;
            case 10:
                r0 = ldr(sp + 4);
                lr = uctypes_struct_addressof + 16 | 1;
                bl(this::mp_obj_new_int, 16);
                return;
            case 16:
                sp = add(sp, 20);
                pop(true);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134310632, size=28, name='uctypes_struct_bytearray_at', path='build/extmod/moductypes.o', has_indirect=False)
    protected void uctypes_struct_bytearray_at(int offset) throws Exception
    {
        pc = uctypes_struct_bytearray_at + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r5 = movs(r5, r0);
                r0 = movs(r0, r1);
                lr = uctypes_struct_bytearray_at + 10 | 1;
                bl(this::mp_obj_int_get_truncated, 10);
                return;
            case 10:
                r4 = movs(r4, r0);
                r0 = movs(r0, r5);
                lr = uctypes_struct_bytearray_at + 18 | 1;
                bl(this::mp_obj_int_get_truncated, 18);
                return;
            case 18:
                r1 = movs(r1, r0);
                r0 = movs(r0, r4);
                lr = uctypes_struct_bytearray_at + 26 | 1;
                bl(this::mp_obj_new_bytearray_by_ref, 26);
                return;
            case 26:
                pop(true, R4, R5, R6);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134310660, size=26, name='uctypes_struct_bytes_at', path='build/extmod/moductypes.o', has_indirect=False)
    protected void uctypes_struct_bytes_at(int offset) throws Exception
    {
        pc = uctypes_struct_bytes_at + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r5 = movs(r5, r1);
                lr = uctypes_struct_bytes_at + 8 | 1;
                bl(this::mp_obj_int_get_truncated, 8);
                return;
            case 8:
                r4 = movs(r4, r0);
                r0 = movs(r0, r5);
                lr = uctypes_struct_bytes_at + 16 | 1;
                bl(this::mp_obj_int_get_truncated, 16);
                return;
            case 16:
                r1 = movs(r1, r0);
                r0 = movs(r0, r4);
                lr = uctypes_struct_bytes_at + 24 | 1;
                bl(this::mp_obj_new_bytes, 24);
                return;
            case 24:
                pop(true, R4, R5, R6);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134310686, size=150, name='get_aligned', path='build/extmod/moductypes.o', has_indirect=False)
    protected void get_aligned(int offset) throws Exception
    {
        pc = get_aligned + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                cmp(r0, 4);
                if (beq(null, 106)) return;
            case 6:
                if (bhi(null, 28)) return;
            case 8:
                cmp(r0, 1);
                if (beq(null, 86)) return;
            case 12:
                cmp(r0, 0);
                if (beq(null, 78)) return;
            case 16:
                cmp(r0, 2);
                if (beq(null, 94)) return;
            case 20:
                cmp(r0, 3);
                if (beq(null, 100)) return;
            case 24:
                r0 = movs(r0, 0);
                b(null, 92);
                return;
            case 28:
                cmp(r0, 7);
                if (beq(null, 126)) return;
            case 32:
                if (bhi(null, 56)) return;
            case 34:
                cmp(r0, 5);
                if (beq(null, 116)) return;
            case 38:
                cmp(r0, 6);
                if (bne(null, 24)) return;
            case 42:
                r2 = lsls(r2, 3);
                r2 = adds(r1, r2);
                r0 = ldr(r2);
                r1 = ldr(r2 + 4);
                lr = get_aligned + 54 | 1;
                bl(this::mp_obj_new_int_from_ull, 54);
                return;
            case 54:
                b(null, 92);
                return;
            case 56:
                cmp(r0, 14);
                if (beq(null, 140)) return;
            case 60:
                cmp(r0, 15);
                if (bne(null, 24)) return;
            case 64:
                r2 = lsls(r2, 3);
                r2 = adds(r1, r2);
                r0 = ldr(r2);
                r1 = ldr(r2 + 4);
                lr = get_aligned + 76 | 1;
                bl(this::__aeabi_d2f, 76);
                return;
            case 76:
                b(null, 144);
                return;
            case 78:
                r3 = ldrb(r1 + r2);
            case 80:
                r3 = lsls(r3, 1);
                r0 = movs(r0, 1);
                b(null, 90);
                return;
            case 86:
                r3 = ldrsb(r1 + r2);
                r3 = lsls(r3, 1);
            case 90:
                r0 = orrs(r0, r3);
            case 92:
                pop(true, R4);
                return;
            case 94:
                r2 = lsls(r2, 1);
                r3 = ldrh(r2 + r1);
                b(null, 80);
                return;
            case 100:
                r2 = lsls(r2, 1);
                r3 = ldrsh(r2 + r1);
                b(null, 80);
                return;
            case 106:
                r2 = lsls(r2, 2);
                r0 = ldr(r2 + r1);
                lr = get_aligned + 114 | 1;
                bl(this::mp_obj_new_int_from_uint, 114);
                return;
            case 114:
                b(null, 92);
                return;
            case 116:
                r2 = lsls(r2, 2);
                r0 = ldr(r2 + r1);
                lr = get_aligned + 124 | 1;
                bl(this::mp_obj_new_int, 124);
                return;
            case 124:
                b(null, 92);
                return;
            case 126:
                r2 = lsls(r2, 3);
                r2 = adds(r1, r2);
                r0 = ldr(r2);
                r1 = ldr(r2 + 4);
                lr = get_aligned + 138 | 1;
                bl(this::mp_obj_new_int_from_ll, 138);
                return;
            case 138:
                b(null, 92);
                return;
            case 140:
                r2 = lsls(r2, 2);
                r0 = ldr(r2 + r1);
            case 144:
                lr = get_aligned + 148 | 1;
                bl(this::mp_obj_new_float, 148);
                return;
            case 148:
                b(null, 92);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134310836, size=66, name='uctypes_struct_make_new', path='build/extmod/moductypes.o', has_indirect=False)
    protected void uctypes_struct_make_new(int offset) throws Exception
    {
        pc = uctypes_struct_make_new + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r4, r5, r6, r7);
                r5 = movs(r5, r3);
                r6 = movs(r6, r1);
                r3 = movs(r3, 0);
                r1 = movs(r1, r2);
                r7 = movs(r7, r0);
                r2 = movs(r2, 2);
                str(sp, r3);
                r0 = movs(r0, r6);
                r3 = adds(r3, 3);
                lr = uctypes_struct_make_new + 24 | 1;
                bl(this::mp_arg_check_num, 24);
                return;
            case 24:
                r0 = movs(r0, 16);
                lr = uctypes_struct_make_new + 30 | 1;
                bl(this::m_malloc, 30);
                return;
            case 30:
                str(r0, r7);
                r4 = movs(r4, r0);
                r0 = ldr(r5);
                lr = uctypes_struct_make_new + 40 | 1;
                bl(this::mp_obj_int_get_truncated, 40);
                return;
            case 40:
                str(r4 + 8, r0);
                r3 = ldr(r5 + 4);
                str(r4 + 4, r3);
                r3 = movs(r3, 2);
                str(r4 + 12, r3);
                cmp(r6, 3);
                if (bne(null, 62)) return;
            case 54:
                r0 = ldr(r5 + 8);
                lr = uctypes_struct_make_new + 60 | 1;
                bl(this::mp_obj_get_int, 60);
                return;
            case 60:
                str(r4 + 12, r0);
            case 62:
                r0 = movs(r0, r4);
                pop(true, R1, R2, R3, R4, R5, R6, R7);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134310904, size=88, name='uctypes_struct_print', path='build/extmod/moductypes.o', has_indirect=False)
    protected void uctypes_struct_print(int offset) throws Exception
    {
        pc = uctypes_struct_print + offset;
        switch (offset)
        {
            case 0:
                r3 = ldr(r1 + 4);
                push(true, r4, r5, r6);
                r2 = 0x080268f3;
                r4 = lsls(r3, 30);
                if (bne(null, 46)) return;
            case 10:
                r4 = ldr(r3);
                r5 = mp_type_dict;
                cmp(r4, r5);
                if (beq(null, 44)) return;
            case 18:
                r5 = mp_type_tuple;
                cmp(r4, r5);
                if (bne(null, 46)) return;
            case 24:
                r3 = ldr(r3 + 8);
                r2 = 0x08020aaf;
                r3 = lsrs(r3, 30);
                cmp(r3, 1);
                if (beq(null, 46)) return;
            case 34:
                r2 = 0x08020772;
                cmp(r3, 2);
                if (beq(null, 46)) return;
            case 40:
                r2 = 0x080268f9;
                b(null, 46);
                return;
            case 44:
                r2 = uctypes_struct_print_str1_1;
            case 46:
                r3 = ldr(r1 + 8);
                r1 = 0x080268fd;
                lr = uctypes_struct_print + 54 | 1;
                bl(this::mp_printf, 54);
                return;
            case 54:
                pop(true, R4, R5, R6);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134310992, size=112, name='set_aligned', path='build/extmod/moductypes.o', has_indirect=False)
    protected void set_aligned(int offset) throws Exception
    {
        pc = set_aligned + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r4, r5, r6, r7);
                r7 = movs(r7, r3);
                r3 = movs(r3, r0);
                r3 = subs(r3, 14);
                r5 = movs(r5, r0);
                r6 = movs(r6, r1);
                r4 = movs(r4, r2);
                r0 = movs(r0, r7);
                cmp(r3, 1);
                if (bhi(null, 48)) return;
            case 20:
                lr = set_aligned + 24 | 1;
                bl(this::mp_obj_get_float, 24);
                return;
            case 24:
                cmp(r5, 14);
                if (bne(null, 34)) return;
            case 28:
                r4 = lsls(r4, 2);
                str(r4 + r6, r0);
            case 32:
                pop(true, R0, R1, R2, R4, R5, R6, R7);
                return;
            case 34:
                lr = set_aligned + 38 | 1;
                bl(this::__aeabi_f2d, 38);
                return;
            case 38:
                r4 = lsls(r4, 3);
                r6 = adds(r6, r4);
                str(r6, r0);
                str(r6 + 4, r1);
                b(null, 32);
                return;
            case 48:
                lr = set_aligned + 52 | 1;
                bl(this::mp_obj_get_int_truncated, 52);
                return;
            case 52:
                cmp(r5, 3);
                if (beq(null, 64)) return;
            case 56:
                if (bhi(null, 70)) return;
            case 58:
                cmp(r5, 1);
                if (beq(null, 98)) return;
            case 62:
                if (bls(null, 98)) return;
            case 64:
                r4 = lsls(r4, 1);
                strh(r4 + r6, r0);
                b(null, 32);
                return;
            case 70:
                cmp(r5, 5);
                if (beq(null, 102)) return;
            case 74:
                if (blo(null, 102)) return;
            case 76:
                cmp(r5, 7);
                if (bhi(null, 32)) return;
            case 80:
                r3 = type2char_6468;
                r2 = movs(r2, r7);
                r1 = ldrb(r3 + r5);
                r0 = movs(r0, 60);
                r3 = add(sp, 4);
                str(sp + 4, r6);
                lr = set_aligned + 96 | 1;
                bl(this::mp_binary_set_val, 96);
                return;
            case 96:
                b(null, 32);
                return;
            case 98:
                strb(r6 + r4, r0);
                b(null, 32);
                return;
            case 102:
                r4 = lsls(r4, 2);
                str(r4 + r6, r0);
                b(null, 32);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134311104, size=236, name='uctypes_struct_size', path='build/extmod/moductypes.o', has_indirect=False)
    protected void uctypes_struct_size(int offset) throws Exception
    {
        pc = uctypes_struct_size + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r6 = movs(r6, r2);
                r7 = movs(r7, r0);
                r2 = movs(r2, 3);
                sp = sub(sp, 20);
                r5 = movs(r5, r0);
                str(sp + 4, r1);
                r7 = ands(r7, r2);
                if (bne(null, 210)) return;
            case 18:
                r3 = ldr(r0);
                r0 = mp_type_dict;
                cmp(r3, r0);
                if (bne(null, 190)) return;
            case 26:
                r4 = movs(r4, r7);
                str(sp + 8, r2);
            case 30:
                r3 = ldr(r5 + 8);
                cmp(r7, r3);
                if (blo(null, 58)) return;
            case 36:
                r3 = ldr(sp + 4);
                cmp(r3, 2);
                if (bne(null, 52)) return;
            case 42:
                r3 = ldr(r6);
                r2 = subs(r3, 1);
                r2 = adds(r2, r4);
                r4 = rsbs(r3, 0);
                r4 = ands(r4, r2);
            case 52:
                r0 = movs(r0, r4);
                sp = add(sp, 20);
                pop(true, R4, R5, R6, R7);
                return;
            case 58:
                r2 = ldr(r5 + 12);
                r3 = lsls(r7, 3);
                r3 = adds(r2, r3);
                r2 = ldr(r3);
                cmp(r2, 0);
                if (beq(null, 130)) return;
            case 70:
                cmp(r2, 4);
                if (beq(null, 130)) return;
            case 74:
                r0 = ldr(r3 + 4);
                r3 = movs(r3, 1);
                tst(r0, r3);
                if (beq(null, 140)) return;
            case 82:
                r3 = asrs(r0, 1);
                r0 = lsrs(r0, 28);
                r2 = movs(r2, r0);
                r2 = subs(r2, 8);
                cmp(r2, 5);
                if (bls(null, 134)) return;
            case 94:
                r3 = lsls(r3, 5);
                r3 = lsrs(r3, 5);
            case 98:
                r2 = movs(r2, 4);
                cmp(r0, 14);
                if (beq(null, 114)) return;
            case 104:
                r2 = ldr(sp + 8);
                r0 = asrs(r0, 1);
                r0 = ands(r0, r2);
                r2 = movs(r2, 1);
                r2 = lsls(r2, r0);
            case 114:
                r1 = ldr(r6);
                cmp(r1, r2);
                if (bhs(null, 122)) return;
            case 120:
                str(r6, r2);
            case 122:
                r3 = adds(r3, r2);
                cmp(r4, r3);
                if (bhs(null, 130)) return;
            case 128:
                r4 = movs(r4, r3);
            case 130:
                r7 = adds(r7, 1);
                b(null, 30);
                return;
            case 134:
                r3 = lsls(r3, 15);
                r3 = lsrs(r3, 15);
                b(null, 98);
                return;
            case 140:
                r3 = ldr(sp + 8);
                tst(r0, r3);
                if (bne(null, 154)) return;
            case 146:
                r3 = mp_type_tuple;
                r2 = ldr(r0);
                cmp(r2, r3);
                if (beq(null, 160)) return;
            case 154:
                r0 = uctypes_struct_size_str1_1;
            case 156:
                lr = uctypes_struct_size + 160 | 1;
                bl(this::mp_raise_TypeError, 160);
                return;
            case 160:
                r3 = ldr(r0 + 8);
                r2 = movs(r2, r6);
                r3 = asrs(r3, 1);
                r1 = ldr(sp + 4);
                str(sp + 12, r3);
                lr = uctypes_struct_size + 174 | 1;
                bl(this::uctypes_struct_agg_size, 174);
                return;
            case 174:
                r3 = ldr(sp + 12);
                r3 = lsls(r3, 3);
                r3 = lsrs(r3, 3);
                r0 = adds(r3, r0);
                cmp(r4, r0);
                if (bhs(null, 130)) return;
            case 186:
                r4 = movs(r4, r0);
                b(null, 130);
                return;
            case 190:
                r2 = mp_type_tuple;
                cmp(r3, r2);
                if (bne(null, 210)) return;
            case 196:
                r2 = movs(r2, r6);
                r1 = ldr(sp + 4);
                r0 = movs(r0, r5);
                lr = uctypes_struct_size + 206 | 1;
                bl(this::uctypes_struct_agg_size, 206);
                return;
            case 206:
                r4 = movs(r4, r0);
                b(null, 52);
                return;
            case 210:
                r3 = lsls(r5, 31);
                if (bpl(null, 154)) return;
            case 214:
                r0 = 0x0802692f;
                b(null, 156);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134311340, size=64, name='uctypes_struct_sizeof', path='build/extmod/moductypes.o', has_indirect=False)
    protected void uctypes_struct_sizeof(int offset) throws Exception
    {
        pc = uctypes_struct_sizeof + offset;
        switch (offset)
        {
            case 0:
                r3 = movs(r3, 0);
                push(true, r0, r1, r2);
                str(sp + 4, r3);
                r3 = lsls(r0, 30);
                if (bne(null, 50)) return;
            case 10:
                r3 = ldr(r0);
                r2 = mp_type_bytearray;
                cmp(r3, r2);
                if (bne(null, 24)) return;
            case 18:
                lr = uctypes_struct_sizeof + 22 | 1;
                bl(this::mp_obj_len, 22);
                return;
            case 22:
                pop(true, R1, R2, R3);
                return;
            case 24:
                r2 = uctypes_struct_type;
                r1 = movs(r1, 2);
                cmp(r3, r2);
                if (bne(null, 36)) return;
            case 32:
                r1 = ldr(r0 + 12);
                r0 = ldr(r0 + 4);
            case 36:
                r2 = add(sp, 4);
                lr = uctypes_struct_sizeof + 42 | 1;
                bl(this::uctypes_struct_size, 42);
                return;
            case 42:
                r3 = lsls(r0, 1);
                r0 = movs(r0, 1);
                r0 = orrs(r0, r3);
                b(null, 22);
                return;
            case 50:
                r1 = movs(r1, 2);
                b(null, 36);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134311404, size=80, name='uctypes_struct_agg_size', path='build/extmod/moductypes.o', has_indirect=False)
    protected void uctypes_struct_agg_size(int offset) throws Exception
    {
        pc = uctypes_struct_agg_size + offset;
        switch (offset)
        {
            case 0:
                r3 = ldr(r0 + 8);
                push(true, r4, r5, r6);
                r3 = lsrs(r3, 30);
                cmp(r3, 1);
                if (beq(null, 30)) return;
            case 10:
                cmp(r3, 0);
                if (beq(null, 22)) return;
            case 14:
                cmp(r3, 2);
                if (beq(null, 42)) return;
            case 18:
                r0 = movs(r0, 0);
                b(null, 28);
                return;
            case 22:
                r0 = ldr(r0 + 12);
                lr = uctypes_struct_agg_size + 28 | 1;
                bl(this::uctypes_struct_size, 28);
                return;
            case 28:
                pop(true, R4, R5, R6);
                return;
            case 30:
                r3 = ldr(r2);
                r0 = movs(r0, 4);
                cmp(r3, 3);
                if (bhi(null, 28)) return;
            case 38:
                str(r2, r0);
                b(null, 28);
                return;
            case 42:
                r3 = ldr(r0 + 12);
                r5 = ldr(r0 + 4);
                r4 = lsls(r3, 4);
                r4 = lsrs(r4, 5);
                cmp(r5, 2);
                if (bne(null, 72)) return;
            case 54:
                r0 = movs(r0, 1);
                r3 = lsrs(r3, 29);
                r0 = lsls(r0, r3);
                r3 = ldr(r2);
                cmp(r0, r3);
                if (bls(null, 68)) return;
            case 66:
                str(r2, r0);
            case 68:
                r0 = muls(r4, r0);
                b(null, 28);
                return;
            case 72:
                r0 = ldr(r0 + 16);
                lr = uctypes_struct_agg_size + 78 | 1;
                bl(this::uctypes_struct_size, 78);
                return;
            case 78:
                b(null, 68);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134311484, size=34, name='uctypes_get_buffer', path='build/extmod/moductypes.o', has_indirect=False)
    protected void uctypes_get_buffer(int offset) throws Exception
    {
        pc = uctypes_get_buffer + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r4, r5, r6);
                r5 = movs(r5, r0);
                r6 = movs(r6, 0);
                r4 = movs(r4, r1);
                r2 = add(sp, 4);
                r1 = ldr(r0 + 12);
                r0 = ldr(r0 + 4);
                str(sp + 4, r6);
                lr = uctypes_get_buffer + 20 | 1;
                bl(this::uctypes_struct_size, 20);
                return;
            case 20:
                r3 = ldr(r5 + 8);
                str(r4, r3);
                r3 = movs(r3, 1);
                str(r4 + 4, r0);
                str(r4 + 8, r3);
                r0 = movs(r0, r6);
                pop(true, R1, R2, R4, R5, R6);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134311520, size=312, name='uctypes_struct_subscr', path='build/extmod/moductypes.o', has_indirect=False)
    protected void uctypes_struct_subscr(int offset) throws Exception
    {
        pc = uctypes_struct_subscr + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r5 = movs(r5, r0);
                sp = sub(sp, 20);
                r4 = subs(r2, 0);
                if (beq(null, 92)) return;
            case 10:
                r2 = movs(r2, 3);
                r6 = ldr(r0 + 4);
                r2 = ands(r2, r6);
                if (bne(null, 26)) return;
            case 18:
                r3 = mp_type_tuple;
                r0 = ldr(r6);
                cmp(r0, r3);
                if (beq(null, 32)) return;
            case 26:
                r0 = uctypes_struct_subscr_str1_1;
                lr = uctypes_struct_subscr + 32 | 1;
                bl(this::mp_raise_TypeError, 32);
                return;
            case 32:
                r3 = ldr(r6 + 8);
                r7 = asrs(r1, 1);
                r3 = lsrs(r3, 30);
                cmp(r3, 2);
                if (bne(null, 212)) return;
            case 42:
                r3 = ldr(r6 + 12);
                r1 = lsls(r3, 4);
                r1 = lsrs(r1, 5);
                cmp(r7, r1);
                if (blt(null, 64)) return;
            case 52:
                r1 = 0x08026975;
                r0 = mp_type_IndexError;
                lr = uctypes_struct_subscr + 60 | 1;
                bl(this::mp_obj_new_exception_msg, 60);
                return;
            case 60:
                lr = uctypes_struct_subscr + 64 | 1;
                bl(this::nlr_jump, 64);
                return;
            case 64:
                r1 = ldr(r6 + 4);
                cmp(r1, 2);
                if (bne(null, 160)) return;
            case 70:
                r2 = ldr(r5 + 12);
                r0 = lsrs(r3, 28);
                r1 = ldr(r5 + 8);
                cmp(r2, 2);
                if (bne(null, 98)) return;
            case 80:
                r2 = movs(r2, r7);
                cmp(r4, 4);
                if (beq(null, 236)) return;
            case 86:
                r3 = movs(r3, r4);
                lr = uctypes_struct_subscr + 92 | 1;
                bl(this::set_aligned, 92);
                return;
            case 92:
                r0 = movs(r0, r4);
                sp = add(sp, 20);
                pop(true, R4, R5, R6, R7);
                return;
            case 98:
                r3 = lsrs(r3, 29);
                r7 = lsls(r7, r3);
                r1 = adds(r1, r7);
                cmp(r4, 4);
                if (bne(null, 134)) return;
            case 108:
                str(sp + 8, r1);
                r3 = movs(r3, 60);
                cmp(r2, 0);
                if (beq(null, 118)) return;
            case 116:
                r3 = adds(r3, 2);
            case 118:
                r2 = type2char_6468;
                r1 = ldrb(r2 + r0);
                r2 = add(sp, 8);
                r0 = movs(r0, r3);
                lr = uctypes_struct_subscr + 130 | 1;
                bl(this::mp_binary_get_val, 130);
                return;
            case 130:
                r4 = movs(r4, r0);
                b(null, 92);
                return;
            case 134:
                str(sp + 12, r1);
                r5 = movs(r5, 60);
                cmp(r2, 0);
                if (beq(null, 144)) return;
            case 142:
                r5 = adds(r5, 2);
            case 144:
                r3 = type2char_6468;
                r2 = movs(r2, r4);
                r1 = ldrb(r3 + r0);
                r3 = add(sp, 12);
                r0 = movs(r0, r5);
                lr = uctypes_struct_subscr + 158 | 1;
                bl(this::mp_binary_set_val, 158);
                return;
            case 158:
                b(null, 92);
                return;
            case 160:
                cmp(r4, 4);
                if (bne(null, 280)) return;
            case 164:
                str(sp + 12, r2);
                r1 = ldr(r5 + 12);
                r2 = add(sp, 12);
                r0 = ldr(r6 + 16);
                lr = uctypes_struct_subscr + 176 | 1;
                bl(this::uctypes_struct_size, 176);
                return;
            case 176:
                str(sp, r0);
                r0 = movs(r0, 16);
                lr = uctypes_struct_subscr + 184 | 1;
                bl(this::m_malloc, 184);
                return;
            case 184:
                r4 = movs(r4, r0);
                r3 = uctypes_struct_type;
                str(r0, r3);
                r3 = ldr(r6 + 16);
                str(r0 + 4, r3);
                r3 = ldr(sp);
                r3 = muls(r7, r3);
                r7 = movs(r7, r3);
                r3 = ldr(r5 + 8);
            case 202:
                r7 = adds(r3, r7);
                r3 = ldr(r5 + 12);
                str(r4 + 8, r7);
                str(r4 + 12, r3);
                b(null, 92);
                return;
            case 212:
                r4 = movs(r4, r2);
                cmp(r3, 1);
                if (bne(null, 92)) return;
            case 218:
                r2 = ldr(r5 + 8);
                r0 = ldr(r6 + 12);
                r2 = ldr(r2);
                r3 = ands(r3, r0);
                str(sp, r2);
                if (beq(null, 242)) return;
            case 230:
                r2 = movs(r2, r7);
                r1 = ldr(sp);
                r0 = lsrs(r0, 28);
            case 236:
                lr = uctypes_struct_subscr + 240 | 1;
                bl(this::get_aligned, 240);
                return;
            case 240:
                b(null, 130);
                return;
            case 242:
                r2 = add(sp, 12);
                r1 = ldr(r5 + 12);
                str(sp + 12, r3);
                lr = uctypes_struct_subscr + 252 | 1;
                bl(this::uctypes_struct_size, 252);
                return;
            case 252:
                str(sp + 4, r0);
                r0 = movs(r0, 16);
                lr = uctypes_struct_subscr + 260 | 1;
                bl(this::m_malloc, 260);
                return;
            case 260:
                r3 = uctypes_struct_type;
                r4 = movs(r4, r0);
                str(r0, r3);
                r3 = ldr(r6 + 12);
                str(r0 + 4, r3);
                r3 = ldr(sp + 4);
                r3 = muls(r7, r3);
                r7 = movs(r7, r3);
                r3 = ldr(sp);
                b(null, 202);
                return;
            case 280:
                r4 = movs(r4, r2);
                b(null, 92);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134311832, size=532, name='uctypes_struct_attr_op', path='build/extmod/moductypes.o', has_indirect=False)
    protected void uctypes_struct_attr_op(int offset) throws Exception
    {
        pc = uctypes_struct_attr_op + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r7 = movs(r7, r0);
                r0 = ldr(r0 + 4);
                r6 = movs(r6, 3);
                r3 = movs(r3, r0);
                sp = sub(sp, 36);
                r3 = ands(r3, r6);
                r4 = movs(r4, r2);
                str(sp + 12, r3);
                cmp(r3, 0);
                if (bne(null, 30)) return;
            case 22:
                r3 = mp_type_dict;
                r2 = ldr(r0);
                cmp(r2, r3);
                if (beq(null, 36)) return;
            case 30:
                r0 = uctypes_struct_attr_op_str1_1;
            case 32:
                lr = uctypes_struct_attr_op + 36 | 1;
                bl(this::mp_raise_TypeError, 36);
                return;
            case 36:
                r3 = lsls(r1, 2);
                r1 = movs(r1, 2);
                r1 = orrs(r1, r3);
                lr = uctypes_struct_attr_op + 46 | 1;
                bl(this::mp_obj_dict_get, 46);
                return;
            case 46:
                r5 = movs(r5, r0);
                r0 = movs(r0, 1);
                tst(r5, r0);
                if (bne(null, 56)) return;
            case 54:
                b(null, 384);
                return;
            case 56:
                r3 = lsrs(r5, 28);
                r1 = asrs(r5, 1);
                str(sp + 4, r3);
                r3 = lsls(r1, 5);
                r3 = lsrs(r3, 5);
                r2 = lsrs(r5, 28);
                cmp(r2, 7);
                if (bls(null, 78)) return;
            case 72:
                r2 = subs(r2, 14);
                cmp(r2, r0);
                if (bhi(null, 174)) return;
            case 78:
                r1 = ldr(r7 + 8);
                r2 = ldr(r7 + 12);
                r1 = adds(r1, r3);
                cmp(r2, 2);
                if (bne(null, 120)) return;
            case 88:
                cmp(r4, 0);
                if (bne(null, 104)) return;
            case 92:
                r2 = movs(r2, r4);
                r0 = ldr(sp + 4);
                lr = uctypes_struct_attr_op + 100 | 1;
                bl(this::get_aligned, 100);
                return;
            case 100:
                r4 = movs(r4, r0);
                b(null, 114);
                return;
            case 104:
                r3 = movs(r3, r4);
                r2 = movs(r2, 0);
                r0 = ldr(sp + 4);
                lr = uctypes_struct_attr_op + 114 | 1;
                bl(this::set_aligned, 114);
                return;
            case 114:
                r0 = movs(r0, r4);
                sp = add(sp, 36);
                pop(true, R4, R5, R6, R7);
                return;
            case 120:
                cmp(r4, 0);
                if (bne(null, 148)) return;
            case 124:
                str(sp + 24, r1);
                r0 = movs(r0, 60);
                cmp(r2, 0);
                if (beq(null, 134)) return;
            case 132:
                r0 = adds(r0, 2);
            case 134:
                r2 = ldr(sp + 4);
                r3 = type2char_6468;
                r1 = ldrb(r3 + r2);
                r2 = add(sp, 24);
                lr = uctypes_struct_attr_op + 146 | 1;
                bl(this::mp_binary_get_val, 146);
                return;
            case 146:
                b(null, 100);
                return;
            case 148:
                str(sp + 28, r1);
                r0 = movs(r0, 60);
                cmp(r2, 0);
                if (beq(null, 158)) return;
            case 156:
                r0 = adds(r0, 2);
            case 158:
                r2 = ldr(sp + 4);
                r3 = type2char_6468;
                r1 = ldrb(r3 + r2);
                r3 = add(sp, 28);
                r2 = movs(r2, r4);
                lr = uctypes_struct_attr_op + 172 | 1;
                bl(this::mp_binary_set_val, 172);
                return;
            case 172:
                b(null, 114);
                return;
            case 174:
                r2 = lsls(r3, 10);
                r1 = lsls(r1, 15);
                r3 = asrs(r3, 22);
                str(sp + 20, r3);
                r3 = lsrs(r1, 15);
                r2 = lsrs(r2, 27);
                str(sp + 16, r3);
                str(sp + 8, r2);
                r3 = ldr(r7 + 8);
                r1 = ldr(sp + 16);
                r2 = ldr(r7 + 12);
                r3 = adds(r3, r1);
                cmp(r2, 2);
                if (bne(null, 264)) return;
            case 202:
                r2 = adds(r2, 4);
                r1 = lsrs(r5, 28);
                r2 = ands(r2, r1);
                cmp(r2, 2);
                if (beq(null, 256)) return;
            case 212:
                cmp(r2, 4);
                if (beq(null, 260)) return;
            case 216:
                r6 = ldr(sp + 12);
                cmp(r2, 0);
                if (bne(null, 224)) return;
            case 222:
                r6 = ldrb(r3);
            case 224:
                r0 = movs(r0, 1);
                r3 = ldr(sp + 20);
                r0 = lsls(r0, r3);
                r3 = subs(r0, 1);
                str(sp + 12, r3);
                cmp(r4, 0);
                if (bne(null, 292)) return;
            case 238:
                r0 = movs(r0, r6);
                r3 = ldr(sp + 8);
                r0 = lsrs(r0, r3);
                r3 = ldr(sp + 12);
                r3 = ands(r3, r0);
                r0 = movs(r0, r3);
                lr = uctypes_struct_attr_op + 254 | 1;
                bl(this::mp_obj_new_int, 254);
                return;
            case 254:
                b(null, 100);
                return;
            case 256:
                r6 = ldrh(r3);
                b(null, 224);
                return;
            case 260:
                r6 = ldr(r3);
                b(null, 224);
                return;
            case 264:
                r1 = subs(r2, 1);
                r2 = sbcs(r2, r1);
                r2 = uxtb(r2);
                str(sp + 12, r2);
                r2 = lsrs(r5, 29);
                r6 = ands(r6, r2);
                r1 = lsrs(r5, 28);
                r1 = ands(r1, r0);
                r2 = ldr(sp + 12);
                r0 = lsls(r0, r6);
                lr = uctypes_struct_attr_op + 288 | 1;
                bl(this::mp_binary_get_int, 288);
                return;
            case 288:
                r6 = movs(r6, r0);
                b(null, 224);
                return;
            case 292:
                r0 = movs(r0, r4);
                lr = uctypes_struct_attr_op + 298 | 1;
                bl(this::mp_obj_get_int, 298);
                return;
            case 298:
                r3 = ldr(sp + 12);
                r2 = ldr(sp + 8);
                r3 = ands(r3, r0);
                r0 = ldr(sp + 12);
                r3 = lsls(r3, r2);
                r0 = lsls(r0, r2);
                r1 = ldr(r7 + 12);
                r6 = bics(r6, r0);
                r3 = orrs(r3, r6);
                r2 = ldr(r7 + 8);
                cmp(r1, 2);
                if (bne(null, 358)) return;
            case 322:
                r1 = ldr(sp + 16);
                r0 = ldr(sp + 4);
                r2 = adds(r2, r1);
                r1 = movs(r1, 6);
                r0 = ands(r0, r1);
                cmp(r0, 2);
                if (beq(null, 350)) return;
            case 336:
                cmp(r0, 4);
                if (beq(null, 354)) return;
            case 340:
                cmp(r0, 0);
                if (beq(null, 346)) return;
            case 344:
                b(null, 114);
                return;
            case 346:
                strb(r2, r3);
                b(null, 114);
                return;
            case 350:
                strh(r2, r3);
                b(null, 114);
                return;
            case 354:
                str(r2, r3);
                b(null, 114);
                return;
            case 358:
                r0 = ldr(sp + 16);
                r1 = subs(r1, 1);
                r2 = adds(r2, r0);
                r0 = rsbs(r1, 0);
                r1 = adcs(r1, r0);
                r0 = movs(r0, 1);
                r5 = lsls(r5, 1);
                r5 = lsrs(r5, 30);
                r1 = uxtb(r1);
                r0 = lsls(r0, r5);
                lr = uctypes_struct_attr_op + 382 | 1;
                bl(this::mp_binary_set_int, 382);
                return;
            case 382:
                b(null, 114);
                return;
            case 384:
                tst(r5, r6);
                if (bne(null, 396)) return;
            case 388:
                r3 = mp_type_tuple;
                r2 = ldr(r5);
                cmp(r2, r3);
                if (beq(null, 400)) return;
            case 396:
                r0 = uctypes_struct_size_str1_1;
                b(null, 32);
                return;
            case 400:
                cmp(r4, 0);
                if (bne(null, 396)) return;
            case 404:
                r3 = ldr(r5 + 8);
                r6 = lsls(r3, 2);
                r6 = lsrs(r6, 3);
                r3 = lsrs(r3, 30);
                cmp(r3, 1);
                if (beq(null, 486)) return;
            case 416:
                cmp(r3, 0);
                if (beq(null, 458)) return;
            case 420:
                cmp(r3, 2);
                if (beq(null, 426)) return;
            case 424:
                b(null, 114);
                return;
            case 426:
                r3 = ldr(r5 + 4);
                cmp(r3, 2);
                if (bne(null, 486)) return;
            case 432:
                r3 = ldr(r5 + 12);
                r3 = lsrs(r3, 28);
                if (bne(null, 486)) return;
            case 438:
                r1 = ldr(r7 + 12);
                r2 = add(sp, 28);
                r0 = movs(r0, r5);
                lr = uctypes_struct_attr_op + 448 | 1;
                bl(this::uctypes_struct_agg_size, 448);
                return;
            case 448:
                r1 = ldr(r7 + 8);
                r1 = adds(r1, r6);
                lr = uctypes_struct_attr_op + 456 | 1;
                bl(this::mp_obj_new_bytearray_by_ref, 456);
                return;
            case 456:
                b(null, 100);
                return;
            case 458:
                r0 = movs(r0, 16);
                lr = uctypes_struct_attr_op + 464 | 1;
                bl(this::m_malloc, 464);
                return;
            case 464:
                r4 = movs(r4, r0);
                r3 = uctypes_struct_type;
                str(r0, r3);
                r3 = ldr(r5 + 12);
                str(r0 + 4, r3);
            case 474:
                r3 = ldr(r7 + 8);
                r6 = adds(r3, r6);
                r3 = ldr(r7 + 12);
                str(r4 + 8, r6);
                str(r4 + 12, r3);
                b(null, 114);
                return;
            case 486:
                r0 = movs(r0, 16);
                lr = uctypes_struct_attr_op + 492 | 1;
                bl(this::m_malloc, 492);
                return;
            case 492:
                r3 = uctypes_struct_type;
                r4 = movs(r4, r0);
                str(r0, r3);
                str(r0 + 4, r5);
                b(null, 474);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134312364, size=34, name='uctypes_struct_attr', path='build/extmod/moductypes.o', has_indirect=False)
    protected void uctypes_struct_attr(int offset) throws Exception
    {
        pc = uctypes_struct_attr + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r4 = movs(r4, r2);
                r2 = ldr(r2);
                cmp(r2, 0);
                if (bne(null, 18)) return;
            case 10:
                lr = uctypes_struct_attr + 14 | 1;
                bl(this::uctypes_struct_attr_op, 14);
                return;
            case 14:
                str(r4, r0);
            case 16:
                pop(true, R4);
                return;
            case 18:
                r2 = ldr(r4 + 4);
                lr = uctypes_struct_attr + 24 | 1;
                bl(this::uctypes_struct_attr_op, 24);
                return;
            case 24:
                cmp(r0, 0);
                if (beq(null, 16)) return;
            case 28:
                r3 = movs(r3, 0);
                str(r4, r3);
                b(null, 16);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134312398, size=42, name='ujson_stream_next', path='build/extmod/modujson.o', has_indirect=False)
    protected void ujson_stream_next(int offset) throws Exception
    {
        pc = ujson_stream_next + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r3 = movs(r3, r0);
                r4 = movs(r4, r0);
                r1 = movs(r1, r0);
                r3 = adds(r3, 8);
                r1 = adds(r1, 12);
                r2 = movs(r2, 1);
                r0 = ldr(r0);
                r5 = ldr(r4 + 4);
                blx(r5, 20);
                return;
            case 20:
                r3 = movs(r3, r0);
                r0 = ldr(r4 + 8);
                cmp(r0, 0);
                if (beq(null, 32)) return;
            case 28:
                lr = ujson_stream_next + 32 | 1;
                bl(this::mp_raise_OSError, 32);
                return;
            case 32:
                cmp(r3, 0);
                if (bne(null, 38)) return;
            case 36:
                strb(r4 + 12, r3);
            case 38:
                r0 = ldrb(r4 + 12);
                pop(true, R4, R5, R6);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134312440, size=760, name='mod_ujson_load', path='build/extmod/modujson.o', has_indirect=False)
    protected void mod_ujson_load(int offset) throws Exception
    {
        pc = mod_ujson_load + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r5 = movs(r5, r0);
                sp = sub(sp, 68);
                r1 = movs(r1, 1);
                lr = mod_ujson_load + 12 | 1;
                bl(this::mp_get_stream_raise, 12);
                return;
            case 12:
                str(sp + 16, r5);
                r5 = movs(r5, 0);
                r6 = movs(r6, r5);
                r3 = ldr(r0);
                r4 = add(sp, 16);
                r1 = movs(r1, 8);
                r0 = add(sp, 32);
                str(r4 + 4, r3);
                str(r4 + 8, r5);
                strb(r4 + 12, r5);
                lr = mod_ujson_load + 36 | 1;
                bl(this::vstr_init, 36);
                return;
            case 36:
                r0 = movs(r0, r4);
                str(sp + 56, r5);
                str(sp + 60, r5);
                lr = mod_ujson_load + 46 | 1;
                bl(this::ujson_stream_next, 46);
                return;
            case 46:
                str(sp + 8, r5);
                str(sp + 12, r5);
            case 50:
                r5 = ldrb(r4 + 12);
                cmp(r5, 0);
                if (bne(null, 58)) return;
            case 56:
                b(null, 684);
                return;
            case 58:
                r0 = movs(r0, r4);
                lr = mod_ujson_load + 64 | 1;
                bl(this::ujson_stream_next, 64);
                return;
            case 64:
                cmp(r5, 57);
                if (bhi(null, 144)) return;
            case 68:
                cmp(r5, 48);
                if (blo(null, 74)) return;
            case 72:
                b(null, 516);
                return;
            case 74:
                cmp(r5, 32);
                if (beq(null, 50)) return;
            case 78:
                if (bhi(null, 98)) return;
            case 80:
                cmp(r5, 9);
                if (blo(null, 92)) return;
            case 84:
                cmp(r5, 10);
                if (bls(null, 50)) return;
            case 88:
                cmp(r5, 13);
                if (beq(null, 50)) return;
            case 92:
                r0 = mod_ujson_load_str1_1;
                lr = mod_ujson_load + 98 | 1;
                bl(this::mp_raise_ValueError, 98);
                return;
            case 98:
                cmp(r5, 44);
                if (beq(null, 50)) return;
            case 102:
                cmp(r5, 45);
                if (bne(null, 108)) return;
            case 106:
                b(null, 516);
                return;
            case 108:
                cmp(r5, 34);
                if (bne(null, 92)) return;
            case 112:
                r3 = movs(r3, 0);
                str(sp + 36, r3);
            case 116:
                r1 = ldrb(r4 + 12);
                cmp(r1, 0);
                if (beq(null, 92)) return;
            case 122:
                cmp(r1, 34);
                if (beq(null, 128)) return;
            case 126:
                b(null, 394);
                return;
            case 128:
                r0 = movs(r0, r4);
                lr = mod_ujson_load + 134 | 1;
                bl(this::ujson_stream_next, 134);
                return;
            case 134:
                r1 = ldr(sp + 36);
                r0 = ldr(sp + 40);
                lr = mod_ujson_load + 142 | 1;
                bl(this::mp_obj_new_str, 142);
                return;
            case 142:
                b(null, 574);
                return;
            case 144:
                cmp(r5, 102);
                if (beq(null, 306)) return;
            case 148:
                if (bhi(null, 166)) return;
            case 150:
                cmp(r5, 91);
                if (bne(null, 156)) return;
            case 154:
                b(null, 598);
                return;
            case 156:
                cmp(r5, 93);
                if (beq(null, 274)) return;
            case 160:
                cmp(r5, 58);
                if (bne(null, 92)) return;
            case 164:
                b(null, 50);
                return;
            case 166:
                cmp(r5, 116);
                if (beq(null, 352)) return;
            case 170:
                if (bhi(null, 264)) return;
            case 172:
                cmp(r5, 110);
                if (bne(null, 92)) return;
            case 176:
                r3 = ldrb(r4 + 12);
                cmp(r3, 117);
                if (bne(null, 92)) return;
            case 182:
                r0 = movs(r0, r4);
                lr = mod_ujson_load + 188 | 1;
                bl(this::ujson_stream_next, 188);
                return;
            case 188:
                cmp(r0, 108);
                if (bne(null, 92)) return;
            case 192:
                r0 = movs(r0, r4);
                lr = mod_ujson_load + 198 | 1;
                bl(this::ujson_stream_next, 198);
                return;
            case 198:
                cmp(r0, 108);
                if (bne(null, 92)) return;
            case 202:
                r0 = movs(r0, r4);
                lr = mod_ujson_load + 208 | 1;
                bl(this::ujson_stream_next, 208);
                return;
            case 208:
                r5 = mp_const_none_obj;
            case 210:
                cmp(r6, 0);
                if (bne(null, 216)) return;
            case 214:
                b(null, 728);
                return;
            case 216:
                r7 = movs(r7, 0);
            case 218:
                r3 = mp_type_list;
                r2 = ldr(sp + 12);
                cmp(r2, r3);
                if (beq(null, 228)) return;
            case 226:
                b(null, 636);
                return;
            case 228:
                r1 = movs(r1, r5);
                r0 = movs(r0, r6);
                lr = mod_ujson_load + 236 | 1;
                bl(this::mp_obj_list_append, 236);
                return;
            case 236:
                cmp(r7, 0);
                if (beq(null, 50)) return;
            case 240:
                r3 = ldr(sp + 60);
                str(sp + 12, r3);
                cmp(r3, 0);
                if (beq(null, 250)) return;
            case 248:
                b(null, 668);
                return;
            case 250:
                r1 = movs(r1, 1);
                r0 = add(sp, 48);
                lr = mod_ujson_load + 258 | 1;
                bl(this::mp_obj_list_init, 258);
                return;
            case 258:
                r3 = ldr(sp + 60);
                str(r3, r6);
                b(null, 616);
                return;
            case 264:
                cmp(r5, 123);
                if (bne(null, 270)) return;
            case 268:
                b(null, 628);
                return;
            case 270:
                cmp(r5, 125);
                if (bne(null, 92)) return;
            case 274:
                cmp(r6, 0);
                if (beq(null, 92)) return;
            case 278:
                r3 = ldr(sp + 56);
                cmp(r3, 0);
                if (bne(null, 286)) return;
            case 284:
                b(null, 684);
                return;
            case 286:
                r3 = subs(r3, 1);
                r2 = ldr(sp + 60);
                str(sp + 56, r3);
                r3 = lsls(r3, 2);
                r6 = ldr(r3 + r2);
                r0 = movs(r0, r6);
                lr = mod_ujson_load + 302 | 1;
                bl(this::mp_obj_get_type, 302);
                return;
            case 302:
                str(sp + 12, r0);
                b(null, 50);
                return;
            case 306:
                r3 = ldrb(r4 + 12);
                cmp(r3, 97);
                if (bne(null, 92)) return;
            case 312:
                r0 = movs(r0, r4);
                lr = mod_ujson_load + 318 | 1;
                bl(this::ujson_stream_next, 318);
                return;
            case 318:
                cmp(r0, 108);
                if (bne(null, 92)) return;
            case 322:
                r0 = movs(r0, r4);
                lr = mod_ujson_load + 328 | 1;
                bl(this::ujson_stream_next, 328);
                return;
            case 328:
                cmp(r0, 115);
                if (bne(null, 92)) return;
            case 332:
                r0 = movs(r0, r4);
                lr = mod_ujson_load + 338 | 1;
                bl(this::ujson_stream_next, 338);
                return;
            case 338:
                cmp(r0, 101);
                if (bne(null, 92)) return;
            case 342:
                r0 = movs(r0, r4);
                lr = mod_ujson_load + 348 | 1;
                bl(this::ujson_stream_next, 348);
                return;
            case 348:
                r5 = mp_const_false_obj;
                b(null, 210);
                return;
            case 352:
                r3 = ldrb(r4 + 12);
                cmp(r3, 114);
                if (beq(null, 360)) return;
            case 358:
                b(null, 92);
                return;
            case 360:
                r0 = movs(r0, r4);
                lr = mod_ujson_load + 366 | 1;
                bl(this::ujson_stream_next, 366);
                return;
            case 366:
                cmp(r0, 117);
                if (beq(null, 372)) return;
            case 370:
                b(null, 92);
                return;
            case 372:
                r0 = movs(r0, r4);
                lr = mod_ujson_load + 378 | 1;
                bl(this::ujson_stream_next, 378);
                return;
            case 378:
                cmp(r0, 101);
                if (beq(null, 384)) return;
            case 382:
                b(null, 92);
                return;
            case 384:
                r0 = movs(r0, r4);
                lr = mod_ujson_load + 390 | 1;
                bl(this::ujson_stream_next, 390);
                return;
            case 390:
                r5 = mp_const_true_obj;
                b(null, 210);
                return;
            case 394:
                cmp(r1, 92);
                if (bne(null, 420)) return;
            case 398:
                r0 = movs(r0, r4);
                lr = mod_ujson_load + 404 | 1;
                bl(this::ujson_stream_next, 404);
                return;
            case 404:
                r1 = movs(r1, r0);
                cmp(r0, 110);
                if (beq(null, 448)) return;
            case 410:
                if (bhi(null, 428)) return;
            case 412:
                cmp(r0, 98);
                if (beq(null, 512)) return;
            case 416:
                cmp(r0, 102);
                if (beq(null, 444)) return;
            case 420:
                r0 = add(sp, 32);
                lr = mod_ujson_load + 426 | 1;
                bl(this::vstr_add_byte, 426);
                return;
            case 426:
                b(null, 504);
                return;
            case 428:
                cmp(r0, 116);
                if (beq(null, 452)) return;
            case 432:
                cmp(r0, 117);
                if (beq(null, 456)) return;
            case 436:
                cmp(r0, 114);
                if (bne(null, 420)) return;
            case 440:
                r1 = movs(r1, 13);
                b(null, 420);
                return;
            case 444:
                r1 = movs(r1, 12);
                b(null, 420);
                return;
            case 448:
                r1 = movs(r1, 10);
                b(null, 420);
                return;
            case 452:
                r1 = movs(r1, 9);
                b(null, 420);
                return;
            case 456:
                r7 = movs(r7, 4);
                r5 = movs(r5, 0);
            case 460:
                r0 = movs(r0, r4);
                lr = mod_ujson_load + 466 | 1;
                bl(this::ujson_stream_next, 466);
                return;
            case 466:
                r3 = movs(r3, 32);
                r0 = orrs(r0, r3);
                r0 = uxtb(r0);
                r3 = movs(r3, r0);
                r3 = subs(r3, 48);
                r3 = uxtb(r3);
                cmp(r3, 9);
                if (bls(null, 486)) return;
            case 482:
                r0 = subs(r0, 87);
                r3 = uxtb(r0);
            case 486:
                r5 = lsls(r5, 4);
                r7 = subs(r7, 1);
                r5 = orrs(r5, r3);
                cmp(r7, 0);
                if (bne(null, 460)) return;
            case 496:
                r1 = movs(r1, r5);
                r0 = add(sp, 32);
                lr = mod_ujson_load + 504 | 1;
                bl(this::vstr_add_char, 504);
                return;
            case 504:
                r0 = movs(r0, r4);
                lr = mod_ujson_load + 510 | 1;
                bl(this::ujson_stream_next, 510);
                return;
            case 510:
                b(null, 116);
                return;
            case 512:
                r1 = movs(r1, 8);
                b(null, 420);
                return;
            case 516:
                r7 = movs(r7, 0);
                str(sp + 36, r7);
            case 520:
                r1 = movs(r1, r5);
                r0 = add(sp, 32);
                lr = mod_ujson_load + 528 | 1;
                bl(this::vstr_add_byte, 528);
                return;
            case 528:
                r5 = ldrb(r4 + 12);
                cmp(r5, 46);
                if (beq(null, 578)) return;
            case 534:
                r3 = movs(r3, r5);
                r2 = movs(r2, 32);
                r3 = bics(r3, r2);
                cmp(r3, 69);
                if (beq(null, 578)) return;
            case 544:
                cmp(r5, 45);
                if (beq(null, 580)) return;
            case 548:
                r0 = movs(r0, r5);
                lr = mod_ujson_load + 554 | 1;
                bl(this::unichar_isdigit, 554);
                return;
            case 554:
                r2 = subs(r0, 0);
                if (bne(null, 580)) return;
            case 558:
                r0 = ldr(sp + 40);
                r1 = ldr(sp + 36);
                cmp(r7, 0);
                if (beq(null, 588)) return;
            case 566:
                str(sp, r2);
                r3 = movs(r3, r2);
                lr = mod_ujson_load + 574 | 1;
                bl(this::mp_parse_num_decimal, 574);
                return;
            case 574:
                r5 = movs(r5, r0);
                b(null, 210);
                return;
            case 578:
                r7 = movs(r7, 1);
            case 580:
                r0 = movs(r0, r4);
                lr = mod_ujson_load + 586 | 1;
                bl(this::ujson_stream_next, 586);
                return;
            case 586:
                b(null, 520);
                return;
            case 588:
                r3 = movs(r3, r7);
                r2 = movs(r2, 10);
                lr = mod_ujson_load + 596 | 1;
                bl(this::mp_parse_num_integer, 596);
                return;
            case 596:
                b(null, 574);
                return;
            case 598:
                r1 = movs(r1, 0);
                r0 = movs(r0, r1);
                lr = mod_ujson_load + 606 | 1;
                bl(this::mp_obj_new_list, 606);
                return;
            case 606:
                r5 = movs(r5, r0);
                r7 = movs(r7, 1);
                cmp(r6, 0);
                if (beq(null, 616)) return;
            case 614:
                b(null, 218);
                return;
            case 616:
                r0 = movs(r0, r5);
                lr = mod_ujson_load + 622 | 1;
                bl(this::mp_obj_get_type, 622);
                return;
            case 622:
                r6 = movs(r6, r5);
                str(sp + 12, r0);
                b(null, 50);
                return;
            case 628:
                r0 = movs(r0, 0);
                lr = mod_ujson_load + 634 | 1;
                bl(this::mp_obj_new_dict, 634);
                return;
            case 634:
                b(null, 606);
                return;
            case 636:
                r3 = ldr(sp + 8);
                cmp(r3, 0);
                if (bne(null, 652)) return;
            case 642:
                cmp(r7, 0);
                if (beq(null, 648)) return;
            case 646:
                b(null, 92);
                return;
            case 648:
                str(sp + 8, r5);
                b(null, 50);
                return;
            case 652:
                r2 = movs(r2, r5);
                r1 = ldr(sp + 8);
                r0 = movs(r0, r6);
                lr = mod_ujson_load + 662 | 1;
                bl(this::mp_obj_dict_store, 662);
                return;
            case 662:
                r3 = movs(r3, 0);
                str(sp + 8, r3);
                b(null, 236);
                return;
            case 668:
                r1 = movs(r1, r6);
                r0 = add(sp, 48);
                lr = mod_ujson_load + 676 | 1;
                bl(this::mp_obj_list_append, 676);
                return;
            case 676:
                b(null, 616);
                return;
            case 678:
                r0 = movs(r0, r4);
                lr = mod_ujson_load + 684 | 1;
                bl(this::ujson_stream_next, 684);
                return;
            case 684:
                r0 = ldrb(r4 + 12);
                lr = mod_ujson_load + 690 | 1;
                bl(this::unichar_isspace, 690);
                return;
            case 690:
                cmp(r0, 0);
                if (bne(null, 678)) return;
            case 694:
                r3 = ldrb(r4 + 12);
                cmp(r3, 0);
                if (beq(null, 702)) return;
            case 700:
                b(null, 92);
                return;
            case 702:
                cmp(r6, 0);
                if (bne(null, 708)) return;
            case 706:
                b(null, 92);
                return;
            case 708:
                r3 = ldr(sp + 56);
                cmp(r3, 0);
                if (beq(null, 716)) return;
            case 714:
                b(null, 92);
                return;
            case 716:
                r0 = add(sp, 32);
                lr = mod_ujson_load + 722 | 1;
                bl(this::vstr_clear, 722);
                return;
            case 722:
                r0 = movs(r0, r6);
                sp = add(sp, 68);
                pop(true, R4, R5, R6, R7);
                return;
            case 728:
                r0 = movs(r0, r5);
                lr = mod_ujson_load + 734 | 1;
                bl(this::mp_obj_get_type, 734);
                return;
            case 734:
                r6 = movs(r6, r5);
                b(null, 684);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134313200, size=56, name='mod_ujson_loads', path='build/extmod/modujson.o', has_indirect=False)
    protected void mod_ujson_loads(int offset) throws Exception
    {
        pc = mod_ujson_loads + offset;
        switch (offset)
        {
            case 0:
                push(true);
                sp = sub(sp, 44);
                r1 = add(sp, 4);
                lr = mod_ujson_loads + 10 | 1;
                bl(this::mp_obj_str_get_data, 10);
                return;
            case 10:
                r2 = ldr(sp + 4);
                r3 = add(sp, 8);
                str(sp + 8, r2);
                str(sp + 12, r2);
                r2 = movs(r2, 1);
                r1 = ldrb(r3 + 12);
                str(sp + 28, r3);
                r2 = orrs(r2, r1);
                strb(r3 + 12, r2);
                r3 = movs(r3, 0);
                r2 = mp_type_stringio;
                str(sp + 16, r0);
                r0 = add(sp, 24);
                str(sp + 24, r2);
                str(sp + 32, r3);
                str(sp + 36, r3);
                lr = mod_ujson_loads + 46 | 1;
                bl(this::mod_ujson_load, 46);
                return;
            case 46:
                sp = add(sp, 44);
                pop(true);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134313256, size=44, name='mod_ujson_dump', path='build/extmod/modujson.o', has_indirect=False)
    protected void mod_ujson_dump(int offset) throws Exception
    {
        pc = mod_ujson_dump + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r4, r5);
                r4 = movs(r4, r1);
                r5 = movs(r5, r0);
                r1 = movs(r1, 2);
                r0 = movs(r0, r4);
                lr = mod_ujson_dump + 14 | 1;
                bl(this::mp_get_stream_raise, 14);
                return;
            case 14:
                r3 = mp_stream_write_adaptor | 1;
                hint(mp_stream_write_adaptor | 1, this::mp_stream_write_adaptor);
                r1 = movs(r1, r5);
                r0 = mov(sp);
                r2 = movs(r2, 3);
                str(sp, r4);
                str(sp + 4, r3);
                lr = mod_ujson_dump + 30 | 1;
                bl(this::mp_obj_print_helper, 30);
                return;
            case 30:
                r0 = mp_const_none_obj;
                pop(true, R1, R2, R3, R4, R5);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134313300, size=44, name='mod_ujson_dumps', path='build/extmod/modujson.o', has_indirect=False)
    protected void mod_ujson_dumps(int offset) throws Exception
    {
        pc = mod_ujson_dumps + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r4 = movs(r4, r0);
                sp = sub(sp, 24);
                r2 = mov(sp);
                r0 = add(sp, 8);
                r1 = movs(r1, 8);
                lr = mod_ujson_dumps + 16 | 1;
                bl(this::vstr_init_print, 16);
                return;
            case 16:
                r2 = movs(r2, 3);
                r1 = movs(r1, r4);
                r0 = mov(sp);
                lr = mod_ujson_dumps + 26 | 1;
                bl(this::mp_obj_print_helper, 26);
                return;
            case 26:
                r1 = add(sp, 8);
                r0 = mp_type_str;
                lr = mod_ujson_dumps + 34 | 1;
                bl(this::mp_obj_new_str_from_vstr, 34);
                return;
            case 34:
                sp = add(sp, 24);
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134313344, size=16, name='match_print', path='build/extmod/modure.o', has_indirect=False)
    protected void match_print(int offset) throws Exception
    {
        pc = match_print + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r2 = ldr(r1 + 4);
                r1 = match_print_str1_1;
                lr = match_print + 10 | 1;
                bl(this::mp_printf, 10);
                return;
            case 10:
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134313360, size=16, name='re_print', path='build/extmod/modure.o', has_indirect=False)
    protected void re_print(int offset) throws Exception
    {
        pc = re_print + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r2 = movs(r2, r1);
                r1 = re_print_str1_1;
                lr = re_print + 10 | 1;
                bl(this::mp_printf, 10);
                return;
            case 10:
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134313376, size=860, name='_compilecode', path='build/extmod/modure.o', has_indirect=False)
    protected void _compilecode(int offset) throws Exception
    {
        pc = _compilecode + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r5 = movs(r5, 0);
                sp = sub(sp, 28);
                r4 = movs(r4, r1);
                str(sp + 20, r2);
                cmp(r2, r5);
                if (bne(null, 18)) return;
            case 14:
                r5 = movs(r5, r1);
                r5 = adds(r5, 12);
            case 18:
                r3 = ldr(r4);
                r6 = movs(r6, r0);
                str(sp + 8, r3);
                r7 = movs(r7, r3);
                r3 = movs(r3, 0);
                str(sp + 4, r3);
            case 30:
                r3 = ldrb(r6);
                cmp(r3, 0);
                if (beq(null, 40)) return;
            case 36:
                cmp(r3, 41);
                if (bne(null, 62)) return;
            case 40:
                r3 = ldr(sp + 4);
                cmp(r3, 0);
                if (beq(null, 294)) return;
            case 46:
                cmp(r5, 0);
                if (beq(null, 294)) return;
            case 50:
                r3 = ldr(r4);
                r2 = ldr(sp + 4);
                r3 = subs(r3, 1);
                r3 = subs(r3, r2);
                strb(r5 + r2, r3);
                b(null, 294);
                return;
            case 62:
                cmp(r3, 46);
                if (bne(null, 68)) return;
            case 66:
                b(null, 364);
                return;
            case 68:
                if (bhi(null, 160)) return;
            case 70:
                r2 = ldr(r4);
                cmp(r3, 40);
                if (bne(null, 78)) return;
            case 76:
                b(null, 448);
                return;
            case 78:
                if (bhi(null, 114)) return;
            case 80:
                cmp(r3, 36);
                if (bne(null, 86)) return;
            case 84:
                b(null, 848);
                return;
            case 86:
                r2 = movs(r2, r6);
            case 88:
                r7 = ldr(r4);
                cmp(r5, 0);
                if (bne(null, 96)) return;
            case 94:
                b(null, 358);
                return;
            case 96:
                r3 = adds(r7, 1);
                str(r4, r3);
                r3 = movs(r3, 1);
                strb(r5 + r7, r3);
                r3 = ldr(r4);
                r1 = adds(r3, 1);
                str(r4, r1);
                r1 = ldrb(r2);
                b(null, 344);
                return;
            case 114:
                cmp(r3, 42);
                if (bne(null, 120)) return;
            case 118:
                b(null, 656);
                return;
            case 120:
                cmp(r3, 43);
                if (bne(null, 86)) return;
            case 124:
                cmp(r2, r7);
                if (beq(null, 292)) return;
            case 128:
                r3 = ldrb(r6 + 1);
                cmp(r3, 63);
                if (beq(null, 136)) return;
            case 134:
                b(null, 758);
                return;
            case 136:
                cmp(r5, 0);
                if (beq(null, 144)) return;
            case 140:
                r3 = adds(r3, 34);
                strb(r5 + r2, r3);
            case 144:
                r6 = adds(r6, 1);
                cmp(r5, 0);
                if (beq(null, 152)) return;
            case 150:
                b(null, 768);
                return;
            case 152:
                r3 = ldr(r4);
                r7 = adds(r3, 2);
                str(r4, r7);
                b(null, 378);
                return;
            case 160:
                cmp(r3, 92);
                if (beq(null, 284)) return;
            case 164:
                r2 = ldr(r4);
                if (bhi(null, 234)) return;
            case 168:
                cmp(r3, 63);
                if (bne(null, 174)) return;
            case 172:
                b(null, 582);
                return;
            case 174:
                cmp(r3, 91);
                if (bne(null, 86)) return;
            case 178:
                r0 = ldrb(r6 + 1);
                r3 = adds(r2, 1);
                r7 = movs(r7, r2);
                r1 = adds(r6, 1);
                str(r4, r3);
                cmp(r0, 94);
                if (bne(null, 386)) return;
            case 192:
                cmp(r5, 0);
                if (beq(null, 200)) return;
            case 196:
                r3 = movs(r3, 4);
                strb(r5 + r2, r3);
            case 200:
                r1 = adds(r6, 2);
            case 202:
                r3 = ldr(r4);
                r6 = movs(r6, r1);
                r3 = adds(r3, 1);
                str(r4, r3);
                r3 = ldr(r4 + 4);
                r3 = adds(r3, 1);
                str(r4 + 4, r3);
                r3 = movs(r3, 0);
            case 218:
                r1 = ldrb(r6);
                cmp(r1, 93);
                if (bne(null, 396)) return;
            case 224:
                cmp(r5, 0);
                if (beq(null, 354)) return;
            case 228:
                r2 = adds(r5, r2);
                strb(r2 + 1, r3);
                b(null, 354);
                return;
            case 234:
                cmp(r3, 94);
                if (bne(null, 240)) return;
            case 238:
                b(null, 834);
                return;
            case 240:
                cmp(r3, 124);
                if (bne(null, 86)) return;
            case 244:
                r3 = ldr(sp + 4);
                cmp(r3, 0);
                if (bne(null, 252)) return;
            case 250:
                b(null, 780);
                return;
            case 252:
                cmp(r5, 0);
                if (bne(null, 258)) return;
            case 256:
                b(null, 786);
                return;
            case 258:
                r2 = subs(r2, 1);
                r2 = subs(r2, r3);
                strb(r5 + r3, r2);
            case 264:
                r3 = ldr(r4);
                r2 = ldr(sp + 8);
                r2 = subs(r3, r2);
                r3 = ldr(sp + 8);
                r0 = adds(r3, 2);
                r1 = adds(r5, r3);
                r0 = adds(r5, r0);
                lr = _compilecode + 282 | 1;
                bl(this::memmove, 282);
                return;
            case 282:
                b(null, 786);
                return;
            case 284:
                r3 = ldrb(r6 + 1);
                r2 = adds(r6, 1);
                cmp(r3, 0);
                if (bne(null, 300)) return;
            case 292:
                r6 = movs(r6, 0);
            case 294:
                r0 = movs(r0, r6);
                sp = add(sp, 28);
                pop(true, R4, R5, R6, R7);
                return;
            case 300:
                r1 = movs(r1, 32);
                r0 = movs(r0, r1);
                r0 = orrs(r0, r3);
                cmp(r0, 100);
                if (beq(null, 322)) return;
            case 310:
                r0 = movs(r0, 4);
                r3 = bics(r3, r0);
                r3 = orrs(r3, r1);
                cmp(r3, 115);
                if (beq(null, 322)) return;
            case 320:
                b(null, 88);
                return;
            case 322:
                r7 = ldr(r4);
                cmp(r5, 0);
                if (beq(null, 358)) return;
            case 328:
                r3 = adds(r7, 1);
                str(r4, r3);
                r3 = movs(r3, 5);
                strb(r5 + r7, r3);
                r3 = ldr(r4);
                r1 = adds(r3, 1);
                str(r4, r1);
                r1 = ldrb(r6 + 1);
            case 344:
                strb(r5 + r3, r1);
            case 346:
                r6 = movs(r6, r2);
                r3 = ldr(r4 + 4);
                r3 = adds(r3, 1);
                str(r4 + 4, r3);
            case 354:
                r6 = adds(r6, 1);
                b(null, 30);
                return;
            case 358:
                r3 = adds(r7, 2);
                str(r4, r3);
                b(null, 346);
                return;
            case 364:
                r7 = ldr(r4);
                r3 = adds(r7, 1);
                str(r4, r3);
                cmp(r5, 0);
                if (beq(null, 378)) return;
            case 374:
                r3 = movs(r3, 2);
                strb(r5 + r7, r3);
            case 378:
                r3 = ldr(r4 + 4);
                r3 = adds(r3, 1);
                str(r4 + 4, r3);
                b(null, 354);
                return;
            case 386:
                cmp(r5, 0);
                if (beq(null, 202)) return;
            case 390:
                r3 = movs(r3, 3);
                strb(r5 + r2, r3);
                b(null, 202);
                return;
            case 396:
                cmp(r1, 0);
                if (beq(null, 292)) return;
            case 400:
                r0 = ldr(r4);
                r1 = adds(r0, 1);
                str(r4, r1);
                cmp(r5, 0);
                if (beq(null, 414)) return;
            case 410:
                r1 = ldrb(r6);
                strb(r5 + r0, r1);
            case 414:
                r1 = ldrb(r6 + 1);
                cmp(r1, 45);
                if (bne(null, 428)) return;
            case 420:
                r1 = ldrb(r6 + 2);
                cmp(r1, 93);
                if (beq(null, 428)) return;
            case 426:
                r6 = adds(r6, 2);
            case 428:
                r0 = ldr(r4);
                r1 = adds(r0, 1);
                str(r4, r1);
                cmp(r5, 0);
                if (beq(null, 442)) return;
            case 438:
                r1 = ldrb(r6);
                strb(r5 + r0, r1);
            case 442:
                r6 = adds(r6, 1);
                r3 = adds(r3, 1);
                b(null, 218);
                return;
            case 448:
                r3 = ldrb(r6 + 1);
                r7 = movs(r7, r2);
                cmp(r3, 63);
                if (bne(null, 526)) return;
            case 456:
                r3 = ldrb(r6 + 2);
                cmp(r3, 58);
                if (bne(null, 526)) return;
            case 462:
                r3 = movs(r3, 0);
                r6 = adds(r6, 2);
                str(sp + 16, r3);
                str(sp + 12, r3);
            case 470:
                r0 = adds(r6, 1);
                r2 = ldr(sp + 20);
                r1 = movs(r1, r4);
                lr = _compilecode + 480 | 1;
                bl(null, 0, 480);
                return;
            case 480:
                r6 = subs(r0, 0);
                if (beq(null, 292)) return;
            case 484:
                r3 = ldrb(r0);
                cmp(r3, 41);
                if (bne(null, 292)) return;
            case 490:
                r3 = ldr(sp + 16);
                cmp(r3, 0);
                if (beq(null, 354)) return;
            case 496:
                r3 = ldr(r4);
                cmp(r5, 0);
                if (beq(null, 576)) return;
            case 502:
                r2 = adds(r3, 1);
                str(r4, r2);
                r2 = movs(r2, 126);
                strb(r5 + r3, r2);
                r2 = ldr(r4);
                r3 = adds(r2, 1);
                str(r4, r3);
                r3 = ldr(sp + 12);
                r3 = lsls(r3, 1);
                r3 = adds(r3, 1);
                strb(r5 + r2, r3);
                b(null, 378);
                return;
            case 526:
                r3 = ldr(r4 + 8);
                r3 = adds(r3, 1);
                str(sp + 12, r3);
                str(r4 + 8, r3);
                cmp(r5, 0);
                if (beq(null, 570)) return;
            case 538:
                r3 = adds(r2, 1);
                str(r4, r3);
                r3 = movs(r3, 126);
                strb(r5 + r2, r3);
                r3 = ldr(r4);
                r2 = adds(r3, 1);
                str(r4, r2);
                r2 = ldr(sp + 12);
                r2 = lsls(r2, 1);
                strb(r5 + r3, r2);
            case 558:
                r3 = ldr(r4 + 4);
                r3 = adds(r3, 1);
                str(r4 + 4, r3);
                r3 = movs(r3, 1);
                str(sp + 16, r3);
                b(null, 470);
                return;
            case 570:
                r2 = adds(r2, 2);
                str(r4, r2);
                b(null, 558);
                return;
            case 576:
                r3 = adds(r3, 2);
                str(r4, r3);
                b(null, 378);
                return;
            case 582:
                cmp(r2, r7);
                if (bne(null, 588)) return;
            case 586:
                b(null, 292);
                return;
            case 588:
                cmp(r5, 0);
                if (beq(null, 604)) return;
            case 592:
                r0 = adds(r7, 2);
                r2 = subs(r2, r7);
                r1 = adds(r5, r7);
                r0 = adds(r5, r0);
                lr = _compilecode + 604 | 1;
                bl(this::memmove, 604);
                return;
            case 604:
                r3 = ldr(r4);
                r3 = adds(r3, 2);
                str(r4, r3);
                r3 = ldrb(r6 + 1);
                cmp(r3, 63);
                if (bne(null, 636)) return;
            case 616:
                cmp(r5, 0);
                if (beq(null, 624)) return;
            case 620:
                r3 = adds(r3, 35);
                strb(r5 + r7, r3);
            case 624:
                r6 = adds(r6, 1);
                cmp(r5, 0);
                if (bne(null, 644)) return;
            case 630:
                r3 = ldr(r4 + 4);
                r3 = adds(r3, 1);
                b(null, 732);
                return;
            case 636:
                cmp(r5, 0);
                if (beq(null, 630)) return;
            case 640:
                r3 = movs(r3, 97);
                strb(r5 + r7, r3);
            case 644:
                r3 = ldr(r4);
                r2 = adds(r5, r7);
                r3 = subs(r3, 2);
                r3 = subs(r3, r7);
                strb(r2 + 1, r3);
                b(null, 630);
                return;
            case 656:
                cmp(r2, r7);
                if (bne(null, 662)) return;
            case 660:
                b(null, 292);
                return;
            case 662:
                cmp(r5, 0);
                if (beq(null, 678)) return;
            case 666:
                r0 = adds(r7, 2);
                r2 = subs(r2, r7);
                r1 = adds(r5, r7);
                r0 = adds(r5, r0);
                lr = _compilecode + 678 | 1;
                bl(this::memmove, 678);
                return;
            case 678:
                r3 = ldr(r4);
                r3 = adds(r3, 2);
                str(r4, r3);
                cmp(r5, 0);
                if (beq(null, 702)) return;
            case 688:
                r2 = movs(r2, 96);
                strb(r5 + r3, r2);
                r3 = ldr(r4);
                r2 = adds(r5, r3);
                r3 = subs(r7, r3);
                r3 = subs(r3, 2);
                strb(r2 + 1, r3);
            case 702:
                r3 = ldr(r4);
                r3 = adds(r3, 2);
                str(r4, r3);
                r3 = ldrb(r6 + 1);
                cmp(r3, 63);
                if (bne(null, 738)) return;
            case 714:
                cmp(r5, 0);
                if (beq(null, 722)) return;
            case 718:
                r3 = adds(r3, 35);
                strb(r5 + r7, r3);
            case 722:
                r6 = adds(r6, 1);
                cmp(r5, 0);
                if (bne(null, 746)) return;
            case 728:
                r3 = ldr(r4 + 4);
                r3 = adds(r3, 2);
            case 732:
                str(r4 + 4, r3);
                r7 = ldr(r4);
                b(null, 354);
                return;
            case 738:
                cmp(r5, 0);
                if (beq(null, 728)) return;
            case 742:
                r3 = movs(r3, 97);
                strb(r5 + r7, r3);
            case 746:
                r3 = ldr(r4);
                r2 = adds(r5, r7);
                r3 = subs(r3, 2);
                r3 = subs(r3, r7);
            case 754:
                strb(r2 + 1, r3);
                b(null, 728);
                return;
            case 758:
                cmp(r5, 0);
                if (bne(null, 764)) return;
            case 762:
                b(null, 152);
                return;
            case 764:
                r3 = movs(r3, 98);
                strb(r5 + r2, r3);
            case 768:
                r3 = ldr(r4);
                r2 = adds(r5, r3);
                r3 = subs(r7, r3);
                r3 = subs(r3, 2);
                strb(r2 + 1, r3);
                b(null, 152);
                return;
            case 780:
                cmp(r5, 0);
                if (beq(null, 786)) return;
            case 784:
                b(null, 264);
                return;
            case 786:
                r3 = ldr(r4);
                r2 = adds(r3, 2);
                r3 = adds(r3, 3);
                str(r4, r2);
                str(r4, r3);
                cmp(r5, 0);
                if (beq(null, 804)) return;
            case 800:
                r3 = movs(r3, 96);
                strb(r5 + r2, r3);
            case 804:
                r3 = ldr(r4);
                str(sp + 4, r3);
                r3 = adds(r3, 1);
                str(r4, r3);
                cmp(r5, 0);
                if (beq(null, 728)) return;
            case 816:
                r3 = movs(r3, 97);
                r2 = ldr(sp + 8);
                r1 = ldr(sp + 8);
                strb(r5 + r2, r3);
                r3 = ldr(r4);
                r2 = adds(r5, r2);
                r3 = subs(r3, 2);
                r3 = subs(r3, r1);
                b(null, 754);
                return;
            case 834:
                r3 = adds(r2, 1);
                str(r4, r3);
                r3 = movs(r3, 80);
                cmp(r5, 0);
                if (beq(null, 630)) return;
            case 844:
                strb(r5 + r2, r3);
                b(null, 630);
                return;
            case 848:
                r3 = adds(r2, 1);
                str(r4, r3);
                cmp(r5, 0);
                if (beq(null, 630)) return;
            case 856:
                r3 = movs(r3, 81);
                b(null, 844);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134314236, size=72, name='match_group', path='build/extmod/modure.o', has_indirect=False)
    protected void match_group(int offset) throws Exception
    {
        pc = match_group + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r5 = movs(r5, r0);
                r0 = movs(r0, r1);
                r4 = movs(r4, r1);
                lr = match_group + 12 | 1;
                bl(this::mp_obj_get_int, 12);
                return;
            case 12:
                cmp(r0, 0);
                if (blt(null, 22)) return;
            case 16:
                r3 = ldr(r5 + 4);
                cmp(r3, r0);
                if (bgt(null, 34)) return;
            case 22:
                r1 = movs(r1, r4);
                r0 = mp_type_IndexError;
                lr = match_group + 30 | 1;
                bl(this::mp_obj_new_exception_arg1, 30);
                return;
            case 30:
                lr = match_group + 34 | 1;
                bl(this::nlr_jump, 34);
                return;
            case 34:
                r0 = lsls(r0, 3);
                r4 = adds(r5, r0);
                r6 = ldr(r4 + 12);
                r0 = mp_const_none_obj;
                cmp(r6, 0);
                if (beq(null, 62)) return;
            case 46:
                r0 = ldr(r5 + 8);
                lr = match_group + 52 | 1;
                bl(this::mp_obj_get_type, 52);
                return;
            case 52:
                r2 = ldr(r4 + 16);
                r1 = movs(r1, r6);
                r2 = subs(r2, r6);
                lr = match_group + 62 | 1;
                bl(this::mp_obj_new_str_of_type, 62);
                return;
            case 62:
                pop(true, R4, R5, R6);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134314308, size=44, name='re1_5_sizecode', path='build/extmod/modure.o', has_indirect=False)
    protected void re1_5_sizecode(int offset) throws Exception
    {
        pc = re1_5_sizecode + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r3, r4);
                r4 = movs(r4, r0);
                r2 = movs(r2, 8);
                r1 = movs(r1, 0);
                r0 = add(sp, 8);
                lr = re1_5_sizecode + 14 | 1;
                bl(this::memset, 14);
                return;
            case 14:
                r3 = movs(r3, 10);
                r2 = movs(r2, 1);
                r1 = add(sp, 4);
                r0 = movs(r0, r4);
                str(sp + 4, r3);
                lr = re1_5_sizecode + 28 | 1;
                bl(this::_compilecode, 28);
                return;
            case 28:
                cmp(r0, 0);
                if (beq(null, 38)) return;
            case 32:
                r0 = ldr(sp + 4);
            case 34:
                sp = add(sp, 16);
                pop(true, R4);
                return;
            case 38:
                r0 = movs(r0, 1);
                r0 = rsbs(r0, 0);
                b(null, 34);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134314352, size=84, name='re1_5_compilecode', path='build/extmod/modure.o', has_indirect=False)
    protected void re1_5_compilecode(int offset) throws Exception
    {
        pc = re1_5_compilecode + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r3 = movs(r3, 7);
                r4 = movs(r4, r0);
                r2 = movs(r2, 0);
                str(r4, r3);
                r3 = subs(r3, 3);
                str(r4 + 4, r3);
                r3 = 0x60020362;
                r0 = movs(r0, r1);
                str(r4 + 12, r3);
                r3 = 0x00007efb;
                str(r4 + 8, r2);
                strh(r4 + 16, r3);
                strb(r4 + 18, r2);
                r1 = movs(r1, r4);
                lr = re1_5_compilecode + 34 | 1;
                bl(this::_compilecode, 34);
                return;
            case 34:
                r3 = movs(r3, 1);
                cmp(r0, 0);
                if (beq(null, 72)) return;
            case 40:
                r0 = ldrb(r0);
                cmp(r0, 0);
                if (bne(null, 72)) return;
            case 46:
                r5 = movs(r5, 126);
                r2 = ldr(r4);
                r1 = adds(r4, r2);
                r2 = adds(r2, 3);
                strb(r1 + 12, r5);
                strb(r1 + 13, r3);
                str(r4, r2);
                r2 = movs(r2, 127);
                r3 = ldr(r4 + 4);
                strb(r1 + 14, r2);
                r3 = adds(r3, 2);
                str(r4 + 4, r3);
                r3 = movs(r3, r0);
            case 72:
                r0 = movs(r0, r3);
                pop(true, R4, R5, R6);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134314436, size=312, name='re1_5_dumpcode', path='build/extmod/modure.o', has_indirect=False)
    protected void re1_5_dumpcode(int offset) throws Exception
    {
        pc = re1_5_dumpcode + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r6 = movs(r6, r0);
                r7 = movs(r7, r0);
                r5 = movs(r5, 0);
                sp = sub(sp, 20);
                r6 = adds(r6, 12);
            case 12:
                r1 = ldr(r7);
                cmp(r1, r5);
                if (bgt(null, 30)) return;
            case 18:
                r2 = ldr(r7 + 4);
                r0 = 0x08026b98;
                lr = re1_5_dumpcode + 26 | 1;
                bl(this::printf, 26);
                return;
            case 26:
                sp = add(sp, 20);
                pop(true, R4, R5, R6, R7);
                return;
            case 30:
                r1 = movs(r1, r5);
                r0 = re1_5_dumpcode_str1_1;
                lr = re1_5_dumpcode + 38 | 1;
                bl(this::printf, 38);
                return;
            case 38:
                r3 = adds(r6, r5);
                str(sp + 8, r3);
                r3 = ldrb(r3);
                r4 = adds(r5, 1);
                cmp(r3, 80);
                if (beq(null, 240)) return;
            case 50:
                if (bhi(null, 100)) return;
            case 52:
                cmp(r3, 4);
                if (bhi(null, 88)) return;
            case 56:
                cmp(r3, 3);
                if (bhs(null, 164)) return;
            case 60:
                cmp(r3, 1);
                if (beq(null, 150)) return;
            case 64:
                r0 = 0x08020c21;
                cmp(r3, 2);
                if (beq(null, 134)) return;
            case 70:
                r2 = ldrsb(r6 + r4);
                r0 = 0x08026b2b;
                r1 = adds(r2, r4);
                r1 = adds(r1, 1);
            case 78:
                lr = re1_5_dumpcode + 82 | 1;
                bl(this::printf, 82);
                return;
            case 82:
                r4 = adds(r5, 2);
            case 84:
                r5 = movs(r5, r4);
                b(null, 12);
                return;
            case 88:
                cmp(r3, 5);
                if (bne(null, 70)) return;
            case 92:
                r5 = adds(r5, 2);
                r1 = ldrb(r6 + r4);
                r0 = 0x08026b6a;
                b(null, 156);
                return;
            case 100:
                cmp(r3, 98);
                if (beq(null, 140)) return;
            case 104:
                if (bhi(null, 124)) return;
            case 106:
                cmp(r3, 81);
                if (beq(null, 244)) return;
            case 110:
                cmp(r3, 96);
                if (bne(null, 70)) return;
            case 114:
                r2 = ldrsb(r6 + r4);
                r0 = 0x08026b3a;
                r1 = adds(r2, r4);
                r1 = adds(r1, 1);
                b(null, 78);
                return;
            case 124:
                cmp(r3, 126);
                if (beq(null, 232)) return;
            case 128:
                r0 = 0x08021349;
                cmp(r3, 127);
                if (bne(null, 70)) return;
            case 134:
                lr = re1_5_dumpcode + 138 | 1;
                bl(this::puts, 138);
                return;
            case 138:
                b(null, 84);
                return;
            case 140:
                r2 = ldrsb(r6 + r4);
                r0 = 0x08026b2a;
                r1 = adds(r2, r4);
                r1 = adds(r1, 1);
                b(null, 78);
                return;
            case 150:
                r1 = ldrb(r6 + r4);
                r0 = 0x08026b47;
                r5 = adds(r5, 2);
            case 156:
                lr = re1_5_dumpcode + 160 | 1;
                bl(this::printf, 160);
                return;
            case 160:
                r4 = movs(r4, r5);
                b(null, 84);
                return;
            case 164:
                r3 = ldrb(r6 + r4);
                r4 = adds(r6, r4);
                r4 = subs(r4, 1);
                str(sp + 4, r3);
                r3 = ldrb(r4);
                r1 = 0x08021bde;
                cmp(r3, 4);
                if (beq(null, 182)) return;
            case 180:
                r1 = 0x0802b305;
            case 182:
                r2 = ldr(sp + 4);
                r0 = 0x08026b50;
                lr = re1_5_dumpcode + 190 | 1;
                bl(this::printf, 190);
                return;
            case 190:
                r3 = adds(r5, 2);
                r4 = ldr(sp + 8);
                r5 = ldr(sp + 4);
                str(sp + 12, r3);
            case 198:
                r4 = adds(r4, 2);
                r5 = subs(r5, 1);
                if (bhs(null, 220)) return;
            case 204:
                r3 = ldr(sp + 4);
                r0 = movs(r0, 10);
                r4 = lsls(r3, 1);
                r3 = ldr(sp + 12);
                r4 = adds(r4, r3);
                lr = re1_5_dumpcode + 218 | 1;
                bl(this::putchar, 218);
                return;
            case 218:
                b(null, 84);
                return;
            case 220:
                r2 = ldrb(r4 + 1);
                r1 = ldrb(r4);
                r0 = 0x08026b5b;
                lr = re1_5_dumpcode + 230 | 1;
                bl(this::printf, 230);
                return;
            case 230:
                b(null, 198);
                return;
            case 232:
                r5 = adds(r5, 2);
                r1 = ldrb(r6 + r4);
                r0 = 0x08026b79;
                b(null, 156);
                return;
            case 240:
                r0 = 0x08026b82;
                b(null, 134);
                return;
            case 244:
                r0 = 0x08026b8d;
                b(null, 134);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134314748, size=92, name='mod_re_compile', path='build/extmod/modure.o', has_indirect=False)
    protected void mod_re_compile(int offset) throws Exception
    {
        pc = mod_re_compile + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r4, r5, r6, r7);
                str(sp + 4, r0);
                r0 = ldr(r1);
                r7 = movs(r7, r1);
                lr = mod_re_compile + 12 | 1;
                bl(this::mp_obj_str_get_str, 12);
                return;
            case 12:
                r6 = movs(r6, r0);
                lr = mod_re_compile + 18 | 1;
                bl(this::re1_5_sizecode, 18);
                return;
            case 18:
                r3 = adds(r0, 1);
                if (bne(null, 28)) return;
            case 22:
                r0 = mod_re_compile_str1_1;
                lr = mod_re_compile + 28 | 1;
                bl(this::mp_raise_ValueError, 28);
                return;
            case 28:
                r0 = adds(r0, 16);
                lr = mod_re_compile + 34 | 1;
                bl(this::m_malloc, 34);
                return;
            case 34:
                r3 = re_type;
                r4 = movs(r4, r0);
                str(r0, r3);
                r3 = ldr(sp + 4);
                r5 = movs(r5, 0);
                cmp(r3, 1);
                if (bls(null, 56)) return;
            case 48:
                r0 = ldr(r7 + 4);
                lr = mod_re_compile + 54 | 1;
                bl(this::mp_obj_get_int, 54);
                return;
            case 54:
                r5 = movs(r5, r0);
            case 56:
                r7 = adds(r4, 4);
                r1 = movs(r1, r6);
                r0 = movs(r0, r7);
                lr = mod_re_compile + 66 | 1;
                bl(this::re1_5_compilecode, 66);
                return;
            case 66:
                cmp(r0, 0);
                if (bne(null, 22)) return;
            case 70:
                r3 = lsls(r5, 19);
                if (bpl(null, 80)) return;
            case 74:
                r0 = movs(r0, r7);
                lr = mod_re_compile + 80 | 1;
                bl(this::re1_5_dumpcode, 80);
                return;
            case 80:
                r0 = movs(r0, r4);
                pop(true, R1, R2, R3, R4, R5, R6, R7);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134314840, size=52, name='_re1_5_classmatch', path='build/extmod/modure.o', has_indirect=False)
    protected void _re1_5_classmatch(int offset) throws Exception
    {
        pc = _re1_5_classmatch + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5);
                r3 = subs(r0, 1);
                r2 = adds(r0, 1);
                r3 = ldrb(r3);
                r0 = ldrb(r0);
            case 10:
                cmp(r0, 0);
                if (bne(null, 24)) return;
            case 14:
                r3 = subs(r3, 3);
                r0 = movs(r0, r3);
                r3 = subs(r0, 1);
                r0 = sbcs(r0, r3);
                b(null, 44);
                return;
            case 24:
                r4 = ldrb(r1);
                r5 = ldrb(r2);
                cmp(r5, r4);
                if (bhi(null, 46)) return;
            case 32:
                r5 = ldrb(r2 + 1);
                cmp(r5, r4);
                if (blo(null, 46)) return;
            case 38:
                r3 = subs(r3, 3);
                r0 = rsbs(r3, 0);
                r0 = adcs(r0, r3);
            case 44:
                pop(true, R4, R5);
                return;
            case 46:
                r2 = adds(r2, 2);
                r0 = subs(r0, 1);
                b(null, 10);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134314892, size=74, name='_re1_5_namedclassmatch', path='build/extmod/modure.o', has_indirect=False)
    protected void _re1_5_namedclassmatch(int offset) throws Exception
    {
        pc = _re1_5_namedclassmatch + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r2 = ldrb(r0);
                r4 = movs(r4, 1);
                r5 = lsrs(r2, 5);
                r0 = movs(r0, r5);
                r6 = movs(r6, 32);
                r0 = ands(r0, r4);
                r2 = orrs(r2, r6);
                r3 = ldrb(r1);
                cmp(r2, 100);
                if (bne(null, 34)) return;
            case 22:
                r3 = subs(r3, 48);
                cmp(r3, 9);
                if (bls(null, 48)) return;
            case 28:
                r0 = movs(r0, r4);
                r0 = bics(r0, r5);
                b(null, 48);
                return;
            case 34:
                cmp(r2, 115);
                if (bne(null, 50)) return;
            case 38:
                cmp(r3, 32);
                if (beq(null, 48)) return;
            case 42:
                r3 = subs(r3, 9);
                cmp(r3, 4);
                if (bhi(null, 28)) return;
            case 48:
                pop(true, R4, R5, R6);
                return;
            case 50:
                r2 = movs(r2, r3);
                r2 = bics(r2, r6);
                r2 = subs(r2, 65);
                cmp(r2, 25);
                if (bls(null, 48)) return;
            case 60:
                r2 = movs(r2, r3);
                r2 = subs(r2, 48);
                cmp(r2, 9);
                if (bls(null, 48)) return;
            case 68:
                cmp(r3, 95);
                if (bne(null, 28)) return;
            case 72:
                b(null, 48);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134314966, size=280, name='recursiveloop', path='build/extmod/modure.o', has_indirect=False)
    protected void recursiveloop(int offset) throws Exception
    {
        pc = recursiveloop + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                sp = sub(sp, 20);
                r6 = movs(r6, r0);
                r5 = movs(r5, r1);
                r7 = movs(r7, r2);
                str(sp + 8, r3);
                lr = recursiveloop + 16 | 1;
                bl(this::mp_stack_check, 16);
                return;
            case 16:
                r3 = ldrb(r6);
                cmp(r3, 79);
                if (bhi(null, 30)) return;
            case 22:
                r2 = ldr(r7 + 4);
                cmp(r2, r5);
                if (bhi(null, 30)) return;
            case 28:
                b(null, 272);
                return;
            case 30:
                r4 = adds(r6, 1);
                cmp(r3, 80);
                if (bne(null, 38)) return;
            case 36:
                b(null, 264);
                return;
            case 38:
                if (bhi(null, 80)) return;
            case 40:
                cmp(r3, 4);
                if (bhi(null, 60)) return;
            case 44:
                cmp(r3, 3);
                if (bhs(null, 156)) return;
            case 48:
                cmp(r3, 1);
                if (beq(null, 144)) return;
            case 52:
                cmp(r3, 2);
                if (beq(null, 176)) return;
            case 56:
                r6 = movs(r6, r4);
                b(null, 16);
                return;
            case 60:
                cmp(r3, 5);
                if (bne(null, 56)) return;
            case 64:
                r1 = movs(r1, r5);
                r0 = movs(r0, r4);
                lr = recursiveloop + 72 | 1;
                bl(this::_re1_5_namedclassmatch, 72);
                return;
            case 72:
                cmp(r0, 0);
                if (bne(null, 152)) return;
            case 76:
                sp = add(sp, 20);
                pop(true, R4, R5, R6, R7);
                return;
            case 80:
                cmp(r3, 97);
                if (beq(null, 180)) return;
            case 84:
                if (bhi(null, 104)) return;
            case 86:
                cmp(r3, 81);
                if (beq(null, 276)) return;
            case 90:
                cmp(r3, 96);
                if (bne(null, 56)) return;
            case 94:
                r3 = movs(r3, 1);
                r3 = ldrsb(r6 + r3);
                r4 = adds(r6, 2);
            case 100:
                r4 = adds(r3, r4);
                b(null, 56);
                return;
            case 104:
                cmp(r3, 126);
                if (beq(null, 216)) return;
            case 108:
                cmp(r3, 127);
                if (beq(null, 206)) return;
            case 112:
                cmp(r3, 98);
                if (bne(null, 56)) return;
            case 116:
                r0 = movs(r0, 1);
                r3 = ldr(sp + 40);
                r0 = ldrsb(r6 + r0);
                r4 = adds(r6, 2);
                str(sp, r3);
                r0 = adds(r4, r0);
                r3 = ldr(sp + 8);
                r2 = movs(r2, r7);
                r1 = movs(r1, r5);
                lr = recursiveloop + 138 | 1;
                bl(null, 0, 138);
                return;
            case 138:
                cmp(r0, 0);
                if (bne(null, 206)) return;
            case 142:
                b(null, 56);
                return;
            case 144:
                r2 = ldrb(r5);
                r3 = ldrb(r6 + 1);
                cmp(r2, r3);
                if (bne(null, 272)) return;
            case 152:
                r4 = adds(r6, 2);
                b(null, 176);
                return;
            case 156:
                r1 = movs(r1, r5);
                r0 = movs(r0, r4);
                lr = recursiveloop + 164 | 1;
                bl(this::_re1_5_classmatch, 164);
                return;
            case 164:
                cmp(r0, 0);
                if (beq(null, 76)) return;
            case 168:
                r3 = ldrb(r6 + 1);
                r3 = lsls(r3, 1);
                r3 = adds(r3, 1);
                r4 = adds(r4, r3);
            case 176:
                r5 = adds(r5, 1);
                b(null, 56);
                return;
            case 180:
                r3 = adds(r6, 2);
                str(sp + 12, r3);
                r3 = ldr(sp + 40);
                r4 = ldrb(r6 + 1);
                r2 = movs(r2, r7);
                str(sp, r3);
                r1 = movs(r1, r5);
                r3 = ldr(sp + 8);
                r0 = ldr(sp + 12);
                lr = recursiveloop + 202 | 1;
                bl(null, 0, 202);
                return;
            case 202:
                cmp(r0, 0);
                if (beq(null, 210)) return;
            case 206:
                r0 = movs(r0, 1);
                b(null, 76);
                return;
            case 210:
                r4 = sxtb(r4);
                r3 = ldr(sp + 12);
                b(null, 100);
                return;
            case 216:
                r4 = adds(r6, 2);
                r3 = ldr(sp + 40);
                r6 = ldrb(r6 + 1);
                cmp(r6, r3);
                if (bge(null, 56)) return;
            case 226:
                r3 = ldr(sp + 8);
                r6 = lsls(r6, 2);
                r6 = adds(r3, r6);
                r3 = ldr(r6);
                r2 = movs(r2, r7);
                str(sp + 12, r3);
                r3 = ldr(sp + 40);
                str(r6, r5);
                r1 = movs(r1, r5);
                str(sp, r3);
                r0 = movs(r0, r4);
                r3 = ldr(sp + 8);
                lr = recursiveloop + 254 | 1;
                bl(null, 0, 254);
                return;
            case 254:
                cmp(r0, 0);
                if (bne(null, 206)) return;
            case 258:
                r3 = ldr(sp + 12);
                str(r6, r3);
                b(null, 76);
                return;
            case 264:
                r3 = ldr(r7);
            case 266:
                cmp(r3, r5);
                if (bne(null, 272)) return;
            case 270:
                b(null, 56);
                return;
            case 272:
                r0 = movs(r0, 0);
                b(null, 76);
                return;
            case 276:
                r3 = ldr(r7 + 4);
                b(null, 266);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134315246, size=26, name='re1_5_recursiveloopprog', path='build/extmod/modure.o', has_indirect=False)
    protected void re1_5_recursiveloopprog(int offset) throws Exception
    {
        pc = re1_5_recursiveloopprog + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r4, r5);
                r5 = ldr(sp + 24);
                r0 = adds(r0, 12);
                cmp(r5, 0);
                if (beq(null, 12)) return;
            case 10:
                r0 = adds(r0, 5);
            case 12:
                str(sp, r3);
                r3 = movs(r3, r2);
                r2 = movs(r2, r1);
                r1 = ldr(r1);
                lr = re1_5_recursiveloopprog + 24 | 1;
                bl(this::recursiveloop, 24);
                return;
            case 24:
                pop(true, R1, R2, R3, R4, R5);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134315272, size=120, name='ure_exec_isra_2', path='build/extmod/modure.o', has_indirect=False)
    protected void ure_exec_isra_2(int offset) throws Exception
    {
        pc = ure_exec_isra_2 + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r6 = movs(r6, r1);
                sp = sub(sp, 44);
                r5 = ldr(r1);
                str(sp + 20, r0);
                r1 = add(sp, 28);
                r0 = ldr(r6 + 4);
                lr = ure_exec_isra_2 + 18 | 1;
                bl(this::mp_obj_str_get_data, 18);
                return;
            case 18:
                r3 = ldr(sp + 28);
                str(sp + 32, r0);
                r0 = adds(r0, r3);
                r3 = ldr(r5 + 12);
                str(sp + 36, r0);
                r7 = adds(r3, 1);
                r3 = lsls(r7, 1);
                r3 = adds(r3, 3);
                r3 = lsls(r3, 2);
                r0 = movs(r0, r3);
                str(sp + 12, r3);
                lr = ure_exec_isra_2 + 44 | 1;
                bl(this::m_malloc, 44);
                return;
            case 44:
                r3 = movs(r3, r0);
                r3 = adds(r3, 12);
                r2 = lsls(r7, 3);
                r1 = movs(r1, 0);
                r4 = movs(r4, r0);
                r0 = movs(r0, r3);
                str(sp + 16, r3);
                lr = ure_exec_isra_2 + 62 | 1;
                bl(this::memset, 62);
                return;
            case 62:
                r3 = ldr(sp + 20);
                r0 = adds(r5, 4);
                str(sp, r3);
                r2 = ldr(sp + 16);
                r3 = lsls(r7, 1);
                r1 = add(sp, 32);
                lr = ure_exec_isra_2 + 78 | 1;
                bl(this::re1_5_recursiveloopprog, 78);
                return;
            case 78:
                cmp(r0, 0);
                if (bne(null, 98)) return;
            case 82:
                r0 = movs(r0, r4);
                r1 = ldr(sp + 12);
                lr = ure_exec_isra_2 + 90 | 1;
                bl(this::m_free, 90);
                return;
            case 90:
                r4 = mp_const_none_obj;
            case 92:
                r0 = movs(r0, r4);
                sp = add(sp, 44);
                pop(true, R4, R5, R6, R7);
                return;
            case 98:
                r3 = match_type;
                str(r4 + 4, r7);
                str(r4, r3);
                r3 = ldr(r6 + 4);
                str(r4 + 8, r3);
                b(null, 92);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134315392, size=10, name='re_match', path='build/extmod/modure.o', has_indirect=False)
    protected void re_match(int offset) throws Exception
    {
        pc = re_match + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r0 = movs(r0, 1);
                lr = re_match + 8 | 1;
                bl(this::ure_exec_isra_2, 8);
                return;
            case 8:
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134315402, size=10, name='re_search', path='build/extmod/modure.o', has_indirect=False)
    protected void re_search(int offset) throws Exception
    {
        pc = re_search + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r0 = movs(r0, 0);
                lr = re_search + 8 | 1;
                bl(this::ure_exec_isra_2, 8);
                return;
            case 8:
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134315412, size=30, name='mod_re_match', path='build/extmod/modure.o', has_indirect=False)
    protected void mod_re_match(int offset) throws Exception
    {
        pc = mod_re_match + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r3, r4);
                r4 = movs(r4, r1);
                r0 = movs(r0, 1);
                lr = mod_re_match + 10 | 1;
                bl(this::mod_re_compile, 10);
                return;
            case 10:
                r3 = ldr(r4 + 4);
                str(sp + 8, r0);
                r1 = add(sp, 8);
                r0 = movs(r0, 1);
                str(sp + 4, r3);
                str(sp + 12, r3);
                lr = mod_re_match + 26 | 1;
                bl(this::ure_exec_isra_2, 26);
                return;
            case 26:
                sp = add(sp, 16);
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134315442, size=30, name='mod_re_search', path='build/extmod/modure.o', has_indirect=False)
    protected void mod_re_search(int offset) throws Exception
    {
        pc = mod_re_search + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r3, r4);
                r4 = movs(r4, r1);
                r0 = movs(r0, 1);
                lr = mod_re_search + 10 | 1;
                bl(this::mod_re_compile, 10);
                return;
            case 10:
                r3 = ldr(r4 + 4);
                str(sp + 8, r0);
                r1 = add(sp, 8);
                r0 = movs(r0, 0);
                str(sp + 4, r3);
                str(sp + 12, r3);
                lr = mod_re_search + 26 | 1;
                bl(this::ure_exec_isra_2, 26);
                return;
            case 26:
                sp = add(sp, 16);
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134315472, size=204, name='re_split', path='build/extmod/modure.o', has_indirect=False)
    protected void re_split(int offset) throws Exception
    {
        pc = re_split + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r7 = movs(r7, r0);
                sp = sub(sp, 44);
                r0 = ldr(r1 + 4);
                r4 = movs(r4, r1);
                r6 = ldr(r1);
                lr = re_split + 16 | 1;
                bl(this::mp_obj_get_type, 16);
                return;
            case 16:
                r1 = add(sp, 28);
                str(sp + 16, r0);
                r0 = ldr(r4 + 4);
                lr = re_split + 26 | 1;
                bl(this::mp_obj_str_get_data, 26);
                return;
            case 26:
                r3 = ldr(sp + 28);
                str(sp + 32, r0);
                r0 = adds(r0, r3);
                r3 = ldr(r6 + 12);
                str(sp + 36, r0);
                r3 = adds(r3, 1);
                r3 = lsls(r3, 1);
                str(sp + 20, r3);
                r5 = movs(r5, 0);
                cmp(r7, 2);
                if (bls(null, 56)) return;
            case 48:
                r0 = ldr(r4 + 8);
                lr = re_split + 54 | 1;
                bl(this::mp_obj_get_int, 54);
                return;
            case 54:
                r5 = movs(r5, r0);
            case 56:
                r1 = movs(r1, 0);
                r0 = movs(r0, r1);
                lr = re_split + 64 | 1;
                bl(this::mp_obj_new_list, 64);
                return;
            case 64:
                r3 = ldr(sp + 20);
                r7 = movs(r7, r0);
                r3 = lsls(r3, 2);
                r0 = movs(r0, r3);
                str(sp + 12, r3);
                lr = re_split + 78 | 1;
                bl(this::mp_pystack_alloc, 78);
                return;
            case 78:
                r4 = movs(r4, r0);
            case 80:
                r2 = ldr(sp + 12);
                r1 = movs(r1, 0);
                r0 = movs(r0, r4);
                lr = re_split + 90 | 1;
                bl(this::memset, 90);
                return;
            case 90:
                r3 = movs(r3, 0);
                r0 = adds(r6, 4);
                str(sp, r3);
                r2 = movs(r2, r4);
                r3 = ldr(sp + 20);
                r1 = add(sp, 32);
                lr = re_split + 106 | 1;
                bl(this::re1_5_recursiveloopprog, 106);
                return;
            case 106:
                cmp(r0, 0);
                if (beq(null, 162)) return;
            case 110:
                r2 = ldr(r4);
                r3 = ldr(r4 + 4);
                r1 = ldr(sp + 32);
                cmp(r2, r3);
                if (beq(null, 162)) return;
            case 120:
                r2 = subs(r2, r1);
                r0 = ldr(sp + 16);
                lr = re_split + 128 | 1;
                bl(this::mp_obj_new_str_of_type, 128);
                return;
            case 128:
                r1 = movs(r1, r0);
                r0 = movs(r0, r7);
                lr = re_split + 136 | 1;
                bl(this::mp_obj_list_append, 136);
                return;
            case 136:
                r3 = ldr(r6 + 12);
                cmp(r3, 0);
                if (ble(null, 148)) return;
            case 142:
                r0 = re_split_str1_1;
                lr = re_split + 148 | 1;
                bl(this::mp_raise_NotImplementedError, 148);
                return;
            case 148:
                r3 = ldr(r4 + 4);
                str(sp + 32, r3);
                cmp(r5, 0);
                if (ble(null, 80)) return;
            case 156:
                r5 = subs(r5, 1);
                cmp(r5, 0);
                if (bne(null, 80)) return;
            case 162:
                r3 = mp_state_ctx;
                r2 = ldr(sp + 36);
                str(r3 + 16, r4);
                r3 = ldr(sp + 32);
                r0 = ldr(sp + 16);
                r1 = movs(r1, r3);
                r2 = subs(r2, r3);
                lr = re_split + 180 | 1;
                bl(this::mp_obj_new_str_of_type, 180);
                return;
            case 180:
                r1 = movs(r1, r0);
                r0 = movs(r0, r7);
                lr = re_split + 188 | 1;
                bl(this::mp_obj_list_append, 188);
                return;
            case 188:
                r0 = movs(r0, r7);
                sp = add(sp, 44);
                pop(true, R4, R5, R6, R7);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134315676, size=102, name='tinf_build_tree', path='build/extmod/moduzlib.o', has_indirect=False)
    protected void tinf_build_tree(int offset) throws Exception
    {
        pc = tinf_build_tree + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r4 = movs(r4, r0);
                r3 = movs(r3, r0);
                r5 = movs(r5, 0);
                sp = sub(sp, 36);
                r4 = adds(r4, 32);
            case 12:
                strh(r3, r5);
                r3 = adds(r3, 2);
                cmp(r4, r3);
                if (bne(null, 12)) return;
            case 20:
                r4 = movs(r4, r1);
                r6 = adds(r1, r2);
            case 24:
                cmp(r6, r4);
                if (bne(null, 58)) return;
            case 28:
                r3 = movs(r3, 0);
                r4 = movs(r4, r3);
                strh(r0, r3);
            case 34:
                r5 = mov(sp);
                strh(r3 + r5, r4);
                r5 = ldrh(r0 + r3);
                r3 = adds(r3, 2);
                r4 = adds(r4, r5);
                cmp(r3, 32);
                if (bne(null, 34)) return;
            case 48:
                r4 = movs(r4, 0);
            case 50:
                cmp(r4, r2);
                if (bne(null, 74)) return;
            case 54:
                sp = add(sp, 36);
                pop(true, R4, R5, R6, R7);
                return;
            case 58:
                r3 = ldrb(r4);
                r4 = adds(r4, 1);
                r3 = lsls(r3, 1);
                r3 = adds(r0, r3);
                r5 = ldrh(r3);
                r5 = adds(r5, 1);
                strh(r3, r5);
                b(null, 24);
                return;
            case 74:
                r5 = ldrb(r1 + r4);
                cmp(r5, 0);
                if (beq(null, 98)) return;
            case 80:
                r3 = mov(sp);
                r7 = mov(sp);
                r5 = lsls(r5, 1);
                r3 = ldrh(r3 + r5);
                r6 = adds(r3, 1);
                r3 = adds(r3, 16);
                r3 = lsls(r3, 1);
                strh(r7 + r5, r6);
                strh(r3 + r0, r4);
            case 98:
                r4 = adds(r4, 1);
                b(null, 50);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134315780, size=56, name='read_src_stream', path='build/extmod/moduzlib.o', has_indirect=True)
    protected void read_src_stream(int offset) throws Exception
    {
        pc = read_src_stream + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r4, r5);
                r3 = mov(sp);
                r0 = subs(r0, 8);
                r0 = ldr(r0 + 4);
                r4 = adds(r3, 3);
                r3 = ldr(r0);
                r2 = movs(r2, 1);
                r3 = ldr(r3 + 48);
                r1 = movs(r1, r4);
                r5 = ldr(r3);
                r3 = add(sp, 4);
                blx(r5, 24);
                return;
            case 24:
                r3 = adds(r0, 1);
                if (bne(null, 34)) return;
            case 28:
                r0 = ldr(sp + 4);
                lr = read_src_stream + 34 | 1;
                bl(this::mp_raise_OSError, 34);
                return;
            case 34:
                cmp(r0, 0);
                if (bne(null, 48)) return;
            case 38:
                r0 = mp_type_EOFError;
                lr = read_src_stream + 44 | 1;
                bl(this::mp_obj_new_exception, 44);
                return;
            case 44:
                lr = read_src_stream + 48 | 1;
                bl(this::nlr_jump, 48);
                return;
            case 48:
                r0 = ldrb(r4);
                pop(true, R1, R2, R3, R4, R5);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134315836, size=22, name='uzlib_get_byte', path='build/extmod/moduzlib.o', has_indirect=False)
    protected void uzlib_get_byte(int offset) throws Exception
    {
        pc = uzlib_get_byte + offset;
        switch (offset)
        {
            case 0:
                r3 = ldr(r0);
                push(true, r4);
                cmp(r3, 0);
                if (beq(null, 16)) return;
            case 8:
                r2 = adds(r3, 1);
                str(r0, r2);
                r0 = ldrb(r3);
            case 14:
                pop(true, R4);
                return;
            case 16:
                r3 = ldr(r0 + 4);
                blx(r3, 20);
                return;
            case 20:
                b(null, 14);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134315858, size=36, name='tinf_getbit', path='build/extmod/moduzlib.o', has_indirect=False)
    protected void tinf_getbit(int offset) throws Exception
    {
        pc = tinf_getbit + offset;
        switch (offset)
        {
            case 0:
                r3 = ldr(r0 + 12);
                push(true, r4);
                r2 = subs(r3, 1);
                r4 = movs(r4, r0);
                str(r0 + 12, r2);
                cmp(r3, 0);
                if (bne(null, 24)) return;
            case 14:
                lr = tinf_getbit + 18 | 1;
                bl(this::uzlib_get_byte, 18);
                return;
            case 18:
                r3 = movs(r3, 7);
                str(r4 + 8, r0);
                str(r4 + 12, r3);
            case 24:
                r0 = ldr(r4 + 8);
                r3 = lsrs(r0, 1);
                str(r4 + 8, r3);
                r3 = movs(r3, 1);
                r0 = ands(r0, r3);
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134315894, size=44, name='tinf_read_bits', path='build/extmod/moduzlib.o', has_indirect=False)
    protected void tinf_read_bits(int offset) throws Exception
    {
        pc = tinf_read_bits + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r4, r5, r6, r7);
                r5 = movs(r5, 0);
                r7 = movs(r7, r0);
                str(sp + 4, r2);
                cmp(r1, r5);
                if (beq(null, 22)) return;
            case 12:
                r4 = movs(r4, 1);
                r6 = movs(r6, r4);
                r6 = lsls(r6, r1);
            case 18:
                cmp(r4, r6);
                if (blo(null, 28)) return;
            case 22:
                r3 = ldr(sp + 4);
                r0 = adds(r3, r5);
                pop(true, R1, R2, R3, R4, R5, R6, R7);
                return;
            case 28:
                r0 = movs(r0, r7);
                lr = tinf_read_bits + 34 | 1;
                bl(this::tinf_getbit, 34);
                return;
            case 34:
                cmp(r0, 0);
                if (beq(null, 40)) return;
            case 38:
                r5 = adds(r5, r4);
            case 40:
                r4 = lsls(r4, 1);
                b(null, 18);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134315938, size=42, name='tinf_decode_symbol', path='build/extmod/moduzlib.o', has_indirect=False)
    protected void tinf_decode_symbol(int offset) throws Exception
    {
        pc = tinf_decode_symbol + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r4, r5, r6, r7);
                r5 = movs(r5, 0);
                r7 = movs(r7, r1);
                r4 = movs(r4, r5);
                str(sp + 4, r0);
                r6 = adds(r1, 2);
            case 12:
                r0 = ldr(sp + 4);
                lr = tinf_decode_symbol + 18 | 1;
                bl(this::tinf_getbit, 18);
                return;
            case 18:
                r5 = lsls(r5, 1);
                r5 = adds(r5, r0);
                r0 = ldrh(r6);
                r6 = adds(r6, 2);
                r4 = adds(r4, r0);
                r5 = subs(r5, r0);
                if (bpl(null, 12)) return;
            case 32:
                r4 = adds(r4, r5);
                r4 = adds(r4, 16);
                r4 = lsls(r4, 1);
                r0 = ldrh(r4 + r7);
                pop(true, R1, R2, R3, R4, R5, R6, R7);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134315980, size=268, name='tinf_decode_trees', path='build/extmod/moduzlib.o', has_indirect=False)
    protected void tinf_decode_trees(int offset) throws Exception
    {
        pc = tinf_decode_trees + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                sp = sub(sp, 340);
                str(sp + 12, r2);
                r2 = movs(r2, 2);
                r7 = movs(r7, r1);
                r2 = adds(r2, 255);
                r1 = movs(r1, 5);
                r5 = movs(r5, r0);
                lr = tinf_decode_trees + 20 | 1;
                bl(this::tinf_read_bits, 20);
                return;
            case 20:
                r2 = movs(r2, 1);
                str(sp, r0);
                r1 = movs(r1, 5);
                r0 = movs(r0, r5);
                lr = tinf_decode_trees + 32 | 1;
                bl(this::tinf_read_bits, 32);
                return;
            case 32:
                r2 = movs(r2, 4);
                str(sp + 4, r0);
                r1 = movs(r1, r2);
                r0 = movs(r0, r5);
                lr = tinf_decode_trees + 44 | 1;
                bl(this::tinf_read_bits, 44);
                return;
            case 44:
                r3 = movs(r3, 0);
                r6 = movs(r6, r0);
                r2 = movs(r2, r3);
            case 50:
                r1 = add(sp, 16);
                strb(r3 + r1, r2);
                r3 = adds(r3, 1);
                cmp(r3, 19);
                if (bne(null, 50)) return;
            case 60:
                r4 = movs(r4, 0);
            case 62:
                cmp(r4, r6);
                if (bne(null, 118)) return;
            case 66:
                r2 = movs(r2, 19);
                r1 = add(sp, 16);
                r0 = movs(r0, r7);
                lr = tinf_decode_trees + 76 | 1;
                bl(this::tinf_build_tree, 76);
                return;
            case 76:
                r4 = movs(r4, 0);
            case 78:
                r3 = ldr(sp);
                r2 = ldr(sp + 4);
                r3 = adds(r3, r2);
                cmp(r3, r4);
                if (bhi(null, 140)) return;
            case 88:
                r2 = ldr(sp);
                r1 = add(sp, 16);
                r0 = movs(r0, r7);
                lr = tinf_decode_trees + 98 | 1;
                bl(this::tinf_build_tree, 98);
                return;
            case 98:
                r3 = ldr(sp);
                r2 = add(sp, 16);
                r3 = adds(r3, r2);
                r1 = movs(r1, r3);
                r2 = ldr(sp + 4);
                r0 = ldr(sp + 12);
                lr = tinf_decode_trees + 114 | 1;
                bl(this::tinf_build_tree, 114);
                return;
            case 114:
                sp = add(sp, 340);
                pop(true, R4, R5, R6, R7);
                return;
            case 118:
                r2 = movs(r2, 0);
                r1 = movs(r1, 3);
                r0 = movs(r0, r5);
                lr = tinf_decode_trees + 128 | 1;
                bl(this::tinf_read_bits, 128);
                return;
            case 128:
                r3 = clcidx;
                r2 = add(sp, 16);
                r3 = ldrb(r4 + r3);
                r4 = adds(r4, 1);
                strb(r2 + r3, r0);
                b(null, 62);
                return;
            case 140:
                r1 = movs(r1, r7);
                r0 = movs(r0, r5);
                lr = tinf_decode_trees + 148 | 1;
                bl(this::tinf_decode_symbol, 148);
                return;
            case 148:
                cmp(r0, 17);
                if (beq(null, 198)) return;
            case 152:
                cmp(r0, 18);
                if (beq(null, 226)) return;
            case 156:
                cmp(r0, 16);
                if (bne(null, 254)) return;
            case 160:
                r3 = add(sp, 16);
                r6 = adds(r4, r3);
                r3 = subs(r6, 1);
                r3 = ldrb(r3);
                r2 = movs(r2, 3);
                r1 = movs(r1, 2);
                r0 = movs(r0, r5);
                str(sp + 8, r3);
                lr = tinf_decode_trees + 180 | 1;
                bl(this::tinf_read_bits, 180);
                return;
            case 180:
                r3 = movs(r3, 0);
            case 182:
                cmp(r0, r3);
                if (bne(null, 190)) return;
            case 186:
                r4 = adds(r4, r0);
                b(null, 78);
                return;
            case 190:
                r2 = ldr(sp + 8);
                strb(r6 + r3, r2);
                r3 = adds(r3, 1);
                b(null, 182);
                return;
            case 198:
                r2 = movs(r2, 3);
                r0 = movs(r0, r5);
                r1 = movs(r1, r2);
                lr = tinf_decode_trees + 208 | 1;
                bl(this::tinf_read_bits, 208);
                return;
            case 208:
                r3 = movs(r3, 0);
                r1 = add(sp, 16);
                r2 = adds(r4, r1);
                r1 = movs(r1, r3);
            case 216:
                cmp(r0, r3);
                if (beq(null, 186)) return;
            case 220:
                strb(r2 + r3, r1);
                r3 = adds(r3, 1);
                b(null, 216);
                return;
            case 226:
                r2 = movs(r2, 11);
                r1 = movs(r1, 7);
                r0 = movs(r0, r5);
                lr = tinf_decode_trees + 236 | 1;
                bl(this::tinf_read_bits, 236);
                return;
            case 236:
                r3 = movs(r3, 0);
                r1 = add(sp, 16);
                r2 = adds(r4, r1);
                r1 = movs(r1, r3);
            case 244:
                cmp(r0, r3);
                if (beq(null, 186)) return;
            case 248:
                strb(r2 + r3, r1);
                r3 = adds(r3, 1);
                b(null, 244);
                return;
            case 254:
                r3 = add(sp, 16);
                strb(r3 + r4, r0);
                r4 = adds(r4, 1);
                b(null, 78);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134316248, size=30, name='tinf_get_le_uint32', path='build/extmod/moduzlib.o', has_indirect=False)
    protected void tinf_get_le_uint32(int offset) throws Exception
    {
        pc = tinf_get_le_uint32 + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r6 = movs(r6, r0);
                r5 = movs(r5, 5);
                r0 = movs(r0, 0);
            case 8:
                r5 = subs(r5, 1);
                cmp(r5, 0);
                if (bne(null, 16)) return;
            case 14:
                pop(true, R4, R5, R6);
                return;
            case 16:
                r4 = lsrs(r0, 8);
                r0 = movs(r0, r6);
                lr = tinf_get_le_uint32 + 24 | 1;
                bl(this::uzlib_get_byte, 24);
                return;
            case 24:
                r0 = lsls(r0, 24);
                r0 = orrs(r0, r4);
                b(null, 8);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134316278, size=28, name='tinf_get_be_uint32', path='build/extmod/moduzlib.o', has_indirect=False)
    protected void tinf_get_be_uint32(int offset) throws Exception
    {
        pc = tinf_get_be_uint32 + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r6 = movs(r6, r0);
                r5 = movs(r5, 5);
                r0 = movs(r0, 0);
            case 8:
                r5 = subs(r5, 1);
                cmp(r5, 0);
                if (bne(null, 16)) return;
            case 14:
                pop(true, R4, R5, R6);
                return;
            case 16:
                r4 = lsls(r0, 8);
                r0 = movs(r0, r6);
                lr = tinf_get_be_uint32 + 24 | 1;
                bl(this::uzlib_get_byte, 24);
                return;
            case 24:
                r0 = orrs(r0, r4);
                b(null, 8);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134316308, size=640, name='uzlib_uncompress', path='build/extmod/moduzlib.o', has_indirect=False)
    protected void uzlib_uncompress(int offset) throws Exception
    {
        pc = uzlib_uncompress + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r4, r5, r6, r7);
                r6 = movs(r6, 128);
                r4 = movs(r4, r0);
                r6 = lsls(r6, 1);
            case 8:
                r3 = ldr(r4 + 40);
                r3 = adds(r3, 1);
                if (beq(null, 16)) return;
            case 14:
                b(null, 292);
                return;
            case 16:
                r0 = movs(r0, r4);
                lr = uzlib_uncompress + 22 | 1;
                bl(this::tinf_getbit, 22);
                return;
            case 22:
                r2 = movs(r2, 0);
                str(r4 + 44, r0);
                r1 = movs(r1, 2);
                r0 = movs(r0, r4);
                lr = uzlib_uncompress + 34 | 1;
                bl(this::tinf_read_bits, 34);
                return;
            case 34:
                str(r4 + 40, r0);
                cmp(r0, 1);
                if (bne(null, 272)) return;
            case 40:
                r1 = movs(r1, r4);
                r3 = movs(r3, 0);
                r1 = adds(r1, 8);
                r2 = adds(r4, 6);
                strh(r2 + 62, r3);
                r1 = adds(r1, 2);
                strh(r1 + 60, r3);
                strh(r1 + 62, r3);
                r1 = adds(r1, 2);
                strh(r1 + 62, r3);
                r1 = adds(r1, 2);
                strh(r1 + 62, r3);
                r1 = adds(r1, 64);
                strh(r1, r3);
                strh(r1 + 2, r3);
                r3 = movs(r3, r4);
                r1 = movs(r1, 24);
                r3 = adds(r3, 82);
                strh(r3, r1);
                r1 = movs(r1, 152);
                strh(r3 + 2, r1);
                r1 = subs(r1, 40);
                strh(r3 + 4, r1);
                r1 = movs(r1, r4);
                r3 = movs(r3, r6);
                r0 = adds(r0, 24);
                r1 = adds(r1, 100);
                r0 = adds(r0, 255);
            case 96:
                strh(r1, r3);
                r3 = adds(r3, 1);
                r3 = uxth(r3);
                r1 = adds(r1, 2);
                cmp(r3, r0);
                if (bne(null, 96)) return;
            case 108:
                r1 = movs(r1, r4);
                r3 = movs(r3, 0);
                r1 = adds(r1, 148);
            case 114:
                strh(r1, r3);
                r3 = adds(r3, 1);
                r1 = adds(r1, 2);
                cmp(r3, 144);
                if (bne(null, 114)) return;
            case 124:
                r1 = movs(r1, 215);
                r0 = movs(r0, 140);
                r1 = lsls(r1, 1);
                r0 = lsls(r0, 1);
                strh(r2 + r1, r0);
                r0 = movs(r0, 26);
                r1 = adds(r1, 2);
                r0 = adds(r0, 255);
                strh(r2 + r1, r0);
                r1 = adds(r1, 2);
                r0 = adds(r0, 1);
                strh(r2 + r1, r0);
                r0 = movs(r0, 28);
                r1 = adds(r1, 2);
                r0 = adds(r0, 255);
                strh(r2 + r1, r0);
                r1 = adds(r1, 2);
                r0 = adds(r0, 1);
                strh(r2 + r1, r0);
                r0 = movs(r0, 30);
                r1 = adds(r1, 2);
                r0 = adds(r0, 255);
                strh(r2 + r1, r0);
                r1 = adds(r1, 2);
                r0 = adds(r0, 1);
                strh(r2 + r1, r0);
                r0 = movs(r0, 32);
                r1 = adds(r1, 2);
                r0 = adds(r0, 255);
                strh(r2 + r1, r0);
                r2 = movs(r2, r4);
                r2 = adds(r2, 197);
                r2 = adds(r2, 255);
            case 190:
                strh(r2, r3);
                r3 = adds(r3, 1);
                r3 = uxth(r3);
                r2 = adds(r2, 2);
                cmp(r3, r6);
                if (bne(null, 190)) return;
            case 202:
                r2 = movs(r2, 169);
                r3 = movs(r3, 0);
                r1 = movs(r1, 32);
                r2 = lsls(r2, 2);
                strh(r4 + r2, r3);
                r2 = adds(r4, r2);
                strh(r2 + 2, r3);
                strh(r2 + 4, r3);
                strh(r2 + 6, r3);
                strh(r2 + 8, r3);
                strh(r2 + 10, r1);
                r2 = movs(r2, 177);
                r2 = lsls(r2, 2);
                r2 = adds(r4, r2);
            case 230:
                strh(r2, r3);
                r3 = adds(r3, 1);
                r2 = adds(r2, 2);
                cmp(r3, 32);
                if (bne(null, 230)) return;
            case 240:
                r3 = ldr(r4 + 48);
                cmp(r3, 0);
                if (beq(null, 248)) return;
            case 246:
                b(null, 576);
                return;
            case 248:
                r1 = movs(r1, r4);
                r0 = movs(r0, r4);
                r1 = adds(r1, 68);
                lr = uzlib_uncompress + 258 | 1;
                bl(this::tinf_decode_symbol, 258);
                return;
            case 258:
                cmp(r0, 255);
                if (bgt(null, 434)) return;
            case 262:
                r3 = ldr(r4 + 24);
                r0 = uxtb(r0);
                r2 = adds(r3, 1);
                str(r4 + 24, r2);
                b(null, 392);
                return;
            case 272:
                cmp(r0, 2);
                if (bne(null, 292)) return;
            case 276:
                r3 = movs(r3, 169);
                r1 = movs(r1, r4);
                r3 = lsls(r3, 2);
                r2 = adds(r4, r3);
                r1 = adds(r1, 68);
                r0 = movs(r0, r4);
                lr = uzlib_uncompress + 292 | 1;
                bl(this::tinf_decode_trees, 292);
                return;
            case 292:
                r3 = ldr(r4 + 40);
                cmp(r3, 0);
                if (beq(null, 310)) return;
            case 298:
                if (blt(null, 304)) return;
            case 300:
                cmp(r3, 2);
                if (ble(null, 240)) return;
            case 304:
                r0 = movs(r0, 3);
            case 306:
                r0 = rsbs(r0, 0);
                b(null, 612);
                return;
            case 310:
                r3 = ldr(r4 + 48);
                str(sp + 4, r3);
                cmp(r3, 0);
                if (bne(null, 370)) return;
            case 318:
                r0 = movs(r0, r4);
                lr = uzlib_uncompress + 324 | 1;
                bl(this::uzlib_get_byte, 324);
                return;
            case 324:
                r7 = movs(r7, r0);
                r0 = movs(r0, r4);
                lr = uzlib_uncompress + 332 | 1;
                bl(this::uzlib_get_byte, 332);
                return;
            case 332:
                r5 = lsls(r0, 8);
                r0 = movs(r0, r4);
                lr = uzlib_uncompress + 340 | 1;
                bl(this::uzlib_get_byte, 340);
                return;
            case 340:
                r5 = adds(r5, r7);
                r7 = movs(r7, r0);
                r0 = movs(r0, r4);
                lr = uzlib_uncompress + 350 | 1;
                bl(this::uzlib_get_byte, 350);
                return;
            case 350:
                r0 = lsls(r0, 8);
                r7 = adds(r0, r7);
                r0 = 0x0000ffff;
                r7 = eors(r7, r0);
                cmp(r5, r7);
                if (bne(null, 304)) return;
            case 362:
                r3 = ldr(sp + 4);
                r5 = adds(r5, 1);
                str(r4 + 48, r5);
                str(r4 + 12, r3);
            case 370:
                r3 = ldr(r4 + 48);
                r3 = subs(r3, 1);
                str(r4 + 48, r3);
                cmp(r3, 0);
                if (beq(null, 602)) return;
            case 380:
                r0 = movs(r0, r4);
                lr = uzlib_uncompress + 386 | 1;
                bl(this::uzlib_get_byte, 386);
                return;
            case 386:
                r3 = ldr(r4 + 24);
                r2 = adds(r3, 1);
                str(r4 + 24, r2);
            case 392:
                strb(r3, r0);
                r2 = ldr(r4 + 56);
                cmp(r2, 0);
                if (beq(null, 420)) return;
            case 400:
                r3 = ldr(r4 + 64);
                r1 = adds(r3, 1);
                str(r4 + 64, r1);
                strb(r2 + r3, r0);
                r3 = ldr(r4 + 64);
                r2 = ldr(r4 + 60);
                cmp(r3, r2);
                if (bne(null, 420)) return;
            case 416:
                r3 = movs(r3, 0);
                str(r4 + 64, r3);
            case 420:
                r3 = ldr(r4 + 20);
                r0 = subs(r3, 1);
                str(r4 + 20, r0);
                cmp(r0, 0);
                if (beq(null, 432)) return;
            case 430:
                b(null, 8);
                return;
            case 432:
                b(null, 612);
                return;
            case 434:
                cmp(r0, r6);
                if (beq(null, 602)) return;
            case 438:
                r0 = subs(r0, 2);
                r0 = subs(r0, 255);
                r3 = length_base;
                r2 = lsls(r0, 1);
                r2 = ldrh(r2 + r3);
                r3 = length_bits;
                r1 = ldrb(r3 + r0);
                r0 = movs(r0, r4);
                lr = uzlib_uncompress + 458 | 1;
                bl(this::tinf_read_bits, 458);
                return;
            case 458:
                r3 = movs(r3, 169);
                r3 = lsls(r3, 2);
                r1 = adds(r4, r3);
                str(r4 + 48, r0);
                r0 = movs(r0, r4);
                lr = uzlib_uncompress + 472 | 1;
                bl(this::tinf_decode_symbol, 472);
                return;
            case 472:
                r3 = dist_base;
                r2 = lsls(r0, 1);
                r2 = ldrh(r2 + r3);
                r3 = dist_bits;
                r1 = ldrb(r3 + r0);
                r0 = movs(r0, r4);
                lr = uzlib_uncompress + 488 | 1;
                bl(this::tinf_read_bits, 488);
                return;
            case 488:
                r3 = ldr(r4 + 56);
                cmp(r3, 0);
                if (beq(null, 598)) return;
            case 494:
                r2 = ldr(r4 + 60);
                cmp(r0, r2);
                if (bhi(null, 614)) return;
            case 500:
                r1 = ldr(r4 + 64);
                r0 = subs(r1, r0);
                if (bmi(null, 572)) return;
            case 506:
                r2 = ldr(r4 + 24);
                str(r4 + 52, r0);
            case 510:
                r1 = adds(r2, 1);
                str(r4 + 24, r1);
                r3 = ldrb(r3 + r0);
                strb(r2, r3);
                r3 = ldr(r4 + 56);
                cmp(r3, 0);
                if (beq(null, 548)) return;
            case 524:
                r2 = ldr(r4 + 64);
                r1 = adds(r2, 1);
                str(r4 + 64, r1);
                r1 = ldr(r4 + 52);
                r1 = ldrb(r3 + r1);
                strb(r3 + r2, r1);
                r3 = ldr(r4 + 64);
                r2 = ldr(r4 + 60);
                cmp(r3, r2);
                if (bne(null, 548)) return;
            case 544:
                r3 = movs(r3, 0);
                str(r4 + 64, r3);
            case 548:
                r3 = ldr(r4 + 52);
                r2 = ldr(r4 + 60);
                r3 = adds(r3, 1);
                str(r4 + 52, r3);
                cmp(r3, r2);
                if (bne(null, 564)) return;
            case 560:
                r3 = movs(r3, 0);
                str(r4 + 52, r3);
            case 564:
                r3 = ldr(r4 + 48);
                r3 = subs(r3, 1);
                str(r4 + 48, r3);
                b(null, 420);
                return;
            case 572:
                r0 = adds(r2, r0);
            case 574:
                str(r4 + 52, r0);
            case 576:
                r3 = ldr(r4 + 56);
                r2 = ldr(r4 + 24);
                r0 = ldr(r4 + 52);
                cmp(r3, 0);
                if (bne(null, 510)) return;
            case 586:
                r3 = ldrb(r2 + r0);
                strb(r2, r3);
                r3 = ldr(r4 + 24);
                r3 = adds(r3, 1);
                str(r4 + 24, r3);
                b(null, 564);
                return;
            case 598:
                r0 = rsbs(r0, 0);
                b(null, 574);
                return;
            case 602:
                r3 = ldr(r4 + 44);
                cmp(r3, 0);
                if (bne(null, 610)) return;
            case 608:
                b(null, 16);
                return;
            case 610:
                r0 = movs(r0, 1);
            case 612:
                pop(true, R1, R2, R3, R4, R5, R6, R7);
                return;
            case 614:
                r0 = movs(r0, 5);
                b(null, 306);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134316948, size=68, name='uzlib_zlib_parse_header', path='build/extmod/moduzlib.o', has_indirect=False)
    protected void uzlib_zlib_parse_header(int offset) throws Exception
    {
        pc = uzlib_zlib_parse_header + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r5 = movs(r5, r0);
                lr = uzlib_zlib_parse_header + 8 | 1;
                bl(this::uzlib_get_byte, 8);
                return;
            case 8:
                r4 = movs(r4, r0);
                r0 = movs(r0, r5);
                lr = uzlib_zlib_parse_header + 16 | 1;
                bl(this::uzlib_get_byte, 16);
                return;
            case 16:
                r6 = movs(r6, r0);
                r0 = lsls(r4, 8);
                r0 = adds(r0, r6);
                r1 = movs(r1, 31);
                lr = uzlib_zlib_parse_header + 28 | 1;
                bl(this::__aeabi_idivmod, 28);
                return;
            case 28:
                cmp(r1, 0);
                if (bne(null, 62)) return;
            case 32:
                r3 = movs(r3, 15);
                r3 = ands(r3, r4);
                cmp(r3, 8);
                if (bne(null, 62)) return;
            case 40:
                r4 = lsrs(r4, 4);
                r0 = uxtb(r4);
                cmp(r0, 7);
                if (bhi(null, 62)) return;
            case 48:
                r3 = lsls(r6, 26);
                if (bmi(null, 62)) return;
            case 52:
                r3 = movs(r3, 1);
                r2 = adds(r5, 5);
                strb(r2 + 31, r3);
                str(r5 + 32, r3);
            case 60:
                pop(true, R4, R5, R6);
                return;
            case 62:
                r0 = movs(r0, 3);
                r0 = rsbs(r0, 0);
                b(null, 60);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134317016, size=20, name='tinf_skip_bytes', path='build/extmod/moduzlib.o', has_indirect=False)
    protected void tinf_skip_bytes(int offset) throws Exception
    {
        pc = tinf_skip_bytes + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r5 = movs(r5, r0);
                r4 = movs(r4, r1);
            case 6:
                r4 = subs(r4, 1);
                if (bhs(null, 12)) return;
            case 10:
                pop(true, R4, R5, R6);
                return;
            case 12:
                r0 = movs(r0, r5);
                lr = tinf_skip_bytes + 18 | 1;
                bl(this::uzlib_get_byte, 18);
                return;
            case 18:
                b(null, 6);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134317036, size=24, name='tinf_get_uint16', path='build/extmod/moduzlib.o', has_indirect=False)
    protected void tinf_get_uint16(int offset) throws Exception
    {
        pc = tinf_get_uint16 + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r4 = movs(r4, r0);
                lr = tinf_get_uint16 + 8 | 1;
                bl(this::uzlib_get_byte, 8);
                return;
            case 8:
                r5 = movs(r5, r0);
                r0 = movs(r0, r4);
                lr = tinf_get_uint16 + 16 | 1;
                bl(this::uzlib_get_byte, 16);
                return;
            case 16:
                r0 = lsls(r0, 8);
                r0 = orrs(r0, r5);
                r0 = uxth(r0);
                pop(true, R4, R5, R6);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134317060, size=138, name='uzlib_gzip_parse_header', path='build/extmod/moduzlib.o', has_indirect=False)
    protected void uzlib_gzip_parse_header(int offset) throws Exception
    {
        pc = uzlib_gzip_parse_header + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r4 = movs(r4, r0);
                lr = uzlib_gzip_parse_header + 8 | 1;
                bl(this::uzlib_get_byte, 8);
                return;
            case 8:
                r6 = movs(r6, r0);
                cmp(r0, 31);
                if (beq(null, 20)) return;
            case 14:
                r0 = movs(r0, 3);
                r0 = rsbs(r0, 0);
            case 18:
                pop(true, R4, R5, R6);
                return;
            case 20:
                r0 = movs(r0, r4);
                lr = uzlib_gzip_parse_header + 26 | 1;
                bl(this::uzlib_get_byte, 26);
                return;
            case 26:
                cmp(r0, 139);
                if (bne(null, 14)) return;
            case 30:
                r0 = movs(r0, r4);
                lr = uzlib_gzip_parse_header + 36 | 1;
                bl(this::uzlib_get_byte, 36);
                return;
            case 36:
                cmp(r0, 8);
                if (bne(null, 14)) return;
            case 40:
                r0 = movs(r0, r4);
                lr = uzlib_gzip_parse_header + 46 | 1;
                bl(this::uzlib_get_byte, 46);
                return;
            case 46:
                r3 = movs(r3, r0);
                r3 = bics(r3, r6);
                r3 = uxtb(r3);
                r5 = movs(r5, r0);
                cmp(r3, 0);
                if (bne(null, 14)) return;
            case 58:
                r1 = movs(r1, 6);
                r0 = movs(r0, r4);
                lr = uzlib_gzip_parse_header + 66 | 1;
                bl(this::tinf_skip_bytes, 66);
                return;
            case 66:
                r3 = lsls(r5, 29);
                if (bpl(null, 84)) return;
            case 70:
                r0 = movs(r0, r4);
                lr = uzlib_gzip_parse_header + 76 | 1;
                bl(this::tinf_get_uint16, 76);
                return;
            case 76:
                r1 = movs(r1, r0);
                r0 = movs(r0, r4);
                lr = uzlib_gzip_parse_header + 84 | 1;
                bl(this::tinf_skip_bytes, 84);
                return;
            case 84:
                r3 = lsls(r5, 28);
                if (bpl(null, 98)) return;
            case 88:
                r0 = movs(r0, r4);
                lr = uzlib_gzip_parse_header + 94 | 1;
                bl(this::uzlib_get_byte, 94);
                return;
            case 94:
                cmp(r0, 0);
                if (bne(null, 88)) return;
            case 98:
                r3 = lsls(r5, 27);
                if (bpl(null, 112)) return;
            case 102:
                r0 = movs(r0, r4);
                lr = uzlib_gzip_parse_header + 108 | 1;
                bl(this::uzlib_get_byte, 108);
                return;
            case 108:
                cmp(r0, 0);
                if (bne(null, 102)) return;
            case 112:
                r6 = movs(r6, 2);
                tst(r5, r6);
                if (beq(null, 124)) return;
            case 118:
                r0 = movs(r0, r4);
                lr = uzlib_gzip_parse_header + 124 | 1;
                bl(this::tinf_get_uint16, 124);
                return;
            case 124:
                r3 = adds(r4, 5);
                strb(r3 + 31, r6);
                r3 = movs(r3, 1);
                r3 = rsbs(r3, 0);
                str(r4 + 32, r3);
                r0 = movs(r0, 0);
                b(null, 18);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134317200, size=184, name='decompio_make_new', path='build/extmod/moduzlib.o', has_indirect=False)
    protected void decompio_make_new(int offset) throws Exception
    {
        pc = decompio_make_new + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r7 = movs(r7, 0);
                r6 = movs(r6, r3);
                sp = sub(sp, 20);
                str(sp + 12, r1);
                r3 = movs(r3, 2);
                r5 = movs(r5, r0);
                r1 = movs(r1, r2);
                r0 = ldr(sp + 12);
                r2 = movs(r2, 1);
                str(sp, r7);
                lr = decompio_make_new + 26 | 1;
                bl(this::mp_arg_check_num, 26);
                return;
            case 26:
                r1 = movs(r1, 1);
                r0 = ldr(r6);
                lr = decompio_make_new + 34 | 1;
                bl(this::mp_get_stream_raise, 34);
                return;
            case 34:
                r0 = movs(r0, 162);
                r0 = lsls(r0, 3);
                lr = decompio_make_new + 42 | 1;
                bl(this::m_malloc, 42);
                return;
            case 42:
                str(r0, r5);
                r5 = movs(r5, r0);
                r4 = movs(r4, r0);
                r5 = adds(r5, 8);
                r2 = 0x00000504;
                r1 = movs(r1, r7);
                r0 = movs(r0, r5);
                lr = decompio_make_new + 60 | 1;
                bl(this::memset, 60);
                return;
            case 60:
                r3 = read_src_stream | 1;
                hint(read_src_stream | 1, this::read_src_stream);
                str(r4 + 12, r3);
                r3 = ldr(r6);
                str(r4 + 4, r3);
                r3 = 0x0000050c;
                strb(r4 + r3, r7);
                r3 = ldr(sp + 12);
                cmp(r3, 1);
                if (bhi(null, 94)) return;
            case 78:
                r0 = movs(r0, r5);
                lr = decompio_make_new + 84 | 1;
                bl(this::uzlib_zlib_parse_header, 84);
                return;
            case 84:
                cmp(r0, 0);
                if (bge(null, 132)) return;
            case 88:
                r0 = decompio_make_new_str1_1;
                lr = decompio_make_new + 94 | 1;
                bl(this::mp_raise_ValueError, 94);
                return;
            case 94:
                r0 = ldr(r6 + 4);
                lr = decompio_make_new + 100 | 1;
                bl(this::mp_obj_get_int, 100);
                return;
            case 100:
                r6 = movs(r6, r0);
                cmp(r0, 15);
                if (ble(null, 124)) return;
            case 106:
                r0 = movs(r0, r5);
                lr = decompio_make_new + 112 | 1;
                bl(this::uzlib_gzip_parse_header, 112);
                return;
            case 112:
                r6 = subs(r6, 16);
                cmp(r0, 0);
                if (bne(null, 88)) return;
            case 118:
                r5 = movs(r5, 1);
                r5 = lsls(r5, r6);
                b(null, 136);
                return;
            case 124:
                cmp(r0, 0);
                if (bge(null, 78)) return;
            case 128:
                r6 = rsbs(r0, 0);
                b(null, 118);
                return;
            case 132:
                r5 = movs(r5, 1);
                r5 = lsls(r5, r0);
            case 136:
                r0 = movs(r0, r5);
                lr = decompio_make_new + 142 | 1;
                bl(this::m_malloc, 142);
                return;
            case 142:
                r2 = movs(r2, 1);
                r3 = movs(r3, 0);
                str(r4 + 64, r0);
                r0 = movs(r0, r4);
                r2 = rsbs(r2, 0);
                str(r4 + 20, r3);
                str(r4 + 52, r3);
                str(r4 + 48, r2);
                str(r4 + 68, r5);
                str(r4 + 72, r3);
                str(r4 + 56, r3);
                sp = add(sp, 20);
                pop(true, R4, R5, R6, R7);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134317384, size=204, name='uzlib_adler32', path='build/extmod/moduzlib.o', has_indirect=False)
    protected void uzlib_adler32(int offset) throws Exception
    {
        pc = uzlib_adler32 + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r4, r5, r6, r7);
                r6 = movs(r6, r1);
                str(sp + 4, r0);
                r5 = uxth(r2);
                r4 = lsrs(r2, 16);
            case 10:
                cmp(r6, 0);
                if (bne(null, 20)) return;
            case 14:
                r0 = lsls(r4, 16);
                r0 = orrs(r0, r5);
                pop(true, R1, R2, R3, R4, R5, R6, R7);
                return;
            case 20:
                r3 = 0x000015b0;
                r7 = movs(r7, r6);
                cmp(r6, r3);
                if (bls(null, 30)) return;
            case 28:
                r7 = movs(r7, r3);
            case 30:
                r1 = asrs(r7, 4);
                r2 = movs(r2, r1);
                r3 = ldr(sp + 4);
            case 36:
                cmp(r2, 0);
                if (bne(null, 82)) return;
            case 40:
                r3 = ldr(sp + 4);
                r1 = lsls(r1, 4);
                r1 = adds(r3, r1);
                r3 = movs(r3, 15);
                r3 = ands(r3, r7);
                r3 = adds(r1, r3);
            case 52:
                cmp(r1, r3);
                if (bne(null, 184)) return;
            case 56:
                str(sp + 4, r1);
                r0 = movs(r0, r5);
                r1 = 0x0000fff1;
                lr = uzlib_adler32 + 66 | 1;
                bl(this::__aeabi_uidivmod, 66);
                return;
            case 66:
                r0 = movs(r0, r4);
                r5 = movs(r5, r1);
                r1 = 0x0000fff1;
                lr = uzlib_adler32 + 76 | 1;
                bl(this::__aeabi_uidivmod, 76);
                return;
            case 76:
                r6 = subs(r6, r7);
                r4 = movs(r4, r1);
                b(null, 10);
                return;
            case 82:
                r0 = ldrb(r3);
                r2 = subs(r2, 1);
                r5 = adds(r0, r5);
                r0 = ldrb(r3 + 1);
                r0 = adds(r0, r5);
                r5 = adds(r5, r0);
                r4 = adds(r5, r4);
                r5 = ldrb(r3 + 2);
                r0 = adds(r5, r0);
                r5 = ldrb(r3 + 3);
                r4 = adds(r4, r0);
                r0 = adds(r5, r0);
                r5 = ldrb(r3 + 4);
                r4 = adds(r4, r0);
                r0 = adds(r5, r0);
                r5 = ldrb(r3 + 5);
                r4 = adds(r4, r0);
                r0 = adds(r5, r0);
                r5 = ldrb(r3 + 6);
                r4 = adds(r4, r0);
                r0 = adds(r5, r0);
                r5 = ldrb(r3 + 7);
                r4 = adds(r4, r0);
                r0 = adds(r5, r0);
                r5 = ldrb(r3 + 8);
                r4 = adds(r4, r0);
                r0 = adds(r5, r0);
                r5 = ldrb(r3 + 9);
                r4 = adds(r4, r0);
                r0 = adds(r5, r0);
                r5 = ldrb(r3 + 10);
                r4 = adds(r4, r0);
                r0 = adds(r5, r0);
                r5 = ldrb(r3 + 11);
                r4 = adds(r4, r0);
                r0 = adds(r5, r0);
                r5 = ldrb(r3 + 12);
                r4 = adds(r4, r0);
                r0 = adds(r5, r0);
                r5 = ldrb(r3 + 13);
                r4 = adds(r4, r0);
                r0 = adds(r5, r0);
                r5 = ldrb(r3 + 14);
                r4 = adds(r4, r0);
                r0 = adds(r5, r0);
                r5 = ldrb(r3 + 15);
                r4 = adds(r4, r0);
                r5 = adds(r5, r0);
                r4 = adds(r4, r5);
                r3 = adds(r3, 16);
                b(null, 36);
                return;
            case 184:
                r2 = ldrb(r1);
                r1 = adds(r1, 1);
                r5 = adds(r5, r2);
                r4 = adds(r4, r5);
                b(null, 52);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134317588, size=56, name='uzlib_crc32', path='build/extmod/moduzlib.o', has_indirect=False)
    protected void uzlib_crc32(int offset) throws Exception
    {
        pc = uzlib_crc32 + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5);
                r3 = movs(r3, r0);
                r1 = adds(r0, r1);
                r5 = movs(r5, 15);
                r0 = movs(r0, r2);
                r4 = tinf_crc32tab;
            case 12:
                cmp(r3, r1);
                if (bne(null, 18)) return;
            case 16:
                pop(true, R4, R5);
                return;
            case 18:
                r2 = ldrb(r3);
                r3 = adds(r3, 1);
                r0 = eors(r0, r2);
                r2 = movs(r2, r0);
                r2 = ands(r2, r5);
                r2 = lsls(r2, 2);
                r2 = ldr(r2 + r4);
                r0 = lsrs(r0, 4);
                r2 = eors(r2, r0);
                r0 = movs(r0, r2);
                r0 = ands(r0, r5);
                r0 = lsls(r0, 2);
                r0 = ldr(r0 + r4);
                r2 = lsrs(r2, 4);
                r0 = eors(r0, r2);
                b(null, 12);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134317644, size=106, name='uzlib_uncompress_chksum', path='build/extmod/moduzlib.o', has_indirect=False)
    protected void uzlib_uncompress_chksum(int offset) throws Exception
    {
        pc = uzlib_uncompress_chksum + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r4 = movs(r4, r0);
                r6 = ldr(r0 + 24);
                lr = uzlib_uncompress_chksum + 10 | 1;
                bl(this::uzlib_uncompress, 10);
                return;
            case 10:
                r5 = subs(r0, 0);
                if (blt(null, 26)) return;
            case 14:
                r3 = adds(r4, 5);
                r3 = ldrb(r3 + 31);
                cmp(r3, 1);
                if (beq(null, 30)) return;
            case 22:
                cmp(r3, 2);
                if (beq(null, 66)) return;
            case 26:
                r0 = movs(r0, r5);
                pop(true, R4, R5, R6);
                return;
            case 30:
                r3 = ldr(r4 + 24);
                r2 = ldr(r4 + 32);
                r1 = subs(r3, r6);
                r0 = movs(r0, r6);
                lr = uzlib_uncompress_chksum + 42 | 1;
                bl(this::uzlib_adler32, 42);
                return;
            case 42:
                str(r4 + 32, r0);
                cmp(r5, 1);
                if (bne(null, 26)) return;
            case 48:
                r0 = movs(r0, r4);
                lr = uzlib_uncompress_chksum + 54 | 1;
                bl(this::tinf_get_be_uint32, 54);
                return;
            case 54:
                r3 = ldr(r4 + 32);
                cmp(r3, r0);
                if (beq(null, 26)) return;
            case 60:
                r5 = movs(r5, 4);
                r5 = rsbs(r5, 0);
                b(null, 26);
                return;
            case 66:
                r3 = ldr(r4 + 24);
                r2 = ldr(r4 + 32);
                r1 = subs(r3, r6);
                r0 = movs(r0, r6);
                lr = uzlib_uncompress_chksum + 78 | 1;
                bl(this::uzlib_crc32, 78);
                return;
            case 78:
                str(r4 + 32, r0);
                cmp(r5, 1);
                if (bne(null, 26)) return;
            case 84:
                r0 = movs(r0, r4);
                lr = uzlib_uncompress_chksum + 90 | 1;
                bl(this::tinf_get_le_uint32, 90);
                return;
            case 90:
                r3 = ldr(r4 + 32);
                r3 = mvns(r3, r3);
                cmp(r3, r0);
                if (bne(null, 60)) return;
            case 98:
                r0 = movs(r0, r4);
                lr = uzlib_uncompress_chksum + 104 | 1;
                bl(this::tinf_get_le_uint32, 104);
                return;
            case 104:
                b(null, 26);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134317752, size=60, name='decompio_read', path='build/extmod/moduzlib.o', has_indirect=False)
    protected void decompio_read(int offset) throws Exception
    {
        pc = decompio_read + offset;
        switch (offset)
        {
            case 0:
                push(true, r3, r4, r5, r6, r7);
                r6 = 0x0000050c;
                r4 = movs(r4, r0);
                r7 = movs(r7, r3);
                r3 = ldrb(r0 + r6);
                r0 = movs(r0, 0);
                r5 = movs(r5, r1);
                cmp(r3, r0);
                if (bne(null, 54)) return;
            case 18:
                r0 = movs(r0, r4);
                str(r4 + 32, r1);
                str(r4 + 28, r2);
                r0 = adds(r0, 8);
                lr = decompio_read + 30 | 1;
                bl(this::uzlib_uncompress_chksum, 30);
                return;
            case 30:
                cmp(r0, 1);
                if (bne(null, 42)) return;
            case 34:
                strb(r4 + r6, r0);
            case 36:
                r0 = ldr(r4 + 32);
                r0 = subs(r0, r5);
                b(null, 54);
                return;
            case 42:
                cmp(r0, 0);
                if (bge(null, 36)) return;
            case 46:
                r3 = movs(r3, 22);
                r0 = movs(r0, 1);
                str(r7, r3);
                r0 = rsbs(r0, 0);
            case 54:
                pop(true, R3, R4, R5, R6, R7);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134317812, size=196, name='mod_uzlib_decompress', path='build/extmod/moduzlib.o', has_indirect=False)
    protected void mod_uzlib_decompress(int offset) throws Exception
    {
        pc = mod_uzlib_decompress + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r7 = movs(r7, r1);
                sp = sub(sp, 28);
                r2 = movs(r2, 1);
                r1 = add(sp, 12);
                str(sp + 4, r0);
                r0 = ldr(r7);
                lr = mod_uzlib_decompress + 18 | 1;
                bl(this::mp_get_buffer_raise, 18);
                return;
            case 18:
                r0 = 0x00000504;
                lr = mod_uzlib_decompress + 24 | 1;
                bl(this::m_malloc, 24);
                return;
            case 24:
                r2 = 0x00000504;
                r1 = movs(r1, 0);
                r4 = movs(r4, r0);
                lr = mod_uzlib_decompress + 34 | 1;
                bl(this::memset, 34);
                return;
            case 34:
                r3 = movs(r3, 1);
                r5 = ldr(sp + 16);
                r3 = rsbs(r3, 0);
                str(r4 + 40, r3);
                r5 = adds(r5, 15);
                r3 = adds(r3, 16);
                r5 = bics(r5, r3);
                r0 = movs(r0, r5);
                lr = mod_uzlib_decompress + 54 | 1;
                bl(this::m_malloc, 54);
                return;
            case 54:
                r3 = ldr(sp + 12);
                r6 = movs(r6, r0);
                str(r4, r3);
                r3 = ldr(sp + 4);
                str(r4 + 24, r0);
                str(r4 + 20, r5);
                cmp(r3, 1);
                if (bls(null, 76)) return;
            case 70:
                r3 = ldr(r7 + 4);
                cmp(r3, 0);
                if (blt(null, 86)) return;
            case 76:
                r0 = movs(r0, r4);
                lr = mod_uzlib_decompress + 82 | 1;
                bl(this::uzlib_zlib_parse_header, 82);
                return;
            case 82:
                cmp(r0, 0);
                if (blt(null, 136)) return;
            case 86:
                r0 = movs(r0, r4);
                lr = mod_uzlib_decompress + 92 | 1;
                bl(this::uzlib_uncompress_chksum, 92);
                return;
            case 92:
                cmp(r0, 0);
                if (blt(null, 136)) return;
            case 96:
                r3 = ldr(r4 + 24);
                r7 = subs(r3, r6);
                cmp(r0, 1);
                if (beq(null, 152)) return;
            case 104:
                r3 = adds(r5, 1);
                r3 = adds(r3, 255);
                r2 = movs(r2, r3);
                r1 = movs(r1, r5);
                r0 = movs(r0, r6);
                str(sp + 4, r3);
                lr = mod_uzlib_decompress + 120 | 1;
                bl(this::m_realloc, 120);
                return;
            case 120:
                r3 = movs(r3, 128);
                r7 = adds(r0, r7);
                r3 = lsls(r3, 1);
                r6 = movs(r6, r0);
                str(r4 + 24, r7);
                str(r4 + 20, r3);
                r5 = ldr(sp + 4);
                b(null, 86);
                return;
            case 136:
                r1 = movs(r1, 1);
                r0 = lsls(r0, 1);
                r1 = orrs(r1, r0);
                r0 = mp_type_ValueError;
                lr = mod_uzlib_decompress + 148 | 1;
                bl(this::mp_obj_new_exception_arg1, 148);
                return;
            case 148:
                lr = mod_uzlib_decompress + 152 | 1;
                bl(this::nlr_jump, 152);
                return;
            case 152:
                r2 = movs(r2, r7);
                r1 = movs(r1, r5);
                r0 = movs(r0, r6);
                lr = mod_uzlib_decompress + 162 | 1;
                bl(this::m_realloc, 162);
                return;
            case 162:
                r1 = movs(r1, r0);
                r0 = movs(r0, r7);
                lr = mod_uzlib_decompress + 170 | 1;
                bl(this::mp_obj_new_bytearray_by_ref, 170);
                return;
            case 170:
                r5 = movs(r5, r0);
                r1 = 0x00000504;
                r0 = movs(r0, r4);
                lr = mod_uzlib_decompress + 180 | 1;
                bl(this::m_free, 180);
                return;
            case 180:
                r0 = movs(r0, r5);
                sp = add(sp, 28);
                pop(true, R4, R5, R6, R7);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134318008, size=32, name='get_heap', path='build/extmod/moduheapq.o', has_indirect=False)
    protected void get_heap(int offset) throws Exception
    {
        pc = get_heap + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r3 = lsls(r0, 30);
                if (bne(null, 14)) return;
            case 6:
                r3 = mp_type_list;
                r2 = ldr(r0);
                cmp(r2, r3);
                if (beq(null, 20)) return;
            case 14:
                r0 = get_heap_str1_1;
                lr = get_heap + 20 | 1;
                bl(this::mp_raise_TypeError, 20);
                return;
            case 20:
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134318040, size=72, name='heap_siftdown_isra_0', path='build/extmod/moduheapq.o', has_indirect=False)
    protected void heap_siftdown_isra_0(int offset) throws Exception
    {
        pc = heap_siftdown_isra_0 + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r4, r5, r6, r7);
                r5 = movs(r5, r0);
                r3 = lsls(r2, 2);
                r4 = movs(r4, r2);
                r2 = ldr(r0);
                str(sp + 4, r1);
                r7 = ldr(r3 + r2);
            case 14:
                r2 = lsls(r4, 2);
                str(sp, r2);
                r2 = ldr(sp + 4);
                r3 = ldr(r5);
                cmp(r4, r2);
                if (bls(null, 50)) return;
            case 26:
                r4 = subs(r4, 1);
                r4 = lsrs(r4, 1);
                r2 = lsls(r4, 2);
                r6 = ldr(r2 + r3);
                r1 = movs(r1, r7);
                r2 = movs(r2, r6);
                r0 = movs(r0, 0);
                lr = heap_siftdown_isra_0 + 44 | 1;
                bl(this::mp_binary_op, 44);
                return;
            case 44:
                r3 = mp_const_true_obj;
                cmp(r0, r3);
                if (beq(null, 58)) return;
            case 50:
                r3 = ldr(r5);
                r2 = ldr(sp);
                str(r3 + r2, r7);
                pop(true, R0, R1, R2, R4, R5, R6, R7);
                return;
            case 58:
                r3 = ldr(r5);
                r2 = ldr(sp);
                str(r3 + r2, r6);
                b(null, 14);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134318112, size=112, name='heap_siftup', path='build/extmod/moduheapq.o', has_indirect=False)
    protected void heap_siftup(int offset) throws Exception
    {
        pc = heap_siftup + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r3 = ldr(r0 + 8);
                sp = sub(sp, 20);
                r2 = ldr(r0 + 12);
                str(sp + 4, r3);
                r3 = lsls(r1, 2);
                r3 = ldr(r3 + r2);
                r5 = movs(r5, r0);
                r6 = movs(r6, r1);
                r2 = movs(r2, r1);
                r4 = lsls(r1, 1);
                str(sp + 8, r3);
                r4 = adds(r4, 1);
            case 26:
                r1 = lsls(r2, 2);
                str(sp + 12, r1);
                r1 = ldr(sp + 4);
                r3 = ldr(r5 + 12);
                cmp(r4, r1);
                if (blo(null, 58)) return;
            case 38:
                r0 = ldr(sp + 8);
                r1 = lsls(r2, 2);
                str(r3 + r1, r0);
                r0 = movs(r0, r5);
                r1 = movs(r1, r6);
                r0 = adds(r0, 12);
                lr = heap_siftup + 54 | 1;
                bl(this::heap_siftdown_isra_0, 54);
                return;
            case 54:
                sp = add(sp, 20);
                pop(true, R4, R5, R6, R7);
                return;
            case 58:
                r2 = ldr(sp + 4);
                r7 = adds(r4, 1);
                cmp(r7, r2);
                if (bhs(null, 88)) return;
            case 66:
                r1 = lsls(r4, 2);
                r2 = adds(r3, r1);
                r2 = ldr(r2 + 4);
                r1 = ldr(r3 + r1);
                r0 = movs(r0, 0);
                lr = heap_siftup + 80 | 1;
                bl(this::mp_binary_op, 80);
                return;
            case 80:
                r3 = mp_const_false_obj;
                cmp(r0, r3);
                if (bne(null, 88)) return;
            case 86:
                r4 = movs(r4, r7);
            case 88:
                r3 = ldr(r5 + 12);
                r2 = lsls(r4, 2);
                r2 = ldr(r2 + r3);
                r1 = ldr(sp + 12);
                str(r3 + r1, r2);
                r3 = lsls(r4, 1);
                r2 = movs(r2, r4);
                r4 = adds(r3, 1);
                b(null, 26);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134318224, size=36, name='mod_uheapq_heapify', path='build/extmod/moduheapq.o', has_indirect=False)
    protected void mod_uheapq_heapify(int offset) throws Exception
    {
        pc = mod_uheapq_heapify + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                lr = mod_uheapq_heapify + 6 | 1;
                bl(this::get_heap, 6);
                return;
            case 6:
                r5 = movs(r5, r0);
                r3 = ldr(r0 + 8);
                r4 = lsrs(r3, 1);
            case 12:
                cmp(r4, 0);
                if (bne(null, 20)) return;
            case 16:
                r0 = mp_const_none_obj;
                pop(true, R4, R5, R6);
                return;
            case 20:
                r4 = subs(r4, 1);
                r1 = movs(r1, r4);
                r0 = movs(r0, r5);
                lr = mod_uheapq_heapify + 30 | 1;
                bl(this::heap_siftup, 30);
                return;
            case 30:
                b(null, 12);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134318260, size=44, name='mod_uheapq_heappush', path='build/extmod/moduheapq.o', has_indirect=False)
    protected void mod_uheapq_heappush(int offset) throws Exception
    {
        pc = mod_uheapq_heappush + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r5 = movs(r5, r0);
                r6 = movs(r6, r1);
                lr = mod_uheapq_heappush + 10 | 1;
                bl(this::get_heap, 10);
                return;
            case 10:
                r4 = movs(r4, r0);
                r1 = movs(r1, r6);
                r0 = movs(r0, r5);
                lr = mod_uheapq_heappush + 20 | 1;
                bl(this::mp_obj_list_append, 20);
                return;
            case 20:
                r0 = movs(r0, r4);
                r3 = ldr(r4 + 8);
                r0 = adds(r0, 12);
                r2 = subs(r3, 1);
                r1 = movs(r1, 0);
                lr = mod_uheapq_heappush + 34 | 1;
                bl(this::heap_siftdown_isra_0, 34);
                return;
            case 34:
                r0 = mp_const_none_obj;
                pop(true, R4, R5, R6);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134318304, size=64, name='mod_uheapq_heappop', path='build/extmod/moduheapq.o', has_indirect=False)
    protected void mod_uheapq_heappop(int offset) throws Exception
    {
        pc = mod_uheapq_heappop + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                lr = mod_uheapq_heappop + 6 | 1;
                bl(this::get_heap, 6);
                return;
            case 6:
                r3 = ldr(r0 + 8);
                cmp(r3, 0);
                if (bne(null, 24)) return;
            case 12:
                r1 = mod_uheapq_heappop_str1_1;
                r0 = mp_type_IndexError;
                lr = mod_uheapq_heappop + 20 | 1;
                bl(this::mp_obj_new_exception_msg, 20);
                return;
            case 20:
                lr = mod_uheapq_heappop + 24 | 1;
                bl(this::nlr_jump, 24);
                return;
            case 24:
                r2 = ldr(r0 + 12);
                r3 = subs(r3, 1);
                r5 = lsls(r3, 2);
                r1 = ldr(r2 + r5);
                r4 = ldr(r2);
                str(r0 + 8, r3);
                str(r2, r1);
                r1 = movs(r1, 0);
                r2 = ldr(r0 + 12);
                str(r2 + r5, r1);
                cmp(r3, r1);
                if (beq(null, 52)) return;
            case 48:
                lr = mod_uheapq_heappop + 52 | 1;
                bl(this::heap_siftup, 52);
                return;
            case 52:
                r0 = movs(r0, r4);
                pop(true, R4, R5, R6);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134318368, size=44, name='utimeq_unary_op', path='build/extmod/modutimeq.o', has_indirect=False)
    protected void utimeq_unary_op(int offset) throws Exception
    {
        pc = utimeq_unary_op + offset;
        switch (offset)
        {
            case 0:
                cmp(r0, 4);
                if (beq(null, 12)) return;
            case 4:
                cmp(r0, 5);
                if (beq(null, 24)) return;
            case 8:
                r0 = movs(r0, 0);
                b(null, 22);
                return;
            case 12:
                r3 = ldr(r1 + 8);
                r0 = mp_const_true_obj;
                cmp(r3, 0);
                if (bne(null, 22)) return;
            case 20:
                r0 = mp_const_false_obj;
            case 22:
                bx(lr);
                return;
            case 24:
                r0 = movs(r0, 1);
                r3 = ldr(r1 + 8);
                r3 = lsls(r3, 1);
                r0 = orrs(r0, r3);
                b(null, 22);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134318412, size=68, name='utimeq_make_new', path='build/extmod/modutimeq.o', has_indirect=False)
    protected void utimeq_make_new(int offset) throws Exception
    {
        pc = utimeq_make_new + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r5 = movs(r5, 0);
                r4 = movs(r4, r3);
                r3 = movs(r3, 1);
                sp = sub(sp, 20);
                str(sp + 12, r0);
                str(sp, r5);
                r0 = movs(r0, r1);
                r1 = movs(r1, r2);
                r2 = movs(r2, r3);
                lr = utimeq_make_new + 24 | 1;
                bl(this::mp_arg_check_num, 24);
                return;
            case 24:
                r0 = ldr(r4);
                lr = utimeq_make_new + 30 | 1;
                bl(this::mp_obj_get_int, 30);
                return;
            case 30:
                r7 = lsls(r0, 4);
                r6 = movs(r6, r0);
                r0 = movs(r0, r7);
                r0 = adds(r0, 12);
                lr = utimeq_make_new + 42 | 1;
                bl(this::m_malloc, 42);
                return;
            case 42:
                r4 = movs(r4, r0);
                r3 = ldr(sp + 12);
                r2 = movs(r2, r7);
                str(r0, r3);
                r1 = movs(r1, r5);
                r0 = adds(r0, 12);
                lr = utimeq_make_new + 58 | 1;
                bl(this::memset, 58);
                return;
            case 58:
                r0 = movs(r0, r4);
                str(r4 + 4, r6);
                str(r4 + 8, r5);
                sp = add(sp, 20);
                pop(true, R4, R5, R6, R7);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134318480, size=40, name='mod_utimeq_peektime', path='build/extmod/modutimeq.o', has_indirect=False)
    protected void mod_utimeq_peektime(int offset) throws Exception
    {
        pc = mod_utimeq_peektime + offset;
        switch (offset)
        {
            case 0:
                r3 = ldr(r0 + 8);
                push(true, r4);
                cmp(r3, 0);
                if (bne(null, 20)) return;
            case 8:
                r1 = mod_uheapq_heappop_str1_1;
                r0 = mp_type_IndexError;
                lr = mod_utimeq_peektime + 16 | 1;
                bl(this::mp_obj_new_exception_msg, 16);
                return;
            case 16:
                lr = mod_utimeq_peektime + 20 | 1;
                bl(this::nlr_jump, 20);
                return;
            case 20:
                r3 = ldr(r0 + 12);
                r0 = movs(r0, 1);
                r3 = lsls(r3, 1);
                r0 = orrs(r0, r3);
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134318520, size=144, name='heap_siftdown_constprop_3', path='build/extmod/modutimeq.o', has_indirect=False)
    protected void heap_siftdown_constprop_3(int offset) throws Exception
    {
        pc = heap_siftdown_constprop_3 + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r2 = lsls(r1, 4);
                sp = sub(sp, 28);
                r3 = adds(r0, r2);
                r3 = adds(r3, 12);
                r4 = add(sp, 8);
                r3 = ldm(r3, R5, R6, R7);
                r4 = stm(r4, R5, R6, R7);
                r3 = ldr(r3);
                str(r4, r3);
                r3 = movs(r3, r2);
                r3 = adds(r3, 12);
                r3 = adds(r0, r3);
                r6 = ldr(r3);
                r5 = ldr(r3 + 4);
            case 30:
                r7 = lsls(r1, 4);
                cmp(r1, 0);
                if (bne(null, 58)) return;
            case 36:
                r0 = adds(r0, r7);
                str(sp + 8, r6);
                str(sp + 12, r5);
                r3 = add(sp, 8);
                r0 = adds(r0, 12);
                r3 = ldm(r3, R1, R2, R4);
                r0 = stm(r0, R1, R2, R4);
                r3 = ldr(r3);
                str(r0, r3);
                sp = add(sp, 28);
                pop(true, R4, R5, R6, R7);
                return;
            case 58:
                r1 = subs(r1, 1);
                r3 = lsrs(r1, 1);
                str(sp, r3);
                r3 = lsls(r3, 4);
                str(sp + 4, r3);
                r3 = adds(r0, r3);
                r12 = mov(r3);
                r3 = ldr(r3 + 12);
                r4 = subs(r3, r6);
                if (bne(null, 114)) return;
            case 78:
                r3 = mov(r12);
                r4 = ldr(r3 + 16);
                cmp(r5, r4);
                r4 = sbcs(r4, r4);
                r4 = rsbs(r4, 0);
            case 88:
                cmp(r4, 0);
                if (beq(null, 36)) return;
            case 92:
                r2 = ldr(sp + 4);
                r3 = adds(r0, r7);
                r2 = adds(r0, r2);
                r3 = adds(r3, 12);
                r2 = adds(r2, 12);
                r2 = ldm(r2, R1, R4, R7);
                r3 = stm(r3, R1, R4, R7);
                r2 = ldr(r2);
                str(r3, r2);
                r1 = ldr(sp);
                b(null, 30);
                return;
            case 114:
                cmp(r4, 0);
                if (bge(null, 124)) return;
            case 118:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 23);
                r4 = adds(r4, r3);
            case 124:
                r3 = movs(r3, 0);
                r2 = 0x1ffffffe;
                r4 = subs(r4, 1);
                cmp(r2, r4);
                r3 = adcs(r3, r3);
                r4 = uxtb(r3);
                b(null, 88);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134318664, size=276, name='mod_utimeq_heappop', path='build/extmod/modutimeq.o', has_indirect=False)
    protected void mod_utimeq_heappop(int offset) throws Exception
    {
        pc = mod_utimeq_heappop + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r3 = ldr(r0 + 8);
                sp = sub(sp, 28);
                r12 = mov(r3);
                cmp(r3, 0);
                if (bne(null, 24)) return;
            case 12:
                r1 = mod_uheapq_heappop_str1_1;
                r0 = mp_type_IndexError;
                lr = mod_utimeq_heappop + 20 | 1;
                bl(this::mp_obj_new_exception_msg, 20);
                return;
            case 20:
                lr = mod_utimeq_heappop + 24 | 1;
                bl(this::nlr_jump, 24);
                return;
            case 24:
                r6 = movs(r6, 3);
                r6 = ands(r6, r1);
                if (bne(null, 44)) return;
            case 30:
                r3 = mp_type_list;
                r2 = ldr(r1);
                cmp(r2, r3);
                if (bne(null, 44)) return;
            case 38:
                r3 = ldr(r1 + 8);
                cmp(r3, 2);
                if (bhi(null, 50)) return;
            case 44:
                r0 = movs(r0, 0);
                lr = mod_utimeq_heappop + 50 | 1;
                bl(this::mp_raise_TypeError, 50);
                return;
            case 50:
                r2 = movs(r2, 1);
                r3 = ldr(r0 + 12);
                r4 = ldr(r1 + 12);
                r3 = lsls(r3, 1);
                r3 = orrs(r3, r2);
                str(r4, r3);
                r3 = ldr(r1 + 12);
                r4 = ldr(r0 + 20);
                str(r3 + 4, r4);
                r3 = ldr(r1 + 12);
                r1 = ldr(r0 + 24);
                str(r3 + 8, r1);
                r3 = mov(r12);
                r1 = movs(r1, r0);
                r4 = subs(r3, 1);
                r3 = lsls(r4, 4);
                r3 = adds(r0, r3);
                str(r0 + 8, r4);
                r1 = adds(r1, 12);
                r3 = adds(r3, 12);
                r3 = ldm(r3, R2, R5, R7);
                r1 = stm(r1, R2, R5, R7);
                r3 = ldr(r3);
                str(r1, r3);
                r3 = mov(r12);
                r5 = lsls(r3, 4);
                r3 = movs(r3, r0);
                r5 = adds(r0, r5);
                str(r5 + 4, r6);
                str(r5 + 8, r6);
                r3 = adds(r3, 12);
                cmp(r4, 0);
                if (beq(null, 158)) return;
            case 116:
                r1 = add(sp, 8);
                r3 = ldm(r3, R2, R5, R7);
                r1 = stm(r1, R2, R5, R7);
                r3 = ldr(r3);
                r2 = movs(r2, 1);
                str(r1, r3);
                r12 = mov(r6);
                r1 = movs(r1, r6);
            case 132:
                r3 = lsls(r1, 4);
                str(sp + 4, r3);
                cmp(r4, r2);
                if (bhi(null, 164)) return;
            case 140:
                r3 = adds(r0, r3);
                r3 = adds(r3, 12);
                r2 = add(sp, 8);
                r2 = ldm(r2, R4, R5, R6);
                r3 = stm(r3, R4, R5, R6);
                r2 = ldr(r2);
                str(r3, r2);
                lr = mod_utimeq_heappop + 158 | 1;
                bl(this::heap_siftdown_constprop_3, 158);
                return;
            case 158:
                r0 = mp_const_none_obj;
                sp = add(sp, 28);
                pop(true, R4, R5, R6, R7);
                return;
            case 164:
                r7 = adds(r2, 1);
                cmp(r4, r7);
                if (bls(null, 202)) return;
            case 170:
                r5 = lsls(r7, 4);
                r6 = lsls(r2, 4);
                r5 = adds(r0, r5);
                r6 = adds(r0, r6);
                r1 = ldr(r5 + 12);
                r3 = ldr(r6 + 12);
                r1 = subs(r1, r3);
                if (bne(null, 230)) return;
            case 186:
                r1 = ldr(r6 + 16);
                r5 = ldr(r5 + 16);
                cmp(r1, r5);
                r1 = sbcs(r1, r1);
                r1 = rsbs(r1, 0);
            case 196:
                cmp(r1, 0);
                if (bne(null, 202)) return;
            case 200:
                r2 = movs(r2, r7);
            case 202:
                r3 = ldr(sp + 4);
                r1 = lsls(r2, 4);
                r3 = adds(r0, r3);
                r1 = adds(r0, r1);
                r3 = adds(r3, 12);
                r1 = adds(r1, 12);
                r1 = ldm(r1, R5, R6, R7);
                r3 = stm(r3, R5, R6, R7);
                r1 = ldr(r1);
                str(r3, r1);
                r3 = lsls(r2, 1);
                r1 = movs(r1, r2);
                r2 = adds(r3, 1);
                b(null, 132);
                return;
            case 230:
                cmp(r1, 0);
                if (bge(null, 240)) return;
            case 234:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 23);
                r1 = adds(r1, r3);
            case 240:
                r5 = mov(r12);
                r6 = 0x1ffffffe;
                r1 = subs(r1, 1);
                cmp(r6, r1);
                r5 = adcs(r5, r5);
                r1 = uxtb(r5);
                b(null, 196);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134318940, size=84, name='mod_utimeq_heappush', path='build/extmod/modutimeq.o', has_indirect=False)
    protected void mod_utimeq_heappush(int offset) throws Exception
    {
        pc = mod_utimeq_heappush + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r4 = ldr(r1);
                r2 = movs(r2, r1);
                r3 = ldr(r4 + 4);
                r1 = ldr(r4 + 8);
                cmp(r1, r3);
                if (bne(null, 22)) return;
            case 14:
                r1 = mod_utimeq_heappush_str1_1;
                r0 = mp_type_IndexError;
                lr = mod_utimeq_heappush + 22 | 1;
                bl(this::mp_raise_msg, 22);
                return;
            case 22:
                r0 = ldr(r2 + 4);
                r5 = utimeq_id;
                r3 = lsls(r1, 4);
                r3 = adds(r4, r3);
                r0 = asrs(r0, 1);
                str(r3 + 12, r0);
                r0 = ldr(r5);
                r6 = adds(r0, 1);
                str(r3 + 16, r0);
                r0 = ldr(r2 + 8);
                str(r5, r6);
                str(r3 + 20, r0);
                r2 = ldr(r2 + 12);
                r0 = movs(r0, r4);
                str(r3 + 24, r2);
                lr = mod_utimeq_heappush + 56 | 1;
                bl(this::heap_siftdown_constprop_3, 56);
                return;
            case 56:
                r3 = ldr(r4 + 8);
                r0 = mp_const_none_obj;
                r3 = adds(r3, 1);
                str(r4 + 8, r3);
                pop(true, R4, R5, R6);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134319024, size=364, name='sha256_transform', path='build/extmod/moduhashlib.o', has_indirect=False)
    protected void sha256_transform(int offset) throws Exception
    {
        pc = sha256_transform + offset;
        switch (offset)
        {
            case 0:
                r2 = movs(r2, 0);
                push(true, r4, r5, r6, r7);
                sp = sub(sp, 308);
            case 6:
                r3 = ldrb(r1);
                r4 = ldrb(r1 + 1);
                r3 = lsls(r3, 24);
                r4 = lsls(r4, 16);
                r3 = orrs(r3, r4);
                r4 = ldrb(r1 + 3);
                r3 = orrs(r3, r4);
                r4 = ldrb(r1 + 2);
                r1 = adds(r1, 4);
                r4 = lsls(r4, 8);
                r3 = orrs(r3, r4);
                r4 = add(sp, 48);
                str(r2 + r4, r3);
                r2 = adds(r2, 4);
                cmp(r2, 64);
                if (bne(null, 6)) return;
            case 38:
                r3 = movs(r3, r4);
                r7 = movs(r7, 17);
                r6 = movs(r6, 19);
            case 44:
                r2 = ldr(r3 + 56);
                r4 = ldr(r3 + 4);
                r1 = movs(r1, r2);
                r1 = rors(r1, r7);
                r12 = mov(r1);
                r1 = movs(r1, r2);
                r5 = mov(r12);
                r1 = rors(r1, r6);
                r2 = lsrs(r2, 10);
                r1 = eors(r1, r5);
                r2 = eors(r2, r1);
                r5 = ldr(r3);
                r1 = ldr(r3 + 36);
                r3 = adds(r3, 4);
                r1 = adds(r1, r5);
                r2 = adds(r2, r1);
                r5 = movs(r5, 7);
                r1 = movs(r1, r4);
                r1 = rors(r1, r5);
                r12 = mov(r1);
                r1 = movs(r1, r4);
                r5 = adds(r5, 11);
                r1 = rors(r1, r5);
                r5 = mov(r12);
                r4 = lsrs(r4, 3);
                r1 = eors(r1, r5);
                r1 = eors(r1, r4);
                r2 = adds(r2, r1);
                str(r3 + 60, r2);
                r2 = add(sp, 240);
                cmp(r2, r3);
                if (bne(null, 44)) return;
            case 108:
                r3 = ldr(r0 + 80);
                r7 = movs(r7, 0);
                str(sp + 8, r3);
                r3 = ldr(r0 + 84);
                r4 = ldr(sp + 8);
                str(sp + 12, r3);
                r3 = ldr(r0 + 88);
                r6 = ldr(sp + 12);
                str(sp + 16, r3);
                r3 = ldr(r0 + 92);
                str(sp + 20, r3);
                r3 = ldr(r0 + 96);
                str(sp + 24, r3);
                r3 = ldr(r0 + 100);
                r1 = ldr(sp + 24);
                str(sp + 28, r3);
                r3 = ldr(r0 + 104);
                str(sp + 32, r3);
                r3 = ldr(r0 + 108);
                str(sp + 36, r3);
                str(sp + 40, r3);
                r3 = ldr(sp + 32);
                str(sp + 4, r3);
                r3 = ldr(sp + 28);
                str(sp, r3);
                r3 = ldr(sp + 20);
                str(sp + 44, r3);
                r3 = ldr(sp + 16);
                r12 = mov(r3);
            case 166:
                r3 = movs(r3, 11);
                r5 = movs(r5, r1);
                r2 = movs(r2, r1);
                r5 = rors(r5, r3);
                r3 = subs(r3, 5);
                r2 = rors(r2, r3);
                r2 = eors(r2, r5);
                r5 = movs(r5, r1);
                r3 = adds(r3, 19);
                r5 = rors(r5, r3);
                r3 = rodata_k;
                r5 = eors(r5, r2);
                r2 = add(sp, 48);
                r3 = ldr(r3 + r7);
                r2 = ldr(r7 + r2);
                r7 = adds(r7, 4);
                r2 = adds(r3, r2);
                r2 = adds(r5, r2);
                r3 = ldr(sp + 4);
                r5 = ldr(sp);
                r3 = bics(r3, r1);
                r5 = ands(r5, r1);
                r3 = eors(r3, r5);
                r2 = adds(r2, r3);
                r3 = ldr(sp + 40);
                r5 = movs(r5, r4);
                r3 = adds(r2, r3);
                str(sp + 40, r3);
                r3 = movs(r3, 13);
                r5 = rors(r5, r3);
                r2 = movs(r2, 2);
                r3 = movs(r3, r5);
                r5 = movs(r5, r4);
                r5 = rors(r5, r2);
                r2 = movs(r2, r4);
                r5 = eors(r5, r3);
                r3 = movs(r3, 22);
                r2 = rors(r2, r3);
                r3 = mov(r12);
                r5 = eors(r5, r2);
                r2 = mov(r12);
                r3 = eors(r3, r6);
                r2 = ands(r2, r6);
                r3 = ands(r3, r4);
                r3 = eors(r3, r2);
                r5 = adds(r5, r3);
                r2 = ldr(sp + 40);
                r3 = ldr(sp + 44);
                r3 = adds(r2, r3);
                r2 = adds(r2, r5);
                r5 = mov(r12);
                str(sp + 44, r5);
                r5 = ldr(sp + 4);
                str(sp + 40, r5);
                r5 = movs(r5, 128);
                r5 = lsls(r5, 1);
                cmp(r7, r5);
                if (bne(null, 342)) return;
            case 282:
                r5 = ldr(sp + 8);
                r2 = adds(r5, r2);
                str(r0 + 80, r2);
                r2 = ldr(sp + 12);
                r4 = adds(r2, r4);
                r2 = ldr(sp + 16);
                str(r0 + 84, r4);
                r6 = adds(r2, r6);
                r2 = ldr(sp + 20);
                str(r0 + 88, r6);
                r2 = add(r2, r12);
                str(r0 + 92, r2);
                r2 = ldr(sp + 24);
                r3 = adds(r2, r3);
                r2 = ldr(sp);
                str(r0 + 96, r3);
                r12 = mov(r2);
                r3 = ldr(sp + 28);
                r2 = ldr(sp + 4);
                r1 = adds(r3, r1);
                r3 = ldr(sp + 32);
                str(r0 + 100, r1);
                r3 = add(r3, r12);
                r12 = mov(r2);
                str(r0 + 104, r3);
                r3 = ldr(sp + 36);
                r3 = add(r3, r12);
                str(r0 + 108, r3);
                sp = add(sp, 308);
                pop(true, R4, R5, R6, R7);
                return;
            case 342:
                r5 = ldr(sp);
                r12 = mov(r6);
                str(sp, r1);
                r6 = movs(r6, r4);
                str(sp + 4, r5);
                r1 = movs(r1, r3);
                r4 = movs(r4, r2);
                b(null, 166);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134319388, size=80, name='sha256_init', path='build/extmod/moduhashlib.o', has_indirect=False)
    protected void sha256_init(int offset) throws Exception
    {
        assert offset == 0;
        pc = sha256_init + offset;
        r3 = movs(r3, 0);
        r2 = movs(r2, 0);
        str(r0 + 64, r3);
        r3 = movs(r3, 0);
        str(r0 + 72, r2);
        str(r0 + 76, r3);
        r3 = 0x6a09e667;
        str(r0 + 80, r3);
        r3 = 0xbb67ae85;
        str(r0 + 84, r3);
        r3 = 0x3c6ef372;
        str(r0 + 88, r3);
        r3 = 0xa54ff53a;
        str(r0 + 92, r3);
        r3 = 0x510e527f;
        str(r0 + 96, r3);
        r3 = 0x9b05688c;
        str(r0 + 100, r3);
        r3 = 0x1f83d9ab;
        str(r0 + 104, r3);
        r3 = 0x5be0cd19;
        str(r0 + 108, r3);
        bx(lr);
    }

    // function: Function(address=134319468, size=66, name='sha256_update', path='build/extmod/moduhashlib.o', has_indirect=False)
    protected void sha256_update(int offset) throws Exception
    {
        pc = sha256_update + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r4, r5, r6, r7);
                r6 = movs(r6, 128);
                r4 = movs(r4, r0);
                r5 = movs(r5, r1);
                r7 = movs(r7, 0);
                r3 = adds(r1, r2);
                str(sp + 4, r3);
                r6 = lsls(r6, 2);
            case 16:
                r3 = ldr(sp + 4);
                cmp(r5, r3);
                if (bne(null, 24)) return;
            case 22:
                pop(true, R0, R1, R2, R4, R5, R6, R7);
                return;
            case 24:
                r3 = ldr(r4 + 64);
                r2 = ldrb(r5);
                strb(r4 + r3, r2);
                r3 = adds(r3, 1);
                str(r4 + 64, r3);
                cmp(r3, 64);
                if (bne(null, 62)) return;
            case 38:
                r1 = movs(r1, r4);
                r0 = movs(r0, r4);
                lr = sha256_update + 46 | 1;
                bl(this::sha256_transform, 46);
                return;
            case 46:
                r2 = ldr(r4 + 72);
                r3 = ldr(r4 + 76);
                r2 = adds(r2, r6);
                r3 = adcs(r3, r7);
                str(r4 + 72, r2);
                str(r4 + 76, r3);
                r3 = movs(r3, 0);
                str(r4 + 64, r3);
            case 62:
                r5 = adds(r5, 1);
                b(null, 16);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134319536, size=36, name='uhashlib_sha256_update', path='build/extmod/moduhashlib.o', has_indirect=False)
    protected void uhashlib_sha256_update(int offset) throws Exception
    {
        pc = uhashlib_sha256_update + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r3, r4);
                r4 = movs(r4, r0);
                r2 = movs(r2, 1);
                r0 = movs(r0, r1);
                r1 = add(sp, 4);
                lr = uhashlib_sha256_update + 14 | 1;
                bl(this::mp_get_buffer_raise, 14);
                return;
            case 14:
                r0 = adds(r4, 4);
                r2 = ldr(sp + 8);
                r1 = ldr(sp + 4);
                lr = uhashlib_sha256_update + 24 | 1;
                bl(this::sha256_update, 24);
                return;
            case 24:
                r0 = mp_const_none_obj;
                sp = add(sp, 16);
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134319572, size=52, name='uhashlib_sha256_make_new', path='build/extmod/moduhashlib.o', has_indirect=False)
    protected void uhashlib_sha256_make_new(int offset) throws Exception
    {
        pc = uhashlib_sha256_make_new + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r4, r5, r6, r7);
                r5 = movs(r5, r1);
                r1 = movs(r1, r2);
                r2 = movs(r2, 0);
                r7 = movs(r7, r0);
                str(sp, r2);
                r0 = movs(r0, r5);
                r6 = movs(r6, r3);
                r3 = movs(r3, 1);
                lr = uhashlib_sha256_make_new + 22 | 1;
                bl(this::mp_arg_check_num, 22);
                return;
            case 22:
                r0 = movs(r0, 116);
                lr = uhashlib_sha256_make_new + 28 | 1;
                bl(this::m_malloc, 28);
                return;
            case 28:
                r4 = movs(r4, r0);
                r0 = stm(r0, R7);
                lr = uhashlib_sha256_make_new + 36 | 1;
                bl(this::sha256_init, 36);
                return;
            case 36:
                cmp(r5, 1);
                if (bne(null, 48)) return;
            case 40:
                r1 = ldr(r6);
                r0 = movs(r0, r4);
                lr = uhashlib_sha256_make_new + 48 | 1;
                bl(this::uhashlib_sha256_update, 48);
                return;
            case 48:
                r0 = movs(r0, r4);
                pop(true, R1, R2, R3, R4, R5, R6, R7);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134319624, size=204, name='sha256_final', path='build/extmod/moduhashlib.o', has_indirect=False)
    protected void sha256_final(int offset) throws Exception
    {
        pc = sha256_final + offset;
        switch (offset)
        {
            case 0:
                push(true, r3, r4, r5, r6, r7);
                r5 = movs(r5, r1);
                r1 = movs(r1, 128);
                r2 = ldr(r0 + 64);
                r4 = movs(r4, r0);
                r3 = adds(r2, 1);
                strb(r0 + r2, r1);
                cmp(r2, 55);
                if (bhi(null, 172)) return;
            case 18:
                r2 = movs(r2, 0);
            case 20:
                cmp(r3, 56);
                if (bne(null, 166)) return;
            case 24:
                r3 = movs(r3, 0);
                r1 = ldr(r4 + 64);
                r2 = lsls(r1, 3);
                r0 = ldr(r4 + 72);
                r1 = ldr(r4 + 76);
                r2 = adds(r2, r0);
                r3 = adcs(r3, r1);
                r1 = movs(r1, r4);
                r6 = movs(r6, r2);
                r7 = movs(r7, r3);
                r1 = adds(r1, 63);
                str(r4 + 72, r6);
                str(r4 + 76, r7);
                r0 = lsrs(r2, 8);
                strb(r1, r2);
                r1 = subs(r1, 1);
                strb(r1, r0);
                r0 = lsrs(r2, 16);
                r1 = subs(r1, 1);
                strb(r1, r0);
                r1 = lsrs(r2, 24);
                r2 = movs(r2, r4);
                r2 = adds(r2, 60);
                strb(r2, r1);
                r2 = subs(r2, 1);
                strb(r2, r3);
                r1 = lsrs(r3, 8);
                r2 = subs(r2, 1);
                strb(r2, r1);
                r1 = lsrs(r3, 16);
                r2 = subs(r2, 1);
                strb(r2, r1);
                r2 = lsrs(r3, 24);
                r3 = movs(r3, r4);
                r3 = adds(r3, 56);
                strb(r3, r2);
                r1 = movs(r1, r4);
                r0 = movs(r0, r4);
                lr = sha256_final + 104 | 1;
                bl(this::sha256_transform, 104);
                return;
            case 104:
                r3 = movs(r3, 24);
            case 106:
                r2 = ldr(r4 + 80);
                r2 = lsrs(r2, r3);
                strb(r5, r2);
                r2 = ldr(r4 + 84);
                r5 = adds(r5, 1);
                r2 = lsrs(r2, r3);
                strb(r5 + 3, r2);
                r2 = ldr(r4 + 88);
                r2 = lsrs(r2, r3);
                strb(r5 + 7, r2);
                r2 = ldr(r4 + 92);
                r2 = lsrs(r2, r3);
                strb(r5 + 11, r2);
                r2 = ldr(r4 + 96);
                r2 = lsrs(r2, r3);
                strb(r5 + 15, r2);
                r2 = ldr(r4 + 100);
                r2 = lsrs(r2, r3);
                strb(r5 + 19, r2);
                r2 = ldr(r4 + 104);
                r2 = lsrs(r2, r3);
                strb(r5 + 23, r2);
                r2 = ldr(r4 + 108);
                r2 = lsrs(r2, r3);
                r3 = subs(r3, 8);
                strb(r5 + 27, r2);
                r2 = movs(r2, r3);
                r2 = adds(r2, 8);
                if (bne(null, 106)) return;
            case 164:
                pop(true, R3, R4, R5, R6, R7);
                return;
            case 166:
                strb(r4 + r3, r2);
                r3 = adds(r3, 1);
                b(null, 20);
                return;
            case 172:
                r2 = movs(r2, 0);
            case 174:
                cmp(r3, 63);
                if (bls(null, 198)) return;
            case 178:
                r1 = movs(r1, r4);
                r0 = movs(r0, r4);
                lr = sha256_final + 186 | 1;
                bl(this::sha256_transform, 186);
                return;
            case 186:
                r2 = movs(r2, 56);
                r1 = movs(r1, 0);
                r0 = movs(r0, r4);
                lr = sha256_final + 196 | 1;
                bl(this::memset, 196);
                return;
            case 196:
                b(null, 24);
                return;
            case 198:
                strb(r4 + r3, r2);
                r3 = adds(r3, 1);
                b(null, 174);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134319828, size=36, name='uhashlib_sha256_digest', path='build/extmod/moduhashlib.o', has_indirect=False)
    protected void uhashlib_sha256_digest(int offset) throws Exception
    {
        pc = uhashlib_sha256_digest + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r3, r4);
                r4 = movs(r4, r0);
                r1 = movs(r1, 32);
                r0 = mov(sp);
                lr = uhashlib_sha256_digest + 12 | 1;
                bl(this::vstr_init_len, 12);
                return;
            case 12:
                r0 = adds(r4, 4);
                r1 = ldr(sp + 8);
                lr = uhashlib_sha256_digest + 20 | 1;
                bl(this::sha256_final, 20);
                return;
            case 20:
                r1 = mov(sp);
                r0 = mp_type_bytes;
                lr = uhashlib_sha256_digest + 28 | 1;
                bl(this::mp_obj_new_str_from_vstr, 28);
                return;
            case 28:
                sp = add(sp, 16);
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134319864, size=136, name='mod_binascii_hexlify', path='build/extmod/modubinascii.o', has_indirect=False)
    protected void mod_binascii_hexlify(int offset) throws Exception
    {
        pc = mod_binascii_hexlify + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r6 = movs(r6, r1);
                sp = sub(sp, 36);
                r7 = movs(r7, r0);
                r2 = movs(r2, 1);
                r0 = ldr(r6);
                r1 = add(sp, 4);
                lr = mod_binascii_hexlify + 18 | 1;
                bl(this::mp_get_buffer_raise, 18);
                return;
            case 18:
                r3 = ldr(sp + 8);
                r0 = mp_const_empty_bytes_obj;
                cmp(r3, 0);
                if (beq(null, 74)) return;
            case 26:
                r5 = lsls(r3, 1);
                r4 = movs(r4, 0);
                cmp(r7, 1);
                if (bls(null, 46)) return;
            case 34:
                r3 = subs(r3, 1);
                r0 = ldr(r6 + 4);
                r5 = adds(r5, r3);
                lr = mod_binascii_hexlify + 44 | 1;
                bl(this::mp_obj_str_get_str, 44);
                return;
            case 44:
                r4 = movs(r4, r0);
            case 46:
                r1 = movs(r1, r5);
                r5 = movs(r5, 15);
                r0 = add(sp, 16);
                lr = mod_binascii_hexlify + 56 | 1;
                bl(this::vstr_init_len, 56);
                return;
            case 56:
                r2 = ldr(sp + 24);
                r1 = ldr(sp + 8);
                r0 = ldr(sp + 4);
            case 62:
                r1 = subs(r1, 1);
                if (bhs(null, 78)) return;
            case 66:
                r1 = add(sp, 16);
                r0 = mp_type_bytes;
                lr = mod_binascii_hexlify + 74 | 1;
                bl(this::mp_obj_new_str_from_vstr, 74);
                return;
            case 74:
                sp = add(sp, 36);
                pop(true, R4, R5, R6, R7);
                return;
            case 78:
                r3 = ldrb(r0);
                r3 = lsrs(r3, 4);
                cmp(r3, 9);
                if (bls(null, 88)) return;
            case 86:
                r3 = adds(r3, 39);
            case 88:
                r3 = adds(r3, 48);
                strb(r2, r3);
                r3 = ldrb(r0);
                r3 = ands(r3, r5);
                cmp(r3, 9);
                if (bls(null, 102)) return;
            case 100:
                r3 = adds(r3, 39);
            case 102:
                r3 = adds(r3, 48);
                r6 = adds(r2, 2);
                strb(r2 + 1, r3);
                cmp(r4, 0);
                if (beq(null, 122)) return;
            case 112:
                cmp(r1, 0);
                if (beq(null, 122)) return;
            case 116:
                r3 = ldrb(r4);
                r6 = adds(r2, 3);
                strb(r2 + 2, r3);
            case 122:
                r0 = adds(r0, 1);
                r2 = movs(r2, r6);
                b(null, 62);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134320000, size=244, name='mod_binascii_b2a_base64', path='build/extmod/modubinascii.o', has_indirect=False)
    protected void mod_binascii_b2a_base64(int offset) throws Exception
    {
        pc = mod_binascii_b2a_base64 + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                sp = sub(sp, 44);
                r1 = add(sp, 12);
                r2 = movs(r2, 1);
                lr = mod_binascii_b2a_base64 + 12 | 1;
                bl(this::mp_get_buffer_raise, 12);
                return;
            case 12:
                r0 = ldr(sp + 16);
                r1 = movs(r1, 1);
                cmp(r0, 0);
                if (beq(null, 32)) return;
            case 20:
                r1 = adds(r1, 2);
                r0 = subs(r0, 1);
                lr = mod_binascii_b2a_base64 + 28 | 1;
                bl(this::__aeabi_uidiv, 28);
                return;
            case 28:
                r1 = lsls(r0, 2);
                r1 = adds(r1, 5);
            case 32:
                r4 = movs(r4, 48);
                r5 = movs(r5, 60);
                r6 = movs(r6, 63);
                r0 = add(sp, 24);
                lr = mod_binascii_b2a_base64 + 44 | 1;
                bl(this::vstr_init_len, 44);
                return;
            case 44:
                r2 = ldr(sp + 12);
                r0 = ldr(sp + 16);
                r3 = ldr(sp + 32);
            case 50:
                cmp(r0, 2);
                if (bhi(null, 136)) return;
            case 54:
                cmp(r0, 0);
                if (beq(null, 98)) return;
            case 58:
                r4 = movs(r4, 48);
                r1 = ldrb(r2);
                r1 = lsrs(r1, 2);
                strb(r3, r1);
                r1 = ldrb(r2);
                r1 = lsls(r1, 4);
                r1 = ands(r1, r4);
                cmp(r0, 2);
                if (bne(null, 184)) return;
            case 76:
                r0 = ldrb(r2 + 1);
                r0 = lsrs(r0, 4);
                r1 = orrs(r1, r0);
                strb(r3 + 1, r1);
                r1 = movs(r1, 60);
                r2 = ldrb(r2 + 1);
                r2 = lsls(r2, 2);
                r2 = ands(r2, r1);
            case 92:
                strb(r3 + 2, r2);
                r2 = movs(r2, 64);
                strb(r3 + 3, r2);
            case 98:
                r3 = ldr(sp + 28);
                r4 = ldr(sp + 32);
                r1 = subs(r3, 1);
                r0 = movs(r0, r1);
                r2 = movs(r2, r4);
                r5 = movs(r5, 61);
                r6 = movs(r6, 47);
                r7 = movs(r7, 43);
                str(sp + 4, r3);
            case 116:
                r0 = subs(r0, 1);
                if (bhs(null, 190)) return;
            case 120:
                r3 = movs(r3, 10);
                r0 = mp_type_bytes;
                strb(r4 + r1, r3);
                r1 = add(sp, 24);
                lr = mod_binascii_b2a_base64 + 132 | 1;
                bl(this::mp_obj_new_str_from_vstr, 132);
                return;
            case 132:
                sp = add(sp, 44);
                pop(true, R4, R5, R6, R7);
                return;
            case 136:
                r1 = ldrb(r2);
                r0 = subs(r0, 3);
                r1 = lsrs(r1, 2);
                strb(r3, r1);
                r1 = ldrb(r2);
                r7 = ldrb(r2 + 1);
                r1 = lsls(r1, 4);
                r7 = lsrs(r7, 4);
                r1 = ands(r1, r4);
                r1 = orrs(r1, r7);
                strb(r3 + 1, r1);
                r1 = ldrb(r2 + 1);
                r7 = ldrb(r2 + 2);
                r1 = lsls(r1, 2);
                r1 = ands(r1, r5);
                r7 = lsrs(r7, 6);
                r1 = orrs(r1, r7);
                strb(r3 + 2, r1);
                r1 = ldrb(r2 + 2);
                r2 = adds(r2, 3);
                r1 = ands(r1, r6);
                strb(r3 + 3, r1);
                r3 = adds(r3, 4);
                b(null, 50);
                return;
            case 184:
                strb(r3 + 1, r1);
                r2 = movs(r2, 64);
                b(null, 92);
                return;
            case 190:
                r3 = ldrb(r2);
                cmp(r3, 25);
                if (bhi(null, 204)) return;
            case 196:
                r3 = adds(r3, 65);
            case 198:
                strb(r2, r3);
            case 200:
                r2 = adds(r2, 1);
                b(null, 116);
                return;
            case 204:
                cmp(r3, 51);
                if (bhi(null, 212)) return;
            case 208:
                r3 = adds(r3, 71);
                b(null, 198);
                return;
            case 212:
                cmp(r3, 61);
                if (bhi(null, 220)) return;
            case 216:
                r3 = subs(r3, 4);
                b(null, 198);
                return;
            case 220:
                cmp(r3, 62);
                if (bne(null, 228)) return;
            case 224:
                strb(r2, r7);
                b(null, 200);
                return;
            case 228:
                cmp(r3, 63);
                if (bne(null, 236)) return;
            case 232:
                strb(r2, r6);
                b(null, 200);
                return;
            case 236:
                strb(r2, r5);
                b(null, 200);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134320244, size=132, name='mod_binascii_unhexlify', path='build/extmod/modubinascii.o', has_indirect=False)
    protected void mod_binascii_unhexlify(int offset) throws Exception
    {
        pc = mod_binascii_unhexlify + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                sp = sub(sp, 44);
                r1 = add(sp, 12);
                r2 = movs(r2, 1);
                lr = mod_binascii_unhexlify + 12 | 1;
                bl(this::mp_get_buffer_raise, 12);
                return;
            case 12:
                r1 = ldr(sp + 16);
                r7 = movs(r7, 1);
                r4 = movs(r4, r1);
                r0 = mod_binascii_unhexlify_str1_1;
                r4 = ands(r4, r7);
                if (bne(null, 114)) return;
            case 24:
                r1 = lsrs(r1, 1);
                r0 = add(sp, 24);
                lr = mod_binascii_unhexlify + 32 | 1;
                bl(this::vstr_init_len, 32);
                return;
            case 32:
                r3 = ldr(sp + 12);
                r5 = ldr(sp + 16);
                r6 = ldr(sp + 32);
                str(sp, r3);
                r5 = subs(r5, 1);
                str(sp + 4, r7);
            case 44:
                r3 = adds(r5, 1);
                if (bne(null, 60)) return;
            case 48:
                r1 = add(sp, 24);
                r0 = mp_type_bytes;
                lr = mod_binascii_unhexlify + 56 | 1;
                bl(this::mp_obj_new_str_from_vstr, 56);
                return;
            case 56:
                sp = add(sp, 44);
                pop(true, R4, R5, R6, R7);
                return;
            case 60:
                r3 = ldr(sp);
                r7 = ldrb(r3);
                r0 = movs(r0, r7);
                lr = mod_binascii_unhexlify + 70 | 1;
                bl(this::unichar_isxdigit, 70);
                return;
            case 70:
                cmp(r0, 0);
                if (beq(null, 112)) return;
            case 74:
                r0 = movs(r0, r7);
                lr = mod_binascii_unhexlify + 80 | 1;
                bl(this::unichar_xdigit_value, 80);
                return;
            case 80:
                r0 = adds(r4, r0);
                r0 = uxtb(r0);
                r3 = ldr(sp + 4);
                r4 = lsls(r0, 4);
                r3 = ands(r3, r5);
                r4 = uxtb(r4);
                cmp(r3, 0);
                if (bne(null, 102)) return;
            case 96:
                r4 = movs(r4, r3);
                strb(r6, r0);
                r6 = adds(r6, 1);
            case 102:
                r3 = ldr(sp);
                r5 = subs(r5, 1);
                r3 = adds(r3, 1);
                str(sp, r3);
                b(null, 44);
                return;
            case 112:
                r0 = 0x08027132;
            case 114:
                lr = mod_binascii_unhexlify + 118 | 1;
                bl(this::mp_raise_ValueError, 118);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134320376, size=196, name='mod_binascii_a2b_base64', path='build/extmod/modubinascii.o', has_indirect=False)
    protected void mod_binascii_a2b_base64(int offset) throws Exception
    {
        pc = mod_binascii_a2b_base64 + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                sp = sub(sp, 44);
                r2 = movs(r2, 1);
                r1 = add(sp, 12);
                lr = mod_binascii_a2b_base64 + 12 | 1;
                bl(this::mp_get_buffer_raise, 12);
                return;
            case 12:
                r1 = movs(r1, 3);
                r3 = ldr(sp + 16);
                r0 = add(sp, 24);
                str(sp, r3);
                r3 = lsrs(r3, 2);
                r1 = muls(r3, r1);
                r1 = adds(r1, 1);
                r4 = ldr(sp + 12);
                lr = mod_binascii_a2b_base64 + 32 | 1;
                bl(this::vstr_init, 32);
                return;
            case 32:
                r1 = movs(r1, 0);
                r5 = movs(r5, r4);
                r2 = movs(r2, r1);
                r0 = movs(r0, r1);
                r3 = ldr(sp + 32);
                str(sp, r3);
            case 44:
                r6 = ldr(sp + 16);
                r3 = subs(r5, r4);
                str(sp + 4, r6);
                cmp(r6, r3);
                if (bhi(null, 64)) return;
            case 54:
                cmp(r2, 0);
                if (beq(null, 176)) return;
            case 58:
                r0 = mod_binascii_a2b_base64_str1_1;
                lr = mod_binascii_a2b_base64 + 64 | 1;
                bl(this::mp_raise_ValueError, 64);
                return;
            case 64:
                r3 = ldrb(r5);
                cmp(r3, 61);
                if (bne(null, 84)) return;
            case 70:
                cmp(r2, 2);
                if (beq(null, 176)) return;
            case 74:
                cmp(r2, 4);
                if (bne(null, 128)) return;
            case 78:
                cmp(r1, 0);
                if (bne(null, 176)) return;
            case 82:
                r1 = adds(r1, 1);
            case 84:
                r7 = movs(r7, r3);
                r7 = subs(r7, 65);
                r6 = uxtb(r7);
                cmp(r6, 25);
                if (bhi(null, 132)) return;
            case 94:
                r3 = movs(r3, r7);
            case 96:
                r0 = lsls(r0, 6);
                r0 = orrs(r0, r3);
                r3 = adds(r2, 6);
                cmp(r3, 7);
                if (ble(null, 172)) return;
            case 106:
                r3 = ldr(sp + 28);
                r2 = subs(r2, 2);
                r1 = adds(r3, 1);
                str(sp + 28, r1);
                r1 = movs(r1, r0);
                r1 = lsrs(r1, r2);
                r6 = ldr(sp);
                strb(r6 + r3, r1);
            case 122:
                r1 = movs(r1, 0);
            case 124:
                r5 = adds(r5, 1);
                b(null, 44);
                return;
            case 128:
                r1 = movs(r1, 1);
                b(null, 84);
                return;
            case 132:
                r7 = movs(r7, r3);
                r7 = subs(r7, 97);
                cmp(r7, 25);
                if (bhi(null, 144)) return;
            case 140:
                r3 = subs(r3, 71);
                b(null, 96);
                return;
            case 144:
                r7 = movs(r7, r3);
                r7 = subs(r7, 48);
                cmp(r7, 9);
                if (bhi(null, 156)) return;
            case 152:
                r3 = adds(r3, 4);
                b(null, 96);
                return;
            case 156:
                cmp(r3, 43);
                if (beq(null, 168)) return;
            case 160:
                cmp(r3, 47);
                if (bne(null, 124)) return;
            case 164:
                r3 = adds(r3, 16);
                b(null, 96);
                return;
            case 168:
                r3 = movs(r3, 62);
                b(null, 96);
                return;
            case 172:
                r2 = movs(r2, r3);
                b(null, 122);
                return;
            case 176:
                r1 = add(sp, 24);
                r0 = mp_type_bytes;
                lr = mod_binascii_a2b_base64 + 184 | 1;
                bl(this::mp_obj_new_str_from_vstr, 184);
                return;
            case 184:
                sp = add(sp, 44);
                pop(true, R4, R5, R6, R7);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134320572, size=50, name='mod_binascii_crc32', path='build/extmod/modubinascii.o', has_indirect=False)
    protected void mod_binascii_crc32(int offset) throws Exception
    {
        pc = mod_binascii_crc32 + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5);
                r4 = movs(r4, r1);
                sp = sub(sp, 20);
                r5 = movs(r5, r0);
                r2 = movs(r2, 1);
                r0 = ldr(r4);
                r1 = add(sp, 4);
                lr = mod_binascii_crc32 + 18 | 1;
                bl(this::mp_get_buffer_raise, 18);
                return;
            case 18:
                r0 = movs(r0, 0);
                cmp(r5, 1);
                if (bls(null, 30)) return;
            case 24:
                r0 = ldr(r4 + 4);
                lr = mod_binascii_crc32 + 30 | 1;
                bl(this::mp_obj_get_int_truncated, 30);
                return;
            case 30:
                r2 = mvns(r2, r0);
                r1 = ldr(sp + 8);
                r0 = ldr(sp + 4);
                lr = mod_binascii_crc32 + 40 | 1;
                bl(this::uzlib_crc32, 40);
                return;
            case 40:
                r0 = mvns(r0, r0);
                lr = mod_binascii_crc32 + 46 | 1;
                bl(this::mp_obj_new_int_from_uint, 46);
                return;
            case 46:
                sp = add(sp, 20);
                pop(true, R4, R5);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134320624, size=40, name='machine_mem_get_addr', path='build/extmod/machine_mem.o', has_indirect=False)
    protected void machine_mem_get_addr(int offset) throws Exception
    {
        pc = machine_mem_get_addr + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r4 = movs(r4, r1);
                lr = machine_mem_get_addr + 8 | 1;
                bl(this::mp_obj_int_get_truncated, 8);
                return;
            case 8:
                r3 = subs(r4, 1);
                tst(r0, r3);
                if (beq(null, 30)) return;
            case 14:
                r2 = movs(r2, r0);
                r3 = movs(r3, r4);
                r1 = machine_mem_get_addr_str1_1;
                r0 = mp_type_ValueError;
                lr = machine_mem_get_addr + 26 | 1;
                bl(this::mp_obj_new_exception_msg_varg, 26);
                return;
            case 26:
                lr = machine_mem_get_addr + 30 | 1;
                bl(this::nlr_jump, 30);
                return;
            case 30:
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134320664, size=20, name='machine_mem_print', path='build/extmod/machine_mem.o', has_indirect=False)
    protected void machine_mem_print(int offset) throws Exception
    {
        pc = machine_mem_print + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r2 = ldr(r1 + 4);
                r1 = machine_mem_print_str1_1;
                r2 = lsls(r2, 3);
                lr = machine_mem_print + 12 | 1;
                bl(this::mp_printf, 12);
                return;
            case 12:
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134320684, size=92, name='machine_mem_subscr', path='build/extmod/machine_mem.o', has_indirect=False)
    protected void machine_mem_subscr(int offset) throws Exception
    {
        pc = machine_mem_subscr + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r3 = movs(r3, r1);
                r6 = movs(r6, r0);
                r4 = movs(r4, r2);
                r0 = subs(r2, 0);
                if (beq(null, 44)) return;
            case 12:
                r1 = ldr(r6 + 4);
                r0 = movs(r0, r3);
                cmp(r2, 4);
                if (bne(null, 50)) return;
            case 20:
                lr = machine_mem_subscr + 24 | 1;
                bl(this::machine_mem_get_addr, 24);
                return;
            case 24:
                r3 = ldr(r6 + 4);
                cmp(r3, 1);
                if (beq(null, 38)) return;
            case 30:
                cmp(r3, 2);
                if (beq(null, 46)) return;
            case 34:
                r0 = ldr(r0);
                b(null, 40);
                return;
            case 38:
                r0 = ldrb(r0);
            case 40:
                lr = machine_mem_subscr + 44 | 1;
                bl(this::mp_obj_new_int, 44);
                return;
            case 44:
                pop(true, R4, R5, R6);
                return;
            case 46:
                r0 = ldrh(r0);
                b(null, 40);
                return;
            case 50:
                lr = machine_mem_subscr + 54 | 1;
                bl(this::machine_mem_get_addr, 54);
                return;
            case 54:
                r5 = movs(r5, r0);
                r0 = movs(r0, r4);
                lr = machine_mem_subscr + 62 | 1;
                bl(this::mp_obj_get_int_truncated, 62);
                return;
            case 62:
                r2 = ldr(r6 + 4);
                r3 = movs(r3, r0);
                r0 = mp_const_none_obj;
                cmp(r2, 1);
                if (beq(null, 80)) return;
            case 72:
                cmp(r2, 2);
                if (beq(null, 84)) return;
            case 76:
                str(r5, r3);
                b(null, 44);
                return;
            case 80:
                strb(r5, r3);
                b(null, 44);
                return;
            case 84:
                strh(r5, r3);
                b(null, 44);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134320776, size=96, name='yasmarang', path='build/extmod/modurandom.o', has_indirect=False)
    protected void yasmarang(int offset) throws Exception
    {
        assert offset == 0;
        pc = yasmarang + offset;
        r3 = yasmarang_d;
        r0 = yasmarang_n;
        push(true, r4, r5, r6, r7);
        r12 = mov(r3);
        r6 = ldr(r3);
        r3 = ldr(r0);
        r4 = yasmarang_dat;
        r3 = muls(r6, r3);
        r7 = yasmarang_pad;
        r5 = ldrb(r4);
        r2 = ldr(r7);
        r3 = adds(r3, r5);
        r3 = adds(r3, r2);
        r1 = movs(r1, 29);
        r2 = movs(r2, r3);
        r2 = rors(r2, r1);
        str(r7, r2);
        r7 = movs(r7, 2);
        r7 = orrs(r7, r2);
        str(r0, r7);
        r0 = movs(r0, 30);
        r3 = rors(r3, r0);
        r1 = movs(r1, r2);
        r2 = mov(r12);
        r3 = eors(r3, r6);
        str(r2, r3);
        r2 = movs(r2, 1);
        r2 = eors(r2, r5);
        r0 = lsrs(r3, 8);
        r2 = eors(r2, r1);
        r2 = eors(r2, r0);
        r0 = lsrs(r1, 18);
        r2 = uxtb(r2);
        r0 = eors(r0, r1);
        r3 = lsls(r3, 5);
        strb(r4, r2);
        r0 = eors(r0, r3);
        r2 = lsls(r2, 1);
        r0 = eors(r0, r2);
        pop(true, R4, R5, R6, R7);
    }

    // function: Function(address=134320872, size=34, name='yasmarang_randbelow', path='build/extmod/modurandom.o', has_indirect=False)
    protected void yasmarang_randbelow(int offset) throws Exception
    {
        pc = yasmarang_randbelow + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r4 = movs(r4, 1);
                r5 = movs(r5, r0);
                r2 = movs(r2, r4);
            case 8:
                r3 = movs(r3, r5);
                r3 = ands(r3, r4);
                cmp(r3, r5);
                if (blo(null, 28)) return;
            case 16:
                lr = yasmarang_randbelow + 20 | 1;
                bl(this::yasmarang, 20);
                return;
            case 20:
                r0 = ands(r0, r4);
                cmp(r5, r0);
                if (bls(null, 16)) return;
            case 26:
                pop(true, R4, R5, R6);
                return;
            case 28:
                r4 = lsls(r4, 1);
                r4 = orrs(r4, r2);
                b(null, 8);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134320906, size=66, name='mod_urandom_uniform', path='build/extmod/modurandom.o', has_indirect=False)
    protected void mod_urandom_uniform(int offset) throws Exception
    {
        pc = mod_urandom_uniform + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r5 = movs(r5, r1);
                lr = mod_urandom_uniform + 8 | 1;
                bl(this::mp_obj_get_float, 8);
                return;
            case 8:
                r4 = adds(r0, 0);
                r0 = movs(r0, r5);
                lr = mod_urandom_uniform + 16 | 1;
                bl(this::mp_obj_get_float, 16);
                return;
            case 16:
                r1 = adds(r4, 0);
                lr = mod_urandom_uniform + 22 | 1;
                bl(this::__aeabi_fsub, 22);
                return;
            case 22:
                r5 = adds(r0, 0);
                lr = mod_urandom_uniform + 28 | 1;
                bl(this::yasmarang, 28);
                return;
            case 28:
                r3 = movs(r3, 254);
                r1 = movs(r1, 254);
                r0 = lsls(r0, 9);
                r3 = lsls(r3, 22);
                r0 = lsrs(r0, 9);
                r0 = orrs(r0, r3);
                r1 = lsls(r1, 22);
                lr = mod_urandom_uniform + 46 | 1;
                bl(this::__aeabi_fsub, 46);
                return;
            case 46:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                lr = mod_urandom_uniform + 54 | 1;
                bl(this::__aeabi_fmul, 54);
                return;
            case 54:
                r1 = adds(r4, 0);
                lr = mod_urandom_uniform + 60 | 1;
                bl(this::__aeabi_fadd, 60);
                return;
            case 60:
                lr = mod_urandom_uniform + 64 | 1;
                bl(this::mp_obj_new_float, 64);
                return;
            case 64:
                pop(true, R4, R5, R6);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134320972, size=42, name='mod_urandom_randint', path='build/extmod/modurandom.o', has_indirect=False)
    protected void mod_urandom_randint(int offset) throws Exception
    {
        pc = mod_urandom_randint + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r5 = movs(r5, r1);
                lr = mod_urandom_randint + 8 | 1;
                bl(this::mp_obj_get_int, 8);
                return;
            case 8:
                r4 = movs(r4, r0);
                r0 = movs(r0, r5);
                lr = mod_urandom_randint + 16 | 1;
                bl(this::mp_obj_get_int, 16);
                return;
            case 16:
                cmp(r4, r0);
                if (ble(null, 26)) return;
            case 20:
                r0 = movs(r0, 0);
                lr = mod_urandom_randint + 26 | 1;
                bl(this::mp_raise_ValueError, 26);
                return;
            case 26:
                r0 = subs(r0, r4);
                r0 = adds(r0, 1);
                lr = mod_urandom_randint + 34 | 1;
                bl(this::yasmarang_randbelow, 34);
                return;
            case 34:
                r0 = adds(r4, r0);
                lr = mod_urandom_randint + 40 | 1;
                bl(this::mp_obj_new_int, 40);
                return;
            case 40:
                pop(true, R4, R5, R6);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134321014, size=106, name='mod_urandom_randrange', path='build/extmod/modurandom.o', has_indirect=False)
    protected void mod_urandom_randrange(int offset) throws Exception
    {
        pc = mod_urandom_randrange + offset;
        switch (offset)
        {
            case 0:
                push(true, r3, r4, r5, r6, r7);
                r7 = movs(r7, r0);
                r0 = ldr(r1);
                r5 = movs(r5, r1);
                lr = mod_urandom_randrange + 12 | 1;
                bl(this::mp_obj_get_int, 12);
                return;
            case 12:
                r6 = movs(r6, r0);
                cmp(r7, 1);
                if (bne(null, 32)) return;
            case 18:
                cmp(r0, 0);
                if (ble(null, 100)) return;
            case 22:
                lr = mod_urandom_randrange + 26 | 1;
                bl(this::yasmarang_randbelow, 26);
                return;
            case 26:
                lr = mod_urandom_randrange + 30 | 1;
                bl(this::mp_obj_new_int, 30);
                return;
            case 30:
                pop(true, R3, R4, R5, R6, R7);
                return;
            case 32:
                r0 = ldr(r5 + 4);
                lr = mod_urandom_randrange + 38 | 1;
                bl(this::mp_obj_get_int, 38);
                return;
            case 38:
                r4 = subs(r0, r6);
                cmp(r7, 2);
                if (bne(null, 58)) return;
            case 44:
                cmp(r6, r0);
                if (bge(null, 100)) return;
            case 48:
                r0 = movs(r0, r4);
                lr = mod_urandom_randrange + 54 | 1;
                bl(this::yasmarang_randbelow, 54);
                return;
            case 54:
                r0 = adds(r0, r6);
                b(null, 26);
                return;
            case 58:
                r0 = ldr(r5 + 8);
                lr = mod_urandom_randrange + 64 | 1;
                bl(this::mp_obj_get_int, 64);
                return;
            case 64:
                r5 = subs(r0, 0);
                if (ble(null, 90)) return;
            case 68:
                r0 = adds(r4, r0);
                r0 = subs(r0, 1);
            case 72:
                r1 = movs(r1, r5);
                lr = mod_urandom_randrange + 78 | 1;
                bl(this::__divsi3, 78);
                return;
            case 78:
                cmp(r0, 0);
                if (ble(null, 100)) return;
            case 82:
                lr = mod_urandom_randrange + 86 | 1;
                bl(this::yasmarang_randbelow, 86);
                return;
            case 86:
                r0 = muls(r5, r0);
                b(null, 54);
                return;
            case 90:
                cmp(r0, 0);
                if (beq(null, 100)) return;
            case 94:
                r0 = adds(r4, r0);
                r0 = adds(r0, 1);
                b(null, 72);
                return;
            case 100:
                r0 = movs(r0, 0);
                lr = mod_urandom_randrange + 106 | 1;
                bl(this::mp_raise_ValueError, 106);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134321120, size=52, name='mod_urandom_seed', path='build/extmod/modurandom.o', has_indirect=False)
    protected void mod_urandom_seed(int offset) throws Exception
    {
        pc = mod_urandom_seed + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                lr = mod_urandom_seed + 6 | 1;
                bl(this::mp_obj_get_int_truncated, 6);
                return;
            case 6:
                r2 = movs(r2, 69);
                r3 = yasmarang_pad;
                str(r3, r0);
                r3 = yasmarang_n;
                r0 = mp_const_none_obj;
                str(r3, r2);
                r3 = yasmarang_d;
                r2 = adds(r2, 164);
                str(r3, r2);
                r2 = movs(r2, 0);
                r3 = yasmarang_dat;
                strb(r3, r2);
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134321172, size=44, name='mod_urandom_getrandbits', path='build/extmod/modurandom.o', has_indirect=False)
    protected void mod_urandom_getrandbits(int offset) throws Exception
    {
        pc = mod_urandom_getrandbits + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                lr = mod_urandom_getrandbits + 6 | 1;
                bl(this::mp_obj_get_int, 6);
                return;
            case 6:
                r4 = movs(r4, r0);
                cmp(r0, 32);
                if (bgt(null, 16)) return;
            case 12:
                cmp(r0, 0);
                if (bne(null, 22)) return;
            case 16:
                r0 = movs(r0, 0);
                lr = mod_urandom_getrandbits + 22 | 1;
                bl(this::mp_raise_ValueError, 22);
                return;
            case 22:
                lr = mod_urandom_getrandbits + 26 | 1;
                bl(this::yasmarang, 26);
                return;
            case 26:
                r2 = movs(r2, 32);
                r3 = movs(r3, 1);
                r2 = subs(r2, r4);
                r3 = rsbs(r3, 0);
                r3 = lsrs(r3, r2);
                r0 = ands(r0, r3);
                lr = mod_urandom_getrandbits + 42 | 1;
                bl(this::mp_obj_new_int_from_uint, 42);
                return;
            case 42:
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134321216, size=52, name='mod_urandom_choice', path='build/extmod/modurandom.o', has_indirect=False)
    protected void mod_urandom_choice(int offset) throws Exception
    {
        pc = mod_urandom_choice + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r4 = movs(r4, r0);
                lr = mod_urandom_choice + 8 | 1;
                bl(this::mp_obj_len, 8);
                return;
            case 8:
                lr = mod_urandom_choice + 12 | 1;
                bl(this::mp_obj_get_int, 12);
                return;
            case 12:
                cmp(r0, 0);
                if (bgt(null, 26)) return;
            case 16:
                r0 = mp_type_IndexError;
                lr = mod_urandom_choice + 22 | 1;
                bl(this::mp_obj_new_exception, 22);
                return;
            case 22:
                lr = mod_urandom_choice + 26 | 1;
                bl(this::nlr_jump, 26);
                return;
            case 26:
                lr = mod_urandom_choice + 30 | 1;
                bl(this::yasmarang_randbelow, 30);
                return;
            case 30:
                lr = mod_urandom_choice + 34 | 1;
                bl(this::mp_obj_new_int, 34);
                return;
            case 34:
                r2 = movs(r2, 4);
                r1 = movs(r1, r0);
                r0 = movs(r0, r4);
                lr = mod_urandom_choice + 44 | 1;
                bl(this::mp_obj_subscr, 44);
                return;
            case 44:
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134321268, size=30, name='mod_urandom_random', path='build/extmod/modurandom.o', has_indirect=False)
    protected void mod_urandom_random(int offset) throws Exception
    {
        pc = mod_urandom_random + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                lr = mod_urandom_random + 6 | 1;
                bl(this::yasmarang, 6);
                return;
            case 6:
                r3 = movs(r3, 254);
                r1 = movs(r1, 254);
                r0 = lsls(r0, 9);
                r3 = lsls(r3, 22);
                r0 = lsrs(r0, 9);
                r0 = orrs(r0, r3);
                r1 = lsls(r1, 22);
                lr = mod_urandom_random + 24 | 1;
                bl(this::__aeabi_fsub, 24);
                return;
            case 24:
                lr = mod_urandom_random + 28 | 1;
                bl(this::mp_obj_new_float, 28);
                return;
            case 28:
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134321298, size=62, name='mp_vfs_proxy_call', path='build/extmod/vfs.o', has_indirect=False)
    protected void mp_vfs_proxy_call(int offset) throws Exception
    {
        pc = mp_vfs_proxy_call + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5);
                r4 = movs(r4, r2);
                sp = sub(sp, 20);
                r5 = movs(r5, r3);
                cmp(r0, 1);
                if (bne(null, 18)) return;
            case 12:
                r0 = adds(r0, 18);
            case 14:
                lr = mp_vfs_proxy_call + 18 | 1;
                bl(this::mp_raise_OSError, 18);
                return;
            case 18:
                cmp(r0, 0);
                if (bne(null, 26)) return;
            case 22:
                r0 = adds(r0, 1);
                b(null, 14);
                return;
            case 26:
                r2 = mov(sp);
                r0 = ldr(r0 + 8);
                lr = mp_vfs_proxy_call + 34 | 1;
                bl(this::mp_load_method, 34);
                return;
            case 34:
                cmp(r5, 0);
                if (beq(null, 48)) return;
            case 38:
                r2 = lsls(r4, 2);
                r1 = movs(r1, r5);
                r0 = add(sp, 8);
                lr = mp_vfs_proxy_call + 48 | 1;
                bl(this::memcpy, 48);
                return;
            case 48:
                r2 = mov(sp);
                r1 = movs(r1, 0);
                r0 = movs(r0, r4);
                lr = mp_vfs_proxy_call + 58 | 1;
                bl(this::mp_call_method_n_kw, 58);
                return;
            case 58:
                sp = add(sp, 20);
                pop(true, R4, R5);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134321360, size=160, name='mp_vfs_umount', path='build/extmod/vfs.o', has_indirect=False)
    protected void mp_vfs_umount(int offset) throws Exception
    {
        pc = mp_vfs_umount + offset;
        switch (offset)
        {
            case 0:
                r3 = movs(r3, 3);
                push(true, r4, r5, r6, r7);
                r3 = ands(r3, r0);
                sp = sub(sp, 20);
                r5 = movs(r5, r0);
                cmp(r3, 2);
                if (beq(null, 28)) return;
            case 14:
                r7 = movs(r7, 0);
                cmp(r3, r7);
                if (bne(null, 38)) return;
            case 20:
                r3 = mp_type_str;
                r2 = ldr(r0);
                cmp(r2, r3);
                if (bne(null, 38)) return;
            case 28:
                r1 = add(sp, 12);
                r0 = movs(r0, r5);
                lr = mp_vfs_umount + 36 | 1;
                bl(this::mp_obj_str_get_data, 36);
                return;
            case 36:
                r7 = movs(r7, r0);
            case 38:
                r3 = movs(r3, 234);
                r6 = mp_state_ctx;
                r3 = lsls(r3, 1);
                r4 = ldr(r6 + r3);
                r3 = ldr(sp + 12);
                r3 = adds(r3, 1);
                str(sp + 4, r3);
                r3 = 0x20009e58;
                str(sp, r3);
            case 56:
                cmp(r4, 0);
                if (bne(null, 66)) return;
            case 60:
                r0 = movs(r0, 22);
                lr = mp_vfs_umount + 66 | 1;
                bl(this::mp_raise_OSError, 66);
                return;
            case 66:
                cmp(r7, 0);
                if (beq(null, 84)) return;
            case 70:
                r2 = ldr(sp + 4);
                r1 = ldr(r4);
                r0 = movs(r0, r7);
                lr = mp_vfs_umount + 80 | 1;
                bl(this::memcmp, 80);
                return;
            case 80:
                cmp(r0, 0);
                if (beq(null, 92)) return;
            case 84:
                r2 = ldr(r4 + 8);
                r3 = ldr(r4 + 12);
                cmp(r2, r5);
                if (bne(null, 130)) return;
            case 92:
                r3 = ldr(sp);
                r2 = ldr(r4 + 12);
                str(r3, r2);
                r3 = movs(r3, 232);
                r3 = lsls(r3, 1);
                r2 = ldr(r6 + r3);
                cmp(r4, r2);
                if (bne(null, 112)) return;
            case 108:
                r2 = movs(r2, 0);
                str(r6 + r3, r2);
            case 112:
                r3 = movs(r3, 0);
                r1 = 0x0000021b;
                r2 = movs(r2, r3);
                r0 = movs(r0, r4);
                lr = mp_vfs_umount + 124 | 1;
                bl(this::mp_vfs_proxy_call, 124);
                return;
            case 124:
                r0 = mp_const_none_obj;
                sp = add(sp, 20);
                pop(true, R4, R5, R6, R7);
                return;
            case 130:
                r4 = adds(r4, 12);
                str(sp, r4);
                r4 = movs(r4, r3);
                b(null, 56);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134321520, size=116, name='mp_vfs_getcwd', path='build/extmod/vfs.o', has_indirect=False)
    protected void mp_vfs_getcwd(int offset) throws Exception
    {
        pc = mp_vfs_getcwd + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r3, r4, r5, r6);
                r5 = movs(r5, 232);
                r6 = mp_state_ctx;
                r5 = lsls(r5, 1);
                r0 = ldr(r6 + r5);
                cmp(r0, 0);
                if (beq(null, 100)) return;
            case 14:
                r3 = movs(r3, 0);
                r1 = movs(r1, 158);
                r2 = movs(r2, r3);
                r1 = lsls(r1, 1);
                lr = mp_vfs_getcwd + 26 | 1;
                bl(this::mp_vfs_proxy_call, 26);
                return;
            case 26:
                r3 = ldr(r6 + r5);
                r3 = ldr(r3 + 4);
                cmp(r3, 1);
                if (beq(null, 96)) return;
            case 34:
                lr = mp_vfs_getcwd + 38 | 1;
                bl(this::mp_obj_str_get_str, 38);
                return;
            case 38:
                r4 = movs(r4, r0);
                lr = mp_vfs_getcwd + 44 | 1;
                bl(this::strlen, 44);
                return;
            case 44:
                r3 = ldr(r6 + r5);
                r1 = ldr(r3 + 4);
                r1 = adds(r1, 1);
                r1 = adds(r1, r0);
                r0 = mov(sp);
                lr = mp_vfs_getcwd + 58 | 1;
                bl(this::vstr_init, 58);
                return;
            case 58:
                r3 = ldr(r6 + r5);
                r0 = mov(sp);
                r3 = ldm(r3, R1, R2);
                lr = mp_vfs_getcwd + 68 | 1;
                bl(this::vstr_add_strn, 68);
                return;
            case 68:
                r3 = ldrb(r4);
                cmp(r3, 47);
                if (bne(null, 80)) return;
            case 74:
                r3 = ldrb(r4 + 1);
                cmp(r3, 0);
                if (beq(null, 88)) return;
            case 80:
                r1 = movs(r1, r4);
                r0 = mov(sp);
                lr = mp_vfs_getcwd + 88 | 1;
                bl(this::vstr_add_str, 88);
                return;
            case 88:
                r1 = mov(sp);
                r0 = mp_type_str;
                lr = mp_vfs_getcwd + 96 | 1;
                bl(this::mp_obj_new_str_from_vstr, 96);
                return;
            case 96:
                sp = add(sp, 16);
                pop(true, R4, R5, R6);
                return;
            case 100:
                r0 = movs(r0, 187);
                r0 = lsls(r0, 1);
                b(null, 96);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134321636, size=112, name='mp_vfs_ilistdir_it_iternext', path='build/extmod/vfs.o', has_indirect=True)
    protected void mp_vfs_ilistdir_it_iternext(int offset) throws Exception
    {
        pc = mp_vfs_ilistdir_it_iternext + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r4, r5, r6);
                r4 = ldr(r0 + 8);
                r1 = ldrb(r0 + 13);
                r6 = movs(r6, r0);
                r0 = movs(r0, r4);
                cmp(r1, 0);
                if (bne(null, 48)) return;
            case 14:
                r5 = subs(r4, 0);
                if (beq(null, 54)) return;
            case 18:
                r3 = ldr(r4 + 12);
                r2 = ldr(r4 + 4);
                str(r6 + 8, r3);
                cmp(r2, 1);
                if (bne(null, 58)) return;
            case 28:
                r3 = movs(r3, 187);
                r1 = movs(r1, 168);
                r3 = lsls(r3, 1);
                str(sp + 4, r3);
                strb(r6 + 13, r2);
                r3 = add(sp, 4);
                r1 = lsls(r1, 1);
                lr = mp_vfs_ilistdir_it_iternext + 46 | 1;
                bl(this::mp_vfs_proxy_call, 46);
                return;
            case 46:
                str(r6 + 8, r0);
            case 48:
                lr = mp_vfs_ilistdir_it_iternext + 52 | 1;
                bl(this::mp_iternext, 52);
                return;
            case 52:
                r5 = movs(r5, r0);
            case 54:
                r0 = movs(r0, r5);
                pop(true, R1, R2, R4, R5, R6);
                return;
            case 58:
                r0 = movs(r0, 3);
                lr = mp_vfs_ilistdir_it_iternext + 64 | 1;
                bl(this::mp_obj_new_tuple, 64);
                return;
            case 64:
                r3 = ldrb(r6 + 12);
                r5 = movs(r5, r0);
                r0 = mp_type_bytes;
                cmp(r3, 0);
                if (beq(null, 76)) return;
            case 74:
                r0 = mp_type_str;
            case 76:
                r3 = ldr(r4 + 4);
                r1 = ldr(r4);
                r2 = subs(r3, 1);
                r1 = adds(r1, 1);
                lr = mp_vfs_ilistdir_it_iternext + 88 | 1;
                bl(this::mp_obj_new_str_of_type, 88);
                return;
            case 88:
                r3 = 0x00008001;
                str(r5 + 8, r0);
                str(r5 + 12, r3);
                r3 = movs(r3, 1);
                str(r5 + 16, r3);
                b(null, 54);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134321748, size=140, name='mp_vfs_lookup_path', path='build/extmod/vfs.o', has_indirect=False)
    protected void mp_vfs_lookup_path(int offset) throws Exception
    {
        pc = mp_vfs_lookup_path + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r4, r5, r6, r7);
                r3 = ldrb(r0);
                r4 = movs(r4, r0);
                r7 = movs(r7, r1);
                cmp(r3, 47);
                if (beq(null, 64)) return;
            case 12:
                r3 = movs(r3, 232);
                r2 = mp_state_ctx;
                r3 = lsls(r3, 1);
                r3 = ldr(r2 + r3);
                cmp(r3, 0);
                if (bne(null, 52)) return;
            case 24:
                str(sp + 4, r3);
                r3 = ldrb(r4);
                r5 = subs(r3, 0);
                if (beq(null, 84)) return;
            case 32:
                r3 = movs(r3, 234);
                r2 = mp_state_ctx;
                r3 = lsls(r3, 1);
                r5 = ldr(r2 + r3);
            case 40:
                cmp(r5, 0);
                if (bne(null, 70)) return;
            case 44:
                r3 = ldr(sp + 4);
                r5 = adds(r5, 1);
                cmp(r3, 0);
                if (bne(null, 84)) return;
            case 52:
                r3 = movs(r3, 232);
                r2 = mp_state_ctx;
                r3 = lsls(r3, 1);
                str(r7, r4);
                r5 = ldr(r2 + r3);
                b(null, 84);
                return;
            case 64:
                r4 = adds(r4, 1);
                r3 = movs(r3, 1);
                b(null, 24);
                return;
            case 70:
                r3 = ldr(r5 + 4);
                r6 = subs(r3, 1);
                cmp(r6, 0);
                if (bne(null, 88)) return;
            case 78:
                r3 = ldr(sp + 4);
                r4 = subs(r4, r3);
                str(r7, r4);
            case 84:
                r0 = movs(r0, r5);
                pop(true, R1, R2, R3, R4, R5, R6, R7);
                return;
            case 88:
                r3 = ldr(r5);
                r2 = movs(r2, r6);
                r1 = adds(r3, 1);
                r0 = movs(r0, r4);
                lr = mp_vfs_lookup_path + 100 | 1;
                bl(this::strncmp, 100);
                return;
            case 100:
                cmp(r0, 0);
                if (bne(null, 126)) return;
            case 104:
                r6 = adds(r4, r6);
                r3 = ldrb(r6);
                cmp(r3, 47);
                if (bne(null, 116)) return;
            case 112:
                str(r7, r6);
                b(null, 84);
                return;
            case 116:
                cmp(r3, 0);
                if (bne(null, 126)) return;
            case 120:
                r3 = 0x0802069b;
                str(r7, r3);
                b(null, 84);
                return;
            case 126:
                r5 = ldr(r5 + 12);
                b(null, 40);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134321888, size=156, name='mp_vfs_mount', path='build/extmod/vfs.o', has_indirect=False)
    protected void mp_vfs_mount(int offset) throws Exception
    {
        pc = mp_vfs_mount + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r5 = movs(r5, r1);
                sp = sub(sp, 44);
                r3 = allowed_args_6655;
                r6 = add(sp, 24);
                r1 = adds(r1, 8);
                r0 = subs(r0, 2);
                str(sp, r3);
                str(sp + 4, r6);
                r3 = movs(r3, 2);
                lr = mp_vfs_mount + 24 | 1;
                bl(this::mp_arg_parse_all, 24);
                return;
            case 24:
                r1 = add(sp, 16);
                r0 = ldr(r5 + 4);
                lr = mp_vfs_mount + 32 | 1;
                bl(this::mp_obj_str_get_data, 32);
                return;
            case 32:
                r1 = movs(r1, 205);
                r7 = ldr(r5);
                r2 = add(sp, 32);
                r1 = lsls(r1, 1);
                str(sp + 12, r0);
                r0 = movs(r0, r7);
                lr = mp_vfs_mount + 48 | 1;
                bl(this::mp_load_method_maybe, 48);
                return;
            case 48:
                r0 = movs(r0, 16);
                lr = mp_vfs_mount + 54 | 1;
                bl(this::m_malloc, 54);
                return;
            case 54:
                r3 = ldr(sp + 12);
                r1 = movs(r1, 205);
                str(r0, r3);
                r3 = ldr(sp + 16);
                r2 = movs(r2, 2);
                str(r0 + 4, r3);
                r3 = movs(r3, 0);
                r1 = lsls(r1, 1);
                str(r0 + 12, r3);
                str(r0 + 8, r7);
                r3 = movs(r3, r6);
                r4 = movs(r4, r0);
                lr = mp_vfs_mount + 82 | 1;
                bl(this::mp_vfs_proxy_call, 82);
                return;
            case 82:
                r0 = ldr(r5 + 4);
                lr = mp_vfs_mount + 88 | 1;
                bl(this::mp_obj_str_get_str, 88);
                return;
            case 88:
                r1 = add(sp, 20);
                lr = mp_vfs_mount + 94 | 1;
                bl(this::mp_vfs_lookup_path, 94);
                return;
            case 94:
                r3 = 0x20009e58;
                cmp(r0, 1);
                if (bls(null, 122)) return;
            case 100:
                r2 = ldr(r4 + 4);
                cmp(r2, 1);
                if (beq(null, 112)) return;
            case 106:
                r2 = ldr(r0 + 4);
                cmp(r2, 1);
                if (beq(null, 122)) return;
            case 112:
                r0 = movs(r0, 1);
                lr = mp_vfs_mount + 118 | 1;
                bl(this::mp_raise_OSError, 118);
                return;
            case 118:
                r3 = movs(r3, r2);
                r3 = adds(r3, 12);
            case 122:
                r2 = ldr(r3);
                cmp(r2, 0);
                if (beq(null, 136)) return;
            case 128:
                r1 = ldr(r2 + 4);
                cmp(r1, 1);
                if (bne(null, 118)) return;
            case 134:
                str(r4 + 12, r2);
            case 136:
                r0 = mp_const_none_obj;
                str(r3, r4);
                sp = add(sp, 44);
                pop(true, R4, R5, R6, R7);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134322044, size=54, name='lookup_path', path='build/extmod/vfs.o', has_indirect=False)
    protected void lookup_path(int offset) throws Exception
    {
        pc = lookup_path + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r4, r5, r6, r7);
                r6 = movs(r6, r1);
                r5 = movs(r5, r0);
                lr = lookup_path + 10 | 1;
                bl(this::mp_obj_str_get_str, 10);
                return;
            case 10:
                r1 = add(sp, 4);
                lr = lookup_path + 16 | 1;
                bl(this::mp_vfs_lookup_path, 16);
                return;
            case 16:
                r4 = movs(r4, r0);
                cmp(r0, 1);
                if (bls(null, 50)) return;
            case 22:
                r0 = movs(r0, r5);
                lr = lookup_path + 28 | 1;
                bl(this::mp_obj_get_type, 28);
                return;
            case 28:
                r5 = ldr(sp + 4);
                r7 = movs(r7, r0);
                r0 = movs(r0, r5);
                lr = lookup_path + 38 | 1;
                bl(this::strlen, 38);
                return;
            case 38:
                r1 = movs(r1, r5);
                r2 = movs(r2, r0);
                r0 = movs(r0, r7);
                lr = lookup_path + 48 | 1;
                bl(this::mp_obj_new_str_of_type, 48);
                return;
            case 48:
                str(r6, r0);
            case 50:
                r0 = movs(r0, r4);
                pop(true, R1, R2, R3, R4, R5, R6, R7);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134322100, size=48, name='mp_vfs_open', path='build/extmod/vfs.o', has_indirect=False)
    protected void mp_vfs_open(int offset) throws Exception
    {
        pc = mp_vfs_open + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r3 = allowed_args_6689;
                sp = sub(sp, 24);
                r4 = add(sp, 8);
                str(sp, r3);
                str(sp + 4, r4);
                r3 = movs(r3, 4);
                lr = mp_vfs_open + 18 | 1;
                bl(this::mp_arg_parse_all, 18);
                return;
            case 18:
                r1 = movs(r1, r4);
                r0 = ldr(sp + 8);
                lr = mp_vfs_open + 26 | 1;
                bl(this::lookup_path, 26);
                return;
            case 26:
                r1 = movs(r1, 209);
                r3 = movs(r3, r4);
                r2 = movs(r2, 2);
                r1 = lsls(r1, 1);
                lr = mp_vfs_open + 38 | 1;
                bl(this::mp_vfs_proxy_call, 38);
                return;
            case 38:
                sp = add(sp, 24);
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134322148, size=72, name='mp_vfs_chdir', path='build/extmod/vfs.o', has_indirect=False)
    protected void mp_vfs_chdir(int offset) throws Exception
    {
        pc = mp_vfs_chdir + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2);
                r1 = mov(sp);
                lr = mp_vfs_chdir + 8 | 1;
                bl(this::lookup_path, 8);
                return;
            case 8:
                r2 = movs(r2, 232);
                r3 = mp_state_ctx;
                r2 = lsls(r2, 1);
                str(r3 + r2, r0);
                cmp(r0, 0);
                if (bne(null, 58)) return;
            case 20:
                r2 = adds(r2, 4);
                r0 = ldr(r3 + r2);
            case 24:
                cmp(r0, 0);
                if (bne(null, 32)) return;
            case 28:
                r0 = mp_const_none_obj;
                pop(true, R1, R2, R3);
                return;
            case 32:
                r2 = ldr(r0 + 4);
                cmp(r2, 1);
                if (bne(null, 54)) return;
            case 38:
                r3 = movs(r3, 187);
                r3 = lsls(r3, 1);
                str(sp + 4, r3);
                r3 = add(sp, 4);
            case 46:
                r1 = movs(r1, 235);
                lr = mp_vfs_chdir + 52 | 1;
                bl(this::mp_vfs_proxy_call, 52);
                return;
            case 52:
                b(null, 28);
                return;
            case 54:
                r0 = ldr(r0 + 12);
                b(null, 24);
                return;
            case 58:
                r3 = mov(sp);
                r2 = movs(r2, 1);
                b(null, 46);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134322220, size=104, name='mp_vfs_ilistdir', path='build/extmod/vfs.o', has_indirect=False)
    protected void mp_vfs_ilistdir(int offset) throws Exception
    {
        pc = mp_vfs_ilistdir + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r4, r5, r6);
                r6 = movs(r6, 6);
                cmp(r0, 1);
                if (bne(null, 10)) return;
            case 8:
                r6 = ldr(r1);
            case 10:
                r1 = add(sp, 4);
                r0 = movs(r0, r6);
                lr = mp_vfs_ilistdir + 18 | 1;
                bl(this::lookup_path, 18);
                return;
            case 18:
                r5 = subs(r0, 0);
                if (bne(null, 70)) return;
            case 22:
                r0 = movs(r0, 16);
                lr = mp_vfs_ilistdir + 28 | 1;
                bl(this::m_malloc, 28);
                return;
            case 28:
                r3 = mp_type_polymorph_iter;
                r2 = mp_state_ctx;
                str(r0, r3);
                r3 = mp_vfs_ilistdir_it_iternext | 1;
                hint(mp_vfs_ilistdir_it_iternext | 1, this::mp_vfs_ilistdir_it_iternext);
                r4 = movs(r4, r0);
                str(r0 + 4, r3);
                r3 = movs(r3, 234);
                r3 = lsls(r3, 1);
                r3 = ldr(r2 + r3);
                str(r0 + 8, r3);
                r0 = movs(r0, r6);
                lr = mp_vfs_ilistdir + 54 | 1;
                bl(this::mp_obj_get_type, 54);
                return;
            case 54:
                r3 = mp_type_str;
                strb(r4 + 13, r5);
                r0 = subs(r0, r3);
                r3 = rsbs(r0, 0);
                r0 = adcs(r0, r3);
                strb(r4 + 12, r0);
            case 66:
                r0 = movs(r0, r4);
                pop(true, R1, R2, R4, R5, R6);
                return;
            case 70:
                r1 = movs(r1, 168);
                r3 = add(sp, 4);
                r2 = movs(r2, 1);
                r1 = lsls(r1, 1);
                lr = mp_vfs_ilistdir + 82 | 1;
                bl(this::mp_vfs_proxy_call, 82);
                return;
            case 82:
                r4 = movs(r4, r0);
                b(null, 66);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134322324, size=50, name='mp_vfs_listdir', path='build/extmod/vfs.o', has_indirect=False)
    protected void mp_vfs_listdir(int offset) throws Exception
    {
        pc = mp_vfs_listdir + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                lr = mp_vfs_listdir + 6 | 1;
                bl(this::mp_vfs_ilistdir, 6);
                return;
            case 6:
                r1 = movs(r1, 0);
                r5 = movs(r5, r0);
                r0 = movs(r0, r1);
                lr = mp_vfs_listdir + 16 | 1;
                bl(this::mp_obj_new_list, 16);
                return;
            case 16:
                r4 = movs(r4, r0);
            case 18:
                r0 = movs(r0, r5);
                lr = mp_vfs_listdir + 24 | 1;
                bl(this::mp_iternext, 24);
                return;
            case 24:
                cmp(r0, 0);
                if (bne(null, 32)) return;
            case 28:
                r0 = movs(r0, r4);
                pop(true, R4, R5, R6);
                return;
            case 32:
                r2 = movs(r2, 4);
                r1 = movs(r1, 1);
                lr = mp_vfs_listdir + 40 | 1;
                bl(this::mp_obj_subscr, 40);
                return;
            case 40:
                r1 = movs(r1, r0);
                r0 = movs(r0, r4);
                lr = mp_vfs_listdir + 48 | 1;
                bl(this::mp_obj_list_append, 48);
                return;
            case 48:
                b(null, 18);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134322376, size=60, name='mp_vfs_mkdir', path='build/extmod/vfs.o', has_indirect=False)
    protected void mp_vfs_mkdir(int offset) throws Exception
    {
        pc = mp_vfs_mkdir + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r4);
                r1 = add(sp, 4);
                lr = mp_vfs_mkdir + 8 | 1;
                bl(this::lookup_path, 8);
                return;
            case 8:
                r4 = subs(r0, 0);
                if (bne(null, 18)) return;
            case 12:
                r0 = movs(r0, 17);
                lr = mp_vfs_mkdir + 18 | 1;
                bl(this::mp_raise_OSError, 18);
                return;
            case 18:
                cmp(r0, 1);
                if (beq(null, 38)) return;
            case 22:
                r0 = ldr(sp + 4);
                lr = mp_vfs_mkdir + 28 | 1;
                bl(this::mp_obj_str_get_str, 28);
                return;
            case 28:
                r1 = 0x0802069b;
                lr = mp_vfs_mkdir + 34 | 1;
                bl(this::strcmp, 34);
                return;
            case 34:
                cmp(r0, 0);
                if (beq(null, 12)) return;
            case 38:
                r1 = movs(r1, 202);
                r3 = add(sp, 4);
                r2 = movs(r2, 1);
                r1 = lsls(r1, 1);
                r0 = movs(r0, r4);
                lr = mp_vfs_mkdir + 52 | 1;
                bl(this::mp_vfs_proxy_call, 52);
                return;
            case 52:
                pop(true, R1, R2, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134322436, size=22, name='mp_vfs_remove', path='build/extmod/vfs.o', has_indirect=False)
    protected void mp_vfs_remove(int offset) throws Exception
    {
        pc = mp_vfs_remove + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2);
                r1 = add(sp, 4);
                lr = mp_vfs_remove + 8 | 1;
                bl(this::lookup_path, 8);
                return;
            case 8:
                r1 = movs(r1, 202);
                r3 = add(sp, 4);
                r2 = movs(r2, 1);
                r1 = adds(r1, 255);
                lr = mp_vfs_remove + 20 | 1;
                bl(this::mp_vfs_proxy_call, 20);
                return;
            case 20:
                pop(true, R1, R2, R3);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134322458, size=46, name='mp_vfs_rename', path='build/extmod/vfs.o', has_indirect=False)
    protected void mp_vfs_rename(int offset) throws Exception
    {
        pc = mp_vfs_rename + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r4, r5);
                r5 = movs(r5, r1);
                r1 = mov(sp);
                lr = mp_vfs_rename + 10 | 1;
                bl(this::lookup_path, 10);
                return;
            case 10:
                r1 = add(sp, 4);
                r4 = movs(r4, r0);
                r0 = movs(r0, r5);
                lr = mp_vfs_rename + 20 | 1;
                bl(this::lookup_path, 20);
                return;
            case 20:
                cmp(r4, r0);
                if (beq(null, 30)) return;
            case 24:
                r0 = movs(r0, 1);
                lr = mp_vfs_rename + 30 | 1;
                bl(this::mp_raise_OSError, 30);
                return;
            case 30:
                r1 = movs(r1, 229);
                r3 = mov(sp);
                r2 = movs(r2, 2);
                r1 = lsls(r1, 1);
                r0 = movs(r0, r4);
                lr = mp_vfs_rename + 44 | 1;
                bl(this::mp_vfs_proxy_call, 44);
                return;
            case 44:
                pop(true, R1, R2, R3, R4, R5);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134322504, size=22, name='mp_vfs_rmdir', path='build/extmod/vfs.o', has_indirect=False)
    protected void mp_vfs_rmdir(int offset) throws Exception
    {
        pc = mp_vfs_rmdir + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2);
                r1 = add(sp, 4);
                lr = mp_vfs_rmdir + 8 | 1;
                bl(this::lookup_path, 8);
                return;
            case 8:
                r2 = movs(r2, 1);
                r1 = movs(r1, 233);
                r3 = add(sp, 4);
                r1 = lsls(r1, r2);
                lr = mp_vfs_rmdir + 20 | 1;
                bl(this::mp_vfs_proxy_call, 20);
                return;
            case 20:
                pop(true, R1, R2, R3);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134322528, size=60, name='mp_vfs_stat', path='build/extmod/vfs.o', has_indirect=False)
    protected void mp_vfs_stat(int offset) throws Exception
    {
        pc = mp_vfs_stat + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2);
                r1 = add(sp, 4);
                lr = mp_vfs_stat + 8 | 1;
                bl(this::lookup_path, 8);
                return;
            case 8:
                cmp(r0, 0);
                if (bne(null, 42)) return;
            case 12:
                r1 = movs(r1, r0);
                r0 = adds(r0, 10);
                lr = mp_vfs_stat + 20 | 1;
                bl(this::mp_obj_new_tuple, 20);
                return;
            case 20:
                r3 = 0x00008001;
                r2 = movs(r2, r0);
                str(r0 + 8, r3);
                r3 = movs(r3, r0);
                r1 = movs(r1, 1);
                r3 = adds(r3, 12);
                r2 = adds(r2, 48);
            case 34:
                r3 = stm(r3, R1);
                cmp(r3, r2);
                if (bne(null, 34)) return;
            case 40:
                pop(true, R1, R2, R3);
                return;
            case 42:
                r1 = movs(r1, 250);
                r3 = add(sp, 4);
                r2 = movs(r2, 1);
                r1 = lsls(r1, 1);
                lr = mp_vfs_stat + 54 | 1;
                bl(this::mp_vfs_proxy_call, 54);
                return;
            case 54:
                b(null, 40);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134322588, size=92, name='mp_vfs_statvfs', path='build/extmod/vfs.o', has_indirect=False)
    protected void mp_vfs_statvfs(int offset) throws Exception
    {
        pc = mp_vfs_statvfs + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2);
                r1 = add(sp, 4);
                lr = mp_vfs_statvfs + 8 | 1;
                bl(this::lookup_path, 8);
                return;
            case 8:
                cmp(r0, 0);
                if (bne(null, 70)) return;
            case 12:
                r3 = movs(r3, 234);
                r2 = mp_state_ctx;
                r3 = lsls(r3, 1);
                r0 = ldr(r2 + r3);
            case 20:
                cmp(r0, 0);
                if (bne(null, 54)) return;
            case 24:
                r1 = movs(r1, r0);
                r0 = movs(r0, 10);
                lr = mp_vfs_statvfs + 32 | 1;
                bl(this::mp_obj_new_tuple, 32);
                return;
            case 32:
                r3 = movs(r3, r0);
                r1 = movs(r1, r0);
                r2 = movs(r2, 1);
                r3 = adds(r3, 8);
                r1 = adds(r1, 44);
            case 42:
                r3 = stm(r3, R2);
                cmp(r1, r3);
                if (bne(null, 42)) return;
            case 48:
                r3 = 0x00000401;
                str(r0 + 44, r3);
            case 52:
                pop(true, R1, R2, R3);
                return;
            case 54:
                r3 = ldr(r0 + 4);
                cmp(r3, 1);
                if (beq(null, 64)) return;
            case 60:
                r0 = ldr(r0 + 12);
                b(null, 20);
                return;
            case 64:
                r3 = movs(r3, 187);
                r3 = lsls(r3, 1);
                str(sp + 4, r3);
            case 70:
                r1 = movs(r1, 251);
                r3 = add(sp, 4);
                r2 = movs(r2, 1);
                r1 = lsls(r1, 1);
                lr = mp_vfs_statvfs + 82 | 1;
                bl(this::mp_vfs_proxy_call, 82);
                return;
            case 82:
                b(null, 52);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134322680, size=124, name='mp_vfs_import_stat', path='build/extmod/vfs.o', has_indirect=False)
    protected void mp_vfs_import_stat(int offset) throws Exception
    {
        pc = mp_vfs_import_stat + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5);
                sp = sub(sp, 68);
                r1 = mov(sp);
                lr = mp_vfs_import_stat + 10 | 1;
                bl(this::mp_vfs_lookup_path, 10);
                return;
            case 10:
                r4 = movs(r4, r0);
                cmp(r0, 1);
                if (bhi(null, 22)) return;
            case 16:
                r0 = movs(r0, 0);
            case 18:
                sp = add(sp, 68);
                pop(true, R4, R5);
                return;
            case 22:
                r0 = ldr(r0 + 8);
                lr = mp_vfs_import_stat + 28 | 1;
                bl(this::mp_obj_get_type, 28);
                return;
            case 28:
                r3 = ldr(r0 + 48);
                cmp(r3, 0);
                if (beq(null, 44)) return;
            case 34:
                r3 = ldr(r3);
                r1 = ldr(sp);
                r0 = ldr(r4 + 8);
                blx(r3, 42);
                return;
            case 42:
                b(null, 18);
                return;
            case 44:
                r5 = ldr(sp);
                r0 = movs(r0, r5);
                lr = mp_vfs_import_stat + 52 | 1;
                bl(this::strlen, 52);
                return;
            case 52:
                r1 = movs(r1, r0);
                r0 = movs(r0, r5);
                lr = mp_vfs_import_stat + 60 | 1;
                bl(this::mp_obj_new_str, 60);
                return;
            case 60:
                str(sp + 4, r0);
                r0 = add(sp, 12);
                lr = mp_vfs_import_stat + 68 | 1;
                bl(this::nlr_push, 68);
                return;
            case 68:
                cmp(r0, 0);
                if (bne(null, 16)) return;
            case 72:
                r1 = movs(r1, 250);
                r3 = add(sp, 4);
                r2 = movs(r2, 1);
                r1 = lsls(r1, 1);
                r0 = movs(r0, r4);
                lr = mp_vfs_import_stat + 86 | 1;
                bl(this::mp_vfs_proxy_call, 86);
                return;
            case 86:
                r4 = movs(r4, r0);
                lr = mp_vfs_import_stat + 92 | 1;
                bl(this::nlr_pop, 92);
                return;
            case 92:
                r2 = add(sp, 8);
                r1 = movs(r1, 10);
                r0 = movs(r0, r4);
                lr = mp_vfs_import_stat + 102 | 1;
                bl(this::mp_obj_get_array_fixed_n, 102);
                return;
            case 102:
                r3 = ldr(sp + 8);
                r0 = ldr(r3);
                lr = mp_vfs_import_stat + 110 | 1;
                bl(this::mp_obj_get_int, 110);
                return;
            case 110:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 7);
                r0 = ands(r0, r3);
                r3 = rsbs(r0, 0);
                r0 = adcs(r0, r3);
                r0 = adds(r0, 1);
                b(null, 18);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134322804, size=20, name='mp_reader_vfs_close', path='build/extmod/vfs_reader.o', has_indirect=True)
    protected void mp_reader_vfs_close(int offset) throws Exception
    {
        pc = mp_reader_vfs_close + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r4 = movs(r4, r0);
                r0 = ldr(r0);
                lr = mp_reader_vfs_close + 10 | 1;
                bl(this::mp_stream_close, 10);
                return;
            case 10:
                r1 = movs(r1, 32);
                r0 = movs(r0, r4);
                lr = mp_reader_vfs_close + 18 | 1;
                bl(this::m_free, 18);
                return;
            case 18:
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134322824, size=70, name='mp_reader_vfs_readbyte', path='build/extmod/vfs_reader.o', has_indirect=True)
    protected void mp_reader_vfs_readbyte(int offset) throws Exception
    {
        pc = mp_reader_vfs_readbyte + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r3, r4);
                r3 = ldrh(r0 + 4);
                r2 = ldrh(r0 + 6);
                r4 = movs(r4, r0);
                cmp(r2, r3);
                if (blo(null, 50)) return;
            case 12:
                cmp(r3, 23);
                if (bls(null, 64)) return;
            case 16:
                r3 = movs(r3, 1);
                r1 = movs(r1, r0);
                str(sp, r3);
                r2 = movs(r2, 24);
                r3 = add(sp, 12);
                r1 = adds(r1, 8);
                r0 = ldr(r0);
                lr = mp_reader_vfs_readbyte + 34 | 1;
                bl(this::mp_stream_rw, 34);
                return;
            case 34:
                r3 = ldr(sp + 12);
                r0 = uxth(r0);
                strh(r4 + 4, r0);
                cmp(r3, 0);
                if (bne(null, 64)) return;
            case 44:
                cmp(r0, 0);
                if (beq(null, 64)) return;
            case 48:
                strh(r4 + 6, r3);
            case 50:
                r3 = ldrh(r4 + 6);
                r2 = adds(r3, 1);
                strh(r4 + 6, r2);
                r4 = adds(r4, r3);
                r0 = ldrb(r4 + 8);
            case 60:
                sp = add(sp, 16);
                pop(true, R4);
                return;
            case 64:
                r0 = movs(r0, 1);
                r0 = rsbs(r0, 0);
                b(null, 60);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134322896, size=96, name='mp_reader_new_file', path='build/extmod/vfs_reader.o', has_indirect=False)
    protected void mp_reader_new_file(int offset) throws Exception
    {
        pc = mp_reader_new_file + offset;
        switch (offset)
        {
            case 0:
                push(true, r0, r1, r2, r3, r4, r5, r6);
                r5 = movs(r5, r0);
                r0 = movs(r0, 32);
                r6 = movs(r6, r1);
                lr = mp_reader_new_file + 12 | 1;
                bl(this::m_malloc, 12);
                return;
            case 12:
                r4 = movs(r4, r0);
                r0 = movs(r0, r6);
                lr = mp_reader_new_file + 20 | 1;
                bl(this::strlen, 20);
                return;
            case 20:
                r1 = movs(r1, r0);
                r0 = movs(r0, r6);
                lr = mp_reader_new_file + 28 | 1;
                bl(this::mp_obj_new_str, 28);
                return;
            case 28:
                r2 = mp_const_empty_map;
                str(sp + 8, r0);
                r1 = add(sp, 8);
                r0 = movs(r0, 1);
                lr = mp_reader_new_file + 40 | 1;
                bl(this::mp_vfs_open, 40);
                return;
            case 40:
                r3 = movs(r3, 1);
                r1 = movs(r1, r4);
                str(r4, r0);
                r1 = adds(r1, 8);
                str(sp, r3);
                r2 = movs(r2, 24);
                r3 = add(sp, 12);
                lr = mp_reader_new_file + 58 | 1;
                bl(this::mp_stream_rw, 58);
                return;
            case 58:
                strh(r4 + 4, r0);
                r0 = ldr(sp + 12);
                cmp(r0, 0);
                if (beq(null, 70)) return;
            case 66:
                lr = mp_reader_new_file + 70 | 1;
                bl(this::mp_raise_OSError, 70);
                return;
            case 70:
                r3 = mp_reader_vfs_readbyte | 1;
                hint(mp_reader_vfs_readbyte | 1, this::mp_reader_vfs_readbyte);
                strh(r4 + 6, r0);
                str(r5 + 4, r3);
                r3 = mp_reader_vfs_close | 1;
                hint(mp_reader_vfs_close | 1, this::mp_reader_vfs_close);
                str(r5, r4);
                str(r5 + 8, r3);
                pop(true, R0, R1, R2, R3, R4, R5, R6);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134322992, size=28, name='time_ticks_diff', path='build/extmod/utime_mphal.o', has_indirect=False)
    protected void time_ticks_diff(int offset) throws Exception
    {
        assert offset == 0;
        pc = time_ticks_diff + offset;
        r3 = movs(r3, 128);
        r0 = asrs(r0, 1);
        r3 = lsls(r3, 22);
        r0 = adds(r0, r3);
        r3 = movs(r3, 192);
        r1 = asrs(r1, 1);
        r0 = subs(r0, r1);
        r0 = lsls(r0, 2);
        r3 = lsls(r3, 24);
        r0 = lsrs(r0, 1);
        r0 = adds(r0, r3);
        r3 = movs(r3, 1);
        r0 = orrs(r0, r3);
        bx(lr);
    }

    // function: Function(address=134323020, size=32, name='time_sleep', path='build/extmod/utime_mphal.o', has_indirect=False)
    protected void time_sleep(int offset) throws Exception
    {
        pc = time_sleep + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                lr = time_sleep + 6 | 1;
                bl(this::mp_obj_get_float, 6);
                return;
            case 6:
                r1 = 0x447a0000;
                lr = time_sleep + 12 | 1;
                bl(this::__aeabi_fmul, 12);
                return;
            case 12:
                lr = time_sleep + 16 | 1;
                bl(this::__fixunssfsi, 16);
                return;
            case 16:
                lr = time_sleep + 20 | 1;
                bl(this::mp_hal_delay_ms, 20);
                return;
            case 20:
                r0 = mp_const_none_obj;
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134323052, size=24, name='time_sleep_ms', path='build/extmod/utime_mphal.o', has_indirect=False)
    protected void time_sleep_ms(int offset) throws Exception
    {
        pc = time_sleep_ms + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                lr = time_sleep_ms + 6 | 1;
                bl(this::mp_obj_get_int, 6);
                return;
            case 6:
                cmp(r0, 0);
                if (ble(null, 14)) return;
            case 10:
                lr = time_sleep_ms + 14 | 1;
                bl(this::mp_hal_delay_ms, 14);
                return;
            case 14:
                r0 = mp_const_none_obj;
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134323076, size=32, name='time_ticks_add', path='build/extmod/utime_mphal.o', has_indirect=False)
    protected void time_ticks_add(int offset) throws Exception
    {
        pc = time_ticks_add + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                r4 = movs(r4, r0);
                r0 = movs(r0, r1);
                lr = time_ticks_add + 10 | 1;
                bl(this::mp_obj_get_int, 10);
                return;
            case 10:
                r4 = asrs(r4, 1);
                r0 = adds(r4, r0);
                r4 = 0x7ffffffe;
                r0 = lsls(r0, 1);
                r0 = ands(r0, r4);
                r4 = movs(r4, 1);
                r0 = orrs(r0, r4);
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134323108, size=24, name='time_ticks_ms', path='build/extmod/utime_mphal.o', has_indirect=False)
    protected void time_ticks_ms(int offset) throws Exception
    {
        pc = time_ticks_ms + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                lr = time_ticks_ms + 6 | 1;
                bl(this::mp_hal_ticks_ms, 6);
                return;
            case 6:
                r3 = 0x7ffffffe;
                r0 = lsls(r0, 1);
                r0 = ands(r0, r3);
                r3 = movs(r3, 1);
                r0 = orrs(r0, r3);
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134323132, size=24, name='time_ticks_cpu', path='build/extmod/utime_mphal.o', has_indirect=False)
    protected void time_ticks_cpu(int offset) throws Exception
    {
        pc = time_ticks_cpu + offset;
        switch (offset)
        {
            case 0:
                push(true, r4);
                lr = time_ticks_cpu + 6 | 1;
                bl(this::mp_hal_ticks_cpu, 6);
                return;
            case 6:
                r3 = 0x7ffffffe;
                r0 = lsls(r0, 1);
                r0 = ands(r0, r3);
                r3 = movs(r3, 1);
                r0 = orrs(r0, r3);
                pop(true, R4);
                return;
            default:
                crash();
        }
    }

} // MicroPython_extmod
