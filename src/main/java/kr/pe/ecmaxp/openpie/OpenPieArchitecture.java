package kr.pe.ecmaxp.openpie;

import li.cil.oc.api.machine.*;
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
        // System.out.println(toString() + ": recomputeMemory()");
        return true;
    }

    @Override
    public boolean initialize()
    {
        System.out.println(toString() + ": initialize()");
        try
        {
            if (vm != null)
                vm.close();

            vm = new OpenPieVirtualMachine(machine);
            initialized = vm.init();
        }
        catch (Exception e)
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
        step(true);
    }

    @Override
    public ExecutionResult runThreaded(boolean isSynchronizedReturn)
    {
        if (!isSynchronizedReturn) {
            // calling
            if (!step(false)) {
                return new ExecutionResult.Shutdown(false);
            }

            if (vm.state.lastInterrupt != null) {
                return new ExecutionResult.SynchronizedCall();
            }
        }

        return new ExecutionResult.Sleep(0);
    }

    private synchronized boolean step(boolean isSynchronized) {
        try
        {
            vm.step(isSynchronized);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            machine.stop();
            close();
            return false;
        }
    }

    @Override
    public void onSignal()
    {
        Signal signal = machine.popSignal();
        /*
        StringBuilder builder = new StringBuilder();
        builder.append(signal.name());
        builder.append('(');
        for (Object arg: signal.args()) {
            builder.append(arg);
            builder.append(", ");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.deleteCharAt(builder.length() - 1);
        builder.append(')');

        System.out.println(toString() + ": onSignal(" + builder.toString() + ")");
        */
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
        return "OpenPieArchitecture{id=" + id + ", vm=" + (vm == null? "(null)": vm.hashCode()) + '}';
    }
}
