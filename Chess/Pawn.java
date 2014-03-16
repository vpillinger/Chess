package Chess;

import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class Pawn extends ChessPiece {
	private int direction;

	public Pawn(ChessBoard<ChessPiece> board, Color color, Location loc) {
		super.setColor(color);
		super.setHasMoved(false);
		super.putSelfInChessBoard(board, loc);

		if (color.equals(Color.WHITE)) {
			direction = Location.NORTH;
		} else {
			direction = Location.SOUTH;
		}
	}

	@Override
	public ArrayList<Location> getValidMoveLocations() {
		// TODO Auto-generated method stub
		ArrayList<Location> validLocs = new ArrayList<Location>();
		// get possible move locations
		validLocs.addAll(checkValidLocInDirection(direction));

		// get capture locations
		int[] captureDirections = new int[2];
		captureDirections[0] = direction + 45;
		captureDirections[1] = direction + 315;
		ChessBoard<ChessPiece> myBoard = super.getChessBoard();
		for (int i = 0; i < captureDirections.length; i++) {
			Location possibleLocation = getLocation().getAdjacentLocation(
					captureDirections[i]);
			if (myBoard.isValid(possibleLocation)) {
				ChessPiece posPiece = myBoard.get(possibleLocation);
				if (posPiece != null
						&& !(posPiece.getColor().equals(getColor()))) {
					validLocs.add(possibleLocation);
				}
			}

		}
		return validLocs;

	}

	private ArrayList<Location> checkValidLocInDirection(int direction) {
		ArrayList<Location> validLocs = new ArrayList<Location>();
		ChessBoard<ChessPiece> myBoard = super.getChessBoard();
		Location myLoc = super.getLocation();
		Location nextLoc = myLoc.getAdjacentLocation(direction);
		// check 1 space ahead
		if (myBoard != null && myBoard.isValid(nextLoc)) {
			ChessPiece pieceAtLoc = myBoard.get(nextLoc);
			// if no piece, this can move there
			if (pieceAtLoc == null) {
				validLocs.add(nextLoc);
				// IF NOT MOVED, CHECKS TWO AHEAD
				if (!super.hasMoved()) {
					nextLoc = nextLoc.getAdjacentLocation(direction);
					pieceAtLoc = (ChessPiece) myBoard.get(nextLoc);
					if (pieceAtLoc == null) {
						validLocs.add(nextLoc);
					}
				}
			}

		}
		return validLocs;
	}

}
