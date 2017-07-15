package com.headfishindustries.sticky.blocks.fluid;

import com.headfishindustries.sticky.Sticky;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class StickyFluids {
	public static Fluid coldWater = new Fluid("cold_water", new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flowing"));
	public static Fluid lukewarmWater = new Fluid("lukewarm_water", new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flowing"));
	public static Fluid hotWater = new Fluid("hot_water", new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flowing"));
	public static Fluid sap;
	
//	static{setupFluids();}
	public static void setupFluids(){		
		coldWater.setTemperature(5);
		FluidRegistry.registerFluid(coldWater);
		FluidRegistry.addBucketForFluid(coldWater);
		coldWater = FluidRegistry.getFluid(StickyFluids.coldWater.getName());
		registerFluidBlock(coldWater);
	
		lukewarmWater.setTemperature(32);
		FluidRegistry.addBucketForFluid(lukewarmWater);
		FluidRegistry.registerFluid(lukewarmWater);
		lukewarmWater = FluidRegistry.getFluid(StickyFluids.lukewarmWater.getName());
		registerFluidBlock(lukewarmWater);
		
		hotWater.setTemperature(95);
		FluidRegistry.addBucketForFluid(hotWater);
		FluidRegistry.registerFluid(hotWater);
		hotWater = FluidRegistry.getFluid(StickyFluids.hotWater.getName());
		registerFluidBlock(hotWater);
		
		/*sap = FluidSap.instance;
		sap.setTemperature(32);
		FluidRegistry.addBucketForFluid(sap);
		registerFluidBlock(sap);*/
	}
	
	public static BlockFluidBase registerFluidBlock(Fluid f){
		BlockFluidBase b = new BlockFluidClassic(f, Material.WATER);
		Sticky.LOGGER.info("Registering FluidBlock sticky:" + f.getName());
		return (BlockFluidBase) GameRegistry.register((Block)b, new ResourceLocation("sticky:" + f.getName()));
	}
}
