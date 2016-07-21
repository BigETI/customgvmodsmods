package com.bigeti.interfaces;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Common proxy interface
 * 
 * @author Ethem Kurt
 * @version 1.0.1
 * @since 1.0.0
 */
public interface ICommonProxy {

	/**
	 * Pre-Init
	 * 
	 * @param event
	 *            Event
	 */
	public void preInit(FMLPreInitializationEvent event);

	/**
	 * Load
	 * 
	 * @param event
	 *            Event
	 */
	public void init(FMLInitializationEvent event);

	/**
	 * Post-Init
	 * 
	 * @param event
	 *            Event
	 */
	public void postInit(FMLPostInitializationEvent event);
}