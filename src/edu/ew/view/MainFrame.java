package edu.ew.view;

import java.io.IOException;

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
		
		try {
			ViewConstants.initialize();
		} catch (Exception e) {
			
			System.out.println( "Initialization failed because some files are corrupted.");
			e.printStackTrace();
			System.exit(0);
		}
		MainFrame a = new MainFrame();
	    a.setVisible( true);
	}
}
