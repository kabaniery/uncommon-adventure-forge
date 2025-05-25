package com.kabaniery.uncommonadventure.gui;

import com.kabaniery.uncommonadventure.blocks.GeneralBlocks;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.Nullable;

public class BrokenGuiMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess access;

    // Server
    public BrokenGuiMenu(int pContainerId, Inventory pInventory, ContainerLevelAccess pLevel) {
        super(GeneralMenuTypes.BROKEN_GUI.get(), pContainerId);
        this.access = pLevel;

        // Пример: добавляем инвентарь игрока начиная с позиции (8, 84)
        int startX = 8;
        int startY = 84;

        // Добавление слотов основного инвентаря (3 ряда по 9 слотов)
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(pInventory, col + row * 9 + 9, startX + col * 18, startY + row * 18));
            }
        }

        // Добавление слотов хотбара (нижняя строка)
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(pInventory, col, startX + col * 18, startY + 58));
        }
    }
    // Client side
    public BrokenGuiMenu(int containerId, Inventory pInventory) {
        this(containerId, pInventory, ContainerLevelAccess.NULL);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return AbstractContainerMenu.stillValid(access, player, GeneralBlocks.WARP_CONTROLLER_BLOCK.get());
    }

}
