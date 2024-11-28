package net.primqd.tutorialmod.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.primqd.tutorialmod.TutorialMod;

public class ModBlocks {

	private static Item registerBlockItem(String name) {
		// Identifier id = Identifier.of(TutorialMod.MOD_ID, name);
		RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, name));
		Item.Settings settings = new Item.Settings().useBlockPrefixedTranslationKey().registryKey(key);
		return Registry.register(Registries.ITEM, key, new Item(settings));
	}

	public static void registerModBlocks() {
		TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);
	}
}
