package edu.ew.model;

import java.io.FileNotFoundException;

import edu.ew.model.Player.Side;

/**
 * This class handles properties inside of the game like deck, charecter etc...
 * 
 * @author Selcuk Gulcan
 * @author Serdar Demirkol
 * @author Umut Hicyilmaz
 *
 */
public class Account {

	private String 	name;
	private Deck	deck;
	private String  aiName;
	
	/**
	 * Throws an exception if problem occurs with files
	 * 
	 * @exception java.io.FileNotFoundException if wrong file argument was passed
	 * @exception java.io.CorruptedFileException if file is changed/corrupted unauthorized
	 */
	public Account() throws FileNotFoundException, CorruptedFileException {
		
		setName( Setting.getName());
		setDeck( DeckIO.importDeck( Setting.getDeckName()));
		setAIName( Setting.getAIName());
	}
	
	/**
	 * Creates account with given parameters
	 * 
	 * @param name
	 */
	public Account( String name) throws FileNotFoundException, CorruptedFileException {
		
		setDeck( DeckIO.importDeck( Setting.getDeckName()));
		setName( name);
		setAIName( Setting.getAIName());
	}
	
	/**
	 * Creates account with given parameters
	 * 
	 * @param deck
	 */
	public Account( Deck deck) throws FileNotFoundException {
		
		setDeck( deck);
		setName( Setting.getName());
		setAIName( Setting.getAIName());
	}
	
	/**
	 * Creates account with given parameters
	 * 
	 * @param name
	 * @param deck
	 */
	public Account( String name, Deck deck) throws FileNotFoundException {
		
		setDeck( deck);
		setName( name);
		setAIName( Setting.getAIName());
	}
	
	/**
	 * Creates player with given parameters
	 * 
	 * @param side
	 */
	public Player createPlayer( Side side) {
		
		return new Player( side, deck);
	}

	//TRIVIAL METHODS
	/**
	 * Gets name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets deck
	 * 
	 * @return deck
	 */
	public Deck getDeck() {
		return deck;
	}
	
	/**
	 * Gets aiName
	 * 
	 * @return aiName
	 */
	public String getAIName() {
		
		return aiName;
	}
	
	/**
	 * Sets name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets deck
	 * 
	 * @param deck
	 */
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	/**
	 * Sets aiName
	 * 
	 * @param aiName
	 */
	public void setAIName( String aiName) {
		
		this.aiName = aiName;
	}
}
