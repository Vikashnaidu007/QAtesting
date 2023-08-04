package com.softwareTesting.RobotProject;

import static org.junit.Assert.*
;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class RobotPrintTest {
//covers R3, R11
	@Test
	public void testPrintFloor() {
		Robot robo = new Robot();
		int[][] floor = new int[1][1];
	    floor[0][0] = 1;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        robo.printFloor(floor);

        String expectedOutput = "0 * \n" +
                "  0 \n\n";
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedOutput.trim(), actualOutput);
    }

	
	@Test
	public void testPrintPosition() {
		Robot robo = new Robot();
		
		robo.setRow(3);
		robo.setCol(5);
		robo.setPen_active(true);
		robo.setCurrent_direction("east");
				
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        
        robo.printPosition();
        
        String expectedOutput = "Robot current position is :\n"+ "Position: 3, 5 - Pen: down - Facing: east";
        String actualOutput = outputStream.toString();

        assertEquals(expectedOutput, actualOutput);
	}
}
