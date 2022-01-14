package net.mcreator.desertdimension.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.desertdimension.init.DesertdimensionModBlocks;

public class DesertPortalNeighbourBlockChangesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == DesertdimensionModBlocks.MAAT_SHRINE)) {
			world.setBlock(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.defaultBlockState(), 3);
		}
	}
}
