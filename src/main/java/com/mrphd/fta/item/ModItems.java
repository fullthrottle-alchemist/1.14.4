package com.mrphd.fta.item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import com.mrphd.fta.block.ModBlocks;
import com.mrphd.fta.itemgroup.ModItemGroups;
import com.mrphd.fta.util.ModUtils;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;

public class ModItems {

	public static final List<Item> ITEMS;

	/***********   NORMAL ITEMS   ***********/
	
	public static final Item ALCHEMY_PACK;
	public static final Item BOMB;
	public static final Item CLIPBOARD;
	public static final Item CUSTOM_FRAME;
	public static final Item ENDER_PACK;
	public static final Item ENTITY_BOTTLE;
	public static final Item FLASK;
	public static final Item HEARTH_STONE;
	public static final Item MEMBER_CARD;
	public static final Item POWERUP;
	public static final Item RESOURCE;
	public static final Item TILE_BOX;
	public static final Item VELLUM;
	
	/*********** END NORMAL ITEMS ***********/ 

	/***********   TOOL ITEMS   ***********/

	public static final Item ALCHEMIST_WRENCH;
	public static final Item ALCHEMY_BELT;
	public static final Item HERO_BOW;
	public static final Item MAGNET;
	public static final Item MITTS;
	public static final Item SABER;
	public static final Item WATCH;
	public static final Item WATERING_CAN;
	
	/*********** END TOOL ITEMS ***********/ 

	/***********   BLOCK ITEMS   ***********/

	public static final BlockItem ALCHEMY_FURNACE;
	public static final BlockItem ATELIER;
	public static final BlockItem ENCHANTMENT_TABLE;
	public static final BlockItem STORAGE;
	
	/*********** END BLOCK ITEMS ***********/ 
	
	static {
		final List<Item> items = new ArrayList<Item>();

		// NORMAL ITEMS
		items.add(ALCHEMY_PACK = dummyItem("alchemy_pack"));
		items.add(BOMB = dummyItem("bomb"));
		items.add(CLIPBOARD = dummyItem("clipboard"));
		items.add(CUSTOM_FRAME = dummyItem("custom_frame"));
		items.add(ENDER_PACK = dummyItem("ender_pack"));
		items.add(ENTITY_BOTTLE = dummyItem("entity_bottle"));
		items.add(FLASK = dummyItem("flask"));
		items.add(HEARTH_STONE = dummyItem("hearth_stone"));
		items.add(MEMBER_CARD = dummyItem("member_card"));
		items.add(POWERUP = dummyItem("powerup"));
		items.add(RESOURCE = dummyItem("resource"));
		items.add(TILE_BOX = dummyItem("tile_box", false));
		items.add(VELLUM = dummyItem("vellum"));
		
		// TOOLS ITEMS
		items.add(ALCHEMIST_WRENCH = dummyItem("alchemist_wrench"));
		items.add(ALCHEMY_BELT = dummyItem("alchemy_belt"));
		items.add(HERO_BOW = dummyItem("hero_bow"));
		items.add(MAGNET = dummyItem("magnet"));
		items.add(MITTS = dummyItem("mitts"));
		items.add(SABER = dummyItem("saber"));
		items.add(WATCH = dummyItem("watch"));
		items.add(WATERING_CAN = dummyItem("watering_can"));
		
		// BLOCK ITEMS
		items.add(ALCHEMY_FURNACE = dummyItemBlock("alchemy_furnace", ModBlocks.ALCHEMY_FURNACE));
		items.add(ATELIER = dummyItemBlock("atelier", ModBlocks.ATELIER));
		items.add(ENCHANTMENT_TABLE = dummyItemBlock("enchantment_table", ModBlocks.ENCHANTMENT_TABLE));
		items.add(STORAGE = dummyItemBlock("storage", ModBlocks.STORAGE));
		
		ITEMS = Collections.unmodifiableList(items);
	}
	
	public static void registerItems(final Consumer<Item> registerer) {
		ITEMS.forEach(registerer::accept);
	}
	
	@Deprecated
	private static Item dummyItem(final String name, boolean hasGroup) {
		return hasGroup ?
			new ItemBase(name, new Properties(), ModItemGroups.DEFAULT) : 
			new ItemBase(name, new Properties());
	}

	@Deprecated
	private static Item dummyItem(final String name) {
		return dummyItem(name, true);
	}
	
	@Deprecated
	private static BlockItem dummyItemBlock(final String name, final Block block) {
		final BlockItem item = new BlockItem(block, new Properties().group(ModItemGroups.DEFAULT));
		item.setRegistryName(ModUtils.registryOf(name));
		return item;
	}
	
}
