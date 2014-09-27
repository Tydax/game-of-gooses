package bour.camus.gameofgooses.models.cells;

import bour.camus.gameofgooses.models.Player;

/**
 * TrapCell represents a cell in which the {@link Player} is trapped, and can't play until someone replaces him
 * in the case.
 * @author Armand BOUR
 *
 */
public class TrapCell extends AbstractCell {

	/**
	 * Constructor taking one parameter.
	 * @param index The index of the cell.
	 */
	public TrapCell(int index) {
		this.mIndex = index;
	}
	
	@Override
	public boolean canBeLeftNow() {
		return false;
	}
	
	@Override
	public int handleMove(int diceThrow) {
		return this.mIndex;
	}
}
