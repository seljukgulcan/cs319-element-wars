package edu.ew.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CardViewPanel extends JPanel {

	public CardViewPanel() {
		
		setPreferredSize( ViewConstants.cardViewPanelSize);
		setBackground( ViewConstants.backgroundColor);
		setLayout( new BoxLayout( this, BoxLayout.Y_AXIS));
		
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File( "assets/card-images/1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		add(picLabel);
	}
}
