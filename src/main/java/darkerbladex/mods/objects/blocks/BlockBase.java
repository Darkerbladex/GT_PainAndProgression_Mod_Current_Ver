package darkerbladex.mods.objects.blocks;

import darkerbladex.mods.Main;
import darkerbladex.mods.init.BlockInit;
import darkerbladex.mods.init.ItemInit;
import darkerbladex.mods.tabs.ModTab;
import darkerbladex.mods.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {
	
	
	public BlockBase(String name, Material material) {
		
		
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.modtab);
		
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}

}
