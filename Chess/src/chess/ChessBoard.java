package chess;

import java.util.ArrayList;


import info.gridworld.grid.Location;

public class ChessBoard<E extends Piece> extends Board<E> {
	/**
	 * Makes a chess board. 
 	 * The board will contain appropriate black and white tiles
	 * @return an initialized chess board
	 */
	public static ChessBoard<Piece> makeEmptyChessBoard(){
		return null;
	}
	/**
	 * Makes a chess board.
	 * The board will have all pieces placed on it for a game of chess.
	 * The board will contain appropriate black and white tiles
	 * @return an initialized chess board will all pieces
	 */
	public static ChessBoard<Piece> makeFullChessBoard(){
		return null;
		
	}
	
	private ChessBoard(int rows, int cols) {
		super(rows, cols);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Returns that locations of all locations not occupied by tiles
	 * @ return an ArrayList of locations
	 */
	public ArrayList<Location> getNonTileOccupiedLocations(){
		return null;
		
	}
}
