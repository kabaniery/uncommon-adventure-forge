package com.kabaniery.uncommonadventure.blocks.blockEntities;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import com.kabaniery.uncommonadventure.blocks.DeathCloneBox.DeathCloneBlockEntity;
import com.kabaniery.uncommonadventure.blocks.GeneralBlocks;
import com.kabaniery.uncommonadventure.blocks.WarpController.WarpControllerEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GeneralBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(
            ForgeRegistries.BLOCK_ENTITY_TYPES, UncommonAdventureMod.MODID);

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

    public static final RegistryObject<BlockEntityType<DeathCloneBlockEntity>> DEATH_BOX_ENTITY =
            BLOCK_ENTITIES.register("death_box_entity",
                    () -> BlockEntityType.Builder.of(DeathCloneBlockEntity::new, GeneralBlocks.DEATH_CLONE_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<WarpControllerEntity>> WARP_CONTROLLER_ENTITY =
            BLOCK_ENTITIES.register("warp_controller_entity",
                    () -> BlockEntityType.Builder.of(WarpControllerEntity::new, GeneralBlocks.WARP_CONTROLLER_BLOCK.get()).build(null));
}
