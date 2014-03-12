package Chess;

import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class ChessWorld<E extends ChessPiece> extends World<E> {
	private ChessBoard<E> chessBoard;
	
	/**
	 * Returns true if a player
	 */
	public boolean locationClicked(Location loc){
		return false;
	}
	
}
