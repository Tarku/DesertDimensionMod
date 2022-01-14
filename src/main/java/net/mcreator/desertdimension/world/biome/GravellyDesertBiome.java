
package net.mcreator.desertdimension.world.biome;

import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.data.worldgen.Features;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.core.Registry;

import net.mcreator.desertdimension.DesertdimensionMod;

import java.util.Map;
import java.util.HashMap;

import com.google.common.collect.ImmutableList;

public class GravellyDesertBiome {
	private static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderBaseConfiguration(
			Blocks.GRAVEL.defaultBlockState(), Blocks.ANDESITE.defaultBlockState(), Blocks.ANDESITE.defaultBlockState()));

	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
				.foliageColorOverride(10387789).grassColorOverride(9470285).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(SURFACE_BUILDER);
		biomeGenerationSettings.addStructureStart(StructureFeatures.NETHER_FOSSIL);
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				register("disk_sand",
						Feature.DISK
								.configured(new DiskConfiguration(Blocks.SAND.defaultBlockState(), UniformInt.of(2, 4), 2,
										ImmutableList.of(Blocks.GRAVEL.defaultBlockState(), Blocks.ANDESITE.defaultBlockState())))
								.decorated(Features.Decorators.TOP_SOLID_HEIGHTMAP_SQUARE).count(1)));
		BiomeDefaultFeatures.addDefaultCarvers(biomeGenerationSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder().setPlayerCanSpawn();
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.DESERT).depth(0f).scale(0f)
				.temperature(1.6f).downfall(0f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build())
				.generationSettings(biomeGenerationSettings.build()).build();
	}

	public static void init() {
		Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(DesertdimensionMod.MODID, "gravelly_desert"),
				SURFACE_BUILDER);
		CONFIGURED_FEATURES.forEach((resourceLocation, configuredFeature) -> Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, resourceLocation,
				configuredFeature));
	}

	private static final Map<ResourceLocation, ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = new HashMap<>();

	private static ConfiguredFeature<?, ?> register(String name, ConfiguredFeature<?, ?> configuredFeature) {
		CONFIGURED_FEATURES.put(new ResourceLocation(DesertdimensionMod.MODID, name + "_gravelly_desert"), configuredFeature);
		return configuredFeature;
	}
}
