package com.mrphd.fta;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value = Main.MOD_ID)
public class Main {

	public static final String MOD_ID = "ftalchemist";
	
    public static final Logger LOGGER = LogManager.getLogger();
	
	public Main() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	public void setupClient(final FMLClientSetupEvent event) {
		LOGGER.info("Running setupClient...");
	}
	
}
