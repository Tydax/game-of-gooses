package bour.camus.gameofgooses.models.cells;

import bour.camus.gameofgooses.models.Player;

/**
 * WaitCell represents a type of cell where the {@link Player} has to wait a specific amount of time
 * before being able to play again.
 * @author Armand BOUR
 *
 */
public class WaitCell extends AbstractCell {

	/** Constant representing the total number of turns a player has to wait before being able
	 * to play again. */
	private final int mWaitingTime;
	
	/** Integer representing the number of turns left the currently retained player has to wait before being
	 * able to play again.
	 */
	private int mTimeLeft;
	
	/**
	 * Constructor taking two parameters to initialise a WaitCell.
	 * @param index The index of the cell in the board (starting at 0).
	 * @param time The number of turns the Player has to wait before being able to play again.
	 */
	
	public WaitCell(int index, int time) {
		this.mIndex = index;
		this.mWaitingTime = time;
		this.mTimeLeft = time;
	}

	/**
	 * Gets the total number of turns a player has to wait upon arrival.
	 * @return The total number of turns a play has to wait.
	 */
	
	public int getTotalWaitingTime() {
		return this.mWaitingTime;
	}
	
	/**
	 * Gets the number of turns left for the player currently retained in the cell before being
	 * able to play again.
	 * @return The number of turns left.
	 */
	
	public int getTimeLeft() {
		return this.mTimeLeft;
	}
	
	@Override
	public boolean canBeLeftNow() {
		return true;
	}
	
	@Override
	public int handleMove(int diceThrow) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void welcome(Player p) {
		
	}
}