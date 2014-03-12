package Chess;

import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class ChessGame {
	private ChessPlayer inactivePlayer; //the player who is waiting for their turn
	private ChessPlayer activePlayer; //the player whose turn it is
	private ChessBoard<ChessPiece>	gameBoard;
	/**
	 * Creates a chess game with filled board and with players
	 */
	public ChessGame(){
		
	}
	/**
	 * 
	 * @param loc
	 * @return
	 */
	public ArrayList<Location> getMoveLocationsAtLocation(Location loc){
		return null;
	}
	/**
	 * 
	 * @return
	 */
	public Color getPieceColorAtLocation(){
		return null;
	}
	 
	public Color getActivePlayerColor() {
		return activePlayer.getColor();
	}
	/**
	 * Move a piece from one location to another location
	 * @param from Location that the piece is in before moving
	 * @param to Location to move piece to
	 * @return return true if a piece was moved
	 */
	public boolean moveAndEndActivePlayerTurn(Location from, Location to) throws InCheckException{
		//if piece exists move it
		//end players turn
		//if turn cannot be ended (in check), then reverse move
		return false;
	}
	/**
	 * Ends active players turn (if its legal)
	 * @return true if players turn was ended, false otherwise
	 */
	public boolean endActivePlayerTurn() throws InCheckException{
		return false;
	}
	/**
	 * Use to start the players turn
	 * @return returns the TURNSTATUS of the player whose turn starts
	 */
	public TURNSTATUS startActivePlayerTurn(){
		return null;
	}
}
