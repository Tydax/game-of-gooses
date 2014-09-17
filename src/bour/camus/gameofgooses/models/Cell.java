package bour.camus.gameofgooses.models;

/** Interface for the cells of the goose game..
 * 
 * @author Armand BOUR
 *
 */

public interface Cell {
	
	/**
	 * Indicates if a player occupying this cell can, at this turn, leave the cell.
	 * @return <code>true</code> if the player in this cell can freely leaves the
	 * 		   cell at this turn ;
	 * 		   <code>false</code> else.
	 */
	public boolean canBeLeftNow();
	
	/**
	 * Indicates if a cell holds a player until another player reaches the same cell.
	 * @return <code>true</code> if the only way for a player to get out of this cell is for another
	 * 		   another player to replace him ;
	 * 		   <code>false</code> else.
	 */
	public boolean isRetaining();
	
	/**
	 * Gets the position of this cell in the board.
	 * @return a number greater or equal to 0 (for the starting cell only).
	 */
	
	public int getIndex();
	
	/**
	 * Returns the index of the cell actually reached by a {@link Player} when he reaches
	 * this cell. For normal cells, the returned value equals {@link #getIndex()} and is
	 * thus independent from <code>diceThrow</code>.
	 * @param diceThrow The result of the dice when the player reaches this cell.
	 * @return The index of the cell effectively reached when a player reaches this cell
	 * 		   after the given throw of dice.
	 */
	
	public int handleMove(int diceThrow);
	
	/**
	 * Indicates if a player currently occupies this cell.
	 * @return <code>true</code> if a player is in this cell ;
	 *         <code>false</code> else.
	 */
	public boolean isBusy();
	
	/**
	 * Returns the {@link Player} currently occupying this cell.
	 * @return The player currently in this cell, <code>null</code> if none.
	 */
	public Player getPlayer();
	
	/**
	 * Welcomes the {@link Player}. This method is called when a new Player arrives on
	 * the cell.
	 * @param player The newcoming Player.
	 */
	public void welcome(Player player);
}
