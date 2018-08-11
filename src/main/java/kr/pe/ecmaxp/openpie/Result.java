package kr.pe.ecmaxp.openpie;

import java.rmi.server.ExportException;

public class Result
{
    private final Call call;
    private final Object[] result;
    private final Exception exception;

    public Result(Call call, Object[] result)
    {
        this.call = call;
        this.result = result;
        this.exception = null;
    }

    public Result(Call call, Exception exception)
    {
        this.call = call;
        this.result = null;
        this.exception = exception;
    }

    public Call getCall()
    {
        return this.call;
    }

    public Object[] getResult()
    {
        return this.result;
    }

    public Exception getException()
    {
        return this.exception;
    }

}
