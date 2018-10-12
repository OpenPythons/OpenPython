package kr.pe.ecmaxp.openpie.arch.state

import kr.pe.ecmaxp.openpie.arch.types.Invoke

class FileHandle(val address: String, val handle: Int, var pos: Int = 0) {
    fun call(func: String, vararg args: Any): Invoke = Invoke(this.address, func, this.handle, *args)

    override fun toString(): String {
        return "FileHandle(address='$address', handle=$handle, pos=$pos)"
    }
}
