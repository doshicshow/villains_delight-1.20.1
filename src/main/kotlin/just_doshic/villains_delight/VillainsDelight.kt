package just_doshic.villains_delight

import just_doshic.villains_delight.registry.VDItems
import just_doshic.villains_delight.registry.VDItems.VD_ITEM_GROUP_KEY
import just_doshic.villains_delight.utils.LootTableModifier
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory


object VillainsDelight : ModInitializer {
	const val MOD_ID = "villains_delight"
	val logger: Logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		logger.info("{} Has initialized", MOD_ID)
		VDItems.init()
		LootTableModifier.modifyLootTables()
	}
}