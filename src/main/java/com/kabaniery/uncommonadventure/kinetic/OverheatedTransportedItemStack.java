package com.kabaniery.uncommonadventure.kinetic;

import com.simibubi.create.content.kinetics.belt.transport.TransportedItemStack;
import com.simibubi.create.content.kinetics.fan.processing.AllFanProcessingTypes;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public class OverheatedTransportedItemStack extends TransportedItemStack {
    public OverheatedTransportedItemStack(ItemStack stack) {
        super(stack);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag =  super.serializeNBT();
        tag.putBoolean("overheated", true);
        return tag;
    }

    public static TransportedItemStack read(CompoundTag nbt) {
        if (nbt.contains("overheated")) {
            TransportedItemStack stack = new OverheatedTransportedItemStack(ItemStack.of(nbt.getCompound("Item")));
            stack.beltPosition = nbt.getFloat("Pos");
            stack.prevBeltPosition = nbt.getFloat("PrevPos");
            stack.sideOffset = nbt.getFloat("Offset");
            stack.prevSideOffset = nbt.getFloat("PrevOffset");
            stack.insertedAt = nbt.getInt("InSegment");
            stack.angle = nbt.getInt("Angle");
            stack.insertedFrom = Direction.from3DDataValue(nbt.getInt("InDirection"));
            stack.locked = nbt.getBoolean("Locked");
            stack.lockedExternally = nbt.getBoolean("LockedExternally");

            if (nbt.contains("FanProcessingType")) {
                stack.processedBy = AllFanProcessingTypes.parseLegacy(nbt.getString("FanProcessingType"));
                stack.processingTime = nbt.getInt("FanProcessingTime");
            }

            return stack;
        } else {
            return TransportedItemStack.read(nbt);
        }
    }
}
