package common.registry


import net.fabricmc.fabric.api.registry.CompostingChanceRegistry
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry
import net.minecraft.item.Item
import net.minecraft.item.Items.register


class VDObjects {
    companion object {
        val HORSE_MEAT: Item = register("horse_meat", Item(Item.Settings().food(VDFoodComponents.HORSE_MEAT)))
        fun init() {
            val flammableRegistry = FlammableBlockRegistry.getDefaultInstance()
            val compostRegistry = CompostingChanceRegistry.INSTANCE

            compostRegistry.add(HORSE_MEAT, 0.65f)
        }
    }
}