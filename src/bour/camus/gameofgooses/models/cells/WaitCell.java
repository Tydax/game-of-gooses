package bour.camus.gameofgooses.models.cells;

import bour.camus.gameofgooses.models.Player;

/**
 * WaitCell represents a type of cell where the {@link Player} has to wait a specific amount of time
 * before being able to play again.
 * @author Armand BOUR
 * @author Tristan CAMUS
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
		if(this.mTimeLeft == 0) {
			return true;
		}
		else {
			this.mTimeLeft --;
			return false;
		}
	}
	
	@Override
	public int handleMove(int diceThrow) {
		return this.mIndex;
	}

	@Override
	public void welcome(Player p) {
		this.mPlayer = p;
		// Reset the number of turns to wait.
		this.mTimeLeft = this.mWaitingTime;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof WaitCell))
			return false;
		WaitCell other = (WaitCell) obj;
		if (mTimeLeft != other.mTimeLeft)
			return false;
		if (mWaitingTime != other.mWaitingTime)
			return false;
		return true;
	}
}
