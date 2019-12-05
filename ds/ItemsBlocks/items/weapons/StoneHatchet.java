package coffee.can.ds.ItemsBlocks.items.weapons;

import coffee.can.ds.DSMain;
import coffee.can.ds.ItemsBlocks.items.models.EntityHatchet;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class StoneHatchet extends Item{

	public StoneHatchet() {
		this.setUnlocalizedName("StoneHatchet");
		this.setMaxStackSize(1);
		this.setCreativeTab(DSMain.DST);
		this.setTextureName("ds:StoneHatchet");
		this.setMaxDamage(64);
	}
	
	public ItemStack onItemRightClick(EntityPlayer player,World world, ItemStack item) {
		
		if(!world.isRemote) {
		world.spawnEntityInWorld(new EntityHatchet(world,player));
		item.stackSize--;
		}
		return item;
		
	}
	public boolean isItemTool(ItemStack item) {
		return true;
	}
	
}
