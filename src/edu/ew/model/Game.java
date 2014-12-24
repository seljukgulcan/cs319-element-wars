package edu.ew.model;

import java.util.Observable;

import edu.ew.model.Player.Side;

/**
 * TODO: Add description
 * 
 * @author Selcuk Gulcan
 *
 */
public class Game extends Observable{

	/*private static final String DEFAULT_WHITE_NAME = "Yin";
	private static final String DEFAULT_BLACK_NAME = "Yang";*/
	private static final int DEF_HEALTH = 20;
	private static final int STARTING_HAND_SIZE = 3;
	
	private Player playerWhite;
	private Player playerBlack;
	private int turnNo;
	private Board board;
	private boolean gameStarted;
	private boolean gameEnded;
	
	/*public Game() {
		
		setPlayerWhite( new Player( DEFAULT_WHITE_NAME));
		setPlayerBlack( new Player( DEFAULT_BLACK_NAME));
		turnNo = 0;
		board = new Board( playerWhite, playerBlack);
		setGameStarted( false);
		setGameEnded( false);
	}
	
	public Game( String playerWhite, String playerBlack) {
		
		setPlayerWhite( new Player( playerWhite));
		setPlayerBlack( new Player( playerBlack));
		turnNo = 0;
		board = new Board( this.playerWhite, this.playerBlack);
		setGameStarted( false);
		setGameEnded( false);
	}*/
	
	public Game( Player playerWhite, Player playerBlack) {
		
		setPlayerWhite( playerWhite);
		setPlayerBlack( playerBlack);
		turnNo = 0;
		board = new Board( this.playerWhite, this.playerBlack);
		setGameStarted( false);
		setGameEnded( false);
	}
	
	public boolean startGame() {
		
		if( isGameStarted())
			return false;
		
		getPlayerWhite().setHealth( DEF_HEALTH);
		getPlayerBlack().setHealth( DEF_HEALTH);
		getPlayerWhite().shuffleDeck();
		getPlayerBlack().shuffleDeck();
		getPlayerWhite().draw( STARTING_HAND_SIZE);
		getPlayerBlack().draw( STARTING_HAND_SIZE);
		setTurnNo( 0);
		gameStarted = true;
		return true;
	}
	
	public Side turnOf() {
		
		if( !isGameStarted() || isGameEnded())
			return null;
		
		return getTurnNo() % 2 == 0 ? Side.WHITE : Side.BLACK;
	}
	
	public void endTurn() {
		
		turnNo++;
	}

	//TRIVIAL METHODS
	public Player getPlayerWhite() {
		return playerWhite;
	}

	public Player getPlayerBlack() {
		return playerBlack;
	}

	public int getTurnNo() {
		return turnNo;
	}

	public Board getBoard() {
		return board;
	}

	public boolean isGameStarted() {
		return gameStarted;
	}

	public boolean isGameEnded() {
		return gameEnded;
	}
	
	public void setTurnNo( int turnNo) {
		
		this.turnNo = turnNo;
	}

	public void setPlayerWhite(Player playerWhite) {
		this.playerWhite = playerWhite;
	}

	public void setPlayerBlack(Player playerBlack) {
		this.playerBlack = playerBlack;
	}

	public void setGameStarted(boolean gameStarted) {
		this.gameStarted = gameStarted;
	}

	public void setGameEnded(boolean gameEnded) {
		this.gameEnded = gameEnded;
	}
}
