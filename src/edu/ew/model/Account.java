package edu.ew.model;

import java.io.FileNotFoundException;

import edu.ew.model.Player.Side;

/**
 * 
 * @author Selcuk Gulcan
 *
 *	TODO: Add Description
 */
public class Account {
	
	private static final String DEFAULT_WHITE_NAME = "Yin";
	private static final String DEFAULT_BLACK_NAME = "Yang";

	private String 	name;
	private Deck	deck;
	
	public Account() throws FileNotFoundException {
		
		setDeck( Deck.getDefaultDeck());
		setName( DEFAULT_WHITE_NAME);
	}
	
	public Account( String name) throws FileNotFoundException {
		
		setDeck( Deck.getDefaultDeck());
		setName( name);
	}
	
	public Account( Deck deck) {
		
		setDeck( deck);
		setName( DEFAULT_WHITE_NAME);
	}
	
	public Account( String name, Deck deck) {
		
		setDeck( deck);
		setName( name);
	}
	
	public Player createPlayer( Side side) {
		
		return new Player( side, deck);
	}

	//TRIVIAL METHODS
	public String getName() {
		return name;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
}
