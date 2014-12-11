package edu.ew.model;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Represents a pile cards.
 * 
 * @author Selcuk Gulcan
 *
 */
public class CardPile extends Observable{

	private ArrayList<Card> cards;
	
	public CardPile() {
		
		cards = new ArrayList<Card>();
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	public void addCard( Card card) {
		
		cards.add( card);
	}
}
