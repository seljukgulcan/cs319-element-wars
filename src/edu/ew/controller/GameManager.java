package edu.ew.controller;

import edu.ew.model.ModelConnector;

public class GameManager extends Manager{

	ActionManager 	actionManager;
	BoardManager 	boardManager;
	CombatManager 	combatManager;
	TurnManager 	turnManager;
	
	ModelConnector	model;
	
	public GameManager( ModelConnector model) { 
		
		super( model);
		this.actionManager 	= new ActionManager( model);
		this.boardManager 	= new BoardManager( model);
		this.combatManager 	= new CombatManager( model);
		this.turnManager 	= new TurnManager( model);
	}
}
