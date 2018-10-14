package kr.pe.ecmaxp.openpie.arch.types.call

import li.cil.oc.api.machine.Machine
import li.cil.oc.api.machine.Value

class ValueUnapply(value: Value, vararg args: Any?) : ValueInvokeable(value, *args) {
    override operator fun invoke(machine: Machine): InvokeResult {
        return try {
            value.unapply(machine, this.args)
            InvokeResult(args = arrayOf())
        } catch (e: Error) {
            InvokeResult(error = e)
        } catch (e: Exception) {
            InvokeResult(error = e)
        }
    }

    companion object {
        fun fromArray(array: Array<*>): ValueUnapply? {
            if (array.isEmpty())
                return null

            val args = arrayOfNulls<Any?>(array.size - 1)
            System.arraycopy(array, 1, args, 0, args.size)

            return ValueUnapply(array[0] as Value, *args)
        }
    }
}
