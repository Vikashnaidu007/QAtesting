package com.softwareTesting.RobotProject;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
//Covers R4,R5,R3
public class RobotExecuteCommandTest {
	
		Robot robo;
		
		@Before
		public void init() {
			robo = new Robot();
		}

	//D command Test
		@Test
		public void testExecuteCommand_D() {
		        
		        robo.executeCommand("D");
		        assertTrue(robo.pen_active);
		 }
		
	//U Command Test
		@Test
		public void testExecuteCommand_U() {
			   
			     robo.executeCommand("U");
			     assertFalse(robo.pen_active);
		}
		
	//C command Test
		@Test
		public void testExecuteCommand_C() {
			robo.setRow(3);
			robo.setCol(5);
			robo.setPen_active(true);
			robo.setCurrent_direction("east");
					
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        PrintStream printStream = new PrintStream(outputStream);
	        System.setOut(printStream);
			
	        robo.executeCommand("C");
			
			String expectedOutput = "Robot current position is :\n"+ "Position: 3, 5 - Pen: down - Facing: east";
	        String actualOutput = outputStream.toString();

	        assertEquals(expectedOutput, actualOutput);
				
		}
		
	//P command Test
		@Test
		public void testExecuteCommand_P() {
			int[][] floor = new int[1][1];
		    floor[0][0] = 1;
			
			robo.setFloor(floor);
			
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        PrintStream printStream = new PrintStream(outputStream);
	        System.setOut(printStream);
			
	        robo.executeCommand("P");
	      			

	        String expectedOutput = "0 * \n" +
	                "  0 \n\n";
	        String actualOutput = outputStream.toString().trim();

	        assertEquals(expectedOutput.trim(), actualOutput);
	        
				
		}
		
	//R command Test
		@Test
		public void testExecuteCommand_R() {
			robo.setCurrent_direction("north");
			
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        PrintStream printStream = new PrintStream(outputStream);
	        System.setOut(printStream);
			
	        robo.executeCommand("R");
	        
	        String expectedOutput = "Robot facing east\n ";
	        String actualOutput = outputStream.toString();

	        assertEquals(expectedOutput, actualOutput);
		}
		
	//L command Test
		@Test
		public void testExecuteCommand_L() {
			robo.setCurrent_direction("north");
			
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        PrintStream printStream = new PrintStream(outputStream);
	        System.setOut(printStream);
			
	        robo.executeCommand("L");
	        
	        String expectedOutput = "Robot facing west\n ";
	        String actualOutput = outputStream.toString();

	        assertEquals(expectedOutput, actualOutput);
		}
		
	//M command Test
		@Test
		public void testExecuteCommand_M_south() {
						
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        PrintStream printStream = new PrintStream(outputStream);
	        System.setOut(printStream);
			
			robo.setCurrent_direction("south");
			robo.setRow(5);
			robo.setMax_row(10);
			robo.setN_row(0);
			robo.setPen_active(true);
			robo.setCol(0);
			robo.setN_col(0);
			robo.setMax_col(10);
			robo.setFloor(new int[10][10]);
			
			robo.executeCommand("M 3");
			
			String expectedOutput = "Robot is moving 3 steps";
			String actualOutput = outputStream.toString().trim();
			
			assertEquals(expectedOutput, actualOutput);	
		}

		@Test
		public void testExecuteCommand_M_south_penup() {
						
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        PrintStream printStream = new PrintStream(outputStream);
	        System.setOut(printStream);
			
			robo.setCurrent_direction("south");
			robo.setRow(5);
			robo.setMax_row(20);
			robo.setN_row(6);
			robo.setPen_active(false);
			robo.setCol(0);
			robo.setN_col(0);
			robo.setMax_col(20);
			robo.setFloor(new int[20][20]);
			
			robo.executeCommand("M 3");
			
			String expectedOutput = "Robot is moving 3 steps";
			String actualOutput = outputStream.toString().trim();
			
			assertEquals(expectedOutput, actualOutput);	
		}
		

		@Test
		public void testExecuteCommand_M_west() {
						
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        PrintStream printStream = new PrintStream(outputStream);
	        System.setOut(printStream);
			
			robo.setCurrent_direction("west");
			robo.setRow(0);
			robo.setMax_row(10);
			robo.setN_row(0);
			robo.setPen_active(false);
			robo.setCol(5);
			robo.setN_col(0);
			robo.setMax_col(10);
			robo.setFloor(new int[10][10]);
			
			robo.executeCommand("M 3");
			
			String expectedOutput = "Robot is moving 3 steps";
			String actualOutput = outputStream.toString().trim();
			
			assertEquals(expectedOutput, actualOutput);	
		}

		
		@Test
		public void testExecuteCommand_M_west_pendown() {
						
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        PrintStream printStream = new PrintStream(outputStream);
	        System.setOut(printStream);
			
			robo.setCurrent_direction("west");
			robo.setRow(0);
			robo.setMax_row(10);
			robo.setN_row(0);
			robo.setPen_active(true);
			robo.setCol(5);
			robo.setN_col(0);
			robo.setMax_col(10);
			robo.setFloor(new int[10][10]);
			
			robo.executeCommand("M 3");
			
			String expectedOutput = "Robot is moving 3 steps";
			String actualOutput = outputStream.toString().trim();
			
			assertEquals(expectedOutput, actualOutput);	
		}
}
