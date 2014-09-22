package bour.camus.gameofgooses.ui;

import bour.camus.gameofgooses.models.Player;
import bour.camus.gameofgooses.models.cells.GooseCell;
import bour.camus.gameofgooses.models.cells.ICell;
import bour.camus.gameofgooses.models.cells.TeleportCell;
import bour.camus.gameofgooses.models.cells.TrapCell;
import bour.camus.gameofgooses.models.cells.WaitCell;

/**
 * Class representing an "interface" using the console to display information.
 * @author Armand BOUR
 *
 */

public class ConsoleUI implements IGameWatcher {

	@Override
	public void onPlayerTurn(Player player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPlayerThrowDice(Player player, int die1, int die2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPlayerMove(Player player, ICell cell) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPlayerSwap(Player player1, ICell cell1, Player player2,
			ICell cell2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPlayerGoose(Player player, GooseCell cell) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPlayerTeleport(Player player, TeleportCell cell,
			ICell destination) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPlayerTrapped(Player player, TrapCell cell) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPlayerWaiting(Player player, WaitCell cell, int turnLeft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPlayerWin(Player player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPlayersAllTrapped() {
		// TODO Auto-generated method stub

	}


}
