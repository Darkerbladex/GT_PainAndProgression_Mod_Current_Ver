package darkerbladex.mods.util.handlers;

import darkerbladex.mods.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler {

	public static final ResourceLocation DARKIUM_ZOMBIE = new LootTableList().register(new ResourceLocation(Reference.MODID, "entities/darkium_zombie"));
	
	public static final ResourceLocation DARKIUM_ARMOURY_CHEST = new LootTableList().register(new ResourceLocation(Reference.MODID, "chests/darkium_armoury_chest"));
}

