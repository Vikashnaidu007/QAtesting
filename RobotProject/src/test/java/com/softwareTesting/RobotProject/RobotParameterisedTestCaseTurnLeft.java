package com.softwareTesting.RobotProject;

import static org.junit.Assert.*;


import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
// covers R7
@RunWith(Parameterized.class)
public class RobotParameterisedTestCaseTurnLeft {
	
	private String input;
	private String expectedOutput;
	
	
	public RobotParameterisedTestCaseTurnLeft(String input, String expectedOutput) {
		
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	//L command Test
		@Parameters
		public static Collection<String[]> testDirectionLeft(){
			String expectedOutputL[][]={{"north","west"},{"east","north"},{"south","east"},{"west","south"}};
			return Arrays.asList(expectedOutputL);
		}
		
		@Test
		public void testTurnLeft() {
			
			Robot robo = new Robot();
			robo.setCurrent_direction(input);
			robo.turnLeft();
			
			assertEquals(expectedOutput,robo.getCurrent_direction());	
		}
		

}
