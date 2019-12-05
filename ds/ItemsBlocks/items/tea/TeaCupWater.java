package coffee.can.ds.ItemsBlocks.items.tea;

import coffee.can.ds.DSMain;
import coffee.can.ds.ItemsBlocks.ExItemsBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TeaCupWater extends Item{

	public TeaCupWater() {
	    setCreativeTab(DSMain.DST);
	    setUnlocalizedName("TeacupWater");
	    setMaxStackSize(1);
	    setTextureName("DS:TeacupWater");
	  }
	public int getMaxItemUseDuration(ItemStack Item) {return 32;}
		
	public EnumAction getItemUseAction(ItemStack Item) {return EnumAction.drink;}
	
	public ItemStack onItemRightClick(ItemStack Item, World world, EntityPlayer Player) {
	    Player.setItemInUse(Item, getMaxItemUseDuration(Item));
	    if (!Player.capabilities.isCreativeMode)
	    {
	      Item.stackSize--;
	    }
	    return (Item.stackSize <= 0) ? new ItemStack(ExItemsBlocks.TeaCup) : Item;
	  }


	  
}
