package darkerbladex.mods.objects.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import darkerbladex.mods.Main;
import darkerbladex.mods.init.BlockInit;
import darkerbladex.mods.init.ItemInit;
import darkerbladex.mods.objects.blocks.item.ItemBlockVariants;
import darkerbladex.mods.util.IHasModel;
import darkerbladex.mods.util.IMetaName;
import darkerbladex.mods.util.handlers.EnumHandler;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLeaf extends BlockLeaves implements IMetaName, IHasModel
{
	
	public static final PropertyEnum<EnumHandler.EnumType> VARIANT = PropertyEnum.<EnumHandler.EnumType>create("variant", EnumHandler.EnumType.class, new Predicate<EnumHandler.EnumType>()
	{
		public boolean apply(@Nullable EnumHandler.EnumType apply) {
			return apply.getMeta() < 2;
		}
	});
	
	private String name;
	
	public BlockLeaf(String name) {
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.PLANT);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandler.EnumType.DARKIUM).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf((true))));
		setCreativeTab(Main.modtab);
		
        this.name = name;
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
		
	}
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, EnumHandler.EnumType.byMetadata(meta % 2));
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		int i = ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
		if(!((Boolean)state.getValue(DECAYABLE)).booleanValue())
		{
			i |=2;
		}
		
		if(!((Boolean)state.getValue(CHECK_DECAY)).booleanValue())
		{
			i |=4;
		}
		
		return i;
	}
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for(EnumHandler.EnumType blockplank$enumtype : EnumHandler.EnumType.values()) {
			items.add(new ItemStack(this, 1, blockplank$enumtype.getMeta()));
		}
	}
	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state)
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta());
	}
	@Override
	public int damageDropped(IBlockState state) {
		return ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
	}
	@Override
	 public Item getItemDropped(IBlockState state, Random rand, int fortune) {
	 return Item.getItemFromBlock(BlockInit.SAPLINGS);
	 }
	@Override
	public String getSpecialName(ItemStack stack)
	{
		return EnumHandler.EnumType.values()[stack.getItemDamage()].getName();
	}
	@Override
	protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance) { return; }
	@Override
	protected int getSaplingDropChance(IBlockState state) { return 30; }
	@Override
	public EnumType getWoodType(int meta) { return null; }
	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune)
	{
		return NonNullList.withSize(1, new ItemStack(this, 1, world.getBlockState(pos).getValue(VARIANT).getMeta()));
	}
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] { VARIANT, DECAYABLE, CHECK_DECAY });
	}
	@Override
	public boolean isOpaqueCube(IBlockState state) { return false; }
	@Override
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.TRANSLUCENT;
	}
	@Override
	public void registerModels() {
		for(int i = 0; i < EnumHandler.EnumType.values().length; i++) {
			Main.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "leaves_" + EnumHandler.EnumType.values()[i].getName(), "inventory");
		}
	}
}
