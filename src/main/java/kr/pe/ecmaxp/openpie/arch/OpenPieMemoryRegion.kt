package kr.pe.ecmaxp.openpie.arch

import kr.pe.ecmaxp.thumbsf.MemoryFlag
import kr.pe.ecmaxp.thumbsf.MemoryFlag.*

const val KB = 1024

enum class OpenPieMemoryRegion(val address: Long, val size: Int, val flag: MemoryFlag) {
    FLASH(0x08000000L, 256 * KB, RX),
    SRAM(0x20000000L, 64 * KB, RW),
    PERIPHERAL(0x40000000L, 4 * KB, HOOK),
    RAM(0x60000000L, 192 * KB, RW),
    SYSCALL(0xE0000000L, 16 * KB, RW),
    EXTERNAL_STACK(0xE1000000L, 2 * KB, RW)
}
