package edu.ew.model;

/**
 * Represents a player of the game
 * 
 * @author Selcuk Gulcan
 * TODO: Add description
 */
public class Player {
	
	public static enum Side { WHITE, BLACK};

	private Deck    deck;
	private int		health;
	private Side	side;
	private Hand	hand;
	private EnergyPalette energyPalette;
	
	public Player( Side side) {
		
		deck = null;
		setSide( side);
		hand = new Hand();
		energyPalette = new EnergyPalette();
	}
	
	public Player( Side side, Deck deck) {
		
		this( side);
		setDeck( deck);
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
}
