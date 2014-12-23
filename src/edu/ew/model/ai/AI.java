package edu.ew.model.ai;

import java.io.FileNotFoundException;

import edu.ew.model.CorruptedFileException;
import edu.ew.model.DeckIO;
import edu.ew.model.Player;

public class AI extends Player{

	public AI(Side side) throws FileNotFoundException, CorruptedFileException {
		super(side, DeckIO.importDeck( "Default"));
	}

}
