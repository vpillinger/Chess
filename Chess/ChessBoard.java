package Chess;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.grid.Location;

public class ChessBoard<E extends ChessPiece> extends Board<E> {
	/**
	 * Makes a chess board. 
 	 * The board will have null in every space
	 * @return an initialized chess board
	 */
	public static ChessBoard<ChessPiece> makeEmptyChessBoard(){
		return new ChessBoard<ChessPiece>(8,8);
	}
	/**
	 * Makes a chess board.
	 * The board will have all pieces placed on it for a game of chess.
	 * The board will contain appropriate black and white tiles
	 * @return an initialized chess board will all pieces
	 */
	public static ChessBoard<ChessPiece> makeFullChessBoard(){
		ChessBoard<ChessPiece> board = new ChessBoard<ChessPiece>(8,8);
		//set up each color
		Color sideColor = Color.WHITE;
		placeLowerSide(board, sideColor);
		placeUpperSide(board, sideColor);
		return null;
	}
	private static void placeLowerSide(ChessBoard<ChessPiece> self, Color sideColor){
		//set up pawns
		for(int i=0;i<8;i++){
			self.put(new Location(1,i),new Pawn(self,sideColor));
		}
		//set up Rooks
		self.put(new Location(0,0),new Rook(self,sideColor));
		self.put(new Location(0,7),new Rook(self,sideColor));
		//set up knights
		//set up bishops
		//set up queen
		//set up king
	}
	private static void placeUpperSide(ChessBoard<ChessPiece> self, Color sideColor){
		
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
		ChessPiece cCP = getChessPieceAtLocation(loc);
		if(cCP != null){
			return getChessPieceAtLocation(loc).getValidMoveLocations();
		}
		return null;
	}
	/**
	 * 
	 * @return
	 */
	public ChessPiece getChessPieceAtLocation(Location loc){
		return super.get(loc);
	}
}
