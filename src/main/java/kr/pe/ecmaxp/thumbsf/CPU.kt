package kr.pe.ecmaxp.thumbsf

import kr.pe.ecmaxp.thumbsf.exc.InvalidAddressArmException
import kr.pe.ecmaxp.thumbsf.exc.InvalidMemoryException
import kr.pe.ecmaxp.thumbsf.exc.UnexceptedLogicError
import kr.pe.ecmaxp.thumbsf.exc.UnknownInstructionException
import kr.pe.ecmaxp.thumbsf.helper.*
import kr.pe.ecmaxp.thumbsf.signal.ControlPauseSignal
import kr.pe.ecmaxp.thumbsf.signal.ControlStopSignal
import kr.pe.ecmaxp.thumbsk.RefCPU

const val RDEST = 8
const val RSRC = 12
const val RNUM = 16
const val RMASK = 0b1111
const val RIMM = 16

class CPU {
    var regs = Registers()
    var memory = Memory()
    private var executedCount = 0

    fun fork(): CPU {
        val cpu = CPU()
        cpu.memory = memory
        return cpu
    }

    fun call(sp: Int, addr: Int, r0: Int = 0, r1: Int = 0, r2: Int = 0, r3: Int = 0): Registers {
        val cpu = fork()
        return Registers()
    }

    @Throws(InvalidMemoryException::class, UnknownInstructionException::class, InvalidAddressArmException::class)
    fun run(insnCount: Int, handler: InterruptHandler) {
        val memory = this.memory
        val (buffer, base) = memory.loadExecCache()

        var REGS = regs.fastLoad()
        var lr = regs.lr
        var sp = regs.sp
        var pc = regs.pc
        var q = regs.q
        var v = regs.v
        var c = regs.c
        var z = regs.z
        var n = regs.n

        assert(pc and I0 == 0)
        pc = pc and I0.inv()

        var count = insnCount

        try {
            loop@ while (count-- > 0) {
                val code = buffer[pc - base]
                val prev_pc = pc

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
                    }
                    ERROR -> throw UnknownInstructionException()

                    // Format 1
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
                    LSRSI -> {
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
                    ASRSI -> {
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

                    // Format 2
                    ADD3S -> {
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
                    ADD3SI -> {
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
                    SUB3S -> {
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
                    SUB3SI -> {
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

                    // Format 3
                    MOVSI -> {
                        val Rd = code shr RDEST and RMASK
                        val imm16 = code shr RIMM
                        val value = imm16
                        REGS[Rd] = value
                        n = value < 0
                        z = value == 0
                        pc += 2
                    }
                    CMPI -> {
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
                    ADDSI -> {
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
                    SUBSI -> {
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

                    // Format 4
                    ANDS -> {
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
                    EORS -> {
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
                    LSLS -> {
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
                    LSRS -> {
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
                    ASRS -> {
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
                    ADCS -> {
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
                    SBCS -> {
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
                    RORS -> {
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
                    TSTS -> {
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val left = REGS[Rd]
                        val right = REGS[Rs]

                        val value = left and right

                        n = value < 0
                        z = value == 0
                        pc += 2
                    }
                    RSBS -> {
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
                    CMP -> {
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
                    CMN -> {
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
                    ORRS -> {
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
                    MULS -> {
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
                    BICS -> {
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
                    MVNS -> {
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val right = REGS[Rs]
                        val value = right.inv()

                        REGS[Rd] = value

                        n = value < 0
                        z = value == 0
                        pc += 2
                    }

                    // Format 5
                    ADD -> {
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val left = REGS[Rd]
                        val right = REGS[Rs]

                        val value = left + right

                        REGS[Rd] = value

                        pc += 2
                    }
                    ADDX -> {
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
                    CMPX -> {
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
                    MOV -> {
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        REGS[Rd] = REGS[Rs]
                        pc += 2
                    }
                    MOVX -> {
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
                    BX -> {
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
                    BLX -> {
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

                    // Format 6
                    MOVI -> {
                        val Rd = code shr RDEST and RMASK
                        val imm32 = buffer[pc - base + 1]
                        REGS[Rd] = imm32
                        pc += 2
                    }

                    // Format 7
                    STR -> {
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val Rn = code shr RNUM and RMASK
                        val addr = REGS[Rs] + REGS[Rn]
                        val value = REGS[Rd]
                        memory.writeInt(addr, value)
                        pc += 2
                    }
                    STRB -> {
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val Rn = code shr RNUM and RMASK
                        val addr = REGS[Rs] + REGS[Rn]
                        val value = REGS[Rd]
                        memory.writeByte(addr, value.toByte())
                        pc += 2
                    }
                    LDR -> {
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val Rn = code shr RNUM and RMASK
                        val addr = REGS[Rs] + REGS[Rn]
                        REGS[Rd] = memory.readInt(addr)
                        pc += 2
                    }
                    LDRB -> {
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val Rn = code shr RNUM and RMASK
                        val addr = REGS[Rs] + REGS[Rn]
                        REGS[Rd] = memory.readByte(addr).toInt() and 0xFF
                        pc += 2
                    }
                    // Format 8
                    STRH -> {
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val Rn = code shr RNUM and RMASK
                        val addr = REGS[Rs] + REGS[Rn]
                        memory.writeShort(addr, REGS[Rd].toShort())
                        pc += 2
                    }
                    LDRH -> {
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val Rn = code shr RNUM and RMASK
                        val addr = REGS[Rs] + REGS[Rn]
                        REGS[Rd] = memory.readShort(addr).toInt() and 0xFFFF
                        pc += 2
                    }
                    LDSB -> {
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val Rn = code shr RNUM and RMASK
                        val addr = REGS[Rs] + REGS[Rn]
                        REGS[Rd] = memory.readByte(addr).toInt()
                        pc += 2
                    }
                    LDSH -> {
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val Rn = code shr RNUM and RMASK
                        val addr = REGS[Rs] + REGS[Rn]
                        REGS[Rd] = memory.readShort(addr).toInt()
                        pc += 2
                    }

                    // Format 9
                    STRI -> {
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val imm16 = code shr RIMM
                        val addr = REGS[Rs] + imm16
                        val value = REGS[Rd]
                        memory.writeInt(addr, value)
                        pc += 2
                    }
                    STRBI -> {
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val imm16 = code shr RIMM
                        val addr = REGS[Rs] + imm16
                        val value = REGS[Rd]
                        memory.writeByte(addr, value.toByte())
                        pc += 2
                    }
                    LDRI -> {
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val imm16 = code shr RIMM
                        val addr = REGS[Rs] + imm16
                        REGS[Rd] = memory.readInt(addr)
                        pc += 2
                    }
                    LDRBI -> {
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val imm16 = code shr RIMM
                        val addr = REGS[Rs] + imm16
                        REGS[Rd] = memory.readByte(addr).toInt() and 0xFF
                        pc += 2
                    }

                    // Format 10
                    STRHI -> {
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val imm16 = code shr RIMM
                        val addr = REGS[Rs] + imm16
                        memory.writeShort(addr, REGS[Rd].toShort())
                        pc += 2
                    }
                    LDRHI -> {
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        val imm16 = code shr RIMM
                        val addr = REGS[Rs] + imm16
                        REGS[Rd] = memory.readShort(addr).toInt() and 0xFFFF
                        pc += 2
                    }

                    // Format 11
                    STRSPI -> {
                        val Rd = code shr RDEST and RMASK
                        val imm16 = code shr RIMM
                        val addr = sp + imm16
                        val value = REGS[Rd]
                        memory.writeInt(addr, value)
                        pc += 2
                    }
                    LDRSPI -> {
                        val Rd = code shr RDEST and RMASK
                        val imm16 = code shr RIMM
                        val addr = sp + imm16
                        REGS[Rd] = memory.readInt(addr)
                        pc += 2
                    }

                    // Format 12
                    ADDXI -> {
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

                    // Format 13
                    ADDSPI -> {
                        val imm16 = code shr RIMM
                        sp += imm16
                        pc += 2
                    }

                    // Format 14
                    PUSH -> {
                        val imm16 = code shr RIMM
                        for (i in 7 downTo 0) {
                            if (imm16 and (1 shl i) != 0) {
                                sp -= 4
                                memory.writeInt(sp, REGS[i])
                            }
                        }

                        pc += 2
                    }
                    PUSHR -> {
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
                    POP -> {
                        val imm16 = code shr RIMM
                        for (i in 0..7) {
                            if (imm16 and (1 shl i) != 0) {
                                REGS[i] = memory.readInt(sp)
                                sp += 4
                            }
                        }

                        pc += 2
                    }
                    POPR -> {
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

                    // Format 15
                    STMIA -> {
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
                    LDMIA -> {
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

                    // Format 16
                    BEQ -> pc += if (z) code shr RIMM else 2
                    BNE -> pc += if (!z) code shr RIMM else 2
                    BCS -> pc += if (c) code shr RIMM else 2
                    BCC -> pc += if (!c) code shr RIMM else 2
                    BMI -> pc += if (n) code shr RIMM else 2
                    BPL -> pc += if (!n) code shr RIMM else 2
                    BVS -> pc += if (v) code shr RIMM else 2
                    BVC -> pc += if (!v) code shr RIMM else 2
                    BHI -> pc += if (c && !z) code shr RIMM else 2
                    BLS -> pc += if (!c || z) code shr RIMM else 2
                    BGE -> pc += if (n == v) code shr RIMM else 2
                    BLT -> pc += if (n != v) code shr RIMM else 2
                    BGT -> pc += if (!z && n == v) code shr RIMM else 2
                    BLE -> pc += if (z || n != v) code shr RIMM else 2

                    // Format 17
                    SVC -> {
                        val imm16 = code shr RIMM
                        println("SVC $imm16:${REGS[7]} r0=${REGS[0]} r1=${REGS[1]} r2=${REGS[2]} r3=${REGS[3]}")
                        regs.setCPSR(q, v, c, z, n)
                        regs.fastStore(REGS, sp, lr, pc)

                        try {
                            handler(imm16)
                        } catch (e: ControlPauseSignal) {
                            throw e
                        } catch (e: ControlStopSignal) {
                            pc += 2
                            throw e
                        } finally {
                            sp = regs.sp
                            lr = regs.lr
                            pc = regs.pc
                            REGS = regs.fastLoad()
                            q = regs.q
                            v = regs.v
                            c = regs.c
                            z = regs.z
                            n = regs.n
                        }

                        pc += 2
                    }

                    // Format 18
                    B -> {
                        val imm16 = code shr RIMM
                        pc += imm16
                    }

                    // Format 19
                    BL -> {
                        val imm32 = buffer[pc - base + 1]
                        lr = pc + 3 + 2
                        pc += imm32 + 2
                    }

                    //
                    SXTH -> {
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        REGS[Rd] = REGS[Rs].toShort().toInt()
                        pc += 2
                    }
                    SXTB -> {
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        REGS[Rd] = REGS[Rs].toByte().toInt()
                        pc += 2
                    }
                    UXTH -> {
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        REGS[Rd] = REGS[Rs] and 0xFFFF
                        pc += 2
                    }
                    UXTB -> {
                        val Rd = code shr RDEST and RMASK
                        val Rs = code shr RSRC and RMASK
                        REGS[Rd] = REGS[Rs] and 0xFF
                        pc += 2
                    }
                    REV -> {
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
            regs.setCPSR(q, v, c, z, n)
            regs.fastStore(REGS, sp, lr, pc)
        }
    }
}