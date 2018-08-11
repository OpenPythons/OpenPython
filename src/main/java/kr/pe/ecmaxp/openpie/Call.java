package kr.pe.ecmaxp.openpie;

import li.cil.oc.api.machine.Machine;

import java.util.Arrays;

public class Call
{
    private final String component;
    private final String function;
    private final Object[] args;
    private Object[] result;
    private Exception exception;

    public Call(String component, String function, Object ... args)
    {
        this.component = component;
        this.function = function;
        this.args = args;
    }

    public String getComponent()
    {
        return component;
    }

    public String getFunction()
    {
        return function;
    }

    public Object[] getArguments()
    {
        return args;
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

    public Result invoke(Machine machine)
    {
        try
        {
            Object[] result = machine.invoke(getComponent(), getFunction(), getArguments());
            return new Result(this, result);
        }
        catch (Exception e)
        {
            return new Result(this, e);
        }
    }
}
