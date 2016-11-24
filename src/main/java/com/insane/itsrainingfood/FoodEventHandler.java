package com.insane.itsrainingfood;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class FoodEventHandler {
	@SubscribeEvent
	public void onPlayerTickEvent(PlayerTickEvent event)
	{
		EntityPlayer player = event.player;
		
		if (player.isEntityAlive() && player.worldObj.isRaining() && player.worldObj.getBiome(player.getPosition()).getRainfall() > 0)
		{
			if (player.ticksExisted%Config.configTicks == 0 && player.rotationPitch < -65f && player.getFoodStats().needFood() && player.worldObj.canSeeSky(player.getPosition()))
			{
				player.getFoodStats().addStats(1, 1.0f);
				if (ItsRainingFood.proxy.shouldPlaySound())
					player.worldObj.playSound(player, player.getPosition(), ItsRainingFood.nomNom, SoundCategory.AMBIENT, 0.8f, 1.0f);
			}
		}
	}

}
