package kr.pe.ecmaxp.openpie.console;

import kr.pe.ecmaxp.thumbsj.CPU;
import kr.pe.ecmaxp.thumbsj.Memory;
import kr.pe.ecmaxp.thumbsj.MemoryFlag;
import kr.pe.ecmaxp.thumbsj.signal.ControlPauseSignal;
import kr.pe.ecmaxp.thumbsj.signal.ControlStopSignal;

import java.io.File;
import java.nio.file.Files;

import static kr.pe.ecmaxp.thumbsj.helper.RegisterIndex.PC;

public class OpenPieMain
{
    static int pos = 0;

    public static void main(String[] args) throws Exception, ControlPauseSignal, ControlStopSignal
    {
        CPU cpu = new CPU();

        File file = new File("C:\\Users\\EcmaXp\\Dropbox\\Projects\\openpie\\oprom\\build\\firmware.bin");
        byte[] firmware = Files.readAllBytes(file.toPath());
        final int KB = 1024;
        Memory memory = cpu.memory;
        memory.map(0x08000000, 256 * KB, MemoryFlag.RX); // flash
        memory.map(0x20000000, 64 * KB, MemoryFlag.RW); // sram
        memory.map(0x40000000, 4 * KB, (addr, read, size, value) ->
        {
            if (!read)
            {
                if (addr == 0x40000000)
                {
                    System.out.append((char) value);
                }
            }

            return 0;
        }); // peripheral
        memory.map(0x60000000, 192 * KB, MemoryFlag.RW); // ram
        memory.map(0xE0000000, 16 * KB, MemoryFlag.RW); // syscall

        int flash = 0x08000000;
        cpu.memory.writeBuffer(flash, firmware);
        cpu.regs.set(PC, cpu.memory.readInt(0x08000000 + 4));

        byte[] line = "print(1, 2, 3)\r\n".getBytes();

        //noinspection InfiniteLoopStatement
        do
        {
            cpu.run(10000);
        }
        while (true);

        // uc.close();
    }
}
