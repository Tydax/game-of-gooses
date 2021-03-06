package bour.camus.gameofgooses.models.cells;

import bour.camus.gameofgooses.models.Board;
import bour.camus.gameofgooses.models.Player;
import bour.camus.gameofgooses.ui.IGameWatcher;

/**
 * AbstractCell represents a basic cell, and allows to avoid duplicating code.
 * @author Armand BOUR
 * @author Tristan CAMUS
 */
public abstract class AbstractCell implements ICell {

	/** The index of the cell in the {@link Board}. */
	protected int mIndex;
	
	/** Reference to the {@link Player} contained by the cell. */
	protected Player mPlayer;
	
	@Override
	public boolean canBeLeftNow() {
		return true;
	}

	@Override
	public boolean isRetaining() {
		return false;
	}

	@Override
	public int getIndex() {
		return this.mIndex;
	}

	@Override
	public boolean isBusy() {
		return (this.mPlayer != null);
	}

	@Override
	public Player getPlayer() {
		return this.mPlayer;
	}

	@Override
	public void welcome(Player player) {
		this.mPlayer = player;
	}

	@Override
	public Player empty() {
		Player player = this.mPlayer;
		this.mPlayer = null;
		return player;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AbstractCell))
			return false;
		AbstractCell other = (AbstractCell) obj;
		if (mIndex != other.mIndex)
			return false;
		if (mPlayer == null) {
			if (other.mPlayer != null)
				return false;
		} else if (!mPlayer.equals(other.mPlayer))
			return false;
		return true;
	}
	
	@Override
	public void noticeUIOfTypeOfCell(Player player, IGameWatcher ui) {
		// Nothing to do here
	}
}
