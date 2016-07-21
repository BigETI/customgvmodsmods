package com.bigeti.rocketbootsmod;

import com.bigeti.interfaces.ICommonProxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

/**
 * Client proxy class
 * 
 * @author Ethem Kurt
 * @version 1.0.1
 * @since 1.0.0
 */
public class ClientProxy implements ICommonProxy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bigeti.rocketbootsmod.ICommonProxy#preInit(cpw.mods.fml.common.event.
	 * FMLPreInitializationEvent)
	 */
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		ClientEventHandler handler = new ClientEventHandler();
		MinecraftForge.EVENT_BUS.register(handler);
		FMLCommonHandler.instance().bus().register(handler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bigeti.rocketbootsmod.ICommonProxy#init(cpw.mods.fml.common.event.
	 * FMLInitializationEvent)
	 */
	@Override
	public void init(FMLInitializationEvent event) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bigeti.rocketbootsmod.ICommonProxy#postInit(cpw.mods.fml.common.event
	 * .FMLPostInitializationEvent)
	 */
	@Override
	public void postInit(FMLPostInitializationEvent event) {
	}

}
