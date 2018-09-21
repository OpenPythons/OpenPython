package kr.pe.ecmaxp.openpie

import kr.pe.ecmaxp.thumbsf.helper.*
import kr.pe.ecmaxp.thumbsf.CPU

class Interrupt(cpu: CPU, imm: Int) {
    val imm: Int
    val r0: Int
    val r1: Int
    val r2: Int
    val r3: Int
    val r4: Int

    init {
        assert(imm == 0)
        this.imm = cpu.regs[R7]
        this.r0 = cpu.regs[R0]
        this.r1 = cpu.regs[R1]
        this.r2 = cpu.regs[R2]
        this.r3 = cpu.regs[R3]
        this.r4 = cpu.regs[R4]
    }
}
