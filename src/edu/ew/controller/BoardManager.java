package edu.ew.controller;

import edu.ew.model.CharacterCard;
import edu.ew.model.ModelConnector;
import edu.ew.model.Character;

public class BoardManager extends Manager {

	public BoardManager(ModelConnector model) {
		super(model);
	}
	
	public boolean putCharacter( Character character, int position) {
		
		return model.putCharacter(character, position);
	}

	public boolean putCharacter( CharacterCard card, int position) {
		
		return model.putCharacter(card, position);
	}
}
