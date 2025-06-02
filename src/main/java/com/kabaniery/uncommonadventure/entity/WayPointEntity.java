package com.kabaniery.uncommonadventure.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class WayPointEntity extends Entity {
    public static final HashMap<BlockPos, WayPointEntity> entities = new HashMap<>();

    private BlockPos pos;
    private Set<UUID> OWNERS = new HashSet<>();
    public WayPointEntity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void defineSynchedData() {

    }

    public void setPos(BlockPos pPos) {
        this.pos = pPos;
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        int x = compoundTag.getInt("x");
        int y = compoundTag.getInt("y");
        int z = compoundTag.getInt("z");
        this.pos = new BlockPos(x, y, z);
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        compoundTag.putInt("x", pos.getX());
        compoundTag.putInt("y", pos.getY());
        compoundTag.putInt("z", pos.getZ());
    }
}
