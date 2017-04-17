package com.headfishindustries.sticky.blocks.leaves;

import java.util.HashMap;
import java.util.Random;
import com.headfishindustries.sticky.blocks.EnumTreeType;
import com.headfishindustries.sticky.blocks.LeavesBase;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LeavesVillager extends LeavesBase{	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand){
		if (!(worldIn.getBlockState(pos).getBlock() instanceof LeavesBase)) return;
		if (rand.nextInt(500) == 42)
		grow(worldIn, rand, pos, state);
	}
	
	@Override
	public EnumTreeType getTreeType() {
		return EnumTreeType.VILLAGER;
	}

	@Override
	public HashMap<Object, Integer> getValidSpawns() {
		HashMap<Object, Integer> spawns = new HashMap<Object, Integer>();
		spawns.put(EntityVillager.class, 100);
		spawns.put(EntityIronGolem.class, 1);
		return spawns;
	}

}
