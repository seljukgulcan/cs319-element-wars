package edu.ew.model;

import java.util.Collections;
import java.util.Iterator;
import java.util.Observable;
import java.util.Stack;

/**
 * Represents a pile cards.
 * 
 * @author Selcuk Gulcan
 * @author Serdar Demirkol
 * @author Umut Hicyilmaz
 *
 */
public class CardPile extends Observable{

	protected Stack<Card> cards;
	
	/**
	 * Constructor for cardPiles
	 */
	public CardPile() {
		
		cards = new Stack<Card>();
	}
	
	/**
	 * Shuffles the cards
	 */
	public void shuffle() {
		
		Collections.shuffle( cards);
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Draws cards
	 */
	public Card draw() {
		
		Card card = cards.pop();
		setChanged();
		notifyObservers();
		return card;
	}
	
	/**
	 * Adds cards to pile
	 * 
	 * @param card
	 */
	public void add( Card card) {
		
		cards.push( card);
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Removes cards from pile
	 * 
	 * @param card
	 */
	public void remove( Card card) {
		
		cards.remove( card);
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Iterates through the cardPile
	 */
	public Iterator<Card> iterator() {
		
		return cards.iterator();
	}
	
	/**
	 * Gets number of cards in Pile
	 * 
	 * @return NoOfCards
	 */
	public int getNoOfCards() {
		
		return cards.size();
	}
	
	//TRIVIAL METHODS
	/**
	 * Gets cards
	 * 
	 * @return cards
	 */
	public Stack<Card> getCards() {
		return cards;
	}
	
	/**
	 * Sets cards
	 * 
	 * @param cards
	 */
	public void setCards(Stack<Card> cards) {
		this.cards = cards;
	}
}
