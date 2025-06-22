
import just_doshic.villains_delight.registry.VDItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.model.BlockStateModelGenerator
import net.minecraft.data.client.model.Models

class VDModelProvider(output: FabricDataOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator) {
        // ...
    }


    override fun generateItemModels(itemModelGenerator: ItemModelGenerator?) {
        itemModelGenerator?.register(VDItems.HORSE_MEAT, Models.SINGLE_LAYER_ITEM)
    }
}