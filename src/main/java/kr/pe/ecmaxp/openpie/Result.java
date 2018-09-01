package kr.pe.ecmaxp.openpie;

public class Result
{
    public final Call call;
    public final Object[] args;
    public final Throwable error;

    public Result(Call call, Object[] args)
    {
        this.call = call;
        this.args = args;
        this.error = null;
    }

    public Result(Call call, Throwable throwable)
    {
        this.call = call;
        this.args = null;
        this.error = throwable;
    }
}
