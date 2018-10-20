package com.insane.itsrainingfood.proxy;

import net.minecraft.entity.player.EntityPlayer;

public class ServerProxy implements IProxy {



    public void playFoodSound(EntityPlayer player)
    {
        // Handled in the registered event handler
    }

    //we want to handle this ourselves with an event handler
    public boolean shouldPlaySound() { return false; }

}
