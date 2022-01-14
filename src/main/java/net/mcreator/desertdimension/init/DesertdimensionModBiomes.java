
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.desertdimension.init;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.desertdimension.world.biome.OasisBiome;
import net.mcreator.desertdimension.world.biome.GravellyDesertBiome;
import net.mcreator.desertdimension.DesertdimensionMod;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DesertdimensionModBiomes {
	private static final List<Biome> REGISTRY = new ArrayList<>();
	public static Biome OASIS = register("oasis", OasisBiome.createBiome());
	public static Biome GRAVELLY_DESERT = register("gravelly_desert", GravellyDesertBiome.createBiome());

	private static Biome register(String registryname, Biome biome) {
		REGISTRY.add(biome.setRegistryName(new ResourceLocation(DesertdimensionMod.MODID, registryname)));
		return biome;
	}

	@SubscribeEvent
	public static void registerBiomes(RegistryEvent.Register<Biome> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Biome[0]));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			OasisBiome.init();
			GravellyDesertBiome.init();
		});
	}
}
