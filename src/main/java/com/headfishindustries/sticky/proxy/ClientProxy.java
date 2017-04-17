package com.headfishindustries.sticky.proxy;

import com.headfishindustries.sticky.defs.BlockDefs;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void preInit(){
		super.preInit();
	}
	
	@Override
	public void init(){
		super.init();
		BlockDefs.initClient();
	}
	
	@Override
	public void postInit(){
		super.postInit();
	}

}
