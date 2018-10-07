package kr.pe.ecmaxp.openpie.arch

import kr.pe.ecmaxp.openpie.OpenPieFilePaths
import kr.pe.ecmaxp.thumbsf.CPU
import java.io.File
import java.nio.file.Files
import java.util.*

class Target(val address: Int, val size: Int, val type: String, val name: String)

class Firmware(val version: String = "debug") {
    fun loadFirmware(): ByteArray {
        val file = File(OpenPieFilePaths.FirmwareFile)
        return Files.readAllBytes(file.toPath())
    }

    fun loadMapping(): List<Target> {
        val file = File(OpenPieFilePaths.MapFile)
        val lines = Files.readAllLines(file.toPath())
        val result = ArrayList<Target>()

        fun parseHex(s: String): Int {
            if (!s.startsWith("0x"))
                throw Exception("Invalid Map File (0x)")

            return s.substring(2).toInt(16)
        }

        for (line in lines) {
            if (line.isEmpty())
                continue;

            val tokens = line.split('\t')
            if (tokens.size != 4)
                throw Exception("Invalid Map File")

            val address = parseHex(tokens[0])
            val size = parseHex(tokens[1])
            val type = tokens[2]
            val name = tokens[3]
            val target = Target(address, size, type, name)
            result.add(target)
        }

        return result
    }


    fun findTarget(address: Int): Target? {
        val mapping = loadMapping()
        var selected: Target? = null
        for (target in mapping) {
            if (target.address <= address && address < target.address + target.size) {
                selected = target
            }
        }

        return selected
    }

    fun printLastTracebackCPU(cpu: CPU) {
        var selected = findTarget(cpu.regs.pc)
        if (selected != null) {
            println("last pc function :${selected.name} (+${cpu.regs.pc - selected.address})")
        } else {
            println("last pc function : (null)")
        }

        selected = findTarget(cpu.regs.lr)
        if (selected != null) {
            println("last lr function :${selected.name} (+${cpu.regs.lr - selected.address})")
        } else {
            println("last lr function : (null)")
        }
    }
}