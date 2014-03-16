package Chess;

import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class ChessGame {
	private ChessPlayer inactivePlayer; // the player who is waiting for their
										// turn
	private ChessPlayer activePlayer; // the player whose turn it is
	private ChessBoard<ChessPiece> gameBoard;

	/**
	 * Creates a chess game with filled board and with players
	 * PostCondition: (1) The game is ready to play
	 */
	public ChessGame(long playerClockTime) {
		gameBoard = ChessBoard.makeFullChessBoard();
		ArrayList<King> kings = new ArrayList<King>();
		ChessPlayer player1 = new ChessPlayer(kings.get(0).getColor(),kings.get(0),playerClockTime);
		ChessPlayer player2 = new ChessPlayer(kings.get(1).getColor(),kings.get(1),playerClockTime);
		if(player1.getColor().equals(Color.WHITE)){
			activePlayer = player1;
			inactivePlayer = player2;
		}else{
			activePlayer = player2;
			inactivePlayer = player1;
		}
	}

	/**
	 * 
	 * @param loc
	 * @return
	 */
	public ArrayList<Location> getMoveLocationsAtLocation(Location loc) {
		return gameBoard.getMoveLocationsForLocation(loc);
	}

	/**
	 * 
	 * @return
	 */
	public Color getPieceColorAtLocation(Location loc) {
		return gameBoard.getChessPieceColorAtLoc(loc);
	}

	public Color getActivePlayerColor() {
		return activePlayer.getColor();
	}

	/**
	 * Move a piece from one location to another location 
	 * PostCondition: (1) the active player is now the inactive player and vice versa
	 * 
	 * @param from
	 *            Location that the piece is in before moving
	 * @param to
	 *            Location to move piece to
	 * @return return true if a piece was moved
	 */
	public boolean moveAndEndActivePlayerTurn(Location from, Location to)
			throws IllegalMoveException {
		activePlayer.stopClock();//so time doesn't run as calculations happen
		ChessPiece movingPiece = gameBoard.getChessPieceAtLoc(from);
		ChessPiece potentialMovedPiece = gameBoard.getChessPieceAtLoc(to);
		if (movingPiece != null) {
			// no need to display, (get a response) if to wasn't a valid move
			// location
			try {
				movingPiece.moveTo(from);
				if (!activePlayer.endTurn()) {//if turn was not ended
					// revert move
					movingPiece.doMove(from);
					if (potentialMovedPiece != null) {
						potentialMovedPiece.putSelfInChessBoard(gameBoard, to);
					}
					// now throw exception, display this
					IllegalMoveException e = new IllegalMoveException(
							"Player cannot end turn, in check");
					e.setDisplay(true);
					throw e;
				}
				return true;
			} catch (IllegalMoveException e) {
				activePlayer.startClock();
				throw e;
			}
		}
		activePlayer.startClock();
		return false;
	}

	/**
	 * Ends active players turn (if its legal) PostCondition: (1) The active
	 * player is now the inactive player and vice versa
	 * 
	 * @return true if players turn was ended, false otherwise
	 */
	public boolean endActivePlayerTurn() throws IllegalMoveException {
		if (activePlayer.endTurn()) {
			ChessPlayer t = activePlayer;
			activePlayer = inactivePlayer;
			inactivePlayer = t;
			return true;
		}
		throw new IllegalMoveException("Player cannot end turn in check");
	}

	/**
	 * Use to start the players turn
	 * 
	 * @return returns the TURNSTATUS of the player whose turn starts
	 */
	public TURNSTATUS startActivePlayerTurn() {
		return activePlayer.startTurn();
	}

	/**
	 * Stops the Active players clock
	 * 
	 * @return true if clock was stopped, false otherwise
	 */
	public void stopActivePlayerClock() {
		activePlayer.stopClock();
	}

	/**
	 * Starts the Active players clock
	 * 
	 * @return true if clock was started, false otherwise
	 */
	public void startActivePlayerClock() {
		activePlayer.startClock();
	}

	/**
	 * This method returns the time left in milliseconds on the ChessClock of
	 * the Active Player
	 * 
	 * @return The time remaining in milliseconds
	 */
	public long getActivePlayerTimeLeft() {
		return activePlayer.getTimeLeftInMilliSeconds();
	}
}