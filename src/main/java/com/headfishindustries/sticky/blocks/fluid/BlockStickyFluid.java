package com.headfishindustries.sticky.blocks.fluid;

import javax.annotation.Nonnull;

import com.headfishindustries.sticky.defs.TabDefs;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class BlockStickyFluid extends BlockFluidClassic{
	public BlockStickyFluid(Fluid fluid, Material material){
		super(fluid, material);
		setCreativeTab(TabDefs.tabStickyTrees);
	}
	
	@Nonnull
	@Override
	public String getUnlocalizedName() {
	Fluid f = FluidRegistry.getFluid(fluidName);
	if(f != null) return f.getUnlocalizedName();
	return super.getUnlocalizedName();
	}
}