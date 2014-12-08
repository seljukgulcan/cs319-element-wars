package edu.ew.model;

/**
 * 
 * TODO:Add description
 * 
 * @author Selcuk Gulcan
 *
 */
public class EnergyPalette {

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
	}
	
	public void addPureEnergy() {
		
		maxEnergies.setEnergy( Energy.PURE, maxEnergies.getPure() + 1);
		fillEnergies();
	}
	
	//Getter & Setter Methods
	public EnergySet getMaxEnergies() {
		
		return maxEnergies;
	}
	
	public void setMaxEnergies( EnergySet maxEnergies) {
		
		this.maxEnergies = maxEnergies;
	}
	
	public EnergySet getActiveEnergies() {
		
		return activeEnergies;
	}
	
	public void setActiveEnergies( EnergySet activeEnergies) {
		
		this.activeEnergies = activeEnergies;
	}
}