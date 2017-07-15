package com.headfishindustries.sticky.proxy;

import com.headfishindustries.sticky.blocks.fluid.StickyFluids;
import com.headfishindustries.sticky.defs.BlockDefs;
import com.headfishindustries.sticky.defs.RecipeDefs;
import com.headfishindustries.sticky.defs.TabDefs;

public class CommonProxy {
	
	BlockDefs blocks;
	
	public void preInit(){
		StickyFluids.setupFluids();
		new TabDefs();
		blocks = new BlockDefs();
		blocks.preInit();
		
	}
	
	public void init(){
		RecipeDefs.addShapedRecipes();
	}
	
	public void postInit(){
		
	}
}
