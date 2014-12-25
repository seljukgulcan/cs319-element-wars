package edu.ew.view.playground;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import edu.ew.controller.ControllerConnector;
import edu.ew.model.Character;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.ew.model.Board;
import edu.ew.model.Player.Side;
import edu.ew.view.ViewConstants;

/**
 * 
 * @author Selcuk Gulcan
 *
 */
@SuppressWarnings("serial")
public class BoardPanel extends JPanel implements Observer{
	
	private static Dimension SIZE = new Dimension( 
			ViewConstants.frameWidth - ViewConstants.cardViewPanelSize.width-50, 135);
	private static Dimension CHAR_SIZE = new Dimension( SIZE.width, 102);
	private static Dimension STAT_SIZE = new Dimension( SIZE.width, SIZE.height - CHAR_SIZE.height - 2);
	private static String CHARACTER_PATH = "assets/character-images/";
	private static String CHARACTER_EXTENSION = ".png";

	private Side side;
	private ArrayList<JPanel> images;
	private ArrayList<JPanel> stats;
	
	private JPanel imagesPanel;
	private JPanel statsPanel;
	
	public BoardPanel() {
		
		this( false);
	}
	
	public BoardPanel( boolean upsideDown) {
		
		super();
		
		side = upsideDown ? Side.BLACK : Side.WHITE;
		
		setLayout( new BoxLayout( this, BoxLayout.Y_AXIS));
		setPreferredSize( SIZE);
		setMaximumSize( getPreferredSize());
		setBackground( PlaygroundConstants.background);
		
		imagesPanel = new JPanel( new GridLayout( 1, 8, 10, 0));
		imagesPanel.setPreferredSize( CHAR_SIZE);
		imagesPanel.setMaximumSize( imagesPanel.getPreferredSize());
		imagesPanel.setBackground( PlaygroundConstants.background);
		
		images = new ArrayList<JPanel>();
		for( int i = 0; i < 8; i++) {
			
			images.add( new JPanel());
			((FlowLayout) (images.get(i).getLayout())).setVgap(0);
			//images.get( i).setBackground( Color.yellow);
			images.get( i).setBackground( PlaygroundConstants.background);
			images.get( i).setBorder( BorderFactory.createLineBorder( Color.black, 1));
			imagesPanel.add( images.get(i));
		}
		
		statsPanel = new JPanel( new GridLayout( 1, 8));
		statsPanel.setPreferredSize( STAT_SIZE);
		statsPanel.setMaximumSize( imagesPanel.getPreferredSize());
		
		stats = new ArrayList<JPanel>();
		for( int i = 0; i < 8; i++) {
			
			stats.add( new JPanel());
			((FlowLayout) (stats.get(i).getLayout())).setVgap(0);
			//stats.get( i).setBackground( Color.red);
			stats.get( i).setBackground( PlaygroundConstants.background);
			statsPanel.add( stats.get(i));
		}
		
		stats.get(0).add( new JLabel("0"));
		
		if( upsideDown) {
			
			add( statsPanel);
			add( imagesPanel);
		}
		
		else {
			
			add( imagesPanel);
			add( statsPanel);
		}
	}
	
	public void clear() {
		
		for( int i = 0; i < images.size(); i++) {
			
			images.get( i).removeAll();
			stats.get(i).removeAll();
		}
	}
	
	public void addCharacter( Character character, int index) {
		
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File( CHARACTER_PATH + character.getId() + CHARACTER_EXTENSION));
		} catch (IOException e) {
			System.out.println( CHARACTER_PATH + character.getId() + CHARACTER_EXTENSION);
			e.printStackTrace();
		}
		images.get(index).add( new JLabel( new ImageIcon( myPicture)));
		images.get(index).addMouseListener( new CharacterMouseListener(character));
		stats.get( index).add( new JLabel( character.getAttack() + " / " + character.getDefence()));
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		clear();
		
		Board board = ((Board)arg0);
		ArrayList<Character> chars = board.getSide( side);
		
		for( int i = 0; i < chars.size(); i++) {
			
			Character current = chars.get( i);
			
			if( current != null) {
				
				addCharacter( current, i);
			}
		}
		
		update( getGraphics());
	}
	
	public class CharacterMouseListener implements MouseListener {

		Character character;
		
		public CharacterMouseListener( Character character) {
			
			this.character = character;
		}
		
		@Override
		public void mouseClicked(MouseEvent arg0) {}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			
			PlaygroundPanel.cardViewPanel.changePicture( character.getId());
		}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if( side == Side.WHITE) {
				
				boolean attack = character.getCanAttack();
				if( attack && PlaygroundPanel.attacker == null) {
					
					PlaygroundPanel.attacker = character;
					//PlaygroundPanel.attackCursor();
				}
			}
		}
	}
}
