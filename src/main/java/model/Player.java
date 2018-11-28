package model;

/**
 * Player class, represents the main character of the game, Bomber.
 * 
 * @author Luis A. Rodriguez, Alvaro J. Escobar, Sebastian Correa.
 * @version 1.0
 * @since 2018-11-26
 */
public class Player {
	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int RIGHT = 3;
	public static final int LEFT = 4;
	
	private String nickname;
	private String imagePath;
	private int i;
	private int j;
	private int numSteps;

	/**
	 * This is the Player class constructor, it is used to create instances of this
	 * class.
	 * 
	 * @param nickname
	 *            the name of the character.
	 */
	public Player(String nickname) {
		this.nickname = nickname;
		this.imagePath = "/data/Bomber_Front2.png";
	}
	
	public String getImage() {
		return this.imagePath;
	}
	
	public void setImage(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public int getSteps() {
		return this.numSteps;
	}
	
	public void setSteps(int numSteps) {
		this.numSteps = numSteps;
	}

	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public int getI() {
		return i;
	}
	
	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
}
