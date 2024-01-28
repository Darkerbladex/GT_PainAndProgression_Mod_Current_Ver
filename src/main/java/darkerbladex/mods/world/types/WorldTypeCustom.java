package darkerbladex.mods.world.types;

import darkerbladex.mods.world.types.layer.GenLayerCustom;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.layer.GenLayer;

public class WorldTypeCustom extends WorldType {
	
	public WorldTypeCustom() {
		super("Custom");
		
		
	}
	
	@Override
	public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer, ChunkGeneratorSettings chunkSettings) {
	
	return new GenLayerCustom(worldSeed);
	}

}
