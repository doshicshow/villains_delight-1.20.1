package just_doshic.villains_delight.common.blocks

import net.minecraft.item.Item
import vectorwing.farmersdelight.common.block.FeastBlock
import java.util.function.Supplier

class RoastCatBlock(properties: Settings?, servingItem: Supplier<Item>?, hasLeftovers: Boolean) :
    FeastBlock(properties, servingItem, hasLeftovers) {
}