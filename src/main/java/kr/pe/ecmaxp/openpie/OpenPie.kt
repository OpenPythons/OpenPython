package kr.pe.ecmaxp.openpie

import kr.pe.ecmaxp.openpie.arch.OpenPieArchitecture
import li.cil.oc.api.Machine
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.init.Blocks
import net.minecraft.init.Items
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.ResourceLocation
import net.minecraft.world.World
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.registry.GameRegistry
import org.apache.logging.log4j.Logger


@Suppress("UNUSED_PARAMETER", "unused")
@Mod(modid = OpenPie.MODID,
        name = OpenPie.NAME,
        version = OpenPie.VERSION,
        dependencies = "required-after:forgelin;",
        modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter")
object OpenPie {
    const val MODID = "openpie"
    const val NAME = "OpenPie"
    const val VERSION = "0.8"
    private var logger: Logger? = null
    val creativeTab = RinrcCreativeTab();

    @EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        logger = event.modLog
        // MinecraftForge.EVENT_BUS.register(RegisterHandler)

        val registry1 = GameRegistry.findRegistry(Block::class.java)
        val location = ResourceLocation(OpenPie.MODID, "hello")
        FSBlock.registryName = location
        FSBlock.unlocalizedName = location.toString()
        FSBlock.setCreativeTab(OpenPie.creativeTab)
        registry1.register(FSBlock)

        val registry2 = GameRegistry.findRegistry(Item::class.java)
        val blockitem = FSBlock.getItemBlock()
        blockitem.registryName = location
        blockitem.unlocalizedName = location.toString()
        blockitem.setCreativeTab(OpenPie.creativeTab)
        registry2.register(blockitem)

        GameRegistry.registerTileEntity(OpenPieFSTile::class.java, ResourceLocation(OpenPie.MODID, "hello"))
    }

    @EventHandler
    fun init(event: FMLInitializationEvent) {
        // some example code
        logger!!.info("DIRT BLOCK >> {}", Blocks.DIRT.registryName)

        Machine.add(OpenPieArchitecture::class.java)


    }
}

/*
@Suppress("unused")
@Mod.EventBusSubscriber(modid = OpenPie.NAME)
object RegisterHandler {

    @JvmStatic
    @SubscribeEvent
    fun registerBlocks(event: RegistryEvent.Register<Block>) {

    }

    @JvmStatic
    @SubscribeEvent
    fun registerItems(event: RegistryEvent.Register<Item>) {
        val registry = event.registry
        val location = ResourceLocation(OpenPie.MODID, "hello")
        val blockitem = FSBlock.getItemBlock()
        blockitem.registryName = location
        blockitem.unlocalizedName = location.toString()
        blockitem.setCreativeTab(OpenPie.creativeTab)
        registry.register(blockitem)
    }
}
 */

object FSBlock : Block(Material.IRON) {
    override fun hasTileEntity(state: IBlockState): Boolean = true
    override fun createTileEntity(world: World, state: IBlockState): TileEntity? {
        return OpenPieFSTile()
    }

    fun getItemBlock(): ItemBlock {
        return ItemBlock(this)
    }
}

class RinrcCreativeTab internal constructor() : CreativeTabs(OpenPie.MODID) {
    private val ICON = ItemStack(Items.GOLDEN_HELMET)
    override fun getTabIconItem(): ItemStack = ICON
}
