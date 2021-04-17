package net.kunmc.lab.liquefaction.mixin;

import net.minecraft.block.*;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(FlowingFluidBlock.class)
public abstract class MixinFlowingFluidBlock extends Block implements IBucketPickupHandler{
    @Shadow @Final private FlowingFluid fluid;

    @Shadow protected abstract void triggerMixEffects(IWorld worldIn, BlockPos pos);

    public MixinFlowingFluidBlock(Properties properties) {
        super(properties);
    }
    /**
     * @author otamusan
     * @reason sushi
     */
    @Overwrite
    private boolean reactWithNeighbors(World worldIn, BlockPos pos, BlockState state) {
        return true;
        /*if (this.fluid.isIn(FluidTags.LAVA)) {
            boolean flag = worldIn.getBlockState(pos.down()).matchesBlock(Blocks.SOUL_SOIL);

            for(Direction direction : Direction.values()) {
                if (direction != Direction.DOWN) {
                    BlockPos blockpos = pos.offset(direction);
                    if (worldIn.getFluidState(blockpos).isTagged(FluidTags.WATER)) {
                        Block block = worldIn.getFluidState(pos).isSource() ? Blocks.OBSIDIAN : Blocks.COBBLESTONE;
                        if(block==Blocks.COBBLESTONE) return true;
                        worldIn.setBlockState(pos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, block.getDefaultState()));
                        this.triggerMixEffects(worldIn, pos);
                        return false;
                    }

                    if (flag && worldIn.getBlockState(blockpos).matchesBlock(Blocks.BLUE_ICE)) {
                        worldIn.setBlockState(pos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, Blocks.BASALT.getDefaultState()));
                        this.triggerMixEffects(worldIn, pos);
                        return false;
                    }
                }
            }
        }

        return true;
        */
    }
}
