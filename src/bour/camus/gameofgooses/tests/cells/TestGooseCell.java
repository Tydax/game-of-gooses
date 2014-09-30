package bour.camus.gameofgooses.tests.cells;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bour.camus.gameofgooses.models.cells.GooseCell;

public class TestGooseCell {

	private GooseCell mCell;
	
	@Before
	public void instantiateFields() {
		this.mCell = new GooseCell(3);
	}
	
	@Test
	public void testHandleMove() {
		assertEquals(10, this.mCell.handleMove(7));
	}

}
