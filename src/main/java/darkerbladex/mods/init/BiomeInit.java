package darkerbladex.mods.init;

import darkerbladex.mods.world.gen.biomes.BiomeDarkiumForest;
import darkerbladex.mods.world.gen.biomes.BiomeLightiumForest;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeInit {
	
	public static final Biome DARKIUM_FOREST = new BiomeDarkiumForest();
	public static final Biome LIGHTIUM_FOREST = new BiomeLightiumForest();
	
	public static void registerBiomes() {
		initBiome(DARKIUM_FOREST, "Darkium_Forest", BiomeType.WARM, Type.FOREST, Type.NETHER, Type.END, Type.MOUNTAIN, Type.VOID, Type.HILLS, Type.DENSE);
		initBiome(LIGHTIUM_FOREST, "Lightium_Forest", BiomeType.WARM, Type.FOREST, Type.NETHER, Type.END, Type.MOUNTAIN, Type.VOID, Type.HILLS, Type.DENSE);
	}
	private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types) {
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		System.out.println("Biome Registerd");
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
		BiomeManager.addSpawnBiome(biome);
		System.out.println("Biome Registerd");
		
		return biome;
	}
}
