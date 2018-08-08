package kr.pe.ecmaxp.openpie.console;

import unicorn.*;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;

import static unicorn.ArmConst.UC_ARM_REG_PC;
import static unicorn.UnicornConst.*;

public class OpenPieMain
{
    private static Unicorn uc;
    private static int pos = 0;

    public static void main(String[] args)
    {
        try
        {
            System.loadLibrary("unicorn_x64");
            uc = new Unicorn(UC_ARCH_ARM, UC_MODE_THUMB);

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

            uc.hook_add((ReadHook) (u, address, size, user) ->
            {
                // if invaild page then error
                // uc.mem_write(address, new byte[]{1, 2, 3, 4});

                int value = 0;
                if (address == 0x4000010c) {
                    value = 0x80000;
                } else if (address == 0x40000110) {
                    value = 0x10000;
                } else if (address == 0x40000004) {
                    if (pos < line.length) {
                        byte ch = line[pos];
                        value = ch;
                        pos++;
                    }
                } else {
                    System.out.printf("read: %x, %d\r\n", address, size);
                }

                ByteBuffer buffer = ByteBuffer.allocate(4);
                buffer.order(ByteOrder.LITTLE_ENDIAN);
                buffer.putInt(value);

                byte[] buf = buffer.array();
                u.mem_write(address, buf);
            }, 0x40000000, 0x40000000 + 0x10000, null);

            uc.hook_add((uc, address, size, value, user) ->
            {
                if (address == 0x40000000) {
                    System.out.append((char)value);
                }
                // System.out.printf("write: %x, %d, %d\n", address, size, value);
            }, 0x40000000, 0x40000000 + 0x10000, null);

            uc.hook_add((u, address, size, value, user) ->
            {
                System.out.printf("failure: %x, %d, %d\n", address, size, value);
                return false;
            }, UC_HOOK_MEM_READ_UNMAPPED, null);

            while (true) {
                long addr = ((Number)uc.reg_read(UC_ARM_REG_PC)).longValue();
                uc.emu_start(addr | 1, flash + 0x100000, 0, 0);
            }
        }
        catch (Exception e)
        {
            System.out.println(uc.reg_read(UC_ARM_REG_PC));
            e.printStackTrace();
        }
    }

    private static int fromByteArray(byte[] bytes)
    {
        return bytes[0] << 24 | (bytes[1] & 0xFF) << 16 | (bytes[2] & 0xFF) << 8 | (bytes[3] & 0xFF);
    }
}
