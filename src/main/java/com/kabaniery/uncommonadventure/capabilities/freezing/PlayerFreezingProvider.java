package com.kabaniery.uncommonadventure.capabilities.freezing;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerFreezingProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerFreezing> PLAYER_FREEZING = CapabilityManager.get(new CapabilityToken<PlayerFreezing>() {});

    private PlayerFreezing freezing = null;
    private final LazyOptional<PlayerFreezing> optional = LazyOptional.of(this::createPlayerFreezing);

    private PlayerFreezing createPlayerFreezing() {
        if (this.freezing == null) {
            this.freezing = new PlayerFreezing();
        }

        return this.freezing;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction direction) {
        if (capability == PLAYER_FREEZING) return optional.cast();

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        createPlayerFreezing().saveNBT(tag);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        createPlayerFreezing().loadNBT(compoundTag);
    }
}
