package darkerbladex.mods.init;

import java.util.ArrayList;
import java.util.List;

import darkerbladex.mods.objects.armour.ArmourBase;
import darkerbladex.mods.objects.items.ItemBase;
import darkerbladex.mods.objects.tools.ToolAxe;
import darkerbladex.mods.objects.tools.ToolHoe;
import darkerbladex.mods.objects.tools.ToolPickaxe;
import darkerbladex.mods.objects.tools.ToolShovel;
import darkerbladex.mods.objects.tools.ToolSword;
import darkerbladex.mods.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Materials
	public static final ToolMaterial TOOL_DARKIUM = EnumHelper.addToolMaterial("tool_darkium", 4, 2000, 10.0f, 5.0f, 20);
	public static final ArmorMaterial ARMOUR_DARKIUM = EnumHelper.addArmorMaterial("armour_darkium", Reference.MODID + ":darkium", 50, new int[] {10, 15, 10, 10}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5f);
	
	//Items
	public static final Item NORI_ROD = new ItemBase("nori_rod");
	public static final Item DARKIUM_INGOT = new ItemBase("darkium_ingot");
	
	//Tools
	public static final Item AXE_DARKIUM = new ToolAxe("axe_darkium", TOOL_DARKIUM);
	public static final Item HOE_DARKIUM = new ToolHoe("hoe_darkium", TOOL_DARKIUM);
	public static final Item PICKAXE_DARKIUM = new ToolPickaxe("pickaxe_darkium", TOOL_DARKIUM);
	public static final Item SHOVEL_DARKIUM = new ToolShovel("shovel_darkium", TOOL_DARKIUM);
	public static final Item SWORD_DARKIUM = new ToolSword("sword_darkium", TOOL_DARKIUM);
	
	//Armour
	public static final Item HELMET_DARKIUM = new ArmourBase("helmet_darkium", ARMOUR_DARKIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_COPPER = new ArmourBase("chestplate_darkium", ARMOUR_DARKIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINGS_COPPER = new ArmourBase("leggings_darkium", ARMOUR_DARKIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_COPPER = new ArmourBase("boots_darkium", ARMOUR_DARKIUM, 1, EntityEquipmentSlot.FEET);

}
