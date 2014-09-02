import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class MenuPanel extends JPanel {
	
	private JButton l1;
	private JButton l2;
	private Game game;
	private char[][] board1 = {{'p', 'o', 'x', 'g', 'x', 'x', 'o', 'o', 'k', 'g', 'o', 'o', 'x', 'x', 'g'},
										{'o', 'o', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'},
										{'o', 'o', 'x', 'o', 'o', 'o', 'o', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o'},
										{'o', 'o', 'g', 'x', 'x', 'o', 'g', 'x', 'o', 'o', 'm', 'o', 'm', 'o', 'o'},
										{'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o'},
										{'x', 'm', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'o', 'o', 'o', 'o', 'o'},
										{'g', 'k', 'o', 'o', 'o', 'x', 'o', 'g', 'o', 'o', 'o', 'o', 'o', 'o', 'o'},
										{'o', 'k', 'o', 'o', 'o', 'x', 'o', 'o', 'o', 'o', 'o', 'g', 'o', 'm', 'g'},
										{'o', 'k', 'o', 'o', 'o', 'x', 'o', 'o', 'o', 'x', 'x', 'x', 'x', 'o', 'o'},
										{'o', 'o', 'o', 'o', 'k', 'm', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'},
										{'o', 'o', 'm', 'o', 'k', 'o', 'o', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'o'},
										{'o', 'o', 'o', 'k', 'k', 'o', 'o', 'm', 'o', 'o', 'o', 'o', 'o', 'o', 'o'},
										{'o', 'k', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'},
										{'o', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'k', 'o', 'o', 'm', 'o', 'o', 'o'},
										{'g', 'm', 'o', 'o', 'o', 'o', 'o', 'o', 'g', 'o', 'o', 'o', 'o', 'o', 'm'},
										{'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'k', 'o', 'x', 'x', 'x', 'x', 'o'},
										{'o', 'o', 'o', 'x', 'o', 'o', 'o', 'o', 'x', 'o', 'm', 'o', 'g', 'x', 'o'},
										{'o', 'o', 'o', 'x', 'o', 'o', 'o', 'o', 'x', 'o', 'o', 'o', 'o', 'x', 'o'},
										{'o', 'o', 'o', 'x', 'x', 'x', 'o', 'o', 'x', 'o', 'x', 'x', 'x', 'x', 'o'},
										{'o', 'g', 'o', 'o', 'o', 'o', 'o', 'o', 'g', 'o', 'o', 'o', 'o', 'o', 'o'},
										{'o', 'o', 'x', 'o', 'o', 'o', 'x', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o'},
										{'x', 'x', 'x', 'o', 'k', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'm', 'o', 'o'},
										{'g', 'o', 'x', 'o', 'k', 'o', 'o', 'o', 'o', 'm', 'o', 'k', 'o', 'k', 'o'},
										{'o', 'o', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'k', 'o', 'k', 'o'},
										{'o', 'o', 'x', 'o', 'g', 'o', 'o', 'k', 'o', 'o', 'o', 'k', 'o', 'k', 'o'},
										{'o', 'o', 'o', 'o', 'o', 'x', 'o', 'o', 'o', 'o', 'o', 'k', 'o', 'k', 'o'},
										{'x', 'o', 'x', 'o', 'o', 'x', 'o', 'o', 'o', 'o', 'o', 'k', 'o', 'k', 'o'},
										{'o', 'm', 'x', 'o', 'o', 'x', 'o', 'o', 'm', 'o', 'o', 'k', 'o', 'k', 'o'},
										{'g', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'k', 'o', 'k', 'o'},
										{'s', 'x', 'o', 'o', 'x', 'o', 'o', 'g', 'o', 'o', 'g', 'k', 'y', 'k', 'g'}};
	
	private char[][] board2 = {{'p', 'o', 'x', 'o', 'o', 'x', 'g', 'o', 'o', 'o', 'k', 'o', 'o', 'o', 'k'},
										{'o', 'o', 'x', 'o', 'o', 'x', 'x', 'x', 'x', 'o', 'k', 'o', 'o', 'o', 'o'},
										{'k', 'o', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'o', 'o', 'o'},
										{'o', 'o', 'x', 'o', 'o', 'm', 'k', 'o', 'o', 'k', 'o', 'x', 'o', 'o', 'o'},
										{'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'm', 'o', 'o', 'x', 'o', 'm', 'o'},
										{'o', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'},
										{'x', 'x', 'o', 'k', 'o', 'x', 'x', 'x', 'o', 'm', 'o', 'o', 'o', 'o', 'o'},
										{'g', 'x', 'o', 'o', 'o', 'o', 'o', 'x', 'o', 'o', 'o', 'o', 'x', 'o', 'o'},
										{'o', 'x', 'o', 'k', 'm', 'o', 'o', 'x', 'o', 'o', 'o', 'o', 'x', 'g', 'o'},
										{'o', 'x', 'o', 'o', 'o', 'k', 'o', 'o', 'o', 'o', 'o', 'k', 'g', 'k', 'o'},
										{'o', 'x', 'o', 'o', 'o', 'o', 'o', 'x', 'o', 'o', 'o', 'x', 'o', 'x', 'o'},
										{'o', 'x', 'o', 'x', 'o', 'o', 'm', 'o', 'k', 'k', 'o', 'x', 'o', 'x', 'x'},
										{'o', 'x', 'o', 'x', 'o', 'o', 'x', 'k', 'x', 'o', 'o', 'x', 'o', 'x', 'o'},
										{'o', 'x', 'o', 'x', 'k', 'o', 'k', 'g', 'k', 'o', 'o', 'o', 'o', 'o', 'o'},
										{'o', 'x', 'o', 'o', 'o', 'o', 'x', 'y', 'x', 'o', 'o', 'o', 'o', 'o', 'o'},
										{'o', 'x', 'm', 'o', 'o', 'o', 'k', 'o', 'k', 'k', 'o', 'o', 'o', 'o', 'o'},
										{'o', 'x', 'o', 'g', 'o', 'o', 'x', 'o', 'o', 'x', 'o', 'o', 'o', 'o', 'o'},
										{'o', 'x', 'o', 'o', 'o', 'o', 'o', 'k', 'o', 'k', 'x', 'o', 'o', 'o', 'o'},
										{'o', 'x', 'o', 'o', 'o', 'o', 'o', 'x', 'o', 'o', 'k', 'o', 'o', 'o', 'o'},
										{'o', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'k', 'o', 'x', 'k', 'x', 'k', 'x'},
										{'o', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'o', 'o', 'o', 'o', 'o', 'o'},
										{'o', 'o', 'o', 'o', 'o', 'o', 'x', 'o', 'k', 'x', 'k', 'x', 'k', 'x', 'o'},
										{'x', 'x', 'x', 'x', 'x', 'o', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'k', 'o'},
										{'g', 'o', 'o', 'o', 'x', 'o', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'o'},
										{'o', 'o', 'o', 'o', 'x', 'g', 'x', 'o', 'o', 'm', 'o', 'o', 'o', 'k', 'o'},
										{'o', 'o', 'o', 'o', 'k', 'o', 'k', 'k', 'o', 'o', 'o', 'o', 'o', 'x', 'o'},
										{'o', 'o', 'o', 'm', 'k', 'o', 'o', 'k', 'o', 'o', 'o', 'o', 'o', 'k', 'o'},
										{'o', 'o', 'o', 'o', 'k', 'k', 'o', 'k', 'o', 'o', 'o', 'o', 'o', 'x', 'g'},
										{'x', 'x', 'x', 'm', 'o', 'k', 'o', 'k', 'o', 'o', 'o', 'o', 'o', 'k', 'o'},
										{'g', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'm', 'o', 'o'}};
	
	public MenuPanel(Game game)
	{
		this.game = game;		
		l1 = new JButton("Level 1");
		l2 = new JButton("Level 2");
		
		l1.addActionListener(new ButtonListener(1));
		l2.addActionListener(new ButtonListener(2));
		
		l1.setPreferredSize(new Dimension(300, 150));
		l2.setPreferredSize(new Dimension(300, 150));
		
		add(l1);
		add(l2);
	}
	
	public void paintComponent(Graphics g)
	{
		ImageIcon player = new ImageIcon("res/player.gif");
		ImageIcon gem = new ImageIcon("res/emerald.gif");
		ImageIcon stop = new ImageIcon("res/sapph.gif");	
		ImageIcon star = new ImageIcon("res/star.gif");
		ImageIcon wall = new ImageIcon("res/tree.gif");
		ImageIcon plant = new ImageIcon("res/plant.gif");
		ImageIcon monster = new ImageIcon("res/monster1.gif");
		
		g.drawImage(player.getImage(), 160, 200, Tile.SIZE, Tile.SIZE, null);
		g.drawImage(gem.getImage(), 160, 275, Tile.SIZE, Tile.SIZE, null);
		g.drawImage(stop.getImage(), 160, 350, Tile.SIZE, Tile.SIZE, null);
		g.drawImage(star.getImage(), 160, 425, Tile.SIZE, Tile.SIZE, null);
		g.drawImage(wall.getImage(), 160, 500, Tile.SIZE, Tile.SIZE, null);
		g.drawImage(plant.getImage(), 160, 575, Tile.SIZE, Tile.SIZE, null);
		g.drawImage(monster.getImage(), 160, 650, Tile.SIZE, Tile.SIZE, null);
		
		String p = "Player - Control with arrow keys";
		String ge = "Gem - Collect all of these on the map to win!";
		String f = "Stop Gem - Stop time and run past some enemies!";
		String s = "Star - Collect to earn a score multiplier!";
		String w = "Tree - Trees block your way, try not to get stuck!";
		String pl = "Piranha Plant - Careful not to get eaten alive!";
		String m = "Monster - Avoid these or you lose!";
		
		g.setColor(Color.black);
		g.drawString(p, 235, 225);
		g.drawString(ge, 235, 300);
		g.drawString(f, 235, 375);
		g.drawString(s, 235, 450);
		g.drawString(w, 235, 525);
		g.drawString(pl, 235, 600);
		g.drawString(m, 235, 675);
		
		repaint();
	}
	
	public class ButtonListener implements ActionListener {
		private int x;
		public ButtonListener(int x) {
			this.x = x;
		}
		
		public void actionPerformed(ActionEvent e) {
			if (x == 1) {
				LevelPanel panel = new LevelPanel(game, board1);
				
				remove(l1);
				remove(l2);
				add(panel);
				panel.requestFocus();
				
			} else if (x == 2) {
				LevelPanel panel = new LevelPanel(game, board2);
								
				remove(l1);
				remove(l2);
				add(panel);
				panel.requestFocus();
			}
			revalidate();
		}
	}
}
