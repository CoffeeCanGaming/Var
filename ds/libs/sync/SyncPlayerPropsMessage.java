package coffee.can.ds.libs.sync;

import coffee.can.ds.libs.AbstractClientMessageHandler;
import coffee.can.ds.util.Props;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class SyncPlayerPropsMessage implements IMessage
{
	  private NBTTagCompound data;
	  
	  public SyncPlayerPropsMessage() {}
	  
	  public SyncPlayerPropsMessage(EntityPlayer player) {
	    this.data = new NBTTagCompound();
	    
	    Props.get(player).saveNBTData(this.data);
	  }


	  
	  public void fromBytes(ByteBuf buffer) { this.data = ByteBufUtils.readTag(buffer); }



	  
	  public void toBytes(ByteBuf buffer) { ByteBufUtils.writeTag(buffer, this.data); }


	  
	  public static class Handler
	    extends AbstractClientMessageHandler<SyncPlayerPropsMessage>
	  {
	    public IMessage handleClientMessage(EntityPlayer player, SyncPlayerPropsMessage message, MessageContext ctx) {
	      Props.get(player).loadNBTData(message.data);
	      return null;
	    }
	  }
	}
