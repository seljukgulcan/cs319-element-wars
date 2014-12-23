package edu.ew.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;


@SuppressWarnings("serial")
public class CreditPanel extends JPanel {

	public CreditPanel() {
		
		JButton mainMenuButton = new JButton( "Return to Main Menu");
		CenteredBoxPanel credits = new CenteredBoxPanel( );
		JScrollPane scrollPane = new JScrollPane( credits);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		credits.setBackground( ViewConstants.backgroundColor);
		
		mainMenuButton.setFont( ViewConstants.buttonFont);
		mainMenuButton.addActionListener( new MainMenuListener());
		
		setBackground( ViewConstants.backgroundColor);
		setLayout( new BoxLayout( this, BoxLayout.Y_AXIS));
		
		mainMenuButton.setAlignmentX( Component.CENTER_ALIGNMENT);
		scrollPane.setAlignmentX( Component.CENTER_ALIGNMENT);
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader( ViewConstants.creditsFilePath));
			String line;
			while ((line = br.readLine()) != null) {
			   credits.add( new JLabel( line));
			}
			br.close();
		} catch (FileNotFoundException e) {
			credits.add( new JLabel( ViewConstants.missingFileEx));
			e.printStackTrace();
		} catch (IOException e) {
			credits.removeAll();
			credits.add( new JLabel( ViewConstants.corruptedFileEx));
			e.printStackTrace();
		}
		
		add( Box.createRigidArea( new Dimension( 0, 10)));
		add( mainMenuButton);
		add( Box.createRigidArea( new Dimension( 0, 10)));
		add( scrollPane);
		add( Box.createRigidArea( new Dimension( 0, 10)));
	}
	
	public class MainMenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			MainFrame frame = (MainFrame) SwingUtilities.getWindowAncestor(CreditPanel.this);
			frame.changePanel( new MainMenuPanel());
		}
	}
}
