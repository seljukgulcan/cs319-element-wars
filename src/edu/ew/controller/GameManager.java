package edu.ew.controller;

import java.io.FileNotFoundException;

import edu.ew.model.ModelConnector;

public class GameManager extends Manager{

	ActionManager 	actionManager;
	BoardManager 	boardManager;
	CombatManager 	combatManager;
	TurnManager 	turnManager;
	
	public GameManager( ModelConnector model) { 
		
		super( model);
		this.actionManager 	= new ActionManager( model);
		this.boardManager 	= new BoardManager( model);
		this.combatManager 	= new CombatManager( model);
		this.turnManager 	= new TurnManager( model);
	}
	
	public boolean startGame() throws FileNotFoundException {
		
		if( model.isGameStarted() && !model.isGameEnded())
			return false;
		
		model.createGame();
		return model.startGame();
	}
}
