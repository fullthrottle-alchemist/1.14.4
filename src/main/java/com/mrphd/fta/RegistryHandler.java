package com.mrphd.fta;

import com.mrphd.fta.block.ModBlocks;
import com.mrphd.fta.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(bus = Bus.MOD, modid = Main.MOD_ID, value = {Dist.CLIENT, Dist.DEDICATED_SERVER})
public class RegistryHandler {

	@SubscribeEvent()
	public static void registerItems(final Register<Item> event) {
		ModItems.registerItems(event.getRegistry()::register);
	}
	
	@SubscribeEvent()
	public static void registerBlocks(final Register<Block> event) {
		ModBlocks.registerBlocks(event.getRegistry()::register);
	}
	
}
