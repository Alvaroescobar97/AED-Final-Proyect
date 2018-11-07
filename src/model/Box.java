package model;

public class Box {
	
	private String coordinates;
	private boolean ocuped;
	private boolean breakable;
	
	public Box(String coordinates, boolean ocuped, boolean breakable) {
		this.ocuped = ocuped;
		this.breakable = breakable;
		this.coordinates = coordinates;
	}
	
	public String getCoordenate(){
		return this.coordinates;
	}
	
	public void setCoordinates(String coordinates){
		this.coordinates = coordinates;
	}

	public boolean isOcuped() {
		return ocuped;
	}

	public void setOcuped(boolean ocuped) {
		this.ocuped = ocuped;
	}

	public boolean isBreakable() {
		return breakable;
	}

	public void setBreakable(boolean breakable) {
		this.breakable = breakable;
	}
	
}
