package kr.pe.ecmaxp.openpython.arch.types.call

import li.cil.oc.api.machine.LimitReachedException
import li.cil.oc.api.machine.Machine
import li.cil.oc.api.machine.Value

abstract class ValueInvokeable(val value: Value, vararg args: Any?) {
    val args: ArgumentsImpl = ArgumentsImpl(args)

    override fun toString(): String {
        return "${this.javaClass.simpleName}(value='$value', args=${args})"
    }

    @Throws(LimitReachedException::class)
    abstract operator fun invoke(machine: Machine): InvokeResult
}
