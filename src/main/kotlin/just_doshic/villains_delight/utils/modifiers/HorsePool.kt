package just_doshic.villains_delight.utils.modifiers

import just_doshic.villains_delight.conditions.KnifeHeldCondition.Companion.knifeHeldCondition
import just_doshic.villains_delight.registry.VDItems.HORSE_MEAT
import net.minecraft.loot.LootPool
import net.minecraft.loot.condition.RandomChanceLootCondition
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.function.SetCountLootFunction
import net.minecraft.loot.provider.number.ConstantLootNumberProvider
import net.minecraft.loot.provider.number.UniformLootNumberProvider

object HorsePool {
    val poolBuilder = LootPool.builder()
        .rolls(ConstantLootNumberProvider.create(1f))
        .conditionally(RandomChanceLootCondition.builder(1f))
        .conditionally(knifeHeldCondition)
        .with(ItemEntry.builder(HORSE_MEAT))
        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())
}