
package kr.pe.ecmaxp.thumbsj

import kr.pe.ecmaxp.thumbsj.exc.InvalidAddressArmException
import kr.pe.ecmaxp.thumbsj.exc.InvalidMemoryException
import kr.pe.ecmaxp.thumbsj.exc.UnexceptedLogicError
import kr.pe.ecmaxp.thumbsj.exc.UnsupportedInstructionException
import kr.pe.ecmaxp.thumbsj.helper.BitConsts.FC
import kr.pe.ecmaxp.thumbsj.helper.BitConsts.FN
import kr.pe.ecmaxp.thumbsj.helper.BitConsts.FQ
import kr.pe.ecmaxp.thumbsj.helper.BitConsts.FV
import kr.pe.ecmaxp.thumbsj.helper.BitConsts.FZ
import kr.pe.ecmaxp.thumbsj.helper.BitConsts.I0
import kr.pe.ecmaxp.thumbsj.helper.BitConsts.I1
import kr.pe.ecmaxp.thumbsj.helper.BitConsts.I10
import kr.pe.ecmaxp.thumbsj.helper.BitConsts.I11
import kr.pe.ecmaxp.thumbsj.helper.BitConsts.I12
import kr.pe.ecmaxp.thumbsj.helper.BitConsts.I7
import kr.pe.ecmaxp.thumbsj.helper.BitConsts.I8
import kr.pe.ecmaxp.thumbsj.helper.BitConsts.I9
import kr.pe.ecmaxp.thumbsj.helper.BitConsts.L1
import kr.pe.ecmaxp.thumbsj.helper.BitConsts.L10
import kr.pe.ecmaxp.thumbsj.helper.BitConsts.L11
import kr.pe.ecmaxp.thumbsj.helper.BitConsts.L2
import kr.pe.ecmaxp.thumbsj.helper.BitConsts.L3
import kr.pe.ecmaxp.thumbsj.helper.BitConsts.L4
import kr.pe.ecmaxp.thumbsj.helper.BitConsts.L5
import kr.pe.ecmaxp.thumbsj.helper.BitConsts.L7
import kr.pe.ecmaxp.thumbsj.helper.BitConsts.L8
import kr.pe.ecmaxp.thumbsj.helper.RegisterIndex.CPSR
import kr.pe.ecmaxp.thumbsj.helper.RegisterIndex.LR
import kr.pe.ecmaxp.thumbsj.helper.RegisterIndex.PC
import kr.pe.ecmaxp.thumbsj.helper.RegisterIndex.SP
import kr.pe.ecmaxp.thumbsj.signal.ControlPauseSignal
import kr.pe.ecmaxp.thumbsj.signal.ControlStopSignal

@Suppress("LocalVariableName", "RedundantGetter", "RedundantSetter")
class CPU {
    var regs = Registers()
        get() = field
        set(value) {
            field = value
        }

    var memory = Memory()
        get() = field
        set(value) {
            field = value
        }

    var interruptHandler: InterruptHandler? = null
        get() = field
        set(value) {
            field = value
        }

    private var executedCount = 0

    @Throws(InvalidMemoryException::class, UnknownInstructionException::class, InvalidAddressArmException::class, ControlPauseSignal::class, ControlStopSignal::class)
    fun run(inst_count: Int) {
        var count = inst_count
        val memory = this.memory
        var REGS = regs.load()

        var q = REGS[CPSR] and FQ != 0
        var v = REGS[CPSR] and FV != 0
        var c = REGS[CPSR] and FC != 0
        var z = REGS[CPSR] and FZ != 0
        var n = REGS[CPSR] and FN != 0

        assert(REGS[PC] and I0 == 0)
        REGS[PC] = REGS[PC] and I0.inv()

        val totalCount = count

        try {
            while (count-- > 0) {
                var increase_pc = true
                val code = memory.fetchCode(REGS[PC])

                when (code shr 12 and L4) {
                    0, 1 -> { // :000x
                        var Rs = code shr 3 and L3
                        var Rd = code and L3
                        var left = REGS[Rs]
                        var value: Int

                        when (code shr 11 and L2) {
                            // Format 1: move shifted register
                            0 -> { // :00000
                                // LSL Rd, Rs, #Offset5
                                val right = code shr 6 and L5 // right = 0 ~ 31
                                value = left shl right

                                if (right > 0)
                                    c = left shl right - 1 and FN != 0
                            }
                            1 -> { // :00001
                                //  LSR Rd, Rs, #Offset5
                                val right = code shr 6 and L5 // right = 1 ~ 32
                                if (right == 0) {
                                    value = 0
                                    c = left and FN != 0
                                } else {
                                    value = left.ushr(right)
                                    c = left and (1 shl right - 1) != 0
                                }
                            }
                            2 -> { // :00010
                                // ASR Rd, Rs, #Offset5
                                val right = code shr 6 and L5 // right = 1 ~ 32
                                if (right == 0) {
                                    value = if (left > 0) 0 else -1
                                    c = left and FN != 0
                                } else {
                                    value = left shr right
                                    c = left and (1 shl right - 1) != 0
                                }
                            }
                            3 -> { // :00011
                                // Format 2: add/subtract
                                val I = code shr 10 and 1 != 0
                                val Rn = code shr 6 and L3
                                Rs = code shr 3 and L3
                                Rd = code and L3
                                left = REGS[Rs]
                                val right = if (I) Rn else REGS[Rn]

                                when (code shr 9 and L1) {
                                    0 -> { // :0001100 | :0001110
                                        // ADD Rd, Rs, Rn
                                        // ADD Rd, Rs, #Offset3
                                        val lvalue = (left.toLong() and 0xffffffffL) + (right.toLong() and 0xffffffffL)
                                        value = lvalue.toInt()
                                        c = lvalue > 0xFFFFFFFFL
                                        v = left xor value and (right xor value) < 0
                                    }
                                    1 -> { // :0001101 | :0001111
                                        // SUB Rd, Rs, Rn
                                        // SUB Rd, Rs, #Offset3
                                        val lvalue = (left.toLong() and 0xffffffffL) +
                                                (right.inv().toLong() and 0xffffffffL) + 1L
                                        value = lvalue.toInt()
                                        c = lvalue > 0xFFFFFFFFL
                                        v = left xor right and (left xor value) < 0
                                    }
                                    else -> throw UnexceptedLogicError()
                                }
                            }
                            else -> throw UnexceptedLogicError()
                        }

                        n = value < 0
                        z = value == 0
                        REGS[Rd] = value
                    }
                    2, 3 -> { // :001
                        // Format 3: move/compare/add/subtract immediate
                        val Rd = code shr 8 and L3
                        val left = REGS[Rd]
                        val right = code and L8
                        var value: Int
                        var lvalue: Long

                        when (code shr 11 and L2) {
                            0 -> { // :001100
                                // MOV Rd, #Offset8
                                value = right
                                REGS[Rd] = value
                            }
                            1 -> { // :001101
                                // CMP Rd, #Offset8
                                lvalue = (left.toLong() and 0xffffffffL) +
                                        (right.inv().toLong() and 0xffffffffL) + 1L
                                value = lvalue.toInt()
                                // only compare (no write)
                                c = lvalue > 0xFFFFFFFFL
                                v = left xor right and (left xor value) < 0
                            }
                            2 -> { // :001110
                                // ADD Rd, #Offset8
                                lvalue = (left.toLong() and 0xffffffffL) + (right.toLong() and 0xffffffffL)
                                value = lvalue.toInt()
                                REGS[Rd] = value
                                c = lvalue > 0xFFFFFFFFL
                                v = left xor value and (right xor value) < 0
                            }
                            3 -> { // :001111
                                // SUB Rd, #Offset8
                                lvalue = (left.toLong() and 0xffffffffL) +
                                        (right.inv().toLong() and 0xffffffffL) + 1L
                                value = lvalue.toInt()
                                REGS[Rd] = value
                                c = lvalue > 0xFFFFFFFFL
                                v = left xor right and (left xor value) < 0
                            }
                            else -> throw UnexceptedLogicError()
                        }

                        n = value < 0
                        z = value == 0
                    }
                    4 -> // :0100
                        when (code shr 10 and L2) {
                            0 -> { // :010000
                                // Format 4: ALU operations
                                val Rs = code shr 3 and L3
                                val Rd = code and L3
                                val left = REGS[Rd]
                                var right = REGS[Rs]
                                val value: Int
                                val lvalue: Long

                                when (code shr 6 and L4) {
                                    0 -> { // :0100000000
                                        // AND Rd, Rs
                                        // Rd:= Rd AND Rs
                                        value = left and right
                                        REGS[Rd] = value
                                    }
                                    1 -> { // :0100000001
                                        // EOR Rd, Rs
                                        // Rd:= Rd EOR Rs
                                        value = left xor right
                                        REGS[Rd] = value
                                    }
                                    2 -> { // :0100000010
                                        // LSL Rd, Rs
                                        // Rd := Rd << Rs

                                        when {
                                            right >= 32 -> {
                                                value = 0
                                                c = right == 32 && left and 1 != 0
                                            }
                                            right < 0 -> {
                                                value = 0
                                                c = false
                                            }
                                            right == 0 -> value = left
                                            else -> {
                                                value = left shl right
                                                c = left shl right - 1 and FN != 0
                                            }
                                        }

                                        REGS[Rd] = value
                                    }
                                    3 -> {
                                        // :0100000011
                                        // LSR Rd, Rs
                                        // Rd := Rd >>> Rs
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
                                                value = left.ushr(right)
                                                REGS[Rd] = value
                                                c = left.ushr(right - 1) and 1 != 0
                                            }
                                        }
                                    }
                                    4 -> // :0100000100
                                        // ASR Rd, Rs
                                        // Rd := Rd ASR Rs

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
                                    5 -> { // :0100000101
                                        // ADC Rd, Rs
                                        // Rd := Rd + Rs + C-bit
                                        lvalue = (left.toLong() and 0xffffffffL) +
                                                (right.toLong() and 0xffffffffL) + if (c) 1L else 0L
                                        value = lvalue.toInt()
                                        REGS[Rd] = value

                                        c = lvalue != value.toLong()
                                        v = left > 0 && right > 0 && value < 0 || left < 0 && right < 0 && value > 0
                                    }
                                    6 -> { // :0100000110
                                        // SBC Rd, Rs
                                        // Rd := Rd - Rs - NOT C-bit
                                        lvalue = left.toLong() - right.toLong() - if (c) 0L else 1L
                                        value = left - right - if (c) 0 else 1
                                        REGS[Rd] = value

                                        c = c || value < 0
                                        v = lvalue != value.toLong()
                                    }
                                    7 -> { // :0100000111
                                        // ROR Rd, Rs
                                        // Rd := Rd ROR Rs
                                        right = right and 31
                                        value = left.ushr(right) or (left shl 32 - right)
                                        c = left.ushr(right - 1) and I0 != 0
                                        REGS[Rd] = value
                                    }
                                    8 -> // :0100001000
                                        // TST Rd, Rs
                                        // set condition codes on Rd AND Rs
                                        value = left and right
                                    9 -> { // :0100001001
                                        // NEG Rd, Rs
                                        // Rd = -Rs
                                        lvalue = (right.inv().toLong() and 0xffffffffL) + 1L
                                        value = lvalue.toInt()
                                        REGS[Rd] = value
                                        c = lvalue > 0xFFFFFFFFL
                                        v = right and value < 0
                                    }
                                    10 -> { // :0100001010
                                        // CMP Rd, Rs
                                        // set condition codes on Rd - Rs
                                        lvalue = (left.toLong() and 0xffffffffL) +
                                                (right.inv().toLong() and 0xffffffffL) + 1L
                                        value = lvalue.toInt()
                                        // only compare (no write)
                                        c = lvalue > 0xFFFFFFFFL
                                        v = left xor right and (left xor value) < 0
                                    }
                                    11 -> { // :0100001011
                                        // CMN Rd, Rs
                                        // set condition codes on Rd + Rs
                                        lvalue = (left.toLong() and 0xffffffffL) + (right.toLong() and 0xffffffffL)
                                        value = lvalue.toInt()
                                        // only compare (no write)
                                        c = lvalue > 0xFFFFFFFFL
                                        v = left xor value and (right xor value) < 0
                                    }
                                    12 -> { // :0100001100
                                        // ORR Rd, Rs
                                        // Rd := Rd OR Rs
                                        value = left or right
                                        REGS[Rd] = value
                                    }
                                    13 -> { // :0100001101
                                        // MUL Rd, Rs
                                        // Rd := Rs * Rd
                                        val svalue = left.toLong() * right.toLong()
                                        value = left * right
                                        REGS[Rd] = value
                                        c = c or (value.toLong() != svalue) // ???
                                        v = false // svalue != value?
                                    }
                                    14 -> { // :0100001110
                                        // BIC Rd, Rs
                                        // Rd := Rd AND NOT Rs
                                        value = left and right.inv()
                                        REGS[Rd] = value
                                    }
                                    15 -> { // :0100001111
                                        // MVN Rd, Rs
                                        // Rd := NOT Rs
                                        value = right.inv()
                                        REGS[Rd] = value
                                    }
                                    else -> throw UnexceptedLogicError()
                                }// only compare (no write)

                                n = value < 0
                                z = value == 0
                            }
                            1 -> { // :010001
                                // Format 5: Hi register operations/branch exchange
                                val H1 = code shr 7 and L1 != 0
                                val H2 = code shr 6 and L1 != 0
                                val Rd = (code and L3) + if (H1) 8 else 0
                                val Rs = (code shr 3 and L3) + if (H2) 8 else 0

                                when (code shr 8 and L2) {
                                    0 -> { // :01000100
                                        // ADD Rd, Hs
                                        // ADD Hd, Rs
                                        // ADD Hd, Hs
                                        val left = REGS[Rd]
                                        var right = REGS[Rs]
                                        if (Rs == PC)
                                            right += 4

                                        REGS[Rd] = left + right
                                    }
                                    1 -> { // :01000101
                                        // CMP Rd, Hs
                                        // CMP Hd, Rs
                                        // CMP Hd, Hs
                                        val left = REGS[Rd]
                                        val right = REGS[Rs]
                                        val lvalue = (left.toLong() and 0xffffffffL) +
                                                (right.inv().toLong() and 0xffffffffL) + 1L
                                        val value = lvalue.toInt()
                                        // only compare (no write)
                                        n = value < 0
                                        z = value == 0
                                        c = lvalue > 0xFFFFFFFFL
                                        v = left xor right and (left xor value) < 0
                                    }
                                    2 -> { // :01000110
                                        // MOV Rd, Hs
                                        // MOV Hd, Rs
                                        // MOV Hd, Hs
                                        var value = REGS[Rs]
                                        if (Rd == PC)
                                            value -= 2

                                        REGS[Rd] = value
                                    }
                                    3 -> { // :01000111
                                        // BX Rs
                                        // BX Hs
                                        val value = REGS[Rs]
                                        if (value and I0 != 1)
                                            throw UnknownInstructionException()

                                        if (H1)
                                            REGS[LR] = REGS[PC] + 2 or I0

                                        REGS[PC] = value and I0.inv()
                                        increase_pc = false
                                    }
                                    else -> throw UnexceptedLogicError()
                                }// no write condition code flags
                            }
                            2, 3 -> { // :01001
                                // Format 6: PC-relative load
                                // LDR Rd, [PC, #Imm]
                                val Rd = code shr 8 and L3
                                var addr = code and L8 shl 2
                                addr += REGS[PC] + 4 and I1.inv()

                                REGS[Rd] = memory.readInt(addr)
                            }
                        }
                    5 -> { // :0101
                        if (code and I9 == 0)
                        // :0101xx0
                        {
                            // Format 7: load/store with register offset
                            val L = code and I11 != 0
                            val B = code and I10 != 0
                            val Ro = code shr 6 and L3
                            val Rb = code shr 3 and L3
                            val Rd = code and L3
                            val addr = REGS[Rb] + REGS[Ro]

                            if (L) {
                                if (B) {// :0101100
                                    // LDRB Rd, [Rb, Ro]
                                    REGS[Rd] = memory.readByte(addr).toInt() and 0xFF
                                } else {// :0101100
                                    // LDR Rd, [Rb, Ro]
                                    REGS[Rd] = memory.readInt(addr)
                                }
                            } else {
                                if (B) { // :0101010
                                    // STRB Rd, [Rb, Ro]
                                    memory.writeByte(addr, REGS[Rd].toByte())
                                } else { // :0101000
                                    // STR Rd, [Rb, Ro]
                                    memory.writeInt(addr, REGS[Rd])
                                }
                            }
                        } else { // :0101xx1
                            // Format 8: load/store sign-extended byte/halfword
                            val H = code and I11 != 0
                            val S = code and I10 != 0
                            val Ro = code shr 6 and L3
                            val Rb = code shr 3 and L3
                            val Rd = code and L3
                            val addr = REGS[Rb] + REGS[Ro]

                            if (S) {
                                val value = if (H) {// :0101111
                                    // LDSH Rd, [Rb, Ro]
                                    memory.readShort(addr).toInt()
                                } else { // :0101011
                                    // LDSB Rd, [Rb, Ro]
                                    memory.readByte(addr).toInt()
                                }

                                REGS[Rd] = value
                            } else {
                                if (H) { // :0101101
                                    // LDRH Rd, [Rb, Ro]
                                    val value = memory.readShort(addr).toInt()
                                    REGS[Rd] = value
                                } else { // :0101001
                                    // STRH Rd, [Rb, Ro]
                                    val value = REGS[Rd]
                                    memory.writeShort(addr, value.toShort())
                                }
                            }
                        }
                    }
                    6, 7 -> { // :011
                        // Format 9: load/store with immediate offset
                        val B = code and I12 != 0
                        val L = code and I11 != 0
                        val Rb = code shr 3 and L3
                        val Rd = code and L3
                        var offset = code shr 6 and L5

                        if (!B)
                            offset = offset shl 2

                        val addr = REGS[Rb] + offset

                        if (L) {
                            val value = if (!B)
                            // :01111
                            // LDR Rd, [Rb, #Imm]
                                memory.readInt(addr)
                            else
                            // :01101
                            // LDRB Rd, [Rb, #Imm]
                                memory.readByte(addr).toInt() and 0xFF

                            REGS[Rd] = value
                        } else {
                            val value = REGS[Rd]

                            if (!B)
                            // :01100
                            // STR Rd, [Rb, #Imm]
                                memory.writeInt(addr, value)
                            else
                            // :01110
                            // STRB Rd, [Rb, #Imm]
                                memory.writeByte(addr, value.toByte())
                        }
                    }
                    8 -> { // :1000x
                        // Format 10: load/store halfword
                        val L = code and I11 != 0
                        val Rb = code shr 3 and L3
                        val Rd = code and L3
                        val value = code shr 6 and L5 shl 1
                        val addr = REGS[Rb] + value

                        if (L)
                        // :10001
                        // LDRH Rd, [Rb, #Imm]
                            REGS[Rd] = memory.readShort(addr).toInt() and 0xFFFF
                        else
                        // :10000
                        // STRH Rd, [Rb, #Imm]
                            memory.writeShort(addr, REGS[Rd].toShort())
                    }
                    9 -> { // :1001x
                        // Format 11: SP-relative load/store
                        val L = code and I11 != 0
                        val Rd = code shr 8 and L3
                        val value = code and L8 shl 2
                        val addr = REGS[SP] + value

                        if (L)
                        // :10011
                        // LDR Rd, [SP, #Imm]
                            REGS[Rd] = memory.readInt(addr)
                        else
                        // :10010
                        // STR Rd, [SP, #Imm]
                            memory.writeInt(addr, REGS[Rd])
                    }
                    10 -> { // :1010x
                        // Format 12: load address
                        val fSP = code and I11 != 0
                        val Rd = code shr 8 and L3
                        var value = code and L8 shl 2

                        value += if (fSP)
                        // :10101
                        // ADD Rd, SP, #Imm
                            REGS[SP]
                        else
                        // :10100
                        // ADD Rd, PC, #Imm
                            REGS[PC] + 4 and I1.inv()

                        REGS[Rd] = value
                    }
                    11 -> { // :1011
                        when (code shr 8 and L4) {
                            0 -> { // :10110000x
                                // Format 13: add offset to Stack Pointer

                                val S = code and I7 != 0
                                val value = code and L7 shl 2

                                if (S)
                                // :101100000
                                // ADD SP, #-Imm
                                    REGS[SP] -= value
                                else
                                // :101100001
                                // ADD SP, #Imm
                                    REGS[SP] += value
                            }
                            1 -> // :10110001
                                // CBZ Rd, #Imm
                                throw UnsupportedInstructionException()
                            2 -> { // :10110010
                                // SXTH, SXTB, UXTH, UXTB
                                val Rs = code shr 3 and L3
                                val Rd = code and L3
                                val left = REGS[Rs]

                                val value = when (code shr 6 and L2) {
                                    0 -> // :1011001000
                                        // SXTH Rd, Rs
                                        left.toShort().toInt()
                                    1 -> // :1011001001
                                        // SXTB Rd, Rs
                                        left.toByte().toInt()
                                    2 -> // :1011001010
                                        // UXTH Rd, Rs
                                        left and 0xFFFF
                                    3 -> // :1011001011
                                        // UXTB Rd, Rs
                                        left and 0XFF
                                    else -> throw UnexceptedLogicError()
                                }

                                REGS[Rd] = value
                            }
                            3 -> // :10110011
                                // CBZ Rd, #Imm
                                throw UnsupportedInstructionException()
                            4, 5 -> { // :1011010x
                                // Format 14: push/pop registers
                                val R = code and I8 != 0
                                val list = code and L8
                                var addr = REGS[SP]

                                try {
                                    if (R)
                                    // :10110101
                                    {
                                        // PUSH { ..., LR }
                                        addr -= 4
                                        memory.writeInt(addr, REGS[LR])
                                    }

                                    // PUSH { Rlist }
                                    for (i in 7 downTo 0) {
                                        if (list and (1 shl i) != 0) {
                                            addr -= 4
                                            memory.writeInt(addr, REGS[i])
                                        }
                                    }
                                } finally {
                                    REGS[SP] = addr
                                }
                            }
                            6, 7, 8 -> // :10110110 :10110111 :10111000
                                throw UnknownInstructionException()
                            9 -> // :10111001
                                // CBNZ Rd, #Imm
                                throw UnsupportedInstructionException()
                            10 -> { // :10111010xx
                                val Rs = code shr 3 and L3
                                val Rd = code and L3
                                var value = REGS[Rs]

                                when (code shr 6 and L2) {
                                    0 -> // :1011101000
                                        // REV Rd, Rs
                                        value = value.ushr(24) and 0xFF or (
                                                value.ushr(16) and 0xFF shl 8) or (
                                                value.ushr(8) and 0xFF shl 16) or
                                                (value and 0xFF shl 24)
                                    1 -> // :1011101001
                                        // REV16 Rd, Rs
                                        throw UnsupportedInstructionException()
                                    2 -> // :1011101010
                                        // INVALID
                                        throw UnknownInstructionException()
                                    3 -> // :1011101011
                                        // REVSH Rd, Rs
                                        throw UnsupportedInstructionException()
                                    else -> throw UnexceptedLogicError()
                                }

                                REGS[Rd] = value
                            }
                            11 -> // :10111011
                                // CBNZ Rd, #Imm
                                throw UnsupportedInstructionException()
                            12, 13 -> { // :1011110x
                                // Format 14: push/pop registers
                                val R = code and I8 != 0
                                val list = code and L8
                                var addr = REGS[SP]

                                try {
                                    // POP { Rlist }
                                    for (i in 0..7) {
                                        if (list and (1 shl i) != 0) {
                                            REGS[i] = memory.readInt(addr)
                                            addr += 4
                                        }
                                    }

                                    if (R)
                                    // :10111101 {..., PC}
                                    {
                                        // POP { ..., PC }
                                        val value = memory.readInt(addr)
                                        if (value and I0 != 1)
                                            throw InvalidAddressArmException()

                                        REGS[PC] = value and I0.inv()
                                        addr += 4
                                        increase_pc = false
                                    }
                                } finally {
                                    REGS[SP] = addr
                                }
                            }
                            14, 15 -> // :10111110 :10111111
                                throw UnknownInstructionException()
                            else -> throw UnexceptedLogicError()
                        }// condition codes are not set
                    }
                    12 -> { // :1100
                        // Format 15: multiple load/store
                        val L = code and I11 != 0
                        val list = code and L8
                        val Rb = code shr 8 and L3
                        var addr = REGS[Rb]

                        try {
                            if (!L) { // :11001
                                // STMIA Rb!, { Rlist }
                                for (i in 0..7)
                                    if (list and (1 shl i) != 0) {
                                        memory.writeInt(addr, REGS[i])
                                        addr += 4
                                    }
                            } else { // :11000
                                // LDMIA Rb!, { Rlist }
                                for (i in 0..7)
                                    if (list and (1 shl i) != 0) {
                                        REGS[i] = memory.readInt(addr)
                                        addr += 4
                                    }
                            }
                        } finally {
                            REGS[Rb] = addr
                        }
                    }
                    13 -> { // :1101
                        val soffset = (code and L8).toByte()
                        // Format 16: conditional branch
                        val cond = when (code shr 8 and L4) {
                            0 -> // :11010000
                                // BEQ label
                                z
                            1 -> // :11010001
                                // BNE label
                                !z
                            2 -> // :11010010
                                // BCS label
                                c
                            3 -> // :11010011
                                // BCC label
                                !c
                            4 -> // :11010100
                                // BMI label
                                n
                            5 -> // :11010101
                                // BPL label
                                !n
                            6 -> // :11010110
                                // BVS label
                                v
                            7 -> // :11010111
                                // BVC label
                                !v
                            8 -> // :11011000
                                // BHI label
                                c && !z
                            9 -> // :11011001
                                // BLS label
                                !c || z
                            10 -> // :11011010
                                // BGE label
                                // (n && v) || (!n && !v)
                                n == v
                            11 -> // :11011011
                                // BLT label
                                // (n && !v) || (!n && v)
                                n != v
                            12 -> // :11011100
                                // BGT label
                                // !z && (n && v || !n && !v)
                                !z && n == v
                            13 -> // :11011101
                                // BLE label
                                // z || (n && !v) || (!n && v)
                                z || n != v
                            14 -> // :11011110
                                throw UnknownInstructionException()
                            15 -> { // :11011111
                                // Format 17: software interrupt
                                // SWI Value8

                                REGS[CPSR] = (if (q) FQ else 0) or
                                        (if (v) FV else 0) or
                                        (if (c) FC else 0) or
                                        (if (z) FZ else 0) or
                                        if (n) FN else 0

                                regs.store(REGS)


                                try {
                                    interruptHandler!!.invoke(soffset.toInt() and 0xFF)
                                } catch (e: ControlPauseSignal) {
                                    throw e
                                } catch (e: ControlStopSignal) {
                                    REGS[PC] += 2
                                    throw e
                                } finally {
                                    REGS = regs.load()
                                    q = REGS[CPSR] and FQ != 0
                                    v = REGS[CPSR] and FV != 0
                                    c = REGS[CPSR] and FC != 0
                                    z = REGS[CPSR] and FZ != 0
                                    n = REGS[CPSR] and FN != 0
                                }

                                false // this is not jump
                            }
                            else -> throw UnexceptedLogicError()
                        }

                        if (cond) {
                            var value = soffset.toInt() and L8 shl 1
                            if (value and I8 != 0) {
                                value = value or L8.inv()
                            }

                            REGS[PC] += 4 + value
                            increase_pc = false
                        }
                    }
                    14 -> { // :11100
                        // Format 18: unconditional branch
                        if (code and I11 != 0)
                            throw UnknownInstructionException()

                        var value = code and L10 shl 1
                        if (code and I10 != 0) {
                            value = value or L11.inv()
                        }

                        REGS[PC] += 4 + value
                        increase_pc = false
                    }
                    15 -> { // :1111
                        // Format 19: long branch with link
                        val H = code shr 11 and L1 != 0
                        val value = code and L11
                        if (!H) {
                            REGS[LR] = value shl 12
                            count++
                        } else {
                            var addr = REGS[LR]
                            addr = addr or (value shl 1)
                            if (addr and (1 shl 22) != 0)
                                addr = addr or 8388607.inv()

                            val lr = REGS[PC]
                            REGS[PC] = lr + addr + 2
                            REGS[LR] = lr + 3
                            increase_pc = false
                        }
                    }
                    else -> throw UnknownInstructionException()
                }//  CPSR condition codes are unaffected

                if (increase_pc)
                    REGS[PC] += 2
            }
        } finally {
            REGS[CPSR] = (if (q) FQ else 0) or
                    (if (v) FV else 0) or
                    (if (c) FC else 0) or
                    (if (z) FZ else 0) or
                    if (n) FN else 0

            regs.store(REGS)
            executedCount += totalCount - count
        }
    }
}
