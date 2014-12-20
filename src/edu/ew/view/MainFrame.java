package edu.ew.view;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	public MainFrame() {
		
		super( ViewConstants.frameTitle);
		getContentPane().setPreferredSize( ViewConstants.frameSize);
		setResizable(false);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    pack();
	    add( new MainMenuPanel());
	    setLocationRelativeTo(null);
	}
	
	public static void main( String args[]) {
		
		MainFrame a = new MainFrame();
	    a.setVisible( true);
	}
}
