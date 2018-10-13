package kr.pe.ecmaxp.openpie.arch.types.call

import li.cil.oc.api.machine.LimitReachedException
import li.cil.oc.api.machine.Machine
import java.util.*

class ComponentInvoke(val component: String, val function: String, vararg args: Any?) {
    val args: Array<*> = args

    override fun toString(): String {
        return "ComponentInvoke(component='$component', function='$function', args=${Arrays.toString(args)})"
    }

    @Throws(LimitReachedException::class)
    operator fun invoke(machine: Machine): InvokeResult {
        return try {
            InvokeResult(machine.invoke(component, function, args))
        } catch (e: LimitReachedException) {
            throw e
        } catch (e: Error) {
            InvokeResult(error = e)
        } catch (e: Exception) {
            InvokeResult(error = e)
        }
    }

    companion object {
        fun fromArray(array: Array<*>): ComponentInvoke? {
            if (array.size < 2)
                return null

            val args = arrayOfNulls<Any?>(array.size - 2)
            System.arraycopy(array, 2, args, 0, args.size)

            return ComponentInvoke(array[0] as String, array[1] as String, *args)
        }
    }
}
