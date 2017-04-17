package com.headfishindustries.sticky.blocks;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

import com.headfishindustries.sticky.blocks.leaves.LeavesMonster;
import com.headfishindustries.sticky.defs.TabDefs;

import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.IGrowable;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.IBlockAccess;
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
	
	public abstract EnumTreeType getTreeType();
	public abstract HashMap<Object, Integer> getValidSpawns();
	public abstract void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand);
	
	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		if (!(worldIn.getBlockState(pos).getBlock() instanceof LeavesMonster)) return false;
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		if (!(worldIn.getBlockState(pos).getBlock() instanceof LeavesBase)) return;
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
	@Override
    public java.util.List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> l = new java.util.ArrayList<ItemStack>();
		return l;
		}
	
	@Override
	 public void beginLeavesDecay(IBlockState state, World world, BlockPos pos){}

	
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
	
	
	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		return null;
	}
	

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return true;
	}
	

	@Override
	public EnumType getWoodType(int meta) {
		return EnumType.OAK;
	}

}
