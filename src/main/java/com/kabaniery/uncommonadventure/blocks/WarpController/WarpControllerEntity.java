package com.kabaniery.uncommonadventure.blocks.WarpController;

import com.kabaniery.uncommonadventure.blocks.blockEntities.GeneralBlockEntities;
import com.kabaniery.uncommonadventure.gui.BrokenGuiMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class WarpControllerEntity extends BlockEntity implements MenuProvider {
    public WarpControllerEntity(BlockPos pPos, BlockState pBlockState) {
        super(GeneralBlockEntities.WARP_CONTROLLER_ENTITY.get(), pPos, pBlockState);
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Warp Controller");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new BrokenGuiMenu(i, inventory);
    }
}
