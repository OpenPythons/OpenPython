package kr.pe.ecmaxp.openpie.arch.state

import kr.pe.ecmaxp.openpie.arch.types.Call

class FileHandle(val address: String, val handle: Int) {
    var pos = 0

    fun call(func: String, vararg args: Any): Call = Call(this.address, func, this.handle, *args)

    override fun toString(): String {
        return "FileHandle(address='$address', handle=$handle, pos=$pos)"
    }
}
