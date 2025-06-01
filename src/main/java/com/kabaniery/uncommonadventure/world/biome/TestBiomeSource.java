package com.kabaniery.uncommonadventure.world.biome;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;

import java.util.stream.Stream;

public class TestBiomeSource extends BiomeSource {
    public static final Codec<TestBiomeSource> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            Codec.LONG.fieldOf("seed").forGetter(o -> o.seed)
    ).apply(instance, TestBiomeSource::new));

    private final long seed;

    public TestBiomeSource(long seed) {
        this.seed = seed;
    }

    @Override
    protected Codec<? extends BiomeSource> codec() {
        return CODEC;
    }

    @Override
    protected Stream<Holder<Biome>> collectPossibleBiomes() {
        return Stream.of(GeneralBiomes.FROZEN_PLACE_HOLDER);
    }

    @Override
    public Holder<Biome> getNoiseBiome(int x, int y, int z, Climate.Sampler sampler) {
        double distance = x * x + z * z;

        final int firstLayer = 1000;

        if (distance < firstLayer * firstLayer) {
            return GeneralBiomes.FROZEN_PLACE_HOLDER;
        } else {

        }
        return GeneralBiomes.FROZEN_PLACE_HOLDER;
    }
}
