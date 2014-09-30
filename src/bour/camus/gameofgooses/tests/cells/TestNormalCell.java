package bour.camus.gameofgooses.tests.cells;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import bour.camus.gameofgooses.models.Player;
import bour.camus.gameofgooses.models.cells.ICell;
import bour.camus.gameofgooses.models.cells.NormalCell;

/**
 * Test class for {@link NormalCell} class.
 * @author Armand BOUR
 *
 */
public class TestNormalCell {

	private ICell mCell;
	private Player mPlayer;
	
	@Before
	public void instantiateCell() {
		// Initialise private fields
		this.mCell = new NormalCell(3);
		this.mPlayer = new Player("Sherlock");
	}
	
	@Test
	public void testHandleMove() {
		assertEquals(3, this.mCell.handleMove(5));
	}

	@Test
	public void testCanBeLeftNow() {
		assertTrue(this.mCell.canBeLeftNow());
	}

	@Test
	public void testIsRetaining() {
		assertFalse(this.mCell.isRetaining());
	}

	@Test
	public void testGetIndex() {
		assertEquals(3, this.mCell.getIndex());
	}

	@Test
	public void testIsBusy() {
		assertFalse(this.mCell.isBusy());
		
		// Set the player in the cell
		this.mCell.welcome(this.mPlayer);
		this.mPlayer.setCell(this.mCell);
		
		assertTrue(this.mCell.isBusy());
	}

	@Test
	public void testGetPlayer() {
		assertEquals(new Player("Sherlock"), this.mPlayer);
	}

	@Test
	public void testWelcome() {
		this.mCell.welcome(this.mPlayer);
		assertEquals(this.mPlayer, this.mCell.getPlayer());
	}

}
