package com.kabaniery.uncommonadventure.item.armor;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class GeneralArmorTemplate extends ArmorItem {
    public GeneralArmorTemplate(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return UncommonAdventureMod.MODID + ":textures/models/armor/" +
                material.getName() + "_layer_" + (slot == EquipmentSlot.LEGS ? "2" : "1")+".png";
    }
}
