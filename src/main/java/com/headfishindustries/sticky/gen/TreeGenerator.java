package com.headfishindustries.sticky.gen;

import java.util.Random;

import com.headfishindustries.sticky.blocks.EnumTreeType;
import com.headfishindustries.sticky.blocks.SaplingBase;
import com.headfishindustries.sticky.defs.BlockDefs;

import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3i;
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
		int height = rand.nextInt(3) + 5;
		EnumTreeType type = ((SaplingBase)(worldIn.getBlockState(pos).getBlock())).getTreeType();
		IBlockState logstate;
		IBlockState leafstate;
		switch (type){
		case MONSTER:
			logstate = BlockDefs.logMonster.getDefaultState()/*.withProperty(LogBase.LOG_AXIS, LogBase.EnumAxis.Y)*/;
			leafstate = BlockDefs.leavesMonster.getDefaultState();
			break;
		case VILLAGER:
			logstate = BlockDefs.logVillager.getDefaultState();
			leafstate = BlockDefs.leavesVillager.getDefaultState();
			break;
		case ENDER:
			logstate = BlockDefs.logEnder.getDefaultState();
			leafstate = BlockDefs.leavesEnder.getDefaultState();
			break;
		case EXPLOSIVE:
			logstate = BlockDefs.logExplosive.getDefaultState();
			leafstate = BlockDefs.leavesExplosive.getDefaultState();
			break;
		case NETHER:
			logstate = BlockDefs.logNether.getDefaultState();
			leafstate = BlockDefs.leavesNether.getDefaultState();
			break;
		case PASSIVE:
			logstate = BlockDefs.logPassive.getDefaultState();
			leafstate = BlockDefs.leavesPassive.getDefaultState();
			break;
		case RAINBOW:
			logstate = BlockDefs.logRainbow.getDefaultState();
			leafstate = BlockDefs.leavesRainbow.getDefaultState();
			break;
		default:
			return false;	
		}
		worldIn.setBlockToAir(pos);
		generatePillar(worldIn, pos, height, logstate);
		generateLeaves(worldIn, pos, height, leafstate);
		return true;
	}
	
	public boolean generatePillar(World worldIn, BlockPos start, int height, IBlockState state){
		for (int i = 0; i < height; i++){
			IBlockState b = worldIn.getBlockState(start.up(i));
			if (!(b.getBlock() instanceof BlockAir || b.getBlock() instanceof BlockLog || b.getBlock() instanceof BlockLeaves || b.getBlock() instanceof BlockSapling)) return false;
			worldIn.setBlockState(start.up(i), state);	
		}
		return true;
	}
	
	public boolean generateLeaves(World worldIn, BlockPos pos, int height, IBlockState state){
		int[] radii = {0, 1, 3, 1};
		int radius = 0;	
		int x;
		int z;
		for (int i = 0; i <= height + 2; i++){
			if (i == height - 3) radius = radii[1];
			else if (height +1 >= i && i >= height - 3) radius = radii[2];
			else if (height + 2 == i) radius = radii[3];
			else radius = radii[0];
			for (x = -radius; x<= radius; x++){
				for (z = -radius; z<= radius; z++){
					BlockPos p = pos.add(new Vec3i(x, i, z));
					if (MathHelper.sqrt(x*x + z*z) <= radius && worldIn.getBlockState(p).getBlock() instanceof BlockAir){
						worldIn.setBlockState(p, state);
					}
				}
			}
			
		}
			
		return true;
	}

}
