package kr.pe.ecmaxp.thumbjk

import kr.pe.ecmaxp.thumbsk.CPU
import kr.pe.ecmaxp.thumbsk.Memory
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

abstract class KotlinCPU(memory: Memory) : JavaCPU(memory) {
    private var cb: Callback = Callback { crash() }
    private var cb_offset: Int = 0

    private var hf_addr: Int = 0
    private var hf_func: Callback = Callback { crash() }
    private var hf_offset: Int = 0

    protected val hints: SortedMap<Int, Pair<Callback, Int>> = sortedMapOf()
    val refCPU = CPU()

    protected abstract fun gen_hints();

    init {
        refCPU.memory = memory

        @Suppress("LeakingThis")
        gen_hints()
    }

    val lastVisits = ArrayDeque<String>();

    protected fun show(tag: String, forced: Boolean = false) {
        if (true)
            return;

        val stackTrace = Thread.currentThread().getStackTrace();
        for (st in stackTrace) {
            if (st.fileName.startsWith("MicroPython")) {
                val line = st.toString()
                if (!lastVisits.contains(line) || forced) {
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

    protected fun hint(addr: Int, func: Callback, offset: Int = 0) {
        hints[(addr + offset) or 1] = Pair(func, offset)
    }

    private fun jump(func: Callback?, func_offset: Int) {
        show("jump")

        if (func != null)
            cb = func

        cb_offset = func_offset
    }

    fun jump(addr: Int): Boolean {
        if ((addr and 1) == 0)
            crash()

        if (addr == hf_addr) {
            jump(hf_func, hf_offset)
            return true
        }

        val hint = hints.get(addr)
        if (hint != null) {
            jump(hint.first, hint.second)
            return true
        }

        return false
    }

    fun link(lr_addr: Int, return_offset: Int) {
        lr = lr_addr
        hf_addr = lr
        hf_func = cb
        hf_offset = return_offset
    }

    fun crash(): Nothing {
        throw Exception()
    }

    private val srMemory = refCPU.memory;
    private var mem: Memory? = null;
    private var init = false

    private var srAddr: Int? = null;
    private var srValue: Int? = null;

    private fun stepMemory(addr: Int, has_value: Boolean = false) {
        if (true)
            return

        srAddr = addr;

        if (has_value) {
            srValue = memory.readInt(addr - addr % 4);
        } else {
            srValue = null
        }
    }

    protected fun step() {
        if (true)
            return

        if (!init) {
            refCPU.regs = regs;
            mem = refCPU.memory.copy()

            init = true;
            return;
        }

        refCPU.memory = mem!!
        refCPU.interruptHandler = { imm ->
            run() {
                println("svc ${imm}")
            }
        }

        refCPU.run(1);
        refCPU.memory = srMemory

        if (srAddr != null) {
            if (false) { // set true when memory or regs error
                val srRegion = srMemory.findRegion(Integer.toUnsignedLong(srAddr!!), 0)
                val refRegion = mem!!.findRegion(Integer.toUnsignedLong(srAddr!!), 0)
                if (!srRegion.buffer.contentEquals(refRegion.buffer))
                    println("memory different!")
            }

            if (srValue != null) {
                srValue = srMemory.readInt(srAddr!!- srAddr!! % 4)
                val refValue = mem!!.readInt(srAddr!!- srAddr!! % 4)
                if (srValue!! != refValue) {
                    val msg = "invalid memory ${srAddr!!} => src=${srValue}; ref=${refValue}"
                    println(msg)
                    crash()
                }

                srAddr = null
                srValue = null
            }

        }

        val srcRegs = regs.load();
        val refRegs = refCPU.regs.load();
        var hasDiff = false
        for (i in 0 until srcRegs.size) {
            if (srcRegs[i] != refRegs[i]) {
                val msg = "invalid reg ${i} => src=${srcRegs[i]}; ref=${refRegs[i]}"
                println(msg)
                hasDiff = true
            }
        }

        if (hasDiff)
            crash()
    }

    fun call(cb: Callback, handler: InterruptHandler) {
        jump(cb, 0)
        run(handler)
    }

    fun run(handler: InterruptHandler): Int {
        while (true) {
            try {
                while (true)
                    cb(cb_offset)
            } catch (intr: Interrupt) {
                handler(intr.svc)
            }
        }
    }

    fun add(left: Int, right: Int): Int {
        step()
        val value = left + right

        pc += 2
        return value
    }

    fun sub(left: Int, right: Int): Int {
        step()
        val value = left - right

        pc += 2
        return value
    }

    fun mov(value: Int): Int {
        step()
        pc += 2
        return value
    }

    fun adr(base: Int, offset: Int): Int {
        step()
        pc += 2
        return base + offset
    }

    fun cmp(left: Int, right: Int) {
        step()
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
        step()
        val Lvalue = (left.toLong() and 0xffffffffL) + (right.toLong() and 0xffffffffL)
        val value = Lvalue.toInt()

        n = value < 0
        z = value == 0
        c = Lvalue > 0xFFFFFFFFL
        v = left xor value and (right xor value) < 0
        pc += 2
    }

    fun rev(left: Int): Int {
        step()
        val value = left.ushr(24) and 0xFF or (
                left.ushr(16) and 0xFF shl 8) or (
                left.ushr(8) and 0xFF shl 16) or
                (left and 0xFF shl 24)

        pc += 2
        return value
    }

    fun adds(left: Int, right: Int): Int {
        step()
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
        step()
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

    @Suppress("UNUSED_PARAMETER")
    fun movs(reg: Int, value: Int): Int {
        step()
        n = value < 0
        z = value == 0
        pc += 2
        return value
    }

    fun ands(left: Int, right: Int): Int {
        step()
        val value = left and right

        n = value < 0
        z = value == 0
        pc += 2
        return value
    }

    fun eors(left: Int, right: Int): Int {
        step()
        val value = left xor right

        n = value < 0
        z = value == 0
        pc += 2
        return value
    }

    fun lsls(left: Int, right: Int): Int {
        step()
        val value = left shl right

        if (right > 0)
            c = left shl right - 1 and BitConsts.FN != 0

        n = value < 0
        z = value == 0
        pc += 2
        return value
    }

    fun lsrs(left: Int, right: Int): Int {
        step()
        val value = left ushr right

        n = value < 0
        z = value == 0
        c = left and (1 shl right - 1) != 0
        pc += 2
        return value
    }

    fun asrs(left: Int, right: Int): Int {
        step()
        val value = left shr right

        n = value < 0
        z = value == 0
        c = left and (1 shl right - 1) != 0
        pc += 2
        return value
    }

    fun adcs(left: Int, right: Int): Int {
        step()
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
        step()
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
        step()
        val offset = right and 31
        val value = left.ushr(offset) or (left shl 32 - offset)

        n = value < 0
        z = value == 0
        c = left.ushr(offset - 1) and BitConsts.I0 != 0
        pc += 2
        return value
    }

    fun tst(left: Int, right: Int) {
        step()
        val value = left and right

        n = value < 0
        z = value == 0
        pc += 2
    }

    fun rsbs(right: Int): Int {
        step()
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
        step()
        val value = left or right

        n = value < 0
        z = value == 0
        pc += 2
        return value
    }

    fun muls(left: Int, right: Int): Int {
        step()
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
        step()
        val value = left and right.inv()

        n = value < 0
        z = value == 0
        pc += 2
        return value
    }

    fun mvns(@Suppress("UNUSED_PARAMETER") left: Int, right: Int): Int {
        step()
        val value = right.inv()

        n = value < 0
        z = value == 0
        pc += 2
        return value
    }

    fun ldrb(addr: Int): Int {
        step()
        val value = memory.readByte(addr).toInt() and 0xFF
        stepMemory(addr, true)

        pc += 2
        return value
    }

    fun ldr(addr: Int): Int {
        step()
        val value = memory.readInt(addr)
        // stepMemory(addr, memory.readInt(addr))

        pc += 2
        return value
    }

    fun strb(addr: Int, value: Int) {
        step()
        memory.writeByte(addr, value.toByte())
        // stepMemory(addr, memory.readInt(addr))

        pc += 2
    }

    fun str(addr: Int, value: Int) {
        step()

        memory.writeInt(addr, value)
        // stepMemory(addr, memory.readInt(addr))

        pc += 2
    }

    fun ldrsh(addr: Int): Int {
        step()
        val value = memory.readShort(addr).toInt()
        // stepMemory(addr, memory.readInt(addr))

        pc += 2
        return value
    }

    fun ldrsb(addr: Int): Int {
        step()
        val value = memory.readByte(addr).toInt()
        // stepMemory(addr, memory.readInt(addr))

        pc += 2
        return value
    }

    fun ldrh(addr: Int): Int {
        step()
        val value = memory.readShort(addr).toInt() and 0xFFFF
        // stepMemory(addr, memory.readInt(addr))

        pc += 2
        return value
    }

    fun strh(addr: Int, value: Int) {
        step()
        memory.writeShort(addr, value.toShort())
        // stepMemory(addr, memory.readInt(addr))

        pc += 2
    }

    fun sxth(left: Int): Int {
        step()
        val value = left.toShort().toInt()

        pc += 2
        return value
    }

    fun sxtb(left: Int): Int {
        step()
        val value = left.toByte().toInt()

        pc += 2
        return value
    }

    fun uxth(left: Int): Int {
        step()
        val value = left and 0xFFFF

        pc += 2
        return value
    }

    fun uxtb(left: Int): Int {
        step()
        val value = left and 0XFF

        pc += 2
        return value
    }

    fun push(R: Boolean, vararg Vlist: Int) {
        step()
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
            // stepMemory(addr)
            sp = addr
        }

        pc += 2
    }

    fun pop(R: Boolean, vararg Rlist: Int) {
        step()
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

                autob(value)
            } else {
                pc += 2
            }
        } finally {
            // stepMemory(addr)
            sp = addr
        }
    }

    fun stm(addr: Int, vararg Vlist: Int): Int {
        step()
        var vaddr = addr

        for (value in Vlist) {
            memory.writeInt(addr, value)
            vaddr += 4
        }

        pc += 2
        stepMemory(vaddr)
        return vaddr
    }

    fun ldm(addr: Int, vararg Rlist: Int): Int {
        step()
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

        pc += 2
        stepMemory(vaddr)
        return vaddr
    }

    fun beq(func_offset: Int): Boolean {
        return beq(cb, func_offset)
    }

    fun beq(): Boolean {
        step()
        val cond = z
        if (cond)
            return true
        else
            pc += 2

        return cond
    }

    fun beq(func: Callback, func_offset: Int): Boolean {
        val cond = beq()
        if (cond)
            jump(func, func_offset)

        return cond
    }

    fun bne(func_offset: Int): Boolean {
        return bne(cb, func_offset)
    }

    fun bne(): Boolean {
        step()
        val cond = !z
        if (cond)
            return true
        else
            pc += 2

        return cond
    }

    fun bne(func: Callback, func_offset: Int): Boolean {
        val cond = bne()
        if (cond)
            jump(func, func_offset)

        return cond
    }

    fun bhs(func_offset: Int): Boolean {
        return bhs(cb, func_offset)
    }

    fun bhs(): Boolean {
        step()
        val cond = c
        if (cond)
            return true
        else
            pc += 2

        return cond
    }

    fun bhs(func: Callback, func_offset: Int): Boolean {
        val cond = bhs()
        if (cond)
            jump(func, func_offset)

        return cond
    }

    fun blo(func_offset: Int): Boolean {
        return blo(cb, func_offset)
    }

    fun blo(): Boolean {
        step()
        val cond = !c
        if (cond)
            return true
        else
            pc += 2

        return cond
    }

    fun blo(func: Callback, func_offset: Int): Boolean {
        val cond = blo()
        if (cond)
            jump(func, func_offset)

        return cond
    }

    fun bmi(func_offset: Int): Boolean {
        return bmi(cb, func_offset)
    }

    fun bmi(): Boolean {
        step()
        val cond = n
        if (cond)
            return true
        else
            pc += 2

        return cond
    }

    fun bmi(func: Callback, func_offset: Int): Boolean {
        val cond = bmi()
        if (cond)
            jump(func, func_offset)

        return cond
    }

    fun bpl(func_offset: Int): Boolean {
        return bpl(cb, func_offset)
    }

    fun bpl(): Boolean {
        step()
        val cond = !n
        if (cond)
            return true
        else
            pc += 2

        return cond
    }

    fun bpl(func: Callback, func_offset: Int): Boolean {
        val cond = bpl()
        if (cond)
            jump(func, func_offset)

        return cond
    }

    fun bvs(func_offset: Int): Boolean {
        return bvs(cb, func_offset)
    }

    fun bvs(): Boolean {
        step()
        val cond = v
        if (cond)
            return true
        else
            pc += 2

        return cond
    }

    fun bvs(func: Callback, func_offset: Int): Boolean {
        val cond = bvs()
        if (cond)
            jump(func, func_offset)

        return cond
    }

    fun bvc(func_offset: Int): Boolean {
        return bvc(cb, func_offset)
    }

    fun bvc(): Boolean {
        step()
        val cond = !v
        if (cond)
            return true
        else
            pc += 2

        return cond
    }

    fun bvc(func: Callback, func_offset: Int): Boolean {
        val cond = bvc()
        if (cond)
            jump(func, func_offset)

        return cond
    }

    fun bhi(func_offset: Int): Boolean {
        return bhi(cb, func_offset)
    }

    fun bhi(): Boolean {
        step()
        val cond = c && !z
        if (cond)
            return true
        else
            pc += 2

        return cond
    }

    fun bhi(func: Callback, func_offset: Int): Boolean {
        val cond = bhi()
        if (cond)
            jump(func, func_offset)

        return cond
    }

    fun bls(func_offset: Int): Boolean {
        return bls(cb, func_offset)
    }

    fun bls(): Boolean {
        step()
        val cond = !c || z
        if (cond)
            return true
        else
            pc += 2

        return cond
    }

    fun bls(func: Callback, func_offset: Int): Boolean {
        val cond = bls()
        if (cond)
            jump(func, func_offset)

        return cond
    }

    fun bge(func_offset: Int): Boolean {
        return bge(cb, func_offset)
    }

    fun bge(): Boolean {
        step()
        val cond = n == v
        if (cond)
            return true
        else
            pc += 2

        return cond
    }

    fun bge(func: Callback, func_offset: Int): Boolean {
        val cond = bge()
        if (cond)
            jump(func, func_offset)

        return cond
    }

    fun blt(func_offset: Int): Boolean {
        return blt(cb, func_offset)
    }

    fun blt(): Boolean {
        step()
        val cond = n != v
        if (cond)
            return true
        else
            pc += 2

        return cond
    }

    fun blt(func: Callback, func_offset: Int): Boolean {
        val cond = blt()
        if (cond)
            jump(func, func_offset)

        return cond
    }

    fun bgt(func_offset: Int): Boolean {
        return bgt(cb, func_offset)
    }

    fun bgt(): Boolean {
        step()
        val cond = !z && n == v
        if (cond)
            return true
        else
            pc += 2

        return cond
    }

    fun bgt(func: Callback, func_offset: Int): Boolean {
        val cond = bgt()
        if (cond)
            jump(func, func_offset)

        return cond
    }

    fun ble(func_offset: Int): Boolean {
        return ble(cb, func_offset)
    }

    fun ble(): Boolean {
        step()
        val cond = z || n != v
        if (cond)
            return true
        else
            pc += 2

        return cond
    }

    fun ble(func: Callback, func_offset: Int): Boolean {
        val cond = ble()
        if (cond)
            jump(func, func_offset)

        return cond
    }

    fun svc(imm: Int, return_offset: Int): Int {
        step()
        jump(cb, return_offset)
        throw Interrupt(imm)
    }

    fun autob(addr: Int) {
        if (jump(addr or 1))
            return;

        TODO("not implemented ${addr}")
    }

    fun b(addr: Int) {
        step()
        if (jump(addr or 1))
            return;

        TODO("not implemented ${addr}")
    }

    fun b(func: Callback) {
        step()
        jump(func, 0)
    }

    fun bl(func: Callback, lr_addr: Int, return_offset: Int) {
        step()
        link(lr_addr, return_offset)
        jump(func, 0)
    }

    fun bl(func: Callback?, func_offset: Int, lr_addr: Int, return_offset: Int) {
        step()
        link(lr_addr, return_offset)
        jump(func, func_offset)
    }

    fun blx(func: Callback, lr_addr: Int, return_offset: Int) {
        step()
        link(lr_addr, return_offset)
        jump(func, 0)
    }

    fun blx(addr: Int, lr_addr: Int, return_offset: Int) {
        step()
        link(lr_addr, return_offset)
        if (jump(addr))
            return;

        TODO("no hint ${addr}")
    }

    fun bx(addr: Int) {
        step()
        if (jump(addr))
            return;

        TODO("no hint ${addr}")
    }
}