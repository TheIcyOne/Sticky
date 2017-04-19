package com.headfishindustries.sticky.blocks.fluid;

import com.headfishindustries.sticky.Sticky;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidSap extends Fluid{
	public static final String name = "sap";
	public static final FluidSap instance = new FluidSap();
	
	public FluidSap()
	{
		super(name, new ResourceLocation(Sticky.MODID + ":blocks/" + name + "_still"), new ResourceLocation(Sticky.MODID + ":blocks/" + name + "_flowing"));
	}
}
