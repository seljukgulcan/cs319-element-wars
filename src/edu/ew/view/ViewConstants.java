package edu.ew.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

/**
 * 
 * @author Selcuk Gulcan
 * 
 * TODO: Add description
 */
public class ViewConstants {

	//Frame Constants
	public static String frameTitle = "Element Wars Card Game";
	public static int frameWidth = 1000;
	public static int frameHeight = 600;
	public static Dimension frameSize = new Dimension( frameWidth, frameHeight);
	
	//Button Constants
	public static Font buttonFont = new Font("Verdana", Font.PLAIN, 11);
	
	//Panel Constants
	public static Color backgroundColor = Color.WHITE;
	
	//Credits Constants
	public static String creditsFilePath = "assets/credits";
	
	//Exception Constants
	public static String missingFileEx = "Error: One or more files needed to run the game are missing.";
	public static String corruptedFileEx = "Error: One or more files needed to run the game are corrupted.";
	
	//PreferredSizes Constants
	public static Dimension preferredTextField = new Dimension( 200, 25);
	
	//CardViewPanel Constants
	public static Dimension cardViewPanelSize = new Dimension( 300 ,frameHeight);
	
	//CardListPanel Constants
	public static Dimension cardListPanelSize = new Dimension( 250 ,frameHeight);
	
	//FilterPanel Constants
	public static Dimension filterPanelSize = new Dimension( cardListPanelSize.width, 100);
}
