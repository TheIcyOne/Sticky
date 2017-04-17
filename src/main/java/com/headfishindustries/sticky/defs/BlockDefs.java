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
	public static final Block logMonster = registerBlock(new LogMonster(), "log_monster").setUnlocalizedName("logmonster");
	public static final Block saplingMonster = registerBlock(new SaplingMonster(), "sapling_monster").setUnlocalizedName("saplingmonster");
	
	public static final Block leavesVillager = registerBlock(new LeavesVillager(), "leaves_villager").setUnlocalizedName("leavesvillager");
	public static final Block logVillager = registerBlock(new LogVillager(), "log_villager").setUnlocalizedName("logvillager");
	public static final Block saplingVillager = registerBlock(new SaplingVillager(), "sapling_villager").setUnlocalizedName("saplingvillager");
	
	public static final Block leavesEnder = registerBlock(new LeavesEnder(), "leaves_ender").setUnlocalizedName("leavesender");
	public static final Block logEnder = registerBlock(new LogEnder(), "log_ender").setUnlocalizedName("logender");
	public static final Block saplingEnder = registerBlock(new SaplingEnder(), "sapling_ender").setUnlocalizedName("saplingender");
	
	public static final Block leavesExplosive = registerBlock(new LeavesExplosive(), "leaves_explosive").setUnlocalizedName("leavesexplosive");
	public static final Block logExplosive = registerBlock(new LogExplosive(), "log_explosive").setUnlocalizedName("logexplosive");
	public static final Block saplingExplosive = registerBlock(new SaplingExplosive(), "sapling_explosive").setUnlocalizedName("saplingexplosive");
	
	public static final Block leavesNether = registerBlock(new LeavesNether(), "leaves_nether").setUnlocalizedName("leavesnether");
	public static final Block logNether = registerBlock(new LogNether(), "log_nether").setUnlocalizedName("lognether");
	public static final Block saplingNether = registerBlock(new SaplingNether(), "sapling_nether").setUnlocalizedName("saplingnether");
	
	public static final Block leavesPassive = registerBlock(new LeavesPassive(), "leaves_passive").setUnlocalizedName("leavespassive");
	public static final Block logPassive = registerBlock(new LogPassive(), "log_passive").setUnlocalizedName("logpassive");
	public static final Block saplingPassive = registerBlock(new SaplingPassive(), "sapling_passive").setUnlocalizedName("saplingpassive");
	
	public static final Block leavesRainbow = registerBlock(new LeavesRainbow(), "leaves_rainbow").setUnlocalizedName("leavesrainbow");
	public static final Block logRainbow = registerBlock(new LogRainbow(), "log_rainbow").setUnlocalizedName("lograinbow");
	public static final Block saplingRainbow = registerBlock(new SaplingRainbow(), "sapling_rainbow").setUnlocalizedName("saplingrainbow");
	
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
		
		registerTexture(leavesEnder);
		registerTexture(logEnder);
		registerTexture(saplingEnder);
		
		registerTexture(leavesExplosive);
		registerTexture(logExplosive);
		registerTexture(saplingExplosive);
		
		registerTexture(leavesNether);
		registerTexture(logNether);
		registerTexture(saplingNether);
		
		registerTexture(leavesPassive);
		registerTexture(logPassive);
		registerTexture(saplingPassive);
		
		registerTexture(leavesRainbow);
		registerTexture(logRainbow);
		registerTexture(saplingRainbow);
	} 
	
}
