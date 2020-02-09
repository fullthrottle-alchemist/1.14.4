package com.mrphd.fta.item;

import com.mrphd.fta.client.gui.ClipboardScreen;
import com.mrphd.fta.itemgroup.ModItemGroups;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class Clipboard extends ItemBase {

	public Clipboard() {
		super("clipboard", new Properties(), ModItemGroups.DEFAULT);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(final World world, final PlayerEntity player, final Hand hand) {
		final ItemStack stack = player.getHeldItem(hand);
		if(!world.isRemote && stack.getItem() == this) {
			Minecraft.getInstance().displayGuiScreen(new ClipboardScreen(player));
			return new ActionResult<>(ActionResultType.SUCCESS, stack);
		}
		return super.onItemRightClick(world, player, hand);
	}
	
	@Override
	public ActionResultType onItemUseFirst(final ItemStack stack, final ItemUseContext context) {
		return ActionResultType.FAIL;
	}
	
}
