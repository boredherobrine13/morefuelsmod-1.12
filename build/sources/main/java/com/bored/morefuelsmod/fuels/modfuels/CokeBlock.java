package com.bored.morefuelsmod.fuels.modfuels;

import com.bored.morefuelsmod.block.ModBlocks;
import com.bored.morefuelsmod.item.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class CokeBlock implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel){
		if(fuel.getItem() == Item.getItemFromBlock(ModBlocks.blockCoke)){
			return 28800;
		}
		return 0;
	}
}