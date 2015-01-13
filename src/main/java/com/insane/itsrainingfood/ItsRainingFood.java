package com.insane.itsrainingfood;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=ItsRainingFood.MODID, name="It's Raining Food", version="1.0.2")
public class ItsRainingFood {

	public static final String MODID = "ItsRainingFood";
	
	@Mod.Instance(MODID)
	public static ItsRainingFood instance;
	
	@SidedProxy(clientSide="com.insane.itsrainingfood.client.ClientProxy", serverSide="com.insane.itsrainingfood.CommonProxy")
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(new FoodEventHandler());
		
		Config.doConfig(event.getSuggestedConfigurationFile());
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
