import java.awt.*;

public abstract class Tile {
	final static int SIZE = 50;
	private int row;
	private int col;
	
	public Tile(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public abstract boolean isPassable();
	public abstract void drawTile(Graphics g, int startX, int startY);	
}
