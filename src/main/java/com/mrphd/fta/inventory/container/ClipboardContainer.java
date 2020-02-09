package com.mrphd.fta.inventory.container;

import java.util.Optional;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.CraftingResultSlot;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.network.play.server.SSetSlotPacket;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ClipboardContainer extends Container {

	private final CraftingInventory crafting = new CraftingInventory(this, 3, 3);
	private final CraftResultInventory result = new CraftResultInventory();
	private final IWorldPosCallable pos;
	private final PlayerEntity player;

	public ClipboardContainer(PlayerInventory inventoryPlayer) {
		super(ContainerType.CRAFTING, 0);
		this.pos = IWorldPosCallable.DUMMY;
		this.player = inventoryPlayer.player;
		this.addSlot(new CraftingResultSlot(inventoryPlayer.player, this.crafting, this.result, 0, 113, 34));
		
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				this.addSlot(new Slot(this.crafting, j + i * 3, 25 + j * 18, 16 + i * 18));
			}
		}

		for (int k = 0; k < 3; ++k) {
			for (int i1 = 0; i1 < 9; ++i1) {
				this.addSlot(new Slot(inventoryPlayer, i1 + k * 9 + 9, 8 + i1 * 18, 79 + k * 18));
			}
		}

		for (int l = 0; l < 9; ++l) {
			this.addSlot(new Slot(inventoryPlayer, l, 8 + l * 18, 137));
		}
	}

	private static void updateRecipe(int slot, World world, PlayerEntity player, CraftingInventory crafting, CraftResultInventory result) {
		if (!world.isRemote) {
			ServerPlayerEntity serverplayerentity = (ServerPlayerEntity) player;
			ItemStack itemstack = ItemStack.EMPTY;
			Optional<ICraftingRecipe> optional = world.getServer().getRecipeManager().getRecipe(IRecipeType.CRAFTING, crafting, world);
			if (optional.isPresent()) {
				ICraftingRecipe icraftingrecipe = optional.get();
				if (result.canUseRecipe(world, serverplayerentity, icraftingrecipe)) {
					itemstack = icraftingrecipe.getCraftingResult(crafting);
				}
			}

			result.setInventorySlotContents(0, itemstack);
			serverplayerentity.connection.sendPacket(new SSetSlotPacket(slot, 0, itemstack));
		}
	}

	@Override
	public void onCraftMatrixChanged(final IInventory inventory) {
		this.pos.consume((world, pos) -> {
			updateRecipe(this.windowId, world, this.player, this.crafting, this.result);
		});
	}

	public boolean matches(final IRecipe<? super CraftingInventory> recipe) {
		return recipe.matches(this.crafting, this.player.world);
	}

	@Override
	public void onContainerClosed(final PlayerEntity player) {
		super.onContainerClosed(player);
		this.pos.consume((world, pos) -> {
			this.clearContainer(player, world, this.crafting);
		});
	}

	@Override
	public boolean canInteractWith(final PlayerEntity player) {
		return true;
	}
	
	@Override
	public ItemStack transferStackInSlot(final PlayerEntity player, final int index) {
		ItemStack itemstack = ItemStack.EMPTY;
	      final Slot slot = this.inventorySlots.get(index);
	      if (slot != null && slot.getHasStack()) {
	         final ItemStack itemstack1 = slot.getStack();
	         itemstack = itemstack1.copy();
	         if (index == 0) {
	            this.pos.consume((world, pos) -> {
	               itemstack1.getItem().onCreated(itemstack1, world, player);
	            });
	            if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
	               return ItemStack.EMPTY;
	            }

	            slot.onSlotChange(itemstack1, itemstack);
	         } else if (index >= 10 && index < 37) {
	            if (!this.mergeItemStack(itemstack1, 37, 46, false)) {
	               return ItemStack.EMPTY;
	            }
	         } else if (index >= 37 && index < 46) {
	            if (!this.mergeItemStack(itemstack1, 10, 37, false)) {
	               return ItemStack.EMPTY;
	            }
	         } else if (!this.mergeItemStack(itemstack1, 10, 46, false)) {
	            return ItemStack.EMPTY;
	         }

	         if (itemstack1.isEmpty()) {
	            slot.putStack(ItemStack.EMPTY);
	         } else {
	            slot.onSlotChanged();
	         }

	         if (itemstack1.getCount() == itemstack.getCount()) {
	            return ItemStack.EMPTY;
	         }

	         ItemStack itemstack2 = slot.onTake(player, itemstack1);
	         if (index == 0) {
	            player.dropItem(itemstack2, false);
	         }
	      }

	      return itemstack;
	}
	
	@Override
	public boolean canMergeSlot(final ItemStack stack, final Slot slot) {
		return slot.inventory != this.result && super.canMergeSlot(stack, slot);
	}
	
	public int getOutputSlot() {
		return 0;
	}
	
	public int getWidth() {
		return this.crafting.getWidth();
	}
	
	public int getHeight() {
		return this.crafting.getHeight();
	}
	
	@OnlyIn(Dist.CLIENT)
	public int getSize() {
		return 10;
	}

}
