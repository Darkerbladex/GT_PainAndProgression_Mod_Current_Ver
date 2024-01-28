package darkerbladex.mods.objects.blocks;

import darkerbladex.mods.Main;
import darkerbladex.mods.init.BlockInit;
import darkerbladex.mods.init.ItemInit;
import darkerbladex.mods.objects.blocks.item.ItemBlockVariants;
import darkerbladex.mods.util.IHasModel;
import darkerbladex.mods.util.IMetaName;
import darkerbladex.mods.util.handlers.EnumHandler;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IPlantable;

public class BlockDirtBase extends BlockBase
{
	public BlockDirtBase(String name, CreativeTabs tab) 
	{
		super(name, Material.GROUND, tab);
		setSoundType(SoundType.GROUND);
		setCreativeTab(Main.modtab);
		
	}
	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) 
	{
		return true;
	}

}


