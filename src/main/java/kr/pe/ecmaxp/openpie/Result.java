package kr.pe.ecmaxp.openpie;

import java.rmi.server.ExportException;

public class Result
{
    private final Call call;
    private final Object[] result;
    private final Throwable error;

    public Result(Call call, Object[] result)
    {
        this.call = call;
        this.result = result;
        this.error = null;
    }

    public Result(Call call, Throwable throwable)
    {
        this.call = call;
        this.result = null;
        this.error = throwable;
    }

    public Call getCall()
    {
        return this.call;
    }

    public Object[] getResult()
    {
        return this.result;
    }

    public Throwable getError()
    {
        return this.error;
    }

}
