package kr.pe.ecmaxp.openpie.arch.types.call

import li.cil.oc.api.machine.LimitReachedException
import li.cil.oc.api.machine.Machine
import li.cil.oc.api.machine.Value
import java.util.*

class ValueInvoke(val value: Value, val function: String, vararg args: Any?) {
    val args: Array<*> = args

    override fun toString(): String {
        return "ValueInvoke(value='$value', function='$function', args=${Arrays.toString(args)})"
    }

    @Throws(LimitReachedException::class)
    operator fun invoke(machine: Machine): InvokeResult {
        return try {
            InvokeResult(machine.invoke(value, function, args))
        } catch (e: LimitReachedException) {
            throw e
        } catch (e: Error) {
            InvokeResult(error = e)
        } catch (e: Exception) {
            InvokeResult(error = e)
        }
    }

    companion object {
        fun fromArray(array: Array<*>): ValueInvoke? {
            if (array.size < 2)
                return null

            val args = arrayOfNulls<Any?>(array.size - 2)
            System.arraycopy(array, 2, args, 0, args.size)

            return ValueInvoke(array[0] as Value, array[1] as String, *args)
        }
    }
}
