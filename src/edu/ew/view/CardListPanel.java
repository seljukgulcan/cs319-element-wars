package edu.ew.view;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import edu.ew.model.Card;
import edu.ew.model.CardImporter;
import edu.ew.model.Deck;

@SuppressWarnings("serial")
public class CardListPanel extends CenteredBoxPanel {

	FilterPanel filterPanel;
	DeckEditPanel controller;
	
	public CardListPanel( DeckEditPanel controller) {
		
		this.controller = controller;
		
		setPreferredSize( ViewConstants.cardListPanelSize);
		setBackground( ViewConstants.backgroundColor);
		
		JPanel listPanel = new CenteredBoxPanel();
		listPanel.setBackground( ViewConstants.backgroundColor);
		JScrollPane scrollPane = new JScrollPane( listPanel);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		
		filterPanel = new FilterPanel();
		
		//add( filterPanel);
		add( scrollPane);
		
		Deck deck = null;
		try {
			deck = CardImporter.loadAllCards();
		} catch (FileNotFoundException e) {
			
			JOptionPane.showMessageDialog( SwingUtilities.getWindowAncestor( this), 
					"Fatal Error. Card files are corrupted. Exiting...");
			e.printStackTrace();
			System.exit( 0);
		}
		
		Iterator<Card> it = deck.iterator();
		while( it.hasNext()) {
			
			listPanel.add( new CardTextViewPanel( it.next(), controller, true));
		}
	}
	
	public class FilterPanel extends JPanel {
		
		public FilterPanel() {
			
			setPreferredSize( ViewConstants.filterPanelSize);
			setLayout( new BoxLayout( this, BoxLayout.Y_AXIS));
			setMaximumSize( getPreferredSize() );
			setBorder( BorderFactory.createMatteBorder( 0, 0, 1, 0, Color.black));
			setBackground(ViewConstants.backgroundColor);
			
			add( new JTextField());
			add( new JButton( "Search"));
		}
	}
}
