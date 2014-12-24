package edu.ew.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * 
 * @author Selcuk Gulcan
 * 
 * TODO: Add description
 */
public class ViewConstants {

	//Frame Constants
	public static String frameTitle = "Element Wars Card Game";
	public static int frameWidth = 1080;
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
	public static final Dimension preferredTextField = new Dimension( 200, 25);
	
	//CardViewPanel Constants
	public static final Dimension cardViewPanelSize = new Dimension( 300 ,frameHeight);
	
	//CardListPanel Constants
	public static final Dimension cardListPanelSize = new Dimension( 200 ,frameHeight);
	public static final Dimension cardTextViewPanelSize = new Dimension( cardListPanelSize.width - 20, 75);
	
	//FilterPanel Constants
	public static final Dimension filterPanelSize = new Dimension( cardListPanelSize.width, 60);
	
	//Energy Icons
	public static ImageIcon air;
	public static ImageIcon earth;
	public static ImageIcon fire;
	public static ImageIcon water;
	public static ImageIcon trivial;
	
	public static ImageIcon airBig;
	public static ImageIcon earthBig;
	public static ImageIcon fireBig;
	public static ImageIcon waterBig;
	public static ImageIcon pureBig;
	
	public static ImageIcon life;
	public static ImageIcon cardBack;
	public static ImageIcon cardBackBig;
	
	public static void initialize() throws IOException {
		
		ViewConstants.air = new ImageIcon( ImageIO.read(new File( "assets/images/air.png")));
		ViewConstants.earth = new ImageIcon( ImageIO.read(new File( "assets/images/earth.png")));
		ViewConstants.fire = new ImageIcon( ImageIO.read(new File( "assets/images/fire.png")));
		ViewConstants.water = new ImageIcon( ImageIO.read(new File( "assets/images/water.png")));
		ViewConstants.trivial = new ImageIcon( ImageIO.read(new File( "assets/images/trivial.png")));
		
		ViewConstants.airBig = new ImageIcon( ImageIO.read(new File( "assets/images/air-big.png")));
		ViewConstants.earthBig = new ImageIcon( ImageIO.read(new File( "assets/images/earth-big.png")));
		ViewConstants.fireBig = new ImageIcon( ImageIO.read(new File( "assets/images/fire-big.png")));
		ViewConstants.waterBig = new ImageIcon( ImageIO.read(new File( "assets/images/water-big.png")));
		ViewConstants.pureBig = new ImageIcon( ImageIO.read(new File( "assets/images/pure-big.png")));
		
		ViewConstants.life = new ImageIcon( ImageIO.read(new File( "assets/images/life.png")));
		ViewConstants.cardBack = new ImageIcon( ImageIO.read(new File( "assets/images/cardback.png")));
		ViewConstants.cardBackBig = new ImageIcon( ImageIO.read(new File( "assets/images/cardback-big.png")));
	}
}
