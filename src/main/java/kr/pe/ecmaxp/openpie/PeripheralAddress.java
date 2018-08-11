package kr.pe.ecmaxp.openpie;

public class PeripheralAddress
{
    public static final int UART0_TXR = 0x40000000;
    public static final int UART0_RXR = 0x40000004;
    public static final int OPENPIE_CONTROLLER_PENDING = 0x40000100;
    public static final int OPENPIE_CONTROLLER_EXCEPTION = 0x40000104;
    public static final int OPENPIE_CONTROLLER_INTR_CHAR = 0x40000108;
    public static final int OPENPIE_CONTROLLER_RAM_SIZE = 0x4000010c;
    public static final int OPENPIE_CONTROLLER_STACK_SIZE = 0x40000110;
    public static final int OPENPIE_CONTROLLER_IDLE = 0x40000114;
    public static final int OPENPIE_CONTROLLER_INSNS = 0x40000118;
    public static final int RTC_TICKS_MS = 0x40000300;
    public static final int RTC_TICKS_US = 0x40000304;
}
