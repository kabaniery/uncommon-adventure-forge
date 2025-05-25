package com.kabaniery.uncommonadventure.item.armor.material;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public enum FrozenResistMaterials implements ArmorMaterial, FrozenResistMaterial {
    BASIC_INSULATED(20, new int[]{0, 0, 0,0}, 0, SoundEvents.ARMOR_EQUIP_LEATHER, Ingredient.EMPTY, "basic_insulate",
            0, 0, 20);


    private final int durability;
    private final int[] defense;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final Ingredient repairMaterial;
    private final String name;
    private final float toughness;
    private final float knockbackResistance;
    private final int frozenResistance;

    FrozenResistMaterials(int durability, int[] defense, int enchantability, SoundEvent equipSound, Ingredient repairMaterial,
                          String name, float toughness, float knockbackResistance, int frozenResistance) {
        this.durability = durability;
        this.defense = defense;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.repairMaterial = repairMaterial;
        this.name = name;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.frozenResistance = frozenResistance;
    }


    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return durability;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return defense[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairMaterial;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }

    @Override
    public int getFrozenResistance() {
        return frozenResistance;
    }
}
