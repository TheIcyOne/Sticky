package com.headfishindustries.sticky.defs;

import com.headfishindustries.sticky.blocks.logs.*;
import com.headfishindustries.sticky.blocks.sapling.*;
import com.headfishindustries.sticky.blocks.leaves.*;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDefs {
	
	public static final Block leavesMonster = registerBlock(new LeavesMonster(), "leaves_monster").setUnlocalizedName("leavesmonster");
	public static final Block leavesVillager = registerBlock(new LeavesVillager(), "leaves_villager").setUnlocalizedName("leavesvillager");
	
	public static final Block logMonster = registerBlock(new LogMonster(), "log_monster").setUnlocalizedName("logmonster");
	public static final Block logVillager = registerBlock(new LogVillager(), "log_villager").setUnlocalizedName("logvillager");
	
	public static final Block saplingMonster = registerBlock(new SaplingMonster(), "sapling_monster").setUnlocalizedName("saplingmonster");
	public static final Block saplingVillager = registerBlock(new SaplingVillager(), "sapling_villager").setUnlocalizedName("saplingvillager");
	
	public void preInit(){
		//Do things later. Not now.

	}
	
	private static Block registerBlock(Block block, String name){
		
		if(block.getRegistryName() == null) block.setRegistryName(name);
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(name));
		return block;
	}
	
	private static void registerTexture(Block block) {
		ResourceLocation loc = block.getRegistryName();
		Item item = GameRegistry.findRegistry(Item.class).getValue(loc);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, (new ModelResourceLocation(loc, "inventory")));
	}

	@SideOnly(Side.CLIENT)
	public static void initClient() {
		registerTexture(leavesMonster);
		registerTexture(logMonster);
		registerTexture(saplingMonster);
		registerTexture(leavesVillager);
		registerTexture(logVillager);
		registerTexture(saplingVillager);		
	} 
	
}
