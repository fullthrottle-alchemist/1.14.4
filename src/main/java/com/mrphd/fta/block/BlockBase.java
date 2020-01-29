package com.mrphd.fta.block;

import com.mrphd.fta.util.ModUtils;

import net.minecraft.block.Block;

public class BlockBase extends Block {

	public BlockBase(final String name, final Block.Properties properties) {
		super(properties);
		setRegistryName(ModUtils.registryOf(name));
	}
	
}
