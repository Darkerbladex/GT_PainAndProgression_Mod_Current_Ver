package darkerbladex.mods.util.handlers;

import darkerbladex.mods.entity.EntityDarkiumZombie;
import darkerbladex.mods.entity.render.RenderDarkiumZombie;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {
	
	public static void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkiumZombie.class, new IRenderFactory<EntityDarkiumZombie>(){
			
			@Override
			public Render<? super EntityDarkiumZombie> createRenderFor(RenderManager manager) {

				return new RenderDarkiumZombie(manager);
			}
			
		});
	}

}
