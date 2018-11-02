package kr.pe.ecmaxp.openpython

import kr.pe.ecmaxp.openpython.repack.org.msgpack.core.MessagePacker
import kr.pe.ecmaxp.openpython.repack.org.msgpack.core.MessageUnpacker
import li.cil.oc.api.Persistable
import li.cil.oc.api.machine.ExecutionResult
import li.cil.oc.api.machine.Value

interface OpenPythonVirtualMachine : Persistable {
    val memorySize: Int

    fun close()
    fun step(synchronized: Boolean): ExecutionResult

    fun unpackExtension(unpacker: MessageUnpacker): Any?
    fun packValue(packer: MessagePacker, value: Value)
}
