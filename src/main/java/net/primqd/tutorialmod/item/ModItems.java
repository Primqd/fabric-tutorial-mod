package net.primqd.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.primqd.tutorialmod.TutorialMod;

import static net.minecraft.component.type.ConsumableComponents.food;

public class ModItems {
	public static final ConsumableComponent BLACK_HOLE_CONSUMABLE_COMPONENT = food() // adds funny non-normal food effects i think
			.consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 5 * 20, 0))) // time is in ticks
			.consumeSeconds(6)
			.build();
	public static final FoodComponent BLACK_HOLE_FOOD_COMPONENT = new FoodComponent.Builder() // this makes it a food
			.alwaysEdible()
			.nutrition(5)
			.saturationModifier(5)
			.build();

	public static void registerModItems() {
		// Initializes all items created in this class.
		TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

		// registers the black_hole item
		Identifier itemId = Identifier.of(TutorialMod.MOD_ID, "black_hole");
		RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemId);
		Item.Settings settings = new Item.Settings().food(BLACK_HOLE_FOOD_COMPONENT, BLACK_HOLE_CONSUMABLE_COMPONENT).registryKey(key);
		Item BLACK_HOLE = Registry.register(Registries.ITEM, key, new Item(settings));

		// makes black_hole able to be used as fuel
		FuelRegistryEvents.BUILD.register((builder, context) -> {
			builder.add(BLACK_HOLE, context.baseSmeltTime()); // smelts 1 item
		});

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
			entries.add(BLACK_HOLE);
		});
	}
}
