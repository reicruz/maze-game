import java.awt.*;
import java.util.*;
import javax.swing.*;
public class Monster extends Character {
	private boolean stopped;
	private Graphics g;
	
	public Monster(Game game, int row, int col) {
		super(game, row, col);
		stopped = false;
	}

	public void draw(Graphics g) {
		this.g = g;
		ImageIcon monster = new ImageIcon("res/monster1.gif");
		g.drawImage(monster.getImage(), getRow()*Tile.SIZE ,getCol()*Tile.SIZE, Tile.SIZE, Tile.SIZE, null);
	}
	
	public void setStop(boolean flag) {
		stopped = flag;
	}

	public void update() {
		Level level = LevelPanel.l;
		Random rand = new Random();
		
		int dx = rand.nextInt(3) - 1;
		int dy = rand.nextInt(3) - 1;
		int dR = getRow();
		int dC = getCol();
		
		if (!stopped) {
			dR = getRow() + dx;
			dC = getCol() + dy;
		}
		
		if ((game.getPlayer().getRow() == getRow()) && (game.getPlayer().getCol() == getCol())) {
			game.lose();
		}	
		
		if (level.monsterPass(dR, dC)) {
			if (level.getTiles()[dR][dC] instanceof Floor) {
				setRow(dR);
				setCol(dC);
			}
		}
		draw(g);
		level.update(0, 0);
		
		if ((game.getPlayer().getRow() == getRow()) && (game.getPlayer().getCol() == getCol())) {
			game.lose();
		}	
	}
}
