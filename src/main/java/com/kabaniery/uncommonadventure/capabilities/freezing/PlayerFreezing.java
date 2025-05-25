package com.kabaniery.uncommonadventure.capabilities.freezing;

import net.minecraft.nbt.CompoundTag;

public class PlayerFreezing implements IPlayerFreezing {
    private final double MAX_FREEZING = 20;
    private double freezing;
    private boolean disabled = false;

    @Override
    public boolean isDisabled() {
        return disabled;
    }

    @Override
    public void setDisabled(boolean disabled) {
        if (disabled) {
            freezing = MAX_FREEZING;
        }
        this.disabled = disabled;
    }

    public void setFreezing(double freezing) {
        this.freezing = freezing;
    }

    @Override
    public double getFreezing() {
        return freezing;
    }

    @Override
    public void substractFreezing(int resistance) {
        freezing -= 0.05 / (1 + resistance);
        if (freezing <= 0) {
            freezing = 0;
        }
    }

    @Override
    public void addFreezing(double amount) {
        freezing += amount;
        if (freezing >= MAX_FREEZING) {
            freezing = MAX_FREEZING;
        }
    }

    @Override
    public void copyFrom(PlayerFreezing other) {
        freezing = other.freezing;
        disabled = other.disabled;
    }

    public void saveNBT(CompoundTag tag) {
        tag.putDouble("freezing", freezing);
        tag.putBoolean("disabled", disabled);
    }

    public void loadNBT(CompoundTag tag) {
        freezing = tag.getDouble("freezing");
        disabled = tag.getBoolean("disabled");
    }
}
