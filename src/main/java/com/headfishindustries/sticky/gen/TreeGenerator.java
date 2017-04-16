package com.headfishindustries.sticky.gen;

import java.util.Random;

import com.headfishindustries.sticky.blocks.EnumTreeType;
import com.headfishindustries.sticky.blocks.LogBase;
import com.headfishindustries.sticky.blocks.SaplingBase;
import com.headfishindustries.sticky.blocks.logs.LogMonster;

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
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		if (worldIn.isRemote || !(worldIn.getBlockState(pos).getBlock() instanceof SaplingBase)) return false;
		int height = rand.nextInt(3) + 5;
		EnumTreeType type = ((SaplingBase)(worldIn.getBlockState(pos).getBlock())).getTreeType();
		IBlockState logstate;
		switch (type){
		case MONSTER:
			logstate = new LogMonster().getDefaultState().withProperty(LogBase.LOG_AXIS, BlockLog.EnumAxis.Y);
			break;
		default:
			return false;	
		}
		generatePillar(worldIn, pos, height, logstate);
		return true;
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
