package kr.pe.ecmaxp.openpython.arch

import kr.pe.ecmaxp.openpython.OpenPython
import kr.pe.ecmaxp.openpython.arch.types.Entry
import kr.pe.ecmaxp.thumbsf.CPU
import java.net.URL
import java.util.*

class OpenPythonFirmware(val name: String) {
    val protocol = 1
    private val path: String = "/assets/${OpenPython.MODID}/firmwares/$name"

    companion object {
        val v1_0_0 = OpenPythonFirmware("v1.0.0")
    }

    init {
        if (name.indexOf('/') >= 0)
            throw Exception("Invalid Filename")

        getResource("firmware.bin")
    }

    private fun getResource(filename: String): URL {
        return OpenPythonFirmware::class.java.getResource("$path/$filename")!!
    }

    fun loadFirmware(): ByteArray {
        val firmware = getResource("firmware.bin")
        return firmware.readBytes()
    }

    fun loadEEPROM(): ByteArray {
        val eeprom = getResource("eeprom.py")
        return eeprom.readBytes()
    }

    fun loadMapping(): List<Entry> {
        val file = getResource("firmware.map")
        val lines = file.readText().lines()
        val result = ArrayList<Entry>()

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
            val target = Entry(address, size, type, name)
            result.add(target)
        }

        return result
    }

    fun findTarget(address: Int): Entry? {
        val mapping = loadMapping()
        var selected: Entry? = null
        for (target in mapping.reversed()) {
            if (target.address <= address) { //  && address < target.address + target.size
                selected = target
                break;
            }
        }

        return selected
    }

    fun printLastTracebackCPU(cpu: CPU) {
        var selected = findTarget(cpu.regs.pc)
        if (selected != null) {
            print("PC: ${selected.name} (+${cpu.regs.pc - selected.address})\t")
        } else {
            print("PC: (null) (${cpu.regs.pc})\t")
        }

        selected = findTarget(cpu.regs.lr)
        if (selected != null) {
            print("LR:${selected.name} (+${cpu.regs.lr - selected.address})")
        } else {
            print("LR: (null) (${cpu.regs.lr})")
        }

        print('\n')
    }
}
