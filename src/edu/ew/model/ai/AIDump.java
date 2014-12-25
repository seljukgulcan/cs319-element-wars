package edu.ew.model.ai;

import java.io.FileNotFoundException;

import edu.ew.model.CorruptedFileException;

public class AIDump extends AI {

	public AIDump(Side side) throws FileNotFoundException, CorruptedFileException {
		super(side);
	}

}
