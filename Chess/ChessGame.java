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
		return gameBoard.getMoveLocationsForLocation(loc);
	}
	/**
	 * 
	 * @return
	 */
	public Color getPieceColorAtLocation(Location loc){
		return gameBoard.getChessPieceColorAtLoc(loc);
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
		if(activePlayer.endTurn()){
			ChessPlayer t = activePlayer;
			activePlayer = inactivePlayer;
			inactivePlayer = t;
		}
		return false;
	}
	/**
	 * Use to start the players turn
	 * @return returns the TURNSTATUS of the player whose turn starts
	 */
	public TURNSTATUS startActivePlayerTurn(){
		return activePlayer.startTurn();
	}
	/**
	 * Stops the Active players clock
	 * @return true if clock was stopped, false otherwise
	 */
	public void stopActivePlayerClock(){
		activePlayer.stopClock();
	}
	/**
	 * Starts the Active players clock
	 * @return true if clock was started, false otherwise
	 */
	public void startActivePlayerClock(){
		activePlayer.startClock();
	}
	/**
	 * This method returns the time left in milliseconds on the ChessClock of the Active Player
	 * @return The time remaining in milliseconds
	 */
	public long getActivePlayerTimeLeft(){
		return activePlayer.getTimeLeftInMilliSeconds();
	}
}
