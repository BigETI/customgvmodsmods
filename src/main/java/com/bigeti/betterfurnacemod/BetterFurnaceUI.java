package com.bigeti.betterfurnacemod;

import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;

/**
 * Better furnace UI class
 * 
 * @author Ethem Kurt
 * @version 1.0.0
 * @since 1.0.0
 */
@SideOnly(Side.CLIENT)
public class BetterFurnaceUI extends GuiContainer {

	/**
	 * Resource location
	 */
	private static final ResourceLocation furnace_gui_textures = new ResourceLocation(
			"textures/gui/container/furnace.png");

	private TileEntityFurnace tile_entity_furnace;

	/**
	 * Constructor
	 * 
	 * @param p_i1072_1_
	 *            Container
	 */
	public BetterFurnaceUI(Container p_i1072_1_) {
		super(p_i1072_1_);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
		String inv_name = tile_entity_furnace.hasCustomInventoryName() ? tile_entity_furnace.getInventoryName()
				: I18n.format(tile_entity_furnace.getInventoryName(), new Object[0]);
		fontRendererObj.drawString(inv_name, xSize / 2 - fontRendererObj.getStringWidth(inv_name), 6, 4210752);
		fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, ySize - 94, 4210752);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.minecraft.client.gui.inventory.GuiContainer#
	 * drawGuiContainerBackgroundLayer(float, int, int)
	 */
	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		int t;
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		mc.getTextureManager().bindTexture(furnace_gui_textures);
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		if (tile_entity_furnace.isBurning()) {
			t = tile_entity_furnace.getBurnTimeRemainingScaled(12);
			drawTexturedModalRect(x + 56, y + 48 - t, 176, 12 - t, 14, t + 2);
		}
		drawTexturedModalRect(x + 79, y + 34, 176, 14, tile_entity_furnace.getCookProgressScaled(24) + 1, 16);
	}

}