package kr.pe.ecmaxp.openpie.arch.state

import kr.pe.ecmaxp.openpie.arch.types.components.ComponentInvoke

class FileHandle(val address: String, val handle: Int, var pos: Int = 0) {
    operator fun invoke(func: String, vararg args: Any): ComponentInvoke = ComponentInvoke(this.address, func, this.handle, *args)

    override fun toString(): String {
        return "FileHandle(address='$address', handle=$handle, pos=$pos)"
    }
}
