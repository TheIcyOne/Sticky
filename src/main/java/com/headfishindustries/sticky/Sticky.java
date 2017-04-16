package com.headfishindustries.sticky;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.headfishindustries.sticky.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Sticky.MODID, version = Sticky.VERSION, name=Sticky.MODID)
public class Sticky {
	public static final String MODID = "sticky";
	public static final String VERSION = "GRADLE:VERSION" + "GRADLE:BUILD";
	
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	@SidedProxy(clientSide="com.headfishindustries.sticky.proxy.ClientProxy", serverSide="com.headfishindustries.sticky.proxy.CommonProxy", modId=MODID)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		proxy.preInit();
	}
}
