package coffee.can.ds.ItemsBlocks.items.weapons;

import coffee.can.ds.DSMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class WoodHatchet extends Item{

	public WoodHatchet() {
		this.setUnlocalizedName("WoodHatchet");
		this.setMaxStackSize(1);
		this.setCreativeTab(DSMain.DST);
		this.setTextureName("ds:WoodHatchet");
		this.setMaxDamage(64);
	}
}