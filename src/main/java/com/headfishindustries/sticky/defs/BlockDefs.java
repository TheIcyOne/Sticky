package com.headfishindustries.sticky.defs;

import com.headfishindustries.sticky.blocks.*;
import com.headfishindustries.sticky.blocks.logs.*;
import com.headfishindustries.sticky.blocks.leaves.*;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockDefs {
	
	public static final Block leavesMonster = registerBlock(new LeavesMonster(), "leaves_monster");
	
	public void preInit(){
		//Do things later. Not now.
		System.out.println(leavesMonster.toString());
	}
	
	private static Block registerBlock(Block block, String name){
		
		if(block.getRegistryName() == null) block.setRegistryName(name);
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(name));
		return block;
	}
	
}
