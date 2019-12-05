package coffee.can.ds.ItemsBlocks.items.tea;



import coffee.can.ds.DSMain;
import coffee.can.ds.ItemsBlocks.ExItemsBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class TeaCup extends Item
{
	  public TeaCup() {
	    setUnlocalizedName("Teacup");
	    setCreativeTab(DSMain.DST);
	    setMaxStackSize(1);
	    setTextureName("DS:Teacup");
	  }
	  
	  public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
	    MovingObjectPosition movingobjectposition = getMovingObjectPositionFromPlayer(world, player, true);
	    
	    if (movingobjectposition == null)
	    {
	      return item;
	    }

	    
	    if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
	      
	      int i = movingobjectposition.blockX;
	      int j = movingobjectposition.blockY;
	      int k = movingobjectposition.blockZ;
	      
	      if (!world.canMineBlock(player, i, j, k))
	      {
	        return item;
	      }
	      
	      if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, item))
	      {
	        return item;
	      }
	      
	      if (world.getBlock(i, j, k).getMaterial() == Material.water) {
	        
	        item.stackSize--;
	        
	        if (item.stackSize <= 0)
	        {
	          return new ItemStack(ExItemsBlocks.TeaCupWater);
	        }
	        
	        if (!player.inventory.addItemStackToInventory(new ItemStack(ExItemsBlocks.TeaCup)))
	        {
	          player.dropPlayerItemWithRandomChoice(new ItemStack(ExItemsBlocks.TeaCup), false);
	        }
	      } 
	    } 
	    
	    return item;
	  }
}