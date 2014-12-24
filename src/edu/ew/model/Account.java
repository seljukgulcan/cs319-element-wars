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

	private String 	name;
	private Deck	deck;
	private String  aiName;
	
	public Account() throws FileNotFoundException, CorruptedFileException {
		
		setName( Setting.getName());
		setDeck( DeckIO.importDeck( Setting.getDeckName()));
		setAIName( Setting.getAIName());
	}
	
	public Account( String name) throws FileNotFoundException, CorruptedFileException {
		
		setDeck( DeckIO.importDeck( Setting.getDeckName()));
		setName( name);
		setAIName( Setting.getAIName());
	}
	
	public Account( Deck deck) throws FileNotFoundException {
		
		setDeck( deck);
		setName( Setting.getName());
		setAIName( Setting.getAIName());
	}
	
	public Account( String name, Deck deck) throws FileNotFoundException {
		
		setDeck( deck);
		setName( name);
		setAIName( Setting.getAIName());
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
	
	public String getAIName() {
		
		return aiName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	public void setAIName( String aiName) {
		
		this.aiName = aiName;
	}
}
