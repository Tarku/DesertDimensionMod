package net.mcreator.desertdimension.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.desertdimension.init.DesertdimensionModBlocks;

public class DesertDimPlayerEntersDimensionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(new BlockPos((int) (x + 1), (int) (y + 4), (int) (z + 1)), DesertdimensionModBlocks.STONE_OF_ISIS.defaultBlockState(), 3);
		world.setBlock(new BlockPos((int) (x + 1), (int) (y + 4), (int) (z + 0)), DesertdimensionModBlocks.STONE_OF_ISIS.defaultBlockState(), 3);
		world.setBlock(new BlockPos((int) (x + 1), (int) (y + 4), (int) (z + -1)), DesertdimensionModBlocks.STONE_OF_ISIS.defaultBlockState(), 3);
		world.setBlock(new BlockPos((int) (x + 0), (int) (y + 4), (int) (z + 1)), DesertdimensionModBlocks.STONE_OF_ISIS.defaultBlockState(), 3);
		world.setBlock(new BlockPos((int) (x + 0), (int) (y + 4), (int) (z + 0)), DesertdimensionModBlocks.DESERT_PORTAL.defaultBlockState(), 3);
		world.setBlock(new BlockPos((int) (x + 0), (int) (y + 4), (int) (z + -1)), DesertdimensionModBlocks.STONE_OF_ISIS.defaultBlockState(), 3);
		world.setBlock(new BlockPos((int) (x + -1), (int) (y + 4), (int) (z + 1)), DesertdimensionModBlocks.STONE_OF_ISIS.defaultBlockState(), 3);
		world.setBlock(new BlockPos((int) (x + -1), (int) (y + 4), (int) (z + 0)), DesertdimensionModBlocks.STONE_OF_ISIS.defaultBlockState(), 3);
		world.setBlock(new BlockPos((int) (x + -1), (int) (y + 4), (int) (z + -1)), DesertdimensionModBlocks.STONE_OF_ISIS.defaultBlockState(), 3);
	}
}
