package kr.pe.ecmaxp.openpie

import net.minecraft.init.Blocks
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import org.apache.logging.log4j.Logger
import li.cil.oc.api.Machine

@Mod(modid = OpenPie.MODID, name = OpenPie.NAME, version = OpenPie.VERSION)
class OpenPie {

    @EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        logger = event.modLog
    }

    @EventHandler
    fun init(event: FMLInitializationEvent) {
        // some example code
        logger!!.info("DIRT BLOCK >> {}", Blocks.DIRT.registryName)

        Machine.add(OpenPieArchitecture::class.java)
    }

    companion object {
        val MODID = "openpie"
        val NAME = "OpenPie"
        val VERSION = "0.4"

        private var logger: Logger? = null
    }
}
