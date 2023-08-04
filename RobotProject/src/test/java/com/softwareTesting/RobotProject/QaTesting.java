package com.softwareTesting.RobotProject;





import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;





public class QaTesting {
	
	
	 private Robot robot;

	    @Before
	    public void setUp() {
	        robot = new Robot();
	    }
	    
	@Test  
	 public void testInitialPosition() {
		assertFalse(robot.checkInitialInput("I"));
		assertTrue(robot.checkInitialInput("I 10"));
		 Robot.executeCommand("I 9");
		 
		 assertFalse(Robot.isPen_active());
		 assertEquals("north",Robot.getCurrent_direction());
		 assertEquals(0,Robot.getRow());
		 assertEquals(0,Robot.getCol());
		
		
		
		
	 }
	
	 @Test
	 public void testDirections() {
		 Robot.executeCommand("I 5");
		 assertEquals("north",Robot.getCurrent_direction());
		 Robot.executeCommand("M 2");
		 Robot.executeCommand("R");
		 assertEquals("east",Robot.getCurrent_direction());
		 Robot.executeCommand("M 2");
		 Robot.executeCommand("R");
		 assertEquals("south",Robot.getCurrent_direction());
		 Robot.executeCommand("M 2");
		 Robot.executeCommand("R");
		 assertEquals("west",Robot.getCurrent_direction());
		 Robot.executeCommand("M 2");
		 Robot.executeCommand("L");
		 assertEquals("south",Robot.getCurrent_direction());
		 Robot.executeCommand("M 2");
		 Robot.executeCommand("L");
		 assertEquals("east",Robot.getCurrent_direction());
		 Robot.executeCommand("M 2");
		 Robot.executeCommand("L");
		 assertEquals("north",Robot.getCurrent_direction());
		 
	 }
	 
	 @Test
	 public void testPenDown() {
		 Robot.executeCommand("D");
		 assertTrue(Robot.isPen_active());
	 }
	 
	
	 
	 @Test
	 public void testPenUp() {
		 
		 Robot.executeCommand("I 5");
		 Robot.executeCommand("D");
		 Robot.executeCommand("M 2");
		 Robot.executeCommand("U");
		 assertFalse(Robot.isPen_active());
	 }
	 
	 @Test
	 public void testCurrentPosition() {
		 Robot.executeCommand("I 10");
		 Robot.executeCommand("D");
		 Robot.executeCommand("M 3");
		 Robot.executeCommand("R");
		 Robot.executeCommand("M 4");
		 Robot.executeCommand("C");
		 assertEquals(3,Robot.getRow());
		 assertEquals(4,Robot.getCol());
		
	 }
	 
	 @Test
	 public void testPrintFloor() {
		 Robot.executeCommand("I 3");
		 Robot.executeCommand("D");
		 Robot.executeCommand("M 1");
		 
		 ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outputStream));
	        
	       Robot.executeCommand("P"); 
	       
	       String expectedOutput = "2       \n" +"1 *     \n" +"0 *     \n" +"  0 1 2";
	       String actualOutput = outputStream.toString().trim();

	        // Assert the results
	        assertEquals(expectedOutput, actualOutput);
	       
		 
	}
	 
	 @Test
	 public void testFloor() {
		 Robot.executeCommand("I 3");
		 Robot.executeCommand("D");
		 Robot.executeCommand("M 1");
		 assertEquals(2,Robot.getMax_row());
		 assertEquals(2,Robot.getMax_col());
		 assertEquals(3,Robot.getFloor().length);
	 }
	 
	 
	 @Test
	 public void testInputs() {
		 assertTrue(robot.checkInput("I 10"));
		 assertTrue(robot.checkInput("i 10"));
		assertTrue(robot.checkInput("U"));
		assertTrue(robot.checkInput("u"));
		 assertTrue(robot.checkInput("D"));
		 assertTrue(robot.checkInput("d"));
		 assertTrue(robot.checkInput("M 3"));
		 assertTrue(robot.checkInput("m 3"));
		 assertTrue(robot.checkInput("C"));
		 assertTrue(robot.checkInput("c"));
		 assertTrue(robot.checkInput("R"));
		 assertTrue(robot.checkInput("r"));
		 assertTrue(robot.checkInput("L"));
		 assertTrue(robot.checkInput("l"));
		 assertTrue(robot.checkInput("P"));
		 assertTrue(robot.checkInput("p"));
		 assertTrue(robot.checkInput("Q"));
		 assertTrue(robot.checkInput("q"));
		 
		 //assertFalse(robot.checkInput("1"));
		 assertFalse(robot.checkInput("I"));
		 assertFalse(robot.checkInput("U 3"));
		 assertFalse(robot.checkInput("M"));
		 assertFalse(robot.checkInput("D 5"));
		 assertFalse(robot.checkInput("C 4"));
		 assertFalse(robot.checkInput("R "));
		 assertFalse(robot.checkInput("L 3"));
		 assertFalse(robot.checkInput("P 4"));
		 assertFalse(robot.checkInput("q 2"));
		 
	 }
	 
	 @Test
	 public void testRight() {
		 Robot.executeCommand("I 3");
		 Robot.executeCommand("D");
		 Robot.executeCommand("M 3");
		 Robot.executeCommand("R");
		 assertEquals("east",Robot.getCurrent_direction());
		 Robot.executeCommand("M 3");
		 Robot.executeCommand("R");
		 assertEquals("south",Robot.getCurrent_direction());
		 Robot.executeCommand("M 3");
		 Robot.executeCommand("R");
		 assertEquals("west",Robot.getCurrent_direction());
		 Robot.executeCommand("M 3");
		 Robot.executeCommand("R");
		 assertEquals("north",Robot.getCurrent_direction());
	 }
	 
	@Test
	 public void testLeft() {
		 Robot.executeCommand("I 10");
		 Robot.executeCommand("m 4");
		 Robot.executeCommand("R");
		 Robot.executeCommand("M 4");
		 Robot.executeCommand("D");
		 Robot.executeCommand("M 3");
		 Robot.executeCommand("L");
		 assertEquals("north",Robot.getCurrent_direction());
		 Robot.executeCommand("M 3");
		 Robot.executeCommand("L");
		 assertEquals("west",Robot.getCurrent_direction());
		 Robot.executeCommand("M 3");
		 Robot.executeCommand("L");
		 assertEquals("south",Robot.getCurrent_direction());
		 Robot.executeCommand("M 3");
		 Robot.executeCommand("L");
		 assertEquals("east",Robot.getCurrent_direction());
	 }
	 
	 
	

}

