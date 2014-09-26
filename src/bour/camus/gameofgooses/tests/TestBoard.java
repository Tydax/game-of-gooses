package bour.camus.gameofgooses.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bour.camus.gameofgooses.models.Board;

/**
 * Test class for the {@link Board} class.
 * @author Armand BOUR
 *
 */
public class TestBoard {

	private Board mBoard;
	
	@Before
	public void initialiseBoard() {
		mBoard = new Board(63);
	}
	
	@Test
	public void testBoard() {
		// TODO: Implement test for Board constructor
		fail("Not implemented");
	}
	
	@Test
	public void testNormalise() {
		assertEquals(12, mBoard.normalise(12));
		assertEquals(59, mBoard.normalise(65));
	}

	@Test
	public void testGetCell() {
		fail("Not yet implemented");
	}

}
