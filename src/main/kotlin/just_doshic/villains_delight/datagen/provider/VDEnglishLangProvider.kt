package just_doshic.villains_delight.datagen.provider

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider

class VDEnglishLangProvider(output: FabricDataOutput?) : FabricLanguageProvider(output) {
    override fun generateTranslations(translationBuilder: TranslationBuilder?) {
        translationBuilder?.add("itemGroup.villains_delight.vd_item_group   ", "Villains Delight")
        translationBuilder?.add("item.villains_delight.horse_meat", "Horse Meat")
    }
}