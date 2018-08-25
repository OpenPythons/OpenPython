package kr.pe.ecmaxp.openpie;

import kr.pe.ecmaxp.thumbsj.CPU;
import kr.pe.ecmaxp.thumbsj.Memory;
import kr.pe.ecmaxp.thumbsj.exc.InvalidMemoryException;
import li.cil.oc.api.machine.Signal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

import static kr.pe.ecmaxp.openpie.PeripheralAddress.*;
import static kr.pe.ecmaxp.thumbsj.helper.RegisterIndex.PC;


public class OpenPieVirtualMachine
{
    private CPU cpu;
    private ArrayDeque<Character> charBuffer;
    private ArrayDeque<Call> calls;
    private Monitor monitor;

    OpenPieVirtualMachine()
    {
    }

    boolean init() throws InvalidMemoryException
    {
        cpu = new CPU();
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

    private void memoryMapping(byte[] firmware) throws InvalidMemoryException
    {
        Memory memory = cpu.memory;
        memory.map(0x08000000, 0x100000, false); // flash
        memory.map(0x20000000, 0x80000, false); // sram
        memory.map(0x3FFF0000, 0x10000, false); // stack
        memory.map(0x40000000, 0x10000, true); // peripheral
        memory.map(0xE0100000, 0x10000, true); // syscall
        memory.writeBuffer(0x08000000, firmware);
    }

    private void initReady() throws InvalidMemoryException
    {
        cpu.regs.set(PC, cpu.memory.readInt(0x08000000 + 4));
    }

    private void readyHook()
    {
        cpu.memory.Hook = (addr, is_read, size, value) ->
        {
            if (is_read)
            {
                switch ((int) addr)
                {
                    case UART0_TXR:
                        break;
                    case UART0_RXR:
                        value = getChar();
                        break;
                    case OPENPIE_CONTROLLER_PENDING:
                    case OPENPIE_CONTROLLER_EXCEPTION:
                    case OPENPIE_CONTROLLER_INTR_CHAR:
                        break;
                    case OPENPIE_CONTROLLER_RAM_SIZE:
                        value = 0x80000;
                        break;
                    case OPENPIE_CONTROLLER_STACK_SIZE:
                        value = 0x10000;
                        break;
                    case OPENPIE_CONTROLLER_IDLE:
                    case OPENPIE_CONTROLLER_INSNS:
                    case RTC_TICKS_MS:
                        break;
                    default:
                        System.out.printf("failure: %x, %d, %d\n", addr, size, value);
                        break;
                }
            }
            else
            {
                switch ((int) addr)
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
                        break;
                    default:
                        System.out.printf("failure: %x, %d, %d\n", addr, size, value);
                        break;
                }
            }


            return value;
        };

        // MEM_READ, memoryReadAccessHook (0
        // MEM_WRITE, memoryWriteAccessHook
        // MEM_READ_UNMAPPED, memoryInvaildHook
    }

    private boolean isSynchronized;

    void step(boolean isSynchronized) throws Exception
    {
        cpu.run(10000);
    }

    int getTotalMemorySize()
    {
        return 0x80000 + 0x10000;
    }

    void close()
    {
        if (cpu != null)
        {
            cpu = null;
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
                monitor.setGpu((String) args[0]);
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
        if (exception != null)
        {
            exception.printStackTrace();
        }
    }
}
