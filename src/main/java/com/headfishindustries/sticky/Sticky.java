package com.headfishindustries.sticky;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;

@Mod(modid=Sticky.MODID, version = Sticky.VERSION)
public class Sticky {
	public static final String MODID = "sticky";
	public static final String VERSION = "GRADLE:VERSION" + "GRADLE:BUILD";
	
	public static final Logger LOGGER = LogManager.getLogger(MODID);
}
