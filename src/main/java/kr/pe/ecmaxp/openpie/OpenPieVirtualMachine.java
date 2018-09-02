package kr.pe.ecmaxp.openpie;

import com.google.gson.Gson;
import com.mojang.realmsclient.util.Pair;
import kr.pe.ecmaxp.thumbsj.*;
import kr.pe.ecmaxp.thumbsj.exc.InvalidMemoryException;
import kr.pe.ecmaxp.thumbsj.signal.ControlPauseSignal;
import kr.pe.ecmaxp.thumbsj.signal.ControlSignal;
import kr.pe.ecmaxp.thumbsj.signal.ControlStopSignal;
import li.cil.oc.api.machine.*;
import li.cil.oc.api.network.Component;
import li.cil.oc.api.network.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static kr.pe.ecmaxp.openpie.OpenPieSystemCallConsts.*;
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

    boolean init() throws Exception
    {
        final int KB = 1024;
        final byte[] firmware = loadFirmware();
        if (firmware == null)
            return false;

        close();

        cpu = new CPU();
        cpu.memory.map(0x08000000L, 256 * KB, MemoryFlag.RX); // flash
        cpu.memory.map(0x20000000L, 64 * KB, MemoryFlag.RW); // sram
        cpu.memory.map(0x40000000L, 4 * KB, this::PeripheralHook); // peripheral
        cpu.memory.map(0x60000000L, 192 * KB, MemoryFlag.RW); // ram
        cpu.memory.map(0xE0000000L, 16 * KB, MemoryFlag.RW); // syscall
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
        public ControlSignal lastControlSignal;
        public boolean redirectKeyEvent = true;
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
            redirectKeyEvent = true;
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
    }

    private InterruptHandler interruptHandler = imm ->
    {
        Interrupt intr = new Interrupt(cpu, imm);

        try
        {
            InterruptHandler(intr);
        }
        catch (Exception e)
        {
            state.lastException = e;
            Crash(e.toString());
        }
    };

    private static final int KB = 1024;
    private static final int bufAddress = 0xE0000000;
    private static final int bufMaxSize = 16 * KB;

    private void SysCallHandler_Control(Interrupt intr) throws InvalidMemoryException, ControlStopSignal
    {
        switch (intr.r0)
        {
            case SYS_CONTROL_SHUTDOWN:
                throw new ControlStopSignal(new ExecutionResult.Shutdown(false));
            case SYS_CONTROL_REBOOT:
                throw new ControlStopSignal(new ExecutionResult.Shutdown(true));
            case SYS_CONTROL_CRASH:
                String str = readString(intr.r1, 256);
                Crash(str);
                break;
            case SYS_CONTROL_RETURN:
                throw new ControlStopSignal(null);
        }

        Crash("Unknown Interrupt");
    }

    private void Crash(String message) throws ControlStopSignal
    {
        machine.crash(message);
        throw new ControlStopSignal(new ExecutionResult.Shutdown(false));
    }

    private void SysCallHandler_Invoke(Interrupt intr) throws InvalidMemoryException, LimitReachedException
    {
        byte[] buf = cpu.memory.readBuffer(intr.r0, intr.r1);
        String str = new String(buf, StandardCharsets.UTF_8);

        Object[] req = new Gson().fromJson(str, Object[].class);
        Call call = Call.FromObjectArray(req);

        Result ret;
        if (call == null)
        {
            ret = new Result(null, new Exception("Invaild call"));
        }
        else
        {
            ret = invoke(call); // LimitReachedException
            if (ret.error != null)
                ret.error.printStackTrace();
        }

        interruptResponseJson(new Object[]{ret.args, ret.error});
    }

    private void SysCallHandler_Request(Interrupt intr) throws InvalidMemoryException, ControlStopSignal
    {
        switch (intr.r0)
        {
            case 0:
            {
                if (!state.pendingSignals.isEmpty())
                {
                    Signal signal = state.pendingSignals.pop();
                    interruptResponseJson(signal);
                }
                else
                {
                    interruptResponseEmpty();
                }
            }
            return;
            case SYS_REQUEST_COMPONENTS:
            {
                interruptResponseJson(machine.components());
            }
            return;
            case SYS_REQUEST_METHODS:
            {
                byte[] buf = cpu.memory.readBuffer(intr.r1, intr.r2);
                String str = new String(buf, StandardCharsets.UTF_8);

                Node node = machine.node().network().node(str);
                if (node instanceof Component)
                {
                    Component component = (Component) node;
                    interruptResponseJson(component.methods());
                }
                else
                {
                    interruptResponseEmpty();
                }
            }
            return;
            case SYS_REQUEST_ANNOTATIONS:
            {
                byte[] buf = cpu.memory.readBuffer(intr.r1, intr.r2);
                String str = new String(buf, StandardCharsets.UTF_8);

                String[] req = new Gson().fromJson(str, String[].class);
                if (req.length != 2)
                {
                    interruptResponseEmpty();
                    break;
                }

                Node node = machine.node().network().node(req[0]);
                if (node instanceof Component)
                {
                    Component component = (Component) node;
                    try
                    {
                        Callback callback = component.annotation(req[1]);
                        interruptResponseJson(callback.doc());
                    }
                    catch (Exception exc)
                    {
                        // how to handle?
                        exc.printStackTrace();
                        interruptResponseEmpty();
                    }
                }
                else
                {
                    interruptResponseEmpty();
                }
            }
            return;
            default:
                break;
        }
    }

    private void SysCallHandler_VirtualFileSystem(Interrupt intr) throws InvalidMemoryException, LimitReachedException
    {
        Result ret;
        int command = intr.r0;
        if (command == 1)
        {
            String address = readString(intr.r1, 64);
            String path = readString(intr.r2, 256);
            String mode = readString(intr.r3, 16);

            ret = invoke(new Call(address, "open", path, mode));
            if (ret.error instanceof FileNotFoundException)
            {
                interruptResponseCode(MP_ENOENT);
            }
            else if (ret.args != null)
            {
                if (ret.args.length != 1)
                {
                    interruptResponseCode(MP_EPERM);
                    return;
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
                return;
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
                    byte[] buf;
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

                    if (whenceStr == null)
                    {
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

    private void SysCallHandler_Debug(Interrupt intr) throws InvalidMemoryException
    {
        if (true) return;
        byte[] buf = cpu.memory.readBuffer(intr.r0, intr.r1);
        String str = new String(buf, StandardCharsets.UTF_8);
        System.out.println(str);
    }

    private void SysCallHandler_Legacy(Interrupt intr) throws InvalidMemoryException
    {
        switch (intr.r0)
        {
            case 0:
            {
                byte[] buf = state.outputBuffer.toString().getBytes(StandardCharsets.UTF_8);
                state.outputBuffer = new StringBuilder();
                interruptResponseBufferOrEmpty(buf);
            }
        }
    }

    private void InterruptHandler(Interrupt intr) throws InvalidMemoryException, ControlStopSignal, ControlPauseSignal
    {
        try
        {
            switch (intr.imm)
            {
                case SYS_CONTROL:
                    SysCallHandler_Control(intr);
                    break;
                case SYS_INVOKE:
                    SysCallHandler_Invoke(intr);
                    break;
                case SYS_REQUEST:
                    SysCallHandler_Request(intr);
                    break;
                case SYS_VFS:
                    SysCallHandler_VirtualFileSystem(intr);
                    break;
                case SYS_DEBUG:
                    SysCallHandler_Debug(intr);
                    break;
                case SYS_LEGACY:
                    SysCallHandler_Legacy(intr);
                    break;
                default:
                    Crash("Unknown interrupt number");
                    break;
            }
        }
        catch (LimitReachedException e)
        {
            throw new ControlStopSignal(new ExecutionResult.SynchronizedCall());
        }
        catch (InvalidMemoryException e)
        {
            throw e;
        }
        catch (Exception e)
        {
            // error!
            throw new ControlStopSignal(e);
        }
    }

    private String readString(int address, int maxSize) throws InvalidMemoryException
    {
        long addr = Integer.toUnsignedLong(address);
        MemoryRegion region = cpu.memory.FindRegion(addr, 0);
        if (region.getFlag() == MemoryFlag.HOOK)
            throw new InvalidMemoryException(address);

        byte[] buffer = region.getBuffer();

        int start = (int) (address - region.getBegin());
        int size = (int) (Math.min(region.getEnd() - addr, maxSize));
        int end = start + size;

        int pos;
        for (pos = start; pos < end; pos++)
        {
            if (buffer[pos] == 0)
                break;
        }

        return new String(buffer, start, pos - start, StandardCharsets.UTF_8);
    }

    private Result invoke(Call call) throws LimitReachedException
    {
        return call.invoke(machine);
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
                    break;
                case OP_RTC_TICKS_MS:
                    return (int)System.currentTimeMillis();
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
                case OP_IO_RXR + 1:
                    state.redirectKeyEvent = value != 0;
                    break;
                default:
                    System.out.printf("failure: %x, %d, %d\n", addr, size, value);
                    break;
            }
        }


        return value;
    }

    synchronized ExecutionResult step(boolean isSynchronized) throws Exception
    {
        if (isSynchronized)
        {
            Interrupt intr = null;
            synchronized (this)
            {
                if (state.lastInterrupt != null)
                {
                    intr = state.lastInterrupt;
                    state.lastInterrupt = null;
                }
            }

            try
            {
                InterruptHandler(intr);
            }
            catch (ControlPauseSignal | ControlStopSignal controlSignal)
            {
                state.lastControlSignal = controlSignal;
            }

            return null;
        }
        else
        {
            boolean foundSignals;

            synchronized (this)
            {
                foundSignals = !state.signals.isEmpty();
                while (!state.signals.isEmpty())
                    state.pendingSignals.add(state.signals.pop());
            }

            if (foundSignals)
            {
                Registers regs = cpu.regs.copy();
                cpu.regs.set(PC, cpu.memory.readInt(0x08000000 + 8));
                cpu.regs.set(SP, cpu.regs.get(SP) - 32);
                // end if

                //noinspection Duplicates
                try
                {
                    cpuStep();
                }
                catch (ControlSignal controlSignal)
                {
                    Object object = controlSignal.getObject();
                    if (object instanceof ExecutionResult)
                        return (ExecutionResult) object;

                    if (object != null)
                        throw new Exception(controlSignal);
                }

                // if runing
                cpu.regs = regs;
                return new ExecutionResult.Sleep(0);
            }

            //noinspection Duplicates
            try
            {
                cpuStep();
            }
            catch (ControlSignal controlSignal)
            {
                Object object = controlSignal.getObject();
                if (object instanceof ExecutionResult)
                    return (ExecutionResult) object;

                throw new Exception(controlSignal);
            }

            return new ExecutionResult.Sleep(0);
        }
    }

    private void cpuStep() throws Exception, ControlPauseSignal, ControlStopSignal
    {
        //noinspection CaughtExceptionImmediatelyRethrown
        try
        {
            cpu.run(1000000);
        }
        catch (ControlPauseSignal | ControlStopSignal controlSignal)
        {
            throw controlSignal;
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

    private byte[] loadFirmware() throws IOException
    {
        File file = new File(OpenPieFilePaths.FirmwareFile);
        return Files.readAllBytes(file.toPath());
    }

    private List<Pair<Long, String>> loadMapping() throws IOException
    {
        File file = new File(OpenPieFilePaths.MapFile);
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
        if (state.redirectKeyEvent)
        {
            if (signal.name().equals("key_down"))
            {
                Object[] args = signal.args();
                if (args.length >= 4)
                    state.inputBuffer.add((char) (int) (double) args[1]);

                return;
            }
            else if (signal.name().equals("key_up"))
            {
                return;
            }
        }

        state.signals.add(signal);
    }

    private void interruptResponseJson(Object object) throws InvalidMemoryException
    {
        // TODO: msgpack
        interruptResponseBufferOrEmpty(new Gson().toJson(object).getBytes(StandardCharsets.UTF_8));
    }

    private void interruptResponseBufferOrEmpty(byte[] buffer) throws InvalidMemoryException
    {
        if (buffer != null && buffer.length > 0)
            interruptResponseBuffer(buffer);
        else
            interruptResponseEmpty();
    }

    private void interruptResponseBuffer(byte[] buffer) throws InvalidMemoryException
    {
        cpu.memory.writeInt(bufAddress, bufAddress + 8); // + 0
        cpu.memory.writeInt(bufAddress + 4, buffer.length); // + 4
        cpu.memory.writeBuffer(bufAddress + 8, buffer); // + 8
        cpu.memory.writeByte(bufAddress + 8 + buffer.length, (byte) 0); // + 8 + n
        cpu.regs.set(R0, bufAddress);
    }

    private void interruptResponseEmpty()
    {
        interruptResponseCode(0);
    }

    private void interruptResponseCode(int code)
    {
        cpu.regs.set(R0, code);
    }
}
