import java.awt.Graphics;

public class Level
{
	private Tile[][] tiles;
	private Game game;
	public static int totalGems;
	public static int score;
	public static int gemCount;
	private int multiplier;
	
	
	public Level(Game game, char[][] levelRep)
	{
		this.game = game;
		tiles = new Tile[levelRep.length][levelRep[0].length];
		multiplier = 1;
		
		for (int i=0; i<levelRep.length; i++) {
			for (int k=0; k<levelRep[i].length; k++) {
			
				if (levelRep[i][k] == 'o') {
					tiles[i][k] = new Floor(i,k);
				} 
				else if (levelRep[i][k] == 'x') {
					tiles[i][k] = new Wall(i,k);
				}
				else if (levelRep[i][k] == 'p') {
					Tile floor = new Floor(i,k);
					tiles[i][k] = floor;
					((Floor) tiles[i][k]).containsPlayer(true);
					((Floor) tiles[i][k]).setPlayer(game.getPlayer());
				} 
				else if (levelRep[i][k] == 'm') {
					Monster m = new Monster(this.game, i, k);
					Tile floor = new Floor(i,k, m);
					tiles[i][k] = floor;
					game.addMonster(m);
				} 
				else if (levelRep[i][k] == 'g') {
					Tile floor = new Floor(i,k, new Gem(100));
					tiles[i][k] = floor;
					totalGems++;
				} 
				else if (levelRep[i][k] == 'y') {
					Tile floor = new Floor(i,k, new Multiply(0,3));
					tiles[i][k] = floor;
				} 
				else if (levelRep[i][k] == 's') {
					Tile stop = new Floor(i,k, new Stop(0,1));
					tiles[i][k] = stop;	
				}
				else if (levelRep[i][k] == 'k') {
					Tile lava = new Plant(i,k);
					tiles[i][k] = lava;
				}
			}
		}
	}
	
	public void draw (Graphics g) {
		for (int i=0; i<tiles.length; i++) {
			for (int k=0; k<tiles[i].length; k++) {
				tiles[i][k].drawTile(g, i*Tile.SIZE, k*Tile.SIZE);
			}
		}
	} 

	public void update(int row, int col)
	{
		game.getPlayer().move(row,col);
		
		int dr = game.getPlayer().getRow();
		int dc = game.getPlayer().getCol();
		
		if (gemCount == totalGems) {
			game.win();
		}	
		
		if (tiles[dr][dc] instanceof Plant) {
			game.lose();
		}
		
		if (tiles[dr][dc] instanceof Floor) {
			Item item = ((Floor) tiles[dr][dc]).collectItem();
			if (item != null) {
				if (item instanceof Gem) {
					gemCount++;
					score = score + item.getValue()*multiplier;	
					
					System.out.println("Gems left: " + (totalGems - gemCount));
					System.out.println("Score: " + score);
				}
				
				else if (item instanceof Multiply) {
					multiplier = item.getMultiplier();
					System.out.println("You have gained score multiplier of " + multiplier + " for the rest of the game!");
				} 
				
				else if (item instanceof Stop) {
				  	this.game.stopMonsters(); 
					System.out.println("Some monsters are frozen in time!");
				}
			} 
		}
	}
	
	public boolean monsterPass(int dR, int dC) {
		if ((dR == -1) || (dC == 15) || dR == 30 || dC == -1)
			return false;
		else
			return true;
	}
		
	public boolean isPassable(int row, int col)
	{
		int dR = game.getPlayer().getRow() + row;
		int dC = game.getPlayer().getCol() + col;
		if ((dR == -1) || (dC == 15) || dR == 30 || dC == -1)
			return false;
		else
			return true;
	}
	
	public Tile[][] getTiles() {
		return tiles;
	}
	
}
