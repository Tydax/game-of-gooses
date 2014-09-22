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
	 * Method called when changing turns.
	 * @param player The player whose turn it is.
	 */
	
	public abstract void onPlayerTurn(Player player);
	
	
	/**
	 * Method called when the {@link Player} throws the dice.
	 * @param player The player throwing the dice.
	 * @param die1 The score of the first die.
	 * @param die2 The score of the second die.
	 */
	
	public abstract void onPlayerThrowDice(Player player, int die1, int die2);
	
	/**
	 * Method called when the {@link Player} moves his goose.
	 * @param player The player moving.
	 * @param cell The cell the player is moving to.
	 */
	public abstract void onPlayerMove(Player player, ICell cell);
	
	/**
	 * Method called when two players swap their gooses.
	 * @param player1 The player arriving on the cell.
	 * @param cell1 The cell where the new player is arriving.
	 * @param player2 The player leaving the cell.
	 * @param cell2 The cell where the new player is coming from.
	 */
	
	public abstract void onPlayerSwap(Player player1, ICell cell1, Player player2, ICell cell2);
	
	/**
	 * Method called when the player arrives on a {@link GooseCell}.
	 * @param player The player arriving on the cell.
	 * @param cell The goose cell on which the player is arriving.
	 */
	
	public abstract void onPlayerGoose(Player player, GooseCell cell);
	
	/**
	 * Method called when the player is teleported (on a {@link TeleportCell}) to another cell.
	 * @param player The player arriving on the cell.
	 * @param cell The {@link TeleportCell} on which the player arrived.
	 * @param destination The destination {@link ICell}.
	 */
	
	public abstract void onPlayerTeleport(Player player, TeleportCell cell, ICell destination);
	
	/**
	 * Method called when the player is trapped in a {@link TrapCell}.
	 * @param player The trapped player.
	 * @param cell The {@link TrapCell} trapping the player.
	 */
	
	public abstract void onPlayerTrapped(Player player, TrapCell cell);
	
	/**
	 * Method called when the player is waiting in a {@link WaitCell} before being able to play.
	 * @param player The player waiting.
	 * @param cell The {@link WaitCell} where the player is waiting.
	 * @param turnLeft The number of turns that the player has to wait before being able to move
	 * again.
	 */
	
	public abstract void onPlayerWaiting(Player player, WaitCell cell, int turnLeft);
	
	/**
	 * Method called when the player arrives on the final cell and wins.
	 * @param player The winner!
	 */
	
	
	public abstract void onPlayerWin(Player player);
	
	/**
	 * Method called when all the players are trapped in a cell and the game is finished.
	 */
	public abstract void onPlayersAllTrapped();
}
