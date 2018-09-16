package kr.pe.ecmaxp.thumbsk

import kr.pe.ecmaxp.thumbsk.helper.BitConsts
import kr.pe.ecmaxp.thumbsk.helper.BitConsts.FC
import kr.pe.ecmaxp.thumbsk.helper.BitConsts.FN
import kr.pe.ecmaxp.thumbsk.helper.BitConsts.FQ
import kr.pe.ecmaxp.thumbsk.helper.BitConsts.FV
import kr.pe.ecmaxp.thumbsk.helper.BitConsts.FZ
import kr.pe.ecmaxp.thumbsk.helper.RegisterIndex
import kr.pe.ecmaxp.thumbsk.helper.RegisterIndex.CPSR

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

    val q: Boolean get() = _regs!![CPSR] and FQ != 0
    val v: Boolean get() = _regs!![CPSR] and FV != 0
    val c: Boolean get() = _regs!![CPSR] and FC != 0
    val z: Boolean get() = _regs!![CPSR] and FZ != 0
    val n: Boolean get() = _regs!![CPSR] and FN != 0
}
