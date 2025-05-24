package com.kabaniery.uncommonadventure.blocks.DeathCloneBox;

import com.kabaniery.uncommonadventure.blocks.blockEntities.GeneralBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Collection;

public class DeathCloneBlockEntity extends BlockEntity {
    private NonNullList<ItemStack> items = NonNullList.withSize(50, ItemStack.EMPTY);

    public DeathCloneBlockEntity(BlockPos pos, BlockState state) {
        super(GeneralBlockEntities.DEATH_BOX_ENTITY.get(), pos, state);
    }

    public void setItems(Collection<ItemEntity> inventory) {
        items = NonNullList.withSize(50, ItemStack.EMPTY);
        int i = 0;
        for (ItemEntity item : inventory) {
            items.set(i, item.getItem());
            i++;
        }
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
            world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack));
        }
    }
}
