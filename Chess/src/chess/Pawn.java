package Chess;

import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class Pawn extends ChessPiece {
	public Pawn(ChessBoard<ChessPiece> board, Color color){
		super.setColor(color);
		super.setHasMoved(false);
		super.setChessBoard(board);
	}
	
	public ArrayList<Location> getValidMoveLocations() {
		
		//moves diagonally
		ArrayList<Location> validLocs = new ArrayList<Location>();
        
		//while still on the board
		//Move left or move right
		/*ChessBoard<ChessPiece> myBoard = super.getChessBoard();
		Location myLoc = super.getLocation();
		Location nextLoc = myLoc.getAdjacentLocation(Location.NORTHWEST);
        */
        
		//while still on a valid location on a board
		/*while(myBoard != null && myBoard.isValid(nextLoc)){
			ChessPiece pieceAtLoc = (ChessPiece) myBoard.get(nextLoc);*/
            
			//if no piece can move there
			if(pieceAtLoc == null){
				validLocs.add(nextLoc); 
				// if piece stop
			}
            
            else{
            	//if enemy piece that is a valid location
            	if((pieceAtLoc.getColor()).equals(super.getColor())){
				}
                
                else{
                	//stop loop break();
					validLocs.add(nextLoc);
				}
			}
			
			
		}
		//incomplete
		return null;
	}
}
