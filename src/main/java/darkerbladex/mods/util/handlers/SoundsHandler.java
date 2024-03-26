package darkerbladex.mods.util.handlers;

import darkerbladex.mods.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler {

	public static SoundEvent BLOCK_BLOCK_DAUOM_REDSIG;
	
	public static void registerSounds() {
		
		BLOCK_BLOCK_DAUOM_REDSIG = registerSound("block.block_dauom.redsig");
		
	}
	
	private static SoundEvent registerSound(String name) {
		
		ResourceLocation location = new ResourceLocation(Reference.MODID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		
		return event;
		
	}
	
}
