package com.softwareTesting.RobotProject;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String input;
		do {
		
			System.out.println("------------------------------------------------------------------");
			System.out.println("\n");
			System.out.println("Welcome User");
			System.out.println("\n");
			System.out.println("!! Activate the Robot using command I and Provide floor size !!");
			System.out.println("\n");
			System.out.println("------------------------------------------------------------------");
			System.out.println("\n");
	    
			Robot robo = new Robot();
	   
			//getting user input
			String command = robo.getUserInput();
	    
			//Check for Initial input
			boolean pass = robo.checkInitialInput(command);
	    
			input = robo.commandScreen(pass,command);
			
		}while(input != "Q");
	    	
	    
	    
	    
	}

}
