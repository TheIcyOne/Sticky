package com.headfishindustries.sticky.blocks;

import net.minecraft.block.BlockLog;

public abstract class LogBase extends BlockLog{
	public LogBase(){
		
	}
	
	public abstract EnumTreeType getTreeType();
}
