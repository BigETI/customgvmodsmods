package com.bigeti.betterfurnacemod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerEx extends Container {
	
	public ContainerEx(EntityPlayer player, Container container) {
		
	}

	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		return true;
	}

}