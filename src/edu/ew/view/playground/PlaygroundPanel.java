package edu.ew.view.playground;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JPanel;

import edu.ew.controller.ControllerConnector;
import edu.ew.model.Player.Side;
import edu.ew.view.CardViewPanel;
import edu.ew.view.CenteredBoxPanel;

/**
 * 
 * @author Selcuk Gulcan
 *
 */
@SuppressWarnings("serial")
public class PlaygroundPanel extends JPanel {

	private InfoPanel infoPanel;
	private HandPanel handPanel;
	private EnergyPanel whiteEnergyPanel, blackEnergyPanel;
	private BoardPanel whiteBoardPanel, blackBoardPanel;
	public static CardViewPanel cardViewPanel;
	public static edu.ew.model.Character attacker;
	
	private CenteredBoxPanel rightPanel;
	
	public PlaygroundPanel() {
		
		//Initializations
		infoPanel = new InfoPanel();
		handPanel = new HandPanel();
		whiteBoardPanel = new BoardPanel();
		blackBoardPanel = new BoardPanel( true);
		whiteEnergyPanel = new EnergyPanel();
		blackEnergyPanel = new EnergyPanel();
		rightPanel = new CenteredBoxPanel();
		cardViewPanel = new CardViewPanel();
		attacker = null;
		
		//Size, Background and Layout
		setLayout( new BorderLayout());
		setBackground( PlaygroundConstants.background);
		
		//rightPanel.setBackground( Color.pink);
		rightPanel.setBackground( PlaygroundConstants.background);
		
		//Adding Panels
		rightPanel.add( infoPanel);
		rightPanel.add( blackEnergyPanel);
		rightPanel.add( blackBoardPanel);
		rightPanel.add( Box.createRigidArea( new Dimension( 0 ,4)));
		rightPanel.add( whiteBoardPanel);
		rightPanel.add( whiteEnergyPanel);
		rightPanel.add( handPanel);
		
		ControllerConnector.addView( ControllerConnector.getHand( Side.WHITE), handPanel);
		ControllerConnector.addView( ControllerConnector.getDeck( Side.WHITE), handPanel);
		ControllerConnector.addView( ControllerConnector.getEnergyPalette( Side.WHITE), whiteEnergyPanel);
		ControllerConnector.addView( ControllerConnector.getEnergyPalette( Side.BLACK), blackEnergyPanel);
		ControllerConnector.addView( ControllerConnector.getBoard(), whiteBoardPanel);
		ControllerConnector.addView( ControllerConnector.getBoard(), blackBoardPanel);
		add( cardViewPanel, BorderLayout.WEST);
		add( rightPanel, BorderLayout.CENTER);
	}
}
