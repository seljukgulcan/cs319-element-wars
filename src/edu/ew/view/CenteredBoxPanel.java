package edu.ew.view;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Component;

/**
 * 
 * @author Selcuk Gulcan
 *
 * 
 */
@SuppressWarnings("serial")
public class CenteredBoxPanel extends JPanel {
	
	public CenteredBoxPanel() {
		
		super();
		setLayout( new BoxLayout( this, BoxLayout.Y_AXIS));
	}

	@Override
	public Component add( Component c) {
		
		((JComponent)c).setAlignmentX( Component.CENTER_ALIGNMENT);
		return super.add( c);
	}
}
