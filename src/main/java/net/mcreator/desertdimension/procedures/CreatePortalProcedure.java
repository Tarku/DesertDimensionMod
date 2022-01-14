package net.mcreator.desertdimension.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.desertdimension.init.DesertdimensionModBlocks;

public class CreatePortalProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos((int) (x + -1), (int) y, (int) (z + -1)))).getBlock() == DesertdimensionModBlocks.STONE_OF_ISIS
				&& (world.getBlockState(new BlockPos((int) (x + -1), (int) y, (int) (z + 0)))).getBlock() == DesertdimensionModBlocks.STONE_OF_ISIS
				&& (world.getBlockState(new BlockPos((int) (x + -1), (int) y, (int) (z + 1)))).getBlock() == DesertdimensionModBlocks.STONE_OF_ISIS
				&& (world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + -1)))).getBlock() == DesertdimensionModBlocks.STONE_OF_ISIS
				&& (world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 0)))).getBlock() == DesertdimensionModBlocks.STONE_OF_ISIS
				&& (world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))).getBlock() == DesertdimensionModBlocks.STONE_OF_ISIS
				&& (world.getBlockState(new BlockPos((int) (x + 0), (int) y, (int) (z + -1)))).getBlock() == DesertdimensionModBlocks.STONE_OF_ISIS
				&& (world.getBlockState(new BlockPos((int) (x + 0), (int) y, (int) (z + 1)))).getBlock() == DesertdimensionModBlocks.STONE_OF_ISIS
				&& ((world.getBlockState(new BlockPos((int) (x + 0), (int) y, (int) (z + 0)))).getBlock() == Blocks.WATER
						|| (world.getBlockState(new BlockPos((int) (x + 0), (int) y, (int) (z + 0)))).getBlock() == Blocks.WATER)) {
			world.setBlock(new BlockPos((int) x, (int) y, (int) z), DesertdimensionModBlocks.DESERT_PORTAL.defaultBlockState(), 3);
		}
	}
}
