package com.kabaniery.uncommonadventure.blocks.DeathCloneBox;

import com.kabaniery.uncommonadventure.blocks.blockEntities.GeneralBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DeathCloneBlockEntity extends BlockEntity {
    private final NonNullList<ItemStack> items = NonNullList.create();

    public DeathCloneBlockEntity(BlockPos pos, BlockState state) {
        super(GeneralBlockEntities.DEATH_BOX_ENTITY.get(), pos, state);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        ContainerHelper.saveAllItems(pTag, items);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        ContainerHelper.loadAllItems(pTag, items);
    }

    public void destroy(Level world, BlockPos pos) {
        for (ItemStack stack : items) {
            //TODO: Проставить выпадение предметов
        }
    }
}
