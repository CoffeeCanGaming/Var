package coffee.can.ds.util.gui;

import org.lwjgl.opengl.GL11;

import coffee.can.ds.util.Props;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;

public class TestGui  extends GuiScreen{
	private EntityPlayer player;
	
	int guiwidth = 192;
	int guiheight = 192;
	
	GuiButton testButton;
	
	
	public void drawScreen(int x,int y,float ticks) {
		
		Props props = Props.get(player);
		
		
		mc.renderEngine.bindTexture(new ResourceLocation("ds:textures/gui/big.png"));
		
		ScaledResolution sr = new ScaledResolution(this.mc,mc.displayWidth,mc.displayHeight);
		GL11.glColor4f(1, 1, 1, 1);
		this.drawTexturedModalRect((sr.getScaledWidth()-guiwidth)/2,(sr.getScaledHeight()-guiheight)/2 , 0, 0,guiwidth ,guiheight );
		int guiX = (sr.getScaledWidth() - this.guiwidth) / 2;
		int guiY = (sr.getScaledHeight() - this.guiheight) / 2;
		
		this.fontRendererObj.drawString("BloodType: ", guiwidth-0, guiheight-75, 0);
		this.fontRendererObj.drawString(props.get(mc.thePlayer).getBloodTypeName(), guiwidth-20, guiheight-75, 0);
		
		
		
		
		
	}
	/*@Override
	public void initGui() {
		buttonList.clear();
		buttonList.add(testButton = new GuiButton(0, 256, 256, 20, 30, "Test"));
		super.initGui();
	}
	@Override
	protected void actionPerformed(GuiButton button) {
		switch(button.id) {
		case 0:
			button.displayString= "Test";
		}
		super.actionPerformed(button);
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		player.addChatComponentMessage(new ChatComponentText("Hello!"));
		}
	*/
	
}