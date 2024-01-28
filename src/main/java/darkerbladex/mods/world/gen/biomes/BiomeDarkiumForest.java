package darkerbladex.mods.world.gen.biomes;

import java.util.Random;


import darkerbladex.mods.init.BlockInit;
import darkerbladex.mods.objects.blocks.BlockDirtBase;
import darkerbladex.mods.objects.blocks.BlockOres;
import darkerbladex.mods.util.handlers.EnumHandler;
import darkerbladex.mods.world.gen.WorldGenDarkiumTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeDarkiumForest extends Biome {

	protected static final WorldGenAbstractTree TREE = new WorldGenDarkiumTree();
	
	public BiomeDarkiumForest() {
		super(new BiomeProperties("Darkium_Forest").setBaseHeight(1.5F).setHeightVariation(0.9F).setTemperature(0.9F).setRainfall(0.5F).setWaterColor(7799039));

		topBlock = BlockInit.DIRT_DARKIUM.getDefaultState();
		fillerBlock = BlockInit.ORE_OVERWORLD.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.DARKIUM);
		
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
