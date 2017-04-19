package com.headfishindustries.sticky.blocks.fluid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidColdWater extends Fluid{
	public static final String name = "cold_water";
	public static final FluidColdWater instance = new FluidColdWater();
	
	public FluidColdWater()
	{
		super(name, new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flowing"));
	}
}
