package com.headfishindustries.sticky.blocks.leaves;

import java.util.HashMap;
import java.util.Random;
import com.headfishindustries.sticky.blocks.EnumTreeType;
import com.headfishindustries.sticky.blocks.LeavesBase;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityElderGuardian;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LeavesRainbow extends LeavesBase{
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand){
		if (!(worldIn.getBlockState(pos).getBlock() instanceof LeavesBase)) return;
		if (rand.nextInt(250) == 42)
		grow(worldIn, rand, pos, state);
	}
	
	@Override
	public EnumTreeType getTreeType() {
		return EnumTreeType.RAINBOW;
	}

	@Override
	public HashMap<Object, Integer> getValidSpawns() {
		HashMap<Object, Integer> spawns = new HashMap<Object, Integer>();
		spawns.put(EntitySheep.class, 500);
		spawns.put(EntityGuardian.class, 25);
		spawns.put(EntityElderGuardian.class, 1);
		return spawns;
	}

}
