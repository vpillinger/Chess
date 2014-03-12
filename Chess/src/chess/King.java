package Chess;

import info.gridworld.grid.Location;
import java.util.ArrayList;


public class King extends ChessPiece{
	
	@Override
	public ArrayList<Location> getValidMoveLocations() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * Use this to see if this King is in check
	 * @return true if this King is in check, false otherwise
	 */
	public boolean isInCheck(){
		return false;
	}
	
	
	
	/**
	 * This method returns the potential move locations for a castling move performed by This King
	 * @return The possible locations that this King will end up in
	 * after castling
	 */
	private ArrayList<Location> getValidCastleLocations(){
		//see rules of chess (make sure that king is not castling through check)
		//both king and rook to perform castle with 
		//have had to not move
		return null;
	}
	
	
	/**
	 * 
	 * @param loc the location that the king ends up in after castling
	 * @return
	 */
	public boolean castleTo(Location loc){
		//make sure it's loc is a valid castle location
		//get the rook that is going to castle with the king
		//move the king, then move the rook
		return false;
	}
	
}
