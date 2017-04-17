package com.headfishindustries.sticky.blocks;

import java.util.Random;

import com.headfishindustries.sticky.defs.TabDefs;
import com.headfishindustries.sticky.gen.TreeGenerator;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class SaplingBase extends BlockBush implements IGrowable{
	
	public SaplingBase(){
		super();
		setCreativeTab(TabDefs.tabStickyTrees);
	}
	
	public abstract EnumTreeType getTreeType();

	private void updateOrGrow(World world, BlockPos pos, IBlockState state, Random rand){
		if (!(world.getBlockState(pos).getBlock() instanceof SaplingBase)) return;
		if (canGrow(world, pos, world.getBlockState(pos), world.isRemote))
			this.grow(world, rand, pos, world.getBlockState(pos));		
	}
	
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand){
		if (worldIn.isRemote) return;
		super.updateTick(worldIn, pos, state, rand);
		updateOrGrow(worldIn, pos, state, rand);
	}
	
	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state){
		TreeGenerator gen = new TreeGenerator(true);
		if (!gen.generate(worldIn, rand, pos))
			worldIn.setBlockState(pos, getDefaultState());
	}
	
	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return true;
	}
}
