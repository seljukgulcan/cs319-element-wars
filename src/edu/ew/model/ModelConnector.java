package edu.ew.model;

import java.io.FileNotFoundException;

import edu.ew.model.Player.Side;
import edu.ew.model.ai.AI;
import edu.ew.model.ai.AIDump;

/**
 * 
 * @author Selcuk Gulcan
 *
 * TODO: Add Description
 */
public class ModelConnector {

	private Account account;
	private Game activeGame;
	
	public ModelConnector() throws FileNotFoundException {
		
		setAccount( new Account());
		activeGame = null;
	}
	
	public ModelConnector( Account account) {
		
		setAccount( account);
		activeGame = null;
	}

	public void setGame() throws FileNotFoundException {
		
		setActiveGame( new Game( account.createPlayer( Side.WHITE), new AIDump( Side.BLACK)));
	}
	
	public void setGame( AI ai) {
		
		setActiveGame( new Game( account.createPlayer( Side.WHITE), ai));
	}
	
	//TRIVIAL METHODS
	public Account getAccount() {
		return account;
	}

	public Game getActiveGame() {
		return activeGame;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setActiveGame(Game activeGame) {
		this.activeGame = activeGame;
	}
}
