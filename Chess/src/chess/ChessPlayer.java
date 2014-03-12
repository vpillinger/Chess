package Chess;

import java.awt.Color;

public class ChessPlayer extends Player{
	private ChessClock clock;
	private King king;
	
	public ChessPlayer(Color color){
		super(color);
	}
	/**
	 * 
	 * @return true if is in check, false if not
	 */
	public boolean isInCheck() {
		return false;
	}

	/**
	 * 
	 * @return true if is in checkmate, false if not
	 */
	public boolean isInCheckMate() {
		return false;
	}

	/**
	 * Returns the players status at the start of a turn
	 * 
	 * @return CHECK,CHECKMATE,or NOSTATUS
	 */
	public TURNSTATUS startTurn() {
		return null;
	}

	/**
	 * Make sure conditions for ending turn are satisfied (not in check)
	 * Then Stop the chess clock
	 */
	public boolean endTurn() throws InCheckException{
		return false;
	}

	/**
	 * Returns the time left on a players clock in seconds
	 * 
	 * @return long representing seconds
	 */
	public long getTimeLeftInSeconds() {
		return 0;
	}

	/**
	 * 
	 * @return
	 */
	public ChessClock getChessClock() {
		return clock;
	}

}
