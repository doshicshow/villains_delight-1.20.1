package common.registry

import net.minecraft.item.FoodComponent



class VDFoodComponents {
    companion object {
        val HORSE_MEAT: FoodComponent = FoodComponent.Builder().meat().hunger(4).build()
    }
}