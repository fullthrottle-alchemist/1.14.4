package com.mrphd.fta.block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.material.Material;

public class ModBlocks {

	private static final List<Block> BLOCKS;

	public static final Block ALCHEMY_FURNACE;
	public static final Block ATELIER;
	public static final Block ENCHANTMENT_TABLE;
	public static final Block STORAGE;
	
	static {
		final List<Block> blocks = new ArrayList<Block>();

		blocks.add(ALCHEMY_FURNACE = dummyBlock("alchemy_furnace"));
		blocks.add(ATELIER = dummyBlock("atelier"));
		blocks.add(ENCHANTMENT_TABLE = dummyBlock("enchantment_table"));
		blocks.add(STORAGE = dummyBlock("storage"));
		
		BLOCKS = Collections.unmodifiableList(blocks);
	}
	
	public static void registerBlocks(final Consumer<Block> registerer) {
		BLOCKS.forEach(registerer::accept);
	}
	
	@Deprecated
	private static Block dummyBlock(final String name) {
		return new BlockBase(name, Properties.create(Material.ROCK));
	}
	
}
