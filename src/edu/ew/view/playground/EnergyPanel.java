package edu.ew.view.playground;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.ew.model.Energy;
import edu.ew.model.EnergyPalette;
import edu.ew.model.EnergySet;
import edu.ew.view.ViewConstants;

/**
 * 
 * @author Selcuk Gulcan
 *
 */
@SuppressWarnings("serial")
public class EnergyPanel extends JPanel implements Observer{
	
	private static final Dimension SIZE = new Dimension( 
			ViewConstants.frameWidth - ViewConstants.cardViewPanelSize.width, 70);
	private static final Dimension SIZE_ONE = new Dimension( 70, 70);
	
	private ArrayList<OneEnergy> energies;

	public EnergyPanel() {
		
		super();
		
		setLayout( new GridLayout( 1, 11));
		setPreferredSize( SIZE);
		setMaximumSize( getPreferredSize());
		setBackground( PlaygroundConstants.background);
		
		energies = new ArrayList<OneEnergy>();
		for( int i = 0; i < 10; i++)
			energies.add( new OneEnergy());
		
		for( int i = 0; i < 5; i++)
			add( energies.get( i));
		
		add( new JLabel( ViewConstants.life));
		
		for( int i = 5; i < 10; i++)
			add( energies.get( i));
	}
	
	public void setEnergy( int index, Energy energy) {
		
		energies.get(index).set(energy);
	}
	
	public void addEnergy( Energy energy) {
		
		getFirstEmpty().set( energy);
	}
	
	public void clear() {
		
		Iterator<OneEnergy> it = energies.iterator();
		while( it.hasNext()) {
			
			OneEnergy current = it.next();
			current.removeAll();
			current.setFull( false);
		}
	}
	
	public void addUsedEnergy( Energy energy) {
		
		OneEnergy slot = getFirstEmpty();
		slot.set( energy);
		slot.use();
	}
	
	public OneEnergy getFirstEmpty() {
		
		for( int i = 0; i < energies.size(); i++)
			if( !energies.get(i).isFull())
				return energies.get(i);
		
		return null;
	}
	
	public class OneEnergy extends JPanel {
		
		private boolean full;
		
		public OneEnergy() {
			
			setPreferredSize( SIZE_ONE);
			setMaximumSize( getPreferredSize());
			setBackground( PlaygroundConstants.background);
			full = false;
		}
		
		public boolean isFull() {
			
			return full;
		}
		
		public void setFull( boolean status) {
			
			full = status;
		}
		
		public void use() {
			
			setBackground( Color.gray);
			update( getGraphics());
			revalidate();
			repaint();
		}
		
		public void set( Energy energy) {
			
			full = true;
			removeAll();
			switch (energy) {
			case AIR:
				add( new JLabel( ViewConstants.airBig));
				break;
			case EARTH:
				add( new JLabel( ViewConstants.earthBig));
				break;
			case FIRE:
				add( new JLabel( ViewConstants.fireBig));
				break;
			case PURE:
				add( new JLabel( ViewConstants.pureBig));
				break;
			case TRIVIAL:
				break;
			case WATER:
				add( new JLabel( ViewConstants.waterBig));
				break;
			default:
				break;
			}
			
			update( getGraphics());
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		
		clear();
		EnergyPalette palette = (EnergyPalette)o;
		
		EnergySet max = palette.getMaxEnergies();
		EnergySet active = palette.getActiveEnergies();
		int no = 0;
		
		no = max.getAir() - active.getAir();
		for( int i = 0; i < no; i++)
			addUsedEnergy( Energy.AIR);
		for( int i = 0; i < active.getAir(); i++)
			addEnergy( Energy.AIR);
		
		no = max.getEarth() - active.getEarth();
		for( int i = 0; i < no; i++)
			addUsedEnergy( Energy.EARTH);
		for( int i = 0; i < active.getEarth(); i++)
			addEnergy( Energy.EARTH);
		
		no = max.getFire() - active.getFire();
		for( int i = 0; i < no; i++)
			addUsedEnergy( Energy.FIRE);
		for( int i = 0; i < active.getFire(); i++)
			addEnergy( Energy.FIRE);
		
		no = max.getWater() - active.getWater();
		for( int i = 0; i < no; i++)
			addUsedEnergy( Energy.WATER);
		for( int i = 0; i < active.getWater(); i++)
			addEnergy( Energy.WATER);
		
		no = max.getPure() - active.getPure();
		for( int i = 0; i < no; i++) {
			addUsedEnergy( Energy.PURE);
		}
		for( int i = 0; i < active.getPure(); i++) {
			addEnergy( Energy.PURE);
		}
		
		update( getGraphics());
	}
}
