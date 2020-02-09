package com.mrphd.fta.client.gui;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mrphd.fta.Main;
import com.mrphd.fta.inventory.container.ClipboardContainer;
import com.mrphd.fta.util.ModUtils;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

public class ClipboardScreen extends ContainerScreen<ClipboardContainer> {

	private static final ResourceLocation CLIPBOARD_TEXTURES = ModUtils.registryOf("textures/gui/clipboard.png");
	   
	public ClipboardScreen(final PlayerEntity player) {
		super(new ClipboardContainer(player.inventory), player.inventory, new TranslationTextComponent("gui.ftalchemist.clipboard"));
	}

	@Override
	protected void init() {
		super.init();
		this.xSize = 176;
		this.ySize = 157;
		this.guiLeft = width < xSize ? 0 : (width - xSize) / 2;
		this.<ImageButton>addButton(new ImageButton(guiLeft + 88, guiTop + 15, 11, 11, 176, 0, 0, CLIPBOARD_TEXTURES, button -> {
			Main.LOGGER.info("Balance button clicked!");
		}));
		this.<ImageButton>addButton(new ImageButton(guiLeft + 81, guiTop + 56, 11, 11, 176, 11, 0, CLIPBOARD_TEXTURES, button -> {
			Main.LOGGER.info("Circle button clicked!");
		}));
		this.<ImageButton>addButton(new ImageButton(guiLeft + 95, guiTop + 56, 11, 11, 176, 22, 0, CLIPBOARD_TEXTURES, button -> {
			Main.LOGGER.info("Down button clicked!");
		}));
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
		super.render(mouseX, mouseY, partialTicks);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
//		this.font.drawString(this.title.getFormattedText(), 28.0F, 6.0F, 4210752);
//		this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float) (this.ySize - 96 + 2), 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		minecraft.getTextureManager().bindTexture(CLIPBOARD_TEXTURES);
		int i = this.guiLeft;
		int j = (this.height - this.ySize) / 2;
		this.blit(i, j, 0, 0, this.xSize, this.ySize);
	}

	@Override
	protected boolean isPointInRegion(int p_195359_1_, int p_195359_2_, int p_195359_3_, int p_195359_4_, double p_195359_5_, double p_195359_7_) {
		return super.isPointInRegion(p_195359_1_, p_195359_2_, p_195359_3_, p_195359_4_, p_195359_5_, p_195359_7_);
	}

	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
		return super.mouseClicked(mouseX, mouseY, mouseButton);
	}

	@Override
	protected boolean hasClickedOutside(double mouseX, double mouseY, int xOff, int yOff, int mouseButton) {
		return super.hasClickedOutside(mouseX, mouseY, xOff, yOff, mouseButton);
	}

	@Override
	protected void handleMouseClick(Slot slot, int slotId, int mouseButton, ClickType type) {
		super.handleMouseClick(slot, slotId, mouseButton, type);
	}
	
	@Override
	public void removed() {
		super.removed();
	}

}
