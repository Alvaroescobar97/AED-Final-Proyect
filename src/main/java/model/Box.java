package model;

public class Box {

	private String coordinates;
	private boolean ocuped;
	private boolean breakable;
	private boolean start;
	private boolean finish;

	public Box(String coordinates, boolean ocuped, boolean breakable) {
		this.ocuped = ocuped;
		this.breakable = breakable;
		this.coordinates = coordinates;
	}

	public String getCoordenate() {
		return this.coordinates;
	}

	public void setCoordinates(String coordinates) {
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

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

}
