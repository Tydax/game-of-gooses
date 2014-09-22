package bour.camus.gameofgooses.models;

import bour.camus.gameofgooses.models.cells.ICell;

/** The Board class represents the board of the {@link Game}. It contains all the {@link ICell}
 * used to play.
 * 
 * @author Armand BOUR
 *
 */
public class Board {
	
	/** Array containing all the cells of the board. */
	private final ICell[] mCells;

	public Board(int size) {
		mCells = new ICell[size];
	}
	
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
	public ICell getCell(int index) {
		return null;
	}
}
