import java.awt.*;
import javax.swing.*;

public class Player extends Character {
	private int score;
	private int row;
	private int col;
	
	public Player(Game game, int row, int col) {
		super(game,row,col);
		this.row = row;
		this.col = col;
	}
	
	public void move(int dx, int dy) {	
		setRow(getRow() + dx);
		setCol(getCol() + dy);
	}
	
	public void draw(Graphics g) {
		ImageIcon player = new ImageIcon("res/player.gif");
		g.drawImage(player.getImage(), getRow()*Tile.SIZE, getCol()*Tile.SIZE, Tile.SIZE, Tile.SIZE, null);
	}
	
}
