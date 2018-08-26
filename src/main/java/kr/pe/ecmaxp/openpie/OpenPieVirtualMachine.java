package kr.pe.ecmaxp.openpie;

import com.google.gson.Gson;
import kr.pe.ecmaxp.thumbsj.*;
import kr.pe.ecmaxp.thumbsj.exc.InvalidMemoryException;
import li.cil.oc.api.machine.LimitReachedException;
import li.cil.oc.api.machine.Machine;
import li.cil.oc.api.machine.Signal;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.LinkedList;

import static kr.pe.ecmaxp.openpie.PeripheralAddress.*;
import static kr.pe.ecmaxp.thumbsj.helper.RegisterIndex.*;


public class OpenPieVirtualMachine
{
    private Machine machine;
    private CPU cpu;

    OpenPieVirtualMachine(Machine machine)
    {
        this.machine = machine;
    }

    boolean init() throws InvalidMemoryException
    {
        byte[] firmware = loadFirmware();
        if (firmware == null)
            return false;

        cpu = new CPU();
        setupInterruptHandler();
        memoryMapping(firmware);
        initReady();

        signals = new LinkedList<>();
        inputBuffer = new LinkedList<>();
        outputBuffer = new StringBuilder();

        return true;
    }

    private LinkedList<Signal> signals;
    private LinkedList<Character> inputBuffer;
    private StringBuilder outputBuffer;

    private void setupInterruptHandler()
    {
        cpu.interruptHandler = interruptHandler;
    }

    private void memoryMapping(byte[] firmware) throws InvalidMemoryException
    {
        final int KB = 1024;
        Memory memory = cpu.memory;
        memory.map(0x08000000, 256 * KB, MemoryFlag.RX); // flash
        memory.map(0x20000000, 64 * KB, MemoryFlag.RW); // sram
        memory.map(0x40000000, 4 * KB, this::PeripheralHook); // peripheral
        memory.map(0x60000000, 192 * KB, MemoryFlag.RW); // ram
        memory.map(0xE0000000, 16 * KB, MemoryFlag.RW); // syscall
        memory.writeBuffer(0x08000000, firmware);
    }

    private Exception pendingException;
    public Interrupt lastInterrupt;

    private InterruptHandler interruptHandler = imm ->
    {
        Interrupt intr = new Interrupt(cpu, imm);
        return InterruptHandler(intr, false);
    };

    public class ResultJson
    {
        public Object[] args;
        public String error;
    }

    private boolean InterruptHandler(Interrupt intr, boolean isSynchronized)
    {
        final int KB = 1024;
        final int addr = 0xE0000000;
        final int size = 16 * KB;
        Gson gson = new Gson();

        try
        {
            switch (intr.imm)
            {
                case 0:
                    // stop
                    return true;
                case 31:
                {
                    byte[] buf = outputBuffer.toString().getBytes(StandardCharsets.UTF_8);
                    outputBuffer = new StringBuilder();
                    cpu.memory.writeBuffer(addr, buf);
                    cpu.memory.writeByte(addr + buf.length, (byte) 0);
                    interruptResponse(addr, buf.length);
                }
                break;
                case 32:
                {
                    byte[] buf = cpu.memory.readBuffer(intr.r0, intr.r1);
                    String str = new String(buf, StandardCharsets.UTF_8);
                    System.out.println(str);
                }
                break;
                case 1:
                {
                    byte[] buf = cpu.memory.readBuffer(intr.r0, intr.r1);
                    String str = new String(buf, StandardCharsets.UTF_8);
                    // System.out.println(str);
                    Object[] req = gson.fromJson(str, Object[].class);
                    if (req.length < 2)
                        break;

                    Object[] args = new Object[req.length - 2];
                    System.arraycopy(req, 2, args, 0, args.length);

                    Call call = new Call((String) req[0], (String) req[1], args);
                    Result result;
                    // System.out.println("call:" + call);

                    System.out.println(call);

                    try
                    {
                        result = call.invoke(machine);
                    }
                    catch (LimitReachedException e)
                    {
                        if (!isSynchronized)
                        {
                            assert lastInterrupt == null;
                            lastInterrupt = intr;
                            return false;
                        }
                        else
                        {
                            throw e;
                        }
                    }

                    ResultJson resultObj = new ResultJson();
                    Throwable error= result.getError();

                    if (error == null)
                        resultObj.args = result.getResult();
                    else
                    {
                        resultObj.error = error.toString();
                        error.printStackTrace();
                    }

                    String json = gson.toJson(resultObj, ResultJson.class);
                    byte[] rawJson = json.getBytes();

                    cpu.memory.writeBuffer(addr, rawJson);
                    cpu.memory.writeByte(addr + rawJson.length, (byte) 0);

                    interruptResponse(addr, rawJson.length);
                }
                break;
                case 2:
                {
                    if (!signals.isEmpty())
                    {
                        Signal signal = signals.pop();
                        String json = gson.toJson(signal);
                        byte[] rawJson = json.getBytes();

                        cpu.memory.writeBuffer(addr, rawJson);
                        cpu.memory.writeByte(addr + rawJson.length, (byte) 0);

                        interruptResponse(addr, rawJson.length);
                    }
                    else
                    {
                        interruptResponse(0);
                    }

                }
                break;
                case 3:
                {
                    String json = gson.toJson(machine.components());
                    byte[] rawJson = json.getBytes();

                    cpu.memory.writeBuffer(addr, rawJson);
                    cpu.memory.writeByte(addr + rawJson.length, (byte) 0);

                    interruptResponse(addr, rawJson.length);
                }
                break;
                default:
                    interruptResponse(0);
                    break;
            }
        }
        catch (Exception e)
        {
            pendingException = e;
            return true;
        }

        return false;
    }

    private int PeripheralHook(long addr, boolean is_read, int size, int value)
    {
        if (is_read)
        {
            switch ((int) addr)
            {
                case OP_IO_RXR:
                    if (!inputBuffer.isEmpty())
                        return inputBuffer.pop();

                    return 0;
                case OP_IO_TXR:
                    return 0;
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
                    System.out.printf("failure: %x, %d, %d\n", addr, size, value);
                    break;
            }
        }
        else
        {
            switch ((int) addr)
            {
                case OP_IO_RXR:
                    inputBuffer.add((char) value);
                    break;
                case OP_IO_TXR:
                    if (value == 0)
                    {
                        int length = outputBuffer.length();
                        if (length > 0)
                            machine.signal("print");
                    }
                    else
                    {
                        outputBuffer.append((char) value);
                    }
                    break;
                case OP_CON_PENDING:
                case OP_CON_EXCEPTION:
                case OP_CON_INTR_CHAR:
                case OP_CON_RAM_SIZE:
                case OP_CON_IDLE:
                case OP_CON_INSNS:
                case OP_RTC_TICKS_MS:
                    break;
                default:
                    System.out.printf("failure: %x, %d, %d\n", addr, size, value);
                    break;
            }
        }


        return value;
    }

    private void initReady() throws InvalidMemoryException
    {
        cpu.regs.set(PC, cpu.memory.readInt(0x08000000 + 4));
    }

    void step(boolean isSynchronized) throws Exception
    {
        if (isSynchronized)
        {
            if (lastInterrupt != null)
            {
                Interrupt intr = lastInterrupt;
                lastInterrupt = null;
                InterruptHandler(intr, true);
            }

            return;
        }

        Signal signal = null;
        synchronized (signals)
        {
            if (!signals.isEmpty())
                signal = signals.pop();
        }

        if (signal != null)
        {
            // System.out.println(signal);
            Registers regs = cpu.regs.copy();
            final int KB = 1024;
            final int addr = 0xE0000000;
            final int size = 16 * KB;

            Gson gson = new Gson();
            String json = gson.toJson(signal);
            // System.out.println(json);
            byte[] rawJson = json.getBytes();
            cpu.memory.writeBuffer(addr, rawJson);
            cpu.memory.writeByte(addr + rawJson.length, (byte) 0);
            interruptResponse(addr, rawJson.length);
            cpu.regs.set(PC, cpu.memory.readInt(0x08000000 + 8));
            cpu.regs.set(SP, cpu.regs.get(SP) - 32);
            cpu.run(10000);
            cpu.regs = regs;

            if (pendingException != null)
                throw pendingException;

            return;
        }

        cpu.run(1000000);

        if (pendingException != null)
            throw pendingException;
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
        synchronized (signals)
        {
            signals.add(signal);
        }
    }

    public void interruptResponse(int r0)
    {
        interruptResponse(r0, 0, 0, 0);
    }

    public void interruptResponse(int r0, int r1)
    {
        interruptResponse(r0, r1, 0, 0);
    }

    public void interruptResponse(int r0, int r1, int r2)
    {
        interruptResponse(r0, r1, r2, 0);
    }

    public void interruptResponse(int r0, int r1, int r2, int r3)
    {
        cpu.regs.set(R0, r0);
        cpu.regs.set(R1, r1);
        cpu.regs.set(R2, r2);
        cpu.regs.set(R3, r3);
    }
}
