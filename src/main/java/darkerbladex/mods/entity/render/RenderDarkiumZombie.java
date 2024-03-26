package darkerbladex.mods.entity.render;

import org.lwjgl.opengl.GL11;

import darkerbladex.mods.entity.EntityDarkiumZombie;
import darkerbladex.mods.entity.model.ModelDarkiumZombie;
import darkerbladex.mods.objects.armour.ArmourBase;
import darkerbladex.mods.util.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.client.renderer.entity.layers.LayerElytra;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.renderer.entity.layers.LayerVillagerArmor;
import net.minecraft.entity.EntityLiving;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;

public class RenderDarkiumZombie extends RenderLiving<EntityDarkiumZombie> {

	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/darkiumzombie.png");
	public RenderDarkiumZombie(RenderManager manager) {
		super(manager, new ModelDarkiumZombie(), 0.5F);
		

		
		this.addLayer(new LayerVillagerArmor(this));
		
		
		
		
		

	}
    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        func_40292_b((EntityDarkiumZombie)par1EntityLiving, par2);
    }

    protected void func_40292_b(EntityDarkiumZombie par1EntityDarkiumZombie, float par2)
    {
        float f = 0.9375F;

        f = (float)((double)f * 0.5D);
        this.shadowSize = 0.25F;

        GL11.glScalef(f, f, f);
    }
	
	@Override
	protected ResourceLocation getEntityTexture(EntityDarkiumZombie entity) {
		
		return TEXTURES;
	}

	@Override
	protected void applyRotations(EntityDarkiumZombie entityLiving, float p_77043_2_, float rotationYaw,
			float partialTicks) {
		// TODO Auto-generated method stub
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}

}
