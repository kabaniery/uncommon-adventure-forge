package com.kabaniery.uncommonadventure.item.armor;

import com.kabaniery.uncommonadventure.item.GeneralItems;
import com.kabaniery.uncommonadventure.item.armor.material.FrozenResistMaterials;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class BasicInsulatedArmors {
    public static final RegistryObject<Item> BASIC_HELMET = GeneralItems.ITEMS.register("basic_insulated_helmet",
            () -> new GeneralArmorTemplate(FrozenResistMaterials.BASIC_INSULATED, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> BASIC_CHESTPLATE = GeneralItems.ITEMS.register("basic_insulated_chestplate",
            () -> new GeneralArmorTemplate(FrozenResistMaterials.BASIC_INSULATED, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> BASIC_LEGGINS = GeneralItems.ITEMS.register("basic_insulated_leggins",
            () -> new GeneralArmorTemplate(FrozenResistMaterials.BASIC_INSULATED, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> BASIC_BOOTS = GeneralItems.ITEMS.register("basic_insulated_boots",
            () -> new GeneralArmorTemplate(FrozenResistMaterials.BASIC_INSULATED, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void init() {}
}
