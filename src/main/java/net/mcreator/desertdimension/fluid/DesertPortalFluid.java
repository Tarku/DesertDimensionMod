
package net.mcreator.desertdimension.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.desertdimension.init.DesertdimensionModFluids;
import net.mcreator.desertdimension.init.DesertdimensionModBlocks;

public abstract class DesertPortalFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> DesertdimensionModFluids.DESERT_PORTAL,
			() -> DesertdimensionModFluids.FLOWING_DESERT_PORTAL,
			FluidAttributes.builder(new ResourceLocation("desertdimension:blocks/desert_portal"),
					new ResourceLocation("desertdimension:blocks/desert_portal")).luminosity(10).density(99999).viscosity(99999)

	).explosionResistance(100f)

			.tickRate(2034).levelDecreasePerBlock(8)

			.block(() -> (LiquidBlock) DesertdimensionModBlocks.DESERT_PORTAL);

	private DesertPortalFluid() {
		super(PROPERTIES);
	}

	public static class Source extends DesertPortalFluid {
		public Source() {
			super();
			setRegistryName("desert_portal");
		}

		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends DesertPortalFluid {
		public Flowing() {
			super();
			setRegistryName("flowing_desert_portal");
		}

		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
