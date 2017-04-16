package com.headfishindustries.sticky.defs;

import com.headfishindustries.sticky.blocks.leaves.LeavesMonster;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabDefs {
	public static final CreativeTabs tabStickyTrees = new CreativeTabs("sticky.Trees") {public ItemStack getTabIconItem(){return new ItemStack(new LeavesMonster());}};
}
