package edu.ew.model;

/**
 * 
 * @author Selcuk Gulcan
 *
 * 
 */
@SuppressWarnings("serial")
public class CorruptedFileException extends Exception {

	public CorruptedFileException(String string) {
		
		super( string);
	}
}
