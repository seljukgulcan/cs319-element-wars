package edu.ew.view;

import java.util.Observable;
import java.util.Observer;

public class ConsoleView implements Observer{

	public static void echo( String message) {
		
		System.out.println( message);
	}
	
	public ConsoleView() {
		
		echo( "ConsoleView constructed");
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
