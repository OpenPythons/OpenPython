package kr.pe.ecmaxp.openpie.console;

import kr.pe.ecmaxp.thumbsj.CPU;

import java.io.File;
import java.nio.file.Files;

import static kr.pe.ecmaxp.thumbsj.helper.RegisterIndex.PC;

public class OpenPieMain
{
    static int pos = 0;

    public static void main(String[] args) throws Exception
    {
        CPU cpu = new CPU();

        File file = new File("C:\\Users\\EcmaXp\\Dropbox\\Projects\\openpie\\oprom\\build\\firmware.bin");
        byte[] firmware = Files.readAllBytes(file.toPath());
        cpu.memory.map(0x08000000, 0x100000, false); // flash
        cpu.memory.map(0x20000000, 0x80000, false); // sram
        cpu.memory.map(0x3FFF0000, 0x10000, false); // stack
        cpu.memory.map(0x40000000, 0x10000, true); // peripheral
        cpu.memory.map(0xE0100000, 0x10000, false); // syscall

        int flash = 0x08000000;
        cpu.memory.writeBuffer(flash, firmware);
        cpu.regs.set(PC, cpu.memory.readInt(0x08000000 + 4));

        byte[] line = "print(1, 2, 3)\r\n".getBytes();

        cpu.memory.Hook = (addr, read, size, value) -> {
            if (!read) {
                if (addr == 0x40000000)
                {
                    System.out.append((char) value);
                }
            }

            return 0;
        };

        //noinspection InfiniteLoopStatement
        do
        {
            cpu.run(10000);
        }
        while (true);

        // uc.close();
    }
}
