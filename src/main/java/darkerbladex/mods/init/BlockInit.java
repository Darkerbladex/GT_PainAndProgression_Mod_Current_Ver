package darkerbladex.mods.init;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import darkerbladex.mods.Main;
import darkerbladex.mods.objects.blocks.BlockBase;
import darkerbladex.mods.objects.blocks.BlockDirtBase;
import darkerbladex.mods.objects.blocks.BlockLeaf;
import darkerbladex.mods.objects.blocks.BlockLogs;
import darkerbladex.mods.objects.blocks.BlockOres;
import darkerbladex.mods.objects.blocks.BlockPlank;
import darkerbladex.mods.objects.blocks.BlockSaplings;
import darkerbladex.mods.util.handlers.SoundsHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockInit {

	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	  public static final Block BLOCK_COPPER = new BlockBase("block_dauom", Material.IRON, Main.modtab) {
			    private boolean isPowered = false;

			    @Override
			    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
			        boolean previouslyPowered = isPowered;
			        isPowered = worldIn.isBlockPowered(pos);

			        if (isPowered && !previouslyPowered) {
			            // Start playing the sound when the block is powered for the first time
			            worldIn.scheduleUpdate(pos, this, 20);  // Schedule an update after 20 ticks (1 second) to start playing the sound
			        }
			    }

			    @Override
			    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
			        if (worldIn.isBlockPowered(pos)) {
			            // If the block is still powered, continue playing the sound
			            worldIn.playSound(null, pos, SoundsHandler.BLOCK_BLOCK_DAUOM_REDSIG, SoundCategory.BLOCKS, 1.0f, 1.0f);
			            worldIn.scheduleUpdate(pos, this, 60);  // Schedule the next update after 20 ticks to continue playing the sound
			        }
			    }
			};
	
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
