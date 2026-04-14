package net.starpony.strawberry.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class DeferredParticleWallTorchBlock extends WallTorchBlock {
    private final Supplier<? extends ParticleOptions> particle;

    public DeferredParticleWallTorchBlock(Supplier<? extends ParticleOptions> particle, BlockBehaviour.Properties properties) {
        super(ParticleTypes.FLAME, properties);
        this.particle = particle;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        Direction direction = state.getValue(FACING).getOpposite();
        double x = pos.getX() + 0.5D + 0.27D * direction.getStepX();
        double y = pos.getY() + 0.92D;
        double z = pos.getZ() + 0.5D + 0.27D * direction.getStepZ();
        level.addParticle(this.particle.get(), x, y, z, 0.0D, 0.0D, 0.0D);
    }
}
