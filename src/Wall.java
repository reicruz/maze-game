import java.awt.*;
import javax.swing.ImageIcon;

public class Wall extends Tile {
	private Item item;

	public Wall(int row, int col) {
		super(row,col);
	}

	public boolean isPassable() {
		return false;
	}

	public void drawTile(Graphics g, int startX, int startY) {
		ImageIcon wall = new ImageIcon("res/tree.gif");
		g.drawImage(wall.getImage(), startX, startY, Tile.SIZE, Tile.SIZE, null);
	}
}