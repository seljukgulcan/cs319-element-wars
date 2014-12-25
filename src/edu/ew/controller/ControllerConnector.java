package edu.ew.controller;

import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;

import edu.ew.model.*;
import edu.ew.model.Player.Side;
import edu.ew.view.MainFrame;
import edu.ew.view.ViewConstants;

/**
 * 
 * @author Selcuk Gulcan
 *
 * TODO: Add Description
 */
public class ControllerConnector {

	//TODO: Complete the class.
	private static GameManager controller;
	
	public static void addView( Observable a, Observer b) {
		
		a.addObserver( b);
		b.update( a, null);
	}
	
	public static void removeAllViews( Observable a) {
		
		a.deleteObservers();
	}
	
	public static void startGame() throws FileNotFoundException, CorruptedFileException {
		
		controller.startGame();
	}
	
	public static Hand getHand( Side side) {

		return controller.getHand( side);

	}
	
	public static String getAccountName() {
		
		return controller.getAccountName();
	}
	
	public static String getDeckName() {
		
		return controller.getDeckName();
	}
	
	public static String getAIName() {
		
		return controller.getAIName();
	}
	
	public static void setAccount( String name, String deckName, String aiName) {
		
		controller.setAccount( name, deckName, aiName);
	}
	
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

	public static EnergyPalette getEnergyPalette(Side side) {
		
		return controller.getEnergyPalette( side);
	}

	public static boolean playCard(Card card, Side side) {
		
		return controller.playCard( card, side);
	}

	public static void discard(Card card, Side side) {
		
		controller.model.discard(card, side);
	}

	public static Board getBoard() {
		
		return controller.getBoard();
	}

	public static Observable getDeck(Side side) {
		
		return controller.getDeck( side);
	}

	public static void endTurn() {
		
		controller.endTurn();
	}

	public static void resign(Side side) {
		
		controller.resign( side);
	}
}
