package bour.camus.gameofgooses.models;

import bour.camus.gameofgooses.models.cells.ICell;

/**
 * This class represents a player in the game with its goose.
 * @author Armand BOUR
 * @author Tristan CAMUS	
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
		return (int) (Math.random() * 5 + 1);
	}
	
	/**
	 * Gets the cell in which the player is.
	 * @return A reference to the cell in which the player is.
	 * 		  <code>null</code> if the Players is not placed on the {@link Board}.
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (mName == null) {
			if (other.mName != null)
				return false;
		} else if (!mName.equals(other.mName))
			return false;
		return true;
	}
}
