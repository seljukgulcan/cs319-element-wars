package edu.ew.controller;

import java.io.FileNotFoundException;

import edu.ew.model.Card;
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
		model.startGame();
		turnManager.startTurn();
		
		return true;
	}
	
	public boolean playCard( int handPos) {
		
		//TODO: Right Here
		Card card = model.getPlayer().getHand().getCard( handPos);
		if( model.canPlay( card))
			return true;
		
		return false;
	}
	
	public void endTurn() {
		
		model.endTurn();
	}

	public boolean canPlay(int cardChoice) {
		// TODO Auto-generated method stub
		return false;
	}
}
