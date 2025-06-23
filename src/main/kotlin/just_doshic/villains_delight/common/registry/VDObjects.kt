package just_doshic.villains_delight.common.registry


import just_doshic.villains_delight.VillainsDelight.MOD_ID
import just_doshic.villains_delight.VillainsDelight.logger
import just_doshic.villains_delight.common.blocks.RoastCatBlock
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import vectorwing.farmersdelight.common.item.ConsumableItem
import vectorwing.farmersdelight.common.registry.ModItems.bowlFoodItem

object VDObjects {
    // Group key and instance
    val VD_ITEM_GROUP_KEY: RegistryKey<ItemGroup> = RegistryKey.of(Registries.ITEM_GROUP.key, Identifier(MOD_ID, "vd_item_group"))
    private val VD_ITEM_GROUP: ItemGroup = FabricItemGroup.builder()
        .icon { ItemStack(HORSE_MEAT) } // temp icon
        .name(Text.translatable("itemGroup.villains_delight.vd_item_group"))
        .build()

    lateinit var HORSE_MEAT: Item

    init {
        // Register the group early
        Registry.register(Registries.ITEM_GROUP, VD_ITEM_GROUP_KEY, VD_ITEM_GROUP)
    }

    private fun <T : Item> registerWithTab(name: String, item: T): T {
        val id = Identifier(MOD_ID, name)
        ItemGroupEvents.modifyEntriesEvent(VD_ITEM_GROUP_KEY).register(ItemGroupEvents.ModifyEntries { itemGroup: FabricItemGroupEntries ->
            itemGroup.addItem(item)
        })
            return Registry.register(Registries.ITEM, id, item)
        }

    private fun <T : Block> registerWithTab(name: String, block: T, settings: Item.Settings): T {
        val id = Identifier(MOD_ID, name)

        Registry.register(Registries.BLOCK, id, block)

        val blockItem = Registry.register(Registries.ITEM, id, BlockItem(block, settings))

        ItemGroupEvents.modifyEntriesEvent(VD_ITEM_GROUP_KEY).register(ItemGroupEvents.ModifyEntries { itemGroup: FabricItemGroupEntries ->
            itemGroup.addItem(blockItem)
        })

        return block
    }

    fun registerAll() {
        HORSE_MEAT = registerWithTab("horse_meat", Item(Item.Settings().food(VDFoodComponents.HORSE_MEAT)))
        val ROAST_CAT = registerWithTab("roast_cat", ConsumableItem(bowlFoodItem(VDFoodComponents.ROAST_CAT), true) )
        val ROAST_CAT_BLOCK = registerWithTab("roast_cat_block", RoastCatBlock(FabricBlockSettings.copy(Blocks.CAKE), {ROAST_CAT}, false),Item.Settings())

        logger.info("{} initialized.", this.javaClass.simpleName.toString())
    }
}
