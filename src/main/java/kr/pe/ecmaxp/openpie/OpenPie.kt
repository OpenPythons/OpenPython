package kr.pe.ecmaxp.openpie

import kr.pe.ecmaxp.openpie.arch.OpenComputersLikeSaveHandler
import kr.pe.ecmaxp.openpie.arch.OpenPieArchitecture
import kr.pe.ecmaxp.openpie.arch.OpenPieFirmware
import li.cil.oc.api.FileSystem
import li.cil.oc.api.Items
import li.cil.oc.api.Machine
import net.minecraft.item.EnumDyeColor
import net.minecraftforge.common.MinecraftForge
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
        MinecraftForge.EVENT_BUS.register(OpenComputersLikeSaveHandler)
        Machine.add(OpenPieArchitecture::class.java)
    }

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        Items.registerFloppy(
                "openpie",
                EnumDyeColor.BLUE,
                { FileSystem.fromClass(this.javaClass, OpenPie.MODID, "opos") },
                true
        ).setStackDisplayName("OpenPie (Operating System)")

        Items.registerEEPROM(
                "EEPROM (OpenPie)",
                OpenPieFirmware.DEBUG.loadEEPROM(),
                byteArrayOf(),
                false
        )
    }
}
