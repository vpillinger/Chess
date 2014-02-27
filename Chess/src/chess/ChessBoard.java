package chess;

import java.util.ArrayList;


import info.gridworld.grid.Location;

public class ChessBoard<E extends ChessPiece> extends Board<E> {
	/**
	 * Makes a chess board. 
 	 * The board will contain appropriate black and white tiles
	 * @return an initialized chess board
	 */
	public static ChessBoard<ChessPiece> makeEmptyChessBoard(){
		return null;
	}
	/**
	 * Makes a chess board.
	 * The board will have all pieces placed on it for a game of chess.
	 * The board will contain appropriate black and white tiles
	 * @return an initialized chess board will all pieces
	 */
	public static ChessBoard<ChessPiece> makeFullChessBoard(){
		return null;
	}
	
	private ChessBoard(int rows, int cols) {
		super(rows, cols);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Returns an array of possible move locations for a piece at a location
	 * @param loc the Location to check
	 * @return null if no piece is there, 
	 * an arrayList of possible move Locations if a piece is there
	 */
	public ArrayList<Location> getMoveLocationsForLocation(Location loc){
		return null;
	}
	/**
	 * 
	 * @return
	 */
	public ChessPiece getChessPieceAtLocation(){
		return null;
	}
}
