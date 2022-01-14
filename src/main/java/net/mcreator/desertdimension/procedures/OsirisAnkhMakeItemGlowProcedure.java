package net.mcreator.desertdimension.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.Zoglin;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.monster.Giant;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.animal.horse.ZombieHorse;
import net.minecraft.world.entity.animal.horse.SkeletonHorse;

public class OsirisAnkhMakeItemGlowProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double osiris_ankh_range = 0;
		osiris_ankh_range = 12;
		return !world
				.getEntitiesOfClass(Zombie.class, AABB.ofSize(new Vec3(x, y, z), osiris_ankh_range, osiris_ankh_range, osiris_ankh_range), e -> true)
				.isEmpty()
				|| !world.getEntitiesOfClass(Skeleton.class, AABB.ofSize(new Vec3(x, y, z), osiris_ankh_range, osiris_ankh_range, osiris_ankh_range),
						e -> true).isEmpty()
				|| !world.getEntitiesOfClass(SkeletonHorse.class,
						AABB.ofSize(new Vec3(x, y, z), osiris_ankh_range, osiris_ankh_range, osiris_ankh_range), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(ZombieHorse.class,
						AABB.ofSize(new Vec3(x, y, z), osiris_ankh_range, osiris_ankh_range, osiris_ankh_range), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(Drowned.class, AABB.ofSize(new Vec3(x, y, z), osiris_ankh_range, osiris_ankh_range, osiris_ankh_range),
						e -> true).isEmpty()
				|| !world.getEntitiesOfClass(Giant.class, AABB.ofSize(new Vec3(x, y, z), osiris_ankh_range, osiris_ankh_range, osiris_ankh_range),
						e -> true).isEmpty()
				|| !world.getEntitiesOfClass(Husk.class, AABB.ofSize(new Vec3(x, y, z), osiris_ankh_range, osiris_ankh_range, osiris_ankh_range),
						e -> true).isEmpty()
				|| !world.getEntitiesOfClass(Stray.class, AABB.ofSize(new Vec3(x, y, z), osiris_ankh_range, osiris_ankh_range, osiris_ankh_range),
						e -> true).isEmpty()
				|| !world.getEntitiesOfClass(WitherSkeleton.class,
						AABB.ofSize(new Vec3(x, y, z), osiris_ankh_range, osiris_ankh_range, osiris_ankh_range), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(Zoglin.class, AABB.ofSize(new Vec3(x, y, z), osiris_ankh_range, osiris_ankh_range, osiris_ankh_range),
						e -> true).isEmpty()
				|| !world.getEntitiesOfClass(ZombieVillager.class,
						AABB.ofSize(new Vec3(x, y, z), osiris_ankh_range, osiris_ankh_range, osiris_ankh_range), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(ZombifiedPiglin.class,
						AABB.ofSize(new Vec3(x, y, z), osiris_ankh_range, osiris_ankh_range, osiris_ankh_range), e -> true).isEmpty();
	}
}
