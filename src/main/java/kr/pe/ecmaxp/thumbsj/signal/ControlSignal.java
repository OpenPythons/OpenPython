package kr.pe.ecmaxp.thumbsj.signal;

public class ControlSignal extends Throwable
{
    private final Object object;

    protected ControlSignal(Object object)
    {
        this.object = object;
    }

    public Object getObject()
    {
        return object;
    }
}
