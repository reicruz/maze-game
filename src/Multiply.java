import java.awt.*;
import javax.swing.*;

public class Multiply extends Item {
	private int multiplier;
	private int moves;
	
	public Multiply(int value, int multiplier) {
		super(value);
		this.multiplier = multiplier;
	}
	
	public void drawItem(Graphics g, int startX, int startY) {
		ImageIcon star = new ImageIcon("res/star.gif");
		g.drawImage(star.getImage(), startX, startY, Tile.SIZE, Tile.SIZE, null);
	}

	public int getMultiplier() {
		return multiplier;
	}
}
