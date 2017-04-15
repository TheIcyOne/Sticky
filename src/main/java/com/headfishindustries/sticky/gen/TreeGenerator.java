package com.headfishindustries.sticky.gen;

import java.util.Random;

import com.headfishindustries.sticky.blocks.LogBase;

import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class TreeGenerator extends WorldGenAbstractTree{
	
	//Currently unused, but should be usable 
	int trunkSize = 1;


	public TreeGenerator(boolean notify) {
		super(notify);
		
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		int height = rand.nextInt(3) + 5;
		IBlockState state = new LogBase().getDefaultState().withProperty(LogBase.LOG_AXIS, EnumAxis.Y);
		generatePillar(worldIn, position, height, state);
		return false;
	}
	
	public boolean generatePillar(World worldIn, BlockPos start, int height, IBlockState state){
		for (int i = 0; i < height; i++){
			IBlockState b = worldIn.getBlockState(start.up(i));
			if (!(b.getBlock() instanceof BlockAir || b.getBlock() instanceof BlockLog || b.getBlock() instanceof BlockLeaves)) return false;
			worldIn.setBlockState(start.up(i), state);
			
		}
		return true;
	}

}
