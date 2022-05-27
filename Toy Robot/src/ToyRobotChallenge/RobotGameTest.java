package ToyRobotChallenge;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests for RobotGame class
 * @author Mark
 *
 */
public class RobotGameTest {
	
	@Test
	//Test the changing direction of the robot
	public void testFacing() {
		RobotGame robotGame = new RobotGame();
		robotGame.startUpRobotGame();
		
		//Test if robot has been placed
		robotGame.executeCommands("PLACE 2,2,NORTH");
		assertEquals("Output: {2, 2} NORTH", robotGame.executeCommands("REPORT"));
		
		//Test right command
		robotGame.executeCommands("RIGHT");
		assertEquals("Output: {2, 2} EAST" ,robotGame.executeCommands("REPORT"));
		robotGame.executeCommands("RIGHT");
		assertEquals("Output: {2, 2} SOUTH", robotGame.executeCommands("REPORT"));
		robotGame.executeCommands("RIGHT");
		assertEquals("Output: {2, 2} WEST" ,robotGame.executeCommands("REPORT"));
		robotGame.executeCommands("RIGHT");
		assertEquals("Output: {2, 2} NORTH" ,robotGame.executeCommands("REPORT"));
		
		//Test left command
		robotGame.executeCommands("LEFT");
		assertEquals("Output: {2, 2} WEST" ,robotGame.executeCommands("REPORT"));
		robotGame.executeCommands("LEFT");
		assertEquals("Output: {2, 2} SOUTH", robotGame.executeCommands("REPORT"));
		robotGame.executeCommands("LEFT");
		assertEquals("Output: {2, 2} EAST" ,robotGame.executeCommands("REPORT"));
		robotGame.executeCommands("LEFT");
		assertEquals("Output: {2, 2} NORTH" ,robotGame.executeCommands("REPORT"));
		
	}
	
	@Test
	//Test if the robot does anything when invalid commands are inputted
	public void robotValidation() {
		RobotGame robotGame = new RobotGame();
		robotGame.startUpRobotGame();
		
		//Test invalid commands
		robotGame.executeCommands("PLACE");
		assertEquals("", robotGame.executeCommands("REPORT"));
		robotGame.executeCommands("LEFT");
		assertEquals("", robotGame.executeCommands("REPORT"));
		robotGame.executeCommands("PLACE 5,2,NORTH");
		assertEquals("", robotGame.executeCommands("REPORT"));
		robotGame.executeCommands("PLACE 2,5,NORTH");
		assertEquals("", robotGame.executeCommands("REPORT"));
		robotGame.executeCommands("PLACE -1,2,NORTH");
		assertEquals("", robotGame.executeCommands("REPORT"));
		robotGame.executeCommands("PLACE 2,-1,NORTH");
		assertEquals("", robotGame.executeCommands("REPORT"));
		robotGame.executeCommands("PLACE 5,2,NORTH");
		assertEquals("", robotGame.executeCommands("REPORT"));
		robotGame.executeCommands("MOVE");
		assertEquals("", robotGame.executeCommands("REPORT"));
		
		//Test valid place
		robotGame.executeCommands("PLACE 0,0,EAST");
		assertEquals("Output: {0, 0} EAST", robotGame.executeCommands("REPORT"));
	}
	
	@Test
	//Test to see if the robot stays on the table after trying to get it off the table
	public void testRobotStaysOnTable() {
		RobotGame robotGame = new RobotGame();
		robotGame.startUpRobotGame();
		
		robotGame.executeCommands("PLACE 0,0,SOUTH");
		assertEquals("Output: {0, 0} SOUTH", robotGame.executeCommands("REPORT"));
		robotGame.executeCommands("MOVE");
		assertEquals("Output: {0, 0} SOUTH", robotGame.executeCommands("REPORT"));
		robotGame.executeCommands("RIGHT");
		assertEquals("Output: {0, 0} WEST", robotGame.executeCommands("REPORT"));
		robotGame.executeCommands("MOVE");
		assertEquals("Output: {0, 0} WEST", robotGame.executeCommands("REPORT"));
		robotGame.executeCommands("RIGHT");
		assertEquals("Output: {0, 0} NORTH", robotGame.executeCommands("REPORT"));
		
		//Try to move the robot north 10 times
		for(int i = 0; i < 10; i++) {
			robotGame.executeCommands("MOVE");
		}
		assertEquals("Output: {0, 4} NORTH", robotGame.executeCommands("REPORT"));
		
		//Try to move the robot east 10 times
		robotGame.executeCommands("RIGHT");
		for(int i = 0; i < 10; i++) {
			robotGame.executeCommands("MOVE");
		}
		assertEquals("Output: {4, 4} EAST", robotGame.executeCommands("REPORT"));
		
		//Try to place the robot off the table
		robotGame.executeCommands("PLACE 5,5,NORTH");
		assertEquals("Output: {4, 4} EAST", robotGame.executeCommands("REPORT"));
	}
	
	@Test
	//Test moving the robot around and placing it more than once
	public void testRobotMovement() {
		RobotGame robotGame = new RobotGame();
		robotGame.startUpRobotGame();
		
		robotGame.executeCommands("PLACE 0,0,NORTH");
		robotGame.executeCommands("MOVE");
		assertEquals("Output: {0, 1} NORTH", robotGame.executeCommands("REPORT"));
		
		robotGame.executeCommands("PLACE 0,0,NORTH");
		robotGame.executeCommands("LEFT");
		assertEquals("Output: {0, 0} WEST", robotGame.executeCommands("REPORT"));
		
		robotGame.executeCommands("PLACE 1,2,EAST");
		robotGame.executeCommands("MOVE");
		robotGame.executeCommands("MOVE");
		robotGame.executeCommands("LEFT");
		robotGame.executeCommands("MOVE");
		assertEquals("Output: {3, 3} NORTH", robotGame.executeCommands("REPORT"));
	}

}

