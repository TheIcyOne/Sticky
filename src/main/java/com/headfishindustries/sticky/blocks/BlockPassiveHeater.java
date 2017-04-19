package com.headfishindustries.sticky.blocks;

import com.headfishindustries.sticky.blocks.fluid.StickyFluids;

import net.minecraft.block.BlockCauldron;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.UniversalBucket;

public class BlockPassiveHeater extends BlockCauldron{

	
	@Override
	 public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		 ItemStack itemstack = playerIn.getHeldItem(hand);

	     	if (itemstack.getItem() == Items.BUCKET && state.getValue(LEVEL) == 3){
	     		float temp = checkBiome(worldIn, pos);
	     		if (temp <= 0.2) playerIn.setHeldItem(hand, UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, StickyFluids.coldWater));
	     		else if (temp >= 1) playerIn.setHeldItem(hand, UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, StickyFluids.hotWater));
	     		else if (temp >= 0.6) playerIn.setHeldItem(hand, UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, StickyFluids.lukewarmWater));
	     		else playerIn.setHeldItem(hand, UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, FluidRegistry.WATER));
	     		this.setWaterLevel(worldIn, pos, state, 0);
	        	return true;
	        }
	        else return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }
	
	public float checkBiome(World worldIn, BlockPos pos){
		return worldIn.getBiome(pos).getFloatTemperature(pos);
	}
    

}
