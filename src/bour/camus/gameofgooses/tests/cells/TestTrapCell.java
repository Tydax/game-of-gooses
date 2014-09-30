package bour.camus.gameofgooses.tests.cells;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bour.camus.gameofgooses.models.cells.TrapCell;

public class TestTrapCell {

	private TrapCell mCell;
	
	@Before
	public void instantiateFields() {
		this.mCell = new TrapCell(3);
	}
	
	@Test
	public void testCanBeLeftNow() {
		assertFalse(this.mCell.canBeLeftNow());
	}

	@Test
	public void testHandleMove() {
		assertEquals(3, this.mCell.handleMove(4));
	}

}
