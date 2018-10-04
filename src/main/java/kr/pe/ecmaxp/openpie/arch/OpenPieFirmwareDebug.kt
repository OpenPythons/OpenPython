package kr.pe.ecmaxp.openpie.arch

import com.mojang.realmsclient.util.Pair
import kr.pe.ecmaxp.openpie.OpenPieFilePaths
import kr.pe.ecmaxp.thumbsf.CPU
import kr.pe.ecmaxp.thumbsf.consts.LR
import kr.pe.ecmaxp.thumbsf.consts.PC
import java.io.File
import java.nio.file.Files
import java.util.*

fun loadFirmware(): ByteArray {
    val file = File(OpenPieFilePaths.FirmwareFile)
    return Files.readAllBytes(file.toPath())
}

fun loadMapping(): List<Pair<Long, String>> {
    val file = File(OpenPieFilePaths.MapFile)
    val lines = Files.readAllLines(file.toPath())
    val result = ArrayList<Pair<Long, String>>()

    var last_name: String? = null
    for (line in lines) {
        val tokens = line.trim { it <= ' ' }.split("\\s+".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()
        var last_pair: Pair<Long, String>?
        if (tokens.size >= 1) {
            if (tokens[0].startsWith(".text")) {
                last_name = tokens[0]
            } else if (tokens[0].startsWith("0x")) {
                val addr = java.lang.Long.parseLong(tokens[0].substring(2), 16)
                if (tokens.size == 2) {
                    last_pair = Pair.of(addr, tokens[1])
                    result.add(last_pair)
                } else if (last_name != null) {
                    last_pair = Pair.of(addr, last_name)
                    result.add(last_pair)
                }
            } else {
                last_name = null
            }
        }
    }

    return result
}

fun printLastTracebackCPU(cpu: CPU) {
    val pc = Integer.toUnsignedLong(cpu.regs.get(PC))
    val mapping = loadMapping()
    var selected: Pair<Long, String>? = null
    var found = false
    for (pair in mapping) {
        val addr = pair.first()
        if (addr > pc) {
            found = true
            break
        }

        selected = pair
    }

    if (found && selected != null) {
        println("last function :" + selected.second() + " (+" + java.lang.Long.toString(pc - selected.first()) + ")")
    } else {
        println("last function : (null)")
    }

    val lr = Integer.toUnsignedLong(cpu.regs.get(LR))
    selected = null
    found = false
    for (pair in mapping) {
        val addr = pair.first()
        if (addr > lr) {
            found = true
            break
        }

        selected = pair
    }

    if (found && selected != null) {
        println("last function :" + selected.second() + " (+" + java.lang.Long.toString(lr - selected.first()) + ")")
    } else {
        println("last function : (null)")
    }
}