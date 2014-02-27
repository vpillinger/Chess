package chess;

import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class Board<E extends Piece> extends BoundedGrid<E>{

	public Board(int rows, int cols) {
		super(rows, cols);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Use to check if there is at a given location
	 * @param loc the Location to check
	 * @return true if there is a piece, false if there is not
	 */
	public boolean isPieceatLoc(Location loc){
		return false;
	}	
	/**
	 * 
	 * @param loc
	 * @return
	 */
	public Piece getPieceatLoc(Location loc){
		return null;
	}
	/**
	 * Use to get the color of a piece at the target location
	 * @param loc the location to find the piece at
	 * @return null if no piece, the color of the piece otherwise
	 */
	public Color pieceColorAtLoc(Location loc){
		return null;
	}
}
