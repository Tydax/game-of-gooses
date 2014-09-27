package bour.camus.gameofgooses.models.cells;

import bour.camus.gameofgooses.models.Player;

/**
 * TeleportCell represents a cell where the {@link Player} is teleported to another cell upon arrival.
 * @author Armand BOUR
 * @author Tristan CAMUS
 */
public class TeleportCell extends AbstractCell {
	
	/** The index of the destination case where the Player must be teleported. */
	private int mDest;
	
	/**
	 * Constructor using two parameters.
	 * @param index The index of the TeleportCell.
	 * @param dest The index of the destination cell where the player should be sent.
	 */
	
	public TeleportCell(int index, int dest) {
		this.mIndex = index;
		this.mDest = dest;
	}
	
	@Override
	public int handleMove(int diceThrow) {
		return this.mDest;
	}
	
	/**
	 * Gets the index of the destination cell.
	 * @return the index of the cell where the player should be sent.
	 */
	public int getDestination() {
		return this.mDest;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof TeleportCell))
			return false;
		TeleportCell other = (TeleportCell) obj;
		if (mDest != other.mDest)
			return false;
		return true;
	}
}
