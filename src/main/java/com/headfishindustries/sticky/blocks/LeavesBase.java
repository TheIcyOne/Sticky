package com.headfishindustries.sticky.blocks;

import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

import com.headfishindustries.sticky.blocks.leaves.LeavesMonster;
import com.headfishindustries.sticky.defs.TabDefs;

import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public abstract class LeavesBase extends BlockLeaves implements IGrowable{
	public LeavesBase(){
		super();
		setHardness(0.2F);
		setLightOpacity(1);
		this.setTickRandomly(true);
		leavesFancy = true;
		setCreativeTab(TabDefs.tabStickyTrees);
	}
	
	@SuppressWarnings("unchecked")
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		if (!(worldIn.getBlockState(pos).getBlock() instanceof LeavesMonster)) return;
		Object s = randomValue(this.getValidSpawns());
		Vec3i vec = new Vec3i(rand.nextInt(6) - 3, rand.nextInt(6) - 3, rand.nextInt(6) - 3);
		BlockPos sPos = pos.add(vec);
		if (worldIn.getBlockState(sPos).getBlock() instanceof BlockAir){
			EntityLiving e = null;
			try{
			e = (EntityLiving) EntityList.createEntityByID(EntityList.getID((Class<? extends Entity>) s), worldIn);
			}catch (Throwable t)
			{
			t.printStackTrace();
			return;
			}
			e.setPosition(sPos.getX(), sPos.getY(), sPos.getZ());
			worldIn.spawnEntity(e);
		}
		}

	
	public Object randomValue(HashMap<Object, Integer> hm){
		int totalWeight = 0;
		TreeMap<Integer, Object> map = new TreeMap<Integer, Object>();
		for (Object key : hm.keySet()){
			map.put(totalWeight, key);
			totalWeight += hm.get(key);
		}
		int rnd = new Random().nextInt(map.lastKey() + hm.get(map.get(map.lastKey())));
		return map.get(map.floorKey(rnd));
	}
	public abstract EnumTreeType getTreeType();
	public abstract HashMap<Object, Integer> getValidSpawns();
}
