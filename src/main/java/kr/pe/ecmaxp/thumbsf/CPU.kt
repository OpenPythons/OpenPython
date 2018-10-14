package kr.pe.ecmaxp.thumbsf

import kr.pe.ecmaxp.thumbsf.consts.*
import kr.pe.ecmaxp.thumbsf.exc.InvalidAddressArmException
import kr.pe.ecmaxp.thumbsf.exc.InvalidMemoryException
import kr.pe.ecmaxp.thumbsf.exc.UnexceptedLogicError
import kr.pe.ecmaxp.thumbsf.exc.UnknownInstructionException
import kr.pe.ecmaxp.thumbsf.signal.ControlPauseSignal
import kr.pe.ecmaxp.thumbsf.signal.ControlStopSignal


class CPU(val memory: Memory = Memory(), val regs: Registers = Registers()) {
    var totalInsnCount = 0L

    fun copy(): CPU = CPU(memory.copy(), regs.copy())

    fun fork(regs: Registers = Registers()): CPU = CPU(memory.fork(), regs)

    fun call(address: Int, r0: Int = 0, r1: Int = 0, r2: Int = 0, r3: Int = 0, lr: Int? = null) {
        regs[PC] = address
        regs[R0] = r0
        regs[R1] = r1
        regs[R2] = r2
        regs[R3] = r3

        if (lr != null)
            regs[LR] = lr
    }

    @Throws(InvalidMemoryException::class, UnknownInstructionException::class, InvalidAddressArmException::class)
    fun run(insnCount: Int, handler: (imm: Int) -> Unit) {
        val memory = this.memory

        var REGS = regs.fastLoad()
        var lr = regs.lr
        var sp = regs.sp
        var pc = regs.pc
        var v = regs.v
        var c = regs.c
        var z = regs.z
        var n = regs.n

        assert(pc and I0 == 0)
        pc = pc and I0.inv()

        val (buffer, base) = memory.loadExecCache(pc)
        var count = insnCount

        try {
            loop@ while (count-- > 0) {
                val code = buffer[pc - base]

                when (code and 0xFF) {
                    NULL -> {
                        val (newCode, newImm32) = decode(memory, pc)
                        when (newCode and 0xFF) {
                            NULL -> throw UnexceptedLogicError()
                        }

                        buffer[pc - base] = newCode
                        buffer[pc - base + 1] = newImm32
                        continue@loop
                    }
                    NOP -> {
                        pc += 2
                    }
                    ERROR -> throw UnknownInstructionException()

                    // Format 1: move shifted register
                    LSLSI -> { // LSL Rd, Rs, #Offset5
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val imm16 = code shr RIMM
                        val left = REGS[Rs]
                        val right = imm16 // 0 ~ 31
                        val value = left shl right

                        n = value < 0
                        z = value == 0
                        if (right > 0)
                            c = left shl right - 1 and FN != 0

                        REGS[Rd] = value
                        pc += 2
                    }
                    LSRSI -> { // LSR Rd, Rs, #Offset5
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val imm16 = code shr RIMM
                        val left = REGS[Rs]
                        val right = imm16 // 1 ~ 32
                        val value = if (right == 32) {
                            c = left and FN != 0
                            0
                        } else {
                            c = left and (1 shl right - 1) != 0
                            left ushr right
                        }

                        REGS[Rd] = value
                        n = value < 0
                        z = value == 0
                        pc += 2
                    }
                    ASRSI -> { // ASR Rd, Rs, #Offset5
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val imm16 = code shr RIMM
                        val left = REGS[Rs]
                        val right = imm16 // 1 ~ 32
                        val value = if (right == 32) {
                            c = left and FN != 0
                            if (left > 0) 0 else -1
                        } else {
                            c = left and (1 shl right - 1) != 0
                            left shr right
                        }

                        REGS[Rd] = value
                        n = value < 0
                        z = value == 0
                        pc += 2
                    }

                    // Format 2: add/subtract
                    ADD3S -> { // ADD Rd, Rs, Rn
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val Rn = code shr RNUM and RMASK
                        val left = REGS[Rs]
                        val right = REGS[Rn]
                        val Lleft = Integer.toUnsignedLong(left)
                        val Lright = Integer.toUnsignedLong(right)
                        val Lvalue = Lleft + Lright;
                        val value = Lvalue.toInt()
                        n = value < 0
                        z = value == 0
                        c = Lvalue > UINT_MAX
                        v = (left xor value) and (right xor value) < 0
                        REGS[Rd] = value
                        pc += 2
                    }
                    ADD3SI -> { // ADD Rd, Rs, #Offset3
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val imm16 = code shr RIMM
                        val left = REGS[Rs]
                        val right = imm16
                        val Lleft = Integer.toUnsignedLong(left)
                        val Lright = Integer.toUnsignedLong(right)
                        val Lvalue = Lleft + Lright;
                        val value = Lvalue.toInt()
                        n = value < 0
                        z = value == 0
                        c = Lvalue > UINT_MAX
                        v = (left xor value) and (right xor value) < 0
                        REGS[Rd] = value
                        pc += 2
                    }
                    SUB3S -> { // SUB Rd, Rs, Rn
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val Rn = code shr RNUM and RMASK
                        val left = REGS[Rs]
                        val right = REGS[Rn]
                        val Lleft = Integer.toUnsignedLong(left)
                        val LIright = Integer.toUnsignedLong(right.inv())
                        val Lvalue = Lleft + LIright + 1L
                        val value = Lvalue.toInt()
                        n = value < 0
                        z = value == 0
                        c = Lvalue > UINT_MAX
                        v = (left xor right) and (left xor value) < 0
                        REGS[Rd] = value
                        pc += 2
                    }
                    SUB3SI -> { // SUB Rd, Rs, #Offset3
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val imm16 = code shr RIMM
                        val left = REGS[Rs]
                        val right = imm16
                        val Lleft = Integer.toUnsignedLong(left)
                        val LIright = Integer.toUnsignedLong(right.inv())
                        val Lvalue = Lleft + LIright + 1L
                        val value = Lvalue.toInt()
                        n = value < 0
                        z = value == 0
                        c = Lvalue > UINT_MAX
                        v = (left xor right) and (left xor value) < 0
                        REGS[Rd] = value
                        pc += 2
                    }

                    // Format 3: move/compare/add/subtract immediate
                    MOVSI -> { // MOV Rd, #Offset8
                        val Rd = code shr RDEST and RMASK
                        val imm16 = code shr RIMM
                        val value = imm16
                        REGS[Rd] = value
                        n = value < 0
                        z = value == 0
                        pc += 2
                    }
                    CMPI -> { // CMP Rd, #Offset8
                        val Rd = code shr RDEST and RMASK
                        val imm16 = code shr RIMM
                        val left = REGS[Rd]
                        val right = imm16
                        val Lvalue = (Integer.toUnsignedLong(left)) +
                                (Integer.toUnsignedLong(right.inv())) + 1L
                        val value = Lvalue.toInt()

                        n = value < 0
                        z = value == 0
                        c = Lvalue > UINT_MAX
                        v = left xor right and (left xor value) < 0
                        pc += 2
                    }
                    ADDSI -> { // ADD Rd, #Offset8
                        val Rd = code shr RDEST and RMASK
                        val imm16 = code shr RIMM
                        val left = REGS[Rd]
                        val right = imm16
                        val Lvalue = (Integer.toUnsignedLong(left)) + (Integer.toUnsignedLong(right))
                        val value = Lvalue.toInt()
                        REGS[Rd] = value
                        n = value < 0
                        z = value == 0
                        c = Lvalue > UINT_MAX
                        v = left xor value and (right xor value) < 0
                        pc += 2
                    }
                    SUBSI -> { // SUB Rd, #Offset8
                        val Rd = code shr RDEST and RMASK
                        val imm16 = code shr RIMM
                        val left = REGS[Rd]
                        val right = imm16
                        val Lvalue = (Integer.toUnsignedLong(left)) +
                                (Integer.toUnsignedLong(right.inv())) + 1L
                        val value = Lvalue.toInt()
                        REGS[Rd] = value
                        n = value < 0
                        z = value == 0
                        c = Lvalue > UINT_MAX
                        v = left xor right and (left xor value) < 0
                        pc += 2
                    }

                    // Format 4: ALU operations
                    ANDS -> { // AND Rd, Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val left = REGS[Rd]
                        val right = REGS[Rs]
                        val value = left and right

                        REGS[Rd] = value

                        n = value < 0
                        z = value == 0
                        pc += 2
                    }
                    EORS -> { // EOR Rd, Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val left = REGS[Rd]
                        val right = REGS[Rs]
                        val value = left xor right

                        REGS[Rd] = value

                        n = value < 0
                        z = value == 0
                        pc += 2
                    }
                    LSLS -> { // LSL Rd, Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val left = REGS[Rd]
                        val right = REGS[Rs]
                        val value = when {
                            right >= 32 -> {
                                c = right == 32 && left and 1 != 0
                                0
                            }
                            right < 0 -> {
                                c = false
                                0
                            }
                            right == 0 -> left
                            else -> {
                                c = left shl right - 1 and FN != 0
                                left shl right
                            }
                        }

                        REGS[Rd] = value

                        n = value < 0
                        z = value == 0
                        pc += 2
                    }
                    LSRS -> { // LSR Rd, Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val left = REGS[Rd]
                        val right = REGS[Rs]
                        var value: Int

                        when {
                            right >= 32 -> {
                                value = 0
                                c = right == 32 && left and FN != 0
                            }
                            right < 0 -> {
                                value = 0
                                c = false
                            }
                            right == 0 -> value = left
                            else -> {
                                value = left ushr right
                                c = (left ushr (right - 1)) and 1 != 0
                            }
                        }

                        REGS[Rd] = value

                        n = value < 0
                        z = value == 0
                        pc += 2
                    }
                    ASRS -> { // ASR Rd, Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val left = REGS[Rd]
                        val right = REGS[Rs]
                        val value: Int

                        if (right < 0 || right >= 32) {
                            value = if (left > 0) 0 else -1
                            c = value < 0
                        } else if (right == 0) {
                            value = left
                        } else {
                            value = left shr right
                            REGS[Rd] = value
                            c = left and (1 shl right - 1) != 0
                        }

                        REGS[Rd] = value

                        n = value < 0
                        z = value == 0
                        pc += 2
                    }
                    ADCS -> { // ADC Rd, Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val left = REGS[Rd]
                        val right = REGS[Rs]
                        val Lvalue = (Integer.toUnsignedLong(left)) +
                                (Integer.toUnsignedLong(right)) + if (c) 1L else 0L
                        val value = Lvalue.toInt()

                        REGS[Rd] = value

                        n = value < 0
                        z = value == 0
                        c = Lvalue != value.toLong()
                        v = left > 0 && right > 0 && value < 0 || left < 0 && right < 0 && value > 0
                        pc += 2
                    }
                    SBCS -> { // SBC Rd, Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val left = REGS[Rd]
                        val right = REGS[Rs]
                        val Lvalue = left.toLong() - right.toLong() - if (c) 0L else 1L
                        val value = left - right - if (c) 0 else 1

                        REGS[Rd] = value

                        n = value < 0
                        z = value == 0
                        c = c || value < 0
                        v = Lvalue != value.toLong()
                        pc += 2
                    }
                    RORS -> { // ROR Rd, Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val left = REGS[Rd]
                        var right = REGS[Rs]

                        right = right and 31
                        val value = left.ushr(right) or (left shl 32 - right)

                        REGS[Rd] = value

                        n = value < 0
                        z = value == 0
                        c = left.ushr(right - 1) and I0 != 0
                        pc += 2
                    }
                    TSTS -> { // TST Rd, Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val left = REGS[Rd]
                        val right = REGS[Rs]

                        val value = left and right

                        n = value < 0
                        z = value == 0
                        pc += 2
                    }
                    RSBS -> { // NEG Rd, Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val right = REGS[Rs]
                        val Lvalue = (Integer.toUnsignedLong(right.inv())) + 1L
                        val value = Lvalue.toInt()

                        REGS[Rd] = value

                        n = value < 0
                        z = value == 0
                        c = Lvalue > UINT_MAX
                        v = right and value < 0
                        pc += 2
                    }
                    CMP -> { // CMP Rd, Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val left = REGS[Rd]
                        val right = REGS[Rs]
                        val Lvalue = (Integer.toUnsignedLong(left)) +
                                (Integer.toUnsignedLong(right.inv())) + 1L
                        val value = Lvalue.toInt()

                        n = value < 0
                        z = value == 0
                        c = Lvalue > UINT_MAX
                        v = left xor right and (left xor value) < 0
                        pc += 2
                    }
                    CMN -> { // CMN Rd, Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val left = REGS[Rd]
                        val right = REGS[Rs]
                        val Lvalue = (Integer.toUnsignedLong(left)) + (Integer.toUnsignedLong(right))
                        val value = Lvalue.toInt()

                        n = value < 0
                        z = value == 0
                        c = Lvalue > UINT_MAX
                        v = left xor value and (right xor value) < 0
                        pc += 2
                    }
                    ORRS -> { // ORR Rd, Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val left = REGS[Rd]
                        val right = REGS[Rs]
                        val value = left or right

                        REGS[Rd] = value

                        n = value < 0
                        z = value == 0
                        pc += 2
                    }
                    MULS -> { // MUL Rd, Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val left = REGS[Rd]
                        val right = REGS[Rs]
                        val svalue = left.toLong() * right.toLong()
                        val value = left * right

                        REGS[Rd] = value

                        n = value < 0
                        z = value == 0
                        c = c or (value.toLong() != svalue) // ???
                        v = false // svalue != value?
                        pc += 2
                    }
                    BICS -> { // BIC Rd, Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val left = REGS[Rd]
                        val right = REGS[Rs]
                        val value = left and right.inv()

                        REGS[Rd] = value

                        n = value < 0
                        z = value == 0
                        pc += 2
                    }
                    MVNS -> { // MVN Rd, Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val right = REGS[Rs]
                        val value = right.inv()

                        REGS[Rd] = value

                        n = value < 0
                        z = value == 0
                        pc += 2
                    }

                    // Format 5: Hi register operations/branch exchange
                    ADD -> { // ADD Rd, Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val left = REGS[Rd]
                        val right = REGS[Rs]

                        val value = left + right

                        REGS[Rd] = value

                        pc += 2
                    }
                    ADDX -> { // ADD Rd, Rs (SP, LR, PC)
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val left = when (Rd) {
                            SP -> sp
                            LR -> lr
                            PC -> pc
                            else -> REGS[Rd]
                        }

                        val right = when (Rs) {
                            SP -> sp
                            LR -> lr
                            PC -> pc + 4
                            else -> REGS[Rs]
                        }

                        val value = left + right

                        when (Rd) {
                            SP -> {
                                sp = value
                                pc += 2
                            }
                            LR -> {
                                lr = value
                                pc += 2
                            }
                            PC -> {
                                pc = value
                                pc += 2 // ?
                            }
                            else -> {
                                REGS[Rd] = value
                                pc += 2
                            }
                        }
                    }
                    CMPX -> { // CMP Rd, Rs (SP, LR, PC)
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val left = REGS[Rd]
                        val right = REGS[Rs]
                        val Lvalue = (Integer.toUnsignedLong(left)) +
                                (Integer.toUnsignedLong(right.inv())) + 1L
                        val value = Lvalue.toInt()

                        n = value < 0
                        z = value == 0
                        c = Lvalue > UINT_MAX
                        v = left xor right and (left xor value) < 0
                        pc += 2
                    }
                    MOV -> { // MOV Rd, Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        REGS[Rd] = REGS[Rs]
                        pc += 2
                    }
                    MOVX -> { // MOV Rd, Rs (SP, LR, PC)
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val value = when (Rs) {
                            SP -> sp
                            LR -> lr
                            PC -> pc
                            else -> REGS[Rs]
                        }

                        when (Rd) {
                            SP -> {
                                sp = value
                                pc += 2
                            }
                            LR -> {
                                lr = value
                                pc += 2
                            }
                            PC -> pc = value
                            else -> {
                                REGS[Rd] = value
                                pc += 2
                            }
                        }
                    }
                    BX -> { // BX Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val value = when (Rs) {
                            SP -> sp
                            LR -> lr
                            PC -> pc
                            else -> REGS[Rs]
                        }

                        if (value and I0 != 1)
                            throw UnknownInstructionException()
                        if (Rd != 0)
                            throw UnknownInstructionException()

                        pc = value and I0.inv()
                    }
                    BLX -> { // BLX Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val value = when (Rs) {
                            SP -> sp
                            LR -> lr
                            PC -> pc
                            else -> REGS[Rs]
                        }

                        if (value and I0 != 1)
                            throw UnknownInstructionException()
                        if (Rd != 0)
                            throw UnknownInstructionException()

                        lr = pc + 2 or I0
                        pc = value and I0.inv()
                    }

                    // Format 6: PC-relative load
                    MOVI -> { // LDR Rd, [PC, #Imm]
                        val Rd = code shr RDEST and RMASK
                        val imm32 = buffer[pc - base + 1]
                        REGS[Rd] = imm32
                        pc += 2
                    }

                    // Format 7: load/store with register offset
                    STR -> { // STR Rd, [Rb, Ro]
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val Rn = code shr RNUM and RMASK
                        val addr = REGS[Rs] + REGS[Rn]
                        val value = REGS[Rd]
                        memory.writeInt(addr, value)
                        pc += 2
                    }
                    STRB -> { // STRB Rd, [Rb, Ro]
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val Rn = code shr RNUM and RMASK
                        val addr = REGS[Rs] + REGS[Rn]
                        val value = REGS[Rd]
                        memory.writeByte(addr, value.toByte())
                        pc += 2
                    }
                    LDR -> { // LDR Rd, [Rb, Ro]
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val Rn = code shr RNUM and RMASK
                        val addr = REGS[Rs] + REGS[Rn]
                        REGS[Rd] = memory.readInt(addr)
                        pc += 2
                    }
                    LDRB -> { // LDRB Rd, [Rb, Ro]
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val Rn = code shr RNUM and RMASK
                        val addr = REGS[Rs] + REGS[Rn]
                        REGS[Rd] = memory.readByte(addr).toInt() and 0xFF
                        pc += 2
                    }
                    // Format 8
                    STRH -> { // STRH Rd, [Rb, Ro]
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val Rn = code shr RNUM and RMASK
                        val addr = REGS[Rs] + REGS[Rn]
                        memory.writeShort(addr, REGS[Rd].toShort())
                        pc += 2
                    }
                    LDRH -> { // LDRH Rd, [Rb, Ro]
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val Rn = code shr RNUM and RMASK
                        val addr = REGS[Rs] + REGS[Rn]
                        REGS[Rd] = memory.readShort(addr).toInt() and 0xFFFF
                        pc += 2
                    }
                    LDSB -> { // LDSB Rd, [Rb, Ro]
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val Rn = code shr RNUM and RMASK
                        val addr = REGS[Rs] + REGS[Rn]
                        REGS[Rd] = memory.readByte(addr).toInt()
                        pc += 2
                    }
                    LDSH -> { // LDSH Rd, [Rb, Ro]
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val Rn = code shr RNUM and RMASK
                        val addr = REGS[Rs] + REGS[Rn]
                        REGS[Rd] = memory.readShort(addr).toInt()
                        pc += 2
                    }

                    // Format 9: load/store with immediate offset
                    STRI -> { // STR Rd, [Rb, #Imm]
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val imm16 = code shr RIMM
                        val addr = REGS[Rs] + imm16
                        val value = REGS[Rd]
                        memory.writeInt(addr, value)
                        pc += 2
                    }
                    STRBI -> { // STRB Rd, [Rb, #Imm]
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val imm16 = code shr RIMM
                        val addr = REGS[Rs] + imm16
                        val value = REGS[Rd]
                        memory.writeByte(addr, value.toByte())
                        pc += 2
                    }
                    LDRI -> { // LDR Rd, [Rb, #Imm]
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val imm16 = code shr RIMM
                        val addr = REGS[Rs] + imm16
                        REGS[Rd] = memory.readInt(addr)
                        pc += 2
                    }
                    LDRBI -> { // LDRB Rd, [Rb, #Imm]
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val imm16 = code shr RIMM
                        val addr = REGS[Rs] + imm16
                        REGS[Rd] = memory.readByte(addr).toInt() and 0xFF
                        pc += 2
                    }

                    // Format 10: load/store halfword
                    STRHI -> { // STRH Rd, [Rb, #Imm]
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val imm16 = code shr RIMM
                        val addr = REGS[Rs] + imm16
                        memory.writeShort(addr, REGS[Rd].toShort())
                        pc += 2
                    }
                    LDRHI -> { // LDRH Rd, [Rb, #Imm]
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val imm16 = code shr RIMM
                        val addr = REGS[Rs] + imm16
                        REGS[Rd] = memory.readShort(addr).toInt() and 0xFFFF
                        pc += 2
                    }

                    // Format 11: SP-relative load/store
                    STRSPI -> { // STR Rd, [SP, #Imm]
                        val Rd = code shr RDEST and RMASK
                        val imm16 = code shr RIMM
                        val addr = sp + imm16
                        val value = REGS[Rd]
                        memory.writeInt(addr, value)
                        pc += 2
                    }
                    LDRSPI -> { // LDR Rd, [SP, #Imm]
                        val Rd = code shr RDEST and RMASK
                        val imm16 = code shr RIMM
                        val addr = sp + imm16
                        REGS[Rd] = memory.readInt(addr)
                        pc += 2
                    }

                    // Format 12: load address
                    ADDXI -> { // ADD Rd, SP, #Imm | ADD Rd, PC, #Imm
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val imm16 = code shr RIMM
                        val value = when (Rs) {
                            SP -> sp
                            PC -> pc + 4 and I1.inv()
                            else -> throw UnknownInstructionException()
                        }

                        REGS[Rd] = value + imm16
                        pc += 2
                    }

                    // Format 13: add offset to Stack Pointer
                    ADDSPI -> { // ADD SP, #Imm | ADD SP, #-Imm
                        val imm16 = code shr RIMM
                        sp += imm16
                        pc += 2
                    }

                    // Format 14: push/pop registers
                    PUSH -> { // PUSH { Rlist }
                        val imm16 = code shr RIMM
                        for (i in 7 downTo 0) {
                            if (imm16 and (1 shl i) != 0) {
                                sp -= 4
                                memory.writeInt(sp, REGS[i])
                            }
                        }

                        pc += 2
                    }
                    PUSHR -> { // PUSH { Rlist, LR }
                        val imm16 = code shr RIMM
                        sp -= 4
                        memory.writeInt(sp, lr)

                        for (i in 7 downTo 0) {
                            if (imm16 and (1 shl i) != 0) {
                                sp -= 4
                                memory.writeInt(sp, REGS[i])
                            }
                        }

                        pc += 2
                    }
                    POP -> { // POP { Rlist }
                        val imm16 = code shr RIMM
                        for (i in 0..7) {
                            if (imm16 and (1 shl i) != 0) {
                                REGS[i] = memory.readInt(sp)
                                sp += 4
                            }
                        }

                        pc += 2
                    }
                    POPR -> { // POP { Rlist, PC }
                        val imm16 = code shr RIMM
                        for (i in 0..7) {
                            if (imm16 and (1 shl i) != 0) {
                                REGS[i] = memory.readInt(sp)
                                sp += 4
                            }
                        }

                        val value = memory.readInt(sp)
                        if (value and I0 != 1)
                            throw InvalidAddressArmException()

                        pc = value and I0.inv()
                        sp += 4
                    }

                    // Format 15: multiple load/store
                    STMIA -> { // STMIA Rb!, { Rlist }
                        val Rd = code shr RDEST and RMASK
                        val imm16 = code shr RIMM
                        var addr = REGS[Rd]
                        for (i in 0..7)
                            if (imm16 and (1 shl i) != 0) {
                                memory.writeInt(addr, REGS[i])
                                addr += 4
                            }

                        REGS[Rd] = addr
                        pc += 2
                    }
                    LDMIA -> { // LDMIA Rb!, { Rlist }
                        val Rd = code shr RDEST and RMASK
                        val imm16 = code shr RIMM
                        var addr = REGS[Rd]
                        for (i in 0..7)
                            if (imm16 and (1 shl i) != 0) {
                                REGS[i] = memory.readInt(addr)
                                addr += 4
                            }

                        REGS[Rd] = addr
                        pc += 2
                    }

                    // Format 16: conditional branch
                    BEQ -> pc += if (z) code shr RIMM else 2 // BEQ label
                    BNE -> pc += if (!z) code shr RIMM else 2 // BNE label
                    BCS -> pc += if (c) code shr RIMM else 2 // BCS label
                    BCC -> pc += if (!c) code shr RIMM else 2 // BCC label
                    BMI -> pc += if (n) code shr RIMM else 2 // BMI label
                    BPL -> pc += if (!n) code shr RIMM else 2 // BPL label
                    BVS -> pc += if (v) code shr RIMM else 2 // BVS label
                    BVC -> pc += if (!v) code shr RIMM else 2 // BVC label
                    BHI -> pc += if (c && !z) code shr RIMM else 2 // BHI label
                    BLS -> pc += if (!c || z) code shr RIMM else 2 // BLS label
                    BGE -> pc += if (n == v) code shr RIMM else 2 // BGE label
                    BLT -> pc += if (n != v) code shr RIMM else 2 // BLT label
                    BGT -> pc += if (!z && n == v) code shr RIMM else 2 // BGT label
                    BLE -> pc += if (z || n != v) code shr RIMM else 2 // BLE label

                    // Format 17: software interrupt
                    SVC -> { // SWI Value8
                        val imm16 = code shr RIMM
                        // println("SVC $imm16:${REGS[7]} r0=${REGS[0]} r1=${REGS[1]} r2=${REGS[2]} r3=${REGS[3]}")
                        regs.setCPSR(v, c, z, n)
                        regs.fastStore(REGS, sp, lr, pc)
                        totalInsnCount += insnCount - count

                        try {
                            handler(imm16)
                        } catch (e: ControlPauseSignal) {
                            throw e
                        } catch (e: ControlStopSignal) {
                            regs[PC] += 2
                            throw e
                        } finally {
                            totalInsnCount -= insnCount - count // restore counter for assign later
                            sp = regs.sp
                            lr = regs.lr
                            pc = regs.pc
                            REGS = regs.fastLoad()
                            v = regs.v
                            c = regs.c
                            z = regs.z
                            n = regs.n
                        }

                        pc += 2
                    }

                    // Format 18: unconditional branch
                    B -> { // B label
                        val imm16 = code shr RIMM
                        pc += imm16
                    }

                    // Format 19: long branch with link
                    BL -> { // BL label
                        val imm32 = buffer[pc - base + 1]
                        lr = pc + 3 + 2
                        pc += imm32 + 2
                    }

                    // Format X
                    SXTH -> { // SXTH Rd, Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        REGS[Rd] = REGS[Rs].toShort().toInt()
                        pc += 2
                    }
                    SXTB -> { // SXTB Rd, Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        REGS[Rd] = REGS[Rs].toByte().toInt()
                        pc += 2
                    }
                    UXTH -> { // UXTH Rd, Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        REGS[Rd] = REGS[Rs] and 0xFFFF
                        pc += 2
                    }
                    UXTB -> { // UXTB Rd, Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        REGS[Rd] = REGS[Rs] and 0xFF
                        pc += 2
                    }
                    REV -> { // REV Rd, Rs
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val value = REGS[Rs]
                        REGS[Rd] = value.ushr(24) and 0xFF or (
                                value.ushr(16) and 0xFF shl 8) or (
                                value.ushr(8) and 0xFF shl 16) or
                                (value and 0xFF shl 24)
                        pc += 2
                    }

                    else -> UnexceptedLogicError()
                }
            }
        } finally {
            regs.setCPSR(v, c, z, n)
            regs.fastStore(REGS, sp, lr, pc)
            totalInsnCount += insnCount - count
        }
    }
}