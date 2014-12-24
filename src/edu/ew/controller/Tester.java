package edu.ew.controller;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import javax.jws.WebParam.Mode;

import edu.ew.model.Account;
import edu.ew.model.CardImporter;
import edu.ew.model.CorruptedFileException;
import edu.ew.model.Deck;
import edu.ew.model.DeckIO;
import edu.ew.model.Hand;
import edu.ew.model.ModelConnector;
import edu.ew.model.Player.Side;

public class Tester {
	
	public static void echo( String message) {
		
		System.out.println( message);
	}

	public static void main( String[] args) throws FileNotFoundException, CorruptedFileException, UnsupportedEncodingException {
		
		/*Deck test = DeckIO.importDeck( "earth-fire");		
		System.out.println( test);
		test.setId( "new-earth-fire");
		test.add( CardImporter.loadCard( 1));
		test.add( CardImporter.loadCard( 1));
		System.out.println( test);
		DeckIO.exportDeck( test);
		
		Deck test2 = DeckIO.importDeck( "sth/new-earth-fire");
		System.out.println( test2);
		
		System.exit( 0);*/
		
		Scanner scanner = new Scanner( System.in);
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
		
		menu();
		
		int choice = -1;
		while( choice != 0) {
			
			choice = scanner.nextInt();
			
			if( choice == 1) {
				
				int cardChoice;
				int posChoice;
				seeHand( model);
				System.out.println( "Choose a card");
				cardChoice = scanner.nextInt();
				
				if( controller.canPlay( cardChoice)) {
					
					seeBoard( model);
					System.out.println( "Select an empty position [0,7]");
					posChoice = scanner.nextInt();
					
					/*if( !controller.playCard( cardChoice, posChoice))
						System.out.println( "Board position is wrong");*/
				}
				
				else {
					
					System.out.println( "You cannot play that card");
				}
			}
			
			else if( choice == 2) {
				
				
			}
			
			else if( choice == 3) {
				
				
			}
			
			else if( choice == 4) {
				
				seeHand( model);
			}
			
			else if( choice == 5) {
				
				seeBoard( model);
			}
			
			else if( choice == 6) {
				
				seePalette( model);
			}
			
			else if( choice == 7) {
				
				controller.endTurn();
			}
			
			if( choice != 0)
				menu();
		}
	}
	
	public static void seeHand( ModelConnector model) {
		
		Hand currentHand = model.getHand( Side.WHITE);
		System.out.println( currentHand);
	}
	
	public static void seeBoard( ModelConnector model) {
		
		System.out.println( model.getActiveGame().getBoard());
	}
	
	public static void seePalette( ModelConnector model) {
		
		System.out.println( model.getPlayer().getEnergyPalette());
	}
	
	public static void menu() {
		
		System.out.println( "----------------------------------------");
		System.out.println( "1 - Play Card");
		System.out.println( "2 - Attack");
		System.out.println( "3 - Convert Energy");
		System.out.println( "4 - See Hand");
		System.out.println( "5 - See Board");
		System.out.println( "6 - See Palette");
		System.out.println( "7 - End Turn");
		System.out.println( "0 - Quit");
		System.out.println( "----------------------------------------");
	}
}
