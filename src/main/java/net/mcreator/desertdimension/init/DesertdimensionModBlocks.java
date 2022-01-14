
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.desertdimension.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.desertdimension.block.WetSandBlock;
import net.mcreator.desertdimension.block.StoneOfIsisBlock;
import net.mcreator.desertdimension.block.MaatShrineBlock;
import net.mcreator.desertdimension.block.DesertPortalBlock;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DesertdimensionModBlocks {
	private static final List<Block> REGISTRY = new ArrayList<>();
	public static final Block STONE_OF_ISIS = register(new StoneOfIsisBlock());
	public static final Block WET_SAND = register(new WetSandBlock());
	public static final Block DESERT_PORTAL = register(new DesertPortalBlock());
	public static final Block MAAT_SHRINE = register(new MaatShrineBlock());

	private static Block register(Block block) {
		REGISTRY.add(block);
		return block;
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Block[0]));
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			MaatShrineBlock.registerRenderLayer();
		}
	}
}
