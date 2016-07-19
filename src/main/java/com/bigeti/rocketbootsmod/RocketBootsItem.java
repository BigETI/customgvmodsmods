package com.bigeti.rocketbootsmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.MovingSoundMinecartRiding;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundEvent;

/**
 * Rocket boots item class
 * 
 * @author Ethem Kurt
 * @version 1.0.0
 * @since 1.0.0
 */
public class RocketBootsItem extends ItemArmor {

	public final static String UNLOCALIZED_NAME = "rocketBootsItem";

	public final static String TEXTURE_NAME = "rocketboots";

	public float original_jump_movement_factor = 0.0f;

	/**
	 * Constructor
	 */
	public RocketBootsItem() {
		super(ArmorMaterial.DIAMOND, 0, 3);
		setUnlocalizedName(UNLOCALIZED_NAME);
		setTextureName(Main.MODID + ":" + UNLOCALIZED_NAME);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return Main.MODID + ":textures/armor/" + TEXTURE_NAME + ".png";
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if (world.isRemote) {
			if (player instanceof EntityPlayerSP) {
				EntityPlayerSP player_sp = (EntityPlayerSP) player;

				boolean mf = false;
				boolean ft = false;
				ItemStack armor = player.getCurrentArmor(0);
				if (armor != null) {
					if (armor.getItem().equals(Main.rocketBootsItem)) {
						GameSettings gs = Minecraft.getMinecraft().gameSettings;
						if (gs.keyBindSneak.getIsKeyPressed()) {
							player_sp.addVelocity(0.0, 0.05, 0.0);
							player_sp.playSound("rocketbootsmod:rocketBootsHalfThrottle", 0.05f, 0.5f);
						} else if (gs.keyBindJump.getIsKeyPressed()) {
							player_sp.addVelocity(0.0, 0.125, 0.0);
							ft = true;
						} else {
							player_sp.addVelocity(0.0, 0.075, 0.0);
							player_sp.playSound("rocketbootsmod:rocketBootsHalfThrottle", 0.1f, 1.0f);
						}
						if ((!gs.keyBindSneak.getIsKeyPressed())
								&& (gs.keyBindForward.getIsKeyPressed() || gs.keyBindBack.getIsKeyPressed()
										|| gs.keyBindLeft.getIsKeyPressed() || gs.keyBindRight.getIsKeyPressed()))
							ft = true;
						if (ft)
							player_sp.playSound("rocketbootsmod:rocketBootsFullThrottle", 0.2f, 2.0f);
						mf = true;
					}
				}
				if (original_jump_movement_factor == 0.0f)
					original_jump_movement_factor = player.jumpMovementFactor;
				player.jumpMovementFactor = (mf ? (original_jump_movement_factor * 5.0f)
						: original_jump_movement_factor);
			}
		}
	}
}
