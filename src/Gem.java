import java.awt.*;
import javax.swing.*;

public class Gem extends Item {
	public Gem(int value){
		super(value);
	}
	
	public void drawItem(Graphics g, int startX, int startY) {	
		ImageIcon gem = new ImageIcon("res/emerald.gif");
		g.drawImage(gem.getImage(), startX, startY, Tile.SIZE,Tile.SIZE, null);	
	}
	
	public int getMultiplier() {
		return 1;
	}
}
