package edu.ew.model;

import java.io.FileNotFoundException;

import edu.ew.model.Player.Side;
import edu.ew.model.ai.AI;
import edu.ew.model.ai.AIDump;

/**
 * This class handles background of gameplay
 * 	such as check of characters, check of turns etc...
 * 
 * @author Selcuk Gulcan
 * @author Serdar Demirkol
 * @author Umut Hicyilmaz
 *
 */
public class ModelConnector {

	private Account account;
	private Game activeGame;
	
	public ModelConnector() throws FileNotFoundException, CorruptedFileException {
		
		setAccount( new Account());
		activeGame = null;
	}
	
	/**
	 * Creates model for game
	 * 
	 * @param account
	 */
	public ModelConnector( Account account) {
		
		setAccount( account);
		activeGame = null;
	}
	
	/**
	 * Represents current situation on board
	 * 
	 * @return board
	 */
	public Board getBoard() {
		
		return activeGame.getBoard();
	}
	
	/**
	 * Helps user to discard unwanted card/s
	 * 
	 * @param card
	 */
	public void discard( Card card) {
		
		discard( card, turnOf());
	}
	
	/**
	 * Puts discarded card to side
	 * 
	 * @param card
	 * @param side
	 */
	public void discard( Card card, Side side) {
		
		Player p = getPlayer( side);
		p.discard( card);
	}
	
	/**
	 * Gets card to hand in given index of side
	 * 
	 * @param index
	 */
	public Card getCard( int index) {
		
		return getHand().getCard( index);
	}
	
	/**
	 * Gets card from side with given index and puts it in hand
	 * 
	 * @param side
	 * @param card
	 */
	public Card getCard( int index, Side side) {
		
		return getHand( side).getCard( index);
	}
	
	/**
	 * Gets character and puts it in given position of board
	 * 
	 * @param character
	 * @param position
	 * @param side
	 */
	public boolean putCharacter( Character character, int position, Side side) {
		
		return activeGame.getBoard().putCharacter(character, position, side);
	}
	
	/**
	 * Checks if character can be put or not to board
	 * 
	 * @param character
	 * @param position
	 */
	public boolean putCharacter( Character character, int position) {
		
		return activeGame.getBoard().putCharacter(character, position, turnOf());
	}
	
	/**
	 * Checks if character can be put or not to board
	 * 
	 * @param character
	 * @param position
	 * @param side
	 */
	public boolean putCharacter( CharacterCard card, int position, Side side) {
		
		return activeGame.getBoard().putCharacter(card, position, side);
	}
	
	/**
	 * Checks if character can be put or not to board
	 * 
	 * @param card
	 * @param position
	 */
	public boolean putCharacter( CharacterCard card, int position) {
		
		return activeGame.getBoard().putCharacter(card, position, turnOf());
	}
	
	/**
	 * Checks whether that card can be played
	 * 
	 * @param card
	 */
	public boolean canPlay( Card card) {
		
		return canPlay( turnOf(), card);
	}
	
	/**
	 * Checks whether that card can be played
	 * 
	 * @param card
	 * @param side
	 */
	public boolean canPlay( Side side, Card card) {
		
		Player p = getPlayer( side);
		return p.canPlay(card);
	}
	
	/**
	 * Chaecks whether that card can be played or not
	 * 	if conversion made
	 * 
	 * @param card
	 */
	public boolean canPlayWithConversion( Card card) {
		
		return canPlayWithConversion( turnOf(), card);
	}
	
	/**
	 * Checks whether that card can be played or not if conversion is made
	 * 
	 * @param side
	 * @param card
	 */
	public boolean canPlayWithConversion( Side side, Card card) {
		
		Player p = getPlayer( side);
		return p.canPlayWithConversion(card);
	}
	
	/**
	 * Gets player to play to each side of the game
	 * 
	 * @param side
	 */
	public Player getPlayer( Side side) {
		
		switch( side) {
		case BLACK:
			return activeGame.getPlayerBlack();
		case WHITE:
			return activeGame.getPlayerWhite();		
		}
		
		return null;
	}
	
	/**
	 * Gets player to play
	 */
	public Player getPlayer() {
		
		return getPlayer( activeGame.turnOf());
	}
	
	/**
	 * Indicates that turn is of for player
	 */
	public Side turnOf() {
		
		return activeGame.turnOf();
	}
	
	/**
	 * Ends turn and turn to play goes to other player
	 */
	public void endTurn() {
		
		activeGame.endTurn();
	}
	
	/**
	 * Gets hand to play
	 */
	public Hand getHand() {
		
		return getHand( turnOf());
	}
	
	/**
	 * Gets hand to play from side
	 * 
	 * @param side
	 */
	public Hand getHand( Side side) {
		
		switch( side) {
		case BLACK:
			return activeGame.getPlayerBlack().getHand();
		case WHITE:
			return activeGame.getPlayerWhite().getHand();
		}
		
		return null;
	}

	/**
	 * Crates game 
	 * 
	 * @exception java.io.FileNotFoundException if wrong file argument was passed
	 * @exception java.io.CorruptedFileException if file is changed/corrupted unauthorized
	 */
	public void createGame() throws FileNotFoundException, CorruptedFileException {
		
		setActiveGame( new Game( account.createPlayer( Side.WHITE), new AIDump( Side.BLACK)));
	}
	
	/**
	 * Creates game with ai
	 * 
	 * @param ai
	 */
	public void createGame( AI ai) {
		
		setActiveGame( new Game( account.createPlayer( Side.WHITE), ai));
	}
	
	/**
	 * Checks whether game is started or not
	 * 
	 * @return boolean equivalent of game start
	 */
	public boolean startGame() {
		
		return activeGame.startGame();
	}
	
	/**
	 * Checks whether there is a already started game
	 * 
	 * @return boolean equivalent of game start
	 */
	public boolean isGameStarted() {
		
		if( activeGame == null)
			return false;
		
		return activeGame.isGameStarted();
	}
	
	/**
	 * Checks whether the game is ended or not
	 * 
	 * @return boolean equivalent of game end
	 */
	public boolean isGameEnded() {
		
		if( activeGame == null)
			return false;
		
		return activeGame.isGameEnded();
	}
	
	/**
	 * Resigning from the game
	 * 
	 * @param side
	 */
	public void resign(Side side) {
		
		activeGame.resign( side);
	}
	
	//TRIVIAL METHODS
	/**
	 * Gets account
	 * 
	 * @return acoount
	 */
	public Account getAccount() {
		return account;
	}
	
	/**
	 * Gets activeGame
	 * 
	 * @return activeGame
	 */
	public Game getActiveGame() {
		return activeGame;
	}
	
	/**
	 * Initializes acoount to given account
	 * 
	 * @param account
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	
	/**
	 * Initializes activeGame to given activeGame
	 * 
	 * @param activeGame
	 */
	public void setActiveGame(Game activeGame) {
		this.activeGame = activeGame;
	}
}
