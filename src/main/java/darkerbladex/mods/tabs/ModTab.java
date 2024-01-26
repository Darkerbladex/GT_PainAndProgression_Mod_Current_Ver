package darkerbladex.mods.tabs;

import darkerbladex.mods.init.BlockInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModTab extends CreativeTabs {

	public ModTab(String label) { super("modtab");
	this.setBackgroundImageName("mod.png");}

	@Override
	public ItemStack getTabIconItem(){return new ItemStack(Item.getItemFromBlock(BlockInit.BLOCK_DARKIUM));}
	
}
