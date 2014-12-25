package edu.ew.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import edu.ew.model.Player.Side;

/**
 * This class handles regulations concernig board
 * 
 * @author Selcuk Gulcan
 * @author Serdar Demirkol
 * @author Umut Hicyilmaz
 *
 */
public class Board extends Observable{

	public static final int SIZE = 8;
	
	private Player whitePlayer;
	private Player blackPlayer;
	private ArrayList<Character> whiteSide;
	private ArrayList<Character> blackSide;
	
	/**
	 * Creates board with two players (wihte and black player)
	 * 
	 * @param whitePlayer
	 * @param blackPlayer
	 */
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
	
	/**
	 * Puts character to board with given parameters
	 * 
	 * @param character
	 * @param position
	 * @param side
	 */
	public boolean putCharacter( Character character, int position, Side side) {
		
		if( getSide( side).get( position) != null)
			return false;
		
		getSide( side).set( position, character);
		setChanged();
		notifyObservers();
		return true;
	}
	
	/**
	 * Puts character from hand to board with given parameters
	 * 
	 * @param card
	 * @param position
	 * @param side
	 */
	public boolean putCharacter( CharacterCard card, int position, Side side) {
		
		Character character = card.createCharacter();
		return putCharacter( character, position, side);
	}
	
	/**
	 * Removes character with given parameters
	 * 
	 * @param position
	 * @param side
	 */
	public boolean removeCharacter( int position, Side side) {
		
		if( getSide( side).get( position) == null)
			return false;
		
		getSide( side).set( position, null);
		setChanged();
		notifyObservers();
		return true;
	}
	
	/**
	 * Puts prepareForBattle tag on players indicating that it's their turn
	 * 
	 * @param side
	 */
	public void prepareForBattle( Side side) {
		
		Iterator<Character> it;
		if( side == Side.WHITE) {
			
			it = whiteSide.iterator();
		}
		
		else {
			
			it = blackSide.iterator();
		}
		
		while( it.hasNext()) {
			
			Character next = it.next();
			if( next != null)
				next.prepareForBattle();
		}
	}
	
	/**
	 * Swaps characters
	 * 
	 * @param pos1
	 * @param pos2
	 * @param side
	 */
	public boolean swapCharacters( int pos1, int pos2, Side side) {
		
		ArrayList<Character> playerSide = getSide( side);
		if( playerSide.get( pos1) == null || playerSide.get( pos2) == null)
			return false;
		
		Character temp = playerSide.get( pos1);
		playerSide.set( pos1, playerSide.get( pos2));
		playerSide.set( pos2, temp);
		return true;
	}
	
	/**
	 * Kills character if it's health is zero
	 * 
	 * @param position
	 * @param side
	 */
	public void killCharacter( int position, Side side) {
		
		getSide( side).remove( position);
	}
	
	/**
	 * Gets character with given parameters
	 * 
	 * @param position
	 * @param side
	 */
	public Character getCharacter( int position, Side side) {
		
		return getSide( side).get( position);
	}
	
	/**
	 * Puts characters in to a arrayList
	 * 
	 * @param side
	 */
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
	
	/**
	 * Gets whitePlayer
	 * 
	 * @return whitePlayer
	 */
	public Player getWhitePlayer() {
		return whitePlayer;
	}
	
	/**
	 * Sets whitePlayer
	 * 
	 * @param whitePlayer
	 */
	public void setWhitePlayer(Player whitePlayer) {
		this.whitePlayer = whitePlayer;
	}
	
	/**
	 * Gets blackPlayer
	 * 
	 * @return blackPlayer
	 */
	public Player getBlackPlayer() {
		return blackPlayer;
	}
	
	/**
	 * Sets blackPlayer
	 * 
	 * @param blackPlayer
	 */
	public void setBlackPlayer(Player blackPlayer) {
		this.blackPlayer = blackPlayer;
	}
	
	/**
	 * Method that turns iterations to strings
	 */
	@Override
	public String toString() {
		
		String stringToReturn = "";
		
		Iterator<Character> it = blackSide.iterator();
		while( it.hasNext()) {
			
			Character i = it.next();
			
			if( i == null)
				stringToReturn += " [<  >]";
			
			else
				stringToReturn += " " + i.toString();
		}
		
		stringToReturn += "\n";
		
		it = whiteSide.iterator();
		while( it.hasNext()) {
			
			Character i = it.next();
			
			if( i == null)
				stringToReturn += " [<  >]";
			
			else
				stringToReturn += " " + i.toString();
		}
		
		return stringToReturn;
	}
}
