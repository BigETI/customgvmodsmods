package com.bigeti.betterfurnacemod;

import com.bigeti.interfaces.ICommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.ExistingSubstitutionException;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

/**
 * Main class
 * 
 * @author Ethem Kurt (BigETI)
 * @version 1.0.0
 * @since 1.0.0
 */
@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main {

	/**
	 * Mod ID
	 */
	public static final String MODID = "betterfurnacemod";

	/**
	 * Mod name
	 */
	public static final String MODNAME = "Better furnace";

	/**
	 * Mod version
	 */
	public static final String VERSION = "1.0.0";

	/**
	 * Sided proxy
	 */
	@SidedProxy(clientSide = "com.bigeti.betterfurnacemod.ClientProxy", serverSide = "com.bigeti.betterfurnacemod.ServerProxy")
	public static ICommonProxy proxy;
	
	private static final ResourceLocation FURNACE_RESOURCE_LOCATION = new ResourceLocation("minecraft", "furnace");
	
	public static BlockBetterFurnace blockBetterFurnace;
	
	public static Item betterFurnaceItem;

	/**
	 * Pre-Init
	 * 
	 * @param event
	 *            Event
	 */
	@cpw.mods.fml.common.Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		blockBetterFurnace = new BlockBetterFurnace(false);
		try {
			System.out.println("WEEEEEEEEEEEEEEEEEEEE");
			Item item = new ItemBlock(blockBetterFurnace).setMaxStackSize(64).setCreativeTab(CreativeTabs.tabDecorations).setTextureName("minecraft:furnace").setUnlocalizedName("furnace");
			GameRegistry.addSubstitutionAlias("minecraft:furnace", GameRegistry.Type.BLOCK, blockBetterFurnace);
			GameRegistry.addSubstitutionAlias("minecraft:furnace", GameRegistry.Type.ITEM, item);
		} catch (ExistingSubstitutionException e) {
			e.printStackTrace();
		}
		proxy.preInit(event);
	}

	/**
	 * Init mod
	 * 
	 * @param event
	 *            Event
	 */
	@cpw.mods.fml.common.Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	/**
	 * Post-Init
	 * 
	 * @param event
	 *            Event
	 */
	@cpw.mods.fml.common.Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}