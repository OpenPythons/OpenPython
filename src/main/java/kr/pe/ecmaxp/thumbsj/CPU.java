package kr.pe.ecmaxp.thumbsj;

import kr.pe.ecmaxp.thumbsj.exc.InvalidAddressArmException;
import kr.pe.ecmaxp.thumbsj.exc.InvalidMemoryException;
import kr.pe.ecmaxp.thumbsj.exc.UnexceptedLogicError;
import kr.pe.ecmaxp.thumbsj.exc.UnsupportedInstructionException;

import static kr.pe.ecmaxp.thumbsj.helper.BitConsts.*;
import static kr.pe.ecmaxp.thumbsj.helper.RegisterIndex.*;

public class CPU
{
    @SuppressWarnings("WeakerAccess")
    public Registers regs = new Registers();

    @SuppressWarnings("WeakerAccess")
    public Memory memory = new Memory();

    @SuppressWarnings("WeakerAccess")
    public InterruptHandler interruptHandler;

    public int executedCount = 0;

    @SuppressWarnings("WeakerAccess")
    public boolean Interrupt(byte soffset)
    {
        throw new UnsupportedOperationException();
    }

    public void run(int count) throws InvalidMemoryException, UnknownInstructionException, InvalidAddressArmException, UnsupportedInstructionException
    {
        Memory memory = this.memory;
        int[] REGS = regs.load();

        boolean q = (REGS[CPSR] & FQ) != 0;
        boolean v = (REGS[CPSR] & FV) != 0;
        boolean c = (REGS[CPSR] & FC) != 0;
        boolean z = (REGS[CPSR] & FZ) != 0;
        boolean n = (REGS[CPSR] & FN) != 0;

        assert (REGS[PC] & I0) == 0;
        REGS[PC] &= ~I0;

        int totalCount = count;

        try
        {
            while (count-- > 0)
            {
                boolean increase_pc = true;
                int Rs, Rd, Rb;
                int left, right, value, addr;
                long lvalue;
                boolean L, B, S, H;
                int list;

                int code = memory.fetchCode(REGS[PC]);

                switch ((code >> 12) & L4)
                {
                    case 0b0000:
                    case 0b0001: // :000x
                        Rs = (code >> 3) & L3;
                        Rd = code & L3;
                        left = REGS[Rs];
                        switch ((code >> 11) & L2)
                        {
                            // Format 1: move shifted register
                            case 0: // :00000
                                // LSL Rd, Rs, #Offset5
                                right = (code >> 6) & L5; // right = 0 ~ 31
                                value = left << right;

                                if (right > 0)
                                    c = ((left << (right - 1)) & FN) != 0;
                                break;
                            case 1: // :00001
                                //  LSR Rd, Rs, #Offset5
                                right = (code >> 6) & L5; // right = 1 ~ 32
                                if (right == 0)
                                {
                                    value = 0;
                                    c = (left & FN) != 0;
                                }
                                else
                                {
                                    value = left >>> right;
                                    c = (left & (1 << (right - 1))) != 0;
                                }
                                break;
                            case 2: // :00010
                                // ASR Rd, Rs, #Offset5
                                right = (code >> 6) & L5; // right = 1 ~ 32
                                if (right == 0)
                                {
                                    value = left > 0 ? 0 : -1;
                                    c = (left & FN) != 0;
                                }
                                else
                                {
                                    value = left >> right;
                                    c = (left & (1 << (right - 1))) != 0;
                                }
                                break;
                            case 3: // :00011
                                // Format 2: add/subtract
                                boolean I = ((code >> 10) & 0b1) != 0;
                                int Rn = (code >> 6) & L3;
                                Rs = (code >> 3) & L3;
                                Rd = code & L3;
                                left = REGS[Rs];
                                right = I ? Rn : REGS[Rn];

                                switch ((code >> 9) & L1)
                                {
                                    case 0: // :0001100 | :0001110
                                        // ADD Rd, Rs, Rn
                                        // ADD Rd, Rs, #Offset3
                                        lvalue = (((long) left) & 0xffffffffL) +
                                                (((long) right) & 0xffffffffL);
                                        value = (int) lvalue;
                                        c = lvalue > 0xFFFFFFFFL;
                                        v = ((left ^ value) & (right ^ value)) < 0;
                                        break;
                                    case 1: // :0001101 | :0001111
                                        // SUB Rd, Rs, Rn
                                        // SUB Rd, Rs, #Offset3
                                        lvalue = (((long) left) & 0xffffffffL) +
                                                (((long) ~right) & 0xffffffffL) + 1L;
                                        value = (int) lvalue;
                                        c = lvalue > 0xFFFFFFFFL;
                                        v = ((left ^ right) & (left ^ value)) < 0;
                                        break;
                                    default:
                                        throw new UnexceptedLogicError();
                                }

                                break;
                            default:
                                throw new UnexceptedLogicError();
                        }

                        n = value < 0;
                        z = value == 0;
                        REGS[Rd] = value;
                        break;
                    case 0b0010:
                    case 0b0011: // :001
                        // Format 3: move/compare/add/subtract immediate
                        Rd = (code >> 8) & L3;
                        left = REGS[Rd];
                        right = code & L8;
                        switch ((code >> 11) & L2)
                        {
                            case 0: // :001100
                                // MOV Rd, #Offset8
                                value = right;
                                REGS[Rd] = value;
                                break;
                            case 1: // :001101
                                // CMP Rd, #Offset8
                                lvalue = (((long) left) & 0xffffffffL) +
                                        (((long) ~right) & 0xffffffffL) + 1L;
                                value = (int) lvalue;
                                // only compare (no write)
                                c = lvalue > 0xFFFFFFFFL;
                                v = ((left ^ right) & (left ^ value)) < 0;
                                break;
                            case 2: // :001110
                                // ADD Rd, #Offset8
                                lvalue = (((long) left) & 0xffffffffL) +
                                        (((long) right) & 0xffffffffL);
                                value = (int) lvalue;
                                REGS[Rd] = value;
                                c = lvalue > 0xFFFFFFFFL;
                                v = ((left ^ value) & (right ^ value)) < 0;
                                break;
                            case 3: // :001111
                                // SUB Rd, #Offset8
                                lvalue = (((long) left) & 0xffffffffL) +
                                        (((long) ~right) & 0xffffffffL) + 1L;
                                value = (int) lvalue;
                                REGS[Rd] = value;
                                c = lvalue > 0xFFFFFFFFL;
                                v = ((left ^ right) & (left ^ value)) < 0;
                                break;
                            default:
                                throw new UnexceptedLogicError();
                        }

                        n = value < 0;
                        z = value == 0;
                        break;
                    case 0b0100: // :0100
                        switch ((code >> 10) & L2)
                        {
                            case 0b00: // :010000
                                // Format 4: ALU operations
                                Rs = (code >> 3) & L3;
                                Rd = code & L3;
                                left = REGS[Rd];
                                right = REGS[Rs];
                                switch ((code >> 6) & L4)
                                {
                                    case 0b0000: // :0100000000
                                        // AND Rd, Rs
                                        // Rd:= Rd AND Rs
                                        value = left & right;
                                        REGS[Rd] = value;
                                        break;
                                    case 0b0001: // :0100000001
                                        // EOR Rd, Rs
                                        // Rd:= Rd EOR Rs
                                        value = left ^ right;
                                        REGS[Rd] = value;
                                        break;
                                    case 0b0010: // :0100000010
                                        // LSL Rd, Rs
                                        // Rd := Rd << Rs

                                        if (right >= 32)
                                        {
                                            value = 0;
                                            c = right == 32 && (left & 1) != 0;
                                        }
                                        else if (right < 0)
                                        {
                                            value = 0;
                                            c = false;
                                        }
                                        else if (right == 0)
                                        {
                                            value = left;
                                        }
                                        else
                                        {
                                            value = left << right;
                                            c = ((left << (right - 1)) & FN) != 0;
                                        }

                                        REGS[Rd] = value;
                                        break;
                                    case 0b0011: // :0100000011
                                        // LSR Rd, Rs
                                        // Rd := Rd >>> Rs

                                        if (right >= 32)
                                        {
                                            value = 0;
                                            c = right == 32 && (left & FN) != 0;
                                        }
                                        else if (right < 0)
                                        {
                                            value = 0;
                                            c = false;
                                        }
                                        else if (right == 0)
                                        {
                                            value = left;
                                        }
                                        else
                                        {
                                            value = left >>> right;
                                            REGS[Rd] = value;
                                            c = ((left >>> (right - 1)) & 1) != 0;
                                        }

                                        break;
                                    case 0b0100: // :0100000100
                                        // ASR Rd, Rs
                                        // Rd := Rd ASR Rs

                                        if (right < 0 || right >= 32)
                                        {
                                            value = left > 0 ? 0 : -1;
                                            c = value < 0;
                                        }
                                        else if (right == 0)
                                        {
                                            value = left;
                                        }
                                        else
                                        {
                                            value = left >> right;
                                            REGS[Rd] = value;
                                            c = (left & (1 << (right - 1))) != 0;
                                        }

                                        break;
                                    case 0b0101: // :0100000101
                                        // ADC Rd, Rs
                                        // Rd := Rd + Rs + C-bit
                                        lvalue = (((long) left) & 0xffffffffL) +
                                                (((long) right) & 0xffffffffL) + (c ? 1L : 0L);
                                        value = (int) lvalue;
                                        REGS[Rd] = value;

                                        c = lvalue != (int) value;
                                        v = left > 0 && right > 0 && value < 0 ||
                                                left < 0 && right < 0 && value > 0;
                                        break;
                                    case 0b0110: // :0100000110
                                        // SBC Rd, Rs
                                        // Rd := Rd - Rs - NOT C-bit
                                        lvalue = (long) left - right - (c ? 0L : 1L);
                                        value = left - right - (c ? 0 : 1);
                                        REGS[Rd] = value;

                                        c = c || value < 0;
                                        v = lvalue != value;
                                        break;
                                    case 0b0111: // :0100000111
                                        // ROR Rd, Rs
                                        // Rd := Rd ROR Rs
                                        right &= 31;
                                        value = (int) ((left >>> right) |
                                                (left << (32 - right)));
                                        c = ((left >>> (right - 1)) & I0) != 0;
                                        REGS[Rd] = value;

                                        break;
                                    case 0b1000: // :0100001000
                                        // TST Rd, Rs
                                        // set condition codes on Rd AND Rs
                                        value = left & right;
                                        // only compare (no write)
                                        break;
                                    case 0b1001: // :0100001001
                                        // NEG Rd, Rs
                                        // Rd = -Rs
                                        lvalue = (((long) ~right) & 0xffffffffL) + 1L;
                                        value = (int) lvalue;
                                        REGS[Rd] = value;
                                        c = lvalue > 0xFFFFFFFFL;
                                        v = (right & value) < 0;
                                        break;
                                    case 0b1010: // :0100001010
                                        // CMP Rd, Rs
                                        // set condition codes on Rd - Rs
                                        lvalue = (((long) left) & 0xffffffffL) +
                                                (((long) ~right) & 0xffffffffL) + 1L;
                                        value = (int) lvalue;
                                        // only compare (no write)
                                        c = lvalue > 0xFFFFFFFFL;
                                        v = ((left ^ right) & (left ^ value)) < 0;
                                        break;
                                    case 0b1011: // :0100001011
                                        // CMN Rd, Rs
                                        // set condition codes on Rd + Rs
                                        lvalue = (((long) left) & 0xffffffffL) +
                                                (((long) right) & 0xffffffffL);
                                        value = (int) lvalue;
                                        // only compare (no write)
                                        c = lvalue > 0xFFFFFFFFL;
                                        v = ((left ^ value) & (right ^ value)) < 0;
                                        break;
                                    case 0b1100: // :0100001100
                                        // ORR Rd, Rs
                                        // Rd := Rd OR Rs
                                        value = left | right;
                                        REGS[Rd] = value;
                                        break;
                                    case 0b1101: // :0100001101
                                        // MUL Rd, Rs
                                        // Rd := Rs * Rd
                                        long svalue = (long) left * (long) right;
                                        value = left * right;
                                        REGS[Rd] = value;
                                        c |= value != svalue; // ???
                                        v = false; // svalue != value?
                                        break;
                                    case 0b1110: // :0100001110
                                        // BIC Rd, Rs
                                        // Rd := Rd AND NOT Rs
                                        value = left & ~right;
                                        REGS[Rd] = value;
                                        break;
                                    case 0b1111: // :0100001111
                                        // MVN Rd, Rs
                                        // Rd := NOT Rs
                                        value = ~right;
                                        REGS[Rd] = value;
                                        break;
                                    default:
                                        throw new UnexceptedLogicError();
                                }

                                n = value < 0;
                                z = value == 0;
                                break;
                            case 0b01: // :010001
                                // Format 5: Hi register operations/branch exchange
                                boolean H1 = ((code >> 7) & L1) != 0;
                                boolean H2 = ((code >> 6) & L1) != 0;
                                Rd = (code & L3) + (H1 ? 8 : 0);
                                Rs = ((code >> 3) & L3) + (H2 ? 8 : 0);

                                switch ((code >> 8) & L2)
                                {
                                    case 0b00: // :01000100
                                        // ADD Rd, Hs
                                        // ADD Hd, Rs
                                        // ADD Hd, Hs
                                        left = REGS[Rd];
                                        right = REGS[Rs];
                                        if (Rs == PC)
                                            right += 4;

                                        REGS[Rd] = left + right;
                                        // no write condition code flags
                                        break;
                                    case 0b01: // :01000101
                                        // CMP Rd, Hs
                                        // CMP Hd, Rs
                                        // CMP Hd, Hs
                                        left = REGS[Rd];
                                        right = REGS[Rs];
                                        lvalue = (((long) left) & 0xffffffffL) +
                                                (((long) ~right) & 0xffffffffL) + 1L;
                                        value = (int) lvalue;
                                        // only compare (no write)
                                        n = value < 0;
                                        z = value == 0;
                                        c = lvalue > 0xFFFFFFFFL;
                                        v = ((left ^ right) & (left ^ value)) < 0;
                                        break;
                                    case 0b10: // :01000110
                                        // MOV Rd, Hs
                                        // MOV Hd, Rs
                                        // MOV Hd, Hs
                                        value = REGS[Rs];
                                        if (Rd == PC)
                                            value -= 2;

                                        REGS[Rd] = value;
                                        break;
                                    case 0b11: // :01000111
                                        // BX Rs
                                        // BX Hs
                                        value = REGS[Rs];
                                        if ((value & I0) != 1)
                                            throw new UnknownInstructionException();

                                        if (H1)
                                            REGS[LR] = (REGS[PC] + 2) | I0;

                                        REGS[PC] = value & ~I0;
                                        increase_pc = false;
                                        break;
                                    default:
                                        throw new UnexceptedLogicError();
                                }

                                break;
                            case 0b10:
                            case 0b11: // :01001
                                // Format 6: PC-relative load
                                // LDR Rd, [PC, #Imm]
                                Rd = (code >> 8) & L3;
                                addr = (code & L8) << 2;
                                addr += (REGS[PC] + 4) & ~I1;

                                REGS[Rd] = memory.readInt(addr);
                                break;
                        }

                        break;
                    case 0b0101: // :0101
                        int Ro;
                        if ((code & I9) == 0) // :0101xx0
                        {
                            // Format 7: load/store with register offset
                            L = (code & I11) != 0;
                            B = (code & I10) != 0;
                            Ro = (code >> 6) & L3;
                            Rb = (code >> 3) & L3;
                            Rd = code & L3;
                            addr = REGS[Rb] + REGS[Ro];

                            if (L)
                            {
                                if (B) // :0101110
                                {
                                    // LDRB Rd, [Rb, Ro]
                                    REGS[Rd] = memory.readByte(addr) & 0xFF;
                                }
                                else // :0101100
                                {
                                    // LDR Rd, [Rb, Ro]
                                    REGS[Rd] = memory.readInt(addr);
                                }
                            }
                            else
                            {
                                if (B) // :0101010
                                {
                                    // STRB Rd, [Rb, Ro]
                                    memory.writeByte(addr, (byte) REGS[Rd]);
                                }
                                else // :0101000
                                {
                                    // STR Rd, [Rb, Ro]
                                    memory.writeInt(addr, REGS[Rd]);
                                }
                            }
                        }
                        else // :0101xx1
                        {
                            // Format 8: load/store sign-extended byte/halfword
                            H = (code & I11) != 0;
                            S = (code & I10) != 0;
                            Ro = (code >> 6) & L3;
                            Rb = (code >> 3) & L3;
                            Rd = code & L3;
                            addr = REGS[Rb] + REGS[Ro];

                            if (S)
                            {
                                if (H) // :0101111
                                {
                                    // LDSH Rd, [Rb, Ro]
                                    value = memory.readShort(addr);
                                }
                                else // :0101011
                                {
                                    // LDSB Rd, [Rb, Ro]
                                    value = memory.readByte(addr);
                                }

                                REGS[Rd] = value;
                            }
                            else
                            {
                                if (H) // :0101101
                                {
                                    // LDRH Rd, [Rb, Ro]
                                    value = memory.readShort(addr);
                                    REGS[Rd] = value;
                                }
                                else // :0101001
                                {
                                    // STRH Rd, [Rb, Ro]
                                    value = REGS[Rd];
                                    memory.writeShort(addr, (short) value);
                                }
                            }
                        }

                        break;
                    case 0b0110:
                    case 0b0111: // :011
                        // Format 9: load/store with immediate offset
                        B = (code & I12) != 0;
                        L = (code & I11) != 0;
                        Rb = (code >> 3) & L3;
                        Rd = code & L3;
                        value = (code >> 6) & L5;
                        if (!B)
                            value <<= 2;

                        addr = REGS[Rb] + value;

                        if (L)
                        {
                            if (!B) // :01111
                                // LDR Rd, [Rb, #Imm]
                                value = memory.readInt(addr);
                            else // :01101
                                // LDRB Rd, [Rb, #Imm]
                                value = memory.readByte(addr) & 0xFF;

                            REGS[Rd] = value;
                        }
                        else
                        {
                            value = REGS[Rd];

                            if (!B) // :01100
                                // STR Rd, [Rb, #Imm]
                                memory.writeInt(addr, value);
                            else // :01110
                                // STRB Rd, [Rb, #Imm]
                                memory.writeByte(addr, (byte) value);
                        }

                        break;
                    case 0b1000: // :1000x
                        // Format 10: load/store halfword
                        L = (code & I11) != 0;
                        Rb = (code >> 3) & L3;
                        Rd = code & L3;
                        value = ((code >> 6) & L5) << 1;
                        addr = REGS[Rb] + value;

                        if (L) // :10001
                            // LDRH Rd, [Rb, #Imm]
                            REGS[Rd] = memory.readShort(addr) & 0xFFFF;
                        else // :10000
                            // STRH Rd, [Rb, #Imm]
                            memory.writeShort(addr, (short) REGS[Rd]);

                        break;
                    case 0b1001: // :1001x
                        // Format 11: SP-relative load/store
                        L = (code & I11) != 0;
                        Rd = (code >> 8) & L3;
                        value = (code & L8) << 2;
                        addr = REGS[SP] + value;

                        if (L) // :10011
                            // LDR Rd, [SP, #Imm]
                            REGS[Rd] = memory.readInt(addr);
                        else // :10010
                            // STR Rd, [SP, #Imm]
                            memory.writeInt(addr, REGS[Rd]);

                        break;
                    case 0b1010: // :1010x
                        // Format 12: load address
                        boolean fSP = (code & I11) != 0;
                        Rd = (code >> 8) & L3;
                        value = (code & L8) << 2;

                        if (fSP) // :10101
                            // ADD Rd, SP, #Imm
                            value += REGS[SP];
                        else // :10100
                            // ADD Rd, PC, #Imm
                            value += (REGS[PC] + 4) & ~I1;

                        REGS[Rd] = value;
                        //  CPSR condition codes are unaffected
                        break;
                    case 0b1011: // :1011
                        boolean R;
                        switch ((code >> 8) & L4)
                        {
                            case 0b0000: // :10110000x
                                // Format 13: add offset to Stack Pointer

                                S = (code & I7) != 0;
                                value = (code & L7) << 2;

                                if (S) // :101100000
                                    // ADD SP, #-Imm
                                    REGS[SP] -= value;
                                else // :101100001
                                    // ADD SP, #Imm
                                    REGS[SP] += value;

                                // condition codes are not set
                                break;
                            case 0b0001: // :10110001
                                // CBZ Rd, #Imm
                                throw new UnsupportedInstructionException();
                            case 0b0010: // :10110010
                                // SXTH, SXTB, UXTH, UXTB
                                Rs = (code >> 3) & L3;
                                Rd = code & L3;
                                value = REGS[Rs];

                                switch ((code >> 6) & L2)
                                {
                                    case 0b00: // :1011001000
                                        // SXTH Rd, Rs
                                        value = (short) value;
                                        break;
                                    case 0b01: // :1011001001
                                        // SXTB Rd, Rs
                                        value = (byte) value;
                                        break;
                                    case 0b10: // :1011001010
                                        // UXTH Rd, Rs
                                        value = value & 0xFFFF;
                                        break;
                                    case 0b11: // :1011001011
                                        // UXTB Rd, Rs
                                        value = value & 0XFF;
                                        break;
                                    default:
                                        throw new UnexceptedLogicError();
                                }

                                REGS[Rd] = value;
                                break;
                            case 0b0011: // :10110011
                                // CBZ Rd, #Imm
                                throw new UnsupportedInstructionException();
                            case 0b0100:
                            case 0b0101: // :1011010x
                                // Format 14: push/pop registers
                                R = (code & I8) != 0;
                                list = code & L8;
                                addr = REGS[SP];

                                try
                                {
                                    if (R) // :10110101
                                    {
                                        // PUSH { ..., LR }
                                        addr -= 4;
                                        memory.writeInt(addr, REGS[LR]);
                                    }

                                    // PUSH { Rlist }
                                    for (int i = 7; i >= 0; i--)
                                    {
                                        if ((list & (1 << i)) != 0)
                                        {
                                            addr -= 4;
                                            memory.writeInt(addr, REGS[i]);
                                        }
                                    }
                                }
                                finally
                                {
                                    REGS[SP] = addr;
                                }

                                break;
                            case 0b0110: // :10110110
                            case 0b0111: // :10110111
                            case 0b1000: // :10111000
                                throw new UnknownInstructionException();
                            case 0b1001: // :10111001
                                // CBNZ Rd, #Imm
                                throw new UnsupportedInstructionException();
                            case 0b1010: // :10111010xx
                                Rs = (code >> 3) & L3;
                                Rd = code & L3;
                                value = REGS[Rs];

                                switch ((code >> 6) & L2)
                                {
                                    case 0b00: // :1011101000
                                        // REV Rd, Rs
                                        value = ((value >>> 24) & 0xFF) |
                                                ((value >>> 16) & 0xFF) << 8 |
                                                ((value >>> 8) & 0xFF) << 16 |
                                                ((value & 0xFF) << 24);
                                        break;
                                    case 0b01: // :1011101001
                                        // REV16 Rd, Rs
                                        throw new UnsupportedInstructionException();
                                    case 0b10: // :1011101010
                                        // INVALID
                                        throw new UnknownInstructionException();
                                    case 0b11: // :1011101011
                                        // REVSH Rd, Rs
                                        throw new UnsupportedInstructionException();
                                    default:
                                        throw new UnexceptedLogicError();
                                }

                                REGS[Rd] = value;
                                break;
                            case 0b1011: // :10111011
                                // CBNZ Rd, #Imm
                                throw new UnsupportedInstructionException();
                            case 0b1100:
                            case 0b1101: // :1011110x
                                // Format 14: push/pop registers
                                R = (code & I8) != 0;
                                list = code & L8;
                                addr = REGS[SP];

                                try
                                {
                                    // POP { Rlist }
                                    for (int i = 0; i < 8; i++)
                                    {
                                        if ((list & (1 << i)) != 0)
                                        {
                                            REGS[i] = memory.readInt(addr);
                                            addr += 4;
                                        }
                                    }

                                    if (R) // :10111101 {..., PC}
                                    {
                                        // POP { ..., PC }
                                        value = memory.readInt(addr);
                                        if ((value & I0) != 1)
                                            throw new InvalidAddressArmException();

                                        REGS[PC] = value & ~I0;
                                        addr += 4;
                                        increase_pc = false;
                                    }
                                }
                                finally
                                {
                                    REGS[SP] = addr;
                                }

                                break;
                            case 0b1110: // :10111110
                            case 0b1111: // :10111111
                                throw new UnknownInstructionException();
                            default:
                                throw new UnexceptedLogicError();
                        }

                        break;
                    case 0b1100: // :1100
                        // Format 15: multiple load/store
                        L = (code & I11) != 0;
                        list = code & L8;
                        Rb = (code >> 8) & L3;
                        addr = REGS[Rb];

                        try
                        {
                            if (!L) // :11001
                            {
                                // STMIA Rb!, { Rlist }
                                for (int i = 0; i < 8; i++)
                                    if ((list & (1 << i)) != 0)
                                    {
                                        memory.writeInt(addr, REGS[i]);
                                        addr += 4;
                                    }
                            }
                            else // :11000
                            {
                                // LDMIA Rb!, { Rlist }
                                for (int i = 0; i < 8; i++)
                                    if ((list & (1 << i)) != 0)
                                    {
                                        REGS[i] = memory.readInt(addr);
                                        addr += 4;
                                    }
                            }
                        }
                        finally
                        {
                            REGS[Rb] = addr;
                        }

                        break;
                    case 0b1101: // :1101
                        byte soffset = (byte) (code & L8);
                        boolean cond = false;

                        // Format 16: conditional branch
                        switch ((code >> 8) & L4)
                        {
                            case 0b0000: // :11010000
                                // BEQ label
                                cond = z;
                                break;
                            case 0b0001: // :11010001
                                // BNE label
                                cond = !z;
                                break;
                            case 0b0010: // :11010010
                                // BCS label
                                cond = c;
                                break;
                            case 0b0011: // :11010011
                                // BCC label
                                cond = !c;
                                break;
                            case 0b0100: // :11010100
                                // BMI label
                                cond = n;
                                break;
                            case 0b0101: // :11010101
                                // BPL label
                                cond = !n;
                                break;
                            case 0b0110: // :11010110
                                // BVS label
                                cond = v;
                                break;
                            case 0b0111: // :11010111
                                // BVC label
                                cond = !v;
                                break;
                            case 0b1000: // :11011000
                                // BHI label
                                cond = c && !z;
                                break;
                            case 0b1001: // :11011001
                                // BLS label
                                cond = !c || z;
                                break;
                            case 0b1010: // :11011010
                                // BGE label
                                cond = n == v;
                                // = (n && v) || (!n && !v)
                                break;
                            case 0b1011: // :11011011
                                // BLT label
                                cond = n != v;
                                // = (n && !v) || (!n && v)
                                break;
                            case 0b1100: // :11011100
                                // BGT label
                                cond = !z && n == v;
                                // = !z && (n && v || !n && !v)
                                break;
                            case 0b1101: // :11011101
                                // BLE label
                                cond = z || (n != v);
                                // = z || (n && !v) || (!n && v)
                                break;
                            case 0b1110: // :11011110
                                throw new UnknownInstructionException();
                            case 0b1111: // :11011111
                                // Format 17: software interrupt
                                // SWI Value8

                                REGS[CPSR] = (q ? FQ : 0) |
                                        (v ? FV : 0) |
                                        (c ? FC : 0) |
                                        (z ? FZ : 0) |
                                        (n ? FN : 0);

                                regs.store(REGS);
                                boolean stop = interruptHandler.invoke(soffset & 0xFF);
                                REGS = regs.load();
                                q = (REGS[CPSR] & FQ) != 0;
                                v = (REGS[CPSR] & FV) != 0;
                                c = (REGS[CPSR] & FC) != 0;
                                z = (REGS[CPSR] & FZ) != 0;
                                n = (REGS[CPSR] & FN) != 0;

                                if (stop) {
                                    REGS[PC] += 2;
                                    return;
                                }

                                break;
                        }

                        if (cond)
                        {
                            value = (soffset & L8) << 1;
                            if ((value & I8) != 0)
                            {
                                value |= ~L8;
                            }

                            REGS[PC] += 4 + value;
                            increase_pc = false;
                        }

                        break;
                    case 0b1110: // :11100
                        // Format 18: unconditional branch
                        if ((code & I11) != 0)
                            throw new UnknownInstructionException();

                        value = (code & L10) << 1;
                        if ((code & I10) != 0)
                        {
                            value |= ~L11;
                        }

                        REGS[PC] += 4 + value;
                        increase_pc = false;
                        break;
                    case 0b1111: // :1111
                        // Format 19: long branch with link
                        H = ((code >> 11) & L1) != 0;
                        value = code & L11;
                        if (!H)
                        {
                            REGS[LR] = value << 12;
                            count++;
                        }
                        else
                        {
                            addr = REGS[LR];
                            addr |= value << 1;
                            if ((addr & (1 << 22)) != 0)
                                addr |= ~0b11111111111111111111111;

                            int lr = REGS[PC];
                            REGS[PC] = lr + addr + 2;
                            REGS[LR] = lr + 3;
                            increase_pc = false;
                        }

                        break;
                    default:
                        throw new UnknownInstructionException();
                }

                if (increase_pc)
                    REGS[PC] += 2;
            }
        }
        finally
        {
            REGS[CPSR] = (q ? FQ : 0) |
                    (v ? FV : 0) |
                    (c ? FC : 0) |
                    (z ? FZ : 0) |
                    (n ? FN : 0);

            regs.store(REGS);
            executedCount += totalCount - count;
        }
    }
}
