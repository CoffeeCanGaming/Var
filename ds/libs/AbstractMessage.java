package coffee.can.ds.libs;

import java.io.IOException;

import com.google.common.base.Throwables;

import coffee.can.ds.DSMain;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;

public abstract class AbstractMessage<T extends AbstractMessage<T>> extends Object
		implements IMessage, IMessageHandler<T, IMessage> {
	protected boolean isValidOnSide(Side side) {
		return true;
	}

	protected boolean requiresMainThread() {
		return true;
	}

	public void fromBytes(ByteBuf buffer) {
		try {
			read(new PacketBuffer(buffer));
		} catch (IOException e) {
			throw Throwables.propagate(e);
		}
	}

	public void toBytes(ByteBuf buffer) {
		try {
			write(new PacketBuffer(buffer));
		} catch (IOException e) {
			throw Throwables.propagate(e);
		}
	}

	protected abstract void read(PacketBuffer paramPacketBuffer) throws IOException;

	public final IMessage onMessage(T msg, MessageContext ctx) {
		if (!msg.isValidOnSide(ctx.side)) {
			throw new RuntimeException("Invalid side " + ctx.side.name() + " for " + msg.getClass().getSimpleName());
		}
		msg.process(DSMain.proxy.getPlayerEntity(ctx), ctx.side);
		return null;
	}

	protected abstract void write(PacketBuffer paramPacketBuffer) throws IOException;

	public abstract void process(EntityPlayer paramEntityPlayer, Side paramSide);

	public static abstract class AbstractClientMessage<T extends AbstractMessage<T>> extends AbstractMessage<T> {
		protected final boolean isValidOnSide(Side side) {
			return side.isClient();
		}
	}

	public static abstract class AbstractServerMessage<T extends AbstractMessage<T>> extends AbstractMessage<T> {
		protected final boolean isValidOnSide(Side side) {
			return side.isServer();
		}
	}
}
