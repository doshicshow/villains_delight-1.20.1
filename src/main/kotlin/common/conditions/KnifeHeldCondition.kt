package common.conditions


import net.minecraft.loot.condition.EntityPropertiesLootCondition
import net.minecraft.predicate.item.ItemPredicate
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier

class KnifeHeldCondition {
    companion object {
        val KNIFE_TAG_ID: Identifier = Identifier("farmersdelight", "tools/knives")
        val KNIFE_TAG = TagKey.of(RegistryKeys.ITEM, KNIFE_TAG_ID)

        val knifeHeldCondition = EntityPropertiesLootCondition.builder(
            net.minecraft.loot.context.LootContext.EntityTarget.KILLER,
            net.minecraft.predicate.entity.EntityPredicate.Builder.create()
                .equipment(
                    net.minecraft.predicate.entity.EntityEquipmentPredicate.Builder.create()
                        .mainhand(
                            ItemPredicate.Builder.create().tag(KNIFE_TAG).build()
                        ).build()
                )
        ).build()
    }
}