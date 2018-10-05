package kr.pe.ecmaxp.thumbsf

import kr.pe.ecmaxp.thumbsf.consts.*

class Registers() {
    private var _regs: IntArray = IntArray(CPSR + 1)

    constructor(r0: Int = 0, r1: Int = 0, r2: Int = 0, r3: Int = 0,
                r4: Int = 0, r5: Int = 0, r6: Int = 0, r7: Int = 0,
                r8: Int = 0, r9: Int = 0, r10: Int = 0, r11: Int = 0,
                r12: Int = 0, sp: Int = 0, lr: Int = 0, pc: Int = 0) : this() {
        _regs[R0] = r0
        _regs[R1] = r1
        _regs[R2] = r2
        _regs[R3] = r3
        _regs[R4] = r4
        _regs[R5] = r5
        _regs[R6] = r6
        _regs[R7] = r7
        _regs[R8] = r8
        _regs[R9] = r9
        _regs[R10] = r10
        _regs[R11] = r11
        _regs[R12] = r12
        _regs[SP] = sp
        _regs[LR] = lr
        _regs[PC] = pc
    }

    init {
        _regs[CPSR] = FZ // set Zero
    }

    fun load(): IntArray {
        return _regs.clone()
    }

    fun store(regs: IntArray) {
        _regs = regs.clone()
    }

    fun fastLoad(): IntArray {
        return _regs.copyOfRange(0, R12 + 1)
    }

    fun fastStore(regs: IntArray, sp: Int, lr: Int, pc: Int) {
        for (reg in 0..R12)
            _regs[reg] = regs[reg]

        _regs[SP] = sp
        _regs[LR] = lr
        _regs[PC] = pc
    }

    fun copy(): Registers {
        val registers = Registers()
        val regs = load()
        registers.store(regs)
        return registers
    }

    operator fun set(index: Int, value: Int) {
        _regs[index] = value
    }

    operator fun get(index: Int): Int {
        return _regs[index]
    }

    fun setCPSR(v: Boolean, c: Boolean, z: Boolean, n: Boolean) {
        _regs[CPSR] = (if (v) FV else 0) or
                (if (c) FC else 0) or
                (if (z) FZ else 0) or
                if (n) FN else 0
    }

    val sp: Int get() = _regs[SP]
    val lr: Int get() = _regs[LR]
    val pc: Int get() = _regs[PC]
    val v: Boolean get() = _regs[CPSR] and FV != 0
    val c: Boolean get() = _regs[CPSR] and FC != 0
    val z: Boolean get() = _regs[CPSR] and FZ != 0
    val n: Boolean get() = _regs[CPSR] and FN != 0
}
