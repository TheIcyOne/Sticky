package com.headfishindustries.sticky.blocks.leaves;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import com.headfishindustries.sticky.blocks.EnumTreeType;
import com.headfishindustries.sticky.blocks.LeavesBase;

import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEvoker;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class LeavesMonster extends LeavesBase{
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand){
		if (!(worldIn.getBlockState(pos).getBlock() instanceof LeavesMonster)) return;
		if (rand.nextInt(100) == 42)
		grow(worldIn, rand, pos, state);
	}
	
	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		if (!(worldIn.getBlockState(pos).getBlock() instanceof LeavesMonster)) return false;
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return true;
	}

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		return null;
	}

	@Override
	public EnumTreeType getTreeType() {
		return EnumTreeType.MONSTER;
	}

	@Override
	public HashMap<Object, Integer> getValidSpawns() {
		HashMap<Object, Integer> spawns = new HashMap<Object, Integer>();
		spawns.put(EntityZombie.class, 100);
		spawns.put(EntitySkeleton.class, 100);
		spawns.put(EntitySlime.class, 20);
		spawns.put(EntityWitch.class, 30);
		spawns.put(EntityStray.class, 10);
		spawns.put(EntityHusk.class, 10);
		spawns.put(EntityVex.class, 7);
		spawns.put(EntityVindicator.class, 5);		
		spawns.put(EntityEvoker.class, 1);
		spawns.put(EntityCreeper.class, 15);
		spawns.put(EntityEnderman.class, 10);
		return spawns;
	}

	@Override
	public EnumType getWoodType(int meta) {
		return null;
	}

}
