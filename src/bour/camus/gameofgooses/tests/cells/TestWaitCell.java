package bour.camus.gameofgooses.tests.cells;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bour.camus.gameofgooses.models.Player;
import bour.camus.gameofgooses.models.cells.WaitCell;

public class TestWaitCell {

	private WaitCell mCell;
	private Player mPlayer;
	
	@Before
	public void instantiateCell() {
		this.mCell = new WaitCell(2, 1);
		this.mPlayer = new Player("Sherlock");

		this.mCell.welcome(this.mPlayer);
	}
	
	@Test
	public void testCanBeLeftNow() {
		// Simulate a turn
		assertFalse(this.mCell.canBeLeftNow());
		
		// Now the cell can be left.
		assertTrue(this.mCell.canBeLeftNow());
	}

	@Test
	public void testWelcome() {
		assertEquals(1, this.mCell.getTimeLeft());
		
		// Simulate a turn
		this.mCell.canBeLeftNow();
		
		assertEquals(0, this.mCell.getTimeLeft());
	}

	@Test
	public void testHandleMove() {
		// TODO: implement this test
		fail("Not yet implemented");
	}

}
