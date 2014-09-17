package bour.camus.gameofgooses.models;

/**
 * This class represents a player in the game with its goose.
 * @author Armand BOUR
 *
 */
public class Player {
	
	/** Reference to the {@link Cell} containing this Player. */
	private Cell mCell;
	
	/**
	 * Throw a die and gets its resulting number.
	 * @return A random number between 1 and 6.
	 */
	
	public int throwDie() {
		return 0;
	}
	
	/**
	 * Gets the cell in which the player is.
	 * @return A reference to the cell in which the player is.
	 */
	public Cell getCell() {
		return mCell;
	}
	
	/**
	 * Move the player to the specified cell.
	 * @param cell The cell where the player should be moved.
	 */
	public void setCell(Cell cell) {
		this.mCell = cell;
	}
}
