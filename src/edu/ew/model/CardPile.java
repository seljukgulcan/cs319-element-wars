package edu.ew.model;

import java.util.Collections;
import java.util.Iterator;
import java.util.Observable;
import java.util.Stack;

/**
 * Represents a pile cards.
 * 
 * @author Selcuk Gulcan
 *
 */
public class CardPile extends Observable{

	protected Stack<Card> cards;
	
	public CardPile() {
		
		cards = new Stack<Card>();
	}
	
	public void shuffle() {
		
		Collections.shuffle( cards);
		setChanged();
		notifyObservers();
	}
	
	public Card draw() {
		
		Card card = cards.pop();
		setChanged();
		notifyObservers();
		return card;
	}
	
	public void add( Card card) {
		
		cards.push( card);
		setChanged();
		notifyObservers();
	}
	
	public void remove( Card card) {
		
		cards.remove( card);
		setChanged();
		notifyObservers();
	}
	
	public Iterator<Card> iterator() {
		
		return cards.iterator();
	}
	
	public int getNoOfCards() {
		
		return cards.size();
	}
	
	//TRIVIAL METHODS
	public Stack<Card> getCards() {
		return cards;
	}

	public void setCards(Stack<Card> cards) {
		this.cards = cards;
	}
}
