package darkerbladex.mods.world.gen.biomes;

import java.util.Random;

import darkerbladex.mods.init.BlockInit;
import darkerbladex.mods.objects.blocks.BlockOres;
import darkerbladex.mods.util.handlers.EnumHandler;
import darkerbladex.mods.world.gen.WorldGenLightiumTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeLightiumForest extends Biome {

	protected static final WorldGenAbstractTree TREE = new WorldGenLightiumTree();
	
	public BiomeLightiumForest() {
		super(new BiomeProperties("Lightium_Forest").setBaseHeight(1.0F).setHeightVariation(0.5F).setTemperature(0.9F).setRainfall(0.5F).setWaterColor(15788797));

		topBlock = BlockInit.DIRT_LIGHTIUM.getDefaultState();
		fillerBlock = BlockInit.ORE_OVERWORLD.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.LIGHTIUM);
		
		this.decorator.treesPerChunk = 2;
			
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		
	}
	 @Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		 return TREE;
	}
}
