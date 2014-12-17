package edu.ew.model;

import java.io.FileNotFoundException;

/**
 * Represents deck of players by extending CardPile class
 * 
 * @author Selcuk Gulcan
 * @see CardPile
 */
public class Deck extends CardPile {

	public static Deck getDefaultDeck() throws FileNotFoundException {
		
		Deck deck = new Deck();
		Card card = CardImporter.loadCard( 1);

		for( int i = 0; i < 30; i++)
			deck.addCard( card.copy());
		
		return deck;
	}
}
