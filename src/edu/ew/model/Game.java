package edu.ew.model;

import java.util.Observable;

/**
 * TODO: Add description
 * 
 * @author Selcuk Gulcan
 *
 */
public class Game extends Observable{

	private static final String DEFAULT_WHITE_NAME = "Yin";
	private static final String DEFAULT_BLACK_NAME = "Yang";
	
	private Player playerWhite;
	private Player playerBlack;
	private int turnNo;
	private Board board;
	private boolean gameStarted;
	private boolean gameEnded;
	
	public Game() {
		
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
	}
	
	public Game( Player playerWhite, Player playerBlack) {
		
		setPlayerWhite( playerWhite);
		setPlayerBlack( playerBlack);
		turnNo = 0;
		board = new Board( this.playerWhite, this.playerBlack);
		setGameStarted( false);
		setGameEnded( false);
	}

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
