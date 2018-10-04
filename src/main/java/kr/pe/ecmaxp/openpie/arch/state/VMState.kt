package kr.pe.ecmaxp.openpie.arch.state

import kr.pe.ecmaxp.openpie.arch.types.Interrupt
import li.cil.oc.api.machine.Signal
import java.util.*

class VMState {
    var redirectKeyEvent = true
    var lastInterrupt: Interrupt? = null
    var fdCount = 3
    var fdMap: HashMap<Int, FileHandle> = HashMap()
    val signals: LinkedList<Signal> = LinkedList()
    val inputBuffer: LinkedList<Char> = LinkedList()
    var outputBuffer: StringBuilder = StringBuilder()
}
