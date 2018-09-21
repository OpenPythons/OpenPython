package kr.pe.ecmaxp.thumbsf

import kr.pe.ecmaxp.thumbsf.helper.*

class Registers {
    private var _regs: IntArray = IntArray(CPSR + 1)

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

    fun setCPSR(q: Boolean, v: Boolean, c: Boolean, z: Boolean, n: Boolean) {
        _regs[CPSR] = (if (q) FQ else 0) or
                (if (v) FV else 0) or
                (if (c) FC else 0) or
                (if (z) FZ else 0) or
                if (n) FN else 0
    }

    val sp: Int get() = _regs[SP]
    val lr: Int get() = _regs[LR]
    val pc: Int get() = _regs[PC]
    val q: Boolean get() = _regs[CPSR] and FQ != 0
    val v: Boolean get() = _regs[CPSR] and FV != 0
    val c: Boolean get() = _regs[CPSR] and FC != 0
    val z: Boolean get() = _regs[CPSR] and FZ != 0
    val n: Boolean get() = _regs[CPSR] and FN != 0
}
