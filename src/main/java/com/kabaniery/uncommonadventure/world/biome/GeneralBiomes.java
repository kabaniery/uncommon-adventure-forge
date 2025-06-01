package com.kabaniery.uncommonadventure.world.biome;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;

public class GeneralBiomes {
    public static final ResourceKey<Biome> FROZEN_PLACE = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(UncommonAdventureMod.MODID, "frozen_place"));

    public static Holder<Biome> FROZEN_PLACE_HOLDER;

    public static void boostrap(BootstapContext<Biome> context) {
        context.register(FROZEN_PLACE, frozen_place(context));

        FROZEN_PLACE_HOLDER = context.lookup(Registries.BIOME).getOrThrow(FROZEN_PLACE);
    }

    private static Biome frozen_place(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.POLAR_BEAR, 5, 2, 4));
        BiomeDefaultFeatures.monsters(spawnBuilder, 2, 0, 4, false);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeSpecialEffects specialEffects = new BiomeSpecialEffects.Builder()
                .fogColor(0xC0D8FF)              // example: light blue fog
                .waterColor(0x3F76E4)            // example: standard water color
                .waterFogColor(0x050533)         // example: dark blue water fog
                .skyColor(0x77ADFF)              // example: sky color
                .build();

        return new Biome.BiomeBuilder()
                .downfall(0.8f)
                .temperature(0.0f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects(specialEffects)
                .build();
    }
}
