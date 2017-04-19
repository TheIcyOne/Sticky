package com.headfishindustries.sticky.blocks.fluid;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class StickyFluids {
	public static Fluid coldWater;
	public static Fluid lukewarmWater;
	public static Fluid hotWater;
	public static Fluid sap;
	
	static{setupFluids();}
	public static void setupFluids(){		
		coldWater = FluidColdWater.instance;
		coldWater.setTemperature(5);
		FluidRegistry.addBucketForFluid(coldWater);
	
		lukewarmWater = FluidLukewarmWater.instance;
		lukewarmWater.setTemperature(32);
		FluidRegistry.addBucketForFluid(lukewarmWater);
		
		hotWater = FluidHotWater.instance;
		hotWater.setTemperature(95);
		FluidRegistry.addBucketForFluid(hotWater);
		
		sap = FluidSap.instance;
		sap.setTemperature(32);
		FluidRegistry.addBucketForFluid(sap);
	}
}
