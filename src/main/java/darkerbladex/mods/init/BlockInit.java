package darkerbladex.mods.init;

import java.util.ArrayList;
import java.util.List;

import darkerbladex.mods.Main;
import darkerbladex.mods.objects.blocks.BlockBase;
import darkerbladex.mods.objects.blocks.BlockDirtBase;
import darkerbladex.mods.objects.blocks.BlockLeaf;
import darkerbladex.mods.objects.blocks.BlockLogs;
import darkerbladex.mods.objects.blocks.BlockOres;
import darkerbladex.mods.objects.blocks.BlockPlank;
import darkerbladex.mods.objects.blocks.BlockSaplings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit {

	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block BLOCK_COPPER = new BlockBase("block_dauom", Material.IRON, Main.modtab);
	
	public static final Block BLOCK_DARKIUM = new BlockBase("block_darkium", Material.IRON, Main.modtab);
	
	public static final Block BLOCK_LIGHTIUM = new BlockBase("block_lightium", Material.IRON, Main.modtab);
	
	public static final Block DIRT_DARKIUM = new BlockDirtBase("dirt_darkium", Main.modtab);
	public static final Block DIRT_LIGHTIUM = new BlockDirtBase("dirt_lightium", Main.modtab);
	
	public static final Block PLANKS =  new BlockPlank("planks");
	public static final Block LOGS =  new BlockLogs("log");
	public static final Block LEAVES =  new BlockLeaf("leaves");
	public static final Block SAPLINGS =  new BlockSaplings("sapling");
	
	public static final Block ORE_END = new BlockOres("ore_end", "end");
	public static final Block ORE_OVERWORLD = new BlockOres("ore_overworld", "overworld");
	public static final Block ORE_NETHER = new BlockOres("ore_nether", "nether");
	
}
