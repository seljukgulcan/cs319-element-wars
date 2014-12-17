package edu.ew.model;

import java.util.ArrayList;

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
}
