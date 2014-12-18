package edu.ew.controller;

import java.io.FileNotFoundException;

import edu.ew.model.Account;
import edu.ew.model.Hand;
import edu.ew.model.ModelConnector;
import edu.ew.model.Player.Side;

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
		GameManager controller = new GameManager( model);
		
		//Game Start
		//Before that set decks and create players.
		if( controller.startGame())
			System.out.println( "Game is started");
		
		//a line
		Hand currentHand = model.getHand( Side.WHITE);
		System.out.println( "White hand:");
		System.out.println( currentHand);
		
	}
}
