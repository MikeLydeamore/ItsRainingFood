package com.insane.itsrainingfood;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class FoodEventHandler {
	public static int ticksSinceLast = 0;
	@SubscribeEvent
	public void onPlayerTickEvent(PlayerTickEvent event)
	{
		if (event.player.worldObj.isRaining())
		{
			EntityPlayer player = event.player;
			if (ticksSinceLast == 0 && player.rotationPitch < -65f && player.getFoodStats().needFood() && player.worldObj.canBlockSeeTheSky((int) player.posX, (int) player.posY, (int) player.posZ))
			{
				event.player.getFoodStats().addStats(1, 1.0f);
				ticksSinceLast++;
				if (ItsRainingFood.proxy.shouldPlaySound())
					event.player.worldObj.playSoundAtEntity(event.player, "itsrainingfood:omnomnom", 0.8f, 1.0f);
			}
			else
			{
				System.out.println("TICKS: "+Config.configTicks);
				ticksSinceLast++;
				ticksSinceLast = ticksSinceLast%Config.configTicks;
			}
		}
	}

}
