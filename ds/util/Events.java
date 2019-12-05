package coffee.can.ds.util;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent;

public class Events {

	@SubscribeEvent
	public void onEntityConstructing(EntityEvent.EntityConstructing event) {
		 if (event.entity instanceof EntityPlayer && Props.get((EntityPlayer)event.entity) == null)
		    {
		      Props.register((EntityPlayer)event.entity);
		    }
	}
}
