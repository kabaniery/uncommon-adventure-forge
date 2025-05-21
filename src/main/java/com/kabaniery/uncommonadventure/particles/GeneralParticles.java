package com.kabaniery.uncommonadventure.particles;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class GeneralParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES =
            DeferredRegister.create(Registries.PARTICLE_TYPE, UncommonAdventureMod.MODID);

    public static void register(IEventBus bus) {
        PARTICLES.register(bus);
    }

    public static final RegistryObject<SimpleParticleType> DEATH_DOT_PARTICLE =
            PARTICLES.register("death_dot", () -> new SimpleParticleType(false));
}
