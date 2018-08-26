package kr.pe.ecmaxp.thumbsj;

public class Handler implements MemoryHook
{
    public static final int OP_IO_TXR = 0x40000000;
    public static final int OP_IO_RXR = 0x40000004;
    public static final int OP_IO_REDIRECT = 0x40000008;
    public static final int OP_IO_TXB = 0x4000000c;
    public static final int OP_IO_RXB = 0x40000010;
    public static final int OP_CON_PENDING = 0x40000100;
    public static final int OP_CON_EXCEPTION = 0x40000104;
    public static final int OP_CON_INTR_CHAR = 0x40000108;
    public static final int OP_CON_RAM_SIZE = 0x4000010c;
    public static final int OP_CON_IDLE = 0x40000110;
    public static final int OP_CON_INSNS = 0x40000114;
    public static final int OP_RTC_TICKS_MS = 0x40000200;

    @Override
    public int Invoke(long address, boolean read, int size, int value)
    {
        if (read)
        {
            switch ((int) address)
            {
                case OP_IO_TXR:
                    break;
                case OP_IO_RXR:
                    value = 0; // getChar();
                    break;
                case OP_CON_PENDING:
                case OP_CON_EXCEPTION:
                case OP_CON_INTR_CHAR:
                    break;
                case OP_CON_RAM_SIZE:
                    value = 0x80000;
                    break;
                case OP_CON_IDLE:
                case OP_CON_INSNS:
                case OP_RTC_TICKS_MS:
                    break;
                default:
                    System.out.printf("failure: %x, %d, %d\n", address, size, value);
                    break;
            }
        }
        else
        {
            switch ((int) address)
            {
                case OP_IO_TXR:
                    System.out.println("console: " + (char)value);
                    break;
                case OP_IO_RXR:
                case OP_CON_PENDING:
                case OP_CON_EXCEPTION:
                case OP_CON_INTR_CHAR:
                case OP_CON_RAM_SIZE:
                case OP_CON_IDLE:
                case OP_CON_INSNS:
                case OP_RTC_TICKS_MS:
                    break;
                default:
                    System.out.printf("failure: %x, %d, %d\n", address, size, value);
                    break;
            }
        }


        return value;
    }
}
