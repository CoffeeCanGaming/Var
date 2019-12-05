package coffee.can.ds.libs;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayerMP;
import coffee.can.ds.libs.sync.*;

public class PacketSender {

	private static byte packetId = 0;
	public static final SimpleNetworkWrapper dispatcher = NetworkRegistry.INSTANCE.newSimpleChannel("DS");

	public static final void registerPackets() {
		registerMessage(SyncPlayerPropsMessage.Handler.class, SyncPlayerPropsMessage.class, Side.CLIENT);
		registerMessage(SyncBloodTypeMessage.class);

	}

	private static final void registerMessage(Class handlerClass, Class messageClass, Side side) {
		packetId = (byte) (packetId + 1);
		dispatcher.registerMessage(handlerClass, messageClass, packetId, side);
	}

	private static final <T extends AbstractMessage<T> & cpw.mods.fml.common.network.simpleimpl.IMessageHandler<T, IMessage>> void registerMessage(
			Class<T> clazz) {
		if (AbstractMessage.AbstractClientMessage.class.isAssignableFrom(clazz)) {

			packetId = (byte) (packetId + 1);
			dispatcher.registerMessage(clazz, clazz, packetId, Side.CLIENT);
		} else if (AbstractMessage.AbstractServerMessage.class.isAssignableFrom(clazz)) {

			packetId = (byte) (packetId + 1);
			dispatcher.registerMessage(clazz, clazz, packetId, Side.SERVER);
		} else {

			dispatcher.registerMessage(clazz, clazz, packetId, Side.CLIENT);
			packetId = (byte) (packetId + 1);
			dispatcher.registerMessage(clazz, clazz, packetId, Side.SERVER);
		}
	}

	public static final void sendTo(IMessage message, EntityPlayerMP player) {
		dispatcher.sendTo(message, player);
	}

	public static void sendToAll(IMessage message) {
		dispatcher.sendToAll(message);
	}

	public static final void sendToAllAround(IMessage message, NetworkRegistry.TargetPoint point) {
		dispatcher.sendToAllAround(message, point);
	}

	public static final void sendToDimension(IMessage message, int dimensionId) {
		dispatcher.sendToDimension(message, dimensionId);
	}

	public static final void sendToServer(IMessage message) {
		dispatcher.sendToServer(message);
	}
}
