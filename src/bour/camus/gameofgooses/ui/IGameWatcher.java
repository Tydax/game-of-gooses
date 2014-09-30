package bour.camus.gameofgooses.ui;

import bour.camus.gameofgooses.models.Player;
import bour.camus.gameofgooses.models.cells.GooseCell;
import bour.camus.gameofgooses.models.cells.ICell;
import bour.camus.gameofgooses.models.cells.TeleportCell;
import bour.camus.gameofgooses.models.cells.TrapCell;
import bour.camus.gameofgooses.models.cells.WaitCell;

/**
 * IGameWatcher allows a class to receive informations about the run of a game. Each method
 * is called upon certain events. By implementing this interface, you can create your own
 * interface for the game.
 * @author Armand BOUR
 *
 */

public interface IGameWatcher {

	
	/**
	 * Method called to initialise players and get the players' name.
	 * @return A Collection containing all the players' name.
	 */
	public String[] initialisePlayers();
	
	/**
	 * Method called when the game starts.
	 */
	
	public void onGameStart();
	
	/**
	 * Method called when changing turns.
	 * @param player The player whose turn it is.
	 */
	
	public void onPlayerTurn(Player player);
	
	
	/**
	 * Method called when the {@link Player} throws the dice.
	 * @param player The player throwing the dice.
	 * @param die1 The score of the first die.
	 * @param die2 The score of the second die.
	 */
	
	public void onPlayerThrowDice(Player player, int die1, int die2);
	
	/**
	 * Method called when the {@link Player} moves his goose.
	 * @param player The player moving.
	 * @param cell The cell the player is moving to.
	 */
	public void onPlayerMove(Player player, ICell cell);
	
	/**
	 * Method called when two players swap their gooses.
	 * @param playerArriving The player arriving on the cell.
	 * @param cellFrom The cell where the new player (playerArriving) is coming from.
	 * @param playerOccupying The player occupying the cell, and about to leave.
	 * @param cellTo The cell where the new player is arriving, already occupied by playerOccupying.
	 */
	
	public void onPlayerSwap(Player playerArriving, ICell cellFrom, Player playerOccupying, ICell cellTo);
	
	/**
	 * Method called when the player arrives on a {@link GooseCell}.
	 * @param player The player arriving on the cell.
	 * @param cell The goose cell on which the player is arriving.
	 */
	
	public void onPlayerGoose(Player player, GooseCell cell);
	
	/**
	 * Method called when the player is teleported (on a {@link TeleportCell}) to another cell.
	 * @param player The player arriving on the cell.
	 * @param cell The {@link TeleportCell} on which the player arrived.
	 * @param destination The destination {@link ICell}.
	 */
	
	public void onPlayerTeleport(Player player, TeleportCell cell, int destination);
	
	/**
	 * Method called when the player is trapped in a {@link TrapCell}.
	 * @param player The trapped player.
	 * @param cell The {@link TrapCell} trapping the player.
	 */
	
	public void onPlayerTrapped(Player player, TrapCell cell);
	
	/**
	 * Method called when the player is waiting in a {@link WaitCell} before being able to play.
	 * @param player The player waiting.
	 * @param cell The {@link WaitCell} where the player is waiting.
	 * @param turnLeft The number of turns that the player has to wait before being able to move
	 * again.
	 */
	
	public void onPlayerWaiting(Player player, WaitCell cell, int turnLeft);
	
	/**
	 * Method called when the player arrives on the final cell and wins.
	 * @param player The winner!
	 */
	
	public void onPlayerWin(Player player);
	
	/**
	 * Method called when all the players are trapped in a cell and the game is finished.
	 */
	public void onPlayersAllTrapped();
}
