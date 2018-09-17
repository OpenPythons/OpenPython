package kr.pe.ecmaxp.micropython.example;

import kr.pe.ecmaxp.thumbjk.Callback;
import kr.pe.ecmaxp.thumbjk.KotlinCPU;
import kr.pe.ecmaxp.thumbjk.InterruptHandler;
import kr.pe.ecmaxp.thumbsk.Memory;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

import static kr.pe.ecmaxp.thumbsk.helper.RegisterIndex.*;

abstract public class MicroPython_extmod extends MicroPython_lib
{
    public MicroPython_extmod(@NotNull Memory memory)
    {
        super(memory);
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
                bl(this::mp_get_buffer_raise, uctypes_struct_addressof + 10 | 1, 10);
                return;
            case 10:
                r0 = ldr(sp + 4);
                bl(this::mp_obj_new_int, uctypes_struct_addressof + 16 | 1, 16);
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
                bl(this::mp_obj_int_get_truncated, uctypes_struct_bytearray_at + 10 | 1, 10);
                return;
            case 10:
                r4 = movs(r4, r0);
                r0 = movs(r0, r5);
                bl(this::mp_obj_int_get_truncated, uctypes_struct_bytearray_at + 18 | 1, 18);
                return;
            case 18:
                r1 = movs(r1, r0);
                r0 = movs(r0, r4);
                bl(this::mp_obj_new_bytearray_by_ref, uctypes_struct_bytearray_at + 26 | 1, 26);
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
                bl(this::mp_obj_int_get_truncated, uctypes_struct_bytes_at + 8 | 1, 8);
                return;
            case 8:
                r4 = movs(r4, r0);
                r0 = movs(r0, r5);
                bl(this::mp_obj_int_get_truncated, uctypes_struct_bytes_at + 16 | 1, 16);
                return;
            case 16:
                r1 = movs(r1, r0);
                r0 = movs(r0, r4);
                bl(this::mp_obj_new_bytes, uctypes_struct_bytes_at + 24 | 1, 24);
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
                if (beq(106)) return;
            case 6:
                if (bhi(28)) return;
            case 8:
                cmp(r0, 1);
                if (beq(86)) return;
            case 12:
                cmp(r0, 0);
                if (beq(78)) return;
            case 16:
                cmp(r0, 2);
                if (beq(94)) return;
            case 20:
                cmp(r0, 3);
                if (beq(100)) return;
            case 24:
                r0 = movs(r0, 0);
                b(null, 92);
                return;
            case 28:
                cmp(r0, 7);
                if (beq(126)) return;
            case 32:
                if (bhi(56)) return;
            case 34:
                cmp(r0, 5);
                if (beq(116)) return;
            case 38:
                cmp(r0, 6);
                if (bne(24)) return;
            case 42:
                r2 = lsls(r2, 3);
                r2 = adds(r1, r2);
                r0 = ldr(r2);
                r1 = ldr(r2 + 4);
                bl(this::mp_obj_new_int_from_ull, get_aligned + 54 | 1, 54);
                return;
            case 54:
                b(null, 92);
                return;
            case 56:
                cmp(r0, 14);
                if (beq(140)) return;
            case 60:
                cmp(r0, 15);
                if (bne(24)) return;
            case 64:
                r2 = lsls(r2, 3);
                r2 = adds(r1, r2);
                r0 = ldr(r2);
                r1 = ldr(r2 + 4);
                bl(this::__aeabi_d2f, get_aligned + 76 | 1, 76);
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
                bl(this::mp_obj_new_int_from_uint, get_aligned + 114 | 1, 114);
                return;
            case 114:
                b(null, 92);
                return;
            case 116:
                r2 = lsls(r2, 2);
                r0 = ldr(r2 + r1);
                bl(this::mp_obj_new_int, get_aligned + 124 | 1, 124);
                return;
            case 124:
                b(null, 92);
                return;
            case 126:
                r2 = lsls(r2, 3);
                r2 = adds(r1, r2);
                r0 = ldr(r2);
                r1 = ldr(r2 + 4);
                bl(this::mp_obj_new_int_from_ll, get_aligned + 138 | 1, 138);
                return;
            case 138:
                b(null, 92);
                return;
            case 140:
                r2 = lsls(r2, 2);
                r0 = ldr(r2 + r1);
            case 144:
                bl(this::mp_obj_new_float, get_aligned + 148 | 1, 148);
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
                bl(this::mp_arg_check_num, uctypes_struct_make_new + 24 | 1, 24);
                return;
            case 24:
                r0 = movs(r0, 16);
                bl(this::m_malloc, uctypes_struct_make_new + 30 | 1, 30);
                return;
            case 30:
                str(r0, r7);
                r4 = movs(r4, r0);
                r0 = ldr(r5);
                bl(this::mp_obj_int_get_truncated, uctypes_struct_make_new + 40 | 1, 40);
                return;
            case 40:
                str(r4 + 8, r0);
                r3 = ldr(r5 + 4);
                str(r4 + 4, r3);
                r3 = movs(r3, 2);
                str(r4 + 12, r3);
                cmp(r6, 3);
                if (bne(62)) return;
            case 54:
                r0 = ldr(r5 + 8);
                bl(this::mp_obj_get_int, uctypes_struct_make_new + 60 | 1, 60);
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
                r2 = ldr(uctypes_struct_print + 56);
                r4 = lsls(r3, 30);
                if (bne(46)) return;
            case 10:
                r4 = ldr(r3);
                r5 = ldr(uctypes_struct_print + 60); // mp_type_dict;
                cmp(r4, r5);
                if (beq(44)) return;
            case 18:
                r5 = ldr(uctypes_struct_print + 64); // mp_type_tuple;
                cmp(r4, r5);
                if (bne(46)) return;
            case 24:
                r3 = ldr(r3 + 8);
                r2 = ldr(uctypes_struct_print + 68);
                r3 = lsrs(r3, 30);
                cmp(r3, 1);
                if (beq(46)) return;
            case 34:
                r2 = ldr(uctypes_struct_print + 72);
                cmp(r3, 2);
                if (beq(46)) return;
            case 40:
                r2 = ldr(uctypes_struct_print + 76);
                b(null, 46);
                return;
            case 44:
                r2 = ldr(uctypes_struct_print + 80); // uctypes_struct_print_str1_1;
            case 46:
                r3 = ldr(r1 + 8);
                r1 = ldr(uctypes_struct_print + 84);
                bl(this::mp_printf, uctypes_struct_print + 54 | 1, 54);
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
                if (bhi(48)) return;
            case 20:
                bl(this::mp_obj_get_float, set_aligned + 24 | 1, 24);
                return;
            case 24:
                cmp(r5, 14);
                if (bne(34)) return;
            case 28:
                r4 = lsls(r4, 2);
                str(r4 + r6, r0);
            case 32:
                pop(true, R0, R1, R2, R4, R5, R6, R7);
                return;
            case 34:
                bl(this::__aeabi_f2d, set_aligned + 38 | 1, 38);
                return;
            case 38:
                r4 = lsls(r4, 3);
                r6 = adds(r6, r4);
                str(r6, r0);
                str(r6 + 4, r1);
                b(null, 32);
                return;
            case 48:
                bl(this::mp_obj_get_int_truncated, set_aligned + 52 | 1, 52);
                return;
            case 52:
                cmp(r5, 3);
                if (beq(64)) return;
            case 56:
                if (bhi(70)) return;
            case 58:
                cmp(r5, 1);
                if (beq(98)) return;
            case 62:
                if (bls(98)) return;
            case 64:
                r4 = lsls(r4, 1);
                strh(r4 + r6, r0);
                b(null, 32);
                return;
            case 70:
                cmp(r5, 5);
                if (beq(102)) return;
            case 74:
                if (blo(102)) return;
            case 76:
                cmp(r5, 7);
                if (bhi(32)) return;
            case 80:
                r3 = ldr(set_aligned + 108); // type2char_6468;
                r2 = movs(r2, r7);
                r1 = ldrb(r3 + r5);
                r0 = movs(r0, 60);
                r3 = add(sp, 4);
                str(sp + 4, r6);
                bl(this::mp_binary_set_val, set_aligned + 96 | 1, 96);
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
                if (bne(210)) return;
            case 18:
                r3 = ldr(r0);
                r0 = ldr(uctypes_struct_size + 220); // mp_type_dict;
                cmp(r3, r0);
                if (bne(190)) return;
            case 26:
                r4 = movs(r4, r7);
                str(sp + 8, r2);
            case 30:
                r3 = ldr(r5 + 8);
                cmp(r7, r3);
                if (blo(58)) return;
            case 36:
                r3 = ldr(sp + 4);
                cmp(r3, 2);
                if (bne(52)) return;
            case 42:
                r3 = ldr(r6);
                r2 = subs(r3, 1);
                r2 = adds(r2, r4);
                r4 = rsbs(r3);
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
                if (beq(130)) return;
            case 70:
                cmp(r2, 4);
                if (beq(130)) return;
            case 74:
                r0 = ldr(r3 + 4);
                r3 = movs(r3, 1);
                tst(r0, r3);
                if (beq(140)) return;
            case 82:
                r3 = asrs(r0, 1);
                r0 = lsrs(r0, 28);
                r2 = movs(r2, r0);
                r2 = subs(r2, 8);
                cmp(r2, 5);
                if (bls(134)) return;
            case 94:
                r3 = lsls(r3, 5);
                r3 = lsrs(r3, 5);
            case 98:
                r2 = movs(r2, 4);
                cmp(r0, 14);
                if (beq(114)) return;
            case 104:
                r2 = ldr(sp + 8);
                r0 = asrs(r0, 1);
                r0 = ands(r0, r2);
                r2 = movs(r2, 1);
                r2 = lsls(r2, r0);
            case 114:
                r1 = ldr(r6);
                cmp(r1, r2);
                if (bhs(122)) return;
            case 120:
                str(r6, r2);
            case 122:
                r3 = adds(r3, r2);
                cmp(r4, r3);
                if (bhs(130)) return;
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
                if (bne(154)) return;
            case 146:
                r3 = ldr(uctypes_struct_size + 224); // mp_type_tuple;
                r2 = ldr(r0);
                cmp(r2, r3);
                if (beq(160)) return;
            case 154:
                r0 = ldr(uctypes_struct_size + 228); // uctypes_struct_size_str1_1;
            case 156:
                bl(this::mp_raise_TypeError, uctypes_struct_size + 160 | 1, 160);
                return;
            case 160:
                r3 = ldr(r0 + 8);
                r2 = movs(r2, r6);
                r3 = asrs(r3, 1);
                r1 = ldr(sp + 4);
                str(sp + 12, r3);
                bl(this::uctypes_struct_agg_size, uctypes_struct_size + 174 | 1, 174);
                return;
            case 174:
                r3 = ldr(sp + 12);
                r3 = lsls(r3, 3);
                r3 = lsrs(r3, 3);
                r0 = adds(r3, r0);
                cmp(r4, r0);
                if (bhs(130)) return;
            case 186:
                r4 = movs(r4, r0);
                b(null, 130);
                return;
            case 190:
                r2 = ldr(uctypes_struct_size + 224); // mp_type_tuple;
                cmp(r3, r2);
                if (bne(210)) return;
            case 196:
                r2 = movs(r2, r6);
                r1 = ldr(sp + 4);
                r0 = movs(r0, r5);
                bl(this::uctypes_struct_agg_size, uctypes_struct_size + 206 | 1, 206);
                return;
            case 206:
                r4 = movs(r4, r0);
                b(null, 52);
                return;
            case 210:
                r3 = lsls(r5, 31);
                if (bpl(154)) return;
            case 214:
                r0 = ldr(uctypes_struct_size + 232);
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
                if (bne(50)) return;
            case 10:
                r3 = ldr(r0);
                r2 = ldr(uctypes_struct_sizeof + 56); // mp_type_bytearray;
                cmp(r3, r2);
                if (bne(24)) return;
            case 18:
                bl(this::mp_obj_len, uctypes_struct_sizeof + 22 | 1, 22);
                return;
            case 22:
                pop(true, R1, R2, R3);
                return;
            case 24:
                r2 = ldr(uctypes_struct_sizeof + 60); // uctypes_struct_type;
                r1 = movs(r1, 2);
                cmp(r3, r2);
                if (bne(36)) return;
            case 32:
                r1 = ldr(r0 + 12);
                r0 = ldr(r0 + 4);
            case 36:
                r2 = add(sp, 4);
                bl(this::uctypes_struct_size, uctypes_struct_sizeof + 42 | 1, 42);
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
                if (beq(30)) return;
            case 10:
                cmp(r3, 0);
                if (beq(22)) return;
            case 14:
                cmp(r3, 2);
                if (beq(42)) return;
            case 18:
                r0 = movs(r0, 0);
                b(null, 28);
                return;
            case 22:
                r0 = ldr(r0 + 12);
                bl(this::uctypes_struct_size, uctypes_struct_agg_size + 28 | 1, 28);
                return;
            case 28:
                pop(true, R4, R5, R6);
                return;
            case 30:
                r3 = ldr(r2);
                r0 = movs(r0, 4);
                cmp(r3, 3);
                if (bhi(28)) return;
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
                if (bne(72)) return;
            case 54:
                r0 = movs(r0, 1);
                r3 = lsrs(r3, 29);
                r0 = lsls(r0, r3);
                r3 = ldr(r2);
                cmp(r0, r3);
                if (bls(68)) return;
            case 66:
                str(r2, r0);
            case 68:
                r0 = muls(r4, r0);
                b(null, 28);
                return;
            case 72:
                r0 = ldr(r0 + 16);
                bl(this::uctypes_struct_size, uctypes_struct_agg_size + 78 | 1, 78);
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
                bl(this::uctypes_struct_size, uctypes_get_buffer + 20 | 1, 20);
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
                if (beq(92)) return;
            case 10:
                r2 = movs(r2, 3);
                r6 = ldr(r0 + 4);
                r2 = ands(r2, r6);
                if (bne(26)) return;
            case 18:
                r3 = ldr(uctypes_struct_subscr + 284); // mp_type_tuple;
                r0 = ldr(r6);
                cmp(r0, r3);
                if (beq(32)) return;
            case 26:
                r0 = ldr(uctypes_struct_subscr + 288); // uctypes_struct_subscr_str1_1;
                bl(this::mp_raise_TypeError, uctypes_struct_subscr + 32 | 1, 32);
                return;
            case 32:
                r3 = ldr(r6 + 8);
                r7 = asrs(r1, 1);
                r3 = lsrs(r3, 30);
                cmp(r3, 2);
                if (bne(212)) return;
            case 42:
                r3 = ldr(r6 + 12);
                r1 = lsls(r3, 4);
                r1 = lsrs(r1, 5);
                cmp(r7, r1);
                if (blt(64)) return;
            case 52:
                r1 = ldr(uctypes_struct_subscr + 292);
                r0 = ldr(uctypes_struct_subscr + 296); // mp_type_IndexError;
                bl(this::mp_obj_new_exception_msg, uctypes_struct_subscr + 60 | 1, 60);
                return;
            case 60:
                bl(this::nlr_jump, uctypes_struct_subscr + 64 | 1, 64);
                return;
            case 64:
                r1 = ldr(r6 + 4);
                cmp(r1, 2);
                if (bne(160)) return;
            case 70:
                r2 = ldr(r5 + 12);
                r0 = lsrs(r3, 28);
                r1 = ldr(r5 + 8);
                cmp(r2, 2);
                if (bne(98)) return;
            case 80:
                r2 = movs(r2, r7);
                cmp(r4, 4);
                if (beq(236)) return;
            case 86:
                r3 = movs(r3, r4);
                bl(this::set_aligned, uctypes_struct_subscr + 92 | 1, 92);
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
                if (bne(134)) return;
            case 108:
                str(sp + 8, r1);
                r3 = movs(r3, 60);
                cmp(r2, 0);
                if (beq(118)) return;
            case 116:
                r3 = adds(r3, 2);
            case 118:
                r2 = ldr(uctypes_struct_subscr + 300); // type2char_6468;
                r1 = ldrb(r2 + r0);
                r2 = add(sp, 8);
                r0 = movs(r0, r3);
                bl(this::mp_binary_get_val, uctypes_struct_subscr + 130 | 1, 130);
                return;
            case 130:
                r4 = movs(r4, r0);
                b(null, 92);
                return;
            case 134:
                str(sp + 12, r1);
                r5 = movs(r5, 60);
                cmp(r2, 0);
                if (beq(144)) return;
            case 142:
                r5 = adds(r5, 2);
            case 144:
                r3 = ldr(uctypes_struct_subscr + 304); // type2char_6468;
                r2 = movs(r2, r4);
                r1 = ldrb(r3 + r0);
                r3 = add(sp, 12);
                r0 = movs(r0, r5);
                bl(this::mp_binary_set_val, uctypes_struct_subscr + 158 | 1, 158);
                return;
            case 158:
                b(null, 92);
                return;
            case 160:
                cmp(r4, 4);
                if (bne(280)) return;
            case 164:
                str(sp + 12, r2);
                r1 = ldr(r5 + 12);
                r2 = add(sp, 12);
                r0 = ldr(r6 + 16);
                bl(this::uctypes_struct_size, uctypes_struct_subscr + 176 | 1, 176);
                return;
            case 176:
                str(sp, r0);
                r0 = movs(r0, 16);
                bl(this::m_malloc, uctypes_struct_subscr + 184 | 1, 184);
                return;
            case 184:
                r4 = movs(r4, r0);
                r3 = ldr(uctypes_struct_subscr + 308); // uctypes_struct_type;
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
                if (bne(92)) return;
            case 218:
                r2 = ldr(r5 + 8);
                r0 = ldr(r6 + 12);
                r2 = ldr(r2);
                r3 = ands(r3, r0);
                str(sp, r2);
                if (beq(242)) return;
            case 230:
                r2 = movs(r2, r7);
                r1 = ldr(sp);
                r0 = lsrs(r0, 28);
            case 236:
                bl(this::get_aligned, uctypes_struct_subscr + 240 | 1, 240);
                return;
            case 240:
                b(null, 130);
                return;
            case 242:
                r2 = add(sp, 12);
                r1 = ldr(r5 + 12);
                str(sp + 12, r3);
                bl(this::uctypes_struct_size, uctypes_struct_subscr + 252 | 1, 252);
                return;
            case 252:
                str(sp + 4, r0);
                r0 = movs(r0, 16);
                bl(this::m_malloc, uctypes_struct_subscr + 260 | 1, 260);
                return;
            case 260:
                r3 = ldr(uctypes_struct_subscr + 308); // uctypes_struct_type;
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
                if (bne(30)) return;
            case 22:
                r3 = ldr(uctypes_struct_attr_op + 504); // mp_type_dict;
                r2 = ldr(r0);
                cmp(r2, r3);
                if (beq(36)) return;
            case 30:
                r0 = ldr(uctypes_struct_attr_op + 508); // uctypes_struct_attr_op_str1_1;
            case 32:
                bl(this::mp_raise_TypeError, uctypes_struct_attr_op + 36 | 1, 36);
                return;
            case 36:
                r3 = lsls(r1, 2);
                r1 = movs(r1, 2);
                r1 = orrs(r1, r3);
                bl(this::mp_obj_dict_get, uctypes_struct_attr_op + 46 | 1, 46);
                return;
            case 46:
                r5 = movs(r5, r0);
                r0 = movs(r0, 1);
                tst(r5, r0);
                if (bne(56)) return;
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
                if (bls(78)) return;
            case 72:
                r2 = subs(r2, 14);
                cmp(r2, r0);
                if (bhi(174)) return;
            case 78:
                r1 = ldr(r7 + 8);
                r2 = ldr(r7 + 12);
                r1 = adds(r1, r3);
                cmp(r2, 2);
                if (bne(120)) return;
            case 88:
                cmp(r4, 0);
                if (bne(104)) return;
            case 92:
                r2 = movs(r2, r4);
                r0 = ldr(sp + 4);
                bl(this::get_aligned, uctypes_struct_attr_op + 100 | 1, 100);
                return;
            case 100:
                r4 = movs(r4, r0);
                b(null, 114);
                return;
            case 104:
                r3 = movs(r3, r4);
                r2 = movs(r2, 0);
                r0 = ldr(sp + 4);
                bl(this::set_aligned, uctypes_struct_attr_op + 114 | 1, 114);
                return;
            case 114:
                r0 = movs(r0, r4);
                sp = add(sp, 36);
                pop(true, R4, R5, R6, R7);
                return;
            case 120:
                cmp(r4, 0);
                if (bne(148)) return;
            case 124:
                str(sp + 24, r1);
                r0 = movs(r0, 60);
                cmp(r2, 0);
                if (beq(134)) return;
            case 132:
                r0 = adds(r0, 2);
            case 134:
                r2 = ldr(sp + 4);
                r3 = ldr(uctypes_struct_attr_op + 512); // type2char_6468;
                r1 = ldrb(r3 + r2);
                r2 = add(sp, 24);
                bl(this::mp_binary_get_val, uctypes_struct_attr_op + 146 | 1, 146);
                return;
            case 146:
                b(null, 100);
                return;
            case 148:
                str(sp + 28, r1);
                r0 = movs(r0, 60);
                cmp(r2, 0);
                if (beq(158)) return;
            case 156:
                r0 = adds(r0, 2);
            case 158:
                r2 = ldr(sp + 4);
                r3 = ldr(uctypes_struct_attr_op + 516); // type2char_6468;
                r1 = ldrb(r3 + r2);
                r3 = add(sp, 28);
                r2 = movs(r2, r4);
                bl(this::mp_binary_set_val, uctypes_struct_attr_op + 172 | 1, 172);
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
                if (bne(264)) return;
            case 202:
                r2 = adds(r2, 4);
                r1 = lsrs(r5, 28);
                r2 = ands(r2, r1);
                cmp(r2, 2);
                if (beq(256)) return;
            case 212:
                cmp(r2, 4);
                if (beq(260)) return;
            case 216:
                r6 = ldr(sp + 12);
                cmp(r2, 0);
                if (bne(224)) return;
            case 222:
                r6 = ldrb(r3);
            case 224:
                r0 = movs(r0, 1);
                r3 = ldr(sp + 20);
                r0 = lsls(r0, r3);
                r3 = subs(r0, 1);
                str(sp + 12, r3);
                cmp(r4, 0);
                if (bne(292)) return;
            case 238:
                r0 = movs(r0, r6);
                r3 = ldr(sp + 8);
                r0 = lsrs(r0, r3);
                r3 = ldr(sp + 12);
                r3 = ands(r3, r0);
                r0 = movs(r0, r3);
                bl(this::mp_obj_new_int, uctypes_struct_attr_op + 254 | 1, 254);
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
                bl(this::mp_binary_get_int, uctypes_struct_attr_op + 288 | 1, 288);
                return;
            case 288:
                r6 = movs(r6, r0);
                b(null, 224);
                return;
            case 292:
                r0 = movs(r0, r4);
                bl(this::mp_obj_get_int, uctypes_struct_attr_op + 298 | 1, 298);
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
                if (bne(358)) return;
            case 322:
                r1 = ldr(sp + 16);
                r0 = ldr(sp + 4);
                r2 = adds(r2, r1);
                r1 = movs(r1, 6);
                r0 = ands(r0, r1);
                cmp(r0, 2);
                if (beq(350)) return;
            case 336:
                cmp(r0, 4);
                if (beq(354)) return;
            case 340:
                cmp(r0, 0);
                if (beq(346)) return;
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
                r0 = rsbs(r1);
                r1 = adcs(r1, r0);
                r0 = movs(r0, 1);
                r5 = lsls(r5, 1);
                r5 = lsrs(r5, 30);
                r1 = uxtb(r1);
                r0 = lsls(r0, r5);
                bl(this::mp_binary_set_int, uctypes_struct_attr_op + 382 | 1, 382);
                return;
            case 382:
                b(null, 114);
                return;
            case 384:
                tst(r5, r6);
                if (bne(396)) return;
            case 388:
                r3 = ldr(uctypes_struct_attr_op + 520); // mp_type_tuple;
                r2 = ldr(r5);
                cmp(r2, r3);
                if (beq(400)) return;
            case 396:
                r0 = ldr(uctypes_struct_attr_op + 524); // uctypes_struct_size_str1_1;
                b(null, 32);
                return;
            case 400:
                cmp(r4, 0);
                if (bne(396)) return;
            case 404:
                r3 = ldr(r5 + 8);
                r6 = lsls(r3, 2);
                r6 = lsrs(r6, 3);
                r3 = lsrs(r3, 30);
                cmp(r3, 1);
                if (beq(486)) return;
            case 416:
                cmp(r3, 0);
                if (beq(458)) return;
            case 420:
                cmp(r3, 2);
                if (beq(426)) return;
            case 424:
                b(null, 114);
                return;
            case 426:
                r3 = ldr(r5 + 4);
                cmp(r3, 2);
                if (bne(486)) return;
            case 432:
                r3 = ldr(r5 + 12);
                r3 = lsrs(r3, 28);
                if (bne(486)) return;
            case 438:
                r1 = ldr(r7 + 12);
                r2 = add(sp, 28);
                r0 = movs(r0, r5);
                bl(this::uctypes_struct_agg_size, uctypes_struct_attr_op + 448 | 1, 448);
                return;
            case 448:
                r1 = ldr(r7 + 8);
                r1 = adds(r1, r6);
                bl(this::mp_obj_new_bytearray_by_ref, uctypes_struct_attr_op + 456 | 1, 456);
                return;
            case 456:
                b(null, 100);
                return;
            case 458:
                r0 = movs(r0, 16);
                bl(this::m_malloc, uctypes_struct_attr_op + 464 | 1, 464);
                return;
            case 464:
                r4 = movs(r4, r0);
                r3 = ldr(uctypes_struct_attr_op + 528); // uctypes_struct_type;
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
                bl(this::m_malloc, uctypes_struct_attr_op + 492 | 1, 492);
                return;
            case 492:
                r3 = ldr(uctypes_struct_attr_op + 528); // uctypes_struct_type;
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
                if (bne(18)) return;
            case 10:
                bl(this::uctypes_struct_attr_op, uctypes_struct_attr + 14 | 1, 14);
                return;
            case 14:
                str(r4, r0);
            case 16:
                pop(true, R4);
                return;
            case 18:
                r2 = ldr(r4 + 4);
                bl(this::uctypes_struct_attr_op, uctypes_struct_attr + 24 | 1, 24);
                return;
            case 24:
                cmp(r0, 0);
                if (beq(16)) return;
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
                blx(r5, ujson_stream_next + 20 | 1, 20);
                return;
            case 20:
                r3 = movs(r3, r0);
                r0 = ldr(r4 + 8);
                cmp(r0, 0);
                if (beq(32)) return;
            case 28:
                bl(this::mp_raise_OSError, ujson_stream_next + 32 | 1, 32);
                return;
            case 32:
                cmp(r3, 0);
                if (bne(38)) return;
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
                bl(this::mp_get_stream_raise, mod_ujson_load + 12 | 1, 12);
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
                bl(this::vstr_init, mod_ujson_load + 36 | 1, 36);
                return;
            case 36:
                r0 = movs(r0, r4);
                str(sp + 56, r5);
                str(sp + 60, r5);
                bl(this::ujson_stream_next, mod_ujson_load + 46 | 1, 46);
                return;
            case 46:
                str(sp + 8, r5);
                str(sp + 12, r5);
            case 50:
                r5 = ldrb(r4 + 12);
                cmp(r5, 0);
                if (bne(58)) return;
            case 56:
                b(null, 684);
                return;
            case 58:
                r0 = movs(r0, r4);
                bl(this::ujson_stream_next, mod_ujson_load + 64 | 1, 64);
                return;
            case 64:
                cmp(r5, 57);
                if (bhi(144)) return;
            case 68:
                cmp(r5, 48);
                if (blo(74)) return;
            case 72:
                b(null, 516);
                return;
            case 74:
                cmp(r5, 32);
                if (beq(50)) return;
            case 78:
                if (bhi(98)) return;
            case 80:
                cmp(r5, 9);
                if (blo(92)) return;
            case 84:
                cmp(r5, 10);
                if (bls(50)) return;
            case 88:
                cmp(r5, 13);
                if (beq(50)) return;
            case 92:
                r0 = ldr(mod_ujson_load + 740); // mod_ujson_load_str1_1;
                bl(this::mp_raise_ValueError, mod_ujson_load + 98 | 1, 98);
                return;
            case 98:
                cmp(r5, 44);
                if (beq(50)) return;
            case 102:
                cmp(r5, 45);
                if (bne(108)) return;
            case 106:
                b(null, 516);
                return;
            case 108:
                cmp(r5, 34);
                if (bne(92)) return;
            case 112:
                r3 = movs(r3, 0);
                str(sp + 36, r3);
            case 116:
                r1 = ldrb(r4 + 12);
                cmp(r1, 0);
                if (beq(92)) return;
            case 122:
                cmp(r1, 34);
                if (beq(128)) return;
            case 126:
                b(null, 394);
                return;
            case 128:
                r0 = movs(r0, r4);
                bl(this::ujson_stream_next, mod_ujson_load + 134 | 1, 134);
                return;
            case 134:
                r1 = ldr(sp + 36);
                r0 = ldr(sp + 40);
                bl(this::mp_obj_new_str, mod_ujson_load + 142 | 1, 142);
                return;
            case 142:
                b(null, 574);
                return;
            case 144:
                cmp(r5, 102);
                if (beq(306)) return;
            case 148:
                if (bhi(166)) return;
            case 150:
                cmp(r5, 91);
                if (bne(156)) return;
            case 154:
                b(null, 598);
                return;
            case 156:
                cmp(r5, 93);
                if (beq(274)) return;
            case 160:
                cmp(r5, 58);
                if (bne(92)) return;
            case 164:
                b(null, 50);
                return;
            case 166:
                cmp(r5, 116);
                if (beq(352)) return;
            case 170:
                if (bhi(264)) return;
            case 172:
                cmp(r5, 110);
                if (bne(92)) return;
            case 176:
                r3 = ldrb(r4 + 12);
                cmp(r3, 117);
                if (bne(92)) return;
            case 182:
                r0 = movs(r0, r4);
                bl(this::ujson_stream_next, mod_ujson_load + 188 | 1, 188);
                return;
            case 188:
                cmp(r0, 108);
                if (bne(92)) return;
            case 192:
                r0 = movs(r0, r4);
                bl(this::ujson_stream_next, mod_ujson_load + 198 | 1, 198);
                return;
            case 198:
                cmp(r0, 108);
                if (bne(92)) return;
            case 202:
                r0 = movs(r0, r4);
                bl(this::ujson_stream_next, mod_ujson_load + 208 | 1, 208);
                return;
            case 208:
                r5 = ldr(mod_ujson_load + 744); // mp_const_none_obj;
            case 210:
                cmp(r6, 0);
                if (bne(216)) return;
            case 214:
                b(null, 728);
                return;
            case 216:
                r7 = movs(r7, 0);
            case 218:
                r3 = ldr(mod_ujson_load + 748); // mp_type_list;
                r2 = ldr(sp + 12);
                cmp(r2, r3);
                if (beq(228)) return;
            case 226:
                b(null, 636);
                return;
            case 228:
                r1 = movs(r1, r5);
                r0 = movs(r0, r6);
                bl(this::mp_obj_list_append, mod_ujson_load + 236 | 1, 236);
                return;
            case 236:
                cmp(r7, 0);
                if (beq(50)) return;
            case 240:
                r3 = ldr(sp + 60);
                str(sp + 12, r3);
                cmp(r3, 0);
                if (beq(250)) return;
            case 248:
                b(null, 668);
                return;
            case 250:
                r1 = movs(r1, 1);
                r0 = add(sp, 48);
                bl(this::mp_obj_list_init, mod_ujson_load + 258 | 1, 258);
                return;
            case 258:
                r3 = ldr(sp + 60);
                str(r3, r6);
                b(null, 616);
                return;
            case 264:
                cmp(r5, 123);
                if (bne(270)) return;
            case 268:
                b(null, 628);
                return;
            case 270:
                cmp(r5, 125);
                if (bne(92)) return;
            case 274:
                cmp(r6, 0);
                if (beq(92)) return;
            case 278:
                r3 = ldr(sp + 56);
                cmp(r3, 0);
                if (bne(286)) return;
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
                bl(this::mp_obj_get_type, mod_ujson_load + 302 | 1, 302);
                return;
            case 302:
                str(sp + 12, r0);
                b(null, 50);
                return;
            case 306:
                r3 = ldrb(r4 + 12);
                cmp(r3, 97);
                if (bne(92)) return;
            case 312:
                r0 = movs(r0, r4);
                bl(this::ujson_stream_next, mod_ujson_load + 318 | 1, 318);
                return;
            case 318:
                cmp(r0, 108);
                if (bne(92)) return;
            case 322:
                r0 = movs(r0, r4);
                bl(this::ujson_stream_next, mod_ujson_load + 328 | 1, 328);
                return;
            case 328:
                cmp(r0, 115);
                if (bne(92)) return;
            case 332:
                r0 = movs(r0, r4);
                bl(this::ujson_stream_next, mod_ujson_load + 338 | 1, 338);
                return;
            case 338:
                cmp(r0, 101);
                if (bne(92)) return;
            case 342:
                r0 = movs(r0, r4);
                bl(this::ujson_stream_next, mod_ujson_load + 348 | 1, 348);
                return;
            case 348:
                r5 = ldr(mod_ujson_load + 752); // mp_const_false_obj;
                b(null, 210);
                return;
            case 352:
                r3 = ldrb(r4 + 12);
                cmp(r3, 114);
                if (beq(360)) return;
            case 358:
                b(null, 92);
                return;
            case 360:
                r0 = movs(r0, r4);
                bl(this::ujson_stream_next, mod_ujson_load + 366 | 1, 366);
                return;
            case 366:
                cmp(r0, 117);
                if (beq(372)) return;
            case 370:
                b(null, 92);
                return;
            case 372:
                r0 = movs(r0, r4);
                bl(this::ujson_stream_next, mod_ujson_load + 378 | 1, 378);
                return;
            case 378:
                cmp(r0, 101);
                if (beq(384)) return;
            case 382:
                b(null, 92);
                return;
            case 384:
                r0 = movs(r0, r4);
                bl(this::ujson_stream_next, mod_ujson_load + 390 | 1, 390);
                return;
            case 390:
                r5 = ldr(mod_ujson_load + 756); // mp_const_true_obj;
                b(null, 210);
                return;
            case 394:
                cmp(r1, 92);
                if (bne(420)) return;
            case 398:
                r0 = movs(r0, r4);
                bl(this::ujson_stream_next, mod_ujson_load + 404 | 1, 404);
                return;
            case 404:
                r1 = movs(r1, r0);
                cmp(r0, 110);
                if (beq(448)) return;
            case 410:
                if (bhi(428)) return;
            case 412:
                cmp(r0, 98);
                if (beq(512)) return;
            case 416:
                cmp(r0, 102);
                if (beq(444)) return;
            case 420:
                r0 = add(sp, 32);
                bl(this::vstr_add_byte, mod_ujson_load + 426 | 1, 426);
                return;
            case 426:
                b(null, 504);
                return;
            case 428:
                cmp(r0, 116);
                if (beq(452)) return;
            case 432:
                cmp(r0, 117);
                if (beq(456)) return;
            case 436:
                cmp(r0, 114);
                if (bne(420)) return;
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
                bl(this::ujson_stream_next, mod_ujson_load + 466 | 1, 466);
                return;
            case 466:
                r3 = movs(r3, 32);
                r0 = orrs(r0, r3);
                r0 = uxtb(r0);
                r3 = movs(r3, r0);
                r3 = subs(r3, 48);
                r3 = uxtb(r3);
                cmp(r3, 9);
                if (bls(486)) return;
            case 482:
                r0 = subs(r0, 87);
                r3 = uxtb(r0);
            case 486:
                r5 = lsls(r5, 4);
                r7 = subs(r7, 1);
                r5 = orrs(r5, r3);
                cmp(r7, 0);
                if (bne(460)) return;
            case 496:
                r1 = movs(r1, r5);
                r0 = add(sp, 32);
                bl(this::vstr_add_char, mod_ujson_load + 504 | 1, 504);
                return;
            case 504:
                r0 = movs(r0, r4);
                bl(this::ujson_stream_next, mod_ujson_load + 510 | 1, 510);
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
                bl(this::vstr_add_byte, mod_ujson_load + 528 | 1, 528);
                return;
            case 528:
                r5 = ldrb(r4 + 12);
                cmp(r5, 46);
                if (beq(578)) return;
            case 534:
                r3 = movs(r3, r5);
                r2 = movs(r2, 32);
                r3 = bics(r3, r2);
                cmp(r3, 69);
                if (beq(578)) return;
            case 544:
                cmp(r5, 45);
                if (beq(580)) return;
            case 548:
                r0 = movs(r0, r5);
                bl(this::unichar_isdigit, mod_ujson_load + 554 | 1, 554);
                return;
            case 554:
                r2 = subs(r0, 0);
                if (bne(580)) return;
            case 558:
                r0 = ldr(sp + 40);
                r1 = ldr(sp + 36);
                cmp(r7, 0);
                if (beq(588)) return;
            case 566:
                str(sp, r2);
                r3 = movs(r3, r2);
                bl(this::mp_parse_num_decimal, mod_ujson_load + 574 | 1, 574);
                return;
            case 574:
                r5 = movs(r5, r0);
                b(null, 210);
                return;
            case 578:
                r7 = movs(r7, 1);
            case 580:
                r0 = movs(r0, r4);
                bl(this::ujson_stream_next, mod_ujson_load + 586 | 1, 586);
                return;
            case 586:
                b(null, 520);
                return;
            case 588:
                r3 = movs(r3, r7);
                r2 = movs(r2, 10);
                bl(this::mp_parse_num_integer, mod_ujson_load + 596 | 1, 596);
                return;
            case 596:
                b(null, 574);
                return;
            case 598:
                r1 = movs(r1, 0);
                r0 = movs(r0, r1);
                bl(this::mp_obj_new_list, mod_ujson_load + 606 | 1, 606);
                return;
            case 606:
                r5 = movs(r5, r0);
                r7 = movs(r7, 1);
                cmp(r6, 0);
                if (beq(616)) return;
            case 614:
                b(null, 218);
                return;
            case 616:
                r0 = movs(r0, r5);
                bl(this::mp_obj_get_type, mod_ujson_load + 622 | 1, 622);
                return;
            case 622:
                r6 = movs(r6, r5);
                str(sp + 12, r0);
                b(null, 50);
                return;
            case 628:
                r0 = movs(r0, 0);
                bl(this::mp_obj_new_dict, mod_ujson_load + 634 | 1, 634);
                return;
            case 634:
                b(null, 606);
                return;
            case 636:
                r3 = ldr(sp + 8);
                cmp(r3, 0);
                if (bne(652)) return;
            case 642:
                cmp(r7, 0);
                if (beq(648)) return;
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
                bl(this::mp_obj_dict_store, mod_ujson_load + 662 | 1, 662);
                return;
            case 662:
                r3 = movs(r3, 0);
                str(sp + 8, r3);
                b(null, 236);
                return;
            case 668:
                r1 = movs(r1, r6);
                r0 = add(sp, 48);
                bl(this::mp_obj_list_append, mod_ujson_load + 676 | 1, 676);
                return;
            case 676:
                b(null, 616);
                return;
            case 678:
                r0 = movs(r0, r4);
                bl(this::ujson_stream_next, mod_ujson_load + 684 | 1, 684);
                return;
            case 684:
                r0 = ldrb(r4 + 12);
                bl(this::unichar_isspace, mod_ujson_load + 690 | 1, 690);
                return;
            case 690:
                cmp(r0, 0);
                if (bne(678)) return;
            case 694:
                r3 = ldrb(r4 + 12);
                cmp(r3, 0);
                if (beq(702)) return;
            case 700:
                b(null, 92);
                return;
            case 702:
                cmp(r6, 0);
                if (bne(708)) return;
            case 706:
                b(null, 92);
                return;
            case 708:
                r3 = ldr(sp + 56);
                cmp(r3, 0);
                if (beq(716)) return;
            case 714:
                b(null, 92);
                return;
            case 716:
                r0 = add(sp, 32);
                bl(this::vstr_clear, mod_ujson_load + 722 | 1, 722);
                return;
            case 722:
                r0 = movs(r0, r6);
                sp = add(sp, 68);
                pop(true, R4, R5, R6, R7);
                return;
            case 728:
                r0 = movs(r0, r5);
                bl(this::mp_obj_get_type, mod_ujson_load + 734 | 1, 734);
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
                bl(this::mp_obj_str_get_data, mod_ujson_loads + 10 | 1, 10);
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
                r2 = ldr(mod_ujson_loads + 52); // mp_type_stringio;
                str(sp + 16, r0);
                r0 = add(sp, 24);
                str(sp + 24, r2);
                str(sp + 32, r3);
                str(sp + 36, r3);
                bl(this::mod_ujson_load, mod_ujson_loads + 46 | 1, 46);
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
                bl(this::mp_get_stream_raise, mod_ujson_dump + 14 | 1, 14);
                return;
            case 14:
                r3 = mov(mp_stream_write_adaptor | 1);
                hint(mp_stream_write_adaptor | 1, this::mp_stream_write_adaptor);
                r1 = movs(r1, r5);
                r0 = mov(sp);
                r2 = movs(r2, 3);
                str(sp, r4);
                str(sp + 4, r3);
                bl(this::mp_obj_print_helper, mod_ujson_dump + 30 | 1, 30);
                return;
            case 30:
                r0 = ldr(mod_ujson_dump + 40); // mp_const_none_obj;
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
                bl(this::vstr_init_print, mod_ujson_dumps + 16 | 1, 16);
                return;
            case 16:
                r2 = movs(r2, 3);
                r1 = movs(r1, r4);
                r0 = mov(sp);
                bl(this::mp_obj_print_helper, mod_ujson_dumps + 26 | 1, 26);
                return;
            case 26:
                r1 = add(sp, 8);
                r0 = ldr(mod_ujson_dumps + 40); // mp_type_str;
                bl(this::mp_obj_new_str_from_vstr, mod_ujson_dumps + 34 | 1, 34);
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
                r1 = ldr(match_print + 12); // match_print_str1_1;
                bl(this::mp_printf, match_print + 10 | 1, 10);
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
                r1 = ldr(re_print + 12); // re_print_str1_1;
                bl(this::mp_printf, re_print + 10 | 1, 10);
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
                if (bne(18)) return;
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
                if (beq(40)) return;
            case 36:
                cmp(r3, 41);
                if (bne(62)) return;
            case 40:
                r3 = ldr(sp + 4);
                cmp(r3, 0);
                if (beq(294)) return;
            case 46:
                cmp(r5, 0);
                if (beq(294)) return;
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
                if (bne(68)) return;
            case 66:
                b(null, 364);
                return;
            case 68:
                if (bhi(160)) return;
            case 70:
                r2 = ldr(r4);
                cmp(r3, 40);
                if (bne(78)) return;
            case 76:
                b(null, 448);
                return;
            case 78:
                if (bhi(114)) return;
            case 80:
                cmp(r3, 36);
                if (bne(86)) return;
            case 84:
                b(null, 848);
                return;
            case 86:
                r2 = movs(r2, r6);
            case 88:
                r7 = ldr(r4);
                cmp(r5, 0);
                if (bne(96)) return;
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
                if (bne(120)) return;
            case 118:
                b(null, 656);
                return;
            case 120:
                cmp(r3, 43);
                if (bne(86)) return;
            case 124:
                cmp(r2, r7);
                if (beq(292)) return;
            case 128:
                r3 = ldrb(r6 + 1);
                cmp(r3, 63);
                if (beq(136)) return;
            case 134:
                b(null, 758);
                return;
            case 136:
                cmp(r5, 0);
                if (beq(144)) return;
            case 140:
                r3 = adds(r3, 34);
                strb(r5 + r2, r3);
            case 144:
                r6 = adds(r6, 1);
                cmp(r5, 0);
                if (beq(152)) return;
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
                if (beq(284)) return;
            case 164:
                r2 = ldr(r4);
                if (bhi(234)) return;
            case 168:
                cmp(r3, 63);
                if (bne(174)) return;
            case 172:
                b(null, 582);
                return;
            case 174:
                cmp(r3, 91);
                if (bne(86)) return;
            case 178:
                r0 = ldrb(r6 + 1);
                r3 = adds(r2, 1);
                r7 = movs(r7, r2);
                r1 = adds(r6, 1);
                str(r4, r3);
                cmp(r0, 94);
                if (bne(386)) return;
            case 192:
                cmp(r5, 0);
                if (beq(200)) return;
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
                if (bne(396)) return;
            case 224:
                cmp(r5, 0);
                if (beq(354)) return;
            case 228:
                r2 = adds(r5, r2);
                strb(r2 + 1, r3);
                b(null, 354);
                return;
            case 234:
                cmp(r3, 94);
                if (bne(240)) return;
            case 238:
                b(null, 834);
                return;
            case 240:
                cmp(r3, 124);
                if (bne(86)) return;
            case 244:
                r3 = ldr(sp + 4);
                cmp(r3, 0);
                if (bne(252)) return;
            case 250:
                b(null, 780);
                return;
            case 252:
                cmp(r5, 0);
                if (bne(258)) return;
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
                bl(this::memmove, _compilecode + 282 | 1, 282);
                return;
            case 282:
                b(null, 786);
                return;
            case 284:
                r3 = ldrb(r6 + 1);
                r2 = adds(r6, 1);
                cmp(r3, 0);
                if (bne(300)) return;
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
                if (beq(322)) return;
            case 310:
                r0 = movs(r0, 4);
                r3 = bics(r3, r0);
                r3 = orrs(r3, r1);
                cmp(r3, 115);
                if (beq(322)) return;
            case 320:
                b(null, 88);
                return;
            case 322:
                r7 = ldr(r4);
                cmp(r5, 0);
                if (beq(358)) return;
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
                if (beq(378)) return;
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
                if (beq(202)) return;
            case 390:
                r3 = movs(r3, 3);
                strb(r5 + r2, r3);
                b(null, 202);
                return;
            case 396:
                cmp(r1, 0);
                if (beq(292)) return;
            case 400:
                r0 = ldr(r4);
                r1 = adds(r0, 1);
                str(r4, r1);
                cmp(r5, 0);
                if (beq(414)) return;
            case 410:
                r1 = ldrb(r6);
                strb(r5 + r0, r1);
            case 414:
                r1 = ldrb(r6 + 1);
                cmp(r1, 45);
                if (bne(428)) return;
            case 420:
                r1 = ldrb(r6 + 2);
                cmp(r1, 93);
                if (beq(428)) return;
            case 426:
                r6 = adds(r6, 2);
            case 428:
                r0 = ldr(r4);
                r1 = adds(r0, 1);
                str(r4, r1);
                cmp(r5, 0);
                if (beq(442)) return;
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
                if (bne(526)) return;
            case 456:
                r3 = ldrb(r6 + 2);
                cmp(r3, 58);
                if (bne(526)) return;
            case 462:
                r3 = movs(r3, 0);
                r6 = adds(r6, 2);
                str(sp + 16, r3);
                str(sp + 12, r3);
            case 470:
                r0 = adds(r6, 1);
                r2 = ldr(sp + 20);
                r1 = movs(r1, r4);
                bl(null, 0, _compilecode + 480 | 1, 480);
                return;
            case 480:
                r6 = subs(r0, 0);
                if (beq(292)) return;
            case 484:
                r3 = ldrb(r0);
                cmp(r3, 41);
                if (bne(292)) return;
            case 490:
                r3 = ldr(sp + 16);
                cmp(r3, 0);
                if (beq(354)) return;
            case 496:
                r3 = ldr(r4);
                cmp(r5, 0);
                if (beq(576)) return;
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
                if (beq(570)) return;
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
                if (bne(588)) return;
            case 586:
                b(null, 292);
                return;
            case 588:
                cmp(r5, 0);
                if (beq(604)) return;
            case 592:
                r0 = adds(r7, 2);
                r2 = subs(r2, r7);
                r1 = adds(r5, r7);
                r0 = adds(r5, r0);
                bl(this::memmove, _compilecode + 604 | 1, 604);
                return;
            case 604:
                r3 = ldr(r4);
                r3 = adds(r3, 2);
                str(r4, r3);
                r3 = ldrb(r6 + 1);
                cmp(r3, 63);
                if (bne(636)) return;
            case 616:
                cmp(r5, 0);
                if (beq(624)) return;
            case 620:
                r3 = adds(r3, 35);
                strb(r5 + r7, r3);
            case 624:
                r6 = adds(r6, 1);
                cmp(r5, 0);
                if (bne(644)) return;
            case 630:
                r3 = ldr(r4 + 4);
                r3 = adds(r3, 1);
                b(null, 732);
                return;
            case 636:
                cmp(r5, 0);
                if (beq(630)) return;
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
                if (bne(662)) return;
            case 660:
                b(null, 292);
                return;
            case 662:
                cmp(r5, 0);
                if (beq(678)) return;
            case 666:
                r0 = adds(r7, 2);
                r2 = subs(r2, r7);
                r1 = adds(r5, r7);
                r0 = adds(r5, r0);
                bl(this::memmove, _compilecode + 678 | 1, 678);
                return;
            case 678:
                r3 = ldr(r4);
                r3 = adds(r3, 2);
                str(r4, r3);
                cmp(r5, 0);
                if (beq(702)) return;
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
                if (bne(738)) return;
            case 714:
                cmp(r5, 0);
                if (beq(722)) return;
            case 718:
                r3 = adds(r3, 35);
                strb(r5 + r7, r3);
            case 722:
                r6 = adds(r6, 1);
                cmp(r5, 0);
                if (bne(746)) return;
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
                if (beq(728)) return;
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
                if (bne(764)) return;
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
                if (beq(786)) return;
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
                if (beq(804)) return;
            case 800:
                r3 = movs(r3, 96);
                strb(r5 + r2, r3);
            case 804:
                r3 = ldr(r4);
                str(sp + 4, r3);
                r3 = adds(r3, 1);
                str(r4, r3);
                cmp(r5, 0);
                if (beq(728)) return;
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
                if (beq(630)) return;
            case 844:
                strb(r5 + r2, r3);
                b(null, 630);
                return;
            case 848:
                r3 = adds(r2, 1);
                str(r4, r3);
                cmp(r5, 0);
                if (beq(630)) return;
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
                bl(this::mp_obj_get_int, match_group + 12 | 1, 12);
                return;
            case 12:
                cmp(r0, 0);
                if (blt(22)) return;
            case 16:
                r3 = ldr(r5 + 4);
                cmp(r3, r0);
                if (bgt(34)) return;
            case 22:
                r1 = movs(r1, r4);
                r0 = ldr(match_group + 64); // mp_type_IndexError;
                bl(this::mp_obj_new_exception_arg1, match_group + 30 | 1, 30);
                return;
            case 30:
                bl(this::nlr_jump, match_group + 34 | 1, 34);
                return;
            case 34:
                r0 = lsls(r0, 3);
                r4 = adds(r5, r0);
                r6 = ldr(r4 + 12);
                r0 = ldr(match_group + 68); // mp_const_none_obj;
                cmp(r6, 0);
                if (beq(62)) return;
            case 46:
                r0 = ldr(r5 + 8);
                bl(this::mp_obj_get_type, match_group + 52 | 1, 52);
                return;
            case 52:
                r2 = ldr(r4 + 16);
                r1 = movs(r1, r6);
                r2 = subs(r2, r6);
                bl(this::mp_obj_new_str_of_type, match_group + 62 | 1, 62);
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
                bl(this::memset, re1_5_sizecode + 14 | 1, 14);
                return;
            case 14:
                r3 = movs(r3, 10);
                r2 = movs(r2, 1);
                r1 = add(sp, 4);
                r0 = movs(r0, r4);
                str(sp + 4, r3);
                bl(this::_compilecode, re1_5_sizecode + 28 | 1, 28);
                return;
            case 28:
                cmp(r0, 0);
                if (beq(38)) return;
            case 32:
                r0 = ldr(sp + 4);
            case 34:
                sp = add(sp, 16);
                pop(true, R4);
                return;
            case 38:
                r0 = movs(r0, 1);
                r0 = rsbs(r0);
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
                r3 = ldr(re1_5_compilecode + 76);
                r0 = movs(r0, r1);
                str(r4 + 12, r3);
                r3 = ldr(re1_5_compilecode + 80);
                str(r4 + 8, r2);
                strh(r4 + 16, r3);
                strb(r4 + 18, r2);
                r1 = movs(r1, r4);
                bl(this::_compilecode, re1_5_compilecode + 34 | 1, 34);
                return;
            case 34:
                r3 = movs(r3, 1);
                cmp(r0, 0);
                if (beq(72)) return;
            case 40:
                r0 = ldrb(r0);
                cmp(r0, 0);
                if (bne(72)) return;
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
                if (bgt(30)) return;
            case 18:
                r2 = ldr(r7 + 4);
                r0 = ldr(re1_5_dumpcode + 248);
                bl(this::printf, re1_5_dumpcode + 26 | 1, 26);
                return;
            case 26:
                sp = add(sp, 20);
                pop(true, R4, R5, R6, R7);
                return;
            case 30:
                r1 = movs(r1, r5);
                r0 = ldr(re1_5_dumpcode + 252); // re1_5_dumpcode_str1_1;
                bl(this::printf, re1_5_dumpcode + 38 | 1, 38);
                return;
            case 38:
                r3 = adds(r6, r5);
                str(sp + 8, r3);
                r3 = ldrb(r3);
                r4 = adds(r5, 1);
                cmp(r3, 80);
                if (beq(240)) return;
            case 50:
                if (bhi(100)) return;
            case 52:
                cmp(r3, 4);
                if (bhi(88)) return;
            case 56:
                cmp(r3, 3);
                if (bhs(164)) return;
            case 60:
                cmp(r3, 1);
                if (beq(150)) return;
            case 64:
                r0 = ldr(re1_5_dumpcode + 256);
                cmp(r3, 2);
                if (beq(134)) return;
            case 70:
                r2 = ldrsb(r6 + r4);
                r0 = ldr(re1_5_dumpcode + 260);
                r1 = adds(r2, r4);
                r1 = adds(r1, 1);
            case 78:
                bl(this::printf, re1_5_dumpcode + 82 | 1, 82);
                return;
            case 82:
                r4 = adds(r5, 2);
            case 84:
                r5 = movs(r5, r4);
                b(null, 12);
                return;
            case 88:
                cmp(r3, 5);
                if (bne(70)) return;
            case 92:
                r5 = adds(r5, 2);
                r1 = ldrb(r6 + r4);
                r0 = ldr(re1_5_dumpcode + 264);
                b(null, 156);
                return;
            case 100:
                cmp(r3, 98);
                if (beq(140)) return;
            case 104:
                if (bhi(124)) return;
            case 106:
                cmp(r3, 81);
                if (beq(244)) return;
            case 110:
                cmp(r3, 96);
                if (bne(70)) return;
            case 114:
                r2 = ldrsb(r6 + r4);
                r0 = ldr(re1_5_dumpcode + 268);
                r1 = adds(r2, r4);
                r1 = adds(r1, 1);
                b(null, 78);
                return;
            case 124:
                cmp(r3, 126);
                if (beq(232)) return;
            case 128:
                r0 = ldr(re1_5_dumpcode + 272);
                cmp(r3, 127);
                if (bne(70)) return;
            case 134:
                bl(this::puts, re1_5_dumpcode + 138 | 1, 138);
                return;
            case 138:
                b(null, 84);
                return;
            case 140:
                r2 = ldrsb(r6 + r4);
                r0 = ldr(re1_5_dumpcode + 276);
                r1 = adds(r2, r4);
                r1 = adds(r1, 1);
                b(null, 78);
                return;
            case 150:
                r1 = ldrb(r6 + r4);
                r0 = ldr(re1_5_dumpcode + 280);
                r5 = adds(r5, 2);
            case 156:
                bl(this::printf, re1_5_dumpcode + 160 | 1, 160);
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
                r1 = ldr(re1_5_dumpcode + 284);
                cmp(r3, 4);
                if (beq(182)) return;
            case 180:
                r1 = ldr(re1_5_dumpcode + 288);
            case 182:
                r2 = ldr(sp + 4);
                r0 = ldr(re1_5_dumpcode + 292);
                bl(this::printf, re1_5_dumpcode + 190 | 1, 190);
                return;
            case 190:
                r3 = adds(r5, 2);
                r4 = ldr(sp + 8);
                r5 = ldr(sp + 4);
                str(sp + 12, r3);
            case 198:
                r4 = adds(r4, 2);
                r5 = subs(r5, 1);
                if (bhs(220)) return;
            case 204:
                r3 = ldr(sp + 4);
                r0 = movs(r0, 10);
                r4 = lsls(r3, 1);
                r3 = ldr(sp + 12);
                r4 = adds(r4, r3);
                bl(this::putchar, re1_5_dumpcode + 218 | 1, 218);
                return;
            case 218:
                b(null, 84);
                return;
            case 220:
                r2 = ldrb(r4 + 1);
                r1 = ldrb(r4);
                r0 = ldr(re1_5_dumpcode + 296);
                bl(this::printf, re1_5_dumpcode + 230 | 1, 230);
                return;
            case 230:
                b(null, 198);
                return;
            case 232:
                r5 = adds(r5, 2);
                r1 = ldrb(r6 + r4);
                r0 = ldr(re1_5_dumpcode + 300);
                b(null, 156);
                return;
            case 240:
                r0 = ldr(re1_5_dumpcode + 304);
                b(null, 134);
                return;
            case 244:
                r0 = ldr(re1_5_dumpcode + 308);
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
                bl(this::mp_obj_str_get_str, mod_re_compile + 12 | 1, 12);
                return;
            case 12:
                r6 = movs(r6, r0);
                bl(this::re1_5_sizecode, mod_re_compile + 18 | 1, 18);
                return;
            case 18:
                r3 = adds(r0, 1);
                if (bne(28)) return;
            case 22:
                r0 = ldr(mod_re_compile + 84); // mod_re_compile_str1_1;
                bl(this::mp_raise_ValueError, mod_re_compile + 28 | 1, 28);
                return;
            case 28:
                r0 = adds(r0, 16);
                bl(this::m_malloc, mod_re_compile + 34 | 1, 34);
                return;
            case 34:
                r3 = ldr(mod_re_compile + 88); // re_type;
                r4 = movs(r4, r0);
                str(r0, r3);
                r3 = ldr(sp + 4);
                r5 = movs(r5, 0);
                cmp(r3, 1);
                if (bls(56)) return;
            case 48:
                r0 = ldr(r7 + 4);
                bl(this::mp_obj_get_int, mod_re_compile + 54 | 1, 54);
                return;
            case 54:
                r5 = movs(r5, r0);
            case 56:
                r7 = adds(r4, 4);
                r1 = movs(r1, r6);
                r0 = movs(r0, r7);
                bl(this::re1_5_compilecode, mod_re_compile + 66 | 1, 66);
                return;
            case 66:
                cmp(r0, 0);
                if (bne(22)) return;
            case 70:
                r3 = lsls(r5, 19);
                if (bpl(80)) return;
            case 74:
                r0 = movs(r0, r7);
                bl(this::re1_5_dumpcode, mod_re_compile + 80 | 1, 80);
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
                if (bne(24)) return;
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
                if (bhi(46)) return;
            case 32:
                r5 = ldrb(r2 + 1);
                cmp(r5, r4);
                if (blo(46)) return;
            case 38:
                r3 = subs(r3, 3);
                r0 = rsbs(r3);
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
                if (bne(34)) return;
            case 22:
                r3 = subs(r3, 48);
                cmp(r3, 9);
                if (bls(48)) return;
            case 28:
                r0 = movs(r0, r4);
                r0 = bics(r0, r5);
                b(null, 48);
                return;
            case 34:
                cmp(r2, 115);
                if (bne(50)) return;
            case 38:
                cmp(r3, 32);
                if (beq(48)) return;
            case 42:
                r3 = subs(r3, 9);
                cmp(r3, 4);
                if (bhi(28)) return;
            case 48:
                pop(true, R4, R5, R6);
                return;
            case 50:
                r2 = movs(r2, r3);
                r2 = bics(r2, r6);
                r2 = subs(r2, 65);
                cmp(r2, 25);
                if (bls(48)) return;
            case 60:
                r2 = movs(r2, r3);
                r2 = subs(r2, 48);
                cmp(r2, 9);
                if (bls(48)) return;
            case 68:
                cmp(r3, 95);
                if (bne(28)) return;
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
                bl(this::mp_stack_check, recursiveloop + 16 | 1, 16);
                return;
            case 16:
                r3 = ldrb(r6);
                cmp(r3, 79);
                if (bhi(30)) return;
            case 22:
                r2 = ldr(r7 + 4);
                cmp(r2, r5);
                if (bhi(30)) return;
            case 28:
                b(null, 272);
                return;
            case 30:
                r4 = adds(r6, 1);
                cmp(r3, 80);
                if (bne(38)) return;
            case 36:
                b(null, 264);
                return;
            case 38:
                if (bhi(80)) return;
            case 40:
                cmp(r3, 4);
                if (bhi(60)) return;
            case 44:
                cmp(r3, 3);
                if (bhs(156)) return;
            case 48:
                cmp(r3, 1);
                if (beq(144)) return;
            case 52:
                cmp(r3, 2);
                if (beq(176)) return;
            case 56:
                r6 = movs(r6, r4);
                b(null, 16);
                return;
            case 60:
                cmp(r3, 5);
                if (bne(56)) return;
            case 64:
                r1 = movs(r1, r5);
                r0 = movs(r0, r4);
                bl(this::_re1_5_namedclassmatch, recursiveloop + 72 | 1, 72);
                return;
            case 72:
                cmp(r0, 0);
                if (bne(152)) return;
            case 76:
                sp = add(sp, 20);
                pop(true, R4, R5, R6, R7);
                return;
            case 80:
                cmp(r3, 97);
                if (beq(180)) return;
            case 84:
                if (bhi(104)) return;
            case 86:
                cmp(r3, 81);
                if (beq(276)) return;
            case 90:
                cmp(r3, 96);
                if (bne(56)) return;
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
                if (beq(216)) return;
            case 108:
                cmp(r3, 127);
                if (beq(206)) return;
            case 112:
                cmp(r3, 98);
                if (bne(56)) return;
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
                bl(null, 0, recursiveloop + 138 | 1, 138);
                return;
            case 138:
                cmp(r0, 0);
                if (bne(206)) return;
            case 142:
                b(null, 56);
                return;
            case 144:
                r2 = ldrb(r5);
                r3 = ldrb(r6 + 1);
                cmp(r2, r3);
                if (bne(272)) return;
            case 152:
                r4 = adds(r6, 2);
                b(null, 176);
                return;
            case 156:
                r1 = movs(r1, r5);
                r0 = movs(r0, r4);
                bl(this::_re1_5_classmatch, recursiveloop + 164 | 1, 164);
                return;
            case 164:
                cmp(r0, 0);
                if (beq(76)) return;
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
                bl(null, 0, recursiveloop + 202 | 1, 202);
                return;
            case 202:
                cmp(r0, 0);
                if (beq(210)) return;
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
                if (bge(56)) return;
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
                bl(null, 0, recursiveloop + 254 | 1, 254);
                return;
            case 254:
                cmp(r0, 0);
                if (bne(206)) return;
            case 258:
                r3 = ldr(sp + 12);
                str(r6, r3);
                b(null, 76);
                return;
            case 264:
                r3 = ldr(r7);
            case 266:
                cmp(r3, r5);
                if (bne(272)) return;
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
                if (beq(12)) return;
            case 10:
                r0 = adds(r0, 5);
            case 12:
                str(sp, r3);
                r3 = movs(r3, r2);
                r2 = movs(r2, r1);
                r1 = ldr(r1);
                bl(this::recursiveloop, re1_5_recursiveloopprog + 24 | 1, 24);
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
                bl(this::mp_obj_str_get_data, ure_exec_isra_2 + 18 | 1, 18);
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
                bl(this::m_malloc, ure_exec_isra_2 + 44 | 1, 44);
                return;
            case 44:
                r3 = movs(r3, r0);
                r3 = adds(r3, 12);
                r2 = lsls(r7, 3);
                r1 = movs(r1, 0);
                r4 = movs(r4, r0);
                r0 = movs(r0, r3);
                str(sp + 16, r3);
                bl(this::memset, ure_exec_isra_2 + 62 | 1, 62);
                return;
            case 62:
                r3 = ldr(sp + 20);
                r0 = adds(r5, 4);
                str(sp, r3);
                r2 = ldr(sp + 16);
                r3 = lsls(r7, 1);
                r1 = add(sp, 32);
                bl(this::re1_5_recursiveloopprog, ure_exec_isra_2 + 78 | 1, 78);
                return;
            case 78:
                cmp(r0, 0);
                if (bne(98)) return;
            case 82:
                r0 = movs(r0, r4);
                r1 = ldr(sp + 12);
                bl(this::m_free, ure_exec_isra_2 + 90 | 1, 90);
                return;
            case 90:
                r4 = ldr(ure_exec_isra_2 + 112); // mp_const_none_obj;
            case 92:
                r0 = movs(r0, r4);
                sp = add(sp, 44);
                pop(true, R4, R5, R6, R7);
                return;
            case 98:
                r3 = ldr(ure_exec_isra_2 + 116); // match_type;
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
                bl(this::ure_exec_isra_2, re_match + 8 | 1, 8);
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
                bl(this::ure_exec_isra_2, re_search + 8 | 1, 8);
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
                bl(this::mod_re_compile, mod_re_match + 10 | 1, 10);
                return;
            case 10:
                r3 = ldr(r4 + 4);
                str(sp + 8, r0);
                r1 = add(sp, 8);
                r0 = movs(r0, 1);
                str(sp + 4, r3);
                str(sp + 12, r3);
                bl(this::ure_exec_isra_2, mod_re_match + 26 | 1, 26);
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
                bl(this::mod_re_compile, mod_re_search + 10 | 1, 10);
                return;
            case 10:
                r3 = ldr(r4 + 4);
                str(sp + 8, r0);
                r1 = add(sp, 8);
                r0 = movs(r0, 0);
                str(sp + 4, r3);
                str(sp + 12, r3);
                bl(this::ure_exec_isra_2, mod_re_search + 26 | 1, 26);
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
                bl(this::mp_obj_get_type, re_split + 16 | 1, 16);
                return;
            case 16:
                r1 = add(sp, 28);
                str(sp + 16, r0);
                r0 = ldr(r4 + 4);
                bl(this::mp_obj_str_get_data, re_split + 26 | 1, 26);
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
                if (bls(56)) return;
            case 48:
                r0 = ldr(r4 + 8);
                bl(this::mp_obj_get_int, re_split + 54 | 1, 54);
                return;
            case 54:
                r5 = movs(r5, r0);
            case 56:
                r1 = movs(r1, 0);
                r0 = movs(r0, r1);
                bl(this::mp_obj_new_list, re_split + 64 | 1, 64);
                return;
            case 64:
                r3 = ldr(sp + 20);
                r7 = movs(r7, r0);
                r3 = lsls(r3, 2);
                r0 = movs(r0, r3);
                str(sp + 12, r3);
                bl(this::mp_pystack_alloc, re_split + 78 | 1, 78);
                return;
            case 78:
                r4 = movs(r4, r0);
            case 80:
                r2 = ldr(sp + 12);
                r1 = movs(r1, 0);
                r0 = movs(r0, r4);
                bl(this::memset, re_split + 90 | 1, 90);
                return;
            case 90:
                r3 = movs(r3, 0);
                r0 = adds(r6, 4);
                str(sp, r3);
                r2 = movs(r2, r4);
                r3 = ldr(sp + 20);
                r1 = add(sp, 32);
                bl(this::re1_5_recursiveloopprog, re_split + 106 | 1, 106);
                return;
            case 106:
                cmp(r0, 0);
                if (beq(162)) return;
            case 110:
                r2 = ldr(r4);
                r3 = ldr(r4 + 4);
                r1 = ldr(sp + 32);
                cmp(r2, r3);
                if (beq(162)) return;
            case 120:
                r2 = subs(r2, r1);
                r0 = ldr(sp + 16);
                bl(this::mp_obj_new_str_of_type, re_split + 128 | 1, 128);
                return;
            case 128:
                r1 = movs(r1, r0);
                r0 = movs(r0, r7);
                bl(this::mp_obj_list_append, re_split + 136 | 1, 136);
                return;
            case 136:
                r3 = ldr(r6 + 12);
                cmp(r3, 0);
                if (ble(148)) return;
            case 142:
                r0 = ldr(re_split + 196); // re_split_str1_1;
                bl(this::mp_raise_NotImplementedError, re_split + 148 | 1, 148);
                return;
            case 148:
                r3 = ldr(r4 + 4);
                str(sp + 32, r3);
                cmp(r5, 0);
                if (ble(80)) return;
            case 156:
                r5 = subs(r5, 1);
                cmp(r5, 0);
                if (bne(80)) return;
            case 162:
                r3 = ldr(re_split + 200); // mp_state_ctx;
                r2 = ldr(sp + 36);
                str(r3 + 16, r4);
                r3 = ldr(sp + 32);
                r0 = ldr(sp + 16);
                r1 = movs(r1, r3);
                r2 = subs(r2, r3);
                bl(this::mp_obj_new_str_of_type, re_split + 180 | 1, 180);
                return;
            case 180:
                r1 = movs(r1, r0);
                r0 = movs(r0, r7);
                bl(this::mp_obj_list_append, re_split + 188 | 1, 188);
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
                if (bne(12)) return;
            case 20:
                r4 = movs(r4, r1);
                r6 = adds(r1, r2);
            case 24:
                cmp(r6, r4);
                if (bne(58)) return;
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
                if (bne(34)) return;
            case 48:
                r4 = movs(r4, 0);
            case 50:
                cmp(r4, r2);
                if (bne(74)) return;
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
                if (beq(98)) return;
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
                blx(r5, read_src_stream + 24 | 1, 24);
                return;
            case 24:
                r3 = adds(r0, 1);
                if (bne(34)) return;
            case 28:
                r0 = ldr(sp + 4);
                bl(this::mp_raise_OSError, read_src_stream + 34 | 1, 34);
                return;
            case 34:
                cmp(r0, 0);
                if (bne(48)) return;
            case 38:
                r0 = ldr(read_src_stream + 52); // mp_type_EOFError;
                bl(this::mp_obj_new_exception, read_src_stream + 44 | 1, 44);
                return;
            case 44:
                bl(this::nlr_jump, read_src_stream + 48 | 1, 48);
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
                if (beq(16)) return;
            case 8:
                r2 = adds(r3, 1);
                str(r0, r2);
                r0 = ldrb(r3);
            case 14:
                pop(true, R4);
                return;
            case 16:
                r3 = ldr(r0 + 4);
                blx(r3, uzlib_get_byte + 20 | 1, 20);
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
                if (bne(24)) return;
            case 14:
                bl(this::uzlib_get_byte, tinf_getbit + 18 | 1, 18);
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
                if (beq(22)) return;
            case 12:
                r4 = movs(r4, 1);
                r6 = movs(r6, r4);
                r6 = lsls(r6, r1);
            case 18:
                cmp(r4, r6);
                if (blo(28)) return;
            case 22:
                r3 = ldr(sp + 4);
                r0 = adds(r3, r5);
                pop(true, R1, R2, R3, R4, R5, R6, R7);
                return;
            case 28:
                r0 = movs(r0, r7);
                bl(this::tinf_getbit, tinf_read_bits + 34 | 1, 34);
                return;
            case 34:
                cmp(r0, 0);
                if (beq(40)) return;
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
                bl(this::tinf_getbit, tinf_decode_symbol + 18 | 1, 18);
                return;
            case 18:
                r5 = lsls(r5, 1);
                r5 = adds(r5, r0);
                r0 = ldrh(r6);
                r6 = adds(r6, 2);
                r4 = adds(r4, r0);
                r5 = subs(r5, r0);
                if (bpl(12)) return;
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
                bl(this::tinf_read_bits, tinf_decode_trees + 20 | 1, 20);
                return;
            case 20:
                r2 = movs(r2, 1);
                str(sp, r0);
                r1 = movs(r1, 5);
                r0 = movs(r0, r5);
                bl(this::tinf_read_bits, tinf_decode_trees + 32 | 1, 32);
                return;
            case 32:
                r2 = movs(r2, 4);
                str(sp + 4, r0);
                r1 = movs(r1, r2);
                r0 = movs(r0, r5);
                bl(this::tinf_read_bits, tinf_decode_trees + 44 | 1, 44);
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
                if (bne(50)) return;
            case 60:
                r4 = movs(r4, 0);
            case 62:
                cmp(r4, r6);
                if (bne(118)) return;
            case 66:
                r2 = movs(r2, 19);
                r1 = add(sp, 16);
                r0 = movs(r0, r7);
                bl(this::tinf_build_tree, tinf_decode_trees + 76 | 1, 76);
                return;
            case 76:
                r4 = movs(r4, 0);
            case 78:
                r3 = ldr(sp);
                r2 = ldr(sp + 4);
                r3 = adds(r3, r2);
                cmp(r3, r4);
                if (bhi(140)) return;
            case 88:
                r2 = ldr(sp);
                r1 = add(sp, 16);
                r0 = movs(r0, r7);
                bl(this::tinf_build_tree, tinf_decode_trees + 98 | 1, 98);
                return;
            case 98:
                r3 = ldr(sp);
                r2 = add(sp, 16);
                r3 = adds(r3, r2);
                r1 = movs(r1, r3);
                r2 = ldr(sp + 4);
                r0 = ldr(sp + 12);
                bl(this::tinf_build_tree, tinf_decode_trees + 114 | 1, 114);
                return;
            case 114:
                sp = add(sp, 340);
                pop(true, R4, R5, R6, R7);
                return;
            case 118:
                r2 = movs(r2, 0);
                r1 = movs(r1, 3);
                r0 = movs(r0, r5);
                bl(this::tinf_read_bits, tinf_decode_trees + 128 | 1, 128);
                return;
            case 128:
                r3 = ldr(tinf_decode_trees + 264); // clcidx;
                r2 = add(sp, 16);
                r3 = ldrb(r4 + r3);
                r4 = adds(r4, 1);
                strb(r2 + r3, r0);
                b(null, 62);
                return;
            case 140:
                r1 = movs(r1, r7);
                r0 = movs(r0, r5);
                bl(this::tinf_decode_symbol, tinf_decode_trees + 148 | 1, 148);
                return;
            case 148:
                cmp(r0, 17);
                if (beq(198)) return;
            case 152:
                cmp(r0, 18);
                if (beq(226)) return;
            case 156:
                cmp(r0, 16);
                if (bne(254)) return;
            case 160:
                r3 = add(sp, 16);
                r6 = adds(r4, r3);
                r3 = subs(r6, 1);
                r3 = ldrb(r3);
                r2 = movs(r2, 3);
                r1 = movs(r1, 2);
                r0 = movs(r0, r5);
                str(sp + 8, r3);
                bl(this::tinf_read_bits, tinf_decode_trees + 180 | 1, 180);
                return;
            case 180:
                r3 = movs(r3, 0);
            case 182:
                cmp(r0, r3);
                if (bne(190)) return;
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
                bl(this::tinf_read_bits, tinf_decode_trees + 208 | 1, 208);
                return;
            case 208:
                r3 = movs(r3, 0);
                r1 = add(sp, 16);
                r2 = adds(r4, r1);
                r1 = movs(r1, r3);
            case 216:
                cmp(r0, r3);
                if (beq(186)) return;
            case 220:
                strb(r2 + r3, r1);
                r3 = adds(r3, 1);
                b(null, 216);
                return;
            case 226:
                r2 = movs(r2, 11);
                r1 = movs(r1, 7);
                r0 = movs(r0, r5);
                bl(this::tinf_read_bits, tinf_decode_trees + 236 | 1, 236);
                return;
            case 236:
                r3 = movs(r3, 0);
                r1 = add(sp, 16);
                r2 = adds(r4, r1);
                r1 = movs(r1, r3);
            case 244:
                cmp(r0, r3);
                if (beq(186)) return;
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
                if (bne(16)) return;
            case 14:
                pop(true, R4, R5, R6);
                return;
            case 16:
                r4 = lsrs(r0, 8);
                r0 = movs(r0, r6);
                bl(this::uzlib_get_byte, tinf_get_le_uint32 + 24 | 1, 24);
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
                if (bne(16)) return;
            case 14:
                pop(true, R4, R5, R6);
                return;
            case 16:
                r4 = lsls(r0, 8);
                r0 = movs(r0, r6);
                bl(this::uzlib_get_byte, tinf_get_be_uint32 + 24 | 1, 24);
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
                if (beq(16)) return;
            case 14:
                b(null, 292);
                return;
            case 16:
                r0 = movs(r0, r4);
                bl(this::tinf_getbit, uzlib_uncompress + 22 | 1, 22);
                return;
            case 22:
                r2 = movs(r2, 0);
                str(r4 + 44, r0);
                r1 = movs(r1, 2);
                r0 = movs(r0, r4);
                bl(this::tinf_read_bits, uzlib_uncompress + 34 | 1, 34);
                return;
            case 34:
                str(r4 + 40, r0);
                cmp(r0, 1);
                if (bne(272)) return;
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
                if (bne(96)) return;
            case 108:
                r1 = movs(r1, r4);
                r3 = movs(r3, 0);
                r1 = adds(r1, 148);
            case 114:
                strh(r1, r3);
                r3 = adds(r3, 1);
                r1 = adds(r1, 2);
                cmp(r3, 144);
                if (bne(114)) return;
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
                if (bne(190)) return;
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
                if (bne(230)) return;
            case 240:
                r3 = ldr(r4 + 48);
                cmp(r3, 0);
                if (beq(248)) return;
            case 246:
                b(null, 576);
                return;
            case 248:
                r1 = movs(r1, r4);
                r0 = movs(r0, r4);
                r1 = adds(r1, 68);
                bl(this::tinf_decode_symbol, uzlib_uncompress + 258 | 1, 258);
                return;
            case 258:
                cmp(r0, 255);
                if (bgt(434)) return;
            case 262:
                r3 = ldr(r4 + 24);
                r0 = uxtb(r0);
                r2 = adds(r3, 1);
                str(r4 + 24, r2);
                b(null, 392);
                return;
            case 272:
                cmp(r0, 2);
                if (bne(292)) return;
            case 276:
                r3 = movs(r3, 169);
                r1 = movs(r1, r4);
                r3 = lsls(r3, 2);
                r2 = adds(r4, r3);
                r1 = adds(r1, 68);
                r0 = movs(r0, r4);
                bl(this::tinf_decode_trees, uzlib_uncompress + 292 | 1, 292);
                return;
            case 292:
                r3 = ldr(r4 + 40);
                cmp(r3, 0);
                if (beq(310)) return;
            case 298:
                if (blt(304)) return;
            case 300:
                cmp(r3, 2);
                if (ble(240)) return;
            case 304:
                r0 = movs(r0, 3);
            case 306:
                r0 = rsbs(r0);
                b(null, 612);
                return;
            case 310:
                r3 = ldr(r4 + 48);
                str(sp + 4, r3);
                cmp(r3, 0);
                if (bne(370)) return;
            case 318:
                r0 = movs(r0, r4);
                bl(this::uzlib_get_byte, uzlib_uncompress + 324 | 1, 324);
                return;
            case 324:
                r7 = movs(r7, r0);
                r0 = movs(r0, r4);
                bl(this::uzlib_get_byte, uzlib_uncompress + 332 | 1, 332);
                return;
            case 332:
                r5 = lsls(r0, 8);
                r0 = movs(r0, r4);
                bl(this::uzlib_get_byte, uzlib_uncompress + 340 | 1, 340);
                return;
            case 340:
                r5 = adds(r5, r7);
                r7 = movs(r7, r0);
                r0 = movs(r0, r4);
                bl(this::uzlib_get_byte, uzlib_uncompress + 350 | 1, 350);
                return;
            case 350:
                r0 = lsls(r0, 8);
                r7 = adds(r0, r7);
                r0 = ldr(uzlib_uncompress + 620);
                r7 = eors(r7, r0);
                cmp(r5, r7);
                if (bne(304)) return;
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
                if (beq(602)) return;
            case 380:
                r0 = movs(r0, r4);
                bl(this::uzlib_get_byte, uzlib_uncompress + 386 | 1, 386);
                return;
            case 386:
                r3 = ldr(r4 + 24);
                r2 = adds(r3, 1);
                str(r4 + 24, r2);
            case 392:
                strb(r3, r0);
                r2 = ldr(r4 + 56);
                cmp(r2, 0);
                if (beq(420)) return;
            case 400:
                r3 = ldr(r4 + 64);
                r1 = adds(r3, 1);
                str(r4 + 64, r1);
                strb(r2 + r3, r0);
                r3 = ldr(r4 + 64);
                r2 = ldr(r4 + 60);
                cmp(r3, r2);
                if (bne(420)) return;
            case 416:
                r3 = movs(r3, 0);
                str(r4 + 64, r3);
            case 420:
                r3 = ldr(r4 + 20);
                r0 = subs(r3, 1);
                str(r4 + 20, r0);
                cmp(r0, 0);
                if (beq(432)) return;
            case 430:
                b(null, 8);
                return;
            case 432:
                b(null, 612);
                return;
            case 434:
                cmp(r0, r6);
                if (beq(602)) return;
            case 438:
                r0 = subs(r0, 2);
                r0 = subs(r0, 255);
                r3 = ldr(uzlib_uncompress + 624); // length_base;
                r2 = lsls(r0, 1);
                r2 = ldrh(r2 + r3);
                r3 = ldr(uzlib_uncompress + 628); // length_bits;
                r1 = ldrb(r3 + r0);
                r0 = movs(r0, r4);
                bl(this::tinf_read_bits, uzlib_uncompress + 458 | 1, 458);
                return;
            case 458:
                r3 = movs(r3, 169);
                r3 = lsls(r3, 2);
                r1 = adds(r4, r3);
                str(r4 + 48, r0);
                r0 = movs(r0, r4);
                bl(this::tinf_decode_symbol, uzlib_uncompress + 472 | 1, 472);
                return;
            case 472:
                r3 = ldr(uzlib_uncompress + 632); // dist_base;
                r2 = lsls(r0, 1);
                r2 = ldrh(r2 + r3);
                r3 = ldr(uzlib_uncompress + 636); // dist_bits;
                r1 = ldrb(r3 + r0);
                r0 = movs(r0, r4);
                bl(this::tinf_read_bits, uzlib_uncompress + 488 | 1, 488);
                return;
            case 488:
                r3 = ldr(r4 + 56);
                cmp(r3, 0);
                if (beq(598)) return;
            case 494:
                r2 = ldr(r4 + 60);
                cmp(r0, r2);
                if (bhi(614)) return;
            case 500:
                r1 = ldr(r4 + 64);
                r0 = subs(r1, r0);
                if (bmi(572)) return;
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
                if (beq(548)) return;
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
                if (bne(548)) return;
            case 544:
                r3 = movs(r3, 0);
                str(r4 + 64, r3);
            case 548:
                r3 = ldr(r4 + 52);
                r2 = ldr(r4 + 60);
                r3 = adds(r3, 1);
                str(r4 + 52, r3);
                cmp(r3, r2);
                if (bne(564)) return;
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
                if (bne(510)) return;
            case 586:
                r3 = ldrb(r2 + r0);
                strb(r2, r3);
                r3 = ldr(r4 + 24);
                r3 = adds(r3, 1);
                str(r4 + 24, r3);
                b(null, 564);
                return;
            case 598:
                r0 = rsbs(r0);
                b(null, 574);
                return;
            case 602:
                r3 = ldr(r4 + 44);
                cmp(r3, 0);
                if (bne(610)) return;
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
                bl(this::uzlib_get_byte, uzlib_zlib_parse_header + 8 | 1, 8);
                return;
            case 8:
                r4 = movs(r4, r0);
                r0 = movs(r0, r5);
                bl(this::uzlib_get_byte, uzlib_zlib_parse_header + 16 | 1, 16);
                return;
            case 16:
                r6 = movs(r6, r0);
                r0 = lsls(r4, 8);
                r0 = adds(r0, r6);
                r1 = movs(r1, 31);
                bl(this::__aeabi_idivmod, uzlib_zlib_parse_header + 28 | 1, 28);
                return;
            case 28:
                cmp(r1, 0);
                if (bne(62)) return;
            case 32:
                r3 = movs(r3, 15);
                r3 = ands(r3, r4);
                cmp(r3, 8);
                if (bne(62)) return;
            case 40:
                r4 = lsrs(r4, 4);
                r0 = uxtb(r4);
                cmp(r0, 7);
                if (bhi(62)) return;
            case 48:
                r3 = lsls(r6, 26);
                if (bmi(62)) return;
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
                r0 = rsbs(r0);
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
                if (bhs(12)) return;
            case 10:
                pop(true, R4, R5, R6);
                return;
            case 12:
                r0 = movs(r0, r5);
                bl(this::uzlib_get_byte, tinf_skip_bytes + 18 | 1, 18);
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
                bl(this::uzlib_get_byte, tinf_get_uint16 + 8 | 1, 8);
                return;
            case 8:
                r5 = movs(r5, r0);
                r0 = movs(r0, r4);
                bl(this::uzlib_get_byte, tinf_get_uint16 + 16 | 1, 16);
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
                bl(this::uzlib_get_byte, uzlib_gzip_parse_header + 8 | 1, 8);
                return;
            case 8:
                r6 = movs(r6, r0);
                cmp(r0, 31);
                if (beq(20)) return;
            case 14:
                r0 = movs(r0, 3);
                r0 = rsbs(r0);
            case 18:
                pop(true, R4, R5, R6);
                return;
            case 20:
                r0 = movs(r0, r4);
                bl(this::uzlib_get_byte, uzlib_gzip_parse_header + 26 | 1, 26);
                return;
            case 26:
                cmp(r0, 139);
                if (bne(14)) return;
            case 30:
                r0 = movs(r0, r4);
                bl(this::uzlib_get_byte, uzlib_gzip_parse_header + 36 | 1, 36);
                return;
            case 36:
                cmp(r0, 8);
                if (bne(14)) return;
            case 40:
                r0 = movs(r0, r4);
                bl(this::uzlib_get_byte, uzlib_gzip_parse_header + 46 | 1, 46);
                return;
            case 46:
                r3 = movs(r3, r0);
                r3 = bics(r3, r6);
                r3 = uxtb(r3);
                r5 = movs(r5, r0);
                cmp(r3, 0);
                if (bne(14)) return;
            case 58:
                r1 = movs(r1, 6);
                r0 = movs(r0, r4);
                bl(this::tinf_skip_bytes, uzlib_gzip_parse_header + 66 | 1, 66);
                return;
            case 66:
                r3 = lsls(r5, 29);
                if (bpl(84)) return;
            case 70:
                r0 = movs(r0, r4);
                bl(this::tinf_get_uint16, uzlib_gzip_parse_header + 76 | 1, 76);
                return;
            case 76:
                r1 = movs(r1, r0);
                r0 = movs(r0, r4);
                bl(this::tinf_skip_bytes, uzlib_gzip_parse_header + 84 | 1, 84);
                return;
            case 84:
                r3 = lsls(r5, 28);
                if (bpl(98)) return;
            case 88:
                r0 = movs(r0, r4);
                bl(this::uzlib_get_byte, uzlib_gzip_parse_header + 94 | 1, 94);
                return;
            case 94:
                cmp(r0, 0);
                if (bne(88)) return;
            case 98:
                r3 = lsls(r5, 27);
                if (bpl(112)) return;
            case 102:
                r0 = movs(r0, r4);
                bl(this::uzlib_get_byte, uzlib_gzip_parse_header + 108 | 1, 108);
                return;
            case 108:
                cmp(r0, 0);
                if (bne(102)) return;
            case 112:
                r6 = movs(r6, 2);
                tst(r5, r6);
                if (beq(124)) return;
            case 118:
                r0 = movs(r0, r4);
                bl(this::tinf_get_uint16, uzlib_gzip_parse_header + 124 | 1, 124);
                return;
            case 124:
                r3 = adds(r4, 5);
                strb(r3 + 31, r6);
                r3 = movs(r3, 1);
                r3 = rsbs(r3);
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
                bl(this::mp_arg_check_num, decompio_make_new + 26 | 1, 26);
                return;
            case 26:
                r1 = movs(r1, 1);
                r0 = ldr(r6);
                bl(this::mp_get_stream_raise, decompio_make_new + 34 | 1, 34);
                return;
            case 34:
                r0 = movs(r0, 162);
                r0 = lsls(r0, 3);
                bl(this::m_malloc, decompio_make_new + 42 | 1, 42);
                return;
            case 42:
                str(r0, r5);
                r5 = movs(r5, r0);
                r4 = movs(r4, r0);
                r5 = adds(r5, 8);
                r2 = ldr(decompio_make_new + 168);
                r1 = movs(r1, r7);
                r0 = movs(r0, r5);
                bl(this::memset, decompio_make_new + 60 | 1, 60);
                return;
            case 60:
                r3 = mov(read_src_stream | 1);
                hint(read_src_stream | 1, this::read_src_stream);
                str(r4 + 12, r3);
                r3 = ldr(r6);
                str(r4 + 4, r3);
                r3 = ldr(decompio_make_new + 176);
                strb(r4 + r3, r7);
                r3 = ldr(sp + 12);
                cmp(r3, 1);
                if (bhi(94)) return;
            case 78:
                r0 = movs(r0, r5);
                bl(this::uzlib_zlib_parse_header, decompio_make_new + 84 | 1, 84);
                return;
            case 84:
                cmp(r0, 0);
                if (bge(132)) return;
            case 88:
                r0 = ldr(decompio_make_new + 180); // decompio_make_new_str1_1;
                bl(this::mp_raise_ValueError, decompio_make_new + 94 | 1, 94);
                return;
            case 94:
                r0 = ldr(r6 + 4);
                bl(this::mp_obj_get_int, decompio_make_new + 100 | 1, 100);
                return;
            case 100:
                r6 = movs(r6, r0);
                cmp(r0, 15);
                if (ble(124)) return;
            case 106:
                r0 = movs(r0, r5);
                bl(this::uzlib_gzip_parse_header, decompio_make_new + 112 | 1, 112);
                return;
            case 112:
                r6 = subs(r6, 16);
                cmp(r0, 0);
                if (bne(88)) return;
            case 118:
                r5 = movs(r5, 1);
                r5 = lsls(r5, r6);
                b(null, 136);
                return;
            case 124:
                cmp(r0, 0);
                if (bge(78)) return;
            case 128:
                r6 = rsbs(r0);
                b(null, 118);
                return;
            case 132:
                r5 = movs(r5, 1);
                r5 = lsls(r5, r0);
            case 136:
                r0 = movs(r0, r5);
                bl(this::m_malloc, decompio_make_new + 142 | 1, 142);
                return;
            case 142:
                r2 = movs(r2, 1);
                r3 = movs(r3, 0);
                str(r4 + 64, r0);
                r0 = movs(r0, r4);
                r2 = rsbs(r2);
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
                if (bne(20)) return;
            case 14:
                r0 = lsls(r4, 16);
                r0 = orrs(r0, r5);
                pop(true, R1, R2, R3, R4, R5, R6, R7);
                return;
            case 20:
                r3 = ldr(uzlib_adler32 + 196);
                r7 = movs(r7, r6);
                cmp(r6, r3);
                if (bls(30)) return;
            case 28:
                r7 = movs(r7, r3);
            case 30:
                r1 = asrs(r7, 4);
                r2 = movs(r2, r1);
                r3 = ldr(sp + 4);
            case 36:
                cmp(r2, 0);
                if (bne(82)) return;
            case 40:
                r3 = ldr(sp + 4);
                r1 = lsls(r1, 4);
                r1 = adds(r3, r1);
                r3 = movs(r3, 15);
                r3 = ands(r3, r7);
                r3 = adds(r1, r3);
            case 52:
                cmp(r1, r3);
                if (bne(184)) return;
            case 56:
                str(sp + 4, r1);
                r0 = movs(r0, r5);
                r1 = ldr(uzlib_adler32 + 200);
                bl(this::__aeabi_uidivmod, uzlib_adler32 + 66 | 1, 66);
                return;
            case 66:
                r0 = movs(r0, r4);
                r5 = movs(r5, r1);
                r1 = ldr(uzlib_adler32 + 200);
                bl(this::__aeabi_uidivmod, uzlib_adler32 + 76 | 1, 76);
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
                r4 = ldr(uzlib_crc32 + 52); // tinf_crc32tab;
            case 12:
                cmp(r3, r1);
                if (bne(18)) return;
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
                bl(this::uzlib_uncompress, uzlib_uncompress_chksum + 10 | 1, 10);
                return;
            case 10:
                r5 = subs(r0, 0);
                if (blt(26)) return;
            case 14:
                r3 = adds(r4, 5);
                r3 = ldrb(r3 + 31);
                cmp(r3, 1);
                if (beq(30)) return;
            case 22:
                cmp(r3, 2);
                if (beq(66)) return;
            case 26:
                r0 = movs(r0, r5);
                pop(true, R4, R5, R6);
                return;
            case 30:
                r3 = ldr(r4 + 24);
                r2 = ldr(r4 + 32);
                r1 = subs(r3, r6);
                r0 = movs(r0, r6);
                bl(this::uzlib_adler32, uzlib_uncompress_chksum + 42 | 1, 42);
                return;
            case 42:
                str(r4 + 32, r0);
                cmp(r5, 1);
                if (bne(26)) return;
            case 48:
                r0 = movs(r0, r4);
                bl(this::tinf_get_be_uint32, uzlib_uncompress_chksum + 54 | 1, 54);
                return;
            case 54:
                r3 = ldr(r4 + 32);
                cmp(r3, r0);
                if (beq(26)) return;
            case 60:
                r5 = movs(r5, 4);
                r5 = rsbs(r5);
                b(null, 26);
                return;
            case 66:
                r3 = ldr(r4 + 24);
                r2 = ldr(r4 + 32);
                r1 = subs(r3, r6);
                r0 = movs(r0, r6);
                bl(this::uzlib_crc32, uzlib_uncompress_chksum + 78 | 1, 78);
                return;
            case 78:
                str(r4 + 32, r0);
                cmp(r5, 1);
                if (bne(26)) return;
            case 84:
                r0 = movs(r0, r4);
                bl(this::tinf_get_le_uint32, uzlib_uncompress_chksum + 90 | 1, 90);
                return;
            case 90:
                r3 = ldr(r4 + 32);
                r3 = mvns(r3, r3);
                cmp(r3, r0);
                if (bne(60)) return;
            case 98:
                r0 = movs(r0, r4);
                bl(this::tinf_get_le_uint32, uzlib_uncompress_chksum + 104 | 1, 104);
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
                r6 = ldr(decompio_read + 56);
                r4 = movs(r4, r0);
                r7 = movs(r7, r3);
                r3 = ldrb(r0 + r6);
                r0 = movs(r0, 0);
                r5 = movs(r5, r1);
                cmp(r3, r0);
                if (bne(54)) return;
            case 18:
                r0 = movs(r0, r4);
                str(r4 + 32, r1);
                str(r4 + 28, r2);
                r0 = adds(r0, 8);
                bl(this::uzlib_uncompress_chksum, decompio_read + 30 | 1, 30);
                return;
            case 30:
                cmp(r0, 1);
                if (bne(42)) return;
            case 34:
                strb(r4 + r6, r0);
            case 36:
                r0 = ldr(r4 + 32);
                r0 = subs(r0, r5);
                b(null, 54);
                return;
            case 42:
                cmp(r0, 0);
                if (bge(36)) return;
            case 46:
                r3 = movs(r3, 22);
                r0 = movs(r0, 1);
                str(r7, r3);
                r0 = rsbs(r0);
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
                bl(this::mp_get_buffer_raise, mod_uzlib_decompress + 18 | 1, 18);
                return;
            case 18:
                r0 = ldr(mod_uzlib_decompress + 188);
                bl(this::m_malloc, mod_uzlib_decompress + 24 | 1, 24);
                return;
            case 24:
                r2 = ldr(mod_uzlib_decompress + 188);
                r1 = movs(r1, 0);
                r4 = movs(r4, r0);
                bl(this::memset, mod_uzlib_decompress + 34 | 1, 34);
                return;
            case 34:
                r3 = movs(r3, 1);
                r5 = ldr(sp + 16);
                r3 = rsbs(r3);
                str(r4 + 40, r3);
                r5 = adds(r5, 15);
                r3 = adds(r3, 16);
                r5 = bics(r5, r3);
                r0 = movs(r0, r5);
                bl(this::m_malloc, mod_uzlib_decompress + 54 | 1, 54);
                return;
            case 54:
                r3 = ldr(sp + 12);
                r6 = movs(r6, r0);
                str(r4, r3);
                r3 = ldr(sp + 4);
                str(r4 + 24, r0);
                str(r4 + 20, r5);
                cmp(r3, 1);
                if (bls(76)) return;
            case 70:
                r3 = ldr(r7 + 4);
                cmp(r3, 0);
                if (blt(86)) return;
            case 76:
                r0 = movs(r0, r4);
                bl(this::uzlib_zlib_parse_header, mod_uzlib_decompress + 82 | 1, 82);
                return;
            case 82:
                cmp(r0, 0);
                if (blt(136)) return;
            case 86:
                r0 = movs(r0, r4);
                bl(this::uzlib_uncompress_chksum, mod_uzlib_decompress + 92 | 1, 92);
                return;
            case 92:
                cmp(r0, 0);
                if (blt(136)) return;
            case 96:
                r3 = ldr(r4 + 24);
                r7 = subs(r3, r6);
                cmp(r0, 1);
                if (beq(152)) return;
            case 104:
                r3 = adds(r5, 1);
                r3 = adds(r3, 255);
                r2 = movs(r2, r3);
                r1 = movs(r1, r5);
                r0 = movs(r0, r6);
                str(sp + 4, r3);
                bl(this::m_realloc, mod_uzlib_decompress + 120 | 1, 120);
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
                r0 = ldr(mod_uzlib_decompress + 192); // mp_type_ValueError;
                bl(this::mp_obj_new_exception_arg1, mod_uzlib_decompress + 148 | 1, 148);
                return;
            case 148:
                bl(this::nlr_jump, mod_uzlib_decompress + 152 | 1, 152);
                return;
            case 152:
                r2 = movs(r2, r7);
                r1 = movs(r1, r5);
                r0 = movs(r0, r6);
                bl(this::m_realloc, mod_uzlib_decompress + 162 | 1, 162);
                return;
            case 162:
                r1 = movs(r1, r0);
                r0 = movs(r0, r7);
                bl(this::mp_obj_new_bytearray_by_ref, mod_uzlib_decompress + 170 | 1, 170);
                return;
            case 170:
                r5 = movs(r5, r0);
                r1 = ldr(mod_uzlib_decompress + 188);
                r0 = movs(r0, r4);
                bl(this::m_free, mod_uzlib_decompress + 180 | 1, 180);
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
                if (bne(14)) return;
            case 6:
                r3 = ldr(get_heap + 24); // mp_type_list;
                r2 = ldr(r0);
                cmp(r2, r3);
                if (beq(20)) return;
            case 14:
                r0 = ldr(get_heap + 28); // get_heap_str1_1;
                bl(this::mp_raise_TypeError, get_heap + 20 | 1, 20);
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
                if (bls(50)) return;
            case 26:
                r4 = subs(r4, 1);
                r4 = lsrs(r4, 1);
                r2 = lsls(r4, 2);
                r6 = ldr(r2 + r3);
                r1 = movs(r1, r7);
                r2 = movs(r2, r6);
                r0 = movs(r0, 0);
                bl(this::mp_binary_op, heap_siftdown_isra_0 + 44 | 1, 44);
                return;
            case 44:
                r3 = ldr(heap_siftdown_isra_0 + 68); // mp_const_true_obj;
                cmp(r0, r3);
                if (beq(58)) return;
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
                if (blo(58)) return;
            case 38:
                r0 = ldr(sp + 8);
                r1 = lsls(r2, 2);
                str(r3 + r1, r0);
                r0 = movs(r0, r5);
                r1 = movs(r1, r6);
                r0 = adds(r0, 12);
                bl(this::heap_siftdown_isra_0, heap_siftup + 54 | 1, 54);
                return;
            case 54:
                sp = add(sp, 20);
                pop(true, R4, R5, R6, R7);
                return;
            case 58:
                r2 = ldr(sp + 4);
                r7 = adds(r4, 1);
                cmp(r7, r2);
                if (bhs(88)) return;
            case 66:
                r1 = lsls(r4, 2);
                r2 = adds(r3, r1);
                r2 = ldr(r2 + 4);
                r1 = ldr(r3 + r1);
                r0 = movs(r0, 0);
                bl(this::mp_binary_op, heap_siftup + 80 | 1, 80);
                return;
            case 80:
                r3 = ldr(heap_siftup + 108); // mp_const_false_obj;
                cmp(r0, r3);
                if (bne(88)) return;
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
                bl(this::get_heap, mod_uheapq_heapify + 6 | 1, 6);
                return;
            case 6:
                r5 = movs(r5, r0);
                r3 = ldr(r0 + 8);
                r4 = lsrs(r3, 1);
            case 12:
                cmp(r4, 0);
                if (bne(20)) return;
            case 16:
                r0 = ldr(mod_uheapq_heapify + 32); // mp_const_none_obj;
                pop(true, R4, R5, R6);
                return;
            case 20:
                r4 = subs(r4, 1);
                r1 = movs(r1, r4);
                r0 = movs(r0, r5);
                bl(this::heap_siftup, mod_uheapq_heapify + 30 | 1, 30);
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
                bl(this::get_heap, mod_uheapq_heappush + 10 | 1, 10);
                return;
            case 10:
                r4 = movs(r4, r0);
                r1 = movs(r1, r6);
                r0 = movs(r0, r5);
                bl(this::mp_obj_list_append, mod_uheapq_heappush + 20 | 1, 20);
                return;
            case 20:
                r0 = movs(r0, r4);
                r3 = ldr(r4 + 8);
                r0 = adds(r0, 12);
                r2 = subs(r3, 1);
                r1 = movs(r1, 0);
                bl(this::heap_siftdown_isra_0, mod_uheapq_heappush + 34 | 1, 34);
                return;
            case 34:
                r0 = ldr(mod_uheapq_heappush + 40); // mp_const_none_obj;
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
                bl(this::get_heap, mod_uheapq_heappop + 6 | 1, 6);
                return;
            case 6:
                r3 = ldr(r0 + 8);
                cmp(r3, 0);
                if (bne(24)) return;
            case 12:
                r1 = ldr(mod_uheapq_heappop + 56); // mod_uheapq_heappop_str1_1;
                r0 = ldr(mod_uheapq_heappop + 60); // mp_type_IndexError;
                bl(this::mp_obj_new_exception_msg, mod_uheapq_heappop + 20 | 1, 20);
                return;
            case 20:
                bl(this::nlr_jump, mod_uheapq_heappop + 24 | 1, 24);
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
                if (beq(52)) return;
            case 48:
                bl(this::heap_siftup, mod_uheapq_heappop + 52 | 1, 52);
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
                if (beq(12)) return;
            case 4:
                cmp(r0, 5);
                if (beq(24)) return;
            case 8:
                r0 = movs(r0, 0);
                b(null, 22);
                return;
            case 12:
                r3 = ldr(r1 + 8);
                r0 = ldr(utimeq_unary_op + 36); // mp_const_true_obj;
                cmp(r3, 0);
                if (bne(22)) return;
            case 20:
                r0 = ldr(utimeq_unary_op + 40); // mp_const_false_obj;
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
                bl(this::mp_arg_check_num, utimeq_make_new + 24 | 1, 24);
                return;
            case 24:
                r0 = ldr(r4);
                bl(this::mp_obj_get_int, utimeq_make_new + 30 | 1, 30);
                return;
            case 30:
                r7 = lsls(r0, 4);
                r6 = movs(r6, r0);
                r0 = movs(r0, r7);
                r0 = adds(r0, 12);
                bl(this::m_malloc, utimeq_make_new + 42 | 1, 42);
                return;
            case 42:
                r4 = movs(r4, r0);
                r3 = ldr(sp + 12);
                r2 = movs(r2, r7);
                str(r0, r3);
                r1 = movs(r1, r5);
                r0 = adds(r0, 12);
                bl(this::memset, utimeq_make_new + 58 | 1, 58);
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
                if (bne(20)) return;
            case 8:
                r1 = ldr(mod_utimeq_peektime + 32); // mod_uheapq_heappop_str1_1;
                r0 = ldr(mod_utimeq_peektime + 36); // mp_type_IndexError;
                bl(this::mp_obj_new_exception_msg, mod_utimeq_peektime + 16 | 1, 16);
                return;
            case 16:
                bl(this::nlr_jump, mod_utimeq_peektime + 20 | 1, 20);
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
                r4 = stm(r4, r5, r6, r7);
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
                if (bne(58)) return;
            case 36:
                r0 = adds(r0, r7);
                str(sp + 8, r6);
                str(sp + 12, r5);
                r3 = add(sp, 8);
                r0 = adds(r0, 12);
                r3 = ldm(r3, R1, R2, R4);
                r0 = stm(r0, r1, r2, r4);
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
                if (bne(114)) return;
            case 78:
                r3 = mov(r12);
                r4 = ldr(r3 + 16);
                cmp(r5, r4);
                r4 = sbcs(r4, r4);
                r4 = rsbs(r4);
            case 88:
                cmp(r4, 0);
                if (beq(36)) return;
            case 92:
                r2 = ldr(sp + 4);
                r3 = adds(r0, r7);
                r2 = adds(r0, r2);
                r3 = adds(r3, 12);
                r2 = adds(r2, 12);
                r2 = ldm(r2, R1, R4, R7);
                r3 = stm(r3, r1, r4, r7);
                r2 = ldr(r2);
                str(r3, r2);
                r1 = ldr(sp);
                b(null, 30);
                return;
            case 114:
                cmp(r4, 0);
                if (bge(124)) return;
            case 118:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 23);
                r4 = adds(r4, r3);
            case 124:
                r3 = movs(r3, 0);
                r2 = ldr(heap_siftdown_constprop_3 + 140);
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
                if (bne(24)) return;
            case 12:
                r1 = ldr(mod_utimeq_heappop + 256); // mod_uheapq_heappop_str1_1;
                r0 = ldr(mod_utimeq_heappop + 260); // mp_type_IndexError;
                bl(this::mp_obj_new_exception_msg, mod_utimeq_heappop + 20 | 1, 20);
                return;
            case 20:
                bl(this::nlr_jump, mod_utimeq_heappop + 24 | 1, 24);
                return;
            case 24:
                r6 = movs(r6, 3);
                r6 = ands(r6, r1);
                if (bne(44)) return;
            case 30:
                r3 = ldr(mod_utimeq_heappop + 264); // mp_type_list;
                r2 = ldr(r1);
                cmp(r2, r3);
                if (bne(44)) return;
            case 38:
                r3 = ldr(r1 + 8);
                cmp(r3, 2);
                if (bhi(50)) return;
            case 44:
                r0 = movs(r0, 0);
                bl(this::mp_raise_TypeError, mod_utimeq_heappop + 50 | 1, 50);
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
                r1 = stm(r1, r2, r5, r7);
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
                if (beq(158)) return;
            case 116:
                r1 = add(sp, 8);
                r3 = ldm(r3, R2, R5, R7);
                r1 = stm(r1, r2, r5, r7);
                r3 = ldr(r3);
                r2 = movs(r2, 1);
                str(r1, r3);
                r12 = mov(r6);
                r1 = movs(r1, r6);
            case 132:
                r3 = lsls(r1, 4);
                str(sp + 4, r3);
                cmp(r4, r2);
                if (bhi(164)) return;
            case 140:
                r3 = adds(r0, r3);
                r3 = adds(r3, 12);
                r2 = add(sp, 8);
                r2 = ldm(r2, R4, R5, R6);
                r3 = stm(r3, r4, r5, r6);
                r2 = ldr(r2);
                str(r3, r2);
                bl(this::heap_siftdown_constprop_3, mod_utimeq_heappop + 158 | 1, 158);
                return;
            case 158:
                r0 = ldr(mod_utimeq_heappop + 268); // mp_const_none_obj;
                sp = add(sp, 28);
                pop(true, R4, R5, R6, R7);
                return;
            case 164:
                r7 = adds(r2, 1);
                cmp(r4, r7);
                if (bls(202)) return;
            case 170:
                r5 = lsls(r7, 4);
                r6 = lsls(r2, 4);
                r5 = adds(r0, r5);
                r6 = adds(r0, r6);
                r1 = ldr(r5 + 12);
                r3 = ldr(r6 + 12);
                r1 = subs(r1, r3);
                if (bne(230)) return;
            case 186:
                r1 = ldr(r6 + 16);
                r5 = ldr(r5 + 16);
                cmp(r1, r5);
                r1 = sbcs(r1, r1);
                r1 = rsbs(r1);
            case 196:
                cmp(r1, 0);
                if (bne(202)) return;
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
                r3 = stm(r3, r5, r6, r7);
                r1 = ldr(r1);
                str(r3, r1);
                r3 = lsls(r2, 1);
                r1 = movs(r1, r2);
                r2 = adds(r3, 1);
                b(null, 132);
                return;
            case 230:
                cmp(r1, 0);
                if (bge(240)) return;
            case 234:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 23);
                r1 = adds(r1, r3);
            case 240:
                r5 = mov(r12);
                r6 = ldr(mod_utimeq_heappop + 272);
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
                if (bne(22)) return;
            case 14:
                r1 = ldr(mod_utimeq_heappush + 68); // mod_utimeq_heappush_str1_1;
                r0 = ldr(mod_utimeq_heappush + 72); // mp_type_IndexError;
                bl(this::mp_raise_msg, mod_utimeq_heappush + 22 | 1, 22);
                return;
            case 22:
                r0 = ldr(r2 + 4);
                r5 = ldr(mod_utimeq_heappush + 76); // utimeq_id;
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
                bl(this::heap_siftdown_constprop_3, mod_utimeq_heappush + 56 | 1, 56);
                return;
            case 56:
                r3 = ldr(r4 + 8);
                r0 = ldr(mod_utimeq_heappush + 80); // mp_const_none_obj;
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
                if (bne(6)) return;
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
                if (bne(44)) return;
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
                r3 = ldr(sha256_transform + 360); // rodata_k;
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
                if (bne(342)) return;
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
        r3 = ldr(sha256_init + 48);
        str(r0 + 80, r3);
        r3 = ldr(sha256_init + 52);
        str(r0 + 84, r3);
        r3 = ldr(sha256_init + 56);
        str(r0 + 88, r3);
        r3 = ldr(sha256_init + 60);
        str(r0 + 92, r3);
        r3 = ldr(sha256_init + 64);
        str(r0 + 96, r3);
        r3 = ldr(sha256_init + 68);
        str(r0 + 100, r3);
        r3 = ldr(sha256_init + 72);
        str(r0 + 104, r3);
        r3 = ldr(sha256_init + 76);
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
                if (bne(24)) return;
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
                if (bne(62)) return;
            case 38:
                r1 = movs(r1, r4);
                r0 = movs(r0, r4);
                bl(this::sha256_transform, sha256_update + 46 | 1, 46);
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
                bl(this::mp_get_buffer_raise, uhashlib_sha256_update + 14 | 1, 14);
                return;
            case 14:
                r0 = adds(r4, 4);
                r2 = ldr(sp + 8);
                r1 = ldr(sp + 4);
                bl(this::sha256_update, uhashlib_sha256_update + 24 | 1, 24);
                return;
            case 24:
                r0 = ldr(uhashlib_sha256_update + 32); // mp_const_none_obj;
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
                bl(this::mp_arg_check_num, uhashlib_sha256_make_new + 22 | 1, 22);
                return;
            case 22:
                r0 = movs(r0, 116);
                bl(this::m_malloc, uhashlib_sha256_make_new + 28 | 1, 28);
                return;
            case 28:
                r4 = movs(r4, r0);
                r0 = stm(r0, r7);
                bl(this::sha256_init, uhashlib_sha256_make_new + 36 | 1, 36);
                return;
            case 36:
                cmp(r5, 1);
                if (bne(48)) return;
            case 40:
                r1 = ldr(r6);
                r0 = movs(r0, r4);
                bl(this::uhashlib_sha256_update, uhashlib_sha256_make_new + 48 | 1, 48);
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
                if (bhi(172)) return;
            case 18:
                r2 = movs(r2, 0);
            case 20:
                cmp(r3, 56);
                if (bne(166)) return;
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
                bl(this::sha256_transform, sha256_final + 104 | 1, 104);
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
                if (bne(106)) return;
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
                if (bls(198)) return;
            case 178:
                r1 = movs(r1, r4);
                r0 = movs(r0, r4);
                bl(this::sha256_transform, sha256_final + 186 | 1, 186);
                return;
            case 186:
                r2 = movs(r2, 56);
                r1 = movs(r1, 0);
                r0 = movs(r0, r4);
                bl(this::memset, sha256_final + 196 | 1, 196);
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
                bl(this::vstr_init_len, uhashlib_sha256_digest + 12 | 1, 12);
                return;
            case 12:
                r0 = adds(r4, 4);
                r1 = ldr(sp + 8);
                bl(this::sha256_final, uhashlib_sha256_digest + 20 | 1, 20);
                return;
            case 20:
                r1 = mov(sp);
                r0 = ldr(uhashlib_sha256_digest + 32); // mp_type_bytes;
                bl(this::mp_obj_new_str_from_vstr, uhashlib_sha256_digest + 28 | 1, 28);
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
                bl(this::mp_get_buffer_raise, mod_binascii_hexlify + 18 | 1, 18);
                return;
            case 18:
                r3 = ldr(sp + 8);
                r0 = ldr(mod_binascii_hexlify + 128); // mp_const_empty_bytes_obj;
                cmp(r3, 0);
                if (beq(74)) return;
            case 26:
                r5 = lsls(r3, 1);
                r4 = movs(r4, 0);
                cmp(r7, 1);
                if (bls(46)) return;
            case 34:
                r3 = subs(r3, 1);
                r0 = ldr(r6 + 4);
                r5 = adds(r5, r3);
                bl(this::mp_obj_str_get_str, mod_binascii_hexlify + 44 | 1, 44);
                return;
            case 44:
                r4 = movs(r4, r0);
            case 46:
                r1 = movs(r1, r5);
                r5 = movs(r5, 15);
                r0 = add(sp, 16);
                bl(this::vstr_init_len, mod_binascii_hexlify + 56 | 1, 56);
                return;
            case 56:
                r2 = ldr(sp + 24);
                r1 = ldr(sp + 8);
                r0 = ldr(sp + 4);
            case 62:
                r1 = subs(r1, 1);
                if (bhs(78)) return;
            case 66:
                r1 = add(sp, 16);
                r0 = ldr(mod_binascii_hexlify + 132); // mp_type_bytes;
                bl(this::mp_obj_new_str_from_vstr, mod_binascii_hexlify + 74 | 1, 74);
                return;
            case 74:
                sp = add(sp, 36);
                pop(true, R4, R5, R6, R7);
                return;
            case 78:
                r3 = ldrb(r0);
                r3 = lsrs(r3, 4);
                cmp(r3, 9);
                if (bls(88)) return;
            case 86:
                r3 = adds(r3, 39);
            case 88:
                r3 = adds(r3, 48);
                strb(r2, r3);
                r3 = ldrb(r0);
                r3 = ands(r3, r5);
                cmp(r3, 9);
                if (bls(102)) return;
            case 100:
                r3 = adds(r3, 39);
            case 102:
                r3 = adds(r3, 48);
                r6 = adds(r2, 2);
                strb(r2 + 1, r3);
                cmp(r4, 0);
                if (beq(122)) return;
            case 112:
                cmp(r1, 0);
                if (beq(122)) return;
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
                bl(this::mp_get_buffer_raise, mod_binascii_b2a_base64 + 12 | 1, 12);
                return;
            case 12:
                r0 = ldr(sp + 16);
                r1 = movs(r1, 1);
                cmp(r0, 0);
                if (beq(32)) return;
            case 20:
                r1 = adds(r1, 2);
                r0 = subs(r0, 1);
                bl(this::__aeabi_uidiv, mod_binascii_b2a_base64 + 28 | 1, 28);
                return;
            case 28:
                r1 = lsls(r0, 2);
                r1 = adds(r1, 5);
            case 32:
                r4 = movs(r4, 48);
                r5 = movs(r5, 60);
                r6 = movs(r6, 63);
                r0 = add(sp, 24);
                bl(this::vstr_init_len, mod_binascii_b2a_base64 + 44 | 1, 44);
                return;
            case 44:
                r2 = ldr(sp + 12);
                r0 = ldr(sp + 16);
                r3 = ldr(sp + 32);
            case 50:
                cmp(r0, 2);
                if (bhi(136)) return;
            case 54:
                cmp(r0, 0);
                if (beq(98)) return;
            case 58:
                r4 = movs(r4, 48);
                r1 = ldrb(r2);
                r1 = lsrs(r1, 2);
                strb(r3, r1);
                r1 = ldrb(r2);
                r1 = lsls(r1, 4);
                r1 = ands(r1, r4);
                cmp(r0, 2);
                if (bne(184)) return;
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
                if (bhs(190)) return;
            case 120:
                r3 = movs(r3, 10);
                r0 = ldr(mod_binascii_b2a_base64 + 240); // mp_type_bytes;
                strb(r4 + r1, r3);
                r1 = add(sp, 24);
                bl(this::mp_obj_new_str_from_vstr, mod_binascii_b2a_base64 + 132 | 1, 132);
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
                if (bhi(204)) return;
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
                if (bhi(212)) return;
            case 208:
                r3 = adds(r3, 71);
                b(null, 198);
                return;
            case 212:
                cmp(r3, 61);
                if (bhi(220)) return;
            case 216:
                r3 = subs(r3, 4);
                b(null, 198);
                return;
            case 220:
                cmp(r3, 62);
                if (bne(228)) return;
            case 224:
                strb(r2, r7);
                b(null, 200);
                return;
            case 228:
                cmp(r3, 63);
                if (bne(236)) return;
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
                bl(this::mp_get_buffer_raise, mod_binascii_unhexlify + 12 | 1, 12);
                return;
            case 12:
                r1 = ldr(sp + 16);
                r7 = movs(r7, 1);
                r4 = movs(r4, r1);
                r0 = ldr(mod_binascii_unhexlify + 120); // mod_binascii_unhexlify_str1_1;
                r4 = ands(r4, r7);
                if (bne(114)) return;
            case 24:
                r1 = lsrs(r1, 1);
                r0 = add(sp, 24);
                bl(this::vstr_init_len, mod_binascii_unhexlify + 32 | 1, 32);
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
                if (bne(60)) return;
            case 48:
                r1 = add(sp, 24);
                r0 = ldr(mod_binascii_unhexlify + 124); // mp_type_bytes;
                bl(this::mp_obj_new_str_from_vstr, mod_binascii_unhexlify + 56 | 1, 56);
                return;
            case 56:
                sp = add(sp, 44);
                pop(true, R4, R5, R6, R7);
                return;
            case 60:
                r3 = ldr(sp);
                r7 = ldrb(r3);
                r0 = movs(r0, r7);
                bl(this::unichar_isxdigit, mod_binascii_unhexlify + 70 | 1, 70);
                return;
            case 70:
                cmp(r0, 0);
                if (beq(112)) return;
            case 74:
                r0 = movs(r0, r7);
                bl(this::unichar_xdigit_value, mod_binascii_unhexlify + 80 | 1, 80);
                return;
            case 80:
                r0 = adds(r4, r0);
                r0 = uxtb(r0);
                r3 = ldr(sp + 4);
                r4 = lsls(r0, 4);
                r3 = ands(r3, r5);
                r4 = uxtb(r4);
                cmp(r3, 0);
                if (bne(102)) return;
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
                r0 = ldr(mod_binascii_unhexlify + 128);
            case 114:
                bl(this::mp_raise_ValueError, mod_binascii_unhexlify + 118 | 1, 118);
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
                bl(this::mp_get_buffer_raise, mod_binascii_a2b_base64 + 12 | 1, 12);
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
                bl(this::vstr_init, mod_binascii_a2b_base64 + 32 | 1, 32);
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
                if (bhi(64)) return;
            case 54:
                cmp(r2, 0);
                if (beq(176)) return;
            case 58:
                r0 = ldr(mod_binascii_a2b_base64 + 188); // mod_binascii_a2b_base64_str1_1;
                bl(this::mp_raise_ValueError, mod_binascii_a2b_base64 + 64 | 1, 64);
                return;
            case 64:
                r3 = ldrb(r5);
                cmp(r3, 61);
                if (bne(84)) return;
            case 70:
                cmp(r2, 2);
                if (beq(176)) return;
            case 74:
                cmp(r2, 4);
                if (bne(128)) return;
            case 78:
                cmp(r1, 0);
                if (bne(176)) return;
            case 82:
                r1 = adds(r1, 1);
            case 84:
                r7 = movs(r7, r3);
                r7 = subs(r7, 65);
                r6 = uxtb(r7);
                cmp(r6, 25);
                if (bhi(132)) return;
            case 94:
                r3 = movs(r3, r7);
            case 96:
                r0 = lsls(r0, 6);
                r0 = orrs(r0, r3);
                r3 = adds(r2, 6);
                cmp(r3, 7);
                if (ble(172)) return;
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
                if (bhi(144)) return;
            case 140:
                r3 = subs(r3, 71);
                b(null, 96);
                return;
            case 144:
                r7 = movs(r7, r3);
                r7 = subs(r7, 48);
                cmp(r7, 9);
                if (bhi(156)) return;
            case 152:
                r3 = adds(r3, 4);
                b(null, 96);
                return;
            case 156:
                cmp(r3, 43);
                if (beq(168)) return;
            case 160:
                cmp(r3, 47);
                if (bne(124)) return;
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
                r0 = ldr(mod_binascii_a2b_base64 + 192); // mp_type_bytes;
                bl(this::mp_obj_new_str_from_vstr, mod_binascii_a2b_base64 + 184 | 1, 184);
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
                bl(this::mp_get_buffer_raise, mod_binascii_crc32 + 18 | 1, 18);
                return;
            case 18:
                r0 = movs(r0, 0);
                cmp(r5, 1);
                if (bls(30)) return;
            case 24:
                r0 = ldr(r4 + 4);
                bl(this::mp_obj_get_int_truncated, mod_binascii_crc32 + 30 | 1, 30);
                return;
            case 30:
                r2 = mvns(r2, r0);
                r1 = ldr(sp + 8);
                r0 = ldr(sp + 4);
                bl(this::uzlib_crc32, mod_binascii_crc32 + 40 | 1, 40);
                return;
            case 40:
                r0 = mvns(r0, r0);
                bl(this::mp_obj_new_int_from_uint, mod_binascii_crc32 + 46 | 1, 46);
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
                bl(this::mp_obj_int_get_truncated, machine_mem_get_addr + 8 | 1, 8);
                return;
            case 8:
                r3 = subs(r4, 1);
                tst(r0, r3);
                if (beq(30)) return;
            case 14:
                r2 = movs(r2, r0);
                r3 = movs(r3, r4);
                r1 = ldr(machine_mem_get_addr + 32); // machine_mem_get_addr_str1_1;
                r0 = ldr(machine_mem_get_addr + 36); // mp_type_ValueError;
                bl(this::mp_obj_new_exception_msg_varg, machine_mem_get_addr + 26 | 1, 26);
                return;
            case 26:
                bl(this::nlr_jump, machine_mem_get_addr + 30 | 1, 30);
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
                r1 = ldr(machine_mem_print + 16); // machine_mem_print_str1_1;
                r2 = lsls(r2, 3);
                bl(this::mp_printf, machine_mem_print + 12 | 1, 12);
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
                if (beq(44)) return;
            case 12:
                r1 = ldr(r6 + 4);
                r0 = movs(r0, r3);
                cmp(r2, 4);
                if (bne(50)) return;
            case 20:
                bl(this::machine_mem_get_addr, machine_mem_subscr + 24 | 1, 24);
                return;
            case 24:
                r3 = ldr(r6 + 4);
                cmp(r3, 1);
                if (beq(38)) return;
            case 30:
                cmp(r3, 2);
                if (beq(46)) return;
            case 34:
                r0 = ldr(r0);
                b(null, 40);
                return;
            case 38:
                r0 = ldrb(r0);
            case 40:
                bl(this::mp_obj_new_int, machine_mem_subscr + 44 | 1, 44);
                return;
            case 44:
                pop(true, R4, R5, R6);
                return;
            case 46:
                r0 = ldrh(r0);
                b(null, 40);
                return;
            case 50:
                bl(this::machine_mem_get_addr, machine_mem_subscr + 54 | 1, 54);
                return;
            case 54:
                r5 = movs(r5, r0);
                r0 = movs(r0, r4);
                bl(this::mp_obj_get_int_truncated, machine_mem_subscr + 62 | 1, 62);
                return;
            case 62:
                r2 = ldr(r6 + 4);
                r3 = movs(r3, r0);
                r0 = ldr(machine_mem_subscr + 88); // mp_const_none_obj;
                cmp(r2, 1);
                if (beq(80)) return;
            case 72:
                cmp(r2, 2);
                if (beq(84)) return;
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
        r3 = ldr(yasmarang + 80); // yasmarang_d;
        r0 = ldr(yasmarang + 84); // yasmarang_n;
        push(true, r4, r5, r6, r7);
        r12 = mov(r3);
        r6 = ldr(r3);
        r3 = ldr(r0);
        r4 = ldr(yasmarang + 88); // yasmarang_dat;
        r3 = muls(r6, r3);
        r7 = ldr(yasmarang + 92); // yasmarang_pad;
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
                if (blo(28)) return;
            case 16:
                bl(this::yasmarang, yasmarang_randbelow + 20 | 1, 20);
                return;
            case 20:
                r0 = ands(r0, r4);
                cmp(r5, r0);
                if (bls(16)) return;
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
                bl(this::mp_obj_get_float, mod_urandom_uniform + 8 | 1, 8);
                return;
            case 8:
                r4 = adds(r0, 0);
                r0 = movs(r0, r5);
                bl(this::mp_obj_get_float, mod_urandom_uniform + 16 | 1, 16);
                return;
            case 16:
                r1 = adds(r4, 0);
                bl(this::__aeabi_fsub, mod_urandom_uniform + 22 | 1, 22);
                return;
            case 22:
                r5 = adds(r0, 0);
                bl(this::yasmarang, mod_urandom_uniform + 28 | 1, 28);
                return;
            case 28:
                r3 = movs(r3, 254);
                r1 = movs(r1, 254);
                r0 = lsls(r0, 9);
                r3 = lsls(r3, 22);
                r0 = lsrs(r0, 9);
                r0 = orrs(r0, r3);
                r1 = lsls(r1, 22);
                bl(this::__aeabi_fsub, mod_urandom_uniform + 46 | 1, 46);
                return;
            case 46:
                r1 = adds(r0, 0);
                r0 = adds(r5, 0);
                bl(this::__aeabi_fmul, mod_urandom_uniform + 54 | 1, 54);
                return;
            case 54:
                r1 = adds(r4, 0);
                bl(this::__aeabi_fadd, mod_urandom_uniform + 60 | 1, 60);
                return;
            case 60:
                bl(this::mp_obj_new_float, mod_urandom_uniform + 64 | 1, 64);
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
                bl(this::mp_obj_get_int, mod_urandom_randint + 8 | 1, 8);
                return;
            case 8:
                r4 = movs(r4, r0);
                r0 = movs(r0, r5);
                bl(this::mp_obj_get_int, mod_urandom_randint + 16 | 1, 16);
                return;
            case 16:
                cmp(r4, r0);
                if (ble(26)) return;
            case 20:
                r0 = movs(r0, 0);
                bl(this::mp_raise_ValueError, mod_urandom_randint + 26 | 1, 26);
                return;
            case 26:
                r0 = subs(r0, r4);
                r0 = adds(r0, 1);
                bl(this::yasmarang_randbelow, mod_urandom_randint + 34 | 1, 34);
                return;
            case 34:
                r0 = adds(r4, r0);
                bl(this::mp_obj_new_int, mod_urandom_randint + 40 | 1, 40);
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
                bl(this::mp_obj_get_int, mod_urandom_randrange + 12 | 1, 12);
                return;
            case 12:
                r6 = movs(r6, r0);
                cmp(r7, 1);
                if (bne(32)) return;
            case 18:
                cmp(r0, 0);
                if (ble(100)) return;
            case 22:
                bl(this::yasmarang_randbelow, mod_urandom_randrange + 26 | 1, 26);
                return;
            case 26:
                bl(this::mp_obj_new_int, mod_urandom_randrange + 30 | 1, 30);
                return;
            case 30:
                pop(true, R3, R4, R5, R6, R7);
                return;
            case 32:
                r0 = ldr(r5 + 4);
                bl(this::mp_obj_get_int, mod_urandom_randrange + 38 | 1, 38);
                return;
            case 38:
                r4 = subs(r0, r6);
                cmp(r7, 2);
                if (bne(58)) return;
            case 44:
                cmp(r6, r0);
                if (bge(100)) return;
            case 48:
                r0 = movs(r0, r4);
                bl(this::yasmarang_randbelow, mod_urandom_randrange + 54 | 1, 54);
                return;
            case 54:
                r0 = adds(r0, r6);
                b(null, 26);
                return;
            case 58:
                r0 = ldr(r5 + 8);
                bl(this::mp_obj_get_int, mod_urandom_randrange + 64 | 1, 64);
                return;
            case 64:
                r5 = subs(r0, 0);
                if (ble(90)) return;
            case 68:
                r0 = adds(r4, r0);
                r0 = subs(r0, 1);
            case 72:
                r1 = movs(r1, r5);
                bl(this::__divsi3, mod_urandom_randrange + 78 | 1, 78);
                return;
            case 78:
                cmp(r0, 0);
                if (ble(100)) return;
            case 82:
                bl(this::yasmarang_randbelow, mod_urandom_randrange + 86 | 1, 86);
                return;
            case 86:
                r0 = muls(r5, r0);
                b(null, 54);
                return;
            case 90:
                cmp(r0, 0);
                if (beq(100)) return;
            case 94:
                r0 = adds(r4, r0);
                r0 = adds(r0, 1);
                b(null, 72);
                return;
            case 100:
                r0 = movs(r0, 0);
                bl(this::mp_raise_ValueError, mod_urandom_randrange + 106 | 1, 106);
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
                bl(this::mp_obj_get_int_truncated, mod_urandom_seed + 6 | 1, 6);
                return;
            case 6:
                r2 = movs(r2, 69);
                r3 = ldr(mod_urandom_seed + 32); // yasmarang_pad;
                str(r3, r0);
                r3 = ldr(mod_urandom_seed + 36); // yasmarang_n;
                r0 = ldr(mod_urandom_seed + 40); // mp_const_none_obj;
                str(r3, r2);
                r3 = ldr(mod_urandom_seed + 44); // yasmarang_d;
                r2 = adds(r2, 164);
                str(r3, r2);
                r2 = movs(r2, 0);
                r3 = ldr(mod_urandom_seed + 48); // yasmarang_dat;
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
                bl(this::mp_obj_get_int, mod_urandom_getrandbits + 6 | 1, 6);
                return;
            case 6:
                r4 = movs(r4, r0);
                cmp(r0, 32);
                if (bgt(16)) return;
            case 12:
                cmp(r0, 0);
                if (bne(22)) return;
            case 16:
                r0 = movs(r0, 0);
                bl(this::mp_raise_ValueError, mod_urandom_getrandbits + 22 | 1, 22);
                return;
            case 22:
                bl(this::yasmarang, mod_urandom_getrandbits + 26 | 1, 26);
                return;
            case 26:
                r2 = movs(r2, 32);
                r3 = movs(r3, 1);
                r2 = subs(r2, r4);
                r3 = rsbs(r3);
                r3 = lsrs(r3, r2);
                r0 = ands(r0, r3);
                bl(this::mp_obj_new_int_from_uint, mod_urandom_getrandbits + 42 | 1, 42);
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
                bl(this::mp_obj_len, mod_urandom_choice + 8 | 1, 8);
                return;
            case 8:
                bl(this::mp_obj_get_int, mod_urandom_choice + 12 | 1, 12);
                return;
            case 12:
                cmp(r0, 0);
                if (bgt(26)) return;
            case 16:
                r0 = ldr(mod_urandom_choice + 48); // mp_type_IndexError;
                bl(this::mp_obj_new_exception, mod_urandom_choice + 22 | 1, 22);
                return;
            case 22:
                bl(this::nlr_jump, mod_urandom_choice + 26 | 1, 26);
                return;
            case 26:
                bl(this::yasmarang_randbelow, mod_urandom_choice + 30 | 1, 30);
                return;
            case 30:
                bl(this::mp_obj_new_int, mod_urandom_choice + 34 | 1, 34);
                return;
            case 34:
                r2 = movs(r2, 4);
                r1 = movs(r1, r0);
                r0 = movs(r0, r4);
                bl(this::mp_obj_subscr, mod_urandom_choice + 44 | 1, 44);
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
                bl(this::yasmarang, mod_urandom_random + 6 | 1, 6);
                return;
            case 6:
                r3 = movs(r3, 254);
                r1 = movs(r1, 254);
                r0 = lsls(r0, 9);
                r3 = lsls(r3, 22);
                r0 = lsrs(r0, 9);
                r0 = orrs(r0, r3);
                r1 = lsls(r1, 22);
                bl(this::__aeabi_fsub, mod_urandom_random + 24 | 1, 24);
                return;
            case 24:
                bl(this::mp_obj_new_float, mod_urandom_random + 28 | 1, 28);
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
                if (bne(18)) return;
            case 12:
                r0 = adds(r0, 18);
            case 14:
                bl(this::mp_raise_OSError, mp_vfs_proxy_call + 18 | 1, 18);
                return;
            case 18:
                cmp(r0, 0);
                if (bne(26)) return;
            case 22:
                r0 = adds(r0, 1);
                b(null, 14);
                return;
            case 26:
                r2 = mov(sp);
                r0 = ldr(r0 + 8);
                bl(this::mp_load_method, mp_vfs_proxy_call + 34 | 1, 34);
                return;
            case 34:
                cmp(r5, 0);
                if (beq(48)) return;
            case 38:
                r2 = lsls(r4, 2);
                r1 = movs(r1, r5);
                r0 = add(sp, 8);
                bl(this::memcpy, mp_vfs_proxy_call + 48 | 1, 48);
                return;
            case 48:
                r2 = mov(sp);
                r1 = movs(r1, 0);
                r0 = movs(r0, r4);
                bl(this::mp_call_method_n_kw, mp_vfs_proxy_call + 58 | 1, 58);
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
                if (beq(28)) return;
            case 14:
                r7 = movs(r7, 0);
                cmp(r3, r7);
                if (bne(38)) return;
            case 20:
                r3 = ldr(mp_vfs_umount + 140); // mp_type_str;
                r2 = ldr(r0);
                cmp(r2, r3);
                if (bne(38)) return;
            case 28:
                r1 = add(sp, 12);
                r0 = movs(r0, r5);
                bl(this::mp_obj_str_get_data, mp_vfs_umount + 36 | 1, 36);
                return;
            case 36:
                r7 = movs(r7, r0);
            case 38:
                r3 = movs(r3, 234);
                r6 = ldr(mp_vfs_umount + 144); // mp_state_ctx;
                r3 = lsls(r3, 1);
                r4 = ldr(r6 + r3);
                r3 = ldr(sp + 12);
                r3 = adds(r3, 1);
                str(sp + 4, r3);
                r3 = ldr(mp_vfs_umount + 148);
                str(sp, r3);
            case 56:
                cmp(r4, 0);
                if (bne(66)) return;
            case 60:
                r0 = movs(r0, 22);
                bl(this::mp_raise_OSError, mp_vfs_umount + 66 | 1, 66);
                return;
            case 66:
                cmp(r7, 0);
                if (beq(84)) return;
            case 70:
                r2 = ldr(sp + 4);
                r1 = ldr(r4);
                r0 = movs(r0, r7);
                bl(this::memcmp, mp_vfs_umount + 80 | 1, 80);
                return;
            case 80:
                cmp(r0, 0);
                if (beq(92)) return;
            case 84:
                r2 = ldr(r4 + 8);
                r3 = ldr(r4 + 12);
                cmp(r2, r5);
                if (bne(130)) return;
            case 92:
                r3 = ldr(sp);
                r2 = ldr(r4 + 12);
                str(r3, r2);
                r3 = movs(r3, 232);
                r3 = lsls(r3, 1);
                r2 = ldr(r6 + r3);
                cmp(r4, r2);
                if (bne(112)) return;
            case 108:
                r2 = movs(r2, 0);
                str(r6 + r3, r2);
            case 112:
                r3 = movs(r3, 0);
                r1 = ldr(mp_vfs_umount + 152);
                r2 = movs(r2, r3);
                r0 = movs(r0, r4);
                bl(this::mp_vfs_proxy_call, mp_vfs_umount + 124 | 1, 124);
                return;
            case 124:
                r0 = ldr(mp_vfs_umount + 156); // mp_const_none_obj;
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
                r6 = ldr(mp_vfs_getcwd + 108); // mp_state_ctx;
                r5 = lsls(r5, 1);
                r0 = ldr(r6 + r5);
                cmp(r0, 0);
                if (beq(100)) return;
            case 14:
                r3 = movs(r3, 0);
                r1 = movs(r1, 158);
                r2 = movs(r2, r3);
                r1 = lsls(r1, 1);
                bl(this::mp_vfs_proxy_call, mp_vfs_getcwd + 26 | 1, 26);
                return;
            case 26:
                r3 = ldr(r6 + r5);
                r3 = ldr(r3 + 4);
                cmp(r3, 1);
                if (beq(96)) return;
            case 34:
                bl(this::mp_obj_str_get_str, mp_vfs_getcwd + 38 | 1, 38);
                return;
            case 38:
                r4 = movs(r4, r0);
                bl(this::strlen, mp_vfs_getcwd + 44 | 1, 44);
                return;
            case 44:
                r3 = ldr(r6 + r5);
                r1 = ldr(r3 + 4);
                r1 = adds(r1, 1);
                r1 = adds(r1, r0);
                r0 = mov(sp);
                bl(this::vstr_init, mp_vfs_getcwd + 58 | 1, 58);
                return;
            case 58:
                r3 = ldr(r6 + r5);
                r0 = mov(sp);
                r3 = ldm(r3, R1, R2);
                bl(this::vstr_add_strn, mp_vfs_getcwd + 68 | 1, 68);
                return;
            case 68:
                r3 = ldrb(r4);
                cmp(r3, 47);
                if (bne(80)) return;
            case 74:
                r3 = ldrb(r4 + 1);
                cmp(r3, 0);
                if (beq(88)) return;
            case 80:
                r1 = movs(r1, r4);
                r0 = mov(sp);
                bl(this::vstr_add_str, mp_vfs_getcwd + 88 | 1, 88);
                return;
            case 88:
                r1 = mov(sp);
                r0 = ldr(mp_vfs_getcwd + 112); // mp_type_str;
                bl(this::mp_obj_new_str_from_vstr, mp_vfs_getcwd + 96 | 1, 96);
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
                if (bne(48)) return;
            case 14:
                r5 = subs(r4, 0);
                if (beq(54)) return;
            case 18:
                r3 = ldr(r4 + 12);
                r2 = ldr(r4 + 4);
                str(r6 + 8, r3);
                cmp(r2, 1);
                if (bne(58)) return;
            case 28:
                r3 = movs(r3, 187);
                r1 = movs(r1, 168);
                r3 = lsls(r3, 1);
                str(sp + 4, r3);
                strb(r6 + 13, r2);
                r3 = add(sp, 4);
                r1 = lsls(r1, 1);
                bl(this::mp_vfs_proxy_call, mp_vfs_ilistdir_it_iternext + 46 | 1, 46);
                return;
            case 46:
                str(r6 + 8, r0);
            case 48:
                bl(this::mp_iternext, mp_vfs_ilistdir_it_iternext + 52 | 1, 52);
                return;
            case 52:
                r5 = movs(r5, r0);
            case 54:
                r0 = movs(r0, r5);
                pop(true, R1, R2, R4, R5, R6);
                return;
            case 58:
                r0 = movs(r0, 3);
                bl(this::mp_obj_new_tuple, mp_vfs_ilistdir_it_iternext + 64 | 1, 64);
                return;
            case 64:
                r3 = ldrb(r6 + 12);
                r5 = movs(r5, r0);
                r0 = ldr(mp_vfs_ilistdir_it_iternext + 100); // mp_type_bytes;
                cmp(r3, 0);
                if (beq(76)) return;
            case 74:
                r0 = ldr(mp_vfs_ilistdir_it_iternext + 104); // mp_type_str;
            case 76:
                r3 = ldr(r4 + 4);
                r1 = ldr(r4);
                r2 = subs(r3, 1);
                r1 = adds(r1, 1);
                bl(this::mp_obj_new_str_of_type, mp_vfs_ilistdir_it_iternext + 88 | 1, 88);
                return;
            case 88:
                r3 = ldr(mp_vfs_ilistdir_it_iternext + 108);
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
                if (beq(64)) return;
            case 12:
                r3 = movs(r3, 232);
                r2 = ldr(mp_vfs_lookup_path + 132); // mp_state_ctx;
                r3 = lsls(r3, 1);
                r3 = ldr(r2 + r3);
                cmp(r3, 0);
                if (bne(52)) return;
            case 24:
                str(sp + 4, r3);
                r3 = ldrb(r4);
                r5 = subs(r3, 0);
                if (beq(84)) return;
            case 32:
                r3 = movs(r3, 234);
                r2 = ldr(mp_vfs_lookup_path + 132); // mp_state_ctx;
                r3 = lsls(r3, 1);
                r5 = ldr(r2 + r3);
            case 40:
                cmp(r5, 0);
                if (bne(70)) return;
            case 44:
                r3 = ldr(sp + 4);
                r5 = adds(r5, 1);
                cmp(r3, 0);
                if (bne(84)) return;
            case 52:
                r3 = movs(r3, 232);
                r2 = ldr(mp_vfs_lookup_path + 132); // mp_state_ctx;
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
                if (bne(88)) return;
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
                bl(this::strncmp, mp_vfs_lookup_path + 100 | 1, 100);
                return;
            case 100:
                cmp(r0, 0);
                if (bne(126)) return;
            case 104:
                r6 = adds(r4, r6);
                r3 = ldrb(r6);
                cmp(r3, 47);
                if (bne(116)) return;
            case 112:
                str(r7, r6);
                b(null, 84);
                return;
            case 116:
                cmp(r3, 0);
                if (bne(126)) return;
            case 120:
                r3 = ldr(mp_vfs_lookup_path + 136);
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
                r3 = ldr(mp_vfs_mount + 144); // allowed_args_6655;
                r6 = add(sp, 24);
                r1 = adds(r1, 8);
                r0 = subs(r0, 2);
                str(sp, r3);
                str(sp + 4, r6);
                r3 = movs(r3, 2);
                bl(this::mp_arg_parse_all, mp_vfs_mount + 24 | 1, 24);
                return;
            case 24:
                r1 = add(sp, 16);
                r0 = ldr(r5 + 4);
                bl(this::mp_obj_str_get_data, mp_vfs_mount + 32 | 1, 32);
                return;
            case 32:
                r1 = movs(r1, 205);
                r7 = ldr(r5);
                r2 = add(sp, 32);
                r1 = lsls(r1, 1);
                str(sp + 12, r0);
                r0 = movs(r0, r7);
                bl(this::mp_load_method_maybe, mp_vfs_mount + 48 | 1, 48);
                return;
            case 48:
                r0 = movs(r0, 16);
                bl(this::m_malloc, mp_vfs_mount + 54 | 1, 54);
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
                bl(this::mp_vfs_proxy_call, mp_vfs_mount + 82 | 1, 82);
                return;
            case 82:
                r0 = ldr(r5 + 4);
                bl(this::mp_obj_str_get_str, mp_vfs_mount + 88 | 1, 88);
                return;
            case 88:
                r1 = add(sp, 20);
                bl(this::mp_vfs_lookup_path, mp_vfs_mount + 94 | 1, 94);
                return;
            case 94:
                r3 = ldr(mp_vfs_mount + 148);
                cmp(r0, 1);
                if (bls(122)) return;
            case 100:
                r2 = ldr(r4 + 4);
                cmp(r2, 1);
                if (beq(112)) return;
            case 106:
                r2 = ldr(r0 + 4);
                cmp(r2, 1);
                if (beq(122)) return;
            case 112:
                r0 = movs(r0, 1);
                bl(this::mp_raise_OSError, mp_vfs_mount + 118 | 1, 118);
                return;
            case 118:
                r3 = movs(r3, r2);
                r3 = adds(r3, 12);
            case 122:
                r2 = ldr(r3);
                cmp(r2, 0);
                if (beq(136)) return;
            case 128:
                r1 = ldr(r2 + 4);
                cmp(r1, 1);
                if (bne(118)) return;
            case 134:
                str(r4 + 12, r2);
            case 136:
                r0 = ldr(mp_vfs_mount + 152); // mp_const_none_obj;
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
                bl(this::mp_obj_str_get_str, lookup_path + 10 | 1, 10);
                return;
            case 10:
                r1 = add(sp, 4);
                bl(this::mp_vfs_lookup_path, lookup_path + 16 | 1, 16);
                return;
            case 16:
                r4 = movs(r4, r0);
                cmp(r0, 1);
                if (bls(50)) return;
            case 22:
                r0 = movs(r0, r5);
                bl(this::mp_obj_get_type, lookup_path + 28 | 1, 28);
                return;
            case 28:
                r5 = ldr(sp + 4);
                r7 = movs(r7, r0);
                r0 = movs(r0, r5);
                bl(this::strlen, lookup_path + 38 | 1, 38);
                return;
            case 38:
                r1 = movs(r1, r5);
                r2 = movs(r2, r0);
                r0 = movs(r0, r7);
                bl(this::mp_obj_new_str_of_type, lookup_path + 48 | 1, 48);
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
                r3 = ldr(mp_vfs_open + 44); // allowed_args_6689;
                sp = sub(sp, 24);
                r4 = add(sp, 8);
                str(sp, r3);
                str(sp + 4, r4);
                r3 = movs(r3, 4);
                bl(this::mp_arg_parse_all, mp_vfs_open + 18 | 1, 18);
                return;
            case 18:
                r1 = movs(r1, r4);
                r0 = ldr(sp + 8);
                bl(this::lookup_path, mp_vfs_open + 26 | 1, 26);
                return;
            case 26:
                r1 = movs(r1, 209);
                r3 = movs(r3, r4);
                r2 = movs(r2, 2);
                r1 = lsls(r1, 1);
                bl(this::mp_vfs_proxy_call, mp_vfs_open + 38 | 1, 38);
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
                bl(this::lookup_path, mp_vfs_chdir + 8 | 1, 8);
                return;
            case 8:
                r2 = movs(r2, 232);
                r3 = ldr(mp_vfs_chdir + 64); // mp_state_ctx;
                r2 = lsls(r2, 1);
                str(r3 + r2, r0);
                cmp(r0, 0);
                if (bne(58)) return;
            case 20:
                r2 = adds(r2, 4);
                r0 = ldr(r3 + r2);
            case 24:
                cmp(r0, 0);
                if (bne(32)) return;
            case 28:
                r0 = ldr(mp_vfs_chdir + 68); // mp_const_none_obj;
                pop(true, R1, R2, R3);
                return;
            case 32:
                r2 = ldr(r0 + 4);
                cmp(r2, 1);
                if (bne(54)) return;
            case 38:
                r3 = movs(r3, 187);
                r3 = lsls(r3, 1);
                str(sp + 4, r3);
                r3 = add(sp, 4);
            case 46:
                r1 = movs(r1, 235);
                bl(this::mp_vfs_proxy_call, mp_vfs_chdir + 52 | 1, 52);
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
                if (bne(10)) return;
            case 8:
                r6 = ldr(r1);
            case 10:
                r1 = add(sp, 4);
                r0 = movs(r0, r6);
                bl(this::lookup_path, mp_vfs_ilistdir + 18 | 1, 18);
                return;
            case 18:
                r5 = subs(r0, 0);
                if (bne(70)) return;
            case 22:
                r0 = movs(r0, 16);
                bl(this::m_malloc, mp_vfs_ilistdir + 28 | 1, 28);
                return;
            case 28:
                r3 = ldr(mp_vfs_ilistdir + 88); // mp_type_polymorph_iter;
                r2 = ldr(mp_vfs_ilistdir + 92); // mp_state_ctx;
                str(r0, r3);
                r3 = mov(mp_vfs_ilistdir_it_iternext | 1);
                hint(mp_vfs_ilistdir_it_iternext | 1, this::mp_vfs_ilistdir_it_iternext);
                r4 = movs(r4, r0);
                str(r0 + 4, r3);
                r3 = movs(r3, 234);
                r3 = lsls(r3, 1);
                r3 = ldr(r2 + r3);
                str(r0 + 8, r3);
                r0 = movs(r0, r6);
                bl(this::mp_obj_get_type, mp_vfs_ilistdir + 54 | 1, 54);
                return;
            case 54:
                r3 = ldr(mp_vfs_ilistdir + 100); // mp_type_str;
                strb(r4 + 13, r5);
                r0 = subs(r0, r3);
                r3 = rsbs(r0);
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
                bl(this::mp_vfs_proxy_call, mp_vfs_ilistdir + 82 | 1, 82);
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
                bl(this::mp_vfs_ilistdir, mp_vfs_listdir + 6 | 1, 6);
                return;
            case 6:
                r1 = movs(r1, 0);
                r5 = movs(r5, r0);
                r0 = movs(r0, r1);
                bl(this::mp_obj_new_list, mp_vfs_listdir + 16 | 1, 16);
                return;
            case 16:
                r4 = movs(r4, r0);
            case 18:
                r0 = movs(r0, r5);
                bl(this::mp_iternext, mp_vfs_listdir + 24 | 1, 24);
                return;
            case 24:
                cmp(r0, 0);
                if (bne(32)) return;
            case 28:
                r0 = movs(r0, r4);
                pop(true, R4, R5, R6);
                return;
            case 32:
                r2 = movs(r2, 4);
                r1 = movs(r1, 1);
                bl(this::mp_obj_subscr, mp_vfs_listdir + 40 | 1, 40);
                return;
            case 40:
                r1 = movs(r1, r0);
                r0 = movs(r0, r4);
                bl(this::mp_obj_list_append, mp_vfs_listdir + 48 | 1, 48);
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
                bl(this::lookup_path, mp_vfs_mkdir + 8 | 1, 8);
                return;
            case 8:
                r4 = subs(r0, 0);
                if (bne(18)) return;
            case 12:
                r0 = movs(r0, 17);
                bl(this::mp_raise_OSError, mp_vfs_mkdir + 18 | 1, 18);
                return;
            case 18:
                cmp(r0, 1);
                if (beq(38)) return;
            case 22:
                r0 = ldr(sp + 4);
                bl(this::mp_obj_str_get_str, mp_vfs_mkdir + 28 | 1, 28);
                return;
            case 28:
                r1 = ldr(mp_vfs_mkdir + 56);
                bl(this::strcmp, mp_vfs_mkdir + 34 | 1, 34);
                return;
            case 34:
                cmp(r0, 0);
                if (beq(12)) return;
            case 38:
                r1 = movs(r1, 202);
                r3 = add(sp, 4);
                r2 = movs(r2, 1);
                r1 = lsls(r1, 1);
                r0 = movs(r0, r4);
                bl(this::mp_vfs_proxy_call, mp_vfs_mkdir + 52 | 1, 52);
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
                bl(this::lookup_path, mp_vfs_remove + 8 | 1, 8);
                return;
            case 8:
                r1 = movs(r1, 202);
                r3 = add(sp, 4);
                r2 = movs(r2, 1);
                r1 = adds(r1, 255);
                bl(this::mp_vfs_proxy_call, mp_vfs_remove + 20 | 1, 20);
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
                bl(this::lookup_path, mp_vfs_rename + 10 | 1, 10);
                return;
            case 10:
                r1 = add(sp, 4);
                r4 = movs(r4, r0);
                r0 = movs(r0, r5);
                bl(this::lookup_path, mp_vfs_rename + 20 | 1, 20);
                return;
            case 20:
                cmp(r4, r0);
                if (beq(30)) return;
            case 24:
                r0 = movs(r0, 1);
                bl(this::mp_raise_OSError, mp_vfs_rename + 30 | 1, 30);
                return;
            case 30:
                r1 = movs(r1, 229);
                r3 = mov(sp);
                r2 = movs(r2, 2);
                r1 = lsls(r1, 1);
                r0 = movs(r0, r4);
                bl(this::mp_vfs_proxy_call, mp_vfs_rename + 44 | 1, 44);
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
                bl(this::lookup_path, mp_vfs_rmdir + 8 | 1, 8);
                return;
            case 8:
                r2 = movs(r2, 1);
                r1 = movs(r1, 233);
                r3 = add(sp, 4);
                r1 = lsls(r1, r2);
                bl(this::mp_vfs_proxy_call, mp_vfs_rmdir + 20 | 1, 20);
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
                bl(this::lookup_path, mp_vfs_stat + 8 | 1, 8);
                return;
            case 8:
                cmp(r0, 0);
                if (bne(42)) return;
            case 12:
                r1 = movs(r1, r0);
                r0 = adds(r0, 10);
                bl(this::mp_obj_new_tuple, mp_vfs_stat + 20 | 1, 20);
                return;
            case 20:
                r3 = ldr(mp_vfs_stat + 56);
                r2 = movs(r2, r0);
                str(r0 + 8, r3);
                r3 = movs(r3, r0);
                r1 = movs(r1, 1);
                r3 = adds(r3, 12);
                r2 = adds(r2, 48);
            case 34:
                r3 = stm(r3, r1);
                cmp(r3, r2);
                if (bne(34)) return;
            case 40:
                pop(true, R1, R2, R3);
                return;
            case 42:
                r1 = movs(r1, 250);
                r3 = add(sp, 4);
                r2 = movs(r2, 1);
                r1 = lsls(r1, 1);
                bl(this::mp_vfs_proxy_call, mp_vfs_stat + 54 | 1, 54);
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
                bl(this::lookup_path, mp_vfs_statvfs + 8 | 1, 8);
                return;
            case 8:
                cmp(r0, 0);
                if (bne(70)) return;
            case 12:
                r3 = movs(r3, 234);
                r2 = ldr(mp_vfs_statvfs + 84); // mp_state_ctx;
                r3 = lsls(r3, 1);
                r0 = ldr(r2 + r3);
            case 20:
                cmp(r0, 0);
                if (bne(54)) return;
            case 24:
                r1 = movs(r1, r0);
                r0 = movs(r0, 10);
                bl(this::mp_obj_new_tuple, mp_vfs_statvfs + 32 | 1, 32);
                return;
            case 32:
                r3 = movs(r3, r0);
                r1 = movs(r1, r0);
                r2 = movs(r2, 1);
                r3 = adds(r3, 8);
                r1 = adds(r1, 44);
            case 42:
                r3 = stm(r3, r2);
                cmp(r1, r3);
                if (bne(42)) return;
            case 48:
                r3 = ldr(mp_vfs_statvfs + 88);
                str(r0 + 44, r3);
            case 52:
                pop(true, R1, R2, R3);
                return;
            case 54:
                r3 = ldr(r0 + 4);
                cmp(r3, 1);
                if (beq(64)) return;
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
                bl(this::mp_vfs_proxy_call, mp_vfs_statvfs + 82 | 1, 82);
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
                bl(this::mp_vfs_lookup_path, mp_vfs_import_stat + 10 | 1, 10);
                return;
            case 10:
                r4 = movs(r4, r0);
                cmp(r0, 1);
                if (bhi(22)) return;
            case 16:
                r0 = movs(r0, 0);
            case 18:
                sp = add(sp, 68);
                pop(true, R4, R5);
                return;
            case 22:
                r0 = ldr(r0 + 8);
                bl(this::mp_obj_get_type, mp_vfs_import_stat + 28 | 1, 28);
                return;
            case 28:
                r3 = ldr(r0 + 48);
                cmp(r3, 0);
                if (beq(44)) return;
            case 34:
                r3 = ldr(r3);
                r1 = ldr(sp);
                r0 = ldr(r4 + 8);
                blx(r3, mp_vfs_import_stat + 42 | 1, 42);
                return;
            case 42:
                b(null, 18);
                return;
            case 44:
                r5 = ldr(sp);
                r0 = movs(r0, r5);
                bl(this::strlen, mp_vfs_import_stat + 52 | 1, 52);
                return;
            case 52:
                r1 = movs(r1, r0);
                r0 = movs(r0, r5);
                bl(this::mp_obj_new_str, mp_vfs_import_stat + 60 | 1, 60);
                return;
            case 60:
                str(sp + 4, r0);
                r0 = add(sp, 12);
                bl(this::nlr_push, mp_vfs_import_stat + 68 | 1, 68);
                return;
            case 68:
                cmp(r0, 0);
                if (bne(16)) return;
            case 72:
                r1 = movs(r1, 250);
                r3 = add(sp, 4);
                r2 = movs(r2, 1);
                r1 = lsls(r1, 1);
                r0 = movs(r0, r4);
                bl(this::mp_vfs_proxy_call, mp_vfs_import_stat + 86 | 1, 86);
                return;
            case 86:
                r4 = movs(r4, r0);
                bl(this::nlr_pop, mp_vfs_import_stat + 92 | 1, 92);
                return;
            case 92:
                r2 = add(sp, 8);
                r1 = movs(r1, 10);
                r0 = movs(r0, r4);
                bl(this::mp_obj_get_array_fixed_n, mp_vfs_import_stat + 102 | 1, 102);
                return;
            case 102:
                r3 = ldr(sp + 8);
                r0 = ldr(r3);
                bl(this::mp_obj_get_int, mp_vfs_import_stat + 110 | 1, 110);
                return;
            case 110:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 7);
                r0 = ands(r0, r3);
                r3 = rsbs(r0);
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
                bl(this::mp_stream_close, mp_reader_vfs_close + 10 | 1, 10);
                return;
            case 10:
                r1 = movs(r1, 32);
                r0 = movs(r0, r4);
                bl(this::m_free, mp_reader_vfs_close + 18 | 1, 18);
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
                if (blo(50)) return;
            case 12:
                cmp(r3, 23);
                if (bls(64)) return;
            case 16:
                r3 = movs(r3, 1);
                r1 = movs(r1, r0);
                str(sp, r3);
                r2 = movs(r2, 24);
                r3 = add(sp, 12);
                r1 = adds(r1, 8);
                r0 = ldr(r0);
                bl(this::mp_stream_rw, mp_reader_vfs_readbyte + 34 | 1, 34);
                return;
            case 34:
                r3 = ldr(sp + 12);
                r0 = uxth(r0);
                strh(r4 + 4, r0);
                cmp(r3, 0);
                if (bne(64)) return;
            case 44:
                cmp(r0, 0);
                if (beq(64)) return;
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
                r0 = rsbs(r0);
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
                bl(this::m_malloc, mp_reader_new_file + 12 | 1, 12);
                return;
            case 12:
                r4 = movs(r4, r0);
                r0 = movs(r0, r6);
                bl(this::strlen, mp_reader_new_file + 20 | 1, 20);
                return;
            case 20:
                r1 = movs(r1, r0);
                r0 = movs(r0, r6);
                bl(this::mp_obj_new_str, mp_reader_new_file + 28 | 1, 28);
                return;
            case 28:
                r2 = ldr(mp_reader_new_file + 84); // mp_const_empty_map;
                str(sp + 8, r0);
                r1 = add(sp, 8);
                r0 = movs(r0, 1);
                bl(this::mp_vfs_open, mp_reader_new_file + 40 | 1, 40);
                return;
            case 40:
                r3 = movs(r3, 1);
                r1 = movs(r1, r4);
                str(r4, r0);
                r1 = adds(r1, 8);
                str(sp, r3);
                r2 = movs(r2, 24);
                r3 = add(sp, 12);
                bl(this::mp_stream_rw, mp_reader_new_file + 58 | 1, 58);
                return;
            case 58:
                strh(r4 + 4, r0);
                r0 = ldr(sp + 12);
                cmp(r0, 0);
                if (beq(70)) return;
            case 66:
                bl(this::mp_raise_OSError, mp_reader_new_file + 70 | 1, 70);
                return;
            case 70:
                r3 = mov(mp_reader_vfs_readbyte | 1);
                hint(mp_reader_vfs_readbyte | 1, this::mp_reader_vfs_readbyte);
                strh(r4 + 6, r0);
                str(r5 + 4, r3);
                r3 = mov(mp_reader_vfs_close | 1);
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
                bl(this::mp_obj_get_float, time_sleep + 6 | 1, 6);
                return;
            case 6:
                r1 = ldr(time_sleep + 24);
                bl(this::__aeabi_fmul, time_sleep + 12 | 1, 12);
                return;
            case 12:
                bl(this::__fixunssfsi, time_sleep + 16 | 1, 16);
                return;
            case 16:
                bl(this::mp_hal_delay_ms, time_sleep + 20 | 1, 20);
                return;
            case 20:
                r0 = ldr(time_sleep + 28); // mp_const_none_obj;
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
                bl(this::mp_obj_get_int, time_sleep_ms + 6 | 1, 6);
                return;
            case 6:
                cmp(r0, 0);
                if (ble(14)) return;
            case 10:
                bl(this::mp_hal_delay_ms, time_sleep_ms + 14 | 1, 14);
                return;
            case 14:
                r0 = ldr(time_sleep_ms + 20); // mp_const_none_obj;
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
                bl(this::mp_obj_get_int, time_ticks_add + 10 | 1, 10);
                return;
            case 10:
                r4 = asrs(r4, 1);
                r0 = adds(r4, r0);
                r4 = ldr(time_ticks_add + 28);
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
                bl(this::mp_hal_ticks_ms, time_ticks_ms + 6 | 1, 6);
                return;
            case 6:
                r3 = ldr(time_ticks_ms + 20);
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
                bl(this::mp_hal_ticks_cpu, time_ticks_cpu + 6 | 1, 6);
                return;
            case 6:
                r3 = ldr(time_ticks_cpu + 20);
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
