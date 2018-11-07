package model;

public class Box {

	private boolean ocuped;
	private boolean breakable;
	
	public Box(boolean ocuped, boolean breakable) {
		this.ocuped = ocuped;
		this.breakable = breakable;
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
