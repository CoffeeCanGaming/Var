package coffee.can.ds.util.keys;

import coffee.can.ds.libs.PacketSender;
import coffee.can.ds.proxies.ClientProxy;
import coffee.can.ds.util.Props;
import coffee.can.ds.util.gui.TestGui;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class KeyHandler {
public final Minecraft mc;

public KeyHandler() {
	this.mc = Minecraft.getMinecraft();
}

@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
public void onEvent(InputEvent.KeyInputEvent event) {
	
	KeyBinding[] keyBindings = ClientProxy.keyBindings;
	EntityPlayer player = mc.thePlayer;
	Props props = Props.get(player);

	if (keyBindings[0].isPressed()) {
		Minecraft.getMinecraft().displayGuiScreen(new TestGui());
	}
	

	
	
}
}
