package just_doshic.villains_delight

import common.registry.VDFoodComponents
import common.registry.VDObjects
import net.fabricmc.api.ModInitializer
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import org.slf4j.LoggerFactory
import vectorwing.farmersdelight.common.registry.ModBlocks
import vectorwing.farmersdelight.common.registry.ModItems.registerWithTab
import java.util.function.Supplier

object VillainsDelight : ModInitializer {
    private val logger = LoggerFactory.getLogger("villains_delight")

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		VDObjects.init()
	}
}