package bour.camus.gameofgooses.models;

import bour.camus.gameofgooses.models.cells.ICell;

/**
 * This class represents a player in the game with its goose.
 * @author Armand BOUR
 *
 */
public class Player {
	
	/** Reference to the {@link ICell} containing this Player. */
	private ICell mCell;
	
	/** The Player's name. */
	private String mName;
	
	/**
	 * Constructor with one parameter.
	 * @param name The name of the Player.
	 */
	public Player(String name) {
		this.mName = name;
	}
	
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
	public ICell getCell() {
		return mCell;
	}
	
	/**
	 * Move the player to the specified cell.
	 * @param cell The cell where the player should be moved.
	 */
	public void setCell(ICell cell) {
		this.mCell = cell;
	}
	
	/**
	 * Gets the player's name.
	 * @return The player's name.
	 */
	public String getName() {
		return this.mName;
	}
}
