package coffee.can.ds;


import org.apache.logging.log4j.Logger;

import coffee.can.ds.ItemsBlocks.ExItemsBlocks;
import coffee.can.ds.libs.PacketSender;
import coffee.can.ds.proxies.ClientProxy;
import coffee.can.ds.proxies.CommonProxy;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import coffee.can.ds.util.*;
import cpw.mods.fml.common.Mod.Instance;

@Mod(name = DSMain.NAME, modid = DSMain.MODID, version = DSMain.VERSION)
public class DSMain
{
	@SidedProxy(clientSide = "coffee.can.ds.proxies.ClientProxy", serverSide = "coffee.can.ds.proxies.CommonProxy")
	  public static CommonProxy proxy;
	  public static ClientProxy cproxy;
	  public static Logger Log = FMLLog.getLogger();
	  
	  @Instance
	  public static DSMain Instance;
	  public static SimpleNetworkWrapper dispatcher;
	  
	
	public static final String NAME = "DemonSlayerMod";
    public static final String MODID = "DS";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	Log.info("Preinit");
    	ExItemsBlocks.initItems();
    	dispatcher = NetworkRegistry.INSTANCE.newSimpleChannel("DS");
    	PacketSender.registerPackets();
    }
    
    
    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
    	proxy.registerKeyBindings();
		Log.info("Init");
    	MinecraftForge.EVENT_BUS.register(new Events());
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {}
    	public static CreativeTabs DST = new DST(CreativeTabs.getNextID(), "DStab");
    
}