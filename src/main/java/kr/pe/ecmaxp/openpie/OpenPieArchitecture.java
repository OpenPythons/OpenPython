package kr.pe.ecmaxp.openpie;

import junicorn.UnicornException;
import li.cil.oc.api.machine.Architecture;
import li.cil.oc.api.machine.ExecutionResult;
import li.cil.oc.api.machine.Machine;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

@Architecture.Name("OpenPie (micropython 3)")
public class OpenPieArchitecture implements Architecture
{
    private final Machine machine;
    private boolean initialized;

    private OpenPieVirtualMachine vm;
    private int id;
    private static int global_id = 1;

    public OpenPieArchitecture(Machine machine)
    {
        this.machine = machine;
        this.id = global_id++;
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
        System.out.println(toString() + ": recomputeMemory()");
        return true;
    }

    @Override
    public boolean initialize()
    {
        System.out.println(toString() + ": initialize()");
        try
        {
            vm = new OpenPieVirtualMachine();
            initialized = vm.init();
        }
        catch (UnicornException e)
        {
            e.printStackTrace();
            return false;
        }

        return initialized;
    }

    @Override
    public void close()
    {
        System.out.println(toString() + ": close()");
        if (vm != null)
        {
            vm.close();
            vm = null;
        }
    }

    @Override
    public void runSynchronized()
    {
        synchronized (this)
        {
            try
            {
                vm.step();
            }
            catch (UnicornException e)
            {
                e.printStackTrace();
                machine.stop();
                close();
            }
        }
    }

    @Override
    public ExecutionResult runThreaded(boolean isSynchronizedReturn)
    {
        if (!isSynchronizedReturn)
            synchronized (this)
            {
                try
                {
                    vm.step();
                }
                catch (UnicornException e)
                {
                    e.printStackTrace();
                    machine.stop();
                    close();
                }
            }

        return new ExecutionResult.Sleep(0);
    }

    @Override
    public void onSignal()
    {
        System.out.println(toString() + ": onSignal()");
    }

    @Override
    public void onConnect()
    {
        System.out.println(toString() + ": onConnect()");
    }

    @Override
    public void load(NBTTagCompound nbtTagCompound)
    {
        System.out.println(toString() + ": loadNBT()");
    }

    @Override
    public void save(NBTTagCompound nbtTagCompound)
    {
        System.out.println(toString() + ": saveNBT()");
    }

    @Override
    public String toString()
    {
        return "OpenPieArchitecture{id=" + id + ", vm=" + vm + '}';
    }
}
