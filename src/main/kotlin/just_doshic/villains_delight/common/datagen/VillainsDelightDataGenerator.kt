package just_doshic.villains_delight.common.datagen


import VDModelProvider
import just_doshic.villains_delight.common.datagen.provider.VDAdvancementsProvider
import just_doshic.villains_delight.common.datagen.provider.VDEnglishLangProvider
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator


object VillainsDelightDataGenerator : DataGeneratorEntrypoint {
	override fun onInitializeDataGenerator(generator: FabricDataGenerator) {
		val pack = generator.createPack()

		pack.addProvider { output, _ ->
			VDAdvancementsProvider(output)
		}

		pack.addProvider { output, _ ->
			VDModelProvider(output)
		}

		pack.addProvider { output, _ ->
			VDEnglishLangProvider(output)
		}
	}


}