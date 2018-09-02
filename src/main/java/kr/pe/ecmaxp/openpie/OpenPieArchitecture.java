package kr.pe.ecmaxp.openpie;

import kr.pe.ecmaxp.thumbsj.signal.ControlPauseSignal;
import kr.pe.ecmaxp.thumbsj.signal.ControlSignal;
import kr.pe.ecmaxp.thumbsj.signal.ControlStopSignal;
import li.cil.oc.api.machine.Architecture;
import li.cil.oc.api.machine.ExecutionResult;
import li.cil.oc.api.machine.Machine;
import li.cil.oc.api.machine.Signal;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;

@Architecture.Name("OpenPie (micropython 3)")
public class OpenPieArchitecture implements Architecture
{
    private final Machine machine;
    private boolean initialized;

    private OpenPieVirtualMachine vm;
    private ExecutionResult lastSynchronizedResult;

    public OpenPieArchitecture(Machine machine)
    {
        this.machine = machine;
    }

    @Override
    public boolean isInitialized()
    {
        return initialized;
    }

    @Override
    public boolean recomputeMemory(Iterable<ItemStack> iterable)
    {
        // vm.getTotalMemorySize();
        // System.out.println(toString() + ": recomputeMemory()");
        return true;
    }

    // TODO: report exception handler?

    @Override
    public boolean initialize()
    {
        close();

        try
        {
            vm = new OpenPieVirtualMachine(machine);
            initialized = vm.init();
            return initialized;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            initialized = false;
            return initialized;
        }
    }

    @Override
    public void close()
    {
        if (vm != null)
        {
            vm.close();
            vm = null;
        }
    }

    @Override
    public synchronized void runSynchronized()
    {
        try
        {
            this.lastSynchronizedResult = vm.step(true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            this.lastSynchronizedResult = new ExecutionResult.Error(e.toString());
        }
    }

    @Override
    public synchronized ExecutionResult runThreaded(boolean isSynchronizedReturn)
    {
        FileTime prev = DebugFirmwareGetLastModifiedTime();
        ExecutionResult result;

        if (!isSynchronizedReturn)
        {
            // calling
            try
            {
                result = vm.step(false);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return new ExecutionResult.Error(e.toString());
            }

            FileTime next = DebugFirmwareGetLastModifiedTime();
            if (prev != null && !prev.equals(next))
                return new ExecutionResult.Shutdown(true);

            return result;
        }
        else
        {
            result = this.lastSynchronizedResult;
            this.lastSynchronizedResult = null;
            return result;
        }
    }

    private FileTime DebugFirmwareGetLastModifiedTime()
    {
        File file = new File("C:\\Users\\EcmaXp\\Dropbox\\Projects\\openpie\\oprom\\build\\firmware.bin");
        try
        {
            return Files.getLastModifiedTime(file.toPath());
        }
        catch (IOException ignored)
        {
        }

        return null;
    }

    @Override
    public void onSignal()
    {
        Signal signal = machine.popSignal();
        vm.onSignal(signal);
    }

    @Override
    public void onConnect()
    {
        System.out.println(toString() + ": onConnect()");
    }

    @Override
    public void load(NBTTagCompound nbtTagCompound)
    {
        // System.out.println(toString() + ": loadNBT()");
    }

    @Override
    public void save(NBTTagCompound nbtTagCompound)
    {
        // System.out.println(toString() + ": saveNBT()");
    }

    @Override
    public String toString()
    {
        return "OpenPieArchitecture{" +
                "vm=" + vm +
                '}';
    }
}
