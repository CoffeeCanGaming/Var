package coffee.can.ds.util;

import coffee.can.ds.ItemsBlocks.ExItemsBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DST  extends CreativeTabs
{
	  public DST(int id, String name) { super(id, name); }



	  
	  @SideOnly(Side.CLIENT)
	  public Item getTabIconItem() { return ExItemsBlocks.StoneHatchet; }
	}

	
	
	
