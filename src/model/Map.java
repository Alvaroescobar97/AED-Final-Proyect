package model;

public class Map {

	public static final int ROWS = 20;
	public static final int COLUMNS = 20;

	private Box[][] boxes;
	private Player bomberman;

	public Map() {
		this.boxes = new Box [ROWS][COLUMNS];
	}

	public Box[][] getBoxes() {
		return boxes;
	}

	public void setBoxes(Box[][] boxes) {
		this.boxes = boxes;
	}
	
	
	
	
	
	
	
	
	
	
	
}
