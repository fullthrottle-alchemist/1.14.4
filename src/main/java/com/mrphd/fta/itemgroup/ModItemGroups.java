package com.mrphd.fta.itemgroup;

import com.mrphd.fta.item.ModItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroups {

	public static final ItemGroup DEFAULT = new ItemGroup("ftalchemist") {
		@Override
		public ItemStack createIcon() {
			return ModItems.ALCHEMIST_WRENCH.getDefaultInstance();
		}
	};
	
}
