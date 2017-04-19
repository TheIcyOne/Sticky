package com.headfishindustries.sticky.blocks.fluid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidHotWater extends Fluid{
	public static final String name = "hot_water";
	public static final FluidHotWater instance = new FluidHotWater();
	
	public FluidHotWater()
	{
		super(name, new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flowing"));
	}
}
