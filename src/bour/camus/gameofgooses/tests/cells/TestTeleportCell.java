package bour.camus.gameofgooses.tests.cells;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bour.camus.gameofgooses.models.cells.TeleportCell;

public class TestTeleportCell {

	private TeleportCell mCell;
	
	@Before
	public void instantiateFields() {
		this.mCell = new TeleportCell(1, 3);
	}
	
	@Test
	public void testHandleMove() {
		assertEquals(3, this.mCell.getDestination());
	}
}
