package kr.pe.ecmaxp.openpie;

import kr.pe.ecmaxp.thumbsj.CPU;

import static kr.pe.ecmaxp.thumbsj.helper.RegisterIndex.*;

public class Interrupt
{
    public final int imm;
    public final int r0;
    public final int r1;
    public final int r2;
    public final int r3;
    public final int r4;

    public Interrupt(CPU cpu, int imm)
    {
        assert imm == 0;
        this.imm = cpu.regs.get(R7);
        this.r0 = cpu.regs.get(R0);
        this.r1 = cpu.regs.get(R1);
        this.r2 = cpu.regs.get(R2);
        this.r3 = cpu.regs.get(R3);
        this.r4 = cpu.regs.get(R4);
    }
}
