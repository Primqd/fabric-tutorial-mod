package net.primqd.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.primqd.tutorialmod.TutorialMod;

public class ModItems {
	private static Item registerItem(String name) {
        Identifier id = Identifier.of(TutorialMod.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item.Settings settings = new Item.Settings().registryKey(key);
        return Registry.register(Registries.ITEM, key, new Item(settings));
	}

	public static void registerModItems() {
		// Initializes all items created in this class.
		TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);
        Item BLACK_HOLE = registerItem("black_hole");
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
			entries.add(BLACK_HOLE);
		});
	}
}
