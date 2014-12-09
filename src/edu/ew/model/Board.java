package edu.ew.model;

import java.util.ArrayList;

/**
 * TODO: Add description
 * 
 * @author Selcuk Gulcan
 *
 */
public class Board {

	public static final int SIZE = 8;
	
	private Player whitePlayer;
	private Player blackPlayer;
	private ArrayList<Character> whiteSide;
	private ArrayList<Character> blackSide;
	
	public Board( Player whitePlayer, Player blackPlayer) {
		
		setWhitePlayer( whitePlayer);
		setBlackPlayer( blackPlayer);
		whiteSide = new ArrayList<Character>( 8);
		blackSide = new ArrayList<Character>( 8);
	}

	public Player getWhitePlayer() {
		return whitePlayer;
	}

	public void setWhitePlayer(Player whitePlayer) {
		this.whitePlayer = whitePlayer;
	}

	public Player getBlackPlayer() {
		return blackPlayer;
	}

	public void setBlackPlayer(Player blackPlayer) {
		this.blackPlayer = blackPlayer;
	}
}
