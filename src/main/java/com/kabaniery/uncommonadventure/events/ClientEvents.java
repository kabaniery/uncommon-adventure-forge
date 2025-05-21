package com.kabaniery.uncommonadventure.events;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import com.kabaniery.uncommonadventure.particles.DeathDot.DeathDotParticleProvider;
import com.kabaniery.uncommonadventure.particles.GeneralParticles;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UncommonAdventureMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onParticleFactoryRegister(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(GeneralParticles.DEATH_DOT_PARTICLE.get(), DeathDotParticleProvider::new);
    }
}
