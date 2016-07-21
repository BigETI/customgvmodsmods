package com.bigeti.rocketbootsmod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingFallEvent;

public class EventHandler {

	@SubscribeEvent
	public void onLivingFall(LivingFallEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			ItemStack armor = player.getCurrentArmor(0);
			if (armor != null) {
				if (armor.getItem().equals(Main.rocketBootsItem)) {
					event.distance = 0.0f;
				}
			}
		}
	}

}
