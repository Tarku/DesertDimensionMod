
package net.mcreator.desertdimension.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.desertdimension.procedures.DesertPortalMobplayerCollidesBlockProcedure;
import net.mcreator.desertdimension.init.DesertdimensionModFluids;

public class DesertPortalBlock extends LiquidBlock {
	public DesertPortalBlock() {
		super(DesertdimensionModFluids.DESERT_PORTAL, BlockBehaviour.Properties.of(Material.WATER).strength(100f).hasPostProcess((bs, br, bp) -> true)
				.emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 10));
		setRegistryName("desert_portal");
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		DesertPortalMobplayerCollidesBlockProcedure.execute(entity);
	}
}
