package darkerbladex.mods.init;

import java.util.ArrayList;
import java.util.List;

import darkerbladex.mods.objects.blocks.BlockBase;
import darkerbladex.mods.objects.blocks.BlockOres;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit {

	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block BLOCK_COPPER = new BlockBase("block_dauom", Material.IRON);
	
	public static final Block BLOCK_DARKIUM = new BlockBase("block_darkium", Material.IRON);
	
	public static final Block BLOCK_LIGHTIUM = new BlockBase("block_lightium", Material.IRON);
	
	public static final Block ORE_END = new BlockOres("ore_end", "end");
	public static final Block ORE_OVERWORLD = new BlockOres("ore_overworld", "overworld");
	public static final Block ORE_NETHER = new BlockOres("ore_nether", "nether");
	
}
