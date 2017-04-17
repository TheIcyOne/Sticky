package com.headfishindustries.sticky.blocks.leaves;

import java.util.HashMap;
import java.util.Random;
import com.headfishindustries.sticky.blocks.EnumTreeType;
import com.headfishindustries.sticky.blocks.LeavesBase;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEvoker;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LeavesNether extends LeavesBase{
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand){
		if (!(worldIn.getBlockState(pos).getBlock() instanceof LeavesBase)) return;
		if (rand.nextInt(150) == 42)
		grow(worldIn, rand, pos, state);
	}
	
	@Override
	public EnumTreeType getTreeType() {
		return EnumTreeType.NETHER;
	}

	@Override
	public HashMap<Object, Integer> getValidSpawns() {
		HashMap<Object, Integer> spawns = new HashMap<Object, Integer>();
		spawns.put(EntityPigZombie.class, 100);
		spawns.put(EntityWitherSkeleton.class, 10);
		spawns.put(EntityGhast.class, 5);
		spawns.put(EntityBlaze.class, 25);
		spawns.put(EntityEnderman.class, 1);
		return spawns;
	}

}
