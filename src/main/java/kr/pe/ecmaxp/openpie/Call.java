package kr.pe.ecmaxp.openpie;

import li.cil.oc.api.machine.LimitReachedException;
import li.cil.oc.api.machine.Machine;

import java.util.Arrays;

public class Call
{
    public final String component;
    public final String function;
    public final Object[] args;

    public Call(String component, String function, Object... args)
    {
        this.component = component;
        this.function = function;
        this.args = args;
    }

    public static Call FromObjectArray(Object[] array)
    {
        if (array.length < 2)
            return null;

        Object[] args = new Object[array.length - 2];
        System.arraycopy(array, 2, args, 0, args.length);

        return new Call((String) array[0], (String) array[1], args);
    }

    @Override
    public String toString()
    {
        return "Call{" +
                "component='" + component + '\'' +
                ", function='" + function + '\'' +
                ", args=" + Arrays.toString(args) +
                '}';
    }

    public Result invoke(Machine machine) throws LimitReachedException
    {
        try
        {
            Object[] result = machine.invoke(component, function, args);
            return new Result(this, result);
        }
        catch (LimitReachedException e)
        {
            throw e;
        }
        catch (Error e)
        {
            return new Result(this, e);
        }
        catch (Exception e)
        {
            return new Result(this, e);
        }
    }
}
