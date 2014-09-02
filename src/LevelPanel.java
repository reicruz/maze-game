import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LevelPanel extends JPanel {
	private Game game;
	private Player p;
	private char[][] board;
	protected static Level l;
			
	public LevelPanel(Game game, char[][] board)
	{
		this.board = board;
		this.game = game;
		p = game.getPlayer();
		l = new Level(game, board);
		
		setFocusable(true);
		requestFocusInWindow();
		
		setBackground(new Color(0,150,0));
		setPreferredSize(new Dimension(30*Tile.SIZE, 17*Tile.SIZE));
		
		addKeyListener(new MoveListener());
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		l.draw(g);
		
		String gems = "Gems left: " + (Level.totalGems - Level.gemCount);
		String score = "Score: " + Level.score;
		g.setColor(Color.black);
		g.drawString(gems, 10, 800);
		g.drawString(score, 500, 800);

	}
	
	public class MoveListener implements KeyListener {

		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (l.isPassable(1,0) && l.getTiles()[p.getRow() + 1][p.getCol()].isPassable()) {
					board[p.getRow()][p.getCol()] = 'o';
					board[p.getRow() + 1][p.getCol()] = 'p';
					l.update(1, 0);
				}
				
			} else if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (l.isPassable(0,-1) && l.getTiles()[p.getRow()][p.getCol() - 1].isPassable()) {
					board[p.getRow()][p.getCol()] = 'o';
					board[p.getRow()][p.getCol() - 1] = 'p';
					l.update(0,-1);
				}
				
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if (l.isPassable(0,1) && l.getTiles()[p.getRow()][p.getCol() + 1].isPassable()) {
					board[p.getRow()][p.getCol()] = 'o';
					board[p.getRow()][p.getCol() + 1] = 'p';
					l.update(0,1);
				}	
						
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (l.isPassable(-1,0) && l.getTiles()[p.getRow() - 1][p.getCol()].isPassable()) {
					board[p.getRow()][p.getCol()] = 'o';
					board[p.getRow() - 1][p.getCol()] = 'p';
					l.update(-1,0);
				}
			}
			repaint();
		}
		
		public void keyReleased(KeyEvent e) {}
		public void keyTyped(KeyEvent e) {}	
	}	
}
