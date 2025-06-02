package com.kabaniery.uncommonadventure.entity;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

public class GeneralEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, UncommonAdventureMod.MODID);

    public static final RegistryObject<EntityType<WayPointEntity>> WAYPOINT_MARKER = ENTITIES.register("waypoint_marker",
            () -> EntityType.Builder.of(WayPointEntity::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .canSpawnFarFromPlayer()
                    .build(UncommonAdventureMod.MODID + ":waypoint_marker"));

    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
    }
}
