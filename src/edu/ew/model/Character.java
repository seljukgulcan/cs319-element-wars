package edu.ew.model;

import java.util.Observable;

/**
 * TODO:Add description
 * @author Selcuk Gulcan
 *
 */
public class Character extends Observable{

	private String name;
	private int attack;
	private int defence;
	private int health;
	private Effect effect;
	
	public Character( String name, int attack, int health) {
		
		setName( name);
		setAttack( attack);
		setHealth( health);
		effect = null;
	}
	
	public Character( CharacterCard card) {
		
		setName( card.getName());
		setAttack( card.getAttack());
		setHealth( card.getHealth());
		effect = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
		this.defence = health;
	}

	public Effect getEffect() {
		return effect;
	}

	public void setEffect(Effect effect) {
		this.effect = effect;
	}
	
	@Override
	public String toString() {
		
		String stringToReturn = "";
		stringToReturn += "[" + attack + ", " + defence + "]";
		
		return stringToReturn;
	}
}
