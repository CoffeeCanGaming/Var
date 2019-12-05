package coffee.can.ds.libs.sync;

import java.io.IOException;

import coffee.can.ds.libs.AbstractMessage;
import coffee.can.ds.util.Props;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;

public class SyncBloodTypeMessage extends AbstractMessage<SyncBloodTypeMessage>
{
	  private int data;
	  
	  public SyncBloodTypeMessage() {}
	  
	  public SyncBloodTypeMessage(EntityPlayer player) {
	    this.data = Props.get(player).getBloodType();
	  }


	  
	  protected void read(PacketBuffer buffer) throws IOException {
	    this.data = buffer.readInt();
	  }


	  
	  protected void write(PacketBuffer buffer) throws IOException {
	    buffer.writeInt(this.data);
	  }

	  
	  public void process(EntityPlayer player, Side side) {
	    Props.get(player).setBloodType(this.data, side);
	  }
	}