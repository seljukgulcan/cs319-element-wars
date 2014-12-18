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
		
		int i = 0;
		Iterator<Card> it = cards.iterator();
		while( it.hasNext()) {
			
			stringToReturn += i + "--> " + it.next().toString() + "\n";
			i++;
		}
		
		if( stringToReturn.equals( ""))
			stringToReturn = "Empty Hand";
		
		return stringToReturn;
	}

	public Card getCard(int handPos) {
		
		return cards.get( handPos);
	}
}
