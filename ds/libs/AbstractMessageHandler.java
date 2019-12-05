package coffee.can.ds.libs;

import coffee.can.ds.DSMain;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;

public abstract class AbstractMessageHandler <T extends IMessage>
extends Object
implements IMessageHandler<T, IMessage>
{
@SideOnly(Side.CLIENT)
public abstract IMessage handleClientMessage(EntityPlayer paramEntityPlayer, T paramT, MessageContext paramMessageContext);

public abstract IMessage handleServerMessage(EntityPlayer paramEntityPlayer, T paramT, MessageContext paramMessageContext);

public IMessage onMessage(T message, MessageContext ctx) {
  if (ctx.side.isClient()) {
    return handleClientMessage(DSMain.proxy.getPlayerEntity(ctx), message, ctx);
  }
  return handleServerMessage(DSMain.proxy.getPlayerEntity(ctx), message, ctx);
}
}