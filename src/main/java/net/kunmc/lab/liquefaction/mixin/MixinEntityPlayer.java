package net.kunmc.lab.liquefaction.mixin;

import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import net.minecraft.command.ICommandSource;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluid;
import net.minecraft.tags.ITag;
import net.minecraft.util.INameable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.*;

import javax.annotation.Nullable;

@Mixin(Entity.class)
public abstract class MixinEntityPlayer extends net.minecraftforge.common.capabilities.CapabilityProvider<Entity> implements INameable, ICommandSource, net.minecraftforge.common.extensions.IForgeEntity{

    @Shadow public World world;

    @Shadow public abstract int getEntityId();

    @Shadow @Nullable public abstract Entity getRidingEntity();

    @Shadow protected boolean inWater;

    @Shadow protected boolean firstUpdate;

    @Shadow protected abstract void doWaterSplashEffect();

    @Shadow public float fallDistance;

    @Shadow public abstract void extinguish();

    @Shadow public abstract AxisAlignedBB getBoundingBox();

    @Shadow public abstract boolean isPushedByWater();

    @Shadow public abstract Vector3d getMotion();

    @Shadow public abstract void setMotion(Vector3d motionIn);

    @Shadow protected Object2DoubleMap<ITag<Fluid>> eyesFluidLevel;
    protected MixinEntityPlayer(Class<Entity> baseClass) {
        super(baseClass);
    }

    public Entity getEntity(){
        return world.getEntityByID(getEntityId());
    }
    /**
     * @author otamusan
     * @reason sushi
     */
   /* @Overwrite
    void updateWaterState() {
        if (this.getRidingEntity() instanceof BoatEntity) {
            this.inWater = false;
        } else if (this.handleFluidAcceleration(FluidTags.WATER, 0.014D)) {
            if (!this.inWater && !this.firstUpdate) {
                this.doWaterSplashEffect();
            }

            this.fallDistance = 0.0F;
            this.inWater = true;
            this.extinguish();
        } else {
            this.inWater = false;
        }
    }*/
    /**
     * @author otamusan
     * @reason sushi
     */
    /*
    @Overwrite
    public boolean handleFluidAcceleration(ITag<Fluid> fluidTag, double motionScale) {
        AxisAlignedBB axisalignedbb = this.getBoundingBox().shrink(0.001D);
        int fx = MathHelper.floor(axisalignedbb.minX);
        int tx = MathHelper.ceil(axisalignedbb.maxX);
        int fy = MathHelper.floor(axisalignedbb.minY);
        int ty = MathHelper.ceil(axisalignedbb.maxY);
        int fz = MathHelper.floor(axisalignedbb.minZ);
        int tz = MathHelper.ceil(axisalignedbb.maxZ);
        if (!this.world.isAreaLoaded(fx, fy, fz, tx, ty, tz)) {
            return false;
        } else {
            double d0 = 0.0D;
            boolean flag = this.isPushedByWater();
            boolean flag1 = false;
            Vector3d vector3d = Vector3d.ZERO;
            int k1 = 0;
            BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

            for(int l1 = fx; l1 < tx; ++l1) {
                for(int i2 = fy; i2 < ty; ++i2) {
                    for(int j2 = fz; j2 < tz; ++j2) {
                        blockpos$mutable.setPos(l1, i2, j2);
                        BlockState blockstate = world.getBlockState(blockpos$mutable);
                        FluidState fluidstate = this.world.getFluidState(blockpos$mutable);
                        if (fluidstate.isTagged(fluidTag)) {
                            double d1 = (double)((float)i2 + fluidstate.getActualHeight(this.world, blockpos$mutable));
                            if (d1 >= axisalignedbb.minY) {
                                flag1 = true;
                                d0 = Math.max(d1 - axisalignedbb.minY, d0);
                                if (flag) {
                                    Vector3d vector3d1 = fluidstate.getFlow(this.world, blockpos$mutable);
                                    if (d0 < 0.4D) {
                                        vector3d1 = vector3d1.scale(d0);
                                    }

                                    vector3d = vector3d.add(vector3d1);
                                    ++k1;
                                }
                            }
                        }else{

                            if(!blockstate.getBlock().isAir(blockstate, world, blockpos$mutable)){
                                flag1 =true;
                                System.out.println(423);
                            }
                        }
                    }
                }
            }

            if (vector3d.length() > 0.0D) {
                if (k1 > 0) {
                    vector3d = vector3d.scale(1.0D / (double)k1);
                }

                if (!(getEntity() instanceof PlayerEntity)) {
                    vector3d = vector3d.normalize();
                }

                Vector3d vector3d2 = this.getMotion();
                vector3d = vector3d.scale(motionScale * 1.0D);
                double d2 = 0.003D;
                if (Math.abs(vector3d2.x) < 0.003D && Math.abs(vector3d2.z) < 0.003D && vector3d.length() < 0.0045000000000000005D) {
                    vector3d = vector3d.normalize().scale(0.0045000000000000005D);
                }

                this.setMotion(this.getMotion().add(vector3d));
            }

            this.eyesFluidLevel.put(fluidTag, d0);
            return flag1;
        }
    }*/
}
