package kr.pe.ecmaxp.openpie

import kr.pe.ecmaxp.thumbsj.CPU

import kr.pe.ecmaxp.thumbsj.helper.RegisterIndex.*

class Interrupt(cpu: CPU, imm: Int) {
    val imm: Int
    val r0: Int
    val r1: Int
    val r2: Int
    val r3: Int
    val r4: Int

    init {
        assert(imm == 0)
        this.imm = cpu.regs.get(R7)
        this.r0 = cpu.regs.get(R0)
        this.r1 = cpu.regs.get(R1)
        this.r2 = cpu.regs.get(R2)
        this.r3 = cpu.regs.get(R3)
        this.r4 = cpu.regs.get(R4)
    }
}
