package Chess;

import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class Rook extends ChessPiece {
	public Rook(ChessBoard<ChessPiece> board, Color color, Location loc){
		super.setColor(color);
		super.setHasMoved(false);
		super.putSelfInChessBoard(board,loc);
	}
	@Override
	public ArrayList<Location> getValidMoveLocations() {
		// TODO Auto-generated method stub
		return new ArrayList<Location>();
	}

}
