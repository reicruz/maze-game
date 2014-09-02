import java.awt.*;

public abstract class Item {
	private int value;
	private int startX;
	private int startY;

	public Item(int value) {	
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public abstract void drawItem(Graphics g, int startX, int startY);
	public abstract int getMultiplier();	
}
