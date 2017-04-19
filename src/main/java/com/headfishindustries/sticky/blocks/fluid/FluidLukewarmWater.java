package com.headfishindustries.sticky.blocks.fluid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidLukewarmWater extends Fluid{
	public static final String name = "lukewarm_water";
	public static final FluidLukewarmWater instance = new FluidLukewarmWater();
	
	public FluidLukewarmWater()
	{
		super(name, new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flowing"));
	}
}
