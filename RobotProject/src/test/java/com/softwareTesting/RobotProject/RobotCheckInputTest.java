package com.softwareTesting.RobotProject;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
// R13
@RunWith(Parameterized.class)
public class RobotCheckInputTest {

	// Check Commands (U,D,R,L,M 3,C,P)
	//valid input
		private String input;
			
	
		public RobotCheckInputTest(String input) {
		super();
		this.input = input;
	}

		@Parameters
		public static String[] testInputs() {
			String[] commands = {"U","u","D","d","R","r","L","l","C","c","P","p","Q","q"};
			return commands;
		}
		
		@Test
		public void testCheckInputTestValidInput() {
			Robot robo = new Robot();
			assertEquals(true, robo.checkInput(input));
		}
		
		@Test
		public void testCheckInputTestValid_I() {
			Robot robo = new Robot();
			assertEquals(true, robo.checkInput("I 10"));
		}
		
		@Test
		public void testCheckInputTestValid_M() {
			Robot robo = new Robot();
			assertEquals(true, robo.checkInput("m 3"));
		}
		
		
		//Invalid Inputs
		@Test
		public void testCheckInputInvalidLength() {
			Robot robo = new Robot();
			assertEquals(false, robo.checkInput(input+"  "));
		}
		
		@Test
		public void testCheckInputInvalidCommand() {
			Robot robo = new Robot();
			assertEquals(false, robo.checkInput(input+" 3"));
		}
		
		 
		@Test
		public void testCheckInputInvalidSymbol() {
			Robot robo = new Robot();
			assertEquals(false, robo.checkInput(" $"));
		}
		

}
