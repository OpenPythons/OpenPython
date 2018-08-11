package kr.pe.ecmaxp.openpie.console;

import junicorn.MemoryAccessHook;
import junicorn.Unicorn;
import junicorn.UnicornException;
import kr.pe.ecmaxp.openpie.PeripheralAddress;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;

import static junicorn.UnicornNative.uc_version;
import static junicorn.ArmConst.UC_ARM_REG_PC;
import static junicorn.UnicornConst.UC_PROT_EXEC;
import static junicorn.UnicornConst.UC_PROT_READ;
import static junicorn.UnicornConst.UC_PROT_WRITE;
import static junicorn.UnicornConst.*;

public class OpenPieMain
{
    static int pos = 0;

    public static void main(String[] args) throws Exception
    {
        System.loadLibrary("unicorn");
        Unicorn uc = new Unicorn(UC_ARCH_ARM, UC_MODE_THUMB);

        File file = new File("C:\\Users\\EcmaXp\\Dropbox\\Projects\\openpie\\oprom\\build\\firmware.bin");
        byte[] firmware = Files.readAllBytes(file.toPath());
        uc.mem_map(0x08000000, 0x100000, UC_PROT_READ | UC_PROT_EXEC); // flash
        uc.mem_map(0x20000000, 0x80000, UC_PROT_READ | UC_PROT_WRITE); // sram
        uc.mem_map(0x3FFF0000, 0x10000, UC_PROT_READ | UC_PROT_WRITE); // stack
        uc.mem_map(0x40000000, 0x10000, UC_PROT_READ | UC_PROT_WRITE); // peripheral
        uc.mem_map(0xE0100000, 0x10000, UC_PROT_READ | UC_PROT_WRITE); // syscall

        long flash = 0x08000000;
        uc.mem_write(flash, firmware);
        uc.reg_write(UC_ARM_REG_PC, 0x8019614);

        byte[] line = "print(1, 2, 3)\r\n".getBytes();

        uc_version();

        //noinspection InfiniteLoopStatement
        do
        {
            long addr = uc.reg_read(UC_ARM_REG_PC);
            uc.emu_start(addr | 1, flash + 0x100000, 0, 10000);
        }
        while (true);

        // uc.close();
    }

    public MemoryAccessHook WriteAccessHook = (uc2, type, address, size, value, user) ->
    {
        if (address == 0x40000000)
        {
            System.out.append((char) value);
        }
        // System.out.printf("write: %x, %d, %d\n", address, size, value);
    };
}
