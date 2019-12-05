package coffee.can.ds.ItemsBlocks.items.medi;

import coffee.can.ds.DSMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class HumanBlood extends Item {
	
	public HumanBlood() {
		this.setUnlocalizedName("HumanBlood");
		this.setMaxStackSize(1);
		this.setCreativeTab(DSMain.DST);
		this.setTextureName("DS_Blood_pack");
	}
	
	
}
