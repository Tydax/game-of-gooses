package bour.camus.gameofgooses.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bour.camus.gameofgooses.models.Board;
import bour.camus.gameofgooses.models.cells.DepartureCell;
import bour.camus.gameofgooses.models.cells.GooseCell;
import bour.camus.gameofgooses.models.cells.NormalCell;
import bour.camus.gameofgooses.models.cells.TeleportCell;
import bour.camus.gameofgooses.models.cells.WaitCell;

/**
 * Test class for the {@link Board} class.
 * @author Armand BOUR
 * @author Tristan CAMUS
 */
public class TestBoard {

	private Board mBoard;
	
	@Before
	public void initialiseBoard() {
		mBoard = new Board("boardTest.txt");
	}
	
	@Test
	public void testBoard() {
		assertEquals(new DepartureCell(), mBoard.getCell(0));
		assertEquals(new NormalCell(1), mBoard.getCell(1));
		assertEquals(new GooseCell(2), mBoard.getCell(2));
		assertEquals(new WaitCell(3,1), mBoard.getCell(3));
		assertEquals(new TeleportCell(4,1), mBoard.getCell(4));
		assertEquals(new NormalCell(5), mBoard.getCell(5));		
	}
	
	@Test
	public void testNormalise() {
		assertEquals(12, mBoard.normalise(12));
		assertEquals(59, mBoard.normalise(65));
	}

	@Test
	public void testGetCell() {
		assertEquals(new TeleportCell(4,1), mBoard.getCell(4));
	}

}
