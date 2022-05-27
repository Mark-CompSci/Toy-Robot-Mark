package ToyRobotChallenge;
/**
 * Directions of the robot
 * @author Mark
 *
 */
public enum Direction {
	NORTH,
	EAST,
	WEST,
	SOUTH;
	
	/**
	 * Returns the Direction object of the string
	 * @param string
	 * @return Direction
	 * @throws IllegalArgumentException
	 */
	public static Direction parseString(String string) throws IllegalArgumentException {
		switch(string) {
			case "NORTH" : {
				return NORTH;
			} 
			case "EAST" : {
				return EAST;
			} 
			case "SOUTH" : {
				return SOUTH;
			}
			case "WEST" : {
				return WEST;
			}
			default : {
				throw new IllegalArgumentException("Invalid input...");
			}
		}
	}
	
	/**
	 * Returns the direction to the left of the current direction
	 * @param currentDirection
	 * @return Direction
	 */
	public static Direction faceLeft(Direction currentDirection) {
		switch(currentDirection) {
			case NORTH : {
				return WEST;
			} 
			case EAST : {
				return NORTH;
			} 
			case SOUTH : {
				return EAST;
			}
			case WEST : {
				return SOUTH;
			}
			default : {
				return null;
			}
		}
	}
	
	/**
	 * Returns the direction to the right of the current direction
	 * @param currentDirection
	 * @return Direction
	 */
	public static Direction faceRight(Direction currentDirection) {
		switch(currentDirection) {
			case NORTH : {
				return EAST;
			} 
			case EAST : {
				return SOUTH;
			} 
			case SOUTH : {
				return WEST;
			}
			case WEST : {
				return NORTH;
			}
			default : {
				return null;
			}
		}
	}
}