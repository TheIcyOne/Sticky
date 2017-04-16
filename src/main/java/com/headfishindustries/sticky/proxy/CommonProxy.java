package com.headfishindustries.sticky.proxy;

import com.headfishindustries.sticky.defs.BlockDefs;
import com.headfishindustries.sticky.defs.TabDefs;

public class CommonProxy {
	
	BlockDefs blocks;
	
	public void preInit(){
		new TabDefs();
		blocks = new BlockDefs();
		blocks.preInit();
	}
	
	public void init(){
		
	}
	
	public void postInit(){
		
	}
}
