package edu.ew.controller;

import java.io.FileNotFoundException;

import edu.ew.model.Account;
import edu.ew.model.Card;
import edu.ew.model.CardImporter;
import edu.ew.model.ModelConnector;

public class Tester {
	
	public static void echo( String message) {
		
		System.out.println( message);
	}

	public static void main( String[] args) throws FileNotFoundException {
		
		echo( "Welcome to the Element Wars Game");
		
		Account me = null;
		try {
			me = new Account( "Shathra");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ModelConnector model = new ModelConnector( me);
		
		//Game Start
		//Before that set decks and create players.
		model.setGame();
		if( model.getActiveGame().startGame())
			System.out.println( "Game is started");
		
		//Card Import Test
		Card cardTest = null;
		try {
			cardTest = CardImporter.loadCard( 1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println( cardTest);
	}
}
