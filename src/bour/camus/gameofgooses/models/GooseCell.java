package bour.camus.gameofgooses.models;

public class GooseCell extends AbstractCell {

	@Override
	public int handleMove(int diceThrow) {
		return this.mIndex + diceThrow;
	}

}
