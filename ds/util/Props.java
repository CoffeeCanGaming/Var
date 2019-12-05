package coffee.can.ds.util;

import coffee.can.ds.libs.PacketSender;
import coffee.can.ds.libs.sync.SyncBloodTypeMessage;
import coffee.can.ds.proxies.CommonProxy;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class Props implements IExtendedEntityProperties{

	public static final String EXT_PROP_NAME = "DSPlayer";
	private final EntityPlayer player;
	public int bloodtype;
	
	
	
	public Props(EntityPlayer player) {
		this.player = player;
		this.bloodtype = 0;
	}
	
	public static final void register(EntityPlayer player) { player.registerExtendedProperties("DSPlayer", new Props(player)); }
	
	public static final Props get(EntityPlayer player) { return (Props)player.getExtendedProperties("DSPlayer"); }
	
	
	public void copy(Props props) {
		this.bloodtype = props.bloodtype;
	}
	
	
	
	public void saveNBTData(NBTTagCompound compound) {
	NBTTagCompound Properties = new NBTTagCompound();
	Properties.setInteger("bloodtype",this.bloodtype);
	
	compound.setTag("DSPlayer",Properties);
		
	}

	
	
	
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound Properties = (NBTTagCompound)compound.getTag("DSPlayer");
		this.bloodtype = Properties.getInteger("bloodtype");
	}
	
	
	  private static final String getSaveKey(EntityPlayer player) { return player.getCommandSenderName() + ":DSPlayer"; }

	  
	  public static final void saveProxyData(EntityPlayer player) {
	    Props playerData = get(player);
	    NBTTagCompound savedData = new NBTTagCompound();
	    
	    playerData.saveNBTData(savedData);
	    
	    CommonProxy.storeEntityData(getSaveKey(player), savedData);
	  }
	  public static final void loadProxyData(EntityPlayer player) {
	    Props playerData = get(player);
	    
	    NBTTagCompound savedData = CommonProxy.getEntityData(getSaveKey(player));
	    if (savedData != null) {
	      playerData.loadNBTData(savedData);
	    }
	  }
	
	
	public void init(Entity entity, World world) {}
	
	public int getBloodType() {
		return this.bloodtype;
	}
	
	public void setBloodType(int d) {
		this.bloodtype = d;
	}
	
	public void setBloodType(int d,Side side) {
		this.bloodtype = d;
		if (side.isServer()) {
			 PacketSender.sendTo(new SyncBloodTypeMessage(this.player), (EntityPlayerMP)this.player);
		}
		
	}
	
	public String getBloodTypeName() {
		if(getBloodType()==1) {
			return "Normal";
		}
		if(getBloodType()==2) {
			return "Marechi";
		}
		return "Unknown";
	}
	
}
