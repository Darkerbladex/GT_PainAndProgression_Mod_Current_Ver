package darkerbladex.mods.entity.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelZombie - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelDarkiumZombie extends ModelBase {
    public ModelRenderer RightArm;
    public ModelRenderer RightLeg;
    public ModelRenderer Head;
    public ModelRenderer ZombieBody;
    public ModelRenderer LeftArm;
    public ModelRenderer LeftLeg;

    public ModelDarkiumZombie() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.ZombieBody = new ModelRenderer(this, 16, 16);
        this.ZombieBody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ZombieBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.RightArm = new ModelRenderer(this, 40, 16);
        this.RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.RightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(RightArm, -1.3962634015954636F, -0.10000736613927509F, 0.10000736613927509F);
        this.LeftArm = new ModelRenderer(this, 40, 16);
        this.LeftArm.mirror = true;
        this.LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.LeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(LeftArm, -1.3962634015954636F, 0.10000736613927509F, -0.10000736613927509F);
        this.RightLeg = new ModelRenderer(this, 0, 16);
        this.RightLeg.setRotationPoint(-1.9F, 12.0F, 0.1F);
        this.RightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 0, 16);
        this.LeftLeg.mirror = true;
        this.LeftLeg.setRotationPoint(1.9F, 12.0F, 0.1F);
        this.LeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
    }
    
  /*  if (isChild)
    {
        float f = 2.0F;
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, textureHeight * f, textureWidth * f);
        Head.render(f);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glScalef(1.0F / f, 1.0F / f, 1.0F / f);
        GL11.glTranslatef(0.0F, 24F * f, 0.0F);
        ZombieBody.render(f);
        RightArm.render(f);
        LeftArm.render(f);
        RightLeg.render(f);
        LeftLeg.render(f);
        GL11.glPopMatrix();
    }
    }
    */


    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Head.render(f5);
        this.ZombieBody.render(f5);
        this.RightArm.render(f5);
        this.LeftArm.render(f5);
        this.RightLeg.render(f5);
        this.LeftLeg.render(f5);
        
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
    	this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + ((float)Math.PI)) * 1.4F * limbSwingAmount;
    	
    	this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.Head.rotateAngleX = headPitch * 0.017453292F;
    }
}
