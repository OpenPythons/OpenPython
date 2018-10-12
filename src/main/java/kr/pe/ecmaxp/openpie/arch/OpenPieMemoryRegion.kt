package kr.pe.ecmaxp.openpie.arch

import kr.pe.ecmaxp.thumbsf.MemoryFlag
import kr.pe.ecmaxp.thumbsf.MemoryFlag.RW
import kr.pe.ecmaxp.thumbsf.MemoryFlag.RX

const val KB = 1024

enum class OpenPieMemoryRegion(val address: Int, val size: Int, val flag: MemoryFlag) {
    FLASH(0x08000000, 256 * KB, RX),
    SRAM(0x20000000, 64 * KB, RW),
    RAM(0x60000000, 256 * KB, RW), // dynamic size
    SYSCALL(0xE0000000.toInt(), 16 * KB, RW)
}
