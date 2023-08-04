package com.softwareTesting.RobotProject;

import java.util.Arrays;
import java.util.Scanner;

public class Robot {
	private String command;
	private boolean pass;
	static boolean pen_active;
	private static String current_direction; 
	private static int row;
	private static int col;
	private static int n_row;
	private static int n_col;
	private static int max_row;
	private static int max_col;
	private static int[][] floor;
	
	
// getter and setters
	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public boolean isPass() {
		return pass;
	}

	public void setPass(boolean pass) {
		this.pass = pass;
	}

	public static boolean isPen_active() {
		return pen_active;
	}

	public static void setPen_active(boolean pen_active) {
		Robot.pen_active = pen_active;
	}

	public static String getCurrent_direction() {
		return current_direction;
	}

	public static void setCurrent_direction(String current_direction) {
		Robot.current_direction = current_direction;
	}

	public static int getRow() {
		return row;
	}

	public static void setRow(int row) {
		Robot.row = row;
	}

	public static int getCol() {
		return col;
	}

	public static void setCol(int col) {
		Robot.col = col;
	}

	public static int getN_row() {
		return n_row;
	}

	public static void setN_row(int n_row) {
		Robot.n_row = n_row;
	}

	public static int getN_col() {
		return n_col;
	}

	public static void setN_col(int n_col) {
		Robot.n_col = n_col;
	}

	public static int getMax_row() {
		return max_row;
	}

	public static void setMax_row(int max_row) {
		Robot.max_row = max_row;
	}

	public static int getMax_col() {
		return max_col;
	}

	public static void setMax_col(int max_col) {
		Robot.max_col = max_col;
	}

	public static int[][] getFloor() {
		return floor;
	}

	public static void setFloor(int[][] floor) {
		Robot.floor = floor;
	}
	
	
	
	
//userInput
	public String getUserInput() {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter command: ");
		command = s.nextLine();
		System.out.println("Your input : "+ command);
		return command;
	}
	
//check whether first command is I
	public boolean checkInitialInput(String command) {
		
		boolean pass;
		if (command.length() >= 3 && command.toUpperCase().charAt(0)== 'I' && Integer.parseInt(command.substring(2)) >= 0 ) {
			 executeCommand(command);
			 pass = true;
		 }else {
			 
			 pass = false;
			 
			 }
		 return pass;
	}
	
// check whether input are valid or not
	public boolean checkInput(String command) {
		switch (command.toUpperCase().charAt(0)) {
		   case 'I':
			   pass = (command.length() >= 3 && command.toUpperCase().charAt(0) == 'I' && Integer.parseInt(command.substring(2)) >= 0) ? true : false;
			   break;
		   case 'U':
			   pass = (command.toUpperCase().charAt(0) == 'U' && command.length() == 1) ? true: false;
			   break;
		   case 'D':
			    pass = (command.toUpperCase().charAt(0) == 'D' && command.length() == 1) ? true: false;
			    break;
		   case 'R':
			    pass = (command.toUpperCase().charAt(0) == 'R' && command.length() == 1)? true: false;
				break;
		   case 'L':
			    pass = (command.toUpperCase().charAt(0) == 'L' && command.length() == 1)? true: false;
				break;
		   case 'P':
			    pass = (command.toUpperCase().charAt(0) == 'P' && command.length() == 1)? true: false;
			    break;
		   case 'C':
			    pass = (command.toUpperCase().charAt(0) == 'C' && command.length() == 1)? true: false;
				break;
		   case 'M':
			    pass =(command.length() >= 3 && command.toUpperCase().charAt(0)== 'M' && Integer.parseInt(command.substring(2)) >= 0 )? true: false;
			    break;
			   
		   case 'Q':
			    pass =(command.toUpperCase().charAt(0) == 'Q' && command.length() == 1)? true: false;
				break;		   
		  
		}
		
		return pass;	
	}
	
	
//list of valid commands
	public String commandScreen(boolean pass, String command) {
		
		if(pass) {
			while (!command.equals("Q")){
				System.out.println("");
				System.out.println("________________________________________________________");
				System.out.println("\n\n");
	        	System.out.println("[U|u] Pen up \r\n"
	        			+ "[D|d] Pen down \r\n"
	        			+ "[R|r] Turn right \r\n"
	        			+ "[L|l] Turn left \r\n"
	        			+ "[M s|m s] Move forward s spaces \r\n"
	        			+ "[P|p] Print the floor \r\n"
	        			+ "[C|c] Print current position \r\n"
	        			+ "[Q|q] Stop the program\r\n"
	        			+ "[I n|i n] Initialize the system");
	        	System.out.println("\n\n");
	        	System.out.println("________________________________________________________");
	        	command = getUserInput();
	        	pass = checkInput(command);
	        	
	        	if (pass){
	        		executeCommand(command);
	        	}else {
	        		pass = false;
	        		break;
	        	}
	        	 
	        };
	        
		    }else {
		    	pass = false;
		    	System.out.println("Invalid input");
		    }
		System.out.println("Program Terminated");
		
		return command;
		
	}
	
//executing command 
	public static void executeCommand(String command) {
		//System.out.println("Executing command.......");
		switch (Character.toUpperCase(command.charAt(0))) {
		case 'I':
			 	int max = Integer.parseInt(command.substring(2));
			 	floor  = new int[max][max];
			 	System.out.println("Floor of size " + max + " is created");
			 	initialSetup(max);
			 	printPosition();
			 break;
		case 'C':			
			 	printPosition();
			 	break;
        case 'D':
        		System.out.println("Robot pen position changed to Pen_Down");
       	 		pen_active = true;
       	 		break;
        case 'U':
        		System.out.println("Robot pen position changed to Pen_Up");
        		pen_active = false;
        	break;
        case 'M':
       	 		moveForward(Integer.parseInt(command.substring(2)));
       	 		break;	 
        case 'R':
        		//System.out.println("Robot is turning right");
        		turnRight();
       	 		break;
        case 'L':
        		//System.out.println("Robot is turning left");
        		turnLeft();
       	 		break;
        case 'P':
        		printFloor(floor);
        		break;
        default:
            System.out.println("Invalid Input");
            break;
		 }
	 }
	
//Initial and reset settings
	 public static void initialSetup(int max) {
		    
		    row = 0;
		 	col = 0;
		 	
		 	max_row = max-1;
		 	max_col = max-1;	
		 	current_direction = "north";
		 	
		    pen_active = false;
		 	System.out.println("Initial Setup is done");		
		}
	 
// R command action	
	public static void turnRight() {
			switch (current_direction) {
			case "north":
				current_direction = "east";
				break;
			case "east":
				current_direction = "south";
				break;
			case "south":
				current_direction = "west";
				break;
			case "west":
				current_direction = "north";
				break;
			}
			System.out.print("Robot facing "+ current_direction);
			System.out.print("\n ");
	}
//L command action
	public static void turnLeft() {
			switch (current_direction) {
				case "north":
					current_direction = "west";
					break;
				case "east":
					current_direction = "north";
					break;
				case "south":
					current_direction = "east";
					break;
				case "west":
					current_direction = "south";
					break;
			}
			System.out.print("Robot facing "+ current_direction);
			System.out.print("\n ");
	}
	
// M command action
	public static void moveForward(int s) {
		
		switch (current_direction) {
		case "north":
			if((row+s)<= max_row) {
				n_row = row + s;
				if (pen_active == true) {
					for(int i= row; i<= n_row; i++) {
						floor[i][col]= 1;
					}
				}else {
					for(int i= row; i<= n_row; i++) {
						floor[i][col]= 0;
					}
				}
				 System.out.println("Robot is moving "+ s + " steps" );
				 row = n_row;
			}else {
				System.out.println("No space to move");
			}
			//row = n_row;
			//System.out.print(row);
			break;
		case "east":
			if((col+s)<= max_col) {
				n_col = col + s;
				if (pen_active == true) {
					for(int i= col; i<= n_col; i++) {
						floor[row][i]= 1;
					}
				}else {
					for(int i= col; i<= n_col; i++) {
						floor[row][col]= 0;
					}
				}
				System.out.println("Robot is moving "+ s + " steps" );
				col = n_col;
			}else {
				System.out.println("No space to move");
			}
			//col = n_col;
			//System.out.println(col);
			break;
		case "south":
			if((row-s)>= 0) {
				n_row = row - s;
				if (pen_active == true) {
					for(int i= row; i>= n_row; i--) {
						floor[i][col]= 1;
					}
				}else {
					for(int i= row; i<= n_row; i--) {
						floor[i][col]= 0;
					}
				}
				System.out.println("Robot is moving "+ s + " steps" );
				row = n_row;
			}else {
				System.out.println("No space to move");
			}
			//row = n_row;
			//System.out.println(row);
			break;
		case "west":
			if((col-s)>= 0) {
				n_col = col - s;
				if (pen_active == true) {
					for(int i= col; i>= n_col; i--) {
						floor[row][i]= 1;
					}
				}else {
					for(int i= col; i>= n_col; i--) {
						floor[row][col]= 0;
					}
				}
				System.out.println("Robot is moving "+ s + " steps" );
				col = n_col;
			}else {
				System.out.println("No space to move");
			}
			//col = n_col;
			//System.out.println(col);
			break;
		}
	}
	
// C command action	
	public static void printPosition() {
		System.out.print("Robot current position is :\n");
		System.out.print("Position: " + row + ", " + col + " - Pen: " + (pen_active ? "down" : "up")
                + " - Facing: " + current_direction);
       
        
    }
	


//	P command action 
	public static void printFloor(int[][] floor) {
	    int numRows = floor.length;
	    int numCols = floor[0].length;

	    // Print the floor rows in reverse order
	    for (int i = numRows - 1; i >= 0; i--) {
	        System.out.print(i + " ");
	        for (int j = 0; j < numCols; j++) {
	            System.out.print(floor[i][j] == 1 ? "*" : " ");
	            System.out.print(" ");
	        }
	        System.out.print("\n");
	    }
	    
	    // Print the column indices
	    System.out.print("  ");
	    for (int j = 0; j < numCols; j++) {
	        System.out.print(j + " ");
	    }
	    System.out.println("\n");
	}
}
