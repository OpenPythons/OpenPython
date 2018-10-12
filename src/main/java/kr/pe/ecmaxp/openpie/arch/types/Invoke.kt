package kr.pe.ecmaxp.openpie.arch.types

import li.cil.oc.api.machine.LimitReachedException
import li.cil.oc.api.machine.Machine
import java.util.*

class Invoke(val component: String, val function: String, vararg args: Any?) {
    val args: Array<*> = args

    override fun toString(): String {
        return "Invoke(component='$component', function='$function', args=${Arrays.toString(args)})"
    }

    @Throws(LimitReachedException::class)
    operator fun invoke(machine: Machine): Result {
        return try {
            val result = machine.invoke(component, function, args)
            Result(this, result, null)
        } catch (e: LimitReachedException) {
            throw e
        } catch (e: Error) {
            Result(this, null, e)
        } catch (e: Exception) {
            Result(this, null, e)
        }
    }

    companion object {
        fun fromArray(array: Array<*>): Invoke? {
            if (array.size < 2)
                return null

            val args = arrayOfNulls<Any?>(array.size - 2)
            System.arraycopy(array, 2, args, 0, args.size)

            return Invoke(array[0] as String, array[1] as String, *args)
        }
    }
}
