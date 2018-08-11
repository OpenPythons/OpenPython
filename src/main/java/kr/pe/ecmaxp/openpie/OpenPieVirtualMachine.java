package kr.pe.ecmaxp.openpie;

import junicorn.MemoryAccessHook;
import junicorn.MemoryInvaildHook;
import junicorn.Unicorn;
import junicorn.UnicornException;
import li.cil.oc.api.machine.Signal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

import static junicorn.ArmConst.UC_ARM_REG_PC;
import static junicorn.UnicornConst.*;
import static kr.pe.ecmaxp.openpie.PeripheralAddress.*;


public class OpenPieVirtualMachine
{
    private Unicorn uc;
    private ArrayDeque<Character> charBuffer;
    private ArrayDeque<Call> calls;
    private Monitor monitor;

    static
    {
        // TODO: drop dll when starting mod
        System.loadLibrary("unicorn");
    }

    OpenPieVirtualMachine()
    {
    }

    boolean init() throws UnicornException
    {
        if (uc != null)
            uc.close();

        uc = new Unicorn(UC_ARCH_ARM, UC_MODE_THUMB);
        byte[] firmware = loadFirmware();

        if (firmware == null)
            return false;

        calls = new ArrayDeque<>();
        monitor = new Monitor();
        memoryMapping(firmware);
        initReady();
        readyHook();

        charBuffer = new ArrayDeque<>();
        for (char c : "print(1, 2, 3)\r\n".toCharArray())
            charBuffer.add(c);

        return true;
    }

    private void memoryMapping(byte[] firmware) throws UnicornException
    {
        uc.mem_map(0x08000000, 0x100000, UC_PROT_READ | UC_PROT_EXEC); // flash
        uc.mem_map(0x20000000, 0x80000, UC_PROT_READ | UC_PROT_WRITE); // sram
        uc.mem_map(0x3FFF0000, 0x10000, UC_PROT_READ | UC_PROT_WRITE); // stack
        uc.mem_map(0x40000000, 0x10000, UC_PROT_READ | UC_PROT_WRITE); // peripheral
        uc.mem_map(0xE0100000, 0x10000, UC_PROT_READ | UC_PROT_WRITE); // syscall
        uc.mem_write(0x08000000, firmware);
    }

    private void initReady() throws UnicornException
    {
        uc.reg_write(UC_ARM_REG_PC, fromNumberBuffer(uc.mem_read(0x08000000 + 4, 4)));
    }

    private void readyHook() throws UnicornException
    {
        uc.hook_add(UC_HOOK_MEM_READ, memoryReadAccessHook, 0x40000000, 0x40000000 + 0x10000, null);
        uc.hook_add(UC_HOOK_MEM_WRITE, memoryWriteAccessHook, 0x40000000, 0x40000000 + 0x10000, null);
        uc.hook_add(UC_HOOK_MEM_READ_UNMAPPED, memoryInvaildHook, 1, 0, null);
    }

    private boolean isSynchronized;

    void step(boolean isSynchronized) throws Exception
    {
        long addr = uc.reg_read(UC_ARM_REG_PC);
        uc.emu_start(addr | 1, 0x08000000 + 0x100000, 0, 10000);
    }

    int getTotalMemorySize()
    {
        return 0x80000 + 0x10000;
    }

    void close()
    {
        if (uc != null)
        {
            try
            {
                uc.close();
            }
            catch (UnicornException e)
            {
                e.printStackTrace();
            }

            uc = null;
        }
    }

    private char getChar()
    {
        char value = 0;
        if (charBuffer != null)
        {
            if (charBuffer.size() > 0)
            {
                value = charBuffer.pop();
            }
        }

        return value;
    }

    private MemoryAccessHook memoryReadAccessHook = (uc, type, address, size, value, user) ->
    {
        switch ((int) address)
        {
            // case UART0_TXR:
            case UART0_RXR:
                value = (long) getChar();
                break;
            // case OPENPIE_CONTROLLER_PENDING:
            // case OPENPIE_CONTROLLER_EXCEPTION:
            // case OPENPIE_CONTROLLER_INTR_CHAR:
            case OPENPIE_CONTROLLER_RAM_SIZE:
                value = 0x80000;
                break;
            case OPENPIE_CONTROLLER_STACK_SIZE:
                value = 0x10000;
                break;
            // case OPENPIE_CONTROLLER_IDLE:
            // case OPENPIE_CONTROLLER_INSNS:
            // case RTC_TICKS_MS:
            // case RTC_TICKS_US:
            default:
                return;
        }

        uc.mem_write(address, getNumberBuffer(value));
    };

    class Monitor
    {
        private String gpuComponent;
        private boolean init = false;
        private ArrayDeque<Call> calls = new ArrayDeque<>();
        private int width = 50;
        private int height = 16;

        private int widthPos = 1;
        private int heightPos = 1;


        void setGpu(String gpuComponent)
        {
            this.gpuComponent = gpuComponent;
            this.init = false;
            widthPos = 1;
            heightPos = 1;
        }

        void init()
        {
            call("bind", "db76f066-fd61-4d48-8492-9cff0698ea54");
            init = true;
        }

        void scroll()
        {
            call("copy", 1, 2, width, height, 0, -1);
            call("fill", 1, height, width, 1, " ");
        }

        void call(String function, Object... args)
        {
            this.calls.add(new Call(
                    gpuComponent,
                    function,
                    args
            ));
        }

        void putChar(char x)
        {
            if (gpuComponent == null) return;
            if (!init) init();

            if (x == '\r')
            {
                widthPos = 1;
            }
            if (x == '\n')
            {
                heightPos++;
            }

            if (widthPos >= width)
            {
                widthPos = 1;
                heightPos++;
            }

            if (heightPos > height)
            {
                scroll();
                heightPos = height;
            }

            if (x == '\r' || x == '\n')
            {
                return;
            }

            String string = String.valueOf(x);
            call("set", widthPos, heightPos, string);
            widthPos++;
        }

        ArrayList<Call> getAndClearCalls()
        {
            ArrayList<Call> calls = new ArrayList<>();
            while (!this.calls.isEmpty())
            {
                calls.add(this.calls.pop());
            }

            return calls;
        }
    }

    private MemoryAccessHook memoryWriteAccessHook = (uc, type, address, size, value, user) ->
    {
        switch ((int) address)
        {
            case UART0_TXR:
                if (monitor != null)
                {
                    monitor.putChar((char) value);

                    for (Call call : monitor.getAndClearCalls())
                    {
                        calls.add(call);
                    }
                }
                break;
            case UART0_RXR:
            case OPENPIE_CONTROLLER_PENDING:
            case OPENPIE_CONTROLLER_EXCEPTION:
            case OPENPIE_CONTROLLER_INTR_CHAR:
            case OPENPIE_CONTROLLER_RAM_SIZE:
            case OPENPIE_CONTROLLER_STACK_SIZE:
            case OPENPIE_CONTROLLER_IDLE:
            case OPENPIE_CONTROLLER_INSNS:
            case RTC_TICKS_MS:
            case RTC_TICKS_US:
            default:
        }
    };

    private MemoryInvaildHook memoryInvaildHook = (uc, type, address, size, value, user_data) ->
    {
        System.out.printf("failure: %x, %d, %d\n", address, size, value);
        return false;
    };


    private byte[] loadFirmware()
    {
        File file = new File("C:\\Users\\EcmaXp\\Dropbox\\Projects\\openpie\\oprom\\build\\firmware.bin");
        byte[] firmware = new byte[0];

        try
        {
            firmware = Files.readAllBytes(file.toPath());
        }
        catch (IOException e)
        {
            return null;
        }

        return firmware;
    }

    private static long fromNumberBuffer(byte[] bytes)
    {
        return ((bytes[0] & 0xFF) |
                (bytes[1] & 0xFF) << 8 |
                (bytes[2] & 0xFF) << 16 |
                (bytes[3] & 0xFF) << 24);
    }

    private byte[] getNumberBuffer(long value)
    {
        return new byte[]{
                (byte) (value & 0xFF),
                (byte) (value >> 8 & 0xFF),
                (byte) (value >> 16 & 0xFF),
                (byte) (value >> 24 & 0xFF)
        };
    }

    public void onSignal(Signal signal)
    {
        String name = signal.name();
        Object[] args = signal.args();
        if (name.equals("key_down"))
        {
            if (args.length >= 4)
            {
                charBuffer.add((char) (double) args[1]);
            }
        }
        else if (name.equals("component_added"))
        {
            if (args.length >= 2 && args[1].equals("gpu"))
            {
                monitor.setGpu((String)args[0]);
            }
        }
    }

    public boolean hasCalls()
    {
        return !calls.isEmpty();
    }

    public Call popCalls()
    {
        return calls.pop();
    }

    public void pushResult(Result result)
    {
        //  if (result.getCall().getFunction().equals("set"))
        //    return;

        System.out.println(result.getCall().toString() + "=>" + Arrays.toString(result.getResult()));
        Exception exception = result.getException();
        if (exception != null) {
            exception.printStackTrace();
        }
    }
}
