package kr.pe.ecmaxp.thumbsj;

import kr.pe.ecmaxp.thumbsj.helper.BitConsts;
import kr.pe.ecmaxp.thumbsj.helper.RegisterIndex;

public class Registers
{
    private int[] _regs;

    @SuppressWarnings("WeakerAccess")
    public Registers()
    {
        _regs = new int[RegisterIndex.CPSR + 1];
        _regs[RegisterIndex.CPSR] = (
                BitConsts.FT | // set Thumb
                        BitConsts.FZ // set Zero
        );
    }

    @SuppressWarnings("WeakerAccess")
    public int[] load()
    {
        return _regs.clone();
    }

    @SuppressWarnings("WeakerAccess")
    public void store(int[] regs)
    {
        _regs = regs.clone();
    }

    public Registers copy()
    {
        Registers registers = new Registers();
        int[] regs = load();
        registers.store(regs);
        return registers;
    }

    public void set(int index, int value)
    {
        _regs[index] = value;
    }

    public int get(int index)
    {
        return _regs[index];
    }
}
