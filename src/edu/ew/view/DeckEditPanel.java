package edu.ew.view;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import edu.ew.model.Card;
import edu.ew.model.Deck;

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
		
		cardListPanel = new CardListPanel( this);
		add( cardListPanel, BorderLayout.EAST);
		
		deckShowPanel = new DeckShowPanel( this);
		add( deckShowPanel, BorderLayout.CENTER);
		
		deckShowPanel.getDeckCardsPanel().update();
	}
	
	public void addCardToCurrentDeck( Card card) {
		
		deckShowPanel.getDeckCardsPanel().addCardToCurrentDeck( card);
	}
	
	public void removeCardFromCurrentDeck( Card card) {
		
		deckShowPanel.getDeckCardsPanel().removeCardFromCurrentDeck( card);
	}
	
	public void setCurrentDeck( Deck deck) {
		
		deckShowPanel.getDeckCardsPanel().setCurrentDeck( deck);
	}
	
	public void changePicture( int cardId) {
		
		cardViewPanel.changePicture( cardId);
	}
	
	public void saveDeck() {
		
		deckShowPanel.getDeckCardsPanel().saveCurrentDeck();
	}
	
	public boolean isCurrentDeckChanged() {
		
		return deckShowPanel.getDeckCardsPanel().isChanged();
	}
	
	public Deck getCurrentDeck() {
		
		return deckShowPanel.getDeckCardsPanel().getCurrentDeck();
	}
			
	
	public int saveBeforeGo() {
		
		if( !isCurrentDeckChanged())
			return 1;
		
		int result = JOptionPane.showConfirmDialog((Component) null, "Do you want to save the deck","Save Deck", JOptionPane.YES_NO_CANCEL_OPTION);
		if( result == 0)
			saveDeck();
		return result;
	}
	
	public void setCurrentDeckChanged( boolean status) {
		
		deckShowPanel.getDeckCardsPanel().setChanged( status);
	}
}
