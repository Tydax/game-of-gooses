package bour.camus.gameofgooses.models.cells;

/**
 * GooseCell represents a cell allowing the {@link Player} to move again by the score
 * of the die.
 * @author Armand BOUR
 *
 */
public class GooseCell extends AbstractCell {

	@Override
	public int handleMove(int diceThrow) {
		return this.mIndex + diceThrow;
	}

}
