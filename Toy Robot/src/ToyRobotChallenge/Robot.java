package ToyRobotChallenge;
/**
 * Class for Toy Robot to move around on a board
 * 
 * 4						 N
 * 3						/ \
 * 2		X			W <-   -> E
 * 1						\ /
 * 0						 S
 * 	0	1	2	3	4
 * 
 * 
 * @author Mark
 *
 */
public class Robot {
	private int[] position = {0,0}; //position of the robot{x, y}
	
	private int maxX = 4;
	private int maxY = 4;
	private Direction facing = Direction.NORTH; //What direction the robot is facing
	private boolean robotHasBeenPlaced = false;
	
	/**
	 * Initializes the size of the table the robot is moving on
	 * @param maxX
	 * @param maxY
	 */
	public Robot(int maxX, int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
	}
	
	/**
	 * places the robot on the table facing a direction
	 * @param positionX
	 * @param positionY
	 * @param facing
	 */
	public void place(int positionX, int positionY, Direction facing) {	
		//Check to see if inputed position is valid
		if(!(validXPosition(positionX) && validYPosition(positionY)))
			return;
		
		this.position[0] = positionX;
		this.position[1] = positionY;
		this.facing = facing;
		
		this.robotHasBeenPlaced = true;	
	}
	
	private boolean validXPosition(int posX) {
		return posX >= 0 && posX <= this.maxX;
	}
	
	private boolean validYPosition(int posY) {
		return posY >= 0 && posY <= this.maxY;
	}
	
	/**
	 * Moves the robot 1 space in the direction it is facing
	 */
	public void move() {
		if(!this.robotHasBeenPlaced) return;
		
		switch(this.facing) {
			case NORTH : {
				if(validYPosition(this.position[1] + 1)) this.position[1] += 1;
				break;
			} 
			case EAST : {
				if(validXPosition(this.position[0] + 1)) this.position[0] += 1;
				break;
			} 
			case SOUTH : {
				if(validYPosition(this.position[1] - 1)) this.position[1] -= 1;
				break;
			}
			case WEST : {
				if(validXPosition(this.position[0] - 1)) this.position[0] -= 1;
				break;
			}
		}
	}
	
	/**
	 * Changes the facing of the robot to the left of its current facing
	 */
	public void left() {
		if(!this.robotHasBeenPlaced) return;
		this.facing = Direction.faceLeft(this.facing);
	}
	
	/**
	 * Changes the facing of the robot to the right of its current facing
	 */
	public void right() {
		if(!this.robotHasBeenPlaced) return;
		this.facing = Direction.faceRight(this.facing);
	}
	
	/**
	 * prints out the current position and facing the robot
	 * @return string(used for testing)
	 */
	public String report() {
		if(!this.robotHasBeenPlaced) return "";
		String reportMessage = "Output: " + "{" + this.position[0] + ", " + this.position[1] + "} " + this.facing.name();
		System.out.println(reportMessage);
		return reportMessage; //Used for testing
	}

}