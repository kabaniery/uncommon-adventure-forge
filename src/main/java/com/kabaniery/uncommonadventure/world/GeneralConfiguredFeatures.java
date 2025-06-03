package com.kabaniery.uncommonadventure.world;

import com.kabaniery.uncommonadventure.Config;
import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import com.kabaniery.uncommonadventure.blocks.CommonDropBlocks;
import com.kabaniery.uncommonadventure.blocks.GeneralBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class GeneralConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAGENTA_ORE_KEY = registerKey("magenta_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

        OreConfiguration.TargetBlockState overworldMagentaOres = OreConfiguration.target(stoneReplaceable,
                CommonDropBlocks.MAGENTA_ORE.get().defaultBlockState());

        register(context, MAGENTA_ORE_KEY, Feature.ORE, new OreConfiguration(List.of(overworldMagentaOres), 9));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(UncommonAdventureMod.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstapContext<ConfiguredFeature<? ,?>> context, ResourceKey<ConfiguredFeature<?, ?>> key,
            F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
