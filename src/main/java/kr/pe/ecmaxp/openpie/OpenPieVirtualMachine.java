package kr.pe.ecmaxp.openpie;

import com.google.gson.Gson;
import com.mojang.realmsclient.util.Pair;
import kr.pe.ecmaxp.thumbsj.CPU;
import kr.pe.ecmaxp.thumbsj.InterruptHandler;
import kr.pe.ecmaxp.thumbsj.MemoryFlag;
import kr.pe.ecmaxp.thumbsj.Registers;
import kr.pe.ecmaxp.thumbsj.exc.InvalidMemoryException;
import li.cil.oc.api.machine.LimitReachedException;
import li.cil.oc.api.machine.Machine;
import li.cil.oc.api.machine.Signal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static kr.pe.ecmaxp.openpie.PeripheralAddress.*;
import static kr.pe.ecmaxp.openpie.micropython.MicroPyInternalError.*;
import static kr.pe.ecmaxp.thumbsj.helper.RegisterIndex.*;


public class OpenPieVirtualMachine
{
    private Machine machine;
    private CPU cpu;
    public VMState state;

    OpenPieVirtualMachine(Machine machine)
    {
        this.machine = machine;
    }

    boolean init() throws InvalidMemoryException
    {
        final int KB = 1024;
        final byte[] firmware = loadFirmware();
        if (firmware == null)
            return false;

        close();

        cpu = new CPU();
        cpu.memory.map(0x08000000, 256 * KB, MemoryFlag.RX); // flash
        cpu.memory.map(0x20000000, 64 * KB, MemoryFlag.RW); // sram
        cpu.memory.map(0x40000000, 4 * KB, this::PeripheralHook); // peripheral
        cpu.memory.map(0x60000000, 192 * KB, MemoryFlag.RW); // ram
        cpu.memory.map(0xE0000000, 16 * KB, MemoryFlag.RW); // syscall
        cpu.memory.writeBuffer(0x08000000, firmware);
        cpu.regs.set(PC, cpu.memory.readInt(0x08000000 + 4));
        cpu.interruptHandler = interruptHandler;

        state = new VMState();

        return true;
    }

    public class FileHandle
    {
        public final String address;
        public final int handle;
        public boolean is_closed;
        public int pos = 0;

        public FileHandle(String address, int handle)
        {
            this.address = address;
            this.handle = handle;
            this.is_closed = false;
        }

        @Override
        public String toString()
        {
            return "FileHandle{" +
                    "address='" + address + '\'' +
                    ", handle=" + handle +
                    '}';
        }

        public Call call(String func, Object... args)
        {
            Object[] callArgs = new Object[args.length + 1];
            callArgs[0] = this.handle;
            System.arraycopy(args, 0, callArgs, 1, args.length);
            return new Call(this.address, func, callArgs);
        }
    }

    public class VMState
    {
        private LinkedList<Signal> signals;
        private LinkedList<Signal> pendingSignals;
        private LinkedList<Character> inputBuffer;
        private StringBuilder outputBuffer;
        private Exception pendingException;
        public HashMap<Integer, FileHandle> fdMap;
        public Exception lastException;
        public Interrupt lastInterrupt;
        public int fdCount = 3;

        private VMState()
        {
            signals = new LinkedList<>();
            fdMap = new HashMap<>();
            pendingSignals = new LinkedList<>();
            inputBuffer = new LinkedList<>();
            outputBuffer = new StringBuilder();
        }
    }

    @SuppressWarnings("unused")
    private class ResultJson
    {
        private Object[] args;
        private String error;

        ResultJson(Throwable error)
        {
            this.error = error.toString();
        }

        ResultJson(Object[] args)
        {
            this.args = args;
        }

        ResultJson(Result result)
        {
            this.args = result.args;
            this.error = result.error != null ? result.error.toString() : null;
        }

        @Override
        public String toString()
        {
            return new Gson().toJson(new Object[]{this.args, this.error});
        }
    }

    private InterruptHandler interruptHandler = imm ->
    {
        Interrupt intr = new Interrupt(cpu, imm);
        try
        {
            return InterruptHandler(intr, false);
        }
        catch (LimitReachedException e)
        {
            assert state.lastInterrupt == null;
            state.lastInterrupt = intr;
            return false;
        }
        catch (Exception e)
        {
            state.lastException = e;
            return false;
        }
    };

    private final int KB = 1024;
    private final int bufAddress = 0xE0000000;
    private final int bufMaxSize = 16 * KB;

    private boolean InterruptHandler(Interrupt intr, boolean isSynchronized) throws LimitReachedException
    {
        byte[] buf;
        int size;
        String str;
        Result ret;
        ResultJson retJson;
        Gson gson = new Gson();

        try
        {
            switch (intr.imm)
            {
                case 0: // STOP MACHINE
                    // stop
                    return true;
                case 1: // SYSCALL
                {
                    buf = cpu.memory.readBuffer(intr.r0, intr.r1);
                    str = new String(buf, StandardCharsets.UTF_8);

                    Object[] req = gson.fromJson(str, Object[].class);
                    Call call = Call.FromObjectArray(req);
                    if (call == null)
                    {
                        retJson = new ResultJson(new Exception("Invaild call"));
                    }
                    else
                    {
                        ret = invoke(call); // LimitReachedException
                        if (ret.error == null)
                            retJson = new ResultJson(ret.args);
                        else
                        {
                            retJson = new ResultJson(ret.error);
                            ret.error.printStackTrace();
                        }
                    }

                    byte[] rawJson = retJson.toString().getBytes();
                    interruptResponseBufferOrEmpty(rawJson);
                }
                break;
                case 2: // SIGNAL
                {
                    if (!state.pendingSignals.isEmpty())
                    {
                        Signal signal = state.pendingSignals.pop();
                        String json = gson.toJson(signal);
                        byte[] rawJson = json.getBytes();
                        interruptResponseBufferOrEmpty(rawJson);
                    }
                    else
                    {
                        interruptResponseEmpty();
                    }

                }
                break;
                case 3: // COMPONENTS
                {
                    String json = gson.toJson(machine.components());
                    byte[] rawJson = json.getBytes();
                    interruptResponseBufferOrEmpty(rawJson);
                }
                break;
                case 31: // usystem_get_stdout_str
                {
                    buf = state.outputBuffer.toString().getBytes(StandardCharsets.UTF_8);
                    state.outputBuffer = new StringBuilder();
                    interruptResponseBufferOrEmpty(buf);
                }
                break;
                case 32: // DEBUG
                {
                    buf = cpu.memory.readBuffer(intr.r0, intr.r1);
                    str = new String(buf, StandardCharsets.UTF_8);
                    // System.out.println(str);
                }
                break;
                case 33: // DEBUG FOR NUMBER
                {
                    System.out.println(intr.r0);
                }
                break;
                case 16:
                {
                    int command = intr.r0;
                    if (command == 1)
                    {
                        String address = readString(intr.r1, 64);
                        String path = readString(intr.r2, 256);
                        String mode = readString(intr.r3, 16);

                        ret = invoke(address, "open", path, mode);
                        if (ret.error instanceof FileNotFoundException)
                        {
                            interruptResponseCode(MP_ENOENT);
                        }
                        else if (ret.args != null)
                        {
                            if (ret.args.length != 1)
                            {
                                interruptResponseCode(MP_EPERM);
                                break;
                            }

                            int fdPtr = intr.r4;
                            int fd = state.fdCount++;
                            int handle = Integer.parseInt(ret.args[0].toString()); // handle

                            state.fdMap.put(
                                    fd,
                                    new FileHandle(address, handle)
                            );

                            cpu.memory.writeInt(fdPtr, fd);
                            interruptResponseCode(0);
                        }
                        else
                        {
                            interruptResponseCode(MP_EPERM);
                        }
                    }
                    else
                    {
                        int fd = intr.r1;
                        FileHandle fh = state.fdMap.getOrDefault(fd, null);
                        if (fh == null)
                        {
                            interruptResponseCode(MP_EBADF);
                            break;
                        }

                        switch (command)
                        {
                            case 2: // VFS_VALID
                                ret = invoke(fh.call("seek", fh.pos));
                                interruptResponseCode(ret.error == null ? 0 : MP_EIO);
                                break;
                            case 3: // VFS_REPR
                                interruptResponseCode(MP_EPERM);
                                break;
                            case 4: // VFS_CLOSE
                                ret = invoke(fh.call("close"));
                                if (ret.error != null)
                                {
                                    ret.error.printStackTrace();
                                    interruptResponseCode(1);
                                }
                                else
                                {
                                    state.fdMap.remove(fd);
                                    interruptResponseCode(0);
                                }
                                break;
                            case 5: // VFS_READ
                                ret = invoke(fh.call("read", intr.r2));
                                if (ret.error != null)
                                {
                                    ret.error.printStackTrace();
                                    interruptResponseCode(1);
                                }
                                else if (ret.args != null)
                                {
                                    if (ret.args.length != 1)
                                    {
                                        interruptResponseCode(MP_EPERM);
                                        break;
                                    }

                                    Object arg = ret.args[0];
                                    if (arg instanceof byte[])
                                    {
                                        buf = (byte[]) arg;
                                        cpu.memory.writeBuffer(intr.r3, buf);
                                        cpu.memory.writeInt(intr.r4, buf.length);
                                    }
                                    else if (arg == null)
                                    {
                                        // EOF
                                        interruptResponseCode(0);
                                    }
                                    else
                                    {
                                        interruptResponseCode(MP_EPERM);
                                    }
                                }
                                else
                                {
                                    interruptResponseCode(MP_EPERM);
                                }
                                interruptResponseCode(0);
                                break;
                            case 6: // VFS_WRITE
                                buf = cpu.memory.readBuffer(intr.r2, intr.r3);
                                ret = invoke(fh.call("write", new Object[]{buf}));
                                if (ret.error != null)
                                {
                                    ret.error.printStackTrace();
                                    interruptResponseCode(1);
                                }
                                else if (ret.args != null)
                                {
                                    if (ret.args.length != 1)
                                    {
                                        interruptResponseCode(MP_EPERM);
                                        break;
                                    }

                                    Object arg = ret.args[0];
                                    if (arg instanceof Boolean)
                                    {
                                        boolean success = (boolean) arg;
                                        if (success)
                                        {
                                            fh.pos += buf.length;
                                            cpu.memory.writeInt(intr.r4, buf.length);
                                        }
                                    }
                                    else if (arg == null)
                                    {
                                        // EOF
                                        interruptResponseCode(0);
                                    }
                                    else
                                    {
                                        interruptResponseCode(MP_EPERM);
                                    }
                                }
                                else
                                {
                                    interruptResponseCode(MP_EPERM);
                                }
                                interruptResponseCode(0);
                                break;
                            case 7: // VFS_SEEK
                                int offset = intr.r2;
                                int whence = intr.r3;
                                int offsetPtr = intr.r4;
                                String whenceStr = null;

                                switch (whence)
                                {
                                    case 0: // MP_SEEK_SET
                                        whenceStr = "set";
                                        break;
                                    case 1: // MP_SEEK_CUR
                                        whenceStr = "cur";
                                        break;
                                    case 2: // MP_SEEK_END
                                        whenceStr = "end";
                                        break;
                                    default:
                                        break;
                                }

                                if (whenceStr == null) {
                                    interruptResponseCode(MP_EPERM);
                                    break;
                                }

                                ret = invoke(fh.call("seek", whenceStr, offset));
                                if (ret.error != null)
                                {
                                    ret.error.printStackTrace();
                                    interruptResponseCode(1);
                                }
                                else if (ret.args != null)
                                {
                                    if (ret.args.length != 1)
                                    {
                                        interruptResponseCode(MP_EPERM);
                                        break;
                                    }

                                    Object arg = ret.args[0];
                                    if (arg instanceof Integer)
                                        fh.pos = (int) arg;
                                    else
                                        interruptResponseCode(MP_EPERM);
                                }
                                else
                                {
                                    interruptResponseCode(MP_EPERM);
                                }
                                interruptResponseCode(0);
                                break;
                            case 8: // VFS_FLUSH
                                interruptResponseCode(0); // always flushed?
                                break;
                            default:
                                interruptResponseCode(MP_EPERM);
                                break;
                        }
                    }
                }
                break;
                default:
                    interruptResponseCode(-1);
                    break;
            }
        }
        catch (Exception e)
        {
            state.pendingException = e;
            return true;
        }

        return false;
    }

    private String readString(int address, int maxSize) throws InvalidMemoryException
    {
        int size;
        byte[] buffer = new byte[maxSize];
        for (size = 0; size < maxSize; size++)
        {
            byte ch = buffer[size] = cpu.memory.readByte(address + size);
            if (ch == 0)
                break;
        }

        return new String(buffer, 0, size, StandardCharsets.UTF_8);
    }

    private Result invoke(Call call) throws LimitReachedException
    {
        return call.invoke(machine);
    }

    private Result invoke(String address, String func, Object... args) throws LimitReachedException
    {
        Call call = new Call(address, func, args);
        return invoke(call);
    }

    private int PeripheralHook(long addr, boolean is_read, int size, int value)
    {
        if (is_read)
        {
            switch ((int) addr)
            {
                case OP_IO_RXR:
                    if (!state.inputBuffer.isEmpty())
                        return state.inputBuffer.pop();

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
                    state.inputBuffer.add((char) value);
                    break;
                case OP_IO_TXR:
                    if (value == 0)
                    {
                        int length = state.outputBuffer.length();
                        if (length > 0)
                            machine.signal("print");

                        System.out.println("console:" + state.outputBuffer.toString());
                    }
                    else
                    {
                        state.outputBuffer.append((char) value);
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

    void step(boolean isSynchronized) throws Exception
    {
        synchronized (this)
        {
            if (isSynchronized)
            {
                if (state.lastInterrupt != null)
                {
                    Interrupt intr = state.lastInterrupt;
                    state.lastInterrupt = null;
                    InterruptHandler(intr, true);
                }

                return;
            }

            Signal signal = null;
            synchronized (this)
            {
                if (!state.signals.isEmpty())
                    signal = state.signals.pop();
            }

            if (signal != null)
            {
                state.pendingSignals.add(signal);

                Registers regs = cpu.regs.copy();
                cpu.regs.set(PC, cpu.memory.readInt(0x08000000 + 8));
                cpu.regs.set(SP, cpu.regs.get(SP) - 32);
                cpuStep();
                cpu.regs = regs;
                return;
            }

            cpuStep();
        }
    }

    private void cpuStep() throws Exception
    {
        try
        {
            cpu.run(1000000);
        }
        catch (Exception e)
        {
            state.pendingException = e;
        }

        if (state.pendingException != null)
        {
            long pc = cpu.regs.get(PC) & 0xFFFFFFFFL;
            List<Pair<Long, String>> mapping = loadMapping();
            Pair<Long, String> selected = null;
            boolean found = false;
            for (Pair<Long, String> pair : mapping)
            {
                long addr = pair.first();
                if (addr > pc)
                {
                    found = true;
                    break;
                }

                selected = pair;
            }

            if (found && selected != null)
            {
                System.out.println("last function :" + selected.second() + " (+" + Long.toString(pc - selected.first()) + ")");
            }
            else
            {
                System.out.println("last function : (null)");
            }


            long lr = cpu.regs.get(LR) & 0xFFFFFFFFL;
            selected = null;
            found = false;
            for (Pair<Long, String> pair : mapping)
            {
                long addr = pair.first();
                if (addr > lr)
                {
                    found = true;
                    break;
                }

                selected = pair;
            }

            if (found && selected != null)
            {
                System.out.println("last function :" + selected.second() + " (+" + Long.toString(lr - selected.first()) + ")");
            }
            else
            {
                System.out.println("last function : (null)");
            }

            throw state.pendingException;
        }
    }

    void close()
    {
        cpu = null;
        state = null;
    }

    private byte[] loadFirmware()
    {
        File file = new File("C:\\Users\\EcmaXp\\Dropbox\\Projects\\openpie\\oprom\\build\\firmware.bin");
        byte[] firmware;

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

    private List<Pair<Long, String>> loadMapping() throws IOException
    {
        File file = new File("C:\\Users\\EcmaXp\\Dropbox\\Projects\\openpie\\oprom\\build\\firmware.elf.map");
        List<String> lines = Files.readAllLines(file.toPath());
        List<Pair<Long, String>> result = new ArrayList<>();

        String last_name = null;
        for (String line : lines)
        {
            String[] tokens = line.trim().split("\\s+");
            Pair<Long, String> last_pair = null;
            if (tokens.length >= 1)
            {
                if (tokens[0].startsWith(".text"))
                {
                    last_name = tokens[0];
                }
                else if (tokens[0].startsWith("0x"))
                {
                    long addr = Long.parseLong(tokens[0].substring(2), 16);
                    if (tokens.length == 2)
                    {
                        last_pair = Pair.of(addr, tokens[1]);
                        result.add(last_pair);
                    }
                    else if (last_name != null)
                    {
                        last_pair = Pair.of(addr, last_name);
                        result.add(last_pair);
                    }
                }
                else
                {
                    last_name = null;
                }
            }
        }

        return result;
    }

    synchronized void onSignal(Signal signal)
    {
        state.signals.add(signal);
    }

    private void interruptResponseBufferOrEmpty(byte[] buffer) throws InvalidMemoryException, IOException
    {
        if (buffer != null && buffer.length > 0)
            interruptResponseBuffer(buffer);
        else
            interruptResponseEmpty();
    }

    private void interruptResponseBuffer(byte[] buffer) throws InvalidMemoryException, IOException
    {
        cpu.memory.writeInt(bufAddress, bufAddress + 8); // + 0
        cpu.memory.writeInt(bufAddress + 4, buffer.length); // + 4
        cpu.memory.writeBuffer(bufAddress + 8, buffer); // + 8
        cpu.memory.writeByte(bufAddress + 8 + buffer.length, (byte) 0); // + 8 + n
        cpu.regs.set(R0, bufAddress);
    }

    private void interruptResponseEmpty() throws InvalidMemoryException, IOException
    {
        interruptResponseCode(0);
    }

    private void interruptResponseCode(int code) throws InvalidMemoryException, IOException
    {
        cpu.regs.set(R0, code);
    }
}
