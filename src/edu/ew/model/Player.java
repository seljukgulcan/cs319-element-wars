package edu.ew.model;

/**
 * Represents a player of the game
 * 
 * @author Selcuk Gulcan
 * TODO: Add description
 */
public class Player {
	
	public static enum Side { WHITE, BLACK};

	private String name;
	private Deck   deck;
	
	public Player( String name) {
		
		setName( name);
		deck = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
}
