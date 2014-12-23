package edu.ew.model;

import java.io.FileNotFoundException;

import edu.ew.model.Player.Side;
import edu.ew.model.ai.AI;
import edu.ew.model.ai.AIDump;

/**
 * 
 * @author Selcuk Gulcan
 *
 * TODO: Add Description
 */
public class ModelConnector {

	private Account account;
	private Game activeGame;
	
	public ModelConnector() throws FileNotFoundException, CorruptedFileException {
		
		setAccount( new Account());
		activeGame = null;
	}
	
	public ModelConnector( Account account) {
		
		setAccount( account);
		activeGame = null;
	}
	
	public Board getBoard() {
		
		return activeGame.getBoard();
	}
	
	public void discard( Card card) {
		
		discard( card, turnOf());
	}
	
	public void discard( Card card, Side side) {
		
		Player p = getPlayer( side);
		p.discard( card);
	}
	
	public Card getCard( int index) {
		
		return getHand().getCard( index);
	}
	
	public Card getCard( int index, Side side) {
		
		return getHand( side).getCard( index);
	}
	
	public boolean putCharacter( Character character, int position, Side side) {
		
		return activeGame.getBoard().putCharacter(character, position, side);
	}
	
	public boolean putCharacter( Character character, int position) {
		
		return activeGame.getBoard().putCharacter(character, position, turnOf());
	}
	
	public boolean putCharacter( CharacterCard card, int position, Side side) {
		
		return activeGame.getBoard().putCharacter(card, position, side);
	}
	
	public boolean putCharacter( CharacterCard card, int position) {
		
		return activeGame.getBoard().putCharacter(card, position, turnOf());
	}
	
	public boolean canPlay( Card card) {
		
		return canPlay( turnOf(), card);
	}
	
	public boolean canPlay( Side side, Card card) {
		
		Player p = getPlayer( side);
		return p.canPlay(card);
	}
	
	public boolean canPlayWithConversion( Card card) {
		
		return canPlayWithConversion( turnOf(), card);
	}
	
	public boolean canPlayWithConversion( Side side, Card card) {
		
		Player p = getPlayer( side);
		return p.canPlayWithConversion(card);
	}
	
	public Player getPlayer( Side side) {
		
		switch( side) {
		case BLACK:
			return activeGame.getPlayerBlack();
		case WHITE:
			return activeGame.getPlayerWhite();		
		}
		
		return null;
	}
	
	public Player getPlayer() {
		
		return getPlayer( activeGame.turnOf());
	}
	
	public Side turnOf() {
		
		return activeGame.turnOf();
	}
	
	public void endTurn() {
		
		activeGame.endTurn();
	}
	
	public Hand getHand() {
		
		return getHand( turnOf());
	}
	
	public Hand getHand( Side side) {
		
		switch( side) {
		case BLACK:
			return activeGame.getPlayerBlack().getHand();
		case WHITE:
			return activeGame.getPlayerWhite().getHand();
		}
		
		return null;
	}

	public void createGame() throws FileNotFoundException, CorruptedFileException {
		
		setActiveGame( new Game( account.createPlayer( Side.WHITE), new AIDump( Side.BLACK)));
	}
	
	public void createGame( AI ai) {
		
		setActiveGame( new Game( account.createPlayer( Side.WHITE), ai));
	}
	
	public boolean startGame() {
		
		return activeGame.startGame();
	}
	
	public boolean isGameStarted() {
		
		if( activeGame == null)
			return false;
		
		return activeGame.isGameStarted();
	}
	
	public boolean isGameEnded() {
		
		if( activeGame == null)
			return false;
		
		return activeGame.isGameEnded();
	}
	
	//TRIVIAL METHODS
	public Account getAccount() {
		return account;
	}

	public Game getActiveGame() {
		return activeGame;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setActiveGame(Game activeGame) {
		this.activeGame = activeGame;
	}
}
