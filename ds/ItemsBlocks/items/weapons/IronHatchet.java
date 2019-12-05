package coffee.can.ds.ItemsBlocks.items.weapons;

import coffee.can.ds.DSMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class IronHatchet extends Item{

	public IronHatchet() {
		this.setUnlocalizedName("IronHatchet");
		this.setMaxStackSize(1);
		this.setCreativeTab(DSMain.DST);
		this.setTextureName("ds:IronHatchet");
		this.setMaxDamage(64);
	}
}
