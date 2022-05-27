package ToyRobotChallenge;
/**
 * The class that handles the robot game itself and the commands of the robot in the game
 * @author Mark
 *
 */
public class RobotGame {
	Robot toyRobot;
	
	/**
	 * Starts up the robot game with a table size of 5 by 5
	 */
	public void startUpRobotGame() {
		this.toyRobot = new Robot(4, 4);
	}
	
	/**
	 * Executes command
	 * @param command
	 */
	public String executeCommands(String command) {
		switch(command) {
			case "MOVE": {
				this.toyRobot.move();
				break;
			}
			case "LEFT": {
				this.toyRobot.left();
				break;
			}
			case "RIGHT": {
				this.toyRobot.right();
				break;
			}
			case "REPORT": {
				return this.toyRobot.report();
			}
			default: {
				this.executePlaceCommand(command);
			}
		}
		
		return "";
	}
	
	/**
	 * Checks if its a valid place command then executes the place command
	 * @param command
	 */
	private void executePlaceCommand(String command) {
		String[] splitCommand = command.split(" ");
		
		if("PLACE".equals(splitCommand[0]) && splitCommand.length == 2) {
			String[] splitPlaceParameters = splitCommand[1].split(",");
			
			if(splitPlaceParameters.length == 3) {
				try {
					int posX = Integer.valueOf(splitPlaceParameters[0]);
					int posY = Integer.valueOf(splitPlaceParameters[1]);
					Direction facing = Direction.parseString(splitPlaceParameters[2]);
					this.toyRobot.place(posX, posY, facing);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
