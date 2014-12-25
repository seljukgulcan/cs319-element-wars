package edu.ew.model;

import java.util.Observable;

/**
 * This class represents characters in game
 * 
 * @author Selcuk Gulcan
 * @author Serdar Demirkol
 * @author Umut Hicyilmaz
 */
public class Character extends Observable{

	private int id;
	private String name;
	private int attack;
	private int defence;
	private int health;
	private Effect effect;
	private boolean canAttack;
	
	/**
	 * Constructor for characters
	 */
	public Character( int id, String name, int attack, int health) {
		
		setId( id);
		setName( name);
		setAttack( attack);
		setHealth( health);
		effect = null;
		canAttack = false;
	}
	
	/**
	 * Constructor for characters with given parameter
	 * 
	 * @param card
	 */
	public Character( CharacterCard card) {
		
		setId( card.getId());
		setName( card.getName());
		setAttack( card.getAttack());
		setHealth( card.getHealth());
		effect = null;
		canAttack = false;
	}
	
	/**
	 * Sets prepareForBattle tag
	 */
	public void prepareForBattle() {
		
		setCanAttack( true);
	}
	
	/**
	 * Gets name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets attack
	 * 
	 * @return attack
	 */
	public int getAttack() {
		return attack;
	}
	
	/**
	 * Sets attack
	 * 
	 * @param attack
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	/**
	 * Gets defence
	 * 
	 * @return defence
	 */
	public int getDefence() {
		return defence;
	}
	
	/**
	 * Sets defence
	 * 
	 * @param defence
	 */
	public void setDefence(int defence) {
		this.defence = defence;
	}
	
	/**
	 * Gets health
	 * 
	 * @return health
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * Sets health
	 * 
	 * @param health
	 */
	public void setHealth(int health) {
		this.health = health;
		this.defence = health;
	}
	
	/**
	 * Gets effect
	 * 
	 * @return effect
	 */
	public Effect getEffect() {
		return effect;
	}
	
	/**
	 * Sets effect
	 * 
	 * @param effect
	 */
	public void setEffect(Effect effect) {
		this.effect = effect;
	}
	
	/**
	 * Gets id
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
<<<<<<< HEAD

	public boolean getCanAttack() {
=======
	
	/**
	 * Gets isCanAttack
	 * 
	 * @return isCanAttack
	 */
	public boolean isCanAttack() {
>>>>>>> ba2abe0d1fc4477eca4949287f78264ba2831c5a
		return canAttack;
	}
	
	/**
	 * Sets canAttack
	 * 
	 * @param canAttack
	 */
	public void setCanAttack(boolean canAttack) {
		this.canAttack = canAttack;
	}

	@Override
	/**
	 * Turns iterations into strings
	 */
	public String toString() {
		
		String stringToReturn = "";
		stringToReturn += "[" + attack + ", " + defence + "]";
		
		return stringToReturn;
	}
}
