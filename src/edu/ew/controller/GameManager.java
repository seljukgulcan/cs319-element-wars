package edu.ew.controller;

import java.io.FileNotFoundException;

import edu.ew.model.CharacterCard;
import edu.ew.model.CorruptedFileException;
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
	
	public boolean startGame() throws FileNotFoundException, CorruptedFileException {
		
		if( model.isGameStarted() && !model.isGameEnded())
			return false;
		
		model.createGame();
		model.startGame();
		turnManager.startTurn();
		
		return true;
	}
	
	public boolean playCard( int handPos, int boardPos) {
		
		//Right now, assuming all cards are character cards
		CharacterCard card = (CharacterCard) model.getPlayer().getHand().getCard( handPos);
		if( !model.canPlay( card)) {
			
			if( model.getPlayer().getNoOfConvert() == 1) {
				
				if( model.canPlayWithConversion( card)) {
					
					if( !model.putCharacter(card, boardPos))
						return false;
					
					model.getPlayer().consume( card.getCost());
					model.getPlayer().discard( card);
				}
				
				else {
					
					return false;
				}
			}
			
			else
				return false;
			return false;
		}
		
		else {
			
			if( !model.putCharacter(card, boardPos))
				return false;
			
			model.getPlayer().consume( card.getCost());
			model.getPlayer().discard( card);
			return true;
		}
	}
	
	public void endTurn() {
		
		model.endTurn();
	}

	public boolean canPlay(int cardChoice) {
		
		return model.canPlay( model.getCard( cardChoice));
	}
}
