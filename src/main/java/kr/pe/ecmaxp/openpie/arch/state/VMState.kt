package kr.pe.ecmaxp.openpie.arch.state

import java.util.*

class VMState {
    // TODO: component and method?
    var fdCount = 3
    var fdMap: HashMap<Int, FileHandle> = HashMap()
}
