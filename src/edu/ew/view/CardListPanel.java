package edu.ew.view;

import java.awt.Color;
import java.awt.Dimension;
import java.io.FileNotFoundException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import edu.ew.model.CardImporter;

@SuppressWarnings("serial")
public class CardListPanel extends CenteredBoxPanel {

	FilterPanel filterPanel;
	
	public CardListPanel() {
		
		setPreferredSize( ViewConstants.cardListPanelSize);
		setBackground( ViewConstants.backgroundColor);
		
		JPanel listPanel = new JPanel();
		listPanel.setLayout( new BoxLayout( listPanel, BoxLayout.Y_AXIS));
		JScrollPane scrollPane = new JScrollPane( listPanel);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		
		filterPanel = new FilterPanel();
		
		add( filterPanel);
		add( scrollPane);
		try {
			listPanel.add( new CardTextViewPanel( CardImporter.loadCard( 1)));
			listPanel.add( new CardTextViewPanel( CardImporter.loadCard( 2)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public class FilterPanel extends JPanel {
		
		public FilterPanel() {
			
			setPreferredSize( ViewConstants.filterPanelSize);
			setMaximumSize( getPreferredSize() );
			//setBackground( Color.black);
			setBackground(ViewConstants.backgroundColor);
			
			add( new JTextField());
			add( new JButton( "Search"));
		}
	}
}
