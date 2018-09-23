package kr.pe.ecmaxp.thumbsf.consts

import kr.pe.ecmaxp.thumbsf.exc.UnknownInstructionException

const val NULL = 0
const val NOP = 1
const val LSLSI = 2
const val LSRSI = 3
const val ASRSI = 4
const val ADD3S = 5
const val ADD3SI = 6
const val SUB3S = 7
const val SUB3SI = 8
const val MOVSI = 9
const val CMPI = 10
const val ADDSI = 11
const val SUBSI = 12
const val ANDS = 13
const val EORS = 14
const val LSLS = 15
const val LSRS = 16
const val ASRS = 17
const val ADCS = 18
const val SBCS = 19
const val RORS = 20
const val TSTS = 21
const val RSBS = 22
const val CMP = 23
const val CMN = 24
const val ORRS = 25
const val MULS = 26
const val BICS = 27
const val MVNS = 28
const val ADD = 29
const val ADDX = 30
const val CMPX = 31
const val MOV = 32
const val MOVX = 33
const val BX = 34
const val BLX = 35
const val MOVI = 36
const val STR = 37
const val STRB = 38
const val LDR = 39
const val LDRB = 40
const val STRH = 41
const val LDRH = 42
const val LDSB = 43
const val LDSH = 44
const val STRI = 45
const val STRBI = 46
const val LDRI = 47
const val LDRBI = 48
const val STRHI = 49
const val LDRHI = 50
const val STRSPI = 51
const val LDRSPI = 52
const val ADDXI = 53
const val ADDSPI = 54
const val PUSH = 55
const val PUSHR = 56
const val POP = 57
const val POPR = 58
const val STMIA = 59
const val LDMIA = 60
const val BEQ = 61
const val BNE = 62
const val BCS = 63
const val BCC = 64
const val BMI = 65
const val BPL = 66
const val BVS = 67
const val BVC = 68
const val BHI = 69
const val BLS = 70
const val BGE = 71
const val BLT = 72
const val BGT = 73
const val BLE = 74
const val SVC = 75
const val B = 76
const val BL = 77
const val SXTH = 78
const val SXTB = 79
const val UXTH = 80
const val UXTB = 81
const val REV = 82
const val ERROR = 83


fun op2str(op: Int): String {
    return when (op) {
        NOP -> "NOP"
        LSLSI -> "LSLSI"
        LSRSI -> "LSRSI"
        ASRSI -> "ASRSI"
        ADD3S -> "ADD3S"
        ADD3SI -> "ADD3SI"
        SUB3S -> "SUB3S"
        SUB3SI -> "SUB3SI"
        MOVSI -> "MOVSI"
        CMPI -> "CMPI"
        ADDSI -> "ADDSI"
        SUBSI -> "SUBSI"
        ANDS -> "ANDS"
        EORS -> "EORS"
        LSLS -> "LSLS"
        LSRS -> "LSRS"
        ASRS -> "ASRS"
        ADCS -> "ADCS"
        SBCS -> "SBCS"
        RORS -> "RORS"
        TSTS -> "TSTS"
        RSBS -> "RSBS"
        CMP -> "CMP"
        CMN -> "CMN"
        ORRS -> "ORRS"
        MULS -> "MULS"
        BICS -> "BICS"
        MVNS -> "MVNS"
        ADD -> "ADD"
        ADDX -> "ADDX"
        CMPX -> "CMPX"
        MOV -> "MOV"
        MOVX -> "MOVX"
        BX -> "BX"
        BLX -> "BLX"
        MOVI -> "MOVI"
        STR -> "STR"
        STRB -> "STRB"
        LDR -> "LDR"
        LDRB -> "LDRB"
        STRH -> "STRH"
        LDRH -> "LDRH"
        LDSB -> "LDSB"
        LDSH -> "LDSH"
        STRI -> "STRI"
        STRBI -> "STRBI"
        LDRI -> "LDRI"
        LDRBI -> "LDRBI"
        STRHI -> "STRHI"
        LDRHI -> "LDRHI"
        STRSPI -> "STRSPI"
        LDRSPI -> "LDRSPI"
        ADDXI -> "ADDXI"
        ADDSPI -> "ADDSPI"
        PUSH -> "PUSH"
        PUSHR -> "PUSHR"
        POP -> "POP"
        POPR -> "POPR"
        STMIA -> "STMIA"
        LDMIA -> "LDMIA"
        BEQ -> "BEQ"
        BNE -> "BNE"
        BCS -> "BCS"
        BCC -> "BCC"
        BMI -> "BMI"
        BPL -> "BPL"
        BVS -> "BVS"
        BVC -> "BVC"
        BHI -> "BHI"
        BLS -> "BLS"
        BGE -> "BGE"
        BLT -> "BLT"
        BGT -> "BGT"
        BLE -> "BLE"
        SVC -> "SVC"
        B -> "B"
        BL -> "BL"
        SXTH -> "SXTH"
        SXTB -> "SXTB"
        UXTH -> "UXTH"
        UXTB -> "UXTB"
        REV -> "REV"
        ERROR -> "ERROR"
        else -> throw UnknownInstructionException()
    }
}
