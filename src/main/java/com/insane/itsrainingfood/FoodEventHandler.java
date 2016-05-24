package com.insane.itsrainingfood;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class FoodEventHandler {
	@SubscribeEvent
	public void onPlayerTickEvent(PlayerTickEvent event)
	{
		EntityPlayer player = event.player;
		int i = MathHelper.floor_double(player.posX);
		int j = MathHelper.floor_double(player.posY);
		int k = MathHelper.floor_double(player.posZ);
		
		if (player.isEntityAlive() && player.worldObj.isRaining() && player.worldObj.getBiomeGenForCoords(i, k).getIntRainfall() > 0)
		{
			if (player.ticksExisted%Config.configTicks == 0 && player.rotationPitch < -65f && player.getFoodStats().needFood() && player.worldObj.canBlockSeeTheSky(i, j, k))
			{
				player.getFoodStats().addStats(1, 1.0f);
				if (ItsRainingFood.proxy.shouldPlaySound())
					player.worldObj.playSoundAtEntity(player, "itsrainingfood:omnomnom", 0.8f, 1.0f);
			}
		}
	}

}
