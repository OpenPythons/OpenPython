package kr.pe.ecmaxp.openpie.arch

import kr.pe.ecmaxp.openpie.OpenPie
import kr.pe.ecmaxp.thumbsf.CPU
import java.io.File
import java.io.IOException
import java.net.URL
import java.util.*

class Target(val address: Int, val size: Int, val type: String, val name: String)

val FirmwareFolder = URL("file:///C:/Users/EcmaXp/Dropbox/Projects/OpenPie/opmod/src/main/resources/assets/openpie/firmwares/debug")

class Firmware(val name: String = "debug") {
    val protocol = 1
    private val path: String = "/assets/${OpenPie.MODID}/firmwares/$name"

    companion object {
        val DEBUG = Firmware()
    }

    init {
        if (name.indexOf('/') >= 0)
            throw Exception("Invalid Filename")

        getResource("firmware.bin")
    }

    private fun getDebugResource(filename: String): URL {
        return URL("${FirmwareFolder.toExternalForm()}/$filename")
    }

    internal fun getDebugLastModifiedTime(): Long? {
        val url = getDebugResource("firmware.bin")
        try {
            val file = File(url.file)
            return file.lastModified()
        } catch (ignored: IOException) {
            return null
        }
    }

    private fun getResource(filename: String): URL {
        if (true)
            return getDebugResource(filename)

        return Firmware::class.java.getResource("$path/$filename")!!
    }

    fun loadFirmware(): ByteArray {
        val firmware = getResource("firmware.bin")
        return firmware.readBytes()
    }

    fun loadMapping(): List<Target> {
        val file = getResource("firmware.map")
        val lines = file.readText().lines()
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