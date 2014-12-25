package edu.ew.model;

import java.util.Observable;

/**
 * 
 * 
 * 
 * @author Selcuk Gulcan
 *
 */
public class EnergyPalette extends Observable{

	private EnergySet maxEnergies;
	private EnergySet activeEnergies;
	
	public EnergyPalette() {
		
		setMaxEnergies( new EnergySet());
		fillEnergies();
	}
	
	public EnergyPalette( EnergySet maxEnergies) {
		
		setMaxEnergies( maxEnergies);
		fillEnergies();
	}
	
	public void fillEnergies() {
		
		activeEnergies = maxEnergies.copy();
		setChanged();
		notifyObservers();
	}
	
	public void addPureEnergy() {
		
		maxEnergies.setEnergy( Energy.PURE, maxEnergies.getPure() + 1);
		fillEnergies();
		setChanged();
		notifyObservers();
	}
	
	//Getter & Setter Methods
	public EnergySet getMaxEnergies() {
		
		return maxEnergies;
	}
	
	public void setMaxEnergies( EnergySet maxEnergies) {
		
		this.maxEnergies = maxEnergies;
		setChanged();
		notifyObservers();
	}
	
	public EnergySet getActiveEnergies() {
		
		return activeEnergies;
	}
	
	public void setActiveEnergies( EnergySet activeEnergies) {
		
		this.activeEnergies = activeEnergies;
		setChanged();
		notifyObservers();
	}
	
	public String toString() {
		
		String stringToReturn = "";
		
		stringToReturn += activeEnergies.toString() + "\n";
		stringToReturn += maxEnergies.toString();
		
		return stringToReturn;		
	}

	public void consume(EnergySet cost) {
		
		activeEnergies.consume( cost);
		/*System.out.println( "after consume");
		System.out.println( activeEnergies);
		System.out.println( maxEnergies);*/
		setChanged();
		notifyObservers();
	}

	public void convert(EnergySet cost) {
		
		Energy converted = maxEnergies.convert( cost);
		activeEnergies.setPure( activeEnergies.getPure() - 1);
		activeEnergies.setEnergy( converted, activeEnergies.getEnergy( converted) + 1);
		/*System.out.println( activeEnergies);
		System.out.println( maxEnergies);*/
		setChanged();
		notifyObservers();
	}
}
