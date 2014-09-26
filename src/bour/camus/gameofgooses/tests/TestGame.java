package bour.camus.gameofgooses.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bour.camus.gameofgooses.models.Board;
import bour.camus.gameofgooses.models.Game;
import bour.camus.gameofgooses.models.Player;
import bour.camus.gameofgooses.models.cells.ICell;
import bour.camus.gameofgooses.models.cells.TrapCell;

public class TestGame {

	private Game mGame;
	
	@Before
	public void instantiateFields() {
		this.mGame = new Game("defaultBoard", "Sherlock", "Watson", "Moriarty", "Lestrade");
	}
	
	@Test
	public void testGame() {
		assertEquals(new Player("Sherlock"), this.mGame.nextPlayer());
		assertEquals(new Player("Watson"), this.mGame.nextPlayer());
		assertEquals(new Player("Moriarty"), this.mGame.nextPlayer());
		assertEquals(new Player("Lestrade"), this.mGame.nextPlayer());
	}
	
	@Test
	public void testIsFinishedPlayerReachedFinalCell() {
		assertFalse(this.mGame.isFinished());
		
		// Put a player in the final cell.
		final Board board = this.mGame.getBoard();
		final Player player = this.mGame.nextPlayer();
		final ICell finalCell = board.getCell(board.getSize() - 1);
		
		finalCell.welcome(player);
		player.setCell(finalCell);
		
		// Game must be finished.
		assertTrue(this.mGame.isFinished());
		
		finalCell.empty();
	}

	@Test
	public void testIsFinishedAllPlayersAreTrapped() {
		final Board board = this.mGame.getBoard();
		
		// Browse through the board to get trap cells and put Players in them
		int nbPlayersTrapped = 0;
		for(int i=0 ; i < board.getSize() && nbPlayersTrapped < 5; i++) {
			ICell c = board.getCell(i);
			
			if(c instanceof TrapCell && !c.isBusy()) {
				c.welcome(this.mGame.nextPlayer());
				nbPlayersTrapped++;
			}
		}
		
		assertTrue(this.mGame.isFinished());
	}
	
	@Test
	public void testNextPlayer() {
		assertEquals(new Player("Sherlock"), this.mGame.nextPlayer());
		assertEquals(new Player("Watson"), this.mGame.nextPlayer());
		assertEquals(new Player("Moriarty"), this.mGame.nextPlayer());
		assertEquals(new Player("Lestrade"), this.mGame.nextPlayer());
		
		assertEquals(new Player("Sherlock"), this.mGame.nextPlayer());
	}

}
