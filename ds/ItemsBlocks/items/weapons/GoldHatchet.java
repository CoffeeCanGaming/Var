package coffee.can.ds.ItemsBlocks.items.weapons;

import coffee.can.ds.DSMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GoldHatchet extends Item{

	public GoldHatchet() {
		this.setUnlocalizedName("GoldHatchet");
		this.setMaxStackSize(1);
		this.setCreativeTab(DSMain.DST);
		this.setTextureName("ds:GoldHatchet");
		this.setMaxDamage(64);
	}
}
