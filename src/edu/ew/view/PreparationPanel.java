package edu.ew.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import edu.ew.controller.ControllerConnector;
import edu.ew.model.CorruptedFileException;
import edu.ew.model.DeckIO;
import edu.ew.view.playground.PlaygroundPanel;

@SuppressWarnings("serial")
public class PreparationPanel extends CenteredBoxPanel {

	JTextField nameField;
	JComboBox<String> deckSelect, opponentSelect;
	
	public PreparationPanel() {
		
		setBackground( ViewConstants.backgroundColor);
		setBorder( BorderFactory.createEmptyBorder());
		
		//Initializations
		nameField = new JTextField();
		nameField.setText( ControllerConnector.getAccountName());
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
		deckSelect.setSelectedItem( ControllerConnector.getDeckName());
		deckSelect.setPreferredSize( ViewConstants.preferredTextField);
		deckSelect.setMaximumSize( deckSelect.getPreferredSize() );
		
		opponentSelect = new JComboBox<String>();
		opponentSelect.setFont( ViewConstants.buttonFont);
		opponentSelect.addItem( "Passive AI");
		opponentSelect.addItem( "Dump AI");
		
		String aiName = ControllerConnector.getAIName();
		for( int i = 0; i < opponentSelect.getComponentCount(); i++) {
			
			if( opponentSelect.getItemAt( i).toString().equals( aiName)) {
				
				opponentSelect.setSelectedIndex( i);
				break;
			}
		}
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

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String name, deckName, aiName;
			name = nameField.getText();
			deckName = deckSelect.getSelectedItem().toString();
			aiName = opponentSelect.getSelectedItem().toString();
			
			ControllerConnector.setAccount( name, deckName, aiName);
			try {
				ControllerConnector.startGame();
			} catch (FileNotFoundException | CorruptedFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			MainFrame frame = ((MainFrame) SwingUtilities.getWindowAncestor( PreparationPanel.this));
			frame.changePanel( new PlaygroundPanel());
		}
	}
}
