import java.awt.*;
import javax.swing.*;

public class Plant extends Tile {

	public Plant(int row, int col) {
		super(row, col);
	}

	public boolean isPassable() {
		return true;
	}

	public void drawTile(Graphics g, int startX, int startY) {
		ImageIcon plant = new ImageIcon("res/plant.gif");
		g.drawImage(plant.getImage(),startX, startY, Tile.SIZE, Tile.SIZE, null);
	}
}

