package com.softwareTesting.RobotProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class RobotCommandScreenTest {
	
	Robot robo;
	
	@Before
	public void init() {
		robo = new Robot();
	}
	
	//CommandScreen Test
	//Valid Test
	
	
	@Test
	public void testCommandScreenValidInput() {
		
		robo.commandScreen(false, "I");
		assertEquals(false,robo.isPass() );
	}
	
	@Test
	public void testCommandScreenValidInputQ() {
		
		robo.commandScreen(true, "Q");
		assertEquals(false,robo.isPass() );
	}
	
	
//	@Test
//	public void testCommandScreenValidInputD() {
//		robo.commandScreen(true, "D");
//        assertEquals("Q",robo.getCommand());
//	}
	
	

}
