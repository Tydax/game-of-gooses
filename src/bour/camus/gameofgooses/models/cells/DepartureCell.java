package bour.camus.gameofgooses.models.cells;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import bour.camus.gameofgooses.models.Board;
import bour.camus.gameofgooses.models.Player;
import bour.camus.gameofgooses.ui.IGameWatcher;

/**
 * DepartureCell represents the first case of a {@link Board}. It is the only cell that can contain
 * several {@link Player}s.
 * @author Armand BOUR
 * @author Tristan CAMUS
 */
public class DepartureCell implements ICell {

	private final LinkedList<Player> mPlayers;
	
	public DepartureCell(Player ... players) {
		this.mPlayers = new LinkedList<Player>(Arrays.asList(players));
	}
	
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
		return 0;
	}

	@Override
	public int handleMove(int diceThrow) {
		return diceThrow;
	}

	@Override
	public boolean isBusy() {
		return !this.mPlayers.isEmpty();
	}

	/**
	 * Gets the first {@link Player} in {@link #mPlayers}, corresponding to the first player
	 * to leave the cell.
	 * @return The first player to leave the cell.
	 */
	@Override
	public Player getPlayer() {
		return this.mPlayers.getFirst();
	}

	/**
	 * Adds the specified {@link Player} at the end of the queue.
	 * @param player The player to add.
	 */
	@Override
	public void welcome(Player player) {
		this.mPlayers.add(player);
	}

	/**
	 * Remove the first {@link Player} in the list, and return it.
	 * @return The removed Player, which is the first to leave the cell.
	 * 			<code>null</code> if the list is empty.
	 */
	@Override
	public Player empty() {
		try {
			return this.mPlayers.removeFirst();
		}
		catch(NoSuchElementException nseExc) {
			return null;
		}
	}

	/**
	 * Gets the number of {@link Player}s in the cell.
	 * @return The number of players currently in the cell.
	 */
	public int getNumberOfPlayers() {
		return this.mPlayers.size();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DepartureCell))
			return false;
		DepartureCell other = (DepartureCell) obj;
		if (mPlayers == null) {
			if (other.mPlayers != null)
				return false;
		} else if (!mPlayers.equals(other.mPlayers))
			return false;
		return true;
	}
	
	@Override
	public void noticeUIOfTypeOfCell(Player player, IGameWatcher ui) {
		// Nothing to do here
	}
}
