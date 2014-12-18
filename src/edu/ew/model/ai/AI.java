package edu.ew.model.ai;

import java.io.FileNotFoundException;

import edu.ew.model.Deck;
import edu.ew.model.Player;

public class AI extends Player{

	public AI(Side side) throws FileNotFoundException {
		super(side, Deck.getDefaultDeck());
	}

}
