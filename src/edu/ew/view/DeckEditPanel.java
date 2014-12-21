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

	public DeckEditPanel() {
		
		setLayout( new BorderLayout());
		setBackground( ViewConstants.backgroundColor);
		
		cardViewPanel = new CardViewPanel();
		add( cardViewPanel, BorderLayout.WEST);
		
		cardListPanel = new CardListPanel();
		add( cardListPanel, BorderLayout.EAST);
		
		//Edit
		JButton back = new JButton( "back");
		back.addActionListener( new MainMenuButtonListener());
		add( back, BorderLayout.CENTER);
	}
	
	public class MainMenuButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame frame = (MainFrame) SwingUtilities.getWindowAncestor(DeckEditPanel.this);
			frame.changePanel( new MainMenuPanel());
		}	
	}
}
