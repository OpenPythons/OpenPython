package kr.pe.ecmaxp.thumbjk;

import kr.pe.ecmaxp.thumbsk.CPU;
import kr.pe.ecmaxp.thumbsk.Memory;
import kr.pe.ecmaxp.thumbsk.Registers;

import static kr.pe.ecmaxp.thumbsk.helper.BitConsts.*;
import static kr.pe.ecmaxp.thumbsk.helper.RegisterIndex.*;

abstract public class JavaCPU
{
    final static boolean debug = true;

    public CPU cpu;
    public Memory memory;

    public JavaCPU()
    {
        this(new CPU());
    }

    public JavaCPU(CPU cpu)
    {
        this.cpu = cpu;
        this.memory = cpu.getMemory();
    }


    protected int r0 = 0;
    protected int r1 = 0;
    protected int r2 = 0;
    protected int r3 = 0;
    protected int r4 = 0;
    protected int r5 = 0;
    protected int r6 = 0;
    protected int r7 = 0;
    protected int r8 = 0;
    protected int r9 = 0;
    protected int r10 = 0;
    protected int r11 = 0;
    protected int r12 = 0;
    protected int sp = 0;
    protected int lr = 0;
    protected int pc = 0;
    protected boolean q = false;
    protected boolean n = false;
    protected boolean z = false;
    protected boolean c = false;
    protected boolean v = false;

    public Registers getRegs()
    {
        int cpsr = (q ? FQ : 0) |
                (v ? FV : 0) |
                (c ? FC : 0) |
                (z ? FZ : 0) |
                (n ? FN : 0);

        Registers regs = new Registers();
        regs.store(new int[]
                {
                        r0,
                        r1,
                        r2,
                        r3,
                        r4,
                        r5,
                        r6,
                        r7,
                        r8,
                        r9,
                        r10,
                        r11,
                        r12,
                        sp,
                        lr,
                        pc,
                        cpsr,
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

