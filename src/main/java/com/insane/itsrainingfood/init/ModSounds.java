package com.insane.itsrainingfood.init;


import com.insane.itsrainingfood.ItsRainingFood;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public final class ModSounds {
    public static final SoundEvent eating = makeSoundEvent("omnomnom");

    private static void initialize() {
        //
    }

    private static SoundEvent makeSoundEvent(String name) {
        ResourceLocation loc = new ResourceLocation(ItsRainingFood.MODID, name);
        return new SoundEvent(loc).setRegistryName(loc);
    }

    @Mod.EventBusSubscriber(modid = ItsRainingFood.MODID)
    public static class RegistrationHandler
    {
        @SubscribeEvent
        public static void onEvent(final RegistryEvent.Register<SoundEvent> evt) {
            IForgeRegistry<SoundEvent> r = evt.getRegistry();

            r.register(eating);


            initialize();
        }

        // hiding implicit public constructor
        private RegistrationHandler() {}
    }

    // hiding implicit public constructor
    private ModSounds() {}
}
