package com.softwareTesting.RobotProject;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
//covers R8,R9,R10
@RunWith(Parameterized.class)
public class RobotMovementTest {
	
	private String input;
	
	
	
	public RobotMovementTest(String input) {
		super();
		this.input = input;
	}


	@Parameters
	public static String[] testDirection(){
		String direction[] = {"north","east"};
		return(direction);
	}
	

	@Test
	public void testRobotMoveForward() {
		Robot robo = new Robot();
		int steps = 5;
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
		
		robo.setCurrent_direction(input);
		robo.setRow(0);
		robo.setMax_row(10);
		robo.setN_row(0);
		robo.setPen_active(true);
		robo.setCol(0);
		robo.setN_col(0);
		robo.setMax_col(10);
		robo.setFloor(new int[10][10]);
		
		robo.moveForward(steps);
		
		String expectedOutput = "Robot is moving 5 steps";
		String actualOutput = outputStream.toString().trim();
		
		assertEquals(expectedOutput, actualOutput);	
		System.out.println("Position : " + robo.getRow());
		
	}
	
	@Test
	public void testRobotMoveForward1() {
		Robot robo = new Robot();
		int steps = 50;
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
		
		robo.setCurrent_direction(input);
		robo.setRow(0);
		robo.setMax_row(10);
		robo.setN_row(0);
		robo.setPen_active(true);
		robo.setCol(0);
		robo.setMax_col(10);
		robo.setFloor(new int[10][10]);
		
		robo.moveForward(steps);
		
		String expectedOutput = "No space to move";
		String actualOutput = outputStream.toString().trim();
		
		assertEquals(expectedOutput, actualOutput);	
		
	}
	
	@Test
	public void testRobotMoveForward2() {
		Robot robo = new Robot();
		int steps = 50;
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
		
		robo.setCurrent_direction(input);
		robo.setRow(0);
		robo.setMax_row(10);
		robo.setN_row(0);
		robo.setPen_active(false);
		robo.setCol(0);
		robo.setMax_col(10);
		robo.setFloor(new int[10][10]);
		
		robo.moveForward(steps);
		
		String expectedOutput = "No space to move";
		String actualOutput = outputStream.toString().trim();
		
		assertEquals(expectedOutput, actualOutput);	
		
	}
	
	@Test
	public void testRobotMoveForward3() {
		Robot robo = new Robot();
		int steps = 5;
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
		
		robo.setCurrent_direction(input);
		robo.setRow(0);
		robo.setMax_row(10);
		robo.setN_row(0);
		robo.setPen_active(false);
		robo.setCol(0);
		robo.setN_col(0);
		robo.setMax_col(10);
		robo.setFloor(new int[10][10]);
		
		robo.moveForward(steps);
		
		String expectedOutput = "Robot is moving 5 steps";
		String actualOutput = outputStream.toString().trim();
		
		assertEquals(expectedOutput, actualOutput);	
		System.out.println("Position : " + robo.getRow());
		
	}
	
	@Test
	public void testExecuteCommand_M_south_nospace() {
		Robot robo = new Robot();			
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
		
		robo.executeCommand("M 30");
		
		String expectedOutput = "No space to move";
		String actualOutput = outputStream.toString().trim();
		
		assertEquals(expectedOutput, actualOutput);	
	}
	

	@Test
	public void testExecuteCommand_M_west_nospace() {
		Robot robo = new Robot();			
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
		
		robo.executeCommand("M 30");
		
		String expectedOutput = "No space to move";
		String actualOutput = outputStream.toString().trim();
		
		assertEquals(expectedOutput, actualOutput);	
	}

}
