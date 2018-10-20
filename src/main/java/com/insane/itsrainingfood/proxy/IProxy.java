package com.insane.itsrainingfood.proxy;

import net.minecraft.entity.player.EntityPlayer;

public interface IProxy {

    void playFoodSound(EntityPlayer player);
    boolean shouldPlaySound();

    class WrongSideException extends RuntimeException {
        public WrongSideException(final String message) {
            super(message);
        }

        public WrongSideException(final String message, final Throwable cause) {
            super(message, cause);
        }
    }
}
