package kr.pe.ecmaxp.openpie.arch.types

import kr.pe.ecmaxp.openpie.arch.msgpack.Msgpack
import kr.pe.ecmaxp.thumbsf.CPU
import kr.pe.ecmaxp.thumbsf.consts.*

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

    fun loadBuffer(cpu: CPU): ByteArray {
        return cpu.memory.readBuffer(r1, r2)
    }

    fun loadObject(cpu: CPU): Any? {
        val buf = loadBuffer(cpu)
        return Msgpack.loads(buf)
    }
}
