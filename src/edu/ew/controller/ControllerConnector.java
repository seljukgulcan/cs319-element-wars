package edu.ew.controller;

import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;

import edu.ew.model.*;
import edu.ew.model.Player.Side;
import edu.ew.view.MainFrame;
import edu.ew.view.ViewConstants;

/**
 * This class sets boundaries for user during gameplay
 * 
 * @author Selcuk Gulcan
 * @author Serdar Demirkol
 * @author Umut Hicyilmaz
 * 
 */
public class ControllerConnector {

	//TODO: Complete the class.
	private static GameManager controller;
	
	/**
	 * Adds observers to internal list of observers
	 * 
	 * @param a observable
	 * @param b observer
	 */
	public static void addView( Observable a, Observer b) {
		
		a.addObserver( b);
		b.update( a, null);
	}
	
	/**
	 * Deletes all observers in internal observer list
	 * 
	 * @param a observable
	 */
	public static void removeAllViews( Observable a) {
		
		a.deleteObservers();
	}
	/**
	 * Starts the game
	 * 
	 * @exception java.io.FileNotFoundException if wrong File argument was passed
	 */
	public static void startGame() throws FileNotFoundException, CorruptedFileException {
		
		controller.startGame();
	}
	
	/**
	 * Gets hand from deck
	 */
	public static Hand getHand( Side side) {

		return controller.getHand( side);

	}
	
	/**
	 * Gets an account name for user to have name in the game
	 */
	public static String getAccountName() {
		
		return controller.getAccountName();
	}
	
	/**
	 * Asks specific name for that deck from the user
	 */
	public static String getDeckName() {
		
		return controller.getDeckName();
	}
	
	/**
	 * Asks a name for AI from user
	 */
	public static String getAIName() {
		
		return controller.getAIName();
	}
	
	/**
	 * Creates account based on information taken from user
	 * 
	 * @param name
	 * @param deckName
	 * @param aiName
	 */
	public static void setAccount( String name, String deckName, String aiName) {
		
		controller.setAccount( name, deckName, aiName);
	}
	
	/**
	 * Starts program and handles exceptions
	 */
	public static void main( String[] args) {
		
		Account me = null;

		try {
			me = new Account();
		} catch (FileNotFoundException e1) {
			
			System.out.println( "Initialization failed. Setting file is missing or corrupted.");
			e1.printStackTrace();
			System.exit( 0);
		} catch (CorruptedFileException e1) {
			
			System.out.println( "Initialization failed. Setting file is missing or corrupted.");
			e1.printStackTrace();
			System.exit( 0);
		}
		
		/**
		 * Creates model and controller to use in game
		 */
		ModelConnector model = new ModelConnector( me);
		controller = new GameManager( model);
		
		try {
			ViewConstants.initialize();
		} catch (Exception e) {
			
			System.out.println( "Initialization failed because some files are corrupted.");
			e.printStackTrace();
			System.exit(0);
		}
		MainFrame a = new MainFrame();
	    a.setVisible( true);
	}

	/**
	 * Creates frames for visualization of game
	 */
	public static EnergyPalette getEnergyPalette(Side side) {
		
		return controller.getEnergyPalette( side);
	}

	/**
	 * Checks whether the card is played or not
	 * 
	 * @return true if card is played
	 */
	public static boolean playCard(Card card, Side side) {
		
		return controller.playCard( card, side);
	}

	/**
	 * When player selects his hand, he may want to get rid of some card/s
	 * 	this method handles this situation
	 */
	public static void discard(Card card, Side side) {
		
		controller.model.discard(card, side);
	}

	/**
	 * After cards are played those should stand in board as long as
	 * 	they have health left
	 */
	public static Board getBoard() {
		
		return controller.getBoard();
	}

	/**
	 * Gets deck for player to use
	 */
	public static Observable getDeck(Side side) {
		
		return controller.getDeck( side);
	}

	/**
	 * When player is done with what he do for that turn
	 * 	player ends turn and turn goes to other player
	 */
	public static void endTurn() {
		
		controller.endTurn();
	}

	/**
	 * When player thinks that he is beaten, he resigns and ends the game
	 * 	in which case he loses
	 */
	public static void resign(Side side) {
		
		controller.resign( side);
	}
}
