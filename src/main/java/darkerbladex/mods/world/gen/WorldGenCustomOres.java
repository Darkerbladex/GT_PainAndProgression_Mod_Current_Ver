package darkerbladex.mods.world.gen;

import java.util.Random;

import darkerbladex.mods.init.BlockInit;
import darkerbladex.mods.objects.blocks.BlockOres;
import darkerbladex.mods.util.handlers.EnumHandler;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustomOres implements IWorldGenerator {

	private WorldGenerator ore_nether_darkium, ore_overworld_darkium, ore_end_darkium;
	private WorldGenerator ore_nether_lightium, ore_overworld_lightium, ore_end_lightium;
	
	public WorldGenCustomOres() {
		ore_nether_darkium = new WorldGenMinable(BlockInit.ORE_NETHER.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.DARKIUM), 6, BlockMatcher.forBlock(Blocks.NETHERRACK));
		ore_overworld_darkium = new WorldGenMinable(BlockInit.ORE_OVERWORLD.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.DARKIUM), 6, BlockMatcher.forBlock(Blocks.STONE));
		ore_end_darkium = new WorldGenMinable(BlockInit.ORE_END.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.DARKIUM), 6, BlockMatcher.forBlock(Blocks.END_STONE));
		
		ore_nether_lightium = new WorldGenMinable(BlockInit.ORE_NETHER.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.LIGHTIUM), 6, BlockMatcher.forBlock(Blocks.NETHERRACK));
		ore_overworld_lightium = new WorldGenMinable(BlockInit.ORE_OVERWORLD.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.LIGHTIUM), 6, BlockMatcher.forBlock(Blocks.STONE));
		ore_end_lightium = new WorldGenMinable(BlockInit.ORE_END.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.LIGHTIUM), 6, BlockMatcher.forBlock(Blocks.END_STONE));
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.getDimension()) {
		case -1:
		
			runGenerator(ore_nether_darkium, world, random, chunkX, chunkZ, 15, 0, 75);
			runGenerator(ore_nether_lightium, world, random, chunkX, chunkZ, 15, 0, 50);
			
			break;
		case 0:
			
			runGenerator2(ore_overworld_darkium, world, random, chunkX, chunkZ,  0.0846, 5, 15);
			runGenerator2(ore_overworld_lightium, world, random, chunkX, chunkZ, 0.0700, 5, 15);
			
			break;
			
		case 1:
			
			runGenerator(ore_end_darkium, world, random, chunkX, chunkZ, 15, 0, 256);
			runGenerator(ore_end_lightium, world, random, chunkX, chunkZ, 15, 0, 150);
			
		}
			
	}
	
	
	private void runGenerator(WorldGenerator gen,World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight ) {
		
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore Generated out of Bounds how you make this Happen? go check");
		
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chance; i++) {
			
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			
			gen.generate(world, rand, new BlockPos(x,y,z));
		}
	
	}
	private void runGenerator2(WorldGenerator gen,World world, Random rand, int chunkX, int chunkZ, double chance, int minHeight, int maxHeight ) {
		
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore Generated out of Bounds how you make this Happen? go check");
		
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chance; i++) {
			
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			
			gen.generate(world, rand, new BlockPos(x,y,z));
		}
	
	}
	
}
