package kr.pe.ecmaxp.thumbjk

import kr.pe.ecmaxp.thumbsk.CPU
import kr.pe.ecmaxp.thumbsk.exc.InvalidAddressArmException
import kr.pe.ecmaxp.thumbsk.helper.BitConsts
import kr.pe.ecmaxp.thumbsk.helper.BitConsts.I0
import kr.pe.ecmaxp.thumbsk.helper.RegisterIndex.R0
import kr.pe.ecmaxp.thumbsk.helper.RegisterIndex.R1
import kr.pe.ecmaxp.thumbsk.helper.RegisterIndex.R2
import kr.pe.ecmaxp.thumbsk.helper.RegisterIndex.R3
import kr.pe.ecmaxp.thumbsk.helper.RegisterIndex.R4
import kr.pe.ecmaxp.thumbsk.helper.RegisterIndex.R5
import kr.pe.ecmaxp.thumbsk.helper.RegisterIndex.R6
import kr.pe.ecmaxp.thumbsk.helper.RegisterIndex.R7
import java.util.*

abstract class KotlinCPU(cpu: CPU) : JavaCPU(cpu) {
    var running = false

    private var cb: Callback = Callback { crash() }
    private var cb_offset: Int = 0
    private val hints: HashMap<Int, Pair<Callback, Int>> = hashMapOf();

    protected abstract fun gen_hints(): java.util.HashMap<Int, Callback>;

    init {
        @Suppress("LeakingThis")
        for (pair in gen_hints()){
            hints[pair.key or 1] = Pair(pair.value, 0)
        }
    }

    protected fun hint(addr: Int, func: Callback)  {
        hint(addr, func, 0)
    }

    val lastVisits = ArrayDeque<String>();

    protected fun show(tag: String) {
        val stackTrace = Thread.currentThread().getStackTrace();
        for (st in stackTrace) {
            if (st.fileName.startsWith("MicroPython")) {
                val line = st.toString()
                if (!lastVisits.contains(line)) {
                    print(tag)
                    print(" ")
                    println(line)
                    lastVisits.addLast(line)
                    if (lastVisits.size > 3)
                        lastVisits.removeFirst()
                }
                break
            }
        }
    }

    protected fun hint(addr: Int, func: Callback, offset: Int)  {
        if (!hints.contains(addr)) {
            show("hint")
        }

        hints[addr] = Pair(func, offset)
    }

    private fun jump(func: Callback?, func_offset: Int) {
        show("jump")
        if (func != null)
            cb = func

        cb_offset = func_offset
    }

    private fun jump(func: Callback?, func_offset: Int, return_offset: Int) {
        show("jump")
        hint(lr, cb, return_offset)

        if (func != null)
            cb = func

        cb_offset = func_offset
    }

    fun crash() {
        throw Exception()
    }

    fun process() {

    }

    var has_address = false;
    fun step(incr: Int) {
        // TODO: more step for all control flow in instruction operator function
        val is_empty = memory.readInt(536936352) == 0;
        if (has_address && is_empty) {
            throw Exception("panic")
        } else if (!is_empty) {
            has_address = true
        }

        pc += incr
    }

    fun call(cb: Callback) {
        call(cb, 0)
    }

    fun call(callback: Callback, offset: Int) {
        jump(callback, offset)
        running = true
        while (running)
            cb(cb_offset)
    }

    fun add(left: Int, right: Int): Int {
        val value = left + right

        step(2);
        return value
    }

    fun sub(left: Int, right: Int): Int {
        val value = left - right

        step(2);
        return value
    }

    fun mov(value: Int): Int {
        step(2);
        return value
    }

    fun adr(base: Int, offset: Int): Int {
        step(2);
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
        step(2);
    }

    fun cmn(left: Int, right: Int) {
        val Lvalue = (left.toLong() and 0xffffffffL) + (right.toLong() and 0xffffffffL)
        val value = Lvalue.toInt()

        n = value < 0
        z = value == 0
        c = Lvalue > 0xFFFFFFFFL
        v = left xor value and (right xor value) < 0
        step(2);
    }

    fun rev(left: Int): Int {
        val value = left.ushr(24) and 0xFF or (
                left.ushr(16) and 0xFF shl 8) or (
                left.ushr(8) and 0xFF shl 16) or
                (left and 0xFF shl 24)

        step(2);
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
        step(2);
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
        step(2);
        return value
    }

    @Suppress("UNUSED_PARAMETER")
    fun movs(reg: Int, value: Int): Int {
        n = value < 0
        z = value == 0
        step(2);
        return value
    }

    fun ands(left: Int, right: Int): Int {
        val value = left and right

        n = value < 0
        z = value == 0
        step(2);
        return value
    }

    fun eors(left: Int, right: Int): Int {
        val value = left xor right

        n = value < 0
        z = value == 0
        step(2);
        return value
    }

    fun lsls(left: Int, right: Int): Int {
        val value = left shl right

        if (right > 0)
            c = left shl right - 1 and BitConsts.FN != 0

        n = value < 0
        z = value == 0
        step(2);
        return value
    }

    fun lsrs(left: Int, right: Int): Int {
        val value = left ushr right

        n = value < 0
        z = value == 0
        c = left and (1 shl right - 1) != 0
        step(2);
        return value
    }

    fun asrs(left: Int, right: Int): Int {
        val value = left shr right

        n = value < 0
        z = value == 0
        c = left and (1 shl right - 1) != 0
        step(2);
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
        step(2);
        return value
    }

    fun sbcs(left: Int, right: Int): Int {
        val Lvalue = left.toLong() - right.toLong() - if (c) 0L else 1L
        val value = left - right - if (c) 0 else 1

        n = value < 0
        z = value == 0
        c = c || value < 0
        v = Lvalue != value.toLong()
        step(2);
        return value
    }

    fun rors(left: Int, right: Int): Int {
        val offset = right and 31
        val value = left.ushr(offset) or (left shl 32 - offset)

        n = value < 0
        z = value == 0
        c = left.ushr(offset - 1) and BitConsts.I0 != 0
        step(2);
        return value
    }

    fun tst(left: Int, right: Int) {
        val value = left and right

        n = value < 0
        z = value == 0
        step(2);
    }

    fun rsbs(@Suppress("UNUSED_PARAMETER") left: Int, right: Int): Int {
        val Lvalue = (right.inv().toLong() and 0xffffffffL) + 1L
        val value = Lvalue.toInt()

        n = value < 0
        z = value == 0
        c = Lvalue > 0xFFFFFFFFL
        v = right and value < 0
        step(2);
        return value
    }

    fun orrs(left: Int, right: Int): Int {
        val value = left or right

        n = value < 0
        z = value == 0
        step(2);
        return value
    }

    fun muls(left: Int, right: Int): Int {
        val svalue = left.toLong() * right.toLong()
        val value = left * right

        n = value < 0
        z = value == 0
        c = c or (value.toLong() != svalue) // ???
        v = false // svalue != value?
        step(2);
        return value
    }

    fun bics(left: Int, right: Int): Int {
        val value = left and right.inv()

        n = value < 0
        z = value == 0
        step(2);
        return value
    }

    fun mvns(@Suppress("UNUSED_PARAMETER") left: Int, right: Int): Int {
        val value = right.inv()

        n = value < 0
        z = value == 0
        step(2);
        return value
    }

    fun ldrb(addr: Int): Int {
        val value = memory.readByte(addr).toInt() and 0xFF
        step(2);
        return value
    }

    fun ldr(addr: Int): Int {
        val value = memory.readInt(addr)

        step(2);
        return value
    }

    fun strb(addr: Int, value: Int) {
        memory.writeByte(addr, value.toByte())

        step(2);
    }

    fun str(addr: Int, value: Int) {
        memory.writeInt(addr, value)
        
        step(2);
    }

    fun ldrsh(addr: Int): Int {
        val value = memory.readShort(addr).toInt()

        step(2);
        return value
    }

    fun ldrsb(addr: Int): Int {
        val value = memory.readByte(addr).toInt()

        step(2);
        return value
    }

    fun ldrh(addr: Int): Int {
        val value = memory.readShort(addr).toInt()

        step(2);
        return value
    }

    fun strh(addr: Int, value: Int) {
        memory.writeShort(addr, value.toShort())

        step(2);
    }

    fun sxth(left: Int): Int {
        val value = left.toShort().toInt()

        step(2);
        return value
    }

    fun sxtb(left: Int): Int {
        val value = left.toByte().toInt()

        step(2);
        return value
    }

    fun uxth(left: Int): Int {
        val value = left and 0xFFFF

        step(2);
        return value
    }

    fun uxtb(left: Int): Int {
        val value = left and 0XFF

        step(2);
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

        step(2);
    }

    fun pop(R: Boolean, vararg Rlist: Int) {
        var addr = sp

        try {
            // POP { Rlist }
            for (reg in Rlist) {
                val value = memory.readInt(addr)

                when (reg) {
                    R0 -> r0 = value
                    R1 -> r1 = value
                    R2 -> r2 = value
                    R3 -> r3 = value
                    R4 -> r4 = value
                    R5 -> r5 = value
                    R6 -> r6 = value
                    R7 -> r7 = value
                    else -> crash()
                }

                addr += 4
            }

            if (R) { // :10111101 {..., PC} ; POP { ..., PC }
                val value = memory.readInt(addr)
                if (value and I0 != 1)
                    throw InvalidAddressArmException()

                addr += 4

                b(value)
            } else {
                step(2);
            }
        } finally {
            sp = addr
        }
    }

    fun stm(addr: Int, vararg Vlist: Int): Int {
        var vaddr = addr

        for (value in Vlist) {
            memory.writeInt(addr, value)
            vaddr += 4
        }

        step(2);
        return vaddr
    }

    fun ldm(addr: Int, vararg Rlist: Int): Int {
        var vaddr = addr

        for (reg in Rlist) {
            val value = memory.readInt(addr)

            when (reg) {
                R0 -> r0 = value
                R1 -> r1 = value
                R2 -> r2 = value
                R3 -> r3 = value
                R4 -> r4 = value
                R5 -> r5 = value
                R6 -> r6 = value
                R7 -> r7 = value
                else -> crash()
            }

            vaddr += 4
        }

        step(2);
        return addr
    }

    fun beq(func: Callback?, func_offset: Int): Boolean {
        val cond = z
        if (cond)
            jump(func, func_offset)
        else
            step(2);

        return cond
    }

    fun bne(func: Callback?, func_offset: Int): Boolean {
        val cond = !z
        if (cond)
            jump(func, func_offset)
        else
            step(2);

        return cond
    }

    fun bhs(func: Callback?, func_offset: Int): Boolean {
        val cond = c
        if (cond)
            jump(func, func_offset)
        else
            step(2);

        return cond
    }

    fun blo(func: Callback?, func_offset: Int): Boolean {
        val cond = !c
        if (cond)
            jump(func, func_offset)
        else
            step(2);

        return cond
    }

    fun bmi(func: Callback?, func_offset: Int): Boolean {
        val cond = n
        if (cond)
            jump(func, func_offset)
        else
            step(2);

        return cond
    }

    fun bpl(func: Callback?, func_offset: Int): Boolean {
        val cond = !n
        if (cond)
            jump(func, func_offset)
        else
            step(2);

        return cond
    }

    fun bvs(func: Callback?, func_offset: Int): Boolean {
        val cond = v
        if (cond)
            jump(func, func_offset)
        else
            step(2);

        return cond
    }

    fun bvc(func: Callback?, func_offset: Int): Boolean {
        val cond = !v
        if (cond)
            jump(func, func_offset)
        else
            step(2);

        return cond
    }

    fun bhi(func: Callback?, func_offset: Int): Boolean {
        val cond = c && !z
        if (cond)
            jump(func, func_offset)
        else
            step(2);

        return cond
    }

    fun bls(func: Callback?, func_offset: Int): Boolean {
        val cond = !c || z
        if (cond)
            jump(func, func_offset)
        else
            step(2);

        return cond
    }

    fun bge(func: Callback?, func_offset: Int): Boolean {
        val cond = n == v
        if (cond)
            jump(func, func_offset)
        else
            step(2);

        return cond
    }

    fun blt(func: Callback?, func_offset: Int): Boolean {
        val cond = n != v
        if (cond)
            jump(func, func_offset)
        else
            step(2);

        return cond
    }

    fun bgt(func: Callback?, func_offset: Int): Boolean {
        val cond = !z && n == v
        if (cond)
            jump(func, func_offset)
        else
            step(2);

        return cond
    }

    fun ble(func: Callback?, func_offset: Int): Boolean {
        val cond = z || n != v
        if (cond)
            jump(func, func_offset)
        else
            step(2);

        return cond
    }

    fun svc(@Suppress("UNUSED_PARAMETER") imm: Int): Int {
        crash()

        step(2);
        return 0
    }

    fun b(addr: Int)  {
        if (jump(addr))
            return;

        TODO("not implemented")
    }

    fun b(func: Callback?) {
        jump(func, 0)
    }

    fun b(func: Callback?, func_offset: Int) {
        jump(func, func_offset)
    }

    fun bl(addr: Int, return_offset: Int) {
        hint(lr, cb, return_offset)
        if (jump(addr))
            return;

        TODO("not implemented")
    }

    fun bl(func: Callback?, return_offset: Int) {
        hint(lr, cb, return_offset)
        jump(func, 0, return_offset)
    }

    fun bl(func: Callback?, func_offset: Int, return_offset: Int) {
        hint(lr, cb, return_offset)
        jump(func, func_offset, return_offset)
    }

    fun blx(func: Callback, return_offset: Int) {
        hint(lr, cb, return_offset)
        jump(func, 0)
    }

    fun blx(addr: Int, return_offset: Int) {
        hint(lr, cb, return_offset)
        if (jump(addr))
            return;

        TODO("no hint")
    }

    fun jump(addr: Int): Boolean {
        assert((addr and 1) != 0)
        val hint = hints.get(addr)
        if (hint != null) {
            jump(hint.first, hint.second)
            return true
        }

        return false
    }

    fun bx(addr: Int) {
        if (jump(addr))
            return;

        TODO("no hint")
    }
}