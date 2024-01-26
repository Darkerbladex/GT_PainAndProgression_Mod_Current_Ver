package darkerbladex.mods;

import darkerbladex.mods.proxy.CommonProxy;
import darkerbladex.mods.tabs.ModTab;
import darkerbladex.mods.util.Reference;
import darkerbladex.mods.util.handlers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION)
public class Main {
	
	
	@Instance
	public static Main instance;
	
	public static final CreativeTabs modtab = new ModTab("modtab");
	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {RegistryHandler.otherRegistries();}
	@EventHandler
	public static void init(FMLInitializationEvent event) {}
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event) {}
}
