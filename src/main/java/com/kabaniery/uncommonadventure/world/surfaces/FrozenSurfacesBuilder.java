package com.kabaniery.uncommonadventure.world.surfaces;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class FrozenSurfacesBuilder {
    public static final SurfaceRules.RuleSource FROZEN_SURFACE = SurfaceRules.sequence(
            SurfaceRules.ifTrue(
                    SurfaceRules.yBlockCheck(VerticalAnchor.TOP, 4),
                    SurfaceRules.state(Blocks.SNOW_BLOCK.defaultBlockState())
            ),
            SurfaceRules.ifTrue(
                    SurfaceRules.yBlockCheck(VerticalAnchor.belowTop(3), 5),
                    SurfaceRules.state(Blocks.ICE.defaultBlockState())
            )
    );
}
