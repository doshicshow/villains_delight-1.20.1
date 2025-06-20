package just_doshic.villains_delight.datagen.provider

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider

class VDEnglishLangProvider(output: FabricDataOutput?) : FabricLanguageProvider(output) {
    override fun generateTranslations(translationBuilder: TranslationBuilder?) {
        translationBuilder?.add("itemGroup.vd_item_group", "Villains delight item group");
    }
}