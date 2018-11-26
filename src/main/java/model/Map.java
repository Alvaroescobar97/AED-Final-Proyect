package model;

import java.util.Random;

public class Map {

	public static final int ROWS = 15;
	public static final int COLUMNS = 15;

	private Box[][] boxes;
	private Player bomberman;
	private Random random;

	public Map() {
		this.boxes = new Box[ROWS][COLUMNS];
		random = new Random();
	}

	public Box[][] getBoxes() {
		return boxes;
	}

	public void setBoxes(Box[][] boxes) {
		this.boxes = boxes;
	}

	public void createLevelOne() {
		createBorders();
		createEasyPattern();

		int breakable = 0;

		while (breakable <= 25) {

			if (boxes[random.nextInt(ROWS)][random.nextInt(COLUMNS)].isBreakable() == false
					&& boxes[random.nextInt(ROWS)][random.nextInt(COLUMNS)].isOcuped() == false) {
				boxes[random.nextInt(ROWS)][random.nextInt(COLUMNS)].setBreakable(true);
				boxes[random.nextInt(ROWS)][random.nextInt(COLUMNS)].setOcuped(true);
				breakable++;
			}

		}

		boxes[1][0].setBreakable(false);
		boxes[1][0].setOcuped(false);
		boxes[1][0].setStart(true);

		boxes[13][COLUMNS - 1].setBreakable(false);
		boxes[13][COLUMNS - 1].setOcuped(false);
		boxes[13][COLUMNS - 1].setFinish(true);
	}

	public void createLevelTwo() {
		createBorders();
		createEasyPattern();

		int breakable = 0;

		while (breakable <= 50) {
			if (boxes[random.nextInt(ROWS)][random.nextInt(COLUMNS)].isBreakable() == false
					&& boxes[random.nextInt(ROWS)][random.nextInt(COLUMNS)].isOcuped() == false) {
				boxes[random.nextInt(ROWS)][random.nextInt(COLUMNS)].setBreakable(true);
				boxes[random.nextInt(ROWS)][random.nextInt(COLUMNS)].setOcuped(true);
				breakable++;
			}
		}

		boxes[13][0].setBreakable(false);
		boxes[13][0].setOcuped(false);
		boxes[13][0].setStart(true);

		boxes[1][COLUMNS - 1].setBreakable(false);
		boxes[1][COLUMNS - 1].setOcuped(false);
		boxes[1][COLUMNS - 1].setFinish(true);
	}

	public void createLevelThree() {
		createBorders();
		createHardPattern();

		int breakable = 0;

		while (breakable <= 60) {
			if (boxes[random.nextInt(ROWS)][random.nextInt(COLUMNS)].isBreakable() == false
					&& boxes[random.nextInt(ROWS)][random.nextInt(COLUMNS)].isOcuped() == false) {
				boxes[random.nextInt(ROWS)][random.nextInt(COLUMNS)].setBreakable(true);
				boxes[random.nextInt(ROWS)][random.nextInt(COLUMNS)].setOcuped(true);
				breakable++;
			}
		}
		
		boxes[0][1].setBreakable(false);
		boxes[0][1].setOcuped(false);
		boxes[0][1].setStart(true);

		boxes[ROWS-1][COLUMNS - 1].setBreakable(false);
		boxes[ROWS-1][COLUMNS - 1].setOcuped(false);
		boxes[ROWS-1][COLUMNS - 1].setFinish(true);
	}

	public void createBorders() {
		for (int i = 0; i < boxes.length; i++) {
			boxes[0][i].setBreakable(false);
			boxes[0][i].setOcuped(true);
			boxes[i][0].setBreakable(false);
			boxes[i][0].setOcuped(true);
			boxes[ROWS - 1][i].setBreakable(false);
			boxes[ROWS - 1][i].setOcuped(true);
			boxes[i][COLUMNS - 1].setBreakable(false);
			boxes[i][COLUMNS - 1].setOcuped(true);
		}
	}

	public void createEasyPattern() {
		for (int i = 2; i <= ROWS - 4; i += 3) {
			for (int j = 2; j <= COLUMNS - 4; j += 3) {
				boxes[i][j].setBreakable(false);
				boxes[i][j].setOcuped(true);
			}
		}
	}

	public void createHardPattern() {
		for (int i = 2; i <= ROWS - 3; i += 2) {
			for (int j = 2; j <= COLUMNS - 3; j += 2) {
				boxes[i][j].setBreakable(false);
				boxes[i][j].setOcuped(true);
			}
		}
	}

}
