package com.kabaniery.uncommonadventure.world.surfaces;

import com.kabaniery.uncommonadventure.blocks.GeneralBlocks;
import com.kabaniery.uncommonadventure.world.biome.GeneralBiomes;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class FrozenSurfacesBuilder {
    public static final SurfaceRules.RuleSource FROZEN_SURFACE = SurfaceRules.sequence(

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
            
    );
}
