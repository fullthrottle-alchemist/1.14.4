package com.mrphd.fta.item;

import com.mrphd.fta.util.ModUtils;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {

	public ItemBase(final String name, final Item.Properties properties) {
		super(properties);
		setRegistryName(ModUtils.registryOf(name));
	}
	
	public ItemBase(final String name, final Item.Properties properties, final ItemGroup group) {
		this(name, properties.group(group));
	}
	
}
