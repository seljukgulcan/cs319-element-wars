package edu.ew.model;

import java.io.FileNotFoundException;
import java.util.Iterator;

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
			deck.add( card.copy());
		
		return deck;
	}
	
	public String toString() {
		
		String stringToReturn = "";
		Iterator<Card> it = cards.iterator();
		
		while( it.hasNext()) {
			
			stringToReturn += it.next().toString() + "\n";
		}
		
		return stringToReturn;
	}
}
