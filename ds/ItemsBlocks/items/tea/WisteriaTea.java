package coffee.can.ds.ItemsBlocks.items.tea;

import coffee.can.ds.DSMain;
import coffee.can.ds.ItemsBlocks.ExItemsBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class WisteriaTea extends Item{
	
	
	public WisteriaTea() {
		this.setUnlocalizedName("WisteriaTea");
		this.setMaxStackSize(1);
		this.setCreativeTab(DSMain.DST);
		this.setTextureName("DS:WisteriaTea");
	}
	
	
	
	public int getMaxItemUseDuration(ItemStack Item) {return 32;}
	
	public EnumAction getItemUseAction(ItemStack Item) {return EnumAction.drink;}
	
	public ItemStack onItemRightClick(ItemStack item,World world,EntityPlayer player) {
		if(!player.capabilities.isCreativeMode) {
			item.stackSize--;
		}
		if(!world.isRemote) {
			player.addPotionEffect(new PotionEffect(Potion.resistance.getId(),600,2));
		}
		
		return (item.stackSize <= 0) ? new ItemStack(ExItemsBlocks.TeaCup): item;
		
	}
}
