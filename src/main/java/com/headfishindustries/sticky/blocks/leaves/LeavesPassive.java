package com.headfishindustries.sticky.blocks.leaves;

import java.util.HashMap;
import java.util.Random;
import com.headfishindustries.sticky.blocks.EnumTreeType;
import com.headfishindustries.sticky.blocks.LeavesBase;

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
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LeavesPassive extends LeavesBase{
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand){
		if (!(worldIn.getBlockState(pos).getBlock() instanceof LeavesBase)) return;
		if (rand.nextInt(100) == 42)
		grow(worldIn, rand, pos, state);
	}
	
	@Override
	public EnumTreeType getTreeType() {
		return EnumTreeType.PASSIVE;
	}

	@Override
	public HashMap<Object, Integer> getValidSpawns() {
		HashMap<Object, Integer> spawns = new HashMap<Object, Integer>();
		spawns.put(EntityCow.class, 50);
		spawns.put(EntitySheep.class, 50);
		spawns.put(EntityPig.class, 50);
		spawns.put(EntityChicken.class, 25);
		spawns.put(EntitySquid.class, 5);
		spawns.put(EntityRabbit.class, 15);
		spawns.put(EntityVillager.class, 1);
		spawns.put(EntityHorse.class, 5);
		spawns.put(EntityBat.class, 5);
		spawns.put(EntityOcelot.class, 10);
		spawns.put(EntityWolf.class, 10);
		return spawns;
	}

}
