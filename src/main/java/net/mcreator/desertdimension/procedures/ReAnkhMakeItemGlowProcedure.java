package net.mcreator.desertdimension.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

public class ReAnkhMakeItemGlowProcedure {
	public static boolean execute(LevelAccessor world) {
		return world instanceof Level _lvl ? _lvl.isDay() : false;
	}
}
