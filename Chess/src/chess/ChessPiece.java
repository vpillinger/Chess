package Chess;

import java.util.ArrayList;
import info.gridworld.grid.Location;

public abstract class ChessPiece extends Piece{
	private ChessBoard<ChessPiece> myBoard;
	private boolean hasMoved;
	/**
	 * Returns all valid move locations for a Chess Piece
	 * @return an ArrayList of Valid Move Locations
	 */
	public abstract ArrayList<Location> getValidMoveLocations();
	
	public void setHasMoved(boolean hasMoved){
		this.hasMoved = hasMoved;
	}
	public boolean hasMoved(){
		return hasMoved;
	}
	/**
	 * returns true and moves piece is the location 
	 * given was a Valid Move Location.
	 * @param loc the potential loc to move to
	 * @return true if the piece moved, false if it did not
	 */
	public boolean MoveTo(Location loc){
		if(getValidMoveLocations().contains(loc)){
			super.moveTo(loc);
			hasMoved = true;
			return true;
		}
		return false;
	}
	public ChessBoard<ChessPiece> getChessBoard() {
		return myBoard;
	}
	public void setChessBoard(ChessBoard<ChessPiece> myBoard) {
		this.myBoard = myBoard;
	}
}
