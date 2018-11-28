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
	
	/**
	 * This method returns the character's image url.
	 * @return String image url.
	 */
	public String getImage() {
		return this.imagePath;
	}
	
	/**
	 * This method is used to set or change the character's image url.
	 * @param imagePath the image url.
	 */
	public void setImage(String imagePath) {
		this.imagePath = imagePath;
	}
	
	/**
	 * This method returns the number of steps the character has taken.
	 * @return int number of steps.
	 */
	public int getSteps() {
		return this.numSteps;
	}
	
	/**
	 * This method is used to set or change the number of steps.
	 * @param numSteps the number of steps.
	 */
	public void setSteps(int numSteps) {
		this.numSteps = numSteps;
	}

	/**
	 * This method is used to get the character's nickname.
	 * @return String character's nickname.
	 */
	public String getNickname() {
		return nickname;
	}
	
	/**
	 * This method is used to set or change the character's nickname.
	 * @param nickname the character's nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/**
	 * This method returns the row in which the character is placed.
	 * @return int row in which the character is placed.
	 */
	public int getI() {
		return i;
	}
	
	/**
	 * This method is used to set or change the row in which the character is placed.
	 * @param i the row.
	 */
	public void setI(int i) {
		this.i = i;
	}

	/**
	 * This method returns the column in which the character is placed.
	 * @return int column in which the character is placed.
	 */
	public int getJ() {
		return j;
	}

	/**
	 * This method is used to set or change the column in which the character is placed.
	 * @param i the column.
	 */
	public void setJ(int j) {
		this.j = j;
	}
}
