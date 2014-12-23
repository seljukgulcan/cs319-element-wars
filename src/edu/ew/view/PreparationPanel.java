package edu.ew.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import edu.ew.model.DeckIO;

@SuppressWarnings("serial")
public class PreparationPanel extends CenteredBoxPanel {

	JTextField nameField;
	JComboBox<String> deckSelect, opponentSelect;
	
	public PreparationPanel() {
		
		setBackground( ViewConstants.backgroundColor);
		setBorder( BorderFactory.createEmptyBorder());
		
		//Initializations
		nameField = new JTextField();
		nameField.setPreferredSize( ViewConstants.preferredTextField);
		nameField.setMaximumSize( nameField.getPreferredSize() );
		
		JButton mainMenuButton = new JButton( "Main Menu");
		mainMenuButton.setFont( ViewConstants.buttonFont);
		mainMenuButton.addActionListener( new MainMenuListener());
		
		JButton playGameButton = new JButton( "Play");
		playGameButton.setFont( ViewConstants.buttonFont);
		playGameButton.addActionListener( new PlayGameListener());
		
		deckSelect = new JComboBox<String>();
		deckSelect.setFont( ViewConstants.buttonFont);
		deckSelect.addItem( "Default");
		
		ArrayList<String> names = DeckIO.getAllDeckNames();
		for( int i = 0; i < names.size(); i++) {
			
			if( !names.get( i).equals( "Default"))
				deckSelect.addItem( names.get(i));
		}
		deckSelect.setPreferredSize( ViewConstants.preferredTextField);
		deckSelect.setMaximumSize( deckSelect.getPreferredSize() );
		
		opponentSelect = new JComboBox<String>();
		opponentSelect.setFont( ViewConstants.buttonFont);
		opponentSelect.addItem( "Passive AI");
		opponentSelect.setPreferredSize( ViewConstants.preferredTextField);
		opponentSelect.setMaximumSize( opponentSelect.getPreferredSize() );
		
		add( Box.createRigidArea( new Dimension( 0, 100)));
		add( new JLabel( "Name:"));
		add( nameField);
		add( Box.createRigidArea( new Dimension( 0, 10)));
		add( new JLabel( "Select a Deck:"));
		add( deckSelect);
		add( Box.createRigidArea( new Dimension( 0, 10)));
		add( new JLabel( "Select an Opponent:"));
		add( opponentSelect);
		add( Box.createRigidArea( new Dimension( 0, 10)));
		add( playGameButton);
		add( Box.createRigidArea( new Dimension( 0, 10)));
		add( mainMenuButton);
		add( Box.createVerticalGlue());
	}
	
	public class MainMenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			MainFrame frame = (MainFrame) SwingUtilities.getWindowAncestor(PreparationPanel.this);
			frame.changePanel( new MainMenuPanel());
		}
	}
	
	public class PlayGameListener implements ActionListener {

		int counter;
		
		public PlayGameListener() {
			
			counter = 1;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			System.out.println( "Test " + counter);
			counter++;
			//TODO: Complete Method
		}
	}
}
