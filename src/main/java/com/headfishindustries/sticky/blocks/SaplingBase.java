package com.headfishindustries.sticky.blocks;

import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBirchTree;

public abstract class SaplingBase extends BlockBush implements IGrowable{
	
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
		WorldGenBirchTree gen = new WorldGenBirchTree(true, true);
		worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
		
		if (!gen.generate(worldIn, rand, pos))
			worldIn.setBlockState(pos, getDefaultState());
	}

}
