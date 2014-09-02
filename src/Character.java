import java.awt.*;

public abstract class Character {
	protected Game game;
	private int row,col;
	
	public Character(Game game, int row, int col) {
		this.game = game;
		this.col = col;
		this.row = row;
	}
	
	public abstract void draw(Graphics g);

	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public void setCol(int col) {
		this.col = col;
	}
}

