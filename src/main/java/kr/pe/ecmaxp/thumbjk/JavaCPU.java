package kr.pe.ecmaxp.thumbjk;

import kr.pe.ecmaxp.thumbsk.Memory;
import kr.pe.ecmaxp.thumbsk.Registers;

import static kr.pe.ecmaxp.thumbsk.helper.BitConsts.*;
import static kr.pe.ecmaxp.thumbsk.helper.RegisterIndex.*;


@SuppressWarnings("WeakerAccess")
abstract public class JavaCPU
{
    public final Memory memory;

    public JavaCPU(Memory memory)
    {
        this.memory = memory;
        setRegs(new Registers());
    }

    // register but fields
    public int r0;
    public int r1;
    public int r2;
    public int r3;
    public int r4;
    public int r5;
    public int r6;
    public int r7;
    public int r8;
    public int r9;
    public int r10;
    public int r11;
    public int r12;
    public int sp;
    public int lr;
    public int pc;
    public boolean q;
    public boolean n;
    public boolean z;
    public boolean c;
    public boolean v;

    @SuppressWarnings("unused")
    public Registers getRegs()
    {
        Registers regs = new Registers();
        int cpsr = (q ? FQ : 0) |
                (v ? FV : 0) |
                (c ? FC : 0) |
                (z ? FZ : 0) |
                (n ? FN : 0);

        regs.store(new int[]{
                r0, r1, r2, r3, r4, r5, r6, r7,
                r8, r9, r10, r11, r12, sp, lr, pc,
                cpsr
        });

        return regs;
    }

    public void setRegs(Registers regs)
    {
        int[] values = regs.load();
        r0 = values[R0];
        r1 = values[R1];
        r2 = values[R2];
        r3 = values[R3];
        r4 = values[R4];
        r5 = values[R5];
        r6 = values[R6];
        r7 = values[R7];
        r8 = values[R8];
        r9 = values[R9];
        r10 = values[R10];
        r11 = values[R11];
        r12 = values[R12];
        sp = values[SP];
        lr = values[LR];
        pc = values[PC];
        int cpsr = values[CPSR];
        q = (cpsr & FQ) != 0;
        v = (cpsr & FV) != 0;
        c = (cpsr & FC) != 0;
        z = (cpsr & FZ) != 0;
        n = (cpsr & FN) != 0;
    }
}

