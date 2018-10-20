package com.insane.itsrainingfood.proxy;

import com.insane.itsrainingfood.init.ModConfig;
import net.minecraft.entity.player.EntityPlayer;

public class ClientProxy implements IProxy {

	@Override
	public void playFoodSound(EntityPlayer player)
	{
		//handling this with a registered event handler.
	}
	
	@Override
	public boolean shouldPlaySound()
	{
		return ModConfig.soundEnabled;
	}
}
