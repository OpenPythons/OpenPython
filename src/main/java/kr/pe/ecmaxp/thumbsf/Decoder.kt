package kr.pe.ecmaxp.thumbsf

import kr.pe.ecmaxp.thumbsf.exc.UnexceptedLogicError
import kr.pe.ecmaxp.thumbsf.exc.UnknownInstructionException
import kr.pe.ecmaxp.thumbsf.exc.UnsupportedInstructionException
import kr.pe.ecmaxp.thumbsf.helper.*


fun insnx(op: Int, Rd: Int, imm32: Int): Pair<Int, Int> {
    assert(op in 0..0xFF)
    assert(Rd in 0..PC)
    return Pair(op or (Rd shl 8), imm32)
}

fun insnx(op: Int, imm32: Int): Pair<Int, Int> {
    assert(op in 0..0xFF)
    return Pair(op, imm32)
}

fun insni(op: Int, Rd: Int, Rs: Int, imm16: Int): Pair<Int, Int> {
    assert(op in 0..0xFF)
    assert(Rd in 0..PC)
    assert(Rs in 0..PC)
    return Pair(op or (Rd shl 8) or (Rs shl 12) or (imm16 shl 16), 0)
}

fun insni(op: Int, Rd: Int, imm16: Int): Pair<Int, Int> {
    assert(op in 0..0xFF)
    assert(Rd in 0..PC)
    return Pair(op or (Rd shl 8) or (imm16 shl 16), 0)
}

fun insni(op: Int, imm16: Int): Pair<Int, Int> {
    assert(op in 0..0xFF)
    return Pair(op or (imm16 shl 16), 0)
}

fun insn(op: Int, Rd: Int, Rs: Int, Rn: Int): Pair<Int, Int> {
    assert(op in 0..0xFF)
    assert(Rd in 0..PC)
    assert(Rs in 0..PC)
    assert(Rn in 0..PC)
    return Pair(op or (Rd shl 8) or (Rs shl 12) or (Rn shl 16), 0)
}

fun insn(op: Int, Rd: Int, Rs: Int): Pair<Int, Int> {
    assert(op in 0..0xFF)
    assert(Rd in 0..PC)
    assert(Rs in 0..PC)
    return Pair(op or (Rd shl 8) or (Rs shl 12), 0)
}

fun insn(op: Int, Rd: Int): Pair<Int, Int> {
    assert(op in 0..0xFF)
    assert(Rd in 0..PC)
    return Pair(op or (Rd shl 8), 0)
}

fun insn(op: Int): Pair<Int, Int> {
    assert(op in 0..0xFF)
    return Pair(op, 0)
}

fun show(code: Int, imm32: Int, executedCount: Int = -1) {
    val op = code and 0xFF
    val Rd = code shr 8 and 0b1111
    val Rs = code shr 12 and 0b1111
    val Rn = code shr 16 and 0b1111
    val imm16 = code shr 16
    println("${executedCount}    ${op2str(op)}  Rd=$Rd  Rs=$Rs  Rn=$Rn  imm16=$imm16  imm32=$imm32")
}

fun decode(memory: Memory, pc: Int): Pair<Int, Int> {
    val code = memory.fetchCode(pc)

    return when (code shr 12 and L4) {
        0, 1 -> { // :000x
            val Rs = code shr 3 and L3
            val Rd = code and L3

            when (code shr 11 and L2) { // move shifted register
                0 -> { // :00000 ; LSL Rd, Rs, #Offset5
                    val offset = code shr 6 and L5 // 0 ~ 31
                    insni(LSLSI, Rd, Rs, offset)
                }
                1 -> { // :00001 ; LSR Rd, Rs, #Offset5
                    val offset = (code shr 6 and L5) // 1 ~ 32
                    insni(LSRSI, Rd, Rs, if (offset != 0) offset else 32)
                }
                2 -> { // :00010 ; ASR Rd, Rs, #Offset5
                    val offset = (code shr 6 and L5) // 1 ~ 32
                    insni(ASRSI, Rd, Rs, if (offset != 0) offset else 32)
                }
                3 -> { // :00011 ; add/subtract
                    val I = code shr 10 and 1 != 0
                    val Rn = code shr 6 and L3

                    when (code shr 9 and L1) {
                        0 -> {
                            if (I)
                                insni(ADD3SI, Rd, Rs, Rn) // :0001110 ; ADD Rd, Rs, #Offset3
                            else
                                insn(ADD3S, Rd, Rs, Rn) // :0001100 ; ADD Rd, Rs, Rn
                        }
                        1 -> {
                            if (I)
                                insni(SUB3SI, Rd, Rs, Rn) // :0001111 ; SUB Rd, Rs, #Offset3
                            else
                                insn(SUB3S, Rd, Rs, Rn) // :0001101 ; SUB Rd, Rs, Rn
                        }
                        else -> throw UnexceptedLogicError()
                    }
                }
                else -> throw UnexceptedLogicError()
            }
        }
        2, 3 -> { // :001 ; move/compare/add/subtract immediate
            val Rd = code shr 8 and L3
            val offset8 = code and L8

            val op = when (code shr 11 and L2) {
                0 -> MOVSI // :001100 ; MOV Rd, #Offset8
                1 -> CMPI // :001101 ; CMP Rd, #Offset8
                2 -> ADDSI // :001110 ; ADD Rd, #Offset8
                3 -> SUBSI // :001111 ; SUB Rd, #Offset8
                else -> throw UnexceptedLogicError()
            }

            insni(op, Rd, offset8)
        }
        4 -> // :0100
            when (code shr 10 and L2) {
                0 -> { // :010000 ; ALU operations
                    val Rs = code shr 3 and L3
                    val Rd = code and L3
                    val op = when (code shr 6 and L4) {
                        0 -> ANDS // :0100000000 ; AND Rd, Rs ; Rd:= Rd AND Rs
                        1 -> EORS // :0100000001 ; EOR Rd, Rs ; Rd:= Rd EOR Rs
                        2 -> LSLS // :0100000010 ; LSL Rd, Rs ; Rd := Rd << Rs
                        3 -> LSRS // :0100000011 ; LSR Rd, Rs ; Rd := Rd >>> Rs
                        4 -> ASRS // :0100000100 ; ASR Rd, Rs ; Rd := Rd ASR Rs
                        5 -> ADCS // :0100000101 ; ADC Rd, Rs ; Rd := Rd + Rs + C-bit
                        6 -> SBCS // :0100000110 ; SBC Rd, Rs ; Rd := Rd - Rs - NOT C-bit
                        7 -> RORS // :0100000111 ; ROR Rd, Rs ; Rd := Rd ROR Rs
                        8 -> TSTS // :0100001000 ; TST Rd, Rs ; set condition codes on Rd AND Rs
                        9 -> RSBS // :0100001001 ; NEG Rd, Rs ; Rd = -Rs
                        10 -> CMP // :0100001010 ; CMP Rd, Rs ; set condition codes on Rd - Rs
                        11 -> CMN // :0100001011 ; CMN Rd, Rs ; set condition codes on Rd + Rs
                        12 -> ORRS // :0100001100 ; ORR Rd, Rs ; Rd := Rd OR Rs
                        13 -> MULS // :0100001101 ; MUL Rd, Rs ; Rd := Rs * Rd
                        14 -> BICS // :0100001110 ; BIC Rd, Rs ; Rd := Rd AND NOT Rs
                        15 -> MVNS // :0100001111 ; MVN Rd, Rs ; Rd := NOT Rs
                        else -> throw UnexceptedLogicError()
                    }

                    insn(op, Rd, Rs)
                }
                1 -> { // :010001 ; Hi register operations/branch exchange
                    val H1 = code shr 7 and L1 != 0
                    val H2 = code shr 6 and L1 != 0
                    val Rd = (code and L3) + if (H1) 8 else 0
                    val Rs = (code shr 3 and L3) + if (H2) 8 else 0
                    var op = when (code shr 8 and L2) {
                        0 -> ADD // :01000100 ; ADD Rd, Hs ; ADD Hd, Rs ; ADD Hd, Hs
                        1 -> CMP // :01000101 ; CMP Rd, Hs ; CMP Hd, Rs ; CMP Hd, Hs
                        2 -> MOV // :01000110 ; MOV Rd, Hs ; MOV Hd, Rs ; MOV Hd, Hs
                        3 -> if (H1) BLX else BX // :01000111 ; BX Rs ; BX Hs
                        else -> throw UnexceptedLogicError()
                    }

                    when (op) {
                        ADD -> {
                            op = when (Rd) {
                                PC, SP, LR -> ADDX
                                else -> op
                            }

                            op = when (Rs) {
                                PC, SP, LR -> ADDX
                                else -> op
                            }
                        }
                        CMP -> {
                            op = when (Rd) {
                                PC, SP, LR -> CMPX
                                else -> op
                            }

                            op = when (Rs) {
                                PC, SP, LR -> CMPX
                                else -> op
                            }
                        }
                        MOV -> {
                            op = when (Rd) {
                                PC, SP, LR -> MOVX
                                else -> op
                            }

                            op = when (Rs) {
                                PC, SP, LR -> MOVX
                                else -> op
                            }
                        }
                    }

                    when (op) {
                        ADD, CMP, MOV -> insn(op, Rd, Rs)
                        ADDX, CMPX, MOVX -> insn(op, Rd, Rs)
                        BX -> insn(op, 0, Rs)
                        BLX -> insn(op, 0, Rs)
                        else -> throw UnexceptedLogicError()
                    }
                }
                2, 3 -> { // :01001 ; PC-relative load ; LDR Rd, [PC, #Imm]
                    val Rd = code shr 8 and L3
                    var addr = code and L8 shl 2
                    addr += pc + 4 and I1.inv()
                    val value = memory.readInt(addr)

                    insnx(MOVI, Rd, value)
                }
                else -> throw UnexceptedLogicError()
            }
        5 -> { // :0101
            if (code and I9 == 0) { // :0101xx0 ; load/store with register offset
                val L = code and I11 != 0
                val B = code and I10 != 0
                val Ro = code shr 6 and L3
                val Rb = code shr 3 and L3
                val Rd = code and L3
                val op = when {
                    L && !B -> LDR // :0101100 ; LDR Rd, [Rb, Ro]
                    L && B -> LDRB // :0101100 ; LDRB Rd, [Rb, Ro]
                    !L && !B -> STR // :0101000 ; STR Rd, [Rb, Ro]
                    !L && B -> STRB // :0101010 ; STRB Rd, [Rb, Ro]
                    else -> throw UnexceptedLogicError()
                }

                insn(op, Rd, Rb, Ro)
            } else { // :0101xx1 ; load/store sign-extended byte/halfword
                val H = code and I11 != 0
                val S = code and I10 != 0
                val Ro = code shr 6 and L3
                val Rb = code shr 3 and L3
                val Rd = code and L3
                val op = when {
                    S && H -> LDSH // :0101111 ; LDSH Rd, [Rb, Ro]
                    S && !H -> LDRB // :0101011 ; LDSB Rd, [Rb, Ro]
                    !S && H -> LDRH // :0101101 ; LDRH Rd, [Rb, Ro]
                    !S && !H -> STRH // :0101001 ; STRH Rd, [Rb, Ro]
                    else -> throw UnexceptedLogicError()
                }

                insn(op, Rd, Rb, Ro)
            }
        }
        6, 7 -> { // :011 ; load/store with immediate offset
            val B = code and I12 != 0
            val L = code and I11 != 0
            val Rb = code shr 3 and L3
            val Rd = code and L3
            var offset = code shr 6 and L5

            if (!B)
                offset = offset shl 2

            val op = when {
                L && !B -> LDRI // :01111 ; LDR Rd, [Rb, #Imm]
                L && B -> LDRBI // :01101 ; LDRB Rd, [Rb, #Imm]
                !L && !B -> STRI // :01100 ; STR Rd, [Rb, #Imm]
                !L && B -> STRBI // :01110 ; STRB Rd, [Rb, #Imm]
                else -> throw UnexceptedLogicError()
            }

            insni(op, Rd, Rb, offset)
        }
        8 -> { // :1000x ; load/store halfword
            val L = code and I11 != 0
            val Rb = code shr 3 and L3
            val Rd = code and L3
            val offset = code shr 6 and L5 shl 1
            val op = when {
                L -> LDRHI // :10001 ; LDRH Rd, [Rb, #Imm]
                !L -> STRHI  // :10000 ; STRH Rd, [Rb, #Imm]
                else -> throw UnexceptedLogicError()
            }

            insni(op, Rd, Rb, offset)
        }
        9 -> { // :1001x ; SP-relative load/store
            val L = code and I11 != 0
            val Rd = code shr 8 and L3
            val offset = code and L8 shl 2
            val op = when {
                L -> LDRSPI // :10011 ; LDR Rd, [SP, #Imm]
                !L -> STRSPI // :10010 ; STR Rd, [SP, #Imm]
                else -> throw UnexceptedLogicError()
            }

            insni(op, Rd, SP, offset)
        }
        10 -> { // :1010x ; load address
            val fSP = code and I11 != 0
            val Rd = code shr 8 and L3
            val value = code and L8 shl 2

            if (fSP) {
                insni(ADDXI, Rd, SP, value)
            } else {
                insni(ADDXI, Rd, PC, value) // from PC
            }
        }
        11 -> { // :1011
            when (code shr 8 and L4) {
                0 -> { // :10110000x ; add offset to Stack Pointer
                    val S = code and I7 != 0
                    var value = code and L7 shl 2

                    if (S) // :101100000 ; ADD SP, #-Imm
                        value = -value

                    // :101100001 ; ADD SP, #Imm
                    return insni(ADDSPI, value)
                }
                1 -> throw UnsupportedInstructionException() // :10110001 ; CBZ Rd, #Imm
                2 -> { // :10110010 ; SXTH, SXTB, UXTH, UXTB
                    val Rs = code shr 3 and L3
                    val Rd = code and L3

                    val op = when (code shr 6 and L2) {
                        0 -> SXTH // :1011001000 ; SXTH Rd, Rs
                        1 -> SXTB // :1011001001 ; SXTB Rd, Rs
                        2 -> UXTH // :1011001010 ; UXTH Rd, Rs
                        3 -> UXTB // :1011001011 ; UXTB Rd, Rs
                        else -> throw UnexceptedLogicError()
                    }

                    return insn(op, Rd, Rs)
                }
                3 -> throw UnsupportedInstructionException() // :10110011 ; CBZ Rd, #Imm
                4, 5 -> { // :1011010x ; push/pop registers
                    val R = code and I8 != 0
                    val list = code and L8

                    if (R) {
                        return insni(PUSHR, list) // :10110101 ; PUSH { ..., LR }
                    } else {
                        return insni(PUSH, list) // :10110100 ; PUSH { ... }
                    }
                }
                6, 7, 8 -> throw UnknownInstructionException() // :10110110 :10110111 :10111000
                9 -> throw UnsupportedInstructionException() // :10111001 ; CBNZ Rd, #Imm
                10 -> { // :10111010xx
                    val Rs = code shr 3 and L3
                    val Rd = code and L3

                    val op = when (code shr 6 and L2) {
                        0 -> REV // :1011101000 ; REV Rd, Rs
                        1 -> throw UnsupportedInstructionException() // :1011101001 ; REV16 Rd, Rs
                        2 -> throw UnknownInstructionException() // :1011101010 ; INVALID
                        3 -> throw UnsupportedInstructionException() // :1011101011 ; REVSH Rd, Rs
                        else -> throw UnexceptedLogicError()
                    }

                    return insn(op, Rd, Rs)
                }
                11 -> throw UnsupportedInstructionException() // :10111011 ; CBNZ Rd, #Imm
                12, 13 -> { // :1011110x ; push/pop registers
                    val R = code and I8 != 0
                    val list = code and L8

                    if (R) {
                        return insni(POPR, list) // :10110101 ; PUSH { ..., LR }
                    } else {
                        return insni(POP, list) // :10110100 ; PUSH { ... }
                    }
                }
                14, 15 -> throw UnknownInstructionException() // :10111110 :10111111
                else -> throw UnexceptedLogicError()
            }
        }
        12 -> { // :1100 ; multiple load/store
            val L = code and I11 != 0
            val list = code and L8
            val Rb = code shr 8 and L3

            if (!L) {
                insni(STMIA, Rb, list) // :11001 ; STMIA Rb!, { Rlist }
            } else {
                insni(LDMIA, Rb, list) // :11000 ; LDMIA Rb!, { Rlist }
            }
        }
        13 -> { // :1101 ; conditional branch (or software interrupt)
            val soffset = (code and L8)
            val op = when (code shr 8 and L4) {
                0 -> BEQ // :11010000 ; BEQ label
                1 -> BNE // :11010001 ; BNE label
                2 -> BCS // :11010010 ; BCS label
                3 -> BCC // :11010011; BCC label
                4 -> BMI // :11010100 ; BMI label
                5 -> BPL // :11010101 ; BPL label
                6 -> BVS // :11010110 ; BVS label
                7 -> BVC // :11010111 ; BVC label
                8 -> BHI // :11011000 ; BHI label
                9 -> BLS // :11011001 ; BLS label
                10 -> BGE // :11011010 ; BGE label ; (n && v) || (!n && !v)
                11 -> BLT // :11011011 ; BLT label ; (n && !v) || (!n && v)
                12 -> BGT // :11011100 ; BGT label ; !z && (n && v || !n && !v)
                13 -> BLE // :11011101 ; BLE label ; z || (n && !v) || (!n && v)
                14 -> throw UnknownInstructionException() // :11011110
                15 -> SVC // :11011111 ; software interrupt
                else -> throw UnexceptedLogicError()
            }

            if (op == SVC) {
                insni(op, soffset)
            } else {
                var value = soffset and L8 shl 1
                if (value and I8 != 0) {
                    value = value or L8.inv()
                }

                val offset = 4 + value
                insni(op, offset)
            }
        }
        14 -> { // :11100 ; unconditional branch
            if (code and I11 != 0)
                throw UnknownInstructionException()

            var value = code and L10 shl 1
            if (code and I10 != 0) {
                value = value or L11.inv()
            }

            val offset = 4 + value
            insni(B, offset)
        }
        15 -> { // :1111 ; long branch with link
            val H1 = code shr 11 and L1 != 0
            val value1 = code and L11

            if (!H1) {
                val otherCode = memory.fetchCode(pc + 2)
                val H2 = otherCode shr 11 and L1 != 0
                val value2 = otherCode and L11

                if (!H1 && H2) {
                    var addr = (value1 shl 12) or (value2 shl 1)
                    if (addr and (1 shl 22) != 0)
                        addr = addr or 8388607.inv()

                    addr += 2
                    insnx(BL, addr)
                } else {
                    throw UnknownInstructionException()
                }
            } else {
                throw UnknownInstructionException()
            }
        }
        else -> throw UnexceptedLogicError()
    }
}