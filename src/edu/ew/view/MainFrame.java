package edu.ew.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel panel;
	
	public MainFrame() {
		
		super( ViewConstants.frameTitle);
		getContentPane().setPreferredSize( ViewConstants.frameSize);
		setResizable(false);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    pack();
	    panel = new MainMenuPanel();
	    add( panel);
	    setLocationRelativeTo(null);
	}
	
	public void changePanel( JPanel panel) {
		
		remove( this.panel);
		this.panel = panel;
		add( panel);
		pack();
	}
	
	public static void main( String args[]) {
		
		MainFrame a = new MainFrame();
	    a.setVisible( true);
	}
}
