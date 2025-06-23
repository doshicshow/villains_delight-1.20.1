package just_doshic.villains_delight.common.datagen.provider

import just_doshic.villains_delight.VillainsDelight.MOD_ID
import just_doshic.villains_delight.common.registry.VDObjects.HORSE_MEAT
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider
import net.minecraft.advancement.Advancement
import net.minecraft.advancement.AdvancementFrame
import net.minecraft.advancement.criterion.ConsumeItemCriterion
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import java.util.function.Consumer

class VDAdvancementsProvider(dataGenerator: FabricDataOutput) :
	FabricAdvancementProvider(dataGenerator) {
	override fun generateAdvancement(consumer: Consumer<Advancement>) {
		val rootAdvancement: Advancement = Advancement.Task.create()
			.display(
				HORSE_MEAT,  // The display icon
				Text.literal("Man I could eat a horse..."),  // The title
				Text.literal("Eat a horse. ur evil."),  // The description
				Identifier("textures/gui/advancements/backgrounds/adventure.png"),  // Background image used
				AdvancementFrame.TASK,  // Options: TASK, CHALLENGE, GOAL
				true,  // Show toast top right
				true,  // Announce to chat
				false // Hidden in the advancement tab
			) // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
			.criterion("ate_horse", ConsumeItemCriterion.Conditions.item(HORSE_MEAT))
			.build(consumer, "$MOD_ID/root")
	}
}