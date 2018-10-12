package kr.pe.ecmaxp.openpie

import kr.pe.ecmaxp.openpie.arch.OpenPieArchitecture
import li.cil.oc.api.FileSystem
import li.cil.oc.api.Items
import li.cil.oc.api.Machine
import net.minecraft.item.EnumDyeColor
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent


@Suppress("UNUSED_PARAMETER", "unused")
@Mod(modid = OpenPie.MODID,
        name = OpenPie.NAME,
        version = OpenPie.VERSION,
        dependencies = "required-after:forgelin;required-after:opencomputers;",
        modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter")
object OpenPie {
    const val MODID = "openpie"
    const val NAME = "OpenPie"
    const val VERSION = "0.9.9"

    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        Machine.add(OpenPieArchitecture::class.java)
    }

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        Items.registerFloppy("openpie", EnumDyeColor.BLUE, {
            FileSystem.fromClass(this.javaClass, OpenPie.MODID, "opos")
        }, true) // .setStackDisplayName("OpenPie (Operating System)")

        Items.registerEEPROM("EEPROM (OpenPie)", """#!micropython
from ucomputer import invoke, components, crash, get_computer_address
from uio import FileIO


init = '/init.py'


def get_component(t):
    seq = components(t)
    return seq[0] if seq else None


filesystems = components("filesystem")
def check_bootable(address):
    return address and address in filesystems and invoke(address, 'exists', init)


def load(address):
    file = invoke(address, 'open', init, 'r')

    try:
        buffer = []
        while True:
            buf = invoke(address, 'read', file, 4096)
            if not buf: break
            buffer.append(buf)
    finally:
        invoke(address, 'close', file)

    content = b"".join(buffer)
    return content.decode()

def main():
    address = invoke(__path__, 'getData').decode()
    if not check_bootable(address):
        invoke(__path__, 'setData', b'')
        for address in filesystems:
            if check_bootable(address):
                break
        else:
            crash("no bootable medium found")

    computer = get_computer_address()
    invoke(computer, 'beep', 1000, 0.2)

    gpu = get_component("gpu")
    monitor = get_component("monitor")
    if gpu and monitor:
        invoke(gpu, "bind", monitor)

    content = load(address)
    context = {'__name__': '__main__', '__path__': address}
    func = compile(content, init, "exec")
    exec(func, context)


if __name__ == '__main__':
    main()
        """.trim().toByteArray(), byteArrayOf(), false)
    }
}
