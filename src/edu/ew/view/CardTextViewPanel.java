package edu.ew.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.ew.model.Card;
import edu.ew.model.CharacterCard;

@SuppressWarnings("serial")
public class CardTextViewPanel extends JPanel {

	public CardTextViewPanel( Card card) {
		
		JLabel cardName = null;
		JLabel atkDef = null;
		
		cardName = new JLabel( card.getName());
		
		if( card instanceof CharacterCard)
			atkDef = new JLabel( 	"Atk: " + ((CharacterCard)card).getAttack() +
									"Def: " + ((CharacterCard)card).getHealth());
		else
			atkDef = new JLabel( "");
		
		cardName.setFont( ViewConstants.buttonFont);
		atkDef.setFont( ViewConstants.buttonFont);
		cardName.setAlignmentX( Component.LEFT_ALIGNMENT);
		atkDef.setAlignmentX( Component.LEFT_ALIGNMENT);
		
		add( cardName);
		add( atkDef);
		
		setPreferredSize( new Dimension( 300, 300));
		setLayout( new BoxLayout( this, BoxLayout.Y_AXIS));
		setBackground( ViewConstants.backgroundColor);
		setBorder( BorderFactory.createMatteBorder( 1, 0, 0, 0, Color.black));
	}
}
