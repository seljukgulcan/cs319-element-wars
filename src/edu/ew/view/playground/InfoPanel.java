package edu.ew.view.playground;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import edu.ew.controller.ControllerConnector;
import edu.ew.view.MainFrame;
import edu.ew.view.PreparationPanel;
import edu.ew.view.ViewConstants;

/**
 * 
 * @author Selcuk Gulcan
 *
 */
@SuppressWarnings("serial")
public class InfoPanel extends JPanel {
	
	private JButton quitButton;
	private JButton endTurnButton;
	
	private static int TOP_GAP = 10;
	private static Dimension SIZE = new Dimension( 
			ViewConstants.frameWidth - ViewConstants.cardViewPanelSize.width,40);

	public InfoPanel() {
		
		super();
		
		setLayout( new BoxLayout( this, BoxLayout.Y_AXIS));
		setPreferredSize( SIZE);
		setMaximumSize( getPreferredSize());
		setBackground( PlaygroundConstants.background);
		
		quitButton = new JButton( "Quit");
		quitButton.setFont( ViewConstants.buttonFont);
		quitButton.addActionListener( new QuitButtonListener());
		
		endTurnButton = new JButton( "End Turn");
		endTurnButton.setFont( ViewConstants.buttonFont);
		endTurnButton.addActionListener( new EndTurnButtonListener());
		
		JPanel menu = new JPanel();
		menu.setLayout( new BoxLayout( menu, BoxLayout.X_AXIS));
		menu.add( Box.createRigidArea( new Dimension( 5, 0)));
		menu.add( quitButton);
		menu.add( endTurnButton);
		
		add( Box.createRigidArea( new Dimension( 0, TOP_GAP)));
		add( menu);
		
	}
	
	public class QuitButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			// TODO:End game
			MainFrame frame = ((MainFrame) SwingUtilities.getWindowAncestor( InfoPanel.this));
			frame.changePanel( new PreparationPanel());
		}
	}
	
	public class EndTurnButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			ControllerConnector.endTurn();
		}
	}
}
