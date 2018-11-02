package kr.pe.ecmaxp.openpython.arch.versions.v1

import kr.pe.ecmaxp.openpython.OpenPythonVirtualMachine
import kr.pe.ecmaxp.openpython.arch.msgpack.Msgpack
import kr.pe.ecmaxp.openpython.arch.types.call.InvokeResult
import kr.pe.ecmaxp.openpython.arch.types.interrupt.Interrupt
import kr.pe.ecmaxp.thumbsf.CPU
import kr.pe.ecmaxp.thumbsf.Memory
import kr.pe.ecmaxp.thumbsf.consts.*

class OpenPythonInterruptV1(val cpu: CPU, imm: Int, val vm: OpenPythonVirtualMachine? = null) : Interrupt {
    val imm: Int
    val r0: Int
    val r1: Int
    val r2: Int
    val r3: Int
    val r4: Int

    init {
        assert(imm == 0)
        this.imm = cpu.regs[R7]
        this.r0 = cpu.regs[R0]
        this.r1 = cpu.regs[R1]
        this.r2 = cpu.regs[R2]
        this.r3 = cpu.regs[R3]
        this.r4 = cpu.regs[R4]
    }

    val memory: Memory get() = cpu.memory

    override fun readBuffer(): ByteArray = readBuffer(r0, r1)
    override fun readBuffer(address: Int, size: Int): ByteArray = memory.readBuffer(address, size)

    override fun readString(): String? = readString(r0, r1)
    override fun readString(address: Int, maxSize: Int): String = memory.readString(address, maxSize)

    override fun readObject(): Any? = Msgpack(vm).loads(readBuffer())

    override fun responseNone(): Int = 0

    override fun responseError(value: Throwable): Int {
        val bufAddress = OpenPythonMemoryRegionV1.SYSCALL.address
        val buffer = Msgpack(vm).dumps(value)
        memory.writeInt(bufAddress, 0) // + 0 | 1 = OK (msgpack)
        memory.writeInt(bufAddress + 4, bufAddress + 12) // + 4
        memory.writeInt(bufAddress + 8, buffer.size) // + 8
        memory.writeBuffer(bufAddress + 12, buffer) // + 12
        return bufAddress
    }

    override fun responseValue(value: Any?): Int {
        if (value == null)
            return responseNone()

        val bufAddress = OpenPythonMemoryRegionV1.SYSCALL.address
        val buffer = Msgpack(vm).dumps(value)
        memory.writeInt(bufAddress, 1) // + 0 = OK (msgpack)
        memory.writeInt(bufAddress + 4, bufAddress + 12) // + 4
        memory.writeInt(bufAddress + 8, buffer.size) // + 8
        memory.writeBuffer(bufAddress + 12, buffer) // + 12
        return bufAddress
    }

    override fun responseBuffer(buffer: ByteArray): Int {
        val bufAddress = OpenPythonMemoryRegionV1.SYSCALL.address
        memory.writeInt(bufAddress, bufAddress + 8) // + 0 | 0 = ERROR
        memory.writeInt(bufAddress + 4, buffer.size) // + 4
        memory.writeBuffer(bufAddress + 8, buffer) // + 8
        memory.writeByte(bufAddress + 8 + buffer.size, 0.toByte()) // + 8 + n
        return bufAddress
    }

    override fun responseResult(ret: InvokeResult): Int {
        return if (ret.error == null) responseValue(ret.args) else responseError(ret.error)
    }
}
