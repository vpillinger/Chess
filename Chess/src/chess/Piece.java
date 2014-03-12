package Chess;

import java.awt.Color;

import info.gridworld.grid.Location;

public abstract class Piece {
	private Board<Piece> board;
	private Location location;
	private Color color;

	/**
	 * Gets the color of this Piece.
	 * 
	 * @return the color of this piece
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Sets the color of this piece.
	 * 
	 * @param newColor
	 *            the new color
	 */
	public void setColor(Color newColor) {
		color = newColor;
	}

	/**
	 * Gets the board in which this piece is located.
	 * 
	 * @return the board of this piece, or <code>null</code> if this piece is
	 *         not contained in a board
	 */
	public Board<Piece> getBoard() {
		return board;
	}

	/**
	 * Gets the location of this piece.
	 * 
	 * @return the location of this piece, or <code>null</code> if this piece is
	 *         not contained in a board
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Puts this piece into a board. If there is another piece at the given
	 * location, it is removed. <br />
	 * Precondition: (1) This piece is not contained in a board (2)
	 * <code>loc</code> is valid in <code>br</code>
	 * 
	 * @param br
	 *            the board into which this piece should be placed
	 * @param loc
	 *            the location into which the piece should be placed
	 */
	public void putSelfInBoard(Board<Piece> br, Location loc) {
		if (board != null)
			throw new IllegalStateException(
					"This Piece is already contained in a board.");

		Piece piece = br.get(loc);
		if (piece != null)
			piece.removeSelfFromBoard();
		br.put(loc, this);
		board = br;
		location = loc;
	}

	/**
	 * Removes this piece from its board. <br />
	 * Precondition: This piece is contained in a board
	 */
	public void removeSelfFromBoard() {
		if (board == null)
			throw new IllegalStateException(
					"This piece is not contained in a board.");
		if (board.get(location) != this)
			throw new IllegalStateException(
					"The board contains a different piece at location "
							+ location + ".");

		board.remove(location);
		board = null;
		location = null;
	}

	/**
	 * Moves this piece to a new location. If there is another piece at the
	 * given location, it is removed. <br />
	 * Precondition: (1) This piece is contained in a board (2)
	 * <code>newLocation</code> is valid in the board of this piece
	 * 
	 * @param newLocation
	 *            the new location
	 */
	public void moveTo(Location newLocation) {
		if (board == null)
			throw new IllegalStateException("This piece is not in a board.");
		if (board.get(location) != this)
			throw new IllegalStateException(
					"The board contains a different piece at location "
							+ location + ".");
		if (!board.isValid(newLocation))
			throw new IllegalArgumentException("Location " + newLocation
					+ " is not valid.");

		if (newLocation.equals(location))
			return;
		board.remove(location);
		Piece other = board.get(newLocation);
		if (other != null)
			other.removeSelfFromBoard();
		location = newLocation;
		board.put(location, this);
	}

	/**
	 * Creates a string that describes this piece.
	 * 
	 * @return a string with the location, direction, and color of this piece
	 */
	public String toString() {
		return getClass().getName() + "[location=" + location + ",color="
				+ color + "]";
	}

}
