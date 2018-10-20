package com.insane.itsrainingfood;

import com.insane.itsrainingfood.init.ModConfig;
import com.insane.itsrainingfood.proxy.IProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid=ItsRainingFood.MODID, name="It's Raining Food", version="0.0.1")
public class ItsRainingFood {

	public static final String MODID = "itsrainingfood";

    @SidedProxy(clientSide="com.insane.itsrainingfood.proxy.ClientProxy", serverSide="com.insane.itsrainingfood.proxy.ServerProxy")
	public static IProxy proxy;

	@Mod.Instance(MODID)
	public static ItsRainingFood instance;
	

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
        MinecraftForge.EVENT_BUS.register(new FoodEventHandler());

        ModConfig.initConfig(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{	}


}
