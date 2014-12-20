package edu.ew.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * 
 * @author Selcuk Gulcan
 * 
 * TODO: Add description
 *
 */
@SuppressWarnings("serial")
public class MainMenuPanel extends JPanel {

	public MainMenuPanel() {
			
		super();
		
		JButton playButton;
		JButton editDeckButton;
		JButton creditsButton;
		JButton exitButton;
		
		playButton = new JButton( "Play a Game");
		editDeckButton = new JButton( "Edit Decks");
		creditsButton = new JButton( "Credits");
		exitButton = new JButton( "Exit");
		
		this.setBackground( ViewConstants.backgroundColor);
		
		playButton.setFont( ViewConstants.buttonFont);
		editDeckButton.setFont( ViewConstants.buttonFont);
		creditsButton.setFont( ViewConstants.buttonFont);
		exitButton.setFont( ViewConstants.buttonFont);
		
		this.setLayout( new BoxLayout( this, BoxLayout.Y_AXIS));
		
		playButton.setAlignmentX( Component.CENTER_ALIGNMENT);
		editDeckButton.setAlignmentX( Component.CENTER_ALIGNMENT);
		creditsButton.setAlignmentX( Component.CENTER_ALIGNMENT);
		exitButton.setAlignmentX( Component.CENTER_ALIGNMENT);
		
		exitButton.addActionListener( new ExitButtonListener());
		creditsButton.addActionListener( new CreditsButtonListener());
		
		add( Box.createRigidArea( new Dimension( 0, 100)));
		add( playButton);
		add( Box.createRigidArea( new Dimension( 0, 20)));
		add( editDeckButton);
		add( Box.createRigidArea( new Dimension( 0, 20)));
		add( creditsButton);
		add( Box.createRigidArea( new Dimension( 0, 20)));
		add( exitButton);
	}
	
	public class ExitButtonListener implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			System.exit(0);
		}
	}
	
	public class CreditsButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			MainFrame frame = (MainFrame) SwingUtilities.getWindowAncestor(MainMenuPanel.this);
			frame.changePanel( new CreditPanel());
		}		
	}
}
