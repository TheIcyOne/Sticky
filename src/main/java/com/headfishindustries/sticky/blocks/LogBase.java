package com.headfishindustries.sticky.blocks;

import java.util.Random;

import com.headfishindustries.sticky.defs.TabDefs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public abstract class LogBase extends Block{
	
	//public static final PropertyEnum<BlockLog.EnumAxis> LOG_AXIS = PropertyEnum.<BlockLog.EnumAxis>create("axis", BlockLog.EnumAxis.class);
	
	public LogBase(){
		super(Material.WOOD);
		setHardness(3.0f);
		setResistance(3.0f);
		setHarvestLevel("axe", 2);
		setCreativeTab(TabDefs.tabStickyTrees);
		setDefaultState(blockState.getBaseState()/*.withProperty(LOG_AXIS, EnumAxis.Y)*/);
	}
	
	public int quantityDropped(Random r){
		return 1;
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return 0;
	}

	@Override
	public void getSubBlocks(Item par1, CreativeTabs t, NonNullList<ItemStack> par3List){
		par3List.add(new ItemStack(this));
	}
	
	/*@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, LOG_AXIS);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(LOG_AXIS).ordinal();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(LOG_AXIS, EnumAxis.values()[MathHelper.clamp(meta, 0, 3)]);
	}*/
	
	public abstract EnumTreeType getTreeType();
}
