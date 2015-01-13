package com.insane.itsrainingfood;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {
	
	public static final String categoryGeneral="categoryGeneral";
	public static int configTicks;
	public static boolean soundEnabled;
	
	public static void doConfig(File file)
	{
		Configuration config = new Configuration(file);
		
		config.load();
		
		configTicks = config.get(categoryGeneral, "ticksForFood", 160, "Number of ticks to restore food").getInt();
		soundEnabled = config.get(categoryGeneral, "soundEnabled", true).getBoolean();
		
		if (config.hasChanged())
			config.save();
	}

}
