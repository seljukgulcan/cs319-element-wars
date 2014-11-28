package edu.ew.model;

/**
 * This class represents single cards.
 * 
 * @author Selcuk Gulcan
 *
 */
public class Card {

	private int			id;
	private String 		name;
	private EnergySet	cost;
	private Effect		effect;
	
	/**
	 * 
	 * @param id The id of the card.
	 * @param name The name of the card.
	 * @param cost Cost of playing card into the board.
	 * @param effect The effect of the card, <code>null</code> if no effect is attached to it.
	 */
	public Card( int id, String name, EnergySet cost, Effect effect) {
		
		setId( id);
		setName( name);
		setCost( cost);
		setEffect( effect);
	}

	/**
	 * 
	 * @return The id of the card.
	 */
	public int getId() {
		
		return id;
	}

	/**
	 * Changes the value of id field.
	 * 
	 * @param id New id of the card.
	 */
	public void setId(int id) {
		
		this.id = id;
	}

	/**
	 * 
	 * @return The name of the card.
	 */
	public String getName() {
		
		return name;
	}

	/**
	 * Changes the value of </i>name</i> field.
	 * 
	 * @param name New name of the card.
	 */
	public void setName(String name) {
		
		this.name = name;
	}

	/**
	 * 
	 * @return The cost of the card.
	 */
	public EnergySet getCost() {
		
		return cost;
	}

	/**
	 * Changes the value of <i>cost</i> field.
	 * 
	 * @param cost New cost of the card.
	 */
	public void setCost(EnergySet cost) {
		
		this.cost = cost;
	}

	/**
	 * 
	 * @return The effect of the card.
	 */
	public Effect getEffect() {
		
		return effect;
	}

	/**
	 * Changes the value of <i>effect</i> field.
	 * 
	 * @param effect New effect of the card.
	 */
	public void setEffect(Effect effect) {
		
		this.effect = effect;
	}
}
