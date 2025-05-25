package com.kabaniery.uncommonadventure.datagenerators;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import com.kabaniery.uncommonadventure.item.GeneralItems;
import com.kabaniery.uncommonadventure.item.armor.BasicInsulatedArmors;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class MItemModelProviders extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public MItemModelProviders(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, UncommonAdventureMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        System.out.println("REGISTERED MODELS");
        basicItem(GeneralItems.BOILED_ROTTEN_FLESH.get());
        basicItem(BasicInsulatedArmors.BASIC_HELMET.get());
        basicItem(BasicInsulatedArmors.BASIC_CHESTPLATE.get());
        basicItem(BasicInsulatedArmors.BASIC_LEGGINS.get());
        basicItem(BasicInsulatedArmors.BASIC_BOOTS.get());
    }
}
