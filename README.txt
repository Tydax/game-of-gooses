
							************************
							**** Game of Gooses ****
							************************

Authors: Armand BOUR and Tristan Camus

To run a game, type the following command:
	java -cp game-of-gooses.jar bour/camus/gameofgooses/models/Game

You can also create your own Board by creating a .txt file following this model:

	0
	0
	1
	0
	0
	0
	0
	2
	1
	3,3
	4,7

0 is a for a normal cell ;
1 is for a goose cell ;
2 is for a trap cell ;
3 is for a wait cell, followed by a comma, and the number of turns to wait ;
4 is for a teleport cell, followed by a comma, and the index of the cell of destination.

Each number must be followed by a carriage return, else the program will fail to load the board.

Then, to load your board, type:
	java -cp game-of-gooses.jar  bour/camus/gameofgooses/models/Game board.txt
if your board file is named "board.txt".

You can access the Javadoc by opening the index.html file contained in the doc folder.