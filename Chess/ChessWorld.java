package Chess;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class ChessWorld<E extends ChessPiece> extends World<E> {
	private ChessGame chessGame;
	private Location locOfPieceSelected;
	private boolean isPieceSelected; 
	/**
	 * Create a ChessWorld where the players have 30 minutes on their chess clocks
	 * @return
	 */
	public static ChessWorld<ChessPiece> createChessWorld(){
		ChessGame chessGame = new ChessGame(1800000);//30 minute chess timer
		Grid<ChessPiece> chessGrid = chessGame.getChessBoard();
		return new ChessWorld<ChessPiece>(chessGrid, chessGame);
	}
	private ChessWorld(Grid<E> chessGrid, ChessGame chessGame){
		super(chessGrid);
		this.chessGame = chessGame;
		locOfPieceSelected = null;
		isPieceSelected = false;
	}
	/**
	 * Returns true if a player
	 */
	public boolean locationClicked(Location loc){
		return false;
	}
	/**
	 * Overwrite to prompt user to surrender or offer draw
	 */
	public void step(){
		
	}
}
