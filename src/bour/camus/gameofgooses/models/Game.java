package bour.camus.gameofgooses.models;

import bour.camus.gameofgooses.ui.ConsoleUI;
import bour.camus.gameofgooses.ui.IGameWatcher;

/**
 * The Game class represents a game of the goose.
 * @author Armand BOUR
 * 
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
	
	/**
	 * Constructor initialising the players in {@link #mPlayers}.
	 */
	public Game() {
		this.mInterface = new ConsoleUI();
		
		// Call interface to get the names
		String[] names = this.mInterface.initialisePlayers();
		
		// Instantiate each player
		this.mPlayers = new Player[names.length];
		for(int i=0 ; i < this.mPlayers.length ; i++) {
			this.mPlayers[i] = new Player(names[i]);
		}
	}
	
	/**
	 * Starts the loop of a game of the goose. 
	 */
	public void play() {
		
	}
	
	/**
	 * Checks whether the current game is finished or not.
	 * @return <code>true</code> if the game is finished ;
	 * 		   <code>false</code> else.
	 */
	
	public boolean isFinished() {
		return true;
	}
	
	/**
	 * Gets the player whose turn is is.
	 * @return The player whose turn it is.
	 */
	
	public Player nextPlayer() {
		return null;
	}
}
