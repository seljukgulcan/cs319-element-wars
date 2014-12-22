package edu.ew.controller;

import java.util.Observable;
import java.util.Observer;

/**
 * 
 * @author Selcuk Gulcan
 *
 * TODO: Add Description
 */
public class ControllerConnector {

	//TODO: Complete the class.
	
	public static void addView( Observable a, Observer b) {
		
		a.addObserver( b);
	}
	
	public static void removeAllViews( Observable a) {
		
		a.deleteObservers();
	}
}
