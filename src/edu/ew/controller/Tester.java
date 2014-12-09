package edu.ew.controller;

import java.io.FileNotFoundException;

import edu.ew.model.Card;
import edu.ew.model.CardImporter;

public class Tester {
	
	public static void echo( String message) {
		
		System.out.println( message);
	}

	public static void main( String[] args) {
		
		echo( "Welcome to the Element Wars Game");
		
		//Card Import Test
		Card cardTest = null;
		try {
			cardTest = CardImporter.loadCard( 1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println( cardTest);
	}
}
