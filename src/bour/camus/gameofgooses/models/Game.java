package bour.camus.gameofgooses.models;

import java.security.InvalidParameterException;

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
	 * Constructor initialising the players through the {@link IGameWatcher#initialisePlayers()} method.
	 * Uses the default board.
	 * @param ui The class implementing {@link IGameWatcher}.
	 */
	
	public Game(IGameWatcher ui) {
		this("defaultboard", ui.initialisePlayers());
	}
	
	/**
	 * Constructor initialising the players through the {@link IGameWatcher#initialisePlayers()} method.
	 * Uses the specified file as a model for the {@link Board}.
	 * @param ui The class implementing {@link IGameWatcher}.
	 * @param boardModel The name of the file to use as a model for the board.
	 */
	
	public Game(IGameWatcher ui, String boardModel) {
		this(boardModel, ui.initialisePlayers());
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
}
