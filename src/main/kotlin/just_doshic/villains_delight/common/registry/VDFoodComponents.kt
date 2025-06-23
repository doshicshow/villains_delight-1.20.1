package just_doshic.villains_delight.common.registry

import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.item.FoodComponent
import vectorwing.farmersdelight.common.FoodValues.LONG_DURATION
import vectorwing.farmersdelight.common.registry.ModEffects


object VDFoodComponents {
    val HORSE_MEAT: FoodComponent = FoodComponent.Builder().meat().hunger(4).build()
    val ROAST_CAT: FoodComponent = FoodComponent.Builder().hunger(14).saturationModifier(0.75F).statusEffect(
        StatusEffectInstance(ModEffects.NOURISHMENT.get(), LONG_DURATION, 0), 1.0F).build()
}