package coffee.can.ds.ItemsBlocks;

import net.minecraft.item.Item;
import coffee.can.ds.ItemsBlocks.items.*;
import coffee.can.ds.ItemsBlocks.items.medi.*;
import coffee.can.ds.ItemsBlocks.items.tea.*;
import coffee.can.ds.ItemsBlocks.items.weapons.DiamondHatchet;
import coffee.can.ds.ItemsBlocks.items.weapons.GoldHatchet;
import coffee.can.ds.ItemsBlocks.items.weapons.IronHatchet;
import coffee.can.ds.ItemsBlocks.items.weapons.StoneHatchet;
import coffee.can.ds.ItemsBlocks.items.weapons.WoodHatchet;
import cpw.mods.fml.common.registry.GameRegistry;

public class ExItemsBlocks {

	public static Item WoodHatchet;
	public static Item StoneHatchet;
	public static Item IronHatchet;
	public static Item GoldHatchet;
	public static Item DiamondHatchet;
	
	public static Item DemonBloodSyringe;
	public static Item BloodTypeKit;
	
	public static Item TeaCup;
	public static Item TeaCupWater;
	public static Item WisteriaTea;
	
	
	
	public static void initItems() {
		
		WoodHatchet = new WoodHatchet();
		GameRegistry.registerItem(WoodHatchet, "WoodHatchet");
		StoneHatchet = new StoneHatchet();
		GameRegistry.registerItem(StoneHatchet, "StoneHatchet");
		IronHatchet = new IronHatchet();
		GameRegistry.registerItem(IronHatchet, "IronHatchet");
		GoldHatchet = new GoldHatchet();
		GameRegistry.registerItem(GoldHatchet, "GoldHatchet");
		DiamondHatchet = new DiamondHatchet();
		GameRegistry.registerItem(DiamondHatchet, "DiamondHatchet");
		
		DemonBloodSyringe = new DemonBloodSyringe();
		GameRegistry.registerItem(DemonBloodSyringe, "DemonBloodSyringe");
		BloodTypeKit = new BloodTypeKit();
		GameRegistry.registerItem(BloodTypeKit, "BloodTypeKit");
		
		
		TeaCup = new TeaCup();
		GameRegistry.registerItem(TeaCup, "TeaCup");
		TeaCupWater = new TeaCupWater();
		GameRegistry.registerItem(TeaCupWater, "TeaCupWater");
		WisteriaTea = new WisteriaTea();
		GameRegistry.registerItem(WisteriaTea, "WisteriaTea");
		
	}
	public static void initBlocks() {
		
	}
}
