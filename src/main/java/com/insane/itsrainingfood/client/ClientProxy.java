package com.insane.itsrainingfood.client;

import net.minecraft.entity.player.EntityPlayer;

import com.insane.itsrainingfood.CommonProxy;
import com.insane.itsrainingfood.Config;

public class ClientProxy extends CommonProxy {

	@Override
	public void playFoodSound(EntityPlayer player)
	{
		
	}
	
	@Override
	public boolean shouldPlaySound()
	{
		return Config.soundEnabled;
	}
}
