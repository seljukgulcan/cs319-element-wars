package edu.ew.model;

import java.util.Observable;

/**
 * Represents a player of the game
 * 
 * @author Selcuk Gulcan
 * 
 */
public class Player extends Observable{
	
	public static enum Side { WHITE, BLACK};

	protected Deck    deck;
	protected int	health;
	protected Side	side;
	protected Hand	hand;
	protected EnergyPalette energyPalette;
	protected int noOfConvert;
	protected CardPile discardPile;
	
	private Player( Side side) {
		
		deck = null;
		setSide( side);
		hand = new Hand();
		energyPalette = new EnergyPalette();
		noOfConvert = 0;
		discardPile = new CardPile();
	}
	
	public Player( Side side, Deck deck) {
		
		this( side);
		setDeck( deck);
	}
	
	public void consume( EnergySet cost) {
		
		energyPalette.consume( cost);
	}
	
	public void shuffleDeck() {
		
		deck.shuffle();
	}
	
	public void draw() {
		
		hand.add( deck.draw());
	}

	public void draw( int size) {
		
		for( int i = 0; i < size; i++)
			draw();
	}
	
	public void gainEnergy() {
		
		energyPalette.addPureEnergy();
	}
	
	public void discard( Card card) {
		
		hand.remove( card);
		discardPile.add( card);
	}
	
	public boolean canPlay( Card card) {
		
		return energyPalette.getActiveEnergies().canPay( card.cost);
	}
	
	public boolean canPlayWithConversion( Card card) {
		
		return energyPalette.getActiveEnergies().canPayWithConversion( card.cost);
	}
	
	public void convert(EnergySet cost) {
		
		energyPalette.convert( cost);
	}
	
	//TRIVIAL METHODS
	public Deck getDeck() {
		return deck;
	}
	
	public void setSide( Side side) {
		this.side = side;
	}
	
	public Side getSide() {
		return side;
	}
	
	public void setHealth( int health) {
		this.health = health;
		this.setChanged();
		this.notifyObservers();
	}
	
	public int getHealth() {
		return health;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Hand getHand() {
		return hand;
	}

	public EnergyPalette getEnergyPalette() {
		return energyPalette;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public void setEnergyPalette(EnergyPalette energyPalette) {
		this.energyPalette = energyPalette;
	}

	public int getNoOfConvert() {
		return noOfConvert;
	}

	public void setNoOfConvert(int noOfConvert) {
		this.noOfConvert = noOfConvert;
	}
}
