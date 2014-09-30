package bour.camus.gameofgooses.ui;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

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
	public String[] initialisePlayers() {
		int nbPlayers;
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("\n");
		
		// Wait for an appropriate number of players
		do {
			// Ask for the number of players
			System.out.print("Number of players (2-6): ");
			
			// Wait for a number and store it
			if(scan.hasNextInt()) {
				nbPlayers = scan.nextInt();
			}
			else {
				nbPlayers = 0;
				scan.next();
			}
		} while (nbPlayers < 2 || nbPlayers > 6);
		
		
		String[] names = new String[nbPlayers];
		
		for(int i=0 ; i < names.length ; i++) {
			// Keep asking for a name that is not in the array
			String name;
			do {
				int index = i + 1;
				// Ask for a name
				System.out.print("Name for Player " + index + ": ");
				
				// Wait for one
				name = scan.next();
			} while(Arrays.asList(names).contains(name));
			
			// Store it
			names[i] = name;
		}
		scan.close();
		return names;
	}
	
	@Override
	public void onGameStart() {
		System.out.println("Game is starting! Let's play!");
	}

	@Override
	public void onPlayerTurn(Player player) {
		System.out.println();
		System.out.println("** " + player.getName() + " (cell " +
				player.getCell().getIndex() +"), it's your turn! **");
		
		// Wait for the user to press enter to continue
		/*
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		} */
	}

	@Override
	public void onPlayerThrowDice(Player player, int die1, int die2) {
		int sum = die1 + die2;
		System.out.println(player.getName() + " throws the dice. Gets " + die1 + " and "
				+ die2 + ", " + sum + ".");

	}

	@Override
	public void onPlayerMove(Player player, ICell cell) {
		System.out.println(player.getName() + " moves to cell " + cell.getIndex() + ".");
	}

	@Override
	public void onPlayerSwap(Player playerArriving, ICell cellFrom, Player playerOccupying,
			ICell cellTo) {
		System.out.println("Cell " + cellTo.getIndex() + " is occupied by " + playerOccupying.getName() + "!");
		System.out.println(playerOccupying.getName() + " is sent to cell " + cellFrom.getIndex() + ".");
	}

	@Override
	public void onPlayerGoose(Player player, GooseCell cell) {
		System.out.println("Goose cell! " + player.getName() + " moves again!");
	}

	@Override
	public void onPlayerTeleport(Player player, TeleportCell cell,
			int destination) {
		System.out.println("Teleport cell! " + player.getName() + " is teleported to cell "
			+ destination + ".");
	}

	@Override
	public void onPlayerTrapped(Player player, TrapCell cell) {
		System.out.println(player.getName() + " is trapped! He cannot move!");
	}

	@Override
	public void onPlayerWaiting(Player player, WaitCell cell, int turnLeft) {
		System.out.println("Wait cell! " + player.getName() + " has to wait " + turnLeft + " turn"
				+ (turnLeft > 1
				  ? "s."
				  : ".")
				);
	}

	@Override
	public void onPlayerWin(Player player) {
		System.out.println(player.getName() + " wins!! Congratulations!!");
	}

	@Override
	public void onPlayersAllTrapped() {
		System.out.println("All players are trapped! The game is over!");
	}
}
