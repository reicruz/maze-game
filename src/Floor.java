import java.awt.*;

public class Floor extends Tile {
	private Item item;
	private Player player;
	private Monster monster;
	private boolean hasPlayer;

	public Floor(int row, int col) {
		super(row,col);
		item = null;
	}
	
	public Floor(int row, int col, Item item) {
		super(row,col);
		this.item = item;
	}
	
	public Floor(int row, int col, Monster monster) {
		super(row,col);
		this.monster = monster;
	}

	public Item collectItem() {
			Item temp = item;
			item = null;
			return temp;
	}

	public boolean isPassable() {
		return true;
	}

	public void drawTile(Graphics g, int startX, int startY)
	{
		if (item != null) {
			item.drawItem(g, startX, startY);
		}
		if (hasPlayer) {
			player.draw(g);
		}
		if (monster != null) {
			monster.draw(g);
		}

		g.setColor(new Color(0,200,0));
		g.drawRect(startX, startY, Tile.SIZE, Tile.SIZE);
	}
	
	public void containsPlayer(boolean hasPlayer) {
		this.hasPlayer = hasPlayer;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setMonster(Monster monster) {
		this.monster = monster;
	}
	
	public void removeMonster() {
		monster = null;
	}
	
}