package model;

import java.util.Random;

/**
 * Map class, contains the classic labyrinth-type map of Bomberman and the main
 * character of the game, the Bomber.
 * 
 * @author Luis A. Rodriguez, Álvaro J. Escobar, Sebastián Correa.
 * @version 1.0
 * @since 2018-11-26
 */

public class Map {

	public static final int ROWS = 13;
	public static final int COLUMNS = 13;

	private Box[][] boxes;
	private Player bomberman;
	private Random random;

	/**
	 * This is the map class constructor, it is used to create instances of this
	 * class.
	 */
	public Map() {
		this.boxes = new Box[ROWS][COLUMNS];
		this.bomberman = new Player("Bomber");
		random = new Random();
	}

	/**
	 * This method returns the matrix of boxes that represents the labyrinth-type
	 * map.
	 * 
	 * @return Box[][] matrix that represents the map.
	 */
	public Box[][] getBoxes() {
		return boxes;
	}

	/**
	 * 
	 * @param boxes
	 */
	public void setBoxes(Box[][] boxes) {
		this.boxes = boxes;
	}

	/**
	 * 
	 */
	public void createLevelOne() {
		createBorders();
		createEasyPattern();

		int breakable = 0;

		while (breakable <= 25) {

			int randomRow = random.nextInt(ROWS);
			int randomColumn = random.nextInt(COLUMNS);

			if (boxes[randomRow][randomColumn].isBreakable() == false
					&& boxes[randomRow][randomColumn].isOccupied() == false
					&& boxes[randomRow][randomColumn].isStart() == false
					&& boxes[randomRow][randomColumn].isFinish() == false) {
				boxes[randomRow][randomColumn].setBreakable(true);
				boxes[randomRow][randomColumn].setOccupied(true);
				breakable++;
			}

		}

		boxes[1][0].setBreakable(false);
		boxes[1][0].setOccupied(false);
		boxes[1][0].setStart(true);

		boxes[13][COLUMNS - 1].setBreakable(false);
		boxes[13][COLUMNS - 1].setOccupied(false);
		boxes[13][COLUMNS - 1].setFinish(true);
	}

	/**
	 * 
	 */
	public void createLevelTwo() {
		createBorders();
		createEasyPattern();

		int breakable = 0;

		while (breakable <= 50) {
			int randomRow = random.nextInt(ROWS);
			int randomColumn = random.nextInt(COLUMNS);

			if (boxes[randomRow][randomColumn].isBreakable() == false
					&& boxes[randomRow][randomColumn].isOccupied() == false
					&& boxes[randomRow][randomColumn].isStart() == false
					&& boxes[randomRow][randomColumn].isFinish() == false) {
				boxes[randomRow][randomColumn].setBreakable(true);
				boxes[randomRow][randomColumn].setOccupied(true);
				breakable++;
			}
		}

		boxes[13][0].setBreakable(false);
		boxes[13][0].setOccupied(false);
		boxes[13][0].setStart(true);

		boxes[1][COLUMNS - 1].setBreakable(false);
		boxes[1][COLUMNS - 1].setOccupied(false);
		boxes[1][COLUMNS - 1].setFinish(true);
	}

	/**
	 * 
	 */
	public void createLevelThree() {
		createBorders();
		createHardPattern();

		int breakable = 0;

		while (breakable <= 60) {
			int randomRow = random.nextInt(ROWS);
			int randomColumn = random.nextInt(COLUMNS);

			if (boxes[randomRow][randomColumn].isBreakable() == false
					&& boxes[randomRow][randomColumn].isOccupied() == false
					&& boxes[randomRow][randomColumn].isStart() == false
					&& boxes[randomRow][randomColumn].isFinish() == false) {
				boxes[randomRow][randomColumn].setBreakable(true);
				boxes[randomRow][randomColumn].setOccupied(true);
				breakable++;
			}
		}

		boxes[0][1].setBreakable(false);
		boxes[0][1].setOccupied(false);
		boxes[0][1].setStart(true);

		boxes[ROWS - 1][COLUMNS - 1].setBreakable(false);
		boxes[ROWS - 1][COLUMNS - 1].setOccupied(false);
		boxes[ROWS - 1][COLUMNS - 1].setFinish(true);
	}

	/**
	 * 
	 */
	public void createBorders() {
		for (int i = 0; i < boxes.length; i++) {
			boxes[0][i].setBreakable(false);
			boxes[0][i].setOccupied(true);
			boxes[i][0].setBreakable(false);
			boxes[i][0].setOccupied(true);
			boxes[ROWS - 1][i].setBreakable(false);
			boxes[ROWS - 1][i].setOccupied(true);
			boxes[i][COLUMNS - 1].setBreakable(false);
			boxes[i][COLUMNS - 1].setOccupied(true);
		}
	}

	/**
	 * 
	 */
	public void createEasyPattern() {
		for (int i = 2; i <= ROWS - 4; i += 3) {
			for (int j = 2; j <= COLUMNS - 4; j += 3) {
				boxes[i][j].setBreakable(false);
				boxes[i][j].setOccupied(true);
			}
		}
	}

	/**
	 * 
	 */
	public void createHardPattern() {
		for (int i = 2; i <= ROWS - 3; i += 2) {
			for (int j = 2; j <= COLUMNS - 3; j += 2) {
				boxes[i][j].setBreakable(false);
				boxes[i][j].setOccupied(true);
			}
		}
	}

	public void movePlayer() {

	}

}
