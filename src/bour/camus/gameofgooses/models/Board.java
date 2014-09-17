package bour.camus.gameofgooses.models;

/** The Board class represents the board of the {@link Game}. It contains all the {@link Cell}
 * used to play.
 * 
 * @author Armand BOUR
 *
 */
public class Board {
	
	/** Array containing all the cells of the board. */
	private Cell[] mCells;

	
	/**
	 * Normalise the specified index to make sure it doesn't exceed the size of the board.
	 * @param index The index of the cell to normalise.
	 * @return the normalised index
	 */
	public int normalise(int index) {
		return 0;
	}
	
	/**
	 * Gets the cell at the specified index.
	 * @param index The index of the cell to get.
	 * @return the cell at the specified index
	 */
	public Cell getCell(int index) {
		return null;
	}
}
