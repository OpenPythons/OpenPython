package kr.pe.ecmaxp.openpie.arch.types.call

import li.cil.oc.api.machine.Machine
import li.cil.oc.api.machine.Value

class ValueApply(value: Value, vararg args: Any?) : ValueInvokeable(value, *args) {
    override operator fun invoke(machine: Machine): InvokeResult {
        return try {
            InvokeResult(args = arrayOf(value.apply(machine, this.args)))
        } catch (e: Error) {
            InvokeResult(error = e)
        } catch (e: Exception) {
            InvokeResult(error = e)
        }
    }

    companion object {
        fun fromArray(array: Array<*>): ValueApply? {
            if (array.size < 1)
                return null

            val args = arrayOfNulls<Any?>(array.size - 1)
            System.arraycopy(array, 1, args, 0, args.size)

            return ValueApply(array[0] as Value, *args)
        }
    }
}
