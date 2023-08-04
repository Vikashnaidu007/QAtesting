package com.softwareTesting.RobotProject;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//Covers R6
@RunWith(Parameterized.class)
public class RobotParameterisedTestCaseTurnRight {
	
	private String input;
	private String expectedOutput;
	
	
	public RobotParameterisedTestCaseTurnRight(String input, String expectedOutput) {
		
		this.input = input;
		this.expectedOutput = expectedOutput;
	}
	

	//R command Test
	@Parameters
	public static Collection<String[]> testDirection() {
		String expectedOutputR[][]={{"north","east"},{"east","south"},{"south","west"},{"west","north"}};
		return Arrays.asList(expectedOutputR);
	}
	
	@Test
	public void testTurnRight() {
		
		Robot robo = new Robot();
		robo.setCurrent_direction(input);
		robo.turnRight();
		
		assertEquals(expectedOutput,robo.getCurrent_direction());	
	}
}
