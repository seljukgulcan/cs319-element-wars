package edu.ew.controller;

import edu.ew.model.ModelConnector;

public class TurnManager extends Manager{

	protected Phase phase;
	protected boolean inPlayPhase;
	
	protected enum Phase{ DRAW, START, PLAY, END};
	
	public TurnManager( ModelConnector model) {
		
		super( model);
		inPlayPhase = false;
	}
	
	public void startTurn() {
		
		playDrawPhase();
	}
	
	public void playDrawPhase() {
		
		model.getPlayer().getEnergyPalette().fillEnergies();
		model.getPlayer().gainEnergy();
		model.getPlayer().draw();
	}
	
	public void playStartPhase() {
		
	}
	
	public void playPlayPhase() {
		
		inPlayPhase = true;
	}
	
	public void playEndPhase() {
		
		inPlayPhase = false;
		model.endTurn();
		startTurn();
	}
	
	//TRIVIAL METHODS
	public void setModel( ModelConnector model) {
		
		this.model = model;
	}

	public boolean isInPlayPhase() {
		return inPlayPhase;
	}
}
