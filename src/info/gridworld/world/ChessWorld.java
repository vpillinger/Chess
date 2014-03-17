package info.gridworld.world;

import java.awt.Color;
import java.util.ArrayList;

import Chess.ChessGame;
import Chess.ChessPiece;
import Chess.IllegalMoveException;
import Chess.PieceNeedsToBeReplacedException;
import Chess.TURNSTATUS;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class ChessWorld<E extends ChessPiece> extends World<E> {
	private ChessGame chessGame;
	private Location locOfPieceSelected;
	private boolean isPieceSelected; 
	private ArrayList<Location> highLightedSpaces;
	/**
	 * Create a ChessWorld where the players have 30 minutes on their chess clocks
	 * @return
	 */
	public static ChessWorld<ChessPiece> createChessWorld(){
		ChessGame chessGame = new ChessGame(1800000);//30 minute chess timer
		Grid<ChessPiece> chessGrid = chessGame.getChessBoard();
		return new ChessWorld<ChessPiece>(chessGrid, chessGame);
	}
	private ChessWorld(Grid<E> chessGrid, ChessGame chessGame){
		super(chessGrid);
		this.chessGame = chessGame;
		locOfPieceSelected = null;
		isPieceSelected = false;
		highLightedSpaces = new ArrayList<Location>();
		
		//set inital message to white players turn
		displayTurnMessage(TURNSTATUS.NOSTATUS,false);
	}
	/**
	 * Returns true if the click is consumed by this method
	 */
	public boolean locationClicked(Location loc){
		//if piece is selected see if you can move it
		if(isPieceSelected){
			try {
				chessGame.moveAndEndActivePlayerTurn(locOfPieceSelected, loc);
				//start other players turn
				TURNSTATUS t = chessGame.startActivePlayerTurn();
				displayTurnMessage(t, false);
				unselectPiece();
				return true;
			} catch (IllegalMoveException e) {
				if(e.shouldDisplay()){
					displayTurnMessage(TURNSTATUS.NOSTATUS, true);
				}
				unselectPiece();
			} catch (PieceNeedsToBeReplacedException e) {
				//prompt user input to get new piece and add it to the board
				/*Needs Implementation*/
				int pieceNum = 0;
				chessGame.addPieceAtLoc(loc, pieceNum, chessGame.getInactivePlayerColor());
				TURNSTATUS u = chessGame.startActivePlayerTurn();
				displayTurnMessage(u,false);
			}
			unselectPiece();
			return true;
		}else{
			//if there is a piece there, select it and highlight its spaces
			if(chessGame.isPieceAtLoc(loc)){
				isPieceSelected = true;
				locOfPieceSelected = loc;
				highLightedSpaces = chessGame.getMoveLocationsAtLocation(loc);
			}
			return true;
		}
	}
	private void displayTurnMessage(TURNSTATUS t, boolean addWarning){
		String color = "White";
		if(chessGame.getActivePlayerColor().equals(Color.BLACK)){
			color = "Black";
		}
		String s = ( color + " Player" + "'s turn.");
		if(t != TURNSTATUS.NOSTATUS){
			s = (s + "\n Player: " + color + " is currently in " + t + ".");
		}
		if(addWarning){
			s = (s + "\n WARNING: You may not end your turn in check.");
		}
		setMessage(s);
	}
	private void unselectPiece(){
		highLightedSpaces = new ArrayList<Location>();
		locOfPieceSelected = null;
		isPieceSelected = false;
	}
	/**
	 * Overwrite to prompt user to surrender or offer draw
	 */
	public void step(){
		String color = "White";
		if(chessGame.getActivePlayerColor().equals(Color.BLACK)){
			color = "Black";
		}
		setMessage("Player " + color + " has lost by CHECKMATE");
	}
	public void stop(){
		ChessGame chessGame = new ChessGame(1800000);//30 minute chess timer
		Grid<ChessPiece> chessGrid = chessGame.getChessBoard();
		this.chessGame = chessGame;
		super.setGrid((Grid<E>)chessGrid);
		locOfPieceSelected = null;
		isPieceSelected = false;
		highLightedSpaces = new ArrayList<Location>();
		
		//set inital message to white players turn
		displayTurnMessage(TURNSTATUS.NOSTATUS,false);
	}
	public ArrayList<Location> getHighlightLocations(){
		return highLightedSpaces;
	}
	public boolean isOpponentPieceSelected(){
		if(chessGame.getActivePlayerColor().equals(chessGame.getPieceColorAtLocation(locOfPieceSelected))){
			return false;
		}
		return true;
	}
}
