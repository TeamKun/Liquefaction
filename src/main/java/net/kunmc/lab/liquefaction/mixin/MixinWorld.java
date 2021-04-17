package net.kunmc.lab.liquefaction.mixin;

import io.netty.channel.ChannelFlushPromiseNotifier;
import io.netty.channel.sctp.oio.OioSctpChannel;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(World.class)
public abstract class MixinWorld extends net.minecraftforge.common.capabilities.CapabilityProvider<World> implements IWorld, AutoCloseable, net.minecraftforge.common.extensions.IForgeWorld {
    @Shadow public abstract Chunk getChunkAt(BlockPos pos);

    @Shadow public abstract BlockState getBlockState(BlockPos pos);

    protected MixinWorld(Class<World> baseClass) {
        super(baseClass);
    }
    /**
     * @author otamusan
     * @reason sushi
     */
    @Overwrite
    public FluidState getFluidState(BlockPos pos) {
        if (World.isOutsideBuildHeight(pos)) {
            return Fluids.EMPTY.getDefaultState();
        } else {
            Chunk chunk = this.getChunkAt(pos);
            FluidState fluidState = chunk.getFluidState(pos);

            if(!chunk.getBlockState(pos).isAir() && fluidState.isEmpty()){
                return Fluids.WATER.getDefaultState();
            }
            return chunk.getFluidState(pos);

        }
    }
}