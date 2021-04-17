package net.kunmc.lab.liquefaction.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.particle.SpitParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ClientPlayerEntity.class)
public abstract class MixinClientEntityPlayer extends AbstractClientPlayerEntity {
    public MixinClientEntityPlayer(ClientWorld world, GameProfile profile) {
        super(world, profile);
    }

    /**
     * @author otamusan
     * @reason sushi
     */
    /*@Overwrite
    private boolean shouldBlockPushPlayer(BlockPos pos) {
        System.out.println(423);
        return false;
    }*/
}
