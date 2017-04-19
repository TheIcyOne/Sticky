package com.headfishindustries.sticky.blocks.leaves;

import java.util.HashMap;
import java.util.Random;
import com.headfishindustries.sticky.blocks.EnumTreeType;
import com.headfishindustries.sticky.blocks.LeavesBase;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LeavesExplosive extends LeavesBase{
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand){
		if (!(worldIn.getBlockState(pos).getBlock() instanceof LeavesBase)) return;
		if (rand.nextInt(300) == 42)
		grow(worldIn, rand, pos, state);
	}
	
	@Override
	public EnumTreeType getTreeType() {
		return EnumTreeType.EXPLOSIVE;
	}

	@Override
	public HashMap<Object, Integer> getValidSpawns() {
		HashMap<Object, Integer> spawns = new HashMap<Object, Integer>();
		spawns.put(EntityCreeper.class, 100);
		spawns.put(EntityGhast.class, 25);
		spawns.put(EntityTNTPrimed.class, 2);
		return spawns;
	}

}
