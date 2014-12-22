package edu.ew.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class DeckEditPanel extends JPanel {
	
	CardViewPanel cardViewPanel;
	CardListPanel cardListPanel;
	DeckShowPanel deckShowPanel;

	public DeckEditPanel() {
		
		setLayout( new BorderLayout());
		setBackground( ViewConstants.backgroundColor);
		
		cardViewPanel = new CardViewPanel();
		add( cardViewPanel, BorderLayout.WEST);
		
		cardListPanel = new CardListPanel( cardViewPanel);
		add( cardListPanel, BorderLayout.EAST);
		
		deckShowPanel = new DeckShowPanel( cardViewPanel);
		add( deckShowPanel, BorderLayout.CENTER);
	}
}
