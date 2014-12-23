package edu.ew.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import edu.ew.model.Card;
import edu.ew.model.CorruptedFileException;
import edu.ew.model.Deck;
import edu.ew.model.DeckIO;

@SuppressWarnings("serial")
public class DeckShowPanel extends JPanel{
	
	private DeckCardsPanel deckMainPanel;
	private JComboBox<String> deckSelect;
	private DeckEditPanel controller;

	public DeckShowPanel( DeckEditPanel controller) {
		
		this.controller = controller;
		
		//Constants
		final int TOP_GAP = 0;
		
		JButton saveButton, newDeckButton, deleteButton;
		
		setLayout( new BoxLayout( this, BoxLayout.Y_AXIS));
		setBorder( BorderFactory.createMatteBorder( 0, 1, 0, 1, Color.black));
		setBackground( ViewConstants.backgroundColor);
		
		JPanel topControlPanel = new JPanel();
		topControlPanel.setBackground( ViewConstants.backgroundColor);
		topControlPanel.setLayout( new BoxLayout( topControlPanel, BoxLayout.X_AXIS));
		topControlPanel.setPreferredSize( 
				new Dimension( ViewConstants.frameWidth - ViewConstants.cardListPanelSize.width - ViewConstants.cardViewPanelSize.width, 
				ViewConstants.filterPanelSize.height - TOP_GAP));
		topControlPanel.setMaximumSize( topControlPanel.getPreferredSize());
		//topControlPanel.setBorder( BorderFactory.createMatteBorder( 0, 0, 1, 0, Color.black));
		
		deckSelect = new JComboBox<String>();
		deckSelect.setFont( ViewConstants.buttonFont);
		deckSelect.addItem( "Default");
		
		ArrayList<String> names = DeckIO.getAllDeckNames();
		for( int i = 0; i < names.size(); i++) {
			
			if( !names.get( i).equals( "Default"))
				deckSelect.addItem( names.get(i));
		}
		deckSelect.setPreferredSize( ViewConstants.preferredTextField);
		deckSelect.setMaximumSize( deckSelect.getPreferredSize() );
		deckSelect.addItemListener( new DeckSelectListener());
		
		saveButton = new JButton( "Save");
		saveButton.setFont( ViewConstants.buttonFont);
		saveButton.addActionListener( new SaveButtonListener());
		newDeckButton = new JButton( "New Deck");
		newDeckButton.setFont( ViewConstants.buttonFont);
		newDeckButton.addActionListener( new NewDeckListener());
		deleteButton = new JButton( "Delete");
		deleteButton.setFont( ViewConstants.buttonFont);
		deleteButton.addActionListener( new DeleteDeckButtonListener());
		
		topControlPanel.add( Box.createRigidArea( new Dimension( 5, 0)));
		topControlPanel.add( deckSelect);
		topControlPanel.add( Box.createRigidArea( new Dimension( 5, 0)));
		topControlPanel.add( saveButton);
		topControlPanel.add( Box.createRigidArea( new Dimension( 5, 0)));
		topControlPanel.add( newDeckButton);
		topControlPanel.add( Box.createRigidArea( new Dimension( 5, 0)));
		topControlPanel.add( deleteButton);
		
		JButton mainMenuButton = new JButton( "Main Menu");
		mainMenuButton.setFont( ViewConstants.buttonFont);
		topControlPanel.add( mainMenuButton);
		mainMenuButton.addActionListener( new MainMenuButtonListener());
		
		deckMainPanel = new DeckCardsPanel();
		JScrollPane deckMainPanelContainer = new JScrollPane( deckMainPanel);
		
		add( Box.createRigidArea( new Dimension( 0, TOP_GAP)));
		add( topControlPanel);
		add( deckMainPanelContainer);
	}
	
	public DeckCardsPanel getDeckCardsPanel() {
		
		return deckMainPanel;
	}
	
	public class SaveButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
		
			controller.saveDeck();
			controller.setCurrentDeckChanged( false);
		}
	}
	
	public class DeckSelectListener implements ItemListener{
	    @Override
	    public void itemStateChanged(ItemEvent event) {
	       if (event.getStateChange() == ItemEvent.SELECTED) {
	          String item = (String) event.getItem();
	          
	          System.out.println( "chagned");
	          int result = controller.saveBeforeGo();
	          
	          if( result != 2) {
	        	  
	        	  try {
					controller.setCurrentDeck( DeckIO.importDeck( item));
				} catch (Exception e) {
					e.printStackTrace();
				}
	          }
	       }
	    }       
	}
	
	public class NewDeckListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int result = controller.saveBeforeGo();
			if( result == 2)
				return;
			
			String name = JOptionPane.showInputDialog( SwingUtilities.getWindowAncestor( DeckShowPanel.this), 
					"Enter deck name:");
			
			if( name != null && !name.equals("")) {
				
				Deck deck = new Deck();
				deck.setId( name);
				DeckIO.exportDeck( deck);
				deckSelect.addItem( name);
				controller.setCurrentDeck( deck);
				deckSelect.setSelectedItem( name);
			}
		}
	}
	
	public class DeleteDeckButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if( controller.getCurrentDeck().getId() == "Default") {
				
				JOptionPane.showMessageDialog( SwingUtilities.getWindowAncestor( DeckShowPanel.this),
						"You cannot delete the Default deck");
				return;
			}
			
			int result = JOptionPane.showConfirmDialog((Component) null, "Are you sure to delete the deck","Save Deck", JOptionPane.YES_NO_OPTION);
			
			if( result == 0) {
				
				Deck current = controller.getCurrentDeck();
				controller.setCurrentDeckChanged( false);
				deckSelect.removeItem( current.getId());
				deckSelect.setSelectedItem("Default");
				
				try {
					DeckIO.deleteDeck( current.getId());
					controller.setCurrentDeck( DeckIO.importDeck( "Default"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CorruptedFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public class MainMenuButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int result = controller.saveBeforeGo();
			if( result == 2)
				return;
			
			MainFrame frame = (MainFrame) SwingUtilities.getWindowAncestor(DeckShowPanel.this);
			frame.changePanel( new MainMenuPanel());
		}	
	}
	
	public class DeckCardsPanel extends JPanel implements Observer{
		
		private Deck current;
		private boolean changed;
		
		public DeckCardsPanel() {
			
			current = null;
			WrapLayout layout = new WrapLayout();
			layout.setAlignment( FlowLayout.LEFT);
			layout.setHgap( 0);
			layout.setVgap( 0);
			setLayout( layout);
			
			try {
				setCurrentDeck( DeckIO.importDeck( "Default"));
			} catch (FileNotFoundException e) {
				
				JOptionPane.showMessageDialog( SwingUtilities.getWindowAncestor( this), 
						"Fatal Error. Default deck file is missing. Exiting...");
				e.printStackTrace();
				System.exit( 0);
			} catch (CorruptedFileException e) {
				
				JOptionPane.showMessageDialog( SwingUtilities.getWindowAncestor( this), 
						"Fatal Error. Default deck file is corrupted. Exiting...");
				System.exit( 0);
				e.printStackTrace();
			}
			
			changed = false;
		}
		
		private void addCard( Card card) {
			
			add( new CardTextViewPanel( card, controller));
		}
		
		public boolean isChanged() {
			
			return changed;
		}
		
		public void setChanged( boolean status) {
			
			changed = status;
		}
		
		public void removeCardFromCurrentDeck( Card card) {
			
			current.remove( card);
			changed = true;
		}
		
		public void addCardToCurrentDeck( Card card) {
			
			current.add( card);
			changed = true;
		}
		
		public void setCurrentDeck( Deck deck) {
			
			if( current != null)
				current.deleteObserver( this);
			this.current = deck;
			this.changed = false;
			current.addObserver( this);
			update( current, null);
		}

		@Override
		public void update(Observable arg0, Object arg1) {
			
			Iterator<Card> it = ((Deck)arg0).iterator();
			
			removeAll();
			
			while( it.hasNext()) {
				
				addCard( it.next());
			}
			
			MainFrame frame = (MainFrame) SwingUtilities.getWindowAncestor( this);
			
			if( frame != null) {
				frame.pack();
			}
			
			update( getGraphics());
		}
		
		public void update() {
			
			update( current, null);
		}

		public void saveCurrentDeck() {
			
			DeckIO.exportDeck( current);
		}

		public Deck getCurrentDeck() {
			return current;
		}
	}
}
