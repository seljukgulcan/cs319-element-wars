package edu.ew.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import com.eclipsesource.json.JsonObject;

/**
 * 
 * @author Selcuk Gulcan
 *
 */
public class Setting {
	
	private static String SETTING_PATH = "assets/settings";

	public static String getName() throws FileNotFoundException {
		
		return getSettings().get( "name").asString();
	}
	
	public static String getDeckName() throws FileNotFoundException {
		
		return getSettings().get( "deck").asString();
	}
	
	public static String getAIName() throws FileNotFoundException {
		
		return getSettings().get( "ai").asString();
	}
	
	public static void setSettings( String name, String deckName, String aiName) throws FileNotFoundException {
		
		JsonObject settings = getSettings();
		
		settings.set( "name", name);
		settings.set( "deck", deckName);
		settings.set( "ai", aiName);
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter( SETTING_PATH, "UTF-8");
		} catch (Exception e) {
			
			System.out.println( "Setting.setSettings() method is used wrong.");
			e.printStackTrace();
		}

		writer.println( settings.toString());
		
		writer.close();
	}
	
	private static JsonObject getSettings() throws FileNotFoundException {
		
		//Load the setting file
		File settingFile = new File( SETTING_PATH);
		
		//Load the string in the file
		Scanner scanner = new Scanner( settingFile);
		String settingContent = scanner.useDelimiter("\\Z").next();
		scanner.close();
		
		//Get json object
		JsonObject settingJson = JsonObject.readFrom( settingContent );
		return settingJson;		
	}
}
