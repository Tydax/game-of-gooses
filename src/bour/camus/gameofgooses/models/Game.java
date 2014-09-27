package bour.camus.gameofgooses.models;

import java.security.InvalidParameterException;

import bour.camus.gameofgooses.models.cells.GooseCell;
import bour.camus.gameofgooses.models.cells.ICell;
import bour.camus.gameofgooses.models.cells.TeleportCell;
import bour.camus.gameofgooses.models.cells.TrapCell;
import bour.camus.gameofgooses.models.cells.WaitCell;
import bour.camus.gameofgooses.ui.ConsoleUI;
import bour.camus.gameofgooses.ui.IGameWatcher;

/**
 * The Game class represents a game of the goose.
 * @author Armand BOUR
 * @author Tristan CAMUS
 */
public class Game {
	
	/** Reference to a class implementing {@link IGameWatcher} used to send information
	 * to the user interface.
	 */
	private IGameWatcher mInterface;
	
	/** Reference to the {@link Board} containing the cells. */
	private Board mBoard;
	
	/** Array containing all the players. */
	private final Player[] mPlayers;
	
	/** The index of the next player to play. */
	private int mNextPlayerIndex;
	
	/**
	 * Exchange positions of two players from 2 cells
	 * @param c1 the cell on which is the first player.
	 * @param c2 the cell on which is the second player.
	 */
	
	private void swapPlayers(ICell c1, ICell c2) {
		this.mInterface.onPlayerSwap(c1.getPlayer(), c1, c2.getPlayer(), c2);
		Player p = c2.getPlayer();
		c2.welcome(c1.getPlayer());
		c1.welcome(p);
	}
	
	/**
	 * Constructor initialising the players through the {@link IGameWatcher#initialisePlayers()} method.
	 * Uses the default board.
	 * @param ui The class implementing {@link IGameWatcher}.
	 */
	
	public Game(IGameWatcher ui) {
		this("board.txt", ui.initialisePlayers());
		this.mInterface = ui;
	}
	
	/**
	 * Constructor initialising the players through the {@link IGameWatcher#initialisePlayers()} method.
	 * Uses the specified file as a model for the {@link Board}.
	 * @param ui The class implementing {@link IGameWatcher}.
	 * @param boardModel The name of the file to use as a model for the board.
	 */
	
	public Game(IGameWatcher ui, String boardModel) {
		this(boardModel, ui.initialisePlayers());
		this.mInterface = ui;
	}
	
	/**
	 * Constructor initialising the players in {@link #mPlayers} using the specified values.
	 * @param boardModel The name of the file to use as a model for the board.
	 * @param names The list of names (between 2 and 6).
	 */
	
	public Game(String boardModel, String ... names) {
		this.mBoard = new Board(boardModel);
		
		// Throw exception in case someone tries to break the rules.
		if(names.length < 2 || names.length > 6) {
			throw new InvalidParameterException("The number of players must be between 2 and 6.");
		}
		
		// Instantiate each player
		this.mPlayers = new Player[names.length];
		for(int i=0 ; i < this.mPlayers.length ; i++) {
			this.mPlayers[i] = new Player(names[i]);
			this.mBoard.getCell(0).welcome(this.mPlayers[i]);
			this.mPlayers[i].setCell(this.mBoard.getCell(0));
		}
		
		this.mNextPlayerIndex = 0;
	}
	
	/**
	 * Starts the loop of a game of the goose. 
	 */
	public void play() {
		while(!isFinished()) {
			// Select the next player to play
			Player player = nextPlayer();
			this.mInterface.onPlayerTurn(player);
			
			// Check if the player can leave
			final ICell currentCell = player.getCell();
			if(currentCell.canBeLeftNow()) {
				// Throw dice
				int die1 = player.throwDie(),
					die2 = player.throwDie(),
					diceScore = die1+ die2;
				this.mInterface.onPlayerThrowDice(player, die1, die2);
				
				int index = this.mBoard.normalise(currentCell.getIndex() + diceScore);
				ICell targetCell = this.mBoard.getCell(index);
				this.mInterface.onPlayerMove(player, targetCell);
				targetCell.noticeUIOfTypeOfCell(player, this.mInterface);
				
				int realIndex = this.mBoard.normalise(targetCell.handleMove(diceScore));
				targetCell = this.mBoard.getCell(realIndex);
				
				if(targetCell.isBusy()) {
					swapPlayers(targetCell, currentCell);
				}
				else {
					targetCell.welcome(player);
					currentCell.empty();
				}
				
				targetCell.noticeUIOfTypeOfCell(player, this.mInterface);
			}
			else { // if he can't, he's stuck in trap cell or wait cell, notice the interface
				if(currentCell instanceof TrapCell) {
					this.mInterface.onPlayerTrapped(player, (TrapCell) currentCell);
				}
				else if(currentCell instanceof WaitCell) {
					WaitCell waitCell = (WaitCell) currentCell;
					this.mInterface.onPlayerWaiting(player, waitCell, waitCell.getTimeLeft());
				}
			}
		}
	}

	/**
	 * Checks whether the current game is finished or not.
	 * @return <code>true</code> if the game is finished ;
	 * 		   <code>false</code> else.
	 */
	
	public boolean isFinished() {
		// Check if last cell is containing a player
		final ICell finalCell = this.mBoard.getCell(this.mBoard.getSize() - 1);
		if(finalCell.isBusy()) {
			// Notice the interface of the winner
			this.mInterface.onPlayerWin(finalCell.getPlayer());
			
			return true;
		}
		else {
			// Check if all players are in trap cells
			for(Player p : this.mPlayers) {
				if(!p.getCell().isRetaining()) {
					// A player is not in a trap cell, so the game is not finished
					return false;
				}
			}
			
			// All players are in trap cells, game is finished.
			return true;
		}
	}
	
	/**
	 * Gets the player whose turn is is.
	 * @return The player whose turn it is.
	 */
	
	public Player nextPlayer() {
		Player p = this.mPlayers[mNextPlayerIndex];
		
		// End of the array reached, let's reset the index.
		if(this.mNextPlayerIndex == this.mPlayers.length - 1) {
			this.mNextPlayerIndex = 0;
		}
		else {
			this.mNextPlayerIndex++;
		}
		
		return p;
	}
	
	/**
	 * Get the number of players in the game.
	 * @return The number of players currently playing.
	 */
	
	public int getNumberPlayers() {
		return this.mPlayers.length;
	}
	
	/**
	 * Gets the {@link Board} used by the current Game.
	 * @return A reference to the Board.
	 */
	public Board getBoard() {
		return this.mBoard;
	}
	
	public static void main(String[] args) {
		Game theGame = new Game(new ConsoleUI());
		theGame.play();
	}
}
