package edu.ew.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;

import edu.ew.model.*;
import edu.ew.model.Character;
import edu.ew.model.Player.Side;

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
	
	public boolean playCard( Card c, Side side) {
		
		if( model.turnOf() != side)
			return false;
		
		int boardPos = -1;
		ArrayList<Character> chars = model.getBoard().getSide( side);
		for( int i = 0; i < chars.size(); i++) {
			
			if( chars.get( i) == null) {
				
				boardPos = i;
				break;
			}
		}
		
		if( boardPos == -1)
			return false;
		
		return playCard( c, boardPos);
	}
	
	public boolean playCard( Card c, int boardPos) {
		
		//Right now, assuming all cards are character cards
		CharacterCard card = (CharacterCard) c;
		if( !model.canPlay( card)) {
			
			if( model.getPlayer().getNoOfConvert() == 1) {
				
				if( model.canPlayWithConversion( card)) {
					
					if( !model.putCharacter(card, boardPos))
						return false;
					
					model.getPlayer().convert( card.getCost());
					model.getPlayer().consume( card.getCost());
					model.getPlayer().discard( card);
					return true;
				}
				
				else {
					
					return false;
				}
			}
			
			
			else {
				return false;
			}
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
		turnManager.startTurn();
		
		//Passive AI
		if( model.turnOf() == Side.BLACK) {
			
			model.endTurn();
			turnManager.startTurn();
		}
	}

	public boolean canPlay(int cardChoice) {
		
		return model.canPlay( model.getCard( cardChoice));
	}
	
	public String getAccountName() {
		
		return model.getAccount().getName();
	}
	
	public String getDeckName() {
		
		return model.getAccount().getDeck().getId();
	}
	
	public String getAIName() {
		
		return model.getAccount().getAIName();
	}
	
	public void setAccount( String name, String deckName, String aiName) {
		
		try {
			Setting.setSettings(name, deckName, aiName);
		} catch (FileNotFoundException e) {
			
			System.out.println( "Fatal Error. Setting file is missing.");
			e.printStackTrace();
			System.exit(0);
		}
		
		model.getAccount().setName( name);
		try {
			model.getAccount().setDeck( DeckIO.importDeck( deckName));
		} catch (FileNotFoundException | CorruptedFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.getAccount().setAIName( aiName);
	}

	public Hand getHand(Side side) {
		
		return model.getHand(side);
	}

	public EnergyPalette getEnergyPalette(Side side) {
		
		return model.getPlayer( side).getEnergyPalette();
	}

	public Board getBoard() {

		return model.getBoard();
	}

	public Observable getDeck(Side side) {
		
		return model.getPlayer(side).getDeck();
	}

	public void resign(Side side) {
		
		model.resign( side);
	}
}
