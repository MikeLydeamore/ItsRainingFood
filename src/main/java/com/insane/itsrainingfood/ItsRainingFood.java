package com.insane.itsrainingfood;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid=ItsRainingFood.MODID, name="It's Raining Food", version="1.0.2")
public class ItsRainingFood {

	public static final String MODID = "ItsRainingFood";
	
	@Mod.Instance(MODID)
	public static ItsRainingFood instance;
	
	@SidedProxy(clientSide="com.insane.itsrainingfood.client.ClientProxy", serverSide="com.insane.itsrainingfood.CommonProxy")
	public static CommonProxy proxy;
	
	public static SoundEvent nomNom;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new FoodEventHandler());
		
		nomNom = new SoundEvent(new ResourceLocation("itsrainingfood:omnomnom"));
		nomNom.setRegistryName("omnomnom");
		GameRegistry.register(nomNom);
		
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
