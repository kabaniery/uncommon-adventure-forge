package com.kabaniery.uncommonadventure.world.dimension;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import com.kabaniery.uncommonadventure.world.biome.GeneralBiomes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

import java.util.OptionalLong;

public class GeneralDimensions {
    public static final ResourceKey<LevelStem> FROZENWORLD_KEY = ResourceKey.create(Registries.LEVEL_STEM,
            new ResourceLocation(UncommonAdventureMod.MODID, "frozenworld"));
    public static final ResourceKey<Level> FROZENWORLD_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(UncommonAdventureMod.MODID, "frozenworld"));
    public static final ResourceKey<DimensionType> FROZENWORLD_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            new ResourceLocation(UncommonAdventureMod.MODID, "frozenworld_type"));

    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(FROZENWORLD_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000),
                true,
                false,
                false,
                false,
                1.0,
                true,
                false,
                0,
                256,
                256,
                BlockTags.INFINIBURN_OVERWORLD,
                BuiltinDimensionTypes.OVERWORLD_EFFECTS,
                0.5f,
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)
        ));
    }

    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        NoiseBasedChunkGenerator wrappedChunkGenerator = new NoiseBasedChunkGenerator(
                new FixedBiomeSource(biomeRegistry.getOrThrow(GeneralBiomes.FROZEN_PLACE)),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.AMPLIFIED));



        LevelStem stem = new LevelStem(dimTypes.getOrThrow(GeneralDimensions.FROZENWORLD_DIM_TYPE), wrappedChunkGenerator);

        context.register(FROZENWORLD_KEY, stem);
    }
}
