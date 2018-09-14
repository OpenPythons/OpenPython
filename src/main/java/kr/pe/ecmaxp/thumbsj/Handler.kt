package kr.pe.ecmaxp.thumbsj

class Handler : MemoryHook {

    override fun Invoke(address: Long, read: Boolean, size: Int, value: Int): Int {
        var value = value
        if (read) {
            when (address.toInt()) {
                OP_IO_TXR -> {
                }
                OP_IO_RXR -> value = 0 // getChar();
                OP_CON_PENDING, OP_CON_EXCEPTION, OP_CON_INTR_CHAR -> {
                }
                OP_CON_RAM_SIZE -> value = 0x80000
                OP_CON_IDLE, OP_CON_INSNS, OP_RTC_TICKS_MS -> {
                }
                else -> System.out.printf("failure: %x, %d, %d\n", address, size, value)
            }
        } else {
            when (address.toInt()) {
                OP_IO_TXR -> println("console: " + value.toChar())
                OP_IO_RXR, OP_CON_PENDING, OP_CON_EXCEPTION, OP_CON_INTR_CHAR, OP_CON_RAM_SIZE, OP_CON_IDLE, OP_CON_INSNS, OP_RTC_TICKS_MS -> {
                }
                else -> System.out.printf("failure: %x, %d, %d\n", address, size, value)
            }
        }


        return value
    }

    companion object {
        val OP_IO_TXR = 0x40000000
        val OP_IO_RXR = 0x40000004
        val OP_IO_REDIRECT = 0x40000008
        val OP_IO_TXB = 0x4000000c
        val OP_IO_RXB = 0x40000010
        val OP_CON_PENDING = 0x40000100
        val OP_CON_EXCEPTION = 0x40000104
        val OP_CON_INTR_CHAR = 0x40000108
        val OP_CON_RAM_SIZE = 0x4000010c
        val OP_CON_IDLE = 0x40000110
        val OP_CON_INSNS = 0x40000114
        val OP_RTC_TICKS_MS = 0x40000200
    }
}
