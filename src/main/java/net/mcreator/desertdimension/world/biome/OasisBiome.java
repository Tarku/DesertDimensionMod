
package net.mcreator.desertdimension.world.biome;

import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.placement.FrequencyWithExtraChanceDecoratorConfiguration;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoiseDependantDecoratorConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.data.worldgen.Features;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.core.Registry;

import net.mcreator.desertdimension.init.DesertdimensionModBlocks;
import net.mcreator.desertdimension.DesertdimensionMod;

import java.util.Map;
import java.util.HashMap;

public class OasisBiome {
	private static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderBaseConfiguration(
			DesertdimensionModBlocks.WET_SAND.defaultBlockState(), Blocks.SANDSTONE.defaultBlockState(), Blocks.SANDSTONE.defaultBlockState()));

	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-6684724).waterColor(-6723841).waterFogColor(329011)
				.skyColor(-6684724).foliageColorOverride(-6684928).grassColorOverride(9470285).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(SURFACE_BUILDER);
		biomeGenerationSettings.addStructureStart(StructureFeatures.MINESHAFT_MESA);
		biomeGenerationSettings.addStructureStart(StructureFeatures.DESERT_PYRAMID);
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, register("trees", Feature.TREE
				.configured((new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(Blocks.JUNGLE_WOOD.defaultBlockState()),
						new ForkingTrunkPlacer(7, 2, 2), new SimpleStateProvider(Blocks.JUNGLE_LEAVES.defaultBlockState()),
						new SimpleStateProvider(Blocks.ACACIA_SAPLING.defaultBlockState()),
						new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build())
				.decorated(Features.Decorators.HEIGHTMAP_SQUARE)
				.decorated(FeatureDecorator.COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(2, 0.1F, 1)))));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				register("grass",
						Feature.RANDOM_PATCH.configured(Features.Configs.DEFAULT_GRASS_CONFIG).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE)
								.decorated(FeatureDecorator.COUNT_NOISE.configured(new NoiseDependantDecoratorConfiguration(-0.8D, 5, 1)))));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, register("patch_sugar_cane",
				Feature.RANDOM_PATCH.configured(Features.Configs.SUGAR_CANE_CONFIG).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(1)));
		BiomeDefaultFeatures.addDefaultCarvers(biomeGenerationSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder().setPlayerCanSpawn();
		mobSpawnInfo.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.AXOLOTL, 3, 1, 1));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 4, 1, 2));
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.DESERT).depth(-0.5f).scale(0.2f)
				.temperature(1.5f).downfall(0.1f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build())
				.generationSettings(biomeGenerationSettings.build()).build();
	}

	public static void init() {
		Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(DesertdimensionMod.MODID, "oasis"), SURFACE_BUILDER);
		CONFIGURED_FEATURES.forEach((resourceLocation, configuredFeature) -> Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, resourceLocation,
				configuredFeature));
	}

	private static final Map<ResourceLocation, ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = new HashMap<>();

	private static ConfiguredFeature<?, ?> register(String name, ConfiguredFeature<?, ?> configuredFeature) {
		CONFIGURED_FEATURES.put(new ResourceLocation(DesertdimensionMod.MODID, name + "_oasis"), configuredFeature);
		return configuredFeature;
	}
}
