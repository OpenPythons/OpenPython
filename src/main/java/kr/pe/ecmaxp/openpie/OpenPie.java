package kr.pe.ecmaxp.openpie;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import li.cil.oc.api.Machine;

@Mod(modid = OpenPie.MODID, name = OpenPie.NAME, version = OpenPie.VERSION)
public class OpenPie
{
    public static final String MODID = "openpie";
    public static final String NAME = "OpenPie";
    public static final String VERSION = "0.4";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

        Machine.add(OpenPieArchitecture.class);
    }
}
