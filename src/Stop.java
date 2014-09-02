import java.awt.*;
import javax.swing.*;

public class Stop extends Item {
	private int multiplier;
	private int moves;
	
	public Stop(int value, int multiplier) {
		super(value);
		this.multiplier = multiplier;
	}

	public void drawItem(Graphics g, int x, int y) {
		ImageIcon stop = new ImageIcon("res/sapph.gif");
		g.drawImage(stop.getImage(), x,y, Tile.SIZE, Tile.SIZE, null);
	}

	public int getMultiplier() {
		return multiplier;
	}
}
