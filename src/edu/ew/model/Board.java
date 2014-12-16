package edu.ew.model;

import java.util.ArrayList;

import edu.ew.model.Player.Side;

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
		whiteSide = new ArrayList<Character>( SIZE);
		blackSide = new ArrayList<Character>( SIZE);
		
		for( int i = 0; i < SIZE; i++) {
			
			whiteSide.add( null);
			blackSide.add( null);
		}
	}
	
	public boolean putCharacter( Character character, int position, Side side) {
		
		if( getSide( side).get( position) != null)
			return false;
		
		getSide( side).set( position, character);
		return true;
	}
	
	public boolean removeCharacter( int position, Side side) {
		
		if( getSide( side).get( position) == null)
			return false;
		
		getSide( side).set( position, null);
		return true;
	}
	
	public boolean swapCharacters( int pos1, int pos2, Side side) {
		
		ArrayList<Character> playerSide = getSide( side);
		if( playerSide.get( pos1) == null || playerSide.get( pos2) == null)
			return false;
		
		Character temp = playerSide.get( pos1);
		playerSide.set( pos1, playerSide.get( pos2));
		playerSide.set( pos2, temp);
		return true;
	}
	
	public Character getCharacter( int position, Side side) {
		
		return getSide( side).get( position);
	}
	
	public ArrayList<Character> getSide( Side side) {

		switch( side) {
		
		case BLACK:
			return blackSide;
			
		case WHITE:
			return whiteSide;
			
		default:
			return null;
		}
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
