package com.softwareTesting.RobotProject;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;



public class RobotTest {
	
	
//covers requirement R1,R2,R13,R14
	//UserInput Test
	// TS14 - R14
	@Test
	public void getUserInputtest() {
		Robot robo = new Robot();
		String Output = "I 10";
		String input = "I 10";
		InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String actualOutput = robo.getUserInput();
	    
        assertEquals(Output, actualOutput);
	}
	
	//Initial Command I 10 test
	//Valid Input
	@Test
	public void testCheckInitialInputTestValidInput() {
		Robot robo = new Robot();
		assertEquals(true, robo.checkInitialInput("I 10"));
	}
	
	@Test
	public void testCheckInitialInputTestValidInputLowercase() {
		Robot robo = new Robot();
		assertEquals(true, robo.checkInitialInput("i 10"));
	}
	
	//Invalid Input
	@Test
	public void testCheckInitialInputTestInValidInput() {
		Robot robo = new Robot();
		assertEquals(false, robo.checkInitialInput("M 1"));
	}
	
	@Test
	public void testCheckInitialInputTestInValidInputOnlyChar() {
		Robot robo = new Robot();
		assertEquals(false, robo.checkInitialInput("I"));
	}
	
	@Test
	public void testCheckInitialInputTestInvalidInputOnlyNo() {
		Robot robo = new Robot();
		assertEquals(false, robo.checkInitialInput("3"));
	}
	
	@Test
	public void testCheckInitialInputTestInvalidInputCharSpace() {
		Robot robo = new Robot();
		assertEquals(false, robo.checkInitialInput("i "));
	}
	
	@Test
	public void testCheckInitialInputTestInvalidInputSymbol() {
		Robot robo = new Robot();
		assertEquals(false, robo.checkInitialInput("$ #"));
	}
	
	@Test
	public void testCheckInitialInputTestInvalidInputS() {
		Robot robo = new Robot();
		assertEquals(false, robo.checkInitialInput(""));
	}
	
	
	//InitialSetup Test cases
	//valid test
	
	@Test
	public void testInitialSetupValid() {
		int max = 5;
	    Robot.initialSetup(max);	
	    assertEquals(0,Robot.getRow());
	    assertEquals(0,Robot.getCol());
	    assertEquals(max-1,Robot.getMax_col());
	    assertEquals(max-1,Robot.getMax_row());
	    assertEquals("north",Robot.getCurrent_direction());
	    assertEquals(false,Robot.isPen_active());
	  }
	
	
	
	
}

