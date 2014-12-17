package edu.ew.controller;

import edu.ew.model.ModelConnector;

public class TurnManager {

	ModelConnector model;
	
	public TurnManager( ModelConnector model) {
		
		setModel( model);
	}
	
	public void setModel( ModelConnector model) {
		
		this.model = model;
	}
}
