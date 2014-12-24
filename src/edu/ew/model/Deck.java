package edu.ew.model;

import java.util.Iterator;

/**
 * Represents deck of players by extending CardPile class
 * 
 * @author Selcuk Gulcan
 * @see CardPile
 */
public class Deck extends CardPile{
	
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id2) {
		this.id = id2;
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
