package edu.ew.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * TODO:Add description
 * 
 * @author Selcuk Gulcan
 *
 */

public class Hand {

	private ArrayList<Card> cards;
	
	public Hand() {
		
		cards = new ArrayList<Card>();
	}
	
	public void add( Card card) {
		
		cards.add( card);
	}

	//TRIVIAL METHODS
	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public String toString() {
		
		String stringToReturn = "";
		
		Iterator<Card> it = cards.iterator();
		while( it.hasNext()) {
			
			//System.out.println( "Something is wrong");
			stringToReturn += it.next().toString() + "\n";
			//((CharacterCard)it.next()).speak();
		}
		
		if( stringToReturn.equals( ""))
			stringToReturn = "Empty Hand";
		
		return stringToReturn;
	}
}
