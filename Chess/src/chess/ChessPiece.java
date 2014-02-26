package chess;

import java.util.ArrayList;
import info.gridworld.grid.Location;

public abstract class ChessPiece extends Piece{

	/**
	 *Flips the piece to face the opposite direction
	 */
	public void flip(){
		super.act();
	}
	/**
	 * Returns all valid move locations for a Chess Piece
	 * @return an ArrayList of Valid Move Locations
	 */
	public abstract ArrayList<Location> getValidMoveLocations();
	/**
	 * returns true and moves piece is the location 
	 * given was a Valid Move Location
	 * @param loc the potential loc to move to
	 * @return true if the piece moved, false if it did not
	 */
	public boolean MoveTo(Location loc){
		if(getValidMoveLocations().contains(loc)){
			super.moveTo(loc);
			return true;
		}
		return false;
	}
}
