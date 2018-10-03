package kr.pe.ecmaxp.openpie.arch.types

import li.cil.oc.api.machine.LimitReachedException
import li.cil.oc.api.machine.Machine
import java.util.*

class Call(val component: String, val function: String, vararg args: Any?) {
    val args: Array<*> = args

    override fun toString(): String {
        return "Call{" +
                "component='" + component + '\''.toString() +
                ", function='" + function + '\''.toString() +
                ", args=" + Arrays.toString(args) +
                '}'.toString()
    }

    @Throws(LimitReachedException::class)
    operator fun invoke(machine: Machine): Result {
        try {
            val result = machine.invoke(component, function, args)
            return Result(this, result)
        } catch (e: LimitReachedException) {
            throw e
        } catch (e: Error) {
            return Result(this, e)
        } catch (e: Exception) {
            return Result(this, e)
        }
    }

    companion object {
        fun FromObjectArray(array: Array<*>): Call? {
            if (array.size < 2)
                return null

            val args = arrayOfNulls<Any?>(array.size - 2)
            System.arraycopy(array, 2, args, 0, args.size)

            return Call(array[0] as String, array[1] as String, *args)
        }
    }
}
