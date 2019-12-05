package coffee.can.ds.proxies;

import coffee.can.ds.util.keys.KeyHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;

public class ClientProxy extends CommonProxy {
	public static KeyBinding[] keyBindings;
	
	  public void registerRenders() {}
	  
	  public void registerEntities() {}
	  
 public void registerKeyBindings() {
		  
		  FMLCommonHandler.instance().bus().register(new KeyHandler());
		  
		  
		  keyBindings = new KeyBinding[4];
		  
		  keyBindings[0] = new KeyBinding("key.hud.desc",40,"key.categories.NHM");
		  keyBindings[1] = new KeyBinding("key.transform.desc",39,"key.categories.NHM");
		  keyBindings[2] = new KeyBinding("key.transform.desc",38,"key.categories.NHM");
		  keyBindings[3] = new KeyBinding("key.transform.desc",37,"key.categories.NHM");
		  
		  for(int i=0; i < keyBindings.length;i++) {
			  ClientRegistry.registerKeyBinding(keyBindings[i]);
		  }
		  
	  }
	  
	  public void loadGUI() {}
	  
	  public EntityPlayer getPlayerEntity(MessageContext ctx) { return ctx.side.isClient() ? (Minecraft.getMinecraft()).thePlayer : super.getPlayerEntity(ctx); }
	}
