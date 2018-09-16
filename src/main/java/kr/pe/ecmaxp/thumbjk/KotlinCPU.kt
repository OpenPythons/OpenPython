package kr.pe.ecmaxp.thumbjk

import kr.pe.ecmaxp.thumbsk.CPU
import kr.pe.ecmaxp.thumbsk.exc.InvalidAddressArmException
import kr.pe.ecmaxp.thumbsk.helper.BitConsts
import kr.pe.ecmaxp.thumbsk.helper.BitConsts.I0

abstract class KotlinCPU(cpu: CPU) : JavaCPU(cpu) {
    var running = false

    fun crash() {
        throw Exception()
    }

    fun process() {

    }

    fun call(cb_addr: Int) {
        TODO("not yet")
    }

    fun call(cb_addr: Int, cb: Callback) {
        call(cb_addr, cb, 0)
    }

    fun call(cb_addr: Int, cb: Callback, offset: Int) {
        jump(cb_addr, cb, offset)
        running = true
        while (running)
            cb(cb_offset)
    }

    fun add(left: Int, right: Int): Int {
        val value = left + right

        pc += 2
        return value
    }

    fun sub(left: Int, right: Int): Int {
        val value = left - right

        pc += 2
        return value
    }

    fun mov(value: Int, src: Int, dest: Int): Int {
        pc += 2
        return value
    }

    fun mov_pc(value: Int): Int { // TODO: check register PC?
        pc += value
        pc += 0
        return pc
    }

    fun adr(base: Int, offset: Int): Int {
        pc += 2
        return base + offset
    }

    fun cmp(left: Int, right: Int) {
        val Lvalue = (left.toLong() and 0xffffffffL) +
                (right.inv().toLong() and 0xffffffffL) + 1L
        val value = Lvalue.toInt()

        n = value < 0
        z = value == 0
        c = Lvalue > 0xFFFFFFFFL
        v = left xor right and (left xor value) < 0
        pc += 2
    }

    fun cmn(left: Int, right: Int) {
        val Lvalue = (left.toLong() and 0xffffffffL) + (right.toLong() and 0xffffffffL)
        val value = Lvalue.toInt()

        n = value < 0
        z = value == 0
        c = Lvalue > 0xFFFFFFFFL
        v = left xor value and (right xor value) < 0
        pc += 2
    }

    fun rev(left: Int): Int {
        val value = left.ushr(24) and 0xFF or (
                left.ushr(16) and 0xFF shl 8) or (
                left.ushr(8) and 0xFF shl 16) or
                (left and 0xFF shl 24)

        pc += 2
        return value
    }

    fun adds(left: Int, right: Int): Int {
        val Lleft = left.toLong() and 0xffffffffL
        val Lright = right.toLong() and 0xffffffffL
        val Lvalue = Lleft + Lright;
        val value = Lvalue.toInt()

        n = value < 0
        z = value == 0
        c = Lvalue > 0xFFFFFFFFL
        v = left xor value and (right xor value) < 0
        pc += 2
        return value
    }

    fun subs(left: Int, right: Int): Int {
        val Lleft = left.toLong() and 0xffffffffL
        val LIright = right.inv().toLong() and 0xffffffffL
        val Lvalue = Lleft + LIright + 1L
        val value = Lvalue.toInt()

        n = value < 0
        z = value == 0
        c = Lvalue > 0xFFFFFFFFL
        v = left xor right and (left xor value) < 0
        pc += 2
        return value
    }

    fun movs(reg: Int, value: Int): Int {
        // if (reg == PC);

        n = value < 0
        z = value == 0
        pc += 2
        return value
    }

    fun ands(left: Int, right: Int): Int {
        val value = left and right

        n = value < 0
        z = value == 0
        pc += 2
        return value
    }

    fun eors(left: Int, right: Int): Int {
        val value = left xor right

        n = value < 0
        z = value == 0
        pc += 2
        return value
    }

    fun lsls(left: Int, right: Int): Int {
        val value = left shl right

        if (right > 0)
            c = left shl right - 1 and BitConsts.FN != 0

        n = value < 0
        z = value == 0
        pc += 2
        return value
    }

    fun lsrs(left: Int, right: Int): Int {
        val value = left ushr right

        n = value < 0
        z = value == 0
        c = left and (1 shl right - 1) != 0
        pc += 2
        return value
    }

    fun asrs(left: Int, right: Int): Int {
        val value = left shr right

        n = value < 0
        z = value == 0
        c = left and (1 shl right - 1) != 0
        pc += 2
        return value
    }

    fun adcs(left: Int, right: Int): Int {
        val Lvalue = (left.toLong() and 0xffffffffL) +
                (right.toLong() and 0xffffffffL) + if (c) 1L else 0L
        val value = Lvalue.toInt()

        n = value < 0
        z = value == 0
        c = Lvalue != value.toLong()
        v = left > 0 && right > 0 && value < 0 || left < 0 && right < 0 && value > 0
        pc += 2
        return value
    }

    fun sbcs(left: Int, right: Int): Int {
        val Lvalue = left.toLong() - right.toLong() - if (c) 0L else 1L
        val value = left - right - if (c) 0 else 1

        n = value < 0
        z = value == 0
        c = c || value < 0
        v = Lvalue != value.toLong()
        pc += 2
        return value
    }

    fun rors(left: Int, right: Int): Int {
        val offset = right and 31
        val value = left.ushr(offset) or (left shl 32 - offset)

        n = value < 0
        z = value == 0
        c = left.ushr(offset - 1) and BitConsts.I0 != 0
        pc += 2
        return value
    }

    fun tst(left: Int, right: Int) {
        val value = left and right

        n = value < 0
        z = value == 0
        pc += 2
    }

    fun rsbs(left: Int, right: Int): Int {
        val Lvalue = (right.inv().toLong() and 0xffffffffL) + 1L
        val value = Lvalue.toInt()

        n = value < 0
        z = value == 0
        c = Lvalue > 0xFFFFFFFFL
        v = right and value < 0
        pc += 2
        return value
    }

    fun orrs(left: Int, right: Int): Int {
        val value = left or right

        n = value < 0
        z = value == 0
        pc += 2
        return value
    }

    fun muls(left: Int, right: Int): Int {
        val svalue = left.toLong() * right.toLong()
        val value = left * right

        n = value < 0
        z = value == 0
        c = c or (value.toLong() != svalue) // ???
        v = false // svalue != value?
        pc += 2
        return value
    }

    fun bics(left: Int, right: Int): Int {
        val value = left and right.inv()

        n = value < 0
        z = value == 0
        pc += 2
        return value
    }

    fun mvns(left: Int, right: Int): Int {
        val value = right.inv()

        n = value < 0
        z = value == 0
        pc += 2
        return value
    }

    fun ldrb(addr: Int): Int {
        val value = memory.readByte(addr).toInt() and 0xFF
        pc += 2
        return value
    }

    fun ldr(addr: Int): Int {
        val value = memory.readInt(addr)

        pc += 2
        return value
    }

    fun strb(addr: Int, value: Int) {
        memory.writeByte(addr, value.toByte())

        pc += 2
    }

    fun str(addr: Int, value: Int) {
        memory.writeInt(addr, value)
        
        pc += 2
    }

    fun ldrsh(addr: Int): Int {
        val value = memory.readShort(addr).toInt()

        pc += 2
        return value
    }

    fun ldrsb(addr: Int): Int {
        val value = memory.readByte(addr).toInt()

        pc += 2
        return value
    }

    fun ldrh(addr: Int): Int {
        val value = memory.readShort(addr).toInt()

        pc += 2
        return value
    }

    fun strh(addr: Int, value: Int) {
        memory.writeShort(addr, value.toShort())

        pc += 2
    }

    fun sxth(left: Int): Int {
        val value = left.toShort().toInt()

        pc += 2
        return value
    }

    fun sxtb(left: Int): Int {
        val value = left.toByte().toInt()

        pc += 2
        return value
    }

    fun uxth(left: Int): Int {
        val value = left and 0xFFFF

        pc += 2
        return value
    }

    fun uxtb(left: Int): Int {
        val value = left and 0XFF

        pc += 2
        return value
    }

    fun push(R: Boolean, vararg Vlist: Int) {
        var addr = sp

        try {
            if (R) // PUSH { ..., LR }
            {
                addr -= 4
                memory.writeInt(addr, lr)
            }

            // PUSH { ... }
            for (value in Vlist.reversed()) {
                addr -= 4
                memory.writeInt(addr, value)
            }
        } finally {
            sp = addr
        }

        pc += 2
    }

    fun pop(R: Boolean, vararg Rlist: Int) {
        var addr = sp

        try {
            // POP { Rlist }
            for (reg in Rlist) {
                val value = memory.readInt(addr)

                when (reg) {
                    0 -> r0 = value
                    1 -> r1 = value
                    2 -> r2 = value
                    3 -> r3 = value
                    4 -> r4 = value
                    5 -> r5 = value
                    6 -> r6 = value
                    7 -> r7 = value
                    else -> crash()
                }

                addr += 4
            }

            if (R) { // :10111101 {..., PC} ; POP { ..., PC }
                val value = memory.readInt(addr)
                if (value and I0 != 1)
                    throw InvalidAddressArmException()

                pc = value and I0.inv()
                addr += 4
                return
            } else {
                pc += 2

            }
        } finally {
            sp = addr
        }
    }

    fun stm(addr: Int, vararg Vlist: Int): Int {
        pc += 2
        return 0
    }

    fun ldm(addr: Int, vararg Rlist: Int): Int {
        pc += 2
        return addr
    }

    private var cb: Callback? = null
    private var cb_offset: Int = 0

    private var cbr: Callback? = null
    private var cbr_addr: Int = 0
    private var cbr_offset: Int = 0

    private fun jump(func_addr: Int, func: Callback, func_offset: Int) {
        pc = func_addr + func_offset;
        cb = func
        cb_offset = func_offset
    }

    private fun jump(addr: Int)
    {
       // TODO: find address
    }

    private fun jump(func_addr: Int, func: Callback, func_offset: Int, origin_addr: Int, origin_cb: Callback, origin_offset: Int)
    {
        jump(func_addr, func, func_offset);

        cbr = origin_cb
        cbr_addr = origin_addr + origin_offset
        cbr_offset = origin_offset

        lr = cbr_addr;
    }

    fun beq(): Boolean {
        return z
    }

    fun beq(addr: Int): Boolean {
        val cond = beq()
        if (cond)
            jump(addr)
        else
            pc += 2

        return cond
    }

    fun beq(func_addr: Int, func: Callback, func_offset: Int): Boolean {
        val cond = beq()
        if (cond)
            jump(func_addr, func, func_offset)
        else
            pc += 2

        return cond
    }

    fun bne(): Boolean {
        return !z
    }

    fun bne(addr: Int): Boolean {
        val cond = bne()
        if (cond)
            jump(addr)
        else
            pc += 2

        return cond
    }

    fun bne(func_addr: Int, func: Callback, func_offset: Int): Boolean {
        val cond = bne()
        if (cond)
            jump(func_addr, func, func_offset)
        else
            pc += 2

        return cond
    }

    fun bhs(): Boolean {
        return c
    }

    fun bhs(addr: Int): Boolean {
        val cond = bhs()
        if (cond)
            jump(addr)
        else
            pc += 2

        return cond
    }

    fun bhs(func_addr: Int, func: Callback, func_offset: Int): Boolean {
        val cond = bhs()
        if (cond)
            jump(func_addr, func, func_offset)
        else
            pc += 2

        return cond
    }

    fun blo(): Boolean {
        return !c
    }

    fun blo(addr: Int): Boolean {
        val cond = blo()
        if (cond)
            jump(addr)
        else
            pc += 2

        return cond
    }

    fun blo(func_addr: Int, func: Callback, func_offset: Int): Boolean {
        val cond = blo()
        if (cond)
            jump(func_addr, func, func_offset)
        else
            pc += 2

        return cond
    }

    fun bmi(): Boolean {
        return n
    }

    fun bmi(addr: Int): Boolean {
        val cond = bmi()
        if (cond)
            jump(addr)
        else
            pc += 2

        return cond
    }

    fun bmi(func_addr: Int, func: Callback, func_offset: Int): Boolean {
        val cond = bmi()
        if (cond)
            jump(func_addr, func, func_offset)
        else
            pc += 2

        return cond
    }

    fun bpl(): Boolean {
        return !n
    }

    fun bpl(addr: Int): Boolean {
        val cond = bpl()
        if (cond)
            jump(addr)
        else
            pc += 2

        return cond
    }

    fun bpl(func_addr: Int, func: Callback, func_offset: Int): Boolean {
        val cond = bpl()
        if (cond)
            jump(func_addr, func, func_offset)
        else
            pc += 2

        return cond
    }

    fun bvs(): Boolean {
        return v
    }

    fun bvs(addr: Int): Boolean {
        val cond = bvs()
        if (cond)
            jump(addr)
        else
            pc += 2

        return cond
    }

    fun bvs(func_addr: Int, func: Callback, func_offset: Int): Boolean {
        val cond = bvs()
        if (cond)
            jump(func_addr, func, func_offset)
        else
            pc += 2

        return cond
    }

    fun bvc(): Boolean {
        return !v
    }

    fun bvc(addr: Int): Boolean {
        val cond = bvc()
        if (cond)
            jump(addr)
        else
            pc += 2

        return cond
    }

    fun bvc(func_addr: Int, func: Callback, func_offset: Int): Boolean {
        val cond = bvc()
        if (cond)
            jump(func_addr, func, func_offset)
        else
            pc += 2

        return cond
    }

    fun bhi(): Boolean {
        return c && !z
    }

    fun bhi(addr: Int): Boolean {
        val cond = bhi()
        if (cond)
            jump(addr)
        else
            pc += 2

        return cond
    }

    fun bhi(func_addr: Int, func: Callback, func_offset: Int): Boolean {
        val cond = bhi()
        if (cond)
            jump(func_addr, func, func_offset)
        else
            pc += 2

        return cond
    }

    fun bls(): Boolean {
        return !c || z
    }

    fun bls(addr: Int): Boolean {
        val cond = bls()
        if (cond)
            jump(addr)
        else
            pc += 2

        return cond
    }

    fun bls(func_addr: Int, func: Callback, func_offset: Int): Boolean {
        val cond = bls()
        if (cond)
            jump(func_addr, func, func_offset)
        else
            pc += 2

        return cond
    }

    fun bge(): Boolean {
        return n == v
    }

    fun bge(addr: Int): Boolean {
        val cond = bge()
        if (cond)
            jump(addr)
        else
            pc += 2

        return cond
    }

    fun bge(func_addr: Int, func: Callback, func_offset: Int): Boolean {
        val cond = bge()
        if (cond)
            jump(func_addr, func, func_offset)
        else
            pc += 2

        return cond
    }

    fun blt(): Boolean {
        return n != v
    }

    fun blt(addr: Int): Boolean {
        val cond = blt()
        if (cond)
            jump(addr)
        else
            pc += 2

        return cond
    }

    fun blt(func_addr: Int, func: Callback, func_offset: Int): Boolean {
        val cond = blt()
        if (cond)
            jump(func_addr, func, func_offset)
        else
            pc += 2

        return cond
    }

    fun bgt(): Boolean {
        return !z && n == v
    }

    fun bgt(addr: Int): Boolean {
        val cond = bgt()
        if (cond)
            jump(addr)
        else
            pc += 2

        return cond
    }

    fun bgt(func_addr: Int, func: Callback, func_offset: Int): Boolean {
        val cond = bgt()
        if (cond)
            jump(func_addr, func, func_offset)
        else
            pc += 2

        return cond
    }

    fun ble(): Boolean {
        return z || n != v
    }

    fun ble(addr: Int): Boolean {
        val cond = ble()
        if (cond)
            jump(addr)
        else
            pc += 2

        return cond
    }

    fun ble(func_addr: Int, func: Callback, func_offset: Int): Boolean {
        val cond = ble()
        if (cond)
            jump(func_addr, func, func_offset)
        else
            pc += 2

        return cond
    }

    fun cbz(left: Int, right: Int): Int {
        pc += 2
        return 0
    }

    fun cbnz(left: Int, right: Int): Int {
        pc += 2
        return 0
    }

    fun svc(imm: Int): Int {
        pc += 2
        return 0
    }

    fun b(func_addr: Int)  {
        TODO("not implemented")
    }

    fun b(func_addr: Int, func: Callback, func_offset: Int) {
        jump(func_addr, func, func_offset)
    }

    fun bl(func_addr: Int) {
        TODO("not implemented")
    }

    fun bl(func_addr: Int, func: Callback, func_offset: Int, origin_addr: Int, origin_cb: Callback, origin_offset: Int) {
        jump(func_addr, func, func_offset, origin_addr, origin_cb, origin_offset)
    }

    fun blx(addr: Int) {
        if (addr == 0)
            running = false;

        TODO("not implemented")
    }

    fun blx(func_addr: Int, func: Callback, func_offset: Int) {
        jump(func_addr, func, func_offset)
    }

    fun bx(addr: Int) {
        TODO("not implemented")
    }
}