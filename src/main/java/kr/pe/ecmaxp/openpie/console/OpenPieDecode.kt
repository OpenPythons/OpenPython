package kr.pe.ecmaxp.openpie.console

import kr.pe.ecmaxp.openpie.arch.Firmware
import kr.pe.ecmaxp.openpie.arch.OpenPieMemoryRegion
import kr.pe.ecmaxp.thumbsf.Memory
import kr.pe.ecmaxp.thumbsf.consts.op2str

object OpenPieDecode {
    @JvmStatic
    fun main(args: Array<String>) {
        val memory = Memory();
        val firmware = Firmware().loadFirmware();
        memory.flash(OpenPieMemoryRegion.FLASH.address, 256 * 1024, firmware);
        val (cache, base) = memory.loadExecCache(OpenPieMemoryRegion.FLASH.address);
        for (i in 0 until firmware.size step 2) {
            show(cache[i], cache[i + 1])
        }
    }
}


fun show(code: Int, imm32: Int) {
    val op = code and 0xFF
    val Rd = code shr 8 and 0b1111
    val Rs = code shr 12 and 0b1111
    val Rn = code shr 16 and 0b1111
    val imm16 = code shr 16
    println("${op2str(op)}\tRd=$Rd\tRs=$Rs\tRn=$Rn\timm16=$imm16\timm32=$imm32")
}