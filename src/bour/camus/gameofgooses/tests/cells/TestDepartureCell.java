package bour.camus.gameofgooses.tests.cells;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bour.camus.gameofgooses.models.Player;
import bour.camus.gameofgooses.models.cells.DepartureCell;

public class TestDepartureCell {

	private DepartureCell mCell;
	
	@Before
	public void initialiseFields() {
		this.mCell = new DepartureCell(new Player("Sherlock"),
									   new Player("Watson"),
									   new Player("Moriarty"));
	}
	
	@Test
	public void testGetPlayer() {
		assertEquals(new Player("Sherlock"), this.mCell.getPlayer());
	}

	@Test
	public void testWelcome() {
		assertEquals(3, this.mCell.getNumberOfPlayers());
		
		this.mCell.welcome(new Player("Lestrade"));
		
		assertEquals(4, this.mCell.getNumberOfPlayers());
	}

	@Test
	public void testEmpty() {
		assertEquals(new Player("Sherlock"), this.mCell.empty());
		assertEquals(new Player("Watson"), this.mCell.empty());
		assertEquals(new Player("Moriarty"), this.mCell.empty());
		assertNull(this.mCell.empty());
	}
}
