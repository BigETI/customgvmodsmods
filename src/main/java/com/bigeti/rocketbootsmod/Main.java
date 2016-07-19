package com.bigeti.rocketbootsmod;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.common.MinecraftForge;

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
	public static final String MODID = "rocketbootsmod";

	/**
	 * Mod name
	 */
	public static final String MODNAME = "Rocket boots";

	/**
	 * Mod version
	 */
	public static final String VERSION = "1.0.0";

	/**
	 * Sided proxy
	 */
	@SidedProxy(clientSide = "com.bigeti.rocketbootsmod.ClientProxy", serverSide = "com.bigeti.rocketbootsmod.ServerProxy")
	public static ICommonProxy proxy;

	/**
	 * Rocket boots item
	 */
	public static Item rocketBootsItem;

	/**
	 * Pre-Init
	 * 
	 * @param event
	 *            Event
	 */
	@cpw.mods.fml.common.Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		rocketBootsItem = new RocketBootsItem();
		GameRegistry.registerItem(rocketBootsItem, "rocketBootsItem");
		EventHandler handler = new EventHandler();
		MinecraftForge.EVENT_BUS.register(handler);
		FMLCommonHandler.instance().bus().register(handler);
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
