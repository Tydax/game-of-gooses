package bour.camus.gameofgooses.models.cells;

import bour.camus.gameofgooses.models.Player;
import bour.camus.gameofgooses.ui.IGameWatcher;

/**
 * GooseCell represents a cell allowing the {@link Player} to move again by the score
 * of the die.
 * @author Armand BOUR
 * @author Tristan CAMUS
 */
public class GooseCell extends AbstractCell {

	/**
	 * Constructor taking one parameter.
	 * @param index The index of the cell in the board (starting with 0).
	 */
	
	public GooseCell(int index) {
		this.mIndex = index;
	}
	
	@Override
	public int handleMove(int diceThrow) {
		return this.mIndex + diceThrow;
	}
	
	@Override
	public void noticeUIOfTypeOfCell(Player player, IGameWatcher ui) {
		ui.onPlayerGoose(player, this);
	}
}
