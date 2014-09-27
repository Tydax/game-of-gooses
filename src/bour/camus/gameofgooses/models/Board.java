package bour.camus.gameofgooses.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import bour.camus.gameofgooses.models.cells.DepartureCell;
import bour.camus.gameofgooses.models.cells.GooseCell;
import bour.camus.gameofgooses.models.cells.ICell;
import bour.camus.gameofgooses.models.cells.NormalCell;
import bour.camus.gameofgooses.models.cells.TeleportCell;
import bour.camus.gameofgooses.models.cells.TrapCell;
import bour.camus.gameofgooses.models.cells.WaitCell;

/** The Board class represents the board of the {@link Game}. It contains all the {@link ICell}
 * used to play.
 * 
 * @author Armand BOUR
 *
 */
public class Board {
	
	/** Array containing all the cells of the board. */
	private ICell[] mCells;

	public Board(String filename) {
		File file = new File(filename);
		Scanner in;
		try 
		{
			in = new Scanner(file);
			int nbLines = 0;
			
			// List containing each line of the file.
		    LinkedList<String> cellsList = new LinkedList<String>();
			
			while(in.hasNextLine())
			{
				cellsList.add(in.next());
				nbLines++;
			}
			nbLines += 2;
			
			mCells = new ICell[nbLines];
			mCells[0] = new DepartureCell();
			
			int i = 1;
			for (String cell : cellsList) {
				if(cell.matches("[0-2]|((3|4),[0-9]*)"))
				{
					switch (cell.charAt(0)) {
					case '0':
						mCells[i] = new NormalCell(i);
						break;
					
					case '1':
						mCells[i] = new GooseCell(i);
						break;
						
					case '2':
						mCells[i] = new TrapCell(i);
						break;
					
					case '3':
						mCells[i] = new WaitCell(i,Integer.parseInt(cell.substring(2)));
						break;
						
					case '4':
						if(Integer.parseInt(cell.substring(2))<=nbLines-1)
						{
							mCells[i] = new TeleportCell(i,Integer.parseInt(cell.substring(2)));
						}
						else
						{
							System.out.println(cell+" : Invalid destination.");
						}
						break;
	
					default:
						break;
					}
				}
				else
				{
					System.out.println(cell+" : Invalid syntax.");
				}
				i++;
			}
			mCells[nbLines-1] = new NormalCell(nbLines-1);
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("File not found.");
		}
	}
	
	/**
	 * Normalise the specified index to make sure it doesn't exceed the size of the board.
	 * @param index The index of the cell to normalise.
	 * @return the normalised index
	 */
	public int normalise(int index) {
		return 0;
	}
	
	/**
	 * Gets the cell at the specified index.
	 * @param index The index of the cell to get.
	 * @return the cell at the specified index
	 */
	public ICell getCell(int index) {
		return null;
	}
	
	/**
	 * Gets the number of cells in the Board.
	 * @return The number of cells.
	 */
	
	public int getSize() {
		return this.mCells.length;
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < mCells.length; i++) {
			s += i+" : "+mCells[i].getClass().getSimpleName();
			
			if(mCells[i] instanceof WaitCell)
			{
				s += " : "+((WaitCell) mCells[i]).getTimeLeft();
			}
			else if(mCells[i] instanceof TeleportCell)
			{
				s += " -> "+((TeleportCell) mCells[i]).getDestination();
			}
			if(i<mCells.length-1)
			{
				s += "\n";
			}
			else
			{
				s += " : End";
			}
				
		}
		return s;
	}
	
	public static void main(String[] args) {
		Board b = new Board("board.txt");
		System.out.println(b);
	}
}
