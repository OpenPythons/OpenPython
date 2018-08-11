package kr.pe.ecmaxp.openpie;

import junicorn.MemoryAccessHook;
import junicorn.MemoryInvaildHook;
import junicorn.Unicorn;
import junicorn.UnicornException;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;

import static junicorn.ArmConst.UC_ARM_REG_PC;
import static junicorn.UnicornConst.*;


public class OpenPieVirtualMachine
{
    private Unicorn uc;
    private static final int flash = 0x08000000;

    static
    {
        // TODO: drop dll when starting mod
        System.loadLibrary("unicorn");
    }

    OpenPieVirtualMachine() throws UnicornException
    {
        uc = new Unicorn(UC_ARCH_ARM, UC_MODE_THUMB);
    }

    private static int fromByteArray(byte[] bytes)
    {
        return bytes[3] << 24 | (bytes[2] & 0xFF) << 16 | (bytes[1] & 0xFF) << 8 | (bytes[0] & 0xFF);
    }

    boolean init() throws UnicornException
    {
        File file = new File("C:\\Users\\EcmaXp\\Dropbox\\Projects\\openpie\\oprom\\build\\firmware.bin");
        byte[] firmware = new byte[0];

        try
        {
            firmware = Files.readAllBytes(file.toPath());
        }
        catch (IOException e)
        {
            return false;
        }

        uc.mem_map(flash, 0x100000, UC_PROT_READ | UC_PROT_EXEC); // flash
        uc.mem_map(0x20000000, 0x80000, UC_PROT_READ | UC_PROT_WRITE); // sram
        uc.mem_map(0x3FFF0000, 0x10000, UC_PROT_READ | UC_PROT_WRITE); // stack
        uc.mem_map(0x40000000, 0x10000, UC_PROT_READ | UC_PROT_WRITE); // peripheral
        uc.mem_map(0xE0100000, 0x10000, UC_PROT_READ | UC_PROT_WRITE); // syscall

        uc.mem_write(flash, firmware);
        uc.reg_write(UC_ARM_REG_PC, fromByteArray(uc.mem_read(flash + 4, 4)));
        System.out.printf("%x\n", fromByteArray(uc.mem_read(flash, 4)));

        byte[] line = "print(1, 2, 3)\r\n".getBytes();
        int[] pos = new int[]{0};

        //noinspection Duplicates
        uc.hook_add(UC_HOOK_MEM_READ, (MemoryAccessHook) (uc, type, address, size, value, user) ->
        {
            // if invaild page then error
            // uc.mem_write(address, new byte[]{1, 2, 3, 4});

            if (address == 0x4000010c)
            {
                value = 0x80000;
            }
            else if (address == 0x40000110)
            {
                value = 0x10000;
            }
            else if (address == 0x40000004)
            {
                if (pos[0] < line.length)
                {
                    byte ch = line[pos[0]];
                    value = ch;
                    pos[0]++;
                }
            }
            else
            {
                System.out.printf("read: %x, %d\r\n", address, size);
            }

            ByteBuffer buffer = ByteBuffer.allocate(4);
            buffer.order(ByteOrder.LITTLE_ENDIAN);
            buffer.putInt((int) value);
            byte[] buf = buffer.array();

            try
            {
                uc.mem_write(address, buf);
            }
            catch (UnicornException e)
            {
                e.printStackTrace();
                return;
            }

        }, 0x40000000, 0x40000000 + 0x10000, null);

        uc.hook_add(UC_HOOK_MEM_WRITE, (MemoryAccessHook) (uc, type, address, size, value, user) ->
        {
            if (address == 0x40000000)
            {
                System.out.append((char) value);
            }
            // System.out.printf("write: %x, %d, %d\n", address, size, value);
        }, 0x40000000, 0x40000000 + 0x10000, null);

        uc.hook_add(UC_HOOK_MEM_READ_UNMAPPED, (MemoryInvaildHook) (u, type, address, size, value, user) ->
        {
            System.out.printf("failure: %x, %d, %d\n", address, size, value);
            return false;
        }, 1, 0, null);

        return true;
    }

    void step() throws UnicornException
    {
        long addr = uc.reg_read(UC_ARM_REG_PC);
        // System.out.printf("%x\n", uc.reg_read(UC_ARM_REG_PC));
        try
        {
            uc.emu_start(addr | 1, flash + 0x100000, 0, 10000);
        }
        catch (UnicornException e)
        {
            System.out.printf("E %x\n", uc.reg_read(UC_ARM_REG_PC));
            throw e;
        }
    }

    int getTotalMemorySize()
    {
        return 0x80000 + 0x10000;
    }

    void close()
    {
        if (uc != null)
        {
            try
            {
                uc.close();
            }
            catch (UnicornException e)
            {
                e.printStackTrace();
            }

            uc = null;
        }
    }
}
