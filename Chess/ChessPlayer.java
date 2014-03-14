package Chess;

import java.awt.Color;

public class ChessPlayer{
	private ChessClock clock;
	private King king;
	private Color color;
	
	public ChessPlayer(Color color, King king, long clockTime){
		if(king.getColor() != color){
			throw new RuntimeException("The king is not the same color as the player");
		}
		this.color = color;
		this.king = king;
		this.clock = new ChessClock(clockTime);
	}
	/**
	 * 
	 * @return true if is in check, false if not
	 */
	public boolean isInCheck() {
		return king.isInCheck();
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
	 * Returns the time left on a players clock in milliSeconds
	 * 
	 * @return long representing seconds
	 */
	public long getTimeLeftInMilliSeconds() {
		return clock.getTimeLeft();
	}

	/**
	 * 
	 * @return
	 */
	public ChessClock getChessClock() {
		return clock;
	}	
	/**
	 * 
	 * @return
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * 
	 * @param myColor
	 */
	public void setColor(Color myColor) {
		this.color = myColor;
	}

}
