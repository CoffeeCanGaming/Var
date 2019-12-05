package coffee.can.ds.proxies;

import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class CommonProxy {
	  private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap();


	  
	  public static void storeEntityData(String name, NBTTagCompound compound) { extendedEntityData.put(name, compound); }


	  
	  public void registerRenders() {}

	  
	  public void registerEntities() {}

	  
	  public void loadGUI() {}
	  
	  public void registerKeyBindings() {}

	  
	  public static NBTTagCompound getEntityData(String saveKey) { return (NBTTagCompound)extendedEntityData.remove(saveKey); }


	  
	  public EntityPlayer getPlayerEntity(MessageContext ctx) { return (ctx.getServerHandler()).playerEntity; }
	}
