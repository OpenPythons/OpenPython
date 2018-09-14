package kr.pe.ecmaxp.thumbsj

import kr.pe.ecmaxp.thumbsj.helper.BitConsts
import kr.pe.ecmaxp.thumbsj.helper.RegisterIndex

class Registers {
    private var _regs: IntArray? = IntArray(RegisterIndex.CPSR + 1)

    init {
        _regs!![RegisterIndex.CPSR] = BitConsts.FT or // set Thumb
                BitConsts.FZ // set Zero
    }

    fun load(): IntArray {
        return _regs!!.clone()
    }

    fun store(regs: IntArray) {
        _regs = regs.clone()
    }

    fun copy(): Registers {
        val registers = Registers()
        val regs = load()
        registers.store(regs)
        return registers
    }

    operator fun set(index: Int, value: Int) {
        _regs!![index] = value
    }

    operator fun get(index: Int): Int {
        return _regs!![index]
    }
}
