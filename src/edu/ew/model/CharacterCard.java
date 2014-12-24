package edu.ew.model;

/**
 * 
 * TODO:Add description
 * 
 * @author Selcuk Gulcan
 */

public class CharacterCard extends Card {

	private int attack;
	private int health;
	
	public CharacterCard(int id, String name, EnergySet cost, Effect effect, int attack, int health) {
		super(id, name, cost, effect);
		setHealth( health);
		setAttack( attack);
	}
	
	public CharacterCard( int id, String name, EnergySet cost, int attack, int health) {
		
		super( id, name, cost);
		setHealth( health);
		setAttack( attack);
	}
	
	public Character createCharacter() {
		
		return new Character( id, name, attack, health);
	}

	public CharacterCard copy() {
		
		CharacterCard card;
		card = new CharacterCard( id, name, cost.copy(), effect == null ? null : effect.copy(), attack, health);
		
		return card;
	}
	
	//TRIVIAL METHODS
	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	@Override
	public String toString() {
		
		String stringToReturn;
		stringToReturn = "[" + attack + ", " + health + "]" + super.toString();
		
		return stringToReturn;
	}
	
	/*public void speak() {
		
		System.out.println( "echo");
	}*/
}
