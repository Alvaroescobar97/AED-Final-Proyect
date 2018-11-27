package model;

import java.util.Random;

import graphEstructure.GraphMatrix;
import graphEstructure.Vertex;

/**
 * Map class, contains the classic labyrinth-type map of Bomberman and the main
 * character of the game, the Bomber.
 * 
 * @author Luis A. Rodriguez, �lvaro J. Escobar, Sebasti�n Correa.
 * @version 1.0
 * @since 2018-11-26
 */

public class Map {

	public static final int ROWS = 13;
	public static final int COLUMNS = 13;
	
	private Box[][] boxes;
	private GraphMatrix<Box> graph;
	private Player bomberman;
	private Random random;

	/**
	 * This is the map class constructor, it is used to create instances of this
	 * class.
	 */
	public Map() {
		this.boxes = new Box[ROWS][COLUMNS];
		
		for(int i = 0; i < boxes.length; i++) {
			for(int j = 0;  j < boxes[0].length; j++) {
				boxes[i][j] =  new Box(false, false);
			}
		}
		
		this.bomberman = new Player("Bomber");
		random = new Random();
	}

	public Player getBomberman() {
		return bomberman;
	}

	public void setBomberman(Player bomberman) {
		this.bomberman = bomberman;
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
	 * This method is used to set a new matrix as map.
	 * 
	 * @param boxes
	 *            the new matrix.
	 */
	public void setBoxes(Box[][] boxes) {
		this.boxes = boxes;
	}

	/**
	 * This creates a random first level for the game, with easy difficulty. The
	 * number of breakable boxes is 25.
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
		boxes[1][0].setBomberman(true);

		boxes[11][COLUMNS - 1].setBreakable(false);
		boxes[11][COLUMNS - 1].setOccupied(false);
		boxes[11][COLUMNS - 1].setFinish(true);
		
		fillGraph();
	}
	
	public void fillGraph() {
		this.graph = new GraphMatrix<Box>(169,false, false);
		
		for(int i = 0; i < boxes.length; i++) {
			for(int j = 0; j < boxes[0].length; j++) {
				graph.addVertex(boxes[i][j]);
			}
		}
		
		for(int i = 1; i < boxes.length-1; i++) {
			for(int j = 1; j < boxes[0].length-1; j++) {
				
				Vertex<Box> v1  = graph.getVertex(boxes[i][j]);
				
				if(boxes[i-1][j].isOccupied() && !boxes[i-1][j].isBreakable()) {
					Vertex<Box> v2 = graph.getVertex(boxes[i-1][j]);
					graph.addEdge(v1, v2);
				}
					
				
				if(boxes[i][j+1].isOccupied() && !boxes[i][j+1].isBreakable()) {
					Vertex<Box> v2 = graph.getVertex(boxes[i][j+1]);
					graph.addEdge(v1, v2);
				}
				
				if(boxes[i+1][j].isOccupied() && !boxes[i+1][j].isBreakable()) {
					Vertex<Box> v2 = graph.getVertex(boxes[i+1][j]);
					graph.addEdge(v1, v2);
				}
					
				
				if(boxes[i][j-1].isOccupied() && !boxes[i][j-1].isBreakable()) {
					Vertex<Box> v2 = graph.getVertex(boxes[i][j-1]);
					graph.addEdge(v1, v2);
				}
					
			}
		}
		
		
		
	}

	/**
	 * This creates a random second level for the game, with easy difficulty. The
	 * number of breakable boxes is 50.
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

		boxes[12][0].setBreakable(false);
		boxes[12][0].setOccupied(false);
		boxes[12][0].setStart(true);

		boxes[1][COLUMNS - 1].setBreakable(false);
		boxes[1][COLUMNS - 1].setOccupied(false);
		boxes[1][COLUMNS - 1].setFinish(true);
		
		fillGraph();
	}

	/**
	 * This creates a random third level for the game, with hard difficulty. The
	 * number of breakable boxes is 60.
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
		
		fillGraph();
	}

	/**
	 * This method creates the borders of the map. The borders of the map are the
	 * first and last rows and columns.
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
	 * This method creates a pattern of walls with two boxes of space, either for
	 * rows or columns.
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
	 * This method creates a pattern of walls with one box of space, either for rows
	 * or columns.
	 */
	public void createHardPattern() {
		for (int i = 2; i <= ROWS - 3; i += 2) {
			for (int j = 2; j <= COLUMNS - 3; j += 2) {
				boxes[i][j].setBreakable(false);
				boxes[i][j].setOccupied(true);
			}
		}
	}

	public void movePlayer(int direction) {
		showBoxes();
		if(direction ==  Player.UP && !boxes[bomberman.getI()+1][bomberman.getJ()].isOccupied()) {
			boxes[bomberman.getI()][bomberman.getJ()].setOccupied(false);
			boxes[bomberman.getI()][bomberman.getJ()].setBomberman(false);
			
			bomberman.setI(bomberman.getI() +1);
			bomberman.setSteps(bomberman.getSteps() +1);
			
			boxes[bomberman.getI()][bomberman.getJ()].setOccupied(true);
			boxes[bomberman.getI()][bomberman.getJ()].setBomberman(true);
			
			bomberman.setImage("/data/Bomber_Back2.png");
			
		}else if(direction == Player.DOWN && !boxes[bomberman.getI()-1][bomberman.getJ()].isOccupied()) {
			boxes[bomberman.getI()][bomberman.getJ()].setOccupied(false);
			boxes[bomberman.getI()][bomberman.getJ()].setBomberman(false);
			
			bomberman.setI(bomberman.getI() -1);
			bomberman.setSteps(bomberman.getSteps() +1);
			
			boxes[bomberman.getI()][bomberman.getJ()].setOccupied(true);
			boxes[bomberman.getI()][bomberman.getJ()].setBomberman(true);
			
			bomberman.setImage("/data/Bomber_Front2.png");
		}else if(direction == Player.LEFT && !boxes[bomberman.getI()][bomberman.getJ() -1].isOccupied()) {
			boxes[bomberman.getI()][bomberman.getJ()].setOccupied(false);
			boxes[bomberman.getI()][bomberman.getJ()].setBomberman(false);
			
			bomberman.setJ(bomberman.getJ() -1);
			bomberman.setSteps(bomberman.getSteps() +1);
			
			boxes[bomberman.getI()][bomberman.getJ()].setOccupied(true);
			boxes[bomberman.getI()][bomberman.getJ()].setBomberman(true);
			
			bomberman.setImage("/data/Bomber_Left2.png");
		}else if(direction == Player.RIGHT && !boxes[bomberman.getI()][bomberman.getJ() +1].isOccupied()) {
			
			boxes[bomberman.getI()][bomberman.getJ()].setOccupied(false);
			boxes[bomberman.getI()][bomberman.getJ()].setBomberman(false);
			
			bomberman.setJ(bomberman.getJ() +1);
			bomberman.setSteps(bomberman.getSteps() +1);
			
			boxes[bomberman.getI()][bomberman.getJ()].setOccupied(true);
			boxes[bomberman.getI()][bomberman.getJ()].setBomberman(true);
			
			bomberman.setImage("/data/Bomber_Right2.png");
		}
	}
	
	public void showBoxes() {
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < ROWS; j++) {
				System.out.println("[" + i + "]" + "[" + j + "] " + boxes[i][j].toString());
			}
		}
	}

}
