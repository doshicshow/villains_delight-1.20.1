package just_doshic.villains_delight.registry


import just_doshic.villains_delight.VillainsDelight.MOD_ID
import just_doshic.villains_delight.VillainsDelight.logger
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.text.Text
import net.minecraft.util.Identifier


object VDItems {
    // Group key and instance
    val VD_ITEM_GROUP_KEY: RegistryKey<ItemGroup> = RegistryKey.of(Registries.ITEM_GROUP.key, Identifier(MOD_ID, "vd_item_group"))
    private val VD_ITEM_GROUP: ItemGroup = FabricItemGroup.builder()
        .icon { ItemStack(HORSE_MEAT) } // temp icon
        .displayName(Text.translatable("itemGroup.villains_delight.vd_item_group"))
        .build()

    lateinit var HORSE_MEAT: Item

    init {
        // Register the group early
        Registry.register(Registries.ITEM_GROUP, VD_ITEM_GROUP_KEY, VD_ITEM_GROUP)
    }

    fun init() {
        HORSE_MEAT = register("horse_meat", Item(Item.Settings().food(VDFoodComponents.HORSE_MEAT)))
        logger.info("VDItems initialized.")
    }

    private fun register(id: String, item: Item): Item {
        val identifier = Identifier(MOD_ID, id)
        val registeredItem = Registry.register(Registries.ITEM, identifier, item)

        // Register item to the group via the key
        ItemGroupEvents.modifyEntriesEvent(VD_ITEM_GROUP_KEY).register { entries ->
            entries.add(registeredItem)
        }

        return registeredItem
    }
}
