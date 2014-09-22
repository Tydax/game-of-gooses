package bour.camus.gameofgooses.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import bour.camus.gameofgooses.models.Player;
import bour.camus.gameofgooses.models.cells.NormalCell;

public class TestPlayer {

	@Test
	public void testThrowDie() {
		Player p = new Player("player1");
		int die = p.throwDie();
		assertTrue(die > 0 && die < 7);
	}

	@Test
	public void testGetCell() {
		Player p = new Player("player1");
		NormalCell c = new NormalCell(21);
		p.setCell(c);
		assertEquals(c, p.getCell());
	}

	@Test
	public void testSetCell() {
		Player p = new Player("player1");
		NormalCell c = new NormalCell(21);
		p.setCell(c);
		assertEquals(c, p.getCell());
	}

}
