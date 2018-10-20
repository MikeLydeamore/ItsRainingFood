package com.insane.itsrainingfood.init;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import net.minecraftforge.common.config.Configuration;
import java.io.File;

public class ModConfig {
    public static File configFile;
    public static Configuration config;
    public static int ticks = 160;
    public static boolean soundEnabled = true;

    public static void initConfig(FMLPreInitializationEvent event) {
        configFile = event.getSuggestedConfigurationFile();

        config = new Configuration(configFile);

        syncConfig();
    }

    public static void syncConfig() {
        config.load();
        ticks = config.getInt(Configuration.CATEGORY_GENERAL,"ticksForFood",160,1, Integer.MAX_VALUE,"Number of ticks to restore food");
        soundEnabled = config.get(Configuration.CATEGORY_GENERAL,"soundEnabled",true).getBoolean();

        config.save();

    }

    //hiding implicit public constructor
    private ModConfig() {}
}
