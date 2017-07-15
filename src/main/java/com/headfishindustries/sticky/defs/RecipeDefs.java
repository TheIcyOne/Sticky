package com.headfishindustries.sticky.defs;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RecipeDefs {
	public static void addShapedRecipes(){
		addSaplingRecipes(new ItemStack(BlockDefs.saplingEnder, 1), new ItemStack(Items.ENDER_PEARL), new ItemStack(Items.ENDER_EYE));
		addSaplingRecipes(new ItemStack(BlockDefs.saplingExplosive, 1), Items.GUNPOWDER, Blocks.TNT);
		addSaplingRecipes(new ItemStack(BlockDefs.saplingMonster, 1), Items.BONE, Items.ROTTEN_FLESH);
		addSaplingRecipes(new ItemStack(BlockDefs.saplingNether, 1), Items.NETHERBRICK, Items.BLAZE_POWDER);
		addSaplingRecipes(new ItemStack(BlockDefs.saplingPassive, 1), Items.WHEAT, Items.EGG);
		addSaplingRecipes(new ItemStack(BlockDefs.saplingVillager, 1), Items.EMERALD, Items.BEETROOT);
		addSaplingRecipes(new ItemStack(BlockDefs.saplingRainbow, 1), Items.DYE, Blocks.WOOL);
	}
	
	public static void addSaplingRecipes(ItemStack output, Object a, Object b){
		System.out.println("Recipe added with output " + output.toString() + " and " + a.toString() + " " + b.toString());
		GameRegistry.addRecipe(new ShapedOreRecipe(output, 
				new Object[]{	"ABA",
								"BCB",
								"ABA",
								'A', a,
								'B', b,
								'C', "treeSapling"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(output, 
				new Object[]{	"ABA",
								"BCB",
								"ABA",
								'A', b,
								'B', a,
								'C', "treeSapling"}));

	}
}
