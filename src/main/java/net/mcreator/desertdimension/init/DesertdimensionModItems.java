
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.desertdimension.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.desertdimension.item.RedstoneCrystalItem;
import net.mcreator.desertdimension.item.ReAnkhItem;
import net.mcreator.desertdimension.item.OsirisAnkhItem;
import net.mcreator.desertdimension.item.AnkhItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DesertdimensionModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item ANKH = register(new AnkhItem());
	public static final Item STONE_OF_ISIS = register(DesertdimensionModBlocks.STONE_OF_ISIS, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item WET_SAND = register(DesertdimensionModBlocks.WET_SAND, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item MAAT_SHRINE = register(DesertdimensionModBlocks.MAAT_SHRINE, CreativeModeTab.TAB_DECORATIONS);
	public static final Item REDSTONE_CRYSTAL = register(new RedstoneCrystalItem());
	public static final Item RE_ANKH = register(new ReAnkhItem());
	public static final Item OSIRIS_ANKH = register(new OsirisAnkhItem());

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	private static Item register(Block block, CreativeModeTab tab) {
		return register(new BlockItem(block, new Item.Properties().tab(tab)).setRegistryName(block.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
