import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Game extends JFrame
{
	private Player p;
	private int gems;
	private int totalGems;
	private ArrayList<Monster> monsters;
	private LevelPanel levelPanel;
	private MenuPanel menuPanel;
	private Timer t;	

	public Game() 
	{
		p = new Player(this, 0, 0);
		monsters = new ArrayList<Monster>();
		menuPanel = new MenuPanel(this);
		t = new Timer(300,new MonsterListener());
		t.start();
	}
	
	public void win()
	{
		t.stop();	
		int reply = JOptionPane.showConfirmDialog(null, "You win!", "YOU WIN", JOptionPane.DEFAULT_OPTION);
      	if (reply == JOptionPane.OK_OPTION) {
        		System.exit(0);
			}
	}
	
	public void lose()
	{
		t.stop();
		int reply = JOptionPane.showConfirmDialog(null, "You Lose!", "YOU LOSE", JOptionPane.DEFAULT_OPTION);
      	if (reply == JOptionPane.OK_OPTION) {
       		System.exit(0);
			}
	}
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Gems Quest");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		frame.add(new MenuPanel(new Game()));
		frame.setPreferredSize(new Dimension(30*Tile.SIZE, 17*Tile.SIZE));
		
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
	}
	
	public Player getPlayer() {
		return p;
	}
	
	public int getGems() {
		return gems;
	}
	
	public void setGems(int numGems, int totalGem) {
		gems = numGems;
		totalGems = totalGem;
	}
	
	public class MonsterListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < monsters.size(); i++) {
				monsters.get(i).update();
			}
		}
	}
	
	public ArrayList<Monster> getMonsters() {
		return monsters;
	}
	
	public void stopMonsters() {
		for (int i = 0; i < monsters.size(); i++) {
			monsters.remove(i);
		}
	}
	
	public void addMonster(Monster monster) {
		monsters.add(monster);
	}
	
	public void drawMonster(Graphics g) {
		for (int i = 0; i < monsters.size(); i++) {
			monsters.get(i).draw(g);
		}
	}	
}