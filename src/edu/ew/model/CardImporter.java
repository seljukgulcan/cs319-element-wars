package edu.ew.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

/**
 * 
 * TODO: Add description
 * 
 * @author Selcuk Gulcan
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
	
	public static Card loadCard( int id) throws FileNotFoundException {
		
		//Load the file
		File cardFile = new File( CARDS_PATH + id + CARDS_EXTENSION);
		
		//Load the string in the file
		String cardContent = new Scanner( cardFile).useDelimiter("\\Z").next();
		
		//Parse json string
		JsonObject cardJson = JsonObject.readFrom( cardContent );
		
		String 		name;
		Effect 		effect;
		EnergySet 	cost;
		boolean 	isSpell;
		
		name = cardJson.get( "name").asString();
		isSpell = cardJson.get( "is-spell").asBoolean();
		cost = parseCost( cardJson.get( "cost").asArray());
		
		//TODO: Effect parser is not implemented.
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
