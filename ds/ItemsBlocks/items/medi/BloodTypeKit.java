package coffee.can.ds.ItemsBlocks.items.medi;

import coffee.can.ds.DSMain;
import coffee.can.ds.ItemsBlocks.ExItemsBlocks;
import coffee.can.ds.libs.PacketSender;
import coffee.can.ds.libs.sync.SyncBloodTypeMessage;
import coffee.can.ds.util.Props;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BloodTypeKit extends Item {

	public BloodTypeKit() {
		setCreativeTab(DSMain.DST);
		setUnlocalizedName("BloodTypeKit");
		setMaxStackSize(1);
		setTextureName("DS:BloodTypeKit");
	}

	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		
			Props props = Props.get(player);
			int rand = world.rand.nextInt(50) + 1;
			
			if (props.bloodtype == 0) {
				if (!world.isRemote) {
				if (rand >= 1 || rand <= 49) {
					props.setBloodType(1);
					PacketSender.sendTo(new SyncBloodTypeMessage(player), (EntityPlayerMP) player);
					player.addChatComponentMessage(new ChatComponentText("You have a normal BloodType."));

				}
				if (rand == 50) {
					props.setBloodType(2);
					PacketSender.sendTo(new SyncBloodTypeMessage(player), (EntityPlayerMP) player);
					player.addChatComponentMessage(new ChatComponentText("You have the Marechi BloodType!"));
					player.addChatComponentMessage(new ChatComponentText("Be careful, you are extra delicious."));
				}
			}
			else {
				player.addChatComponentMessage(new ChatComponentText("You already know your BloodType."));
			}
				player.inventoryContainer.detectAndSendChanges();
				
		}
		if (!player.capabilities.isCreativeMode) {
					item.stackSize--;
				}
		return item;

	}
}
