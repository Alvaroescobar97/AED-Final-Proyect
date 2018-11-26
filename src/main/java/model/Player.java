package model;

/**
 * Player class, represents the main character of the game, Bomber.
 * 
 * @author Luis A. Rodriguez, Álvaro J. Escobar, Sebastián Correa.
 * @version 1.0
 * @since 2018-11-26
 */
public class Player {

	private String nickname;
	private Step steps;

	/**
	 * This is the Player class constructor, it is used to create instances of this
	 * class.
	 * 
	 * @param nickname
	 *            the name of the character.
	 */
	public Player(String nickname) {
		this.nickname = nickname;
		this.steps = new Step(0);
	}

	/**
	 * 
	 * @return
	 */
	public Step getSteps() {
		return steps;
	}

	/**
	 * 
	 * @param steps
	 */
	public void setSteps(Step steps) {
		this.steps = steps;
	}

	/**
	 * 
	 */
	public void move() {

	}
}
