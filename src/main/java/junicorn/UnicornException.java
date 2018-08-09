package junicorn;

import static junicorn.UnicornNative.uc_strerror;

public class UnicornException extends Exception
{
    private int errno;

    public UnicornException(int errno)
    {
        super(uc_strerror(errno));
        this.errno = errno;
    }

    public UnicornException(String message, int errno)
    {
        super(message);
        this.errno = errno;
    }

    public int getErrno()
    {
        return errno;
    }
}
