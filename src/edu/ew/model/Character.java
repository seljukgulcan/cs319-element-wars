package edu.ew.model;

import java.util.Observable;

/**
 * 
 * @author Selcuk Gulcan
 *
 */
public class Character extends Observable{

	private int id;
	private String name;
	private int attack;
	private int defence;
	private int health;
	private Effect effect;
	private boolean canAttack;
	
	public Character( int id, String name, int attack, int health) {
		
		setId( id);
		setName( name);
		setAttack( attack);
		setHealth( health);
		effect = null;
		canAttack = false;
	}
	
	public Character( CharacterCard card) {
		
		setId( card.getId());
		setName( card.getName());
		setAttack( card.getAttack());
		setHealth( card.getHealth());
		effect = null;
		canAttack = false;
	}
	
	public void prepareForBattle() {
		
		setCanAttack( true);
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getCanAttack() {
		return canAttack;
	}

	public void setCanAttack(boolean canAttack) {
		this.canAttack = canAttack;
	}

	@Override
	public String toString() {
		
		String stringToReturn = "";
		stringToReturn += "[" + attack + ", " + defence + "]";
		
		return stringToReturn;
	}
}
