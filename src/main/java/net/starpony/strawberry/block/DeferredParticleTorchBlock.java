package net.starpony.strawberry.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class DeferredParticleTorchBlock extends TorchBlock {
    private final Supplier<? extends ParticleOptions> particle;

    public DeferredParticleTorchBlock(Supplier<? extends ParticleOptions> particle, BlockBehaviour.Properties properties) {
        super(ParticleTypes.FLAME, properties);
        this.particle = particle;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        double x = pos.getX() + 0.5D;
        double y = pos.getY() + 0.7D;
        double z = pos.getZ() + 0.5D;
        level.addParticle(this.particle.get(), x, y, z, 0.0D, 0.0D, 0.0D);
    }
}
