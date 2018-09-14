package kr.pe.ecmaxp.openpie

enum class OpenPieMemoryRegion private constructor(val address: Long, val size: Long, val perms: Int) {
    FLASH(0x08000000, 0x100000, 0),
    SRAM(0x20000000, 0x80000, 0),
    STACK(0x3FFF0000, 0x10000, 0),
    PERIPHERAL(0x40000000, 0x10000, 0),
    SYSCALL_BUFFER(-0x20000000, 0x10000, 0)
}
