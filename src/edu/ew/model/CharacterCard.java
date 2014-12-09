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
		stringToReturn = super.toString();
		stringToReturn += "attack: " + attack + "\n";
		stringToReturn += "health: " + health + "\n";
		
		return stringToReturn;
	}
}
