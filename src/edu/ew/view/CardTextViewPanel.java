package edu.ew.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.ew.model.Card;
import edu.ew.model.CharacterCard;
import edu.ew.model.EnergySet;

@SuppressWarnings("serial")
public class CardTextViewPanel extends JPanel {
	
	CardViewPanel viewPanel;
	DeckShowPanel deckShowPanel;
	int cardId;
	Card card;
	DeckEditPanel controller;

	public CardTextViewPanel( Card card, DeckEditPanel controller, boolean inCollection) {
		
		this.controller = controller;
		this.card = card;
		setLayout( new BoxLayout( this, BoxLayout.Y_AXIS));
		setBackground( ViewConstants.backgroundColor);
		setPreferredSize( ViewConstants.cardTextViewPanelSize);
		setMaximumSize( getPreferredSize());
		setBorder( BorderFactory.createMatteBorder( 0, 0, 1, 1, Color.black));
		
		JLabel cardName = null;
		JLabel atkDef = null;
		EnergySetPanel cost = null;
		
		cardId = card.getId();
		cardName = new JLabel( card.getName());
		
		if( card instanceof CharacterCard)
			atkDef = new JLabel( 	"Atk: " + ((CharacterCard)card).getAttack() +
									"     Def: " + ((CharacterCard)card).getHealth());
		else
			atkDef = new JLabel( "");
		cost = new EnergySetPanel( card.getCost());
		
		cardName.setFont( ViewConstants.buttonFont);
		atkDef.setFont( ViewConstants.buttonFont);
		cardName.setAlignmentX( Component.LEFT_ALIGNMENT);
		atkDef.setAlignmentX( Component.LEFT_ALIGNMENT);
		cost.setAlignmentX( Component.LEFT_ALIGNMENT);
		
		add( cardName);
		add( Box.createRigidArea( new Dimension(0 ,5)));
		add( atkDef);
		add( Box.createRigidArea( new Dimension(0 ,5)));
		add( cost);
		
		addMouseListener( new CardHoverListener( inCollection));
	}
	
	public CardTextViewPanel( Card card, DeckEditPanel controller) {
		
		this( card, controller, false);
	}
	
	public class CardHoverListener implements MouseListener {

		private boolean inCollection;
		
		public CardHoverListener() {
			
			this.inCollection = false;
		}
		
		public CardHoverListener( boolean inCollection) {
			
			this.inCollection = inCollection;
		}
		
		@Override
		public void mouseClicked(MouseEvent arg0) {}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			
			controller.changePicture( cardId);
		}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			
			if( inCollection) {
				
				controller.addCardToCurrentDeck( card.copy());
			}
			
			else {
				
				controller.removeCardFromCurrentDeck( card);
			}
		}
	}
	
	public class EnergySetPanel extends JPanel {
		
		public EnergySetPanel( EnergySet set) {
			
			setBackground( ViewConstants.backgroundColor);
			for( int i = 0; i < set.getAir(); i++)
				add( new JLabel( ViewConstants.air));
			
			for( int i = 0; i < set.getEarth(); i++)
				add( new JLabel( ViewConstants.earth));
			
			for( int i = 0; i < set.getFire(); i++)
				add( new JLabel( ViewConstants.fire));
			
			for( int i = 0; i < set.getWater(); i++)
				add( new JLabel( ViewConstants.water));
			
			for( int i = 0; i < set.getTrivial(); i++)
				add( new JLabel( ViewConstants.trivial));
		}
	}
}
