package net.kunmc.lab.liquefaction.mixin;

import com.google.common.collect.ImmutableMap;
import com.mojang.authlib.GameProfile;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.state.Property;
import net.minecraft.state.StateHolder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(AbstractBlock.AbstractBlockState.class)
public abstract class MixinBlockState extends StateHolder<Block, BlockState> {

    protected MixinBlockState(Block block, ImmutableMap<Property<?>, Comparable<?>> propertyValueMap, MapCodec<BlockState> stateCodec) {
        super(block, propertyValueMap, stateCodec);
    }

    /**
     * @author otamusan
     * @reason sushi
     */
    @Overwrite
    public VoxelShape getCollisionShapeUncached(IBlockReader worldIn, BlockPos pos) {
        return VoxelShapes.empty();
    }

    /**
     * @author otamusan
     * @reason sushi
     */
    @Overwrite
    public VoxelShape getCollisionShape(IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return VoxelShapes.empty();
    }
    @Shadow
    public abstract BlockState getSelf();

    /**
     * @author otamusan
     * @reason sushi
     */
    @Overwrite
    public VoxelShape getCollisionShape(IBlockReader worldIn, BlockPos pos) {
        return VoxelShapes.empty();
    }
}
