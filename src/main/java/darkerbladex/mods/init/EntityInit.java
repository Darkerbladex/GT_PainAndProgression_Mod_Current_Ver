package darkerbladex.mods.init;

import darkerbladex.mods.Main;
import darkerbladex.mods.entity.EntityDarkiumZombie;
import darkerbladex.mods.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {

	public static void regiserEntities()
	{
		
		registerEntity("darkium_zombie", EntityDarkiumZombie.class, Reference.ENTITY_DARKIUM_ZOMBIE, 75, 3705769, 000000);
		
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
	}
	
}
