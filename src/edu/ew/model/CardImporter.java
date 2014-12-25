package edu.ew.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

/**
 * This class gets cards to decks
 * 
 * @author Selcuk Gulcan
 * @author Serdar Demirkol
 * @author Umut Hicyilmaz
 *
 */
public class CardImporter {

	private static final String CARDS_PATH = "assets/cards/";
	private static final String CARDS_EXTENSION = ".card";
	
	private static EnergySet parseCost( JsonArray arr) {
		
		EnergySet toReturn;
		
		toReturn = new EnergySet();

		for (Energy current : Energy.values()) {
		    
			int value = arr.get( current.ordinal()).asInt();
			if( value != 0)
				toReturn.setEnergy( current, value);
		}
		
		return toReturn;
	}
	
	/**
	 * Gets all cards to deck
	 * 
	 * @exception java.io.FileNotFoundException if wrong file argument was passed
	 */
	public static Deck loadAllCards() throws FileNotFoundException {
		
		Deck deck = new Deck();
		File folder = new File( CARDS_PATH);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			
			String fileName = listOfFiles[i].getName();
			int id = Integer.parseInt( fileName.substring( 0, fileName.lastIndexOf( '.')));
			deck.add( loadCard( id));
		}
		
		return deck;
	}
	
	/**
	 * Loads cards according to their id
	 * 
	 * @param id
	 * 
	 * @exception java.io.FileNotFoundException if wrong file argument was passed
	 */
	public static Card loadCard( int id) throws FileNotFoundException {
		
		//Load the file
		File cardFile = new File( CARDS_PATH + id + CARDS_EXTENSION);
		
		//Load the string in the file
		Scanner scanner = new Scanner( cardFile);
		String cardContent = scanner.useDelimiter("\\Z").next();
		scanner.close();
		
		//Parse json string
		JsonObject cardJson = JsonObject.readFrom( cardContent );
		
		String 		name;
		Effect 		effect;
		EnergySet 	cost;
		boolean 	isSpell;
		
		name = cardJson.get( "name").asString();
		isSpell = cardJson.get( "is-spell").asBoolean();
		cost = parseCost( cardJson.get( "cost").asArray());
		
		effect = null;
		JsonValue effectValue = cardJson.get( "effect");
		if( effectValue == null)
			effect = null;
		
		Card cardToReturn = null;
		if( isSpell) {
			
			cardToReturn = new SpellCard( id, name, cost, effect);
		}
		
		else {
			
			int attack;
			int health;
			
			attack = cardJson.get( "attack").asInt();
			health = cardJson.get( "health").asInt();
			
			cardToReturn = new CharacterCard( id, name, cost, effect, attack, health);
		}
		
		return cardToReturn;
	}
}
