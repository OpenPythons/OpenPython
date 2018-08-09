package junicorn;

public class MemoryRegion
{
    @SuppressWarnings("WeakerAccess")
    public final long begin;

    @SuppressWarnings("WeakerAccess")
    public final long end;

    @SuppressWarnings("WeakerAccess")
    public final int perms;

    public MemoryRegion(long begin, long end, int perms)
    {
        this.begin = begin;
        this.end = end;
        this.perms = perms;
    }

    @Override
    public String toString()
    {
        return "MemoryRegion{" +
                "begin=" + begin +
                ", end=" + end +
                ", perms=" + perms +
                '}';
    }

}

