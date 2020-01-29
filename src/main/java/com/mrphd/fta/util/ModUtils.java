package com.mrphd.fta.util;

import com.mrphd.fta.Main;

import net.minecraft.util.ResourceLocation;

public class ModUtils {

	public static ResourceLocation registryOf(final String path) {
		return new ResourceLocation(Main.MOD_ID, path);
	}
	
}
