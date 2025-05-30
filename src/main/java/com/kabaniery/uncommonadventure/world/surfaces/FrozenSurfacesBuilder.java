package com.kabaniery.uncommonadventure.world.surfaces;

import com.kabaniery.uncommonadventure.blocks.GeneralBlocks;
import com.kabaniery.uncommonadventure.world.biome_source.GeneralBiomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class FrozenSurfacesBuilder {
    public static final SurfaceRules.RuleSource FROZEN_SURFACE = SurfaceRules.sequence(
            SurfaceRules.ifTrue(
                    SurfaceRules.isBiome(GeneralBiomes.FROZEN_PLACE),
                    SurfaceRules.sequence(
                            SurfaceRules.ifTrue(
                                    SurfaceRules.ON_FLOOR,
                                    SurfaceRules.state(GeneralBlocks.POISONED_SNOW_BLOCK.get().defaultBlockState())
                            ),
                            SurfaceRules.ifTrue(
                                    SurfaceRules.UNDER_FLOOR,
                                    SurfaceRules.state(GeneralBlocks.POISONED_ICE.get().defaultBlockState())
                            )
                    )
            )
    );
}
