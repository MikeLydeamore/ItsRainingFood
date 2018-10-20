package com.insane.itsrainingfood;

import com.insane.itsrainingfood.init.ModConfig;
import com.insane.itsrainingfood.init.ModSounds;
import com.insane.itsrainingfood.proxy.IProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

@Mod.EventBusSubscriber(modid = ItsRainingFood.MODID)
public class FoodEventHandler {

	public FoodEventHandler() {
	}

	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public static void onEvent(PlayerTickEvent event)
	{
		EntityPlayer player = event.player;
		int i = MathHelper.floor(player.posX);
		int j = MathHelper.floor(player.posY);
		int k = MathHelper.floor(player.posZ);
		BlockPos pbp = new BlockPos(i,j,k);

		
		if (player.isEntityAlive() &&
            player.world.isRaining() &&
            player.world.getBiomeForCoordsBody(pbp).getRainfall() > 0f &&
			player.ticksExisted% ModConfig.ticks == 0 &&
            player.rotationPitch < -65f &&
            player.getFoodStats().needFood() &&
            player.world.canBlockSeeSky(pbp) &&
            ItsRainingFood.proxy.shouldPlaySound())
        {
            player.getFoodStats().addStats(1, 1.0f);
            player.world.playSound(player,i,j,k, ModSounds.eating, SoundCategory.PLAYERS,0.8F,0.1F);
        }
    }

}
