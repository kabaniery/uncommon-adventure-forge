package com.kabaniery.uncommonadventure.particles.DeathDot;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DeathDotParticleProvider implements ParticleProvider<SimpleParticleType> {
    private final SpriteSet sprites;

    public DeathDotParticleProvider(SpriteSet sprites) {
        this.sprites = sprites;
    }

    @Override
    public @Nullable Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double v, double v1, double v2, double v3, double v4, double v5) {
        DeathDotParticle particle = new DeathDotParticle(clientLevel, v, v1, v2, v3, v4, v5);
        particle.pickSprite(this.sprites);
        return particle;
    }
}
