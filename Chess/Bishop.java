package Chess;

import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class Bishop extends ChessPiece {
	public Bishop(ChessBoard<ChessPiece> board, Color color){
		super.setColor(color);
		super.setHasMoved(false);
		super.setChessBoard(board);
	}
	
	public ArrayList<Location> getValidMoveLocations() {
		//moves diagonally
		ArrayList<Location> validLocs = new ArrayList<Location>();
		//while still in the board go up-left
		ChessBoard<ChessPiece> myBoard = super.getChessBoard();
		Location myLoc = super.getLocation();
		Location nextLoc = myLoc.getAdjacentLocation(Location.NORTHWEST);
		//while still on a valid location on a board
		//loop for just northwest here
		while(myBoard != null && myBoard.isValid(nextLoc)){
			ChessPiece pieceAtLoc = (ChessPiece) myBoard.get(nextLoc);
			//if no piece can move there
			if(pieceAtLoc == null){
				validLocs.add(nextLoc);
			// if piece stop
			}else{
				if((pieceAtLoc.getColor()).equals(super.getColor())){
					//top loop break();
				//if enemy piece that is a valid location
				}else{
					validLocs.add(nextLoc);
					//stop loop break();
				}
			}
		}
		//incomplete
		return null;
	}
}
