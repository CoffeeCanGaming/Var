package coffee.can.ds.ItemsBlocks.items.weapons;

import coffee.can.ds.DSMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class DiamondHatchet extends Item{

	public DiamondHatchet() {
		this.setUnlocalizedName("DiamondHatchet");
		this.setMaxStackSize(1);
		this.setCreativeTab(DSMain.DST);
		this.setTextureName("ds:DiamondHatchet");
		this.setMaxDamage(64);
	}
}