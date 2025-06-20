package just_doshic.villains_delight.utils

import just_doshic.villains_delight.utils.modifiers.HorsePool
import net.fabricmc.fabric.api.loot.v2.LootTableEvents
import net.minecraft.util.Identifier

object LootTableModifier {
    private val HORSE_ID: Identifier = Identifier("minecraft", "entities/horse")


    fun modifyLootTables(){
        LootTableEvents.MODIFY.register { _, _, id, tableBuilder, _ ->

            if (HORSE_ID == id) {
                tableBuilder.pool(HorsePool.poolBuilder.build())
            }

        }
    }
}