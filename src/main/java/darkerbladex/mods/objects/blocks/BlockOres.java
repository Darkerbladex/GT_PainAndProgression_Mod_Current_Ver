package darkerbladex.mods.objects.blocks;

import darkerbladex.mods.Main;
import darkerbladex.mods.init.BlockInit;
import darkerbladex.mods.init.ItemInit;
import darkerbladex.mods.objects.blocks.item.ItemBlockVariants;
import darkerbladex.mods.util.IHasModel;
import darkerbladex.mods.util.IMetaName;
import darkerbladex.mods.util.handlers.EnumHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockOres extends Block implements IHasModel, IMetaName {

	public static final PropertyEnum<EnumHandler.EnumType> VARIANT = PropertyEnum.<EnumHandler.EnumType>create("variant", EnumHandler.EnumType.class);
	
	
	private String name, dimension;
	
	
public BlockOres(String name, String dimension) {
		
		
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.modtab);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandler.EnumType.DARKIUM));
		
		
		this.setHardness(6.0F);
		this.setResistance(15.0F);
	    this.setHarvestLevel("pickaxe", 3, this.getDefaultState().withProperty(VARIANT, EnumHandler.EnumType.DARKIUM));
        this.setHarvestLevel("pickaxe", 4, this.getDefaultState().withProperty(VARIANT, EnumHandler.EnumType.LIGHTIUM));
		
		this.name = name;
		this.dimension = dimension;
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	}
	

	@Override
	public int damageDropped(IBlockState state) {
		return ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
	}
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
	}
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, EnumHandler.EnumType.byMetadata(meta));
	}
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
			return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for(EnumHandler.EnumType variant : EnumHandler.EnumType.values()) {
			items.add(new ItemStack(this, 1, variant.getMeta()));
		}
	}
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}
	@Override
	public String getSpecialName(ItemStack stack) {
		return EnumHandler.EnumType.values()[stack.getItemDamage()].getName();
	}
	@Override
	public void registerModels() {
		for(int i = 0; i < EnumHandler.EnumType.values().length; i++) {
			Main.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "ore_" + this.dimension + "_" + EnumHandler.EnumType.values()[i].getName(), "inventory");
		}
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_OVERWORLD, 1, 0), new ItemStack(ItemInit.DARKIUM_INGOT, 1), 10.0F);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_OVERWORLD, 1, 1), new ItemStack(ItemInit.UNSTABLE_LIGHTIUM, 1), 10.0F);
		
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_NETHER, 1, 0), new ItemStack(ItemInit.DARKIUM_INGOT, 2), 10.0F);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_NETHER, 1, 1), new ItemStack(ItemInit.UNSTABLE_LIGHTIUM, 2), 10.0F);
		
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_END, 1, 0), new ItemStack(ItemInit.DARKIUM_INGOT, 3), 10.0F);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_END, 1, 1), new ItemStack(ItemInit.UNSTABLE_LIGHTIUM, 3), 10.0F);
	}
	

}
