package kr.pe.ecmaxp.openpython

import kr.pe.ecmaxp.openpython.arch.OpenComputersLikeSaveHandler
import kr.pe.ecmaxp.openpython.arch.OpenPythonFirmware
import kr.pe.ecmaxp.openpython.arch.versions.OpenPythonArchitecture_v1_0
import li.cil.oc.api.FileSystem
import li.cil.oc.api.Items
import li.cil.oc.api.Machine
import net.minecraft.item.EnumDyeColor
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent


@Suppress("UNUSED_PARAMETER", "unused")
@Mod(modid = OpenPython.MODID,
        name = OpenPython.NAME,
        version = OpenPython.VERSION,
        dependencies = "required-after:forgelin;required-after:opencomputers;",
        modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter"
        /*@MCVERSIONDEP@*/)
object OpenPython {
    const val MODID = "openpython"
    const val NAME = "OpenPython"
    const val VERSION = "1.0.1"

    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(OpenComputersLikeSaveHandler)
        Machine.add(OpenPythonArchitecture_v1_0::class.java)
    }

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        Items.registerFloppy(
                "openpython",
                EnumDyeColor.BLUE,
                { FileSystem.fromClass(this.javaClass, OpenPython.MODID, "opos") },
                true
        ).setStackDisplayName("OpenPython OS (Operating System for micropython)")

        Items.registerEEPROM(
                "EEPROM (OpenPython BIOS)",
                OpenPythonFirmware.v1_0_1.loadEEPROM(),
                byteArrayOf(),
                false
        )
    }
}
