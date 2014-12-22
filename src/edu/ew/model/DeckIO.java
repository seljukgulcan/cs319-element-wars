package edu.ew.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 
 * @author Selcuk Gulcan
 *
 * TODO: Add description
 */
public class DeckIO {

	public static final String DECKS_PATH = "assets/decks/";
	public static final String DECKS_EXTENSION = ".deck";
	
	public static Deck importDeck( String id) throws FileNotFoundException, CorruptedFileException {
		
		File cardFile = new File( DECKS_PATH + id + DECKS_EXTENSION);
		Scanner scanner = new Scanner( cardFile);
		Deck deck = new Deck();
		
		try {
			int n = scanner.nextInt();
			for( int i = 0; i < n; i++) {
				
				int cardId = scanner.nextInt();
				deck.add( CardImporter.loadCard( cardId));
			}
		}
		catch( Exception e) {
			
			throw new CorruptedFileException( "Deck file is corrupted");
		}
		
		return deck;
	}
	
	public static void exportDeck( Deck deck, String id) {
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter( DECKS_PATH + id + DECKS_EXTENSION, "UTF-8");
		} catch (Exception e) {
			
			System.out.println( "DeckIO.exportDeck() method is used wrong.");
			e.printStackTrace();
		}
		Iterator<Card> it = deck.iterator();
		
		writer.println( deck.getNoOfCards());
		while( it.hasNext()) {
			
			writer.println( it.next().getId());
		}
		
		writer.close();
	}
	
	public static Deck importAllCards() {
		
		return null;
	}
}
