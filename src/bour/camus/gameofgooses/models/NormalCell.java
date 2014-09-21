package bour.camus.gameofgooses.models;

/**
 * NormalCell represents a basic cell with absolutely no special effect.
 * @author Armand BOUR
 *
 */
public class NormalCell extends AbstractCell {

	/**
	 * Constructor with the index. Creates a normal cell containing no player.
	 * @param index The index of the cell.
	 */

	public NormalCell(int index) {
		this.mIndex = index;
	}
	
	@Override
	public int handleMove(int diceThrow) {
		return this.mIndex;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof NormalCell) {
			NormalCell cell = (NormalCell) o;
			
			return cell.mIndex == this.mIndex;
		}
		
		return false;
	}
}
