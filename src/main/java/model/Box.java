package model;

/**
 * Box class, represents either a wall or a breakable block, it also represents
 * a space.
 * 
 * @author Luis A. Rodriguez, �lvaro J. Escobar, Sebasti�n Correa.
 * @version 1.0
 * @since 2018-11-26
 */

public class Box {

	private boolean occupied;
	private boolean breakable;
	private boolean start;
	private boolean finish;
	private boolean isBomberman;
	/**
	 * This is the box class constructor, it is used to create instances of this
	 * class.
	 * 
	 * @param occupied
	 *            the box is occupied by a wall or a block.
	 * @param breakable
	 *            the box can be destroyed with a bomb.
	 */
	public Box(boolean occupied, boolean breakable) {
		this.occupied = occupied;
		this.breakable = breakable;
	}

	/**
	 * This method is used to verify if a box is occupied by a wall or a block.
	 * 
	 * @return boolean true if the box contains a wall or breakable block and false
	 *         if there's a space.
	 */
	public boolean isOccupied() {
		return occupied;
	}

	/**
	 * This method is used to change the occupied state of a box.
	 * 
	 * @param occupied
	 *            the new state of the box.
	 */
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	/**
	 * This method is used to verify if a box is a breakable block.
	 * 
	 * @return boolean true if the box is a breakable block and false if the box is
	 *         a wall.
	 */
	public boolean isBreakable() {
		return breakable;
	}

	/**
	 * This method is used to change the breakable state of a box.
	 * 
	 * @param breakable
	 *            the new state of the box.
	 */
	public void setBreakable(boolean breakable) {
		this.breakable = breakable;
	}

	/**
	 * This method is used to verify if a box is the start of the labyrinth.
	 * 
	 * @return boolean true if the box is the start of the labyrinth.
	 */
	public boolean isStart() {
		return start;
	}

	/**
	 * This method is used to set a block as the new start of the labyrinth.
	 * <b>pre:</b> there can be only one start in the labyrinth. 
	 * <b>post:</b> a block is the start of the labyrinth.
	 * 
	 * @param start
	 *            true if the block is the new start.
	 */
	public void setStart(boolean start) {
		this.start = start;
	}

	/**
	 * This method is used to verify if a box is the finish of the labyrinth.
	 * 
	 * @return boolean true if the box is the finish of the labyrinth.
	 */
	public boolean isFinish() {
		return finish;
	}

	/**
	 * This method is used to set a block as the new finish of the labyrinth.
	 * <b>pre:</b> there can be only one start in the labyrinth. 
	 * <b>post:</b> a block is the finish of the labyrinth.
	 * 
	 * @param finish
	 */
	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	public boolean isBomberman() {
		return isBomberman;
	}

	public void setBomberman(boolean isBomberman) {
		this.isBomberman = isBomberman;
	}

}
