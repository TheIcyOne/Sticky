package com.headfishindustries.sticky;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.headfishindustries.sticky.proxy.CommonProxy;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Sticky.MODID, version = Sticky.VERSION, name="Sticky")
public class Sticky {
	public static final String MODID = "sticky";
	public static final String VERSION = "%gradle.version%";
	
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	@SidedProxy(clientSide="com.headfishindustries.sticky.proxy.ClientProxy", serverSide="com.headfishindustries.sticky.proxy.CommonProxy", modId=MODID)
	public static CommonProxy proxy;
	
	@EventHandler
	public void construct(FMLConstructionEvent e){
		//I'm not doing buckets myself.
		FluidRegistry.enableUniversalBucket();
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		proxy.preInit();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e){
		proxy.init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e){
		proxy.postInit();
	}

}
