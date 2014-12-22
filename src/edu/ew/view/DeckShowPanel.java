package edu.ew.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.text.View;

import edu.ew.model.Card;
import edu.ew.model.CardImporter;

@SuppressWarnings("serial")
public class DeckShowPanel extends JPanel{
	
	DeckCardsPanel deckMainPanel;

	public DeckShowPanel( CardViewPanel cardViewPanel) {
		
		setLayout( new BoxLayout( this, BoxLayout.Y_AXIS));
		setBorder( BorderFactory.createMatteBorder( 0, 1, 0, 1, Color.black));
		setBackground( Color.gray);
		
		JPanel topControlPanel = new JPanel();
		topControlPanel.setBackground( ViewConstants.backgroundColor);
		topControlPanel.setLayout( new BoxLayout( topControlPanel, BoxLayout.Y_AXIS));
		topControlPanel.setPreferredSize( 
				new Dimension( ViewConstants.frameWidth - ViewConstants.cardListPanelSize.width - ViewConstants.cardViewPanelSize.width, 
				ViewConstants.filterPanelSize.height));
		topControlPanel.setMaximumSize( topControlPanel.getPreferredSize());
		//topControlPanel.setBorder( BorderFactory.createMatteBorder( 0, 0, 1, 0, Color.black));
		
		JButton mainMenuButton = new JButton( "Main Menu");
		mainMenuButton.setFont( ViewConstants.buttonFont);
		topControlPanel.add( mainMenuButton);
		mainMenuButton.addActionListener( new MainMenuButtonListener());
		
		deckMainPanel = new DeckCardsPanel( cardViewPanel);
		JScrollPane deckMainPanelContainer = new JScrollPane( deckMainPanel);
		
		add( topControlPanel);
		add( deckMainPanelContainer);
	}
	
	public class MainMenuButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame frame = (MainFrame) SwingUtilities.getWindowAncestor(DeckShowPanel.this);
			frame.changePanel( new MainMenuPanel());
		}	
	}
	
	public class DeckCardsPanel extends JPanel {
		
		CardViewPanel cardView;
		
		public DeckCardsPanel( CardViewPanel panel) {
			
			cardView = panel;
			WrapLayout layout = new WrapLayout();
			layout.setAlignment( FlowLayout.LEFT);
			layout.setHgap( 0);
			layout.setVgap( 0);
			setLayout( layout);
			
			Card c = null;
			try {
				c = CardImporter.loadCard( 1);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			addCard( c);
			addCard( c);
			addCard( c);
			addCard( c);
			addCard( c);
		}
		
		public void addCard( Card card) {
			
			add( new CardTextViewPanel( card, cardView));
		}
	}
}
