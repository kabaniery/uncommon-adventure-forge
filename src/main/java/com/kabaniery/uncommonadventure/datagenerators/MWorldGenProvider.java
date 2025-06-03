package com.kabaniery.uncommonadventure.datagenerators;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import com.kabaniery.uncommonadventure.world.GeneralConfiguredFeatures;
import com.kabaniery.uncommonadventure.world.GeneralPlacedFeature;
import com.kabaniery.uncommonadventure.world.biome.GeneralBiomeModifiers;
import com.kabaniery.uncommonadventure.world.biome.GeneralBiomes;
import com.kabaniery.uncommonadventure.world.dimension.GeneralDimensions;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class MWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER_REGISTRY = new RegistrySetBuilder()
            .add(Registries.DIMENSION_TYPE, GeneralDimensions::bootstrapType)
            .add(Registries.BIOME, GeneralBiomes::boostrap)
            .add(Registries.LEVEL_STEM, GeneralDimensions::bootstrapStem)
            .add(Registries.CONFIGURED_FEATURE, GeneralConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, GeneralPlacedFeature::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, GeneralBiomeModifiers::bootstrap);

    public MWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER_REGISTRY, Set.of(UncommonAdventureMod.MODID));
    }
}
